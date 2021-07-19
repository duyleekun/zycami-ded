/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import com.zhiyun.cama.publish.PublishFragment$c;

public final class z
implements Runnable {
    public final /* synthetic */ PublishFragment$c a;
    public final /* synthetic */ double b;
    public final /* synthetic */ double c;

    public /* synthetic */ z(PublishFragment$c publishFragment$c, double d10, double d11) {
        this.a = publishFragment$c;
        this.b = d10;
        this.c = d11;
    }

    public final void run() {
        PublishFragment$c publishFragment$c = this.a;
        double d10 = this.b;
        double d11 = this.c;
        publishFragment$c.f(d10, d11);
    }
}

