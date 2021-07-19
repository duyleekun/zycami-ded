/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;

public class AbstractExecutionThreadService$1$1
implements Supplier {
    public final /* synthetic */ AbstractExecutionThreadService$1 this$1;

    public AbstractExecutionThreadService$1$1(AbstractExecutionThreadService$1 abstractExecutionThreadService$1) {
        this.this$1 = abstractExecutionThreadService$1;
    }

    public String get() {
        return this.this$1.this$0.serviceName();
    }
}

