/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons.a;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.a.d$1;
import com.mob.commons.a.d$2;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.k;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.io.Closeable;
import java.io.File;
import java.util.HashMap;

public class d
implements Handler.Callback {
    private static HashMap c;
    private static HashMap d;
    private MobHandlerThread a;
    private boolean b = false;
    private Handler e;

    static {
        HashMap hashMap;
        c = hashMap = new HashMap();
        d = hashMap = new HashMap();
    }

    public static /* synthetic */ Handler a(d d10, Handler handler) {
        d10.e = handler;
        return handler;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String object, File object2, String object3, String objectArray) {
        int n10;
        int n11;
        Object object4;
        Object object5 = MobSDK.getContext();
        String string2 = k.a(8);
        Object object6 = new Object[]{};
        object5 = ReflectHelper.invokeInstanceMethod(object5, string2, (Object[])object6);
        int n12 = 9;
        object6 = k.a(n12);
        Object object7 = k.a(n12);
        ReflectHelper.importClass((String)object6, (String)object7);
        object6 = ((File)object2).getParentFile();
        object7 = d;
        synchronized (object7) {
            object4 = d;
            object4 = object4.get(object);
            n11 = 2;
            n10 = 1;
            if (object4 == null) {
                string2 = k.a(n12);
                int n13 = 4;
                object4 = new Object[n13];
                object4[0] = object2 = ((File)object2).getAbsolutePath();
                object4[n10] = object2 = ((File)object6).getAbsolutePath();
                object4[n11] = object2 = ((File)object6).getAbsolutePath();
                int n14 = 3;
                object4[n14] = object5;
                object4 = ReflectHelper.newInstance(string2, object4);
                object2 = d;
                ((HashMap)object2).put(object, object4);
            }
        }
        ResHelper.deleteFileAndFolder((File)object6);
        object = DeviceAuthorizer.authorize(null);
        object2 = k.a(10);
        object5 = new Object[n10];
        object5[0] = object3;
        object2 = ReflectHelper.invokeInstanceMethod(object4, (String)object2, object5);
        object3 = k.a(11);
        object5 = new Object[n11];
        object5[0] = objectArray;
        object5[n10] = String.class;
        object2 = ReflectHelper.invokeInstanceMethod(object2, (String)object3, object5);
        object3 = new HashMap();
        ((HashMap)object3).put("duid", object);
        objectArray = com.mob.commons.b.d.c(MobSDK.getContext());
        ((HashMap)object3).put("moid", objectArray);
        objectArray = MobSDK.SDK_VERSION_CODE;
        ((HashMap)object3).put("sdkVersion", objectArray);
        objectArray = MobSDK.getAppkey();
        ((HashMap)object3).put("appKey", objectArray);
        objectArray = MobSDK.getAppSecret();
        ((HashMap)object3).put("appSecret", objectArray);
        objectArray = MobSDK.getDomain().getDomain();
        ((HashMap)object3).put("domain", objectArray);
        objectArray = MobSDK.checkForceHttps();
        ((HashMap)object3).put("forceHttps", objectArray);
        object = new Hashon();
        object = ((Hashon)object).fromHashMap((HashMap)object3);
        object3 = k.a(12);
        objectArray = new Object[n10];
        objectArray[0] = object5 = Boolean.TRUE;
        ReflectHelper.invokeInstanceMethod(object2, (String)object3, objectArray);
        com.mob.commons.d.a().a(15);
        object3 = new d$2(object2, (String)object);
        UIHandler.sendEmptyMessage(0, (Handler.Callback)object3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void a(Class ... classArray) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            int n10;
            if (classArray == null || (n10 = classArray.length) == 0) {
                return;
            }
            n10 = classArray.length;
            int n11 = 0;
            while (n11 < n10) {
                Object object = classArray[n11];
                if (object != null) {
                    Object object2 = ((Class)object).getSimpleName();
                    Object object3 = c;
                    object3 = ((HashMap)object3).get(object2);
                    if ((object3 = (d)object3) == null) {
                        try {
                            object = ((Class)object).newInstance();
                            object = (d)object;
                            object3 = c;
                            ((HashMap)object3).put(object2, object);
                            super.h();
                        }
                        catch (Throwable throwable) {
                            object2 = MobLog.getInstance();
                            ((NLog)object2).d(throwable);
                        }
                    }
                }
                ++n11;
            }
            return;
        }
    }

    public static /* synthetic */ boolean a(d d10) {
        return d10.b;
    }

    public static /* synthetic */ HashMap g() {
        return c;
    }

    private void h() {
        File file = this.a();
        if (file == null) {
            return;
        }
        d$1 d$1 = new d$1(this, file);
        this.a = d$1;
        d$1.start();
    }

    public File a() {
        return null;
    }

    public final void a(int n10) {
        Handler handler = this.e;
        if (handler != null) {
            handler.removeMessages(n10);
        }
    }

    public final void a(int n10, long l10) {
        Handler handler = this.e;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(n10, l10);
        }
    }

    public void a(Message message) {
    }

    public void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.d(throwable);
            }
        }
    }

    public void b() {
    }

    public final void b(int n10) {
        Handler handler = this.e;
        if (handler != null) {
            handler.sendEmptyMessage(n10);
        }
    }

    public final void b(Message message) {
        Handler handler = this.e;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public boolean b_() {
        return true;
    }

    public void d() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e() {
        Object object;
        Object object2;
        try {
            object2 = this.e;
            if (object2 != null) {
                object2.removeCallbacksAndMessages(null);
            }
            if ((object2 = this.a) != null) {
                ((MobHandlerThread)object2).quit();
            }
            this.e = null;
            this.a = null;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
        this.b();
        this.b = true;
        object2 = c;
        object = this.getClass().getSimpleName();
        ((HashMap)object2).put(object, null);
    }

    public HashMap f() {
        boolean bl2 = com.mob.commons.b.x();
        if (bl2) {
            Object object = DeviceHelper.getInstance(MobSDK.getContext());
            boolean bl3 = true;
            int n10 = 0;
            float f10 = 0.0f;
            Object object2 = null;
            if ((object = ((DeviceHelper)object).getLocation(0, 0, bl3)) != null) {
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                f10 = object.getAccuracy();
                object2 = Float.valueOf(f10);
                String string2 = "accuracy";
                hashMap.put(string2, object2);
                n10 = Build.VERSION.SDK_INT;
                int n11 = 26;
                if (n10 >= n11 && (n10 = (int)(object.hasVerticalAccuracy() ? 1 : 0)) != 0) {
                    f10 = object.getVerticalAccuracyMeters();
                    object2 = Float.valueOf(f10);
                    string2 = "verticalAccuracy";
                    hashMap.put(string2, object2);
                }
                object2 = object.getLatitude();
                hashMap.put("latitude", object2);
                object2 = object.getLongitude();
                hashMap.put("longitude", object2);
                object2 = object.getTime();
                hashMap.put("ltime", object2);
                object2 = object.getProvider();
                hashMap.put("provider", object2);
                object2 = object.getAltitude();
                hashMap.put("altitude", object2);
                object2 = Float.valueOf(object.getBearing());
                hashMap.put("bearing", object2);
                object = Float.valueOf(object.getSpeed());
                hashMap.put("speed", object);
                return hashMap;
            }
        }
        return null;
    }

    public final boolean handleMessage(Message message) {
        boolean bl2 = com.mob.commons.b.J();
        if (bl2) {
            this.e();
        } else {
            this.a(message);
        }
        return false;
    }
}

