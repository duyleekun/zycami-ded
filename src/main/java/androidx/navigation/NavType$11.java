/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$11
extends NavType {
    public NavType$11(boolean bl2) {
        super(bl2);
    }

    public String[] get(Bundle bundle, String string2) {
        return (String[])bundle.get(string2);
    }

    public String getName() {
        return "string[]";
    }

    public String[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, String[] stringArray) {
        bundle.putStringArray(string2, stringArray);
    }
}

