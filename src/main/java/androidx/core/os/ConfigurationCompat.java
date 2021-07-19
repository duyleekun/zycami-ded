/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 */
package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class ConfigurationCompat {
    private ConfigurationCompat() {
    }

    public static LocaleListCompat getLocales(Configuration object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return LocaleListCompat.wrap(object.getLocales());
        }
        Locale[] localeArray = new Locale[1];
        object = object.locale;
        localeArray[0] = object;
        return LocaleListCompat.create(localeArray);
    }
}

