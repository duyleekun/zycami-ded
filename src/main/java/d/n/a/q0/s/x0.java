/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCallback
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.jakewharton.rxrelay2.PublishRelay;
import com.polidea.rxandroidble2.RxBleConnection$RxBleConnectionState;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import com.polidea.rxandroidble2.exceptions.BleGattDescriptorException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.k.b.c;
import d.n.a.b0;
import d.n.a.q0.s.a;
import d.n.a.q0.s.p0;
import d.n.a.q0.s.w;
import d.n.a.q0.s.x0$a;
import d.n.a.q0.s.x0$b;
import d.n.a.q0.s.x0$c;
import e.a.e0;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class x0 {
    private final h0 a;
    public final a b;
    public final w c;
    public final p0 d;
    public final PublishRelay e;
    public final x0$c f;
    public final x0$c g;
    public final x0$c h;
    public final c i;
    public final x0$c j;
    public final x0$c k;
    public final x0$c l;
    public final x0$c m;
    public final x0$c n;
    private final o o;
    private final BluetoothGattCallback p;

    public x0(h0 h02, a a10, w w10, p0 p02) {
        Object object = PublishRelay.k8();
        this.e = object;
        this.f = object = new x0$c();
        this.g = object = new x0$c();
        this.h = object = new x0$c();
        this.i = object = PublishRelay.k8().i8();
        this.j = object = new x0$c();
        this.k = object = new x0$c();
        this.l = object = new x0$c();
        this.m = object = new x0$c();
        this.n = object = new x0$c();
        this.o = object = new x0$a(this);
        object = new x0$b(this);
        this.p = object;
        this.a = h02;
        this.b = a10;
        this.c = w10;
        this.d = p02;
    }

    private static boolean l(int n10) {
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public static RxBleConnection$RxBleConnectionState m(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return RxBleConnection$RxBleConnectionState.DISCONNECTED;
                }
                return RxBleConnection$RxBleConnectionState.DISCONNECTING;
            }
            return RxBleConnection$RxBleConnectionState.CONNECTED;
        }
        return RxBleConnection$RxBleConnectionState.CONNECTING;
    }

    public static boolean o(x0$c x0$c, BluetoothGatt bluetoothGatt, int n10, d.n.a.o0.a a10) {
        BleGattException bleGattException;
        boolean bl2;
        boolean bl3 = x0.l(n10);
        if (bl3 && (bl2 = x0.r(x0$c, bleGattException = new BleGattException(bluetoothGatt, n10, a10)))) {
            bl2 = true;
        } else {
            bl2 = false;
            x0$c = null;
        }
        return bl2;
    }

    public static boolean p(x0$c x0$c, BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10, d.n.a.o0.a a10) {
        BleGattCharacteristicException bleGattCharacteristicException;
        boolean bl2;
        boolean bl3 = x0.l(n10);
        if (bl3 && (bl2 = x0.r(x0$c, bleGattCharacteristicException = new BleGattCharacteristicException(bluetoothGatt, bluetoothGattCharacteristic, n10, a10)))) {
            bl2 = true;
        } else {
            bl2 = false;
            x0$c = null;
        }
        return bl2;
    }

    public static boolean q(x0$c x0$c, BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int n10, d.n.a.o0.a a10) {
        BleGattDescriptorException bleGattDescriptorException;
        boolean bl2;
        boolean bl3 = x0.l(n10);
        if (bl3 && (bl2 = x0.r(x0$c, bleGattDescriptorException = new BleGattDescriptorException(bluetoothGatt, bluetoothGattDescriptor, n10, a10)))) {
            bl2 = true;
        } else {
            bl2 = false;
            x0$c = null;
        }
        return bl2;
    }

    private static boolean r(x0$c x0$c, BleGattException bleGattException) {
        x0$c.b.accept(bleGattException);
        return true;
    }

    private z u(x0$c object) {
        z z10 = this.c.b();
        PublishRelay publishRelay = ((x0$c)object).a;
        object = ((x0$c)object).b;
        o o10 = this.o;
        object = ((z)object).s2(o10);
        return z.M3(z10, publishRelay, (e0)object);
    }

    public BluetoothGattCallback a() {
        return this.p;
    }

    public z b() {
        Object object = this.n;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z c() {
        z z10 = this.c.b();
        Object object = this.i;
        z10 = z.L3(z10, object);
        object = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return z10.F1(0L, (TimeUnit)((Object)object), h02);
    }

    public z d() {
        Object object = this.g;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z e() {
        Object object = this.h;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z f() {
        PublishRelay publishRelay = this.e;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return publishRelay.F1(0L, timeUnit, h02);
    }

    public z g() {
        Object object = this.j;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z h() {
        Object object = this.k;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z i() {
        Object object = this.m;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z j() {
        Object object = this.l;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z k() {
        Object object = this.f;
        object = this.u((x0$c)object);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h0 h02 = this.a;
        return ((z)object).F1(0L, timeUnit, h02);
    }

    public z n() {
        return this.c.b();
    }

    public void s(b0 b02) {
        this.d.m(b02);
    }

    public void t(BluetoothGattCallback bluetoothGattCallback) {
        this.d.l(bluetoothGattCallback);
    }
}

