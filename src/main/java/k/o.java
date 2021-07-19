/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import k.e$a;
import k.g;
import k.i;
import k.m;
import k.o$a;

public class o {
    private static final o c = o.f();
    private final boolean a;
    private final Constructor b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public o(boolean bl2) {
        this.a = bl2;
        Constructor constructor = null;
        if (bl2) {
            Class<MethodHandles.Lookup> clazz = MethodHandles.Lookup.class;
            int n10 = 2;
            try {
                Class<Class> clazz2;
                Class[] classArray = new Class[n10];
                Class<Integer> clazz3 = null;
                classArray[0] = clazz2 = Class.class;
                clazz3 = Integer.TYPE;
                boolean bl3 = true;
                classArray[bl3] = clazz3;
                constructor = clazz.getDeclaredConstructor(classArray);
                constructor.setAccessible(bl3);
            }
            catch (NoClassDefFoundError | NoSuchMethodException throwable) {}
        }
        this.b = constructor;
    }

    private static o f() {
        String string2 = "Dalvik";
        Object object = System.getProperty("java.vm.name");
        boolean bl2 = string2.equals(object);
        if (bl2) {
            object = new o$a();
        } else {
            boolean bl3 = true;
            object = new o(bl3);
        }
        return object;
    }

    public static o g() {
        return c;
    }

    public List a(Executor object) {
        i i10 = new i((Executor)object);
        int n10 = this.a;
        if (n10 != 0) {
            e$a e$a;
            n10 = 2;
            object = new e$a[n10];
            object[0] = e$a = g.a;
            int n11 = 1;
            object[n11] = i10;
            object = Arrays.asList(object);
        } else {
            object = Collections.singletonList(i10);
        }
        return object;
    }

    public int b() {
        int n10 = this.a;
        n10 = n10 != 0 ? 2 : 1;
        return n10;
    }

    public Executor c() {
        return null;
    }

    public List d() {
        boolean bl2 = this.a;
        List<Object> list = bl2 ? Collections.singletonList(m.a) : Collections.emptyList();
        return list;
    }

    public int e() {
        return (int)(this.a ? 1 : 0);
    }

    public Object h(Method method, Class clazz, Object object, Object ... objectArray) {
        Object object2 = this.b;
        if (object2 != null) {
            int n10 = 2;
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = clazz;
            int n11 = 1;
            int n12 = -1;
            Integer n13 = n12;
            objectArray2[n11] = n13;
            object2 = (MethodHandles.Lookup)((Constructor)object2).newInstance(objectArray2);
        } else {
            object2 = MethodHandles.lookup();
        }
        return ((MethodHandles.Lookup)object2).unreflectSpecial(method, clazz).bindTo(object).invokeWithArguments(objectArray);
    }

    public boolean i(Method method) {
        boolean bl2;
        boolean bl3 = this.a;
        if (bl3 && (bl2 = method.isDefault())) {
            bl2 = true;
        } else {
            bl2 = false;
            method = null;
        }
        return bl2;
    }
}

