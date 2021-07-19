/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.model;

import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryResponse;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryResponse$Data;

public class CompositeFinishResponse {
    private String OooO00o;
    private String OooO0O0;
    private String OooO0OO;
    private String OooO0Oo;
    private String OooO0o0;

    public CompositeFinishResponse(CloudCompositeQueryResponse object) {
        String string2;
        object = ((CloudCompositeQueryResponse)object).data;
        this.OooO00o = string2 = ((CloudCompositeQueryResponse$Data)object).fileId;
        this.OooO0O0 = string2 = ((CloudCompositeQueryResponse$Data)object).businessId;
        this.OooO0OO = string2 = ((CloudCompositeQueryResponse$Data)object).fileUrl;
        this.OooO0Oo = string2 = ((CloudCompositeQueryResponse$Data)object).coverImageUrl;
        this.OooO0o0 = object = ((CloudCompositeQueryResponse$Data)object).duration;
    }

    public String getBusinessId() {
        return this.OooO0O0;
    }

    public String getCoverImageUrl() {
        return this.OooO0Oo;
    }

    public String getDuration() {
        return this.OooO0o0;
    }

    public String getFileId() {
        return this.OooO00o;
    }

    public String getFileUrl() {
        return this.OooO0OO;
    }
}

