/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.cloud_engine;

import androidx.databinding.ObservableField;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnTemplateListener;
import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout;
import com.zhiyun.cama.cloud_engine.CETemplateFragment;
import java.util.Collection;

public class CETemplateFragment$a
implements OnTemplateListener {
    public final /* synthetic */ CETemplateFragment a;

    public CETemplateFragment$a(CETemplateFragment cETemplateFragment) {
        this.a = cETemplateFragment;
    }

    public void onFailure(RequestError object) {
        Object object2 = CETemplateFragment.j(this.a).getLoadMoreModule();
        int n10 = 1;
        ((BaseLoadMoreModule)object2).setEnableLoadMore(n10 != 0);
        object2 = this.a;
        int n11 = CETemplateFragment.k((CETemplateFragment)object2);
        if (n11 == n10) {
            object2 = CETemplateFragment.n((CETemplateFragment)this.a).d;
            n10 = 0;
            ((CEPullToRefreshLayout)object2).setRefreshing(false);
            object2 = CETemplateFragment.j(this.a).getData();
            n11 = (int)(object2.isEmpty() ? 1 : 0);
            if (n11 != 0) {
                object2 = CETemplateFragment.m(this.a);
                ((ObservableField)object2).set(object);
            }
        } else {
            object = CETemplateFragment.j(this.a).getLoadMoreModule();
            ((BaseLoadMoreModule)object).loadMoreFail();
        }
    }

    public void onSuccess(TemplateResponse object) {
        boolean bl2 = ((TemplateResponse)object).isHasMore();
        object = ((TemplateResponse)object).getData();
        Object object2 = CETemplateFragment.j(this.a).getLoadMoreModule();
        int n10 = 1;
        ((BaseLoadMoreModule)object2).setEnableLoadMore(n10 != 0);
        object2 = this.a;
        int n11 = CETemplateFragment.k((CETemplateFragment)object2);
        if (n11 == n10) {
            CETemplateFragment.m(this.a).set(null);
            object2 = CETemplateFragment.n((CETemplateFragment)this.a).d;
            n10 = 0;
            ((CEPullToRefreshLayout)object2).setRefreshing(false);
            object2 = CETemplateFragment.j(this.a);
            ((BaseQuickAdapter)object2).setList((Collection)object);
        } else {
            CETemplateFragment.j(this.a).getLoadMoreModule().loadMoreEnd();
            object2 = CETemplateFragment.j(this.a);
            ((BaseQuickAdapter)object2).addData((Collection)object);
        }
        if (bl2) {
            object = CETemplateFragment.j(this.a).getLoadMoreModule();
            ((BaseLoadMoreModule)object).loadMoreComplete();
        }
        CETemplateFragment.l(this.a);
    }
}

