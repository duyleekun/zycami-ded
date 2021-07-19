/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;

public final class AbstractService$HasReachedRunningGuard
extends Monitor$Guard {
    public final /* synthetic */ AbstractService this$0;

    public AbstractService$HasReachedRunningGuard(AbstractService object) {
        this.this$0 = object;
        object = AbstractService.access$000((AbstractService)object);
        super((Monitor)object);
    }

    public boolean isSatisfied() {
        Service$State service$State;
        Service$State service$State2 = this.this$0.state();
        int n10 = service$State2.compareTo(service$State = Service$State.RUNNING);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            service$State2 = null;
        }
        return n10 != 0;
    }
}

