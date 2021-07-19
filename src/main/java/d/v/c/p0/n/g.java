/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;

public final class g
implements Observer {
    public final /* synthetic */ AppealDetailActivity a;

    public /* synthetic */ g(AppealDetailActivity appealDetailActivity) {
        this.a = appealDetailActivity;
    }

    public final void onChanged(Object object) {
        AppealDetailActivity appealDetailActivity = this.a;
        boolean bl2 = (Boolean)object;
        appealDetailActivity.r(bl2);
    }
}

