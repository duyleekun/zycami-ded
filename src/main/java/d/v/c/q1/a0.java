/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1;

import androidx.arch.core.util.Function;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.c.q1.g0;

public final class a0
implements Function {
    public final /* synthetic */ g0 a;

    public /* synthetic */ a0(g0 g02) {
        this.a = g02;
    }

    public final Object apply(Object object) {
        g0 g02 = this.a;
        object = (UserInfo)object;
        return g02.J((UserInfo)object);
    }
}

