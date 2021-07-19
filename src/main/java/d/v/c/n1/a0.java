/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import com.zhiyun.cama.publish.PublishFragment$c;

public final class a0
implements Runnable {
    public final /* synthetic */ PublishFragment$c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ a0(PublishFragment$c c10, String string2, String string3) {
        this.a = c10;
        this.b = string2;
        this.c = string3;
    }

    public final void run() {
        PublishFragment$c publishFragment$c = this.a;
        String string2 = this.b;
        String string3 = this.c;
        publishFragment$c.d(string2, string3);
    }
}

