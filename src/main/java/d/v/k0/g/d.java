/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.k0.g;

import android.text.TextUtils;
import com.zhiyun.zysocket.util.SocketUtil;
import d.v.k0.g.a;
import d.v.k0.g.b;
import e.a.h0;
import e.a.i0;
import e.a.v0.g;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.MulticastSocket;

public class d {
    public static DatagramSocket a(int n10) {
        d.v.k0.f.b b10 = new d.v.k0.f.b();
        return b10.f(n10).d(true).a();
    }

    public static DatagramSocket b() {
        d.v.k0.f.b b10 = new d.v.k0.f.b();
        return b10.d(true).a();
    }

    public static MulticastSocket c(int n10, InetAddress inetAddress) {
        d.v.k0.f.b b10 = new d.v.k0.f.b();
        Object object = b10.f(n10);
        boolean bl2 = true;
        if ((object = ((d.v.k0.f.b)object).d(bl2).b()) != null) {
            ((MulticastSocket)object).joinGroup(inetAddress);
        }
        return object;
    }

    public static MulticastSocket d() {
        d.v.k0.f.b b10 = new d.v.k0.f.b();
        return b10.d(true).b();
    }

    public static InetAddress e(String string2) {
        Object object = SocketUtil.m(string2);
        if (object != null) {
            return ((InterfaceAddress)object).getBroadcast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not a available address:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static InetAddress f(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = "224.2.2.0";
        }
        object = InetAddress.getByName((String)object);
        ((InetAddress)object).isMulticastAddress();
        return object;
    }

    public static /* synthetic */ void g(Object object, Runnable runnable) {
        if (object != null) {
            runnable.run();
        }
    }

    public static void h(String string2, Throwable throwable, int n10, d.v.k0.e.a a10) {
        int n11 = 2;
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        Object object = n10;
        int n12 = 1;
        objectArray[n12] = object;
        object = "%s,errorCode:%s";
        m.a.a.k(throwable, (String)object, objectArray);
        if (a10 != null) {
            a10.b(string2, throwable, n10);
        }
    }

    public static void i(Runnable object) {
        object = i0.x0(object);
        Object object2 = e.a.q0.c.a.c();
        object = ((i0)object).O0((h0)object2);
        object2 = b.a;
        ((i0)object).b0((g)object2).a();
    }

    public static void j(Runnable object, Object object2) {
        object = i0.x0(object);
        Object object3 = e.a.q0.c.a.c();
        object = ((i0)object).O0((h0)object3);
        object3 = new a(object2);
        ((i0)object).b0((g)object3).a();
    }
}

