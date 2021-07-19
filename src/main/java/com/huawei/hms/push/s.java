/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.support.log.HMSLog;
import d.j.a.f.a;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

public abstract class s {
    public static final Object a;
    public static int b = 255;

    static {
        Object object;
        a = object = new Object();
    }

    public static boolean a() {
        block28: {
            String string2 = "CommFun";
            Object object = "huawei.cust.HwCfgFilePolicy";
            object = Class.forName((String)object);
            Object object2 = "CUST_TYPE_CONFIG";
            object2 = ((Class)object).getDeclaredField((String)object2);
            object2 = ((Field)object2).get(object);
            object2 = (Integer)object2;
            int n10 = (Integer)object2;
            Object object3 = "getCfgFile";
            int n11 = 2;
            Object object4 = new Class[n11];
            Class clazz = String.class;
            object4[0] = clazz;
            clazz = Integer.TYPE;
            boolean bl2 = true;
            object4[bl2] = clazz;
            object3 = ((Class)object).getDeclaredMethod((String)object3, (Class<?>)object4);
            Object[] objectArray = new Object[n11];
            object4 = "jars/hwpush.jar";
            objectArray[0] = object4;
            object2 = n10;
            objectArray[bl2] = object2;
            object = ((Method)object3).invoke(object, objectArray);
            object = (File)object;
            if (object == null) break block28;
            n10 = (int)(((File)object).exists() ? 1 : 0);
            if (n10 == 0) break block28;
            object2 = new StringBuilder();
            object3 = "get push cust File path is ";
            ((StringBuilder)object2).append((String)object3);
            object = ((File)object).getCanonicalPath();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            try {
                HMSLog.d(string2, (String)object);
                return bl2;
            }
            catch (IOException iOException) {
                object = "check jarFile exist but get not path";
                HMSLog.e(string2, (String)object);
            }
            catch (InvocationTargetException invocationTargetException) {
                object = "check cust exist push InvocationTargetException.";
                HMSLog.e(string2, (String)object);
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "check cust exist push IllegalAccessException.";
                HMSLog.e(string2, (String)object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = "check cust exist push IllegalArgumentException.";
                HMSLog.e(string2, (String)object);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = "check cust exist push NoSuchMethodException.";
                HMSLog.e(string2, (String)object);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                object = "check cust exist push NoSuchFieldException.";
                HMSLog.e(string2, (String)object);
            }
            catch (SecurityException securityException) {
                object = "check cust exist push SecurityException.";
                HMSLog.e(string2, (String)object);
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = "HwCfgFilePolicy ClassNotFoundException";
                HMSLog.e(string2, (String)object);
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(Context object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("existFrameworkPush:");
        int n10 = b;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "CommFun";
        HMSLog.d(string2, (String)object);
        object = "/system/framework/";
        CharSequence charSequence = "hwpush.jar";
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append((String)charSequence);
            object = stringBuilder.toString();
            File file = new File((String)object);
            boolean bl2 = s.a();
            charSequence = "push jarFile is exist";
            if (bl2) {
                HMSLog.d(string2, (String)charSequence);
                return true;
            }
            bl2 = file.isFile();
            if (!bl2) return false;
            HMSLog.d(string2, (String)charSequence);
            return true;
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("get Apk version faild ,Exception e= ");
            String string3 = exception.toString();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            HMSLog.e(string2, string3);
            return false;
        }
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String string2) {
        boolean bl2;
        if (!(jSONObject == null || (bl2 = TextUtils.isEmpty((CharSequence)string2)) && jSONObject2 == null)) {
            bl2 = false;
            jSONObject = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static long b(Context object) {
        long l10;
        int n10;
        object = object.getPackageManager();
        String string2 = "com.huawei.android.pushagent";
        object = object.getPackageInfo(string2, 0);
        try {
            n10 = object.versionCode;
        }
        catch (Exception exception) {
            object = "CommFun";
            string2 = "get nc versionCode error";
            HMSLog.e((String)object, string2);
            l10 = -1;
        }
        l10 = n10;
        return l10;
    }

    public static boolean b() {
        int n10 = HwBuildEx$VERSION.EMUI_SDK_INT;
        int n11 = 21;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public static String c(Context context) {
        return d.j.a.f.a.a(context).g("client/project_id");
    }

    public static boolean c() {
        int n10 = HwBuildEx$VERSION.EMUI_SDK_INT;
        int n11 = 19;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean d(Context context) {
        int n10;
        int n11;
        int n12;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("existFrameworkPush:");
        int n13 = b;
        ((StringBuilder)object).append(n13);
        object = ((StringBuilder)object).toString();
        String string2 = "CommFun";
        HMSLog.d(string2, (String)object);
        object = a;
        synchronized (object) {
            n13 = b;
            n12 = 0;
            n11 = 1;
            int n14 = -1;
            if (n14 != n13) {
                if (n11 != n13) return n12 != 0;
                return n11 != 0;
            }
            n10 = s.a(context);
            b = n10 != 0 ? n11 : 0;
        }
        n10 = b;
        if (n11 != n10) return n12 != 0;
        return n11 != 0;
    }
}

