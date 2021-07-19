/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import androidx.core.util.Pair;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.StackLiveData$1;
import java.util.LinkedList;

public final class StackLiveData
extends MutableLiveData {
    private final LinkedList a;

    public StackLiveData() {
        LinkedList linkedList;
        this.a = linkedList = new LinkedList();
    }

    public static /* synthetic */ LinkedList a(StackLiveData stackLiveData) {
        return stackLiveData.a;
    }

    public static /* synthetic */ void b(StackLiveData stackLiveData, LifecycleOwner lifecycleOwner, Observer observer) {
        super.observe(lifecycleOwner, observer);
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer observer) {
        Object object = (Pair)this.a.peekLast();
        if (object != null && (object = ((Pair)object).first) != null) {
            object = (LifecycleOwner)object;
            this.removeObservers((LifecycleOwner)object);
        }
        object = lifecycleOwner.getLifecycle();
        Object object2 = new StackLiveData$1(this);
        ((Lifecycle)object).addObserver((LifecycleObserver)object2);
        object = this.a;
        object2 = Pair.create(lifecycleOwner, observer);
        ((LinkedList)object).addLast(object2);
        super.observe(lifecycleOwner, observer);
    }
}

