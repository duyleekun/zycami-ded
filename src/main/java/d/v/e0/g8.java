/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.v0.r;

public final class g8
implements r {
    public final /* synthetic */ ce a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ g8(ce ce2, boolean bl2) {
        this.a = ce2;
        this.b = bl2;
    }

    public final boolean test(Object object) {
        ce ce2 = this.a;
        boolean bl2 = this.b;
        object = (Stabilizer)object;
        return ce2.D4(bl2, (Stabilizer)object);
    }
}

