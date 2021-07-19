/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.rd;
import e.a.v0.o;

public final class u4
implements o {
    public final /* synthetic */ Stabilizer a;

    public /* synthetic */ u4(Stabilizer stabilizer) {
        this.a = stabilizer;
    }

    public final Object apply(Object object) {
        Stabilizer stabilizer = this.a;
        object = (rd)object;
        return Stabilizer.K3(stabilizer, (rd)object);
    }
}

