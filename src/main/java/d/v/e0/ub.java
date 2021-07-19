/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.fe;
import e.a.v0.o;

public final class ub
implements o {
    public final /* synthetic */ fe a;
    public final /* synthetic */ float b;

    public /* synthetic */ ub(fe fe2, float f10) {
        this.a = fe2;
        this.b = f10;
    }

    public final Object apply(Object object) {
        fe fe2 = this.a;
        float f10 = this.b;
        object = (Stabilizer)object;
        return fe2.l(f10, (Stabilizer)object);
    }
}

