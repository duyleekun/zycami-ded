/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.e;
import g.h0.n.h;
import java.lang.reflect.Method;
import javax.net.ssl.SSLSocket;

public final class e$b {
    private e$b() {
    }

    public /* synthetic */ e$b(u u10) {
        this();
    }

    public final h a() {
        Object object = System.getProperty("java.specification.version", "unknown");
        Object object2 = "jvmVersion";
        try {
            f0.o(object, (String)object2);
            int n10 = Integer.parseInt((String)object);
            int n11 = 9;
            if (n10 >= n11) {
                return null;
            }
        }
        catch (NumberFormatException numberFormatException) {}
        object = "org.eclipse.jetty.alpn.ALPN";
        object2 = "org.eclipse.jetty.alpn.ALPN";
        int n12 = 1;
        object2 = Class.forName((String)object2, n12 != 0, null);
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object);
        Object object4 = "$Provider";
        ((StringBuilder)object3).append((String)object4);
        object3 = ((StringBuilder)object3).toString();
        object3 = Class.forName((String)object3, n12 != 0, null);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object);
        Object object5 = "$ClientProvider";
        ((StringBuilder)object4).append((String)object5);
        object4 = ((StringBuilder)object4).toString();
        Class<?> clazz = Class.forName((String)object4, n12 != 0, null);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object);
        object = "$ServerProvider";
        ((StringBuilder)object4).append((String)object);
        object = ((StringBuilder)object4).toString();
        Class<?> clazz2 = Class.forName((String)object, n12 != 0, null);
        object = "put";
        int n13 = 2;
        object4 = new Class[n13];
        object5 = SSLSocket.class;
        object4[0] = object5;
        object4[n12] = object3;
        object = ((Class)object2).getMethod((String)object, (Class<?>)object4);
        object3 = "get";
        object4 = new Class[n12];
        object5 = SSLSocket.class;
        object4[0] = object5;
        Method method = ((Class)object2).getMethod((String)object3, (Class<?>)object4);
        object3 = "remove";
        Object object6 = new Class[n12];
        object4 = SSLSocket.class;
        object6[0] = object4;
        Method method2 = ((Class)object2).getMethod((String)object3, (Class<?>)object6);
        object6 = "putMethod";
        f0.o(object, (String)object6);
        object6 = "getMethod";
        f0.o(method, (String)object6);
        object6 = "removeMethod";
        f0.o(method2, (String)object6);
        object6 = "clientProviderClass";
        f0.o(clazz, (String)object6);
        object6 = "serverProviderClass";
        f0.o(clazz2, (String)object6);
        object5 = object2;
        try {
            object2 = new e((Method)object, method, method2, clazz, clazz2);
            return object2;
        }
        catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
            return null;
        }
    }
}

