/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import com.zhiyun.cama.cloud_engine.CEPullToRefreshLayout$d;
import com.zhiyun.cama.cloud_engine.CETemplateFragment;

public final class m
implements CEPullToRefreshLayout$d {
    public final /* synthetic */ CETemplateFragment a;

    public /* synthetic */ m(CETemplateFragment cETemplateFragment) {
        this.a = cETemplateFragment;
    }

    public final void onRefresh() {
        CETemplateFragment.q(this.a);
    }
}

