/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.liveassistant;

public final class LiveAssistantState
extends Enum {
    public static final /* enum */ LiveAssistantState CLOSE;
    public static final /* enum */ LiveAssistantState OPEN;
    public static final /* enum */ LiveAssistantState OPENING;
    public static final /* enum */ LiveAssistantState OPEN_SUCCESS;
    private static final /* synthetic */ LiveAssistantState[] a;
    private int stateExplainText;
    private int stateText;

    static {
        LiveAssistantState liveAssistantState;
        LiveAssistantState liveAssistantState2;
        LiveAssistantState liveAssistantState3;
        LiveAssistantState liveAssistantState4;
        int n10 = 2131952440;
        CLOSE = liveAssistantState4 = new LiveAssistantState("CLOSE", 0, 2131952442, n10);
        int n11 = 1;
        OPENING = liveAssistantState3 = new LiveAssistantState("OPENING", n11, 2131952445, n10);
        int n12 = 2;
        int n13 = 2131952441;
        OPEN_SUCCESS = liveAssistantState2 = new LiveAssistantState("OPEN_SUCCESS", n12, 2131952443, n13);
        int n14 = 3;
        OPEN = liveAssistantState = new LiveAssistantState("OPEN", n14, 2131952438, n13);
        LiveAssistantState[] liveAssistantStateArray = new LiveAssistantState[4];
        liveAssistantStateArray[0] = liveAssistantState4;
        liveAssistantStateArray[n11] = liveAssistantState3;
        liveAssistantStateArray[n12] = liveAssistantState2;
        liveAssistantStateArray[n14] = liveAssistantState;
        a = liveAssistantStateArray;
    }

    /*
     * WARNING - void declaration
     */
    private LiveAssistantState() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.stateText = var3_1;
        this.stateExplainText = var4_2;
    }

    public static LiveAssistantState valueOf(String string2) {
        return Enum.valueOf(LiveAssistantState.class, string2);
    }

    public static LiveAssistantState[] values() {
        return (LiveAssistantState[])a.clone();
    }

    public int getStateExplainText() {
        return this.stateExplainText;
    }

    public int getStateText() {
        return this.stateText;
    }

    public void setStateExplainText(int n10) {
        this.stateExplainText = n10;
    }

    public void setStateText(int n10) {
        this.stateText = n10;
    }
}

