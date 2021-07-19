/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import com.zhiyun.editorsdk.draft.withdraw.LimitQueue;
import java.util.function.Consumer;

public final class c
implements Consumer {
    public final /* synthetic */ LimitQueue a;

    public /* synthetic */ c(LimitQueue limitQueue) {
        this.a = limitQueue;
    }

    public final void accept(Object object) {
        this.a.p(object);
    }
}

