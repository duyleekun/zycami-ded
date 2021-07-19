/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

public class PagerTabStrip$2
implements View.OnClickListener {
    public final /* synthetic */ PagerTabStrip this$0;

    public PagerTabStrip$2(PagerTabStrip pagerTabStrip) {
        this.this$0 = pagerTabStrip;
    }

    public void onClick(View object) {
        object = this.this$0.mPager;
        int n10 = ((ViewPager)((Object)object)).getCurrentItem() + 1;
        ((ViewPager)((Object)object)).setCurrentItem(n10);
    }
}

