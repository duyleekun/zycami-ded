/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.b0;
import g.h0.d;
import g.s;
import g.v;
import g.w;
import g.w$c;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;

public final class w$a {
    private final ByteString a;
    private v b;
    private final List c;

    public w$a() {
        this(null, 1, null);
    }

    public w$a(String arrayList) {
        f0.p(arrayList, "boundary");
        arrayList = ByteString.Companion.l((String)((Object)arrayList));
        this.a = arrayList;
        arrayList = w.f;
        this.b = arrayList;
        this.c = arrayList = new ArrayList();
    }

    public /* synthetic */ w$a(String string2, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            string2 = UUID.randomUUID().toString();
            String string3 = "UUID.randomUUID().toString()";
            f0.o(string2, string3);
        }
        this(string2);
    }

    public final w$a a(String object, String string2) {
        f0.p(object, "name");
        f0.p(string2, "value");
        object = w$c.c.c((String)object, string2);
        this.d((w$c)object);
        return this;
    }

    public final w$a b(String object, String string2, b0 b02) {
        f0.p(object, "name");
        f0.p(b02, "body");
        object = w$c.c.d((String)object, string2, b02);
        this.d((w$c)object);
        return this;
    }

    public final w$a c(s object, b0 b02) {
        f0.p(b02, "body");
        object = w$c.c.a((s)object, b02);
        this.d((w$c)object);
        return this;
    }

    public final w$a d(w$c w$c) {
        f0.p(w$c, "part");
        this.c.add(w$c);
        return this;
    }

    public final w$a e(b0 object) {
        f0.p(object, "body");
        object = w$c.c.b((b0)object);
        this.d((w$c)object);
        return this;
    }

    public final w f() {
        Object object = this.c;
        boolean bl2 = object.isEmpty() ^ true;
        if (bl2) {
            ByteString byteString = this.a;
            v v10 = this.b;
            List list = d.c0(this.c);
            object = new w(byteString, v10, list);
            return object;
        }
        String string2 = "Multipart body must have at least one part.".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final w$a g(v object) {
        f0.p(object, "type");
        Object object2 = ((v)object).l();
        String string2 = "multipart";
        boolean bl2 = f0.g(object2, string2);
        if (bl2) {
            this.b = object;
            return this;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("multipart != ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }
}

