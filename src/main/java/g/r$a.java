/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.u;
import g.r;
import g.t;
import g.t$b;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public final class r$a {
    private final List a;
    private final List b;
    private final Charset c;

    public r$a() {
        this(null, 1, null);
    }

    public r$a(Charset arrayList) {
        this.c = arrayList;
        this.a = arrayList = new ArrayList();
        this.b = arrayList = new ArrayList();
    }

    public /* synthetic */ r$a(Charset charset, int n10, u u10) {
        if ((n10 &= 1) != 0) {
            charset = null;
        }
        this(charset);
    }

    public final r$a a(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        List list = this.a;
        t$b t$b = t.w;
        Charset charset = this.c;
        boolean bl2 = true;
        int n10 = 91;
        Object object = t$b;
        object = t$b.f(t$b, string2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, bl2, false, charset, n10, null);
        list.add(object);
        list = this.b;
        charset = this.c;
        object = t$b;
        object = t$b.f(t$b, string3, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, bl2, false, charset, n10, null);
        list.add(object);
        return this;
    }

    public final r$a b(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        List list = this.a;
        t$b t$b = t.w;
        Charset charset = this.c;
        boolean bl2 = true;
        boolean bl3 = true;
        int n10 = 83;
        Object object = t$b;
        object = t$b.f(t$b, string2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", bl2, false, bl3, false, charset, n10, null);
        list.add(object);
        list = this.b;
        charset = this.c;
        object = t$b;
        object = t$b.f(t$b, string3, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", bl2, false, bl3, false, charset, n10, null);
        list.add(object);
        return this;
    }

    public final r c() {
        List list = this.a;
        List list2 = this.b;
        r r10 = new r(list, list2);
        return r10;
    }
}

