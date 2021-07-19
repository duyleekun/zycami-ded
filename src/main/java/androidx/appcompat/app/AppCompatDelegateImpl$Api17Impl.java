/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;

public class AppCompatDelegateImpl$Api17Impl {
    private AppCompatDelegateImpl$Api17Impl() {
    }

    public static Context createConfigurationContext(Context context, Configuration configuration) {
        return context.createConfigurationContext(configuration);
    }

    public static void generateConfigDelta_densityDpi(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int n10 = configuration.densityDpi;
        int n11 = configuration2.densityDpi;
        if (n10 != n11) {
            configuration3.densityDpi = n11;
        }
    }
}

