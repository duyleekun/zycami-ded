/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattService
 */
package d.n.a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.polidea.rxandroidble2.exceptions.BleCharacteristicNotFoundException;
import d.n.a.k0;
import java.util.UUID;
import java.util.concurrent.Callable;

public class k0$b
implements Callable {
    public final /* synthetic */ UUID a;
    public final /* synthetic */ k0 b;

    public k0$b(k0 k02, UUID uUID) {
        this.b = k02;
        this.a = uUID;
    }

    public BluetoothGattCharacteristic a() {
        Object object;
        boolean bl2;
        Object object2 = this.b.a.iterator();
        while (bl2 = object2.hasNext()) {
            object = (BluetoothGattService)object2.next();
            UUID uUID = this.a;
            if ((object = object.getCharacteristic(uUID)) == null) continue;
            return object;
        }
        object = this.a;
        object2 = new BleCharacteristicNotFoundException((UUID)object);
        throw object2;
    }
}

