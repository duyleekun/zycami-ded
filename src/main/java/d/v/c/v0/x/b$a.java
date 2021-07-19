/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.x;

import com.zhiyun.net.BaseEntity;
import d.v.c.v0.x.a;
import d.v.c.v0.x.b;

public class b$a
extends d.v.a.f.b.a {
    public final /* synthetic */ a a;
    public final /* synthetic */ b b;

    public b$a(b b10, a a10) {
        this.b = b10;
        this.a = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }

    public void onSuccess(BaseEntity object) {
        object = this.b;
        a a10 = this.a;
        d.v.c.v0.x.b.f((b)object, a10);
    }
}

