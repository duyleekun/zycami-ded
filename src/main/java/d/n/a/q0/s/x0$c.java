/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import com.jakewharton.rxrelay2.PublishRelay;

public class x0$c {
    public final PublishRelay a;
    public final PublishRelay b;

    public x0$c() {
        PublishRelay publishRelay;
        this.a = publishRelay = PublishRelay.k8();
        this.b = publishRelay = PublishRelay.k8();
    }

    public boolean a() {
        PublishRelay publishRelay = this.a;
        boolean bl2 = publishRelay.h8();
        if (!bl2 && !(bl2 = (publishRelay = this.b).h8())) {
            bl2 = false;
            publishRelay = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

