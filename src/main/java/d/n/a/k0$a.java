/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattService
 */
package d.n.a;

import android.bluetooth.BluetoothGattService;
import d.n.a.k0;
import e.a.v0.r;
import java.util.UUID;

public class k0$a
implements r {
    public final /* synthetic */ UUID a;
    public final /* synthetic */ k0 b;

    public k0$a(k0 k02, UUID uUID) {
        this.b = k02;
        this.a = uUID;
    }

    public boolean a(BluetoothGattService object) {
        object = object.getUuid();
        UUID uUID = this.a;
        return ((UUID)object).equals(uUID);
    }
}

