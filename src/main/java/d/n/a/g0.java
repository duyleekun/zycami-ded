/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleClient$State;
import d.n.a.b$c;
import d.n.a.g0$a;
import d.n.a.g0$b;
import d.n.a.g0$c;
import d.n.a.g0$d;
import d.n.a.g0$e;
import d.n.a.g0$f;
import d.n.a.g0$g;
import d.n.a.j0;
import d.n.a.m0;
import d.n.a.q0.n;
import d.n.a.q0.u.m;
import d.n.a.q0.u.p;
import d.n.a.q0.v.l;
import d.n.a.q0.v.x;
import d.n.a.q0.x.a0;
import d.n.a.q0.x.i;
import d.n.a.q0.x.r;
import d.n.a.q0.x.y;
import d.n.a.r0.a;
import d.n.a.r0.b;
import d.n.a.r0.e;
import e.a.e0;
import e.a.h0;
import e.a.q;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class g0
extends RxBleClient {
    public static final String p = "RxBleClient";
    public final d.n.a.q0.w.a a;
    private final a0 b;
    private final n c;
    public final x d;
    public final d.n.a.q0.v.n e;
    public final o f;
    private final b$c g;
    public final h0 h;
    public final Map i;
    private final y j;
    private final z k;
    private final r l;
    private final c.a.e m;
    private final a n;
    private final i o;

    public g0(y y10, d.n.a.q0.w.a a10, z z10, a0 a02, r r10, c.a.e e10, n n10, x x10, d.n.a.q0.v.n n11, o o10, h0 h02, b$c b$c, a a11, i i10) {
        HashMap hashMap;
        this.i = hashMap = new HashMap();
        this.b = a02;
        this.a = a10;
        this.j = y10;
        this.k = z10;
        this.l = r10;
        this.m = e10;
        this.c = n10;
        this.d = x10;
        this.e = n11;
        this.f = o10;
        this.h = h02;
        this.g = b$c;
        this.n = a11;
        this.o = i10;
    }

    private z o(UUID[] object) {
        Object object2 = this.b.f((UUID[])object);
        y y10 = this.j;
        a0 a02 = this.b;
        Object object3 = new m((UUID[])object, y10, a02);
        object = this.a.d((p)object3);
        object3 = new g0$g(this, (Set)object2);
        object = ((z)object).X1((e.a.v0.a)object3);
        object2 = this.m();
        object = ((z)object).f4((e0)object2);
        object2 = new g0$f(this);
        object = ((z)object).H3((o)object2);
        object2 = new g0$e(this);
        return ((z)object).f2((g)object2).p5();
    }

    private void p() {
        Object object = this.j;
        boolean bl2 = ((y)object).c();
        if (bl2) {
            return;
        }
        object = new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
        throw object;
    }

    public a b() {
        return this.n;
    }

    public j0 c(String string2) {
        this.p();
        return this.c.a(string2);
    }

    public Set d() {
        boolean bl2;
        this.p();
        HashSet<Object> hashSet = new HashSet<Object>();
        Iterator iterator2 = this.j.a().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = ((BluetoothDevice)iterator2.next()).getAddress();
            object = this.c((String)object);
            hashSet.add(object);
        }
        return hashSet;
    }

    public String[] e() {
        return this.o.a();
    }

    public RxBleClient$State f() {
        Object object = this.j;
        boolean bl2 = ((y)object).c();
        if (!bl2) {
            return RxBleClient$State.BLUETOOTH_NOT_AVAILABLE;
        }
        object = this.l;
        bl2 = object.b();
        if (!bl2) {
            return RxBleClient$State.LOCATION_PERMISSION_NOT_GRANTED;
        }
        object = this.j;
        bl2 = ((y)object).d();
        if (!bl2) {
            return RxBleClient$State.BLUETOOTH_NOT_ENABLED;
        }
        object = this.l;
        bl2 = object.a();
        if (!bl2) {
            return RxBleClient$State.LOCATION_SERVICES_NOT_ENABLED;
        }
        return RxBleClient$State.READY;
    }

    public void finalize() {
        this.g.a();
        super.finalize();
    }

    public boolean g() {
        return this.o.c();
    }

    public z h() {
        return (z)this.m.get();
    }

    public z i(e e10, b ... bArray) {
        g0$a g0$a = new g0$a(this, e10, bArray);
        return z.D1(g0$a);
    }

    public z j(UUID ... uUIDArray) {
        g0$b g0$b = new g0$b(this, uUIDArray);
        return z.D1(g0$b);
    }

    public z m() {
        Object object = this.k;
        Object object2 = new g0$d(this);
        object = ((z)object).o2((e.a.v0.r)object2).q2();
        object2 = new g0$c(this);
        return ((q)object).h0((o)object2).L1();
    }

    public m0 n(l object) {
        Object object2 = ((l)object).a().getAddress();
        object2 = this.c((String)object2);
        int n10 = ((l)object).b();
        object = ((l)object).c();
        m0 m02 = new m0((j0)object2, n10, (byte[])object);
        return m02;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public z q(UUID[] object) {
        Set set = this.b.f((UUID[])object);
        Map map = this.i;
        synchronized (map) {
            Object object2 = this.i;
            object2 = object2.get(set);
            object2 = (z)object2;
            if (object2 == null) {
                object2 = this.o((UUID[])object);
                object = this.i;
                object.put(set, object2);
            }
            return object2;
        }
    }
}

