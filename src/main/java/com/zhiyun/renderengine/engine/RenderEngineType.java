/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.renderengine.engine;

public final class RenderEngineType
extends Enum {
    public static final /* enum */ RenderEngineType FACE_UNITY_ENGINE;
    public static final /* enum */ RenderEngineType ZHI_YUN_ENGINE;
    private static final /* synthetic */ RenderEngineType[] a;
    private int engineType;
    private String engineTypeDescription;

    static {
        RenderEngineType renderEngineType;
        RenderEngineType renderEngineType2;
        FACE_UNITY_ENGINE = renderEngineType2 = new RenderEngineType("FACE_UNITY_ENGINE", 0, 0, "impl by face unity");
        int n10 = 1;
        ZHI_YUN_ENGINE = renderEngineType = new RenderEngineType("ZHI_YUN_ENGINE", n10, n10, "impl by zhiyun technology");
        RenderEngineType[] renderEngineTypeArray = new RenderEngineType[2];
        renderEngineTypeArray[0] = renderEngineType2;
        renderEngineTypeArray[n10] = renderEngineType;
        a = renderEngineTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private RenderEngineType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.engineType = var3_1;
        this.engineTypeDescription = var4_2;
    }

    public static RenderEngineType valueOf(String string2) {
        return Enum.valueOf(RenderEngineType.class, string2);
    }

    public static RenderEngineType[] values() {
        return (RenderEngineType[])a.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RenderEngineType{engineType=");
        int n10 = this.engineType;
        stringBuilder.append(n10);
        stringBuilder.append(", engineTypeDescription='");
        String string2 = this.engineTypeDescription;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public int value() {
        return this.engineType;
    }
}

