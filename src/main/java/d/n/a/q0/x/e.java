/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.x;

import android.bluetooth.BluetoothGattDescriptor;
import d.n.a.q0.x.e$a;
import d.n.a.q0.x.e$b;
import d.n.a.q0.x.e$c;
import e.a.v0.o;
import e.a.v0.r;
import java.util.UUID;

public class e {
    private e() {
    }

    public static r a(UUID uUID) {
        e$a e$a = new e$a(uUID);
        return e$a;
    }

    public static r b(BluetoothGattDescriptor bluetoothGattDescriptor) {
        e$c e$c = new e$c(bluetoothGattDescriptor);
        return e$c;
    }

    public static o c() {
        e$b e$b = new e$b();
        return e$b;
    }
}

