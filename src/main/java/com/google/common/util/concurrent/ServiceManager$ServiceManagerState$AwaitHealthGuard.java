/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.Multiset;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service$State;
import com.google.common.util.concurrent.ServiceManager$ServiceManagerState;

public final class ServiceManager$ServiceManagerState$AwaitHealthGuard
extends Monitor$Guard {
    public final /* synthetic */ ServiceManager$ServiceManagerState this$0;

    public ServiceManager$ServiceManagerState$AwaitHealthGuard(ServiceManager$ServiceManagerState object) {
        this.this$0 = object;
        object = ((ServiceManager$ServiceManagerState)object).monitor;
        super((Monitor)object);
    }

    public boolean isSatisfied() {
        Multiset multiset = this.this$0.states;
        Object object = Service$State.RUNNING;
        int n10 = multiset.count(object);
        object = this.this$0;
        int n11 = ((ServiceManager$ServiceManagerState)object).numberOfServices;
        if (n10 != n11 && (n10 = (multiset = ((ServiceManager$ServiceManagerState)object).states).contains(object = Service$State.STOPPING)) == 0 && (n10 = (multiset = this.this$0.states).contains(object = Service$State.TERMINATED)) == 0 && (n10 = (multiset = this.this$0.states).contains(object = Service$State.FAILED)) == 0) {
            n10 = 0;
            multiset = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }
}

