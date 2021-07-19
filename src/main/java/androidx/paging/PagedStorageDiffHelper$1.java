/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PagedStorage;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;

public final class PagedStorageDiffHelper$1
extends DiffUtil$Callback {
    public final /* synthetic */ DiffUtil$ItemCallback val$diffCallback;
    public final /* synthetic */ PagedStorage val$newList;
    public final /* synthetic */ int val$newSize;
    public final /* synthetic */ PagedStorage val$oldList;
    public final /* synthetic */ int val$oldOffset;
    public final /* synthetic */ int val$oldSize;

    public PagedStorageDiffHelper$1(PagedStorage pagedStorage, int n10, PagedStorage pagedStorage2, DiffUtil$ItemCallback diffUtil$ItemCallback, int n11, int n12) {
        this.val$oldList = pagedStorage;
        this.val$oldOffset = n10;
        this.val$newList = pagedStorage2;
        this.val$diffCallback = diffUtil$ItemCallback;
        this.val$oldSize = n11;
        this.val$newSize = n12;
    }

    public boolean areContentsTheSame(int n10, int n11) {
        Object object;
        PagedStorage pagedStorage = this.val$oldList;
        int n12 = this.val$oldOffset;
        Object object2 = pagedStorage.get(n10 += n12);
        if (object2 == (object = (pagedStorage = this.val$newList).get(n11 += (n12 = pagedStorage.getLeadingNullCount())))) {
            return true;
        }
        if (object2 != null && object != null) {
            return this.val$diffCallback.areContentsTheSame(object2, object);
        }
        return false;
    }

    public boolean areItemsTheSame(int n10, int n11) {
        Object object;
        PagedStorage pagedStorage = this.val$oldList;
        int n12 = this.val$oldOffset;
        Object object2 = pagedStorage.get(n10 += n12);
        if (object2 == (object = (pagedStorage = this.val$newList).get(n11 += (n12 = pagedStorage.getLeadingNullCount())))) {
            return true;
        }
        if (object2 != null && object != null) {
            return this.val$diffCallback.areItemsTheSame(object2, object);
        }
        return false;
    }

    public Object getChangePayload(int n10, int n11) {
        PagedStorage pagedStorage = this.val$oldList;
        int n12 = this.val$oldOffset;
        Object object = pagedStorage.get(n10 += n12);
        pagedStorage = this.val$newList;
        n12 = pagedStorage.getLeadingNullCount();
        Object object2 = pagedStorage.get(n11 += n12);
        if (object != null && object2 != null) {
            return this.val$diffCallback.getChangePayload(object, object2);
        }
        return null;
    }

    public int getNewListSize() {
        return this.val$newSize;
    }

    public int getOldListSize() {
        return this.val$oldSize;
    }
}

