/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.publicsuffix;

import f.e2.b;
import f.h2.t.f0;
import f.x1.t;
import h.m0;
import h.u;
import h.z;
import java.io.Closeable;
import java.io.InputStream;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase$a;

public final class PublicSuffixDatabase {
    public static final String e = "publicsuffixes.gz";
    private static final byte[] f;
    private static final List g;
    private static final char h = '!';
    private static final PublicSuffixDatabase i;
    public static final PublicSuffixDatabase$a j;
    private final AtomicBoolean a;
    private final CountDownLatch b;
    private byte[] c;
    private byte[] d;

    static {
        Object object = new PublicSuffixDatabase$a(null);
        j = object;
        object = new byte[1];
        byte by2 = (byte)42;
        object[0] = by2;
        f = (byte[])object;
        g = t.k("*");
        i = object = new PublicSuffixDatabase();
    }

    public PublicSuffixDatabase() {
        Object object = new AtomicBoolean(false);
        this.a = object;
        this.b = object = new CountDownLatch(1);
    }

    public static final /* synthetic */ PublicSuffixDatabase a() {
        return i;
    }

    public static final /* synthetic */ byte[] b(PublicSuffixDatabase object) {
        object = ((PublicSuffixDatabase)object).c;
        if (object == null) {
            String string2 = "publicSuffixListBytes";
            f0.S(string2);
        }
        return object;
    }

    public static final /* synthetic */ void c(PublicSuffixDatabase publicSuffixDatabase, byte[] byArray) {
        publicSuffixDatabase.c = byArray;
    }

    /*
     * WARNING - void declaration
     */
    private final List d(List list) {
        String string2;
        Object object;
        block32: {
            Object object2;
            int n10;
            int n11;
            block36: {
                block35: {
                    int n12;
                    Object[] objectArray;
                    Object object3;
                    Object object4;
                    block34: {
                        block33: {
                            int n13;
                            byte[] byArray;
                            int n14;
                            Object object5;
                            Object object6;
                            Object object7;
                            Object object8;
                            int n15;
                            int n16;
                            PublicSuffixDatabase publicSuffixDatabase;
                            block31: {
                                void var4_8;
                                boolean bl2;
                                publicSuffixDatabase = this;
                                object = this.a;
                                boolean n122 = ((AtomicBoolean)object).get();
                                n11 = 0;
                                string2 = null;
                                n10 = 1;
                                if (!n122 && (bl2 = ((AtomicBoolean)(object = this.a)).compareAndSet(false, n10 != 0))) {
                                    this.g();
                                } else {
                                    object = publicSuffixDatabase.b;
                                    try {
                                        ((CountDownLatch)object).await();
                                    }
                                    catch (InterruptedException interruptedException) {
                                        object = Thread.currentThread();
                                        ((Thread)object).interrupt();
                                    }
                                }
                                object = publicSuffixDatabase.c;
                                if (object != null) {
                                    int n17 = n10;
                                } else {
                                    boolean bl3 = false;
                                    object = null;
                                }
                                if (var4_8 == false) break block32;
                                n16 = list.size();
                                object2 = new byte[n16][];
                                object4 = null;
                                for (n15 = 0; n15 < n16; ++n15) {
                                    object8 = list;
                                    object7 = (String)list.get(n15);
                                    object6 = StandardCharsets.UTF_8;
                                    f0.o(object6, "UTF_8");
                                    object5 = "null cannot be cast to non-null type java.lang.String";
                                    Objects.requireNonNull(object7, (String)object5);
                                    object7 = ((String)object7).getBytes((Charset)object6);
                                    object6 = "(this as java.lang.String).getBytes(charset)";
                                    f0.o(object7, (String)object6);
                                    object2[n15] = (byte[])object7;
                                }
                                n15 = 0;
                                object4 = null;
                                while (true) {
                                    object8 = "publicSuffixListBytes";
                                    object7 = null;
                                    if (n15 >= n16) break;
                                    object6 = j;
                                    object5 = publicSuffixDatabase.c;
                                    if (object5 == null) {
                                        f0.S((String)object8);
                                    }
                                    if ((object6 = PublicSuffixDatabase$a.a((PublicSuffixDatabase$a)object6, (byte[])object5, (byte[][])object2, n15)) == null) {
                                        ++n15;
                                        continue;
                                    }
                                    break block31;
                                    break;
                                }
                                object6 = null;
                            }
                            if (n16 > n10) {
                                object4 = (byte[][])object2.clone();
                                n14 = ((byte[][])object4).length - n10;
                                byArray = null;
                                for (n13 = 0; n13 < n14; ++n13) {
                                    object3 = f;
                                    object4[n13] = object3;
                                    object3 = j;
                                    objectArray = publicSuffixDatabase.c;
                                    if (objectArray == null) {
                                        f0.S((String)object8);
                                    }
                                    if ((object3 = (Object)PublicSuffixDatabase$a.a((PublicSuffixDatabase$a)object3, (byte[])objectArray, object4, n13)) == null) continue;
                                    object4 = object3;
                                    break;
                                }
                            } else {
                                n15 = 0;
                                object4 = null;
                            }
                            if (object4 != null) {
                                int n18 = n16 - n10;
                                object8 = null;
                                for (int i10 = 0; i10 < n18; ++i10) {
                                    object5 = j;
                                    byArray = publicSuffixDatabase.d;
                                    if (byArray == null) {
                                        object3 = "publicSuffixExceptionListBytes";
                                        f0.S((String)object3);
                                    }
                                    if ((object5 = PublicSuffixDatabase$a.a((PublicSuffixDatabase$a)object5, byArray, (byte[][])object2, i10)) == null) continue;
                                    object7 = object5;
                                    break;
                                }
                            }
                            n12 = 46;
                            if (object7 != null) {
                                object2 = new StringBuilder;
                                ((StringBuilder)object2)();
                                ((StringBuilder)object2).append('!');
                                ((StringBuilder)object2).append((String)object7);
                                object6 = ((StringBuilder)object2).toString();
                                object5 = new char[n10];
                                object5[0] = n12;
                                return StringsKt__StringsKt.H4((CharSequence)object6, (char[])object5, false, 0, 6, null);
                            }
                            if (object6 == null && object4 == null) {
                                return g;
                            }
                            if (object6 == null) break block33;
                            object7 = new char[n10];
                            object7[0] = n12;
                            n14 = 0;
                            object5 = null;
                            n13 = 6;
                            object3 = null;
                            object8 = object6;
                            object6 = null;
                            object2 = StringsKt__StringsKt.H4((CharSequence)object8, (char[])object7, false, 0, n13, null);
                            if (object2 != null) break block34;
                        }
                        object2 = CollectionsKt__CollectionsKt.E();
                    }
                    if (object4 == null) break block35;
                    objectArray = new char[n10];
                    objectArray[0] = n12;
                    int n19 = 6;
                    object3 = object4;
                    object = StringsKt__StringsKt.H4((CharSequence)object4, objectArray, false, 0, n19, null);
                    if (object != null) break block36;
                }
                object = CollectionsKt__CollectionsKt.E();
            }
            n11 = object2.size();
            n10 = object.size();
            if (n11 <= n10) {
                object2 = object;
            }
            return object2;
        }
        string2 = "Unable to load publicsuffixes.gz resource from the classpath.".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void f() {
        byte[] byArray;
        byte[] byArray2;
        Object object = e;
        Closeable closeable = PublicSuffixDatabase.class.getResourceAsStream((String)object);
        if (closeable == null) {
            return;
        }
        closeable = z.m((InputStream)closeable);
        object = new u((m0)closeable);
        closeable = z.d((m0)object);
        object = null;
        try {
            int n10 = closeable.readInt();
            long l10 = n10;
            byArray2 = closeable.z(l10);
            int n11 = closeable.readInt();
            long l11 = n11;
            byArray = closeable.z(l11);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                f.e2.b.a(closeable, throwable);
                throw throwable2;
            }
        }
        f.e2.b.a(closeable, null);
        synchronized (this) {
            f0.m(byArray2);
            this.c = byArray2;
            f0.m(byArray);
            this.d = byArray;
        }
        this.b.countDown();
    }

    /*
     * Exception decompiling
     */
    private final void g() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [3 : 26->29)] java.lang.Throwable
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

    private final List i(String object) {
        int n10 = 1;
        Object object2 = new char[n10];
        object2[0] = 46;
        int n11 = 6;
        String string2 = object;
        string2 = (String)CollectionsKt___CollectionsKt.a3((List)(object = StringsKt__StringsKt.H4((CharSequence)object, object2, false, 0, n11, null)));
        boolean bl2 = f0.g(string2, object2 = (Object)"");
        if (bl2) {
            object = CollectionsKt___CollectionsKt.Q1((List)object, n10);
        }
        return object;
    }

    public final String e(String string2) {
        int n10;
        int n11;
        String string3;
        f0.p(string2, "domain");
        Object object = IDN.toUnicode(string2);
        f0.o(object, "unicodeDomain");
        object = this.i((String)object);
        List list = this.d((List)object);
        int n12 = object.size();
        int n13 = list.size();
        int n14 = 33;
        if (n12 == n13 && (n12 = (int)(string3 = (String)list.get(0)).charAt(0)) != n14) {
            return null;
        }
        string3 = (String)list.get(0);
        n12 = string3.charAt(0);
        if (n12 == n14) {
            n11 = object.size();
            n10 = list.size();
        } else {
            n11 = object.size();
            n10 = list.size() + 1;
        }
        return SequencesKt___SequencesKt.V0(SequencesKt___SequencesKt.d0(CollectionsKt___CollectionsKt.n1(this.i(string2)), n11 -= n10), ".", null, null, 0, null, null, 62, null);
    }

    public final void h(byte[] byArray, byte[] byArray2) {
        f0.p(byArray, "publicSuffixListBytes");
        f0.p(byArray2, "publicSuffixExceptionListBytes");
        this.c = byArray;
        this.d = byArray2;
        this.a.set(true);
        this.b.countDown();
    }
}

