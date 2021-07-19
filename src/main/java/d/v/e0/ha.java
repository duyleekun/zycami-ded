/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.utils.Axis;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.ie.g;
import e.a.v0.o;
import java.util.List;

public final class ha
implements o {
    public final /* synthetic */ Stabilizer a;
    public final /* synthetic */ g b;
    public final /* synthetic */ int c;
    public final /* synthetic */ List d;

    public /* synthetic */ ha(Stabilizer stabilizer, g g10, int n10, List list) {
        this.a = stabilizer;
        this.b = g10;
        this.c = n10;
        this.d = list;
    }

    public final Object apply(Object object) {
        Stabilizer stabilizer = this.a;
        g g10 = this.b;
        int n10 = this.c;
        List list = this.d;
        object = (Axis)object;
        return ce.m3(stabilizer, g10, n10, list, (Axis)object);
    }
}

