/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.legacy.app;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.legacy.app.ActionBarDrawerToggle;

public class ActionBarDrawerToggle$SlideDrawable
extends InsetDrawable
implements Drawable.Callback {
    private final boolean mHasMirroring;
    private float mOffset;
    private float mPosition;
    private final Rect mTmpRect;
    public final /* synthetic */ ActionBarDrawerToggle this$0;

    public ActionBarDrawerToggle$SlideDrawable(ActionBarDrawerToggle actionBarDrawerToggle, Drawable drawable2) {
        this.this$0 = actionBarDrawerToggle;
        boolean bl2 = false;
        actionBarDrawerToggle = null;
        super(drawable2, 0);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 > n11) {
            bl2 = true;
        }
        this.mHasMirroring = bl2;
        super();
        this.mTmpRect = actionBarDrawerToggle;
    }

    public void draw(Canvas canvas) {
        float f10;
        Rect rect = this.mTmpRect;
        this.copyBounds(rect);
        canvas.save();
        rect = this.this$0.mActivity.getWindow().getDecorView();
        int n10 = ViewCompat.getLayoutDirection((View)rect);
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == n11) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            f10 = 0.0f;
            rect = null;
        }
        if (n10 != 0) {
            n11 = -1;
            f11 = 0.0f / 0.0f;
        }
        Rect rect2 = this.mTmpRect;
        int n12 = rect2.width();
        float f12 = -this.mOffset;
        float f13 = n12;
        f12 *= f13;
        float f14 = this.mPosition;
        f12 *= f14;
        f11 = n11;
        f12 *= f11;
        n11 = 0;
        f11 = 0.0f;
        canvas.translate(f12, 0.0f);
        if (n10 != 0 && (n10 = (int)(this.mHasMirroring ? 1 : 0)) == 0) {
            canvas.translate(f13, 0.0f);
            n10 = -1082130432;
            f10 = -1.0f;
            n11 = 1065353216;
            f11 = 1.0f;
            canvas.scale(f10, f11);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public float getPosition() {
        return this.mPosition;
    }

    public void setOffset(float f10) {
        this.mOffset = f10;
        this.invalidateSelf();
    }

    public void setPosition(float f10) {
        this.mPosition = f10;
        this.invalidateSelf();
    }
}

