/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.b0;
import f.h2.t.o0;
import f.m2.d;
import f.m2.g;
import f.m2.h;
import f.m2.i;
import f.m2.k;
import f.m2.l;
import f.m2.m;
import f.m2.o;
import f.m2.p;
import f.m2.q;
import f.m2.r;
import f.m2.s;
import f.m2.t;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KVariance;

public class n0 {
    private static final o0 a;
    public static final String b = " (Kotlin reflection is not available)";
    private static final d[] c;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object = null;
        Object object2 = "kotlin.reflect.jvm.internal.ReflectionFactoryImpl";
        try {
            object2 = Class.forName((String)object2);
            object2 = ((Class)object2).newInstance();
            object = object2 = (o0)object2;
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException exception) {}
        if (object == null) {
            object = new o0();
        }
        a = object;
        c = new d[0];
    }

    public static r A(Class object, t ... object2) {
        o0 o02 = a;
        object = n0.d((Class)object);
        object2 = ArraysKt___ArraysKt.uy(object2);
        return o02.p((g)object, (List)object2, false);
    }

    public static r B(g g10) {
        o0 o02 = a;
        List list = Collections.emptyList();
        return o02.p(g10, list, false);
    }

    public static s C(Object object, String string2, KVariance kVariance, boolean bl2) {
        return a.q(object, string2, kVariance, bl2);
    }

    public static d a(Class clazz) {
        return a.a(clazz);
    }

    public static d b(Class clazz, String string2) {
        return a.b(clazz, string2);
    }

    public static i c(FunctionReference functionReference) {
        return a.c(functionReference);
    }

    public static d d(Class clazz) {
        return a.d(clazz);
    }

    public static d e(Class clazz, String string2) {
        return a.e(clazz, string2);
    }

    public static d[] f(Class[] classArray) {
        int n10 = classArray.length;
        if (n10 == 0) {
            return c;
        }
        d[] dArray = new d[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            d d10;
            dArray[i10] = d10 = n0.d(classArray[i10]);
        }
        return dArray;
    }

    public static h g(Class clazz) {
        return a.f(clazz, "");
    }

    public static h h(Class clazz, String string2) {
        return a.f(clazz, string2);
    }

    public static k i(MutablePropertyReference0 mutablePropertyReference0) {
        return a.g(mutablePropertyReference0);
    }

    public static l j(MutablePropertyReference1 mutablePropertyReference1) {
        return a.h(mutablePropertyReference1);
    }

    public static m k(MutablePropertyReference2 mutablePropertyReference2) {
        return a.i(mutablePropertyReference2);
    }

    public static r l(Class object) {
        o0 o02 = a;
        object = n0.d((Class)object);
        List list = Collections.emptyList();
        return o02.p((g)object, list, true);
    }

    public static r m(Class object, t object2) {
        o0 o02 = a;
        object = n0.d((Class)object);
        object2 = Collections.singletonList(object2);
        return o02.p((g)object, (List)object2, true);
    }

    public static r n(Class object, t t10, t object2) {
        o0 o02 = a;
        object = n0.d((Class)object);
        t[] tArray = new t[2];
        tArray[0] = t10;
        boolean bl2 = true;
        tArray[bl2] = object2;
        object2 = Arrays.asList(tArray);
        return o02.p((g)object, (List)object2, bl2);
    }

    public static r o(Class object, t ... object2) {
        o0 o02 = a;
        object = n0.d((Class)object);
        object2 = ArraysKt___ArraysKt.uy(object2);
        return o02.p((g)object, (List)object2, true);
    }

    public static r p(g g10) {
        o0 o02 = a;
        List list = Collections.emptyList();
        return o02.p(g10, list, true);
    }

    public static o q(PropertyReference0 propertyReference0) {
        return a.j(propertyReference0);
    }

    public static p r(PropertyReference1 propertyReference1) {
        return a.k(propertyReference1);
    }

    public static q s(PropertyReference2 propertyReference2) {
        return a.l(propertyReference2);
    }

    public static String t(b0 b02) {
        return a.m(b02);
    }

    public static String u(Lambda lambda2) {
        return a.n(lambda2);
    }

    public static void v(s s10, r object) {
        o0 o02 = a;
        object = Collections.singletonList(object);
        o02.o(s10, (List)object);
    }

    public static void w(s s10, r ... object) {
        o0 o02 = a;
        object = ArraysKt___ArraysKt.uy(object);
        o02.o(s10, (List)object);
    }

    public static r x(Class object) {
        o0 o02 = a;
        object = n0.d((Class)object);
        List list = Collections.emptyList();
        return o02.p((g)object, list, false);
    }

    public static r y(Class object, t object2) {
        o0 o02 = a;
        object = n0.d((Class)object);
        object2 = Collections.singletonList(object2);
        return o02.p((g)object, (List)object2, false);
    }

    public static r z(Class object, t object2, t t10) {
        o0 o02 = a;
        object = n0.d((Class)object);
        t[] tArray = new t[]{object2, t10};
        object2 = Arrays.asList(tArray);
        return o02.p((g)object, (List)object2, false);
    }
}

