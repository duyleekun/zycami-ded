/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.pm.ServiceInfo
 *  android.content.pm.Signature
 *  android.text.TextUtils
 */
package d.r.a.u;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import d.r.a.p;
import d.r.a.r.f;
import d.r.a.u.c;
import d.r.a.u.c0;
import d.r.a.u.d0;
import d.r.a.u.k;
import d.r.a.u.s;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public final class w {
    public static Boolean a;

    public static f a(Context object) {
        long l10;
        Object object2;
        String string2;
        boolean bl2;
        object = c.c((Context)object).getApplicationContext();
        Object object3 = w.g((Context)object);
        String string3 = "PushPackageUtils";
        if (object3 != null) {
            object = new StringBuilder("get system push info :");
            ((StringBuilder)object).append(object3);
            object = ((StringBuilder)object).toString();
            s.m(string3, (String)object);
            return object3;
        }
        Object object4 = w.i((Context)object);
        Object object5 = object.getPackageName();
        object5 = w.h((Context)object, (String)object5);
        int n10 = object4.size();
        if (n10 <= 0) {
            if (object5 != null && (bl2 = ((f)object5).f)) {
                object3 = object5;
            }
            object4 = "findAllPushPackages error: find no package!";
            s.a(string3, (String)object4);
        } else {
            long l11;
            long l12;
            long l13;
            object3 = c0.c((Context)object);
            string2 = "com.vivo.push.cur_pkg";
            object2 = null;
            n10 = (int)(TextUtils.isEmpty((CharSequence)(object3 = ((c0)object3).a(string2, null))) ? 1 : 0);
            if (n10 != 0 || (n10 = (int)(w.d((Context)object, (String)object3, string2 = "com.vivo.pushservice.action.METHOD") ? 1 : 0)) == 0 || (object3 = w.h((Context)object, (String)object3)) == null || (n10 = (int)(((f)object3).f ? 1 : 0)) == 0) {
                object3 = null;
            }
            if (object5 == null || (n10 = (int)(((f)object5).f ? 1 : 0)) == 0) {
                object5 = null;
            }
            if (object3 == null) {
                object3 = null;
            }
            if (object5 == null || object3 != null && !((n10 = (int)(((f)object5).e ? 1 : 0)) != 0 ? (n10 = (int)(((f)object3).e ? 1 : 0)) != 0 && (n10 = (int)((l13 = (l10 = ((f)object5).b) - (l12 = ((f)object3).b)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) > 0 : (n10 = (int)(((f)object3).e ? 1 : 0)) != 0 || (n10 = (int)((l11 = (l10 = ((f)object5).b) - (l12 = ((f)object3).b)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0)) {
                object5 = object3;
            }
            object3 = new HashMap();
            if (object5 != null) {
                n10 = (int)(((f)object5).e ? 1 : 0);
                if (n10 != 0) {
                    object2 = object5;
                    object5 = null;
                }
            } else {
                object5 = null;
            }
            n10 = object4.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                long l14;
                long l15;
                long l16;
                f f10;
                String string4 = (String)object4.get(i10);
                boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
                if (bl3 || (f10 = w.h((Context)object, string4)) == null) continue;
                ((HashMap)object3).put(string4, f10);
                int n11 = f10.f;
                if (n11 == 0) continue;
                n11 = f10.e;
                if (n11 != 0) {
                    long l17;
                    if (object2 != null && (n11 = (l17 = (l16 = f10.b) - (l15 = ((f)object2).b)) == 0L ? 0 : (l17 < 0L ? -1 : 1)) <= 0) continue;
                    object2 = f10;
                    continue;
                }
                if (object5 != null && (n11 = (l14 = (l16 = f10.b) - (l15 = ((f)object5).b)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) <= 0) continue;
                object5 = f10;
            }
            if (object5 != null) {
                object3 = object5;
            } else {
                s.m(string3, "findSuitablePushPackage, all push app in balck list.");
                object3 = object2;
            }
        }
        if (object3 != null) {
            bl2 = ((f)object3).e;
            object5 = "finSuitablePushPackage";
            string2 = "\u67e5\u627e\u6700\u4f18\u5305\u4e3a:";
            object2 = "(";
            if (bl2) {
                object4 = new StringBuilder(string2);
                string2 = ((f)object3).a;
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append((String)object2);
                l10 = ((f)object3).b;
                ((StringBuilder)object4).append(l10);
                string2 = ", Black)";
                ((StringBuilder)object4).append(string2);
                object4 = ((StringBuilder)object4).toString();
                s.e((Context)object, (String)object4);
                object = new StringBuilder((String)object5);
                object4 = ((f)object3).a;
                ((StringBuilder)object).append((String)object4);
                ((StringBuilder)object).append((String)object2);
                long l18 = ((f)object3).b;
                ((StringBuilder)object).append(l18);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                s.m(string3, (String)object);
            } else {
                object4 = new StringBuilder(string2);
                string2 = ((f)object3).a;
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append((String)object2);
                l10 = ((f)object3).b;
                ((StringBuilder)object4).append(l10);
                string2 = ")";
                ((StringBuilder)object4).append(string2);
                object4 = ((StringBuilder)object4).toString();
                s.e((Context)object, (String)object4);
                object = new StringBuilder((String)object5);
                object4 = ((f)object3).a;
                ((StringBuilder)object).append((String)object4);
                ((StringBuilder)object).append((String)object2);
                long l19 = ((f)object3).b;
                ((StringBuilder)object).append(l19);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                s.m(string3, (String)object);
            }
        } else {
            object4 = "\u67e5\u627e\u6700\u4f18\u5305\u4e3a\u7a7a!";
            s.j((Context)object, (String)object4);
            object = "finSuitablePushPackage is null";
            s.m(string3, (String)object);
        }
        return object3;
    }

    private static boolean b(Context object, long l10) {
        d.r.a.k.c c10 = d.r.a.k.c.a();
        object = c10.b((Context)object);
        if (object != null) {
            return object.a(l10);
        }
        return false;
    }

    public static boolean c(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && object != null) {
            String string3 = "com.vivo.pushservice.action.PUSH_SERVICE";
            Object object2 = new Intent(string3);
            object2.setPackage(string2);
            object = object.getPackageManager();
            int n10 = 576;
            object2 = object.queryIntentServices((Intent)object2, n10);
            if (object2 != null && (n10 = object2.size()) > 0) {
                n10 = object2.size();
                int n11 = 0;
                ServiceInfo serviceInfo = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    ServiceInfo serviceInfo2;
                    ResolveInfo resolveInfo = (ResolveInfo)object2.get(i10);
                    if (resolveInfo == null || (serviceInfo2 = resolveInfo.serviceInfo) == null) continue;
                    String string4 = serviceInfo2.name;
                    int n12 = serviceInfo2.exported;
                    String string5 = "com.vivo.push.sdk.service.PushService";
                    boolean bl3 = string5.equals(string4);
                    if (!bl3 || n12 == 0) continue;
                    serviceInfo = resolveInfo.serviceInfo;
                    n11 = serviceInfo.enabled;
                    resolveInfo = new ComponentName(string2, string5);
                    int n13 = object.getComponentEnabledSetting((ComponentName)resolveInfo);
                    if (n13 != (n12 = 1) && (n13 != 0 || n11 == 0)) {
                        n11 = 0;
                        serviceInfo = null;
                        continue;
                    }
                    n11 = n12;
                }
                return n11 != 0;
            }
            object = "PushPackageUtils";
            string2 = "isEnablePush error: can not find push service.";
            s.a((String)object, string2);
        }
        return false;
    }

    public static boolean d(Context object, String string2, String string3) {
        boolean bl2;
        Intent intent = new Intent(string3);
        intent.setPackage(string2);
        object = object.getPackageManager();
        int n10 = 576;
        try {
            object = object.queryBroadcastReceivers(intent, n10);
        }
        catch (Exception exception) {
            bl2 = false;
            object = null;
        }
        if (object != null && (bl2 = object.size()) > false) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String e(Context object) {
        void var1_12;
        Object object2;
        String string2;
        String string3;
        block24: {
            Object object3;
            String string4;
            block25: {
                block26: {
                    int n10;
                    block27: {
                        String string5;
                        int n11;
                        String string6;
                        int n12;
                        String string7;
                        int n13;
                        Object object4;
                        block23: {
                            string4 = "name";
                            string3 = "close";
                            string2 = "PushPackageUtils";
                            object2 = null;
                            try {
                                object4 = object.getContentResolver();
                                object3 = p.a;
                                n13 = 0;
                                string7 = null;
                                n12 = 0;
                                string6 = null;
                                n11 = 0;
                                string5 = null;
                                object = object4.query(object3, null, null, null, null);
                                if (object != null) break block23;
                                string4 = "cursor is null";
                            }
                            catch (Throwable throwable) {
                                break block24;
                            }
                            catch (Exception exception) {
                                object3 = null;
                                break block25;
                            }
                            try {
                                s.a(string2, string4);
                                if (object == null) return null;
                            }
                            catch (Exception exception) {
                                object3 = null;
                                break block26;
                            }
                            catch (Throwable throwable) {
                                object2 = object;
                                break block24;
                            }
                            try {
                                object.close();
                                return null;
                            }
                            catch (Exception exception) {
                                s.b(string2, string3, exception);
                            }
                            return null;
                        }
                        n10 = 0;
                        object4 = null;
                        object3 = null;
                        try {
                            while ((n13 = object.moveToNext()) != 0) {
                                string7 = "pushPkgName";
                                n12 = object.getColumnIndex(string4);
                                string6 = object.getString(n12);
                                n13 = string7.equals(string6);
                                string6 = "value";
                                if (n13 != 0) {
                                    n13 = object.getColumnIndex(string6);
                                    object3 = object.getString(n13);
                                    continue;
                                }
                                string7 = "pushEnable";
                                n11 = object.getColumnIndex(string4);
                                string5 = object.getString(n11);
                                n13 = (int)(string7.equals(string5) ? 1 : 0);
                                if (n13 == 0) continue;
                                n10 = object.getColumnIndex(string6);
                                object4 = object.getString(n10);
                                n10 = (int)(Boolean.parseBoolean((String)object4) ? 1 : 0);
                            }
                            boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
                            if (!bl2) break block27;
                            if (object == null) return null;
                        }
                        catch (Exception exception) {
                            // empty catch block
                            break block26;
                        }
                        try {
                            object.close();
                            return null;
                        }
                        catch (Exception exception) {
                            s.b(string2, string3, exception);
                        }
                        return null;
                    }
                    if (n10 == 0) {
                        if (object == null) return null;
                        try {
                            object.close();
                            return null;
                        }
                        catch (Exception exception) {
                            s.b(string2, string3, exception);
                        }
                        return null;
                    }
                    if (object == null) return object3;
                    {
                        object.close();
                        return object3;
                    }
                }
                object2 = object;
            }
            object = "getSystemPush";
            {
                s.b(string2, (String)object, (Throwable)((Object)string4));
                if (object2 == null) return object3;
            }
            {
                object2.close();
            }
            return object3;
        }
        if (object2 == null) throw var1_12;
        try {
            object2.close();
            throw var1_12;
        }
        catch (Exception exception) {
            s.b(string2, string3, exception);
        }
        throw var1_12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String f(Context object, String string2) {
        String string3;
        int n10 = TextUtils.isEmpty((CharSequence)string3);
        if (n10 != 0) return null;
        if (object == null) {
            return null;
        }
        try {
            int n11;
            PackageManager packageManager = object.getPackageManager();
            n10 = 64;
            PackageInfo packageInfo = packageManager.getPackageInfo(string3, n10);
            Signature[] signatureArray = packageInfo.signatures;
            int n12 = 0;
            string3 = null;
            Signature signature = signatureArray[0];
            byte[] byArray = signature.toByteArray();
            Object object2 = "SHA256";
            object2 = MessageDigest.getInstance((String)object2);
            byte[] byArray2 = ((MessageDigest)object2).digest(byArray);
            object2 = new StringBuffer();
            while (n12 < (n11 = byArray2.length)) {
                int n13;
                n11 = byArray2[n12] & 0xFF;
                String string4 = Integer.toHexString(n11);
                Object object3 = Locale.US;
                int n14 = (string4 = string4.toUpperCase((Locale)object3)).length();
                if (n14 == (n13 = 1)) {
                    object3 = "0";
                    ((StringBuffer)object2).append((String)object3);
                }
                ((StringBuffer)object2).append(string4);
                ++n12;
            }
            return ((StringBuffer)object2).toString();
        }
        catch (Exception exception) {
            string3 = "PushPackageUtils";
            s.c(string3, exception);
        }
        return null;
    }

    private static f g(Context context) {
        boolean bl2;
        long l10;
        f f10;
        int n10;
        String string2;
        block5: {
            int n11;
            PackageManager packageManager;
            string2 = w.e(context);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            n10 = 0;
            String string3 = null;
            if (bl3) {
                return null;
            }
            f10 = new f(string2);
            try {
                packageManager = context.getPackageManager();
                n11 = 128;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
                s.m("PushPackageUtils", "PackageManager NameNotFoundException is null");
                return null;
            }
            packageManager = packageManager.getPackageInfo(string2, n11);
            if (packageManager != null) {
                f10.c = n10 = packageManager.versionCode;
                f10.d = string3 = packageManager.versionName;
                string3 = packageManager.applicationInfo;
            }
            if (string3 == null) break block5;
            f10.b = l10 = d0.a(context, string2);
        }
        l10 = f10.b;
        n10 = (int)(w.b(context, l10) ? 1 : 0);
        f10.e = n10;
        f10.f = bl2 = w.c(context, string2);
        return f10;
    }

    private static f h(Context context, String string2) {
        block11: {
            boolean bl2;
            boolean bl3;
            long l10;
            Object object;
            block12: {
                Object object2;
                String string3;
                block10: {
                    boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
                    int n10 = 0;
                    string3 = null;
                    if (bl4) break block11;
                    object = "com.vivo.pushservice.action.METHOD";
                    bl4 = w.d(context, string2, (String)object);
                    if (!bl4 && !(bl4 = w.d(context, string2, (String)(object = "com.vivo.pushservice.action.RECEIVE")))) {
                        bl4 = false;
                        object = null;
                    } else {
                        bl4 = true;
                    }
                    if (!bl4) break block11;
                    object = new f(string2);
                    object2 = context.getPackageManager();
                    int n11 = 128;
                    object2 = object2.getPackageInfo(string2, n11);
                    if (object2 == null) break block10;
                    n10 = object2.versionCode;
                    ((f)object).c = n10;
                    string3 = object2.versionName;
                    ((f)object).d = string3;
                    string3 = object2.applicationInfo;
                }
                if (string3 == null) break block12;
                l10 = d0.a(context, string2);
                try {
                    ((f)object).b = l10;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object2 = "PushPackageUtils";
                    String string4 = "getPushPackageInfo exception: ";
                    s.b((String)object2, string4, nameNotFoundException);
                }
            }
            ((f)object).f = bl3 = w.c(context, string2);
            l10 = ((f)object).b;
            ((f)object).e = bl2 = w.b(context, l10);
            return object;
        }
        return null;
    }

    private static List i(Context object) {
        int n10;
        int n11;
        k.a("findAllCoreClientPush");
        ArrayList<ResolveInfo> arrayList = new ArrayList<ResolveInfo>();
        String string2 = "com.vivo.pushservice.action.PUSH_SERVICE";
        Object object2 = new Intent(string2);
        object = object.getPackageManager();
        int n12 = 576;
        try {
            object = object.queryIntentServices(object2, n12);
        }
        catch (Exception exception) {
            n11 = 0;
            object = null;
        }
        if (object != null && (n10 = object.size()) > 0) {
            n10 = object.size();
            string2 = null;
            for (n12 = 0; n12 < n10; ++n12) {
                boolean bl2;
                Object object3 = (ResolveInfo)object.get(n12);
                if (object3 == null || (bl2 = TextUtils.isEmpty((CharSequence)(object3 = object3.serviceInfo.packageName)))) continue;
                arrayList.add((ResolveInfo)object3);
            }
        }
        if ((n11 = arrayList.size()) <= 0) {
            object = "PushPackageUtils";
            object2 = "get all push packages is null";
            s.m((String)object, (String)object2);
        }
        return arrayList;
    }
}

