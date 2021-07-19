/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.request;

public final class RequestCoordinator$RequestState
extends Enum {
    public static final /* enum */ RequestCoordinator$RequestState CLEARED;
    public static final /* enum */ RequestCoordinator$RequestState FAILED;
    public static final /* enum */ RequestCoordinator$RequestState PAUSED;
    public static final /* enum */ RequestCoordinator$RequestState RUNNING;
    public static final /* enum */ RequestCoordinator$RequestState SUCCESS;
    private static final /* synthetic */ RequestCoordinator$RequestState[] a;
    private final boolean isComplete;

    static {
        RequestCoordinator$RequestState requestCoordinator$RequestState;
        RequestCoordinator$RequestState requestCoordinator$RequestState2;
        RequestCoordinator$RequestState requestCoordinator$RequestState3;
        RequestCoordinator$RequestState requestCoordinator$RequestState4;
        RequestCoordinator$RequestState requestCoordinator$RequestState5;
        RUNNING = requestCoordinator$RequestState5 = new RequestCoordinator$RequestState("RUNNING", 0, false);
        int n10 = 1;
        PAUSED = requestCoordinator$RequestState4 = new RequestCoordinator$RequestState("PAUSED", n10, false);
        int n11 = 2;
        CLEARED = requestCoordinator$RequestState3 = new RequestCoordinator$RequestState("CLEARED", n11, false);
        int n12 = 3;
        SUCCESS = requestCoordinator$RequestState2 = new RequestCoordinator$RequestState("SUCCESS", n12, n10 != 0);
        int n13 = 4;
        FAILED = requestCoordinator$RequestState = new RequestCoordinator$RequestState("FAILED", n13, n10 != 0);
        RequestCoordinator$RequestState[] requestCoordinator$RequestStateArray = new RequestCoordinator$RequestState[5];
        requestCoordinator$RequestStateArray[0] = requestCoordinator$RequestState5;
        requestCoordinator$RequestStateArray[n10] = requestCoordinator$RequestState4;
        requestCoordinator$RequestStateArray[n11] = requestCoordinator$RequestState3;
        requestCoordinator$RequestStateArray[n12] = requestCoordinator$RequestState2;
        requestCoordinator$RequestStateArray[n13] = requestCoordinator$RequestState;
        a = requestCoordinator$RequestStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private RequestCoordinator$RequestState() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.isComplete = var3_1;
    }

    public static RequestCoordinator$RequestState valueOf(String string2) {
        return Enum.valueOf(RequestCoordinator$RequestState.class, string2);
    }

    public static RequestCoordinator$RequestState[] values() {
        return (RequestCoordinator$RequestState[])a.clone();
    }

    public boolean isComplete() {
        return this.isComplete;
    }
}

