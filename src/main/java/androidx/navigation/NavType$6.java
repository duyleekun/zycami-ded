/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavType;

public class NavType$6
extends NavType {
    public NavType$6(boolean bl2) {
        super(bl2);
    }

    public Float get(Bundle bundle, String string2) {
        return (Float)bundle.get(string2);
    }

    public String getName() {
        return "float";
    }

    public Float parseValue(String string2) {
        return Float.valueOf(Float.parseFloat(string2));
    }

    public void put(Bundle bundle, String string2, Float f10) {
        float f11 = f10.floatValue();
        bundle.putFloat(string2, f11);
    }
}

