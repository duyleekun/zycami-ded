/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGattCharacteristic;
import d.n.a.q0.t.b;
import d.n.a.q0.x.h;
import java.util.Locale;

public class d0 {
    private final h a;

    public d0(h h10) {
        this.a = h10;
    }

    public String a(BluetoothGattCharacteristic object, int n10) {
        Object object2;
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[5];
        objectArray[0] = object2 = b.h(object.getUuid());
        object2 = this.a;
        int n11 = object.getProperties();
        objectArray[1] = object2 = ((h)object2).c(n11);
        object = object.getProperties();
        objectArray[2] = object;
        object = this.a.c(n10);
        objectArray[3] = object;
        object = n10;
        objectArray[4] = object;
        return String.format(locale, "Characteristic %s supports properties: %s (%d) does not have any property matching %s (%d)", objectArray);
    }
}

