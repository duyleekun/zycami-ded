/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.os.DeadObjectException
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothDevice;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.q0.k;
import d.n.a.q0.s.m;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.d$a;
import d.n.a.q0.u.d$b;
import d.n.a.q0.u.d$c;
import d.n.a.q0.u.d$d;
import d.n.a.q0.u.d$e;
import d.n.a.q0.u.z;
import d.n.a.q0.w.j;
import d.n.a.q0.x.b;
import d.n.a.q0.x.o;
import e.a.b0;
import e.a.i0;
import e.a.l0;
import e.a.p0;
import e.a.v0.a;
import e.a.y0.e;

public class d
extends k {
    public final BluetoothDevice a;
    public final b b;
    public final x0 c;
    public final d.n.a.q0.s.a d;
    public final z e;
    public final boolean f;
    public final m g;

    public d(BluetoothDevice bluetoothDevice, b b10, x0 x02, d.n.a.q0.s.a a10, z z10, boolean bl2, m m10) {
        this.a = bluetoothDevice;
        this.b = b10;
        this.c = x02;
        this.d = a10;
        this.e = z10;
        this.f = bl2;
        this.g = m10;
    }

    private i0 e() {
        d$d d$d = new d$d(this);
        return i0.H(d$d);
    }

    private p0 g() {
        d$b d$b = new d$b(this);
        return d$b;
    }

    public void b(b0 b02, j j10) {
        Object object = new d$a(this, j10);
        Object object2 = this.e();
        p0 p02 = this.g();
        object = ((i0)object2).s(p02).W((a)object);
        object2 = o.b(b02);
        object = (e)((i0)object).h((l0)object2);
        b02.setDisposable((e.a.s0.b)object);
        boolean bl2 = this.f;
        if (bl2) {
            j10.release();
        }
    }

    public BleException c(DeadObjectException deadObjectException) {
        String string2 = this.a.getAddress();
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(deadObjectException, string2, -1);
        return bleDisconnectedException;
    }

    public i0 d() {
        d$e d$e = new d$e(this);
        return i0.o0(d$e);
    }

    public i0 f() {
        d$c d$c = new d$c(this);
        return i0.o0(d$c);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectOperation{");
        String string2 = d.n.a.q0.t.b.d(this.a.getAddress());
        stringBuilder.append(string2);
        stringBuilder.append(", autoConnect=");
        boolean bl2 = this.f;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

