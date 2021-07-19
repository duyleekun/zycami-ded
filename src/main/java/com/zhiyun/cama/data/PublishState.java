/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

public final class PublishState
extends Enum {
    public static final /* enum */ PublishState STATE_CANCEL;
    public static final /* enum */ PublishState STATE_FAILED;
    public static final /* enum */ PublishState STATE_NONE;
    public static final /* enum */ PublishState STATE_PUBLISHING;
    public static final /* enum */ PublishState STATE_SUCCESS;
    private static final /* synthetic */ PublishState[] a;

    static {
        PublishState publishState;
        PublishState publishState2;
        PublishState publishState3;
        PublishState publishState4;
        PublishState publishState5;
        STATE_NONE = publishState5 = new PublishState("STATE_NONE", 0);
        int n10 = 1;
        STATE_PUBLISHING = publishState4 = new PublishState("STATE_PUBLISHING", n10);
        int n11 = 2;
        STATE_SUCCESS = publishState3 = new PublishState("STATE_SUCCESS", n11);
        int n12 = 3;
        STATE_FAILED = publishState2 = new PublishState("STATE_FAILED", n12);
        int n13 = 4;
        STATE_CANCEL = publishState = new PublishState("STATE_CANCEL", n13);
        PublishState[] publishStateArray = new PublishState[5];
        publishStateArray[0] = publishState5;
        publishStateArray[n10] = publishState4;
        publishStateArray[n11] = publishState3;
        publishStateArray[n12] = publishState2;
        publishStateArray[n13] = publishState;
        a = publishStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private PublishState() {
        void var2_-1;
        void var1_-1;
    }

    public static PublishState valueOf(String string2) {
        return Enum.valueOf(PublishState.class, string2);
    }

    public static PublishState[] values() {
        return (PublishState[])a.clone();
    }
}

