/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$8
extends NavType {
    public NavType$8(boolean bl2) {
        super(bl2);
    }

    public Boolean get(Bundle bundle, String string2) {
        return (Boolean)bundle.get(string2);
    }

    public String getName() {
        return "boolean";
    }

    public Boolean parseValue(String object) {
        String string2 = "true";
        boolean bl2 = string2.equals(object);
        if (bl2) {
            return Boolean.TRUE;
        }
        string2 = "false";
        boolean bl3 = string2.equals(object);
        if (bl3) {
            return Boolean.FALSE;
        }
        object = new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, Boolean bl2) {
        boolean bl3 = bl2;
        bundle.putBoolean(string2, bl3);
    }
}

