/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0$a;
import d.n.a.q0.s.s0$b;
import d.n.a.q0.s.s0$c;
import d.n.a.q0.s.s0$d;
import d.n.a.q0.s.s0$e;
import d.n.a.q0.s.s0$f;
import d.n.a.q0.s.s0$g;
import d.n.a.q0.s.x0;
import d.n.a.q0.x.g;
import e.a.a;
import e.a.f0;
import e.a.h;
import e.a.v0.o;
import e.a.z;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class s0 {
    public static final UUID h = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public final byte[] a;
    public final byte[] b;
    public final byte[] c;
    public final BluetoothGatt d;
    public final x0 e;
    public final s f;
    public final Map g;

    public s0(byte[] byArray, byte[] byArray2, byte[] byArray3, BluetoothGatt bluetoothGatt, x0 x02, s s10) {
        HashMap hashMap;
        this.g = hashMap = new HashMap();
        this.a = byArray;
        this.b = byArray2;
        this.c = byArray3;
        this.d = bluetoothGatt;
        this.e = x02;
        this.f = s10;
    }

    public static z a(x0 object, g object2) {
        object = ((x0)object).c();
        s0$f s0$f = new s0$f((g)((Object)object2));
        object = ((z)object).o2(s0$f);
        object2 = new s0$e();
        return ((z)object).H3((o)object2);
    }

    public static a b(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean bl2) {
        s0$b s0$b = new s0$b(bluetoothGatt, bluetoothGattCharacteristic, bl2);
        return e.a.a.X(s0$b);
    }

    public static f0 c(s s10, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] byArray, NotificationSetupMode notificationSetupMode) {
        s0$c s0$c = new s0$c(notificationSetupMode, bluetoothGattCharacteristic, s10, byArray);
        return s0$c;
    }

    public static h e(s s10, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] byArray, NotificationSetupMode notificationSetupMode) {
        s0$d s0$d = new s0$d(notificationSetupMode, bluetoothGattCharacteristic, s10, byArray);
        return s0$d;
    }

    public static a f(BluetoothGattCharacteristic bluetoothGattCharacteristic, s object, byte[] object2) {
        UUID uUID = h;
        if ((uUID = bluetoothGattCharacteristic.getDescriptor(uUID)) == null) {
            object = new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, null);
            return e.a.a.V((Throwable)object);
        }
        object = ((s)object).a((BluetoothGattDescriptor)uUID, (byte[])object2);
        object2 = new s0$g;
        object2(bluetoothGattCharacteristic);
        return ((a)object).w0((o)object2);
    }

    public z d(BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode, boolean bl2) {
        s0$a s0$a = new s0$a(this, bluetoothGattCharacteristic, bl2, notificationSetupMode);
        return z.D1(s0$a);
    }
}

