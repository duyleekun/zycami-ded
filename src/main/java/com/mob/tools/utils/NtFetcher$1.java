/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager$NetworkCallback
 *  android.net.LinkProperties
 *  android.net.Network
 *  android.net.NetworkCapabilities
 */
package com.mob.tools.utils;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.mob.tools.utils.NtFetcher;

public class NtFetcher$1
extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ NtFetcher this$0;

    public NtFetcher$1(NtFetcher ntFetcher) {
        this.this$0 = ntFetcher;
    }

    public void onAvailable(Network network) {
        super.onAvailable(network);
        NtFetcher.access$000(this.this$0);
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
    }

    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        super.onLinkPropertiesChanged(network, linkProperties);
    }

    public void onLosing(Network network, int n10) {
        super.onLosing(network, n10);
    }

    public void onLost(Network network) {
        super.onLost(network);
        NtFetcher.access$000(this.this$0);
    }

    public void onUnavailable() {
        super.onUnavailable();
    }
}

