/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 */
package l.a.q.g0;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import l.a.q.g0.a;
import l.a.q.g0.b;

public class n {
    public static final String a = "_";
    public static final String b = "auto";
    public static final String c = "zh";
    public static final String d = "zh_CN";
    public static final String e = "zh_TW";
    public static final String f = "en";
    public static final String g = "ko";
    public static final String h = "de";
    public static final String i = "fr";
    public static final String j = "ru";
    public static final String k = "es";
    public static final String l = "ja";
    public static final String m = "pt";
    public static final String n = "ar";
    public static final String o = "in";
    public static final String p = "it";
    public static final String q = "nl";
    public static final String r = "th";
    public static final String s = "pt_BR";

    public static String[] a(Resources object) {
        object = object.getConfiguration();
        int n10 = Build.VERSION.SDK_INT;
        b b10 = null;
        int n11 = 24;
        if (n10 >= n11) {
            object = object.getLocales();
            n10 = object.size();
            Object object2 = IntStream.range(0, n10);
            b10 = new b((LocaleList)object);
            object = object2.mapToObj(b10);
            object2 = l.a.q.g0.a.a;
            return (String[])object.toArray((IntFunction<A[]>)object2);
        }
        String[] stringArray = new String[1];
        object = l.a.q.g0.n.c(((Configuration)object).locale);
        stringArray[0] = object;
        return stringArray;
    }

    public static Locale b(Resources resources) {
        resources = resources.getConfiguration();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return resources.getLocales().get(0);
        }
        return resources.locale;
    }

    private static String c(Locale object) {
        String string2 = ((Locale)object).getLanguage();
        object = ((Locale)object).getCountry();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(a);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static boolean d(String string2) {
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 1;
        int n12 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 2691: {
                String string3 = "TW";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n12 = 2;
                break;
            }
            case 2466: {
                String string4 = "MO";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n12 = n11;
                break;
            }
            case 2307: {
                String string5 = "HK";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                return false;
            }
            case 0: 
            case 1: 
            case 2: 
        }
        return n11 != 0;
    }

    public static /* synthetic */ String e(LocaleList localeList, int n10) {
        return l.a.q.g0.n.c(localeList.get(n10));
    }

    public static /* synthetic */ String[] f(int n10) {
        return new String[n10];
    }
}

