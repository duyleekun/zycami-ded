/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.e2.b;
import f.h2.t.f0;
import f.q1;
import f.q2.u;
import g.h0.h.a;
import g.h0.h.c;
import g.h0.h.d;
import g.h0.n.h;
import g.h0.n.h$a;
import h.k0;
import h.n;
import h.z;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.cache.DiskLruCache$a;
import okhttp3.internal.cache.DiskLruCache$b;
import okhttp3.internal.cache.DiskLruCache$c;
import okhttp3.internal.cache.DiskLruCache$d;
import okhttp3.internal.cache.DiskLruCache$e;
import okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1;

public final class DiskLruCache
implements Closeable,
Flushable {
    public static final long A;
    public static final Regex B;
    public static final String C;
    public static final String D;
    public static final String E;
    public static final String F;
    public static final DiskLruCache$a G;
    public static final String v;
    public static final String w;
    public static final String x;
    public static final String y;
    public static final String z;
    private long a;
    private final File b;
    private final File c;
    private final File d;
    private long e;
    private n f;
    private final LinkedHashMap g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private long o;
    private final c p;
    private final DiskLruCache$d q;
    private final g.h0.m.a r;
    private final File s;
    private final int t;
    private final int u;

    static {
        Object object = new DiskLruCache$a(null);
        G = object;
        v = "journal";
        w = "journal.tmp";
        x = "journal.bkp";
        y = "libcore.io.DiskLruCache";
        z = "1";
        A = -1;
        B = object = new Regex("[a-z0-9_-]{1,120}");
        C = "CLEAN";
        D = "DIRTY";
        E = "REMOVE";
        F = "READ";
    }

    public DiskLruCache(g.h0.m.a object, File object2, int n10, int n11, long l10, d object3) {
        f0.p(object, "fileSystem");
        f0.p(object2, "directory");
        f0.p(object3, "taskRunner");
        this.r = object;
        this.s = object2;
        this.t = n10;
        this.u = n11;
        this.a = l10;
        n10 = 0;
        String string2 = null;
        float f10 = 0.75f;
        int n12 = 1;
        object = new LinkedHashMap(0, f10, n12 != 0);
        this.g = object;
        this.p = object = ((d)object3).j();
        object3 = new StringBuilder();
        String string3 = g.h0.d.i;
        ((StringBuilder)object3).append(string3);
        string3 = " Cache";
        ((StringBuilder)object3).append(string3);
        object3 = ((StringBuilder)object3).toString();
        this.q = object = new DiskLruCache$d(this, (String)object3);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            l12 = n12;
        } else {
            l12 = 0;
            object = null;
        }
        if (l12 != false) {
            if (n11 > 0) {
                n10 = n12;
            }
            if (n10 != 0) {
                string2 = v;
                this.b = object = new File((File)object2, string2);
                string2 = w;
                this.c = object = new File((File)object2, string2);
                string2 = x;
                this.d = object = new File((File)object2, string2);
                return;
            }
            object2 = "valueCount <= 0".toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object2 = "maxSize <= 0".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static final /* synthetic */ n B(DiskLruCache diskLruCache) {
        return diskLruCache.f;
    }

    public static final /* synthetic */ boolean C(DiskLruCache diskLruCache) {
        return diskLruCache.n;
    }

    public static final /* synthetic */ boolean D(DiskLruCache diskLruCache) {
        return diskLruCache.m;
    }

    public static final /* synthetic */ int E(DiskLruCache diskLruCache) {
        return diskLruCache.h;
    }

    private final boolean I0() {
        LinkedHashMap linkedHashMap;
        int n10 = this.h;
        int n11 = 2000;
        n10 = n10 >= n11 && n10 >= (n11 = (linkedHashMap = this.g).size()) ? 1 : 0;
        return n10 != 0;
    }

    private final n J0() {
        Object object = this.r;
        Object object2 = this.b;
        object = object.c((File)object2);
        DiskLruCache$newJournalWriter$faultHidingSink$1 diskLruCache$newJournalWriter$faultHidingSink$1 = new DiskLruCache$newJournalWriter$faultHidingSink$1(this);
        object2 = new g.h0.f.d((k0)object, diskLruCache$newJournalWriter$faultHidingSink$1);
        return h.z.c((k0)object2);
    }

    private final void K0() {
        boolean bl2;
        Object object = this.r;
        Object object2 = this.c;
        object.h((File)object2);
        object = this.g.values().iterator();
        while (bl2 = object.hasNext()) {
            int n10;
            int n11;
            object2 = object.next();
            f0.o(object2, "i.next()");
            object2 = (DiskLruCache$b)object2;
            DiskLruCache$Editor diskLruCache$Editor = ((DiskLruCache$b)object2).b();
            if (diskLruCache$Editor == null) {
                n11 = this.u;
                for (n10 = 0; n10 < n11; ++n10) {
                    long l10 = this.e;
                    long[] lArray = ((DiskLruCache$b)object2).e();
                    long l11 = lArray[n10];
                    this.e = l10 += l11;
                }
                continue;
            }
            diskLruCache$Editor = null;
            ((DiskLruCache$b)object2).l(null);
            n11 = this.u;
            while (n10 < n11) {
                g.h0.m.a a10 = this.r;
                File file = (File)((DiskLruCache$b)object2).a().get(n10);
                a10.h(file);
                a10 = this.r;
                file = (File)((DiskLruCache$b)object2).c().get(n10);
                a10.h(file);
                ++n10;
            }
            object.remove();
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void L0() {
        block42: {
            var1_1 = ", ";
            var2_3 = this.r;
            var3_4 = this.b;
            var2_3 = h.z.d(var2_3.e((File)var3_4));
            var3_4 = var2_3.w();
            var4_6 = var2_3.w();
            var5_7 = var2_3.w();
            var6_8 = var2_3.w();
            var7_9 = var2_3.w();
            var8_10 = DiskLruCache.y;
            var9_11 = f0.g(var8_10, var3_4);
            var10_12 = 1;
            if ((var9_11 ^= var10_12) != 0) break block42;
            var8_10 = DiskLruCache.z;
            var9_11 = f0.g(var8_10, var4_6) ^ var10_12;
            if (var9_11 != 0) break block42;
            var9_11 = this.t;
            var8_10 = String.valueOf(var9_11);
            var11_13 = f0.g(var8_10, var5_7) ^ var10_12;
            if (var11_13 != 0) break block42;
            var11_13 = this.u;
            var5_7 = String.valueOf(var11_13);
            var11_13 = f0.g(var5_7, var6_8) ^ var10_12;
            if (var11_13 != 0) break block42;
            var11_13 = var7_9.length();
            var9_11 = 0;
            var8_10 = null;
            if (var11_13 <= 0) {
                var10_12 = 0;
                var12_14 = null;
            }
            if (var10_12 != 0) break block42;
            while (true) {
                var1_1 = var2_3.w();
                this.M0((String)var1_1);
                ++var9_11;
                continue;
                break;
            }
            catch (EOFException v0) {
                var1_1 = this.g;
                var13_15 = var1_1.size();
                var9_11 -= var13_15;
                this.h = var9_11;
                var13_15 = (int)var2_3.V();
                if (var13_15 != 0) ** GOTO lbl68
                this.N0();
                ** GOTO lbl71
lbl68:
                // 1 sources

                var1_1 = this.J0();
                this.f = var1_1;
lbl71:
                // 2 sources

                var1_1 = q1.a;
                f.e2.b.a((Closeable)var2_3, null);
                return;
            }
        }
        var8_10 = new StringBuilder();
        var12_14 = "unexpected journal header: [";
        {
            catch (Throwable var1_2) {
                try {
                    throw var1_2;
                }
                catch (Throwable var3_5) {
                    f.e2.b.a((Closeable)var2_3, var1_2);
                    throw var3_5;
                }
            }
        }
        var8_10.append(var12_14);
        var8_10.append((String)var3_4);
        var8_10.append((String)var1_1);
        var8_10.append(var4_6);
        var8_10.append((String)var1_1);
        var8_10.append(var6_8);
        var8_10.append((String)var1_1);
        var8_10.append(var7_9);
        var13_16 = ']';
        var8_10.append(var13_16);
        var1_1 = var8_10.toString();
        var5_7 = new IOException((String)var1_1);
        throw var5_7;
    }

    private final void M0(String string2) {
        String string3;
        Object object;
        block8: {
            CharSequence charSequence;
            String string4;
            block12: {
                block10: {
                    int n10;
                    int n11;
                    int n12;
                    int n13;
                    int n14;
                    block11: {
                        Object object2;
                        int n15;
                        DiskLruCache diskLruCache;
                        block9: {
                            Object object3;
                            int n16;
                            String string5;
                            diskLruCache = this;
                            string4 = string2;
                            n14 = 32;
                            n15 = 0;
                            String string6 = null;
                            n13 = 0;
                            int n17 = 6;
                            object = string2;
                            n12 = StringsKt__StringsKt.i3(string2, (char)n14, 0, false, n17, null);
                            string3 = "unexpected journal line: ";
                            n11 = -1;
                            if (n12 == n11) break block8;
                            int n18 = n12 + 1;
                            n14 = 32;
                            n15 = n18;
                            n10 = StringsKt__StringsKt.i3(string2, (char)n14, n18, false, 4, null);
                            charSequence = "(this as java.lang.String).substring(startIndex)";
                            string6 = "null cannot be cast to non-null type java.lang.String";
                            n13 = 2;
                            n17 = 0;
                            if (n10 == n11) {
                                boolean bl2;
                                Objects.requireNonNull(string2, string6);
                                string5 = string2.substring(n18);
                                f0.o(string5, (String)charSequence);
                                object2 = E;
                                n16 = ((String)object2).length();
                                if (n12 == n16 && (bl2 = f.q2.u.q2(string2, (String)object2, false, n13, null))) {
                                    this.g.remove(string5);
                                    return;
                                }
                            } else {
                                Objects.requireNonNull(string2, string6);
                                string5 = string2.substring(n18, n10);
                                object2 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                                f0.o(string5, (String)object2);
                            }
                            if ((object2 = (DiskLruCache$b)diskLruCache.g.get(string5)) == null) {
                                object2 = new DiskLruCache$b(diskLruCache, string5);
                                object3 = diskLruCache.g;
                                object3.put(string5, object2);
                            }
                            if (n10 == n11 || n12 != (n16 = (string5 = C).length()) || (n18 = (int)(f.q2.u.q2(string4, string5, false, n13, null) ? 1 : 0)) == 0) break block9;
                            n13 = 1;
                            Objects.requireNonNull(string4, string6);
                            object3 = string4.substring(n10 += n13);
                            f0.o(object3, (String)charSequence);
                            char[] cArray = new char[n13];
                            cArray[0] = n10 = 32;
                            int n19 = 6;
                            object = StringsKt__StringsKt.H4((CharSequence)object3, cArray, false, 0, n19, null);
                            ((DiskLruCache$b)object2).o(n13 != 0);
                            ((DiskLruCache$b)object2).l(null);
                            ((DiskLruCache$b)object2).m((List)object);
                            break block10;
                        }
                        if (n10 != n11 || n12 != (n15 = ((String)(charSequence = D)).length()) || (n14 = (int)(f.q2.u.q2(string4, (String)charSequence, false, n13, null) ? 1 : 0)) == 0) break block11;
                        object = new DiskLruCache$Editor(diskLruCache, (DiskLruCache$b)object2);
                        ((DiskLruCache$b)object2).l((DiskLruCache$Editor)object);
                        break block10;
                    }
                    if (n10 != n11 || n12 != (n14 = ((String)(object = F)).length()) || (n10 = (int)(f.q2.u.q2(string4, (String)object, false, n13, null) ? 1 : 0)) == 0) break block12;
                }
                return;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            object = new IOException((String)charSequence);
            throw object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new IOException((String)charSequence);
        throw object;
    }

    public static final /* synthetic */ boolean O(DiskLruCache diskLruCache) {
        return diskLruCache.I0();
    }

    private final boolean Q0() {
        boolean bl2;
        Iterator iterator2 = this.g.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            DiskLruCache$b diskLruCache$b = (DiskLruCache$b)iterator2.next();
            boolean bl3 = diskLruCache$b.i();
            if (bl3) continue;
            f0.o(diskLruCache$b, "toEvict");
            this.P0(diskLruCache$b);
            return true;
        }
        return false;
    }

    public static final /* synthetic */ void S(DiskLruCache diskLruCache, boolean bl2) {
        diskLruCache.j = bl2;
    }

    private final void W0(String string2) {
        Serializable serializable = B;
        boolean bl2 = ((Regex)serializable).matches(string2);
        if (bl2) {
            return;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("keys must match regex [a-z0-9_-]{1,120}: \"");
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append('\"');
        string2 = ((StringBuilder)serializable).toString();
        string2 = string2.toString();
        serializable = new IllegalArgumentException(string2);
        throw serializable;
    }

    public static final /* synthetic */ boolean a(DiskLruCache diskLruCache) {
        return diskLruCache.j;
    }

    public static final /* synthetic */ boolean h(DiskLruCache diskLruCache) {
        return diskLruCache.i;
    }

    public static final /* synthetic */ void n0(DiskLruCache diskLruCache, boolean bl2) {
        diskLruCache.i = bl2;
    }

    public static final /* synthetic */ void o0(DiskLruCache diskLruCache, boolean bl2) {
        diskLruCache.k = bl2;
    }

    public static final /* synthetic */ void p0(DiskLruCache diskLruCache, n n10) {
        diskLruCache.f = n10;
    }

    public static final /* synthetic */ boolean q(DiskLruCache diskLruCache) {
        return diskLruCache.k;
    }

    public static final /* synthetic */ void q0(DiskLruCache diskLruCache, boolean bl2) {
        diskLruCache.n = bl2;
    }

    public static final /* synthetic */ void r0(DiskLruCache diskLruCache, boolean bl2) {
        diskLruCache.m = bl2;
    }

    public static final /* synthetic */ void s0(DiskLruCache diskLruCache, int n10) {
        diskLruCache.h = n10;
    }

    private final void t0() {
        synchronized (this) {
            block6: {
                boolean bl2 = this.l ^ true;
                if (!bl2) break block6;
                return;
            }
            String string2 = "cache is closed";
            string2 = string2.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
    }

    public static /* synthetic */ DiskLruCache$Editor y0(DiskLruCache diskLruCache, String string2, long l10, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            l10 = A;
        }
        return diskLruCache.x0(string2, l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final DiskLruCache$c A0(String object) {
        synchronized (this) {
            Object object2 = "key";
            f0.p(object, (String)object2);
            this.H0();
            this.t0();
            this.W0((String)object);
            object2 = this.g;
            object2 = ((LinkedHashMap)object2).get(object);
            object2 = (DiskLruCache$b)object2;
            int n10 = 0;
            Object object3 = null;
            if (object2 == null) return null;
            Object object4 = "lruEntries[key] ?: return null";
            f0.o(object2, (String)object4);
            object2 = ((DiskLruCache$b)object2).r();
            if (object2 == null) {
                return null;
            }
            this.h = n10 = this.h + 1;
            object3 = this.f;
            f0.m(object3);
            object4 = F;
            object3 = object3.r((String)object4);
            int n11 = 32;
            object3 = object3.writeByte(n11);
            object = object3.r((String)object);
            n10 = 10;
            object.writeByte(n10);
            boolean bl2 = this.I0();
            if (bl2) {
                object3 = this.p;
                object4 = this.q;
                long l10 = 0L;
                int n12 = 2;
                g.h0.h.c.p((c)object3, (a)object4, l10, n12, null);
            }
            return object2;
        }
    }

    public final boolean B0() {
        return this.l;
    }

    public final File C0() {
        return this.s;
    }

    public final g.h0.m.a D0() {
        return this.r;
    }

    public final LinkedHashMap E0() {
        return this.g;
    }

    public final long F0() {
        synchronized (this) {
            long l10 = this.a;
            return l10;
        }
    }

    public final int G0() {
        return this.u;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void H0() {
        synchronized (this) {
            Object object;
            boolean bl2 = g.h0.d.h;
            if (bl2 && !(bl2 = Thread.holdsLock(this))) {
                CharSequence charSequence = new StringBuilder();
                Object object2 = "Thread ";
                charSequence.append((String)object2);
                object2 = Thread.currentThread();
                String string2 = "Thread.currentThread()";
                f0.o(object2, string2);
                object2 = ((Thread)object2).getName();
                charSequence.append((String)object2);
                object2 = " MUST hold lock on ";
                charSequence.append((String)object2);
                charSequence.append(this);
                charSequence = charSequence.toString();
                AssertionError assertionError = new AssertionError(charSequence);
                throw assertionError;
            }
            bl2 = this.k;
            if (bl2) {
                return;
            }
            g.h0.m.a a10 = this.r;
            File file = this.d;
            bl2 = a10.b(file);
            if (bl2) {
                a10 = this.r;
                file = this.b;
                bl2 = a10.b(file);
                if (bl2) {
                    a10 = this.r;
                    file = this.d;
                    a10.h(file);
                } else {
                    a10 = this.r;
                    file = this.d;
                    object = this.b;
                    a10.g(file, (File)object);
                }
            }
            a10 = this.r;
            file = this.d;
            this.j = bl2 = g.h0.d.J(a10, file);
            a10 = this.r;
            file = this.b;
            bl2 = a10.b(file);
            boolean bl3 = true;
            if (bl2) {
                try {
                    this.L0();
                    this.K0();
                    this.k = bl3;
                    return;
                }
                catch (IOException iOException) {
                    object = g.h0.n.h.e;
                    object = ((h$a)object).g();
                    CharSequence charSequence = new StringBuilder();
                    Object object3 = "DiskLruCache ";
                    charSequence.append((String)object3);
                    object3 = this.s;
                    charSequence.append(object3);
                    object3 = " is corrupt: ";
                    charSequence.append((String)object3);
                    object3 = iOException.getMessage();
                    charSequence.append((String)object3);
                    object3 = ", removing";
                    charSequence.append((String)object3);
                    charSequence = charSequence.toString();
                    int n10 = 5;
                    ((h)object).m((String)charSequence, n10, iOException);
                    bl2 = false;
                    Object var2_5 = null;
                    try {
                        this.v0();
                    }
                    finally {
                        this.l = false;
                    }
                }
            }
            this.N0();
            this.k = bl3;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void N0() {
        synchronized (this) {
            Object object;
            Object object2 = this.f;
            if (object2 != null) {
                object2.close();
            }
            object2 = this.r;
            File file = this.c;
            object2 = object2.f(file);
            object2 = h.z.c((k0)object2);
            file = null;
            try {
                boolean bl2;
                object = y;
                object = object2.r((String)object);
                int n10 = 10;
                object.writeByte(n10);
                object = z;
                object = object2.r((String)object);
                object.writeByte(n10);
                int n11 = this.t;
                long l10 = n11;
                object = object2.M(l10);
                object.writeByte(n10);
                n11 = this.u;
                l10 = n11;
                object = object2.M(l10);
                object.writeByte(n10);
                object2.writeByte(n10);
                object = this.g;
                object = ((LinkedHashMap)object).values();
                object = object.iterator();
                while (bl2 = object.hasNext()) {
                    Object object3 = object.next();
                    object3 = (DiskLruCache$b)object3;
                    Object object4 = ((DiskLruCache$b)object3).b();
                    int n12 = 32;
                    if (object4 != null) {
                        object4 = D;
                        object4 = object2.r((String)object4);
                        object4.writeByte(n12);
                        object3 = ((DiskLruCache$b)object3).d();
                        object2.r((String)object3);
                        object2.writeByte(n10);
                        continue;
                    }
                    object4 = C;
                    object4 = object2.r((String)object4);
                    object4.writeByte(n12);
                    object4 = ((DiskLruCache$b)object3).d();
                    object2.r((String)object4);
                    ((DiskLruCache$b)object3).s((n)object2);
                    object2.writeByte(n10);
                }
                object = q1.a;
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    f.e2.b.a((Closeable)object2, throwable);
                    throw throwable2;
                }
            }
            f.e2.b.a((Closeable)object2, null);
            object2 = this.r;
            file = this.b;
            boolean bl3 = object2.b(file);
            if (bl3) {
                object2 = this.r;
                file = this.b;
                object = this.d;
                object2.g(file, (File)object);
            }
            object2 = this.r;
            file = this.c;
            object = this.b;
            object2.g(file, (File)object);
            object2 = this.r;
            file = this.d;
            object2.h(file);
            this.f = object2 = this.J0();
            bl3 = false;
            object2 = null;
            this.i = false;
            this.n = false;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean O0(String object) {
        synchronized (this) {
            long l10;
            long l11;
            long l12;
            long l13;
            Object object2 = "key";
            f0.p(object, (String)object2);
            this.H0();
            this.t0();
            this.W0((String)object);
            object2 = this.g;
            object = ((LinkedHashMap)object2).get(object);
            object = (DiskLruCache$b)object;
            object2 = null;
            if (object == null) return false;
            String string2 = "lruEntries[key] ?: return false";
            f0.o(object, string2);
            boolean bl2 = this.P0((DiskLruCache$b)object);
            if (bl2 && (l13 = (l12 = (l11 = this.e) - (l10 = this.a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
                this.m = false;
            }
            return bl2;
        }
    }

    public final boolean P0(DiskLruCache$b object) {
        long l10;
        Object object2;
        Object object3;
        Object object4 = "entry";
        f0.p(object, (String)object4);
        int n10 = this.j;
        int n11 = 10;
        int n12 = 32;
        int n13 = 1;
        if (n10 == 0) {
            n10 = ((DiskLruCache$b)object).f();
            if (n10 > 0 && (object4 = this.f) != null) {
                object3 = D;
                object4.r((String)object3);
                object4.writeByte(n12);
                object3 = ((DiskLruCache$b)object).d();
                object4.r((String)object3);
                object4.writeByte(n11);
                object4.flush();
            }
            if ((n10 = ((DiskLruCache$b)object).f()) > 0 || (object4 = ((DiskLruCache$b)object).b()) != null) {
                ((DiskLruCache$b)object).q(n13 != 0);
                return n13 != 0;
            }
        }
        if ((object4 = ((DiskLruCache$b)object).b()) != null) {
            ((DiskLruCache$Editor)object4).c();
        }
        object4 = null;
        int n14 = this.u;
        for (n10 = 0; n10 < n14; ++n10) {
            object2 = this.r;
            File file = (File)((DiskLruCache$b)object).a().get(n10);
            object2.h(file);
            long l11 = this.e;
            long[] lArray = ((DiskLruCache$b)object).e();
            long l12 = lArray[n10];
            this.e = l11 -= l12;
            object2 = ((DiskLruCache$b)object).e();
            l10 = 0L;
            object2[n10] = l10;
        }
        this.h = n10 = this.h + n13;
        object4 = this.f;
        if (object4 != null) {
            object3 = E;
            object4.r((String)object3);
            object4.writeByte(n12);
            String string2 = ((DiskLruCache$b)object).d();
            object4.r(string2);
            object4.writeByte(n11);
        }
        object4 = this.g;
        object = ((DiskLruCache$b)object).d();
        ((HashMap)object4).remove(object);
        boolean bl2 = this.I0();
        if (bl2) {
            object3 = this.p;
            object2 = this.q;
            l10 = 0L;
            int n15 = 2;
            g.h0.h.c.p((c)object3, (a)object2, l10, n15, null);
        }
        return n13 != 0;
    }

    public final void R0(boolean bl2) {
        this.l = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void S0(long l10) {
        synchronized (this) {
            this.a = l10;
            boolean bl2 = this.k;
            if (bl2) {
                c c10 = this.p;
                DiskLruCache$d diskLruCache$d = this.q;
                long l11 = 0L;
                int n10 = 2;
                g.h0.h.c.p(c10, diskLruCache$d, l11, n10, null);
            }
            return;
        }
    }

    public final long T0() {
        synchronized (this) {
            this.H0();
            long l10 = this.e;
            return l10;
        }
    }

    public final Iterator U0() {
        synchronized (this) {
            this.H0();
            DiskLruCache$e diskLruCache$e = new DiskLruCache$e(this);
            return diskLruCache$e;
        }
    }

    public final void V0() {
        long l10;
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = (l11 = this.e) - (l10 = this.a)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            l13 = (long)this.Q0();
            if (l13 != false) continue;
            return;
        }
        this.m = false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        synchronized (this) {
            boolean bl2 = this.k;
            boolean bl3 = true;
            if (bl2 && !(bl2 = this.l)) {
                Object object = this.g;
                object = ((LinkedHashMap)object).values();
                String string2 = "lruEntries.values";
                f0.o(object, string2);
                int n10 = 0;
                string2 = null;
                DiskLruCache$b[] diskLruCache$bArray = new DiskLruCache$b[]{};
                object = object.toArray(diskLruCache$bArray);
                if (object == null) {
                    String string3 = "null cannot be cast to non-null type kotlin.Array<T>";
                    object = new NullPointerException(string3);
                    throw object;
                }
                int n11 = ((DiskLruCache$b[])object).length;
                while (true) {
                    if (n10 >= n11) {
                        this.V0();
                        object = this.f;
                        f0.m(object);
                        object.close();
                        bl2 = false;
                        object = null;
                        this.f = null;
                        this.l = bl3;
                        return;
                    }
                    Object object2 = object[n10];
                    DiskLruCache$Editor diskLruCache$Editor = ((DiskLruCache$b)object2).b();
                    if (diskLruCache$Editor != null && (object2 = ((DiskLruCache$b)object2).b()) != null) {
                        ((DiskLruCache$Editor)object2).c();
                    }
                    ++n10;
                }
            }
            this.l = bl3;
            return;
        }
    }

    public void flush() {
        synchronized (this) {
            block5: {
                boolean bl2 = this.k;
                if (bl2) break block5;
                return;
            }
            this.t0();
            this.V0();
            n n10 = this.f;
            f0.m(n10);
            n10.flush();
            return;
        }
    }

    public final boolean isClosed() {
        synchronized (this) {
            boolean bl2 = this.l;
            return bl2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void u0(DiskLruCache$Editor object, boolean bl2) {
        synchronized (this) {
            long l10;
            Object object2;
            int n10;
            Object object3;
            int n11;
            Object object4;
            int n12;
            void var2_2;
            Object object5 = "editor";
            f0.p(object, (String)object5);
            object5 = ((DiskLruCache$Editor)object).d();
            Object object6 = ((DiskLruCache$b)object5).b();
            int n13 = f0.g(object6, object);
            if (n13 == 0) {
                object = "Check failed.";
                object = object.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
            n13 = 0;
            object6 = null;
            if (var2_2 != false && (n12 = ((DiskLruCache$b)object5).g()) == 0) {
                n12 = this.u;
                object4 = null;
                for (n11 = 0; n11 < n12; ++n11) {
                    object3 = ((DiskLruCache$Editor)object).e();
                    f0.m(object3);
                    n10 = object3[n11];
                    if (n10 == 0) {
                        ((DiskLruCache$Editor)object).a();
                        CharSequence charSequence = new StringBuilder();
                        object5 = "Newly created entry didn't create value for index ";
                        charSequence.append((String)object5);
                        charSequence.append(n11);
                        charSequence = charSequence.toString();
                        object = new IllegalStateException((String)charSequence);
                        throw object;
                    }
                    object3 = this.r;
                    object2 = ((DiskLruCache$b)object5).c();
                    object2 = object2.get(n11);
                    n10 = (int)(object3.b((File)(object2 = (File)object2)) ? 1 : 0);
                    if (n10 != 0) continue;
                    ((DiskLruCache$Editor)object).a();
                    return;
                }
            }
            int n14 = this.u;
            while (n13 < n14) {
                Object object7 = ((DiskLruCache$b)object5).c();
                object7 = object7.get(n13);
                object7 = (File)object7;
                if (var2_2 != false && (n11 = (int)(((DiskLruCache$b)object5).i() ? 1 : 0)) == 0) {
                    object4 = this.r;
                    n11 = (int)(object4.b((File)object7) ? 1 : 0);
                    if (n11 != 0) {
                        long l11;
                        object4 = ((DiskLruCache$b)object5).a();
                        object4 = object4.get(n13);
                        object4 = (File)object4;
                        object3 = this.r;
                        object3.g((File)object7, (File)object4);
                        object7 = ((DiskLruCache$b)object5).e();
                        Object object8 = object7[n13];
                        object7 = this.r;
                        l10 = object7.d((File)object4);
                        long[] lArray = ((DiskLruCache$b)object5).e();
                        lArray[n13] = l10;
                        this.e = l11 = this.e - object8 + l10;
                    }
                } else {
                    object4 = this.r;
                    object4.h((File)object7);
                }
                ++n13;
            }
            n14 = 0;
            object = null;
            ((DiskLruCache$b)object5).l(null);
            n14 = (int)(((DiskLruCache$b)object5).i() ? 1 : 0);
            if (n14 != 0) {
                this.P0((DiskLruCache$b)object5);
                return;
            }
            n14 = this.h;
            n13 = 1;
            this.h = n14 += n13;
            object = this.f;
            f0.m(object);
            n12 = (int)(((DiskLruCache$b)object5).g() ? 1 : 0);
            n11 = 10;
            n10 = 32;
            if (n12 == 0 && var2_2 == false) {
                Object object9 = this.g;
                object6 = ((DiskLruCache$b)object5).d();
                ((HashMap)object9).remove(object6);
                object9 = E;
                object9 = object.r((String)object9);
                object9.writeByte(n10);
                object9 = ((DiskLruCache$b)object5).d();
                object.r((String)object9);
                object.writeByte(n11);
            } else {
                ((DiskLruCache$b)object5).o(n13 != 0);
                object6 = C;
                object6 = object.r((String)object6);
                object6.writeByte(n10);
                object6 = ((DiskLruCache$b)object5).d();
                object.r((String)object6);
                ((DiskLruCache$b)object5).s((n)object);
                object.writeByte(n11);
                if (var2_2 != false) {
                    long l12;
                    long l13 = this.o;
                    this.o = l12 = 1L + l13;
                    ((DiskLruCache$b)object5).p(l13);
                }
            }
            object.flush();
            long l14 = this.e;
            long l15 = this.a;
            n14 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
            if (n14 > 0 || (n14 = (int)(this.I0() ? 1 : 0)) != 0) {
                object5 = this.p;
                object6 = this.q;
                l10 = 0L;
                n10 = 2;
                object2 = null;
                g.h0.h.c.p((c)object5, (a)object6, l10, n10, null);
            }
            return;
        }
    }

    public final void v0() {
        this.close();
        g.h0.m.a a10 = this.r;
        File file = this.s;
        a10.a(file);
    }

    public final DiskLruCache$Editor w0(String string2) {
        return DiskLruCache.y0(this, string2, 0L, 2, null);
    }

    public final DiskLruCache$Editor x0(String object, long l10) {
        synchronized (this) {
            block34: {
                Object object2;
                Object object3;
                block35: {
                    int n10;
                    long l11;
                    block33: {
                        block31: {
                            block32: {
                                object3 = "key";
                                f0.p(object, (String)object3);
                                this.H0();
                                this.t0();
                                this.W0((String)object);
                                object3 = this.g;
                                object3 = ((LinkedHashMap)object3).get(object);
                                object3 = (DiskLruCache$b)object3;
                                long l12 = A;
                                l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                                if (l11 == false) break block31;
                                if (object3 == null) break block32;
                                long l13 = ((DiskLruCache$b)object3).h();
                                n10 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
                                if (n10 == 0) break block31;
                            }
                            return null;
                        }
                        if (object3 != null) {
                            object2 = ((DiskLruCache$b)object3).b();
                        } else {
                            n10 = 0;
                            object2 = null;
                        }
                        if (object2 != null) {
                            return null;
                        }
                        if (object3 != null) {
                            n10 = ((DiskLruCache$b)object3).f();
                            if (n10 == 0) break block33;
                            return null;
                        }
                    }
                    n10 = (int)(this.m ? 1 : 0);
                    if (n10 != 0) break block34;
                    n10 = (int)(this.n ? 1 : 0);
                    if (n10 != 0) break block34;
                    object2 = this.f;
                    f0.m(object2);
                    Object object4 = D;
                    object4 = object2.r((String)object4);
                    l11 = 32;
                    object4 = object4.writeByte((int)l11);
                    object4 = object4.r((String)object);
                    l11 = 10;
                    object4.writeByte((int)l11);
                    object2.flush();
                    n10 = (int)(this.i ? 1 : 0);
                    if (n10 == 0) break block35;
                    return null;
                }
                if (object3 == null) {
                    object3 = new DiskLruCache$b(this, (String)object);
                    object2 = this.g;
                    object2.put(object, object3);
                }
                object = new DiskLruCache$Editor(this, (DiskLruCache$b)object3);
                ((DiskLruCache$b)object3).l((DiskLruCache$Editor)object);
                return object;
            }
            c c10 = this.p;
            DiskLruCache$d diskLruCache$d = this.q;
            long l14 = 0L;
            int n11 = 2;
            g.h0.h.c.p(c10, diskLruCache$d, l14, n11, null);
            return null;
        }
    }

    public final void z0() {
        synchronized (this) {
            String string2;
            block15: {
                this.H0();
                LinkedHashMap linkedHashMap = this.g;
                Collection collection = linkedHashMap.values();
                string2 = "lruEntries.values";
                f0.o(collection, string2);
                string2 = null;
                DiskLruCache$b[] diskLruCache$bArray = new DiskLruCache$b[]{};
                DiskLruCache$b[] diskLruCache$bArray2 = collection.toArray(diskLruCache$bArray);
                if (diskLruCache$bArray2 == null) break block15;
                DiskLruCache$b[] diskLruCache$bArray3 = diskLruCache$bArray2;
                int n10 = diskLruCache$bArray3.length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    DiskLruCache$b diskLruCache$b = diskLruCache$bArray3[i10];
                    String string3 = "entry";
                    f0.o(diskLruCache$b, string3);
                    this.P0(diskLruCache$b);
                    continue;
                }
                this.m = false;
                return;
            }
            string2 = "null cannot be cast to non-null type kotlin.Array<T>";
            NullPointerException nullPointerException = new NullPointerException(string2);
            throw nullPointerException;
        }
    }
}

