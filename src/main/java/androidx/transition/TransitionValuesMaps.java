/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package androidx.transition;

import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

public class TransitionValuesMaps {
    public final SparseArray mIdValues;
    public final LongSparseArray mItemIdValues;
    public final ArrayMap mNameValues;
    public final ArrayMap mViewValues;

    public TransitionValuesMaps() {
        Object object = new ArrayMap();
        this.mViewValues = object;
        this.mIdValues = object;
        this.mItemIdValues = object = new LongSparseArray();
        this.mNameValues = object = new ArrayMap();
    }
}

