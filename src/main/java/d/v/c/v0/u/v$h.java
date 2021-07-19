/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.database.model.Feedback;
import d.v.a.f.b.a;
import d.v.c.v0.u.c;
import d.v.c.v0.u.v;

public class v$h
extends a {
    public final /* synthetic */ a a;
    public final /* synthetic */ v b;

    public v$h(v v10, a a10) {
        this.b = v10;
        this.a = a10;
    }

    private /* synthetic */ void a(Feedback feedback) {
        v.L(this.b).o(feedback);
    }

    public /* synthetic */ void b(Feedback feedback) {
        this.a(feedback);
    }

    public void c(Feedback feedback) {
        Object object = v.J(this.b).a();
        c c10 = new c(this, feedback);
        object.execute(c10);
        object = this.a;
        if (object != null) {
            object.onSuccess(feedback);
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.a;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }
}

