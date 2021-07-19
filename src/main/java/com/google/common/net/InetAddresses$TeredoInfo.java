/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.net.InetAddresses;
import java.net.Inet4Address;

public final class InetAddresses$TeredoInfo {
    private final Inet4Address client;
    private final int flags;
    private final int port;
    private final Inet4Address server;

    public InetAddresses$TeredoInfo(Inet4Address inet4Address, Inet4Address inet4Address2, int n10, int n11) {
        Inet4Address inet4Address3;
        boolean bl2 = true;
        char c10 = (char)-1;
        boolean bl3 = n10 >= 0 && n10 <= c10 ? bl2 : false;
        String string2 = "port '%s' is out of range (0 <= port <= 0xffff)";
        Preconditions.checkArgument(bl3, string2, n10);
        if (n11 < 0 || n11 > c10) {
            bl2 = false;
            inet4Address3 = null;
        }
        Preconditions.checkArgument(bl2, "flags '%s' is out of range (0 <= flags <= 0xffff)", n11);
        inet4Address3 = InetAddresses.access$000();
        this.server = inet4Address = (Inet4Address)MoreObjects.firstNonNull(inet4Address, inet4Address3);
        inet4Address = InetAddresses.access$000();
        this.client = inet4Address = (Inet4Address)MoreObjects.firstNonNull(inet4Address2, inet4Address);
        this.port = n10;
        this.flags = n11;
    }

    public Inet4Address getClient() {
        return this.client;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getPort() {
        return this.port;
    }

    public Inet4Address getServer() {
        return this.server;
    }
}

