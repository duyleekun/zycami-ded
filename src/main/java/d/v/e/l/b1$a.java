/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.LinkProperties
 *  android.net.Network
 *  android.net.NetworkCapabilities
 */
package d.v.e.l;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import d.v.e.l.b1;
import d.v.e.l.b1$b;
import m.a.a;

public class b1$a
extends ConnectivityManager.NetworkCallback {
    public String a = "registerNetworkCallback";
    public final /* synthetic */ b1 b;

    public b1$a(b1 b12) {
        this.b = b12;
    }

    public void onAvailable(Network network) {
        super.onAvailable(network);
        CharSequence charSequence = new StringBuilder();
        Object[] objectArray = this.a;
        charSequence.append((String)objectArray);
        charSequence.append(" onAvailable,");
        charSequence.append(network);
        charSequence = charSequence.toString();
        objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        b1.a(this.b, network);
    }

    public void onBlockedStatusChanged(Network object, boolean bl2) {
        super.onBlockedStatusChanged(object, bl2);
        Object[] objectArray = new StringBuilder();
        String string2 = this.a;
        objectArray.append(string2);
        objectArray.append(" onBlockedStatusChanged,");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public void onCapabilitiesChanged(Network object, NetworkCapabilities object2) {
        super.onCapabilitiesChanged((Network)object, object2);
        CharSequence charSequence = new StringBuilder();
        Object[] objectArray = this.a;
        charSequence.append((String)objectArray);
        charSequence.append(" onCapabilitiesChanged,");
        charSequence.append(object);
        charSequence.append(" networkCapabilities:");
        charSequence.append(object2);
        charSequence = charSequence.toString();
        objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        object = b1.a(this.b, (Network)object);
        charSequence = ((b1$b)object).c();
        if (charSequence == null) {
            ((b1$b)object).f((NetworkCapabilities)object2);
            object2 = this.b;
            b1.d((b1)object2, (b1$b)object);
        } else {
            ((b1$b)object).f((NetworkCapabilities)object2);
        }
    }

    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        super.onLinkPropertiesChanged(network, linkProperties);
        CharSequence charSequence = new StringBuilder();
        Object[] objectArray = this.a;
        charSequence.append((String)objectArray);
        charSequence.append(" onLinkPropertiesChanged,");
        charSequence.append(network);
        charSequence = charSequence.toString();
        objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        b1.a(this.b, network).d(linkProperties);
    }

    public void onLosing(Network object, int n10) {
        super.onLosing(object, n10);
        Object[] objectArray = new StringBuilder();
        String string2 = this.a;
        objectArray.append(string2);
        objectArray.append(" onLosing,");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        m.a.a.b((String)object, objectArray);
    }

    public void onLost(Network network) {
        super.onLost(network);
        Object object = new StringBuilder();
        Object object2 = this.a;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" onLost,");
        ((StringBuilder)object).append(network);
        object = ((StringBuilder)object).toString();
        object2 = new Object[]{};
        m.a.a.b((String)object, object2);
        object = this.b;
        object2 = b1.a((b1)object, network);
        b1.b((b1)object, (b1$b)object2);
        b1.c(this.b, network);
    }

    public void onUnavailable() {
        super.onUnavailable();
        CharSequence charSequence = new StringBuilder();
        Object[] objectArray = this.a;
        charSequence.append((String)objectArray);
        charSequence.append(" onUnavailable");
        charSequence = charSequence.toString();
        objectArray = new Object[]{};
        m.a.a.x((String)charSequence, objectArray);
    }
}

