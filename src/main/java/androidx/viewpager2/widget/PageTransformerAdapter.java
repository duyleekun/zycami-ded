/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import androidx.viewpager2.widget.ViewPager2$PageTransformer;
import java.util.Locale;

public final class PageTransformerAdapter
extends ViewPager2$OnPageChangeCallback {
    private final LinearLayoutManager mLayoutManager;
    private ViewPager2$PageTransformer mPageTransformer;

    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.mLayoutManager = linearLayoutManager;
    }

    public ViewPager2$PageTransformer getPageTransformer() {
        return this.mPageTransformer;
    }

    public void onPageScrollStateChanged(int n10) {
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        View view;
        int n12;
        Object object = this.mPageTransformer;
        if (object == null) {
            return;
        }
        f10 = -f10;
        object = null;
        Integer n13 = null;
        for (int i10 = 0; i10 < (n12 = (view = this.mLayoutManager).getChildCount()); ++i10) {
            view = this.mLayoutManager.getChildAt(i10);
            if (view != null) {
                LinearLayoutManager linearLayoutManager = this.mLayoutManager;
                int n14 = linearLayoutManager.getPosition(view) - n10;
                float f11 = (float)n14 + f10;
                ViewPager2$PageTransformer viewPager2$PageTransformer = this.mPageTransformer;
                viewPager2$PageTransformer.transformPage(view, f11);
                continue;
            }
            Object object2 = Locale.US;
            view = new Object[2];
            n13 = i10;
            view[0] = n13;
            view[1] = object = Integer.valueOf(this.mLayoutManager.getChildCount());
            object2 = String.format((Locale)object2, "LayoutManager returned a null child at pos %d/%d while transforming pages", (Object[])view);
            IllegalStateException illegalStateException = new IllegalStateException((String)object2);
            throw illegalStateException;
        }
    }

    public void onPageSelected(int n10) {
    }

    public void setPageTransformer(ViewPager2$PageTransformer viewPager2$PageTransformer) {
        this.mPageTransformer = viewPager2$PageTransformer;
    }
}

