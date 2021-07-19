/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class ViewGroupUtils {
    private static final ThreadLocal sMatrix;
    private static final ThreadLocal sRectF;

    static {
        ThreadLocal threadLocal;
        sMatrix = threadLocal = new ThreadLocal();
        sRectF = threadLocal = new ThreadLocal();
    }

    private ViewGroupUtils() {
    }

    public static void getDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        int n10 = view.getWidth();
        int n11 = view.getHeight();
        rect.set(0, 0, n10, n11);
        ViewGroupUtils.offsetDescendantRect(viewGroup, view, rect);
    }

    private static void offsetDescendantMatrix(ViewParent viewParent, View view, Matrix matrix) {
        float f10;
        int n10;
        float f11;
        int n11;
        ViewParent viewParent2 = view.getParent();
        boolean bl2 = viewParent2 instanceof View;
        if (bl2 && viewParent2 != viewParent) {
            viewParent2 = (View)viewParent2;
            ViewGroupUtils.offsetDescendantMatrix(viewParent, (View)viewParent2, matrix);
            n11 = -viewParent2.getScrollX();
            f11 = n11;
            n10 = -viewParent2.getScrollY();
            f10 = n10;
            matrix.preTranslate(f11, f10);
        }
        f11 = view.getLeft();
        n10 = view.getTop();
        f10 = n10;
        matrix.preTranslate(f11, f10);
        viewParent = view.getMatrix();
        n11 = (int)(viewParent.isIdentity() ? 1 : 0);
        if (n11 == 0) {
            viewParent = view.getMatrix();
            matrix.preConcat((Matrix)viewParent);
        }
    }

    public static void offsetDescendantRect(ViewGroup object, View view, Rect rect) {
        ThreadLocal threadLocal = sMatrix;
        Matrix matrix = (Matrix)threadLocal.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal.set(matrix);
        } else {
            matrix.reset();
        }
        ViewGroupUtils.offsetDescendantMatrix((ViewParent)object, view, matrix);
        object = sRectF;
        view = (RectF)((ThreadLocal)object).get();
        if (view == null) {
            view = new RectF();
            ((ThreadLocal)object).set(view);
        }
        view.set(rect);
        matrix.mapRect((RectF)view);
        float f10 = view.left;
        float f11 = 0.5f;
        int n10 = (int)(f10 + f11);
        int n11 = (int)(view.top + f11);
        int n12 = (int)(view.right + f11);
        int n13 = (int)(view.bottom + f11);
        rect.set(n10, n11, n12, n13);
    }
}

