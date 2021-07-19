/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.e.e.y1$c;
import io.reactivex.subjects.UnicastSubject;

public final class y1$c$a
implements Runnable {
    private final UnicastSubject a;
    public final /* synthetic */ y1$c b;

    public y1$c$a(y1$c c10, UnicastSubject unicastSubject) {
        this.b = c10;
        this.a = unicastSubject;
    }

    public void run() {
        y1$c y1$c = this.b;
        UnicastSubject unicastSubject = this.a;
        y1$c.i(unicastSubject);
    }
}

