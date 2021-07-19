/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import d.v.e.i.b;
import d.v.e.i.i$a;
import java.util.concurrent.atomic.AtomicBoolean;

public class i
extends MediatorLiveData {
    private final AtomicBoolean a;
    private boolean b;

    public i() {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean(false);
        this.b = false;
    }

    private /* synthetic */ void d(Observer observer, Object object) {
        AtomicBoolean atomicBoolean = this.a;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.compareAndSet(bl2, false);
        if (bl3) {
            observer.onChanged(object);
        }
    }

    public void a() {
        this.b = true;
    }

    public void b(LiveData liveData, Observer observer, boolean bl2) {
        Object object;
        if (bl2 && (object = liveData.getValue()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        i$a i$a = new i$a(this, bl2, observer);
        super.addSource(liveData, i$a);
    }

    public void c() {
        this.setValue(null);
    }

    public /* synthetic */ void e(Observer observer, Object object) {
        this.d(observer, object);
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer observer) {
        b b10 = new b(this, observer);
        super.observe(lifecycleOwner, b10);
    }

    public void setValue(Object object) {
        AtomicBoolean atomicBoolean = this.a;
        boolean bl2 = this.b ^ true;
        atomicBoolean.set(bl2);
        this.b = false;
        super.setValue(object);
    }
}

