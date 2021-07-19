/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 *  android.util.Base64
 */
package com.mob.commons.logcollector;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.MobProductCollector;
import com.mob.commons.b;
import com.mob.commons.e;
import com.mob.commons.j;
import com.mob.commons.logcollector.c$1;
import com.mob.commons.logcollector.c$2;
import com.mob.commons.logcollector.c$3;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

public class c {
    private static c b;
    private static String c;
    public final Handler a;
    private HashMap d;
    private NetworkHelper e;
    private File f;

    static {
        c = j.b("api.exc.mob.com");
    }

    private c() {
        Object object = new NetworkHelper();
        this.e = object;
        object = new HashMap();
        this.d = object;
        object = new c$1(this);
        object = MobHandlerThread.newHandler("l", (Handler.Callback)object);
        this.a = object;
    }

    public static c a() {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c10 = b;
            if (c10 == null) {
                b = c10 = new c();
            }
            c10 = b;
            return c10;
        }
    }

    public static /* synthetic */ String a(c c10, String string2) {
        return c10.a(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(String object) {
        int n10;
        int n11;
        object = ((String)object).getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = new ByteArrayOutputStream();
        Object object2 = new GZIPOutputStream((OutputStream)object);
        int n12 = 1024;
        byte[] byArray = new byte[n12];
        while ((n11 = byteArrayInputStream.read(byArray, 0, n12)) != (n10 = -1)) {
            ((GZIPOutputStream)object2).write(byArray, 0, n11);
        }
        try {
            ((DeflaterOutputStream)object2).flush();
        }
        catch (Throwable throwable) {}
        ((DeflaterOutputStream)object2).close();
        object2 = ((ByteArrayOutputStream)object).toByteArray();
        ((OutputStream)object).flush();
        ((ByteArrayOutputStream)object).close();
        byteArrayInputStream.close();
        return Base64.encodeToString((byte[])object2, (int)2);
    }

    public static /* synthetic */ HashMap a(c c10) {
        return c10.d;
    }

    public static /* synthetic */ HashMap a(c c10, int n10, String string2) {
        return c10.b(n10, string2);
    }

    private void a(int n10, String object, String[] stringArray) {
        block10: {
            Object object2 = MobSDK.getContext();
            object2 = DeviceHelper.getInstance((Context)object2);
            object2 = ((DeviceHelper)object2).getDetailNetworkTypeForStatic();
            Object object3 = "none";
            boolean bl2 = ((String)object3).equals(object2);
            if (bl2) break block10;
            this.b();
            object2 = this.f;
            object3 = new c$3(this, stringArray, n10, (String)object);
            com.mob.commons.e.a((File)object2, (LockAction)object3);
        }
        object = "network is disconnected!";
        try {
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).i(throwable);
        }
    }

    public static /* synthetic */ void a(c c10, Message message) {
        c10.b(message);
    }

    public static /* synthetic */ boolean a(c c10, String string2, boolean bl2) {
        return c10.a(string2, bl2);
    }

    private boolean a(String object, boolean bl2) {
        Object object2;
        block21: {
            bl2 = com.mob.commons.b.I();
            if (bl2) {
                return false;
            }
            try {
                object2 = MobSDK.getContext();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().i(throwable);
                return false;
            }
            object2 = DeviceHelper.getInstance((Context)object2);
            object2 = ((DeviceHelper)object2).getDetailNetworkTypeForStatic();
            Object object3 = "none";
            bl2 = ((String)object3).equals(object2);
            if (bl2) break block21;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            object3 = "m";
            object2 = new KVPair((String)object3, object);
            arrayList.add(object2);
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            object2 = "User-Identity";
            object3 = MobProductCollector.getUserIdentity();
            object = new KVPair((String)object2, object3);
            arrayList2.add(object);
            NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut = new NetworkHelper$NetworkTimeOut();
            int n10 = 10000;
            networkHelper$NetworkTimeOut.readTimout = n10;
            networkHelper$NetworkTimeOut.connectionTimeout = n10;
            object3 = this.e;
            String string2 = this.c();
            ((NetworkHelper)object3).httpPost(string2, arrayList, null, arrayList2, networkHelper$NetworkTimeOut);
            return true;
        }
        object2 = "network is disconnected!";
        object = new IllegalStateException((String)object2);
        throw object;
    }

    private HashMap b(int n10, String string2) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        Object object = MobSDK.getAppkey();
        hashMap.put("key", object);
        int n11 = deviceHelper.getPlatformCode();
        object = n11;
        String string3 = "plat";
        hashMap.put(string3, object);
        object = "sdk";
        hashMap.put(object, string2);
        Object object2 = n10;
        hashMap.put("sdkver", object2);
        object2 = deviceHelper.getAppName();
        hashMap.put("appname", object2);
        object2 = deviceHelper.getPackageName();
        hashMap.put("apppkg", object2);
        object2 = String.valueOf(deviceHelper.getAppVersion());
        hashMap.put("appver", object2);
        object2 = deviceHelper.getModel();
        string2 = "model";
        hashMap.put(string2, object2);
        n10 = (int)(com.mob.commons.b.b() ? 1 : 0);
        if (n10 != 0) {
            object2 = deviceHelper.getDeviceKey();
            hashMap.put("deviceid", object2);
            object2 = deviceHelper.getMacAddress();
            hashMap.put("mac", object2);
            object2 = deviceHelper.getDeviceId();
            string2 = "udid";
            hashMap.put(string2, object2);
        }
        object2 = String.valueOf(deviceHelper.getOSVersionInt());
        hashMap.put("sysver", object2);
        object2 = deviceHelper.getDetailNetworkTypeForStatic();
        hashMap.put("networktype", object2);
        return hashMap;
    }

    private void b() {
        boolean bl2;
        Object object;
        File file = this.f;
        if (file == null) {
            object = MobSDK.getContext().getFilesDir();
            String string2 = ".lock";
            this.f = file = new File((File)object, string2);
        }
        if (!(bl2 = (file = this.f).exists())) {
            file = this.f;
            try {
                file.createNewFile();
            }
            catch (Exception exception) {
                object = MobLog.getInstance();
                ((NLog)object).w(exception);
            }
        }
    }

    private void b(Message message) {
        this.a.sendMessageDelayed(message, 1000L);
    }

    private String c() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = c;
        stringBuilder.append(string2);
        stringBuilder.append("/errlog");
        return stringBuilder.toString();
    }

    private void c(Message object) {
        block15: {
            int n10;
            int n11;
            int n12;
            block14: {
                n12 = object.arg1;
                object = object.obj;
                object = (String)object;
                boolean bl2 = com.mob.commons.b.af();
                n11 = com.mob.commons.b.ag();
                n10 = 1;
                if (!bl2) break block14;
                String[] stringArray = new String[n10];
                String string2 = String.valueOf(n10);
                stringArray[0] = string2;
                this.a(n12, (String)object, stringArray);
            }
            if (n11 == 0) break block15;
            String[] stringArray = new String[n10];
            n11 = 2;
            String string3 = String.valueOf(n11);
            stringArray[0] = string3;
            try {
                this.a(n12, (String)object, stringArray);
            }
            catch (Throwable throwable) {
                NLog nLog = MobLog.getInstance();
                nLog.w(throwable);
            }
        }
    }

    private void d(Message message) {
        block28: {
            int n10;
            boolean bl2;
            int n11;
            int n12;
            int n13;
            Object object;
            Object object2;
            Object object3;
            int n14;
            Object object4;
            c c10;
            block29: {
                c$2 c$2;
                boolean bl3;
                Object object5;
                File file;
                block27: {
                    c10 = this;
                    object4 = message;
                    n14 = message.arg1;
                    object3 = message.obj;
                    object3 = object3;
                    file = null;
                    object = object2 = object3[0];
                    object = (String)object2;
                    int n15 = 1;
                    float f10 = Float.MIN_VALUE;
                    object5 = object3 = object3[n15];
                    object5 = (String)object3;
                    n13 = message.arg2;
                    n12 = 3;
                    int n16 = 2;
                    float f11 = 2.8E-45f;
                    n11 = n13 == n12 ? n16 : n15;
                    bl3 = com.mob.commons.b.af();
                    bl2 = com.mob.commons.b.ag();
                    if (n15 == n11 && !bl3) {
                        return;
                    }
                    if (n16 != n11 || bl2) break block27;
                    return;
                }
                String string2 = Data.MD5((String)object5);
                this.b();
                Object object6 = c10.f;
                object3 = c$2;
                object2 = this;
                file = object6;
                object6 = string2;
                string2 = message;
                c$2 = new c$2(this, (String)object5, n11, (String)object6, message);
                n10 = com.mob.commons.e.a(file, c$2);
                if (n10 == 0) break block28;
                object4 = c10.d;
                ((HashMap)object4).remove(object6);
                n10 = 1;
                if (n10 != n11 || !bl3) break block29;
                object3 = new String[n10];
                object4 = String.valueOf(n10);
                n12 = 0;
                object2 = null;
                object3[0] = object4;
                c10.a(n14, (String)object, (String[])object3);
            }
            n10 = 2;
            if (n10 != n11 || !bl2) break block28;
            n13 = 1;
            object3 = new String[n13];
            object4 = String.valueOf(n10);
            n12 = 0;
            object2 = null;
            object3[0] = object4;
            try {
                c10.a(n14, (String)object, (String[])object3);
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                object3.w(throwable);
            }
        }
    }

    public void a(int n10, int n11, String string2, String string3) {
        Message message = new Message();
        message.what = 101;
        message.arg1 = n10;
        message.arg2 = n11;
        Object[] objectArray = new Object[]{string2, string3};
        message.obj = objectArray;
        this.a.sendMessage(message);
    }

    public void a(int n10, String string2) {
        Message message = new Message();
        message.what = 100;
        message.arg1 = n10;
        message.obj = string2;
        this.a.sendMessage(message);
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 100;
        if (n10 != n11) {
            n11 = 101;
            if (n10 == n11) {
                this.d(message);
            }
        } else {
            this.c(message);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b(int n10, int n11, String string2, String string3) {
        Handler handler;
        this.a(n10, n11, string2, string3);
        try {
            handler = this.a;
        }
        catch (Throwable throwable) {
            return;
        }
        handler.wait();
    }
}

