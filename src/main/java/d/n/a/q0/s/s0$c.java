/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.NotificationSetupMode;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0;
import d.n.a.q0.s.s0$c$a;
import d.n.a.q0.s.s0$h;
import e.a.a;
import e.a.e0;
import e.a.f0;
import e.a.g;
import e.a.v0.o;
import e.a.z;

public final class s0$c
implements f0 {
    public final /* synthetic */ NotificationSetupMode a;
    public final /* synthetic */ BluetoothGattCharacteristic b;
    public final /* synthetic */ s c;
    public final /* synthetic */ byte[] d;

    public s0$c(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, s s10, byte[] byArray) {
        this.a = notificationSetupMode;
        this.b = bluetoothGattCharacteristic;
        this.c = s10;
        this.d = byArray;
    }

    public e0 a(z z10) {
        Object object = s0$h.a;
        Object object2 = this.a;
        int n10 = object2.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                object = this.b;
                object2 = this.c;
                byte[] byArray = this.d;
                return s0.f((BluetoothGattCharacteristic)object, (s)object2, byArray).q(z10);
            }
            object = this.b;
            s s10 = this.c;
            byte[] byArray = this.d;
            object = s0.f((BluetoothGattCharacteristic)object, s10, byArray).Z0().t4().i8(n10).k3();
            z10 = z10.d4((g)object);
            object2 = new s0$c$a(this, (a)object);
            z10 = z10.H3((o)object2);
        }
        return z10;
    }
}

