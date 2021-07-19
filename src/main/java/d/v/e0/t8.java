/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.entities.PathShot;
import d.v.e0.ce;
import e.a.v0.o;

public final class t8
implements o {
    public final /* synthetic */ ce a;
    public final /* synthetic */ PathShot b;

    public /* synthetic */ t8(ce ce2, PathShot pathShot) {
        this.a = ce2;
        this.b = pathShot;
    }

    public final Object apply(Object object) {
        ce ce2 = this.a;
        PathShot pathShot = this.b;
        object = (Boolean)object;
        return ce2.s4(pathShot, (Boolean)object);
    }
}

