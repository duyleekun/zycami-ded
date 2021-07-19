/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import f.q2.u;
import g.c0;
import g.h0.d;
import g.h0.n.h;
import g.l;
import g.l$b;
import g.m;
import g.s;
import g.t;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;
import okio.ByteString$a;

public final class e {
    private static final ByteString a;
    private static final ByteString b;

    static {
        ByteString$a byteString$a = ByteString.Companion;
        a = byteString$a.l("\"\\");
        b = byteString$a.l("\t ,=");
    }

    public static final boolean a(c0 c02) {
        f0.p(c02, "response");
        return e.c(c02);
    }

    public static final List b(s s10, String string2) {
        f0.p(s10, "$this$parseChallenges");
        f0.p(string2, "headerName");
        ArrayList arrayList = new ArrayList();
        int n10 = s10.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Object object = s10.h(i10);
            boolean bl3 = u.I1(string2, (String)object, bl2 = true);
            if (!bl3) continue;
            object = new h.m();
            Object object2 = s10.n(i10);
            object = ((h.m)object).p1((String)object2);
            try {
                e.d((h.m)object, arrayList);
                continue;
            }
            catch (EOFException eOFException) {
                object2 = h.e.g();
                int n11 = 5;
                String string3 = "Unable to parse challenge";
                ((h)object2).m(string3, n11, eOFException);
            }
        }
        return arrayList;
    }

    public static final boolean c(c0 object) {
        String string2;
        boolean bl2;
        long l10;
        f0.p(object, "$this$promisesBody");
        String string3 = ((c0)object).L0().m();
        int n10 = f0.g(string3, "HEAD");
        if (n10 != 0) {
            return false;
        }
        n10 = ((c0)object).v0();
        int n11 = 100;
        boolean bl3 = true;
        if ((n10 < n11 || n10 >= (n11 = 200)) && n10 != (n11 = 204) && n10 != (n11 = 304)) {
            return bl3;
        }
        long l11 = d.x((c0)object);
        long l12 = l11 - (l10 = (long)-1);
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 == 0 && !(bl2 = u.I1(string3 = "chunked", (String)(object = c0.A0((c0)object, string2 = "Transfer-Encoding", null, n10 = 2, null)), bl3))) {
            return false;
        }
        return bl3;
    }

    /*
     * Exception decompiling
     */
    private static final void d(h.m var0, List var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[UNCONDITIONALDOLOOP]], but top level block is 2[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static final String e(h.m object) {
        Object object2;
        byte by2;
        byte by3 = ((h.m)object).readByte();
        if (by3 == (by2 = (byte)34)) {
            by3 = 1;
        } else {
            by3 = 0;
            object2 = null;
        }
        if (by3 != 0) {
            object2 = new h.m();
            while (true) {
                long l10;
                long l11;
                long l12;
                ByteString byteString;
                long l13;
                long l14;
                Object object3;
                if ((object3 = (l14 = (l13 = ((h.m)object).m(byteString = a)) - (l12 = (long)-1)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
                    return null;
                }
                object3 = ((h.m)object).z0(l13);
                if (object3 == by2) {
                    ((h.m)object2).t((h.m)object, l13);
                    ((h.m)object).readByte();
                    return ((h.m)object2).f0();
                }
                long l15 = ((h.m)object).S0();
                long l16 = l15 - (l11 = l13 + (l10 = 1L));
                object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object3 == false) {
                    return null;
                }
                ((h.m)object2).t((h.m)object, l13);
                ((h.m)object).readByte();
                ((h.m)object2).t((h.m)object, l10);
            }
        }
        object2 = "Failed requirement.".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    private static final String f(h.m object) {
        long l10;
        long l11;
        ByteString byteString = b;
        long l12 = ((h.m)object).m(byteString);
        long l13 = l12 - (l11 = (long)-1);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            l12 = ((h.m)object).S0();
        }
        object = (object2 = (l10 = l12 - (l11 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false ? ((h.m)object).P(l12) : null;
        return object;
    }

    public static final void g(m m10, t t10, s iterable) {
        f0.p(m10, "$this$receiveHeaders");
        f0.p(t10, "url");
        f0.p(iterable, "headers");
        Object object = m.a;
        if (m10 == object) {
            return;
        }
        object = l.n;
        boolean bl2 = (iterable = ((l$b)object).g(t10, (s)iterable)).isEmpty();
        if (bl2) {
            return;
        }
        m10.saveFromResponse(t10, (List)iterable);
    }

    private static final boolean h(h.m m10) {
        int n10;
        boolean bl2 = false;
        while ((n10 = m10.V()) == 0) {
            int n11;
            long l10 = 0L;
            n10 = m10.z0(l10);
            if (n10 != (n11 = 9) && n10 != (n11 = 32)) {
                n11 = 44;
                if (n10 != n11) break;
                m10.readByte();
                bl2 = true;
                continue;
            }
            m10.readByte();
        }
        return bl2;
    }

    private static final boolean i(h.m m10, byte by2) {
        long l10;
        byte by3;
        boolean bl2 = m10.V();
        if (!bl2 && (by3 = m10.z0(l10 = 0L)) == by2) {
            by3 = 1;
        } else {
            by3 = 0;
            m10 = null;
        }
        return by3 != 0;
    }
}

