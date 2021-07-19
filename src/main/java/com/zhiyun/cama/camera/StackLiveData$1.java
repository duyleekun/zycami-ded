/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import androidx.core.util.Pair;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.StackLiveData;
import java.util.AbstractSequentialList;
import java.util.LinkedList;

public class StackLiveData$1
implements DefaultLifecycleObserver {
    public final /* synthetic */ StackLiveData a;

    public StackLiveData$1(StackLiveData stackLiveData) {
        this.a = stackLiveData;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy(LifecycleOwner object) {
        synchronized (this) {
            boolean bl2;
            Object object2 = object.getLifecycle();
            ((Lifecycle)object2).removeObserver(this);
            object2 = this.a;
            object2 = StackLiveData.a((StackLiveData)object2);
            object2 = ((AbstractSequentialList)object2).iterator();
            while (bl2 = object2.hasNext()) {
                Object e10 = object2.next();
                Pair pair = (Pair)e10;
                Object object3 = pair.first;
                if (object3 != object) continue;
                object2.remove();
                break;
            }
            object = this.a;
            object = StackLiveData.a((StackLiveData)object);
            object = ((LinkedList)object).peekLast();
            if ((object = (Pair)object) != null && (object2 = ((Pair)object).first) != null && (object = ((Pair)object).second) != null) {
                StackLiveData stackLiveData = this.a;
                object2 = (LifecycleOwner)object2;
                object = (Observer)object;
                StackLiveData.b(stackLiveData, (LifecycleOwner)object2, (Observer)object);
            }
            return;
        }
    }
}

