/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import d.n.a.q0.x.g;
import java.util.Arrays;
import java.util.UUID;

public class f
extends g {
    public final byte[] a;

    public f(UUID uUID, Integer n10, byte[] byArray) {
        super(uUID, n10);
        this.a = byArray;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof f;
        if (!bl3) {
            boolean bl4;
            bl3 = object instanceof g;
            if (!bl3 || !(bl4 = super.equals(object))) {
                bl2 = false;
                Object var5_5 = null;
            }
            return bl2;
        }
        bl2 = super.equals(object);
        if (!bl2) {
            return false;
        }
        object = (f)((Object)object);
        byte[] byArray = this.a;
        object = ((f)object).a;
        return Arrays.equals(byArray, (byte[])object);
    }

    public int hashCode() {
        int n10 = super.hashCode() * 31;
        int n11 = Arrays.hashCode(this.a);
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicChangedEvent{UUID=");
        String string2 = ((UUID)this.first).toString();
        stringBuilder.append(string2);
        stringBuilder.append(", instanceId=");
        string2 = ((Integer)this.second).toString();
        stringBuilder.append(string2);
        stringBuilder.append(", data=");
        string2 = Arrays.toString(this.a);
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

