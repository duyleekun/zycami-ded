/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import com.zhiyun.net.BaseEntity;
import d.v.j.e.h.j$a;

public final class b
implements Runnable {
    public final /* synthetic */ j$a a;
    public final /* synthetic */ BaseEntity b;

    public /* synthetic */ b(j$a a10, BaseEntity baseEntity) {
        this.a = a10;
        this.b = baseEntity;
    }

    public final void run() {
        j$a j$a = this.a;
        BaseEntity baseEntity = this.b;
        j$a.h(baseEntity);
    }
}

