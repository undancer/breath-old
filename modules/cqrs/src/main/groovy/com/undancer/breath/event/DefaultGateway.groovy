//package com.undancer.breath.event
//
//import org.axonframework.commandhandling.CommandCallback
//import org.axonframework.commandhandling.gateway.CommandGateway
//
//import javax.inject.Inject
//import java.util.concurrent.TimeUnit
//
///**
// * Created by undancer on 14-1-7.
// */
//
//class R {}
//
//class DefaultGateway implements Gateway {
//
//    @Inject
//    CommandGateway commandGateway
//
//    void send(Object command) {
//        commandGateway.send(command)
//    }
//
//
//    def <R> void send(Object command, CallBack<R> callback) {
//        commandGateway.send(command,
//                [
//                        onSuccess: { R result ->
//                            callback.success(result)
//                        },
//                        onFailure: { Throwable cause ->
//                            callback.failure(cause)
//                        }
//                ] as CommandCallback<R>
//        )
//    }
//
//    def <R> R sendAndWait(Object command) {
//        commandGateway.sendAndWait(command)
//    }
//
//    def <R> R sendAndWait(Object command, long timeout, TimeUnit unit) {
//        commandGateway.sendAndWait(command, timeout, unit)
//    }
//
////    public static void main(String[] args) {
////        Gateway gateway = [] as DefaultGateway
////
////        gateway.send("sign")
////
////        def gateway = [
////                send: {
////
////                },
////                send: { command, Closure callback ->
////                    println("send -> $command")
////
////                    def result, throwable
////
////                    try {
////                        result = command
//////                throw new Exception("fake error")
////                    } catch (Throwable e) {
////                        throwable = e
////                    }
////
////                    callback.call(result, throwable)
////
////                }] as com.undancer.breath.event.Gateway
////
////        gateway.send("sign") { result, throwable ->
////            println "result -> $result"
////            println "throwable -> $throwable"
////        }
////
////        gateway.send("undancer")
////        CommandGateway defaultCommandGateway;
////
////    }
//}