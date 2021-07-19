/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zysocket.udp.interactive;

import d.v.k0.f.d.a;

public class UdpInteractiveException
extends Exception {
    private final int errorCode;
    private final a mUdpMessage;

    public UdpInteractiveException(Throwable throwable, a a10, int n10) {
        super(throwable);
        this.mUdpMessage = a10;
        this.errorCode = n10;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public a getUdpMessage() {
        return this.mUdpMessage;
    }
}

