/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.A;
import j$.time.format.B;
import j$.time.format.C;
import j$.time.format.DateTimeFormatter;
import j$.time.format.a_0;
import j$.time.format.b_0;
import j$.time.format.d;
import j$.time.format.e;
import j$.time.format.f;
import j$.time.format.g;
import j$.time.format.h;
import j$.time.format.i;
import j$.time.format.j;
import j$.time.format.k;
import j$.time.format.l;
import j$.time.format.n;
import j$.time.format.o;
import j$.time.format.p;
import j$.time.format.r;
import j$.time.format.x;
import j$.time.format.y;
import j$.time.format.z;
import j$.time.q.q;
import j$.time.q.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class t {
    private static final Map h;
    public static final /* synthetic */ int i;
    private t a = this;
    private final t b;
    private final List c;
    private final boolean d;
    private int e;
    private char f;
    private int g;

    static {
        HashMap<Character, j$.time.q.h> hashMap;
        h = hashMap = new HashMap<Character, j$.time.q.h>();
        Character c10 = Character.valueOf('G');
        u u10 = j$.time.q.h.F;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('y');
        u10 = j$.time.q.h.D;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('u');
        u10 = j$.time.q.h.E;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('Q');
        u10 = q.a;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('q');
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('M');
        u10 = j$.time.q.h.B;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('L');
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('D');
        u10 = j$.time.q.h.x;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('d');
        u10 = j$.time.q.h.w;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('F');
        u10 = j$.time.q.h.u;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('E');
        u10 = j$.time.q.h.t;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('c');
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('e');
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('a');
        u10 = j$.time.q.h.s;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('H');
        u10 = j$.time.q.h.q;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('k');
        u10 = j$.time.q.h.r;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('K');
        u10 = j$.time.q.h.o;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('h');
        u10 = j$.time.q.h.p;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('m');
        u10 = j$.time.q.h.m;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('s');
        u10 = j$.time.q.h.k;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('S');
        u10 = j$.time.q.h.e;
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('A');
        j$.time.q.h h10 = j$.time.q.h.j;
        hashMap.put(c10, h10);
        c10 = Character.valueOf('n');
        hashMap.put(c10, (j$.time.q.h)u10);
        c10 = Character.valueOf('N');
        u10 = j$.time.q.h.f;
        hashMap.put(c10, (j$.time.q.h)u10);
    }

    public t() {
        ArrayList arrayList;
        this.c = arrayList = new ArrayList();
        this.g = -1;
        this.b = null;
        this.d = false;
    }

    private t(t t10, boolean bl2) {
        ArrayList arrayList;
        this.c = arrayList = new ArrayList();
        this.g = -1;
        this.b = t10;
        this.d = bl2;
    }

    private int d(f object) {
        Objects.requireNonNull(object, "pp");
        t t10 = this.a;
        int n10 = t10.e;
        if (n10 > 0) {
            char c10 = t10.f;
            l l10 = new l((f)object, n10, c10);
            t10.e = 0;
            t10.f = '\u0000';
            object = l10;
        }
        t10.c.add(object);
        object = this.a;
        ((t)object).g = -1;
        return ((t)object).c.size() + -1;
    }

    private t m(j object) {
        Object object2 = this.a;
        int n10 = ((t)object2).g;
        if (n10 >= 0) {
            B b10;
            Object object3;
            object2 = (j)((t)object2).c.get(n10);
            int n11 = ((j)object).b;
            int n12 = ((j)object).c;
            if (n11 == n12 && (object3 = j.a((j)object)) == (b10 = B.c)) {
                n11 = ((j)object).c;
                object2 = ((j)object2).d(n11);
                object = ((j)object).c();
                this.d((f)object);
                object = this.a;
                ((t)object).g = n10;
            } else {
                int n13;
                object2 = ((j)object2).c();
                object3 = this.a;
                ((t)object3).g = n13 = this.d((f)object);
            }
            object = this.a.c;
            object.set(n10, object2);
        } else {
            int n14;
            ((t)object2).g = n14 = this.d((f)object);
        }
        return this;
    }

    private DateTimeFormatter y(Locale locale, A a10, j$.time.p.j j10) {
        Object object = "locale";
        Objects.requireNonNull(locale, (String)object);
        while ((object = this.a.b) != null) {
            this.r();
        }
        object = this.c;
        e e10 = new e((List)object, false);
        z z10 = z.e;
        object = new DateTimeFormatter(e10, locale, z10, a10, null, j10, null);
        return object;
    }

    public t a(DateTimeFormatter object) {
        object = ((DateTimeFormatter)object).f(false);
        this.d((f)object);
        return this;
    }

    public t b(u u10, int n10, int n11, boolean bl2) {
        g g10 = new g(u10, n10, n11, bl2);
        this.d(g10);
        return this;
    }

    public t c() {
        h h10 = new h(-2);
        this.d(h10);
        return this;
    }

    public t e(char c10) {
        d d10 = new d(c10);
        this.d(d10);
        return this;
    }

    public t f(String string2) {
        Object object = "literal";
        Objects.requireNonNull(string2, (String)object);
        int n10 = string2.length();
        if (n10 > 0) {
            int n11;
            n10 = string2.length();
            if (n10 == (n11 = 1)) {
                n11 = 0;
                char c10 = string2.charAt(0);
                object = new d(c10);
            } else {
                object = new o(string2);
            }
            this.d((f)object);
        }
        return this;
    }

    public t g(C object) {
        Object object2 = C.b;
        if (object != object2 && object != (object2 = C.d)) {
            object = new IllegalArgumentException("Style must be either full or short");
            throw object;
        }
        object2 = new i((C)((Object)object));
        this.d((f)object2);
        return this;
    }

    public t h(String string2, String string3) {
        k k10 = new k(string2, string3);
        this.d(k10);
        return this;
    }

    public t i() {
        k k10 = k.d;
        this.d(k10);
        return this;
    }

    /*
     * Exception decompiling
     */
    public t j(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[CASE], 1[CASE]], but top level block is 12[SWITCH]
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

    public t k(u u10, C c10) {
        Objects.requireNonNull(u10, "field");
        y y10 = new y();
        p p10 = new p(u10, c10, y10);
        this.d(p10);
        return this;
    }

    public t l(u u10, Map object) {
        Objects.requireNonNull(u10, "field");
        Object object2 = new LinkedHashMap(object);
        object = C.b;
        object2 = Collections.singletonMap(object, object2);
        Object object3 = new x((Map)object2);
        object2 = new b_0(this, (x)object3);
        object3 = new p(u10, (C)((Object)object), (y)object2);
        this.d((f)object3);
        return this;
    }

    public t n(u u10) {
        Objects.requireNonNull(u10, "field");
        B b10 = B.a;
        j j10 = new j(u10, 1, 19, b10);
        this.m(j10);
        return this;
    }

    public t o(u object, int n10) {
        Object object2 = "field";
        Objects.requireNonNull(object, (String)object2);
        int n11 = 1;
        if (n10 >= n11 && n10 <= (n11 = 19)) {
            B b10 = B.c;
            object2 = new j((u)object, n10, n10, b10);
            this.m((j)object2);
            return this;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("The width must be from 1 to 19 inclusive but was ");
        ((StringBuilder)object2).append(n10);
        String string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public t p(u object, int n10, int n11, B object2) {
        int n12;
        Object object3;
        if (n10 == n11 && object2 == (object3 = B.c)) {
            this.o((u)object, n11);
            return this;
        }
        object3 = "field";
        Objects.requireNonNull(object, (String)object3);
        int n13 = 1;
        if (n10 >= n13 && n10 <= (n12 = 19)) {
            if (n11 >= n13 && n11 <= n12) {
                if (n11 >= n10) {
                    object3 = new j((u)object, n10, n11, (B)((Object)object2));
                    this.m((j)object3);
                    return this;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("The maximum width must exceed or equal the minimum width but ");
                ((StringBuilder)object2).append(n11);
                ((StringBuilder)object2).append(" < ");
                ((StringBuilder)object2).append(n10);
                String string2 = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("The maximum width must be from 1 to 19 inclusive but was ");
            charSequence.append(n11);
            charSequence = charSequence.toString();
            object = new IllegalArgumentException((String)charSequence);
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The minimum width must be from 1 to 19 inclusive but was ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        object = new IllegalArgumentException(string3);
        throw object;
    }

    public t q() {
        a_0 a_02 = a_0.a;
        r r10 = new r(a_02, "ZoneRegionId()");
        this.d(r10);
        return this;
    }

    public t r() {
        Object object = this.a;
        t t10 = ((t)object).b;
        if (t10 != null) {
            object = ((t)object).c;
            int n10 = object.size();
            if (n10 > 0) {
                t10 = this.a;
                List list = t10.c;
                boolean bl2 = t10.d;
                object = new e(list, bl2);
                this.a = t10 = this.a.b;
                this.d((f)object);
            } else {
                this.a = object = this.a.b;
            }
            return this;
        }
        object = new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        throw object;
    }

    public t s() {
        t t10;
        t t11 = this.a;
        t11.g = -1;
        this.a = t10 = new t(t11, true);
        return this;
    }

    public t t() {
        n n10 = n.b;
        this.d(n10);
        return this;
    }

    public t u() {
        n n10 = n.a;
        this.d(n10);
        return this;
    }

    public t v() {
        n n10 = n.c;
        this.d(n10);
        return this;
    }

    public DateTimeFormatter w() {
        Locale locale = Locale.getDefault();
        A a10 = A.b;
        return this.y(locale, a10, null);
    }

    DateTimeFormatter x(A a10, j$.time.p.j j10) {
        Locale locale = Locale.getDefault();
        return this.y(locale, a10, j10);
    }
}

