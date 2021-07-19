/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.l.a$a;
import okio.ByteString;
import okio.ByteString$a;

public final class a {
    public static final ByteString d;
    public static final String e = ":status";
    public static final String f = ":method";
    public static final String g = ":path";
    public static final String h = ":scheme";
    public static final String i = ":authority";
    public static final ByteString j;
    public static final ByteString k;
    public static final ByteString l;
    public static final ByteString m;
    public static final ByteString n;
    public static final a$a o;
    public final int a;
    public final ByteString b;
    public final ByteString c;

    static {
        Object object = new a$a(null);
        o = object;
        object = ByteString.Companion;
        d = ((ByteString$a)object).l(":");
        j = ((ByteString$a)object).l(e);
        k = ((ByteString$a)object).l(f);
        l = ((ByteString$a)object).l(g);
        m = ((ByteString$a)object).l(h);
        n = ((ByteString$a)object).l(i);
    }

    public a(String object, String object2) {
        f0.p(object, "name");
        f0.p(object2, "value");
        ByteString$a byteString$a = ByteString.Companion;
        object = byteString$a.l((String)object);
        object2 = byteString$a.l((String)object2);
        this((ByteString)object, (ByteString)object2);
    }

    public a(ByteString byteString, String object) {
        f0.p(byteString, "name");
        f0.p(object, "value");
        object = ByteString.Companion.l((String)object);
        this(byteString, (ByteString)object);
    }

    public a(ByteString byteString, ByteString byteString2) {
        f0.p(byteString, "name");
        f0.p(byteString2, "value");
        this.b = byteString;
        this.c = byteString2;
        int n10 = byteString.size() + 32;
        int n11 = byteString2.size();
        this.a = n10 += n11;
    }

    public static /* synthetic */ a d(a a10, ByteString byteString, ByteString byteString2, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            byteString = a10.b;
        }
        if ((n10 &= 2) != 0) {
            byteString2 = a10.c;
        }
        return a10.c(byteString, byteString2);
    }

    public final ByteString a() {
        return this.b;
    }

    public final ByteString b() {
        return this.c;
    }

    public final a c(ByteString byteString, ByteString byteString2) {
        f0.p(byteString, "name");
        f0.p(byteString2, "value");
        a a10 = new a(byteString, byteString2);
        return a10;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof a;
                if (!bl3) break block3;
                object = (a)object;
                ByteString byteString = this.b;
                ByteString byteString2 = ((a)object).b;
                bl3 = f0.g(byteString, byteString2);
                if (bl3 && (bl2 = f0.g(byteString = this.c, object = ((a)object).c))) break block2;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int n10;
        ByteString byteString = this.b;
        int n11 = 0;
        if (byteString != null) {
            n10 = ((Object)byteString).hashCode();
        } else {
            n10 = 0;
            byteString = null;
        }
        n10 *= 31;
        ByteString byteString2 = this.c;
        if (byteString2 != null) {
            n11 = ((Object)byteString2).hashCode();
        }
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b.utf8();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        string2 = this.c.utf8();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

