/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PagedList;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedStorage;
import androidx.paging.TiledPagedList;
import java.util.AbstractList;
import java.util.List;

public class TiledPagedList$1
extends PageResult$Receiver {
    public final /* synthetic */ TiledPagedList this$0;

    public TiledPagedList$1(TiledPagedList tiledPagedList) {
        this.this$0 = tiledPagedList;
    }

    /*
     * WARNING - void declaration
     */
    public void onPageResult(int n10, PageResult object) {
        block12: {
            void var11_26;
            void var8_15;
            boolean bl2;
            block14: {
                PagedList$BoundaryCallback pagedList$BoundaryCallback;
                block13: {
                    int n11;
                    int n12;
                    Object object2;
                    int n13;
                    int n14;
                    boolean n132 = ((PageResult)object).isInvalid();
                    if (n132) {
                        this.this$0.detach();
                        return;
                    }
                    Object object3 = this.this$0;
                    boolean bl3 = ((PagedList)object3).isDetached();
                    if (bl3) {
                        return;
                    }
                    int n15 = 3;
                    if (n10 != 0 && n10 != n15) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("unexpected resultType");
                        ((StringBuilder)object3).append(n10);
                        String string2 = ((StringBuilder)object3).toString();
                        object = new IllegalArgumentException(string2);
                        throw object;
                    }
                    List list = ((PageResult)object).page;
                    AbstractList abstractList = this.this$0.mStorage;
                    int n16 = ((PagedStorage)abstractList).getPageCount();
                    if (n16 == 0) {
                        TiledPagedList tiledPagedList = this.this$0;
                        abstractList = tiledPagedList.mStorage;
                        bl2 = ((PageResult)object).leadingNulls;
                        int n17 = ((PageResult)object).trailingNulls;
                        n14 = ((PageResult)object).positionOffset;
                        PagedList$Config pagedList$Config = tiledPagedList.mConfig;
                        n13 = pagedList$Config.pageSize;
                        ((PagedStorage)abstractList).initAndSplit((int)(bl2 ? 1 : 0), list, n17, n14, n13, tiledPagedList);
                    } else {
                        TiledPagedList tiledPagedList = this.this$0;
                        abstractList = tiledPagedList.mStorage;
                        bl2 = ((PageResult)object).positionOffset;
                        int n18 = tiledPagedList.mLastLoad;
                        object2 = tiledPagedList.mConfig;
                        n14 = ((PagedList$Config)object2).maxSize;
                        n13 = tiledPagedList.mRequiredRemainder;
                        ((PagedStorage)abstractList).tryInsertPageAndTrim((int)(bl2 ? 1 : 0), list, n18, n14, n13, tiledPagedList);
                    }
                    abstractList = this.this$0;
                    pagedList$BoundaryCallback = ((PagedList)abstractList).mBoundaryCallback;
                    if (pagedList$BoundaryCallback == null) break block12;
                    abstractList = ((PagedList)abstractList).mStorage;
                    int n19 = ((PagedStorage)abstractList).size();
                    bl2 = true;
                    list = null;
                    if (n19 == 0) {
                        boolean bl4 = bl2;
                    } else {
                        boolean bl5 = false;
                        abstractList = null;
                    }
                    if (var8_15 == false && (n12 = ((PageResult)object).leadingNulls) == 0 && (n11 = ((PageResult)object).positionOffset) == 0) {
                        boolean bl6 = bl2;
                    } else {
                        boolean bl7 = false;
                    }
                    object2 = this.this$0;
                    n14 = ((PagedList)object2).size();
                    if (var8_15 != false) break block13;
                    if (n10 == 0 && (n13 = ((PageResult)object).trailingNulls) == 0) break block14;
                    if (n10 != n15) break block13;
                    n10 = ((PageResult)object).positionOffset;
                    object = this.this$0.mConfig;
                    int n20 = ((PagedList$Config)object).pageSize;
                    if ((n10 += n20) >= n14) break block14;
                }
                bl2 = false;
                pagedList$BoundaryCallback = null;
            }
            TiledPagedList tiledPagedList = this.this$0;
            tiledPagedList.deferBoundaryCallbacks((boolean)var8_15, (boolean)var11_26, bl2);
        }
    }
}

