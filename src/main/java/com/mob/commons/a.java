/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 *  android.util.Log
 */
package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.PrivacyPolicy;
import com.mob.commons.MobProductCollector;
import com.mob.commons.a$1;
import com.mob.commons.a$2;
import com.mob.commons.a$3;
import com.mob.commons.a$4;
import com.mob.commons.a$5;
import com.mob.commons.a$6;
import com.mob.commons.a.b;
import com.mob.commons.a.c;
import com.mob.commons.a.d;
import com.mob.commons.a.e;
import com.mob.commons.a.f;
import com.mob.commons.a.g;
import com.mob.commons.a.h;
import com.mob.commons.a.i;
import com.mob.commons.a.j;
import com.mob.commons.a.k;
import com.mob.commons.a.l;
import com.mob.commons.a.n;
import com.mob.commons.a.o;
import com.mob.commons.a.p;
import com.mob.commons.a.q;
import com.mob.commons.a.r;
import com.mob.commons.a.s;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b$a;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public final class a {
    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static Boolean g;
    private static Boolean h;
    private static int i;
    private static Boolean j;
    private static Boolean k;
    private static int l;
    private static int m;
    private static int n;
    private static Boolean o;
    private static Boolean p;
    private static Boolean q;
    private static Boolean r;
    private static byte[] s;
    private static byte[] t;
    private static volatile int u;

    static {
        int n10;
        String string2;
        CharSequence charSequence = com.mob.commons.j.a();
        a = charSequence;
        b = string2 = com.mob.commons.j.b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("/privacy/policy/ms/version");
        c = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("/privacy/policy/rejection/strategy");
        d = stringBuilder.toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("/privacy/policy/authorization/status");
        e = ((StringBuilder)charSequence).toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("/privacy/policy/permission/window/status");
        f = ((StringBuilder)charSequence).toString();
        l = n10 = -1;
        m = n10;
        s = new byte[0];
        t = new byte[0];
        u = n10;
    }

    public static /* synthetic */ Boolean a(Boolean bl2) {
        h = bl2;
        return bl2;
    }

    public static /* synthetic */ String a(long l10, String string2) {
        return com.mob.commons.a.b(l10, string2);
    }

    public static final void a() {
        Runnable runnable = new a$1();
        Thread thread = new Thread(runnable);
        thread.start();
        runnable = new a$2();
        thread = new Thread(runnable);
        thread.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(int n10) {
        Object object = MobLog.getInstance();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Notify initLock. initialized: ");
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        Object[] objectArray = null;
        Object object3 = new Object[]{};
        ((NLog)object).d(object2, object3);
        object = t;
        synchronized (object) {
            try {
                u = n10;
                byte[] byArray = t;
                byArray.notifyAll();
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                object3 = "Init lock error";
                objectArray = new Object[]{};
                ((NLog)object2).d(throwable, object3, objectArray);
            }
            return;
        }
    }

    public static /* synthetic */ void a(int n10, boolean bl2) {
        com.mob.commons.a.b(n10, bl2);
    }

    public static void a(boolean bl2, OperationCallback objectArray) {
        Object[] objectArray2;
        com.mob.commons.a.c(bl2, (OperationCallback)objectArray2);
        objectArray2 = MobLog.getInstance();
        String string2 = null;
        Object object = new Object[]{};
        objectArray2.d("submitPpResult().", (Object[])object);
        objectArray2 = MobLog.getInstance();
        object = new StringBuilder();
        ((StringBuilder)object).append("grtd: ");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        Object[] objectArray3 = new Object[]{};
        objectArray2.d(object, objectArray3);
        if (!bl2) {
            Boolean bl3;
            k = bl3 = Boolean.FALSE;
            com.mob.commons.i.c(0);
        } else {
            boolean bl4 = com.mob.commons.a.d();
            objectArray2 = MobLog.getInstance();
            object = new StringBuilder();
            ((StringBuilder)object).append("bfdIsAgrPp: ");
            ((StringBuilder)object).append(bl4);
            object = ((StringBuilder)object).toString();
            objectArray3 = new Object[]{};
            objectArray2.d(object, objectArray3);
            if (!bl4) {
                int n10;
                k = Boolean.TRUE;
                com.mob.commons.i.c(1);
                Object object2 = MobLog.getInstance();
                objectArray2 = new Object[]{};
                string2 = "====> Entr 5";
                ((NLog)object2).d(string2, objectArray2);
                g = com.mob.commons.a.d();
                h = null;
                i = n10 = com.mob.commons.a.x();
                object2 = new a$4();
                com.mob.commons.b.a((b$a)object2);
            }
        }
    }

    public static /* synthetic */ int b(int n10) {
        i = n10;
        return n10;
    }

    public static /* synthetic */ Boolean b(Boolean bl2) {
        g = bl2;
        return bl2;
    }

    private static String b(long l10, String string2) {
        block18: {
            String string3 = ":";
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) break block18;
            String string4 = MobSDK.getAppkey();
            Object object = MobSDK.getContext();
            object = DeviceHelper.getInstance((Context)object);
            object = ((DeviceHelper)object).getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            stringBuilder.append(l10);
            Object object2 = stringBuilder.toString();
            object2 = Data.rawMD5((String)object2);
            Object object3 = null;
            object3 = Base64.decode((String)string2, (int)0);
            object2 = Data.AES128Decode((byte[])object2, (byte[])object3);
            string2 = "UTF-8";
            try {
                object3 = new String((byte[])object2, string2);
                return object3;
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                ((NLog)object3).d(throwable);
            }
        }
        return null;
    }

    private static void b(int n10, boolean bl2) {
        Throwable throwable2;
        block76: {
            block74: {
                Object object;
                Object object2;
                Object object3;
                Object object4;
                int n11;
                block75: {
                    block72: {
                        block73: {
                            int n12;
                            CharSequence charSequence;
                            block71: {
                                ++n10;
                                n11 = 2;
                                object4 = MobSDK.getContext();
                                object4 = DeviceHelper.getInstance((Context)object4);
                                object3 = new ArrayList();
                                object2 = "appkey";
                                charSequence = MobSDK.getAppkey();
                                object = new KVPair((String)object2, charSequence);
                                ((ArrayList)object3).add(object);
                                object2 = "apppkg";
                                charSequence = ((DeviceHelper)object4).getPackageName();
                                object = new KVPair((String)object2, charSequence);
                                ((ArrayList)object3).add(object);
                                object2 = "appver";
                                charSequence = ((DeviceHelper)object4).getAppVersionName();
                                object = new KVPair((String)object2, charSequence);
                                ((ArrayList)object3).add(object);
                                object2 = "plat";
                                int n13 = ((DeviceHelper)object4).getPlatformCode();
                                charSequence = String.valueOf(n13);
                                object = new KVPair((String)object2, charSequence);
                                ((ArrayList)object3).add(object);
                                object2 = "networktype";
                                object4 = ((DeviceHelper)object4).getDetailNetworkTypeForStatic();
                                object = new KVPair((String)object2, object4);
                                ((ArrayList)object3).add(object);
                                object4 = DeviceAuthorizer.authorizeForOnce();
                                n12 = TextUtils.isEmpty((CharSequence)object4);
                                if (n12 != 0) break block71;
                                object2 = "duid";
                                object = new KVPair((String)object2, object4);
                                ((ArrayList)object3).add(object);
                            }
                            object = "isAgreePp";
                            object2 = String.valueOf(bl2);
                            object4 = new KVPair((String)object, object2);
                            ((ArrayList)object3).add(object4);
                            object4 = new NetworkHelper$NetworkTimeOut();
                            n12 = 10000;
                            ((NetworkHelper$NetworkTimeOut)object4).readTimout = n12;
                            n12 = 5000;
                            ((NetworkHelper$NetworkTimeOut)object4).connectionTimeout = n12;
                            object = new ArrayList();
                            charSequence = "User-Identity";
                            String string2 = MobProductCollector.getUserIdentity();
                            object2 = new KVPair((String)charSequence, string2);
                            ((ArrayList)object).add(object2);
                            object2 = MobLog.getInstance();
                            charSequence = new StringBuilder();
                            string2 = "Request: ";
                            ((StringBuilder)charSequence).append(string2);
                            string2 = e;
                            ((StringBuilder)charSequence).append(string2);
                            String string3 = "\nHeaders: ";
                            ((StringBuilder)charSequence).append(string3);
                            ((StringBuilder)charSequence).append(object);
                            string3 = "\nValues: ";
                            ((StringBuilder)charSequence).append(string3);
                            ((StringBuilder)charSequence).append(object3);
                            charSequence = ((StringBuilder)charSequence).toString();
                            string3 = null;
                            Object[] objectArray = new Object[]{};
                            object2.d(charSequence, objectArray);
                            object2 = new NetworkHelper();
                            object4 = object2.httpGet(string2, (ArrayList)object3, (ArrayList)object, (NetworkHelper$NetworkTimeOut)object4);
                            object3 = MobLog.getInstance();
                            object = new StringBuilder();
                            object2 = "Response: ";
                            ((StringBuilder)object).append((String)object2);
                            ((StringBuilder)object).append((String)object4);
                            object = ((StringBuilder)object).toString();
                            object2 = new Object[]{};
                            ((NLog)object3).d(object, object2);
                            object3 = new Hashon();
                            object3 = ((Hashon)object3).fromJson((String)object4);
                            if (object3 != null) break block72;
                            if (n10 >= n11) break block73;
                            com.mob.commons.a.b(n10, bl2);
                            break block72;
                        }
                        object = new StringBuilder();
                        object2 = "Response is illegal: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append((String)object4);
                        object4 = ((StringBuilder)object).toString();
                        object3 = new Throwable((String)object4);
                        throw object3;
                    }
                    object = "code";
                    object3 = ((HashMap)object3).get(object);
                    object3 = String.valueOf(object3);
                    object = "200";
                    boolean bl3 = ((String)object).equals(object3);
                    if (bl3) break block74;
                    if (n10 >= n11) break block75;
                    com.mob.commons.a.b(n10, bl2);
                }
                object = new StringBuilder();
                object2 = "Response code is not 200: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)object4);
                object4 = ((StringBuilder)object).toString();
                try {
                    object3 = new Throwable((String)object4);
                    throw object3;
                }
                catch (Throwable throwable2) {
                    object3 = MobLog.getInstance();
                    ((NLog)object3).d(throwable2);
                    if (n10 >= n11) break block76;
                    com.mob.commons.a.b(n10, bl2);
                }
            }
            return;
        }
        throw throwable2;
    }

    public static /* synthetic */ void b(boolean bl2, OperationCallback operationCallback) {
        com.mob.commons.a.c(bl2, operationCallback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b() {
        boolean bl2 = u;
        boolean bl3 = -1 != 0;
        boolean bl4 = false;
        boolean bl5 = true;
        if (bl2 != bl3) {
            bl2 = u;
            if (bl2 != bl5) return bl4;
            return bl5;
        }
        byte[] byArray = t;
        synchronized (byArray) {
            boolean bl6 = u;
            if (bl6 == bl3) {
                try {
                    Object object = MobLog.getInstance();
                    String string2 = "Wait initLock";
                    Object[] objectArray = new Object[]{};
                    ((NLog)object).d(string2, objectArray);
                    object = t;
                    object.wait();
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    String string3 = "Init lock error";
                    Object[] objectArray = new Object[]{};
                    nLog.d(throwable, (Object)string3, objectArray);
                }
            }
        }
        bl2 = u;
        if (bl2 != bl5) return bl4;
        return bl5;
    }

    public static /* synthetic */ int c(int n10) {
        n = n10;
        return n10;
    }

    public static /* synthetic */ Boolean c(Boolean bl2) {
        j = bl2;
        return bl2;
    }

    private static void c(boolean bl2, OperationCallback operationCallback) {
        a$6 a$6 = new a$6(bl2, operationCallback);
        Thread thread = new Thread(a$6);
        thread.start();
    }

    public static boolean c() {
        Boolean bl2 = j;
        if (bl2 == null) {
            boolean bl3 = com.mob.commons.i.A();
            j = bl2 = Boolean.valueOf(bl3);
        }
        return j;
    }

    public static /* synthetic */ void d(int n10) {
        com.mob.commons.a.e(n10);
    }

    public static boolean d() {
        Boolean bl2 = com.mob.commons.a.k();
        if (bl2 == null) {
            bl2 = Boolean.FALSE;
        }
        return bl2;
    }

    public static Boolean e() {
        return g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void e(int n10) {
        int n11 = l;
        int n12 = -1;
        if (n11 == n12) {
            l = n11 = com.mob.commons.i.w();
        }
        if ((n11 = m) == n12) {
            m = n11 = com.mob.commons.i.y();
        }
        try {
            n11 = l;
            n12 = 0;
            Object var3_3 = null;
            if (n11 != n10) {
                Object object = new com.mob.commons.h();
                int n13 = 2;
                object = ((com.mob.commons.h)object).b(n13, null);
                l = n11 = ((PrivacyPolicy)object).getPpVersion();
            }
            if ((n11 = m) == n10) return;
            Object object = new com.mob.commons.h();
            n11 = 1;
            object = ((com.mob.commons.h)object).b(n11, null);
            m = n10 = ((PrivacyPolicy)object).getPpVersion();
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            n11 = 0;
            Object[] objectArray = new Object[]{};
            String string2 = "Update privacy policy err.";
            nLog.d(string2, objectArray);
        }
    }

    public static Boolean f() {
        return h;
    }

    public static int g() {
        return i;
    }

    public static int h() {
        return n;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean i() {
        Boolean bl2 = Boolean.TRUE;
        Class<a> clazz = a.class;
        synchronized (clazz) {
            Boolean bl3 = o;
            if (bl3 == null) {
                int n10;
                int n11 = com.mob.commons.i.C();
                o = n11 == (n10 = 1) ? bl2 : (n11 == 0 ? (bl2 = Boolean.FALSE) : bl2);
            }
            bl2 = o;
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean j() {
        Object object = Boolean.FALSE;
        Object object2 = p;
        if (object2 != null) return p;
        object2 = s;
        synchronized (object2) {
            int n10;
            Object object3 = p;
            if (object3 != null) return p;
            int n11 = com.mob.commons.i.D();
            if (n11 == (n10 = -1)) {
                com.mob.commons.a.w();
            } else {
                n10 = 1;
                if (n11 == n10) {
                    object = Boolean.TRUE;
                    p = object;
                } else {
                    p = n11 == 0 ? object : object;
                }
                object3 = new a$3();
                object = new Thread((Runnable)object3);
                ((Thread)object).start();
            }
            return p;
        }
    }

    public static Boolean k() {
        boolean bl2;
        boolean bl3;
        Boolean bl4 = k;
        if (bl4 == null && (bl3 = com.mob.commons.i.B()) != (bl2 = -1 != 0)) {
            bl2 = true;
            if (bl3 != bl2) {
                bl2 = false;
            }
            k = bl4 = Boolean.valueOf(bl2);
        }
        return k;
    }

    public static /* synthetic */ void l() {
        com.mob.commons.a.v();
    }

    public static /* synthetic */ int m() {
        return com.mob.commons.a.x();
    }

    public static /* synthetic */ void n() {
        com.mob.commons.a.u();
    }

    public static /* synthetic */ void o() {
        com.mob.commons.a.t();
    }

    public static /* synthetic */ void p() {
        com.mob.commons.a.w();
    }

    public static /* synthetic */ String q() {
        return c;
    }

    public static /* synthetic */ Boolean r() {
        return j;
    }

    public static /* synthetic */ int s() {
        return n;
    }

    private static void t() {
        boolean bl2 = com.mob.commons.b.ab();
        if (bl2) {
            String string2 = "MobSDK/Policy";
            String string3 = "\u60a8\u597d\uff01\u4f9d\u7167\u56fd\u5bb6\u5bf9\u7f51\u7edc\u5b89\u5168\u53ca\u6570\u636e\u5b89\u5168\u7684\u8981\u6c42\uff0c\u8bf7\u60a8\u8fd0\u8425\u7684APP\u96c6\u6210\u5e76\u5411\u7ec8\u7aef\u7528\u6237\u5c55\u793aMob SDK\u7684\u9690\u79c1\u653f\u7b56\u3002";
            Log.w((String)string2, (String)string3);
        }
    }

    private static void u() {
        Class[] classArray = new Class[]{com.mob.commons.a.a.class, k.class, o.class, q.class, b.class, s.class, h.class, r.class, p.class, n.class, j.class, i.class, e.class, c.class, f.class, g.class, l.class};
        com.mob.commons.a.d.a(classArray);
    }

    private static void v() {
        a$5 a$5 = new a$5();
        Thread thread = new Thread(a$5);
        thread.start();
    }

    private static void w() {
        block127: {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            block123: {
                block124: {
                    block125: {
                        block126: {
                            int n10;
                            block134: {
                                block132: {
                                    int n12;
                                    block133: {
                                        block130: {
                                            block131: {
                                                block128: {
                                                    block129: {
                                                        int n13;
                                                        Object[] objectArray;
                                                        block122: {
                                                            object5 = null;
                                                            object4 = MobSDK.getContext();
                                                            object4 = DeviceHelper.getInstance((Context)object4);
                                                            object3 = new ArrayList();
                                                            object2 = "appkey";
                                                            objectArray = MobSDK.getAppkey();
                                                            object = new KVPair((String)object2, objectArray);
                                                            ((ArrayList)object3).add(object);
                                                            object2 = "apppkg";
                                                            objectArray = ((DeviceHelper)object4).getPackageName();
                                                            object = new KVPair((String)object2, objectArray);
                                                            ((ArrayList)object3).add(object);
                                                            object2 = "appver";
                                                            objectArray = ((DeviceHelper)object4).getAppVersionName();
                                                            object = new KVPair((String)object2, objectArray);
                                                            ((ArrayList)object3).add(object);
                                                            object2 = "plat";
                                                            n13 = ((DeviceHelper)object4).getPlatformCode();
                                                            objectArray = String.valueOf(n13);
                                                            object = new KVPair((String)object2, objectArray);
                                                            ((ArrayList)object3).add(object);
                                                            object2 = "networktype";
                                                            object4 = ((DeviceHelper)object4).getDetailNetworkTypeForStatic();
                                                            object = new KVPair((String)object2, object4);
                                                            ((ArrayList)object3).add(object);
                                                            object4 = DeviceAuthorizer.authorizeForOnce();
                                                            n10 = TextUtils.isEmpty((CharSequence)object4);
                                                            if (n10 != 0) break block122;
                                                            object2 = "duid";
                                                            object = new KVPair((String)object2, object4);
                                                            ((ArrayList)object3).add(object);
                                                        }
                                                        object4 = new NetworkHelper$NetworkTimeOut();
                                                        n10 = 10000;
                                                        ((NetworkHelper$NetworkTimeOut)object4).readTimout = n10;
                                                        n10 = 5000;
                                                        ((NetworkHelper$NetworkTimeOut)object4).connectionTimeout = n10;
                                                        object = new ArrayList();
                                                        objectArray = "User-Identity";
                                                        String string2 = MobProductCollector.getUserIdentity();
                                                        object2 = new KVPair((String)objectArray, string2);
                                                        ((ArrayList)object).add(object2);
                                                        object2 = MobLog.getInstance();
                                                        objectArray = new StringBuilder();
                                                        string2 = "Request: ";
                                                        objectArray.append(string2);
                                                        string2 = d;
                                                        objectArray.append(string2);
                                                        Object[] objectArray2 = "\nHeaders: ";
                                                        objectArray.append((String)objectArray2);
                                                        objectArray.append(object);
                                                        objectArray2 = "\nValues: ";
                                                        objectArray.append((String)objectArray2);
                                                        objectArray.append(object3);
                                                        objectArray = objectArray.toString();
                                                        objectArray2 = new Object[]{};
                                                        ((NLog)object2).d(objectArray, objectArray2);
                                                        object2 = new NetworkHelper();
                                                        object4 = ((NetworkHelper)object2).httpGet(string2, (ArrayList)object3, (ArrayList)object, (NetworkHelper$NetworkTimeOut)object4);
                                                        object3 = MobLog.getInstance();
                                                        object = new StringBuilder();
                                                        object2 = "Response: ";
                                                        ((StringBuilder)object).append((String)object2);
                                                        ((StringBuilder)object).append((String)object4);
                                                        object = ((StringBuilder)object).toString();
                                                        object2 = new Object[]{};
                                                        ((NLog)object3).d(object, (Object[])object2);
                                                        object3 = new Hashon();
                                                        object = ((Hashon)object3).fromJson((String)object4);
                                                        object2 = "Response is illegal: ";
                                                        if (object == null) break block123;
                                                        objectArray = "code";
                                                        objectArray = ((HashMap)object).get(objectArray);
                                                        objectArray = String.valueOf(objectArray);
                                                        string2 = "200";
                                                        n13 = (int)(string2.equals(objectArray) ? 1 : 0);
                                                        if (n13 == 0) break block124;
                                                        objectArray = "data";
                                                        object = ((HashMap)object).get(objectArray);
                                                        if (object == null) break block125;
                                                        object = (HashMap)object;
                                                        if (object == null) break block126;
                                                        object4 = "content";
                                                        object4 = ((HashMap)object).get(object4);
                                                        object4 = (String)object4;
                                                        object2 = "timestamp";
                                                        object = ((HashMap)object).get(object2);
                                                        object = (Long)object;
                                                        n12 = TextUtils.isEmpty((CharSequence)object4);
                                                        if (n12 != 0) break block127;
                                                        long l10 = (Long)object;
                                                        object4 = com.mob.commons.a.b(l10, (String)object4);
                                                        object = MobLog.getInstance();
                                                        object2 = new StringBuilder();
                                                        objectArray = "contentDe: ";
                                                        ((StringBuilder)object2).append((String)objectArray);
                                                        ((StringBuilder)object2).append((String)object4);
                                                        objectArray = " (pprdms->clt, pprfms->func, pprsbs->cover, pprspw->dialog)";
                                                        ((StringBuilder)object2).append((String)objectArray);
                                                        object2 = ((StringBuilder)object2).toString();
                                                        objectArray = new Object[]{};
                                                        ((NLog)object).d(object2, objectArray);
                                                        object4 = ((Hashon)object3).fromJson((String)object4);
                                                        if (object4 == null) break block127;
                                                        boolean n11 = ((HashMap)object4).isEmpty();
                                                        if (n11) break block127;
                                                        object3 = "pprdms";
                                                        object3 = ((HashMap)object4).get(object3);
                                                        object3 = (Integer)object3;
                                                        n10 = 1;
                                                        if (object3 == null) break block128;
                                                        n12 = (Integer)object3;
                                                        if (n12 == n10) {
                                                            n12 = n10;
                                                            break block129;
                                                        }
                                                        n12 = 0;
                                                        object2 = null;
                                                    }
                                                    object2 = n12 != 0;
                                                    p = object2;
                                                    int n11 = (Integer)object3;
                                                    com.mob.commons.i.e(n11);
                                                }
                                                object3 = "pprfms";
                                                object3 = ((HashMap)object4).get(object3);
                                                object3 = (Integer)object3;
                                                if (object3 == null) break block130;
                                                n12 = (Integer)object3;
                                                if (n12 == n10) {
                                                    n12 = n10;
                                                    break block131;
                                                }
                                                n12 = 0;
                                                object2 = null;
                                            }
                                            object2 = n12 != 0;
                                            o = object2;
                                            int n13 = (Integer)object3;
                                            com.mob.commons.i.d(n13);
                                        }
                                        object3 = "pprsbs";
                                        object3 = ((HashMap)object4).get(object3);
                                        object3 = (Integer)object3;
                                        if (object3 == null) break block132;
                                        n12 = (Integer)object3;
                                        if (n12 == n10) {
                                            n12 = n10;
                                            break block133;
                                        }
                                        n12 = 0;
                                        object2 = null;
                                    }
                                    object2 = n12 != 0;
                                    q = object2;
                                    int n14 = (Integer)object3;
                                    com.mob.commons.i.f(n14);
                                }
                                object3 = "pprspw";
                                object4 = ((HashMap)object4).get(object3);
                                object4 = (Integer)object4;
                                if (object4 == null) break block127;
                                int n15 = (Integer)object4;
                                if (n15 == n10) break block134;
                                n10 = 0;
                                object = null;
                            }
                            object3 = n10 != 0;
                            r = object3;
                            int n16 = (Integer)object4;
                            com.mob.commons.i.g(n16);
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append((String)object4);
                        object4 = ((StringBuilder)object).toString();
                        object3 = new Throwable((String)object4);
                        throw object3;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append((String)object4);
                    object4 = ((StringBuilder)object).toString();
                    object3 = new Throwable((String)object4);
                    throw object3;
                }
                object = new StringBuilder();
                object2 = "Response code is not 200: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)object4);
                object4 = ((StringBuilder)object).toString();
                object3 = new Throwable((String)object4);
                throw object3;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append((String)object4);
            object4 = ((StringBuilder)object).toString();
            try {
                object3 = new Throwable((String)object4);
                throw object3;
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                object5 = new Object[]{};
                object = "Request total switch error";
                ((NLog)object3).e(throwable, object, object5);
                p = Boolean.FALSE;
                o = object5 = Boolean.TRUE;
                q = object5;
                r = object5;
            }
        }
    }

    private static int x() {
        int n10 = l;
        int n11 = -1;
        if (n10 == n11) {
            l = n10 = com.mob.commons.i.w();
        }
        if ((n10 = m) == n11) {
            m = n10 = com.mob.commons.i.y();
        }
        if ((n10 = l) < (n11 = m)) {
            n10 = n11;
        }
        return n10;
    }
}

