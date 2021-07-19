/*
 * Decompiled with CFR 0.151.
 */
package kotlin.reflect;

import f.h2.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.h2.t.g0;
import f.m2.d;
import f.m2.r;
import f.m2.s;
import f.m2.t;
import f.m2.x;
import f.m2.y;
import f.m2.z;
import f.n2.m;
import f.q2.u;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.KVariance;
import kotlin.reflect.ParameterizedTypeImpl;
import kotlin.reflect.TypesJVMKt$typeToString$unwrap$1;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

public final class TypesJVMKt {
    public static final /* synthetic */ Type a(r r10, boolean bl2) {
        return TypesJVMKt.c(r10, bl2);
    }

    public static final /* synthetic */ String b(Type type) {
        return TypesJVMKt.j(type);
    }

    private static final Type c(r object, boolean bl2) {
        Object object2 = object.m();
        Object object3 = object2 instanceof s;
        if (object3 != 0) {
            object2 = (s)object2;
            object = new x((s)object2);
            return object;
        }
        object3 = object2 instanceof d;
        if (object3 != 0) {
            object2 = (d)object2;
            Object object4 = bl2 ? a.e((d)object2) : a.c((d)object2);
            object2 = object.getArguments();
            object3 = object2.isEmpty();
            if (object3 != 0) {
                return object4;
            }
            object3 = ((Class)object4).isArray();
            if (object3 != 0) {
                Class<?> clazz = ((Class)object4).getComponentType();
                object3 = clazz.isPrimitive();
                if (object3 != 0) {
                    return object4;
                }
                if ((object2 = (t)CollectionsKt___CollectionsKt.X4((List)object2)) != null) {
                    object = ((t)object2).a();
                    object2 = ((t)object2).b();
                    if (object != null) {
                        clazz = (Class<?>)y.a;
                        Object object5 = ((Enum)object).ordinal();
                        object3 = 1;
                        if ((object5 = (Object)clazz[object5]) != object3) {
                            Object object6 = 2;
                            if (object5 != object6 && object5 != (object6 = 3)) {
                                object = new NoWhenBranchMatchedException();
                                throw object;
                            }
                            f0.m(object2);
                            object5 = 0;
                            object6 = 0;
                            object = TypesJVMKt.d((r)object2, false, object3, null);
                            boolean bl3 = object instanceof Class;
                            if (!bl3) {
                                object4 = new f.m2.a((Type)object);
                            }
                        }
                    }
                    return object4;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("kotlin.Array must have exactly one type argument: ");
                ((StringBuilder)object2).append(object);
                object = ((StringBuilder)object2).toString();
                object4 = new IllegalArgumentException((String)object);
                throw object4;
            }
            return TypesJVMKt.e((Class)object4, (List)object2);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unsupported type classifier: ");
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }

    public static /* synthetic */ Type d(r r10, boolean bl2, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            bl2 = false;
        }
        return TypesJVMKt.c(r10, bl2);
    }

    private static final Type e(Class clazz, List object) {
        Type type = clazz.getDeclaringClass();
        int n10 = 10;
        if (type != null) {
            int n11 = Modifier.isStatic(clazz.getModifiers());
            if (n11 != 0) {
                n10 = f.x1.u.Y((Iterable)object, n10);
                ArrayList<Type> arrayList = new ArrayList<Type>(n10);
                object = object.iterator();
                while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    Type type2 = TypesJVMKt.g((t)object.next());
                    arrayList.add(type2);
                }
                object = new ParameterizedTypeImpl(clazz, type, arrayList);
                return object;
            }
            n11 = clazz.getTypeParameters().length;
            int n12 = object.size();
            List list = object.subList(n11, n12);
            type = TypesJVMKt.e(type, list);
            n12 = 0;
            list = null;
            object = object.subList(0, n11);
            n10 = f.x1.u.Y(object, n10);
            ArrayList<Type> arrayList = new ArrayList<Type>(n10);
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                Type type3 = TypesJVMKt.g((t)object.next());
                arrayList.add(type3);
            }
            object = new ParameterizedTypeImpl(clazz, type, arrayList);
            return object;
        }
        type = null;
        n10 = f.x1.u.Y((Iterable)object, n10);
        ArrayList<Type> arrayList = new ArrayList<Type>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Type type4 = TypesJVMKt.g((t)object.next());
            arrayList.add(type4);
        }
        object = new ParameterizedTypeImpl(clazz, null, arrayList);
        return object;
    }

    public static final Type f(r r10) {
        Object object = "$this$javaType";
        f0.p(r10, (String)object);
        boolean bl2 = r10 instanceof g0;
        if (bl2) {
            object = r10;
            object = ((g0)r10).j();
            if (object != null) {
                return object;
            }
        }
        return TypesJVMKt.d(r10, false, 1, null);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static final Type g(t object) {
        void var1_5;
        KVariance kVariance = ((t)object).h();
        if (kVariance == null) return z.d.a();
        object = ((t)object).g();
        f0.m(object);
        int[] nArray = y.b;
        int n11 = kVariance.ordinal();
        n11 = nArray[n11];
        int n12 = 1;
        if (n11 == n12) {
            Type type = TypesJVMKt.c((r)object, n12 != 0);
            return var1_5;
        }
        int n13 = 2;
        if (n11 == n13) {
            object = TypesJVMKt.c((r)object, n12 != 0);
            z z10 = new z(null, (Type)object);
            return var1_5;
        }
        int n14 = 3;
        if (n11 == n14) {
            object = TypesJVMKt.c((r)object, n12 != 0);
            z z11 = new z((Type)object, null);
            return var1_5;
        }
        object = new NoWhenBranchMatchedException();
        throw object;
    }

    public static /* synthetic */ void h(r r10) {
    }

    private static /* synthetic */ void i(t t10) {
    }

    private static final String j(Type object) {
        boolean bl2 = object instanceof Class;
        if (bl2) {
            Object object2 = object;
            object2 = (Class)object;
            boolean bl3 = ((Class)object2).isArray();
            if (bl3) {
                object2 = TypesJVMKt$typeToString$unwrap$1.INSTANCE;
                object = SequencesKt__SequencesKt.o(object, (l)object2);
                object2 = new StringBuilder();
                String string2 = ((Class)SequencesKt___SequencesKt.W0((m)object)).getName();
                ((StringBuilder)object2).append(string2);
                int n10 = SequencesKt___SequencesKt.Z((m)object);
                string2 = "[]";
                object = u.c2(string2, n10);
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            } else {
                object = ((Class)object2).getName();
            }
            object2 = "if (type.isArray) {\n    \u2026\n        } else type.name";
            f0.o(object, (String)object2);
        } else {
            object = object.toString();
        }
        return object;
    }
}

