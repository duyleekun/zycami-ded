/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.database.model.Feedback;
import d.v.c.v0.u.v$h;

public final class c
implements Runnable {
    public final /* synthetic */ v$h a;
    public final /* synthetic */ Feedback b;

    public /* synthetic */ c(v$h h10, Feedback feedback) {
        this.a = h10;
        this.b = feedback;
    }

    public final void run() {
        v$h v$h = this.a;
        Feedback feedback = this.b;
        v$h.b(feedback);
    }
}

