/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.widget.ImageView
 */
package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

public class ImageViewUtils {
    private static Field sDrawMatrixField;
    private static boolean sDrawMatrixFieldFetched = false;
    private static boolean sTryHiddenAnimateTransform = true;

    private ImageViewUtils() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void animateTransform(ImageView imageView, Matrix matrix) {
        void var7_13;
        block11: {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 29;
            if (n10 >= n11) {
                imageView.animateTransform(matrix);
                return;
            }
            n11 = 0;
            Object object = null;
            if (matrix == null) {
                matrix = imageView.getDrawable();
                if (matrix == null) return;
                n10 = imageView.getWidth();
                int n12 = imageView.getPaddingLeft();
                n10 -= n12;
                n12 = imageView.getPaddingRight();
                n10 -= n12;
                n12 = imageView.getHeight();
                int n13 = imageView.getPaddingTop();
                n12 -= n13;
                n13 = imageView.getPaddingBottom();
                matrix.setBounds(0, 0, n10, n12 -= n13);
                imageView.invalidate();
                return;
            }
            int n14 = 21;
            if (n10 >= n14) {
                ImageViewUtils.hiddenAnimateTransform(imageView, matrix);
                return;
            }
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 == null) return;
            n14 = drawable2.getIntrinsicWidth();
            int n15 = drawable2.getIntrinsicHeight();
            drawable2.setBounds(0, 0, n14, n15);
            n10 = 0;
            Object var7_10 = null;
            ImageViewUtils.fetchDrawMatrixField();
            object = sDrawMatrixField;
            if (object != null) {
                block10: {
                    Matrix matrix2;
                    try {
                        object = ((Field)object).get(imageView);
                        object = (Matrix)object;
                        if (object != null) break block10;
                    }
                    catch (IllegalAccessException illegalAccessException) {}
                    try {
                        matrix2 = new Matrix();
                    }
                    catch (IllegalAccessException illegalAccessException) {}
                    object = sDrawMatrixField;
                    ((Field)object).set(imageView, matrix2);
                    break block11;
                }
                Object object2 = object;
            }
        }
        if (var7_13 != null) {
            var7_13.set(matrix);
        }
        imageView.invalidate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void fetchDrawMatrixField() {
        boolean bl2 = sDrawMatrixFieldFetched;
        if (!bl2) {
            bl2 = true;
            Object object = ImageView.class;
            String string2 = "mDrawMatrix";
            try {
                sDrawMatrixField = object = ((Class)object).getDeclaredField(string2);
                ((Field)object).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            sDrawMatrixFieldFetched = bl2;
        }
    }

    private static void hiddenAnimateTransform(ImageView imageView, Matrix matrix) {
        boolean bl2 = sTryHiddenAnimateTransform;
        if (bl2) {
            try {
                imageView.animateTransform(matrix);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                imageView = null;
                sTryHiddenAnimateTransform = false;
            }
        }
    }
}

