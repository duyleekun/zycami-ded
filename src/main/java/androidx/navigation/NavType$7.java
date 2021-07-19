/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$7
extends NavType {
    public NavType$7(boolean bl2) {
        super(bl2);
    }

    public float[] get(Bundle bundle, String string2) {
        return (float[])bundle.get(string2);
    }

    public String getName() {
        return "float[]";
    }

    public float[] parseValue(String object) {
        object = new UnsupportedOperationException("Arrays don't support default values.");
        throw object;
    }

    public void put(Bundle bundle, String string2, float[] fArray) {
        bundle.putFloatArray(string2, fArray);
    }
}

