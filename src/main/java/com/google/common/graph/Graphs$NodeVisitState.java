/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.graph;

public final class Graphs$NodeVisitState
extends Enum {
    private static final /* synthetic */ Graphs$NodeVisitState[] $VALUES;
    public static final /* enum */ Graphs$NodeVisitState COMPLETE;
    public static final /* enum */ Graphs$NodeVisitState PENDING;

    static {
        Graphs$NodeVisitState graphs$NodeVisitState;
        Graphs$NodeVisitState graphs$NodeVisitState2;
        PENDING = graphs$NodeVisitState2 = new Graphs$NodeVisitState("PENDING", 0);
        int n10 = 1;
        COMPLETE = graphs$NodeVisitState = new Graphs$NodeVisitState("COMPLETE", n10);
        Graphs$NodeVisitState[] graphs$NodeVisitStateArray = new Graphs$NodeVisitState[2];
        graphs$NodeVisitStateArray[0] = graphs$NodeVisitState2;
        graphs$NodeVisitStateArray[n10] = graphs$NodeVisitState;
        $VALUES = graphs$NodeVisitStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Graphs$NodeVisitState() {
        void var2_-1;
        void var1_-1;
    }

    public static Graphs$NodeVisitState valueOf(String string2) {
        return Enum.valueOf(Graphs$NodeVisitState.class, string2);
    }

    public static Graphs$NodeVisitState[] values() {
        return (Graphs$NodeVisitState[])$VALUES.clone();
    }
}

