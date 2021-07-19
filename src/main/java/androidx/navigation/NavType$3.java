/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$3
extends NavType {
    public NavType$3(boolean bl2) {
        super(bl2);
    }

    public int[] get(Bundle bundle, String string2) {
        return (int[])bundle.get(string2);
    }

    public String getName() {
        return "integer[]";
    }

    public int[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, int[] nArray) {
        bundle.putIntArray(string2, nArray);
    }
}

