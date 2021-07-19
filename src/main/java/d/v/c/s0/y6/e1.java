/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.data.CameraSet$Exception;
import com.zhiyun.protocol.core.entities.ErrorStatus;
import com.zhiyun.stabilizer.Stabilizer$g;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class e1
implements Stabilizer$g {
    private final AtomicInteger a;
    private final AtomicBoolean b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final AtomicBoolean g;
    private final MutableLiveData h;
    private final MutableLiveData i;

    public e1() {
        Object object = new AtomicInteger();
        this.a = object;
        this.b = object;
        super();
        this.c = object;
        super();
        this.d = object;
        super();
        this.e = object;
        super();
        this.f = object;
        super();
        this.g = object;
        this.h = object = new MutableLiveData();
        this.i = object = new MutableLiveData();
    }

    private boolean b(AtomicBoolean atomicBoolean, boolean bl2) {
        boolean bl3 = atomicBoolean.getAndSet(bl2);
        if (bl2 == bl3) {
            bl3 = true;
        } else {
            bl3 = false;
            atomicBoolean = null;
        }
        return bl3;
    }

    private boolean c(AtomicInteger atomicInteger, int n10) {
        int n11 = atomicInteger.getAndSet(n10);
        if (n10 == n11) {
            n11 = 1;
        } else {
            n11 = 0;
            atomicInteger = null;
        }
        return n11 != 0;
    }

    private void f(CameraSet$Exception object, AtomicBoolean serializable, boolean bl2) {
        if (!(bl2 = this.b((AtomicBoolean)serializable, bl2))) {
            MutableLiveData mutableLiveData = this.i;
            boolean bl3 = serializable.get();
            serializable = Boolean.valueOf(bl3);
            object = Pair.create(object, serializable);
            mutableLiveData.postValue(object);
        }
    }

    public void a(boolean bl2, int n10, ErrorStatus errorStatus) {
        Object object;
        Serializable serializable;
        int n11 = 10;
        n11 = n10 <= n11 ? 1 : 0;
        Object object2 = this.a;
        if ((n10 = (int)(this.c((AtomicInteger)object2, n10) ? 1 : 0)) == 0 || (bl2 = this.b((AtomicBoolean)(serializable = this.b), bl2))) {
            bl2 = this.b.get();
            n10 = this.a.get();
            object2 = this.h;
            object = bl2;
            serializable = Integer.valueOf(n10);
            object = Pair.create(object, serializable);
            ((MutableLiveData)object2).postValue(object);
        }
        object = CameraSet$Exception.AXIS_LOCK;
        serializable = this.c;
        boolean bl3 = errorStatus.axislock;
        this.f((CameraSet$Exception)((Object)object), (AtomicBoolean)serializable, bl3);
        object = CameraSet$Exception.OVER_HEAT;
        serializable = this.d;
        bl3 = errorStatus.overheat;
        this.f((CameraSet$Exception)((Object)object), (AtomicBoolean)serializable, bl3);
        object = CameraSet$Exception.LOW_OPS;
        serializable = this.e;
        bl3 = errorStatus.lowpos;
        this.f((CameraSet$Exception)((Object)object), (AtomicBoolean)serializable, bl3);
        object = CameraSet$Exception.NO_LOAD;
        serializable = this.f;
        boolean bl4 = errorStatus.noload;
        this.f((CameraSet$Exception)((Object)object), (AtomicBoolean)serializable, bl4);
        object = CameraSet$Exception.LOW_BATTERY;
        serializable = this.g;
        this.f((CameraSet$Exception)((Object)object), (AtomicBoolean)serializable, n11 != 0);
    }

    public LiveData d() {
        return this.h;
    }

    public LiveData e() {
        return this.i;
    }
}

