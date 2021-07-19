/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager.widget;

import androidx.viewpager.widget.ViewPager$ItemInfo;
import java.util.Comparator;

public final class ViewPager$1
implements Comparator {
    public int compare(ViewPager$ItemInfo viewPager$ItemInfo, ViewPager$ItemInfo viewPager$ItemInfo2) {
        int n10 = viewPager$ItemInfo.position;
        int n11 = viewPager$ItemInfo2.position;
        return n10 - n11;
    }
}

