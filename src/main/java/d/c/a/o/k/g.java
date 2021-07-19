/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.o.k;

import android.util.Log;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.engine.GlideException;
import d.c.a.o.f;
import d.c.a.o.k.g$a;
import d.c.a.o.k.s;
import d.c.a.o.m.i.e;
import d.c.a.u.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class g {
    private static final String f = "DecodePath";
    private final Class a;
    private final List b;
    private final e c;
    private final Pools$Pool d;
    private final String e;

    public g(Class object, Class object2, Class clazz, List object3, e e10, Pools$Pool pools$Pool) {
        this.a = object;
        this.b = object3;
        this.c = e10;
        this.d = pools$Pool;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Failed DecodePath{");
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
        this.e = object = ((StringBuilder)object3).toString();
    }

    private s b(d.c.a.o.j.e object, int n10, int n11, f f10) {
        List list = (List)k.d(this.d.acquire());
        try {
            object = this.c((d.c.a.o.j.e)object, n10, n11, f10, list);
            return object;
        }
        finally {
            this.d.release(list);
        }
    }

    private s c(d.c.a.o.j.e object, int n10, int n11, f f10, List list) {
        List list2 = this.b;
        int n12 = list2.size();
        s s10 = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            block10: {
                Object object2 = (d.c.a.o.g)this.b.get(i10);
                Object object3 = object.a();
                boolean bl2 = object2.a(object3, f10);
                if (!bl2) break block10;
                object3 = object.a();
                try {
                    s10 = object2.b(object3, n10, n11, f10);
                    break block10;
                }
                catch (OutOfMemoryError outOfMemoryError) {
                }
                catch (RuntimeException runtimeException) {
                }
                catch (IOException iOException) {
                    // empty catch block
                }
                String string2 = f;
                boolean bl3 = Log.isLoggable((String)string2, (int)2);
                if (bl3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "Failed to decode data for ";
                    stringBuilder.append(string3);
                    stringBuilder.append(object2);
                    object2 = stringBuilder.toString();
                    Log.v((String)string2, (String)object2, (Throwable)object3);
                }
                list.add(object3);
            }
            if (s10 != null) break;
        }
        if (s10 != null) {
            return s10;
        }
        String string4 = this.e;
        ArrayList arrayList = new ArrayList(list);
        object = new GlideException(string4, arrayList);
        throw object;
    }

    public s a(d.c.a.o.j.e object, int n10, int n11, f f10, g$a g$a) {
        object = this.b((d.c.a.o.j.e)object, n10, n11, f10);
        object = g$a.a((s)object);
        return this.c.a((s)object, f10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecodePath{ dataClass=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", decoders=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", transcoder=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

