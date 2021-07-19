/*
 * Decompiled with CFR 0.151.
 */
package d.p.a.a.a.c;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import d.p.a.a.a.c.a$a;
import d.p.a.a.a.c.a$b;
import d.p.a.a.a.c.a$c;
import d.p.a.a.a.c.a$d;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class a {
    public static final Type[] a = new Type[0];

    private a() {
    }

    public static /* synthetic */ Type a(Type type) {
        return d.p.a.a.a.c.a.e(type);
    }

    public static /* synthetic */ void b(Type type) {
        d.p.a.a.a.c.a.f(type);
    }

    public static /* synthetic */ int c(Object object) {
        return d.p.a.a.a.c.a.g(object);
    }

    public static /* synthetic */ String d(Type type) {
        return d.p.a.a.a.c.a.k(type);
    }

    private static Type e(Type typeArray) {
        boolean bl2 = typeArray instanceof Class;
        if (bl2) {
            bl2 = (typeArray = (Class)typeArray).isArray();
            if (bl2) {
                typeArray = d.p.a.a.a.c.a.e(typeArray.getComponentType());
                a$b a$b = new a$b((Type)typeArray);
                typeArray = a$b;
            }
            return typeArray;
        }
        bl2 = typeArray instanceof ParameterizedType;
        if (bl2) {
            bl2 = typeArray instanceof a$c;
            if (bl2) {
                return typeArray;
            }
            typeArray = (ParameterizedType)typeArray;
            Type type = typeArray.getOwnerType();
            Type type2 = typeArray.getRawType();
            typeArray = typeArray.getActualTypeArguments();
            a$c a$c = new a$c(type, type2, typeArray);
            return a$c;
        }
        bl2 = typeArray instanceof GenericArrayType;
        if (bl2) {
            bl2 = typeArray instanceof a$b;
            if (bl2) {
                return typeArray;
            }
            typeArray = (GenericArrayType)typeArray;
            typeArray = typeArray.getGenericComponentType();
            a$b a$b = new a$b((Type)typeArray);
            return a$b;
        }
        bl2 = typeArray instanceof WildcardType;
        if (bl2) {
            bl2 = typeArray instanceof a$d;
            if (bl2) {
                return typeArray;
            }
            typeArray = (WildcardType)typeArray;
            Type[] typeArray2 = typeArray.getUpperBounds();
            typeArray = typeArray.getLowerBounds();
            a$d a$d = new a$d(typeArray2, typeArray);
            return a$d;
        }
        return typeArray;
    }

    private static void f(Type object) {
        boolean bl2 = object instanceof Class;
        if (bl2) {
            Object object2 = object;
            object2 = (Class)object;
            bl2 = ((Class)object2).isPrimitive();
            if (bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected primitive ");
                stringBuilder.append(object);
                stringBuilder.append(". Use the boxed type.");
                object = stringBuilder.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
        }
    }

    private static int g(Object object) {
        int n10;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    private static String h(char c10, String string2, int n10) {
        String string3;
        int n11 = string2.length();
        if (n10 < n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c10);
            string3 = string2.substring(n10);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
        } else {
            string3 = String.valueOf(c10);
        }
        return string3;
    }

    public static Map i(Class clazz, List object, FieldNamingStrategy fieldNamingStrategy) {
        boolean bl2;
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2;
            String string2 = (String)object.next();
            int n10 = fieldNamingStrategy instanceof FieldNamingPolicy;
            if (n10 != 0) {
                object2 = a$a.a;
                Object object3 = fieldNamingStrategy;
                object3 = (FieldNamingPolicy)fieldNamingStrategy;
                int n11 = ((Enum)object3).ordinal();
                n10 = object2[n11];
                if (n10 != (n11 = 1)) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            n11 = 4;
                            if (n10 != n11) {
                                n11 = 5;
                                if (n10 != n11) {
                                    linkedHashMap.put(string2, string2);
                                    continue;
                                }
                                object2 = d.p.a.a.a.c.a.j(string2, ".");
                                object3 = Locale.ENGLISH;
                                object2 = ((String)object2).toLowerCase((Locale)object3);
                                linkedHashMap.put(string2, object2);
                                continue;
                            }
                            object2 = d.p.a.a.a.c.a.j(string2, "-");
                            object3 = Locale.ENGLISH;
                            object2 = ((String)object2).toLowerCase((Locale)object3);
                            linkedHashMap.put(string2, object2);
                            continue;
                        }
                        object2 = d.p.a.a.a.c.a.j(string2, "_");
                        object3 = Locale.ENGLISH;
                        object2 = ((String)object2).toLowerCase((Locale)object3);
                        linkedHashMap.put(string2, object2);
                        continue;
                    }
                    object2 = d.p.a.a.a.c.a.l(d.p.a.a.a.c.a.j(string2, " "));
                    linkedHashMap.put(string2, object2);
                    continue;
                }
                object2 = d.p.a.a.a.c.a.l(string2);
                linkedHashMap.put(string2, object2);
                continue;
            }
            object2 = clazz.getDeclaredField(string2);
            object2 = fieldNamingStrategy.translateName((Field)object2);
            try {
                linkedHashMap.put(string2, object2);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                linkedHashMap.put(string2, string2);
            }
        }
        return linkedHashMap;
    }

    private static String j(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = string2.charAt(i10);
            int n11 = Character.isUpperCase(c10);
            if (n11 != 0 && (n11 = stringBuilder.length()) != 0) {
                stringBuilder.append(string3);
            }
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    private static String k(Type object) {
        boolean bl2 = object instanceof Class;
        object = bl2 ? ((Class)object).getName() : object.toString();
        return object;
    }

    private static String l(String string2) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        int n11 = 0;
        char c10 = string2.charAt(0);
        int n12 = string2.length();
        while (n11 < (n10 = n12 + -1) && (n10 = (int)(Character.isLetter(c10) ? 1 : 0)) == 0) {
            stringBuilder.append(c10);
            c10 = string2.charAt(++n11);
        }
        n12 = (int)(Character.isUpperCase(c10) ? 1 : 0);
        if (n12 == 0) {
            c10 = Character.toUpperCase(c10);
            string2 = d.p.a.a.a.c.a.h(c10, string2, ++n11);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }
}

