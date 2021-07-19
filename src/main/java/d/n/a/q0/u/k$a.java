/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import d.n.a.q0.p;
import d.n.a.q0.u.k;
import d.n.a.q0.w.j;
import e.a.b0;
import e.a.i;
import e.a.l0;
import e.a.s0.b;

public class k$a
implements l0 {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ j b;
    public final /* synthetic */ k c;

    public k$a(k k10, b0 b02, j j10) {
        this.c = k10;
        this.a = b02;
        this.b = j10;
    }

    public void a(BluetoothGatt object) {
        object.close();
        object = this.c;
        b0 b02 = this.a;
        j j10 = this.b;
        ((k)object).d(b02, j10);
    }

    public void onError(Throwable object) {
        Object object2 = new Object[]{};
        p.v((Throwable)object, "Disconnect operation has been executed but finished with an error - considering disconnected.", object2);
        object = this.c;
        object2 = this.a;
        j j10 = this.b;
        ((k)object).d((i)object2, j10);
    }

    public void onSubscribe(b b10) {
    }
}

