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
import e.a.a;
import e.a.g;
import e.a.h;

public final class s0$d
implements h {
    public final /* synthetic */ NotificationSetupMode a;
    public final /* synthetic */ BluetoothGattCharacteristic b;
    public final /* synthetic */ s c;
    public final /* synthetic */ byte[] d;

    public s0$d(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, s s10, byte[] byArray) {
        this.a = notificationSetupMode;
        this.b = bluetoothGattCharacteristic;
        this.c = s10;
        this.d = byArray;
    }

    public a a(a a10) {
        Object object = this.a;
        Object object2 = NotificationSetupMode.COMPAT;
        if (object == object2) {
            return a10;
        }
        object = this.b;
        object2 = this.c;
        byte[] byArray = this.d;
        object = s0.f((BluetoothGattCharacteristic)object, (s)object2, byArray);
        return a10.n((g)object);
    }
}

