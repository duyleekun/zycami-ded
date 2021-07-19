/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

public final class ExecutionSequencer$RunningState
extends Enum {
    private static final /* synthetic */ ExecutionSequencer$RunningState[] $VALUES;
    public static final /* enum */ ExecutionSequencer$RunningState CANCELLED;
    public static final /* enum */ ExecutionSequencer$RunningState NOT_RUN;
    public static final /* enum */ ExecutionSequencer$RunningState STARTED;

    static {
        ExecutionSequencer$RunningState executionSequencer$RunningState;
        ExecutionSequencer$RunningState executionSequencer$RunningState2;
        ExecutionSequencer$RunningState executionSequencer$RunningState3;
        NOT_RUN = executionSequencer$RunningState3 = new ExecutionSequencer$RunningState("NOT_RUN", 0);
        int n10 = 1;
        CANCELLED = executionSequencer$RunningState2 = new ExecutionSequencer$RunningState("CANCELLED", n10);
        int n11 = 2;
        STARTED = executionSequencer$RunningState = new ExecutionSequencer$RunningState("STARTED", n11);
        ExecutionSequencer$RunningState[] executionSequencer$RunningStateArray = new ExecutionSequencer$RunningState[3];
        executionSequencer$RunningStateArray[0] = executionSequencer$RunningState3;
        executionSequencer$RunningStateArray[n10] = executionSequencer$RunningState2;
        executionSequencer$RunningStateArray[n11] = executionSequencer$RunningState;
        $VALUES = executionSequencer$RunningStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ExecutionSequencer$RunningState() {
        void var2_-1;
        void var1_-1;
    }

    public static ExecutionSequencer$RunningState valueOf(String string2) {
        return Enum.valueOf(ExecutionSequencer$RunningState.class, string2);
    }

    public static ExecutionSequencer$RunningState[] values() {
        return (ExecutionSequencer$RunningState[])$VALUES.clone();
    }
}

