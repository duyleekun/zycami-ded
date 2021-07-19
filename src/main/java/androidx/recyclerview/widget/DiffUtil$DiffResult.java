/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.BatchingListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$Diagonal;
import androidx.recyclerview.widget.DiffUtil$PostponedUpdate;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DiffUtil$DiffResult {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_MASK = 15;
    private static final int FLAG_MOVED = 12;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 4;
    public static final int NO_POSITION = 255;
    private final DiffUtil$Callback mCallback;
    private final boolean mDetectMoves;
    private final List mDiagonals;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;

    public DiffUtil$DiffResult(DiffUtil$Callback diffUtil$Callback, List list, int[] nArray, int[] nArray2, boolean bl2) {
        int n10;
        int n11;
        this.mDiagonals = list;
        this.mOldItemStatuses = nArray;
        this.mNewItemStatuses = nArray2;
        Arrays.fill(nArray, 0);
        Arrays.fill(nArray2, 0);
        this.mCallback = diffUtil$Callback;
        this.mOldListSize = n11 = diffUtil$Callback.getOldListSize();
        this.mNewListSize = n10 = diffUtil$Callback.getNewListSize();
        this.mDetectMoves = bl2;
        this.addEdgeDiagonals();
        this.findMatchingItems();
    }

    private void addEdgeDiagonals() {
        DiffUtil$Diagonal diffUtil$Diagonal;
        int n10;
        Object object = this.mDiagonals;
        int n11 = object.isEmpty();
        if (n11 != 0) {
            n11 = 0;
            object = null;
        } else {
            object = (DiffUtil$Diagonal)this.mDiagonals.get(0);
        }
        if (object == null || (n10 = ((DiffUtil$Diagonal)object).x) != 0 || (n11 = ((DiffUtil$Diagonal)object).y) != 0) {
            object = this.mDiagonals;
            diffUtil$Diagonal = new DiffUtil$Diagonal(0, 0, 0);
            object.add(0, diffUtil$Diagonal);
        }
        object = this.mDiagonals;
        int n12 = this.mOldListSize;
        int n13 = this.mNewListSize;
        diffUtil$Diagonal = new DiffUtil$Diagonal(n12, n13, 0);
        object.add(diffUtil$Diagonal);
    }

    private void findMatchingAddition(int n10) {
        Object object = this.mDiagonals;
        int n11 = object.size();
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13;
            Object object2 = (DiffUtil$Diagonal)this.mDiagonals.get(i10);
            while (n12 < (n13 = ((DiffUtil$Diagonal)object2).y)) {
                Object object3 = this.mNewItemStatuses;
                n13 = object3[n12];
                if (n13 == 0 && (n13 = (int)((object3 = (Object)this.mCallback).areItemsTheSame(n10, n12) ? 1 : 0)) != 0) {
                    object = this.mCallback;
                    n11 = (int)(((DiffUtil$Callback)object).areContentsTheSame(n10, n12) ? 1 : 0);
                    i10 = 4;
                    n11 = n11 != 0 ? 8 : i10;
                    object2 = this.mOldItemStatuses;
                    n13 = n12 << 4 | n11;
                    object2[n10] = n13;
                    object2 = this.mNewItemStatuses;
                    n10 = n10 << i10 | n11;
                    object2[n12] = n10;
                    return;
                }
                ++n12;
            }
            n12 = ((DiffUtil$Diagonal)object2).endY();
        }
    }

    private void findMatchingItems() {
        boolean bl2;
        Iterator iterator2 = this.mDiagonals.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n10;
            DiffUtil$Diagonal diffUtil$Diagonal = (DiffUtil$Diagonal)iterator2.next();
            for (int i10 = 0; i10 < (n10 = diffUtil$Diagonal.size); ++i10) {
                int n11;
                DiffUtil$Callback diffUtil$Callback = this.mCallback;
                n10 = diffUtil$Diagonal.x + i10;
                int n12 = diffUtil$Diagonal.y + i10;
                int n13 = diffUtil$Callback.areContentsTheSame(n10, n12);
                n13 = n13 != 0 ? 1 : 2;
                int[] nArray = this.mOldItemStatuses;
                nArray[n10] = n11 = n12 << 4 | n13;
                nArray = this.mNewItemStatuses;
                nArray[n12] = n10 = n10 << 4 | n13;
            }
        }
        boolean bl3 = this.mDetectMoves;
        if (bl3) {
            this.findMoveMatches();
        }
    }

    private void findMoveMatches() {
        boolean bl2;
        Iterator iterator2 = this.mDiagonals.iterator();
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            int n11;
            DiffUtil$Diagonal diffUtil$Diagonal = (DiffUtil$Diagonal)iterator2.next();
            while (n10 < (n11 = diffUtil$Diagonal.x)) {
                int[] nArray = this.mOldItemStatuses;
                n11 = nArray[n10];
                if (n11 == 0) {
                    this.findMatchingAddition(n10);
                }
                ++n10;
            }
            n10 = diffUtil$Diagonal.endX();
        }
    }

    private static DiffUtil$PostponedUpdate getPostponedUpdate(Collection object, int n10, boolean n11) {
        int n12;
        DiffUtil$PostponedUpdate diffUtil$PostponedUpdate;
        block3: {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                diffUtil$PostponedUpdate = (DiffUtil$PostponedUpdate)object.next();
                n12 = diffUtil$PostponedUpdate.posInOwnerList;
                if (n12 != n10 || (n12 = (int)(diffUtil$PostponedUpdate.removal ? 1 : 0)) != n11) continue;
                object.remove();
                break block3;
            }
            bl2 = false;
            diffUtil$PostponedUpdate = null;
        }
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            DiffUtil$PostponedUpdate diffUtil$PostponedUpdate2 = (DiffUtil$PostponedUpdate)object.next();
            if (n11 != 0) {
                diffUtil$PostponedUpdate2.currentPos = n12 = diffUtil$PostponedUpdate2.currentPos + -1;
                continue;
            }
            diffUtil$PostponedUpdate2.currentPos = n12 = diffUtil$PostponedUpdate2.currentPos + 1;
        }
        return diffUtil$PostponedUpdate;
    }

    public int convertNewPositionToOld(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.mNewListSize)) {
            int[] nArray = this.mNewItemStatuses;
            n11 = (n10 = nArray[n10]) & 0xF;
            if (n11 == 0) {
                return -1;
            }
            return n10 >> 4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index out of bounds - passed position = ");
        stringBuilder.append(n10);
        stringBuilder.append(", new list size = ");
        n10 = this.mNewListSize;
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public int convertOldPositionToNew(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.mOldListSize)) {
            int[] nArray = this.mOldItemStatuses;
            n11 = (n10 = nArray[n10]) & 0xF;
            if (n11 == 0) {
                return -1;
            }
            return n10 >> 4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index out of bounds - passed position = ");
        stringBuilder.append(n10);
        stringBuilder.append(", old list size = ");
        n10 = this.mOldListSize;
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public void dispatchUpdatesTo(ListUpdateCallback listUpdateCallback) {
        int n10 = listUpdateCallback instanceof BatchingListUpdateCallback;
        if (n10 != 0) {
            listUpdateCallback = (BatchingListUpdateCallback)listUpdateCallback;
        } else {
            BatchingListUpdateCallback batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            listUpdateCallback = batchingListUpdateCallback;
        }
        n10 = this.mOldListSize;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
        int n11 = this.mOldListSize;
        int n12 = this.mNewListSize;
        List list = this.mDiagonals;
        int n13 = list.size();
        int n14 = 1;
        n13 -= n14;
        while (n13 >= 0) {
            Object object;
            int n15;
            int n16;
            int n17;
            DiffUtil$Diagonal diffUtil$Diagonal = (DiffUtil$Diagonal)this.mDiagonals.get(n13);
            int n18 = diffUtil$Diagonal.endX();
            int n19 = diffUtil$Diagonal.endY();
            while (true) {
                n17 = 0;
                DiffUtil$PostponedUpdate diffUtil$PostponedUpdate = null;
                if (n11 <= n18) break;
                Object object2 = this.mOldItemStatuses;
                n16 = object2[n11 += -1];
                n15 = n16 & 0xC;
                if (n15 != 0) {
                    n15 = n16 >> 4;
                    diffUtil$PostponedUpdate = DiffUtil$DiffResult.getPostponedUpdate(arrayDeque, n15, false);
                    if (diffUtil$PostponedUpdate != null) {
                        n17 = diffUtil$PostponedUpdate.currentPos;
                        n17 = n10 - n17 - n14;
                        ((BatchingListUpdateCallback)listUpdateCallback).onMoved(n11, n17);
                        if ((n16 &= 4) == 0) continue;
                        object2 = this.mCallback.getChangePayload(n11, n15);
                        ((BatchingListUpdateCallback)listUpdateCallback).onChanged(n17, n14, object2);
                        continue;
                    }
                    n16 = n10 - n11 - n14;
                    diffUtil$PostponedUpdate = new DiffUtil$PostponedUpdate(n11, n16, n14 != 0);
                    arrayDeque.add(diffUtil$PostponedUpdate);
                    continue;
                }
                ((BatchingListUpdateCallback)listUpdateCallback).onRemoved(n11, n14);
                n10 += -1;
            }
            while (n12 > n19) {
                object = this.mNewItemStatuses;
                n18 = object[n12 += -1];
                n16 = n18 & 0xC;
                if (n16 != 0) {
                    n16 = n18 >> 4;
                    DiffUtil$PostponedUpdate diffUtil$PostponedUpdate = DiffUtil$DiffResult.getPostponedUpdate(arrayDeque, n16, n14 != 0);
                    if (diffUtil$PostponedUpdate == null) {
                        object = new DiffUtil$PostponedUpdate;
                        n16 = n10 - n11;
                        object(n12, n16, false);
                        arrayDeque.add(object);
                        continue;
                    }
                    n15 = diffUtil$PostponedUpdate.currentPos;
                    n15 = n10 - n15 - n14;
                    ((BatchingListUpdateCallback)listUpdateCallback).onMoved(n15, n11);
                    if ((n18 &= 4) == 0) continue;
                    object = this.mCallback.getChangePayload(n16, n12);
                    ((BatchingListUpdateCallback)listUpdateCallback).onChanged(n11, n14, object);
                    continue;
                }
                ((BatchingListUpdateCallback)listUpdateCallback).onInserted(n11, n14);
                ++n10;
            }
            n11 = diffUtil$Diagonal.x;
            n12 = diffUtil$Diagonal.y;
            while (n17 < (n18 = diffUtil$Diagonal.size)) {
                object = this.mOldItemStatuses;
                n18 = object[n11] & 0xF;
                n19 = 2;
                if (n18 == n19) {
                    object = this.mCallback.getChangePayload(n11, n12);
                    ((BatchingListUpdateCallback)listUpdateCallback).onChanged(n11, n14, object);
                }
                ++n11;
                ++n12;
                ++n17;
            }
            n11 = diffUtil$Diagonal.x;
            n12 = diffUtil$Diagonal.y;
            n13 += -1;
        }
        ((BatchingListUpdateCallback)listUpdateCallback).dispatchLastEvent();
    }

    public void dispatchUpdatesTo(RecyclerView$Adapter recyclerView$Adapter) {
        AdapterListUpdateCallback adapterListUpdateCallback = new AdapterListUpdateCallback(recyclerView$Adapter);
        this.dispatchUpdatesTo(adapterListUpdateCallback);
    }
}

