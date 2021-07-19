/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.i$1;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.HashMap;
import java.util.Map;

public class i {
    private static volatile boolean a = false;
    private static SharePrefrenceHelper b;

    public static boolean A() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pp_ncsy";
            boolean bl2 = MobSDK.checkPpNecessary();
            boolean bl3 = sharePrefrenceHelper.getBoolean(string2, bl2);
            return bl3;
        }
    }

    public static int B() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pp_grtd";
            int n10 = -1;
            int n11 = sharePrefrenceHelper.getInt(string2, n10);
            return n11;
        }
    }

    public static int C() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pprfms";
            int n10 = -1;
            int n11 = sharePrefrenceHelper.getInt(string2, n10);
            return n11;
        }
    }

    public static int D() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pprdms";
            int n10 = -1;
            int n11 = sharePrefrenceHelper.getInt(string2, n10);
            return n11;
        }
    }

    public static Boolean E() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            Object object;
            block9: {
                int n10;
                block8: {
                    i.J();
                    object = b;
                    String string2 = "key_re_upload_policy_grant_result";
                    int n11 = -1;
                    n10 = ((SharePrefrenceHelper)object).getInt(string2, n11);
                    int n12 = 1;
                    if (n10 != n12) break block8;
                    object = Boolean.TRUE;
                    break block9;
                }
                if (n10 == 0) {
                    object = Boolean.FALSE;
                } else {
                    n10 = 0;
                    object = null;
                }
            }
            return object;
        }
    }

    public static long F() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_request_duid_time";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static long G() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_first_launch_time";
            long l10 = 0L;
            long l11 = sharePrefrenceHelper.getLong(string2, l10);
            return l11;
        }
    }

    public static long H() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_dev_ext_var_upload_time";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static void I() {
        boolean bl2 = a;
        if (bl2) {
            return;
        }
        a = true;
        i$1 i$1 = new i$1();
        i$1.start();
    }

    private static void J() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            Object var1_1 = null;
            i.b(false);
            return;
        }
    }

    public static String a() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_ext_info";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void a(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_policy_txt_related_version";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void a(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "wifi_last_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void a(Boolean comparable) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            int n10;
            block9: {
                block8: {
                    i.J();
                    if (comparable != null) break block8;
                    n10 = -1;
                    break block9;
                }
                n10 = (int)(comparable.booleanValue() ? 1 : 0);
                if (n10 != 0) {
                    n10 = 1;
                    break block9;
                }
                n10 = 0;
                comparable = null;
            }
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_re_upload_policy_grant_result";
            comparable = n10;
            sharePrefrenceHelper.putInt(string2, (Integer)comparable);
            return;
        }
    }

    public static void a(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_ext_info";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static void a(HashMap object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            if (object == null) {
                object = b;
                String string2 = "key_utag_config";
                ((SharePrefrenceHelper)object).remove(string2);
            } else {
                Object object2 = b;
                Object object3 = "key_utag_config";
                Hashon hashon = new Hashon();
                object = hashon.fromHashMap((HashMap)object);
                ((SharePrefrenceHelper)object2).putString((String)object3, (String)object);
                object = b;
                object2 = "key_last_utag_config";
                long l10 = System.currentTimeMillis();
                object3 = l10;
                ((SharePrefrenceHelper)object).putLong((String)object2, (Long)object3);
            }
            return;
        }
    }

    public static void a(HashMap object, int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object2 = b;
            String string2 = "key_utags_buffer_time";
            Hashon hashon = new Hashon();
            object = hashon.fromHashMap((HashMap)object);
            ((SharePrefrenceHelper)object2).putString(string2, (String)object);
            object = b;
            object2 = "key_utags_buffer_time";
            long l10 = System.currentTimeMillis();
            long l11 = n10 *= 1000;
            l10 += l11;
            Long l12 = l10;
            ((SharePrefrenceHelper)object).putLong((String)object2, l12);
            return;
        }
    }

    public static void a(boolean bl2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pp_ncsy";
            Boolean bl3 = bl2;
            sharePrefrenceHelper.putBoolean(string2, bl3);
            return;
        }
    }

    public static String b() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "wifi_last_info";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void b(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_policy_url_related_version";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void b(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_cellinfo_next_total";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void b(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "wifi_last_info";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b(HashMap object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            boolean bl2;
            i.J();
            if (object != null && !(bl2 = ((HashMap)object).isEmpty())) {
                try {
                    Object object2;
                    Object object3;
                    boolean bl3;
                    Object object4 = new HashMap();
                    object = ((HashMap)object).entrySet();
                    object = object.iterator();
                    while (bl3 = object.hasNext()) {
                        object3 = object.next();
                        if ((object3 = (Map.Entry)object3) == null) continue;
                        object2 = object3.getKey();
                        object2 = String.valueOf(object2);
                        object3 = object3.getValue();
                        ((HashMap)object4).put(object2, object3);
                    }
                    object = b;
                    object3 = "key_app_active_time";
                    object2 = new Hashon();
                    object4 = ((Hashon)object2).fromHashMap((HashMap)object4);
                    ((SharePrefrenceHelper)object).putString((String)object3, (String)object4);
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    String string2 = "Parse String error";
                    Object[] objectArray = null;
                    objectArray = new Object[]{};
                    nLog.d(throwable, (Object)string2, objectArray);
                }
            } else {
                object = b;
                String string3 = "key_app_active_time";
                ((SharePrefrenceHelper)object).remove(string3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void b(boolean bl2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            Object object = b;
            if (object == null || bl2) {
                SharePrefrenceHelper sharePrefrenceHelper;
                object = MobSDK.getContext();
                b = sharePrefrenceHelper = new SharePrefrenceHelper((Context)object);
                object = "mob_commons";
                int n10 = 1;
                sharePrefrenceHelper.open((String)object, n10);
            }
            return;
        }
    }

    public static String c() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_cellinfo";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void c(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pp_grtd";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void c(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_art_next_total";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void c(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_cellinfo";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static void c(HashMap object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_channels";
            Hashon hashon = new Hashon();
            object = hashon.fromHashMap((HashMap)object);
            sharePrefrenceHelper.putString(string2, (String)object);
            return;
        }
    }

    public static long d() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_cellinfo_next_total";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static void d(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pprfms";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void d(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_backend_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void d(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_switches";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static long e() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_art_next_total";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static void e(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pprdms";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void e(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_dev_ext_info_upload_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void e(String object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            if (object == null) {
                object = b;
                String string2 = "key_data_url";
                ((SharePrefrenceHelper)object).remove(string2);
            } else {
                SharePrefrenceHelper sharePrefrenceHelper = b;
                String string3 = "key_data_url";
                sharePrefrenceHelper.putString(string3, (String)object);
            }
            return;
        }
    }

    public static String f() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_switches";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void f(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pprsbs";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void f(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_upload_wifi_list_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void f(String object) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            if (object == null) {
                object = b;
                String string2 = "key_conf_url";
                ((SharePrefrenceHelper)object).remove(string2);
            } else {
                SharePrefrenceHelper sharePrefrenceHelper = b;
                String string3 = "key_conf_url";
                sharePrefrenceHelper.putString(string3, (String)object);
            }
            return;
        }
    }

    public static String g() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_data_url";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void g(int n10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_pprspw";
            Integer n11 = n10;
            sharePrefrenceHelper.putInt(string2, n11);
            return;
        }
    }

    public static void g(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_upload_buffered_location_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void g(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_wifi_list_hash";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static String h() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_conf_url";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void h(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_upload_app_active_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void h(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_simulator_info_md5";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static String i() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_wifi_list_hash";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void i(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_request_duid_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void i(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_lduid";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static long j() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_last_utag_config";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static void j(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_first_launch_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void j(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_buffered_location_md5";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static HashMap k() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            Object object;
            Object object2;
            block9: {
                i.J();
                object2 = b;
                object = "key_utag_config";
                object2 = ((SharePrefrenceHelper)object2).getString((String)object);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl2) break block9;
                return null;
            }
            object = new Hashon();
            object2 = ((Hashon)object).fromJson((String)object2);
            return object2;
        }
    }

    public static void k(long l10) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_dev_ext_var_upload_time";
            Long l11 = l10;
            sharePrefrenceHelper.putLong(string2, l11);
            return;
        }
    }

    public static void k(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_privacy_policy_txt";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static HashMap l() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            Object object;
            Object object2;
            block13: {
                block12: {
                    i.J();
                    object2 = b;
                    object = "key_utags_buffer_time";
                    long l10 = ((SharePrefrenceHelper)object2).getLong((String)object);
                    long l11 = System.currentTimeMillis();
                    long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                    object = null;
                    if (l12 <= 0) break block12;
                    return null;
                }
                object2 = b;
                String string2 = "key_utags";
                object2 = ((SharePrefrenceHelper)object2).getString(string2);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl2) break block13;
                return null;
            }
            object = new Hashon();
            object2 = ((Hashon)object).fromJson((String)object2);
            return object2;
        }
    }

    public static void l(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_privacy_policy_url";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static String m() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_simulator_info_md5";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static void m(String string2) {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string3 = "key_privacy_policy_language";
            sharePrefrenceHelper.putString(string3, string2);
            return;
        }
    }

    public static String n() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_lduid";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static long o() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_dev_ext_info_upload_time";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static long p() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_upload_wifi_list_time";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static String q() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_buffered_location_md5";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static long r() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_upload_buffered_location_time";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    public static long s() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_next_upload_app_active_time";
            long l10 = sharePrefrenceHelper.getLong(string2);
            return l10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HashMap t() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            HashMap<Long, Object> hashMap = "key_app_active_time";
            object = ((SharePrefrenceHelper)object).getString((String)((Object)hashMap));
            hashMap = new HashMap<Long, Object>();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                return hashMap;
            }
            Object object2 = new Hashon();
            if ((object = ((Hashon)object2).fromJson((String)object)) != null && !(bl2 = ((HashMap)object).isEmpty())) {
                object = ((HashMap)object).entrySet();
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    object2 = object.next();
                    if ((object2 = (Map.Entry)object2) == null) continue;
                    try {
                        Object k10 = object2.getKey();
                        String string2 = (String)k10;
                        long l10 = Long.parseLong(string2);
                        Long l11 = l10;
                        object2 = object2.getValue();
                        hashMap.put(l11, object2);
                    }
                    catch (Throwable throwable) {
                        NLog nLog = MobLog.getInstance();
                        String string3 = "Parse long error";
                        Object[] objectArray = null;
                        objectArray = new Object[]{};
                        nLog.d(throwable, (Object)string3, objectArray);
                    }
                }
            }
            return hashMap;
        }
    }

    public static HashMap u() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            Object object;
            Object object2;
            block9: {
                i.J();
                object2 = b;
                object = "key_channels";
                object2 = ((SharePrefrenceHelper)object2).getString((String)object);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (!bl2) break block9;
                return null;
            }
            object = new Hashon();
            object2 = ((Hashon)object).fromJson((String)object2);
            return object2;
        }
    }

    public static String v() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_privacy_policy_txt";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static int w() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_policy_txt_related_version";
            int n10 = sharePrefrenceHelper.getInt(string2);
            return n10;
        }
    }

    public static String x() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_privacy_policy_url";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }

    public static int y() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            SharePrefrenceHelper sharePrefrenceHelper = b;
            String string2 = "key_policy_url_related_version";
            int n10 = sharePrefrenceHelper.getInt(string2);
            return n10;
        }
    }

    public static String z() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i.J();
            Object object = b;
            String string2 = "key_privacy_policy_language";
            object = ((SharePrefrenceHelper)object).getString(string2);
            return object;
        }
    }
}

