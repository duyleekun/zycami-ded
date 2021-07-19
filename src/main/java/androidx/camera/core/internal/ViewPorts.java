/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Matrix$ScaleToFit
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.Rational
 *  android.util.Size
 */
package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ViewPorts {
    private ViewPorts() {
    }

    public static Map calculateViewPortRects(Rect object, boolean n10, Rational rational, int n11, int n12, int n13, Map object2) {
        int n14;
        int n15;
        Rational rational2;
        boolean bl2;
        RectF rectF;
        int n16 = object.width();
        if (n16 > 0 && (n16 = object.height()) > 0) {
            n16 = 1;
        } else {
            n16 = 0;
            rectF = null;
        }
        Preconditions.checkArgument(n16 != 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        rectF = new RectF((Rect)object);
        HashMap<Object, Rational> hashMap = new HashMap<Object, Rational>();
        RectF rectF2 = new RectF((Rect)object);
        object = object2.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            rational2 = new Matrix();
            n15 = ((Size)object2.getValue()).getWidth();
            float f10 = n15;
            Size size = (Size)object2.getValue();
            n14 = size.getHeight();
            float f11 = n14;
            RectF rectF3 = new RectF(0.0f, 0.0f, f10, f11);
            Matrix.ScaleToFit scaleToFit = Matrix.ScaleToFit.CENTER;
            rational2.setRectToRect(rectF3, rectF, scaleToFit);
            object2 = (UseCase)object2.getKey();
            hashMap.put(object2, rational2);
            object2 = new RectF();
            rational2.mapRect((RectF)object2, rectF3);
            rectF2.intersect((RectF)object2);
        }
        rational2 = ImageUtil.getRotatedAspectRatio(n11, rational);
        n15 = n10;
        n14 = n13;
        object = ViewPorts.getScaledRect(rectF2, rational2, n12, n10 != 0, n13, n11);
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        rational = new RectF();
        Matrix matrix = new Matrix();
        Iterator iterator2 = hashMap.entrySet().iterator();
        while ((n13 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object3 = iterator2.next();
            ((Matrix)object3.getValue()).invert(matrix);
            matrix.mapRect((RectF)rational, (RectF)object);
            object2 = new Rect();
            rational.round((Rect)object2);
            object3 = (UseCase)object3.getKey();
            hashMap2.put(object3, object2);
        }
        return hashMap2;
    }

    private static RectF correctStartOrEnd(boolean bl2, int n10, RectF object, RectF object2) {
        int n11 = 1;
        int n12 = n10 == 0 && !bl2 ? n11 : 0;
        int n13 = 90;
        int n14 = n10 == n13 && bl2 ? n11 : 0;
        if (n12 == 0 && n14 == 0) {
            n12 = n10 == 0 && bl2 ? n11 : 0;
            n14 = 270;
            int n15 = n10 == n14 && !bl2 ? n11 : 0;
            if (n12 == 0 && n15 == 0) {
                n12 = n10 == n13 && !bl2 ? n11 : 0;
                n13 = 180;
                n15 = n10 == n13 && bl2 ? n11 : 0;
                if (n12 == 0 && n15 == 0) {
                    n12 = n10 == n13 && !bl2 ? n11 : 0;
                    if (n10 != n14 || !bl2) {
                        n11 = 0;
                    }
                    if (n12 == 0 && n11 == 0) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Invalid argument: mirrored ");
                        ((StringBuilder)object2).append(bl2);
                        ((StringBuilder)object2).append(" rotation ");
                        ((StringBuilder)object2).append(n10);
                        String string2 = ((StringBuilder)object2).toString();
                        object = new IllegalArgumentException(string2);
                        throw object;
                    }
                    float f10 = object.centerY();
                    RectF rectF = ViewPorts.flipVertically((RectF)object2, f10);
                    float f11 = object.centerX();
                    return ViewPorts.flipHorizontally(rectF, f11);
                }
                float f12 = object.centerY();
                return ViewPorts.flipVertically((RectF)object2, f12);
            }
            float f13 = object.centerX();
            return ViewPorts.flipHorizontally((RectF)object2, f13);
        }
        return object2;
    }

    private static RectF flipHorizontally(RectF rectF, float f10) {
        float f11 = ViewPorts.flipX(rectF.right, f10);
        float f12 = rectF.top;
        f10 = ViewPorts.flipX(rectF.left, f10);
        float f13 = rectF.bottom;
        RectF rectF2 = new RectF(f11, f12, f10, f13);
        return rectF2;
    }

    private static RectF flipVertically(RectF rectF, float f10) {
        float f11 = rectF.left;
        float f12 = ViewPorts.flipY(rectF.bottom, f10);
        float f13 = rectF.right;
        float f14 = ViewPorts.flipY(rectF.top, f10);
        RectF rectF2 = new RectF(f11, f12, f13, f14);
        return rectF2;
    }

    private static float flipX(float f10, float f11) {
        return f11 + f11 - f10;
    }

    private static float flipY(float f10, float f11) {
        return f11 + f11 - f10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static RectF getScaledRect(RectF object, Rational object2, int n10, boolean bl2, int n11, int n12) {
        void var5_6;
        void var4_5;
        void var3_4;
        Object object3;
        void var2_3;
        int n13 = 3;
        if (var2_3 == n13) {
            return object;
        }
        Matrix matrix = new Matrix();
        int n14 = object3.getNumerator();
        float f10 = n14;
        int n15 = object3.getDenominator();
        float f11 = n15;
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        if (var2_3 != false) {
            n15 = 1;
            f11 = Float.MIN_VALUE;
            if (var2_3 != n15) {
                n15 = 2;
                f11 = 2.8E-45f;
                if (var2_3 != n15) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Unexpected scale type: ");
                    ((StringBuilder)object3).append((int)var2_3);
                    object3 = ((StringBuilder)object3).toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object3);
                    throw illegalStateException;
                }
                object3 = Matrix.ScaleToFit.END;
                matrix.setRectToRect(rectF, object, (Matrix.ScaleToFit)object3);
            } else {
                object3 = Matrix.ScaleToFit.CENTER;
                matrix.setRectToRect(rectF, object, (Matrix.ScaleToFit)object3);
            }
        } else {
            object3 = Matrix.ScaleToFit.START;
            matrix.setRectToRect(rectF, object, (Matrix.ScaleToFit)object3);
        }
        object3 = new RectF();
        matrix.mapRect((RectF)object3, rectF);
        return ViewPorts.correctStartOrEnd(ViewPorts.shouldMirrorStartAndEnd((boolean)var3_4, (int)var4_5), (int)var5_6, object, (RectF)object3);
    }

    private static boolean shouldMirrorStartAndEnd(boolean bl2, int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return (bl2 ^ n11) != 0;
    }
}

