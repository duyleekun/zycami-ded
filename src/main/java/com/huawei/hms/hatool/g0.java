/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.y;
import java.util.Map;

public class g0 {
    public static long a(Context context, String string2, String string3, long l10) {
        boolean bl2;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            if ((context = g0.b(context, string2)) != null) {
                l10 = context.getLong(string3, l10);
            }
            return l10;
        }
        y.f("hmsSdk", "context is null or spName empty or spkey is empty");
        return l10;
    }

    public static String a(Context context, String string2, String string3, String string4) {
        boolean bl2;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            if ((context = g0.b(context, string2)) != null) {
                string4 = context.getString(string3, string4);
            }
            return string4;
        }
        y.f("hmsSdk", "context is null or spName empty or spkey is empty");
        return string4;
    }

    public static Map a(Context context, String string2) {
        return g0.b(context, string2).getAll();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static void a(Context object, String string2, String ... stringArray) {
        void var0_2;
        String string3;
        block6: {
            SharedPreferences.Editor editor;
            int n10;
            string3 = "hmsSdk";
            if (object != null && (n10 = TextUtils.isEmpty((CharSequence)editor)) == 0) {
                void var2_6;
                if (var2_6 == null) {
                    String string4 = "clearData(): No data need to be deleted,keys is null";
                    break block6;
                } else {
                    SharedPreferences sharedPreferences = g0.b(object, (String)editor);
                    if (sharedPreferences == null) return;
                    editor = sharedPreferences.edit();
                    int n11 = ((void)var2_6).length;
                    if (n11 == 0) {
                        editor.clear();
                        editor.commit();
                        return;
                    }
                    n11 = ((void)var2_6).length;
                    n10 = 0;
                    while (n10 < n11) {
                        void var6_10 = var2_6[n10];
                        boolean bl2 = sharedPreferences.contains((String)var6_10);
                        if (bl2) {
                            editor.remove((String)var6_10);
                            editor.commit();
                        }
                        ++n10;
                    }
                    return;
                }
            }
            String string5 = "clearData(): parameter error.context,spname";
        }
        y.f(string3, (String)var0_2);
    }

    public static SharedPreferences b(Context context, String string2) {
        string2 = g0.c(context, string2);
        return context.getSharedPreferences(string2, 0);
    }

    public static void b(Context context, String string2, String string3, long l10) {
        boolean bl2;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            if ((context = g0.b(context, string2)) != null) {
                context = context.edit();
                context.putLong(string3, l10);
                context.commit();
            }
            return;
        }
        y.f("hmsSdk", "context is null or spName empty or spkey is empty");
    }

    public static void b(Context context, String string2, String string3, String string4) {
        boolean bl2;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            if ((context = g0.b(context, string2)) != null) {
                context = context.edit();
                context.putString(string3, string4);
                context.commit();
            }
            return;
        }
        y.e("hmsSdk", "context is null or spName empty or spkey is empty");
    }

    public static String c(Context object, String string2) {
        object = object.getPackageName();
        CharSequence charSequence = "oper";
        CharSequence charSequence2 = c.n("_hms_config_tag", (String)charSequence);
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence2);
        String string3 = "hms_";
        String string4 = "_";
        if (bl2) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append(string4);
            ((StringBuilder)charSequence2).append((String)object);
            return ((StringBuilder)charSequence2).toString();
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append((String)charSequence2);
        return ((StringBuilder)charSequence).toString();
    }
}

