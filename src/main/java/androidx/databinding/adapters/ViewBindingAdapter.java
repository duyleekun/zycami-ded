/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.View$OnLongClickListener
 */
package androidx.databinding.adapters;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.databinding.adapters.ListenerUtil;
import androidx.databinding.adapters.ViewBindingAdapter$1;
import androidx.databinding.adapters.ViewBindingAdapter$OnViewAttachedToWindow;
import androidx.databinding.adapters.ViewBindingAdapter$OnViewDetachedFromWindow;
import androidx.databinding.library.baseAdapters.R$id;

public class ViewBindingAdapter {
    public static final int FADING_EDGE_HORIZONTAL = 1;
    public static final int FADING_EDGE_NONE = 0;
    public static final int FADING_EDGE_VERTICAL = 2;

    private static int pixelsToDimensionPixelSize(float f10) {
        float f11 = 0.5f + f10;
        int n10 = (int)f11;
        if (n10 != 0) {
            return n10;
        }
        n10 = 0;
        f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return 0;
        }
        if (object > 0) {
            return 1;
        }
        return -1;
    }

    public static void setBackground(View view, Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            view.setBackground(drawable2);
        } else {
            view.setBackgroundDrawable(drawable2);
        }
    }

    public static void setClickListener(View view, View.OnClickListener onClickListener, boolean bl2) {
        view.setOnClickListener(onClickListener);
        view.setClickable(bl2);
    }

    public static void setOnAttachStateChangeListener(View view, ViewBindingAdapter$OnViewDetachedFromWindow object, ViewBindingAdapter$OnViewAttachedToWindow viewBindingAdapter$OnViewAttachedToWindow) {
        if (object == null && viewBindingAdapter$OnViewAttachedToWindow == null) {
            object = null;
        } else {
            ViewBindingAdapter$1 viewBindingAdapter$1 = new ViewBindingAdapter$1(viewBindingAdapter$OnViewAttachedToWindow, (ViewBindingAdapter$OnViewDetachedFromWindow)object);
            object = viewBindingAdapter$1;
        }
        int n10 = R$id.onAttachStateChangeListener;
        viewBindingAdapter$OnViewAttachedToWindow = (View.OnAttachStateChangeListener)ListenerUtil.trackListener(view, object, n10);
        if (viewBindingAdapter$OnViewAttachedToWindow != null) {
            view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)viewBindingAdapter$OnViewAttachedToWindow);
        }
        if (object != null) {
            view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)object);
        }
    }

    public static void setOnClick(View view, View.OnClickListener onClickListener, boolean bl2) {
        view.setOnClickListener(onClickListener);
        view.setClickable(bl2);
    }

    public static void setOnLayoutChangeListener(View view, View.OnLayoutChangeListener onLayoutChangeListener, View.OnLayoutChangeListener onLayoutChangeListener2) {
        if (onLayoutChangeListener != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        if (onLayoutChangeListener2 != null) {
            view.addOnLayoutChangeListener(onLayoutChangeListener2);
        }
    }

    public static void setOnLongClick(View view, View.OnLongClickListener onLongClickListener, boolean bl2) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(bl2);
    }

    public static void setOnLongClickListener(View view, View.OnLongClickListener onLongClickListener, boolean bl2) {
        view.setOnLongClickListener(onLongClickListener);
        view.setLongClickable(bl2);
    }

    public static void setPadding(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        view.setPadding(n10, n10, n10, n10);
    }

    public static void setPaddingBottom(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        int n11 = view.getPaddingLeft();
        int n12 = view.getPaddingTop();
        int n13 = view.getPaddingRight();
        view.setPadding(n11, n12, n13, n10);
    }

    public static void setPaddingEnd(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            n11 = view.getPaddingStart();
            n12 = view.getPaddingTop();
            int n13 = view.getPaddingBottom();
            view.setPaddingRelative(n11, n12, n10, n13);
        } else {
            n11 = view.getPaddingLeft();
            n12 = view.getPaddingTop();
            int n14 = view.getPaddingBottom();
            view.setPadding(n11, n12, n10, n14);
        }
    }

    public static void setPaddingLeft(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        int n11 = view.getPaddingTop();
        int n12 = view.getPaddingRight();
        int n13 = view.getPaddingBottom();
        view.setPadding(n10, n11, n12, n13);
    }

    public static void setPaddingRight(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        int n11 = view.getPaddingLeft();
        int n12 = view.getPaddingTop();
        int n13 = view.getPaddingBottom();
        view.setPadding(n11, n12, n10, n13);
    }

    public static void setPaddingStart(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            n11 = view.getPaddingTop();
            n12 = view.getPaddingEnd();
            int n13 = view.getPaddingBottom();
            view.setPaddingRelative(n10, n11, n12, n13);
        } else {
            n11 = view.getPaddingTop();
            n12 = view.getPaddingRight();
            int n14 = view.getPaddingBottom();
            view.setPadding(n10, n11, n12, n14);
        }
    }

    public static void setPaddingTop(View view, float f10) {
        int n10 = ViewBindingAdapter.pixelsToDimensionPixelSize(f10);
        int n11 = view.getPaddingLeft();
        int n12 = view.getPaddingRight();
        int n13 = view.getPaddingBottom();
        view.setPadding(n11, n10, n12, n13);
    }

    public static void setRequiresFadingEdge(View view, int n10) {
        int n11 = n10 & 2;
        int n12 = 0;
        int n13 = 1;
        n11 = n11 != 0 ? n13 : 0;
        if ((n10 &= n13) != 0) {
            n12 = n13;
        }
        view.setVerticalFadingEdgeEnabled(n11 != 0);
        view.setHorizontalFadingEdgeEnabled(n12 != 0);
    }
}

