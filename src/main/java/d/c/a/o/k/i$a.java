/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.DecodeJob$b;
import com.bumptech.glide.load.engine.DecodeJob$e;
import d.c.a.e;
import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.o.k.h;
import d.c.a.o.k.i$a$a;
import d.c.a.o.k.l;
import d.c.a.u.k;
import d.c.a.u.o.a;
import d.c.a.u.o.a$d;
import java.util.Map;

public class i$a {
    public final DecodeJob$e a;
    public final Pools$Pool b;
    private int c;

    public i$a(DecodeJob$e decodeJob$e) {
        Object object = new i$a$a(this);
        this.b = object = d.c.a.u.o.a.e(150, (a$d)object);
        this.a = decodeJob$e;
    }

    public DecodeJob a(e object, Object object2, l l10, c c10, int n10, int n11, Class clazz, Class clazz2, Priority priority, h h10, Map map, boolean bl2, boolean bl3, boolean bl4, f f10, DecodeJob$b decodeJob$b) {
        e e10 = object;
        DecodeJob decodeJob = (DecodeJob)k.d((DecodeJob)this.b.acquire());
        object = decodeJob;
        int n12 = this.c;
        int n13 = n12++;
        this.c = n12;
        return decodeJob.o(e10, object2, l10, c10, n10, n11, clazz, clazz2, priority, h10, map, bl2, bl3, bl4, f10, decodeJob$b, n13);
    }
}

