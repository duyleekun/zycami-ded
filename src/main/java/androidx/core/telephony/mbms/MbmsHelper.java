/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.telephony.mbms.ServiceInfo
 */
package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;

public final class MbmsHelper {
    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context object, ServiceInfo serviceInfo) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        CharSequence charSequence = null;
        int n11 = 28;
        if (n10 < n11) {
            return null;
        }
        object = object.getResources().getConfiguration().getLocales();
        String[] stringArray = serviceInfo.getNamedContentLocales();
        n10 = stringArray.size();
        if (n10 == 0) {
            return null;
        }
        stringArray = new String[n10];
        n11 = 0;
        Iterator iterator2 = serviceInfo.getNamedContentLocales().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2;
            stringArray[n11] = string2 = ((Locale)iterator2.next()).toLanguageTag();
            ++n11;
        }
        if ((object = object.getFirstMatch(stringArray)) != null) {
            charSequence = serviceInfo.getNameForLocale((Locale)object);
        }
        return charSequence;
    }
}

