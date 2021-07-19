/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.SystemClock
 */
package com.google.android.gms.internal.base;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import com.google.android.gms.internal.base.zag;
import com.google.android.gms.internal.base.zai;

public final class zae
extends Drawable
implements Drawable.Callback {
    private int mAlpha;
    private int mFrom;
    private boolean zamz;
    private int zanh;
    private long zani;
    private int zanj;
    private int zank;
    private int zanl;
    private boolean zanm;
    private zai zann;
    private Drawable zano;
    private Drawable zanp;
    private boolean zanq;
    private boolean zanr;
    private boolean zans;
    private int zant;

    public zae(Drawable object, Drawable drawable2) {
        int n10;
        int n11;
        int n12 = 0;
        zai zai2 = null;
        this(null);
        if (object == null) {
            object = zag.zacg();
        }
        this.zano = object;
        object.setCallback((Drawable.Callback)this);
        zai2 = this.zann;
        int n13 = zai2.zanw;
        zai2.zanw = n11 = object.getChangingConfigurations() | n13;
        if (drawable2 == null) {
            drawable2 = zag.zacg();
        }
        this.zanp = drawable2;
        drawable2.setCallback((Drawable.Callback)this);
        object = this.zann;
        n12 = object.zanw;
        object.zanw = n10 = drawable2.getChangingConfigurations() | n12;
    }

    public zae(zai zai2) {
        zai zai3;
        this.zanh = 0;
        this.zank = 255;
        this.mAlpha = 0;
        this.zamz = true;
        this.zann = zai3 = new zai(zai2);
    }

    private final boolean canConstantState() {
        boolean bl2 = this.zanq;
        if (!bl2) {
            Drawable.ConstantState constantState = this.zano.getConstantState();
            boolean bl3 = true;
            if (constantState != null && (constantState = this.zanp.getConstantState()) != null) {
                bl2 = bl3;
            } else {
                bl2 = false;
                constantState = null;
            }
            this.zanr = bl2;
            this.zanq = bl3;
        }
        return this.zanr;
    }

    public final void draw(Canvas canvas) {
        Drawable drawable2;
        int n10 = this.zanh;
        int n11 = 2;
        float f10 = 2.8E-45f;
        int n12 = 0;
        float f11 = 0.0f;
        int n13 = 1;
        float f12 = Float.MIN_VALUE;
        if (n10 != n13) {
            long l10;
            long l11;
            long l12;
            if (n10 == n11 && (n10 = (int)((l12 = (l11 = this.zani) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) >= 0) {
                l11 = SystemClock.uptimeMillis();
                l10 = this.zani;
                float f13 = l11 -= l10;
                f10 = this.zanl;
                f13 /= f10;
                n11 = 1065353216;
                f10 = 1.0f;
                float f14 = f13 - f10;
                Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                if (object < 0) {
                    n13 = 0;
                    drawable2 = null;
                    f12 = 0.0f;
                }
                if (n13 != 0) {
                    this.zanh = 0;
                }
                f13 = Math.min(f13, f10);
                n11 = 0;
                f10 = 0.0f;
                n12 = this.zanj;
                f11 = (float)n12 * f13 + 0.0f;
                this.mAlpha = n10 = (int)f11;
            }
            n12 = n13;
            f11 = f12;
        } else {
            long l13;
            this.zani = l13 = SystemClock.uptimeMillis();
            this.zanh = n11;
        }
        n10 = this.mAlpha;
        n11 = (int)(this.zamz ? 1 : 0);
        drawable2 = this.zano;
        Drawable drawable3 = this.zanp;
        if (n12 != 0) {
            if (n11 == 0 || n10 == 0) {
                drawable2.draw(canvas);
            }
            if (n10 == (n11 = this.zank)) {
                drawable3.setAlpha(n11);
                drawable3.draw(canvas);
            }
            return;
        }
        if (n11 != 0) {
            n12 = this.zank - n10;
            drawable2.setAlpha(n12);
        }
        drawable2.draw(canvas);
        if (n11 != 0) {
            n11 = this.zank;
            drawable2.setAlpha(n11);
        }
        if (n10 > 0) {
            drawable3.setAlpha(n10);
            drawable3.draw(canvas);
            int n14 = this.zank;
            drawable3.setAlpha(n14);
        }
        this.invalidateSelf();
    }

    public final int getChangingConfigurations() {
        int n10 = super.getChangingConfigurations();
        zai zai2 = this.zann;
        int n11 = zai2.mChangingConfigurations;
        int n12 = zai2.zanw;
        return (n10 |= n11) | n12;
    }

    public final Drawable.ConstantState getConstantState() {
        boolean bl2 = this.canConstantState();
        if (bl2) {
            int n10;
            zai zai2 = this.zann;
            zai2.mChangingConfigurations = n10 = this.getChangingConfigurations();
            return this.zann;
        }
        return null;
    }

    public final int getIntrinsicHeight() {
        int n10 = this.zano.getIntrinsicHeight();
        int n11 = this.zanp.getIntrinsicHeight();
        return Math.max(n10, n11);
    }

    public final int getIntrinsicWidth() {
        int n10 = this.zano.getIntrinsicWidth();
        int n11 = this.zanp.getIntrinsicWidth();
        return Math.max(n10, n11);
    }

    public final int getOpacity() {
        int n10 = this.zans;
        if (n10 == 0) {
            Drawable drawable2 = this.zano;
            n10 = drawable2.getOpacity();
            Drawable drawable3 = this.zanp;
            int n11 = drawable3.getOpacity();
            this.zant = n10 = Drawable.resolveOpacity((int)n10, (int)n11);
            n10 = 1;
            this.zans = n10;
        }
        return this.zant;
    }

    public final void invalidateDrawable(Drawable drawable2) {
        drawable2 = this.getCallback();
        if (drawable2 != null) {
            drawable2.invalidateDrawable((Drawable)this);
        }
    }

    public final Drawable mutate() {
        Object object;
        boolean bl2 = this.zanm;
        if (!bl2 && (object = super.mutate()) == this) {
            bl2 = this.canConstantState();
            if (bl2) {
                this.zano.mutate();
                object = this.zanp;
                object.mutate();
                this.zanm = bl2 = true;
            } else {
                object = new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
                throw object;
            }
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        this.zano.setBounds(rect);
        this.zanp.setBounds(rect);
    }

    public final void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        drawable2 = this.getCallback();
        if (drawable2 != null) {
            drawable2.scheduleDrawable((Drawable)this, runnable, l10);
        }
    }

    public final void setAlpha(int n10) {
        int n11 = this.mAlpha;
        int n12 = this.zank;
        if (n11 == n12) {
            this.mAlpha = n10;
        }
        this.zank = n10;
        this.invalidateSelf();
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.zano.setColorFilter(colorFilter);
        this.zanp.setColorFilter(colorFilter);
    }

    public final void startTransition(int n10) {
        int n11;
        this.mFrom = 0;
        this.zanj = n11 = this.zank;
        this.mAlpha = 0;
        this.zanl = 250;
        this.zanh = 1;
        this.invalidateSelf();
    }

    public final void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        drawable2 = this.getCallback();
        if (drawable2 != null) {
            drawable2.unscheduleDrawable((Drawable)this, runnable);
        }
    }

    public final Drawable zacf() {
        return this.zanp;
    }
}

