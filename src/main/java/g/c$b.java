/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.h2.t.s0;
import f.q2.u;
import f.x1.d1;
import g.a0;
import g.c0;
import g.h0.d;
import g.s;
import g.s$a;
import g.t;
import h.o;
import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import kotlin.text.StringsKt__StringsKt;
import okio.ByteString;
import okio.ByteString$a;

public final class c$b {
    private c$b() {
    }

    public /* synthetic */ c$b(f.h2.t.u u10) {
        this();
    }

    private final Set d(s s10) {
        int n10 = s10.size();
        TreeSet<String> treeSet = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            int n11;
            String string2 = "Vary";
            Object object = s10.h(i10);
            int n12 = u.I1(string2, (String)object, (n11 = 1) != 0);
            if (n12 == 0) continue;
            String string3 = s10.n(i10);
            if (treeSet == null) {
                object = u.Q1(s0.a);
                treeSet = new TreeSet<String>((Comparator<String>)object);
            }
            char[] cArray = new char[n11];
            cArray[0] = n12 = 44;
            int n13 = 6;
            object = StringsKt__StringsKt.H4(string3, cArray, false, 0, n13, null).iterator();
            while (bl2 = object.hasNext()) {
                string2 = (String)object.next();
                String string4 = "null cannot be cast to non-null type kotlin.CharSequence";
                Objects.requireNonNull(string2, string4);
                string2 = ((Object)StringsKt__StringsKt.p5(string2)).toString();
                treeSet.add(string2);
            }
        }
        if (treeSet == null) {
            treeSet = d1.k();
        }
        return treeSet;
    }

    private final s e(s s10, s iterable) {
        boolean bl2 = (iterable = this.d((s)iterable)).isEmpty();
        if (bl2) {
            return d.b;
        }
        s$a s$a = new s$a();
        int n10 = s10.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = s10.h(i10);
            boolean bl3 = iterable.contains(string2);
            if (!bl3) continue;
            String string3 = s10.n(i10);
            s$a.b(string2, string3);
        }
        return s$a.i();
    }

    public final boolean a(c0 object) {
        f0.p(object, "$this$hasVaryAll");
        object = ((c0)object).C0();
        return this.d((s)object).contains("*");
    }

    public final String b(t object) {
        f0.p(object, "url");
        ByteString$a byteString$a = ByteString.Companion;
        object = ((t)object).toString();
        return byteString$a.l((String)object).md5().hex();
    }

    public final int c(o object) {
        IOException iOException;
        long l10;
        block14: {
            long l11;
            block15: {
                block13: {
                    long l12;
                    Object object2 = "source";
                    f0.p(object, (String)object2);
                    try {
                        l10 = object.W();
                    }
                    catch (NumberFormatException numberFormatException) {
                        String string2 = numberFormatException.getMessage();
                        object2 = new IOException(string2);
                        throw object2;
                    }
                    object = object.w();
                    long l13 = 0L;
                    l11 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
                    if (l11 < 0 || (l11 = (l12 = l10 - (l13 = (long)(-1 >>> 1))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) break block14;
                    l11 = object.length();
                    if (l11 <= 0) break block13;
                    l11 = 1;
                    break block15;
                }
                l11 = 0;
                iOException = null;
            }
            if (l11 == false) {
                return (int)l10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "expected an int but was \"";
        stringBuilder.append(string3);
        stringBuilder.append(l10);
        stringBuilder.append((String)object);
        char c10 = '\"';
        stringBuilder.append(c10);
        object = stringBuilder.toString();
        iOException = new IOException((String)object);
        throw iOException;
    }

    public final s f(c0 object) {
        f0.p(object, "$this$varyHeaders");
        Object object2 = ((c0)object).F0();
        f0.m(object2);
        object2 = ((c0)object2).L0().k();
        object = ((c0)object).C0();
        return this.e((s)object2, (s)object);
    }

    public final boolean g(c0 iterator2, s s10, a0 a02) {
        f0.p(iterator2, "cachedResponse");
        f0.p(s10, "cachedRequest");
        Object object = "newRequest";
        f0.p(a02, (String)object);
        iterator2 = ((c0)((Object)iterator2)).C0();
        iterator2 = this.d((s)((Object)iterator2));
        boolean bl2 = iterator2 instanceof Collection;
        boolean bl3 = true;
        if (!bl2 || !(bl2 = iterator2.isEmpty())) {
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object = (String)iterator2.next();
                List list = s10.o((String)object);
                bl2 = f0.g(list, object = a02.j((String)object)) ^ bl3;
                if (!bl2) continue;
                bl3 = false;
                break;
            }
        }
        return bl3;
    }
}

