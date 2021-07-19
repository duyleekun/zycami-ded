/*
 * Decompiled with CFR 0.151.
 */
package k.y.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import g.b0;
import g.v;
import h.m;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import k.h;
import okio.ByteString;

public final class b
implements h {
    private static final v c = v.h("application/json; charset=UTF-8");
    private static final Charset d = Charset.forName("UTF-8");
    private final Gson a;
    private final TypeAdapter b;

    public b(Gson gson, TypeAdapter typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    public b0 a(Object object) {
        Object object2 = new m();
        OutputStream outputStream = ((m)object2).j0();
        Charset charset = d;
        Closeable closeable = new OutputStreamWriter(outputStream, charset);
        closeable = this.a.newJsonWriter((Writer)closeable);
        this.b.write((JsonWriter)closeable, object);
        ((JsonWriter)closeable).close();
        object = c;
        object2 = ((m)object2).b0();
        return b0.create((v)object, (ByteString)object2);
    }
}

