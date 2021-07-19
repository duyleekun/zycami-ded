/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import g.h0.n.e$a;
import g.h0.n.e$b;
import g.h0.n.h;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class e
extends h {
    public static final e$b k;
    private final Method f;
    private final Method g;
    private final Method h;
    private final Class i;
    private final Class j;

    static {
        e$b e$b;
        k = e$b = new e$b(null);
    }

    public e(Method method, Method method2, Method method3, Class clazz, Class clazz2) {
        f0.p(method, "putMethod");
        f0.p(method2, "getMethod");
        f0.p(method3, "removeMethod");
        f0.p(clazz, "clientProviderClass");
        f0.p(clazz2, "serverProviderClass");
        this.f = method;
        this.g = method2;
        this.h = method3;
        this.i = clazz;
        this.j = clazz2;
    }

    public void c(SSLSocket sSLSocket) {
        String string2 = "failed to remove ALPN";
        Object object = "sslSocket";
        f0.p(sSLSocket, (String)object);
        object = this.h;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = sSLSocket;
        try {
            ((Method)object).invoke(null, objectArray);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new AssertionError(string2, invocationTargetException);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new AssertionError(string2, illegalAccessException);
            throw object;
        }
    }

    public void f(SSLSocket sSLSocket, String string2, List object) {
        string2 = "failed to set ALPN";
        f0.p(sSLSocket, "sslSocket");
        f0.p(object, "protocols");
        object = g.h0.n.h.e.b((List)object);
        Object object2 = h.class;
        object2 = ((Class)object2).getClassLoader();
        int n10 = 2;
        Class[] classArray = new Class[n10];
        Object object3 = this.i;
        classArray[0] = object3;
        object3 = this.j;
        int n11 = 1;
        classArray[n11] = object3;
        object3 = new e$a((List)object);
        object = Proxy.newProxyInstance((ClassLoader)object2, classArray, (InvocationHandler)object3);
        object2 = this.f;
        classArray = null;
        Object[] objectArray = new Object[n10];
        objectArray[0] = sSLSocket;
        objectArray[n11] = object;
        try {
            ((Method)object2).invoke(null, objectArray);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new AssertionError(string2, illegalAccessException);
            throw object;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new AssertionError(string2, invocationTargetException);
            throw object;
        }
    }

    public String j(SSLSocket object) {
        Object object2;
        String string2;
        block15: {
            block17: {
                int n10;
                block16: {
                    string2 = "failed to get ALPN selected protocol";
                    object2 = "sslSocket";
                    f0.p(object, (String)object2);
                    object2 = this.g;
                    n10 = 1;
                    Object object3 = new Object[n10];
                    object3[0] = object;
                    object = null;
                    object2 = ((Method)object2).invoke(null, object3);
                    object2 = Proxy.getInvocationHandler(object2);
                    if (object2 == null) break block15;
                    object2 = (e$a)object2;
                    n10 = (int)(((e$a)object2).b() ? 1 : 0);
                    if (n10 != 0) break block16;
                    object3 = ((e$a)object2).a();
                    if (object3 != null) break block16;
                    String string3 = "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?";
                    int n11 = 6;
                    g.h0.n.h.n(this, string3, 0, null, n11, null);
                    return null;
                }
                n10 = (int)(((e$a)object2).b() ? 1 : 0);
                if (n10 != 0) break block17;
                object = ((e$a)object2).a();
            }
            return object;
        }
        object2 = "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider";
        try {
            object = new NullPointerException((String)object2);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new AssertionError(string2, illegalAccessException);
            throw object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = new AssertionError(string2, invocationTargetException);
            throw object2;
        }
    }
}

