/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

public final class ModelLoader$ModelLoadingState
extends Enum {
    public static final /* enum */ ModelLoader$ModelLoadingState LOCAL_MODEL_LOADED;
    public static final /* enum */ ModelLoader$ModelLoadingState NO_MODEL_LOADED;
    public static final /* enum */ ModelLoader$ModelLoadingState REMOTE_MODEL_LOADED;
    private static final /* synthetic */ ModelLoader$ModelLoadingState[] zza;

    static {
        ModelLoader$ModelLoadingState modelLoader$ModelLoadingState;
        ModelLoader$ModelLoadingState modelLoader$ModelLoadingState2;
        ModelLoader$ModelLoadingState modelLoader$ModelLoadingState3;
        NO_MODEL_LOADED = modelLoader$ModelLoadingState3 = new ModelLoader$ModelLoadingState("NO_MODEL_LOADED", 0);
        int n10 = 1;
        REMOTE_MODEL_LOADED = modelLoader$ModelLoadingState2 = new ModelLoader$ModelLoadingState("REMOTE_MODEL_LOADED", n10);
        int n11 = 2;
        LOCAL_MODEL_LOADED = modelLoader$ModelLoadingState = new ModelLoader$ModelLoadingState("LOCAL_MODEL_LOADED", n11);
        ModelLoader$ModelLoadingState[] modelLoader$ModelLoadingStateArray = new ModelLoader$ModelLoadingState[3];
        modelLoader$ModelLoadingStateArray[0] = modelLoader$ModelLoadingState3;
        modelLoader$ModelLoadingStateArray[n10] = modelLoader$ModelLoadingState2;
        modelLoader$ModelLoadingStateArray[n11] = modelLoader$ModelLoadingState;
        zza = modelLoader$ModelLoadingStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ModelLoader$ModelLoadingState() {
        void var2_-1;
        void var1_-1;
    }

    public static ModelLoader$ModelLoadingState[] values() {
        return (ModelLoader$ModelLoadingState[])zza.clone();
    }
}

