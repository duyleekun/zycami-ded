/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.h2.t.u;
import g.a0;
import g.c0$a;
import g.h0.j.i;
import g.h0.j.k;
import g.h0.j.k$a;
import g.h0.l.a;
import g.h0.l.e;
import g.s;
import g.s$a;
import g.t;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import okhttp3.Protocol;
import okio.ByteString;

public final class e$a {
    private e$a() {
    }

    public /* synthetic */ e$a(u u10) {
        this();
    }

    public final List a(a0 object) {
        f0.p(object, "request");
        s s10 = ((a0)object).k();
        int n10 = s10.size() + 4;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        Object object2 = a.k;
        Object object3 = ((a0)object).m();
        Object object4 = new a((ByteString)object2, (String)object3);
        arrayList.add(object4);
        object2 = a.l;
        object3 = i.a;
        Object object5 = ((a0)object).q();
        object3 = ((i)object3).c((t)object5);
        object4 = new a((ByteString)object2, (String)object3);
        arrayList.add(object4);
        object4 = ((a0)object).i("Host");
        if (object4 != null) {
            object3 = a.n;
            object2 = new a((ByteString)object3, (String)object4);
            arrayList.add(object2);
        }
        object2 = a.m;
        object = ((a0)object).q().X();
        object4 = new a((ByteString)object2, (String)object);
        arrayList.add(object4);
        object = null;
        n10 = s10.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            object2 = s10.h(i10);
            object3 = Locale.US;
            f0.o(object3, "Locale.US");
            object5 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(object2, (String)object5);
            object2 = ((String)object2).toLowerCase((Locale)object3);
            f0.o(object2, "(this as java.lang.String).toLowerCase(locale)");
            object3 = e.j();
            boolean bl2 = object3.contains(object2);
            if (bl2 && (!(bl2 = f0.g(object2, object3 = "te")) || !(bl2 = f0.g(object3 = s10.n(i10), object5 = "trailers")))) continue;
            object5 = s10.n(i10);
            object3 = new a((String)object2, (String)object5);
            arrayList.add(object3);
        }
        return arrayList;
    }

    public final c0$a b(s object, Protocol object2) {
        f0.p(object, "headerBlock");
        f0.p(object2, "protocol");
        s$a s$a = new s$a();
        int n10 = ((s)object).size();
        Object object3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            CharSequence charSequence = ((s)object).h(i10);
            String string2 = ((s)object).n(i10);
            Object object4 = ":status";
            boolean bl2 = f0.g(charSequence, object4);
            if (bl2) {
                object3 = k.h;
                charSequence = new StringBuilder();
                object4 = "HTTP/1.1 ";
                ((StringBuilder)charSequence).append((String)object4);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                object3 = ((k$a)object3).b((String)charSequence);
                continue;
            }
            object4 = e.k();
            bl2 = object4.contains(charSequence);
            if (bl2) continue;
            s$a.g((String)charSequence, string2);
        }
        if (object3 != null) {
            object = new c0$a();
            object = ((c0$a)object).B((Protocol)((Object)object2));
            int n11 = ((k)object3).b;
            object = ((c0$a)object).g(n11);
            object2 = ((k)object3).c;
            object = ((c0$a)object).y((String)object2);
            object2 = s$a.i();
            return ((c0$a)object).w((s)object2);
        }
        object = new ProtocolException("Expected ':status' header not present");
        throw object;
    }
}

