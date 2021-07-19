/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.a;
import cn.sharesdk.framework.b.b.c;
import cn.sharesdk.framework.b.b.e;
import cn.sharesdk.framework.b.b.g;
import cn.sharesdk.framework.b.d$1;
import cn.sharesdk.framework.b.d$2;
import cn.sharesdk.framework.b.d$3;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.MobSDK;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.Calendar;

public class d
extends cn.sharesdk.framework.utils.e {
    private static d b;
    private DeviceHelper c;
    private a d;
    private Handler e;
    private boolean f;
    private long g;
    private boolean h;
    private File i;
    private FileLocker j;

    private d() {
        Object object = DeviceHelper.getInstance(MobSDK.getContext());
        this.c = object;
        this.d = object = cn.sharesdk.framework.b.a.a();
        this.j = object = new FileLocker();
        Object object2 = MobSDK.getContext().getFilesDir();
        String string2 = ".statistics";
        this.i = object = new File((File)object2, string2);
        boolean bl2 = ((File)object).exists();
        if (!bl2) {
            object = this.i;
            try {
                ((File)object).createNewFile();
            }
            catch (Exception exception) {
                object2 = SSDKLog.b();
                ((NLog)object2).d(exception);
            }
        }
    }

    public static /* synthetic */ a a(d d10) {
        return d10.d;
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

    private void b() {
        boolean bl2 = this.c();
        if (bl2) {
            boolean bl3 = this.h;
            if (!bl3) {
                long l10;
                this.h = bl2;
                this.g = l10 = System.currentTimeMillis();
                g g10 = new g();
                this.a(g10);
            }
        } else {
            boolean bl4 = this.h;
            if (bl4) {
                this.h = bl2;
                long l11 = System.currentTimeMillis();
                long l12 = this.g;
                e e10 = new e();
                e10.a = l11 -= l12;
                this.a(e10);
            }
        }
    }

    private void c(c c10) {
        int n10;
        Object object = this.c.getDeviceKey();
        c10.f = object;
        object = this.c.getPackageName();
        c10.g = object;
        c10.h = n10 = this.c.getAppVersion();
        object = String.valueOf(ShareSDK.SDK_VERSION_CODE);
        c10.i = object;
        c10.j = n10 = this.c.getPlatformCode();
        object = this.c.getDetailNetworkTypeForStatic();
        c10.k = object;
        object = MobSDK.getAppkey();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        int n11 = 1;
        String string2 = "ShareSDKCore";
        if (n10 != 0) {
            object = SSDKLog.b();
            Object[] objectArray = new Object[n11];
            String string3 = "Your appKey of ShareSDK is null , this will cause its data won't be count!";
            objectArray[0] = string3;
            ((NLog)object).w(string2, objectArray);
        } else {
            String string4 = "cn.sharesdk.demo";
            object = c10.g;
            n10 = (int)(string4.equals(object) ? 1 : 0);
            if (n10 == 0 && ((n10 = (int)((string4 = "api20").equals(object = MobSDK.getAppkey()) ? 1 : 0)) != 0 || (n10 = (int)((string4 = "androidv1101").equals(object = MobSDK.getAppkey()) ? 1 : 0)) != 0)) {
                object = SSDKLog.b();
                Object[] objectArray = new Object[n11];
                string4 = "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!";
                objectArray[0] = string4;
                ((NLog)object).w(string2, objectArray);
            }
        }
        c10.l = object = this.c.getDeviceData();
    }

    private boolean c() {
        return DeviceHelper.getInstance(MobSDK.getContext()).amIOnForeground();
    }

    private void d() {
        d$3 d$3 = new d$3(this);
        Thread thread = new Thread(d$3);
        thread.start();
    }

    private void d(c object) {
        a a10 = this.d;
        try {
            a10.a((c)object);
            ((c)object).h();
        }
        catch (Throwable throwable) {
            SSDKLog.b().d(throwable);
            NLog nLog = SSDKLog.b();
            object = ((c)object).toString();
            Object[] objectArray = new Object[]{};
            nLog.d(object, objectArray);
        }
    }

    public void a(Handler handler) {
        this.e = handler;
    }

    public void a(Message message) {
        block16: {
            int n10 = (int)(this.f ? 1 : 0);
            if (n10 == 0) {
                n10 = 1;
                this.f = n10;
                Object object = this.j;
                Object object2 = this.i;
                object2 = ((File)object2).getAbsolutePath();
                ((FileLocker)object).setLockFile((String)object2);
                object = this.j;
                int n11 = 0;
                object2 = null;
                boolean n12 = ((FileLocker)object).lock(false);
                if (!n12) break block16;
                object2 = new d$1(this);
                object = new Thread((Runnable)object2);
                ((Thread)object).start();
                object = this.d;
                ((a)object).b();
                object = this.d;
                ((a)object).c();
                ShareSDK.setEnableAuthTag(n10 != 0);
                this.d();
                object = this.a;
                n11 = 4;
                long l10 = 3600000L;
                object.sendEmptyMessageDelayed(n11, l10);
                object = this.a;
                object.sendEmptyMessage(n10);
                message = this.a;
                int n13 = 2;
                try {
                    message.sendEmptyMessage(n13);
                }
                catch (Throwable throwable) {
                    object = SSDKLog.b();
                    ((NLog)object).d(throwable);
                }
            }
        }
    }

    public void a(c c10) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object == (looper = Looper.getMainLooper())) {
            object = new d$2(this, c10);
            ((Thread)object).start();
        } else {
            this.b(c10);
        }
    }

    public void b(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                int n13 = 3;
                if (n10 != n13) {
                    int n14 = 4;
                    if (n10 == n14) {
                        long l10 = cn.sharesdk.framework.b.a.e.a().j();
                        Object object2 = Calendar.getInstance();
                        ((Calendar)object2).setTimeInMillis(l10);
                        n13 = ((Calendar)object2).get(n11);
                        int n15 = ((Calendar)object2).get(n12);
                        int n16 = 5;
                        int n17 = ((Calendar)object2).get(n16);
                        long l11 = System.currentTimeMillis();
                        ((Calendar)object2).setTimeInMillis(l11);
                        n11 = ((Calendar)object2).get(n11);
                        n12 = ((Calendar)object2).get(n12);
                        n10 = ((Calendar)object2).get(n16);
                        if (n13 != n11 || n15 != n12 || n17 != n10) {
                            object2 = this.d;
                            ((a)object2).c();
                        }
                        object2 = this.a;
                        long l12 = 3600000L;
                        object2.sendEmptyMessageDelayed(n14, l12);
                    }
                } else {
                    object = ((Message)object).obj;
                    if (object != null) {
                        object = (c)object;
                        this.d((c)object);
                        this.a.removeMessages(n12);
                        object = this.a;
                        long l13 = 2000L;
                        object.sendEmptyMessageDelayed(n12, l13);
                    }
                }
            } else {
                object = this.d;
                try {
                    ((a)object).d();
                }
                catch (Throwable throwable) {
                    NLog nLog = SSDKLog.b();
                    nLog.d(throwable);
                }
            }
        } else {
            this.b();
            object = this.a;
            long l14 = 5000L;
            try {
                object.sendEmptyMessageDelayed(n11, l14);
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void b(c var1_1) {
        block20: {
            block19: {
                var2_5 = null;
                var3_6 = MobSDK.isMob();
                if (var3_6) break block19;
                return;
            }
            var3_6 = this.f;
            if (!var3_6) break block20;
            this.c((c)var1_1);
            var3_6 = var1_1.g();
            if (!var3_6) ** GOTO lbl-1000
            var4_7 = new Message();
            var5_8 = 3;
            var4_7.what = var5_8;
            var4_7.obj = var1_1;
            var1_1 = this.a;
            try {
                var1_1.sendMessage((Message)var4_7);
            }
            catch (Throwable var1_2) {
                var4_7 = SSDKLog.b();
                var4_7.d(var1_2);
            }
            break block20;
lbl-1000:
            // 1 sources

            {
                var4_7 = SSDKLog.b();
            }
            var6_9 = new StringBuilder();
            var7_10 = "Drop event: ";
            var6_9.append(var7_10);
            var1_1 = var1_1.toString();
            var6_9.append((String)var1_1);
            var1_1 = var6_9.toString();
            var6_9 = new Object[]{};
            var4_7.d(var1_1, var6_9);
            {
                catch (Throwable var1_3) {
                    var4_7 = SSDKLog.b();
                    var6_9 = new StringBuilder();
                    var7_10 = "logStart ";
                    var6_9.append(var7_10);
                    var6_9.append(var1_3);
                    var1_4 = var6_9.toString();
                    var2_5 = new Object[]{};
                    var4_7.d(var1_4, var2_5);
                }
            }
        }
    }

    public void c(Message object) {
        boolean bl2 = this.f;
        if (bl2) {
            long l10 = System.currentTimeMillis();
            long l11 = this.g;
            object = new e();
            object.a = l10 -= l11;
            this.a((c)object);
            bl2 = false;
            object = null;
            this.f = false;
            object = this.e;
            int n10 = 1;
            try {
                object.sendEmptyMessage(n10);
            }
            catch (Throwable throwable) {
                NLog nLog = SSDKLog.b();
                nLog.d(throwable);
            }
            bl2 = false;
            b = null;
            object = this.a.getLooper();
            object.quit();
        }
    }
}

