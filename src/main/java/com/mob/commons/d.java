/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons;

import android.os.Handler;
import android.os.Message;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.b;
import com.mob.commons.j;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class d
implements Handler.Callback {
    private static final String a = j.b("dfe.mic.mob.com/drl");
    private static d b;
    private MobCommunicator c;
    private SimpleDateFormat d;
    private HashMap e;
    private Handler f;
    private String g;
    private int h;

    private d() {
        int n10;
        Object object = "yyyy-MM-dd HH:mm:ss.SSS z";
        Object object2 = new SimpleDateFormat((String)object);
        this.d = object2;
        this.e = object2;
        object2 = null;
        this.g = null;
        this.h = n10 = -1;
        object2 = UUID.randomUUID();
        object2 = ((UUID)object2).toString();
        try {
            this.g = object2;
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).d(throwable);
        }
        object2 = MobHandlerThread.newHandler("d", (Handler.Callback)this);
        this.f = object2;
    }

    public static d a() {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            d d10 = b;
            if (d10 == null) {
                b = d10 = new d();
            }
            d10 = b;
            return d10;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String a(Throwable object) {
        String string2;
        Object object2;
        block27: {
            Object object3 = "";
            if (object == null) {
                return object3;
            }
            object2 = null;
            for (Object object4 = object; object4 != null; object4 = ((Throwable)object4).getCause()) {
                boolean bl2 = object4 instanceof UnknownHostException;
                if (bl2) {
                    return object3;
                }
                continue;
            }
            object3 = new StringWriter();
            object2 = new PrintWriter((Writer)object3);
            ((Throwable)object).printStackTrace((PrintWriter)object2);
            ((PrintWriter)object2).flush();
            object = ((StringWriter)object3).toString();
            try {
                ((StringWriter)object3).close();
                return object;
            }
            catch (Throwable throwable) {
                return object;
            }
            catch (Throwable throwable) {
                object2 = object3;
            }
            break block27;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        boolean bl3 = string2 instanceof OutOfMemoryError;
        if (bl3) {
            string2 = "getStackTraceString oom";
            if (object2 != null) {
                ((StringWriter)object2).close();
            }
            return string2;
        }
        string2 = ((Throwable)((Object)string2)).getMessage();
        return string2;
        catch (Throwable throwable) {
            return string2;
        }
        finally {
            if (object2 != null) {
                ((StringWriter)object2).close();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, Throwable object, String string2) {
        synchronized (this) {
            int n11;
            NLog nLog;
            if (object == null) {
                nLog = MobLog.getInstance();
                Object[] objectArray = new Object[]{};
                nLog.d(string2, objectArray);
            } else {
                nLog = MobLog.getInstance();
                nLog.d((Throwable)object);
            }
            boolean bl2 = com.mob.commons.b.aa();
            if (bl2) {
                return;
            }
            nLog = new Message();
            ((Message)nLog).what = n11 = 1;
            int n12 = 4;
            Object[] objectArray = new Object[n12];
            long l10 = System.currentTimeMillis();
            Long l11 = l10;
            objectArray[0] = l11;
            if (object == null) {
                object = string2;
            }
            objectArray[n11] = object;
            int n13 = 2;
            Integer n14 = n10;
            objectArray[n13] = n14;
            n10 = 3;
            n13 = this.b();
            objectArray[n10] = object = Integer.valueOf(n13);
            ((Message)nLog).obj = objectArray;
            n14 = this.f;
            n14.sendMessage((Message)nLog);
            return;
        }
    }

    private boolean a(HashMap hashMap) {
        try {
            return this.b(hashMap);
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.d(throwable);
            try {
                return this.b(hashMap);
            }
            catch (Throwable throwable2) {
                MobLog.getInstance().d(throwable2);
                return false;
            }
        }
    }

    private int b() {
        synchronized (this) {
            int n10 = this.h;
            return n10;
        }
    }

    private boolean b(HashMap object) {
        boolean bl2;
        boolean bl3 = true;
        if (object != null && !(bl2 = ((HashMap)object).isEmpty())) {
            boolean bl4;
            HashMap hashMap = com.mob.commons.b.ao();
            hashMap.put("errors", object);
            this.e();
            object = this.c;
            String string2 = a;
            object = (HashMap)((MobCommunicator)object).requestSynchronized(hashMap, string2, false);
            if (object != null && !(bl4 = ((HashMap)object).isEmpty())) {
                bl3 = false;
            }
        }
        return bl3;
    }

    private void c() {
        int n10 = com.mob.commons.b.aa();
        if (n10 != 0) {
            return;
        }
        n10 = this.f();
        long l10 = 0L;
        long l11 = n10 == 0 ? 120000L : l10;
        n10 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        int n11 = 2;
        if (n10 > 0) {
            Handler handler = this.f;
            handler.sendEmptyMessageDelayed(n11, l11);
        } else {
            Handler handler = this.f;
            long l12 = 10000L;
            handler.sendEmptyMessageDelayed(n11, l12);
        }
    }

    private void c(HashMap object) {
        try {
            this.d((HashMap)object);
        }
        catch (Throwable throwable) {
            try {
                this.d((HashMap)object);
            }
            catch (Throwable throwable2) {
                object = MobLog.getInstance();
                ((NLog)object).d(throwable);
            }
        }
    }

    private void d() {
        int n10;
        Serializable serializable = this.e;
        int n11 = ((HashMap)serializable).size();
        if (n11 > 0) {
            HashMap hashMap;
            serializable = this.e;
            n11 = (int)(this.a((HashMap)serializable) ? 1 : 0);
            if (n11 == 0) {
                hashMap = this.e;
                this.c(hashMap);
            }
            hashMap = this.e;
            hashMap.clear();
        } else {
            n11 = 1;
        }
        if (n11 != 0 && (n10 = ((File)(serializable = this.g())).exists()) != 0 && (n10 = ((File)serializable).isDirectory()) != 0 && (serializable = ((File)serializable).listFiles()) != null && (n10 = ((Serializable)serializable).length) > 0) {
            for (Serializable serializable2 : serializable) {
                HashMap hashMap = (HashMap)ResHelper.readObjectFromFile(((File)serializable2).getAbsolutePath());
                boolean bl2 = this.a(hashMap);
                if (!bl2 || (bl2 = ((File)serializable2).delete())) continue;
                ((File)serializable2).delete();
            }
        }
    }

    private void d(HashMap hashMap) {
        Object object;
        Object object2;
        int n10;
        File file = this.g();
        boolean bl2 = file.exists();
        if (!bl2 || !(bl2 = file.isDirectory())) {
            file.mkdirs();
        }
        if ((n10 = ((File)(object2 = new File(file, (String)(object = ".dyl_0")))).exists()) != 0 && (object = file.listFiles()) != null && (n10 = ((File[])object).length) > 0) {
            boolean bl3;
            bl2 = false;
            CharSequence charSequence = new StringBuilder();
            String string2 = ".dyl_";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(0);
            charSequence = ((StringBuilder)charSequence).toString();
            Object object3 = object = new File(file, (String)charSequence);
            n10 = 0;
            object = null;
            object2 = object3;
            while (bl3 = ((File)object2).exists()) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(++n10);
                charSequence = ((StringBuilder)charSequence).toString();
                object2 = new File(file, (String)charSequence);
            }
        }
        ResHelper.saveObjectToFile(((File)object2).getPath(), hashMap);
    }

    private void e() {
        MobCommunicator mobCommunicator = this.c;
        if (mobCommunicator == null) {
            int n10 = 1024;
            String string2 = "ab0a0a6473d1891d388773574764b239d4ad80cb2fd3a83d81d03901c1548c13fee7c9692c326e6682b239d4c5d0021d1b607642c47ec29f10b0602908c3e6c9";
            String string3 = "23c3c8cb41c47dd288cc7f4c218fbc7c839a34e0a0d1b2130e87b7914936b120a2d6570ee7ac66282328d50f2acfd82f2259957c89baea32547758db05de9cd7c6822304c8e45742f24bbbe41c1e12f09e18c6fab4d078065f2e5aaed94c900c66e8bbf8a120eefa7bd1fb52114d529250084f5f6f369ed4ce9645978dd30c51";
            this.c = mobCommunicator = new MobCommunicator(n10, string2, string3);
        }
    }

    private boolean f() {
        String string2;
        boolean bl2;
        String string3 = DeviceHelper.getInstance(MobSDK.getContext()).getNetworkType();
        if (string3 != null && !(bl2 = (string2 = "none").equals(string3))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    private File g() {
        String string2 = ResHelper.getDataCache(MobSDK.getContext());
        File file = new File(string2, ".dyl");
        return file;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        synchronized (this) {
            this.h = n10;
            int n11 = 1;
            if (n10 != n11 && n10 != (n11 = 4) && n10 != (n11 = 17) && n10 != (n11 = 18) && n10 != (n11 = 19) && n10 != (n11 = 20)) {
                n11 = 10;
                if (n10 != n11) return;
            } else {
                n11 = 8;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "ld vr ";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                String string3 = stringBuilder.toString();
                this.a(n11, null, string3);
            }
            return;
        }
    }

    public void a(int n10, Throwable throwable) {
        synchronized (this) {
            this.a(n10, throwable, null);
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public boolean handleMessage(Message var1_1) {
        block48: {
            block49: {
                var2_3 = "][";
                var3_4 = "list";
                var4_5 = var1_1.what;
                var5_6 = 2;
                var6_7 = 1;
                if (var4_5 == var6_7) ** GOTO lbl15
                if (var4_5 != var5_6) break block48;
                var1_1 = this.f;
                var1_1.removeMessages(var5_6);
                this.d();
                break block48;
lbl15:
                // 1 sources

                var7_8 = this.e;
                var4_5 = var7_8.size();
                var8_9 = 10;
                if (var4_5 <= var8_9) ** GOTO lbl27
                var7_8 = this.e;
                this.c((HashMap)var7_8);
                var7_8 = this.e;
                var7_8.clear();
lbl27:
                // 2 sources

                var1_1 = var1_1.obj;
                var1_1 = (Object[])var1_1;
                var7_8 = this.e;
                var9_10 = "sd";
                var10_11 = this.g;
                var7_8.put(var9_10, var10_11);
                var7_8 = this.e;
                var7_8 = var7_8.get(var3_4);
                var7_8 = (ArrayList)var7_8;
                if (var7_8 != null) break block49;
                var7_8 = new ArrayList();
            }
            var9_10 = new HashMap<String, Object>();
            var10_11 = "ct";
            var11_12 = var1_1[0];
            var9_10.put((String)var10_11, var11_12);
            var10_11 = var1_1[var6_7];
            var12_13 = var10_11 instanceof Throwable;
            if (var12_13) {
                var13_14 = var1_1[var6_7];
                var13_14 = (Throwable)var13_14;
                var13_14 = this.a((Throwable)var13_14);
            } else {
                var13_14 = var1_1[var6_7];
                var13_14 = String.valueOf(var13_14);
            }
            var10_11 = "mg";
            var11_12 = new StringBuilder();
            var14_15 = "[";
            var11_12.append((String)var14_15);
            var14_15 = this.d;
            var15_16 = var1_1[0];
            var14_15 = var14_15.format(var15_16);
            var11_12.append((String)var14_15);
            var11_12.append((String)var2_3);
            var14_15 = var1_1[var5_6];
            var11_12.append(var14_15);
            var11_12.append((String)var2_3);
            var16_17 = 3;
            var14_15 = var1_1[var16_17];
            var11_12.append(var14_15);
            var14_15 = "] ";
            var11_12.append((String)var14_15);
            var11_12.append((String)var13_14);
            var13_14 = var11_12.toString();
            var9_10.put((String)var10_11, var13_14);
            var13_14 = "et";
            var17_18 = var1_1[var5_6];
            var9_10.put((String)var13_14, var17_18);
            var17_18 = "po";
            var1_1 = var1_1[var16_17];
            var9_10.put((String)var17_18, var1_1);
            var7_8.add(var9_10);
            var1_1 = this.e;
            try {
                var1_1.put(var3_4, var7_8);
                this.c();
            }
            catch (Throwable var1_2) {
                var2_3 = MobLog.getInstance();
                var2_3.d(var1_2);
            }
        }
        return false;
    }
}

