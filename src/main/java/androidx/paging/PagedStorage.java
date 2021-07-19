/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PagedStorage$Callback;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public final class PagedStorage
extends AbstractList {
    private static final List PLACEHOLDER_LIST;
    private int mLeadingNullCount;
    private int mLoadedCount;
    private int mNumberAppended;
    private int mNumberPrepended;
    private int mPageSize;
    private final ArrayList mPages;
    private int mPositionOffset;
    private int mStorageCount;
    private int mTrailingNullCount;

    static {
        ArrayList arrayList;
        PLACEHOLDER_LIST = arrayList = new ArrayList();
    }

    public PagedStorage() {
        ArrayList arrayList;
        this.mLeadingNullCount = 0;
        this.mPages = arrayList = new ArrayList();
        this.mTrailingNullCount = 0;
        this.mPositionOffset = 0;
        this.mLoadedCount = 0;
        this.mStorageCount = 0;
        this.mPageSize = 1;
        this.mNumberPrepended = 0;
        this.mNumberAppended = 0;
    }

    public PagedStorage(int n10, List list, int n11) {
        this();
        this.init(n10, list, n11, 0);
    }

    private PagedStorage(PagedStorage pagedStorage) {
        int n10;
        ArrayList arrayList;
        int n11;
        this.mLeadingNullCount = n11 = pagedStorage.mLeadingNullCount;
        ArrayList arrayList2 = pagedStorage.mPages;
        this.mPages = arrayList = new ArrayList(arrayList2);
        this.mTrailingNullCount = n11 = pagedStorage.mTrailingNullCount;
        this.mPositionOffset = n11 = pagedStorage.mPositionOffset;
        this.mLoadedCount = n11 = pagedStorage.mLoadedCount;
        this.mStorageCount = n11 = pagedStorage.mStorageCount;
        this.mPageSize = n11 = pagedStorage.mPageSize;
        this.mNumberPrepended = n11 = pagedStorage.mNumberPrepended;
        this.mNumberAppended = n10 = pagedStorage.mNumberAppended;
    }

    private void init(int n10, List list, int n11, int n12) {
        this.mLeadingNullCount = n10;
        this.mPages.clear();
        this.mPages.add(list);
        this.mTrailingNullCount = n11;
        this.mPositionOffset = n12;
        this.mLoadedCount = n10 = list.size();
        this.mStorageCount = n10;
        this.mPageSize = n10 = list.size();
        this.mNumberPrepended = 0;
        this.mNumberAppended = 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean needsTrim(int n10, int n11, int n12) {
        ArrayList arrayList = this.mPages;
        List list = (List)arrayList.get(n12);
        if (list == null) return 1 != 0;
        int n13 = this.mLoadedCount;
        if (n13 <= n10) return 0 != 0;
        ArrayList arrayList2 = this.mPages;
        n10 = arrayList2.size();
        if (n10 <= (n13 = 2)) return 0 != 0;
        List list2 = PLACEHOLDER_LIST;
        if (list == list2) return 0 != 0;
        n10 = this.mLoadedCount;
        n12 = list.size();
        if ((n10 -= n12) < n11) return 0 != 0;
        return 1 != 0;
    }

    public void allocatePageRange(int n10, int n11) {
        int n12;
        int n13;
        ArrayList arrayList;
        ArrayList arrayList2;
        int n14;
        int n15 = this.mLeadingNullCount;
        int n16 = this.mPageSize;
        n15 /= n16;
        n16 = 0;
        if (n10 < n15) {
            n14 = 0;
            arrayList2 = null;
            arrayList = null;
            for (n13 = 0; n13 < (n12 = n15 - n10); ++n13) {
                ArrayList arrayList3 = this.mPages;
                arrayList3.add(0, null);
            }
            n15 = this.mPageSize;
            n12 *= n15;
            this.mStorageCount = n15 = this.mStorageCount + n12;
            this.mLeadingNullCount = n15 = this.mLeadingNullCount - n12;
        } else {
            n10 = n15;
        }
        ArrayList arrayList4 = this.mPages;
        n15 = arrayList4.size() + n10;
        if (n11 >= n15) {
            n15 = this.mTrailingNullCount;
            n14 = n11 + 1;
            arrayList = this.mPages;
            n13 = arrayList.size() + n10;
            n14 -= n13;
            n13 = this.mPageSize;
            n15 = Math.min(n15, n14 *= n13);
            arrayList2 = this.mPages;
            for (n14 = arrayList2.size(); n14 <= (n13 = n11 - n10); ++n14) {
                arrayList = this.mPages;
                n12 = arrayList.size();
                arrayList.add(n12, null);
            }
            this.mStorageCount = n10 = this.mStorageCount + n15;
            this.mTrailingNullCount = n10 = this.mTrailingNullCount - n15;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void allocatePlaceholders(int n10, int n11, int n12, PagedStorage$Callback pagedStorage$Callback) {
        ArrayList arrayList;
        int n13 = this.mPageSize;
        int n14 = 1;
        if (n12 != n13) {
            if (n12 < n13) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Page size cannot be reduced");
                throw illegalArgumentException;
            }
            arrayList = this.mPages;
            n13 = arrayList.size();
            if (n13 == n14 && (n13 = this.mTrailingNullCount) == 0) {
                this.mPageSize = n12;
            } else {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Page size can change only if last page is only one present");
                throw illegalArgumentException;
            }
        }
        n12 = this.size();
        n13 = this.mPageSize;
        n12 = (n12 + n13 - n14) / n13;
        int n15 = (n10 - n11) / n13;
        arrayList = null;
        n13 = Math.max(n15, 0);
        n10 += n11;
        n11 = this.mPageSize;
        n10 /= n11;
        n10 = Math.min(n10, n12 -= n14);
        this.allocatePageRange(n13, n10);
        n11 = this.mLeadingNullCount;
        n12 = this.mPageSize;
        n11 /= n12;
        while (n13 <= n10) {
            n12 = n13 - n11;
            Object e10 = this.mPages.get(n12);
            if (e10 == null) {
                ArrayList arrayList2 = this.mPages;
                List list = PLACEHOLDER_LIST;
                arrayList2.set(n12, list);
                pagedStorage$Callback.onPagePlaceholderInserted(n13);
            }
            ++n13;
        }
        return;
    }

    public void appendPage(List list, PagedStorage$Callback pagedStorage$Callback) {
        int n10;
        int n11;
        List list2;
        int n12 = list.size();
        if (n12 == 0) {
            pagedStorage$Callback.onEmptyAppend();
            return;
        }
        int n13 = this.mPageSize;
        if (n13 > 0) {
            list2 = this.mPages;
            n11 = ((ArrayList)list2).size() + -1;
            n13 = (list2 = (List)((ArrayList)list2).get(n11)).size();
            if (n13 != (n11 = this.mPageSize) || n12 > n11) {
                this.mPageSize = n13 = -1;
            }
        }
        list2 = this.mPages;
        ((ArrayList)list2).add(list);
        this.mLoadedCount = n10 = this.mLoadedCount + n12;
        this.mStorageCount = n10 = this.mStorageCount + n12;
        n10 = Math.min(this.mTrailingNullCount, n12);
        n13 = n12 - n10;
        if (n10 != 0) {
            this.mTrailingNullCount = n11 = this.mTrailingNullCount - n10;
        }
        this.mNumberAppended = n11 = this.mNumberAppended + n12;
        n11 = this.mLeadingNullCount;
        int n14 = this.mStorageCount;
        n11 = n11 + n14 - n12;
        pagedStorage$Callback.onPageAppended(n11, n10, n13);
    }

    public int computeLeadingNulls() {
        List list;
        List list2;
        int n10 = this.mLeadingNullCount;
        ArrayList arrayList = this.mPages;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11 && ((list2 = (List)this.mPages.get(i10)) == null || list2 == (list = PLACEHOLDER_LIST)); ++i10) {
            int n12 = this.mPageSize;
            n10 += n12;
        }
        return n10;
    }

    public int computeTrailingNulls() {
        List list;
        List list2;
        int n10 = this.mTrailingNullCount;
        ArrayList arrayList = this.mPages;
        for (int i10 = arrayList.size() + -1; i10 >= 0 && ((list2 = (List)this.mPages.get(i10)) == null || list2 == (list = PLACEHOLDER_LIST)); i10 += -1) {
            int n11 = this.mPageSize;
            n10 += n11;
        }
        return n10;
    }

    public Object get(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size())) {
            int n12;
            n11 = this.mLeadingNullCount;
            n10 -= n11;
            n11 = 0;
            Object var3_3 = null;
            if (n10 >= 0 && n10 < (n12 = this.mStorageCount)) {
                List list;
                int n13;
                n12 = (int)(this.isTiled() ? 1 : 0);
                if (n12 != 0) {
                    n12 = this.mPageSize;
                    n13 = n10 / n12;
                    n10 %= n12;
                } else {
                    List list2;
                    int n14;
                    list = this.mPages;
                    n12 = ((ArrayList)list).size();
                    for (n13 = 0; n13 < n12 && (n14 = (list2 = (List)this.mPages.get(n13)).size()) <= n10; n10 -= n14, ++n13) {
                    }
                }
                list = (List)this.mPages.get(n13);
                if (list != null && (n13 = list.size()) != 0) {
                    return list.get(n10);
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n10);
        stringBuilder.append(", Size: ");
        n10 = this.size();
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public Object getFirstLoadedItem() {
        return ((List)this.mPages.get(0)).get(0);
    }

    public Object getLastLoadedItem() {
        List list = this.mPages;
        int n10 = ((ArrayList)list).size() + -1;
        list = (List)((ArrayList)list).get(n10);
        n10 = list.size() + -1;
        return list.get(n10);
    }

    public int getLeadingNullCount() {
        return this.mLeadingNullCount;
    }

    public int getLoadedCount() {
        return this.mLoadedCount;
    }

    public int getMiddleOfLoadedRange() {
        int n10 = this.mLeadingNullCount;
        int n11 = this.mPositionOffset;
        n10 += n11;
        n11 = this.mStorageCount / 2;
        return n10 + n11;
    }

    public int getNumberAppended() {
        return this.mNumberAppended;
    }

    public int getNumberPrepended() {
        return this.mNumberPrepended;
    }

    public int getPageCount() {
        return this.mPages.size();
    }

    public int getPositionOffset() {
        return this.mPositionOffset;
    }

    public int getStorageCount() {
        return this.mStorageCount;
    }

    public int getTrailingNullCount() {
        return this.mTrailingNullCount;
    }

    public boolean hasPage(int n10, int n11) {
        List list;
        List list2;
        ArrayList arrayList;
        int n12;
        int n13 = this.mLeadingNullCount / n10;
        n10 = 0;
        if (n11 >= n13 && n11 < (n12 = (arrayList = this.mPages).size() + n13) && (list2 = (List)(arrayList = this.mPages).get(n11 -= n13)) != null && list2 != (list = PLACEHOLDER_LIST)) {
            n10 = 1;
        }
        return n10 != 0;
    }

    public void init(int n10, List list, int n11, int n12, PagedStorage$Callback pagedStorage$Callback) {
        this.init(n10, list, n11, n12);
        n10 = this.size();
        pagedStorage$Callback.onInitialized(n10);
    }

    public void initAndSplit(int n10, List list, int n11, int n12, int n13, PagedStorage$Callback pagedStorage$Callback) {
        int n14 = list.size();
        int n15 = n13 + -1;
        n14 = (n14 + n15) / n13;
        n15 = 0;
        while (n15 < n14) {
            int n16 = n15 * n13;
            int n17 = list.size();
            int n18 = n15 + 1;
            int n19 = n18 * n13;
            n17 = Math.min(n17, n19);
            List list2 = list.subList(n16, n17);
            if (n15 == 0) {
                n15 = list.size() + n11;
                n16 = list2.size();
                this.init(n10, list2, n15 -= n16, n12);
            } else {
                n15 = 0;
                this.insertPage(n16 += n10, list2, null);
            }
            n15 = n18;
        }
        n10 = this.size();
        pagedStorage$Callback.onInitialized(n10);
    }

    public void insertPage(int n10, List object, PagedStorage$Callback object2) {
        int n11;
        List list;
        List list2;
        int n12;
        int n13;
        int n14;
        int n15 = object.size();
        if (n15 != (n14 = this.mPageSize)) {
            n14 = this.size();
            n13 = this.mPageSize;
            n12 = n14 % n13;
            n14 -= n12;
            n12 = 0;
            list2 = null;
            int n16 = 1;
            n14 = n10 == n14 && n15 < n13 ? n16 : 0;
            n13 = this.mTrailingNullCount;
            if (n13 == 0 && (n13 = ((ArrayList)(list = this.mPages)).size()) == n16 && n15 > (n13 = this.mPageSize)) {
                n12 = n16;
            }
            if (n12 == 0 && n14 == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("page introduces incorrect tiling");
                throw illegalArgumentException;
            }
            if (n12 != 0) {
                this.mPageSize = n15;
            }
        }
        n14 = this.mPageSize;
        n14 = n10 / n14;
        this.allocatePageRange(n14, n14);
        n13 = this.mLeadingNullCount;
        n12 = this.mPageSize;
        list = (List)this.mPages.get(n14 -= (n13 /= n12));
        if (list != null && list != (list2 = PLACEHOLDER_LIST)) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Invalid position ");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append(": data already loaded");
            String string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        list = this.mPages;
        ((ArrayList)list).set(n14, object);
        this.mLoadedCount = n11 = this.mLoadedCount + n15;
        if (object2 != null) {
            object2.onPageInserted(n10, n15);
        }
    }

    public boolean isTiled() {
        int n10 = this.mPageSize;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean needsTrimFromEnd(int n10, int n11) {
        int n12 = this.mPages.size() + -1;
        return this.needsTrim(n10, n11, n12);
    }

    public boolean needsTrimFromFront(int n10, int n11) {
        return this.needsTrim(n10, n11, 0);
    }

    public boolean pageWouldBeBoundary(int n10, boolean n11) {
        int n12;
        ArrayList arrayList;
        int n13 = this.mPageSize;
        int n14 = 1;
        if (n13 >= n14 && (n13 = (arrayList = this.mPages).size()) >= (n12 = 2)) {
            n13 = this.mLeadingNullCount;
            if (n10 < n13) {
                return n11 != 0;
            }
            n12 = this.mStorageCount + n13;
            if (n10 >= n12) {
                return n11 ^ true;
            }
            n10 -= n13;
            n13 = this.mPageSize;
            n10 /= n13;
            n13 = 0;
            arrayList = null;
            if (n11 != 0) {
                Object var7_7 = null;
                for (n11 = 0; n11 < n10; ++n11) {
                    Object e10 = this.mPages.get(n11);
                    if (e10 == null) continue;
                    return false;
                }
            } else {
                ArrayList arrayList2 = this.mPages;
                for (n11 = arrayList2.size() - n14; n11 > n10; n11 += -1) {
                    Object e11 = this.mPages.get(n11);
                    if (e11 == null) continue;
                    return false;
                }
            }
            return n14 != 0;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Trimming attempt before sufficient load");
        throw illegalStateException;
    }

    public void prependPage(List list, PagedStorage$Callback pagedStorage$Callback) {
        int n10;
        int n11;
        ArrayList arrayList;
        int n12 = list.size();
        if (n12 == 0) {
            pagedStorage$Callback.onEmptyPrepend();
            return;
        }
        int n13 = this.mPageSize;
        if (n13 > 0 && n12 != n13) {
            arrayList = this.mPages;
            n13 = arrayList.size();
            this.mPageSize = n13 == (n11 = 1) && n12 > (n13 = this.mPageSize) ? n12 : (n13 = -1);
        }
        arrayList = this.mPages;
        n11 = 0;
        arrayList.add(0, list);
        this.mLoadedCount = n10 = this.mLoadedCount + n12;
        this.mStorageCount = n10 = this.mStorageCount + n12;
        n10 = Math.min(this.mLeadingNullCount, n12);
        n13 = n12 - n10;
        if (n10 != 0) {
            this.mLeadingNullCount = n11 = this.mLeadingNullCount - n10;
        }
        this.mPositionOffset = n11 = this.mPositionOffset - n13;
        this.mNumberPrepended = n11 = this.mNumberPrepended + n12;
        n12 = this.mLeadingNullCount;
        pagedStorage$Callback.onPagePrepended(n12, n10, n13);
    }

    public boolean shouldPreTrimNewPage(int n10, int n11, int n12) {
        ArrayList arrayList;
        int n13 = this.mLoadedCount + n12;
        n12 = 1;
        if (n13 <= n10 || (n10 = (arrayList = this.mPages).size()) <= n12 || (n10 = this.mLoadedCount) < n11) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public int size() {
        int n10 = this.mLeadingNullCount;
        int n11 = this.mStorageCount;
        n10 += n11;
        n11 = this.mTrailingNullCount;
        return n10 + n11;
    }

    public PagedStorage snapshot() {
        PagedStorage pagedStorage = new PagedStorage(this);
        return pagedStorage;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("leading ");
        int n10 = this.mLeadingNullCount;
        charSequence.append(n10);
        charSequence.append(", storage ");
        n10 = this.mStorageCount;
        charSequence.append(n10);
        Object object = ", trailing ";
        charSequence.append((String)object);
        n10 = this.getTrailingNullCount();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder((String)charSequence);
        charSequence = null;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mPages)).size()); ++i10) {
            stringBuilder.append(" ");
            object = this.mPages.get(i10);
            stringBuilder.append(object);
        }
        return stringBuilder.toString();
    }

    /*
     * WARNING - void declaration
     */
    public boolean trimFromEnd(boolean bl2, int n10, int n11, PagedStorage$Callback pagedStorage$Callback) {
        int n12;
        int n13;
        int n14;
        int n15 = 0;
        int n16 = 0;
        while (true) {
            int n17 = this.needsTrimFromEnd(n14, n13);
            n12 = 1;
            if (n17 == 0) break;
            List list = this.mPages;
            int n18 = ((ArrayList)list).size() - n12;
            n12 = (list = (List)((ArrayList)list).remove(n18)) == null ? this.mPageSize : list.size();
            n16 += n12;
            this.mStorageCount = n18 = this.mStorageCount - n12;
            n12 = this.mLoadedCount;
            if (list == null) {
                n17 = 0;
                list = null;
            } else {
                n17 = list.size();
            }
            this.mLoadedCount = n12 -= n17;
        }
        if (n16 > 0) {
            void var4_5;
            n14 = this.mLeadingNullCount;
            n13 = this.mStorageCount;
            n14 += n13;
            if (bl2) {
                int n19;
                this.mTrailingNullCount = n19 = this.mTrailingNullCount + n16;
                var4_5.onPagesSwappedToPlaceholder(n14, n16);
            } else {
                var4_5.onPagesRemoved(n14, n16);
            }
        }
        if (n16 > 0) {
            n15 = n12;
        }
        return n15 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean trimFromFront(boolean bl2, int n10, int n11, PagedStorage$Callback pagedStorage$Callback) {
        void var3_6;
        int n12;
        int n13;
        boolean bl3 = false;
        int n14 = 0;
        while ((n13 = this.needsTrimFromFront(n12, (int)var3_6)) != 0) {
            int n15;
            List list = (List)this.mPages.remove(0);
            int n16 = list == null ? this.mPageSize : list.size();
            n14 += n16;
            this.mStorageCount = n15 = this.mStorageCount - n16;
            n16 = this.mLoadedCount;
            if (list == null) {
                n13 = 0;
                list = null;
            } else {
                n13 = list.size();
            }
            this.mLoadedCount = n16 -= n13;
        }
        if (n14 > 0) {
            void var4_7;
            if (bl2) {
                int n17 = this.mLeadingNullCount;
                this.mLeadingNullCount = n12 = n17 + n14;
                var4_7.onPagesSwappedToPlaceholder(n17, n14);
            } else {
                int n18;
                this.mPositionOffset = n18 = this.mPositionOffset + n14;
                int n19 = this.mLeadingNullCount;
                var4_7.onPagesRemoved(n19, n14);
            }
        }
        if (n14 > 0) {
            bl3 = true;
        }
        return bl3;
    }

    /*
     * Unable to fully structure code
     */
    public void tryInsertPageAndTrim(int var1_1, List var2_2, int var3_3, int var4_4, int var5_5, PagedStorage$Callback var6_6) {
        var7_7 = 0;
        var8_8 = 1;
        var9_9 = -1 >>> 1;
        var9_9 = var4_4 != var9_9 ? var8_8 : 0;
        var10_10 = this.getMiddleOfLoadedRange();
        var3_3 = var3_3 > var10_10 ? var8_8 : 0;
        if (var9_9 == 0) ** GOTO lbl-1000
        var10_10 = var2_2.size();
        if ((var10_10 = (int)this.shouldPreTrimNewPage(var4_4, var5_5, var10_10)) != 0 && (var10_10 = (int)this.pageWouldBeBoundary(var1_1, (boolean)var3_3)) != 0) {
            var10_10 = 0;
            var11_11 = null;
        } else lbl-1000:
        // 2 sources

        {
            var10_10 = var8_8;
        }
        if (var10_10 != 0) {
            this.insertPage(var1_1, var2_2, var6_6);
        } else {
            var10_10 = this.mLeadingNullCount;
            var1_1 -= var10_10;
            var10_10 = this.mPageSize;
            var11_11 = this.mPages;
            var11_11.set(var1_1 /= var10_10, null);
            var1_1 = this.mStorageCount;
            var10_10 = var2_2.size();
            this.mStorageCount = var1_1 -= var10_10;
            if (var3_3 != 0) {
                var12_12 = this.mPages;
                var12_12.remove(0);
                var1_1 = this.mLeadingNullCount;
                var13_14 = var2_2.size();
                this.mLeadingNullCount = var1_1 += var13_14;
            } else {
                var12_13 = this.mPages;
                var7_7 = var12_13.size() - var8_8;
                var12_13.remove(var7_7);
                var1_1 = this.mTrailingNullCount;
                var13_15 = var2_2.size();
                this.mTrailingNullCount = var1_1 += var13_15;
            }
        }
        if (var9_9 != 0) {
            if (var3_3 != 0) {
                this.trimFromFront((boolean)var8_8, var4_4, var5_5, var6_6);
            } else {
                this.trimFromEnd((boolean)var8_8, var4_4, var5_5, var6_6);
            }
        }
    }
}

