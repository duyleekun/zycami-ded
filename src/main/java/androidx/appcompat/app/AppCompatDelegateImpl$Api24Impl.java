/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.LocaleList
 */
package androidx.appcompat.app;

import android.content.res.Configuration;
import android.os.LocaleList;

public class AppCompatDelegateImpl$Api24Impl {
    private AppCompatDelegateImpl$Api24Impl() {
    }

    public static void generateConfigDelta_locale(Configuration object, Configuration configuration, Configuration configuration2) {
        LocaleList localeList;
        boolean bl2 = (object = object.getLocales()).equals((Object)(localeList = configuration.getLocales()));
        if (!bl2) {
            configuration2.setLocales(localeList);
            object = configuration.locale;
            configuration2.locale = object;
        }
    }
}

