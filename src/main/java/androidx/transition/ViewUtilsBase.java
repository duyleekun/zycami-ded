/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.transition.R$id;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtilsBase {
    private static final String TAG = "ViewUtilsBase";
    private static final int VISIBILITY_MASK = 12;
    private static boolean sSetFrameFetched;
    private static Method sSetFrameMethod;
    private static Field sViewFlagsField;
    private static boolean sViewFlagsFieldFetched;
    private float[] mMatrixValues;

    private void fetchSetFrame() {
        boolean bl2 = sSetFrameFetched;
        if (!bl2) {
            bl2 = true;
            Object object = View.class;
            String string2 = "setFrame";
            int n10 = 4;
            Object object2 = new Class[n10];
            int n11 = 0;
            Class<Integer> clazz = Integer.TYPE;
            object2[0] = clazz;
            object2[bl2] = clazz;
            n11 = 2;
            object2[n11] = clazz;
            n11 = 3;
            object2[n11] = clazz;
            object = ((Class)object).getDeclaredMethod(string2, (Class<?>)object2);
            sSetFrameMethod = object;
            try {
                ((Method)object).setAccessible(bl2);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                string2 = TAG;
                object2 = "Failed to retrieve setFrame method";
                Log.i((String)string2, (String)object2, (Throwable)noSuchMethodException);
            }
            sSetFrameFetched = bl2;
        }
    }

    public void clearNonTransitionAlpha(View view) {
        int n10 = view.getVisibility();
        if (n10 == 0) {
            n10 = R$id.save_non_transition_alpha;
            view.setTag(n10, null);
        }
    }

    public float getTransitionAlpha(View view) {
        int n10 = R$id.save_non_transition_alpha;
        Float f10 = (Float)view.getTag(n10);
        if (f10 != null) {
            float f11 = view.getAlpha();
            float f12 = f10.floatValue();
            return f11 / f12;
        }
        return view.getAlpha();
    }

    public void saveNonTransitionAlpha(View view) {
        int n10 = R$id.save_non_transition_alpha;
        Object object = view.getTag(n10);
        if (object == null) {
            float f10 = view.getAlpha();
            object = Float.valueOf(f10);
            view.setTag(n10, object);
        }
    }

    public void setAnimationMatrix(View view, Matrix matrix) {
        int n10;
        float f10 = 1.0f;
        int n11 = 2;
        float f11 = 2.8E-45f;
        if (matrix != null && (n10 = matrix.isIdentity()) == 0) {
            float[] fArray = this.mMatrixValues;
            if (fArray == null) {
                n10 = 9;
                this.mMatrixValues = fArray = new float[n10];
            }
            matrix.getValues(fArray);
            int n12 = 3;
            float f12 = fArray[n12];
            float f13 = f12 * f12;
            double d10 = Math.sqrt(f10 - f13);
            f10 = (float)d10;
            f13 = 0.0f;
            float f14 = fArray[0];
            float f15 = f14 - 0.0f;
            float f16 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (f16 < 0) {
                f16 = -1;
                f14 = 0.0f / 0.0f;
            } else {
                f16 = 1.0f;
                f14 = Float.MIN_VALUE;
            }
            f14 = f16;
            double d11 = f12;
            double d12 = f10 *= f14;
            d11 = Math.toDegrees(Math.atan2(d11, d12));
            f12 = (float)d11;
            f13 = fArray[0] / f10;
            f16 = 4;
            f14 = fArray[f16] / f10;
            f10 = fArray[n11];
            n11 = 5;
            f11 = fArray[n11];
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setTranslationX(f10);
            view.setTranslationY(f11);
            view.setRotation(f12);
            view.setScaleX(f13);
            view.setScaleY(f14);
        } else {
            float f17 = view.getWidth() / n11;
            view.setPivotX(f17);
            int n13 = view.getHeight() / n11;
            f17 = n13;
            view.setPivotY(f17);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(f10);
            view.setScaleY(f10);
            view.setRotation(0.0f);
        }
    }

    public void setLeftTopRightBottom(View view, int n10, int n11, int n12, int n13) {
        this.fetchSetFrame();
        Method method = sSetFrameMethod;
        if (method != null) {
            int n14 = 4;
            Object[] objectArray = new Object[n14];
            Serializable serializable = Integer.valueOf(n10);
            objectArray[0] = serializable;
            n10 = 1;
            Integer n15 = n11;
            objectArray[n10] = n15;
            n10 = 2;
            n15 = n12;
            objectArray[n10] = n15;
            n10 = 3;
            n15 = n13;
            objectArray[n10] = n15;
            try {
                method.invoke(view, objectArray);
            }
            catch (InvocationTargetException invocationTargetException) {
                Throwable throwable = invocationTargetException.getCause();
                serializable = new RuntimeException(throwable);
                throw serializable;
            }
            catch (IllegalAccessException illegalAccessException) {}
        }
    }

    public void setTransitionAlpha(View view, float f10) {
        int n10 = R$id.save_non_transition_alpha;
        Float f11 = (Float)view.getTag(n10);
        if (f11 != null) {
            float f12 = f11.floatValue() * f10;
            view.setAlpha(f12);
        } else {
            view.setAlpha(f10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setTransitionVisibility(View view, int n10) {
        Field field;
        Object object;
        int n11 = sViewFlagsFieldFetched;
        if (n11 == 0) {
            n11 = 1;
            object = View.class;
            String string2 = "mViewFlags";
            try {
                sViewFlagsField = object = ((Class)object).getDeclaredField(string2);
                ((Field)object).setAccessible(n11 != 0);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                object = TAG;
                string2 = "fetchViewFlagsField: ";
                Log.i((String)object, (String)string2);
            }
            sViewFlagsFieldFetched = n11;
        }
        if ((field = sViewFlagsField) == null) return;
        try {
            n11 = field.getInt(view);
            object = sViewFlagsField;
            ((Field)object).setInt(view, n10 |= (n11 &= 0xFFFFFFF3));
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            return;
        }
    }

    public void transformMatrixToGlobal(View view, Matrix matrix) {
        float f10;
        int n10;
        float f11;
        ViewParent viewParent = view.getParent();
        int n11 = viewParent instanceof View;
        if (n11 != 0) {
            viewParent = (View)viewParent;
            this.transformMatrixToGlobal((View)viewParent, matrix);
            n11 = -viewParent.getScrollX();
            f11 = n11;
            n10 = -viewParent.getScrollY();
            f10 = n10;
            matrix.preTranslate(f11, f10);
        }
        f10 = view.getLeft();
        n11 = view.getTop();
        f11 = n11;
        matrix.preTranslate(f10, f11);
        view = view.getMatrix();
        n10 = (int)(view.isIdentity() ? 1 : 0);
        if (n10 == 0) {
            matrix.preConcat((Matrix)view);
        }
    }

    public void transformMatrixToLocal(View view, Matrix matrix) {
        boolean bl2;
        float f10;
        int n10;
        float f11;
        ViewParent viewParent = view.getParent();
        int n11 = viewParent instanceof View;
        if (n11 != 0) {
            viewParent = (View)viewParent;
            this.transformMatrixToLocal((View)viewParent, matrix);
            n11 = viewParent.getScrollX();
            f11 = n11;
            n10 = viewParent.getScrollY();
            f10 = n10;
            matrix.postTranslate(f11, f10);
        }
        f10 = -view.getLeft();
        n11 = -view.getTop();
        f11 = n11;
        matrix.postTranslate(f10, f11);
        view = view.getMatrix();
        n10 = (int)(view.isIdentity() ? 1 : 0);
        if (n10 == 0 && (bl2 = view.invert((Matrix)(viewParent = new Matrix())))) {
            matrix.postConcat((Matrix)viewParent);
        }
    }
}

