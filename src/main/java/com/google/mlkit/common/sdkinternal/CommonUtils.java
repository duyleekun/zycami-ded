/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Locale;

public class CommonUtils {
    private static final GmsLogger zza;

    static {
        GmsLogger gmsLogger;
        zza = gmsLogger = new GmsLogger("CommonUtils", "");
    }

    private CommonUtils() {
    }

    public static String getAppVersion(Context object) {
        Object object2 = object.getPackageManager();
        object = object.getPackageName();
        int n10 = 0;
        String string2 = null;
        object = object2.getPackageInfo((String)object, 0);
        int n11 = object.versionCode;
        try {
            object = String.valueOf(n11);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object2 = zza;
            object = String.valueOf((Object)nameNotFoundException);
            n10 = String.valueOf(object).length() + 48;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Exception thrown when trying to get app version ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            string2 = "CommonUtils";
            ((GmsLogger)object2).e(string2, (String)object);
            object = "";
        }
        return object;
    }

    public static String languageTagFromLocale(Locale object) {
        boolean bl2 = PlatformVersion.isAtLeastLollipop();
        if (bl2) {
            return ((Locale)object).toLanguageTag();
        }
        String string2 = ((Locale)object).getLanguage();
        StringBuilder stringBuilder = new StringBuilder(string2);
        string2 = ((Locale)object).getCountry();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "-";
        if (!bl3) {
            stringBuilder.append(string3);
            string2 = ((Locale)object).getCountry();
            stringBuilder.append(string2);
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)(string2 = ((Locale)object).getVariant())))) {
            stringBuilder.append(string3);
            object = ((Locale)object).getVariant();
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }
}

