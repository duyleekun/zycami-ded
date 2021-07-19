/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 */
package androidx.viewpager.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;

public class PagerTitleStrip$PageListener
extends DataSetObserver
implements ViewPager$OnPageChangeListener,
ViewPager$OnAdapterChangeListener {
    private int mScrollState;
    public final /* synthetic */ PagerTitleStrip this$0;

    public PagerTitleStrip$PageListener(PagerTitleStrip pagerTitleStrip) {
        this.this$0 = pagerTitleStrip;
    }

    public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        this.this$0.updateAdapter(pagerAdapter, pagerAdapter2);
    }

    public void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.this$0;
        ViewPager viewPager = pagerTitleStrip.mPager;
        int n10 = viewPager.getCurrentItem();
        PagerAdapter pagerAdapter = this.this$0.mPager.getAdapter();
        pagerTitleStrip.updateText(n10, pagerAdapter);
        pagerTitleStrip = this.this$0;
        float f10 = pagerTitleStrip.mLastKnownPositionOffset;
        int n11 = 0;
        pagerAdapter = null;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (f12 < 0) {
            n10 = 0;
            viewPager = null;
            f10 = 0.0f;
        }
        n11 = pagerTitleStrip.mPager.getCurrentItem();
        pagerTitleStrip.updateTextPositions(n11, f10, true);
    }

    public void onPageScrollStateChanged(int n10) {
        this.mScrollState = n10;
    }

    public void onPageScrolled(int n10, float f10, int n11) {
        float f11 = 0.5f;
        float f12 = f10 - f11;
        n11 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
        if (n11 > 0) {
            ++n10;
        }
        this.this$0.updateTextPositions(n10, f10, false);
    }

    public void onPageSelected(int n10) {
        n10 = this.mScrollState;
        if (n10 == 0) {
            PagerTitleStrip pagerTitleStrip = this.this$0;
            ViewPager viewPager = pagerTitleStrip.mPager;
            int n11 = viewPager.getCurrentItem();
            Object object = this.this$0.mPager.getAdapter();
            pagerTitleStrip.updateText(n11, (PagerAdapter)object);
            pagerTitleStrip = this.this$0;
            float f10 = pagerTitleStrip.mLastKnownPositionOffset;
            int n12 = 0;
            object = null;
            float f11 = f10 - 0.0f;
            float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (f12 < 0) {
                n11 = 0;
                viewPager = null;
                f10 = 0.0f;
            }
            object = pagerTitleStrip.mPager;
            n12 = ((ViewPager)((Object)object)).getCurrentItem();
            f12 = 1.0f;
            pagerTitleStrip.updateTextPositions(n12, f10, (boolean)f12);
        }
    }
}

