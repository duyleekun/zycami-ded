/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

import com.zhiyun.protocol.constants.Model;

public final class MoreDevice
extends Enum {
    public static final /* enum */ MoreDevice SMOOTH_Q3;
    public static final /* enum */ MoreDevice SMOOTH_X;
    public static final /* enum */ MoreDevice SMOOTH_XS;
    private static final /* synthetic */ MoreDevice[] a;
    private Model[] models;
    private int stringRes;

    static {
        Model model;
        MoreDevice moreDevice;
        int n10 = 1;
        Object object = new Model[n10];
        Object object2 = Model.SMOOTHQ3;
        object[0] = object2;
        SMOOTH_Q3 = moreDevice = new MoreDevice("SMOOTH_Q3", 0, 2131953121, object);
        object2 = new Model[n10];
        Enum[] enumArray = Model.SMOOTHXS;
        object2[0] = enumArray;
        SMOOTH_XS = object = new MoreDevice("SMOOTH_XS", n10, 2131953123, object2);
        enumArray = new Model[n10];
        enumArray[0] = model = Model.SMOOTHX;
        int n11 = 2;
        SMOOTH_X = object2 = new MoreDevice("SMOOTH_X", n11, 2131953122, (Model[])enumArray);
        enumArray = new MoreDevice[3];
        enumArray[0] = moreDevice;
        enumArray[n10] = object;
        enumArray[n11] = object2;
        a = enumArray;
    }

    /*
     * WARNING - void declaration
     */
    private MoreDevice() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.stringRes = var3_1;
        this.models = var4_2;
    }

    public static MoreDevice fromModel(Model model) {
        for (MoreDevice moreDevice : MoreDevice.values()) {
            int n10;
            Model[] modelArray = moreDevice.getModels();
            if (modelArray == null || (n10 = (modelArray = moreDevice.getModels()).length) <= 0) continue;
            for (Model model2 : moreDevice.getModels()) {
                if (model2 != model) continue;
                return moreDevice;
            }
        }
        return SMOOTH_Q3;
    }

    public static MoreDevice fromName(String string2) {
        for (MoreDevice moreDevice : MoreDevice.values()) {
            String string3 = moreDevice.name();
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return moreDevice;
        }
        return SMOOTH_Q3;
    }

    public static MoreDevice valueOf(String string2) {
        return Enum.valueOf(MoreDevice.class, string2);
    }

    public static MoreDevice[] values() {
        return (MoreDevice[])a.clone();
    }

    public Model[] getModels() {
        return this.models;
    }

    public int getStringRes() {
        return this.stringRes;
    }

    public void setModels(Model[] modelArray) {
        this.models = modelArray;
    }

    public void setStringRes(int n10) {
        this.stringRes = n10;
    }
}

