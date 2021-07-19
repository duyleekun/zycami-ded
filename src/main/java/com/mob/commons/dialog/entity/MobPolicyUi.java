/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog.entity;

import com.mob.commons.dialog.entity.BaseEntity;
import com.mob.commons.dialog.entity.MobPolicyUi$1;
import com.mob.commons.dialog.entity.MobPolicyUi$Builder;

public class MobPolicyUi
extends BaseEntity {
    private int backgroundColorId;
    private String backgroundColorStr;
    private int negativeBtnColorId;
    private String negativeBtnColorStr;
    private int positiveBtnColorId;
    private String positiveBtnColorStr;

    private MobPolicyUi(MobPolicyUi$Builder object) {
        String string2;
        int n10;
        this.backgroundColorId = n10 = MobPolicyUi$Builder.access$000((MobPolicyUi$Builder)object);
        this.backgroundColorStr = string2 = MobPolicyUi$Builder.access$100((MobPolicyUi$Builder)object);
        this.positiveBtnColorId = n10 = MobPolicyUi$Builder.access$200((MobPolicyUi$Builder)object);
        this.positiveBtnColorStr = string2 = MobPolicyUi$Builder.access$300((MobPolicyUi$Builder)object);
        this.negativeBtnColorId = n10 = MobPolicyUi$Builder.access$400((MobPolicyUi$Builder)object);
        this.negativeBtnColorStr = object = MobPolicyUi$Builder.access$500((MobPolicyUi$Builder)object);
    }

    public /* synthetic */ MobPolicyUi(MobPolicyUi$Builder mobPolicyUi$Builder, MobPolicyUi$1 mobPolicyUi$1) {
        this(mobPolicyUi$Builder);
    }

    public int getBackgroundColorId() {
        return this.backgroundColorId;
    }

    public String getBackgroundColorStr() {
        return this.backgroundColorStr;
    }

    public int getNegativeBtnColorId() {
        return this.negativeBtnColorId;
    }

    public String getNegativeBtnColorStr() {
        return this.negativeBtnColorStr;
    }

    public int getPositiveBtnColorId() {
        return this.positiveBtnColorId;
    }

    public String getPositiveBtnColorStr() {
        return this.positiveBtnColorStr;
    }
}

