/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.f.c;

import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.a.f.c.d.d;

public class b$h
extends a {
    public final /* synthetic */ int a;
    public final /* synthetic */ a b;
    public final /* synthetic */ b c;

    public b$h(b b10, int n10, a a10) {
        this.c = b10;
        this.a = n10;
        this.b = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.b;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
        Object object = d.v.a.f.c.b.M(this.c);
        int n10 = this.a;
        ((d)object).d0(n10);
        object = this.b;
        if (object != null) {
            object.onSuccess(baseEntity);
        }
    }
}

