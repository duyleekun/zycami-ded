/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.active;

public final class ActiveState
extends Enum {
    public static final /* enum */ ActiveState ACTIVATED;
    public static final /* enum */ ActiveState EXPIRED;
    public static final /* enum */ ActiveState INACTIVATED;
    private static final /* synthetic */ ActiveState[] a;
    public final int code;

    static {
        ActiveState activeState;
        ActiveState activeState2;
        ActiveState activeState3;
        INACTIVATED = activeState3 = new ActiveState("INACTIVATED", 0, 0);
        int n10 = 1;
        ACTIVATED = activeState2 = new ActiveState("ACTIVATED", n10, n10);
        int n11 = 2;
        EXPIRED = activeState = new ActiveState("EXPIRED", n11, n11);
        ActiveState[] activeStateArray = new ActiveState[3];
        activeStateArray[0] = activeState3;
        activeStateArray[n10] = activeState2;
        activeStateArray[n11] = activeState;
        a = activeStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ActiveState() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.code = var3_1;
    }

    public static ActiveState from(int n10) {
        ActiveState activeState = INACTIVATED;
        for (ActiveState activeState2 : ActiveState.values()) {
            int n11 = activeState2.code;
            if (n11 != n10) continue;
            activeState = activeState2;
            break;
        }
        return activeState;
    }

    public static ActiveState valueOf(String string2) {
        return Enum.valueOf(ActiveState.class, string2);
    }

    public static ActiveState[] values() {
        return (ActiveState[])a.clone();
    }
}

