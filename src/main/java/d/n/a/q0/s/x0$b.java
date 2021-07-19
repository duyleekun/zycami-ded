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
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.k.b.c;
import d.n.a.k0;
import d.n.a.q0.s.a;
import d.n.a.q0.s.k;
import d.n.a.q0.s.p0;
import d.n.a.q0.s.w;
import d.n.a.q0.s.x0;
import d.n.a.q0.s.x0$c;
import d.n.a.q0.t.b;
import d.n.a.q0.x.d;
import d.n.a.q0.x.f;
import java.util.List;
import java.util.UUID;

public class x0$b
extends BluetoothGattCallback {
    public final /* synthetic */ x0 a;

    public x0$b(x0 x02) {
        this.a = x02;
    }

    private boolean a(int n10) {
        int n11;
        n10 = n10 != 0 && n10 != (n11 = 3) ? 0 : 1;
        return n10 != 0;
    }

    public void onCharacteristicChanged(BluetoothGatt object, BluetoothGattCharacteristic object2) {
        boolean bl2 = true;
        b.m("onCharacteristicChanged", (BluetoothGatt)object, object2, bl2);
        Object object3 = this.a.d;
        object3.a((BluetoothGatt)object, (BluetoothGattCharacteristic)object2);
        super.onCharacteristicChanged((BluetoothGatt)object, object2);
        object = this.a.i;
        boolean bl3 = ((c)object).h8();
        if (bl3) {
            object = this.a.i;
            UUID uUID = object2.getUuid();
            int n10 = object2.getInstanceId();
            Integer n11 = n10;
            object2 = object2.getValue();
            object3 = new f(uUID, n11, (byte[])object2);
            ((c)object).accept(object3);
        }
    }

    public void onCharacteristicRead(BluetoothGatt object, BluetoothGattCharacteristic object2, int n10) {
        d.n.a.o0.a a10;
        boolean bl2;
        boolean bl3 = true;
        b.k("onCharacteristicRead", (BluetoothGatt)object, n10, object2, bl3);
        this.a.d.g((BluetoothGatt)object, (BluetoothGattCharacteristic)object2, n10);
        super.onCharacteristicRead((BluetoothGatt)object, object2, n10);
        Object object3 = this.a.g;
        boolean bl4 = ((x0$c)object3).a();
        if (bl4 && !(bl2 = x0.p((x0$c)(object3 = this.a.g), (BluetoothGatt)object, object2, n10, a10 = d.n.a.o0.a.d))) {
            object = this.a.g.a;
            object3 = object2.getUuid();
            object2 = object2.getValue();
            d d10 = new d(object3, (byte[])object2);
            ((PublishRelay)object).accept(d10);
        }
    }

    public void onCharacteristicWrite(BluetoothGatt object, BluetoothGattCharacteristic object2, int n10) {
        boolean bl2;
        d.n.a.o0.a a10 = null;
        b.k("onCharacteristicWrite", (BluetoothGatt)object, n10, object2, false);
        this.a.d.k((BluetoothGatt)object, (BluetoothGattCharacteristic)object2, n10);
        super.onCharacteristicWrite((BluetoothGatt)object, object2, n10);
        Object object3 = this.a.h;
        boolean bl3 = ((x0$c)object3).a();
        if (bl3 && !(bl2 = x0.p((x0$c)(object3 = this.a.h), (BluetoothGatt)object, object2, n10, a10 = d.n.a.o0.a.e))) {
            object = this.a.h.a;
            object3 = object2.getUuid();
            object2 = object2.getValue();
            d d10 = new d(object3, (byte[])object2);
            ((PublishRelay)object).accept(d10);
        }
    }

    public void onConnectionStateChange(BluetoothGatt object, int n10, int n11) {
        b.j("onConnectionStateChange", (BluetoothGatt)object, n10, n11);
        this.a.d.b((BluetoothGatt)object, n10, n11);
        super.onConnectionStateChange((BluetoothGatt)object, n10, n11);
        Object object2 = this.a.b;
        ((a)object2).b((BluetoothGatt)object);
        boolean bl2 = this.a(n11);
        if (bl2) {
            object2 = this.a.c;
            object = object.getDevice().getAddress();
            BleDisconnectedException bleDisconnectedException = new BleDisconnectedException((String)object, n10);
            ((w)object2).c(bleDisconnectedException);
        } else if (n10 != 0) {
            object2 = this.a.c;
            d.n.a.o0.a a10 = d.n.a.o0.a.b;
            BleGattException bleGattException = new BleGattException((BluetoothGatt)object, n10, a10);
            ((w)object2).a(bleGattException);
        }
        object = this.a.e;
        RxBleConnection$RxBleConnectionState rxBleConnection$RxBleConnectionState = x0.m(n11);
        ((PublishRelay)object).accept((Object)rxBleConnection$RxBleConnectionState);
    }

    public void onConnectionUpdated(BluetoothGatt object, int n10, int n11, int n12, int n13) {
        boolean bl2;
        Object object2 = object;
        b.n("onConnectionUpdated", (BluetoothGatt)object, n13, n10, n11, n12);
        object2 = this.a.d;
        ((p0)object2).f((BluetoothGatt)object, n10, n11, n12, n13);
        x0$c x0$c = this.a.n;
        boolean bl3 = x0$c.a();
        if (bl3 && !(bl2 = x0.o(x0$c = this.a.n, (BluetoothGatt)object, n13, (d.n.a.o0.a)(object2 = d.n.a.o0.a.m)))) {
            object = this.a.n.a;
            k k10 = new k(n10, n11, n12);
            ((PublishRelay)object).accept(k10);
        }
    }

    public void onDescriptorRead(BluetoothGatt object, BluetoothGattDescriptor bluetoothGattDescriptor, int n10) {
        d.n.a.o0.a a10;
        boolean bl2;
        boolean bl3 = true;
        b.l("onDescriptorRead", (BluetoothGatt)object, n10, bluetoothGattDescriptor, bl3);
        this.a.d.c((BluetoothGatt)object, bluetoothGattDescriptor, n10);
        super.onDescriptorRead((BluetoothGatt)object, bluetoothGattDescriptor, n10);
        Object object2 = this.a.j;
        boolean bl4 = ((x0$c)object2).a();
        if (bl4 && !(bl2 = x0.q((x0$c)(object2 = this.a.j), (BluetoothGatt)object, bluetoothGattDescriptor, n10, a10 = d.n.a.o0.a.h))) {
            object = this.a.j.a;
            object2 = bluetoothGattDescriptor.getValue();
            d d10 = new d(bluetoothGattDescriptor, (byte[])object2);
            ((PublishRelay)object).accept(d10);
        }
    }

    public void onDescriptorWrite(BluetoothGatt object, BluetoothGattDescriptor bluetoothGattDescriptor, int n10) {
        boolean bl2;
        d.n.a.o0.a a10 = null;
        b.l("onDescriptorWrite", (BluetoothGatt)object, n10, bluetoothGattDescriptor, false);
        this.a.d.d((BluetoothGatt)object, bluetoothGattDescriptor, n10);
        super.onDescriptorWrite((BluetoothGatt)object, bluetoothGattDescriptor, n10);
        Object object2 = this.a.k;
        boolean bl3 = ((x0$c)object2).a();
        if (bl3 && !(bl2 = x0.q((x0$c)(object2 = this.a.k), (BluetoothGatt)object, bluetoothGattDescriptor, n10, a10 = d.n.a.o0.a.i))) {
            object = this.a.k.a;
            object2 = bluetoothGattDescriptor.getValue();
            d d10 = new d(bluetoothGattDescriptor, (byte[])object2);
            ((PublishRelay)object).accept(d10);
        }
    }

    public void onMtuChanged(BluetoothGatt object, int n10, int n11) {
        d.n.a.o0.a a10;
        boolean bl2;
        b.j("onMtuChanged", (BluetoothGatt)object, n11, n10);
        this.a.d.e((BluetoothGatt)object, n10, n11);
        super.onMtuChanged((BluetoothGatt)object, n10, n11);
        x0$c x0$c = this.a.m;
        boolean bl3 = x0$c.a();
        if (bl3 && !(bl2 = x0.o(x0$c = this.a.m, (BluetoothGatt)object, n11, a10 = d.n.a.o0.a.l))) {
            object = this.a.m.a;
            Integer n12 = n10;
            ((PublishRelay)object).accept(n12);
        }
    }

    public void onReadRemoteRssi(BluetoothGatt object, int n10, int n11) {
        d.n.a.o0.a a10;
        boolean bl2;
        b.j("onReadRemoteRssi", (BluetoothGatt)object, n11, n10);
        this.a.d.h((BluetoothGatt)object, n10, n11);
        super.onReadRemoteRssi((BluetoothGatt)object, n10, n11);
        x0$c x0$c = this.a.l;
        boolean bl3 = x0$c.a();
        if (bl3 && !(bl2 = x0.o(x0$c = this.a.l, (BluetoothGatt)object, n11, a10 = d.n.a.o0.a.k))) {
            object = this.a.l.a;
            Integer n12 = n10;
            ((PublishRelay)object).accept(n12);
        }
    }

    public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int n10) {
        b.i("onReliableWriteCompleted", bluetoothGatt, n10);
        this.a.d.i(bluetoothGatt, n10);
        super.onReliableWriteCompleted(bluetoothGatt, n10);
    }

    public void onServicesDiscovered(BluetoothGatt object, int n10) {
        d.n.a.o0.a a10;
        b.i("onServicesDiscovered", object, n10);
        this.a.d.j((BluetoothGatt)object, n10);
        super.onServicesDiscovered(object, n10);
        Object object2 = this.a.f;
        boolean bl2 = ((x0$c)object2).a();
        if (bl2 && (n10 = (int)(x0.o((x0$c)(object2 = this.a.f), object, n10, a10 = d.n.a.o0.a.c) ? 1 : 0)) == 0) {
            PublishRelay publishRelay = this.a.f.a;
            object = object.getServices();
            object2 = new k0((List)object);
            publishRelay.accept(object2);
        }
    }
}

