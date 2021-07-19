/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.Observer;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.c.s0.a7.e1;

public final class v
implements Observer {
    public final /* synthetic */ e1 a;

    public /* synthetic */ v(e1 e12) {
        this.a = e12;
    }

    public final void onChanged(Object object) {
        e1 e12 = this.a;
        object = (WorkingMode)((Object)object);
        e12.b0((WorkingMode)((Object)object));
    }
}

