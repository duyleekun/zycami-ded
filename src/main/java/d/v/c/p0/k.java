/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.AppealActivity;

public final class k
implements Observer {
    public final /* synthetic */ AppealActivity a;

    public /* synthetic */ k(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    public final void onChanged(Object object) {
        AppealActivity appealActivity = this.a;
        boolean bl2 = (Boolean)object;
        appealActivity.B(bl2);
    }
}

