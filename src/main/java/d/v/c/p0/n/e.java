/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;
import java.util.List;

public final class e
implements Observer {
    public final /* synthetic */ AppealDetailActivity a;

    public /* synthetic */ e(AppealDetailActivity appealDetailActivity) {
        this.a = appealDetailActivity;
    }

    public final void onChanged(Object object) {
        AppealDetailActivity appealDetailActivity = this.a;
        object = (List)object;
        appealDetailActivity.o((List)object);
    }
}

