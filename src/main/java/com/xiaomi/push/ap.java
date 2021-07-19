/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 *  android.os.Looper
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ap$a;
import com.xiaomi.push.ar;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ap
implements ar {
    private static boolean a;
    private volatile int a;
    private Context a;
    private ServiceConnection a;
    private final Object a;
    private volatile String a = null;
    private volatile String b;
    private volatile boolean b = null;

    public ap(Context context) {
        Object object;
        this.a = object = new Object();
        this.a = context;
        this.a();
    }

    public static /* synthetic */ int a(ap ap2, int n10) {
        ap2.a = n10;
        return n10;
    }

    public static /* synthetic */ Object a(ap ap2) {
        return ap2.a;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(Context object) {
        Object object2;
        String string2;
        Context context;
        block6: {
            context = null;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            string2 = "aaid";
            if (n10 >= n11) {
                object2 = object.createDeviceProtectedStorageContext();
                object2 = object2.getSharedPreferences(string2, 0);
                if ((object2 = object2.getString(string2, null)) != null) {
                    return object2;
                }
                break block6;
            }
            n10 = 0;
            object2 = null;
            {
                catch (Exception exception) {}
            }
        }
        try {
            object = object.getSharedPreferences(string2, 0);
            object = object.getString(string2, null);
        }
        catch (Exception exception) {
            context = object2;
            object = context;
        }
        if (object != null) return object;
        return "";
    }

    public static /* synthetic */ String a(ap ap2, String string2) {
        ap2.a = string2;
        return string2;
    }

    private void a() {
        boolean bl2;
        ap$a ap$a = new ap$a(this, null);
        this.a = ap$a;
        ap$a = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        String string2 = "com.huawei.hwid";
        ap$a.setPackage(string2);
        int n10 = 1;
        Context context = this.a;
        ServiceConnection serviceConnection = this.a;
        try {
            bl2 = context.bindService((Intent)ap$a, serviceConnection, n10);
        }
        catch (Exception exception) {
            bl2 = false;
            ap$a = null;
        }
        if (!bl2) {
            n10 = 2;
        }
        this.a = n10;
    }

    public static /* synthetic */ void a(ap ap2) {
        ap2.b();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(String object) {
        Object object2;
        int n10 = this.a;
        int n11 = 1;
        if (n10 != n11) return;
        Object object3 = Looper.myLooper();
        if (object3 == (object2 = Looper.getMainLooper())) return;
        object3 = this.a;
        synchronized (object3) {
            Throwable throwable2;
            block5: {
                try {
                    object2 = new StringBuilder();
                    String string2 = "huawei's ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append((String)object);
                    object = " wait...";
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    com.xiaomi.channel.commonutils.logger.b.a((String)object);
                    object = this.a;
                    long l10 = 3000L;
                    object.wait(l10);
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                catch (Exception exception) {}
                return;
            }
            throw throwable2;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static boolean a(Context context) {
        void var3_8;
        void var4_12;
        int n10;
        block11: {
            block10: {
                int bl3;
                String string2;
                try {
                    context = context.getPackageManager();
                    string2 = "com.huawei.hwid";
                    bl3 = 128;
                }
                catch (Exception exception) {}
                context = context.getPackageInfo(string2, bl3);
                string2 = context.applicationInfo;
                int n11 = ((ApplicationInfo)string2).flags;
                n10 = 1;
                int n12 = n11 & n10;
                if (n12 != 0) {
                    int n13 = n10;
                    break block10;
                }
                boolean bl2 = false;
                string2 = null;
            }
            int n14 = context.versionCode;
            int n15 = 20602000;
            if (n14 >= n15) {
                int n16 = n10;
                break block11;
            }
            boolean bl3 = false;
            context = null;
        }
        a = var4_12;
        if (var3_8 != false) {
            return n10 != 0;
        }
        return false;
    }

    public static /* synthetic */ boolean a(ap ap2, boolean bl2) {
        ap2.b = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        ServiceConnection serviceConnection = this.a;
        if (serviceConnection == null) return;
        try {
            Context context = this.a;
            context.unbindService(serviceConnection);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public String a() {
        return null;
    }

    public boolean a() {
        return a;
    }

    public String b() {
        this.a("getOAID");
        return this.a;
    }

    public String c() {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String d() {
        String string2 = this.b;
        if (string2 != null) return this.b;
        synchronized (this) {
            string2 = this.b;
            if (string2 != null) return this.b;
            string2 = this.a;
            this.b = string2 = ap.a((Context)string2);
            return this.b;
        }
    }
}

