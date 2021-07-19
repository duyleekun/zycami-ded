/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$id;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ItemTouchUIUtilImpl
implements ItemTouchUIUtil {
    public static final ItemTouchUIUtil INSTANCE;

    static {
        ItemTouchUIUtilImpl itemTouchUIUtilImpl = new ItemTouchUIUtilImpl();
        INSTANCE = itemTouchUIUtilImpl;
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int n10 = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11;
            float f12;
            float f13;
            View view2 = recyclerView.getChildAt(i10);
            if (view2 == view || (f13 = (f12 = (f11 = ViewCompat.getElevation(view2)) - f10) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) <= 0) continue;
            f10 = f11;
        }
        return f10;
    }

    public void clearView(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        float f10 = 2.9E-44f;
        if (n10 >= n11) {
            n10 = R$id.item_touch_helper_previous_elevation;
            Object object = view.getTag(n10);
            boolean bl2 = object instanceof Float;
            if (bl2) {
                object = (Float)object;
                f10 = ((Float)object).floatValue();
                ViewCompat.setElevation(view, f10);
            }
            n11 = 0;
            f10 = 0.0f;
            object = null;
            view.setTag(n10, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int n10, boolean bl2) {
        Object object;
        int n11 = Build.VERSION.SDK_INT;
        n10 = 21;
        float f12 = 2.9E-44f;
        if (n11 >= n10 && bl2 && (object = view.getTag(n11 = R$id.item_touch_helper_previous_elevation)) == null) {
            f12 = ViewCompat.getElevation(view);
            object = Float.valueOf(f12);
            int n12 = 1065353216;
            float f13 = 1.0f;
            float f14 = ItemTouchUIUtilImpl.findMaxElevation(recyclerView, view) + f13;
            ViewCompat.setElevation(view, f14);
            view.setTag(n11, object);
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int n10, boolean bl2) {
    }

    public void onSelected(View view) {
    }
}

