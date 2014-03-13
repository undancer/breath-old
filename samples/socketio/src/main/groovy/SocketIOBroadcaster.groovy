import org.atmosphere.config.service.BroadcasterService
import org.atmosphere.cpr.AtmosphereResource
import org.atmosphere.socketio.transport.SocketIOPacketImpl
import org.atmosphere.util.ExcludeSessionBroadcaster

import java.util.concurrent.Future

/**
 * Created by undancer on 14-3-11.
 */
@BroadcasterService
class SocketIOBroadcaster extends ExcludeSessionBroadcaster {

    Future<Object> broadcast(Object msg) {
        Object message = new SocketIOPacketImpl(SocketIOPacketImpl.PacketType.EVENT, msg.toString()).toString()
        System.out.println("broadcast#1 - " + message)
        super.broadcast(message);
    }

    Future<Object> broadcast(Object msg, AtmosphereResource r) {
        Object message = new SocketIOPacketImpl(SocketIOPacketImpl.PacketType.EVENT, msg.toString()).toString()
        System.out.println("broadcast#2 - " + message)
        super.broadcast(message, r)
    }

    Future<Object> broadcast(Object msg, Set<AtmosphereResource> subset) {
        Object message = new SocketIOPacketImpl(SocketIOPacketImpl.PacketType.EVENT, msg.toString()).toString()
        System.out.println("broadcast#3 - " + message)
        super.broadcast(message, subset)
    }


}
