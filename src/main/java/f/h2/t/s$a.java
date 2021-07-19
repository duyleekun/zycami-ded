/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.a;
import f.h2.t.f0;
import f.h2.t.s;
import f.h2.t.t0;
import f.h2.t.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class s$a {
    private s$a() {
    }

    public /* synthetic */ s$a(u u10) {
        this();
    }

    public final String a(Class object) {
        Object object2 = "jClass";
        f0.p(object, (String)object2);
        boolean bl2 = ((Class)object).isAnonymousClass();
        Object object3 = null;
        if (!bl2 && !(bl2 = ((Class)object).isLocalClass())) {
            bl2 = ((Class)object).isArray();
            if (bl2) {
                bl2 = ((Class)(object = ((Class)object).getComponentType())).isPrimitive();
                if (bl2) {
                    object2 = s.x();
                    object = ((Class)object).getName();
                    if ((object = (String)((HashMap)object2).get(object)) != null) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append((String)object);
                        ((StringBuilder)object2).append("Array");
                        object3 = object = ((StringBuilder)object2).toString();
                    }
                }
                if (object3 == null) {
                    object3 = "kotlin.Array";
                }
            } else {
                object2 = s.x();
                object3 = ((Class)object).getName();
                object3 = object2 = ((HashMap)object2).get(object3);
                object3 = (String)object2;
                if (object3 == null) {
                    object3 = ((Class)object).getCanonicalName();
                }
            }
        }
        return object3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String b(Class object) {
        String string2;
        Object object2;
        boolean bl2;
        Object object3;
        block10: {
            String string3;
            int n10;
            block12: {
                String string4;
                block11: {
                    object3 = "jClass";
                    f0.p(object, (String)object3);
                    bl2 = ((Class)object).isAnonymousClass();
                    object2 = "Array";
                    string2 = null;
                    if (bl2) {
                        return string2;
                    }
                    bl2 = ((Class)object).isLocalClass();
                    if (!bl2) break block10;
                    object3 = ((Class)object).getSimpleName();
                    object2 = ((Class)object).getEnclosingMethod();
                    string4 = "$";
                    n10 = 2;
                    string3 = "name";
                    if (object2 == null) break block11;
                    f0.o(object3, string3);
                    StringBuilder stringBuilder = new StringBuilder();
                    object2 = ((Method)object2).getName();
                    stringBuilder.append((String)object2);
                    stringBuilder.append(string4);
                    object2 = stringBuilder.toString();
                    object2 = StringsKt__StringsKt.c5((String)object3, (String)object2, null, n10, null);
                    if (object2 != null) break block12;
                }
                if ((object = ((Class)object).getEnclosingConstructor()) != null) {
                    f0.o(object3, string3);
                    object2 = new StringBuilder();
                    object = ((Constructor)object).getName();
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(string4);
                    object = ((StringBuilder)object2).toString();
                    object2 = object = StringsKt__StringsKt.c5((String)object3, (String)object, null, n10, null);
                } else {
                    object2 = null;
                }
            }
            if (object2 != null) return object2;
            f0.o(object3, string3);
            char c10 = '$';
            return StringsKt__StringsKt.b5((String)object3, c10, null, n10, null);
        }
        bl2 = ((Class)object).isArray();
        if (bl2) {
            bl2 = ((Class)(object = ((Class)object).getComponentType())).isPrimitive();
            if (bl2) {
                object3 = s.z();
                object = ((Class)object).getName();
                if ((object = (String)object3.get(object)) != null) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)object);
                    ((StringBuilder)object3).append((String)object2);
                    string2 = ((StringBuilder)object3).toString();
                }
            }
            if (string2 == null) return object2;
            return string2;
        }
        object3 = s.z();
        object2 = ((Class)object).getName();
        object2 = object3 = object3.get(object2);
        object2 = (String)object3;
        if (object2 == null) return ((Class)object).getSimpleName();
        return object2;
    }

    public final boolean c(Object object, Class clazz) {
        f0.p(clazz, "jClass");
        Object object2 = s.y();
        String string2 = "null cannot be cast to non-null type kotlin.collections.Map<K, V>";
        Objects.requireNonNull(object2, string2);
        object2 = (Integer)object2.get(clazz);
        if (object2 != null) {
            int n10 = ((Number)object2).intValue();
            return t0.B(object, n10);
        }
        boolean bl2 = clazz.isPrimitive();
        if (bl2) {
            clazz = a.e(a.g(clazz));
        }
        return clazz.isInstance(object);
    }
}

