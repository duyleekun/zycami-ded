/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.s;
import com.xiaomi.mipush.sdk.w;
import com.xiaomi.push.ai;
import com.xiaomi.push.az;
import com.xiaomi.push.bf;
import com.xiaomi.push.hr;
import com.xiaomi.push.r;
import com.xiaomi.push.service.ak;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class v
implements Thread.UncaughtExceptionHandler {
    private static final Object a;
    private static final String[] a;
    private Context a;
    private SharedPreferences a;
    private Thread.UncaughtExceptionHandler a;

    static {
        Object object;
        a = object = new Object();
        a = new String[]{"com.xiaomi.channel.commonutils", "com.xiaomi.common.logger", "com.xiaomi.measite.smack", "com.xiaomi.metoknlp", "com.xiaomi.mipush.sdk", "com.xiaomi.network", "com.xiaomi.push", "com.xiaomi.slim", "com.xiaomi.smack", "com.xiaomi.stats", "com.xiaomi.tinyData", "com.xiaomi.xmpush.thrift", "com.xiaomi.clientreport"};
    }

    public v(Context context) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this(context, uncaughtExceptionHandler);
    }

    public v(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = context;
        this.a = uncaughtExceptionHandler;
    }

    public static /* synthetic */ Context a(v v10) {
        return v10.a;
    }

    public static /* synthetic */ Object a() {
        return a;
    }

    private String a(Throwable object) {
        int n10;
        int n11;
        object = object.getStackTrace();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (n11 = Math.min(3, n10 = ((StackTraceElement[])object).length)); ++i10) {
            CharSequence charSequence = new StringBuilder();
            String string2 = object[i10].toString();
            charSequence.append(string2);
            string2 = "\r\n";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            stringBuilder.append((String)charSequence);
        }
        object = stringBuilder.toString();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return "";
        }
        return bf.a((String)object);
    }

    private void a() {
        ai ai2 = ai.a(this.a);
        w w10 = new w(this);
        ai2.a(w10);
    }

    public static /* synthetic */ void a(v v10) {
        v10.b();
    }

    private void a(Throwable object) {
        String string2 = this.b((Throwable)object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        bl2 = TextUtils.isEmpty((CharSequence)(object = this.a((Throwable)object)));
        if (bl2) {
            return;
        }
        s s10 = s.a(this.a);
        s10.a(string2, (String)object);
        boolean bl3 = this.a();
        if (bl3) {
            this.a();
        }
    }

    private boolean a() {
        Object object = this.a;
        String string2 = "mipush_extra";
        int n10 = 4;
        float f10 = 5.6E-45f;
        object = object.getSharedPreferences(string2, n10);
        this.a = object;
        object = this.a;
        boolean n11 = az.e((Context)object);
        long l10 = 0L;
        String string3 = "last_crash_upload_time_stamp";
        long l11 = 1000L;
        boolean bl2 = false;
        boolean bl3 = true;
        if (n11) {
            hr hr2;
            int n12;
            object = ak.a(this.a);
            boolean bl4 = ((ak)object).a(n12 = (hr2 = hr.aw).a(), bl3);
            if (!bl4) {
                return false;
            }
            object = ak.a(this.a);
            hr2 = hr.ax;
            n12 = hr2.a();
            int n13 = 3600;
            int n15 = ((ak)object).a(n12, n13);
            n15 = Math.max(n13, n15);
            long l12 = System.currentTimeMillis() / l11;
            SharedPreferences sharedPreferences = this.a;
            l10 = sharedPreferences.getLong(string3, l10);
            l12 -= l10;
            l10 = Math.abs(l12);
            float f11 = l10;
            float f12 = n15;
            n10 = 0x3F666666;
            f10 = 0.9f;
            float f13 = f11 - (f12 *= f10);
            Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2 >= 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        object = this.a;
        boolean bl5 = az.d((Context)object);
        if (bl5) {
            long l13;
            object = ak.a(this.a);
            hr hr3 = hr.ay;
            int n16 = hr3.a();
            int n17 = 1800;
            int n18 = ((ak)object).a(n16, n17);
            n16 = 60;
            int n19 = Math.max(n16, n18);
            long l14 = System.currentTimeMillis() / l11;
            SharedPreferences sharedPreferences = this.a;
            l10 = sharedPreferences.getLong(string3, l10);
            long l15 = (l10 = Math.abs(l14 -= l10)) - (l13 = (long)n19);
            Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object3 >= 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        return bl3;
    }

    private boolean a(boolean bl2, String string2) {
        for (String string3 : a) {
            boolean bl3 = string2.contains(string3);
            if (!bl3) continue;
            return true;
        }
        return bl2;
    }

    private String b(Throwable object) {
        int n10;
        StackTraceElement[] stackTraceElementArray = ((Throwable)object).getStackTrace();
        object = ((Throwable)object).toString();
        StringBuilder stringBuilder = new StringBuilder((String)object);
        object = "\r\n";
        stringBuilder.append((String)object);
        boolean bl2 = false;
        for (int i10 = 0; i10 < (n10 = stackTraceElementArray.length); ++i10) {
            String string2 = stackTraceElementArray[i10].toString();
            bl2 = this.a(bl2, string2);
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
        }
        object = bl2 ? stringBuilder.toString() : "";
        return object;
    }

    private void b() {
        SharedPreferences sharedPreferences;
        this.a = sharedPreferences = this.a.getSharedPreferences("mipush_extra", 4);
        sharedPreferences = sharedPreferences.edit();
        long l10 = System.currentTimeMillis() / 1000L;
        sharedPreferences.putLong("last_crash_upload_time_stamp", l10);
        r.a((SharedPreferences.Editor)sharedPreferences);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void uncaughtException(Thread thread, Throwable throwable) {
        block6: {
            this.a(throwable);
            Object object = a;
            synchronized (object) {
                long l10 = 3000L;
                try {
                    object.wait(l10);
                }
                catch (InterruptedException interruptedException) {
                    b.a(interruptedException);
                }
                object = this.a;
                if (object == null) break block6;
                object.uncaughtException(thread, throwable);
                return;
            }
        }
        Process.killProcess((int)Process.myPid());
        int n10 = 1;
        System.exit(n10);
        return;
        {
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }
}

