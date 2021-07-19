/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 */
package d.c.a.l;

import android.os.Build;
import android.os.StrictMode;
import d.c.a.l.a$a;
import d.c.a.l.a$b;
import d.c.a.l.a$c;
import d.c.a.l.a$d;
import d.c.a.l.a$e;
import d.c.a.l.b;
import d.c.a.l.c;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
implements Closeable {
    public static final String o = "journal";
    public static final String p = "journal.tmp";
    public static final String q = "journal.bkp";
    public static final String r = "libcore.io.DiskLruCache";
    public static final String s = "1";
    public static final long t = 255L;
    private static final String u = "CLEAN";
    private static final String v = "DIRTY";
    private static final String w = "REMOVE";
    private static final String x = "READ";
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    private final int g;
    private long h;
    private Writer i;
    private final LinkedHashMap j;
    private int k;
    private long l;
    public final ThreadPoolExecutor m;
    private final Callable n;

    private a(File file, int n10, int n11, long l10) {
        LinkedHashMap linkedHashMap;
        long l11;
        this.h = l11 = 0L;
        this.j = linkedHashMap = new LinkedHashMap(0, 0.75f, true);
        this.l = l11;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        a$b a$b = new a$b(null);
        Object object = new ThreadPoolExecutor(0, 1, (long)60, timeUnit, linkedBlockingQueue, a$b);
        this.m = object;
        this.n = object = new a$a(this);
        this.a = file;
        this.e = n10;
        this.b = object = new File(file, o);
        this.c = object = new File(file, p);
        this.d = object = new File(file, q);
        this.g = n11;
        this.f = l10;
    }

    private boolean A0() {
        LinkedHashMap linkedHashMap;
        int n10 = this.k;
        int n11 = 2000;
        n10 = n10 >= n11 && n10 >= (n11 = (linkedHashMap = this.j).size()) ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ int B(a a10) {
        return a10.g;
    }

    public static a B0(File serializable, int n10, int n11, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            if (n11 > 0) {
                Object object2;
                Object object3 = q;
                Object object4 = new File((File)serializable, (String)object3);
                boolean bl2 = ((File)object4).exists();
                if (bl2) {
                    object2 = o;
                    object3 = new File((File)serializable, (String)object2);
                    boolean bl3 = ((File)object3).exists();
                    if (bl3) {
                        ((File)object4).delete();
                    } else {
                        bl3 = false;
                        object2 = null;
                        d.c.a.l.a.H0((File)object4, (File)object3, false);
                    }
                }
                Object object5 = object4;
                Object object6 = serializable;
                object4 = new a((File)serializable, n10, n11, l10);
                object3 = ((a)object4).b;
                bl2 = ((File)object3).exists();
                if (bl2) {
                    try {
                        super.D0();
                        super.C0();
                        return object4;
                    }
                    catch (IOException iOException) {
                        object2 = System.out;
                        object5 = new StringBuilder();
                        ((StringBuilder)object5).append("DiskLruCache ");
                        ((StringBuilder)object5).append(serializable);
                        object6 = " is corrupt: ";
                        ((StringBuilder)object5).append((String)object6);
                        String string2 = iOException.getMessage();
                        ((StringBuilder)object5).append(string2);
                        ((StringBuilder)object5).append(", removing");
                        string2 = ((StringBuilder)object5).toString();
                        ((PrintStream)object2).println(string2);
                        ((a)object4).r0();
                    }
                }
                ((File)serializable).mkdirs();
                object5 = object4;
                object6 = serializable;
                object4 = new a((File)serializable, n10, n11, l10);
                super.F0();
                return object4;
            }
            serializable = new IllegalArgumentException("valueCount <= 0");
            throw serializable;
        }
        serializable = new IllegalArgumentException("maxSize <= 0");
        throw serializable;
    }

    public static /* synthetic */ void C(a a10) {
        a10.K0();
    }

    private void C0() {
        boolean bl2;
        d.c.a.l.a.s0(this.c);
        Iterator iterator2 = this.j.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            int n10;
            int n11;
            a$d a$d = (a$d)iterator2.next();
            Object object = a$d.g(a$d);
            if (object == null) {
                for (n11 = 0; n11 < (n10 = this.g); ++n11) {
                    long l10 = this.h;
                    object = a$d.a(a$d);
                    Object object2 = object[n11];
                    this.h = l10 += object2;
                }
                continue;
            }
            n10 = 0;
            object = null;
            a$d.h(a$d, null);
            while (n11 < (n10 = this.g)) {
                d.c.a.l.a.s0(a$d.j(n11));
                object = a$d.k(n11);
                d.c.a.l.a.s0((File)object);
                ++n11;
            }
            iterator2.remove();
        }
    }

    public static /* synthetic */ File D(a a10) {
        return a10.a;
    }

    /*
     * Loose catch block
     * Could not resolve type clashes
     */
    private void D0() {
        CharSequence charSequence;
        String string2;
        String string3;
        Object object;
        b b10;
        Object object2;
        Object object3;
        Object object4;
        block46: {
            object4 = ", ";
            object3 = this.b;
            object2 = new FileInputStream((File)object3);
            object3 = d.c.a.l.c.a;
            b10 = new b((InputStream)object2, (Charset)object3);
            object2 = b10.B();
            object3 = b10.B();
            object = b10.B();
            string3 = b10.B();
            string2 = b10.B();
            charSequence = r;
            int n10 = ((String)charSequence).equals(object2);
            if (n10 == 0) break block46;
            charSequence = s;
            n10 = ((String)charSequence).equals(object3);
            if (n10 == 0) break block46;
            n10 = this.e;
            charSequence = Integer.toString(n10);
            int n11 = ((String)charSequence).equals(object);
            if (n11 == 0) break block46;
            n11 = this.g;
            object = Integer.toString(n11);
            n11 = (int)(((String)object).equals(string3) ? 1 : 0);
            if (n11 == 0) break block46;
            object = "";
            n11 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n11 == 0) break block46;
            int n12 = 0;
            object4 = null;
            while (true) {
                object2 = b10.B();
                this.E0((String)object2);
                ++n12;
                continue;
                break;
            }
            catch (EOFException eOFException) {
                object2 = this.j;
                int n13 = ((HashMap)object2).size();
                this.k = n12 -= n13;
                n12 = (int)(b10.q() ? 1 : 0);
                if (n12 != 0) {
                    this.F0();
                } else {
                    object = this.b;
                    boolean bl2 = true;
                    object3 = new FileOutputStream((File)object, bl2);
                    object = d.c.a.l.c.a;
                    object2 = new OutputStreamWriter((OutputStream)object3, (Charset)object);
                    this.i = object4 = new BufferedWriter((Writer)object2);
                }
                return;
            }
        }
        charSequence = new StringBuilder();
        String string4 = "unexpected journal header: [";
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append((String)object4);
        ((StringBuilder)charSequence).append((String)object3);
        ((StringBuilder)charSequence).append((String)object4);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append((String)object4);
        ((StringBuilder)charSequence).append(string2);
        object4 = "]";
        ((StringBuilder)charSequence).append((String)object4);
        object4 = ((StringBuilder)charSequence).toString();
        object = new IOException((String)object4);
        throw object;
        {
            finally {
                d.c.a.l.c.a(b10);
            }
        }
    }

    public static /* synthetic */ void E(a a10, a$c a$c, boolean bl2) {
        a10.q0(a$c, bl2);
    }

    private void E0(String stringArray) {
        String string2;
        block8: {
            Object object;
            block12: {
                block10: {
                    int n10;
                    int n11;
                    int n12;
                    block11: {
                        Object object2;
                        String string3;
                        int n13;
                        block9: {
                            boolean bl2;
                            Object object3;
                            n12 = 32;
                            n11 = stringArray.indexOf(n12);
                            string2 = "unexpected journal line: ";
                            n10 = -1;
                            if (n11 == n10) break block8;
                            n13 = n11 + 1;
                            if ((n12 = stringArray.indexOf(n12, n13)) == n10) {
                                string3 = stringArray.substring(n13);
                                int n14 = 6;
                                if (n11 == n14 && (n14 = (int)(stringArray.startsWith((String)(object2 = w)) ? 1 : 0)) != 0) {
                                    this.j.remove(string3);
                                    return;
                                }
                            } else {
                                string3 = stringArray.substring(n13, n12);
                            }
                            if ((object2 = (a$d)this.j.get(string3)) == null) {
                                object2 = new a$d(this, string3, null);
                                object3 = this.j;
                                ((HashMap)object3).put(string3, object2);
                            }
                            n13 = 5;
                            if (n12 == n10 || n11 != n13 || !(bl2 = stringArray.startsWith((String)(object3 = u)))) break block9;
                            n11 = 1;
                            stringArray = stringArray.substring(n12 += n11);
                            String string4 = " ";
                            stringArray = stringArray.split(string4);
                            a$d.f((a$d)object2, n11 != 0);
                            a$d.h((a$d)object2, null);
                            a$d.i((a$d)object2, stringArray);
                            break block10;
                        }
                        if (n12 != n10 || n11 != n13 || (n13 = (int)(stringArray.startsWith(string3 = v) ? 1 : 0)) == 0) break block11;
                        stringArray = new a$c(this, (a$d)object2, null);
                        a$d.h((a$d)object2, (a$c)stringArray);
                        break block10;
                    }
                    if (n12 != n10 || n11 != (n12 = 4) || (n12 = (int)(stringArray.startsWith((String)(object = x)) ? 1 : 0)) == 0) break block12;
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((String)stringArray);
            stringArray = stringBuilder.toString();
            object = new IOException((String)stringArray);
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append((String)stringArray);
        stringArray = stringBuilder.toString();
        IOException iOException = new IOException((String)stringArray);
        throw iOException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void F0() {
        synchronized (this) {
            boolean bl2;
            Object object;
            Object object2;
            Object object3;
            Object object4;
            block9: {
                boolean bl3;
                object4 = this.i;
                if (object4 != null) {
                    d.c.a.l.a.p0((Writer)object4);
                }
                object3 = this.c;
                object2 = new FileOutputStream((File)object3);
                object3 = d.c.a.l.c.a;
                object = new OutputStreamWriter((OutputStream)object2, (Charset)object3);
                object4 = new BufferedWriter((Writer)object);
                object = r;
                ((Writer)object4).write((String)object);
                object = "\n";
                ((Writer)object4).write((String)object);
                object = s;
                ((Writer)object4).write((String)object);
                object = "\n";
                ((Writer)object4).write((String)object);
                int n10 = this.e;
                object = Integer.toString(n10);
                ((Writer)object4).write((String)object);
                object = "\n";
                ((Writer)object4).write((String)object);
                int n11 = this.g;
                object = Integer.toString(n11);
                ((Writer)object4).write((String)object);
                object = "\n";
                ((Writer)object4).write((String)object);
                object = "\n";
                ((Writer)object4).write((String)object);
                object = this.j;
                object = ((LinkedHashMap)object).values();
                object = object.iterator();
                while (bl3 = object.hasNext()) {
                    String string2;
                    object2 = object.next();
                    object2 = (a$d)object2;
                    object3 = a$d.g((a$d)object2);
                    char c10 = '\n';
                    if (object3 != null) {
                        object3 = new StringBuilder();
                        string2 = "DIRTY ";
                        ((StringBuilder)object3).append(string2);
                        object2 = a$d.b((a$d)object2);
                        ((StringBuilder)object3).append((String)object2);
                        ((StringBuilder)object3).append(c10);
                        object2 = ((StringBuilder)object3).toString();
                        ((Writer)object4).write((String)object2);
                        continue;
                    }
                    object3 = new StringBuilder();
                    string2 = "CLEAN ";
                    ((StringBuilder)object3).append(string2);
                    string2 = a$d.b((a$d)object2);
                    ((StringBuilder)object3).append(string2);
                    object2 = ((a$d)object2).l();
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append(c10);
                    object2 = ((StringBuilder)object3).toString();
                    ((Writer)object4).write((String)object2);
                }
                object4 = this.b;
                boolean bl4 = ((File)object4).exists();
                bl2 = true;
                if (!bl4) break block9;
                object4 = this.b;
                object2 = this.d;
                d.c.a.l.a.H0((File)object4, (File)object2, bl2);
            }
            object4 = this.c;
            object2 = this.b;
            object3 = null;
            d.c.a.l.a.H0((File)object4, (File)object2, false);
            object4 = this.d;
            ((File)object4).delete();
            File file = this.b;
            object3 = new FileOutputStream(file, bl2);
            object = d.c.a.l.c.a;
            object2 = new OutputStreamWriter((OutputStream)object3, (Charset)object);
            this.i = object4 = new BufferedWriter((Writer)object2);
            return;
            finally {
                d.c.a.l.a.p0((Writer)object4);
            }
        }
    }

    private static void H0(File serializable, File file, boolean bl2) {
        boolean bl3;
        if (bl2) {
            d.c.a.l.a.s0(file);
        }
        if (bl3 = serializable.renameTo(file)) {
            return;
        }
        serializable = new IOException();
        throw serializable;
    }

    private void K0() {
        long l10;
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = (l11 = this.h) - (l10 = this.f)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            String string2 = (String)this.j.entrySet().iterator().next().getKey();
            this.G0(string2);
        }
    }

    public static /* synthetic */ boolean O(a a10) {
        return a10.A0();
    }

    public static /* synthetic */ void S(a a10) {
        a10.F0();
    }

    public static /* synthetic */ Writer a(a a10) {
        return a10.i;
    }

    public static /* synthetic */ a$c h(a a10, String string2, long l10) {
        return a10.u0(string2, l10);
    }

    public static /* synthetic */ int n0(a a10, int n10) {
        a10.k = n10;
        return n10;
    }

    private void o0() {
        Object object = this.i;
        if (object != null) {
            return;
        }
        object = new IllegalStateException("cache is closed");
        throw object;
    }

    private static void p0(Writer writer) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
        builder = builder.permitUnbufferedIo().build();
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)builder);
        try {
            writer.close();
            return;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    public static /* synthetic */ String q(InputStream inputStream) {
        return d.c.a.l.a.z0(inputStream);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void q0(a$c object, boolean bl2) {
        synchronized (this) {
            long l10;
            int n10;
            File file;
            char c10;
            void var2_2;
            Object object2 = a$c.c((a$c)object);
            Object object3 = a$d.g((a$d)object2);
            if (object3 != object) {
                object = new IllegalStateException();
                throw object;
            }
            int n11 = 0;
            object3 = null;
            if (var2_2 != false && (c10 = a$d.e((a$d)object2)) == '\u0000') {
                int n12;
                file = null;
                for (c10 = '\u0000'; c10 < (n12 = this.g); ++c10) {
                    Object object4 = a$c.d((a$c)object);
                    n12 = object4[c10];
                    if (n12 == 0) {
                        ((a$c)object).a();
                        StringBuilder stringBuilder = new StringBuilder();
                        object2 = "Newly created entry didn't create value for index ";
                        stringBuilder.append((String)object2);
                        stringBuilder.append((int)c10);
                        String string2 = stringBuilder.toString();
                        object = new IllegalStateException(string2);
                        throw object;
                    }
                    object4 = ((a$d)object2).k(c10);
                    n12 = (int)(object4.exists() ? 1 : 0);
                    if (n12 != 0) continue;
                    ((a$c)object).a();
                    return;
                }
            }
            while (n11 < (n10 = this.g)) {
                object = ((a$d)object2).k(n11);
                if (var2_2 != false) {
                    c10 = (char)(((File)object).exists() ? 1 : 0);
                    if (c10 != '\u0000') {
                        long l11;
                        file = ((a$d)object2).j(n11);
                        ((File)object).renameTo(file);
                        object = a$d.a((a$d)object2);
                        Object object5 = object[n11];
                        long l12 = file.length();
                        object = a$d.a((a$d)object2);
                        object[n11] = l12;
                        this.h = l11 = this.h - object5 + l12;
                    }
                } else {
                    d.c.a.l.a.s0((File)object);
                }
                ++n11;
            }
            n10 = this.k;
            n11 = 1;
            this.k = n10 += n11;
            n10 = 0;
            object = null;
            a$d.h((a$d)object2, null);
            n10 = a$d.e((a$d)object2) | var2_2;
            c10 = '\n';
            char c11 = ' ';
            if (n10 != 0) {
                a$d.f((a$d)object2, n11 != 0);
                object = this.i;
                object3 = u;
                ((Writer)object).append((CharSequence)object3);
                object = this.i;
                ((Writer)object).append(c11);
                object = this.i;
                object3 = a$d.b((a$d)object2);
                ((Writer)object).append((CharSequence)object3);
                object = this.i;
                object3 = ((a$d)object2).l();
                ((Writer)object).append((CharSequence)object3);
                object = this.i;
                ((Writer)object).append(c10);
                if (var2_2 != false) {
                    long l13;
                    l10 = this.l;
                    this.l = l13 = 1L + l10;
                    a$d.d((a$d)object2, l10);
                }
            } else {
                object = this.j;
                String string3 = a$d.b((a$d)object2);
                ((HashMap)object).remove(string3);
                object = this.i;
                String string4 = w;
                ((Writer)object).append(string4);
                object = this.i;
                ((Writer)object).append(c11);
                object = this.i;
                String string5 = a$d.b((a$d)object2);
                ((Writer)object).append(string5);
                object = this.i;
                ((Writer)object).append(c10);
            }
            object = this.i;
            d.c.a.l.a.v0((Writer)object);
            l10 = this.h;
            long l14 = this.f;
            n10 = (int)(l10 == l14 ? 0 : (l10 < l14 ? -1 : 1));
            if (n10 > 0 || (n10 = (int)(this.A0() ? 1 : 0)) != 0) {
                object = this.m;
                Callable callable = this.n;
                ((AbstractExecutorService)object).submit(callable);
            }
            return;
        }
    }

    private static void s0(File serializable) {
        boolean bl2;
        boolean bl3 = serializable.exists();
        if (bl3 && !(bl2 = serializable.delete())) {
            serializable = new IOException();
            throw serializable;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private a$c u0(String object, long l10) {
        synchronized (this) {
            Object object2;
            long l11;
            long l12;
            long l13;
            void var2_2;
            this.o0();
            Object object3 = this.j;
            object3 = ((LinkedHashMap)object3).get(object);
            object3 = (a$d)object3;
            long l14 = -1;
            void var7_5 = var2_2 == l14 ? 0 : (var2_2 < l14 ? -1 : 1);
            if (var7_5 != false && (object3 == null || (l13 = (l12 = (l11 = a$d.c((a$d)object3)) - var2_2) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false)) {
                return null;
            }
            if (object3 == null) {
                object3 = new a$d(this, (String)object, null);
                object2 = this.j;
                ((HashMap)object2).put(object, object3);
            } else {
                object2 = a$d.g((a$d)object3);
                if (object2 != null) {
                    return null;
                }
            }
            object2 = new a$c(this, (a$d)object3, null);
            a$d.h((a$d)object3, (a$c)object2);
            Writer writer = this.i;
            object3 = v;
            writer.append((CharSequence)object3);
            writer = this.i;
            char c10 = ' ';
            writer.append(c10);
            writer = this.i;
            writer.append((CharSequence)object);
            object = this.i;
            char c11 = '\n';
            ((Writer)object).append(c11);
            object = this.i;
            d.c.a.l.a.v0((Writer)object);
            return object2;
        }
    }

    private static void v0(Writer writer) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
        builder = builder.permitUnbufferedIo().build();
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)builder);
        try {
            writer.flush();
            return;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }

    private static String z0(InputStream inputStream) {
        Charset charset = d.c.a.l.c.b;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return d.c.a.l.c.c(inputStreamReader);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean G0(String object) {
        synchronized (this) {
            Object object2;
            this.o0();
            Object object3 = this.j;
            object3 = ((LinkedHashMap)object3).get(object);
            object3 = (a$d)object3;
            String string2 = null;
            if (object3 != null && (object2 = a$d.g((a$d)object3)) == null) {
                int n10;
                int n11;
                for (n11 = 0; n11 < (n10 = this.g); ++n11) {
                    object2 = ((a$d)object3).j(n11);
                    boolean bl2 = ((File)object2).exists();
                    if (bl2 && !(bl2 = ((File)object2).delete())) {
                        object3 = new StringBuilder();
                        string2 = "failed to delete ";
                        ((StringBuilder)object3).append(string2);
                        ((StringBuilder)object3).append(object2);
                        object3 = ((StringBuilder)object3).toString();
                        object = new IOException((String)object3);
                        throw object;
                    }
                    long l10 = this.h;
                    long[] lArray = a$d.a((a$d)object3);
                    long l11 = lArray[n11];
                    this.h = l10 -= l11;
                    object2 = a$d.a((a$d)object3);
                    long l12 = 0L;
                    object2[n11] = l12;
                }
                int n12 = this.k;
                n11 = 1;
                this.k = n12 += n11;
                object3 = this.i;
                object2 = w;
                ((Writer)object3).append((CharSequence)object2);
                object3 = this.i;
                n10 = 32;
                ((Writer)object3).append((char)n10);
                object3 = this.i;
                ((Writer)object3).append((CharSequence)object);
                object3 = this.i;
                n10 = 10;
                ((Writer)object3).append((char)n10);
                object3 = this.j;
                ((HashMap)object3).remove(object);
                boolean bl3 = this.A0();
                if (bl3) {
                    object = this.m;
                    object3 = this.n;
                    ((AbstractExecutorService)object).submit(object3);
                }
                return n11 != 0;
            }
            return false;
        }
    }

    public void I0(long l10) {
        synchronized (this) {
            this.f = l10;
            ThreadPoolExecutor threadPoolExecutor = this.m;
            Callable callable = this.n;
            threadPoolExecutor.submit(callable);
            return;
        }
    }

    public long J0() {
        synchronized (this) {
            long l10 = this.h;
            return l10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        synchronized (this) {
            Object object = this.i;
            if (object == null) {
                return;
            }
            Object object2 = this.j;
            object2 = ((LinkedHashMap)object2).values();
            object = new ArrayList(object2);
            object = ((ArrayList)object).iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    this.K0();
                    object = this.i;
                    d.c.a.l.a.p0((Writer)object);
                    object = null;
                    this.i = null;
                    return;
                }
                object2 = object.next();
                a$c a$c = a$d.g((a$d)(object2 = (a$d)object2));
                if (a$c == null) continue;
                object2 = a$d.g((a$d)object2);
                ((a$c)object2).a();
            }
        }
    }

    public void flush() {
        synchronized (this) {
            this.o0();
            this.K0();
            Writer writer = this.i;
            d.c.a.l.a.v0(writer);
            return;
        }
    }

    public boolean isClosed() {
        synchronized (this) {
            boolean bl2;
            block4: {
                Writer writer = this.i;
                if (writer == null) {
                    bl2 = true;
                    break block4;
                }
                bl2 = false;
                writer = null;
            }
            return bl2;
        }
    }

    public void r0() {
        this.close();
        d.c.a.l.c.b(this.a);
    }

    public a$c t0(String string2) {
        return this.u0(string2, -1);
    }

    public a$e w0(String string2) {
        synchronized (this) {
            a$e a$e;
            File[] fileArray;
            Object object;
            Object object2;
            Object object3;
            block26: {
                char c10;
                int n10;
                block25: {
                    block24: {
                        this.o0();
                        object3 = this.j;
                        object3 = ((LinkedHashMap)object3).get(string2);
                        object3 = (a$d)object3;
                        n10 = 0;
                        object2 = null;
                        if (object3 != null) break block24;
                        return null;
                    }
                    c10 = a$d.e((a$d)object3);
                    if (c10 != '\u0000') break block25;
                    return null;
                }
                object = ((a$d)object3).c;
                int n11 = ((File[])object).length;
                for (int i10 = 0; i10 < n11; ++i10) {
                    fileArray = object[i10];
                    boolean bl2 = fileArray.exists();
                    if (bl2) continue;
                    return null;
                }
                n10 = this.k + 1;
                this.k = n10;
                object2 = this.i;
                object = x;
                ((Writer)object2).append((CharSequence)object);
                object2 = this.i;
                c10 = ' ';
                ((Writer)object2).append(c10);
                object2 = this.i;
                ((Writer)object2).append(string2);
                object2 = this.i;
                c10 = '\n';
                ((Writer)object2).append(c10);
                n10 = (int)(this.A0() ? 1 : 0);
                if (n10 == 0) break block26;
                object2 = this.m;
                object = this.n;
                ((AbstractExecutorService)object2).submit(object);
            }
            long l10 = a$d.c((a$d)object3);
            fileArray = ((a$d)object3).c;
            long[] lArray = a$d.a((a$d)object3);
            object3 = a$e;
            object2 = this;
            object = string2;
            a$e = new a$e(this, string2, l10, fileArray, lArray, null);
            return a$e;
        }
    }

    public File x0() {
        return this.a;
    }

    public long y0() {
        synchronized (this) {
            long l10 = this.f;
            return l10;
        }
    }
}

