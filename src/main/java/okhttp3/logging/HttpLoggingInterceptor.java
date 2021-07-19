/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.logging;

import f.e2.b;
import f.h2.t.f0;
import f.h2.t.s0;
import f.q2.u;
import f.x1.d1;
import f.x1.y;
import g.a0;
import g.b0;
import g.c0;
import g.d0;
import g.h0.j.e;
import g.s;
import g.u$a;
import g.v;
import h.m;
import h.m0;
import h.n;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor$Level;
import okhttp3.logging.HttpLoggingInterceptor$a;

public final class HttpLoggingInterceptor
implements g.u {
    private volatile Set b;
    private volatile HttpLoggingInterceptor$Level c;
    private final HttpLoggingInterceptor$a d;

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(HttpLoggingInterceptor$a object) {
        f0.p(object, "logger");
        this.d = object;
        this.b = object = d1.k();
        object = HttpLoggingInterceptor$Level.NONE;
        this.c = object;
    }

    public /* synthetic */ HttpLoggingInterceptor(HttpLoggingInterceptor$a httpLoggingInterceptor$a, int n10, f.h2.t.u u10) {
        if ((n10 &= 1) != 0) {
            httpLoggingInterceptor$a = HttpLoggingInterceptor$a.a;
        }
        this(httpLoggingInterceptor$a);
    }

    private final boolean b(s object) {
        boolean bl2;
        boolean bl3;
        String string2;
        boolean bl4;
        object = ((s)object).e("Content-Encoding");
        boolean bl5 = false;
        if (object != null && !(bl4 = u.I1((String)object, string2 = "identity", bl3 = true)) && !(bl2 = u.I1((String)object, string2 = "gzip", bl3))) {
            bl5 = bl3;
        }
        return bl5;
    }

    private final void e(s object, int n10) {
        Object object2 = this.b;
        Object object3 = ((s)object).h(n10);
        boolean bl2 = object2.contains(object3);
        object2 = bl2 ? "\u2588\u2588" : ((s)object).n(n10);
        object3 = this.d;
        StringBuilder stringBuilder = new StringBuilder();
        object = ((s)object).h(n10);
        stringBuilder.append((String)object);
        stringBuilder.append(": ");
        stringBuilder.append((String)object2);
        object = stringBuilder.toString();
        object3.log((String)object);
    }

    public final HttpLoggingInterceptor$Level a() {
        return this.c;
    }

    public final HttpLoggingInterceptor$Level c() {
        return this.c;
    }

    public final void d(HttpLoggingInterceptor$Level httpLoggingInterceptor$Level) {
        f0.p((Object)httpLoggingInterceptor$Level, "<set-?>");
        this.c = httpLoggingInterceptor$Level;
    }

    public final void f(String string2) {
        f0.p(string2, "name");
        Object object = u.Q1(s0.a);
        TreeSet<String> treeSet = new TreeSet<String>((Comparator<String>)object);
        object = this.b;
        y.q0(treeSet, (Iterable)object);
        treeSet.add(string2);
        this.b = treeSet;
    }

    public final HttpLoggingInterceptor g(HttpLoggingInterceptor$Level httpLoggingInterceptor$Level) {
        f0.p((Object)httpLoggingInterceptor$Level, "level");
        this.c = httpLoggingInterceptor$Level;
        return this;
    }

    public c0 intercept(u$a u$a) {
        char c10;
        Object object;
        int n10;
        long l10;
        int n11;
        CharSequence charSequence;
        Object object2;
        Object object3;
        Object object4;
        long l11;
        CharSequence charSequence2;
        CharSequence charSequence3;
        boolean bl2;
        Object object5;
        boolean bl3;
        HttpLoggingInterceptor httpLoggingInterceptor = this;
        Object object6 = u$a;
        f0.p(u$a, "chain");
        Object object7 = this.c;
        Object object8 = u$a.C();
        Object object9 = HttpLoggingInterceptor$Level.NONE;
        if (object7 == object9) {
            return u$a.c((a0)object8);
        }
        object9 = HttpLoggingInterceptor$Level.BODY;
        if (object7 == object9) {
            bl3 = true;
        } else {
            bl3 = false;
            object9 = null;
        }
        if (!bl3 && object7 != (object5 = HttpLoggingInterceptor$Level.HEADERS)) {
            bl2 = false;
            object7 = null;
        } else {
            bl2 = true;
        }
        object5 = ((a0)object8).f();
        Object object10 = u$a.f();
        CharSequence charSequence4 = new StringBuilder();
        ((StringBuilder)charSequence4).append("--> ");
        Object object11 = ((a0)object8).m();
        ((StringBuilder)charSequence4).append((String)object11);
        int n12 = 32;
        ((StringBuilder)charSequence4).append((char)n12);
        Object object12 = ((a0)object8).q();
        ((StringBuilder)charSequence4).append(object12);
        object12 = "";
        if (object10 != null) {
            charSequence3 = new StringBuilder();
            charSequence2 = " ";
            ((StringBuilder)charSequence3).append((String)charSequence2);
            object10 = object10.a();
            ((StringBuilder)charSequence3).append(object10);
            object10 = ((StringBuilder)charSequence3).toString();
        } else {
            object10 = object12;
        }
        ((StringBuilder)charSequence4).append((String)object10);
        object10 = ((StringBuilder)charSequence4).toString();
        charSequence4 = "-byte body)";
        charSequence3 = " (";
        if (!bl2 && object5 != null) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)object10);
            ((StringBuilder)charSequence2).append((String)charSequence3);
            l11 = ((b0)object5).contentLength();
            ((StringBuilder)charSequence2).append(l11);
            ((StringBuilder)charSequence2).append((String)charSequence4);
            object10 = ((StringBuilder)charSequence2).toString();
        }
        httpLoggingInterceptor.d.log((String)object10);
        object10 = "-byte body omitted)";
        charSequence2 = "UTF_8";
        if (bl2) {
            object4 = ((a0)object8).k();
            if (object5 != null) {
                long l12;
                object3 = ((b0)object5).contentType();
                if (object3 != null && (object11 = ((s)object4).e("Content-Type")) == null) {
                    object11 = httpLoggingInterceptor.d;
                    object2 = new StringBuilder();
                    charSequence = "Content-Type: ";
                    ((StringBuilder)object2).append((String)charSequence);
                    ((StringBuilder)object2).append(object3);
                    object3 = ((StringBuilder)object2).toString();
                    object11.log((String)object3);
                }
                if ((n11 = (int)((l12 = (l11 = ((b0)object5).contentLength()) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) && (object3 = ((s)object4).e("Content-Length")) == null) {
                    object3 = httpLoggingInterceptor.d;
                    object11 = new StringBuilder();
                    object2 = "Content-Length: ";
                    ((StringBuilder)object11).append((String)object2);
                    l11 = ((b0)object5).contentLength();
                    ((StringBuilder)object11).append(l11);
                    object11 = ((StringBuilder)object11).toString();
                    object3.log((String)object11);
                }
            }
            n11 = ((s)object4).size();
            object11 = null;
            for (n12 = 0; n12 < n11; n12 += 1) {
                httpLoggingInterceptor.e((s)object4, n12);
            }
            object4 = "--> END ";
            if (bl3 && object5 != null) {
                object3 = ((a0)object8).k();
                n11 = (int)(httpLoggingInterceptor.b((s)object3) ? 1 : 0);
                if (n11) {
                    object3 = httpLoggingInterceptor.d;
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append((String)object4);
                    object4 = ((a0)object8).m();
                    ((StringBuilder)object5).append((String)object4);
                    ((StringBuilder)object5).append(" (encoded body omitted)");
                    object4 = ((StringBuilder)object5).toString();
                    object3.log((String)object4);
                } else {
                    n11 = (int)(((b0)object5).isDuplex() ? 1 : 0);
                    if (n11) {
                        object3 = httpLoggingInterceptor.d;
                        object5 = new StringBuilder();
                        ((StringBuilder)object5).append((String)object4);
                        object4 = ((a0)object8).m();
                        ((StringBuilder)object5).append((String)object4);
                        ((StringBuilder)object5).append(" (duplex request body omitted)");
                        object4 = ((StringBuilder)object5).toString();
                        object3.log((String)object4);
                    } else {
                        n11 = (int)(((b0)object5).isOneShot() ? 1 : 0);
                        if (n11) {
                            object3 = httpLoggingInterceptor.d;
                            object5 = new StringBuilder();
                            ((StringBuilder)object5).append((String)object4);
                            object4 = ((a0)object8).m();
                            ((StringBuilder)object5).append((String)object4);
                            ((StringBuilder)object5).append(" (one-shot body omitted)");
                            object4 = ((StringBuilder)object5).toString();
                            object3.log((String)object4);
                        } else {
                            object3 = new m();
                            ((b0)object5).writeTo((n)object3);
                            object11 = ((b0)object5).contentType();
                            if (object11 == null || (object11 = ((v)object11).f((Charset)(object2 = StandardCharsets.UTF_8))) == null) {
                                object11 = StandardCharsets.UTF_8;
                                f0.o(object11, (String)charSequence2);
                            }
                            object2 = httpLoggingInterceptor.d;
                            object2.log((String)object12);
                            n10 = (int)(g.i0.b.a((m)object3) ? 1 : 0);
                            if (n10 != 0) {
                                object2 = httpLoggingInterceptor.d;
                                object3 = ((m)object3).Y((Charset)object11);
                                object2.log((String)object3);
                                object3 = httpLoggingInterceptor.d;
                                object11 = new StringBuilder();
                                ((StringBuilder)object11).append((String)object4);
                                object4 = ((a0)object8).m();
                                ((StringBuilder)object11).append((String)object4);
                                ((StringBuilder)object11).append((String)charSequence3);
                                l11 = ((b0)object5).contentLength();
                                ((StringBuilder)object11).append(l11);
                                ((StringBuilder)object11).append((String)charSequence4);
                                object4 = ((StringBuilder)object11).toString();
                                object3.log((String)object4);
                            } else {
                                object3 = httpLoggingInterceptor.d;
                                object11 = new StringBuilder();
                                ((StringBuilder)object11).append((String)object4);
                                object4 = ((a0)object8).m();
                                ((StringBuilder)object11).append((String)object4);
                                ((StringBuilder)object11).append(" (binary ");
                                l11 = ((b0)object5).contentLength();
                                ((StringBuilder)object11).append(l11);
                                ((StringBuilder)object11).append((String)object10);
                                object4 = ((StringBuilder)object11).toString();
                                object3.log((String)object4);
                            }
                        }
                    }
                }
            } else {
                object3 = httpLoggingInterceptor.d;
                object5 = new StringBuilder();
                ((StringBuilder)object5).append((String)object4);
                object4 = ((a0)object8).m();
                ((StringBuilder)object5).append((String)object4);
                object4 = ((StringBuilder)object5).toString();
                object3.log((String)object4);
            }
        }
        long l13 = System.nanoTime();
        try {
            object6 = object6.c((a0)object8);
            object8 = TimeUnit.NANOSECONDS;
        }
        catch (Exception exception) {
            object6 = httpLoggingInterceptor.d;
            object8 = new StringBuilder();
            ((StringBuilder)object8).append("<-- HTTP FAILED: ");
            ((StringBuilder)object8).append(exception);
            object8 = ((StringBuilder)object8).toString();
            object6.log((String)object8);
            throw exception;
        }
        l11 = System.nanoTime() - l13;
        l13 = ((TimeUnit)((Object)object8)).toMillis(l11);
        object8 = ((c0)object6).r0();
        f0.m(object8);
        l11 = ((d0)object8).contentLength();
        l10 = -1;
        long l14 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (l14 != false) {
            object5 = new StringBuilder();
            ((StringBuilder)object5).append(l11);
            object11 = "-byte";
            ((StringBuilder)object5).append((String)object11);
            object5 = ((StringBuilder)object5).toString();
        } else {
            object5 = "unknown-length";
        }
        object11 = httpLoggingInterceptor.d;
        CharSequence charSequence5 = charSequence4;
        charSequence4 = new StringBuilder();
        long l15 = l11;
        ((StringBuilder)charSequence4).append("<-- ");
        n10 = ((c0)object6).v0();
        ((StringBuilder)charSequence4).append(n10);
        object2 = ((c0)object6).E0();
        n10 = object2.length();
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            object = object10;
            object10 = object12;
            c10 = ' ';
        } else {
            object2 = ((c0)object6).E0();
            charSequence = new StringBuilder();
            object = object10;
            c10 = ' ';
            object10 = String.valueOf(c10);
            ((StringBuilder)charSequence).append((String)object10);
            ((StringBuilder)charSequence).append((String)object2);
            object10 = ((StringBuilder)charSequence).toString();
        }
        ((StringBuilder)charSequence4).append((String)object10);
        ((StringBuilder)charSequence4).append(c10);
        object10 = ((c0)object6).L0().q();
        ((StringBuilder)charSequence4).append(object10);
        ((StringBuilder)charSequence4).append((String)charSequence3);
        ((StringBuilder)charSequence4).append(l13);
        object4 = "ms";
        ((StringBuilder)charSequence4).append((String)object4);
        if (!bl2) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append(", ");
            ((StringBuilder)object4).append((String)object5);
            object3 = " body";
            ((StringBuilder)object4).append((String)object3);
            object4 = ((StringBuilder)object4).toString();
        } else {
            object4 = object12;
        }
        ((StringBuilder)charSequence4).append((String)object4);
        int n13 = 41;
        ((StringBuilder)charSequence4).append((char)n13);
        object4 = ((StringBuilder)charSequence4).toString();
        object11.log((String)object4);
        if (bl2) {
            object7 = ((c0)object6).C0();
            n13 = ((s)object7).size();
            object3 = null;
            for (n11 = 0; n11 < n13; n11 += 1) {
                httpLoggingInterceptor.e((s)object7, n11);
            }
            if (bl3 && (bl3 = e.c((c0)object6))) {
                object9 = ((c0)object6).C0();
                bl3 = httpLoggingInterceptor.b((s)object9);
                if (bl3) {
                    object7 = httpLoggingInterceptor.d;
                    object8 = "<-- END HTTP (encoded body omitted)";
                    object7.log((String)object8);
                } else {
                    long l16;
                    object9 = ((d0)object8).source();
                    l13 = Long.MAX_VALUE;
                    object9.request(l13);
                    object9 = object9.getBuffer();
                    object7 = ((s)object7).e("Content-Encoding");
                    n11 = 1;
                    bl2 = u.I1("gzip", (String)object7, n11 != 0);
                    n13 = 0;
                    object4 = null;
                    if (bl2) {
                        l16 = ((m)object9).S0();
                        object7 = l16;
                        object9 = ((m)object9).E();
                        object3 = new h.u((m0)object9);
                        try {
                            object9 = new m();
                        }
                        catch (Throwable throwable) {
                            object7 = throwable;
                            try {
                                throw throwable;
                            }
                            catch (Throwable throwable2) {
                                object8 = throwable2;
                                f.e2.b.a((Closeable)object3, (Throwable)object7);
                                throw throwable2;
                            }
                        }
                        ((m)object9).v((m0)object3);
                        f.e2.b.a((Closeable)object3, null);
                        object4 = object7;
                    }
                    if ((object7 = ((d0)object8).contentType()) == null || (object7 = ((v)object7).f((Charset)(object8 = StandardCharsets.UTF_8))) == null) {
                        object7 = StandardCharsets.UTF_8;
                        f0.o(object7, (String)charSequence2);
                    }
                    Object object13 = g.i0.b.a((m)object9);
                    if (!object13) {
                        httpLoggingInterceptor.d.log((String)object12);
                        object7 = httpLoggingInterceptor.d;
                        object8 = new StringBuilder();
                        ((StringBuilder)object8).append("<-- END HTTP (binary ");
                        long l17 = ((m)object9).S0();
                        ((StringBuilder)object8).append(l17);
                        object9 = object;
                        ((StringBuilder)object8).append((String)object);
                        object8 = ((StringBuilder)object8).toString();
                        object7.log((String)object8);
                        return object6;
                    }
                    l16 = 0L;
                    long l18 = l15 - l16;
                    object13 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                    if (object13) {
                        httpLoggingInterceptor.d.log((String)object12);
                        object8 = httpLoggingInterceptor.d;
                        object3 = ((m)object9).E();
                        object7 = ((m)object3).Y((Charset)object7);
                        object8.log((String)object7);
                    }
                    object7 = "<-- END HTTP (";
                    if (object4 != null) {
                        object8 = httpLoggingInterceptor.d;
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append((String)object7);
                        long l19 = ((m)object9).S0();
                        ((StringBuilder)object3).append(l19);
                        ((StringBuilder)object3).append("-byte, ");
                        ((StringBuilder)object3).append(object4);
                        ((StringBuilder)object3).append("-gzipped-byte body)");
                        object7 = ((StringBuilder)object3).toString();
                        object8.log((String)object7);
                    } else {
                        object8 = httpLoggingInterceptor.d;
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append((String)object7);
                        l16 = ((m)object9).S0();
                        ((StringBuilder)object4).append(l16);
                        object7 = charSequence5;
                        ((StringBuilder)object4).append((String)charSequence5);
                        object7 = ((StringBuilder)object4).toString();
                        object8.log((String)object7);
                    }
                }
            } else {
                object7 = httpLoggingInterceptor.d;
                object8 = "<-- END HTTP";
                object7.log((String)object8);
            }
        }
        return object6;
    }
}

