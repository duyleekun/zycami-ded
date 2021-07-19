/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package d.j.e.a.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.tencent.liteav.basic.log.TXCLog;
import d.j.e.a.b.b.a;
import d.j.e.a.b.b.c;

public class b {
    private static final String b = "HwAudioKit.FeatureKitManager";
    private static final Object c;
    private static final Object d;
    private static final Object e;
    private static final Object f;
    private static final String g = "com.huawei.multimedia.audioengine";
    private static final int h;
    private static b i;
    private c a = null;

    static {
        Object object;
        c = object = new Object();
        d = object = new Object();
        e = object = new Object();
        f = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b d() {
        Object object = d;
        synchronized (object) {
            b b10 = i;
            if (b10 != null) return i;
            i = b10 = new b();
            return i;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context context, ServiceConnection object, String objectArray) {
        Object object2 = e;
        synchronized (object2) {
            if (context == null) {
                return;
            }
            Object object3 = new Intent();
            String string2 = g;
            object3.setClassName(string2, (String)objectArray);
            int n10 = 1;
            string2 = b;
            String string3 = "bindService";
            try {
                TXCLog.i(string2, string3);
                context.bindService(object3, object, n10);
            }
            catch (SecurityException securityException) {
                object = b;
                object3 = "bindService, SecurityException, %s";
                objectArray = new Object[n10];
                string2 = null;
                String string4 = securityException.getMessage();
                objectArray[0] = string4;
                TXCLog.e((String)object, (String)object3, objectArray);
            }
            return;
        }
    }

    public a b(int n10, Context context) {
        Object object;
        int n11 = 1;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object = Integer.valueOf(n10);
        object = b;
        String string2 = "createFeatureKit, type = %d";
        TXCLog.i((String)object, string2, objectArray);
        objectArray = null;
        if (context == null) {
            return null;
        }
        if (n10 != n11) {
            TXCLog.i((String)object, "createFeatureKit, type error");
            return null;
        }
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(context);
        hwAudioKaraokeFeatureKit.o(context);
        return hwAudioKaraokeFeatureKit;
    }

    public c c() {
        return this.a;
    }

    public boolean e(Context object) {
        block5: {
            String string2 = b;
            if (object == null) {
                return false;
            }
            if ((object = object.getPackageManager()) != null) {
                String string3 = g;
                try {
                    object = object.getPackageInfo(string3, 0);
                    if (object != null) break block5;
                    object = "packageInfo is null";
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    TXCLog.e(string2, "isAudioKitSupport ,NameNotFoundException");
                    return false;
                }
                TXCLog.i(string2, (String)object);
                return false;
            }
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(int n10) {
        Object object = "onCallBack, result = %d";
        int n11 = 1;
        Object[] objectArray = new Object[n11];
        Integer n12 = n10;
        objectArray[0] = n12;
        TXCLog.i(b, (String)object, objectArray);
        Object object2 = c;
        synchronized (object2) {
            object = this.c();
            if (object != null) {
                object = this.c();
                object.onResult(n10);
            }
            return;
        }
    }

    public void g(c c10) {
        this.a = c10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(Context context, ServiceConnection serviceConnection) {
        String string2 = "unbindService";
        TXCLog.i(b, string2);
        Object object = f;
        synchronized (object) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
            return;
        }
    }
}

