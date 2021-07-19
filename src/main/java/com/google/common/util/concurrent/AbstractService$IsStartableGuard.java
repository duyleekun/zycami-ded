/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;

public final class AbstractService$IsStartableGuard
extends Monitor$Guard {
    public final /* synthetic */ AbstractService this$0;

    public AbstractService$IsStartableGuard(AbstractService object) {
        this.this$0 = object;
        object = AbstractService.access$000((AbstractService)object);
        super((Monitor)object);
    }

    public boolean isSatisfied() {
        boolean bl2;
        Service$State service$State;
        Service$State service$State2 = this.this$0.state();
        if (service$State2 == (service$State = Service$State.NEW)) {
            bl2 = true;
        } else {
            bl2 = false;
            service$State2 = null;
        }
        return bl2;
    }
}

