/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.ViewOutlineProvider
 */
package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.utils.widget.ImageFilterView$1;
import androidx.constraintlayout.utils.widget.ImageFilterView$2;
import androidx.constraintlayout.utils.widget.ImageFilterView$ImageMatrix;
import androidx.constraintlayout.widget.R$styleable;

public class ImageFilterView
extends AppCompatImageView {
    private float mCrossfade;
    private ImageFilterView$ImageMatrix mImageMatrix;
    public LayerDrawable mLayer;
    public Drawable[] mLayers;
    private boolean mOverlay;
    private Path mPath;
    public RectF mRect;
    private float mRound;
    private float mRoundPercent;
    public ViewOutlineProvider mViewOutlineProvider;

    public ImageFilterView(Context context) {
        super(context);
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix;
        this.mImageMatrix = imageFilterView$ImageMatrix = new ImageFilterView$ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = 0.0f / 0.0f;
        this.init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix;
        this.mImageMatrix = imageFilterView$ImageMatrix = new ImageFilterView$ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = 0.0f / 0.0f;
        this.init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix;
        this.mImageMatrix = imageFilterView$ImageMatrix = new ImageFilterView$ImageMatrix();
        this.mOverlay = true;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = 0.0f / 0.0f;
        this.init(context, attributeSet);
    }

    public static /* synthetic */ float access$000(ImageFilterView imageFilterView) {
        return imageFilterView.mRoundPercent;
    }

    public static /* synthetic */ float access$100(ImageFilterView imageFilterView) {
        return imageFilterView.mRound;
    }

    private void init(Context layerDrawable, AttributeSet attributeSet) {
        int n10 = Build.VERSION.SDK_INT;
        if (attributeSet != null) {
            Drawable[] drawableArray = this.getContext();
            Object object = R$styleable.ImageFilterView;
            attributeSet = drawableArray.obtainStyledAttributes(attributeSet, object);
            int n11 = attributeSet.getIndexCount();
            int n12 = R$styleable.ImageFilterView_altSrc;
            object = attributeSet.getDrawable(n12);
            for (int i10 = 0; i10 < n11; ++i10) {
                float f10;
                int n13;
                int n14 = attributeSet.getIndex(i10);
                if (n14 == (n13 = R$styleable.ImageFilterView_crossfade)) {
                    this.mCrossfade = f10 = attributeSet.getFloat(n14, 0.0f);
                    continue;
                }
                n13 = R$styleable.ImageFilterView_warmth;
                if (n14 == n13) {
                    f10 = attributeSet.getFloat(n14, 0.0f);
                    this.setWarmth(f10);
                    continue;
                }
                n13 = R$styleable.ImageFilterView_saturation;
                if (n14 == n13) {
                    f10 = attributeSet.getFloat(n14, 0.0f);
                    this.setSaturation(f10);
                    continue;
                }
                n13 = R$styleable.ImageFilterView_contrast;
                if (n14 == n13) {
                    f10 = attributeSet.getFloat(n14, 0.0f);
                    this.setContrast(f10);
                    continue;
                }
                n13 = R$styleable.ImageFilterView_round;
                int n15 = 21;
                if (n14 == n13) {
                    if (n10 < n15) continue;
                    f10 = attributeSet.getDimension(n14, 0.0f);
                    this.setRound(f10);
                    continue;
                }
                n13 = R$styleable.ImageFilterView_roundPercent;
                if (n14 == n13) {
                    if (n10 < n15) continue;
                    f10 = attributeSet.getFloat(n14, 0.0f);
                    this.setRoundPercent(f10);
                    continue;
                }
                n13 = R$styleable.ImageFilterView_overlay;
                if (n14 != n13) continue;
                n13 = (int)(this.mOverlay ? 1 : 0);
                n14 = (int)(attributeSet.getBoolean(n14, n13 != 0) ? 1 : 0);
                this.setOverlay(n14 != 0);
            }
            attributeSet.recycle();
            if (object != null) {
                n10 = 2;
                layerDrawable = new Drawable[n10];
                this.mLayers = layerDrawable;
                attributeSet = this.getDrawable();
                layerDrawable[0] = attributeSet;
                layerDrawable = this.mLayers;
                int n16 = 1;
                layerDrawable[n16] = (Drawable)object;
                drawableArray = this.mLayers;
                this.mLayer = layerDrawable = new LayerDrawable(drawableArray);
                layerDrawable = layerDrawable.getDrawable(n16);
                float f11 = 255.0f;
                float f12 = this.mCrossfade * f11;
                n16 = (int)f12;
                layerDrawable.setAlpha(n16);
                layerDrawable = this.mLayer;
                super.setImageDrawable((Drawable)layerDrawable);
            }
        }
    }

    private void setOverlay(boolean bl2) {
        this.mOverlay = bl2;
    }

    /*
     * Unable to fully structure code
     */
    public void draw(Canvas var1_1) {
        var2_2 = Build.VERSION.SDK_INT;
        var3_3 = 21;
        if (var2_2 >= var3_3) ** GOTO lbl-1000
        var4_4 = this.mRoundPercent;
        var3_3 = 0;
        var5_5 = null;
        cfr_temp_0 = var4_4 - 0.0f;
        var2_2 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
        if (var2_2 != 0 && (var6_6 = this.mPath) != null) {
            var2_2 = 1;
            var4_4 = 1.4E-45f;
            var1_1.save();
            var5_5 = this.mPath;
            var1_1.clipPath(var5_5);
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = 0;
            var4_4 = 0.0f;
            var6_6 = null;
        }
        super.draw(var1_1);
        if (var2_2 != 0) {
            var1_1.restore();
        }
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    public void setBrightness(float f10) {
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix = this.mImageMatrix;
        imageFilterView$ImageMatrix.mBrightness = f10;
        imageFilterView$ImageMatrix.updateMatrix(this);
    }

    public void setContrast(float f10) {
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix = this.mImageMatrix;
        imageFilterView$ImageMatrix.mContrast = f10;
        imageFilterView$ImageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f10) {
        this.mCrossfade = f10;
        LayerDrawable layerDrawable = this.mLayers;
        if (layerDrawable != null) {
            int n10;
            float f11;
            boolean bl2 = this.mOverlay;
            int n11 = 1132396544;
            float f12 = 255.0f;
            if (!bl2) {
                layerDrawable = this.mLayer.getDrawable(0);
                float f13 = this.mCrossfade;
                f11 = (1.0f - f13) * f12;
                n10 = (int)f11;
                layerDrawable.setAlpha(n10);
            }
            layerDrawable = this.mLayer;
            n10 = 1;
            layerDrawable = layerDrawable.getDrawable(n10);
            f11 = this.mCrossfade * f12;
            n11 = (int)f11;
            layerDrawable.setAlpha(n11);
            layerDrawable = this.mLayer;
            super.setImageDrawable((Drawable)layerDrawable);
        }
    }

    public void setRound(float f10) {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = Float.isNaN(f10);
        if (bl2) {
            this.mRound = f10;
            f10 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            this.setRoundPercent(f10);
            return;
        }
        float f11 = this.mRound;
        bl2 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
        boolean bl3 = true;
        float f12 = Float.MIN_VALUE;
        float f13 = 0.0f;
        RectF rectF = null;
        if (bl2) {
            bl2 = bl3;
            f11 = f12;
        } else {
            bl2 = false;
            f11 = 0.0f;
        }
        this.mRound = f10;
        Path.Direction direction = null;
        float f14 = f10 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        int n11 = 21;
        if (f15 != false) {
            Object object = this.mPath;
            if (object == null) {
                this.mPath = object = new Path();
            }
            if ((object = this.mRect) == null) {
                object = new RectF();
                this.mRect = object;
            }
            if (n10 >= n11) {
                object = this.mViewOutlineProvider;
                if (object == null) {
                    object = new ImageFilterView$2(this);
                    this.mViewOutlineProvider = object;
                    this.setOutlineProvider((ViewOutlineProvider)object);
                }
                this.setClipToOutline(bl3);
            }
            f15 = this.getWidth();
            int n12 = this.getHeight();
            rectF = this.mRect;
            f10 = f15;
            f12 = n12;
            rectF.set(0.0f, 0.0f, f10, f12);
            this.mPath.reset();
            object = this.mPath;
            RectF rectF2 = this.mRect;
            f13 = this.mRound;
            direction = Path.Direction.CW;
            object.addRoundRect(rectF2, f13, f13, direction);
        } else if (n10 >= n11) {
            this.setClipToOutline(false);
        }
        if (bl2 && n10 >= n11) {
            this.invalidateOutline();
        }
    }

    public void setRoundPercent(float f10) {
        int n10 = Build.VERSION.SDK_INT;
        float f11 = this.mRoundPercent;
        float f12 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
        int n11 = 1;
        float f13 = Float.MIN_VALUE;
        int n12 = 0;
        float f14 = 0.0f;
        if (f12 != false) {
            f12 = n11;
            f11 = f13;
        } else {
            f12 = 0.0f;
            f11 = 0.0f;
        }
        this.mRoundPercent = f10;
        Path.Direction direction = null;
        float f15 = f10 - 0.0f;
        float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        int n13 = 21;
        if (f16 != false) {
            Object object = this.mPath;
            if (object == null) {
                this.mPath = object = new Path();
            }
            if ((object = this.mRect) == null) {
                object = new RectF();
                this.mRect = object;
            }
            if (n10 >= n13) {
                object = this.mViewOutlineProvider;
                if (object == null) {
                    object = new ImageFilterView$1(this);
                    this.mViewOutlineProvider = object;
                    this.setOutlineProvider((ViewOutlineProvider)object);
                }
                this.setClipToOutline(n11 != 0);
            }
            f16 = this.getWidth();
            n11 = this.getHeight();
            n12 = Math.min((int)f16, n11);
            f14 = n12;
            float f17 = this.mRoundPercent;
            f14 *= f17;
            f17 = 2.0f;
            RectF rectF = this.mRect;
            f10 = f16;
            f13 = n11;
            rectF.set(0.0f, 0.0f, f10, f13);
            this.mPath.reset();
            object = this.mPath;
            RectF rectF2 = this.mRect;
            direction = Path.Direction.CW;
            object.addRoundRect(rectF2, f14 /= f17, f14, direction);
        } else if (n10 >= n13) {
            this.setClipToOutline(false);
        }
        if (f12 != false && n10 >= n13) {
            this.invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix = this.mImageMatrix;
        imageFilterView$ImageMatrix.mSaturation = f10;
        imageFilterView$ImageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f10) {
        ImageFilterView$ImageMatrix imageFilterView$ImageMatrix = this.mImageMatrix;
        imageFilterView$ImageMatrix.mWarmth = f10;
        imageFilterView$ImageMatrix.updateMatrix(this);
    }
}

