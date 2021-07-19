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
import androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;
import java.util.List;

public class ViewTypeStorage$SharedIdRangeViewTypeStorage
implements ViewTypeStorage {
    public SparseArray mGlobalTypeToWrapper;

    public ViewTypeStorage$SharedIdRangeViewTypeStorage() {
        SparseArray sparseArray;
        this.mGlobalTypeToWrapper = sparseArray = new SparseArray();
    }

    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup viewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup = new ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup(this, nestedAdapterWrapper);
        return viewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup;
    }

    public NestedAdapterWrapper getWrapperForGlobalType(int n10) {
        boolean bl2;
        Object object = (List)this.mGlobalTypeToWrapper.get(n10);
        if (object != null && !(bl2 = object.isEmpty())) {
            return (NestedAdapterWrapper)object.get(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find the wrapper for global view type ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void removeWrapper(NestedAdapterWrapper nestedAdapterWrapper) {
        SparseArray sparseArray = this.mGlobalTypeToWrapper;
        for (int i10 = sparseArray.size() + -1; i10 >= 0; i10 += -1) {
            boolean bl2;
            List list = (List)this.mGlobalTypeToWrapper.valueAt(i10);
            boolean bl3 = list.remove(nestedAdapterWrapper);
            if (!bl3 || !(bl2 = list.isEmpty())) continue;
            list = this.mGlobalTypeToWrapper;
            list.removeAt(i10);
        }
    }
}

