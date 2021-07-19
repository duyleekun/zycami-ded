/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.o;
import com.xiaomi.push.s;
import com.xiaomi.push.t;
import java.util.Locale;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class l {
    private static int a = 0;
    private static Map a;
    private static int b = 255;

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int a() {
        var0 = l.class;
        synchronized (var0) {
            var1_1 = l.a;
            if (var1_1 != 0) return l.a;
            var1_1 = 0;
            var2_2 /* !! */  = null;
            var3_3 = "ro.miui.ui.version.code";
            try {
                var3_3 = l.a(var3_3);
                var4_5 = TextUtils.isEmpty((CharSequence)var3_3);
                var5_6 = 1;
                if (var4_5 == 0) ** GOTO lbl-1000
                var3_3 = "ro.miui.ui.version.name";
                var4_5 = (int)TextUtils.isEmpty((CharSequence)(var3_3 = l.a(var3_3)));
                if (var4_5 != 0) {
                    var4_5 = 0;
                    var3_3 = null;
                } else lbl-1000:
                // 2 sources

                {
                    var4_5 = var5_6;
                }
                if (var4_5 == 0) {
                    var5_6 = 2;
                }
                l.a = var5_6;
            }
            catch (Throwable var3_4) {
                var6_7 = "get isMIUI failed";
                com.xiaomi.channel.commonutils.logger.b.a(var6_7, var3_4);
                l.a = 0;
            }
            var2_2 /* !! */  = new StringBuilder();
            var3_3 = "isMIUI's value is: ";
            var2_2 /* !! */ .append(var3_3);
            var4_5 = l.a;
            var2_2 /* !! */ .append(var4_5);
            var2_2 /* !! */  = var2_2 /* !! */ .toString();
            com.xiaomi.channel.commonutils.logger.b.b((String)var2_2 /* !! */ );
            return l.a;
        }
    }

    public static o a(String object) {
        if ((object = l.b(object)) == null) {
            object = o.b;
        }
        return object;
    }

    public static String a() {
        Class<l> clazz = l.class;
        synchronized (clazz) {
            block5: {
                int n10;
                int n11;
                block6: {
                    n11 = t.a();
                    n10 = l.a();
                    if (n10 == 0 || n11 <= 0) break block5;
                    n10 = 2;
                    if (n11 >= n10) break block6;
                    return "alpha";
                }
                n10 = 3;
                if (n11 < n10) {
                    return "development";
                }
                return "stable";
            }
            return "";
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(String object) {
        String string2 = "android.os.SystemProperties";
        String string3 = "get";
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        String string4 = null;
        objectArray[0] = object;
        int n11 = 1;
        string4 = "";
        objectArray[n11] = string4;
        object = ba.a(string2, string3, objectArray);
        try {
            return (String)object;
        }
        catch (Exception exception) {
            try {
                com.xiaomi.channel.commonutils.logger.b.a(exception);
                return null;
            }
            catch (Throwable throwable) {
                return null;
            }
        }
    }

    private static void a() {
        Map<String, o> map = a;
        if (map != null) {
            return;
        }
        map = new Map<String, o>();
        a = map;
        o o10 = o.a;
        map.put("CN", o10);
        map = a;
        o10 = o.c;
        map.put("FI", o10);
        a.put("SE", o10);
        a.put("NO", o10);
        a.put("FO", o10);
        a.put("EE", o10);
        a.put("LV", o10);
        a.put("LT", o10);
        a.put("BY", o10);
        a.put("MD", o10);
        a.put("UA", o10);
        a.put("PL", o10);
        a.put("CZ", o10);
        a.put("SK", o10);
        a.put("HU", o10);
        a.put("DE", o10);
        a.put("AT", o10);
        a.put("CH", o10);
        a.put("LI", o10);
        a.put("GB", o10);
        a.put("IE", o10);
        a.put("NL", o10);
        a.put("BE", o10);
        a.put("LU", o10);
        a.put("FR", o10);
        a.put("RO", o10);
        a.put("BG", o10);
        a.put("RS", o10);
        a.put("MK", o10);
        a.put("AL", o10);
        a.put("GR", o10);
        a.put("SI", o10);
        a.put("HR", o10);
        a.put("IT", o10);
        a.put("SM", o10);
        a.put("MT", o10);
        a.put("ES", o10);
        a.put("PT", o10);
        a.put("AD", o10);
        a.put("CY", o10);
        a.put("DK", o10);
        map = a;
        o10 = o.d;
        map.put("RU", o10);
        map = a;
        o10 = o.e;
        map.put("IN", o10);
    }

    public static boolean a() {
        Class<l> clazz = l.class;
        synchronized (clazz) {
            boolean bl2;
            block3: {
                boolean bl3 = l.a();
                bl2 = true;
                if (bl3 == bl2) break block3;
                bl2 = false;
            }
            return bl2;
        }
    }

    private static o b(String string2) {
        l.a();
        Map map = a;
        string2 = string2.toUpperCase();
        return (o)((Object)map.get(string2));
    }

    public static String b() {
        String string2;
        boolean bl2;
        CharSequence charSequence = "";
        String string3 = s.a("ro.miui.region", (String)charSequence);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            string3 = s.a("persist.sys.oppo.region", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("ro.oppo.regionmark", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("ro.hw.country", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("ro.csc.countryiso_code", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("ro.product.country.region", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("gsm.vivo.countrycode", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("persist.sys.oem.region", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("ro.product.locale.region", (String)charSequence);
        }
        if (bl3 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = s.a("persist.sys.country", (String)charSequence);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            charSequence = new StringBuilder();
            string2 = "get region from system, region = ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)charSequence);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)string3)) {
            string3 = Locale.getDefault().getCountry();
            charSequence = new StringBuilder();
            string2 = "locale.default.country = ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            com.xiaomi.channel.commonutils.logger.b.a((String)charSequence);
        }
        return string3;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean b() {
        Class<l> clazz = l.class;
        synchronized (clazz) {
            void var1_4;
            block4: {
                int bl2 = l.a();
                int n10 = 2;
                if (bl2 == n10) {
                    boolean bl3 = true;
                    break block4;
                }
                boolean bl4 = false;
                Object var3_6 = null;
            }
            return (boolean)var1_4;
        }
    }

    public static boolean c() {
        int n10 = b;
        int n11 = 1;
        if (n10 < 0) {
            boolean bl2;
            Object object = new Object[]{};
            Object object2 = "miui.external.SdkHelper";
            String string2 = "isMiuiSystem";
            object = ba.a((String)object2, string2, (Object[])object);
            b = 0;
            if (object != null && (bl2 = object instanceof Boolean) && (n10 = (int)(((Boolean)(object = (Boolean)((Class)(object2 = Boolean.class)).cast(object))).booleanValue() ? 1 : 0)) == 0) {
                b = n11;
            }
        }
        if ((n10 = b) <= 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public static boolean d() {
        String string2 = o.a.name();
        String string3 = l.a(l.b()).name();
        return string2.equalsIgnoreCase(string3) ^ true;
    }
}

