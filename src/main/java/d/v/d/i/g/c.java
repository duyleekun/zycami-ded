/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.StatFs
 */
package d.v.d.i.g;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.StatFs;
import d.v.d.h.f;
import d.v.d.i.a.a;
import d.v.d.i.g.c$a;
import java.io.File;

public class c
extends a {
    private static final long j = 1024L;
    private final Handler h;
    private final Runnable i;

    public c() {
        Handler handler;
        Object object = new c$a(this);
        this.i = object;
        this.a = object = Long.valueOf(1024L);
        object = new HandlerThread("record_arm");
        object.start();
        object = object.getLooper();
        this.h = handler = new Handler((Looper)object);
    }

    public static /* synthetic */ Runnable n(c c10) {
        return c10.i;
    }

    public static /* synthetic */ Handler o(c c10) {
        return c10.h;
    }

    public static long p() {
        Object object = Environment.getExternalStorageDirectory();
        try {
            object = ((File)object).getAbsolutePath();
        }
        catch (Exception exception) {
            return 0L;
        }
        StatFs statFs = new StatFs((String)object);
        long l10 = statFs.getBlockSizeLong();
        long l11 = statFs.getAvailableBlocksLong();
        l10 *= l11;
        l11 = 1024L;
        return l10 / l11 / l11;
    }

    public void b() {
        super.b();
        Handler handler = this.h;
        Runnable runnable = this.i;
        handler.removeCallbacks(runnable);
        this.h.getLooper().quitSafely();
    }

    public void q(Long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Arm set aLong=");
        stringBuilder.append(l10);
        d.v.d.h.f.a(stringBuilder.toString());
        super.set(l10);
    }

    public void r() {
        d.v.d.h.f.a("start arm");
        Handler handler = this.h;
        Runnable runnable = this.i;
        handler.post(runnable);
    }

    public void s() {
        d.v.d.h.f.a("stop arm");
        Handler handler = this.h;
        Runnable runnable = this.i;
        handler.removeCallbacks(runnable);
    }
}

