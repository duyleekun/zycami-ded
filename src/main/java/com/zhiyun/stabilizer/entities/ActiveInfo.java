/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.zhiyun.protocol.message.bl.active.ActiveState;

public class ActiveInfo {
    public final byte[] activeCode;
    public final String date;
    public final ActiveState state;

    public ActiveInfo(ActiveState activeState, String string2, byte[] byArray) {
        this.date = string2;
        this.state = activeState;
        this.activeCode = byArray;
    }
}

