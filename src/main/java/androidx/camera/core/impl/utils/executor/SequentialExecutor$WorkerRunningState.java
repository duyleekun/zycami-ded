/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

public final class SequentialExecutor$WorkerRunningState
extends Enum {
    private static final /* synthetic */ SequentialExecutor$WorkerRunningState[] $VALUES;
    public static final /* enum */ SequentialExecutor$WorkerRunningState IDLE;
    public static final /* enum */ SequentialExecutor$WorkerRunningState QUEUED;
    public static final /* enum */ SequentialExecutor$WorkerRunningState QUEUING;
    public static final /* enum */ SequentialExecutor$WorkerRunningState RUNNING;

    static {
        SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState;
        SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState2;
        SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState3;
        SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState4;
        IDLE = sequentialExecutor$WorkerRunningState4 = new SequentialExecutor$WorkerRunningState("IDLE", 0);
        int n10 = 1;
        QUEUING = sequentialExecutor$WorkerRunningState3 = new SequentialExecutor$WorkerRunningState("QUEUING", n10);
        int n11 = 2;
        QUEUED = sequentialExecutor$WorkerRunningState2 = new SequentialExecutor$WorkerRunningState("QUEUED", n11);
        int n12 = 3;
        RUNNING = sequentialExecutor$WorkerRunningState = new SequentialExecutor$WorkerRunningState("RUNNING", n12);
        SequentialExecutor$WorkerRunningState[] sequentialExecutor$WorkerRunningStateArray = new SequentialExecutor$WorkerRunningState[4];
        sequentialExecutor$WorkerRunningStateArray[0] = sequentialExecutor$WorkerRunningState4;
        sequentialExecutor$WorkerRunningStateArray[n10] = sequentialExecutor$WorkerRunningState3;
        sequentialExecutor$WorkerRunningStateArray[n11] = sequentialExecutor$WorkerRunningState2;
        sequentialExecutor$WorkerRunningStateArray[n12] = sequentialExecutor$WorkerRunningState;
        $VALUES = sequentialExecutor$WorkerRunningStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SequentialExecutor$WorkerRunningState() {
        void var2_-1;
        void var1_-1;
    }

    public static SequentialExecutor$WorkerRunningState valueOf(String string2) {
        return Enum.valueOf(SequentialExecutor$WorkerRunningState.class, string2);
    }

    public static SequentialExecutor$WorkerRunningState[] values() {
        return (SequentialExecutor$WorkerRunningState[])$VALUES.clone();
    }
}

