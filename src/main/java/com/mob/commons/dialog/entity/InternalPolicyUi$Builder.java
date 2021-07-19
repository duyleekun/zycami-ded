/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog.entity;

import com.mob.commons.dialog.entity.BaseEntity;
import com.mob.commons.dialog.entity.InternalPolicyUi;

public class InternalPolicyUi$Builder
extends BaseEntity {
    private String contentText;
    private String negativeBtnText;
    private String positiveBtnText;
    private String titleText;

    public static /* synthetic */ String access$000(InternalPolicyUi$Builder internalPolicyUi$Builder) {
        return internalPolicyUi$Builder.titleText;
    }

    public static /* synthetic */ String access$100(InternalPolicyUi$Builder internalPolicyUi$Builder) {
        return internalPolicyUi$Builder.contentText;
    }

    public static /* synthetic */ String access$200(InternalPolicyUi$Builder internalPolicyUi$Builder) {
        return internalPolicyUi$Builder.positiveBtnText;
    }

    public static /* synthetic */ String access$300(InternalPolicyUi$Builder internalPolicyUi$Builder) {
        return internalPolicyUi$Builder.negativeBtnText;
    }

    public InternalPolicyUi build() {
        InternalPolicyUi internalPolicyUi = new InternalPolicyUi(this, null);
        return internalPolicyUi;
    }

    public InternalPolicyUi$Builder setContentText(String string2) {
        this.contentText = string2;
        return this;
    }

    public InternalPolicyUi$Builder setNegativeBtnText(String string2) {
        this.negativeBtnText = string2;
        return this;
    }

    public InternalPolicyUi$Builder setPositiveBtnText(String string2) {
        this.positiveBtnText = string2;
        return this;
    }

    public InternalPolicyUi$Builder setTitleText(String string2) {
        this.titleText = string2;
        return this;
    }
}

