/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.ColorFilter
 *  android.graphics.ColorMatrix
 *  android.graphics.ColorMatrixColorFilter
 *  android.widget.ImageView
 */
package androidx.constraintlayout.utils.widget;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;

public class ImageFilterView$ImageMatrix {
    public float[] m;
    public float mBrightness;
    public ColorMatrix mColorMatrix;
    public float mContrast;
    public float mSaturation;
    public ColorMatrix mTmpColorMatrix;
    public float mWarmth;

    public ImageFilterView$ImageMatrix() {
        float f10;
        Object object = new float[20];
        this.m = object;
        object = new ColorMatrix;
        this.mColorMatrix = (ColorMatrix)object;
        object = new ColorMatrix;
        super();
        this.mTmpColorMatrix = (ColorMatrix)object;
        this.mBrightness = f10 = 1.0f;
        this.mSaturation = f10;
        this.mContrast = f10;
        this.mWarmth = f10;
    }

    private void brightness(float f10) {
        float[] fArray = this.m;
        fArray[0] = f10;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = 0.0f;
        fArray[6] = f10;
        fArray[7] = 0.0f;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = 0.0f;
        fArray[11] = 0.0f;
        fArray[12] = f10;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 0.0f;
        fArray[17] = 0.0f;
        fArray[18] = 1.0f;
        fArray[19] = 0.0f;
    }

    private void saturation(float f10) {
        float f11;
        float f12 = 1.0f;
        float f13 = f12 - f10;
        float f14 = 0.2999f * f13;
        float f15 = 0.587f * f13;
        float[] fArray = this.m;
        fArray[0] = f11 = f14 + f10;
        fArray[1] = f15;
        fArray[2] = f13 *= 0.114f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = f14;
        fArray[6] = f11 = f15 + f10;
        fArray[7] = f13;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = f14;
        fArray[11] = f15;
        fArray[12] = f13 += f10;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 0.0f;
        fArray[17] = 0.0f;
        fArray[18] = f12;
        fArray[19] = 0.0f;
    }

    private void warmth(float f10) {
        float f11;
        double d10;
        float f12;
        float f13;
        int n10;
        float f14 = f10 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (f15 <= 0) {
            n10 = 1008981770;
            f10 = 0.01f;
        }
        f15 = 1167867904;
        float f16 = 5000.0f / f10 / 100.0f;
        n10 = 1115947008;
        f10 = 66.0f;
        float f17 = f16 == f10 ? 0 : (f16 > f10 ? 1 : -1);
        float f18 = 161.11957f;
        float f19 = 99.4708f;
        int n11 = 1132396544;
        float f20 = 255.0f;
        if (f17 > 0) {
            f17 = 1114636288;
            double d11 = f16 - 60.0f;
            f13 = (float)Math.pow(d11, -0.13320475816726685) * 329.69873f;
            f12 = 288.12216f;
            d10 = 0.07551484555006027;
            d11 = Math.pow(d11, d10);
            f11 = (float)d11 * f12;
        } else {
            double d12 = Math.log(f16);
            f11 = (float)d12 * f19 - f18;
            f17 = n11;
            f13 = f20;
        }
        n10 = f16 == f10 ? 0 : (f16 < f10 ? -1 : 1);
        f12 = 305.0448f;
        float f21 = 138.51773f;
        if (n10 < 0) {
            f10 = 19.0f;
            float f22 = f16 - f10;
            n10 = f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1);
            if (n10 > 0) {
                n10 = 1092616192;
                d10 = Math.log(f16 -= 10.0f);
                f10 = (float)d10 * f21 - f12;
            } else {
                n10 = 0;
                f10 = 0.0f;
            }
        } else {
            n10 = n11;
            f10 = f20;
        }
        f16 = Math.max(f13, 0.0f);
        f16 = Math.min(f20, f16);
        f13 = Math.max(f11, 0.0f);
        f13 = Math.min(f20, f13);
        f10 = Math.max(f10, 0.0f);
        f10 = Math.min(f20, f10);
        f11 = (float)Math.log(50.0f) * f19 - f18;
        f18 = (float)Math.log(40.0f) * f21 - f12;
        f19 = Math.max(f20, 0.0f);
        f19 = Math.min(f20, f19);
        f12 = Math.max(f11, 0.0f);
        f12 = Math.min(f20, f12);
        f18 = Math.max(f18, 0.0f);
        f18 = Math.min(f20, f18);
        float[] fArray = this.m;
        fArray[0] = f16 /= f19;
        fArray[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray[5] = 0.0f;
        fArray[6] = f13 /= f12;
        fArray[7] = 0.0f;
        fArray[8] = 0.0f;
        fArray[9] = 0.0f;
        fArray[10] = 0.0f;
        fArray[11] = 0.0f;
        fArray[12] = f10 /= f18;
        fArray[13] = 0.0f;
        fArray[14] = 0.0f;
        fArray[15] = 0.0f;
        fArray[16] = 0.0f;
        fArray[17] = 0.0f;
        fArray[18] = 1.0f;
        fArray[19] = 0.0f;
    }

    public void updateMatrix(ImageView imageView) {
        Object object;
        float f10;
        float f11;
        boolean bl2;
        Object object2;
        ColorMatrix colorMatrix = this.mColorMatrix;
        colorMatrix.reset();
        float f12 = this.mSaturation;
        int n10 = 1065353216;
        float f13 = 1.0f;
        float f14 = f12 == f13 ? 0 : (f12 > f13 ? 1 : -1);
        boolean bl3 = true;
        float f15 = Float.MIN_VALUE;
        if (f14 != false) {
            this.saturation(f12);
            colorMatrix = this.mColorMatrix;
            object2 = this.m;
            colorMatrix.set(object2);
            bl2 = bl3;
            f12 = f15;
        } else {
            bl2 = false;
            f12 = 0.0f;
            colorMatrix = null;
        }
        float f16 = this.mContrast;
        float f17 = f16 == f13 ? 0 : (f16 > f13 ? 1 : -1);
        if (f17 != false) {
            this.mTmpColorMatrix.setScale(f16, f16, f16, f13);
            colorMatrix = this.mColorMatrix;
            object2 = this.mTmpColorMatrix;
            colorMatrix.postConcat((ColorMatrix)object2);
            bl2 = bl3;
            f12 = f15;
        }
        if ((f17 = (f11 = (f16 = this.mWarmth) - f13) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            this.warmth(f16);
            colorMatrix = this.mTmpColorMatrix;
            object2 = this.m;
            colorMatrix.set(object2);
            colorMatrix = this.mColorMatrix;
            object2 = this.mTmpColorMatrix;
            colorMatrix.postConcat((ColorMatrix)object2);
            bl2 = bl3;
            f12 = f15;
        }
        if ((n10 = (int)((f10 = (f16 = this.mBrightness) - f13) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) != 0) {
            this.brightness(f16);
            colorMatrix = this.mTmpColorMatrix;
            object = this.m;
            colorMatrix.set(object);
            colorMatrix = this.mColorMatrix;
            object = this.mTmpColorMatrix;
            colorMatrix.postConcat((ColorMatrix)object);
        } else {
            bl3 = bl2;
            f15 = f12;
        }
        if (bl3) {
            object = this.mColorMatrix;
            colorMatrix = new ColorMatrixColorFilter((ColorMatrix)object);
            imageView.setColorFilter((ColorFilter)colorMatrix);
        } else {
            imageView.clearColorFilter();
        }
    }
}

