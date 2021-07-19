/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

public final class ServiceManager$ServiceManagerState$StoppedGuard
extends Monitor$Guard {
    public final /* synthetic */ ServiceManager$ServiceManagerState this$0;

    public ServiceManager$ServiceManagerState$StoppedGuard(ServiceManager$ServiceManagerState object) {
        this.this$0 = object;
        object = ((ServiceManager$ServiceManagerState)object).monitor;
        super((Monitor)object);
    }

    public boolean isSatisfied() {
        Multiset multiset = this.this$0.states;
        Object object = Service$State.TERMINATED;
        int n10 = multiset.count(object);
        object = this.this$0.states;
        Service$State service$State = Service$State.FAILED;
        int n11 = object.count((Object)service$State);
        n10 += n11;
        object = this.this$0;
        n11 = ((ServiceManager$ServiceManagerState)object).numberOfServices;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            multiset = null;
        }
        return n10;
    }
}

