/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

public final class ModelType
extends Enum {
    public static final /* enum */ ModelType AUTOML;
    public static final /* enum */ ModelType BASE;
    public static final /* enum */ ModelType CUSTOM;
    public static final /* enum */ ModelType ENTITY_EXTRACTION;
    public static final /* enum */ ModelType TRANSLATE;
    public static final /* enum */ ModelType UNKNOWN;
    private static final /* synthetic */ ModelType[] zza;

    static {
        ModelType modelType;
        ModelType modelType2;
        ModelType modelType3;
        ModelType modelType4;
        ModelType modelType5;
        ModelType modelType6;
        UNKNOWN = modelType6 = new ModelType("UNKNOWN", 0);
        int n10 = 1;
        BASE = modelType5 = new ModelType("BASE", n10);
        int n11 = 2;
        AUTOML = modelType4 = new ModelType("AUTOML", n11);
        int n12 = 3;
        TRANSLATE = modelType3 = new ModelType("TRANSLATE", n12);
        int n13 = 4;
        ENTITY_EXTRACTION = modelType2 = new ModelType("ENTITY_EXTRACTION", n13);
        int n14 = 5;
        CUSTOM = modelType = new ModelType("CUSTOM", n14);
        ModelType[] modelTypeArray = new ModelType[6];
        modelTypeArray[0] = modelType6;
        modelTypeArray[n10] = modelType5;
        modelTypeArray[n11] = modelType4;
        modelTypeArray[n12] = modelType3;
        modelTypeArray[n13] = modelType2;
        modelTypeArray[n14] = modelType;
        zza = modelTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ModelType() {
        void var2_-1;
        void var1_-1;
    }

    public static ModelType[] values() {
        return (ModelType[])zza.clone();
    }
}

