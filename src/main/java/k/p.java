/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.a0$a;
import g.b0;
import g.r$a;
import g.s;
import g.s$a;
import g.t;
import g.t$a;
import g.v;
import g.w;
import g.w$a;
import g.w$c;
import h.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.p$a;

public final class p {
    private static final char[] l;
    private static final String m = " \"<>^`{}|\\?#";
    private static final Pattern n;
    private final String a;
    private final t b;
    private String c;
    private t$a d;
    private final a0$a e;
    private final s$a f;
    private v g;
    private final boolean h;
    private w$a i;
    private r$a j;
    private b0 k;

    static {
        char[] cArray;
        char[] cArray2 = cArray = new char[16];
        char[] cArray3 = cArray;
        cArray2[0] = 48;
        cArray3[1] = 49;
        cArray2[2] = 50;
        cArray3[3] = 51;
        cArray2[4] = 52;
        cArray3[5] = 53;
        cArray2[6] = 54;
        cArray3[7] = 55;
        cArray2[8] = 56;
        cArray3[9] = 57;
        cArray2[10] = 65;
        cArray3[11] = 66;
        cArray2[12] = 67;
        cArray3[13] = 68;
        cArray2[14] = 69;
        cArray3[15] = 70;
        l = cArray;
        n = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    }

    public p(String object, t object2, String string2, s s10, v v10, boolean bl2, boolean bl3, boolean bl4) {
        this.a = object;
        this.b = object2;
        this.c = string2;
        this.e = object = new a0$a();
        this.g = v10;
        this.h = bl2;
        this.f = s10 != null ? (object = s10.j()) : (object = new s$a());
        if (bl3) {
            this.j = object = new r$a();
        } else if (bl4) {
            this.i = object = new w$a();
            object2 = w.j;
            ((w$a)object).g((v)object2);
        }
    }

    private static String i(String string2, boolean bl2) {
        int n10;
        int n11 = string2.length();
        for (int i10 = 0; i10 < n11; i10 += n10) {
            int n12;
            String string3;
            int n13;
            n10 = string2.codePointAt(i10);
            if (n10 >= (n13 = 32) && n10 < (n13 = 127) && (n13 = (string3 = m).indexOf(n10)) == (n12 = -1) && (bl2 || n10 != (n13 = 47) && n10 != (n13 = 37))) {
                n10 = Character.charCount(n10);
                continue;
            }
            m m10 = new m();
            m10.q1(string2, 0, i10);
            p.j(m10, string2, i10, n11, bl2);
            string2 = m10.f0();
            break;
        }
        return string2;
    }

    private static void j(m m10, String string2, int n10, int n11, boolean bl2) {
        m m11 = null;
        while (n10 < n11) {
            int n12;
            int n13 = string2.codePointAt(n10);
            if (!bl2 || n13 != (n12 = 9) && n13 != (n12 = 10) && n13 != (n12 = 12) && n13 != (n12 = 13)) {
                int n14;
                String string3;
                n12 = 32;
                int n15 = 37;
                if (n13 >= n12 && n13 < (n12 = 127) && (n12 = (string3 = m).indexOf(n13)) == (n14 = -1) && (bl2 || n13 != (n12 = 47) && n13 != n15)) {
                    m10.r1(n13);
                } else {
                    if (m11 == null) {
                        m11 = new m();
                    }
                    m11.r1(n13);
                    while ((n12 = (int)(m11.V() ? 1 : 0)) == 0) {
                        n12 = m11.readByte() & 0xFF;
                        m10.b1(n15);
                        char[] cArray = l;
                        int n16 = n12 >> 4 & 0xF;
                        n16 = cArray[n16];
                        m10.b1(n16);
                        n12 &= 0xF;
                        n12 = cArray[n12];
                        m10.b1(n12);
                    }
                }
            }
            n13 = Character.charCount(n13);
            n10 += n13;
        }
    }

    public void a(String string2, String string3, boolean bl2) {
        if (bl2) {
            r$a r$a = this.j;
            r$a.b(string2, string3);
        } else {
            r$a r$a = this.j;
            r$a.a(string2, string3);
        }
    }

    public void b(String object, String string2) {
        Object object2 = "Content-Type";
        boolean bl2 = ((String)object2).equalsIgnoreCase((String)object);
        if (bl2) {
            try {
                object = v.h(string2);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Malformed content type: ");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                object2 = new IllegalArgumentException(string2, illegalArgumentException);
                throw object2;
            }
            this.g = object;
        } else {
            object2 = this.f;
            ((s$a)object2).b((String)object, string2);
        }
    }

    public void c(s s10) {
        this.f.e(s10);
    }

    public void d(s s10, b0 b02) {
        this.i.c(s10, b02);
    }

    public void e(w$c w$c) {
        this.i.d(w$c);
    }

    public void f(String object, String string2, boolean bl2) {
        String string3 = this.c;
        if (string3 != null) {
            Object object2 = p.i(string2, bl2);
            string3 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "{";
            stringBuilder.append(string4);
            stringBuilder.append((String)object);
            stringBuilder.append("}");
            object = stringBuilder.toString();
            object = string3.replace((CharSequence)object, (CharSequence)object2);
            object2 = n.matcher((CharSequence)object);
            bl2 = ((Matcher)object2).matches();
            if (!bl2) {
                this.c = object;
                return;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("@Path parameters shouldn't perform path traversal ('.' or '..'): ");
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        object = new AssertionError();
        throw object;
    }

    public void g(String object, String charSequence, boolean bl2) {
        Object object2 = this.c;
        if (object2 != null) {
            t t10 = this.b;
            this.d = object2 = t10.I((String)object2);
            if (object2 != null) {
                object2 = null;
                this.c = null;
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Malformed URL. Base: ");
                Object object3 = this.b;
                ((StringBuilder)charSequence).append(object3);
                ((StringBuilder)charSequence).append(", Relative: ");
                object3 = this.c;
                ((StringBuilder)charSequence).append((String)object3);
                charSequence = ((StringBuilder)charSequence).toString();
                object = new IllegalArgumentException((String)charSequence);
                throw object;
            }
        }
        if (bl2) {
            t$a t$a = this.d;
            t$a.c((String)object, (String)charSequence);
        } else {
            t$a t$a = this.d;
            t$a.g((String)object, (String)charSequence);
        }
    }

    public void h(Class clazz, Object object) {
        this.e.z(clazz, object);
    }

    public a0$a k() {
        Object object;
        Object object2;
        block14: {
            Object object3;
            block13: {
                block12: {
                    object2 = this.d;
                    if (object2 == null) break block12;
                    object2 = ((t$a)object2).h();
                    break block13;
                }
                object2 = this.b;
                object = this.c;
                if ((object2 = ((t)object2).W((String)object)) == null) break block14;
            }
            object = this.k;
            if (object == null) {
                object3 = this.j;
                if (object3 != null) {
                    object = ((r$a)object3).c();
                } else {
                    object3 = this.i;
                    if (object3 != null) {
                        object = ((w$a)object3).f();
                    } else {
                        boolean bl2 = this.h;
                        if (bl2) {
                            bl2 = false;
                            object3 = new byte[0];
                            object = b0.create(null, (byte[])object3);
                        }
                    }
                }
            }
            if ((object3 = this.g) != null) {
                if (object != null) {
                    p$a p$a = new p$a((b0)object, (v)object3);
                    object = p$a;
                } else {
                    s$a s$a = this.f;
                    object3 = ((v)object3).toString();
                    String string2 = "Content-Type";
                    s$a.b(string2, (String)object3);
                }
            }
            object2 = this.e.D((t)object2);
            object3 = this.f.i();
            object2 = ((a0$a)object2).o((s)object3);
            object3 = this.a;
            return ((a0$a)object2).p((String)object3, (b0)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Malformed URL. Base: ");
        Object object4 = this.b;
        ((StringBuilder)object).append(object4);
        ((StringBuilder)object).append(", Relative: ");
        object4 = this.c;
        ((StringBuilder)object).append((String)object4);
        object = ((StringBuilder)object).toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void l(b0 b02) {
        this.k = b02;
    }

    public void m(Object object) {
        this.c = object = object.toString();
    }
}

