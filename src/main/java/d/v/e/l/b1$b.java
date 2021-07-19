/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.LinkProperties
 *  android.net.Network
 *  android.net.NetworkCapabilities
 */
package d.v.e.l;

import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;

public class b1$b {
    public Network a;
    public NetworkCapabilities b;
    public LinkProperties c;

    public b1$b(Network network) {
        this.a = network;
    }

    public LinkProperties a() {
        return this.c;
    }

    public Network b() {
        return this.a;
    }

    public NetworkCapabilities c() {
        return this.b;
    }

    public void d(LinkProperties linkProperties) {
        this.c = linkProperties;
    }

    public void e(Network network) {
        this.a = network;
    }

    public void f(NetworkCapabilities networkCapabilities) {
        this.b = networkCapabilities;
    }
}

