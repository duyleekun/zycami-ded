/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.f.c;

import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.a.f.c.d.d;
import d.v.a.i.a.w0.c;

public class b$g
extends a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a c;
    public final /* synthetic */ b d;

    public b$g(b b10, String string2, String string3, a a10) {
        this.d = b10;
        this.a = string2;
        this.b = string3;
        this.c = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.c;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
        Object object = this.a;
        Object object2 = this.b;
        object = d.v.a.i.a.w0.c.f((String)object, (String)object2);
        object2 = this.b;
        boolean bl2 = d.v.a.i.a.w0.c.b((String)object2);
        if (bl2) {
            object2 = d.v.a.f.c.b.M(this.d);
            ((d)object2).e0((String)object);
        } else {
            object2 = d.v.a.f.c.b.M(this.d);
            ((d)object2).f0((String)object);
        }
        object = this.c;
        if (object != null) {
            object.onSuccess(baseEntity);
        }
    }
}

