/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$10
extends NavType {
    public NavType$10(boolean bl2) {
        super(bl2);
    }

    public String get(Bundle bundle, String string2) {
        return (String)bundle.get(string2);
    }

    public String getName() {
        return "string";
    }

    public String parseValue(String string2) {
        return string2;
    }

    public void put(Bundle bundle, String string2, String string3) {
        bundle.putString(string2, string3);
    }
}

