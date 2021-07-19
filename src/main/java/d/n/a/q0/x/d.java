/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.x;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import java.util.Arrays;
import java.util.UUID;

public class d {
    public final Object a;
    public final byte[] b;

    public d(Object object, byte[] byArray) {
        this.a = object;
        this.b = byArray;
    }

    public static d a(Object object, byte[] byArray) {
        d d10 = new d(object, byArray);
        return d10;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof d;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (d)object;
        Object object2 = ((d)object).b;
        byte[] byArray = this.b;
        bl3 = Arrays.equals(object2, byArray);
        if (bl3 && (bl2 = (object = ((d)object).a).equals(object2 = (Object)this.a))) {
            bl4 = true;
        }
        return bl4;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = Arrays.hashCode(this.b);
        return n10 ^ n11;
    }

    public String toString() {
        CharSequence charSequence;
        Object object = this.a;
        boolean bl2 = object instanceof BluetoothGattCharacteristic;
        String string2 = ")";
        String string3 = "(";
        if (bl2) {
            object = new StringBuilder();
            charSequence = BluetoothGattCharacteristic.class.getSimpleName();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(string3);
            charSequence = ((BluetoothGattCharacteristic)this.a).getUuid().toString();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        } else {
            bl2 = object instanceof BluetoothGattDescriptor;
            if (bl2) {
                object = new StringBuilder();
                charSequence = BluetoothGattDescriptor.class.getSimpleName();
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(string3);
                charSequence = ((BluetoothGattDescriptor)this.a).getUuid().toString();
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
            } else {
                bl2 = object instanceof UUID;
                if (bl2) {
                    object = new StringBuilder();
                    charSequence = UUID.class.getSimpleName();
                    ((StringBuilder)object).append((String)charSequence);
                    ((StringBuilder)object).append(string3);
                    charSequence = this.a.toString();
                    ((StringBuilder)object).append((String)charSequence);
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = object.getClass().getSimpleName();
                }
            }
        }
        charSequence = new StringBuilder();
        string2 = this.getClass().getSimpleName();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("[first=");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(", second=");
        object = Arrays.toString(this.b);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("]");
        return ((StringBuilder)charSequence).toString();
    }
}

