/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.NestedAdapterWrapper;
import androidx.recyclerview.widget.ViewTypeStorage$ViewTypeLookup;

public interface ViewTypeStorage {
    public ViewTypeStorage$ViewTypeLookup createViewTypeWrapper(NestedAdapterWrapper var1);

    public NestedAdapterWrapper getWrapperForGlobalType(int var1);
}

