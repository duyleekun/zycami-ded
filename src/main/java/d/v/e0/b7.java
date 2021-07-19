/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.ie.g;
import e.a.v0.o;
import java.util.List;

public final class b7
implements o {
    public final /* synthetic */ List a;
    public final /* synthetic */ g b;
    public final /* synthetic */ int c;
    public final /* synthetic */ List d;

    public /* synthetic */ b7(List list, g g10, int n10, List list2) {
        this.a = list;
        this.b = g10;
        this.c = n10;
        this.d = list2;
    }

    public final Object apply(Object object) {
        List list = this.a;
        g g10 = this.b;
        int n10 = this.c;
        List list2 = this.d;
        object = (Stabilizer)object;
        return ce.G4(list, g10, n10, list2, (Stabilizer)object);
    }
}

