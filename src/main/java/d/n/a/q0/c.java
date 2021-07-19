/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import d.k.b.b;
import d.n.a.j0;
import d.n.a.q0.c$a;
import d.n.a.q0.l;
import d.n.a.q0.s.m;
import d.n.a.q0.s.o;
import d.n.a.q0.s.p;
import d.n.a.q0.u.z;
import d.n.a.q0.x.y;
import e.a.h0;
import java.util.concurrent.TimeUnit;

public abstract class c {
    public static final String a = "mac-address";
    public static final String b = "operation-timeout";
    public static final String c = "disconnect-timeout";
    public static final String d = "connect-timeout";
    private static final int e = 30;
    private static final int f = 10;
    private static final int g = 35;

    public static BluetoothDevice c(String string2, y y10) {
        return y10.b(string2);
    }

    public static m d(b b10) {
        c$a c$a = new c$a(b10);
        return c$a;
    }

    public static b e() {
        return d.k.b.b.l8((Object)RxBleConnection$RxBleConnectionState.DISCONNECTED);
    }

    public static z f(h0 h02) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z z10 = new z(35, timeUnit, h02);
        return z10;
    }

    public static z g(h0 h02) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        z z10 = new z(10, timeUnit, h02);
        return z10;
    }

    public abstract o a(p var1);

    public abstract j0 b(l var1);
}

