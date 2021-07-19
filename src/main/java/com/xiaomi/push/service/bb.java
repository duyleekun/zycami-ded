/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Messenger
 *  android.os.RemoteException
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ab;
import com.xiaomi.push.l;
import com.xiaomi.push.service.bc;
import com.xiaomi.push.service.bd;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bb {
    private static bb a;
    private static String a;
    private Context a;
    private Messenger a;
    private List a;
    private boolean a = false;
    private Messenger b;
    private boolean b;

    private bb(Context object) {
        Looper looper;
        this.a = looper = new ArrayList();
        this.b = false;
        this.a = object = object.getApplicationContext();
        looper = Looper.getMainLooper();
        bc bc2 = new bc(this, looper);
        super((Handler)bc2);
        this.a = object;
        boolean bl2 = this.a();
        if (bl2) {
            object = "use miui push service";
            com.xiaomi.channel.commonutils.logger.b.c((String)object);
            this.a = bl2 = true;
        }
    }

    private Message a(Intent intent) {
        Message message = Message.obtain();
        message.what = 17;
        message.obj = intent;
        return message;
    }

    public static /* synthetic */ Messenger a(bb bb2) {
        return bb2.b;
    }

    public static /* synthetic */ Messenger a(bb bb2, Messenger messenger) {
        bb2.b = messenger;
        return messenger;
    }

    public static bb a(Context context) {
        bb bb2 = a;
        if (bb2 == null) {
            a = bb2 = new bb(context);
        }
        return a;
    }

    public static /* synthetic */ List a(bb bb2) {
        return bb2.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Intent intent) {
        synchronized (this) {
            int n10 = this.b;
            bd bd2 = null;
            if (n10 != 0) {
                int n11;
                intent = this.a(intent);
                List list = this.a;
                n10 = list.size();
                if (n10 >= (n11 = 50)) {
                    list = this.a;
                    list.remove(0);
                }
                list = this.a;
                list.add(intent);
                return;
            }
            Object object = this.b;
            if (object == null) {
                object = this.a;
                bd2 = new bd(this);
                int n12 = 1;
                object.bindService(intent, (ServiceConnection)bd2, n12);
                this.b = n12;
                object = this.a;
                object.clear();
                intent = this.a(intent);
                object = this.a;
                object.add(intent);
            } else {
                intent = this.a(intent);
                try {
                    object = this.b;
                    object.send((Message)intent);
                }
                catch (RemoteException remoteException) {
                    intent = null;
                    this.b = null;
                    this.b = false;
                }
            }
            return;
        }
    }

    private boolean a() {
        PackageManager packageManager;
        int n10;
        block4: {
            n10 = ab.e;
            if (n10 != 0) {
                return false;
            }
            packageManager = this.a.getPackageManager();
            String string2 = "com.xiaomi.xmsf";
            int n11 = 4;
            try {
                packageManager = packageManager.getPackageInfo(string2, n11);
                if (packageManager != null) break block4;
                return false;
            }
            catch (Exception exception) {
                return false;
            }
        }
        n10 = packageManager.versionCode;
        int n12 = 104;
        return n10 >= n12;
    }

    public static /* synthetic */ boolean a(bb bb2, boolean bl2) {
        bb2.b = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Intent intent) {
        try {
            int n10;
            int n11 = l.a();
            if (n11 == 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 26)) {
                this.a(intent);
                return true;
            }
            Context context = this.a;
            context.startService(intent);
            return true;
        }
        catch (Exception exception) {
            com.xiaomi.channel.commonutils.logger.b.a(exception);
            return false;
        }
    }
}

