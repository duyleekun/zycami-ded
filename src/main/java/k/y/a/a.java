/*
 * Decompiled with CFR 0.151.
 */
package k.y.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import k.h;
import k.h$a;
import k.s;
import k.y.a.b;
import k.y.a.c;

public final class a
extends h$a {
    private final Gson a;

    private a(Gson gson) {
        this.a = gson;
    }

    public static a a() {
        Gson gson = new Gson();
        return k.y.a.a.b(gson);
    }

    public static a b(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        a a10 = new a(gson);
        return a10;
    }

    public h requestBodyConverter(Type object, Annotation[] object2, Annotation[] object3, s s10) {
        object2 = this.a;
        object = TypeToken.get((Type)object);
        object = ((Gson)object2).getAdapter((TypeToken)object);
        object3 = this.a;
        object2 = new b((Gson)object3, (TypeAdapter)object);
        return object2;
    }

    public h responseBodyConverter(Type object, Annotation[] object2, s object3) {
        object2 = this.a;
        object = TypeToken.get((Type)object);
        object = ((Gson)object2).getAdapter((TypeToken)object);
        object3 = this.a;
        object2 = new c((Gson)object3, (TypeAdapter)object);
        return object2;
    }
}

