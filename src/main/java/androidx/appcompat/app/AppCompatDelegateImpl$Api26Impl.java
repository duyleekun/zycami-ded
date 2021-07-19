/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 */
package androidx.appcompat.app;

import android.content.res.Configuration;

public class AppCompatDelegateImpl$Api26Impl {
    private AppCompatDelegateImpl$Api26Impl() {
    }

    public static void generateConfigDelta_colorMode(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int n10;
        int n11;
        int n12 = configuration.colorMode & 3;
        int n13 = configuration2.colorMode;
        int n14 = n13 & 3;
        if (n12 != n14) {
            n12 = configuration3.colorMode;
            configuration3.colorMode = n12 |= (n13 &= 3);
        }
        if ((n11 = configuration.colorMode & 0xC) != (n12 = (n10 = configuration2.colorMode) & 0xC)) {
            n11 = configuration3.colorMode;
            configuration3.colorMode = n11 |= (n10 &= 0xC);
        }
    }
}

