/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import k.c$d;
import k.e;
import k.e$a;
import k.h;
import k.h$a;
import k.o;
import k.s$a;
import k.s$b;
import k.t;

public final class s {
    private final Map a;
    public final g.e$a b;
    public final g.t c;
    public final List d;
    public final List e;
    public final Executor f;
    public final boolean g;

    public s(g.e$a e$a, g.t t10, List list, List list2, Executor executor, boolean bl2) {
        ConcurrentHashMap concurrentHashMap;
        this.a = concurrentHashMap = new ConcurrentHashMap();
        this.b = e$a;
        this.c = t10;
        this.d = list;
        this.e = list2;
        this.f = executor;
        this.g = bl2;
    }

    private void p(Class object) {
        boolean bl2 = ((Class)object).isInterface();
        if (bl2) {
            int n10;
            Object object2;
            int n11 = 1;
            Object object3 = new ArrayDeque(n11);
            object3.add(object);
            while ((n11 = (int)(object3.isEmpty() ? 1 : 0)) == 0) {
                Object object4 = (Class<?>[])object3.removeFirst();
                object2 = object4.getTypeParameters();
                n10 = ((TypeVariable<Class<T>>[])object2).length;
                if (n10 != 0) {
                    object3 = new StringBuilder("Type parameters are unsupported on ");
                    object2 = object4.getName();
                    ((StringBuilder)object3).append((String)object2);
                    if (object4 != object) {
                        object4 = " which is an interface of ";
                        ((StringBuilder)object3).append((String)object4);
                        object = ((Class)object).getName();
                        ((StringBuilder)object3).append((String)object);
                    }
                    object3 = ((StringBuilder)object3).toString();
                    object = new IllegalArgumentException((String)object3);
                    throw object;
                }
                object4 = object4.getInterfaces();
                Collections.addAll(object3, object4);
            }
            bl2 = this.g;
            if (bl2) {
                object3 = o.g();
                object = ((Class)object).getDeclaredMethods();
                n11 = ((Serializable)object).length;
                object2 = null;
                for (n10 = 0; n10 < n11; ++n10) {
                    Serializable serializable = object[n10];
                    boolean bl3 = ((o)object3).i((Method)((Object)serializable));
                    if (bl3 || (bl3 = Modifier.isStatic(((Method)((Object)serializable)).getModifiers()))) continue;
                    this.h((Method)((Object)serializable));
                }
            }
            return;
        }
        object = new IllegalArgumentException("API declarations must be interfaces.");
        throw object;
    }

    public g.t a() {
        return this.c;
    }

    public e b(Type type, Annotation[] annotationArray) {
        return this.j(null, type, annotationArray);
    }

    public List c() {
        return this.e;
    }

    public g.e$a d() {
        return this.b;
    }

    public Executor e() {
        return this.f;
    }

    public List f() {
        return this.d;
    }

    public Object g(Class clazz) {
        this.p(clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] classArray = new Class[]{clazz};
        s$a s$a = new s$a(this, clazz);
        return Proxy.newProxyInstance(classLoader, classArray, (InvocationHandler)s$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public t h(Method method) {
        Object object = (t)this.a.get(method);
        if (object != null) {
            return object;
        }
        object = this.a;
        synchronized (object) {
            Object object2 = this.a;
            object2 = object2.get(method);
            object2 = (t)object2;
            if (object2 == null) {
                object2 = t.b(this, method);
                Map map = this.a;
                map.put(method, object2);
            }
            return object2;
        }
    }

    public s$b i() {
        s$b s$b = new s$b(this);
        return s$b;
    }

    public e j(e$a object, Type object2, Annotation[] annotationArray) {
        int n10;
        Objects.requireNonNull(object2, "returnType == null");
        Objects.requireNonNull(annotationArray, "annotations == null");
        List list = this.e;
        int n11 = list.indexOf(object) + 1;
        Object object3 = this.e;
        int n12 = object3.size();
        for (int i10 = n11; i10 < n12; ++i10) {
            e e10 = ((e$a)this.e.get(i10)).a((Type)object2, annotationArray, this);
            if (e10 == null) continue;
            return e10;
        }
        object3 = "Could not locate call adapter for ";
        annotationArray = new StringBuilder((String)object3);
        annotationArray.append(object2);
        annotationArray.append(".\n");
        object2 = "\n   * ";
        if (object != null) {
            annotationArray.append("  Skipped:");
            object = null;
            for (n10 = 0; n10 < n11; ++n10) {
                annotationArray.append((String)object2);
                object3 = ((e$a)this.e.get(n10)).getClass().getName();
                annotationArray.append((String)object3);
            }
            n10 = 10;
            annotationArray.append((char)n10);
        }
        annotationArray.append("  Tried:");
        object = this.e;
        n10 = object.size();
        while (n11 < n10) {
            annotationArray.append((String)object2);
            object3 = ((e$a)this.e.get(n11)).getClass().getName();
            annotationArray.append((String)object3);
            ++n11;
        }
        object2 = annotationArray.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public h k(h$a object, Type object2, Annotation[] annotationArray, Annotation[] object3) {
        int n10;
        Objects.requireNonNull(object2, "type == null");
        Objects.requireNonNull(annotationArray, "parameterAnnotations == null");
        Objects.requireNonNull(object3, "methodAnnotations == null");
        List list = this.d;
        int n11 = list.indexOf(object) + 1;
        List list2 = this.d;
        int n12 = list2.size();
        for (int i10 = n11; i10 < n12; ++i10) {
            h h10 = ((h$a)this.d.get(i10)).requestBodyConverter((Type)object2, annotationArray, (Annotation[])object3, this);
            if (h10 == null) continue;
            return h10;
        }
        object3 = "Could not locate RequestBody converter for ";
        annotationArray = new StringBuilder((String)object3);
        annotationArray.append(object2);
        annotationArray.append(".\n");
        object2 = "\n   * ";
        if (object != null) {
            annotationArray.append("  Skipped:");
            object = null;
            for (n10 = 0; n10 < n11; ++n10) {
                annotationArray.append((String)object2);
                object3 = ((h$a)this.d.get(n10)).getClass().getName();
                annotationArray.append((String)object3);
            }
            n10 = 10;
            annotationArray.append((char)n10);
        }
        annotationArray.append("  Tried:");
        object = this.d;
        n10 = object.size();
        while (n11 < n10) {
            annotationArray.append((String)object2);
            object3 = ((h$a)this.d.get(n11)).getClass().getName();
            annotationArray.append((String)object3);
            ++n11;
        }
        object2 = annotationArray.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public h l(h$a object, Type object2, Annotation[] annotationArray) {
        int n10;
        Objects.requireNonNull(object2, "type == null");
        Objects.requireNonNull(annotationArray, "annotations == null");
        List list = this.d;
        int n11 = list.indexOf(object) + 1;
        Object object3 = this.d;
        int n12 = object3.size();
        for (int i10 = n11; i10 < n12; ++i10) {
            h h10 = ((h$a)this.d.get(i10)).responseBodyConverter((Type)object2, annotationArray, this);
            if (h10 == null) continue;
            return h10;
        }
        object3 = "Could not locate ResponseBody converter for ";
        annotationArray = new StringBuilder((String)object3);
        annotationArray.append(object2);
        annotationArray.append(".\n");
        object2 = "\n   * ";
        if (object != null) {
            annotationArray.append("  Skipped:");
            object = null;
            for (n10 = 0; n10 < n11; ++n10) {
                annotationArray.append((String)object2);
                object3 = ((h$a)this.d.get(n10)).getClass().getName();
                annotationArray.append((String)object3);
            }
            n10 = 10;
            annotationArray.append((char)n10);
        }
        annotationArray.append("  Tried:");
        object = this.d;
        n10 = object.size();
        while (n11 < n10) {
            annotationArray.append((String)object2);
            object3 = ((h$a)this.d.get(n11)).getClass().getName();
            annotationArray.append((String)object3);
            ++n11;
        }
        object2 = annotationArray.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public h m(Type type, Annotation[] annotationArray, Annotation[] annotationArray2) {
        return this.k(null, type, annotationArray, annotationArray2);
    }

    public h n(Type type, Annotation[] annotationArray) {
        return this.l(null, type, annotationArray);
    }

    public h o(Type type, Annotation[] annotationArray) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArray, "annotations == null");
        List list = this.d;
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            h h10 = ((h$a)this.d.get(i10)).stringConverter(type, annotationArray, this);
            if (h10 == null) continue;
            return h10;
        }
        return c$d.a;
    }
}

