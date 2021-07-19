/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.AppealActivity;

public final class a
implements Observer {
    public final /* synthetic */ AppealActivity a;

    public /* synthetic */ a(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    public final void onChanged(Object object) {
        AppealActivity appealActivity = this.a;
        boolean bl2 = (Boolean)object;
        appealActivity.l(bl2);
    }
}

