/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothGatt;
import d.n.a.o0.a;
import d.n.a.q0.q;
import d.n.a.q0.s.x0;
import d.n.a.q0.u.z;
import e.a.h0;
import e.a.i0;
import java.util.concurrent.TimeUnit;

public class f
extends q {
    private final int e;
    private final z f;

    public f(x0 x02, BluetoothGatt bluetoothGatt, z z10, int n10, z z11) {
        a a10 = a.m;
        super(bluetoothGatt, x02, a10, z10);
        this.e = n10;
        this.f = z11;
    }

    private static String g(int n10) {
        if (n10 != 0) {
            int n11 = 2;
            if (n10 != n11) {
                return "CONNECTION_PRIORITY_HIGH";
            }
            return "CONNECTION_PRIORITY_LOW_POWER";
        }
        return "CONNECTION_PRIORITY_BALANCED";
    }

    public i0 d(x0 object) {
        object = this.f;
        long l10 = ((z)object).a;
        TimeUnit timeUnit = ((z)object).b;
        object = ((z)object).c;
        return i0.p1(l10, timeUnit, (h0)object);
    }

    public boolean e(BluetoothGatt bluetoothGatt) {
        int n10 = this.e;
        return bluetoothGatt.requestConnectionPriority(n10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionPriorityChangeOperation{");
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", connectionPriority=");
        object = d.n.a.q0.u.f.g(this.e);
        stringBuilder.append((String)object);
        stringBuilder.append(", successTimeout=");
        object = this.f;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

