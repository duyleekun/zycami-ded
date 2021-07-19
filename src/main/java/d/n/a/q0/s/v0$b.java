/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.os.DeadObjectException
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.i0;
import d.n.a.q0.j;
import d.n.a.q0.k;
import d.n.a.q0.s.v0;
import d.n.a.q0.s.v0$b$a;
import d.n.a.q0.s.x0;
import d.n.a.q0.x.x;
import e.a.b0;
import e.a.g0;
import e.a.h0;
import e.a.v0.a;
import e.a.z;

public class v0$b
extends k {
    public final /* synthetic */ i0 a;
    public final /* synthetic */ j b;
    public final /* synthetic */ v0 c;

    public v0$b(v0 v02, i0 i02, j j10) {
        this.c = v02;
        this.a = i02;
        this.b = j10;
    }

    private a d() {
        v0$b$a v0$b$a = new v0$b$a(this);
        return v0$b$a;
    }

    public j E() {
        return this.b;
    }

    public void b(b0 object, d.n.a.q0.w.j j10) {
        Object object2;
        try {
            object2 = this.a;
        }
        catch (Throwable throwable) {
            j10.release();
            throw throwable;
        }
        Object object3 = this.c;
        BluetoothGatt bluetoothGatt = ((v0)object3).g;
        x0 x02 = ((v0)object3).f;
        object3 = ((v0)object3).j;
        object2 = object2.a(bluetoothGatt, x02, (h0)object3);
        if (object2 != null) {
            object3 = new x((b0)object, j10);
            object = this.d();
            ((z)object2).h2((a)object).subscribe((g0)object3);
            return;
        }
        j10.release();
        object = new IllegalArgumentException("The custom operation asObservable method must return a non-null observable");
        throw object;
    }

    public BleException c(DeadObjectException deadObjectException) {
        String string2 = this.c.g.getDevice().getAddress();
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(deadObjectException, string2, -1);
        return bleDisconnectedException;
    }
}

