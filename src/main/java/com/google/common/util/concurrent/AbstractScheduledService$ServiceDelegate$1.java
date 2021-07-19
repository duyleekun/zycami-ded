/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate;

public class AbstractScheduledService$ServiceDelegate$1
implements Supplier {
    public final /* synthetic */ AbstractScheduledService$ServiceDelegate this$1;

    public AbstractScheduledService$ServiceDelegate$1(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        this.this$1 = abstractScheduledService$ServiceDelegate;
    }

    public String get() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.this$1.this$0.serviceName();
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        object = this.this$1.state();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

