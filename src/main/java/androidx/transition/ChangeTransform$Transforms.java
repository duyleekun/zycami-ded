/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeTransform;

public class ChangeTransform$Transforms {
    public final float mRotationX;
    public final float mRotationY;
    public final float mRotationZ;
    public final float mScaleX;
    public final float mScaleY;
    public final float mTranslationX;
    public final float mTranslationY;
    public final float mTranslationZ;

    public ChangeTransform$Transforms(View view) {
        float f10;
        float f11;
        this.mTranslationX = f11 = view.getTranslationX();
        this.mTranslationY = f11 = view.getTranslationY();
        this.mTranslationZ = f11 = ViewCompat.getTranslationZ(view);
        this.mScaleX = f11 = view.getScaleX();
        this.mScaleY = f11 = view.getScaleY();
        this.mRotationX = f11 = view.getRotationX();
        this.mRotationY = f11 = view.getRotationY();
        this.mRotationZ = f10 = view.getRotation();
    }

    public boolean equals(Object object) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Object object2 = object instanceof ChangeTransform$Transforms;
        boolean bl2 = false;
        if (!object2) {
            return false;
        }
        object = (ChangeTransform$Transforms)object;
        float f19 = ((ChangeTransform$Transforms)object).mTranslationX;
        float f20 = this.mTranslationX;
        float f21 = f19 - f20;
        object2 = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
        if (!(object2 || (object2 = (f18 = (f19 = ((ChangeTransform$Transforms)object).mTranslationY) - (f20 = this.mTranslationY)) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1)) || (object2 = (f17 = (f19 = ((ChangeTransform$Transforms)object).mTranslationZ) - (f20 = this.mTranslationZ)) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1)) || (object2 = (f16 = (f19 = ((ChangeTransform$Transforms)object).mScaleX) - (f20 = this.mScaleX)) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) || (object2 = (f15 = (f19 = ((ChangeTransform$Transforms)object).mScaleY) - (f20 = this.mScaleY)) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) || (object2 = (f14 = (f19 = ((ChangeTransform$Transforms)object).mRotationX) - (f20 = this.mRotationX)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) || (object2 = (f13 = (f19 = ((ChangeTransform$Transforms)object).mRotationY) - (f20 = this.mRotationY)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) || (f12 = (f11 = (f10 = ((ChangeTransform$Transforms)object).mRotationZ) - (f19 = this.mRotationZ)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false)) {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        float f10 = this.mTranslationX;
        boolean bl2 = false;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        int n11 = 0;
        if (f12 != false) {
            n10 = Float.floatToIntBits(f10);
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        n10 *= 31;
        float f13 = this.mTranslationY;
        float f14 = f13 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (f15 != false) {
            f12 = Float.floatToIntBits(f13);
        } else {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        n10 = (n10 + f12) * 31;
        f13 = this.mTranslationZ;
        float f16 = f13 - 0.0f;
        f15 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (f15 != false) {
            f12 = Float.floatToIntBits(f13);
        } else {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        n10 = (n10 + f12) * 31;
        f13 = this.mScaleX;
        float f17 = f13 - 0.0f;
        f15 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
        if (f15 != false) {
            f12 = Float.floatToIntBits(f13);
        } else {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        n10 = (n10 + f12) * 31;
        f13 = this.mScaleY;
        float f18 = f13 - 0.0f;
        f15 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (f15 != false) {
            f12 = Float.floatToIntBits(f13);
        } else {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        n10 = (n10 + f12) * 31;
        f13 = this.mRotationX;
        float f19 = f13 - 0.0f;
        f15 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
        if (f15 != false) {
            f12 = Float.floatToIntBits(f13);
        } else {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        n10 = (n10 + f12) * 31;
        f13 = this.mRotationY;
        float f20 = f13 - 0.0f;
        f15 = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
        if (f15 != false) {
            f12 = Float.floatToIntBits(f13);
        } else {
            f12 = 0.0f;
            f13 = 0.0f;
        }
        n10 = (n10 + f12) * 31;
        f13 = this.mRotationZ;
        float f21 = f13 - 0.0f;
        bl2 = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
        if (bl2) {
            n11 = Float.floatToIntBits(f13);
        }
        return n10 + n11;
    }

    public void restore(View view) {
        float f10 = this.mTranslationX;
        float f11 = this.mTranslationY;
        float f12 = this.mTranslationZ;
        float f13 = this.mScaleX;
        float f14 = this.mScaleY;
        float f15 = this.mRotationX;
        float f16 = this.mRotationY;
        float f17 = this.mRotationZ;
        ChangeTransform.setTransforms(view, f10, f11, f12, f13, f14, f15, f16, f17);
    }
}

