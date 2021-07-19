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
import com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException;
import d.n.a.q0.s.s;
import d.n.a.q0.s.s0;
import d.n.a.q0.s.s0$a$a;
import d.n.a.q0.s.s0$a$b;
import d.n.a.q0.s.x0;
import d.n.a.q0.x.g;
import d.n.a.q0.x.w;
import e.a.a;
import e.a.e0;
import e.a.f0;
import e.a.v0.o;
import e.a.z;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

public class s0$a
implements Callable {
    public final /* synthetic */ BluetoothGattCharacteristic a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ NotificationSetupMode c;
    public final /* synthetic */ s0 d;

    public s0$a(s0 s02, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean bl2, NotificationSetupMode notificationSetupMode) {
        this.d = s02;
        this.a = bluetoothGattCharacteristic;
        this.b = bl2;
        this.c = notificationSetupMode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e0 a() {
        Map map = this.d.g;
        synchronized (map) {
            Object object = this.a;
            object = object.getUuid();
            Object object2 = this.a;
            int n10 = object2.getInstanceId();
            object2 = n10;
            Object object3 = new g((UUID)object, (Integer)object2);
            object = this.d;
            object = ((s0)object).g;
            object = object.get(object3);
            object = (d.n.a.q0.x.a)object;
            n10 = 1;
            if (object != null) {
                boolean bl2 = ((d.n.a.q0.x.a)object).b;
                boolean bl3 = this.b;
                if (bl2 == bl3) {
                    return ((d.n.a.q0.x.a)object).a;
                }
                object = this.a;
                object = object.getUuid();
                bl3 = this.b;
                if (bl3) {
                    n10 = 0;
                    object2 = null;
                }
                object3 = new BleConflictingNotificationAlreadySetException((UUID)object, n10 != 0);
                return z.m2((Throwable)object3);
            }
            boolean bl4 = this.b;
            if (bl4) {
                object = this.d;
                object = ((s0)object).b;
            } else {
                object = this.d;
                object = ((s0)object).a;
            }
            Object object4 = PublishSubject.n8();
            Object object5 = this.d;
            object5 = ((s0)object5).d;
            Object object6 = this.a;
            object5 = s0.b((BluetoothGatt)object5, object6, n10 != 0);
            object6 = this.d;
            object6 = object6.e;
            object6 = s0.a((x0)object6, object3);
            object6 = w.b(object6);
            object5 = ((a)object5).q((e0)object6);
            object6 = this.d;
            object6 = object6.f;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.a;
            NotificationSetupMode notificationSetupMode = this.c;
            object = s0.c((s)object6, bluetoothGattCharacteristic, (byte[])object, notificationSetupMode);
            object = ((z)object5).z0((f0)object);
            object5 = new s0$a$b(this, (PublishSubject)object4);
            object = ((z)object).H3((o)object5);
            object5 = new s0$a$a(this, (PublishSubject)object4, (g)((Object)object3));
            object = ((z)object).X1((e.a.v0.a)object5);
            object4 = this.d;
            object4 = ((s0)object4).e;
            object4 = ((x0)object4).n();
            object = ((z)object).f4((e0)object4);
            object = ((z)object).M4(n10);
            object = ((e.a.x0.a)object).n8();
            object2 = this.d;
            object2 = ((s0)object2).g;
            boolean bl5 = this.b;
            object4 = new d.n.a.q0.x.a((z)object, bl5);
            object2.put(object3, object4);
            return object;
        }
    }
}

