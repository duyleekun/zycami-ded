/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import f.e2.a;
import f.e2.b;
import f.e2.f;
import f.e2.k;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.c0;
import f.h2.t.f0;
import f.l2.q;
import f.q1;
import f.q2.d;
import f.x1.n;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.io.FilesKt__FileReadWriteKt$readLines$1;
import kotlin.io.TextStreamsKt;

public class FilesKt__FileReadWriteKt
extends k {
    private static final InputStreamReader A(File object, Charset charset) {
        FileInputStream fileInputStream = new FileInputStream((File)object);
        object = new InputStreamReader((InputStream)fileInputStream, charset);
        return object;
    }

    public static /* synthetic */ InputStreamReader B(File object, Charset charset, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        FileInputStream fileInputStream = new FileInputStream((File)object);
        object = new InputStreamReader((InputStream)fileInputStream, charset);
        return object;
    }

    /*
     * Unable to fully structure code
     */
    public static final Object C(File var0, Charset var1_1, l var2_3) {
        f0.p(var0, "$this$useLines");
        f0.p(var1_1, "charset");
        f0.p(var2_3, "block");
        var3_5 = new FileInputStream((File)var0);
        var0 = new InputStreamReader((InputStream)var3_5, (Charset)var1_1);
        var4_6 = var0 instanceof BufferedReader;
        if (var4_6) {
            var0 = (BufferedReader)var0;
        } else {
            var5_7 = 8192;
            var0 = var1_1 = new BufferedReader((Reader)var0, var5_7);
        }
        var4_6 = false;
        var1_1 = null;
        var5_7 = 0;
        var3_5 = null;
        var6_8 = 1;
        try {
            var7_9 = TextStreamsKt.h((BufferedReader)var0);
        }
        catch (Throwable var1_2) {
            try {
                throw var1_2;
            }
            catch (Throwable var2_4) {
                c0.d(var6_8);
                var5_7 = (int)f.d2.l.a(var6_8, var6_8, 0);
                if (var5_7 == 0) {
                    var0.close();
                } else {
                    b.a((Closeable)var0, var1_2);
                }
lbl30:
                // 3 sources

                while (true) {
                    c0.c(var6_8);
                    throw var2_4;
                }
                catch (Throwable v0) {
                    ** continue;
                }
            }
        }
        var2_3 = var2_3.invoke(var7_9);
        c0.d(var6_8);
        var5_7 = (int)f.d2.l.a(var6_8, var6_8, 0);
        if (var5_7 != 0) {
            b.a((Closeable)var0, null);
        } else {
            var0.close();
        }
        c0.c(var6_8);
        return var2_3;
    }

    /*
     * Unable to fully structure code
     */
    public static /* synthetic */ Object D(File var0, Charset var1_1, l var2_3, int var3_5, Object var4_6) {
        var5_7 = 1;
        if ((var3_5 &= var5_7) != 0) {
            var1_1 = d.a;
        }
        f0.p(var0, "$this$useLines");
        f0.p(var1_1, "charset");
        var6_8 = "block";
        f0.p(var2_3, var6_8);
        var3_5 = 8192;
        var7_9 = new FileInputStream((File)var0);
        var0 = new InputStreamReader((InputStream)var7_9, (Charset)var1_1);
        var8_10 = var0 instanceof BufferedReader;
        var0 = var8_10 != false ? (BufferedReader)var0 : (var1_1 = new BufferedReader((Reader)var0, var3_5));
        var8_10 = false;
        var1_1 = null;
        var3_5 = 0;
        var6_8 = null;
        try {
            var7_9 = TextStreamsKt.h((BufferedReader)var0);
        }
        catch (Throwable var1_2) {
            try {
                throw var1_2;
            }
            catch (Throwable var2_4) {
                c0.d(var5_7);
                var3_5 = (int)f.d2.l.a(var5_7, var5_7, 0);
                if (var3_5 == 0) {
                    var0.close();
                } else {
                    b.a((Closeable)var0, var1_2);
                }
lbl30:
                // 3 sources

                while (true) {
                    c0.c(var5_7);
                    throw var2_4;
                }
                catch (Throwable v0) {
                    ** continue;
                }
            }
        }
        var2_3 = var2_3.invoke(var7_9);
        c0.d(var5_7);
        var3_5 = (int)f.d2.l.a(var5_7, var5_7, 0);
        if (var3_5 != 0) {
            b.a((Closeable)var0, null);
        } else {
            var0.close();
        }
        c0.c(var5_7);
        return var2_3;
    }

    public static final void E(File object, byte[] byArray) {
        f0.p(object, "$this$writeBytes");
        f0.p(byArray, "array");
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        try {
            fileOutputStream.write(byArray);
            object = q1.a;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a(fileOutputStream, throwable);
                throw throwable2;
            }
        }
        b.a(fileOutputStream, null);
    }

    public static final void F(File file, String object, Charset charset) {
        f0.p(file, "$this$writeText");
        f0.p(object, "text");
        f0.p(charset, "charset");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        FilesKt__FileReadWriteKt.E(file, (byte[])object);
    }

    public static /* synthetic */ void G(File file, String string2, Charset charset, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            charset = d.a;
        }
        FilesKt__FileReadWriteKt.F(file, string2, charset);
    }

    private static final OutputStreamWriter H(File object, Charset charset) {
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        object = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        return object;
    }

    public static /* synthetic */ OutputStreamWriter I(File object, Charset charset, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        object = new OutputStreamWriter((OutputStream)fileOutputStream, charset);
        return object;
    }

    public static final void g(File object, byte[] byArray) {
        f0.p(object, "$this$appendBytes");
        f0.p(byArray, "array");
        boolean bl2 = true;
        FileOutputStream fileOutputStream = new FileOutputStream((File)object, bl2);
        try {
            fileOutputStream.write(byArray);
            object = q1.a;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a(fileOutputStream, throwable);
                throw throwable2;
            }
        }
        b.a(fileOutputStream, null);
    }

    public static final void h(File file, String object, Charset charset) {
        f0.p(file, "$this$appendText");
        f0.p(object, "text");
        f0.p(charset, "charset");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        FilesKt__FileReadWriteKt.g(file, (byte[])object);
    }

    public static /* synthetic */ void i(File file, String string2, Charset charset, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            charset = d.a;
        }
        FilesKt__FileReadWriteKt.h(file, string2, charset);
    }

    private static final BufferedReader j(File object, Charset object2, int n10) {
        FileInputStream fileInputStream = new FileInputStream((File)object);
        object = new InputStreamReader((InputStream)fileInputStream, (Charset)object2);
        boolean bl2 = object instanceof BufferedReader;
        object = bl2 ? (BufferedReader)object : (object2 = new BufferedReader((Reader)object, n10));
        return object;
    }

    public static /* synthetic */ BufferedReader k(File object, Charset object2, int n10, int n11, Object object3) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            object2 = d.a;
        }
        if ((n11 &= 2) != 0) {
            n10 = 8192;
        }
        FileInputStream fileInputStream = new FileInputStream((File)object);
        object = new InputStreamReader((InputStream)fileInputStream, (Charset)object2);
        boolean bl2 = object instanceof BufferedReader;
        object = bl2 ? (BufferedReader)object : (object2 = new BufferedReader((Reader)object, n10));
        return object;
    }

    private static final BufferedWriter l(File object, Charset object2, int n10) {
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        object = new OutputStreamWriter((OutputStream)fileOutputStream, (Charset)object2);
        boolean bl2 = object instanceof BufferedWriter;
        object = bl2 ? (BufferedWriter)object : (object2 = new BufferedWriter((Writer)object, n10));
        return object;
    }

    public static /* synthetic */ BufferedWriter m(File object, Charset object2, int n10, int n11, Object object3) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            object2 = d.a;
        }
        if ((n11 &= 2) != 0) {
            n10 = 8192;
        }
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        object = new OutputStreamWriter((OutputStream)fileOutputStream, (Charset)object2);
        boolean bl2 = object instanceof BufferedWriter;
        object = bl2 ? (BufferedWriter)object : (object2 = new BufferedWriter((Writer)object, n10));
        return object;
    }

    /*
     * Loose catch block
     */
    public static final void n(File object, int n10, p p10) {
        int n11;
        f0.p(object, "$this$forEachBlock");
        f0.p(p10, "action");
        int n12 = 512;
        n10 = q.n(n10, n12);
        byte[] byArray = new byte[n10];
        FileInputStream fileInputStream = new FileInputStream((File)object);
        while (true) {
            n11 = fileInputStream.read(byArray);
            if (n11 > 0) break block8;
            break;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a(fileInputStream, throwable);
                throw throwable2;
            }
        }
        {
            block8: {
                object = q1.a;
                b.a(fileInputStream, null);
                return;
            }
            object = n11;
            p10.invoke(byArray, object);
            continue;
        }
    }

    public static final void o(File file, p p10) {
        f0.p(file, "$this$forEachBlock");
        f0.p(p10, "action");
        FilesKt__FileReadWriteKt.n(file, 4096, p10);
    }

    public static final void p(File file, Charset charset, l l10) {
        f0.p(file, "$this$forEachLine");
        f0.p(charset, "charset");
        f0.p(l10, "action");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, charset);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        TextStreamsKt.g(bufferedReader, l10);
    }

    public static /* synthetic */ void q(File file, Charset charset, l l10, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        FilesKt__FileReadWriteKt.p(file, charset, l10);
    }

    private static final FileInputStream r(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }

    private static final FileOutputStream s(File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        return fileOutputStream;
    }

    private static final PrintWriter t(File object, Charset object2) {
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        object = new OutputStreamWriter((OutputStream)fileOutputStream, (Charset)object2);
        boolean bl2 = object instanceof BufferedWriter;
        if (bl2) {
            object = (BufferedWriter)object;
        } else {
            int n10 = 8192;
            object = object2 = new BufferedWriter((Writer)object, n10);
        }
        PrintWriter printWriter = new PrintWriter((Writer)object);
        return printWriter;
    }

    public static /* synthetic */ PrintWriter u(File object, Charset object2, int n10, Object object3) {
        if ((n10 &= 1) != 0) {
            object2 = d.a;
        }
        int n11 = 8192;
        FileOutputStream fileOutputStream = new FileOutputStream((File)object);
        object = new OutputStreamWriter((OutputStream)fileOutputStream, (Charset)object2);
        boolean bl2 = object instanceof BufferedWriter;
        object = bl2 ? (BufferedWriter)object : (object2 = new BufferedWriter((Writer)object, n11));
        PrintWriter printWriter = new PrintWriter((Writer)object);
        return printWriter;
    }

    /*
     * Unable to fully structure code
     */
    public static final byte[] v(File var0) {
        block34: {
            block33: {
                block32: {
                    f0.p(var0, "$this$readBytes");
                    var1_2 = new FileInputStream((File)var0);
                    var2_3 = var0.length();
                    var4_4 = -1 >>> 1;
                    var6_5 = var2_3 == var4_4 ? 0 : (var2_3 < var4_4 ? -1 : 1);
                    var7_6 = "File ";
                    if (var6_5 > 0) break block34;
                    var8_7 = (int)var2_3;
                    var9_8 = new byte[var8_7];
                    var6_5 = 0;
                    var10_9 = null;
                    var11_11 = var8_7;
                    var12_12 = 0;
                    var13_13 = null;
                    while (var11_11 > 0) {
                        var14_14 = var1_2.read((byte[])var9_8, var12_12, var11_11);
                        if (var14_14 < 0) break;
                        var11_11 -= var14_14;
                        var12_12 += var14_14;
                    }
                    var15_15 = "java.util.Arrays.copyOf(this, newSize)";
                    if (var11_11 <= 0) ** GOTO lbl37
                    try {
                        var9_8 = Arrays.copyOf((byte[])var9_8, var12_12);
                    }
                    catch (Throwable var0_1) {
                        try {
                            throw var0_1;
                        }
                        catch (Throwable var18_19) {
                            b.a(var1_2, var0_1);
                            throw var18_19;
                        }
                    }
                    f0.o(var9_8, var15_15);
                    break block32;
lbl37:
                    // 1 sources

                    var11_11 = var1_2.read();
                    if (var11_11 == (var12_12 = -1)) break block32;
                    var16_16 = 8193;
                    var13_13 = new f(var16_16);
                    var13_13.write(var11_11);
                    var11_11 = 2;
                    a.l(var1_2, var13_13, 0, var11_11, null);
                    var11_11 = var13_13.size() + var8_7;
                    if (var11_11 < 0) break block33;
                    var0 = var13_13.a();
                    var9_8 = Arrays.copyOf((byte[])var9_8, var11_11);
                    f0.o(var9_8, var15_15);
                    var17_17 = var13_13.size();
                    var9_8 = n.W0((byte[])var0, (byte[])var9_8, var8_7, 0, var17_17);
                }
                b.a(var1_2, null);
                return var9_8;
            }
            var9_8 = new StringBuilder;
            var9_8();
            var9_8.append(var7_6);
            var9_8.append(var0);
            var0 = " is too big to fit in memory.";
            var9_8.append((String)var0);
            var0 = var9_8.toString();
            var18_18 = new OutOfMemoryError((String)var0);
            throw var18_18;
        }
        var19_20 = new StringBuilder();
        var19_20.append(var7_6);
        var19_20.append(var0);
        var0 = " is too big (";
        var19_20.append((String)var0);
        var19_20.append(var2_3);
        var0 = " bytes) to fit in memory.";
        var19_20.append((String)var0);
        var0 = var19_20.toString();
        var10_10 = new OutOfMemoryError((String)var0);
        throw var10_10;
    }

    public static final List w(File file, Charset charset) {
        f0.p(file, "$this$readLines");
        f0.p(charset, "charset");
        ArrayList arrayList = new ArrayList();
        FilesKt__FileReadWriteKt$readLines$1 filesKt__FileReadWriteKt$readLines$1 = new FilesKt__FileReadWriteKt$readLines$1(arrayList);
        FilesKt__FileReadWriteKt.p(file, charset, filesKt__FileReadWriteKt$readLines$1);
        return arrayList;
    }

    public static /* synthetic */ List x(File file, Charset charset, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        return FilesKt__FileReadWriteKt.w(file, charset);
    }

    public static final String y(File object, Charset object2) {
        f0.p(object, "$this$readText");
        f0.p(object2, "charset");
        FileInputStream fileInputStream = new FileInputStream((File)object);
        object = new InputStreamReader((InputStream)fileInputStream, (Charset)object2);
        try {
            object2 = TextStreamsKt.k((Reader)object);
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a((Closeable)object, throwable);
                throw throwable2;
            }
        }
        b.a((Closeable)object, null);
        return object2;
    }

    public static /* synthetic */ String z(File file, Charset charset, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        return FilesKt__FileReadWriteKt.y(file, charset);
    }
}

