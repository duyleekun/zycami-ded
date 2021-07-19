/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class o2
implements o {
    public final /* synthetic */ StringBuilder a;

    public /* synthetic */ o2(StringBuilder stringBuilder) {
        this.a = stringBuilder;
    }

    public final Object apply(Object object) {
        StringBuilder stringBuilder = this.a;
        object = (String)object;
        return Stabilizer.V3(stringBuilder, (String)object);
    }
}

