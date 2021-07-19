/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$1
extends NavType {
    public NavType$1(boolean bl2) {
        super(bl2);
    }

    public Integer get(Bundle bundle, String string2) {
        return (Integer)bundle.get(string2);
    }

    public String getName() {
        return "integer";
    }

    public Integer parseValue(String string2) {
        String string3 = "0x";
        boolean bl2 = string2.startsWith(string3);
        if (bl2) {
            return Integer.parseInt(string2.substring(2), 16);
        }
        return Integer.parseInt(string2);
    }

    public void put(Bundle bundle, String string2, Integer n10) {
        int n11 = n10;
        bundle.putInt(string2, n11);
    }
}

