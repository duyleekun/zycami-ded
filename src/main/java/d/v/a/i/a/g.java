/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.arch.core.util.Function;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.i.a.m0;

public final class g
implements Function {
    public final /* synthetic */ m0 a;

    public /* synthetic */ g(m0 m02) {
        this.a = m02;
    }

    public final Object apply(Object object) {
        m0 m02 = this.a;
        object = (GetCodeStatus)((Object)object);
        return m02.o((GetCodeStatus)((Object)object));
    }
}

