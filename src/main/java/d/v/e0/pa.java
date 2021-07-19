/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.v0.o;
import java.util.List;

public final class pa
implements o {
    public final /* synthetic */ List a;

    public /* synthetic */ pa(List list) {
        this.a = list;
    }

    public final Object apply(Object object) {
        List list = this.a;
        object = (Stabilizer)object;
        ce.K4(list, (Stabilizer)object);
        return list;
    }
}

