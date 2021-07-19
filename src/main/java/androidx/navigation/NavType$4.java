/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$4
extends NavType {
    public NavType$4(boolean bl2) {
        super(bl2);
    }

    public Long get(Bundle bundle, String string2) {
        return (Long)bundle.get(string2);
    }

    public String getName() {
        return "long";
    }

    public Long parseValue(String string2) {
        String string3 = "L";
        boolean bl2 = string2.endsWith(string3);
        if (bl2) {
            bl2 = false;
            string3 = null;
            int n10 = string2.length() + -1;
            string2 = string2.substring(0, n10);
        }
        if (bl2 = string2.startsWith(string3 = "0x")) {
            return Long.parseLong(string2.substring(2), 16);
        }
        return Long.parseLong(string2);
    }

    public void put(Bundle bundle, String string2, Long l10) {
        long l11 = l10;
        bundle.putLong(string2, l11);
    }
}

