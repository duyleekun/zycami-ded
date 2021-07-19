/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleAdapterDisabledException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.s0.b;

public class BleDisconnectedException
extends BleException {
    public static final int UNKNOWN_STATUS = 255;
    public final String bluetoothDeviceAddress;
    public final int state;

    public BleDisconnectedException() {
        this("", -1);
    }

    public BleDisconnectedException(String string2) {
        this(string2, -1);
    }

    public BleDisconnectedException(String string2, int n10) {
        String string3 = BleDisconnectedException.a(string2, n10);
        super(string3);
        this.bluetoothDeviceAddress = string2;
        this.state = n10;
    }

    public BleDisconnectedException(Throwable throwable, String string2) {
        this(throwable, string2, -1);
    }

    public BleDisconnectedException(Throwable throwable, String string2, int n10) {
        String string3 = BleDisconnectedException.a(string2, n10);
        super(string3, throwable);
        this.bluetoothDeviceAddress = string2;
        this.state = n10;
    }

    private static String a(String string2, int n10) {
        String string3 = b.a(n10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Disconnected from ");
        string2 = d.n.a.q0.t.b.d(string2);
        stringBuilder.append(string2);
        stringBuilder.append(" with status ");
        stringBuilder.append(n10);
        stringBuilder.append(" (");
        stringBuilder.append(string3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static BleDisconnectedException adapterDisabled(String string2) {
        BleAdapterDisabledException bleAdapterDisabledException = new BleAdapterDisabledException();
        BleDisconnectedException bleDisconnectedException = new BleDisconnectedException(bleAdapterDisabledException, string2, -1);
        return bleDisconnectedException;
    }
}

