/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import d.v.c.i1.s2.r;
import d.v.f.h.a;

public final class p2
extends FragmentPagerAdapter {
    private final Fragment[] a;

    public p2(FragmentManager fragmentArray) {
        int n10 = 1;
        super((FragmentManager)fragmentArray, n10);
        fragmentArray = new Fragment[2];
        a a10 = new r();
        fragmentArray[0] = a10;
        super();
        fragmentArray[n10] = a10;
        this.a = fragmentArray;
    }

    public int getCount() {
        return this.a.length;
    }

    public Fragment getItem(int n10) {
        return this.a[n10];
    }
}

