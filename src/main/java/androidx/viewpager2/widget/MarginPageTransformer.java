/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$PageTransformer;

public final class MarginPageTransformer
implements ViewPager2$PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int n10) {
        Preconditions.checkArgumentNonnegative(n10, "Margin must be non-negative");
        this.mMarginPx = n10;
    }

    private ViewPager2 requireViewPager(View object) {
        object = object.getParent();
        ViewParent viewParent = object.getParent();
        boolean bl2 = object instanceof RecyclerView;
        if (bl2 && (bl2 = viewParent instanceof ViewPager2)) {
            return (ViewPager2)viewParent;
        }
        object = new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
        throw object;
    }

    public void transformPage(View view, float f10) {
        ViewPager2 viewPager2 = this.requireViewPager(view);
        int n10 = this.mMarginPx;
        float f11 = (float)n10 * f10;
        int n11 = viewPager2.getOrientation();
        if (n11 == 0) {
            n11 = (int)(viewPager2.isRtl() ? 1 : 0);
            if (n11 != 0) {
                f11 = -f11;
            }
            view.setTranslationX(f11);
        } else {
            view.setTranslationY(f11);
        }
    }
}

