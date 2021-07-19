/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.f.c;

import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.a.f.c.d.d;

public class b$i
extends a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ a b;
    public final /* synthetic */ b c;

    public b$i(b b10, boolean bl2, a a10) {
        this.c = b10;
        this.a = bl2;
        this.b = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.b;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
        Object object;
        boolean bl2 = this.a;
        String string2 = "";
        if (bl2) {
            object = d.v.a.f.c.b.M(this.c);
            ((d)object).f0(string2);
        } else {
            object = d.v.a.f.c.b.M(this.c);
            ((d)object).e0(string2);
        }
        object = this.b;
        if (object != null) {
            object.onSuccess(baseEntity);
        }
    }
}

