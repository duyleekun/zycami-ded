/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.e2.b;
import f.h2.s.l;
import f.h2.t.c0;
import g.d0$a;
import g.d0$b;
import g.h0.d;
import g.v;
import h.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import okio.ByteString;

public abstract class d0
implements Closeable {
    public static final d0$b Companion;
    private Reader reader;

    static {
        d0$b d0$b;
        Companion = d0$b = new d0$b(null);
    }

    private final Charset charset() {
        Charset charset;
        Object object = this.contentType();
        if (object == null || (object = ((v)object).f(charset = f.q2.d.a)) == null) {
            object = f.q2.d.a;
        }
        return object;
    }

    private final Object consumeSource(l object, l object2) {
        long l10;
        long l11 = this.contentLength();
        long l12 = l11 - (l10 = (long)(-1 >>> 1));
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 <= 0) {
            long l13;
            Object object4 = this.source();
            int n10 = 1;
            try {
                object = object.invoke(object4);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    c0.d(n10);
                    b.a((Closeable)object4, throwable);
                    c0.c(n10);
                    throw throwable2;
                }
            }
            c0.d(n10);
            b.a((Closeable)object4, null);
            c0.c(n10);
            object2 = (Number)object2.invoke(object);
            int n11 = ((Number)object2).intValue();
            l10 = -1;
            object3 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object3 != false && (object3 = (l13 = l11 - (l10 = (long)n11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Content-Length (");
                ((StringBuilder)object4).append(l11);
                ((StringBuilder)object4).append(") and stream length (");
                ((StringBuilder)object4).append(n11);
                ((StringBuilder)object4).append(") disagree");
                object2 = ((StringBuilder)object4).toString();
                object = new IOException((String)object2);
                throw object;
            }
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Cannot buffer entire body for content length: ");
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        object = new IOException((String)object2);
        throw object;
    }

    public static final d0 create(v v10, long l10, o o10) {
        return Companion.b(v10, l10, o10);
    }

    public static final d0 create(v v10, String string2) {
        return Companion.c(v10, string2);
    }

    public static final d0 create(v v10, ByteString byteString) {
        return Companion.d(v10, byteString);
    }

    public static final d0 create(v v10, byte[] byArray) {
        return Companion.e(v10, byArray);
    }

    public static final d0 create(o o10, v v10, long l10) {
        return Companion.f(o10, v10, l10);
    }

    public static final d0 create(String string2, v v10) {
        return Companion.a(string2, v10);
    }

    public static final d0 create(ByteString byteString, v v10) {
        return Companion.g(byteString, v10);
    }

    public static final d0 create(byte[] byArray, v v10) {
        return Companion.h(byArray, v10);
    }

    public final InputStream byteStream() {
        return this.source().l0();
    }

    public final ByteString byteString() {
        long l10;
        long l11 = this.contentLength();
        long l12 = l11 - (l10 = (long)(-1 >>> 1));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            long l13;
            Comparable comparable;
            o o10 = this.source();
            boolean bl2 = false;
            IOException iOException = null;
            try {
                comparable = o10.b0();
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    b.a(o10, throwable);
                    throw throwable2;
                }
            }
            b.a(o10, null);
            object = ((ByteString)comparable).size();
            long l14 = -1;
            bl2 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
            if (bl2 && (bl2 = (l13 = l11 - (l14 = (long)object)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
                comparable = new StringBuilder();
                ((StringBuilder)comparable).append("Content-Length (");
                ((StringBuilder)comparable).append(l11);
                ((StringBuilder)comparable).append(") and stream length (");
                ((StringBuilder)comparable).append((int)object);
                ((StringBuilder)comparable).append(") disagree");
                String string2 = ((StringBuilder)comparable).toString();
                iOException = new IOException(string2);
                throw iOException;
            }
            return comparable;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot buffer entire body for content length: ");
        stringBuilder.append(l11);
        String string3 = stringBuilder.toString();
        IOException iOException = new IOException(string3);
        throw iOException;
    }

    public final byte[] bytes() {
        long l10;
        long l11 = this.contentLength();
        long l12 = l11 - (l10 = (long)(-1 >>> 1));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            long l13;
            Object object2;
            o o10 = this.source();
            boolean bl2 = false;
            IOException iOException = null;
            try {
                object2 = o10.T();
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    b.a(o10, throwable);
                    throw throwable2;
                }
            }
            b.a(o10, null);
            object = ((byte[])object2).length;
            long l14 = -1;
            bl2 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
            if (bl2 && (bl2 = (l13 = l11 - (l14 = (long)object)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) {
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append("Content-Length (");
                ((StringBuilder)object2).append(l11);
                ((StringBuilder)object2).append(") and stream length (");
                ((StringBuilder)object2).append((int)object);
                ((StringBuilder)object2).append(") disagree");
                String string2 = ((StringBuilder)object2).toString();
                iOException = new IOException(string2);
                throw iOException;
            }
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot buffer entire body for content length: ");
        stringBuilder.append(l11);
        String string3 = stringBuilder.toString();
        IOException iOException = new IOException(string3);
        throw iOException;
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            o o10 = this.source();
            Charset charset = this.charset();
            this.reader = reader = new d0$a(o10, charset);
        }
        return reader;
    }

    public void close() {
        d.l(this.source());
    }

    public abstract long contentLength();

    public abstract v contentType();

    public abstract o source();

    public final String string() {
        Object object;
        o o10 = this.source();
        try {
            object = this.charset();
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                b.a(o10, throwable);
                throw throwable2;
            }
        }
        object = d.P(o10, (Charset)object);
        object = o10.Y((Charset)object);
        b.a(o10, null);
        return object;
    }
}

