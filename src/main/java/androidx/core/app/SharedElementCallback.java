/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.SharedElementCallback$OnSharedElementsReadyListener;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 0x100000;
    private Matrix mTempMatrix;

    private static Bitmap createDrawableBitmap(Drawable drawable2) {
        int n10 = drawable2.getIntrinsicWidth();
        int n11 = drawable2.getIntrinsicHeight();
        if (n10 > 0 && n11 > 0) {
            float f10 = n10 * n11;
            float f11 = (float)8 / f10;
            int n12 = 1065353216;
            f10 = 1.0f;
            f11 = Math.min(f10, f11);
            int n13 = drawable2 instanceof BitmapDrawable;
            if (n13 != 0 && (n12 = (int)(f11 == f10 ? 0 : (f11 > f10 ? 1 : -1))) == 0) {
                return ((BitmapDrawable)drawable2).getBitmap();
            }
            n10 = (int)((float)n10 * f11);
            n11 = (int)((float)n11 * f11);
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            config = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)config);
            Canvas canvas = new Canvas((Bitmap)config);
            Rect rect = drawable2.getBounds();
            int n14 = rect.left;
            int n15 = rect.top;
            int n16 = rect.right;
            n13 = rect.bottom;
            drawable2.setBounds(0, 0, n10, n11);
            drawable2.draw(canvas);
            drawable2.setBounds(n14, n15, n16, n13);
            return config;
        }
        return null;
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix object, RectF object2) {
        Drawable drawable2;
        int n10 = view instanceof ImageView;
        if (n10 != 0) {
            View view2 = view;
            view2 = (ImageView)view;
            Drawable drawable3 = view2.getDrawable();
            drawable2 = view2.getBackground();
            if (drawable3 != null && drawable2 == null && (drawable3 = SharedElementCallback.createDrawableBitmap(drawable3)) != null) {
                view = new Bundle();
                view.putParcelable(BUNDLE_SNAPSHOT_BITMAP, (Parcelable)drawable3);
                object = view2.getScaleType().toString();
                view.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, (String)object);
                object = view2.getScaleType();
                object2 = ImageView.ScaleType.MATRIX;
                if (object == object2) {
                    object = view2.getImageMatrix();
                    int n11 = 9;
                    float f10 = 1.3E-44f;
                    object2 = new float[n11];
                    object.getValues((float[])object2);
                    object = BUNDLE_SNAPSHOT_IMAGE_MATRIX;
                    view.putFloatArray((String)object, (float[])object2);
                }
                return view;
            }
        }
        float f11 = object2.width();
        n10 = Math.round(f11);
        float f12 = object2.height();
        int n12 = Math.round(f12);
        float f13 = 0.0f;
        drawable2 = null;
        if (n10 > 0 && n12 > 0) {
            int n13 = n10 * n12;
            float f14 = n13;
            float f15 = (float)8 / f14;
            f13 = Math.min(1.0f, f15);
            f11 = (float)n10 * f13;
            n10 = (int)f11;
            f12 = (float)n12 * f13;
            n12 = (int)f12;
            Matrix matrix = this.mTempMatrix;
            if (matrix == null) {
                this.mTempMatrix = matrix = new Matrix();
            }
            matrix = this.mTempMatrix;
            matrix.set(object);
            object = this.mTempMatrix;
            f15 = -object2.left;
            float f16 = -object2.top;
            object.postTranslate(f15, f16);
            this.mTempMatrix.postScale(f13, f13);
            object = Bitmap.Config.ARGB_8888;
            drawable2 = Bitmap.createBitmap((int)n10, (int)n12, (Bitmap.Config)object);
            object = new Canvas((Bitmap)drawable2);
            object2 = this.mTempMatrix;
            object.concat((Matrix)object2);
            view.draw((Canvas)object);
        }
        return drawable2;
    }

    public View onCreateSnapshotView(Context object, Parcelable parcelable) {
        boolean bl2 = parcelable instanceof Bundle;
        ImageView imageView = null;
        if (bl2) {
            Bitmap bitmap = (Bitmap)(parcelable = (Bundle)parcelable).getParcelable(BUNDLE_SNAPSHOT_BITMAP);
            if (bitmap == null) {
                return null;
            }
            imageView = new ImageView(object);
            imageView.setImageBitmap(bitmap);
            object = ImageView.ScaleType.valueOf((String)parcelable.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE));
            imageView.setScaleType((ImageView.ScaleType)object);
            object = imageView.getScaleType();
            bitmap = ImageView.ScaleType.MATRIX;
            if (object == bitmap) {
                object = parcelable.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
                parcelable = new Matrix();
                parcelable.setValues((float[])object);
                imageView.setImageMatrix((Matrix)parcelable);
            }
        } else {
            bl2 = parcelable instanceof Bitmap;
            if (bl2) {
                parcelable = (Bitmap)parcelable;
                imageView = new ImageView(object);
                imageView.setImageBitmap((Bitmap)parcelable);
            }
        }
        return imageView;
    }

    public void onMapSharedElements(List list, Map map) {
    }

    public void onRejectSharedElements(List list) {
    }

    public void onSharedElementEnd(List list, List list2, List list3) {
    }

    public void onSharedElementStart(List list, List list2, List list3) {
    }

    public void onSharedElementsArrived(List list, List list2, SharedElementCallback$OnSharedElementsReadyListener sharedElementCallback$OnSharedElementsReadyListener) {
        sharedElementCallback$OnSharedElementsReadyListener.onSharedElementsReady();
    }
}

