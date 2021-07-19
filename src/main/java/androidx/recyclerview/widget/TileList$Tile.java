/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import java.lang.reflect.Array;

public class TileList$Tile {
    public int mItemCount;
    public final Object[] mItems;
    public TileList$Tile mNext;
    public int mStartPosition;

    public TileList$Tile(Class objectArray, int n10) {
        objectArray = (Object[])Array.newInstance(objectArray, n10);
        this.mItems = objectArray;
    }

    public boolean containsPosition(int n10) {
        int n11;
        int n12 = this.mStartPosition;
        n10 = n12 <= n10 && n10 < (n12 += (n11 = this.mItemCount)) ? 1 : 0;
        return n10 != 0;
    }

    public Object getByPosition(int n10) {
        Object[] objectArray = this.mItems;
        int n11 = this.mStartPosition;
        return objectArray[n10 -= n11];
    }
}

