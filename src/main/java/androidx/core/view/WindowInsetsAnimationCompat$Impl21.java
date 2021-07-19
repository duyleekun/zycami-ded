/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.WindowInsets
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import androidx.core.R$id;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsAnimationCompat$BoundsCompat;
import androidx.core.view.WindowInsetsAnimationCompat$Callback;
import androidx.core.view.WindowInsetsAnimationCompat$Impl;
import androidx.core.view.WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import java.util.List;

public class WindowInsetsAnimationCompat$Impl21
extends WindowInsetsAnimationCompat$Impl {
    public WindowInsetsAnimationCompat$Impl21(int n10, Interpolator interpolator2, long l10) {
        super(n10, interpolator2, l10);
    }

    public static int buildAnimationMask(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
        int n10;
        int n11 = 0;
        for (int i10 = 1; i10 <= (n10 = 256); i10 <<= 1) {
            Insets insets;
            Insets insets2 = windowInsetsCompat.getInsets(i10);
            n10 = (int)(insets2.equals(insets = windowInsetsCompat2.getInsets(i10)) ? 1 : 0);
            if (n10 != 0) continue;
            n11 |= i10;
        }
        return n11;
    }

    public static WindowInsetsAnimationCompat$BoundsCompat computeAnimationBounds(WindowInsetsCompat object, WindowInsetsCompat object2, int n10) {
        object = ((WindowInsetsCompat)object).getInsets(n10);
        object2 = ((WindowInsetsCompat)object2).getInsets(n10);
        n10 = ((Insets)object).left;
        int n11 = ((Insets)object2).left;
        n10 = Math.min(n10, n11);
        n11 = ((Insets)object).top;
        int n12 = ((Insets)object2).top;
        n11 = Math.min(n11, n12);
        n12 = ((Insets)object).right;
        int n13 = ((Insets)object2).right;
        n12 = Math.min(n12, n13);
        n13 = ((Insets)object).bottom;
        int n14 = ((Insets)object2).bottom;
        n13 = Math.min(n13, n14);
        Insets insets = Insets.of(n10, n11, n12, n13);
        n11 = ((Insets)object).left;
        n12 = ((Insets)object2).left;
        n11 = Math.max(n11, n12);
        n12 = ((Insets)object).top;
        n13 = ((Insets)object2).top;
        n12 = Math.max(n12, n13);
        n13 = ((Insets)object).right;
        n14 = ((Insets)object2).right;
        n13 = Math.max(n13, n14);
        int n15 = ((Insets)object).bottom;
        int n16 = ((Insets)object2).bottom;
        n15 = Math.max(n15, n16);
        object = Insets.of(n11, n12, n13, n15);
        object2 = new WindowInsetsAnimationCompat$BoundsCompat(insets, (Insets)object);
        return object2;
    }

    private static View.OnApplyWindowInsetsListener createProxyListener(View view, WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener = new WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener(view, windowInsetsAnimationCompat$Callback);
        return windowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener;
    }

    public static void dispatchOnEnd(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        int n10;
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = WindowInsetsAnimationCompat$Impl21.getCallback(view);
        if (windowInsetsAnimationCompat$Callback != null) {
            windowInsetsAnimationCompat$Callback.onEnd(windowInsetsAnimationCompat);
            n10 = windowInsetsAnimationCompat$Callback.getDispatchMode();
            if (n10 == 0) {
                return;
            }
        }
        if ((n10 = view instanceof ViewGroup) != 0) {
            int n11;
            view = (ViewGroup)view;
            windowInsetsAnimationCompat$Callback = null;
            for (n10 = 0; n10 < (n11 = view.getChildCount()); ++n10) {
                View view2 = view.getChildAt(n10);
                WindowInsetsAnimationCompat$Impl21.dispatchOnEnd(view2, windowInsetsAnimationCompat);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void dispatchOnPrepare(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean bl2) {
        int n10;
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = WindowInsetsAnimationCompat$Impl21.getCallback(view);
        int n11 = 0;
        if (windowInsetsAnimationCompat$Callback != null) {
            windowInsetsAnimationCompat$Callback.mDispachedInsets = windowInsets;
            if (!bl2) {
                windowInsetsAnimationCompat$Callback.onPrepare(windowInsetsAnimationCompat);
                int n12 = windowInsetsAnimationCompat$Callback.getDispatchMode();
                if (n12 == 0) {
                    boolean bl3 = true;
                } else {
                    boolean bl4 = false;
                }
            }
        }
        if ((n10 = view instanceof ViewGroup) != 0) {
            view = (ViewGroup)view;
            while (n11 < (n10 = view.getChildCount())) {
                void var3_7;
                windowInsetsAnimationCompat$Callback = view.getChildAt(n11);
                WindowInsetsAnimationCompat$Impl21.dispatchOnPrepare((View)windowInsetsAnimationCompat$Callback, windowInsetsAnimationCompat, windowInsets, (boolean)var3_7);
                ++n11;
            }
        }
    }

    public static void dispatchOnProgress(View view, WindowInsetsCompat windowInsetsCompat, List list) {
        int n10;
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = WindowInsetsAnimationCompat$Impl21.getCallback(view);
        if (windowInsetsAnimationCompat$Callback != null) {
            windowInsetsCompat = windowInsetsAnimationCompat$Callback.onProgress(windowInsetsCompat, list);
            n10 = windowInsetsAnimationCompat$Callback.getDispatchMode();
            if (n10 == 0) {
                return;
            }
        }
        if ((n10 = view instanceof ViewGroup) != 0) {
            int n11;
            view = (ViewGroup)view;
            windowInsetsAnimationCompat$Callback = null;
            for (n10 = 0; n10 < (n11 = view.getChildCount()); ++n10) {
                View view2 = view.getChildAt(n10);
                WindowInsetsAnimationCompat$Impl21.dispatchOnProgress(view2, windowInsetsCompat, list);
            }
        }
    }

    public static void dispatchOnStart(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat$BoundsCompat windowInsetsAnimationCompat$BoundsCompat) {
        int n10;
        WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback = WindowInsetsAnimationCompat$Impl21.getCallback(view);
        if (windowInsetsAnimationCompat$Callback != null) {
            windowInsetsAnimationCompat$Callback.onStart(windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompat);
            n10 = windowInsetsAnimationCompat$Callback.getDispatchMode();
            if (n10 == 0) {
                return;
            }
        }
        if ((n10 = view instanceof ViewGroup) != 0) {
            int n11;
            view = (ViewGroup)view;
            windowInsetsAnimationCompat$Callback = null;
            for (n10 = 0; n10 < (n11 = view.getChildCount()); ++n10) {
                View view2 = view.getChildAt(n10);
                WindowInsetsAnimationCompat$Impl21.dispatchOnStart(view2, windowInsetsAnimationCompat, windowInsetsAnimationCompat$BoundsCompat);
            }
        }
    }

    public static WindowInsets forwardToViewIfNeeded(View view, WindowInsets windowInsets) {
        int n10 = R$id.tag_on_apply_window_listener;
        Object object = view.getTag(n10);
        if (object != null) {
            return windowInsets;
        }
        return view.onApplyWindowInsets(windowInsets);
    }

    public static WindowInsetsAnimationCompat$Callback getCallback(View object) {
        int n10 = R$id.tag_window_insets_animation_callback;
        object = (n10 = (object = object.getTag(n10)) instanceof WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener) != 0 ? ((WindowInsetsAnimationCompat$Impl21$Impl21OnApplyWindowInsetsListener)object).mCallback : null;
        return object;
    }

    public static WindowInsetsCompat interpolateInsets(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f10, int n10) {
        int n11;
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder(windowInsetsCompat);
        for (int i10 = 1; i10 <= (n11 = 256); i10 <<= 1) {
            Insets insets;
            n11 = n10 & i10;
            if (n11 == 0) {
                insets = windowInsetsCompat.getInsets(i10);
                windowInsetsCompat$Builder.setInsets(i10, insets);
                continue;
            }
            insets = windowInsetsCompat.getInsets(i10);
            Insets insets2 = windowInsetsCompat2.getInsets(i10);
            int n12 = insets.left;
            int n13 = insets2.left;
            float f11 = n12 - n13;
            n13 = 1065353216;
            float f12 = 1.0f - f10;
            double d10 = f11 *= f12;
            double d11 = 0.5;
            n12 = (int)(d10 + d11);
            int n14 = insets.top;
            int n15 = insets2.top;
            float f13 = (float)(n14 - n15) * f12;
            d10 = (double)f13 + d11;
            n14 = (int)d10;
            n15 = insets.right;
            int n16 = insets2.right;
            float f14 = (float)(n15 - n16) * f12;
            n15 = (int)((double)f14 + d11);
            n16 = insets.bottom;
            int n17 = insets2.bottom;
            float f15 = (float)(n16 -= n17) * f12;
            double d12 = (double)f15 + d11;
            n17 = (int)d12;
            insets = WindowInsetsCompat.insetInsets(insets, n12, n14, n15, n17);
            windowInsetsCompat$Builder.setInsets(i10, insets);
        }
        return windowInsetsCompat$Builder.build();
    }

    public static void setCallback(View view, WindowInsetsAnimationCompat$Callback windowInsetsAnimationCompat$Callback) {
        int n10 = R$id.tag_on_apply_window_listener;
        Object object = view.getTag(n10);
        if (windowInsetsAnimationCompat$Callback == null) {
            int n11 = R$id.tag_window_insets_animation_callback;
            boolean bl2 = false;
            view.setTag(n11, null);
            if (object == null) {
                view.setOnApplyWindowInsetsListener(null);
            }
        } else {
            windowInsetsAnimationCompat$Callback = WindowInsetsAnimationCompat$Impl21.createProxyListener(view, windowInsetsAnimationCompat$Callback);
            int n12 = R$id.tag_window_insets_animation_callback;
            view.setTag(n12, (Object)windowInsetsAnimationCompat$Callback);
            if (object == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)windowInsetsAnimationCompat$Callback);
            }
        }
    }
}

