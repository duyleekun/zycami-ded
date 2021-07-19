/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Size
 *  android.util.SizeF
 *  android.view.TextureView
 *  android.view.View
 */
package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.util.SizeF;
import android.view.TextureView;
import android.view.View;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.view.PreviewTransformation$1;
import androidx.camera.view.PreviewView$ScaleType;
import androidx.camera.view.TransformUtils;
import androidx.core.util.Preconditions;

public final class PreviewTransformation {
    private static final PreviewView$ScaleType DEFAULT_SCALE_TYPE = PreviewView$ScaleType.FILL_CENTER;
    private static final String TAG = "PreviewTransform";
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView$ScaleType mScaleType;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;

    public PreviewTransformation() {
        PreviewView$ScaleType previewView$ScaleType;
        this.mScaleType = previewView$ScaleType = DEFAULT_SCALE_TYPE;
    }

    private static RectF flipHorizontally(RectF rectF, float f10) {
        f10 += f10;
        float f11 = rectF.right;
        f11 = f10 - f11;
        float f12 = rectF.top;
        float f13 = rectF.left;
        float f14 = rectF.bottom;
        RectF rectF2 = new RectF(f11, f12, f10 -= f13, f14);
        return rectF2;
    }

    private SizeF getRotatedCropRectSize() {
        Rect rect = this.mSurfaceCropRect;
        Preconditions.checkNotNull(rect);
        boolean bl2 = TransformUtils.is90or270(this.mPreviewRotationDegrees);
        if (bl2) {
            float f10 = this.mSurfaceCropRect.height();
            float f11 = this.mSurfaceCropRect.width();
            rect = new SizeF(f10, f11);
            return rect;
        }
        float f12 = this.mSurfaceCropRect.width();
        float f13 = this.mSurfaceCropRect.height();
        rect = new SizeF(f12, f13);
        return rect;
    }

    private Matrix getSurfaceToPreviewViewMatrix(Size object, int n10) {
        boolean bl2 = this.isTransformationInfoReady();
        Preconditions.checkState(bl2);
        Matrix matrix = new Matrix();
        int n11 = this.isCropRectAspectRatioMatchPreviewView((Size)object);
        object = n11 != 0 ? (Object)TransformUtils.sizeToVertices((Size)object) : (Object)TransformUtils.rectToVertices(this.getPreviewViewCropRectForMismatchedAspectRatios((Size)object, n10));
        n10 = this.mPreviewRotationDegrees;
        float[] fArray = TransformUtils.createRotatedVertices((float[])object, n10);
        Rect rect = this.mSurfaceCropRect;
        object = new RectF(rect);
        Object object2 = TransformUtils.rectToVertices((RectF)object);
        int n12 = 4;
        matrix.setPolyToPoly(object2, 0, fArray, 0, n12);
        int n13 = this.mIsFrontCamera;
        if (n13 != 0) {
            n13 = TransformUtils.is90or270(this.mPreviewRotationDegrees);
            n10 = 1065353216;
            float f10 = 1.0f;
            n11 = -1082130432;
            float f11 = -1.0f;
            if (n13 != 0) {
                object = this.mSurfaceCropRect;
                n13 = object.centerX();
                float f12 = n13;
                object2 = this.mSurfaceCropRect;
                int n14 = object2.centerY();
                float f13 = n14;
                matrix.preScale(f10, f11, f12, f13);
            } else {
                object = this.mSurfaceCropRect;
                n13 = object.centerX();
                float f14 = n13;
                object2 = this.mSurfaceCropRect;
                int n15 = object2.centerY();
                float f15 = n15;
                matrix.preScale(f11, f10, f14, f15);
            }
        }
        return matrix;
    }

    private RectF getTransformedSurfaceRect(Size size, int n10) {
        Preconditions.checkState(this.isTransformationInfoReady());
        size = this.getSurfaceToPreviewViewMatrix(size, n10);
        float[] fArray = TransformUtils.sizeToVertices(this.mResolution);
        size.mapPoints(fArray);
        return TransformUtils.verticesToRect(fArray);
    }

    private boolean isTransformationInfoReady() {
        boolean bl2;
        Rect rect = this.mSurfaceCropRect;
        if (rect != null && (rect = this.mResolution) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            rect = null;
        }
        return bl2;
    }

    private static void setMatrixRectToRect(Matrix matrix, RectF rectF, RectF rectF2, PreviewView$ScaleType previewView$ScaleType) {
        boolean bl2;
        Object object;
        Object object2 = PreviewTransformation$1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType;
        int n10 = previewView$ScaleType.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append("Unexpected crop rect: ");
                ((StringBuilder)object2).append((Object)previewView$ScaleType);
                object2 = ((StringBuilder)object2).toString();
                object = TAG;
                Logger.e((String)object, (String)object2);
                object2 = Matrix.ScaleToFit.FILL;
                break;
            }
            case 5: 
            case 6: {
                object2 = Matrix.ScaleToFit.START;
                break;
            }
            case 3: 
            case 4: {
                object2 = Matrix.ScaleToFit.END;
                break;
            }
            case 1: 
            case 2: {
                object2 = Matrix.ScaleToFit.CENTER;
            }
        }
        object = PreviewView$ScaleType.FIT_CENTER;
        if (previewView$ScaleType != object && previewView$ScaleType != (object = PreviewView$ScaleType.FIT_START) && previewView$ScaleType != (object = PreviewView$ScaleType.FIT_END)) {
            bl2 = false;
            previewView$ScaleType = null;
        } else {
            bl2 = true;
        }
        if (bl2) {
            matrix.setRectToRect(rectF, rectF2, (Matrix.ScaleToFit)object2);
        } else {
            matrix.setRectToRect(rectF2, rectF, (Matrix.ScaleToFit)object2);
            matrix.invert(matrix);
        }
    }

    public Bitmap createTransformedBitmap(Bitmap bitmap, Size size, int n10) {
        boolean bl2 = this.isTransformationInfoReady();
        if (!bl2) {
            return bitmap;
        }
        Matrix matrix = this.getTextureViewCorrectionMatrix();
        RectF rectF = this.getTransformedSurfaceRect(size, n10);
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        size = Bitmap.createBitmap((int)n11, (int)n12, (Bitmap.Config)config);
        Canvas canvas = new Canvas((Bitmap)size);
        config = new Matrix();
        config.postConcat(matrix);
        float f10 = rectF.width();
        float f11 = this.mResolution.getWidth();
        f10 /= f11;
        f11 = rectF.height();
        float f12 = this.mResolution.getHeight();
        config.postScale(f10, f11 /= f12);
        f10 = rectF.left;
        float f13 = rectF.top;
        config.postTranslate(f10, f13);
        rectF = new Paint(7);
        canvas.drawBitmap(bitmap, (Matrix)config, (Paint)rectF);
        return size;
    }

    public RectF getPreviewViewCropRectForMismatchedAspectRatios(Size size, int n10) {
        int n11 = size.getWidth();
        float f10 = n11;
        int n12 = size.getHeight();
        float f11 = n12;
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        SizeF sizeF = this.getRotatedCropRectSize();
        float f12 = sizeF.getWidth();
        f10 = sizeF.getHeight();
        RectF rectF2 = new RectF(0.0f, 0.0f, f12, f10);
        sizeF = new Matrix();
        PreviewView$ScaleType previewView$ScaleType = this.mScaleType;
        PreviewTransformation.setMatrixRectToRect((Matrix)sizeF, rectF2, rectF, previewView$ScaleType);
        sizeF.mapRect(rectF2);
        int n13 = 1;
        if (n10 == n13) {
            float f13 = (float)size.getWidth() / 2.0f;
            return PreviewTransformation.flipHorizontally(rectF2, f13);
        }
        return rectF2;
    }

    public Matrix getPreviewViewToNormalizedSurfaceMatrix(Size size, int n10) {
        boolean bl2 = this.isTransformationInfoReady();
        if (!bl2) {
            return null;
        }
        Matrix matrix = new Matrix();
        this.getSurfaceToPreviewViewMatrix(size, n10).invert(matrix);
        size = new Matrix();
        float f10 = this.mResolution.getWidth();
        float f11 = this.mResolution.getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        f11 = 1.0f;
        RectF rectF2 = new RectF(0.0f, 0.0f, f11, f11);
        Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.FILL;
        size.setRectToRect(rectF, rectF2, scaleToFit);
        matrix.postConcat((Matrix)size);
        return matrix;
    }

    public PreviewView$ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(this.isTransformationInfoReady());
        Matrix matrix = new Matrix();
        float[] fArray = TransformUtils.sizeToVertices(this.mResolution);
        int n10 = -TransformUtils.surfaceRotationToRotationDegrees(this.mTargetRotation);
        float[] fArray2 = TransformUtils.createRotatedVertices(fArray, n10);
        matrix.setPolyToPoly(fArray, 0, fArray2, 0, 4);
        return matrix;
    }

    public boolean isCropRectAspectRatioMatchPreviewView(Size size) {
        int n10 = size.getWidth();
        float f10 = n10;
        float f11 = size.getHeight();
        f10 /= f11;
        size = this.getRotatedCropRectSize();
        float f12 = size.getWidth();
        float f13 = 0.5f;
        f12 += f13;
        float f14 = size.getHeight() - f13;
        f12 /= f14;
        f14 = size.getWidth() - f13;
        f11 = size.getHeight() + f13;
        float f15 = f10 - (f14 /= f11);
        float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (f16 >= 0 && (f16 = f10 == f12 ? 0 : (f10 < f12 ? -1 : 1)) <= 0) {
            f16 = 1.0f;
            f11 = Float.MIN_VALUE;
        } else {
            f16 = 0.0f;
            f11 = 0.0f;
            size = null;
        }
        return (boolean)f16;
    }

    public void setScaleType(PreviewView$ScaleType previewView$ScaleType) {
        this.mScaleType = previewView$ScaleType;
    }

    public void setTransformationInfo(SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo, Size size, boolean bl2) {
        int n10;
        int n11;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Transformation info set: ");
        charSequence.append(surfaceRequest$TransformationInfo);
        String string2 = " ";
        charSequence.append(string2);
        charSequence.append(size);
        charSequence.append(string2);
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        Logger.d(TAG, (String)charSequence);
        charSequence = surfaceRequest$TransformationInfo.getCropRect();
        this.mSurfaceCropRect = charSequence;
        this.mPreviewRotationDegrees = n11 = surfaceRequest$TransformationInfo.getRotationDegrees();
        this.mTargetRotation = n10 = surfaceRequest$TransformationInfo.getTargetRotation();
        this.mResolution = size;
        this.mIsFrontCamera = bl2;
    }

    public void transformView(Size size, int n10, View view) {
        int n11 = this.isTransformationInfoReady();
        if (n11 == 0) {
            return;
        }
        n11 = view instanceof TextureView;
        if (n11 != 0) {
            View view2 = view;
            view2 = (TextureView)view;
            Matrix matrix = this.getTextureViewCorrectionMatrix();
            view2.setTransform(matrix);
        } else {
            int n12;
            Object object = view.getDisplay();
            if (object != null && (n11 = object.getRotation()) != (n12 = this.mTargetRotation)) {
                object = TAG;
                String string2 = "Non-display rotation not supported with SurfaceView / PERFORMANCE mode.";
                Logger.e((String)object, string2);
            }
        }
        size = this.getTransformedSurfaceRect(size, n10);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        float f10 = size.width();
        float f11 = this.mResolution.getWidth();
        view.setScaleX(f10 /= f11);
        f10 = size.height();
        f11 = this.mResolution.getHeight();
        view.setScaleY(f10 /= f11);
        f10 = size.left;
        f11 = view.getLeft();
        view.setTranslationX(f10 -= f11);
        float f12 = size.top;
        f10 = view.getTop();
        view.setTranslationY(f12 -= f10);
    }
}

