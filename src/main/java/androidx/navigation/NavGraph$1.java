/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavGraph$1
implements Iterator {
    private int mIndex = -1;
    private boolean mWentToNext = false;
    public final /* synthetic */ NavGraph this$0;

    public NavGraph$1(NavGraph navGraph) {
        this.this$0 = navGraph;
    }

    public boolean hasNext() {
        int n10 = this.mIndex;
        int n11 = 1;
        SparseArrayCompat sparseArrayCompat = this.this$0.mNodes;
        int n12 = sparseArrayCompat.size();
        if ((n10 += n11) >= n12) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public NavDestination next() {
        int n10 = (int)(this.hasNext() ? 1 : 0);
        if (n10 != 0) {
            int n11;
            n10 = 1;
            this.mWentToNext = n10;
            SparseArrayCompat sparseArrayCompat = this.this$0.mNodes;
            this.mIndex = n11 = this.mIndex + n10;
            return (NavDestination)sparseArrayCompat.valueAt(n11);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        int n10 = this.mWentToNext;
        if (n10 != 0) {
            SparseArrayCompat sparseArrayCompat = this.this$0.mNodes;
            int n11 = this.mIndex;
            ((NavDestination)sparseArrayCompat.valueAt(n11)).setParent(null);
            sparseArrayCompat = this.this$0.mNodes;
            n11 = this.mIndex;
            sparseArrayCompat.removeAt(n11);
            this.mIndex = n10 = this.mIndex + -1;
            this.mWentToNext = false;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("You must call next() before you can remove an element");
        throw illegalStateException;
    }
}

