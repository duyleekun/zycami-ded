/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import d.n.a.q0.s.s0$a;
import e.a.v0.o;
import e.a.z;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;

public class s0$a$b
implements o {
    public final /* synthetic */ PublishSubject a;
    public final /* synthetic */ s0$a b;

    public s0$a$b(s0$a s0$a, PublishSubject publishSubject) {
        this.b = s0$a;
        this.a = publishSubject;
    }

    public z a(z z10) {
        z z11;
        z[] zArray = new z[2];
        zArray[0] = z11 = this.a.e0(byte[].class);
        z11 = this.a;
        zArray[1] = z10 = z10.n6(z11);
        return z.l(Arrays.asList(zArray));
    }
}

