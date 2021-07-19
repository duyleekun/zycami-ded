/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.s$a;
import g.w$c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.h;
import k.n;
import k.n$c;
import k.n$d;
import k.n$e;
import k.n$f;
import k.n$g;
import k.n$h;
import k.n$i;
import k.n$j;
import k.n$k;
import k.n$l;
import k.n$m;
import k.n$n;
import k.n$o;
import k.n$p;
import k.n$q;
import k.q;
import k.s;
import k.w;
import k.z.a;
import k.z.b;
import k.z.c;
import k.z.d;
import k.z.e;
import k.z.f;
import k.z.g;
import k.z.i;
import k.z.j;
import k.z.k;
import k.z.l;
import k.z.m;
import k.z.o;
import k.z.p;
import k.z.r;
import k.z.t;
import k.z.u;
import k.z.v;
import k.z.x;
import k.z.y;

public final class q$a {
    private static final String x = "[a-zA-Z][a-zA-Z0-9_-]*";
    private static final Pattern y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    private static final Pattern z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    public final s a;
    public final Method b;
    public final Annotation[] c;
    public final Annotation[][] d;
    public final Type[] e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public String n;
    public boolean o;
    public boolean p;
    public boolean q;
    public String r;
    public g.s s;
    public g.v t;
    public Set u;
    public n[] v;
    public boolean w;

    public q$a(s objectArray, Method method) {
        this.a = objectArray;
        this.b = method;
        objectArray = method.getAnnotations();
        this.c = objectArray;
        objectArray = method.getGenericParameterTypes();
        this.e = objectArray;
        objectArray = method.getParameterAnnotations();
        this.d = objectArray;
    }

    private static Class a(Class clazz) {
        Class<Comparable<Boolean>> clazz2 = Boolean.TYPE;
        if (clazz2 == clazz) {
            return Boolean.class;
        }
        clazz2 = Byte.TYPE;
        if (clazz2 == clazz) {
            return Byte.class;
        }
        clazz2 = Character.TYPE;
        if (clazz2 == clazz) {
            return Character.class;
        }
        clazz2 = Double.TYPE;
        if (clazz2 == clazz) {
            return Double.class;
        }
        clazz2 = Float.TYPE;
        if (clazz2 == clazz) {
            return Float.class;
        }
        clazz2 = Integer.TYPE;
        if (clazz2 == clazz) {
            return Integer.class;
        }
        clazz2 = Long.TYPE;
        if (clazz2 == clazz) {
            return Long.class;
        }
        clazz2 = Short.TYPE;
        if (clazz2 == clazz) {
            clazz = Short.class;
        }
        return clazz;
    }

    private g.s c(String[] object) {
        Object object2 = new s$a();
        int n10 = ((String[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = object[i10];
            int n11 = string2.indexOf(58);
            int n12 = -1;
            int n13 = 1;
            if (n11 != n12 && n11 != 0 && n11 != (n12 = string2.length() - n13)) {
                String string3 = string2.substring(0, n11);
                string2 = string2.substring(++n11).trim();
                Object object3 = "Content-Type";
                n11 = (int)(((String)object3).equalsIgnoreCase(string3) ? 1 : 0);
                if (n11 != 0) {
                    try {
                        object3 = g.v.h(string2);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        object2 = this.b;
                        Object[] objectArray = new Object[n13];
                        objectArray[0] = string2;
                        throw k.w.n((Method)object2, illegalArgumentException, "Malformed content type: %s", objectArray);
                    }
                    this.t = object3;
                    continue;
                }
                object2.b(string3, string2);
                continue;
            }
            object = this.b;
            object2 = new Object[n13];
            object2[0] = string2;
            throw k.w.m((Method)object, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", object2);
        }
        return object2.i();
    }

    private void d(String object, String object2, boolean n10) {
        String string2 = this.n;
        int n11 = 1;
        if (string2 == null) {
            int n12;
            Object[] objectArray;
            this.n = object;
            this.o = n10;
            boolean n122 = ((String)object2).isEmpty();
            if (n122) {
                return;
            }
            int n13 = ((String)object2).indexOf(63);
            if (n13 != (n10 = -1) && n13 < (n10 = ((String)object2).length() - n11) && (n10 = (int)((objectArray = y.matcher((CharSequence)(object = ((String)object2).substring(n12 = n13 + n11)))).find() ? 1 : 0)) != 0) {
                object2 = this.b;
                objectArray = new Object[n11];
                objectArray[0] = object;
                throw k.w.m((Method)object2, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", objectArray);
            }
            this.r = object2;
            this.u = object = q$a.h((String)object2);
            return;
        }
        object2 = this.b;
        Object[] objectArray = new Object[2];
        objectArray[0] = string2;
        objectArray[n11] = object;
        throw k.w.m((Method)object2, "Only one HTTP method is allowed. Found: %s and %s.", objectArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void e(Annotation object) {
        int n10 = object instanceof b;
        String string2 = null;
        if (n10 != 0) {
            String string3 = ((b)object).value();
            String string4 = "DELETE";
            this.d(string4, string3, false);
            return;
        }
        n10 = object instanceof f;
        if (n10 != 0) {
            String string5 = ((f)object).value();
            String string6 = "GET";
            this.d(string6, string5, false);
            return;
        }
        n10 = object instanceof g;
        if (n10 != 0) {
            String string7 = ((g)object).value();
            String string8 = "HEAD";
            this.d(string8, string7, false);
            return;
        }
        n10 = object instanceof k.z.n;
        boolean bl2 = true;
        if (n10 != 0) {
            String string9 = ((k.z.n)object).value();
            String string10 = "PATCH";
            this.d(string10, string9, bl2);
            return;
        }
        n10 = object instanceof o;
        if (n10 != 0) {
            String string11 = ((o)object).value();
            String string12 = "POST";
            this.d(string12, string11, bl2);
            return;
        }
        n10 = object instanceof p;
        if (n10 != 0) {
            String string13 = ((p)object).value();
            String string14 = "PUT";
            this.d(string14, string13, bl2);
            return;
        }
        n10 = object instanceof m;
        if (n10 != 0) {
            String string15 = ((m)object).value();
            String string16 = "OPTIONS";
            this.d(string16, string15, false);
            return;
        }
        n10 = object instanceof k.z.h;
        if (n10 != 0) {
            k.z.h h10 = (k.z.h)object;
            String string17 = h10.method();
            string2 = h10.path();
            boolean bl3 = h10.hasBody();
            this.d(string17, string2, bl3);
            return;
        }
        n10 = object instanceof k;
        if (n10 != 0) {
            String[] stringArray = ((k)object).value();
            n10 = stringArray.length;
            if (n10 != 0) {
                g.s s10;
                this.s = s10 = this.c(stringArray);
                return;
            }
            Method method = this.b;
            Object[] objectArray = new Object[]{};
            throw k.w.m(method, "@Headers annotation is empty.", objectArray);
        }
        n10 = object instanceof l;
        String string18 = "Only one encoding annotation is allowed.";
        if (n10 != 0) {
            boolean bl4 = this.p;
            if (!bl4) {
                this.q = bl2;
                return;
            }
            Method method = this.b;
            Object[] objectArray = new Object[]{};
            throw k.w.m(method, string18, objectArray);
        }
        boolean bl5 = object instanceof e;
        if (!bl5) return;
        bl5 = this.q;
        if (!bl5) {
            this.p = bl2;
            return;
        }
        Method method = this.b;
        Object[] objectArray = new Object[]{};
        throw k.w.m(method, string18, objectArray);
    }

    private n f(int n10, Type object, Annotation[] objectArray, boolean bl2) {
        Object object2;
        if (objectArray != null) {
            int n11 = objectArray.length;
            object2 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                Object object3 = objectArray[i10];
                if ((object3 = this.g(n10, (Type)object, (Annotation[])objectArray, (Annotation)object3)) == null) continue;
                if (object2 == null) {
                    object2 = object3;
                    continue;
                }
                object = this.b;
                objectArray = new Object[]{};
                throw k.w.o((Method)object, n10, "Multiple Retrofit annotations found, only one allowed.", objectArray);
            }
        } else {
            object2 = null;
        }
        if (object2 == null) {
            block9: {
                if (bl2) {
                    boolean bl3;
                    try {
                        object = k.w.h((Type)object);
                        objectArray = f.b2.c.class;
                        if (object != objectArray) break block9;
                        bl3 = true;
                    }
                    catch (NoClassDefFoundError noClassDefFoundError) {}
                    this.w = bl3;
                    return null;
                }
            }
            object = this.b;
            objectArray = new Object[]{};
            throw k.w.o((Method)object, n10, "No Retrofit annotation found.", objectArray);
        }
        return object2;
    }

    private n g(int n10, Type clazz, Annotation[] object, Annotation object2) {
        Object object3 = String.class;
        Type type = w$c.class;
        int n11 = object2 instanceof y;
        Class<Map> clazz2 = "@Path parameters may not be used with @Url.";
        int n12 = 1;
        boolean bl2 = false;
        if (n11 != 0) {
            this.j(n10, clazz);
            boolean bl3 = this.m;
            if (!bl3) {
                bl3 = this.i;
                if (!bl3) {
                    bl3 = this.j;
                    if (!bl3) {
                        bl3 = this.k;
                        if (!bl3) {
                            bl3 = this.l;
                            if (!bl3) {
                                object = this.r;
                                if (object == null) {
                                    boolean bl4;
                                    this.m = n12;
                                    object = g.t.class;
                                    if (!(clazz == object || clazz == object3 || clazz == (object = URI.class) || (bl3 = clazz instanceof Class) && (bl4 = ((String)(object = "android.net.Uri")).equals(clazz = ((Class)clazz).getName())))) {
                                        clazz = this.b;
                                        object = new Object[]{};
                                        throw k.w.o((Method)((Object)clazz), n10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", (Object[])object);
                                    }
                                    object = this.b;
                                    clazz = new n$p((Method)object, n10);
                                    return clazz;
                                }
                                clazz = this.b;
                                object = new Object[n12];
                                object[0] = object2 = this.n;
                                throw k.w.o((Method)((Object)clazz), n10, "@Url cannot be used with @%s URL", (Object[])object);
                            }
                            clazz = this.b;
                            object = new Object[]{};
                            throw k.w.o((Method)((Object)clazz), n10, "A @Url parameter must not come after a @QueryMap.", (Object[])object);
                        }
                        clazz = this.b;
                        object = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, "A @Url parameter must not come after a @QueryName.", (Object[])object);
                    }
                    clazz = this.b;
                    object = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, "A @Url parameter must not come after a @Query.", (Object[])object);
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, (String)((Object)clazz2), (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "Multiple @Url method annotations found.", (Object[])object);
        }
        n11 = object2 instanceof k.z.s;
        if (n11 != 0) {
            this.j(n10, clazz);
            boolean bl5 = this.j;
            if (!bl5) {
                bl5 = this.k;
                if (!bl5) {
                    bl5 = this.l;
                    if (!bl5) {
                        bl5 = this.m;
                        if (!bl5) {
                            object3 = this.r;
                            if (object3 != null) {
                                this.i = n12;
                                object2 = (k.z.s)object2;
                                clazz2 = object2.value();
                                this.i(n10, (String)((Object)clazz2));
                                h h10 = this.a.o(clazz, (Annotation[])object);
                                type = this.b;
                                bl2 = object2.encoded();
                                object3 = clazz;
                                n11 = n10;
                                clazz = new n$k((Method)((Object)type), n10, (String)((Object)clazz2), h10, bl2);
                                return clazz;
                            }
                            clazz = this.b;
                            object = new Object[n12];
                            object[0] = object2 = this.n;
                            throw k.w.o((Method)((Object)clazz), n10, "@Path can only be used with relative url on @%s", (Object[])object);
                        }
                        clazz = this.b;
                        object = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, (String)((Object)clazz2), (Object[])object);
                    }
                    clazz = this.b;
                    object = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, "A @Path parameter must not come after a @QueryMap.", (Object[])object);
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, "A @Path parameter must not come after a @QueryName.", (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "A @Path parameter must not come after a @Query.", (Object[])object);
        }
        n11 = object2 instanceof t;
        clazz2 = "<String>)";
        String string2 = " must include generic type (e.g., ";
        if (n11 != 0) {
            this.j(n10, clazz);
            object2 = (t)object2;
            object3 = object2.value();
            boolean bl6 = object2.encoded();
            type = k.w.h(clazz);
            this.j = n12;
            Class<Iterable> clazz3 = Iterable.class;
            n11 = clazz3.isAssignableFrom((Class<?>)type);
            if (n11 != 0) {
                n11 = clazz instanceof ParameterizedType;
                if (n11 != 0) {
                    clazz = (ParameterizedType)((Object)clazz);
                    Object object4 = k.w.g(0, (ParameterizedType)((Object)clazz));
                    object4 = this.a.o((Type)object4, (Annotation[])object);
                    clazz = new n$l((String)object3, (h)object4, bl6);
                    return ((n)((Object)clazz)).c();
                }
                clazz = this.b;
                object = new StringBuilder();
                object2 = ((Class)type).getSimpleName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object2 = ((Class)type).getSimpleName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)((Object)clazz2));
                object = ((StringBuilder)object).toString();
                object2 = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
            }
            n10 = (int)(((Class)type).isArray() ? 1 : 0);
            if (n10 != 0) {
                Object object5 = q$a.a(((Class)type).getComponentType());
                object5 = this.a.o((Type)object5, (Annotation[])object);
                clazz = new n$l((String)object3, (h)object5, bl6);
                return ((n)((Object)clazz)).b();
            }
            h h11 = this.a.o(clazz, (Annotation[])object);
            clazz = new n$l((String)object3, h11, bl6);
            return clazz;
        }
        n11 = object2 instanceof v;
        if (n11 != 0) {
            this.j(n10, clazz);
            object2 = (v)object2;
            boolean bl7 = object2.encoded();
            object3 = k.w.h(clazz);
            this.k = n12;
            type = Iterable.class;
            boolean bl8 = ((Class)type).isAssignableFrom((Class<?>)object3);
            if (bl8) {
                bl8 = clazz instanceof ParameterizedType;
                if (bl8) {
                    clazz = (ParameterizedType)((Object)clazz);
                    Object object6 = k.w.g(0, (ParameterizedType)((Object)clazz));
                    object6 = this.a.o((Type)object6, (Annotation[])object);
                    clazz = new n$n((h)object6, bl7);
                    return ((n)((Object)clazz)).c();
                }
                clazz = this.b;
                object = new StringBuilder();
                object2 = ((Class)object3).getSimpleName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object2 = ((Class)object3).getSimpleName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)((Object)clazz2));
                object = ((StringBuilder)object).toString();
                object2 = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
            }
            n10 = (int)(((Class)object3).isArray() ? 1 : 0);
            if (n10 != 0) {
                Object object7 = q$a.a(((Class)object3).getComponentType());
                object7 = this.a.o((Type)object7, (Annotation[])object);
                clazz = new n$n((h)object7, bl7);
                return ((n)((Object)clazz)).b();
            }
            h h12 = this.a.o(clazz, (Annotation[])object);
            clazz = new n$n(h12, bl7);
            return clazz;
        }
        n11 = object2 instanceof u;
        String[] stringArray = "Map must include generic types (e.g., Map<String, String>)";
        if (n11 != 0) {
            this.j(n10, clazz);
            type = k.w.h(clazz);
            this.l = n12;
            Class<Map> clazz4 = Map.class;
            n11 = clazz4.isAssignableFrom((Class<?>)type);
            if (n11 != 0) {
                clazz4 = Map.class;
                boolean bl9 = (clazz = k.w.i(clazz, type, clazz4)) instanceof ParameterizedType;
                if (bl9) {
                    type = k.w.g(0, (ParameterizedType)((Object)(clazz = (ParameterizedType)((Object)clazz))));
                    if (object3 == type) {
                        clazz = k.w.g(n12, (ParameterizedType)((Object)clazz));
                        clazz = this.a.o(clazz, (Annotation[])object);
                        object3 = this.b;
                        boolean bl10 = ((u)object2).encoded();
                        object = new n$m((Method)object3, n10, (h)((Object)clazz), bl10);
                        return object;
                    }
                    clazz = this.b;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("@QueryMap keys must be of type String: ");
                    ((StringBuilder)object).append(type);
                    object = ((StringBuilder)object).toString();
                    object2 = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, (String)stringArray, (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@QueryMap parameter type must be Map.", (Object[])object);
        }
        n11 = object2 instanceof i;
        if (n11 != 0) {
            this.j(n10, clazz);
            object2 = ((i)object2).value();
            object3 = k.w.h(clazz);
            type = Iterable.class;
            boolean bl11 = ((Class)type).isAssignableFrom((Class<?>)object3);
            if (bl11) {
                bl11 = clazz instanceof ParameterizedType;
                if (bl11) {
                    clazz = (ParameterizedType)((Object)clazz);
                    Object object8 = k.w.g(0, (ParameterizedType)((Object)clazz));
                    object8 = this.a.o((Type)object8, (Annotation[])object);
                    clazz = new n$f((String)object2, (h)object8);
                    return ((n)((Object)clazz)).c();
                }
                clazz = this.b;
                object = new StringBuilder();
                object2 = ((Class)object3).getSimpleName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object2 = ((Class)object3).getSimpleName();
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append((String)((Object)clazz2));
                object = ((StringBuilder)object).toString();
                object2 = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
            }
            n10 = (int)(((Class)object3).isArray() ? 1 : 0);
            if (n10 != 0) {
                Object object9 = q$a.a(((Class)object3).getComponentType());
                object9 = this.a.o((Type)object9, (Annotation[])object);
                clazz = new n$f((String)object2, (h)object9);
                return ((n)((Object)clazz)).b();
            }
            h h13 = this.a.o(clazz, (Annotation[])object);
            clazz = new n$f((String)object2, h13);
            return clazz;
        }
        n11 = object2 instanceof j;
        if (n11 != 0) {
            object2 = g.s.class;
            if (clazz == object2) {
                object = this.b;
                clazz = new n$h((Method)object, n10);
                return clazz;
            }
            this.j(n10, clazz);
            object2 = k.w.h(clazz);
            type = Map.class;
            boolean bl12 = ((Class)type).isAssignableFrom((Class<?>)object2);
            if (bl12) {
                type = Map.class;
                boolean bl13 = (clazz = k.w.i(clazz, (Class)object2, (Class)type)) instanceof ParameterizedType;
                if (bl13) {
                    object2 = k.w.g(0, (ParameterizedType)((Object)(clazz = (ParameterizedType)((Object)clazz))));
                    if (object3 == object2) {
                        clazz = k.w.g(n12, (ParameterizedType)((Object)clazz));
                        clazz = this.a.o(clazz, (Annotation[])object);
                        object2 = this.b;
                        object = new n$g((Method)object2, n10, (h)((Object)clazz));
                        return object;
                    }
                    clazz = this.b;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("@HeaderMap keys must be of type String: ");
                    ((StringBuilder)object).append(object2);
                    object = ((StringBuilder)object).toString();
                    object2 = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, (String)stringArray, (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@HeaderMap parameter type must be Map.", (Object[])object);
        }
        n11 = object2 instanceof c;
        if (n11 != 0) {
            this.j(n10, clazz);
            boolean bl14 = this.p;
            if (bl14) {
                object2 = (c)object2;
                object3 = object2.value();
                boolean bl15 = object2.encoded();
                this.f = n12;
                Class<Iterable> clazz5 = Iterable.class;
                type = k.w.h(clazz);
                n11 = (int)(clazz5.isAssignableFrom((Class<?>)type) ? 1 : 0);
                if (n11 != 0) {
                    n11 = clazz instanceof ParameterizedType;
                    if (n11 != 0) {
                        clazz = (ParameterizedType)((Object)clazz);
                        Object object10 = k.w.g(0, (ParameterizedType)((Object)clazz));
                        object10 = this.a.o((Type)object10, (Annotation[])object);
                        clazz = new n$d((String)object3, (h)object10, bl15);
                        return ((n)((Object)clazz)).c();
                    }
                    clazz = this.b;
                    object = new StringBuilder();
                    object2 = ((Class)type).getSimpleName();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string2);
                    object2 = ((Class)type).getSimpleName();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append((String)((Object)clazz2));
                    object = ((StringBuilder)object).toString();
                    object2 = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                }
                n10 = (int)(((Class)type).isArray() ? 1 : 0);
                if (n10 != 0) {
                    Object object11 = q$a.a(((Class)type).getComponentType());
                    object11 = this.a.o((Type)object11, (Annotation[])object);
                    clazz = new n$d((String)object3, (h)object11, bl15);
                    return ((n)((Object)clazz)).b();
                }
                h h14 = this.a.o(clazz, (Annotation[])object);
                clazz = new n$d((String)object3, h14, bl15);
                return clazz;
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@Field parameters can only be used with form encoding.", (Object[])object);
        }
        n11 = object2 instanceof d;
        if (n11 != 0) {
            this.j(n10, clazz);
            boolean bl16 = this.p;
            if (bl16) {
                Class<Map> clazz6 = Map.class;
                type = k.w.h(clazz);
                n11 = clazz6.isAssignableFrom((Class<?>)type);
                if (n11 != 0) {
                    clazz6 = Map.class;
                    bl16 = (clazz = k.w.i(clazz, (Class)type, clazz6)) instanceof ParameterizedType;
                    if (bl16) {
                        type = k.w.g(0, (ParameterizedType)((Object)(clazz = (ParameterizedType)((Object)clazz))));
                        if (object3 == type) {
                            clazz = k.w.g(n12, (ParameterizedType)((Object)clazz));
                            clazz = this.a.o(clazz, (Annotation[])object);
                            this.f = n12;
                            object3 = this.b;
                            boolean bl17 = ((d)object2).encoded();
                            object = new n$e((Method)object3, n10, (h)((Object)clazz), bl17);
                            return object;
                        }
                        clazz = this.b;
                        object = new StringBuilder();
                        ((StringBuilder)object).append("@FieldMap keys must be of type String: ");
                        ((StringBuilder)object).append(type);
                        object = ((StringBuilder)object).toString();
                        object2 = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                    }
                    clazz = this.b;
                    object = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)stringArray, (Object[])object);
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, "@FieldMap parameter type must be Map.", (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@FieldMap parameters can only be used with form encoding.", (Object[])object);
        }
        n11 = object2 instanceof k.z.q;
        if (n11 != 0) {
            this.j(n10, clazz);
            boolean bl18 = this.q;
            if (bl18) {
                object2 = (k.z.q)object2;
                this.g = n12;
                object3 = object2.value();
                Class clazz7 = k.w.h(clazz);
                boolean n13 = ((String)object3).isEmpty();
                if (n13) {
                    object = Iterable.class;
                    boolean bl19 = ((Class)object).isAssignableFrom(clazz7);
                    object2 = "@Part annotation must supply a name or use MultipartBody.Part parameter type.";
                    if (bl19) {
                        bl19 = clazz instanceof ParameterizedType;
                        if (bl19) {
                            clazz = (ParameterizedType)((Object)clazz);
                            boolean bl20 = ((Class)type).isAssignableFrom(clazz = k.w.h(k.w.g(0, (ParameterizedType)((Object)clazz))));
                            if (bl20) {
                                return n$o.a.c();
                            }
                            clazz = this.b;
                            object = new Object[]{};
                            throw k.w.o((Method)((Object)clazz), n10, (String)object2, (Object[])object);
                        }
                        clazz = this.b;
                        object = new StringBuilder();
                        object2 = clazz7.getSimpleName();
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(string2);
                        object2 = clazz7.getSimpleName();
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append((String)((Object)clazz2));
                        object = ((StringBuilder)object).toString();
                        object2 = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                    }
                    boolean bl21 = clazz7.isArray();
                    if (bl21) {
                        clazz = clazz7.getComponentType();
                        bl21 = ((Class)type).isAssignableFrom(clazz);
                        if (bl21) {
                            return n$o.a.b();
                        }
                        clazz = this.b;
                        object = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, (String)object2, (Object[])object);
                    }
                    bl21 = ((Class)type).isAssignableFrom(clazz7);
                    if (bl21) {
                        return n$o.a;
                    }
                    clazz = this.b;
                    object = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)object2, (Object[])object);
                }
                int n14 = 4;
                stringArray = new String[n14];
                stringArray[0] = "Content-Disposition";
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "form-data; name=\"";
                stringBuilder.append(string3);
                stringBuilder.append((String)object3);
                stringBuilder.append("\"");
                stringArray[n12] = object3 = stringBuilder.toString();
                stringArray[2] = "Content-Transfer-Encoding";
                stringArray[3] = object2 = object2.encoding();
                object2 = g.s.l(stringArray);
                object3 = Iterable.class;
                bl18 = ((Class)object3).isAssignableFrom(clazz7);
                String string4 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.";
                if (bl18) {
                    bl18 = clazz instanceof ParameterizedType;
                    if (bl18) {
                        clazz = (ParameterizedType)((Object)clazz);
                        object3 = k.w.h(clazz = k.w.g(0, (ParameterizedType)((Object)clazz)));
                        bl18 = ((Class)type).isAssignableFrom((Class<?>)object3);
                        if (!bl18) {
                            object3 = this.a;
                            type = this.c;
                            clazz = ((s)object3).m(clazz, (Annotation[])object, (Annotation[])type);
                            object3 = this.b;
                            object = new n$i((Method)object3, n10, (g.s)object2, (h)((Object)clazz));
                            return ((n)object).c();
                        }
                        clazz = this.b;
                        object = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, string4, (Object[])object);
                    }
                    clazz = this.b;
                    object = new StringBuilder();
                    object2 = clazz7.getSimpleName();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string2);
                    object2 = clazz7.getSimpleName();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append((String)((Object)clazz2));
                    object = ((StringBuilder)object).toString();
                    object2 = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                }
                bl18 = clazz7.isArray();
                if (bl18) {
                    clazz = q$a.a(clazz7.getComponentType());
                    bl18 = ((Class)type).isAssignableFrom(clazz);
                    if (!bl18) {
                        object3 = this.a;
                        type = this.c;
                        clazz = ((s)object3).m(clazz, (Annotation[])object, (Annotation[])type);
                        object3 = this.b;
                        object = new n$i((Method)object3, n10, (g.s)object2, (h)((Object)clazz));
                        return ((n)object).b();
                    }
                    clazz = this.b;
                    object = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, string4, (Object[])object);
                }
                bl18 = ((Class)type).isAssignableFrom(clazz7);
                if (!bl18) {
                    object3 = this.a;
                    type = this.c;
                    clazz = ((s)object3).m(clazz, (Annotation[])object, (Annotation[])type);
                    object3 = this.b;
                    object = new n$i((Method)object3, n10, (g.s)object2, (h)((Object)clazz));
                    return object;
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, string4, (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@Part parameters can only be used with multipart encoding.", (Object[])object);
        }
        n11 = object2 instanceof r;
        if (n11 != 0) {
            this.j(n10, clazz);
            n11 = this.q;
            if (n11 != 0) {
                this.g = n12;
                clazz2 = Map.class;
                Type type2 = k.w.h(clazz);
                boolean bl3 = clazz2.isAssignableFrom((Class<?>)type2);
                if (bl3) {
                    clazz2 = Map.class;
                    n11 = (clazz = k.w.i(clazz, type2, clazz2)) instanceof ParameterizedType;
                    if (n11 != 0) {
                        type2 = k.w.g(0, (ParameterizedType)((Object)(clazz = (ParameterizedType)((Object)clazz))));
                        if (object3 == type2) {
                            object3 = k.w.h(clazz = k.w.g(n12, (ParameterizedType)((Object)clazz)));
                            boolean bl23 = ((Class)type).isAssignableFrom((Class<?>)object3);
                            if (!bl23) {
                                object3 = this.a;
                                type = this.c;
                                clazz = ((s)object3).m(clazz, (Annotation[])object, (Annotation[])type);
                                object2 = (r)object2;
                                object3 = this.b;
                                object2 = object2.encoding();
                                object = new n$j((Method)object3, n10, (h)((Object)clazz), (String)object2);
                                return object;
                            }
                            clazz = this.b;
                            object = new Object[]{};
                            throw k.w.o((Method)((Object)clazz), n10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", (Object[])object);
                        }
                        clazz = this.b;
                        object = new StringBuilder();
                        ((StringBuilder)object).append("@PartMap keys must be of type String: ");
                        ((StringBuilder)object).append(type2);
                        object = ((StringBuilder)object).toString();
                        object2 = new Object[]{};
                        throw k.w.o((Method)((Object)clazz), n10, (String)object, (Object[])object2);
                    }
                    clazz = this.b;
                    object = new Object[]{};
                    throw k.w.o((Method)((Object)clazz), n10, (String)stringArray, (Object[])object);
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, "@PartMap parameter type must be Map.", (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@PartMap parameters can only be used with multipart encoding.", (Object[])object);
        }
        boolean bl24 = object2 instanceof a;
        if (bl24) {
            this.j(n10, clazz);
            boolean bl25 = this.p;
            if (!bl25 && !(bl25 = this.q)) {
                bl25 = this.h;
                if (!bl25) {
                    try {
                        object2 = this.a;
                    }
                    catch (RuntimeException runtimeException) {
                        object2 = this.b;
                        object3 = new Object[n12];
                        object3[0] = clazz;
                        throw k.w.p((Method)object2, runtimeException, n10, "Unable to create @Body converter for %s", (Object[])object3);
                    }
                    object3 = this.c;
                    clazz = ((s)object2).m(clazz, (Annotation[])object, (Annotation[])object3);
                    this.h = n12;
                    object2 = this.b;
                    object = new n$c((Method)object2, n10, (h)((Object)clazz));
                    return object;
                }
                clazz = this.b;
                object = new Object[]{};
                throw k.w.o((Method)((Object)clazz), n10, "Multiple @Body method annotations found.", (Object[])object);
            }
            clazz = this.b;
            object = new Object[]{};
            throw k.w.o((Method)((Object)clazz), n10, "@Body parameters cannot be used with form or multi-part encoding.", (Object[])object);
        }
        int n14 = object2 instanceof x;
        if (n14 != 0) {
            this.j(n10, clazz);
            clazz = k.w.h(clazz);
            for (n14 = n10 + -1; n14 >= 0; n14 += -1) {
                boolean bl26;
                object2 = this.v[n14];
                bl24 = object2 instanceof n$q;
                if (!bl24 || !(bl26 = (object2 = ((n$q)object2).a).equals(clazz))) continue;
                object2 = this.b;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("@Tag type ");
                clazz = clazz.getName();
                ((StringBuilder)object3).append((String)((Object)clazz));
                ((StringBuilder)object3).append(" is duplicate of parameter #");
                ((StringBuilder)object3).append(n14 += n12);
                ((StringBuilder)object3).append(" and would always overwrite its value.");
                clazz = ((StringBuilder)object3).toString();
                object = new Object[]{};
                throw k.w.o((Method)object2, n10, (String)((Object)clazz), (Object[])object);
            }
            n$q n$q = new n$q(clazz);
            return n$q;
        }
        return null;
    }

    public static Set h(String object) {
        int n10;
        object = y.matcher((CharSequence)object);
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        while ((n10 = ((Matcher)object).find()) != 0) {
            n10 = 1;
            String string2 = ((Matcher)object).group(n10);
            linkedHashSet.add(string2);
        }
        return linkedHashSet;
    }

    private void i(int n10, String string2) {
        Object object = z.matcher(string2);
        boolean bl2 = ((Matcher)object).matches();
        int n11 = 1;
        int n12 = 2;
        if (bl2) {
            object = this.u;
            bl2 = object.contains(string2);
            if (bl2) {
                return;
            }
            object = this.b;
            Object[] objectArray = new Object[n12];
            String string3 = this.r;
            objectArray[0] = string3;
            objectArray[n11] = string2;
            throw k.w.o((Method)object, n10, "URL \"%s\" does not contain \"{%s}\".", objectArray);
        }
        object = this.b;
        Object[] objectArray = new Object[n12];
        String string4 = y.pattern();
        objectArray[0] = string4;
        objectArray[n11] = string2;
        throw k.w.o((Method)object, n10, "@Path parameter name must match %s. Found: %s", objectArray);
    }

    private void j(int n10, Type type) {
        boolean bl2 = k.w.j(type);
        if (!bl2) {
            return;
        }
        Method method = this.b;
        Object[] objectArray = new Object[]{type};
        throw k.w.o(method, n10, "Parameter type must not include a type variable or wildcard: %s", objectArray);
    }

    public q b() {
        Object object;
        int n10;
        Object object2 = this.c;
        int n11 = ((Annotation[])object2).length;
        String string2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            object = object2[n10];
            this.e((Annotation)object);
        }
        object2 = this.n;
        if (object2 != null) {
            boolean bl2;
            int n12 = this.o;
            if (n12 == 0) {
                n12 = this.q;
                if (n12 == 0) {
                    n12 = (int)(this.p ? 1 : 0);
                    if (n12 != 0) {
                        object2 = this.b;
                        Object[] objectArray = new Object[]{};
                        throw k.w.m((Method)object2, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", objectArray);
                    }
                } else {
                    object2 = this.b;
                    Object[] objectArray = new Object[]{};
                    throw k.w.m((Method)object2, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", objectArray);
                }
            }
            object2 = this.d;
            n12 = ((Annotation[])object2).length;
            Object[] objectArray = new n[n12];
            this.v = objectArray;
            n11 = n12 + -1;
            n10 = 0;
            string2 = null;
            while (true) {
                bl2 = true;
                if (n10 >= n12) break;
                n[] nArray = this.v;
                Type type = this.e[n10];
                Annotation[] annotationArray = this.d[n10];
                if (n10 != n11) {
                    bl2 = false;
                    object = null;
                }
                nArray[n10] = object = this.f(n10, type, annotationArray, bl2);
                ++n10;
            }
            object2 = this.r;
            if (object2 == null && (n12 = (int)(this.m ? 1 : 0)) == 0) {
                object2 = this.b;
                objectArray = new Object[bl2];
                string2 = this.n;
                objectArray[0] = string2;
                throw k.w.m((Method)object2, "Missing either @%s URL or @Url parameter.", objectArray);
            }
            n12 = (int)(this.p ? 1 : 0);
            if (n12 == 0 && (n11 = (int)(this.q ? 1 : 0)) == 0 && (n11 = (int)(this.o ? 1 : 0)) == 0 && (n11 = (int)(this.h ? 1 : 0)) != 0) {
                object2 = this.b;
                objectArray = new Object[]{};
                throw k.w.m((Method)object2, "Non-body HTTP method cannot contain @Body.", objectArray);
            }
            if (n12 != 0 && (n12 = (int)(this.f ? 1 : 0)) == 0) {
                object2 = this.b;
                objectArray = new Object[]{};
                throw k.w.m((Method)object2, "Form-encoded method must contain at least one @Field.", objectArray);
            }
            n12 = (int)(this.q ? 1 : 0);
            if (n12 != 0 && (n12 = (int)(this.g ? 1 : 0)) == 0) {
                object2 = this.b;
                objectArray = new Object[]{};
                throw k.w.m((Method)object2, "Multipart method must contain at least one @Part.", objectArray);
            }
            object2 = new q(this);
            return object2;
        }
        object2 = this.b;
        Object[] objectArray = new Object[]{};
        throw k.w.m((Method)object2, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", objectArray);
    }
}

