/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Paint
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.OvalShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  android.widget.ImageView
 */
package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

public class CircleImageView
extends ImageView {
    private static final int FILL_SHADOW_COLOR = 0x3D000000;
    private static final int KEY_SHADOW_COLOR = 0x1E000000;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation.AnimationListener mListener;
    public int mShadowRadius;

    public CircleImageView(Context object, int n10) {
        super(object);
        ShapeDrawable shapeDrawable;
        int n11;
        object = this.getContext().getResources().getDisplayMetrics();
        float f10 = object.density;
        float f11 = 1.75f * f10;
        int n12 = (int)f11;
        OvalShape ovalShape = null;
        float f12 = 0.0f * f10;
        int n13 = (int)f12;
        float f13 = 3.5f * f10;
        this.mShadowRadius = n11 = (int)f13;
        n11 = (int)(this.elevationSupported() ? 1 : 0);
        if (n11 != 0) {
            ovalShape = new OvalShape();
            shapeDrawable = new ShapeDrawable((Shape)ovalShape);
            n13 = 0x40800000;
            f12 = 4.0f;
            ViewCompat.setElevation((View)this, f10 *= f12);
        } else {
            n11 = this.mShadowRadius;
            super(this, n11);
            ShapeDrawable shapeDrawable2 = new ShapeDrawable((Shape)object);
            f10 = Float.MIN_VALUE;
            Paint paint = shapeDrawable2.getPaint();
            this.setLayerType(1, paint);
            object = shapeDrawable2.getPaint();
            int n14 = this.mShadowRadius;
            float f14 = n14;
            f12 = n13;
            f11 = n12;
            int n15 = 0x1E000000;
            object.setShadowLayer(f14, f12, f11, n15);
            int n16 = this.mShadowRadius;
            this.setPadding(n16, n16, n16, n16);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(n10);
        ViewCompat.setBackground((View)this, (Drawable)shapeDrawable);
    }

    private boolean elevationSupported() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Animation animation = this.getAnimation();
            animationListener.onAnimationEnd(animation);
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.mListener;
        if (animationListener != null) {
            Animation animation = this.getAnimation();
            animationListener.onAnimationStart(animation);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        n10 = (int)(this.elevationSupported() ? 1 : 0);
        if (n10 == 0) {
            n10 = this.getMeasuredWidth();
            n11 = this.mShadowRadius * 2;
            n10 += n11;
            n11 = this.getMeasuredHeight();
            int n12 = this.mShadowRadius * 2;
            this.setMeasuredDimension(n10, n11 += n12);
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mListener = animationListener;
    }

    public void setBackgroundColor(int n10) {
        Drawable drawable2 = this.getBackground();
        boolean bl2 = drawable2 instanceof ShapeDrawable;
        if (bl2) {
            drawable2 = ((ShapeDrawable)this.getBackground()).getPaint();
            drawable2.setColor(n10);
        }
    }

    public void setBackgroundColorRes(int n10) {
        n10 = ContextCompat.getColor(this.getContext(), n10);
        this.setBackgroundColor(n10);
    }
}

