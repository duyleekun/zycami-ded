/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

public class ViewPager$4
implements OnApplyWindowInsetsListener {
    private final Rect mTempRect;
    public final /* synthetic */ ViewPager this$0;

    public ViewPager$4(ViewPager viewPager) {
        this.this$0 = viewPager;
        this.mTempRect = viewPager;
    }

    public WindowInsetsCompat onApplyWindowInsets(View object, WindowInsetsCompat windowInsetsCompat) {
        int n10;
        int n11;
        boolean n12 = ((WindowInsetsCompat)(object = ViewCompat.onApplyWindowInsets((View)object, windowInsetsCompat))).isConsumed();
        if (n12) {
            return object;
        }
        windowInsetsCompat = this.mTempRect;
        ((Rect)windowInsetsCompat).left = n11 = ((WindowInsetsCompat)object).getSystemWindowInsetLeft();
        ((Rect)windowInsetsCompat).top = n11 = ((WindowInsetsCompat)object).getSystemWindowInsetTop();
        ((Rect)windowInsetsCompat).right = n11 = ((WindowInsetsCompat)object).getSystemWindowInsetRight();
        ((Rect)windowInsetsCompat).bottom = n11 = ((WindowInsetsCompat)object).getSystemWindowInsetBottom();
        ViewPager viewPager = this.this$0;
        int n13 = viewPager.getChildCount();
        for (n11 = 0; n11 < n13; ++n11) {
            WindowInsetsCompat windowInsetsCompat2 = ViewCompat.dispatchApplyWindowInsets(this.this$0.getChildAt(n11), (WindowInsetsCompat)object);
            int n14 = windowInsetsCompat2.getSystemWindowInsetLeft();
            int n15 = ((Rect)windowInsetsCompat).left;
            ((Rect)windowInsetsCompat).left = n14 = Math.min(n14, n15);
            n14 = windowInsetsCompat2.getSystemWindowInsetTop();
            n15 = ((Rect)windowInsetsCompat).top;
            ((Rect)windowInsetsCompat).top = n14 = Math.min(n14, n15);
            n14 = windowInsetsCompat2.getSystemWindowInsetRight();
            n15 = ((Rect)windowInsetsCompat).right;
            ((Rect)windowInsetsCompat).right = n14 = Math.min(n14, n15);
            n10 = windowInsetsCompat2.getSystemWindowInsetBottom();
            n14 = ((Rect)windowInsetsCompat).bottom;
            ((Rect)windowInsetsCompat).bottom = n10 = Math.min(n10, n14);
        }
        n11 = ((Rect)windowInsetsCompat).left;
        n13 = ((Rect)windowInsetsCompat).top;
        n10 = ((Rect)windowInsetsCompat).right;
        int n16 = ((Rect)windowInsetsCompat).bottom;
        return ((WindowInsetsCompat)object).replaceSystemWindowInsets(n11, n13, n10, n16);
    }
}

