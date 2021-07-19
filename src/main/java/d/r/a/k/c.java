/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.k;

import android.content.Context;
import d.r.a.k.e;
import d.r.a.u.d0;
import d.r.a.u.s;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public final class c {
    private static volatile c b;
    private e a;

    private c() {
    }

    public static c a() {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            c c10 = b;
            if (c10 == null) {
                b = c10 = new c();
            }
            c10 = b;
            return c10;
        }
    }

    public final e b(Context object) {
        Object object2;
        String string2 = "ConfigManagerFactory";
        e e10 = this.a;
        if (e10 != null) {
            return e10;
        }
        e10 = null;
        try {
            boolean bl2 = d0.g(object);
            object2 = bl2 ? "com.vivo.push.cache.ServerConfigManagerImpl" : "com.vivo.push.cache.ClientConfigManagerImpl";
        }
        catch (Exception exception) {
            exception.printStackTrace();
            s.i(string2, "createConfig error", exception);
            return null;
        }
        GenericDeclaration genericDeclaration = Class.forName((String)object2);
        CharSequence charSequence = "getInstance";
        int n10 = 1;
        Object object3 = new Class[n10];
        Class<Context> clazz = Context.class;
        object3[0] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)charSequence, (Class<?>)object3);
        object3 = "createConfig success is ";
        charSequence = new StringBuilder((String)object3);
        ((StringBuilder)charSequence).append((String)object2);
        object2 = ((StringBuilder)charSequence).toString();
        s.m(string2, (String)object2);
        object2 = new Object[n10];
        object2[0] = object;
        object = ((Method)genericDeclaration).invoke(null, object2);
        object = (e)object;
        this.a = object;
        return object;
    }
}

