/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.WithdrawUseCase;
import d.v.j.e.g.a0;
import java.util.function.Consumer;

public final class b1
implements Consumer {
    public final /* synthetic */ a0 a;

    public /* synthetic */ b1(a0 a02) {
        this.a = a02;
    }

    public final void accept(Object object) {
        a0 a02 = this.a;
        object = (a0)object;
        WithdrawUseCase.h(a02, (a0)object);
    }
}

