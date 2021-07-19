/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer$i;
import d.v.e0.ce;

public class ce$v
implements Stabilizer$i {
    public final /* synthetic */ ce a;

    public ce$v(ce ce2) {
        this.a = ce2;
    }

    public void a() {
        this.a.R();
        ce.p(this.a, false);
    }

    public void onConnected() {
        ce.o(this.a);
        this.a.c0();
        ce.p(this.a, true);
    }

    public void onFailed(Throwable throwable) {
        this.a.R();
        ce.q(this.a, throwable);
    }
}

