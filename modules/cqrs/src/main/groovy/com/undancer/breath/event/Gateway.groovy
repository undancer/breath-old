package com.undancer.breath.event

import org.axonframework.commandhandling.gateway.CommandGateway

import java.util.concurrent.TimeUnit

/**
 * Created by undancer on 14-1-7.
 */
public interface Gateway {

    public void send(Object command)

    public <R> void send(Object command, CallBack<R> callback)

    public <R> R sendAndWait(Object command)

    public <R> R sendAndWait(Object command, long timeout, TimeUnit unit)

}

//CommandGateway commandGateway
//    groovy.lang.Closure

//    def gateway = new com.undancer.breath.event.Gateway() {}

//    DefaultCommandGateway gateway = [] as DefaultCommandGateway
