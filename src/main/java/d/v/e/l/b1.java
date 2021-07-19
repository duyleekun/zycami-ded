/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.Network
 *  android.net.NetworkCapabilities
 *  android.net.NetworkRequest
 *  android.net.NetworkRequest$Builder
 *  android.os.Build$VERSION
 */
package d.v.e.l;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import d.v.e.l.b1$a;
import d.v.e.l.b1$b;
import d.v.e.l.b1$c;
import java.util.HashMap;
import java.util.Map;
import m.a.a;

public class b1 {
    private b1$c a;
    private ConnectivityManager b;
    private ConnectivityManager.NetworkCallback c;
    private Map d;

    public b1() {
        HashMap hashMap;
        this.d = hashMap = new HashMap();
    }

    public static /* synthetic */ b1$b a(b1 b12, Network network) {
        return b12.j(network);
    }

    public static /* synthetic */ void b(b1 b12, b1$b b1$b) {
        b12.g(b1$b);
    }

    public static /* synthetic */ void c(b1 b12, Network network) {
        b12.r(network);
    }

    public static /* synthetic */ void d(b1 b12, b1$b b1$b) {
        b12.e(b1$b);
    }

    private void e(b1$b b1$b) {
        boolean bl2;
        boolean bl3 = this.l((NetworkCapabilities)(b1$b = b1$b.c()), (int)((bl2 = true) ? 1 : 0));
        if (bl3) {
            boolean bl4 = this.k((NetworkCapabilities)b1$b);
            this.f(bl4, bl2, false);
        } else {
            bl3 = this.l((NetworkCapabilities)b1$b, 0);
            if (bl3) {
                boolean bl5 = this.k((NetworkCapabilities)b1$b);
                this.f(bl5, false, bl2);
            }
        }
    }

    private void f(boolean bl2, boolean bl3, boolean bl4) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("callConnected, hasNetCapability:");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(" isWifiType:");
        ((StringBuilder)object).append(bl3);
        ((StringBuilder)object).append(" isMobileType:");
        ((StringBuilder)object).append(bl4);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
        object = this.a;
        if (object != null) {
            Object object2;
            if (bl3) {
                object2 = new Object[]{};
                object = "WiFi\u7f51\u7edc\u8fde\u63a5";
                m.a.a.i((String)object, (Object[])object2);
                object2 = this.a;
                object2.c(bl2);
            }
            if (bl4) {
                object2 = new Object[]{};
                String string2 = "\u8702\u7a9d\u7f51\u7edc\u8fde\u63a5";
                m.a.a.i(string2, (Object[])object2);
                object2 = this.a;
                object2.a(bl2);
            }
        }
    }

    private void g(b1$b b1$b) {
        boolean bl2;
        NetworkCapabilities networkCapabilities = b1$b.c();
        boolean bl3 = this.l(networkCapabilities, (int)((bl2 = true) ? 1 : 0));
        if (bl3) {
            this.h(bl2, false);
        } else {
            boolean bl4 = this.l((NetworkCapabilities)(b1$b = b1$b.c()), 0);
            if (bl4) {
                this.h(false, bl2);
            }
        }
    }

    private void h(boolean bl2, boolean bl3) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("callDisconnected, isWifiType:");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(" isMobileType:");
        ((StringBuilder)object).append(bl3);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
        object = this.a;
        if (object != null) {
            Object object2;
            if (bl2) {
                object2 = new Object[]{};
                object = "WiFi\u7f51\u7edc\u65ad\u5f00";
                m.a.a.i((String)object, (Object[])object2);
                object2 = this.a;
                object2.b();
            }
            if (bl3) {
                object2 = new Object[]{};
                String string2 = "\u8702\u7a9d\u7f51\u7edc\u65ad\u5f00";
                m.a.a.i(string2, (Object[])object2);
                object2 = this.a;
                object2.d();
            }
        }
    }

    private String i(Network network) {
        return network.toString();
    }

    private b1$b j(Network object) {
        Object object2 = this.d;
        Object object3 = this.i((Network)object);
        if ((object2 = (b1$b)object2.get(object3)) == null) {
            object2 = new b1$b((Network)object);
            object3 = this.d;
            object = this.i((Network)object);
            object3.put(object, object2);
        }
        return object2;
    }

    private boolean k(NetworkCapabilities networkCapabilities) {
        int n10;
        boolean bl2;
        if (networkCapabilities != null && (bl2 = networkCapabilities.hasCapability(n10 = 16))) {
            bl2 = true;
        } else {
            bl2 = false;
            networkCapabilities = null;
        }
        return bl2;
    }

    private boolean l(NetworkCapabilities networkCapabilities, int n10) {
        boolean bl2;
        if (networkCapabilities != null && (bl2 = networkCapabilities.hasTransport(n10))) {
            bl2 = true;
        } else {
            bl2 = false;
            networkCapabilities = null;
        }
        return bl2;
    }

    private void r(Network object) {
        Map map = this.d;
        object = this.i((Network)object);
        map.remove(object);
    }

    public boolean m(boolean bl2) {
        Network[] networkArray = this.b.getAllNetworks();
        int n10 = networkArray.length;
        boolean bl3 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            Network network = networkArray[i10];
            ConnectivityManager connectivityManager = this.b;
            network = connectivityManager.getNetworkCapabilities(network);
            boolean bl4 = this.l((NetworkCapabilities)network, (int)(bl2 ? 1 : 0));
            bl3 |= bl4;
        }
        return bl3;
    }

    public boolean n() {
        return this.m(false);
    }

    public boolean o() {
        return this.m(true);
    }

    public void p(Context object, b1$c networkCallback) {
        this.a = networkCallback;
        networkCallback = this.c;
        if (networkCallback == null) {
            networkCallback = this.b;
            if (networkCallback == null) {
                networkCallback = "connectivity";
                object = (ConnectivityManager)object.getSystemService((String)networkCallback);
                this.b = object;
            }
            object = new b1$a(this);
            this.c = object;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if (n10 >= n11) {
                networkCallback = this.b;
                networkCallback.registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback)object);
            } else {
                object = new NetworkRequest.Builder();
                object = object.build();
                networkCallback = this.b;
                ConnectivityManager.NetworkCallback networkCallback2 = this.c;
                networkCallback.registerNetworkCallback((NetworkRequest)object, networkCallback2);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("onRegister onRegister: ");
            networkCallback = this.c;
            ((StringBuilder)object).append(networkCallback);
            object = ((StringBuilder)object).toString();
            n10 = 0;
            networkCallback = new Object[]{};
            m.a.a.b((String)object, (Object[])networkCallback);
        }
    }

    public void q() {
        Object object = this.c;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("onUnregister: ");
            Object[] objectArray = this.c;
            ((StringBuilder)object).append(objectArray);
            object = ((StringBuilder)object).toString();
            objectArray = new Object[]{};
            m.a.a.b((String)object, objectArray);
            object = this.b;
            objectArray = this.c;
            object.unregisterNetworkCallback((ConnectivityManager.NetworkCallback)objectArray);
            this.d.clear();
            object = null;
            this.c = null;
        }
    }
}

