/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

public final class BaseQuickAdapter$AnimationType
extends Enum {
    private static final /* synthetic */ BaseQuickAdapter$AnimationType[] $VALUES;
    public static final /* enum */ BaseQuickAdapter$AnimationType AlphaIn;
    public static final /* enum */ BaseQuickAdapter$AnimationType ScaleIn;
    public static final /* enum */ BaseQuickAdapter$AnimationType SlideInBottom;
    public static final /* enum */ BaseQuickAdapter$AnimationType SlideInLeft;
    public static final /* enum */ BaseQuickAdapter$AnimationType SlideInRight;

    static {
        BaseQuickAdapter$AnimationType baseQuickAdapter$AnimationType;
        BaseQuickAdapter$AnimationType[] baseQuickAdapter$AnimationTypeArray = new BaseQuickAdapter$AnimationType[5];
        AlphaIn = baseQuickAdapter$AnimationType = new BaseQuickAdapter$AnimationType("AlphaIn", 0);
        baseQuickAdapter$AnimationTypeArray[0] = baseQuickAdapter$AnimationType;
        int n10 = 1;
        ScaleIn = baseQuickAdapter$AnimationType = new BaseQuickAdapter$AnimationType("ScaleIn", n10);
        baseQuickAdapter$AnimationTypeArray[n10] = baseQuickAdapter$AnimationType;
        n10 = 2;
        SlideInBottom = baseQuickAdapter$AnimationType = new BaseQuickAdapter$AnimationType("SlideInBottom", n10);
        baseQuickAdapter$AnimationTypeArray[n10] = baseQuickAdapter$AnimationType;
        n10 = 3;
        SlideInLeft = baseQuickAdapter$AnimationType = new BaseQuickAdapter$AnimationType("SlideInLeft", n10);
        baseQuickAdapter$AnimationTypeArray[n10] = baseQuickAdapter$AnimationType;
        n10 = 4;
        SlideInRight = baseQuickAdapter$AnimationType = new BaseQuickAdapter$AnimationType("SlideInRight", n10);
        baseQuickAdapter$AnimationTypeArray[n10] = baseQuickAdapter$AnimationType;
        $VALUES = baseQuickAdapter$AnimationTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BaseQuickAdapter$AnimationType() {
        void var2_-1;
        void var1_-1;
    }

    public static BaseQuickAdapter$AnimationType valueOf(String string2) {
        return Enum.valueOf(BaseQuickAdapter$AnimationType.class, string2);
    }

    public static BaseQuickAdapter$AnimationType[] values() {
        return (BaseQuickAdapter$AnimationType[])$VALUES.clone();
    }
}

