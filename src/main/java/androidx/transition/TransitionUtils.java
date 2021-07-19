/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Picture
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ImageView;
import androidx.transition.ViewUtils;

public class TransitionUtils {
    private static final boolean HAS_IS_ATTACHED_TO_WINDOW = false;
    private static final boolean HAS_OVERLAY = false;
    private static final boolean HAS_PICTURE_BITMAP = false;
    private static final int MAX_IMAGE_SIZE = 0x100000;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 19;
        n12 = n10 >= n12 ? n11 : 0;
        HAS_IS_ATTACHED_TO_WINDOW = n12;
        n12 = 18;
        n12 = n10 >= n12 ? n11 : 0;
        HAS_OVERLAY = n12;
        n12 = 28;
        if (n10 < n12) {
            n11 = 0;
        }
        HAS_PICTURE_BITMAP = n11;
    }

    private TransitionUtils() {
    }

    public static View copyViewImage(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        float f10 = -view2.getScrollX();
        int n10 = -view2.getScrollY();
        float f11 = n10;
        matrix.setTranslate(f10, f11);
        ViewUtils.transformMatrixToGlobal(view, matrix);
        ViewUtils.transformMatrixToLocal((View)viewGroup, matrix);
        f10 = view.getWidth();
        float f12 = view.getHeight();
        view2 = new RectF(0.0f, 0.0f, f10, f12);
        matrix.mapRect((RectF)view2);
        f10 = view2.left;
        int n11 = Math.round(f10);
        f12 = view2.top;
        int n12 = Math.round(f12);
        float f13 = view2.right;
        int n13 = Math.round(f13);
        float f14 = view2.bottom;
        int n14 = Math.round(f14);
        Context context = view.getContext();
        ImageView imageView = new ImageView(context);
        context = ImageView.ScaleType.CENTER_CROP;
        imageView.setScaleType((ImageView.ScaleType)context);
        viewGroup = TransitionUtils.createViewBitmap(view, matrix, (RectF)view2, viewGroup);
        if (viewGroup != null) {
            imageView.setImageBitmap((Bitmap)viewGroup);
        }
        int n15 = n13 - n11;
        int n16 = 0x40000000;
        n15 = View.MeasureSpec.makeMeasureSpec((int)n15, (int)n16);
        n16 = View.MeasureSpec.makeMeasureSpec((int)(n14 - n12), (int)n16);
        imageView.measure(n15, n16);
        imageView.layout(n11, n12, n13, n14);
        return imageView;
    }

    private static Bitmap createViewBitmap(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        int n10;
        boolean bl2 = HAS_IS_ATTACHED_TO_WINDOW;
        ViewGroup viewGroup2 = null;
        if (bl2) {
            bl2 = view.isAttachedToWindow() ^ true;
            n10 = viewGroup == null ? 0 : viewGroup.isAttachedToWindow();
        } else {
            bl2 = false;
            n10 = 0;
        }
        boolean bl3 = HAS_OVERLAY;
        float f10 = 0.0f;
        Bitmap bitmap = null;
        if (bl3 && bl2) {
            if (n10 == 0) {
                return null;
            }
            viewGroup2 = (ViewGroup)view.getParent();
            n10 = viewGroup2.indexOfChild(view);
            ViewGroupOverlay viewGroupOverlay = viewGroup.getOverlay();
            viewGroupOverlay.add(view);
        } else {
            n10 = 0;
            viewGroup2 = null;
        }
        float f11 = rectF.width();
        int n11 = Math.round(f11);
        float f12 = rectF.height();
        int n12 = Math.round(f12);
        if (n11 > 0 && n12 > 0) {
            int n13 = n11 * n12;
            float f13 = n13;
            float f14 = (float)8 / f13;
            f10 = Math.min(1.0f, f14);
            f11 = (float)n11 * f10;
            n11 = Math.round(f11);
            f12 = (float)n12 * f10;
            n12 = Math.round(f12);
            f14 = -rectF.left;
            float f15 = -rectF.top;
            matrix.postTranslate(f14, f15);
            matrix.postScale(f10, f10);
            boolean bl4 = HAS_PICTURE_BITMAP;
            if (bl4) {
                rectF = new Picture();
                bitmap = rectF.beginRecording(n11, n12);
                bitmap.concat(matrix);
                view.draw((Canvas)bitmap);
                rectF.endRecording();
                bitmap = Bitmap.createBitmap((Picture)rectF);
            } else {
                rectF = Bitmap.Config.ARGB_8888;
                bitmap = Bitmap.createBitmap((int)n11, (int)n12, (Bitmap.Config)rectF);
                rectF = new Canvas(bitmap);
                rectF.concat(matrix);
                view.draw((Canvas)rectF);
            }
        }
        if (bl3 && bl2) {
            matrix = viewGroup.getOverlay();
            matrix.remove(view);
            viewGroup2.addView(view, n10);
        }
        return bitmap;
    }

    public static Animator mergeAnimators(Animator animator2, Animator animator3) {
        if (animator2 == null) {
            return animator3;
        }
        if (animator3 == null) {
            return animator2;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArray = new Animator[]{animator2, animator3};
        animatorSet.playTogether(animatorArray);
        return animatorSet;
    }
}

