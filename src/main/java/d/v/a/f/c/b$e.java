/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.f.c;

import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.b;

public class b$e
extends a {
    public final /* synthetic */ a a;
    public final /* synthetic */ b b;

    public b$e(b b10, a a10) {
        this.b = b10;
        this.a = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.a;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
        this.b.e(false);
        a a10 = this.a;
        if (a10 != null) {
            a10.onSuccess(baseEntity);
        }
    }
}

