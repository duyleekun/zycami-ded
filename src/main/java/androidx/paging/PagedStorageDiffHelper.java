/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PagedStorage;
import androidx.paging.PagedStorageDiffHelper$1;
import androidx.paging.PagedStorageDiffHelper$OffsettingListUpdateCallback;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.ListUpdateCallback;

public class PagedStorageDiffHelper {
    private PagedStorageDiffHelper() {
    }

    public static DiffUtil$DiffResult computeDiff(PagedStorage pagedStorage, PagedStorage pagedStorage2, DiffUtil$ItemCallback diffUtil$ItemCallback) {
        int n10 = pagedStorage.computeLeadingNulls();
        int n11 = pagedStorage2.computeLeadingNulls();
        int n12 = pagedStorage.size() - n10;
        int n13 = pagedStorage.computeTrailingNulls();
        int n14 = n12 - n13;
        n12 = pagedStorage2.size() - n11;
        n11 = pagedStorage2.computeTrailingNulls();
        int n15 = n12 - n11;
        PagedStorageDiffHelper$1 pagedStorageDiffHelper$1 = new PagedStorageDiffHelper$1(pagedStorage, n10, pagedStorage2, diffUtil$ItemCallback, n14, n15);
        return DiffUtil.calculateDiff(pagedStorageDiffHelper$1, true);
    }

    public static void dispatchDiff(ListUpdateCallback listUpdateCallback, PagedStorage object, PagedStorage pagedStorage, DiffUtil$DiffResult diffUtil$DiffResult) {
        int n10;
        int n11 = ((PagedStorage)object).computeTrailingNulls();
        int n12 = pagedStorage.computeTrailingNulls();
        int n13 = ((PagedStorage)object).computeLeadingNulls();
        int n14 = pagedStorage.computeLeadingNulls();
        if (n11 == 0 && n12 == 0 && n13 == 0 && n14 == 0) {
            diffUtil$DiffResult.dispatchUpdatesTo(listUpdateCallback);
            return;
        }
        if (n11 > n12) {
            n10 = ((PagedStorage)object).size() - (n11 -= n12);
            listUpdateCallback.onRemoved(n10, n11);
        } else if (n11 < n12) {
            n10 = ((PagedStorage)object).size();
            listUpdateCallback.onInserted(n10, n12 -= n11);
        }
        n10 = 0;
        object = null;
        if (n13 > n14) {
            listUpdateCallback.onRemoved(0, n13 -= n14);
        } else if (n13 < n14) {
            n11 = n14 - n13;
            listUpdateCallback.onInserted(0, n11);
        }
        if (n14 != 0) {
            object = new PagedStorageDiffHelper$OffsettingListUpdateCallback(n14, listUpdateCallback);
            diffUtil$DiffResult.dispatchUpdatesTo((ListUpdateCallback)object);
        } else {
            diffUtil$DiffResult.dispatchUpdatesTo(listUpdateCallback);
        }
    }

    public static int transformAnchorIndex(DiffUtil$DiffResult diffUtil$DiffResult, PagedStorage pagedStorage, PagedStorage pagedStorage2, int n10) {
        int n11 = pagedStorage.computeLeadingNulls();
        int n12 = n10 - n11;
        int n13 = pagedStorage.size() - n11;
        n11 = pagedStorage.computeTrailingNulls();
        n13 -= n11;
        n11 = 0;
        int n14 = 1;
        if (n12 >= 0 && n12 < n13) {
            int n15;
            for (n13 = 0; n13 < (n15 = 30); ++n13) {
                n15 = n13 / 2;
                int n16 = n13 % 2;
                int n17 = -1;
                n16 = n16 == n14 ? n17 : n14;
                if ((n15 = n15 * n16 + n12) < 0 || n15 >= (n16 = pagedStorage.getStorageCount())) continue;
                try {
                    n15 = diffUtil$DiffResult.convertOldPositionToNew(n15);
                    if (n15 == n17) continue;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
                int n18 = pagedStorage2.getLeadingNullCount();
                return n15 + n18;
                break;
            }
        }
        int n19 = pagedStorage2.size() - n14;
        n19 = Math.min(n10, n19);
        return Math.max(0, n19);
    }
}

