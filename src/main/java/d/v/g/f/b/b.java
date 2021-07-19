/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d.v.g.f.b.b$a;
import java.lang.reflect.Type;
import java.util.List;

public class b {
    private final Gson a;

    public b() {
        Gson gson;
        this.a = gson = new Gson();
    }

    public String a(List list) {
        return this.a.toJson(list);
    }

    public List b(String string2) {
        Object object = new b$a(this);
        object = ((TypeToken)object).getType();
        return (List)this.a.fromJson(string2, (Type)object);
    }
}

