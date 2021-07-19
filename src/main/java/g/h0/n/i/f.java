/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import g.h0.n.b;
import g.h0.n.h;
import g.h0.n.h$a;
import g.h0.n.i.f$a;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import g.h0.n.i.k$a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class f
implements k {
    private static final j$a f;
    public static final f$a g;
    private final Method a;
    private final Method b;
    private final Method c;
    private final Method d;
    private final Class e;

    static {
        f$a f$a;
        g = f$a = new f$a(null);
        f = f$a.c("com.google.android.gms.org.conscrypt");
    }

    public f(Class genericDeclaration) {
        Class<Boolean> clazz;
        f0.p(genericDeclaration, "sslSocketClass");
        this.e = genericDeclaration;
        int n10 = 1;
        Object object = new Class[n10];
        object[0] = clazz = Boolean.TYPE;
        object = genericDeclaration.getDeclaredMethod("setUseSessionTickets", (Class<?>)object);
        f0.o(object, "sslSocketClass.getDeclar\u2026:class.javaPrimitiveType)");
        this.a = object;
        object = new Class[n10];
        object[0] = String.class;
        this.b = object = genericDeclaration.getMethod("setHostname", (Class<?>)object);
        object = new Class[]{};
        this.c = object = genericDeclaration.getMethod("getAlpnSelectedProtocol", (Class<?>)object);
        Class[] classArray = new Class[n10];
        classArray[0] = byte[].class;
        genericDeclaration = genericDeclaration.getMethod("setAlpnProtocols", classArray);
        this.d = genericDeclaration;
    }

    public static final /* synthetic */ j$a g() {
        return f;
    }

    public boolean a(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
        return this.e.isInstance(sSLSocket);
    }

    public boolean b() {
        return g.h0.n.b.i.b();
    }

    public String c(SSLSocket object) {
        NullPointerException nullPointerException2;
        block12: {
            Object object2;
            block11: {
                Object object3 = "sslSocket";
                f0.p(object, (String)object3);
                boolean bl2 = this.a((SSLSocket)object);
                object2 = null;
                if (!bl2) {
                    return null;
                }
                object3 = this.c;
                Object object4 = null;
                object4 = new Object[]{};
                object = ((Method)object3).invoke(object, object4);
                object = (byte[])object;
                if (object == null) break block11;
                object3 = StandardCharsets.UTF_8;
                object4 = "StandardCharsets.UTF_8";
                f0.o(object3, (String)object4);
                try {
                    object2 = object4 = new String((byte[])object, (Charset)object3);
                }
                catch (InvocationTargetException invocationTargetException) {
                    object3 = new AssertionError((Object)invocationTargetException);
                    throw object3;
                }
                catch (IllegalAccessException illegalAccessException) {
                    object3 = new AssertionError((Object)illegalAccessException);
                    throw object3;
                }
                catch (NullPointerException nullPointerException2) {
                    object3 = nullPointerException2.getMessage();
                    object4 = "ssl == null";
                    bl2 = f0.g(object3, object4);
                    if (!bl2) break block12;
                }
            }
            return object2;
        }
        throw nullPointerException2;
    }

    public X509TrustManager d(SSLSocketFactory sSLSocketFactory) {
        f0.p(sSLSocketFactory, "sslSocketFactory");
        return k$a.b(this, sSLSocketFactory);
    }

    public boolean e(SSLSocketFactory sSLSocketFactory) {
        f0.p(sSLSocketFactory, "sslSocketFactory");
        return k$a.a(this, sSLSocketFactory);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(SSLSocket sSLSocket, String object, List object2) {
        f0.p(sSLSocket, "sslSocket");
        Object[] objectArray = "protocols";
        f0.p(object2, (String)objectArray);
        boolean bl2 = this.a(sSLSocket);
        if (!bl2) return;
        try {
            objectArray = this.a;
            int n10 = 1;
            Object[] objectArray2 = new Object[n10];
            Boolean bl3 = Boolean.TRUE;
            objectArray2[0] = bl3;
            objectArray.invoke(sSLSocket, objectArray2);
            if (object != null) {
                objectArray = this.b;
                objectArray2 = new Object[n10];
                objectArray2[0] = object;
                objectArray.invoke(sSLSocket, objectArray2);
            }
            object = this.d;
            objectArray = new Object[n10];
            h$a h$a = h.e;
            objectArray[0] = object2 = (Object)h$a.c((List)object2);
            ((Method)object).invoke(sSLSocket, objectArray);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            object = new AssertionError((Object)invocationTargetException);
            throw object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new AssertionError((Object)illegalAccessException);
            throw object;
        }
    }
}

