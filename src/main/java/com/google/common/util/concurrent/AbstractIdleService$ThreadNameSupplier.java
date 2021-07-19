/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$1;

public final class AbstractIdleService$ThreadNameSupplier
implements Supplier {
    public final /* synthetic */ AbstractIdleService this$0;

    private AbstractIdleService$ThreadNameSupplier(AbstractIdleService abstractIdleService) {
        this.this$0 = abstractIdleService;
    }

    public /* synthetic */ AbstractIdleService$ThreadNameSupplier(AbstractIdleService abstractIdleService, AbstractIdleService$1 abstractIdleService$1) {
        this(abstractIdleService);
    }

    public String get() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.this$0.serviceName();
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        object = this.this$0.state();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

