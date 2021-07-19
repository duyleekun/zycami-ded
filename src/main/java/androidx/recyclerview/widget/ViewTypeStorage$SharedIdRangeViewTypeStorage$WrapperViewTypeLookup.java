/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage$SharedIdRangeViewTypeStorage;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;
import java.util.ArrayList;

public class ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup
implements ViewTypeStorage$ViewTypeLookup {
    public final NestedAdapterWrapper mWrapper;
    public final /* synthetic */ ViewTypeStorage$SharedIdRangeViewTypeStorage this$0;

    public ViewTypeStorage$SharedIdRangeViewTypeStorage$WrapperViewTypeLookup(ViewTypeStorage$SharedIdRangeViewTypeStorage viewTypeStorage$SharedIdRangeViewTypeStorage, NestedAdapterWrapper nestedAdapterWrapper) {
        this.this$0 = viewTypeStorage$SharedIdRangeViewTypeStorage;
        this.mWrapper = nestedAdapterWrapper;
    }

    public void dispose() {
        ViewTypeStorage$SharedIdRangeViewTypeStorage viewTypeStorage$SharedIdRangeViewTypeStorage = this.this$0;
        NestedAdapterWrapper nestedAdapterWrapper = this.mWrapper;
        viewTypeStorage$SharedIdRangeViewTypeStorage.removeWrapper(nestedAdapterWrapper);
    }

    public int globalToLocal(int n10) {
        return n10;
    }

    public int localToGlobal(int n10) {
        boolean bl2;
        NestedAdapterWrapper nestedAdapterWrapper;
        ArrayList<NestedAdapterWrapper> arrayList = (ArrayList<NestedAdapterWrapper>)this.this$0.mGlobalTypeToWrapper.get(n10);
        if (arrayList == null) {
            arrayList = new ArrayList<NestedAdapterWrapper>();
            nestedAdapterWrapper = this.this$0.mGlobalTypeToWrapper;
            nestedAdapterWrapper.put(n10, arrayList);
        }
        if (!(bl2 = arrayList.contains(nestedAdapterWrapper = this.mWrapper))) {
            nestedAdapterWrapper = this.mWrapper;
            arrayList.add(nestedAdapterWrapper);
        }
        return n10;
    }
}

