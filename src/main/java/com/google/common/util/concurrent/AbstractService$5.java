/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ListenerCallQueue$Event;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;

public class AbstractService$5
implements ListenerCallQueue$Event {
    public final /* synthetic */ AbstractService this$0;
    public final /* synthetic */ Throwable val$cause;
    public final /* synthetic */ Service$State val$from;

    public AbstractService$5(AbstractService abstractService, Service$State service$State, Throwable throwable) {
        this.this$0 = abstractService;
        this.val$from = service$State;
        this.val$cause = throwable;
    }

    public void call(Service$Listener service$Listener) {
        Service$State service$State = this.val$from;
        Throwable throwable = this.val$cause;
        service$Listener.failed(service$State, throwable);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed({from = ");
        Object object = this.val$from;
        stringBuilder.append(object);
        stringBuilder.append(", cause = ");
        object = this.val$cause;
        stringBuilder.append(object);
        stringBuilder.append("})");
        return stringBuilder.toString();
    }
}

