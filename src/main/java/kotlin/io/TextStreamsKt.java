/*
 * Decompiled with CFR 0.151.
 */
package kotlin.io;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import f.e2.a;
import f.e2.b;
import f.e2.n;
import f.h2.s.l;
import f.h2.t.c0;
import f.h2.t.f0;
import f.n2.m;
import f.q1;
import f.q2.d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.TextStreamsKt$readLines$1;
import kotlin.sequences.SequencesKt__SequencesKt;

public final class TextStreamsKt {
    private static final BufferedReader a(Reader reader, int n10) {
        boolean bl2 = reader instanceof BufferedReader;
        if (bl2) {
            reader = (BufferedReader)reader;
        } else {
            BufferedReader bufferedReader = new BufferedReader(reader, n10);
            reader = bufferedReader;
        }
        return reader;
    }

    private static final BufferedWriter b(Writer writer, int n10) {
        boolean bl2 = writer instanceof BufferedWriter;
        if (bl2) {
            writer = (BufferedWriter)writer;
        } else {
            BufferedWriter bufferedWriter = new BufferedWriter(writer, n10);
            writer = bufferedWriter;
        }
        return writer;
    }

    public static /* synthetic */ BufferedReader c(Reader reader, int n10, int n11, Object object) {
        if ((n11 &= 1) != 0) {
            n10 = 8192;
        }
        if ((n11 = reader instanceof BufferedReader) != 0) {
            reader = (BufferedReader)reader;
        } else {
            BufferedReader bufferedReader = new BufferedReader(reader, n10);
            reader = bufferedReader;
        }
        return reader;
    }

    public static /* synthetic */ BufferedWriter d(Writer writer, int n10, int n11, Object object) {
        if ((n11 &= 1) != 0) {
            n10 = 8192;
        }
        if ((n11 = writer instanceof BufferedWriter) != 0) {
            writer = (BufferedWriter)writer;
        } else {
            BufferedWriter bufferedWriter = new BufferedWriter(writer, n10);
            writer = bufferedWriter;
        }
        return writer;
    }

    public static final long e(Reader reader, Writer writer, int n10) {
        f0.p(reader, "$this$copyTo");
        String string2 = "out";
        f0.p(writer, string2);
        char[] cArray = new char[n10];
        int n11 = reader.read(cArray);
        long l10 = 0L;
        while (n11 >= 0) {
            writer.write(cArray, 0, n11);
            long l11 = n11;
            l10 += l11;
            n11 = reader.read(cArray);
        }
        return l10;
    }

    public static /* synthetic */ long f(Reader reader, Writer writer, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 8192;
        }
        return TextStreamsKt.e(reader, writer, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final void g(Reader object, l object2) {
        f0.p(object, "$this$forEachLine");
        Object object3 = "action";
        f0.p(object2, (String)object3);
        boolean bl2 = object instanceof BufferedReader;
        if (bl2) {
            object = (BufferedReader)object;
        } else {
            int n10 = 8192;
            object = object3 = new BufferedReader((Reader)object, n10);
        }
        bl2 = false;
        object3 = null;
        try {
            boolean bl3;
            Object object4 = TextStreamsKt.h((BufferedReader)object);
            object4 = object4.iterator();
            while (bl3 = object4.hasNext()) {
                Object e10 = object4.next();
                object2.invoke(e10);
            }
            object2 = q1.a;
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
    }

    public static final m h(BufferedReader bufferedReader) {
        f0.p(bufferedReader, "$this$lineSequence");
        n n10 = new n(bufferedReader);
        return SequencesKt__SequencesKt.i(n10);
    }

    public static final byte[] i(URL object) {
        f0.p(object, "$this$readBytes");
        object = FirebasePerfUrlConnection.openStream((URL)object);
        Object object2 = "it";
        try {
            f0.o(object, (String)object2);
            object2 = a.p((InputStream)object);
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

    public static final List j(Reader reader) {
        f0.p(reader, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        TextStreamsKt$readLines$1 textStreamsKt$readLines$1 = new TextStreamsKt$readLines$1(arrayList);
        TextStreamsKt.g(reader, textStreamsKt$readLines$1);
        return arrayList;
    }

    public static final String k(Reader object) {
        f0.p(object, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        TextStreamsKt.f((Reader)object, stringWriter, 0, 2, null);
        object = stringWriter.toString();
        f0.o(object, "buffer.toString()");
        return object;
    }

    private static final String l(URL object, Charset charset) {
        object = TextStreamsKt.i((URL)object);
        String string2 = new String((byte[])object, charset);
        return string2;
    }

    public static /* synthetic */ String m(URL object, Charset charset, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        object = TextStreamsKt.i((URL)object);
        String string2 = new String((byte[])object, charset);
        return string2;
    }

    private static final StringReader n(String string2) {
        StringReader stringReader = new StringReader(string2);
        return stringReader;
    }

    /*
     * Unable to fully structure code
     */
    public static final Object o(Reader var0, l var1_1) {
        f0.p(var0, "$this$useLines");
        var2_3 = "block";
        f0.p(var1_1, (String)var2_3);
        var3_5 = var0 instanceof BufferedReader;
        if (var3_5) {
            var0 = (BufferedReader)var0;
        } else {
            var4_6 = 8192;
            var0 = var2_3 = new BufferedReader((Reader)var0, var4_6);
        }
        var3_5 = false;
        var2_3 = null;
        var4_6 = 0;
        var5_7 = 1;
        try {
            var6_8 = TextStreamsKt.h((BufferedReader)var0);
        }
        catch (Throwable var1_2) {
            try {
                throw var1_2;
            }
            catch (Throwable var2_4) {
                c0.d(var5_7);
                var4_6 = (int)f.d2.l.a(var5_7, var5_7, 0);
                if (var4_6 == 0) {
                    var0.close();
                } else {
                    b.a((Closeable)var0, var1_2);
                }
lbl27:
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
        var1_1 = var1_1.invoke(var6_8);
        c0.d(var5_7);
        var4_6 = (int)f.d2.l.a(var5_7, var5_7, 0);
        if (var4_6 != 0) {
            b.a((Closeable)var0, null);
        } else {
            var0.close();
        }
        c0.c(var5_7);
        return var1_1;
    }
}

