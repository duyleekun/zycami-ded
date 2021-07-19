/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DecodeJob$e;
import d.c.a.o.k.i$a;
import d.c.a.u.o.a$d;

public class i$a$a
implements a$d {
    public final /* synthetic */ i$a a;

    public i$a$a(i$a i$a) {
        this.a = i$a;
    }

    public DecodeJob a() {
        Object object = this.a;
        DecodeJob$e decodeJob$e = ((i$a)object).a;
        object = ((i$a)object).b;
        DecodeJob decodeJob = new DecodeJob(decodeJob$e, (Pools$Pool)object);
        return decodeJob;
    }
}

