/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.zhiyun.cama.cloud_engine.CETemplateFragment;

public final class n
implements OnLoadMoreListener {
    public final /* synthetic */ CETemplateFragment a;

    public /* synthetic */ n(CETemplateFragment cETemplateFragment) {
        this.a = cETemplateFragment;
    }

    public final void onLoadMore() {
        CETemplateFragment.r(this.a);
    }
}

