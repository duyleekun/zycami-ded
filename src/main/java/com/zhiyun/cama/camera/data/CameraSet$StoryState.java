/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

public final class CameraSet$StoryState
extends Enum {
    public static final /* enum */ CameraSet$StoryState NONE;
    public static final /* enum */ CameraSet$StoryState STORY_DRAFT;
    public static final /* enum */ CameraSet$StoryState STORY_DRAFT_TO_REVIEW;
    public static final /* enum */ CameraSet$StoryState STORY_LIST;
    public static final /* enum */ CameraSet$StoryState STORY_MORE;
    public static final /* enum */ CameraSet$StoryState STORY_PERSONAL;
    public static final /* enum */ CameraSet$StoryState STORY_RECORD;
    public static final /* enum */ CameraSet$StoryState STORY_REVIEW;
    public static final /* enum */ CameraSet$StoryState STORY_SAVE;
    private static final /* synthetic */ CameraSet$StoryState[] a;

    static {
        CameraSet$StoryState cameraSet$StoryState;
        CameraSet$StoryState cameraSet$StoryState2;
        CameraSet$StoryState cameraSet$StoryState3;
        CameraSet$StoryState cameraSet$StoryState4;
        CameraSet$StoryState cameraSet$StoryState5;
        CameraSet$StoryState cameraSet$StoryState6;
        CameraSet$StoryState cameraSet$StoryState7;
        CameraSet$StoryState cameraSet$StoryState8;
        CameraSet$StoryState cameraSet$StoryState9;
        STORY_LIST = cameraSet$StoryState9 = new CameraSet$StoryState("STORY_LIST", 0);
        int n10 = 1;
        STORY_RECORD = cameraSet$StoryState8 = new CameraSet$StoryState("STORY_RECORD", n10);
        int n11 = 2;
        STORY_REVIEW = cameraSet$StoryState7 = new CameraSet$StoryState("STORY_REVIEW", n11);
        int n12 = 3;
        STORY_DRAFT = cameraSet$StoryState6 = new CameraSet$StoryState("STORY_DRAFT", n12);
        int n13 = 4;
        STORY_DRAFT_TO_REVIEW = cameraSet$StoryState5 = new CameraSet$StoryState("STORY_DRAFT_TO_REVIEW", n13);
        STORY_PERSONAL = cameraSet$StoryState4 = new CameraSet$StoryState("STORY_PERSONAL", 5);
        STORY_MORE = cameraSet$StoryState3 = new CameraSet$StoryState("STORY_MORE", 6);
        STORY_SAVE = cameraSet$StoryState2 = new CameraSet$StoryState("STORY_SAVE", 7);
        int n14 = 8;
        NONE = cameraSet$StoryState = new CameraSet$StoryState("NONE", n14);
        CameraSet$StoryState[] cameraSet$StoryStateArray = new CameraSet$StoryState[9];
        cameraSet$StoryStateArray[0] = cameraSet$StoryState9;
        cameraSet$StoryStateArray[n10] = cameraSet$StoryState8;
        cameraSet$StoryStateArray[n11] = cameraSet$StoryState7;
        cameraSet$StoryStateArray[n12] = cameraSet$StoryState6;
        cameraSet$StoryStateArray[n13] = cameraSet$StoryState5;
        cameraSet$StoryStateArray[5] = cameraSet$StoryState4;
        cameraSet$StoryStateArray[6] = cameraSet$StoryState3;
        cameraSet$StoryStateArray[7] = cameraSet$StoryState2;
        cameraSet$StoryStateArray[n14] = cameraSet$StoryState;
        a = cameraSet$StoryStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$StoryState() {
        void var2_-1;
        void var1_-1;
    }

    public static CameraSet$StoryState valueOf(String string2) {
        return Enum.valueOf(CameraSet$StoryState.class, string2);
    }

    public static CameraSet$StoryState[] values() {
        return (CameraSet$StoryState[])a.clone();
    }
}

