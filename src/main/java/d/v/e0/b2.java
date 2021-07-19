/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.rd;
import e.a.v0.o;

public final class b2
implements o {
    public final /* synthetic */ Stabilizer a;
    public final /* synthetic */ int b;

    public /* synthetic */ b2(Stabilizer stabilizer, int n10) {
        this.a = stabilizer;
        this.b = n10;
    }

    public final Object apply(Object object) {
        Stabilizer stabilizer = this.a;
        int n10 = this.b;
        object = (rd)object;
        return stabilizer.g6(n10, (rd)object);
    }
}

