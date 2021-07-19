/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.view.Gravity
 */
package d.c.a.n.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import d.c.a.c;
import d.c.a.n.a.d.i;
import d.c.a.n.a.d.k$a;
import d.c.a.n.a.d.o;
import d.c.a.n.a.d.o$b;
import d.c.a.o.k.x.e;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class k
extends Drawable
implements o$b,
Animatable,
Animatable2Compat {
    public static final int l = 255;
    public static final int m = 0;
    private static final int n = 119;
    private final k$a a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private boolean h;
    private Paint i;
    private Rect j;
    private List k;

    public k(Context context, i i10, e e10, d.c.a.o.i i11, int n10, int n11, Bitmap bitmap) {
        c c10 = d.c.a.c.d(context);
        o o10 = new o(c10, i10, n10, n11, i11, bitmap);
        k$a k$a = new k$a(e10, o10);
        this(k$a);
    }

    public k(k$a k$a) {
        int n10;
        boolean bl2;
        this.e = bl2 = true;
        this.g = n10 = -1;
        this.e = bl2;
        this.g = n10;
        this.a = k$a = (k$a)((Object)d.c.a.u.k.d((Object)k$a));
    }

    public k(o o10, e e10, Paint paint) {
        k$a k$a = new k$a(e10, o10);
        this(k$a);
        this.i = paint;
    }

    private Drawable.Callback b() {
        boolean bl2;
        Drawable.Callback callback = this.getCallback();
        while (bl2 = callback instanceof Drawable) {
            callback = ((Drawable)callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        Rect rect = this.j;
        if (rect == null) {
            this.j = rect = new Rect();
        }
        return this.j;
    }

    private Paint k() {
        Paint paint = this.i;
        if (paint == null) {
            int n10 = 2;
            this.i = paint = new Paint(n10);
        }
        return this.i;
    }

    private void n() {
        List list = this.k;
        if (list != null) {
            int n10 = list.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback = (Animatable2Compat$AnimationCallback)this.k.get(i10);
                animatable2Compat$AnimationCallback.onAnimationEnd(this);
            }
        }
    }

    private void p() {
        this.f = 0;
    }

    private void u() {
        int n10 = this.d;
        int n11 = 1;
        String string2 = "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.";
        d.c.a.u.k.a((n10 ^= n11) != 0, string2);
        o o10 = this.a.b;
        n10 = o10.f();
        if (n10 == n11) {
            this.invalidateSelf();
        } else {
            n10 = (int)(this.b ? 1 : 0);
            if (n10 == 0) {
                this.b = n11;
                o10 = this.a.b;
                o10.w(this);
                this.invalidateSelf();
            }
        }
    }

    private void v() {
        this.b = false;
        this.a.b.x(this);
    }

    public void a() {
        Drawable.Callback callback = this.b();
        if (callback == null) {
            this.stop();
            this.invalidateSelf();
            return;
        }
        this.invalidateSelf();
        int n10 = this.g();
        int n11 = this.f() + -1;
        if (n10 == n11) {
            this.f = n10 = this.f + 1;
        }
        if ((n10 = this.g) != (n11 = -1) && (n11 = this.f) >= n10) {
            this.n();
            this.stop();
        }
    }

    public ByteBuffer c() {
        return this.a.b.b();
    }

    public void clearAnimationCallbacks() {
        List list = this.k;
        if (list != null) {
            list.clear();
        }
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap;
        Rect rect;
        boolean bl2 = this.m();
        if (bl2) {
            return;
        }
        bl2 = this.h;
        if (bl2) {
            int n10 = this.getIntrinsicWidth();
            int n11 = this.getIntrinsicHeight();
            rect = this.getBounds();
            Rect rect2 = this.d();
            Gravity.apply((int)119, (int)n10, (int)n11, (Rect)rect, (Rect)rect2);
            bl2 = false;
            bitmap = null;
            this.h = false;
        }
        bitmap = this.a.b.c();
        Rect rect3 = this.d();
        rect = this.k();
        canvas.drawBitmap(bitmap, null, rect3, (Paint)rect);
    }

    public Bitmap e() {
        return this.a.b.e();
    }

    public int f() {
        return this.a.b.f();
    }

    public int g() {
        return this.a.b.d();
    }

    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    public int getIntrinsicHeight() {
        return this.a.b.j();
    }

    public int getIntrinsicWidth() {
        return this.a.b.n();
    }

    public int getOpacity() {
        return -2;
    }

    public d.c.a.o.i h() {
        return this.a.b.i();
    }

    public int i() {
        return this.a.b.k();
    }

    public boolean isRunning() {
        return this.b;
    }

    public int j() {
        return this.g;
    }

    public int l() {
        return this.a.b.m();
    }

    public boolean m() {
        return this.d;
    }

    public void o() {
        this.d = true;
        this.a.b.a();
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.h = true;
    }

    public void q(d.c.a.o.i i10, Bitmap bitmap) {
        this.a.b.r(i10, bitmap);
    }

    public void r(boolean bl2) {
    }

    public void registerAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        if (animatable2Compat$AnimationCallback == null) {
            return;
        }
        ArrayList arrayList = this.k;
        if (arrayList == null) {
            this.k = arrayList = new ArrayList();
        }
        this.k.add(animatable2Compat$AnimationCallback);
    }

    public void s(int n10) {
        int n11 = -1;
        if (n10 <= 0 && n10 != n11 && n10 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Loop count must be greater than 0, or equal to LOOP_FOREVER, or equal to LOOP_INTRINSIC");
            throw illegalArgumentException;
        }
        if (n10 == 0) {
            o o10 = this.a.b;
            n10 = o10.k();
            if (n10 != 0) {
                n11 = n10;
            }
            this.g = n11;
        } else {
            this.g = n10;
        }
    }

    public void setAlpha(int n10) {
        this.k().setAlpha(n10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.k().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = this.d ^ true;
        String string2 = "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.";
        d.c.a.u.k.a(bl4, string2);
        this.e = bl2;
        if (!bl2) {
            this.v();
        } else {
            bl4 = this.c;
            if (bl4) {
                this.u();
            }
        }
        return super.setVisible(bl2, bl3);
    }

    public void start() {
        this.c = true;
        this.p();
        boolean bl2 = this.e;
        if (bl2) {
            this.u();
        }
    }

    public void stop() {
        this.c = false;
        this.v();
    }

    public void t() {
        d.c.a.u.k.a(this.b ^ true, "You cannot restart a currently running animation.");
        this.a.b.s();
        this.start();
    }

    public boolean unregisterAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        List list = this.k;
        if (list != null && animatable2Compat$AnimationCallback != null) {
            return list.remove(animatable2Compat$AnimationCallback);
        }
        return false;
    }
}

