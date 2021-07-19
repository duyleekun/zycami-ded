/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.NotificationSetupMode;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0;
import d.n.a.q0.s.s0$a;
import d.n.a.q0.x.g;
import e.a.a;
import e.a.h;
import io.reactivex.internal.functions.Functions;
import io.reactivex.subjects.PublishSubject;

public class s0$a$a
implements e.a.v0.a {
    public final /* synthetic */ PublishSubject a;
    public final /* synthetic */ g b;
    public final /* synthetic */ s0$a c;

    public s0$a$a(s0$a s0$a, PublishSubject publishSubject, g g10) {
        this.c = s0$a;
        this.a = publishSubject;
        this.b = g10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        this.a.onComplete();
        Object object3 = this.c.d.g;
        synchronized (object3) {
            object2 = this.c;
            object2 = ((s0$a)object2).d;
            object2 = ((s0)object2).g;
            object = this.b;
            object2.remove(object);
        }
        object3 = this.c;
        object2 = object3.d.d;
        object3 = ((s0$a)object3).a;
        object3 = s0.b((BluetoothGatt)object2, (BluetoothGattCharacteristic)object3, false);
        object2 = this.c;
        object = ((s0$a)object2).d;
        s s10 = ((s0)object).f;
        BluetoothGattCharacteristic bluetoothGattCharacteristic = ((s0$a)object2).a;
        object = ((s0)object).c;
        object2 = ((s0$a)object2).c;
        object2 = s0.e(s10, bluetoothGattCharacteristic, (byte[])object, (NotificationSetupMode)((Object)object2));
        object3 = ((a)object3).z((h)object2);
        object2 = Functions.c;
        object = Functions.h();
        ((a)object3).h((e.a.v0.a)object2, (e.a.v0.g)object);
    }
}

