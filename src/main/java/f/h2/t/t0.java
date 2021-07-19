/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.s.i;
import f.h2.s.j;
import f.h2.s.k;
import f.h2.s.l;
import f.h2.s.m;
import f.h2.s.n;
import f.h2.s.o;
import f.h2.s.q;
import f.h2.s.r;
import f.h2.s.s;
import f.h2.s.t;
import f.h2.s.u;
import f.h2.s.v;
import f.h2.s.w;
import f.h2.t.b0;
import f.h2.t.f0;
import f.h2.t.x0.a;
import f.h2.t.x0.b;
import f.h2.t.x0.c;
import f.h2.t.x0.d;
import f.h2.t.x0.e;
import f.h2.t.x0.f;
import f.h2.t.x0.g;
import f.h2.t.x0.g$a;
import f.h2.t.x0.h;
import f.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class t0 {
    public static int A(Object object) {
        boolean bl2 = object instanceof b0;
        if (bl2) {
            return ((b0)object).getArity();
        }
        bl2 = object instanceof f.h2.s.a;
        if (bl2) {
            return 0;
        }
        bl2 = object instanceof l;
        if (bl2) {
            return 1;
        }
        bl2 = object instanceof f.h2.s.p;
        if (bl2) {
            return 2;
        }
        bl2 = object instanceof q;
        if (bl2) {
            return 3;
        }
        bl2 = object instanceof r;
        if (bl2) {
            return 4;
        }
        bl2 = object instanceof s;
        if (bl2) {
            return 5;
        }
        bl2 = object instanceof t;
        if (bl2) {
            return 6;
        }
        bl2 = object instanceof u;
        if (bl2) {
            return 7;
        }
        bl2 = object instanceof v;
        if (bl2) {
            return 8;
        }
        bl2 = object instanceof w;
        if (bl2) {
            return 9;
        }
        bl2 = object instanceof f.h2.s.b;
        if (bl2) {
            return 10;
        }
        bl2 = object instanceof f.h2.s.c;
        if (bl2) {
            return 11;
        }
        bl2 = object instanceof f.h2.s.d;
        if (bl2) {
            return 12;
        }
        bl2 = object instanceof f.h2.s.e;
        if (bl2) {
            return 13;
        }
        bl2 = object instanceof f.h2.s.f;
        if (bl2) {
            return 14;
        }
        bl2 = object instanceof f.h2.s.g;
        if (bl2) {
            return 15;
        }
        bl2 = object instanceof f.h2.s.h;
        if (bl2) {
            return 16;
        }
        bl2 = object instanceof i;
        if (bl2) {
            return 17;
        }
        bl2 = object instanceof j;
        if (bl2) {
            return 18;
        }
        bl2 = object instanceof k;
        if (bl2) {
            return 19;
        }
        bl2 = object instanceof m;
        if (bl2) {
            return 20;
        }
        bl2 = object instanceof n;
        if (bl2) {
            return 21;
        }
        boolean bl3 = object instanceof o;
        if (bl3) {
            return 22;
        }
        return -1;
    }

    public static boolean B(Object object, int n10) {
        int n11;
        boolean bl2 = object instanceof p;
        if (bl2 && (n11 = t0.A(object)) == n10) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11;
    }

    public static boolean C(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Collection;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof b))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean D(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Iterable;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof c))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean E(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Iterator;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof d))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean F(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof List;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof e))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean G(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof ListIterator;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof f))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean H(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Map;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof g))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean I(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Map.Entry;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof g.a))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean J(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Set;
        if (bl3 && (!(bl3 = object instanceof a) || (bl2 = object instanceof h))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static Throwable K(Throwable throwable) {
        String string2 = t0.class.getName();
        return f0.B(throwable, string2);
    }

    public static ClassCastException L(ClassCastException classCastException) {
        throw (ClassCastException)t0.K(classCastException);
    }

    public static void M(Object object, String string2) {
        object = object == null ? "null" : object.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" cannot be cast to ");
        stringBuilder.append(string2);
        t0.N(stringBuilder.toString());
    }

    public static void N(String string2) {
        ClassCastException classCastException = new ClassCastException(string2);
        throw t0.L(classCastException);
    }

    public static Collection a(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof b)) {
            String string2 = "kotlin.collections.MutableCollection";
            t0.M(object, string2);
        }
        return t0.s(object);
    }

    public static Collection b(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof b)) {
            t0.N(string2);
        }
        return t0.s(object);
    }

    public static Iterable c(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof c)) {
            String string2 = "kotlin.collections.MutableIterable";
            t0.M(object, string2);
        }
        return t0.t(object);
    }

    public static Iterable d(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof c)) {
            t0.N(string2);
        }
        return t0.t(object);
    }

    public static Iterator e(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof d)) {
            String string2 = "kotlin.collections.MutableIterator";
            t0.M(object, string2);
        }
        return t0.u(object);
    }

    public static Iterator f(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof d)) {
            t0.N(string2);
        }
        return t0.u(object);
    }

    public static List g(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof e)) {
            String string2 = "kotlin.collections.MutableList";
            t0.M(object, string2);
        }
        return t0.v(object);
    }

    public static List h(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof e)) {
            t0.N(string2);
        }
        return t0.v(object);
    }

    public static ListIterator i(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof f)) {
            String string2 = "kotlin.collections.MutableListIterator";
            t0.M(object, string2);
        }
        return t0.w(object);
    }

    public static ListIterator j(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof f)) {
            t0.N(string2);
        }
        return t0.w(object);
    }

    public static Map k(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof g)) {
            String string2 = "kotlin.collections.MutableMap";
            t0.M(object, string2);
        }
        return t0.x(object);
    }

    public static Map l(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof g)) {
            t0.N(string2);
        }
        return t0.x(object);
    }

    public static Map.Entry m(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof g.a)) {
            String string2 = "kotlin.collections.MutableMap.MutableEntry";
            t0.M(object, string2);
        }
        return t0.y(object);
    }

    public static Map.Entry n(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof g.a)) {
            t0.N(string2);
        }
        return t0.y(object);
    }

    public static Set o(Object object) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof h)) {
            String string2 = "kotlin.collections.MutableSet";
            t0.M(object, string2);
        }
        return t0.z(object);
    }

    public static Set p(Object object, String string2) {
        boolean bl2 = object instanceof a;
        if (bl2 && !(bl2 = object instanceof h)) {
            t0.N(string2);
        }
        return t0.z(object);
    }

    public static Object q(Object object, int n10) {
        boolean bl2;
        if (object != null && !(bl2 = t0.B(object, n10))) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "kotlin.jvm.functions.Function";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            t0.M(object, string3);
        }
        return object;
    }

    public static Object r(Object object, int n10, String string2) {
        if (object != null && (n10 = (int)(t0.B(object, n10) ? 1 : 0)) == 0) {
            t0.N(string2);
        }
        return object;
    }

    public static Collection s(Object object) {
        try {
            return (Collection)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static Iterable t(Object object) {
        try {
            return (Iterable)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static Iterator u(Object object) {
        try {
            return (Iterator)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static List v(Object object) {
        try {
            return (List)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static ListIterator w(Object object) {
        try {
            return (ListIterator)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static Map x(Object object) {
        try {
            return (Map)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static Map.Entry y(Object object) {
        try {
            return (Map.Entry)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }

    public static Set z(Object object) {
        try {
            return (Set)object;
        }
        catch (ClassCastException classCastException) {
            throw t0.L(classCastException);
        }
    }
}

