/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import androidx.lifecycle.Observer;
import com.zhiyun.pay.data.PayFlowResult;
import d.v.c.l1.x;

public final class e
implements Observer {
    public final /* synthetic */ x a;

    public /* synthetic */ e(x x10) {
        this.a = x10;
    }

    public final void onChanged(Object object) {
        x x10 = this.a;
        object = (PayFlowResult)((Object)object);
        x10.j((PayFlowResult)((Object)object));
    }
}

