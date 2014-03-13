import SocketIOBroadcaster
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.StringUtils
import org.atmosphere.config.service.AtmosphereHandlerService
import org.atmosphere.cpr.AtmosphereResource
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter
import org.atmosphere.cpr.BroadcasterFactory
import org.atmosphere.cpr.DefaultBroadcasterFactory
import org.atmosphere.interceptor.AtmosphereResourceLifecycleInterceptor
import org.atmosphere.socketio.SocketIOSessionOutbound
import org.atmosphere.socketio.cache.SocketIOBroadcasterCache
import org.atmosphere.socketio.cpr.SocketIOAtmosphereHandler
import org.atmosphere.socketio.transport.DisconnectReason

import java.util.concurrent.ConcurrentHashMap

/**
 * Created by undancer on 14-3-11.
 */

@Slf4j
@AtmosphereHandlerService(
        path = "/socket.io"
        , supportSession = true
//        , interceptors = [AtmosphereResourceLifecycleInterceptor, SocketIOAtmosphereInterceptor, HeartbeatInterceptor]
        , interceptors = [AtmosphereResourceLifecycleInterceptor]
        , broadcasterCache = SocketIOBroadcasterCache
        , broadcaster = SocketIOBroadcaster
)
class SocketIOChat extends SocketIOAtmosphereHandler {

    def broadcasterFactory = BroadcasterFactory.default as DefaultBroadcasterFactory
    ObjectMapper objectMapper = [] as ObjectMapper

    ConcurrentHashMap<String, String> online = [:] as ConcurrentHashMap<String, String>


    void onConnect(AtmosphereResource event, SocketIOSessionOutbound handler) throws IOException {
        log.debug('onConnect - {}', handler.sessionId)
        event.addEventListener([onClose: {
            safeRemoveOnline(handler.sessionId)
        }] as AtmosphereResourceEventListenerAdapter)
    }

    void onDisconnect(AtmosphereResource event, SocketIOSessionOutbound handler, DisconnectReason reason) {
        log.debug('onDisconnect - {}', handler.sessionId)
        safeRemoveOnline(handler.sessionId)
    }


    void onMessage(AtmosphereResource event, SocketIOSessionOutbound handler, String message) {
        log.debug('onMessage - {} -> {}', handler.sessionId, message)
        def sessionId = handler.sessionId
        def msg = objectMapper.readValue(message, Object)
        def eventName = msg['name']
        def eventArgs = msg['args']

        log.debug("msg {} name:{} args:{}", msg, eventName, eventArgs)
        switch (eventName) {
            case 'nickname':
                online.put(sessionId, eventArgs)
                broadcasterFactory.lookup('/chat', true).addAtmosphereResource(event)
                broadcasterFactory.lookup("/chat/${sessionId}", true).addAtmosphereResource(event)
                println onlinePkg
                broadcasterFactory.lookup('/chat').broadcast(onlinePkg)
//                event.broadcaster.broadcast(onlinePkg)
                break
            case 'online':
                handler.sendMessage(onlinePkg)
                break
            case 'message':
                def json = JsonNodeFactory.instance.objectNode()
                json.put('nickname', online.get(sessionId, '匿名用户'))
                json.put('text', eventArgs['text'])
                json.put('timestamp', (System.currentTimeMillis() / 1000) as long)
                def pkg = objectMapper.writeValueAsString([name: 'message', args: json])
                if (StringUtils.isNotBlank(eventArgs['to'])) {
                    online.each { id, name ->
                        if (name == eventArgs['to']) {
                            broadcasterFactory.lookup("/chat/${id}", true).broadcast(pkg)
                        }
                    }
                } else {
                    broadcasterFactory.lookup('/chat').broadcast(pkg)
                }
                break
            default:
//                println "message - $message"
//                println "===================="
//                (BroadcasterFactory.default.lookupAll() as LinkedHashSet<Broadcaster>).sort({
//                    it.ID
//                }).each { broadcaster ->
//                    println broadcaster.ID
//                }
//                println "===================="

                break
        }

    }

    void safeRemoveOnline(String sessionId) {
        log.debug('safeRemoveOnline - {}', sessionId)
        if (online.containsKey(sessionId)) {
            online.remove(sessionId)
        }
    }

    def getOnlinePkg() {
        def json = JsonNodeFactory.instance.arrayNode()
        online.each { id, name ->
            json.add("$name")
        }
        return objectMapper.writeValueAsString([name: 'online', args: json])
    }
}
