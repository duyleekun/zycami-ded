/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.r0;

import com.google.android.material.tabs.TabLayout$OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import d.v.c.s0.h7.r0.r;

public class r$c
implements TabLayout$OnTabSelectedListener {
    public final /* synthetic */ r a;

    public r$c(r r10) {
        this.a = r10;
    }

    public void onTabReselected(TabLayout$Tab tabLayout$Tab) {
    }

    public void onTabSelected(TabLayout$Tab tabLayout$Tab) {
        r.l(this.a, tabLayout$Tab, true);
    }

    public void onTabUnselected(TabLayout$Tab tabLayout$Tab) {
        r.l(this.a, tabLayout$Tab, false);
    }
}

