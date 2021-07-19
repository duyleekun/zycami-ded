/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.i1.s2.r;
import d.v.c.i1.s2.s;

public class r$b
implements BleConnection$j {
    public final /* synthetic */ r a;

    public r$b(r r10) {
        this.a = r10;
    }

    public void a() {
        d.v.g0.s.j();
        r.r(this.a);
    }

    public void b(Stabilizer stabilizer) {
        s s10 = r.o(this.a);
        BleDevice bleDevice = new BleDevice(stabilizer);
        s10.c(bleDevice);
    }

    public void c(Throwable throwable, Stabilizer stabilizer) {
    }

    public void d(Stabilizer object) {
        r.o(this.a).c(null);
        object = r.o((r)this.a).d;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
    }

    public void e(Stabilizer object) {
        if (object == null) {
            return;
        }
        Object object2 = r.o((r)this.a).d;
        Object object3 = Boolean.TRUE;
        ((MutableLiveData)object2).setValue(object3);
        object2 = r.o(this.a);
        int n10 = ((s)object2).b();
        int n11 = 2;
        if (n10 == n11) {
            object = this.a;
            r.p((r)object, n11);
        } else {
            object2 = r.o(this.a);
            object3 = new BleDevice((Stabilizer)object);
            ((s)object2).c((BleDevice)object3);
        }
    }

    public void f(boolean bl2) {
        d.v.g0.s.j();
        if (bl2) {
            r r10 = this.a;
            r.s(r10);
        } else {
            r r11 = this.a;
            r.t(r11);
        }
    }

    public void g() {
        d.v.g0.s.j();
        r.u(this.a);
    }

    public void h() {
        d.v.g0.s.j();
        r.q(this.a);
    }
}

