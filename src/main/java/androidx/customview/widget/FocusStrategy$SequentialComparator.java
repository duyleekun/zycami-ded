/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.customview.widget;

import android.graphics.Rect;
import androidx.customview.widget.FocusStrategy$BoundsAdapter;
import java.util.Comparator;

public class FocusStrategy$SequentialComparator
implements Comparator {
    private final FocusStrategy$BoundsAdapter mAdapter;
    private final boolean mIsLayoutRtl;
    private final Rect mTemp1;
    private final Rect mTemp2;

    public FocusStrategy$SequentialComparator(boolean bl2, FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter) {
        Rect rect;
        this.mTemp1 = rect = new Rect();
        this.mTemp2 = rect = new Rect();
        this.mIsLayoutRtl = bl2;
        this.mAdapter = focusStrategy$BoundsAdapter;
    }

    public int compare(Object object, Object object2) {
        Rect rect = this.mTemp1;
        Rect rect2 = this.mTemp2;
        FocusStrategy$BoundsAdapter focusStrategy$BoundsAdapter = this.mAdapter;
        focusStrategy$BoundsAdapter.obtainBounds(object, rect);
        object = this.mAdapter;
        object.obtainBounds(object2, rect2);
        int n10 = rect.top;
        int n11 = rect2.top;
        int n12 = -1;
        if (n10 < n11) {
            return n12;
        }
        int n13 = 1;
        if (n10 > n11) {
            return n13;
        }
        n10 = rect.left;
        n11 = rect2.left;
        if (n10 < n11) {
            n10 = (int)(this.mIsLayoutRtl ? 1 : 0);
            if (n10 != 0) {
                n12 = n13;
            }
            return n12;
        }
        if (n10 > n11) {
            n10 = (int)(this.mIsLayoutRtl ? 1 : 0);
            if (n10 == 0) {
                n12 = n13;
            }
            return n12;
        }
        n10 = rect.bottom;
        n11 = rect2.bottom;
        if (n10 < n11) {
            return n12;
        }
        if (n10 > n11) {
            return n13;
        }
        n10 = rect.right;
        n11 = rect2.right;
        if (n10 < n11) {
            n10 = (int)(this.mIsLayoutRtl ? 1 : 0);
            if (n10 != 0) {
                n12 = n13;
            }
            return n12;
        }
        if (n10 > n11) {
            n10 = (int)(this.mIsLayoutRtl ? 1 : 0);
            if (n10 == 0) {
                n12 = n13;
            }
            return n12;
        }
        return 0;
    }
}

