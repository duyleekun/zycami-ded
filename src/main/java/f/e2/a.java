/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.a$a;
import f.h2.t.f0;
import f.q2.d;
import f.x1.q;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class a {
    private static final BufferedInputStream a(InputStream inputStream, int n10) {
        boolean bl2 = inputStream instanceof BufferedInputStream;
        if (bl2) {
            inputStream = (BufferedInputStream)inputStream;
        } else {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, n10);
            inputStream = bufferedInputStream;
        }
        return inputStream;
    }

    private static final BufferedOutputStream b(OutputStream outputStream, int n10) {
        boolean bl2 = outputStream instanceof BufferedOutputStream;
        if (bl2) {
            outputStream = (BufferedOutputStream)outputStream;
        } else {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, n10);
            outputStream = bufferedOutputStream;
        }
        return outputStream;
    }

    public static /* synthetic */ BufferedInputStream c(InputStream inputStream, int n10, int n11, Object object) {
        if ((n11 &= 1) != 0) {
            n10 = 8192;
        }
        if ((n11 = inputStream instanceof BufferedInputStream) != 0) {
            inputStream = (BufferedInputStream)inputStream;
        } else {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, n10);
            inputStream = bufferedInputStream;
        }
        return inputStream;
    }

    public static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int n10, int n11, Object object) {
        if ((n11 &= 1) != 0) {
            n10 = 8192;
        }
        if ((n11 = outputStream instanceof BufferedOutputStream) != 0) {
            outputStream = (BufferedOutputStream)outputStream;
        } else {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream, n10);
            outputStream = bufferedOutputStream;
        }
        return outputStream;
    }

    private static final BufferedReader e(InputStream closeable, Charset charset) {
        Closeable closeable2 = new InputStreamReader((InputStream)closeable, charset);
        boolean bl2 = closeable2 instanceof BufferedReader;
        if (bl2) {
            closeable2 = (BufferedReader)closeable2;
        } else {
            int n10 = 8192;
            closeable = new BufferedReader((Reader)closeable2, n10);
            closeable2 = closeable;
        }
        return closeable2;
    }

    public static /* synthetic */ BufferedReader f(InputStream inputStream, Charset object, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            object = d.a;
        }
        Object object3 = new InputStreamReader(inputStream, (Charset)object);
        int n11 = 8192;
        boolean bl2 = object3 instanceof BufferedReader;
        object3 = bl2 ? (BufferedReader)object3 : (object = new BufferedReader((Reader)object3, n11));
        return object3;
    }

    private static final BufferedWriter g(OutputStream closeable, Charset charset) {
        Closeable closeable2 = new OutputStreamWriter((OutputStream)closeable, charset);
        boolean bl2 = closeable2 instanceof BufferedWriter;
        if (bl2) {
            closeable2 = (BufferedWriter)closeable2;
        } else {
            int n10 = 8192;
            closeable = new BufferedWriter((Writer)closeable2, n10);
            closeable2 = closeable;
        }
        return closeable2;
    }

    public static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset object, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            object = d.a;
        }
        Object object3 = new OutputStreamWriter(outputStream, (Charset)object);
        int n11 = 8192;
        boolean bl2 = object3 instanceof BufferedWriter;
        object3 = bl2 ? (BufferedWriter)object3 : (object = new BufferedWriter((Writer)object3, n11));
        return object3;
    }

    private static final ByteArrayInputStream i(String object, Charset charset) {
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        return byteArrayInputStream;
    }

    public static /* synthetic */ ByteArrayInputStream j(String object, Charset charset, int n10, Object object2) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.String");
        object = ((String)object).getBytes(charset);
        f0.o(object, "(this as java.lang.String).getBytes(charset)");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        return byteArrayInputStream;
    }

    public static final long k(InputStream inputStream, OutputStream outputStream, int n10) {
        f0.p(inputStream, "$this$copyTo");
        String string2 = "out";
        f0.p(outputStream, string2);
        byte[] byArray = new byte[n10];
        int n11 = inputStream.read(byArray);
        long l10 = 0L;
        while (n11 >= 0) {
            outputStream.write(byArray, 0, n11);
            long l11 = n11;
            l10 += l11;
            n11 = inputStream.read(byArray);
        }
        return l10;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 8192;
        }
        return a.k(inputStream, outputStream, n10);
    }

    private static final ByteArrayInputStream m(byte[] byArray) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }

    private static final ByteArrayInputStream n(byte[] byArray, int n10, int n11) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray, n10, n11);
        return byteArrayInputStream;
    }

    public static final q o(BufferedInputStream bufferedInputStream) {
        f0.p(bufferedInputStream, "$this$iterator");
        a$a a$a = new a$a(bufferedInputStream);
        return a$a;
    }

    public static final byte[] p(InputStream object) {
        f0.p(object, "$this$readBytes");
        int n10 = ((InputStream)object).available();
        n10 = Math.max(8192, n10);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n10);
        a.l((InputStream)object, byteArrayOutputStream, 0, 2, null);
        object = byteArrayOutputStream.toByteArray();
        f0.o(object, "buffer.toByteArray()");
        return object;
    }

    public static final byte[] q(InputStream object, int n10) {
        f0.p(object, "$this$readBytes");
        int n11 = ((InputStream)object).available();
        n10 = Math.max(n10, n11);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n10);
        a.l((InputStream)object, byteArrayOutputStream, 0, 2, null);
        object = byteArrayOutputStream.toByteArray();
        f0.o(object, "buffer.toByteArray()");
        return object;
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int n10, int n11, Object object) {
        if ((n11 &= 1) != 0) {
            n10 = 8192;
        }
        return a.q(inputStream, n10);
    }

    private static final InputStreamReader s(InputStream inputStream, Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader;
    }

    public static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader;
    }

    private static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter;
    }

    public static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            charset = d.a;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter;
    }
}

