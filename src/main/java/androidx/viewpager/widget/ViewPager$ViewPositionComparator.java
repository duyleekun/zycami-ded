/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.viewpager.widget;

import android.view.View;
import androidx.viewpager.widget.ViewPager$LayoutParams;
import java.util.Comparator;

public class ViewPager$ViewPositionComparator
implements Comparator {
    public int compare(View object, View object2) {
        object = (ViewPager$LayoutParams)object.getLayoutParams();
        object2 = (ViewPager$LayoutParams)object2.getLayoutParams();
        boolean bl2 = object.isDecor;
        boolean bl3 = object2.isDecor;
        if (bl2 != bl3) {
            int n10 = bl2 ? 1 : -1;
            return n10;
        }
        int n11 = object.position;
        int n12 = object2.position;
        return n11 - n12;
    }
}

