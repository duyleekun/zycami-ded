/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.model;

public final class TemplateResponse$Data$DataType
extends Enum {
    private static final /* synthetic */ TemplateResponse$Data$DataType[] $VALUES;
    public static final /* enum */ TemplateResponse$Data$DataType both;
    public static final /* enum */ TemplateResponse$Data$DataType image;
    public static final /* enum */ TemplateResponse$Data$DataType video;

    static {
        TemplateResponse$Data$DataType templateResponse$Data$DataType;
        TemplateResponse$Data$DataType templateResponse$Data$DataType2;
        TemplateResponse$Data$DataType templateResponse$Data$DataType3;
        both = templateResponse$Data$DataType3 = new TemplateResponse$Data$DataType("both", 0);
        int n10 = 1;
        image = templateResponse$Data$DataType2 = new TemplateResponse$Data$DataType("image", n10);
        int n11 = 2;
        video = templateResponse$Data$DataType = new TemplateResponse$Data$DataType("video", n11);
        TemplateResponse$Data$DataType[] templateResponse$Data$DataTypeArray = new TemplateResponse$Data$DataType[3];
        templateResponse$Data$DataTypeArray[0] = templateResponse$Data$DataType3;
        templateResponse$Data$DataTypeArray[n10] = templateResponse$Data$DataType2;
        templateResponse$Data$DataTypeArray[n11] = templateResponse$Data$DataType;
        $VALUES = templateResponse$Data$DataTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private TemplateResponse$Data$DataType() {
        void var2_-1;
        void var1_-1;
    }

    public static TemplateResponse$Data$DataType valueOf(String string2) {
        return Enum.valueOf(TemplateResponse$Data$DataType.class, string2);
    }

    public static TemplateResponse$Data$DataType[] values() {
        return (TemplateResponse$Data$DataType[])$VALUES.clone();
    }
}

