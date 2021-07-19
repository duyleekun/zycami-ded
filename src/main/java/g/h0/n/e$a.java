/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class e$a
implements InvocationHandler {
    private boolean a;
    private String b;
    private final List c;

    public e$a(List list) {
        f0.p(list, "protocols");
        this.c = list;
    }

    public final String a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public final void c(String string2) {
        this.b = string2;
    }

    public final void d(boolean bl2) {
        this.a = bl2;
    }

    public Object invoke(Object object, Method object2, Object[] object3) {
        int n10;
        int n11;
        String string2 = "proxy";
        f0.p(object, string2);
        f0.p(object2, "method");
        int n12 = 0;
        object = null;
        if (object3 == null) {
            object3 = new Object[]{};
        }
        string2 = ((Method)object2).getName();
        Object object4 = ((Method)object2).getReturnType();
        Object object5 = "supports";
        int n13 = f0.g(string2, object5);
        if (n13 != 0 && (n13 = f0.g(object5 = Boolean.TYPE, object4)) != 0) {
            return Boolean.TRUE;
        }
        object5 = "unsupported";
        n13 = f0.g(string2, object5);
        int n14 = 1;
        if (n13 != 0 && (n13 = f0.g(object5 = Void.TYPE, object4)) != 0) {
            this.a = n14;
            return null;
        }
        object5 = "protocols";
        n13 = f0.g(string2, object5);
        if (n13 != 0) {
            n13 = ((Object[])object3).length;
            if (n13 == 0) {
                n13 = n14;
            } else {
                n13 = 0;
                object5 = null;
            }
            if (n13 != 0) {
                return this.c;
            }
        }
        object5 = "selectProtocol";
        n13 = (int)(f0.g(string2, object5) ? 1 : 0);
        String string3 = "null cannot be cast to non-null type kotlin.String";
        if ((n13 != 0 || (n13 = (int)(f0.g(string2, object5 = "select") ? 1 : 0)) != 0) && (n11 = f0.g(object5 = String.class, object4)) != 0 && (n11 = ((Object[])object3).length) == n14 && (n11 = (object4 = object3[0]) instanceof List) != 0) {
            object2 = object3[0];
            object3 = "null cannot be cast to non-null type kotlin.collections.List<*>";
            Objects.requireNonNull(object2, (String)object3);
            object2 = (List)object2;
            int n15 = object2.size();
            if (n15 >= 0) {
                int n16 = 0;
                string2 = null;
                while (true) {
                    object4 = object2.get(n16);
                    Objects.requireNonNull(object4, string3);
                    object4 = (String)object4;
                    object5 = this.c;
                    n13 = (int)(object5.contains(object4) ? 1 : 0);
                    if (n13 != 0) {
                        this.b = object4;
                        return object4;
                    }
                    if (n16 == n15) break;
                    ++n16;
                }
            }
            this.b = object = (String)this.c.get(0);
            return object;
        }
        object4 = "protocolSelected";
        n11 = (int)(f0.g(string2, object4) ? 1 : 0);
        if ((n11 != 0 || (n10 = (int)(f0.g(string2, object4 = "selected") ? 1 : 0)) != 0) && (n10 = ((Object[])object3).length) == n14) {
            object = object3[0];
            Objects.requireNonNull(object, string3);
            this.b = object = (String)object;
            return null;
        }
        n12 = ((Object[])object3).length;
        object = Arrays.copyOf(object3, n12);
        return ((Method)object2).invoke(this, object);
    }
}

