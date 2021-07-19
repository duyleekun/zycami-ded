/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.mob.commons.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.b.a;
import com.mob.commons.b.b;
import com.mob.commons.b.c;
import com.mob.commons.b.d$1;
import com.mob.commons.b.d$a;
import com.mob.commons.b.e;
import com.mob.commons.b.f;
import com.mob.commons.b.g;
import com.mob.commons.b.h;
import com.mob.commons.b.i;
import com.mob.commons.b.j;
import com.mob.commons.b.k;
import com.mob.commons.b.l;
import com.mob.commons.b.m;
import com.mob.commons.b.n;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import java.lang.reflect.Method;
import java.util.HashMap;

public class d {
    private static f a;

    public static d$a a(String string2) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            for (d$a d$a : d$a.values()) {
                String string3 = d$a.a(d$a);
                boolean bl4 = string3.equalsIgnoreCase(string2);
                if (!bl4) continue;
                return d$a;
            }
        }
        if (!(bl2 = d.a()) && !(bl2 = d.b())) {
            return d$a.a;
        }
        return d$a.o;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HashMap a(Context context) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            String string2;
            Object object;
            Object object2;
            int n10;
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            b b10 = b.a(context);
            Object object3 = b10.a();
            if (object3 != null && (n10 = ((HashMap)object3).size()) > 0) {
                n10 = 1;
            } else {
                n10 = 0;
                object2 = null;
            }
            int n11 = 73;
            int n12 = 72;
            if (n10 != 0) {
                object = new HashMap();
                int n13 = 71;
                string2 = com.mob.commons.k.a(n13);
                boolean bl2 = ((HashMap)object3).containsKey(string2);
                if (bl2) {
                    string2 = com.mob.commons.k.a(n12);
                    String string3 = com.mob.commons.k.a(n13);
                    Object v10 = ((HashMap)object3).remove(string3);
                    ((HashMap)object3).put(string2, v10);
                }
                if (bl2 = ((HashMap)object3).containsKey(string2 = com.mob.commons.k.a(n13 = 74))) {
                    string2 = com.mob.commons.k.a(n11);
                    String string4 = com.mob.commons.k.a(n13);
                    Object v11 = ((HashMap)object3).remove(string4);
                    ((HashMap)object3).put(string2, v11);
                }
                ((HashMap)object).putAll(object3);
                object3 = "fidsCache";
                hashMap.put(object3, object);
            }
            object3 = d.c(context);
            object = d.e(context);
            String string5 = d.g(context);
            string2 = d.f(context);
            if (n10 == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0)) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0)) != 0) {
                return null;
            }
            boolean bl3 = d.b(context);
            n10 = 75;
            object2 = com.mob.commons.k.a(n10);
            hashMap.put(object2, object);
            n10 = 69;
            object2 = com.mob.commons.k.a(n10);
            hashMap.put(object2, object3);
            n10 = 70;
            object2 = com.mob.commons.k.a(n10);
            hashMap.put(object2, string5);
            object2 = com.mob.commons.k.a(n12);
            hashMap.put(object2, string2);
            object2 = com.mob.commons.k.a(n11);
            Object object4 = bl3;
            hashMap.put(object2, object4);
            object2 = object;
            object4 = string5;
            b10.a((String)object3, (String)object, string5, string2, bl3);
            return hashMap;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a() {
        boolean bl2 = false;
        String string2 = "ro.build.freeme.label";
        try {
            string2 = d.b(string2);
        }
        catch (Throwable throwable) {
            return bl2;
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) return bl2;
        String string3 = "FREEMEOS";
        boolean bl4 = string2.equalsIgnoreCase(string3);
        if (!bl4) return bl2;
        return true;
    }

    public static String b(String object) {
        int n10;
        String string2;
        Object object2 = "android.os.SystemProperties";
        try {
            object2 = Class.forName((String)object2);
            string2 = "get";
            n10 = 1;
        }
        catch (Throwable throwable) {
            return "";
        }
        Class[] classArray = new Class[n10];
        Class<String> clazz = String.class;
        classArray[0] = clazz;
        object2 = ((Class)object2).getDeclaredMethod(string2, classArray);
        ((Method)object2).setAccessible(n10 != 0);
        string2 = null;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = ((Method)object2).invoke(null, objectArray);
        return String.valueOf(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean b() {
        boolean bl2 = false;
        String string2 = "ro.ssui.product";
        try {
            string2 = d.b(string2);
        }
        catch (Throwable throwable) {
            return bl2;
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) return bl2;
        String string3 = "unknown";
        boolean bl4 = string2.equalsIgnoreCase(string3);
        if (bl4) return bl2;
        return true;
    }

    public static boolean b(Context object) {
        d.h((Context)object);
        object = a;
        if (object != null) {
            return ((f)object).h();
        }
        return false;
    }

    public static String c(Context object) {
        d.h((Context)object);
        object = a;
        if (object != null) {
            return ((f)object).e();
        }
        return null;
    }

    public static String d(Context object) {
        boolean bl2;
        d.h((Context)object);
        object = a;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((f)object).e())))) {
            Object object2;
            try {
                object2 = MobSDK.getContext();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().d(throwable);
                return object;
            }
            object2 = DeviceHelper.getInstance(object2);
            object2 = object2.getManufacturer();
            object2 = Data.MD5((String)object2);
            object2 = Data.AES128Encode((String)object2, (String)object);
            int n10 = 2;
            return Base64.encodeToString((byte[])object2, (int)n10);
        }
        return null;
    }

    public static String e(Context object) {
        d.h((Context)object);
        object = a;
        if (object != null) {
            return ((f)object).b();
        }
        return null;
    }

    public static String f(Context object) {
        d.h((Context)object);
        object = a;
        if (object != null) {
            return ((f)object).f();
        }
        return null;
    }

    public static String g(Context object) {
        d.h((Context)object);
        object = a;
        if (object != null) {
            return ((f)object).g();
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void h(Context object) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            d$a d$a;
            Object object2 = a;
            if (object2 != null) {
                return;
            }
            object2 = Build.MANUFACTURER;
            Object object3 = d.a((String)object2);
            if (object3 == (d$a = d$a.a)) {
                object = c.a();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object2);
                object2 = " not support";
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                ((c)object).a(object2);
                return;
            }
            object2 = d$1.a;
            int n10 = object3.ordinal();
            Object object4 = object2[n10];
            switch (object4) {
                default: {
                    break;
                }
                case 14: 
                case 15: 
                case 16: {
                    a = object2 = new n((Context)object);
                    break;
                }
                case 13: {
                    a = object2 = new i((Context)object);
                    break;
                }
                case 11: 
                case 12: {
                    a = object2 = new g((Context)object);
                    break;
                }
                case 10: {
                    a = object2 = new k((Context)object);
                    break;
                }
                case 9: {
                    a = object2 = new a((Context)object);
                    break;
                }
                case 7: 
                case 8: {
                    a = object2 = new h((Context)object);
                    break;
                }
                case 5: 
                case 6: {
                    a = object2 = new j((Context)object);
                    break;
                }
                case 4: {
                    a = object2 = new e((Context)object);
                    break;
                }
                case 3: {
                    a = object2 = new l((Context)object);
                    break;
                }
                case 1: 
                case 2: {
                    a = object2 = new m((Context)object);
                }
            }
            return;
        }
    }
}

