/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import d.v.c.h1.p;
import d.v.c.i1.t2.m0;

public final class h0
extends FragmentPagerAdapter {
    private final Fragment[] a;

    public h0(FragmentManager fragmentArray) {
        int n10 = 1;
        super((FragmentManager)fragmentArray, n10);
        fragmentArray = new Fragment[2];
        this.a = fragmentArray;
        p p10 = new m0();
        fragmentArray[0] = p10;
        super();
        fragmentArray[n10] = p10;
    }

    public int getCount() {
        return this.a.length;
    }

    public Fragment getItem(int n10) {
        return this.a[n10];
    }
}

