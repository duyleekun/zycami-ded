/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.widget.base;

public final class BaseResourceListView$ResourceType
extends Enum {
    public static final /* enum */ BaseResourceListView$ResourceType RESOURCE_TYPE_CAPTION;
    public static final /* enum */ BaseResourceListView$ResourceType RESOURCE_TYPE_FILTER;
    public static final /* enum */ BaseResourceListView$ResourceType RESOURCE_TYPE_FONT;
    public static final /* enum */ BaseResourceListView$ResourceType RESOURCE_TYPE_STICKER;
    public static final /* enum */ BaseResourceListView$ResourceType RESOURCE_TYPE_TRANSITION;
    private static final /* synthetic */ BaseResourceListView$ResourceType[] a;

    static {
        BaseResourceListView$ResourceType baseResourceListView$ResourceType;
        BaseResourceListView$ResourceType baseResourceListView$ResourceType2;
        BaseResourceListView$ResourceType baseResourceListView$ResourceType3;
        BaseResourceListView$ResourceType baseResourceListView$ResourceType4;
        BaseResourceListView$ResourceType baseResourceListView$ResourceType5;
        RESOURCE_TYPE_FILTER = baseResourceListView$ResourceType5 = new BaseResourceListView$ResourceType("RESOURCE_TYPE_FILTER", 0);
        int n10 = 1;
        RESOURCE_TYPE_STICKER = baseResourceListView$ResourceType4 = new BaseResourceListView$ResourceType("RESOURCE_TYPE_STICKER", n10);
        int n11 = 2;
        RESOURCE_TYPE_FONT = baseResourceListView$ResourceType3 = new BaseResourceListView$ResourceType("RESOURCE_TYPE_FONT", n11);
        int n12 = 3;
        RESOURCE_TYPE_CAPTION = baseResourceListView$ResourceType2 = new BaseResourceListView$ResourceType("RESOURCE_TYPE_CAPTION", n12);
        int n13 = 4;
        RESOURCE_TYPE_TRANSITION = baseResourceListView$ResourceType = new BaseResourceListView$ResourceType("RESOURCE_TYPE_TRANSITION", n13);
        BaseResourceListView$ResourceType[] baseResourceListView$ResourceTypeArray = new BaseResourceListView$ResourceType[5];
        baseResourceListView$ResourceTypeArray[0] = baseResourceListView$ResourceType5;
        baseResourceListView$ResourceTypeArray[n10] = baseResourceListView$ResourceType4;
        baseResourceListView$ResourceTypeArray[n11] = baseResourceListView$ResourceType3;
        baseResourceListView$ResourceTypeArray[n12] = baseResourceListView$ResourceType2;
        baseResourceListView$ResourceTypeArray[n13] = baseResourceListView$ResourceType;
        a = baseResourceListView$ResourceTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BaseResourceListView$ResourceType() {
        void var2_-1;
        void var1_-1;
    }

    public static BaseResourceListView$ResourceType valueOf(String string2) {
        return Enum.valueOf(BaseResourceListView$ResourceType.class, string2);
    }

    public static BaseResourceListView$ResourceType[] values() {
        return (BaseResourceListView$ResourceType[])a.clone();
    }
}

