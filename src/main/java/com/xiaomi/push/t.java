/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;
import com.xiaomi.push.l;
import com.xiaomi.push.s;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class t {
    private static Context a;
    private static String a;

    public static int a() {
        Object object;
        Object object2 = "miui.os.Build";
        try {
            object2 = t.a(null, (String)object2);
            object = "IS_STABLE_VERSION";
        }
        catch (Exception exception) {
            return 0;
        }
        object = ((Class)object2).getField((String)object);
        boolean bl2 = ((Field)object).getBoolean(null);
        if (bl2) {
            return 3;
        }
        object = "IS_DEVELOPMENT_VERSION";
        object2 = ((Class)object2).getField((String)object);
        boolean bl3 = ((Field)object2).getBoolean(null);
        if (bl3) {
            return 2;
        }
        return 1;
    }

    public static Context a() {
        return a;
    }

    public static Class a(Context object, String object2) {
        String string2;
        int n10;
        if (object2 != null && (n10 = (string2 = object2.trim()).length()) != 0) {
            int n11;
            int n12;
            Boolean bl2;
            int n13;
            n10 = 1;
            String string3 = null;
            if (object != null) {
                n13 = n10;
            } else {
                n13 = 0;
                bl2 = null;
            }
            if (n13 != 0 && (n12 = Build.VERSION.SDK_INT) >= (n11 = 29)) {
                try {
                    object = object.getClassLoader();
                }
                catch (ClassNotFoundException classNotFoundException) {}
                return ((ClassLoader)object).loadClass((String)object2);
            }
            try {
                return Class.forName((String)object2);
            }
            catch (ClassNotFoundException classNotFoundException) {
                object2 = new Object[2];
                bl2 = n13 != 0;
                object2[0] = bl2;
                string3 = classNotFoundException.getLocalizedMessage();
                object2[n10] = string3;
                b.a(String.format("loadClass fail hasContext= %s, errMsg = %s", object2));
                object2 = new ClassNotFoundException("loadClass fail ", classNotFoundException);
                throw object2;
            }
        }
        object = new ClassNotFoundException("class is empty");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a() {
        Class<t> clazz = t.class;
        synchronized (clazz) {
            String string2 = a;
            if (string2 != null) {
                return string2;
            }
            string2 = Build.VERSION.INCREMENTAL;
            int n10 = t.a();
            if (n10 <= 0) {
                CharSequence charSequence = t.b();
                boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
                if (!(bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(charSequence = t.c()))) && (bl2 = TextUtils.isEmpty((CharSequence)(charSequence = t.d()))))) {
                    string2 = charSequence;
                } else {
                    charSequence = new StringBuilder();
                    String string3 = "ro.product.brand";
                    String string4 = "Android";
                    string3 = s.a(string3, string4);
                    ((StringBuilder)charSequence).append(string3);
                    string3 = "_";
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    string2 = String.valueOf(string2);
                }
            }
            a = string2;
            return string2;
        }
    }

    public static String a(Context object) {
        boolean bl2 = l.b();
        if (bl2) {
            return "";
        }
        Object[] objectArray = new Object[]{object};
        String string2 = "getMIID";
        object = (String)ba.a("com.xiaomi.xmsf.helper.MIIDAccountHelper", string2, objectArray);
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = "0";
        }
        return object;
    }

    public static void a(Context context) {
        a = context.getApplicationContext();
    }

    public static boolean a() {
        Object[] objectArray = new Object[]{"sys.boot_completed"};
        return TextUtils.equals((CharSequence)((String)ba.a("android.os.SystemProperties", "get", objectArray)), (CharSequence)"1");
    }

    public static boolean a(Context context) {
        boolean bl2 = false;
        try {
            context = context.getApplicationInfo();
        }
        catch (Exception exception) {
            b.a(exception);
            return false;
        }
        int n10 = context.flags & 2;
        if (n10 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    private static String b() {
        String string2;
        a = string2 = s.a("ro.build.version.emui", "");
        return string2;
    }

    public static boolean b() {
        AnnotatedElement annotatedElement = null;
        Object object = "miui.os.Build";
        annotatedElement = t.a(null, (String)object);
        object = "IS_GLOBAL_BUILD";
        annotatedElement = ((Class)annotatedElement).getField((String)object);
        object = Boolean.FALSE;
        try {
            return ((Field)annotatedElement).getBoolean(object);
        }
        catch (Exception exception) {
            b.a(exception);
            return false;
        }
        catch (ClassNotFoundException classNotFoundException) {
            b.d("miui.os.Build ClassNotFound");
            return false;
        }
    }

    private static String c() {
        boolean bl2;
        String string2 = "";
        String string3 = s.a("ro.build.version.opporom", string2);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3 && !(bl2 = string3.startsWith(string2 = "ColorOS_"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            a = string3 = stringBuilder.toString();
        }
        return a;
    }

    private static String d() {
        boolean bl2;
        String string2 = "";
        String string3 = s.a("ro.vivo.os.version", string2);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3 && !(bl2 = string3.startsWith(string2 = "FuntouchOS_"))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            a = string3 = stringBuilder.toString();
        }
        return a;
    }
}

