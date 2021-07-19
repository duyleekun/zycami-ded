/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager$OnPageChangeListener;
import d.v.c.s0.h7.r0.r;
import d.v.e.h.a;

public class r$b
implements ViewPager$OnPageChangeListener {
    public final /* synthetic */ r a;

    public r$b(r r10) {
        this.a = r10;
    }

    public void onPageScrollStateChanged(int n10) {
    }

    public void onPageScrolled(int n10, float f10, int n11) {
    }

    public void onPageSelected(int n10) {
        Boolean bl2;
        MutableLiveData mutableLiveData = r.k((r)this.a).a;
        if (n10 == 0 && (n10 = (int)(d.v.e.h.a.c(bl2 = (Boolean)r.k((r)this.a).g.getValue()) ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            bl2 = null;
        }
        bl2 = n10 != 0;
        mutableLiveData.setValue(bl2);
    }
}

