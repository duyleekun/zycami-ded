/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;

public final class a
implements Observer {
    public final /* synthetic */ AppealDetailActivity a;

    public /* synthetic */ a(AppealDetailActivity appealDetailActivity) {
        this.a = appealDetailActivity;
    }

    public final void onChanged(Object object) {
        AppealDetailActivity appealDetailActivity = this.a;
        object = (Boolean)object;
        appealDetailActivity.n((Boolean)object);
    }
}

