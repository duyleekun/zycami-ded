/*
 * Decompiled with CFR 0.151.
 */
package g.h0;

import f.h2.s.l;
import f.h2.t.f0;
import f.h2.t.s0;
import f.k;
import f.x1.l0;
import f.x1.t0;
import f.x1.u;
import g.b0;
import g.b0$a;
import g.c0;
import g.d0;
import g.d0$b;
import g.h0.d$a;
import g.h0.d$b;
import g.h0.l.a;
import g.q;
import g.q$c;
import g.s;
import g.s$a;
import g.s$b;
import g.t;
import g.t$b;
import g.z;
import h.c0$a;
import h.m;
import h.m0;
import h.n;
import h.o;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okio.ByteString;
import okio.ByteString$a;

public final class d {
    public static final byte[] a;
    public static final s b;
    public static final d0 c;
    public static final b0 d;
    private static final h.c0 e;
    public static final TimeZone f;
    private static final Regex g;
    public static final boolean h = false;
    public static final String i;
    public static final String j = "okhttp/4.9.0";

    static {
        Object[] objectArray = new byte[]{};
        a = objectArray;
        Object object = s.b;
        Object object2 = new String[]{};
        b = ((s$b)object).j((String[])object2);
        object = d0.Companion;
        int n10 = 1;
        c = d0$b.l((d0$b)object, objectArray, null, n10, null);
        d = b0$a.r(b0.Companion, objectArray, null, 0, 0, 7, null);
        object = h.c0.d;
        objectArray = new ByteString[5];
        object2 = ByteString.Companion;
        ByteString byteString = ((ByteString$a)object2).i("efbbbf");
        objectArray[0] = (byte)byteString;
        byteString = ((ByteString$a)object2).i("feff");
        objectArray[n10] = (byte)byteString;
        byteString = ((ByteString$a)object2).i("fffe");
        objectArray[2] = (byte)byteString;
        byteString = ((ByteString$a)object2).i("0000ffff");
        objectArray[3] = (byte)byteString;
        object2 = ((ByteString$a)object2).i("ffff0000");
        objectArray[4] = (byte)object2;
        e = ((c0$a)object).d((ByteString[])objectArray);
        object = DesugarTimeZone.getTimeZone("GMT");
        f0.m(object);
        f = object;
        g = object = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        h = false;
        String string2 = z.class.getName();
        f0.o(string2, "OkHttpClient::class.java.name");
        i = StringsKt__StringsKt.a4(StringsKt__StringsKt.U3(string2, "okhttp3."), "Client");
    }

    public static final int A(String[] stringArray, String string2, Comparator comparator) {
        int n10;
        block4: {
            f0.p(stringArray, "$this$indexOf");
            f0.p(string2, "value");
            String string3 = "comparator";
            f0.p(comparator, string3);
            int n11 = stringArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                String string4 = stringArray[n10];
                int n12 = comparator.compare(string4, string2);
                if (n12 == 0) {
                    n12 = 1;
                } else {
                    n12 = 0;
                    string4 = null;
                }
                if (n12 == 0) {
                    continue;
                }
                break block4;
            }
            n10 = -1;
        }
        return n10;
    }

    public static final int B(String string2) {
        String string3 = "$this$indexOfControlOrNonAscii";
        f0.p(string2, string3);
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = string2.charAt(i10);
            int n12 = f0.t(n11, 31);
            if (n12 > 0 && (n11 = f0.t(n11, n12 = 127)) < 0) {
                continue;
            }
            return i10;
        }
        return -1;
    }

    public static final int C(String string2, int n10, int n11) {
        String string3 = "$this$indexOfFirstNonAsciiWhitespace";
        f0.p(string2, string3);
        while (n10 < n11) {
            int n12;
            int n13 = string2.charAt(n10);
            if (n13 != (n12 = 9) && n13 != (n12 = 10) && n13 != (n12 = 12) && n13 != (n12 = 13) && n13 != (n12 = 32)) {
                return n10;
            }
            ++n10;
        }
        return n11;
    }

    public static /* synthetic */ int D(String string2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = string2.length();
        }
        return g.h0.d.C(string2, n10, n11);
    }

    public static final int E(String string2, int n10, int n11) {
        String string3 = "$this$indexOfLastNonAsciiWhitespace";
        f0.p(string2, string3);
        if ((n11 += -1) >= n10) {
            while (true) {
                int n12;
                int n13;
                if ((n13 = string2.charAt(n11)) != (n12 = 9) && n13 != (n12 = 10) && n13 != (n12 = 12) && n13 != (n12 = 13) && n13 != (n12 = 32)) {
                    return n11 + 1;
                }
                if (n11 == n10) break;
                n11 += -1;
            }
        }
        return n10;
    }

    public static /* synthetic */ int F(String string2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = string2.length();
        }
        return g.h0.d.E(string2, n10, n11);
    }

    public static final int G(String string2, int n10) {
        String string3 = "$this$indexOfNonWhitespace";
        f0.p(string2, string3);
        int n11 = string2.length();
        while (n10 < n11) {
            int n12;
            int n13 = string2.charAt(n10);
            if (n13 != (n12 = 32) && n13 != (n12 = 9)) {
                return n10;
            }
            ++n10;
        }
        return string2.length();
    }

    public static /* synthetic */ int H(String string2, int n10, int n11, Object object) {
        if ((n11 &= 1) != 0) {
            n10 = 0;
        }
        return g.h0.d.G(string2, n10);
    }

    public static final String[] I(String[] stringArray, String[] stringArray2, Comparator comparator) {
        f0.p(stringArray, "$this$intersect");
        f0.p(stringArray2, "other");
        f0.p(comparator, "comparator");
        ArrayList<String> arrayList = new ArrayList<String>();
        block0: for (String string2 : stringArray) {
            for (String string3 : stringArray2) {
                int n10 = comparator.compare(string2, string3);
                if (n10 != 0) continue;
                arrayList.add(string2);
                continue block0;
            }
        }
        stringArray = new String[]{};
        stringArray = arrayList.toArray(stringArray);
        Objects.requireNonNull(stringArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return stringArray;
    }

    /*
     * Exception decompiling
     */
    public static final boolean J(g.h0.m.a var0, File var1_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [2 : 39->42)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final boolean K(Socket socket, o o10) {
        int n10;
        f0.p(socket, "$this$isHealthy");
        String string2 = "source";
        f0.p(o10, string2);
        int n11 = 1;
        int n12 = socket.getSoTimeout();
        try {
            socket.setSoTimeout(n11);
            n10 = o10.V() ^ n11;
        }
        catch (Throwable throwable) {
            try {
                socket.setSoTimeout(n12);
                throw throwable;
            }
            catch (IOException iOException) {
                return 0 != 0;
            }
            catch (SocketTimeoutException socketTimeoutException) {
                return n11 != 0;
            }
        }
        socket.setSoTimeout(n12);
        return n10 != 0;
    }

    public static final void L(Object object) {
        f0.p(object, "$this$notify");
        object.notify();
    }

    public static final void M(Object object) {
        f0.p(object, "$this$notifyAll");
        object.notifyAll();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final int N(char n10) {
        int n11;
        int n12 = 48;
        if (n12 <= n10 && (n11 = 57) >= n10) {
            n10 -= n12;
            return n10;
        } else {
            n12 = 102;
            n11 = 97;
            if (n11 <= n10 && n12 >= n10) {
                return n10 - n11 + 10;
            }
            n12 = 70;
            n11 = 65;
            if (n11 > n10) return -1;
            if (n12 < n10) return -1;
            return n10 - n11 + 10;
        }
    }

    public static final String O(Socket object) {
        String string2 = "$this$peerName";
        f0.p(object, string2);
        object = ((Socket)object).getRemoteSocketAddress();
        boolean bl2 = object instanceof InetSocketAddress;
        if (bl2) {
            object = ((InetSocketAddress)object).getHostName();
            string2 = "address.hostName";
            f0.o(object, string2);
        } else {
            object = object.toString();
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Charset P(o object, Charset charset) {
        f0.p(object, "$this$readBomAsCharset");
        f0.p(charset, "default");
        h.c0 c02 = e;
        int n10 = object.m0(c02);
        int n11 = -1;
        if (n10 == n11) return charset;
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n12 = 2;
                if (n10 != n12) {
                    n12 = 3;
                    if (n10 != n12) {
                        n12 = 4;
                        if (n10 == n12) {
                            object = f.q2.d.j;
                            return ((f.q2.d)object).c();
                        }
                        object = new AssertionError();
                        throw object;
                    }
                    object = f.q2.d.j;
                    return ((f.q2.d)object).b();
                }
                charset = StandardCharsets.UTF_16LE;
                object = "UTF_16LE";
                f0.o(charset, (String)object);
                return charset;
            } else {
                charset = StandardCharsets.UTF_16BE;
                object = "UTF_16BE";
                f0.o(charset, (String)object);
            }
            return charset;
        } else {
            charset = StandardCharsets.UTF_8;
            object = "UTF_8";
            f0.o(charset, (String)object);
        }
        return charset;
    }

    public static final Object Q(Object object, Class clazz, String string2) {
        boolean bl2;
        boolean bl3;
        Class<Object> clazz2 = Object.class;
        f0.p(object, "instance");
        f0.p(clazz, "fieldType");
        f0.p(string2, "fieldName");
        Object object2 = object.getClass();
        while (true) {
            Object var7_7;
            block9: {
                String string3;
                Object object3;
                bl3 = f0.g(object2, clazz2);
                bl2 = true;
                var7_7 = null;
                if (!(bl3 ^= bl2)) break;
                try {
                    object3 = ((Class)object2).getDeclaredField(string2);
                    string3 = "field";
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    object2 = ((Class)object2).getSuperclass();
                    object3 = "c.superclass";
                    f0.o(object2, (String)object3);
                    continue;
                }
                f0.o(object3, string3);
                ((Field)object3).setAccessible(bl2);
                object3 = ((Field)object3).get(object);
                bl2 = clazz.isInstance(object3);
                if (!bl2) break block9;
                var7_7 = clazz.cast(object3);
            }
            return var7_7;
        }
        object2 = "delegate";
        bl3 = f0.g(string2, object2) ^ bl2;
        if (bl3 && (object = g.h0.d.Q(object, clazz2, object2)) != null) {
            return g.h0.d.Q(object, clazz, string2);
        }
        return null;
    }

    public static final int R(o o10) {
        f0.p(o10, "$this$readMedium");
        int n10 = o10.readByte();
        int n11 = 255;
        n10 = g.h0.d.b((byte)n10, n11) << 16;
        int n12 = g.h0.d.b(o10.readByte(), n11) << 8;
        return g.h0.d.b(o10.readByte(), n11) | (n10 |= n12);
    }

    public static final int S(m m10, byte by2) {
        long l10;
        byte by3;
        f0.p(m10, "$this$skipAll");
        int n10 = 0;
        while ((by3 = m10.V()) == 0 && (by3 = m10.z0(l10 = 0L)) == by2) {
            ++n10;
            m10.readByte();
        }
        return n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final boolean T(m0 var0, int var1_1, TimeUnit var2_2) {
        block14: {
            f0.p(var0, "$this$skipAll");
            var3_3 = "timeUnit";
            f0.p((Object)var2_2, var3_3);
            var4_4 = System.nanoTime();
            var6_5 = var0.timeout();
            var7_6 = var6_5.f();
            var8_7 = 0x7FFFFFFFFFFFFFFFL;
            if (var7_6) {
                var6_5 = var0.timeout();
                var10_8 = var6_5.d() - var4_4;
            } else {
                var10_8 = var8_7;
            }
            var6_5 = var0.timeout();
            var12_9 = var1_1;
            var14_10 = var2_2.toNanos(var12_9);
            var14_10 = Math.min(var10_8, var14_10) + var4_4;
            var6_5.e(var14_10);
            try {
                var16_11 = new m();
            }
            catch (Throwable var16_12) {
                var19_14 /* !! */  = var10_8 == var8_7 ? 0 : (var10_8 < var8_7 ? -1 : 1);
                if (var19_14 /* !! */  == false) {
                    var0 = var0.timeout();
                    var0.a();
                } else {
                    var0 = var0.timeout();
                    var0.e(var4_4 += var10_8);
                }
                throw var16_12;
            }
            catch (InterruptedIOException v0) {
                var1_1 = 0;
                var16_11 = null;
                if ((var19_14 /* !! */  = var10_8 == var8_7 ? 0 : (var10_8 < var8_7 ? -1 : 1)) != false) ** continue;
                ** continue;
            }
            while (true) {
                var12_9 = 8192L;
                var12_9 = var0.read(var16_11, var12_9);
                var17_13 = -1;
                var19_14 /* !! */  = var12_9 == var17_13 ? 0 : (var12_9 < var17_13 ? -1 : 1);
                if (var19_14 /* !! */  == false) break;
                var16_11.B();
                continue;
                break;
            }
            var1_1 = 1;
            var19_14 /* !! */  = (long)(var10_8 == var8_7 ? 0 : (var10_8 < var8_7 ? -1 : 1));
            if (var19_14 /* !! */  == false) lbl-1000:
            // 2 sources

            {
                while (true) {
                    var0 = var0.timeout();
                    var0.a();
                    break block14;
                    break;
                }
            }
            while (true) {
                var0 = var0.timeout();
                var0.e(var4_4 += var10_8);
                break;
            }
        }
        return (boolean)var1_1;
    }

    public static final ThreadFactory U(String string2, boolean bl2) {
        f0.p(string2, "name");
        d$b d$b = new d$b(string2, bl2);
        return d$b;
    }

    public static final void V(String string2, f.h2.s.a a10) {
        f0.p(string2, "name");
        f0.p(a10, "block");
        Thread thread = Thread.currentThread();
        f0.o(thread, "currentThread");
        String string3 = thread.getName();
        thread.setName(string2);
        int n10 = 1;
        try {
            a10.invoke();
            return;
        }
        finally {
            f.h2.t.c0.d(n10);
            thread.setName(string3);
            f.h2.t.c0.c(n10);
        }
    }

    public static final List W(s s10) {
        f0.p(s10, "$this$toHeaderList");
        int n10 = s10.size();
        Object object = f.l2.q.n1(0, n10);
        int n11 = u.Y((Iterable)object, 10);
        ArrayList<a> arrayList = new ArrayList<a>(n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = object;
            n11 = ((l0)object).c();
            String string2 = s10.h(n11);
            object2 = s10.n(n11);
            a a10 = new a(string2, (String)object2);
            arrayList.add(a10);
        }
        return arrayList;
    }

    public static final s X(List object) {
        boolean bl2;
        f0.p(object, "$this$toHeaders");
        s$a s$a = new s$a();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (a)object.next();
            Object object3 = ((a)object2).a();
            object2 = ((a)object2).b();
            object3 = ((ByteString)object3).utf8();
            object2 = ((ByteString)object2).utf8();
            s$a.g((String)object3, (String)object2);
        }
        return s$a.i();
    }

    public static final String Y(int n10) {
        String string2 = Integer.toHexString(n10);
        f0.o(string2, "Integer.toHexString(this)");
        return string2;
    }

    public static final String Z(long l10) {
        String string2 = Long.toHexString(l10);
        f0.o(string2, "java.lang.Long.toHexString(this)");
        return string2;
    }

    public static final void a(List list, Object object) {
        String string2 = "$this$addIfAbsent";
        f0.p(list, string2);
        boolean bl2 = list.contains(object);
        if (!bl2) {
            list.add(object);
        }
    }

    public static final String a0(t t10, boolean c10) {
        char c11;
        f0.p(t10, "$this$toHostHeader");
        CharSequence charSequence = t10.F();
        Object object = ":";
        String string2 = null;
        int n10 = 2;
        char c12 = StringsKt__StringsKt.P2(charSequence, (CharSequence)object, false, n10, null);
        if (c12 != '\u0000') {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append('[');
            object = t10.F();
            ((StringBuilder)charSequence).append((String)object);
            c11 = ']';
            ((StringBuilder)charSequence).append(c11);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = t10.F();
        }
        if (c10 != '\u0000' || (c10 = t10.N()) != (c11 = ((t$b)(object = t.w)).g(string2 = t10.X()))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            c12 = ':';
            stringBuilder.append(c12);
            int n11 = t10.N();
            stringBuilder.append(n11);
            charSequence = stringBuilder.toString();
        }
        return charSequence;
    }

    public static final int b(byte by2, int n10) {
        return by2 & n10;
    }

    public static /* synthetic */ String b0(t t10, boolean bl2, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            bl2 = false;
        }
        return g.h0.d.a0(t10, bl2);
    }

    public static final int c(short s10, int n10) {
        return s10 & n10;
    }

    public static final List c0(List list) {
        f0.p(list, "$this$toImmutableList");
        list = Collections.unmodifiableList(CollectionsKt___CollectionsKt.L5(list));
        f0.o(list, "Collections.unmodifiableList(toMutableList())");
        return list;
    }

    public static final long d(int n10, long l10) {
        return (long)n10 & l10;
    }

    public static final Map d0(Map map) {
        Object object = "$this$toImmutableMap";
        f0.p(map, (String)object);
        boolean bl2 = map.isEmpty();
        if (bl2) {
            map = t0.z();
        } else {
            object = new LinkedHashMap(map);
            map = Collections.unmodifiableMap(object);
            object = "Collections.unmodifiableMap(LinkedHashMap(this))";
            f0.o(map, (String)object);
        }
        return map;
    }

    public static final q$c e(q q10) {
        f0.p(q10, "$this$asFactory");
        d$a d$a = new d$a(q10);
        return d$a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final long e0(String string2, long l10) {
        String string3 = "$this$toLongOrDefault";
        f0.p(string2, string3);
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return l10;
        }
    }

    public static final void f(Object object) {
        Object object2 = "$this$assertThreadDoesntHoldLock";
        f0.p(object, (String)object2);
        boolean bl2 = h;
        if (bl2 && (bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new AssertionError(object);
            throw object2;
        }
    }

    public static final int f0(String string2, int n10) {
        if (string2 != null) {
            int n11;
            long l10;
            try {
                l10 = Long.parseLong(string2);
                n11 = -1 >>> 1;
            }
            catch (NumberFormatException numberFormatException) {}
            long l11 = n11;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 <= 0) {
                long l13 = 0L;
                long l14 = l10 - l13;
                n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                n11 = n11 < 0 ? 0 : (int)l10;
            }
            return n11;
        }
        return n10;
    }

    public static final void g(Object object) {
        Object object2 = "$this$assertThreadHoldsLock";
        f0.p(object, (String)object2);
        boolean bl2 = h;
        if (bl2 && !(bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new AssertionError(object);
            throw object2;
        }
    }

    public static final String g0(String string2, int n10, int n11) {
        f0.p(string2, "$this$trimSubstring");
        n10 = g.h0.d.C(string2, n10, n11);
        n11 = g.h0.d.E(string2, n10, n11);
        string2 = string2.substring(n10, n11);
        f0.o(string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final boolean h(String string2) {
        f0.p(string2, "$this$canParseAsIpAddress");
        return g.matches(string2);
    }

    public static /* synthetic */ String h0(String string2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = string2.length();
        }
        return g.h0.d.g0(string2, n10, n11);
    }

    public static final boolean i(t object, t object2) {
        boolean bl2;
        int n10;
        f0.p(object, "$this$canReuseConnectionFor");
        f0.p(object2, "other");
        String string2 = ((t)object).F();
        String string3 = ((t)object2).F();
        int n11 = f0.g(string2, string3);
        if (n11 != 0 && (n11 = ((t)object).N()) == (n10 = ((t)object2).N()) && (bl2 = f0.g(object = ((t)object).X(), object2 = ((t)object2).X()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static final void i0(Object object) {
        f0.p(object, "$this$wait");
        object.wait();
    }

    public static final int j(String object, long l10, TimeUnit timeUnit) {
        String string2 = "name";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        int n11 = l12 >= 0 ? n10 : 0;
        if (n11 != 0) {
            n11 = timeUnit != null ? n10 : 0;
            if (n11 != 0) {
                long l13;
                long l14 = (l10 = timeUnit.toMillis(l10)) - (l13 = (long)(-1 >>> 1));
                Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 <= 0) {
                    object2 = n10;
                } else {
                    object2 = 0;
                    timeUnit = null;
                }
                if (object2 != false) {
                    object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (object2 == false && l12 > 0) {
                        n10 = 0;
                    }
                    if (n10 != 0) {
                        return (int)l10;
                    }
                    Serializable serializable = new StringBuilder();
                    serializable.append((String)object);
                    serializable.append(" too small.");
                    object = serializable.toString();
                    object = object.toString();
                    serializable = new IllegalArgumentException((String)object);
                    throw serializable;
                }
                Serializable serializable = new StringBuilder();
                serializable.append((String)object);
                serializable.append(" too large.");
                object = serializable.toString();
                object = object.toString();
                serializable = new IllegalArgumentException((String)object);
                throw serializable;
            }
            String string3 = "unit == null".toString();
            object = new IllegalStateException(string3);
            throw object;
        }
        Serializable serializable = new StringBuilder();
        serializable.append((String)object);
        serializable.append(" < 0");
        object = serializable.toString();
        object = object.toString();
        serializable = new IllegalStateException((String)object);
        throw serializable;
    }

    public static final Throwable j0(Exception exception, List object) {
        f0.p(exception, "$this$withSuppressed");
        Object object2 = "suppressed";
        f0.p(object, (String)object2);
        int n10 = object.size();
        int n11 = 1;
        if (n10 > n11) {
            object2 = System.out;
            ((PrintStream)object2).println(object);
        }
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (Exception)object.next();
            k.a(exception, (Throwable)object2);
        }
        return exception;
    }

    public static final void k(long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15 = l11 | l12;
        long l16 = 0L;
        long l17 = l15 - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object >= 0 && (object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) <= 0 && (l14 = (l13 = (l10 -= l11) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
            return;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }

    public static final void k0(n n10, int n11) {
        f0.p(n10, "$this$writeMedium");
        int n12 = n11 >>> 16 & 0xFF;
        n10.writeByte(n12);
        n12 = n11 >>> 8 & 0xFF;
        n10.writeByte(n12);
        n10.writeByte(n11 &= 0xFF);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void l(Closeable closeable) {
        String string2 = "$this$closeQuietly";
        f0.p(closeable, string2);
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void m(ServerSocket serverSocket) {
        String string2 = "$this$closeQuietly";
        f0.p(serverSocket, string2);
        try {
            serverSocket.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void n(Socket socket) {
        String string2 = "$this$closeQuietly";
        f0.p(socket, string2);
        try {
            socket.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (AssertionError assertionError) {
            throw assertionError;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static final String[] o(String[] stringArray, String string2) {
        f0.p(stringArray, "$this$concat");
        f0.p(string2, "value");
        int n10 = stringArray.length + 1;
        stringArray = Arrays.copyOf(stringArray, n10);
        f0.o(stringArray, "java.util.Arrays.copyOf(this, newSize)");
        n10 = ArraysKt___ArraysKt.Rd(stringArray);
        stringArray[n10] = string2;
        Objects.requireNonNull(stringArray, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        return stringArray;
    }

    public static final int p(String string2, char c10, int n10, int n11) {
        String string3 = "$this$delimiterOffset";
        f0.p(string2, string3);
        while (n10 < n11) {
            char c11 = string2.charAt(n10);
            if (c11 == c10) {
                return n10;
            }
            ++n10;
        }
        return n11;
    }

    public static final int q(String string2, String string3, int n10, int n11) {
        f0.p(string2, "$this$delimiterOffset");
        String string4 = "delimiters";
        f0.p(string3, string4);
        while (n10 < n11) {
            char c10 = string2.charAt(n10);
            int n12 = 2;
            if ((c10 = (char)(StringsKt__StringsKt.O2(string3, c10, false, n12, null) ? 1 : 0)) != '\u0000') {
                return n10;
            }
            ++n10;
        }
        return n11;
    }

    public static /* synthetic */ int r(String string2, char c10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = string2.length();
        }
        return g.h0.d.p(string2, c10, n10, n11);
    }

    public static /* synthetic */ int s(String string2, String string3, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = string2.length();
        }
        return g.h0.d.q(string2, string3, n10, n11);
    }

    public static final boolean t(m0 m02, int n10, TimeUnit timeUnit) {
        boolean bl2;
        f0.p(m02, "$this$discard");
        String string2 = "timeUnit";
        f0.p((Object)timeUnit, string2);
        try {
            bl2 = g.h0.d.T(m02, n10, timeUnit);
        }
        catch (IOException iOException) {
            bl2 = false;
            m02 = null;
        }
        return bl2;
    }

    public static final List u(Iterable object, l l10) {
        boolean bl2;
        f0.p(object, "$this$filterList");
        f0.p(l10, "predicate");
        ArrayList arrayList = CollectionsKt__CollectionsKt.E();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Object object2 = (Boolean)l10.invoke(e10);
            boolean bl3 = (Boolean)object2;
            if (!bl3) continue;
            bl3 = arrayList.isEmpty();
            if (bl3) {
                arrayList = new ArrayList();
            }
            Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<T>");
            object2 = f.h2.t.t0.g(arrayList);
            object2.add(e10);
        }
        return arrayList;
    }

    public static final String v(String string2, Object ... objectArray) {
        f0.p(string2, "format");
        f0.p(objectArray, "args");
        Object object = s0.a;
        object = Locale.US;
        int n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        string2 = String.format((Locale)object, string2, objectArray);
        f0.o(string2, "java.lang.String.format(locale, format, *args)");
        return string2;
    }

    public static final boolean w(String[] stringArray, String[] stringArray2, Comparator comparator) {
        f0.p(stringArray, "$this$hasIntersection");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = stringArray.length;
        int n11 = 1;
        if (!n10) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (!n10 && stringArray2 != null) {
            n10 = stringArray2.length;
            if (!n10) {
                n10 = n11;
            } else {
                n10 = 0;
                string2 = null;
            }
            if (!n10) {
                for (String string3 : stringArray) {
                    for (String string4 : stringArray2) {
                        int n12 = comparator.compare(string3, string4);
                        if (n12 != 0) continue;
                        return n11 != 0;
                    }
                }
            }
        }
        return false;
    }

    public static final long x(c0 object) {
        f0.p(object, "$this$headersContentLength");
        object = ((c0)object).C0();
        String string2 = "Content-Length";
        object = ((s)object).e(string2);
        long l10 = -1;
        if (object != null) {
            l10 = g.h0.d.e0((String)object, l10);
        }
        return l10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final void y(f.h2.s.a a10) {
        String string2 = "block";
        f0.p(a10, string2);
        try {
            a10.invoke();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static final List z(Object ... object) {
        f0.p(object, "elements");
        object = (Object[])object.clone();
        int n10 = ((Object[])object).length;
        object = Collections.unmodifiableList(CollectionsKt__CollectionsKt.L(Arrays.copyOf(object, n10)));
        f0.o(object, "Collections.unmodifiable\u2026istOf(*elements.clone()))");
        return object;
    }
}

