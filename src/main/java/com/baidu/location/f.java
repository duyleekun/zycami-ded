/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.IBinder
 *  android.os.Process
 *  android.util.Log
 *  dalvik.system.DexClassLoader
 */
package com.baidu.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.g.a;
import com.baidu.location.h.l;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

public class f
extends Service {
    public static boolean isServing = false;
    public static boolean isStartedServing = false;
    public static Context mC;
    public static String replaceFileName = "repll.jar";
    public LLSInterface a = null;
    public LLSInterface b = null;
    public LLSInterface c = null;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(File object) {
        boolean bl2;
        block15: {
            Object object2;
            block16: {
                Object object3;
                Object object4;
                object2 = new StringBuilder();
                String string2 = l.j();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append("/grtcfrsa.dat");
                object2 = ((StringBuilder)object2).toString();
                bl2 = false;
                string2 = null;
                try {
                    object4 = new File((String)object2);
                    boolean bl3 = ((File)object4).exists();
                    if (!bl3) break block15;
                    object3 = "rw";
                }
                catch (Exception exception) {
                    return bl2;
                }
                object2 = new RandomAccessFile((File)object4, (String)object3);
                long l10 = 200L;
                ((RandomAccessFile)object2).seek(l10);
                int n10 = ((RandomAccessFile)object2).readBoolean();
                if (n10 == 0) break block16;
                n10 = ((RandomAccessFile)object2).readBoolean();
                if (n10 == 0) break block16;
                n10 = ((RandomAccessFile)object2).readInt();
                if (n10 == 0) break block16;
                object3 = new byte[n10];
                ((RandomAccessFile)object2).read((byte[])object3, 0, n10);
                object4 = new String((byte[])object3);
                object3 = "SHA-256";
                object = l.a((File)object, (String)object3);
                if (object == null) break block16;
                object3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB";
                boolean bl4 = l.b((String)object, (String)object4, (String)object3);
                if (!bl4) break block16;
                bl2 = bl4 = true;
            }
            ((RandomAccessFile)object2).close();
        }
        return bl2;
    }

    public static float getFrameVersion() {
        return 8.4f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return mC;
    }

    public IBinder onBind(Intent intent) {
        LLSInterface lLSInterface = this.c;
        if (lLSInterface != null) {
            return lLSInterface.onBind(intent);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate() {
        double d10;
        double d11;
        double d12;
        double d13;
        Object object;
        block8: {
            object = "app.jar";
            int n10 = isServing;
            if (n10 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("baidu location service can not start again ...20190306...");
                n10 = Process.myPid();
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                Log.d((String)"baidu_location_service", (String)object);
                return;
            }
            mC = this.getApplicationContext();
            System.currentTimeMillis();
            a a10 = new a();
            this.b = a10;
            n10 = 0;
            a10 = null;
            try {
                boolean bl2;
                Object object2 = new StringBuilder();
                Object object3 = l.j();
                ((StringBuilder)object2).append((String)object3);
                object3 = File.separator;
                ((StringBuilder)object2).append((String)object3);
                CharSequence charSequence = replaceFileName;
                ((StringBuilder)object2).append((String)charSequence);
                object2 = ((StringBuilder)object2).toString();
                File file = new File((String)object2);
                charSequence = new StringBuilder();
                String string2 = l.j();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object3);
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
                object2 = new File((String)charSequence);
                boolean bl3 = file.exists();
                if (bl3) {
                    bl3 = ((File)object2).exists();
                    if (bl3) {
                        ((File)object2).delete();
                    }
                    file.renameTo((File)object2);
                }
                if (!(bl2 = ((File)object2).exists())) break block8;
                object2 = new StringBuilder();
                charSequence = l.j();
                ((StringBuilder)object2).append((String)charSequence);
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                file = new File((String)object2);
                bl2 = this.a(file);
                if (bl2) {
                    object2 = new StringBuilder();
                    charSequence = l.j();
                    ((StringBuilder)object2).append((String)charSequence);
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    object2 = l.j();
                    object3 = this.getClassLoader();
                    file = new DexClassLoader((String)object, (String)object2, null, (ClassLoader)object3);
                    object = "com.baidu.serverLoc.LocationService";
                    object = file.loadClass((String)object);
                    object = ((Class)object).newInstance();
                    this.a = object = (LLSInterface)object;
                }
            }
            catch (Exception exception) {
                this.a = null;
            }
        }
        if ((object = this.a) != null && (d13 = (d12 = (d11 = object.getVersion()) - (d10 = (object = this.b).getVersion())) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) >= 0) {
            this.c = object = this.a;
            this.b = null;
        } else {
            this.c = object = this.b;
            this.a = null;
        }
        isServing = true;
        this.c.onCreate((Context)this);
    }

    public void onDestroy() {
        boolean bl2 = false;
        isServing = false;
        LLSInterface lLSInterface = this.c;
        if (lLSInterface != null) {
            lLSInterface.onDestroy();
        }
        if (bl2 = isStartedServing) {
            bl2 = true;
            this.stopForeground(bl2);
        }
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        block9: {
            int n12;
            int n13;
            String string2;
            block8: {
                if (intent == null) break block9;
                string2 = "command";
                String string3 = null;
                n13 = intent.getIntExtra(string2, 0);
                n12 = 1;
                if (n13 != n12) break block8;
                string2 = "id";
                n13 = intent.getIntExtra(string2, 0);
                string3 = "notification";
                string3 = intent.getParcelableExtra(string3);
                string3 = (Notification)string3;
                this.startForeground(n13, (Notification)string3);
                isStartedServing = n12;
            }
            int n14 = 2;
            if (n13 != n14) break block9;
            string2 = "removenotify";
            n13 = intent.getBooleanExtra(string2, n12 != 0);
            try {
                this.stopForeground(n13 != 0);
                isStartedServing = false;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return this.c.onStartCommand(intent, n10, n11);
    }

    public void onTaskRemoved(Intent intent) {
        LLSInterface lLSInterface = this.c;
        if (lLSInterface != null) {
            lLSInterface.onTaskRemoved(intent);
        }
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }
}

