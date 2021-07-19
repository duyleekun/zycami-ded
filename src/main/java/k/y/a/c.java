/*
 * Decompiled with CFR 0.151.
 */
package k.y.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import g.d0;
import java.io.Reader;
import k.h;

public final class c
implements h {
    private final Gson a;
    private final TypeAdapter b;

    public c(Gson gson, TypeAdapter typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    public Object a(d0 d02) {
        Object object = this.a;
        Object object2 = d02.charStream();
        object = ((Gson)object).newJsonReader((Reader)object2);
        try {
            object2 = this.b;
        }
        catch (Throwable throwable) {
            d02.close();
            throw throwable;
        }
        object2 = ((TypeAdapter)object2).read((JsonReader)object);
        object = ((JsonReader)object).peek();
        JsonToken jsonToken = JsonToken.END_DOCUMENT;
        if (object == jsonToken) {
            d02.close();
            return object2;
        }
        object2 = "JSON document was not fully consumed.";
        object = new JsonIOException((String)object2);
        throw object;
    }
}

