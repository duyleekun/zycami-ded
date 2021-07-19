/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog.entity;

import com.mob.commons.dialog.entity.BaseEntity;
import com.mob.commons.dialog.entity.MobPolicyUi;

public class MobPolicyUi$Builder
extends BaseEntity {
    private int backgroundColorId;
    private String backgroundColorStr;
    private int negativeBtnColorId;
    private String negativeBtnColorStr;
    private int positiveBtnColorId;
    private String positiveBtnColorStr;

    public MobPolicyUi$Builder() {
        int n10;
        this.backgroundColorId = n10 = -1;
        this.positiveBtnColorId = n10;
        this.negativeBtnColorId = n10;
    }

    public static /* synthetic */ int access$000(MobPolicyUi$Builder mobPolicyUi$Builder) {
        return mobPolicyUi$Builder.backgroundColorId;
    }

    public static /* synthetic */ String access$100(MobPolicyUi$Builder mobPolicyUi$Builder) {
        return mobPolicyUi$Builder.backgroundColorStr;
    }

    public static /* synthetic */ int access$200(MobPolicyUi$Builder mobPolicyUi$Builder) {
        return mobPolicyUi$Builder.positiveBtnColorId;
    }

    public static /* synthetic */ String access$300(MobPolicyUi$Builder mobPolicyUi$Builder) {
        return mobPolicyUi$Builder.positiveBtnColorStr;
    }

    public static /* synthetic */ int access$400(MobPolicyUi$Builder mobPolicyUi$Builder) {
        return mobPolicyUi$Builder.negativeBtnColorId;
    }

    public static /* synthetic */ String access$500(MobPolicyUi$Builder mobPolicyUi$Builder) {
        return mobPolicyUi$Builder.negativeBtnColorStr;
    }

    public MobPolicyUi build() {
        MobPolicyUi mobPolicyUi = new MobPolicyUi(this, null);
        return mobPolicyUi;
    }

    public MobPolicyUi$Builder setBackgroundColorId(int n10) {
        this.backgroundColorId = n10;
        return this;
    }

    public MobPolicyUi$Builder setBackgroundColorStr(String string2) {
        this.backgroundColorStr = string2;
        return this;
    }

    public MobPolicyUi$Builder setNegativeBtnColorId(int n10) {
        this.negativeBtnColorId = n10;
        return this;
    }

    public MobPolicyUi$Builder setNegativeBtnColorStr(String string2) {
        this.negativeBtnColorStr = string2;
        return this;
    }

    public MobPolicyUi$Builder setPositiveBtnColorId(int n10) {
        this.positiveBtnColorId = n10;
        return this;
    }

    public MobPolicyUi$Builder setPositiveBtnColorStr(String string2) {
        this.positiveBtnColorStr = string2;
        return this;
    }
}

