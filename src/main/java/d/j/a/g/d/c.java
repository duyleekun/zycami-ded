/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package d.j.a.g.d;

import android.content.Context;
import android.util.Log;
import d.j.a.g.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private Map a;
    private Map b;

    public c(List object) {
        boolean bl2;
        Object object2 = new HashMap();
        this.a = object2;
        object2 = new HashMap();
        this.b = object2;
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (b)object.next();
            Map map = this.a;
            Class clazz = ((b)object2).d();
            map.put(clazz, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object a(d.j.a.b b10, b object) {
        String string2;
        String string3 = "ServiceRepository";
        String string4 = "Instantiate service exception ";
        if ((object = ((b)object).e()) == null) {
            return null;
        }
        int n10 = 2;
        try {
            Class<Context> clazz;
            Object object2 = new Class[n10];
            object2[0] = clazz = Context.class;
            Class<d.j.a.b> clazz2 = d.j.a.b.class;
            int n11 = 1;
            object2[n11] = clazz2;
            object2 = c.c((Class)object, (Class[])object2);
            if (object2 != null) {
                object = new Object[n10];
                Context context = b10.a();
                object[0] = context;
                object[n11] = b10;
                return ((Constructor)object2).newInstance((Object[])object);
            }
            Object object3 = new Class[n11];
            object3[0] = object2 = Context.class;
            if ((object3 = c.c((Class)object, (Class[])object3)) != null) {
                object = new Object[n11];
                b10 = b10.a();
                object[0] = b10;
                return ((Constructor)object3).newInstance((Object[])object);
            }
            return ((Class)object).newInstance();
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string4);
            string2 = illegalAccessException.getLocalizedMessage();
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string4);
            string2 = invocationTargetException.getLocalizedMessage();
        }
        catch (InstantiationException instantiationException) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string4);
            string2 = instantiationException.getLocalizedMessage();
        }
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        Log.e((String)string3, (String)string2);
        return null;
    }

    private static Constructor c(Class constructorArray, Class ... classArray) {
        constructorArray = constructorArray.getDeclaredConstructors();
        int n10 = constructorArray.length;
        boolean bl2 = false;
        Class<?> clazz = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Constructor<?> constructor = constructorArray[i10];
            Class<?>[] classArray2 = constructor.getParameterTypes();
            int n12 = classArray2.length;
            if (n12 != (n11 = classArray.length)) continue;
            for (n12 = 0; n12 < (n11 = classArray.length); ++n12) {
                clazz = classArray2[n12];
                Class clazz2 = classArray[n12];
                if (clazz == clazz2) {
                    bl2 = true;
                    continue;
                }
                bl2 = false;
                clazz = null;
            }
            if (!bl2) continue;
            return constructor;
        }
        return null;
    }

    public Object b(d.j.a.b object, Class clazz) {
        boolean bl2;
        Object v10;
        Object object2 = (b)this.a.get(clazz);
        if (object2 == null) {
            return null;
        }
        boolean bl3 = ((b)object2).f();
        if (bl3 && (v10 = this.b.get(clazz)) != null) {
            return v10;
        }
        if ((object = this.a((d.j.a.b)object, (b)object2)) != null && (bl2 = ((b)object2).f())) {
            object2 = this.b;
            object2.put(clazz, object);
        }
        return object;
    }
}

