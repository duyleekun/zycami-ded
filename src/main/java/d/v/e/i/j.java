/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import d.v.e.i.c;
import java.util.concurrent.atomic.AtomicBoolean;
import m.a.a;

public class j
extends MutableLiveData {
    private final AtomicBoolean a;

    public j() {
        AtomicBoolean atomicBoolean;
        this.a = atomicBoolean = new AtomicBoolean(false);
    }

    private /* synthetic */ void b(Observer observer, Object object) {
        AtomicBoolean atomicBoolean = this.a;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.compareAndSet(bl2, false);
        if (bl3) {
            observer.onChanged(object);
        }
    }

    public void a() {
        this.setValue(null);
    }

    public /* synthetic */ void c(Observer observer, Object object) {
        this.b(observer, object);
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer observer) {
        Object[] objectArray;
        boolean bl2 = this.hasActiveObservers();
        if (bl2) {
            bl2 = false;
            objectArray = new Object[]{};
            String string2 = "Multiple observers registered but only one will be notified of changes.";
            m.a.a.x(string2, objectArray);
        }
        objectArray = new c(this, observer);
        super.observe(lifecycleOwner, (Observer)objectArray);
    }

    public void setValue(Object object) {
        this.a.set(true);
        super.setValue(object);
    }
}

