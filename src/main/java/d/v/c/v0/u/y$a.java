/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.database.model.PublishWorks;
import d.v.c.v0.u.b0.b;
import d.v.c.v0.u.n;
import d.v.c.v0.u.y;
import d.v.h.c.b$a;

public class y$a
implements b$a {
    public final /* synthetic */ y a;

    public y$a(y y10) {
        this.a = y10;
    }

    private /* synthetic */ void d() {
        y.e(this.a);
    }

    public void a(Exception object, String object2) {
        object = y.a(this.a);
        object2 = PublishState.STATE_FAILED;
        ((PublishWorks)object).setState((PublishState)((Object)object2));
        object = y.b(this.a);
        object2 = y.a(this.a);
        ((b)object).r((PublishWorks)object2);
        y.c(this.a).c(4);
    }

    public void b(int n10) {
        PublishWorks publishWorks = y.a(this.a);
        n10 = (int)((double)n10 * 0.3);
        publishWorks.setPercent(n10);
        y y10 = this.a;
        publishWorks = y.a(y10);
        y.d(y10, publishWorks);
    }

    public void c(String object) {
        y.a(this.a).setTranscodingPath((String)object);
        n n10 = new n(this);
        object = new Thread(n10);
        ((Thread)object).start();
    }

    public /* synthetic */ void e() {
        this.d();
    }
}

