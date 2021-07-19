/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.model;

import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeMakeResponse;

public class CompositePreResponse {
    private String OooO00o;

    public CompositePreResponse(CloudCompositeMakeResponse object) {
        this.OooO00o = object = object.data.businessId;
    }

    public String getBusinessId() {
        return this.OooO00o;
    }
}

