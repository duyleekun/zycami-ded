/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.a;
import f.h2.s.b;
import f.h2.s.c;
import f.h2.s.e;
import f.h2.s.f;
import f.h2.s.g;
import f.h2.s.h;
import f.h2.s.i;
import f.h2.s.j;
import f.h2.s.k;
import f.h2.s.l;
import f.h2.s.m;
import f.h2.s.n;
import f.h2.s.o;
import f.h2.s.p;
import f.h2.s.q;
import f.h2.s.t;
import f.h2.s.u;
import f.h2.s.v;
import f.h2.s.w;
import f.h2.t.f0;
import f.h2.t.r;
import f.h2.t.s$a;
import f.m2.d;
import f.w0;
import f.x1.s0;
import f.x1.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;

public final class s
implements d,
r {
    private static final Map b;
    private static final HashMap c;
    private static final HashMap d;
    private static final HashMap e;
    private static final Map f;
    public static final s$a g;
    private final Class a;

    static {
        Object object = new s$a(null);
        g = object;
        int n10 = 23;
        object = new Class[n10];
        int n11 = 0;
        Object object2 = null;
        object[0] = f.h2.s.a.class;
        object[1] = l.class;
        int n12 = 2;
        object[n12] = p.class;
        object[3] = q.class;
        object[4] = f.h2.s.r.class;
        object[5] = f.h2.s.s.class;
        object[6] = t.class;
        object[7] = u.class;
        object[8] = v.class;
        Object object3 = w.class;
        object[9] = object3;
        char c10 = '\n';
        object[c10] = b.class;
        object[11] = c.class;
        object[12] = f.h2.s.d.class;
        object[13] = e.class;
        object[14] = f.class;
        object[15] = g.class;
        object[16] = h.class;
        object[17] = i.class;
        object[18] = j.class;
        object[19] = k.class;
        object[20] = m.class;
        object[21] = n.class;
        int n13 = 22;
        Object object4 = o.class;
        object[n13] = object4;
        object = CollectionsKt__CollectionsKt.L((Object[])object);
        c10 = f.x1.u.Y((Iterable)object, c10);
        Object object5 = new ArrayList(c10);
        object = object.iterator();
        while ((c10 = (char)(object.hasNext() ? 1 : 0)) != '\u0000') {
            object3 = object.next();
            int n14 = n11 + 1;
            if (n11 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            object2 = n11;
            object2 = w0.a(object3, object2);
            object5.add(object2);
            n11 = n14;
        }
        b = t0.B0(object5);
        object = new HashMap();
        object2 = "kotlin.Boolean";
        ((HashMap)object).put("boolean", object2);
        object3 = "kotlin.Char";
        ((HashMap)object).put("char", object3);
        object4 = "kotlin.Byte";
        ((HashMap)object).put("byte", object4);
        CharSequence charSequence = "kotlin.Short";
        ((HashMap)object).put("short", charSequence);
        String string2 = "kotlin.Int";
        ((HashMap)object).put("int", string2);
        String string3 = "kotlin.Float";
        ((HashMap)object).put("float", string3);
        String string4 = "kotlin.Long";
        ((HashMap)object).put("long", string4);
        String string5 = "kotlin.Double";
        ((HashMap)object).put("double", string5);
        c = object;
        object5 = new HashMap();
        String string6 = "java.lang.Boolean";
        ((HashMap)object5).put(string6, object2);
        ((HashMap)object5).put("java.lang.Character", object3);
        ((HashMap)object5).put("java.lang.Byte", object4);
        ((HashMap)object5).put("java.lang.Short", charSequence);
        ((HashMap)object5).put("java.lang.Integer", string2);
        ((HashMap)object5).put("java.lang.Float", string3);
        ((HashMap)object5).put("java.lang.Long", string4);
        ((HashMap)object5).put("java.lang.Double", string5);
        d = object5;
        object2 = new HashMap();
        ((HashMap)object2).put("java.lang.Object", "kotlin.Any");
        ((HashMap)object2).put("java.lang.String", "kotlin.String");
        ((HashMap)object2).put("java.lang.CharSequence", "kotlin.CharSequence");
        ((HashMap)object2).put("java.lang.Throwable", "kotlin.Throwable");
        ((HashMap)object2).put("java.lang.Cloneable", "kotlin.Cloneable");
        ((HashMap)object2).put("java.lang.Number", "kotlin.Number");
        ((HashMap)object2).put("java.lang.Comparable", "kotlin.Comparable");
        ((HashMap)object2).put("java.lang.Enum", "kotlin.Enum");
        ((HashMap)object2).put("java.lang.annotation.Annotation", "kotlin.Annotation");
        ((HashMap)object2).put("java.lang.Iterable", "kotlin.collections.Iterable");
        ((HashMap)object2).put("java.util.Iterator", "kotlin.collections.Iterator");
        ((HashMap)object2).put("java.util.Collection", "kotlin.collections.Collection");
        ((HashMap)object2).put("java.util.List", "kotlin.collections.List");
        ((HashMap)object2).put("java.util.Set", "kotlin.collections.Set");
        ((HashMap)object2).put("java.util.ListIterator", "kotlin.collections.ListIterator");
        ((HashMap)object2).put("java.util.Map", "kotlin.collections.Map");
        ((HashMap)object2).put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        ((HashMap)object2).put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        object3 = "kotlin.jvm.internal.EnumCompanionObject";
        object4 = "kotlin.Enum.Companion";
        ((HashMap)object2).put(object3, object4);
        ((HashMap)object2).putAll(object);
        ((HashMap)object2).putAll(object5);
        object = ((HashMap)object).values();
        object5 = "primitiveFqNames.values";
        f0.o(object, (String)object5);
        object = object.iterator();
        while (true) {
            n13 = (int)(object.hasNext() ? 1 : 0);
            c10 = '.';
            if (n13 == 0) break;
            object5 = (String)object.next();
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("kotlin.jvm.internal.");
            charSequence = "kotlinName";
            f0.o(object5, (String)charSequence);
            object3 = StringsKt__StringsKt.f5((String)object5, c10, null, n12, null);
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append("CompanionObject");
            object3 = ((StringBuilder)object4).toString();
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object5);
            ((StringBuilder)object4).append(".Companion");
            object5 = ((StringBuilder)object4).toString();
            object5 = w0.a(object3, object5);
            object3 = ((Pair)object5).getFirst();
            object5 = ((Pair)object5).getSecond();
            object2.put(object3, object5);
        }
        object = b.entrySet().iterator();
        while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object5 = (Map.Entry)object.next();
            object4 = (Class)object5.getKey();
            n13 = ((Number)object5.getValue()).intValue();
            object4 = ((Class)object4).getName();
            charSequence = new StringBuilder();
            string2 = "kotlin.Function";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n13);
            object5 = ((StringBuilder)charSequence).toString();
            ((HashMap)object2).put(object4, object5);
        }
        e = object2;
        n13 = s0.j(object2.size());
        object = new LinkedHashMap(n13);
        object5 = object2.entrySet().iterator();
        while ((n11 = (int)(object5.hasNext() ? 1 : 0)) != 0) {
            object2 = (Map.Entry)object5.next();
            object4 = object2.getKey();
            object2 = StringsKt__StringsKt.f5((String)object2.getValue(), c10, null, n12, null);
            object.put(object4, object2);
        }
        f = object;
    }

    public s(Class clazz) {
        f0.p(clazz, "jClass");
        this.a = clazz;
    }

    private final Void A() {
        KotlinReflectionNotSupportedError kotlinReflectionNotSupportedError = new KotlinReflectionNotSupportedError();
        throw kotlinReflectionNotSupportedError;
    }

    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ void C() {
    }

    public static /* synthetic */ void D() {
    }

    public static /* synthetic */ void E() {
    }

    public static /* synthetic */ void F() {
    }

    public static /* synthetic */ void G() {
    }

    public static /* synthetic */ void H() {
    }

    public static /* synthetic */ void I() {
    }

    public static /* synthetic */ void J() {
    }

    public static /* synthetic */ void K() {
    }

    public static /* synthetic */ void L() {
    }

    public static /* synthetic */ void M() {
    }

    public static final /* synthetic */ HashMap x() {
        return e;
    }

    public static final /* synthetic */ Map y() {
        return b;
    }

    public static final /* synthetic */ Map z() {
        return f;
    }

    public Collection a() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public Collection b() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public Collection c() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean equals(Object object) {
        Class clazz;
        boolean bl2;
        boolean bl3 = object instanceof s;
        if (bl3 && (bl2 = f0.g(clazz = f.h2.a.e(this), object = f.h2.a.e((d)object)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public List f() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean g() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public List getAnnotations() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public List getTypeParameters() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public KVisibility getVisibility() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public int hashCode() {
        return f.h2.a.e(this).hashCode();
    }

    public Object i() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean isAbstract() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean isFinal() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean isOpen() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean k() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean l() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public boolean n(Object object) {
        s$a s$a = g;
        Class clazz = this.o();
        return s$a.c(object, clazz);
    }

    public Class o() {
        return this.a;
    }

    public String p() {
        s$a s$a = g;
        Class clazz = this.o();
        return s$a.a(clazz);
    }

    public boolean q() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public String r() {
        s$a s$a = g;
        Class clazz = this.o();
        return s$a.b(clazz);
    }

    public List s() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.o().toString();
        stringBuilder.append(string2);
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }

    public boolean w() {
        this.A();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}

