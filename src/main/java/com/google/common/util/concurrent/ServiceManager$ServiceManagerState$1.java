/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;
import java.util.Map;

public class ServiceManager$ServiceManagerState$1
implements Function {
    public final /* synthetic */ ServiceManager$ServiceManagerState this$0;

    public ServiceManager$ServiceManagerState$1(ServiceManager$ServiceManagerState serviceManager$ServiceManagerState) {
        this.this$0 = serviceManager$ServiceManagerState;
    }

    public Long apply(Map.Entry entry) {
        return (Long)entry.getValue();
    }
}

