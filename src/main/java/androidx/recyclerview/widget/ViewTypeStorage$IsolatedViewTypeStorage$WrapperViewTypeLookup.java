/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package androidx.recyclerview.widget;

import android.util.SparseIntArray;
import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage$IsolatedViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;

public class ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup
implements ViewTypeStorage$ViewTypeLookup {
    private SparseIntArray mGlobalToLocalMapping;
    private SparseIntArray mLocalToGlobalMapping;
    public final NestedAdapterWrapper mWrapper;
    public final /* synthetic */ ViewTypeStorage$IsolatedViewTypeStorage this$0;

    public ViewTypeStorage$IsolatedViewTypeStorage$WrapperViewTypeLookup(ViewTypeStorage$IsolatedViewTypeStorage viewTypeStorage$IsolatedViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = viewTypeStorage$IsolatedViewTypeStorage;
        int n10 = 1;
        super(n10);
        this.mLocalToGlobalMapping = viewTypeStorage$IsolatedViewTypeStorage;
        super(n10);
        this.mGlobalToLocalMapping = viewTypeStorage$IsolatedViewTypeStorage;
        this.mWrapper = nestedAdapterWrapper;
    }

    public void dispose() {
        ViewTypeStorage$IsolatedViewTypeStorage viewTypeStorage$IsolatedViewTypeStorage = this.this$0;
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrapper;
        viewTypeStorage$IsolatedViewTypeStorage.removeWrapper(nestedAdapterWrapper);
    }

    public int globalToLocal(int n10) {
        Object object = this.mGlobalToLocalMapping;
        int n11 = object.indexOfKey(n10);
        if (n11 >= 0) {
            return this.mGlobalToLocalMapping.valueAt(n11);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("requested global type ");
        stringBuilder.append(n10);
        stringBuilder.append(" does not belong to the adapter:");
        Object object2 = this.mWrapper.adapter;
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public int localToGlobal(int n10) {
        int n11;
        Object object = this.mLocalToGlobalMapping;
        int n12 = object.indexOfKey(n10);
        if (n12 > (n11 = -1)) {
            return this.mLocalToGlobalMapping.valueAt(n12);
        }
        object = this.this$0;
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrapper;
        n12 = ((ViewTypeStorage$IsolatedViewTypeStorage)object).obtainViewType(nestedAdapterWrapper);
        this.mLocalToGlobalMapping.put(n10, n12);
        this.mGlobalToLocalMapping.put(n12, n10);
        return n12;
    }
}

