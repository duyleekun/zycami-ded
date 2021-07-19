/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$9
extends NavType {
    public NavType$9(boolean bl2) {
        super(bl2);
    }

    public boolean[] get(Bundle bundle, String string2) {
        return (boolean[])bundle.get(string2);
    }

    public String getName() {
        return "boolean[]";
    }

    public boolean[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, boolean[] blArray) {
        bundle.putBooleanArray(string2, blArray);
    }
}

