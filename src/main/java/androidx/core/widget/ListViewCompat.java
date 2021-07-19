/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

public final class ListViewCompat {
    private ListViewCompat() {
    }

    public static boolean canScrollList(ListView listView, int n10) {
        int n11;
        int n12;
        int n13;
        int n14;
        block6: {
            block8: {
                block7: {
                    int n15 = Build.VERSION.SDK_INT;
                    n14 = 19;
                    if (n15 >= n14) {
                        return listView.canScrollList(n10);
                    }
                    n15 = listView.getChildCount();
                    n14 = 0;
                    if (n15 == 0) {
                        return false;
                    }
                    n13 = listView.getFirstVisiblePosition();
                    n12 = 1;
                    if (n10 <= 0) break block6;
                    n10 = n15 + -1;
                    View view = listView.getChildAt(n10);
                    n10 = view.getBottom();
                    if ((n13 += n15) < (n15 = listView.getCount())) break block7;
                    n15 = listView.getHeight();
                    int n16 = listView.getListPaddingBottom();
                    if (n10 <= (n15 -= n16)) break block8;
                }
                n14 = n12;
            }
            return n14 != 0;
        }
        View view = listView.getChildAt(0);
        n10 = view.getTop();
        if (n13 > 0 || n10 < (n11 = listView.getListPaddingTop())) {
            n14 = n12;
        }
        return n14 != 0;
    }

    public static void scrollListBy(ListView listView, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            listView.scrollListBy(n10);
        } else {
            n11 = listView.getFirstVisiblePosition();
            if (n11 == (n12 = -1)) {
                return;
            }
            n12 = 0;
            View view = listView.getChildAt(0);
            if (view == null) {
                return;
            }
            n12 = view.getTop() - n10;
            listView.setSelectionFromTop(n11, n12);
        }
    }
}

