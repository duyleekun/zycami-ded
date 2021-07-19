/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity.result;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import java.util.ArrayList;
import java.util.Iterator;

public class ActivityResultRegistry$LifecycleContainer {
    public final Lifecycle mLifecycle;
    private final ArrayList mObservers;

    public ActivityResultRegistry$LifecycleContainer(Lifecycle arrayList) {
        this.mLifecycle = arrayList;
        this.mObservers = arrayList = new ArrayList();
    }

    public void addObserver(LifecycleEventObserver lifecycleEventObserver) {
        this.mLifecycle.addObserver(lifecycleEventObserver);
        this.mObservers.add(lifecycleEventObserver);
    }

    public void clearObservers() {
        boolean bl2;
        Iterator iterator2 = this.mObservers.iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver)iterator2.next();
            Lifecycle lifecycle = this.mLifecycle;
            lifecycle.removeObserver(lifecycleEventObserver);
        }
        this.mObservers.clear();
    }
}

