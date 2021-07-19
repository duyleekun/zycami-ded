/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package d.n.a.q0.x;

import android.util.Pair;
import java.util.UUID;

public class g
extends Pair {
    public g(UUID uUID, Integer n10) {
        super((Object)uUID, (Object)n10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CharacteristicNotificationId{UUID=");
        String string2 = ((UUID)this.first).toString();
        stringBuilder.append(string2);
        stringBuilder.append(", instanceId=");
        string2 = ((Integer)this.second).toString();
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

