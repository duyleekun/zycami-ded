/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.engine.GlideException;
import d.c.a.o.f;
import d.c.a.o.j.e;
import d.c.a.o.k.g;
import d.c.a.o.k.g$a;
import d.c.a.o.k.s;
import d.c.a.u.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class q {
    private final Class a;
    private final Pools$Pool b;
    private final List c;
    private final String d;

    public q(Class object, Class object2, Class clazz, List object3, Pools$Pool pools$Pool) {
        this.a = object;
        this.b = pools$Pool;
        object3 = (List)k.c((Collection)object3);
        this.c = object3;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Failed LoadPath{");
        object = ((Class)object).getSimpleName();
        ((StringBuilder)object3).append((String)object);
        object = "->";
        ((StringBuilder)object3).append((String)object);
        object2 = ((Class)object2).getSimpleName();
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append((String)object);
        object = clazz.getSimpleName();
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append("}");
        this.d = object = ((StringBuilder)object3).toString();
    }

    private s c(e e10, f f10, int n10, int n11, g$a g$a, List list) {
        q q10 = this;
        List list2 = list;
        int n12 = this.c.size();
        Object object = null;
        Object object2 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object3 = object = q10.c.get(i10);
            object3 = (g)object;
            try {
                object2 = object = ((g)object3).a(e10, n10, n11, f10, g$a);
            }
            catch (GlideException glideException) {
                object3 = glideException;
                list2.add(glideException);
            }
            if (object2 != null) break;
        }
        if (object2 != null) {
            return object2;
        }
        String string2 = q10.d;
        object2 = new ArrayList(list2);
        object = new GlideException(string2, (List)object2);
        throw object;
    }

    public Class a() {
        return this.a;
    }

    public s b(e object, f f10, int n10, int n11, g$a g$a) {
        List list = (List)k.d(this.b.acquire());
        try {
            object = this.c((e)object, f10, n10, n11, g$a, list);
            return object;
        }
        finally {
            this.b.release(list);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LoadPath{decodePaths=");
        String string2 = Arrays.toString(this.c.toArray());
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

