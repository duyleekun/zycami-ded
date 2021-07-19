/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.a;
import f.h2.t.f0;
import f.h2.t.w0;
import f.m2.d;
import f.m2.g;
import f.m2.r;
import f.m2.t;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.TypeReference$asString$args$1;

public final class TypeReference
implements r {
    private final g a;
    private final List b;
    private final boolean c;

    public TypeReference(g g10, List list, boolean bl2) {
        f0.p(g10, "classifier");
        f0.p(list, "arguments");
        this.a = g10;
        this.b = list;
        this.c = bl2;
    }

    public static final /* synthetic */ String d(TypeReference typeReference, t t10) {
        return typeReference.o(t10);
    }

    private final String h() {
        Object object;
        boolean bl2;
        Object object2 = this.m();
        boolean bl3 = object2 instanceof d;
        Object object3 = null;
        if (!bl3) {
            bl2 = false;
            object2 = null;
        }
        if ((object2 = (d)object2) != null) {
            object3 = f.h2.a.c((d)object2);
        }
        object2 = object3 == null ? this.m().toString() : ((bl2 = ((Class)object3).isArray()) ? this.x((Class)object3) : ((Class)object3).getName());
        Object object4 = this.getArguments();
        bl3 = object4.isEmpty();
        object3 = "";
        if (bl3) {
            object4 = object3;
        } else {
            object = this.getArguments();
            TypeReference$asString$args$1 typeReference$asString$args$1 = new TypeReference$asString$args$1(this);
            int n10 = 24;
            String string2 = ", ";
            String string3 = "<";
            String string4 = ">";
            object4 = CollectionsKt___CollectionsKt.X2((Iterable)object, string2, string3, string4, 0, null, typeReference$asString$args$1, n10, null);
        }
        boolean bl4 = this.e();
        if (bl4) {
            object3 = "?";
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append((String)object4);
        ((StringBuilder)object).append((String)object3);
        return ((StringBuilder)object).toString();
    }

    private final String o(t object) {
        block3: {
            Object object2;
            block4: {
                Object object3;
                block5: {
                    object2 = ((t)object).h();
                    if (object2 == null) {
                        return "*";
                    }
                    object2 = ((t)object).g();
                    int n10 = object2 instanceof TypeReference;
                    if (n10 == 0) {
                        object2 = null;
                    }
                    if ((object2 = (TypeReference)object2) == null || (object2 = super.h()) == null) {
                        object2 = String.valueOf(((t)object).g());
                    }
                    object = ((t)object).h();
                    if (object == null) break block3;
                    object3 = w0.a;
                    int n11 = ((Enum)object).ordinal();
                    n10 = 1;
                    if ((n11 = object3[n11]) == n10) break block4;
                    n10 = 2;
                    if (n11 == n10) break block5;
                    n10 = 3;
                    if (n11 != n10) break block3;
                    object = new StringBuilder();
                    object3 = "out ";
                    ((StringBuilder)object).append((String)object3);
                    ((StringBuilder)object).append((String)object2);
                    object2 = ((StringBuilder)object).toString();
                    break block4;
                }
                object = new StringBuilder();
                object3 = "in ";
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append((String)object2);
                object2 = ((StringBuilder)object).toString();
            }
            return object2;
        }
        object = new NoWhenBranchMatchedException();
        throw object;
    }

    private final String x(Class object) {
        boolean bl2;
        Class clazz = boolean[].class;
        boolean bl3 = f0.g(object, clazz);
        object = bl3 ? "kotlin.BooleanArray" : ((bl3 = f0.g(object, clazz = char[].class)) ? "kotlin.CharArray" : ((bl3 = f0.g(object, clazz = byte[].class)) ? "kotlin.ByteArray" : ((bl3 = f0.g(object, clazz = short[].class)) ? "kotlin.ShortArray" : ((bl3 = f0.g(object, clazz = int[].class)) ? "kotlin.IntArray" : ((bl3 = f0.g(object, clazz = float[].class)) ? "kotlin.FloatArray" : ((bl3 = f0.g(object, clazz = long[].class)) ? "kotlin.LongArray" : ((bl2 = f0.g(object, clazz = double[].class)) ? "kotlin.DoubleArray" : "kotlin.Array")))))));
        return object;
    }

    public boolean e() {
        return this.c;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3 = object instanceof TypeReference;
        if (bl3 && (bl3 = f0.g(object3 = this.m(), object2 = ((TypeReference)(object = (TypeReference)object)).m())) && (bl3 = f0.g(object3 = this.getArguments(), object2 = ((TypeReference)object).getArguments())) && (bl3 = this.e()) == (bl2 = ((TypeReference)object).e())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public List getAnnotations() {
        return CollectionsKt__CollectionsKt.E();
    }

    public List getArguments() {
        return this.b;
    }

    public int hashCode() {
        int n10 = this.m().hashCode() * 31;
        int n11 = ((Object)this.getArguments()).hashCode();
        n10 = (n10 + n11) * 31;
        n11 = ((Object)this.e()).hashCode();
        return n10 + n11;
    }

    public g m() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.h();
        stringBuilder.append(string2);
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}

