/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$5
extends NavType {
    public NavType$5(boolean bl2) {
        super(bl2);
    }

    public long[] get(Bundle bundle, String string2) {
        return (long[])bundle.get(string2);
    }

    public String getName() {
        return "long[]";
    }

    public long[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, long[] lArray) {
        bundle.putLongArray(string2, lArray);
    }
}

