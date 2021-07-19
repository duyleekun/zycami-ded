/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.arch.core.util.Function;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.j.c.y;

public final class l
implements Function {
    public final /* synthetic */ y a;

    public /* synthetic */ l(y y10) {
        this.a = y10;
    }

    public final Object apply(Object object) {
        y y10 = this.a;
        object = (UserInfo)object;
        return y10.u((UserInfo)object);
    }
}

