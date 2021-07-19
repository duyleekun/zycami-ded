/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;

public class ViewTypeStorage$IsolatedViewTypeStorage
implements ViewTypeStorage {
    public SparseArray mGlobalTypeToWrapper;
    public int mNextViewType;

    public ViewTypeStorage$IsolatedViewTypeStorage() {
        SparseArray sparseArray;
        this.mGlobalTypeToWrapper = sparseArray = new SparseArray();
        this.mNextViewType = 0;
    }

    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup viewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup = new ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup(this, nestedAdapterWrapper);
        return viewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup;
    }

    public NestedAdapterWrapper getWrapperForGlobalType(int n10) {
        Object object = (NestedAdapterWrapper)this.mGlobalTypeToWrapper.get(n10);
        if (object != null) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find the wrapper for global view type ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public int obtainViewType(NestedAdapterWrapper nestedAdapterWrapper) {
        int n10;
        int n11 = this.mNextViewType;
        this.mNextViewType = n10 = n11 + 1;
        this.mGlobalTypeToWrapper.put(n11, (Object)nestedAdapterWrapper);
        return n11;
    }

    public void removeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        SparseArray sparseArray = this.mGlobalTypeToWrapper;
        for (int i10 = sparseArray.size() + -1; i10 >= 0; i10 += -1) {
            NestedAdapterWrapper nestedAdapterWrapper2 = (NestedAdapterWrapper)this.mGlobalTypeToWrapper.valueAt(i10);
            if (nestedAdapterWrapper2 != nestedAdapterWrapper) continue;
            nestedAdapterWrapper2 = this.mGlobalTypeToWrapper;
            nestedAdapterWrapper2.removeAt(i10);
        }
    }
}

