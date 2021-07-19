/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.preference.PreferenceManager
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import d.v.e.f;
import java.util.Locale;

public class w1 {
    public static final String a = "auto";
    public static final String b = "zh";
    public static final String c = "zh_CN";
    public static final String d = "zh_TW";
    public static final String e = "en";
    public static final String f = "ko";
    public static final String g = "de";
    public static final String h = "fr";
    public static final String i = "ru";
    public static final String j = "es";
    public static final String k = "ja";
    public static final String l = "pt";
    public static final String m = "ar";
    public static final String n = "id";
    public static final String o = "it";
    public static final String p = "nl";
    public static final String q = "th";
    public static final String r = "pt_BR";
    private static final String s = "app_language";

    public static String a() {
        return w1.i(w1.c(d.v.e.f.a().c().getResources())).toLowerCase();
    }

    public static String b(Context context) {
        return w1.d(context).getString(s, a);
    }

    public static Locale c(Resources object) {
        object = object.getConfiguration();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            object = object.getLocales();
            n10 = 0;
            object = object.get(0);
        } else {
            object = object.locale;
        }
        return object;
    }

    private static SharedPreferences d(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context);
    }

    private static boolean e(String string2) {
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

    private static void f(Context context, String string2) {
        w1.d(context).edit().putString(s, string2).apply();
    }

    private static Context g(Context context) {
        String string2 = w1.b(context);
        return w1.h(context, string2);
    }

    private static Context h(Context context, String string2) {
        w1.f(context, string2);
        return w1.j(context, string2);
    }

    private static String i(Locale object) {
        Object object2 = ((Locale)object).getLanguage();
        object = ((Locale)object).getCountry();
        ((String)object2).hashCode();
        int n10 = ((String)object2).hashCode();
        String string2 = e;
        int n11 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 3886: {
                String string3 = b;
                n10 = (int)(((String)object2).equals(string3) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 13;
                break;
            }
            case 3700: {
                String string4 = q;
                n10 = (int)(((String)object2).equals(string4) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 12;
                break;
            }
            case 3651: {
                String string5 = i;
                n10 = (int)(((String)object2).equals(string5) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 11;
                break;
            }
            case 3588: {
                String string6 = l;
                n10 = (int)(((String)object2).equals(string6) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 10;
                break;
            }
            case 3518: {
                String string7 = p;
                n10 = (int)(((String)object2).equals(string7) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 9;
                break;
            }
            case 3428: {
                String string8 = f;
                n10 = (int)(((String)object2).equals(string8) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 8;
                break;
            }
            case 3383: {
                String string9 = k;
                n10 = (int)(((String)object2).equals(string9) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 7;
                break;
            }
            case 3371: {
                String string10 = o;
                n10 = (int)(((String)object2).equals(string10) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 6;
                break;
            }
            case 3355: {
                String string11 = n;
                n10 = (int)(((String)object2).equals(string11) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 5;
                break;
            }
            case 3276: {
                String string12 = h;
                n10 = (int)(((String)object2).equals(string12) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 4;
                break;
            }
            case 3246: {
                String string13 = j;
                n10 = (int)(((String)object2).equals(string13) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 3;
                break;
            }
            case 3241: {
                n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 2;
                break;
            }
            case 3201: {
                String string14 = g;
                n10 = (int)(((String)object2).equals(string14) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 1;
                break;
            }
            case 3121: {
                String string15 = m;
                n10 = (int)(((String)object2).equals(string15) ? 1 : 0);
                if (n10 == 0) break;
                n11 = 0;
            }
        }
        switch (n11) {
            default: {
                object2 = string2;
                break;
            }
            case 13: {
                boolean bl2 = w1.e((String)object);
                object = bl2 ? d : c;
                object2 = object;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
        }
        return object2;
    }

    private static Context j(Context context, String displayMetrics) {
        String string2;
        Object object;
        block23: {
            int n10;
            block20: {
                block22: {
                    block21: {
                        boolean bl2;
                        block19: {
                            object = "_";
                            string2 = a;
                            bl2 = string2.equals(displayMetrics);
                            if (!bl2) break block19;
                            displayMetrics = context.getResources();
                            displayMetrics = w1.c((Resources)displayMetrics);
                            break block20;
                        }
                        bl2 = displayMetrics.contains((CharSequence)object);
                        if (!bl2) break block21;
                        displayMetrics = TextUtils.split((String)displayMetrics, (String)object);
                        bl2 = false;
                        string2 = null;
                        string2 = displayMetrics[0];
                        n10 = 1;
                        displayMetrics = displayMetrics[n10];
                        object = new Locale(string2, (String)displayMetrics);
                        break block22;
                    }
                    object = new Locale((String)displayMetrics);
                }
                displayMetrics = object;
            }
            Locale.setDefault((Locale)displayMetrics);
            object = context.getResources();
            Configuration configuration = object.getConfiguration();
            string2 = new Configuration(configuration);
            n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            if (n10 < n11) break block23;
            string2.setLocale((Locale)displayMetrics);
            context = context.createConfigurationContext((Configuration)string2);
        }
        ((Configuration)string2).locale = displayMetrics;
        displayMetrics = object.getDisplayMetrics();
        try {
            object.updateConfiguration((Configuration)string2, displayMetrics);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        d.v.e.f.d(context);
        return context;
    }
}

