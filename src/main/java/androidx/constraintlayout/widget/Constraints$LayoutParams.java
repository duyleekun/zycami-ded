/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.R$styleable;

public class Constraints$LayoutParams
extends ConstraintLayout$LayoutParams {
    public float alpha;
    public boolean applyElevation;
    public float elevation;
    public float rotation;
    public float rotationX;
    public float rotationY;
    public float scaleX;
    public float scaleY;
    public float transformPivotX;
    public float transformPivotY;
    public float translationX;
    public float translationY;
    public float translationZ;

    public Constraints$LayoutParams(int n10, int n11) {
        super(n10, n11);
        float f10;
        this.alpha = f10 = 1.0f;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = f10;
        this.scaleY = f10;
        this.transformPivotX = 0.0f;
        this.transformPivotY = 0.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
    }

    public Constraints$LayoutParams(Context context, AttributeSet attributeSet) {
        float f10;
        int n10 = Build.VERSION.SDK_INT;
        super(context, attributeSet);
        int n11 = 1065353216;
        this.alpha = f10 = 1.0f;
        this.applyElevation = false;
        int n12 = 0;
        float f11 = 0.0f;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = f10;
        this.scaleY = f10;
        this.transformPivotX = 0.0f;
        this.transformPivotY = 0.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        int[] nArray = R$styleable.ConstraintSet;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n13 = context.getIndexCount();
        for (int i10 = 0; i10 < n13; ++i10) {
            n11 = context.getIndex(i10);
            if (n11 == (n12 = R$styleable.ConstraintSet_android_alpha)) {
                f11 = this.alpha;
                this.alpha = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_elevation;
            int n14 = 21;
            if (n11 == n12) {
                if (n10 < n14) continue;
                f11 = this.elevation;
                this.elevation = f10 = context.getFloat(n11, f11);
                n11 = 1;
                f10 = Float.MIN_VALUE;
                this.applyElevation = n11;
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_rotationX;
            if (n11 == n12) {
                f11 = this.rotationX;
                this.rotationX = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_rotationY;
            if (n11 == n12) {
                f11 = this.rotationY;
                this.rotationY = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_rotation;
            if (n11 == n12) {
                f11 = this.rotation;
                this.rotation = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_scaleX;
            if (n11 == n12) {
                f11 = this.scaleX;
                this.scaleX = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_scaleY;
            if (n11 == n12) {
                f11 = this.scaleY;
                this.scaleY = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_transformPivotX;
            if (n11 == n12) {
                f11 = this.transformPivotX;
                this.transformPivotX = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_transformPivotY;
            if (n11 == n12) {
                f11 = this.transformPivotY;
                this.transformPivotY = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_translationX;
            if (n11 == n12) {
                f11 = this.translationX;
                this.translationX = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_translationY;
            if (n11 == n12) {
                f11 = this.translationY;
                this.translationY = f10 = context.getFloat(n11, f11);
                continue;
            }
            n12 = R$styleable.ConstraintSet_android_translationZ;
            if (n11 != n12 || n10 < n14) continue;
            f11 = this.translationZ;
            this.translationZ = f10 = context.getFloat(n11, f11);
        }
        context.recycle();
    }

    public Constraints$LayoutParams(Constraints$LayoutParams constraints$LayoutParams) {
        super(constraints$LayoutParams);
        float f10;
        this.alpha = f10 = 1.0f;
        this.applyElevation = false;
        this.elevation = 0.0f;
        this.rotation = 0.0f;
        this.rotationX = 0.0f;
        this.rotationY = 0.0f;
        this.scaleX = f10;
        this.scaleY = f10;
        this.transformPivotX = 0.0f;
        this.transformPivotY = 0.0f;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
    }
}

