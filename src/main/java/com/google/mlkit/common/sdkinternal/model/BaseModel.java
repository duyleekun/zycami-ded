/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

public final class BaseModel
extends Enum {
    public static final /* enum */ BaseModel ENTITY_EXTRACTION;
    public static final /* enum */ BaseModel TRANSLATE;
    private static final /* enum */ BaseModel zza;
    private static final /* enum */ BaseModel zzb;
    private static final /* synthetic */ BaseModel[] zzc;

    static {
        BaseModel baseModel;
        BaseModel baseModel2;
        BaseModel baseModel3;
        BaseModel baseModel4;
        zza = baseModel4 = new BaseModel("FACE_DETECTION", 0);
        int n10 = 1;
        zzb = baseModel3 = new BaseModel("SMART_REPLY", n10);
        int n11 = 2;
        TRANSLATE = baseModel2 = new BaseModel("TRANSLATE", n11);
        int n12 = 3;
        ENTITY_EXTRACTION = baseModel = new BaseModel("ENTITY_EXTRACTION", n12);
        BaseModel[] baseModelArray = new BaseModel[4];
        baseModelArray[0] = baseModel4;
        baseModelArray[n10] = baseModel3;
        baseModelArray[n11] = baseModel2;
        baseModelArray[n12] = baseModel;
        zzc = baseModelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BaseModel() {
        void var2_-1;
        void var1_-1;
    }

    public static BaseModel[] values() {
        return (BaseModel[])zzc.clone();
    }
}

