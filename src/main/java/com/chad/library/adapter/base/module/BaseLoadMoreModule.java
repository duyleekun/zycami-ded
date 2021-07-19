/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.LoadMoreListenerImp;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.module.BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$1;
import com.chad.library.adapter.base.module.BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$2;
import com.chad.library.adapter.base.module.BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1;
import com.chad.library.adapter.base.module.BaseLoadMoreModule$setupViewHolder$1;
import com.chad.library.adapter.base.module.LoadMoreModuleConfig;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f.h2.t.f0;

public class BaseLoadMoreModule
implements LoadMoreListenerImp {
    private final BaseQuickAdapter baseQuickAdapter;
    private boolean enableLoadMoreEndClick;
    private boolean isAutoLoadMore;
    private boolean isEnableLoadMore;
    private boolean isEnableLoadMoreIfNotFullPage;
    private boolean isLoadEndMoreGone;
    private LoadMoreStatus loadMoreStatus;
    private BaseLoadMoreView loadMoreView;
    private OnLoadMoreListener mLoadMoreListener;
    private boolean mNextLoadEnable;
    private int preLoadNumber;

    public BaseLoadMoreModule(BaseQuickAdapter baseQuickAdapter) {
        Object object;
        boolean bl2;
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.mNextLoadEnable = bl2 = true;
        this.loadMoreStatus = object = LoadMoreStatus.Complete;
        object = LoadMoreModuleConfig.getDefLoadMoreView();
        this.loadMoreView = object;
        this.isAutoLoadMore = bl2;
        this.isEnableLoadMoreIfNotFullPage = bl2;
        this.preLoadNumber = (int)(bl2 ? 1 : 0);
    }

    public static final /* synthetic */ BaseQuickAdapter access$getBaseQuickAdapter$p(BaseLoadMoreModule baseLoadMoreModule) {
        return baseLoadMoreModule.baseQuickAdapter;
    }

    public static final /* synthetic */ LoadMoreStatus access$getLoadMoreStatus$p(BaseLoadMoreModule baseLoadMoreModule) {
        return baseLoadMoreModule.loadMoreStatus;
    }

    public static final /* synthetic */ OnLoadMoreListener access$getMLoadMoreListener$p(BaseLoadMoreModule baseLoadMoreModule) {
        return baseLoadMoreModule.mLoadMoreListener;
    }

    public static final /* synthetic */ boolean access$getMNextLoadEnable$p(BaseLoadMoreModule baseLoadMoreModule) {
        return baseLoadMoreModule.mNextLoadEnable;
    }

    public static final /* synthetic */ int access$getTheBiggestNumber(BaseLoadMoreModule baseLoadMoreModule, int[] nArray) {
        return baseLoadMoreModule.getTheBiggestNumber(nArray);
    }

    public static final /* synthetic */ boolean access$isFullScreen(BaseLoadMoreModule baseLoadMoreModule, LinearLayoutManager linearLayoutManager) {
        return baseLoadMoreModule.isFullScreen(linearLayoutManager);
    }

    public static final /* synthetic */ void access$setLoadMoreStatus$p(BaseLoadMoreModule baseLoadMoreModule, LoadMoreStatus loadMoreStatus) {
        baseLoadMoreModule.loadMoreStatus = loadMoreStatus;
    }

    public static final /* synthetic */ void access$setMLoadMoreListener$p(BaseLoadMoreModule baseLoadMoreModule, OnLoadMoreListener onLoadMoreListener) {
        baseLoadMoreModule.mLoadMoreListener = onLoadMoreListener;
    }

    public static final /* synthetic */ void access$setMNextLoadEnable$p(BaseLoadMoreModule baseLoadMoreModule, boolean bl2) {
        baseLoadMoreModule.mNextLoadEnable = bl2;
    }

    private final int getTheBiggestNumber(int[] nArray) {
        int n10 = -1;
        if (nArray != null) {
            int n11 = nArray.length;
            if ((n11 = n11 == 0 ? 1 : 0) == 0) {
                for (int n12 : nArray) {
                    if (n12 <= n10) continue;
                    n10 = n12;
                }
            }
        }
        return n10;
    }

    private final void invokeLoadMoreListener() {
        Object object = LoadMoreStatus.Loading;
        this.loadMoreStatus = object;
        object = this.baseQuickAdapter.getMRecyclerView$com_github_CymChad_brvah();
        if (object != null) {
            BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1 baseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1 = new BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(this);
            object.post((Runnable)baseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1);
        } else {
            object = this.mLoadMoreListener;
            if (object != null) {
                object.onLoadMore();
            }
        }
    }

    private final boolean isFullScreen(LinearLayoutManager linearLayoutManager) {
        int n10;
        int n11 = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        int n12 = 1;
        BaseQuickAdapter baseQuickAdapter = this.baseQuickAdapter;
        int n13 = baseQuickAdapter.getItemCount();
        if ((n11 += n12) == n13 && (n10 = linearLayoutManager.findFirstCompletelyVisibleItemPosition()) == 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static /* synthetic */ void loadMoreEnd$default(BaseLoadMoreModule object, boolean bl2, int n10, Object object2) {
        if (object2 == null) {
            if ((n10 &= 1) != 0) {
                bl2 = false;
            }
            ((BaseLoadMoreModule)object).loadMoreEnd(bl2);
            return;
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        throw object;
    }

    public final void autoLoadMore$com_github_CymChad_brvah(int n10) {
        int n11 = this.isAutoLoadMore;
        if (n11 == 0) {
            return;
        }
        n11 = this.hasLoadMoreView();
        if (n11 == 0) {
            return;
        }
        Object object = this.baseQuickAdapter;
        n11 = object.getItemCount();
        int n12 = this.preLoadNumber;
        if (n10 < (n11 -= n12)) {
            return;
        }
        LoadMoreStatus loadMoreStatus = this.loadMoreStatus;
        object = LoadMoreStatus.Complete;
        if (loadMoreStatus != object) {
            return;
        }
        object = LoadMoreStatus.Loading;
        if (loadMoreStatus == object) {
            return;
        }
        n10 = (int)(this.mNextLoadEnable ? 1 : 0);
        if (n10 == 0) {
            return;
        }
        this.invokeLoadMoreListener();
    }

    public final void checkDisableLoadMoreIfNotFullPage() {
        RecyclerView$LayoutManager recyclerView$LayoutManager;
        boolean bl2 = this.isEnableLoadMoreIfNotFullPage;
        if (bl2) {
            return;
        }
        bl2 = false;
        this.mNextLoadEnable = false;
        RecyclerView recyclerView = this.baseQuickAdapter.getMRecyclerView$com_github_CymChad_brvah();
        if (recyclerView != null && (recyclerView$LayoutManager = recyclerView.getLayoutManager()) != null) {
            Object object = "recyclerView.layoutManager ?: return";
            f0.h(recyclerView$LayoutManager, (String)object);
            boolean bl3 = recyclerView$LayoutManager instanceof LinearLayoutManager;
            long l10 = 50;
            if (bl3) {
                object = new BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$1(this, recyclerView$LayoutManager);
                recyclerView.postDelayed((Runnable)object, l10);
            } else {
                bl3 = recyclerView$LayoutManager instanceof StaggeredGridLayoutManager;
                if (bl3) {
                    object = new BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$2(this, recyclerView$LayoutManager);
                    recyclerView.postDelayed((Runnable)object, l10);
                }
            }
        }
    }

    public final boolean getEnableLoadMoreEndClick() {
        return this.enableLoadMoreEndClick;
    }

    public final LoadMoreStatus getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    public final BaseLoadMoreView getLoadMoreView() {
        return this.loadMoreView;
    }

    public final int getLoadMoreViewPosition() {
        BaseQuickAdapter baseQuickAdapter = this.baseQuickAdapter;
        int n10 = baseQuickAdapter.hasEmptyView();
        if (n10 != 0) {
            return -1;
        }
        baseQuickAdapter = this.baseQuickAdapter;
        int n11 = baseQuickAdapter.getHeaderLayoutCount();
        int n12 = baseQuickAdapter.getData().size();
        n10 = baseQuickAdapter.getFooterLayoutCount();
        return (n11 += n12) + n10;
    }

    public final int getPreLoadNumber() {
        return this.preLoadNumber;
    }

    public final boolean hasLoadMoreView() {
        boolean bl2;
        Object object = this.mLoadMoreListener;
        if (object != null && (bl2 = this.isEnableLoadMore)) {
            object = this.loadMoreStatus;
            LoadMoreStatus loadMoreStatus = LoadMoreStatus.End;
            if (object == loadMoreStatus && (bl2 = this.isLoadEndMoreGone)) {
                return false;
            }
            return this.baseQuickAdapter.getData().isEmpty() ^ true;
        }
        return false;
    }

    public final boolean isAutoLoadMore() {
        return this.isAutoLoadMore;
    }

    public final boolean isEnableLoadMore() {
        return this.isEnableLoadMore;
    }

    public final boolean isEnableLoadMoreIfNotFullPage() {
        return this.isEnableLoadMoreIfNotFullPage;
    }

    public final boolean isLoadEndMoreGone() {
        return this.isLoadEndMoreGone;
    }

    public final boolean isLoading() {
        boolean bl2;
        LoadMoreStatus loadMoreStatus = this.loadMoreStatus;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus == loadMoreStatus2) {
            bl2 = true;
        } else {
            bl2 = false;
            loadMoreStatus = null;
        }
        return bl2;
    }

    public final void loadMoreComplete() {
        boolean bl2 = this.hasLoadMoreView();
        if (!bl2) {
            return;
        }
        Object object = LoadMoreStatus.Complete;
        this.loadMoreStatus = object;
        object = this.baseQuickAdapter;
        int n10 = this.getLoadMoreViewPosition();
        ((RecyclerView$Adapter)object).notifyItemChanged(n10);
        this.checkDisableLoadMoreIfNotFullPage();
    }

    public final void loadMoreEnd() {
        BaseLoadMoreModule.loadMoreEnd$default(this, false, 1, null);
    }

    public final void loadMoreEnd(boolean bl2) {
        LoadMoreStatus loadMoreStatus;
        int n10 = this.hasLoadMoreView();
        if (n10 == 0) {
            return;
        }
        this.isLoadEndMoreGone = bl2;
        this.loadMoreStatus = loadMoreStatus = LoadMoreStatus.End;
        if (bl2) {
            BaseQuickAdapter baseQuickAdapter = this.baseQuickAdapter;
            n10 = this.getLoadMoreViewPosition();
            baseQuickAdapter.notifyItemRemoved(n10);
        } else {
            BaseQuickAdapter baseQuickAdapter = this.baseQuickAdapter;
            n10 = this.getLoadMoreViewPosition();
            baseQuickAdapter.notifyItemChanged(n10);
        }
    }

    public final void loadMoreFail() {
        boolean bl2 = this.hasLoadMoreView();
        if (!bl2) {
            return;
        }
        Object object = LoadMoreStatus.Fail;
        this.loadMoreStatus = object;
        object = this.baseQuickAdapter;
        int n10 = this.getLoadMoreViewPosition();
        ((RecyclerView$Adapter)object).notifyItemChanged(n10);
    }

    public final void loadMoreToLoading() {
        Object object = this.loadMoreStatus;
        LoadMoreStatus loadMoreStatus = LoadMoreStatus.Loading;
        if (object == loadMoreStatus) {
            return;
        }
        this.loadMoreStatus = loadMoreStatus;
        object = this.baseQuickAdapter;
        int n10 = this.getLoadMoreViewPosition();
        ((RecyclerView$Adapter)object).notifyItemChanged(n10);
        this.invokeLoadMoreListener();
    }

    public final void reset$com_github_CymChad_brvah() {
        Object object = this.mLoadMoreListener;
        if (object != null) {
            boolean bl2 = true;
            this.setEnableLoadMore(bl2);
            object = LoadMoreStatus.Complete;
            this.loadMoreStatus = object;
        }
    }

    public final void setAutoLoadMore(boolean bl2) {
        this.isAutoLoadMore = bl2;
    }

    public final void setEnableLoadMore(boolean bl2) {
        int n10 = this.hasLoadMoreView();
        this.isEnableLoadMore = bl2;
        bl2 = this.hasLoadMoreView();
        if (n10 != 0) {
            if (!bl2) {
                BaseQuickAdapter baseQuickAdapter = this.baseQuickAdapter;
                n10 = this.getLoadMoreViewPosition();
                baseQuickAdapter.notifyItemRemoved(n10);
            }
        } else if (bl2) {
            Object object = LoadMoreStatus.Complete;
            this.loadMoreStatus = object;
            object = this.baseQuickAdapter;
            n10 = this.getLoadMoreViewPosition();
            ((RecyclerView$Adapter)object).notifyItemInserted(n10);
        }
    }

    public final void setEnableLoadMoreEndClick(boolean bl2) {
        this.enableLoadMoreEndClick = bl2;
    }

    public final void setEnableLoadMoreIfNotFullPage(boolean bl2) {
        this.isEnableLoadMoreIfNotFullPage = bl2;
    }

    public final void setLoadMoreView(BaseLoadMoreView baseLoadMoreView) {
        f0.q(baseLoadMoreView, "<set-?>");
        this.loadMoreView = baseLoadMoreView;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.setEnableLoadMore(true);
    }

    public final void setPreLoadNumber(int n10) {
        int n11 = 1;
        if (n10 > n11) {
            this.preLoadNumber = n10;
        }
    }

    public final void setupViewHolder$com_github_CymChad_brvah(BaseViewHolder baseViewHolder) {
        f0.q(baseViewHolder, "viewHolder");
        baseViewHolder = baseViewHolder.itemView;
        BaseLoadMoreModule$setupViewHolder$1 baseLoadMoreModule$setupViewHolder$1 = new BaseLoadMoreModule$setupViewHolder$1(this);
        baseViewHolder.setOnClickListener(baseLoadMoreModule$setupViewHolder$1);
    }
}

