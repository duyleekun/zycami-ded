/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.SystemClock
 */
package d.m.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.meishe.cafconvertor.webpcoder.FrameSequence;
import com.meishe.cafconvertor.webpcoder.FrameSequence$a;
import d.m.a.g.a$a;
import d.m.a.g.a$b;
import d.m.a.g.a$e;
import d.m.a.g.a$f;
import d.m.a.g.a$g;

public class a
extends Drawable
implements Animatable,
Runnable {
    private static String A = a.class.getSimpleName();
    public static a$e B;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    private final Object a;
    private HandlerThread b;
    private Handler c;
    private final FrameSequence d;
    private final FrameSequence$a e;
    private final Paint f;
    private BitmapShader g;
    private BitmapShader h;
    private final Rect i;
    private boolean j;
    private final Object k;
    private final a$e l;
    private boolean m;
    private Bitmap n;
    private Bitmap o;
    private int p;
    private int q;
    private int r;
    private long s;
    private long t;
    private int u;
    private a$f v;
    private Runnable w;
    private Runnable x;
    private Runnable y;
    private a$g z;

    static {
        a$a a$a = new a$a();
        B = a$a;
    }

    public a(FrameSequence frameSequence) {
        a$e a$e = B;
        this(frameSequence, a$e);
    }

    public a(FrameSequence object, a$e a$e) {
        int n10;
        Object object2;
        this.a = object2 = new Object();
        this.k = object2 = new Object();
        object2 = null;
        this.m = false;
        this.r = n10 = 3;
        Object object3 = new a$b(this);
        this.w = object3;
        super(this);
        this.x = object3;
        super(this);
        this.y = object3;
        if (object != null && a$e != null) {
            Bitmap bitmap;
            this.d = object;
            this.e = object3 = ((FrameSequence)object).b();
            int n11 = ((FrameSequence)object).j();
            int n12 = ((FrameSequence)object).i();
            this.l = a$e;
            this.n = bitmap = d.m.a.g.a.c(a$e, n11, n12);
            a$e = d.m.a.g.a.c(a$e, n11, n12);
            this.o = a$e;
            super(0, 0, n11, n12);
            this.i = a$e;
            object = new Paint();
            this.f = object;
            object.setFilterBitmap(true);
            a$e = this.n;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            object = new BitmapShader((Bitmap)a$e, tileMode, tileMode);
            this.g = object;
            a$e = this.o;
            tileMode = Shader.TileMode.CLAMP;
            object = new BitmapShader((Bitmap)a$e, tileMode, tileMode);
            this.h = object;
            this.s = 0L;
            this.u = n12 = -1;
            a$e = this.n;
            ((FrameSequence$a)object3).b(0, (Bitmap)a$e, n12);
            this.f();
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public static /* synthetic */ int a(a a10, int n10) {
        a10.p = n10;
        return n10;
    }

    public static /* synthetic */ long b(a a10, long l10) {
        a10.t = l10;
        return l10;
    }

    private static Bitmap c(a$e object, int n10, int n11) {
        Bitmap.Config config;
        Bitmap.Config config2;
        int n12 = (object = object.a(n10, n11)).getWidth();
        if (n12 >= n10 && (n10 = object.getHeight()) >= n11 && (config2 = object.getConfig()) == (config = Bitmap.Config.ARGB_8888)) {
            return object;
        }
        object = new IllegalArgumentException("Invalid bitmap provided");
        throw object;
    }

    public static /* synthetic */ Bitmap d(a a10, Bitmap bitmap) {
        a10.o = bitmap;
        return bitmap;
    }

    public static /* synthetic */ Object e(a a10) {
        return a10.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        Object object = this.a;
        synchronized (object) {
            HandlerThread handlerThread = this.b;
            if (handlerThread != null) {
                return;
            }
            String string2 = "FrameSequence decoding thread";
            int n10 = 10;
            this.b = handlerThread = new HandlerThread(string2, n10);
            handlerThread.start();
            string2 = this.b;
            string2 = string2.getLooper();
            handlerThread = new Handler((Looper)string2);
            this.c = handlerThread;
            return;
        }
    }

    private void g() {
        boolean bl2 = this.m;
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot perform operation on recycled drawable");
        throw illegalStateException;
    }

    public static /* synthetic */ boolean h(a a10) {
        return a10.m;
    }

    public static /* synthetic */ int i(a a10) {
        return a10.u;
    }

    private void j() {
        int n10;
        this.p = n10 = 1;
        int n11 = this.u + n10;
        n10 = this.d.h();
        this.u = n11 %= n10;
        Handler handler = this.c;
        Runnable runnable = this.w;
        handler.post(runnable);
    }

    public static /* synthetic */ Bitmap k(a a10) {
        return a10.o;
    }

    public static /* synthetic */ FrameSequence$a m(a a10) {
        return a10.e;
    }

    public static /* synthetic */ int o(a a10) {
        return a10.p;
    }

    public static /* synthetic */ long p(a a10) {
        return a10.s;
    }

    public static /* synthetic */ a$g r(a a10) {
        return a10.z;
    }

    public static /* synthetic */ long s(a a10) {
        return a10.t;
    }

    public static /* synthetic */ a$e u(a a10) {
        return a10.l;
    }

    public static /* synthetic */ a$f v(a a10) {
        return a10.v;
    }

    public void A(a$g a$g) {
        this.z = a$g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void draw(Canvas canvas) {
        Object object;
        Object object2;
        float f10;
        int n10;
        float f11;
        int n11;
        Object object3 = this.k;
        synchronized (object3) {
            this.g();
            n11 = this.p;
            int n12 = 4;
            f11 = 5.6E-45f;
            n10 = 3;
            f10 = 4.2E-45f;
            long l10 = 0L;
            if (n11 == n10) {
                long l11 = this.t;
                long l12 = SystemClock.uptimeMillis();
                long l13 = (l11 -= l12) - l10;
                n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n11 <= 0) {
                    this.p = n12;
                }
            }
            if ((n11 = (int)(this.isRunning() ? 1 : 0)) != 0 && (n11 = this.p) == n12) {
                long l14;
                object2 = this.o;
                object = this.n;
                this.o = object;
                this.n = object2;
                object2 = this.h;
                object = this.g;
                this.h = object;
                this.g = object2;
                this.s = l14 = SystemClock.uptimeMillis();
                n11 = this.q;
                if (n11 == 0 && (n11 = this.u) == 0) {
                    object2 = this.x;
                    this.scheduleSelf((Runnable)object2, l10);
                }
                n11 = this.u;
                object = this.d;
                n12 = ((FrameSequence)object).h();
                int n13 = 1;
                if (n11 == (n12 -= n13)) {
                    this.q = n11 = this.q + n13;
                    n12 = this.r;
                    if (n12 == n13 && n11 == n13 || n12 == n10 && n11 == (n12 = ((FrameSequence)(object = this.d)).g())) {
                        n13 = 0;
                    }
                }
                if (n13 != 0) {
                    this.j();
                } else {
                    object2 = this.y;
                    this.scheduleSelf((Runnable)object2, l10);
                }
            }
        }
        int n14 = this.j;
        if (n14 != 0) {
            object3 = this.getBounds();
            object2 = this.f;
            object = this.g;
            object2.setShader((Shader)object);
            n11 = object3.width();
            float f12 = n11;
            n14 = object3.height();
            float f13 = n14;
            f11 = Math.min(f12, f13);
            n10 = 0x40000000;
            f10 = 2.0f;
            Paint paint = this.f;
            canvas.drawCircle(f12 /= f10, f13 /= f10, f11 /= f10, paint);
            return;
        }
        object3 = this.f;
        n11 = 0;
        float f14 = 0.0f;
        object3.setShader(null);
        object3 = this.n;
        object2 = this.i;
        object = this.getBounds();
        Paint paint = this.f;
        canvas.drawBitmap((Bitmap)object3, (Rect)object2, (Rect)object, paint);
    }

    public void finalize() {
        try {
            FrameSequence$a frameSequence$a = this.e;
            frameSequence$a.a();
            return;
        }
        finally {
            super.finalize();
        }
    }

    public int getIntrinsicHeight() {
        return this.d.i();
    }

    public int getIntrinsicWidth() {
        return this.d.j();
    }

    public int getOpacity() {
        FrameSequence frameSequence = this.d;
        int n10 = frameSequence.k();
        n10 = n10 != 0 ? -1 : -2;
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isRunning() {
        Object object = this.k;
        synchronized (object) {
            boolean bl2 = this.u;
            boolean bl3 = -1 != 0;
            if (bl2 <= bl3) return false;
            bl2 = this.m;
            if (bl2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void l() {
        Bitmap bitmap;
        Object object;
        Object object2 = this.l;
        if (object2 == null) {
            object2 = new IllegalStateException("BitmapProvider must be non-null");
            throw object2;
        }
        object2 = this.k;
        synchronized (object2) {
            this.g();
            object = this.n;
            this.n = null;
            int n10 = this.p;
            int n11 = 2;
            if (n10 != n11) {
                bitmap = this.o;
                this.o = null;
            } else {
                n10 = 0;
                bitmap = null;
            }
            n11 = 1;
            this.m = n11;
        }
        this.e.a();
        object2 = this.l;
        object2.b((Bitmap)object);
        if (bitmap != null) {
            object2 = this.l;
            object2.b(bitmap);
        }
        if ((object2 = this.b) != null) {
            object2.quit();
            this.b = null;
        }
        if ((object2 = this.c) != null) {
            object = this.w;
            object2.removeCallbacks((Runnable)object);
            this.w = null;
        }
        this.unscheduleSelf(this);
    }

    public int q() {
        FrameSequence frameSequence = this.d;
        if (frameSequence != null) {
            return frameSequence.h();
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        int n10;
        int n11 = this.m;
        if (n11 != 0) {
            return;
        }
        n11 = 0;
        Object var2_2 = null;
        Object object = this.k;
        // MONITORENTER : object
        int n12 = this.u;
        if (n12 >= 0 && (n12 = this.p) == (n10 = 3)) {
            this.p = n11 = 4;
            n11 = 1;
        }
        // MONITOREXIT : object
        if (n11 == 0) return;
        this.invalidateSelf();
    }

    public void setAlpha(int n10) {
        this.f.setAlpha(n10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f.setColorFilter(colorFilter);
    }

    public void setFilterBitmap(boolean bl2) {
        this.f.setFilterBitmap(bl2);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = super.setVisible(bl2, bl3);
        if (!bl2) {
            this.stop();
        } else if (bl3 || bl4) {
            this.stop();
            this.start();
        }
        return bl4;
    }

    public void start() {
        this.g();
        this.q = 0;
        this.j();
    }

    public void stop() {
        boolean bl2 = this.isRunning();
        if (bl2) {
            this.unscheduleSelf(this);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean t() {
        Object object = this.k;
        synchronized (object) {
            return this.m;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unscheduleSelf(Runnable runnable) {
        Object object = this.k;
        synchronized (object) {
            int n10;
            this.u = n10 = -1;
            n10 = 0;
            this.p = 0;
        }
        super.unscheduleSelf(runnable);
    }

    public void w(int n10) {
        this.d.l(n10);
    }

    public final void x(boolean bl2) {
        this.j = bl2;
        this.f.setAntiAlias(bl2);
    }

    public void y(int n10) {
        this.r = n10;
    }

    public void z(a$f a$f) {
        this.v = a$f;
    }
}

