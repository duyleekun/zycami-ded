/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.ChangeImageTransform$1;
import androidx.transition.ChangeImageTransform$2;
import androidx.transition.ChangeImageTransform$3;
import androidx.transition.MatrixUtils;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils$MatrixEvaluator;
import androidx.transition.TransitionValues;
import java.util.Map;

public class ChangeImageTransform
extends Transition {
    private static final Property ANIMATED_TRANSFORM_PROPERTY;
    private static final TypeEvaluator NULL_MATRIX_EVALUATOR;
    private static final String PROPNAME_BOUNDS = "android:changeImageTransform:bounds";
    private static final String PROPNAME_MATRIX = "android:changeImageTransform:matrix";
    private static final String[] sTransitionProperties;

    static {
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_BOUNDS};
        Object object = new ChangeImageTransform$1();
        NULL_MATRIX_EVALUATOR = object;
        object = new ChangeImageTransform$2(Matrix.class, "animatedTransform");
        ANIMATED_TRANSFORM_PROPERTY = object;
    }

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues object) {
        View view = ((TransitionValues)object).view;
        int n10 = view instanceof ImageView;
        if (n10 != 0 && (n10 = view.getVisibility()) == 0) {
            Object object2 = view;
            object2 = (ImageView)view;
            Drawable drawable2 = object2.getDrawable();
            if (drawable2 == null) {
                return;
            }
            object = ((TransitionValues)object).values;
            int n11 = view.getLeft();
            int n12 = view.getTop();
            int n13 = view.getRight();
            int n14 = view.getBottom();
            Rect rect = new Rect(n11, n12, n13, n14);
            object.put(PROPNAME_BOUNDS, rect);
            view = ChangeImageTransform.copyImageMatrix((ImageView)object2);
            object2 = PROPNAME_MATRIX;
            object.put(object2, view);
        }
    }

    private static Matrix centerCropMatrix(ImageView imageView) {
        Drawable drawable2 = imageView.getDrawable();
        int n10 = drawable2.getIntrinsicWidth();
        float f10 = imageView.getWidth();
        float f11 = n10;
        float f12 = f10 / f11;
        int n11 = drawable2.getIntrinsicHeight();
        float f13 = imageView.getHeight();
        float f14 = n11;
        float f15 = f13 / f14;
        f12 = Math.max(f12, f15);
        f11 = 2.0f;
        int n12 = Math.round((f10 -= (f11 *= f12)) / f11);
        int n13 = Math.round((f13 - (f14 *= f12)) / f11);
        drawable2 = new Matrix();
        drawable2.postScale(f12, f12);
        f11 = n12;
        f13 = n13;
        drawable2.postTranslate(f11, f13);
        return drawable2;
    }

    private static Matrix copyImageMatrix(ImageView imageView) {
        Object object;
        Object object2 = imageView.getDrawable();
        int n10 = object2.getIntrinsicWidth();
        if (n10 > 0 && (object = object2.getIntrinsicHeight()) > 0) {
            object2 = ChangeImageTransform$3.$SwitchMap$android$widget$ImageView$ScaleType;
            ImageView.ScaleType scaleType = imageView.getScaleType();
            n10 = scaleType.ordinal();
            object = object2[n10];
            if (object != (n10 = 1)) {
                n10 = 2;
                if (object == n10) {
                    return ChangeImageTransform.centerCropMatrix(imageView);
                }
            } else {
                return ChangeImageTransform.fitXYMatrix(imageView);
            }
        }
        imageView = imageView.getImageMatrix();
        object2 = new Matrix((Matrix)imageView);
        return object2;
    }

    private ObjectAnimator createMatrixAnimator(ImageView imageView, Matrix matrix, Matrix matrix2) {
        Property property = ANIMATED_TRANSFORM_PROPERTY;
        TransitionUtils$MatrixEvaluator transitionUtils$MatrixEvaluator = new TransitionUtils$MatrixEvaluator();
        Object[] objectArray = new Matrix[]{matrix, matrix2};
        return ObjectAnimator.ofObject((Object)imageView, (Property)property, (TypeEvaluator)transitionUtils$MatrixEvaluator, (Object[])objectArray);
    }

    private ObjectAnimator createNullAnimator(ImageView imageView) {
        Property property = ANIMATED_TRANSFORM_PROPERTY;
        TypeEvaluator typeEvaluator = NULL_MATRIX_EVALUATOR;
        Matrix matrix = MatrixUtils.IDENTITY_MATRIX;
        Object[] objectArray = new Matrix[]{matrix, matrix};
        return ObjectAnimator.ofObject((Object)imageView, (Property)property, (TypeEvaluator)typeEvaluator, (Object[])objectArray);
    }

    private static Matrix fitXYMatrix(ImageView imageView) {
        Drawable drawable2 = imageView.getDrawable();
        Matrix matrix = new Matrix();
        float f10 = imageView.getWidth();
        float f11 = drawable2.getIntrinsicWidth();
        float f12 = imageView.getHeight();
        float f13 = drawable2.getIntrinsicHeight();
        matrix.postScale(f10 /= f11, f12 /= f13);
        return matrix;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues object, TransitionValues transitionValues) {
        viewGroup = null;
        if (object != null && transitionValues != null) {
            Map map = ((TransitionValues)object).values;
            String string2 = PROPNAME_BOUNDS;
            map = (Rect)map.get(string2);
            Object object2 = transitionValues.values;
            string2 = (Rect)object2.get(string2);
            if (map != null && string2 != null) {
                boolean bl2;
                object = ((TransitionValues)object).values;
                object2 = PROPNAME_MATRIX;
                object = (Matrix)object.get(object2);
                Map map2 = transitionValues.values;
                object2 = (Matrix)map2.get(object2);
                if (object == null && object2 == null || object != null && (bl2 = object.equals(object2))) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    map2 = null;
                }
                int n10 = map.equals(string2);
                if (n10 != 0 && bl2) {
                    return null;
                }
                viewGroup = (ImageView)transitionValues.view;
                transitionValues = viewGroup.getDrawable();
                n10 = transitionValues.getIntrinsicWidth();
                int n11 = transitionValues.getIntrinsicHeight();
                if (n10 > 0 && n11 > 0) {
                    if (object == null) {
                        object = MatrixUtils.IDENTITY_MATRIX;
                    }
                    if (object2 == null) {
                        object2 = MatrixUtils.IDENTITY_MATRIX;
                    }
                    transitionValues = ANIMATED_TRANSFORM_PROPERTY;
                    transitionValues.set(viewGroup, object);
                    viewGroup = this.createMatrixAnimator((ImageView)viewGroup, (Matrix)object, (Matrix)object2);
                } else {
                    viewGroup = this.createNullAnimator((ImageView)viewGroup);
                }
            }
        }
        return viewGroup;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}

