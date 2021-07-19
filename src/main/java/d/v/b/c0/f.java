/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioAttributes
 *  android.media.AudioAttributes$Builder
 *  android.media.SoundPool
 *  android.media.SoundPool$Builder
 *  android.media.SoundPool$OnLoadCompleteListener
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package d.v.b.c0;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.zhiyun.android.R$raw;
import d.v.b.c0.a;
import d.v.b.c0.f$a;
import d.v.b.c0.f$b;

public class f {
    private static final int f = 1;
    private static f g;
    private static final int[] h;
    private static final String i = "SoundController";
    public static final int j = 0;
    public static final int k = 1;
    public static final int l = 2;
    private static final int m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private SoundPool a;
    private f$b[] b;
    private Handler c;
    private HandlerThread d;
    private final SoundPool.OnLoadCompleteListener e;

    static {
        int n10 = R$raw.shutter_click;
        n10 = R$raw.video_start;
        n10 = R$raw.video_stop;
        int[] nArray = new int[]{n10, n10, n10};
        h = nArray;
    }

    private f() {
        f$a f$a = new f$a(this);
        this.e = f$a;
    }

    public static /* synthetic */ f$b[] a(f f10) {
        return f10.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f b() {
        Object object = g;
        if (object != null) return g;
        object = f.class;
        synchronized (object) {
            f f10 = g;
            if (f10 != null) return g;
            g = f10 = new f();
            return g;
        }
    }

    private void c() {
        f$b[] f$bArray;
        f$b[] f$bArray2 = this.a;
        if (f$bArray2 == null) {
            f$bArray2 = new SoundPool.Builder();
            int n10 = 1;
            f$bArray2 = f$bArray2.setMaxStreams(n10);
            Object object = new AudioAttributes.Builder();
            int n11 = 13;
            object = object.setUsage(n11);
            f$bArray = object.setFlags(n10);
            int n12 = 4;
            f$bArray = f$bArray.setContentType(n12).build();
            f$bArray2 = f$bArray2.setAudioAttributes((AudioAttributes)f$bArray).build();
            this.a = f$bArray2;
            f$bArray = this.e;
            f$bArray2.setOnLoadCompleteListener((SoundPool.OnLoadCompleteListener)f$bArray);
            f$bArray2 = new f$b[h.length];
            this.b = f$bArray2;
            f$bArray2 = null;
            for (int i10 = 0; i10 < (n12 = (f$bArray = this.b).length); ++i10) {
                object = new f$b(i10);
                f$bArray[i10] = object;
            }
        }
        if ((f$bArray2 = this.d) == null) {
            f$bArray2 = new HandlerThread("SoundThread");
            this.d = f$bArray2;
            f$bArray2.start();
            f$bArray = this.d.getLooper();
            f$bArray2 = new Handler((Looper)f$bArray);
            this.c = f$bArray2;
        }
    }

    private /* synthetic */ void d(f$b f$b) {
        SoundPool soundPool = this.a;
        int n10 = f$b.b;
        soundPool.play(n10, 0.2f, 0.2f, 0, 0, 1.0f);
    }

    private int g(Context context, f$b f$b) {
        SoundPool soundPool = this.a;
        int[] nArray = h;
        int n10 = f$b.a;
        int n11 = nArray[n10];
        int n12 = 1;
        int n13 = soundPool.load(context, n11, n12);
        if (n13 > 0) {
            f$b.c = n12;
            f$b.b = n13;
            return n13;
        }
        return 0;
    }

    public /* synthetic */ void e(f$b f$b) {
        this.d(f$b);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(Context context) {
        System.currentTimeMillis();
        this.c();
        int n10 = 0;
        while (true) {
            Object object;
            int n11;
            if (n10 >= (n11 = ((int[])(object = h)).length)) {
                System.currentTimeMillis();
                return;
            }
            int cfr_ignored_0 = object[n10];
            object = this.b[n10];
            synchronized (object) {
                n11 = object.c;
                if (n11 == 0) {
                    n11 = this.g(context, (f$b)object);
                }
            }
            ++n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h(int n10) {
        Object object;
        int n11;
        if (n10 >= 0 && n10 < (n11 = ((int[])(object = h)).length)) {
            object = this.b[n10];
            synchronized (object) {
                int n12;
                int n13 = object.c;
                if (n13 != 0 && n13 != (n12 = 1)) {
                    n12 = 3;
                    if (n13 == n12) {
                        Object object2 = this.c;
                        Object object3 = new a(this, (f$b)object);
                        object2.post((Runnable)object3);
                        object2 = new StringBuilder();
                        object3 = "play beep finish soundName=";
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append(n10);
                        String string2 = ((StringBuilder)object2).toString();
                        d.v.d.h.f.a(string2);
                    }
                } else {
                    object.c = n10 = 2;
                }
                return;
            }
        }
        object = new RuntimeException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown sound requested: ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        object(string3);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void i() {
        Handler handler = this.a;
        if (handler != null) {
            for (Handler handler2 : this.b) {
                synchronized (handler2) {
                    handler2.c = 0;
                    handler2.b = 0;
                }
            }
            handler = this.a;
            handler.release();
            this.a = null;
        }
        if ((handler = this.c) != null) {
            handler.removeCallbacksAndMessages(null);
            this.c = null;
        }
        if ((handler = this.d) != null) {
            handler.quit();
            this.d = null;
        }
    }
}

