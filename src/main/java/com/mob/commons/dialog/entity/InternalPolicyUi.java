/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.dialog.entity;

import com.mob.commons.dialog.entity.BaseEntity;
import com.mob.commons.dialog.entity.InternalPolicyUi$1;
import com.mob.commons.dialog.entity.InternalPolicyUi$Builder;

public class InternalPolicyUi
extends BaseEntity {
    private String contentText;
    private String negativeBtnText;
    private String positiveBtnText;
    private String titleText;

    private InternalPolicyUi(InternalPolicyUi$Builder object) {
        String string2;
        this.titleText = string2 = InternalPolicyUi$Builder.access$000((InternalPolicyUi$Builder)object);
        this.contentText = string2 = InternalPolicyUi$Builder.access$100((InternalPolicyUi$Builder)object);
        this.positiveBtnText = string2 = InternalPolicyUi$Builder.access$200((InternalPolicyUi$Builder)object);
        this.negativeBtnText = object = InternalPolicyUi$Builder.access$300((InternalPolicyUi$Builder)object);
    }

    public /* synthetic */ InternalPolicyUi(InternalPolicyUi$Builder internalPolicyUi$Builder, InternalPolicyUi$1 internalPolicyUi$1) {
        this(internalPolicyUi$Builder);
    }

    public String getContentText() {
        return this.contentText;
    }

    public String getNegativeBtnText() {
        return this.negativeBtnText;
    }

    public String getPositiveBtnText() {
        return this.positiveBtnText;
    }

    public String getTitleText() {
        return this.titleText;
    }
}

