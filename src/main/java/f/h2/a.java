/*
 * Decompiled with CFR 0.151.
 */
package f.h2;

import f.h2.t.f0;
import f.h2.t.n0;
import f.h2.t.r;
import f.m2.d;
import java.lang.annotation.Annotation;
import java.util.Objects;

public final class a {
    public static final d a(Annotation object) {
        f0.p(object, "$this$annotationClass");
        object = a.g(object.annotationType());
        Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
        return object;
    }

    public static final Class b(Object clazz) {
        f0.p(clazz, "$this$javaClass");
        clazz = clazz.getClass();
        Objects.requireNonNull(clazz, "null cannot be cast to non-null type java.lang.Class<T>");
        return clazz;
    }

    public static final Class c(d object) {
        f0.p(object, "$this$java");
        object = ((r)object).o();
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.Class<T>");
        return object;
    }

    public static /* synthetic */ void d(d d10) {
    }

    public static final Class e(d clazz) {
        String string2 = "$this$javaObjectType";
        f0.p(clazz, string2);
        clazz = ((r)((Object)clazz)).o();
        boolean bl2 = clazz.isPrimitive();
        String string3 = "null cannot be cast to non-null type java.lang.Class<T>";
        if (!bl2) {
            Objects.requireNonNull(clazz, string3);
            return clazz;
        }
        string2 = clazz.getName();
        if (string2 != null) {
            int n10 = string2.hashCode();
            switch (n10) {
                default: {
                    break;
                }
                case 109413500: {
                    String string4 = "short";
                    bl2 = string2.equals(string4);
                    if (!bl2) break;
                    clazz = Short.class;
                    break;
                }
                case 97526364: {
                    String string5 = "float";
                    bl2 = string2.equals(string5);
                    if (!bl2) break;
                    clazz = Float.class;
                    break;
                }
                case 64711720: {
                    String string6 = "boolean";
                    bl2 = string2.equals(string6);
                    if (!bl2) break;
                    clazz = Boolean.class;
                    break;
                }
                case 3625364: {
                    String string7 = "void";
                    bl2 = string2.equals(string7);
                    if (!bl2) break;
                    clazz = Void.class;
                    break;
                }
                case 3327612: {
                    String string8 = "long";
                    bl2 = string2.equals(string8);
                    if (!bl2) break;
                    clazz = Long.class;
                    break;
                }
                case 3052374: {
                    String string9 = "char";
                    bl2 = string2.equals(string9);
                    if (!bl2) break;
                    clazz = Character.class;
                    break;
                }
                case 3039496: {
                    String string10 = "byte";
                    bl2 = string2.equals(string10);
                    if (!bl2) break;
                    clazz = Byte.class;
                    break;
                }
                case 104431: {
                    String string11 = "int";
                    bl2 = string2.equals(string11);
                    if (!bl2) break;
                    clazz = Integer.class;
                    break;
                }
                case -1325958191: {
                    String string12 = "double";
                    bl2 = string2.equals(string12);
                    if (!bl2) break;
                    clazz = Double.class;
                }
            }
        }
        Objects.requireNonNull(clazz, string3);
        return clazz;
    }

    public static final Class f(d clazz) {
        block13: {
            boolean bl2;
            block12: {
                String string2 = "$this$javaPrimitiveType";
                f0.p(clazz, string2);
                clazz = ((r)((Object)clazz)).o();
                int n10 = clazz.isPrimitive();
                if (n10 != 0) {
                    Objects.requireNonNull(clazz, "null cannot be cast to non-null type java.lang.Class<T>");
                    return clazz;
                }
                if ((clazz = clazz.getName()) == null) break block12;
                n10 = ((String)((Object)clazz)).hashCode();
                switch (n10) {
                    default: {
                        break;
                    }
                    case 761287205: {
                        string2 = "java.lang.Double";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Double.TYPE;
                        break block13;
                    }
                    case 399092968: {
                        string2 = "java.lang.Void";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Void.TYPE;
                        break block13;
                    }
                    case 398795216: {
                        string2 = "java.lang.Long";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Long.TYPE;
                        break block13;
                    }
                    case 398507100: {
                        string2 = "java.lang.Byte";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Byte.TYPE;
                        break block13;
                    }
                    case 344809556: {
                        string2 = "java.lang.Boolean";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Boolean.TYPE;
                        break block13;
                    }
                    case 155276373: {
                        string2 = "java.lang.Character";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Character.TYPE;
                        break block13;
                    }
                    case -515992664: {
                        string2 = "java.lang.Short";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Short.TYPE;
                        break block13;
                    }
                    case -527879800: {
                        string2 = "java.lang.Float";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Float.TYPE;
                        break block13;
                    }
                    case -2056817302: {
                        string2 = "java.lang.Integer";
                        bl2 = ((String)((Object)clazz)).equals(string2);
                        if (!bl2) break;
                        clazz = Integer.TYPE;
                        break block13;
                    }
                }
            }
            bl2 = false;
            clazz = null;
        }
        return clazz;
    }

    public static final d g(Class clazz) {
        f0.p(clazz, "$this$kotlin");
        return n0.d(clazz);
    }

    public static final Class h(d object) {
        f0.p(object, "$this$javaClass");
        object = object.getClass();
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
        return object;
    }

    public static /* synthetic */ void i(d d10) {
    }

    public static final /* synthetic */ boolean j(Object[] object) {
        f0.p(object, "$this$isArrayOf");
        f0.y(4, "T");
        object = object.getClass().getComponentType();
        return Object.class.isAssignableFrom((Class<?>)object);
    }
}

