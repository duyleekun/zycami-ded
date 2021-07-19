/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;

public final class AbstractService$IsStoppedGuard
extends Monitor$Guard {
    public final /* synthetic */ AbstractService this$0;

    public AbstractService$IsStoppedGuard(AbstractService object) {
        this.this$0 = object;
        object = AbstractService.access$000((AbstractService)object);
        super((Monitor)object);
    }

    public boolean isSatisfied() {
        return this.this$0.state().isTerminal();
    }
}

