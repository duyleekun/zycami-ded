/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

public class MoveLine {
    public final boolean ble;
    public final boolean move;
    public final boolean wifi;

    public MoveLine() {
        this.move = false;
        this.ble = false;
        this.wifi = false;
    }

    public MoveLine(boolean bl2, boolean bl3, boolean bl4) {
        this.move = bl2;
        this.ble = bl3;
        this.wifi = bl4;
    }
}

