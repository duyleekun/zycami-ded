/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.api.entity.IntegerEntity;
import d.v.a.f.b.a;
import d.v.c.v0.u.v;

public class v$c
extends a {
    public final /* synthetic */ a a;
    public final /* synthetic */ v b;

    public v$c(v v10, a a10) {
        this.b = v10;
        this.a = a10;
    }

    public void a(IntegerEntity integerEntity) {
        a a10 = this.a;
        if (a10 != null) {
            a10.onSuccess(integerEntity);
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.a;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }
}

