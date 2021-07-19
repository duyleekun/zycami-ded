/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.core;

import com.quvideo.mobile.external.component.cloudcomposite.model.VideoResponse;
import com.quvideo.mobile.external.component.cloudengine.core.OooO00o;
import com.quvideo.mobile.external.component.cloudengine.core.OooO0O0;
import com.quvideo.mobile.external.component.cloudengine.core.OooO0OO;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnVideoListener;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryListResponse;

public class OooO00o$b
extends OooO0OO {
    public final /* synthetic */ OnVideoListener a;

    public OooO00o$b(OooO00o oooO00o, OnVideoListener onVideoListener) {
        this.a = onVideoListener;
    }

    public void a(CloudCompositeQueryListResponse cloudCompositeQueryListResponse) {
        OnVideoListener onVideoListener = this.a;
        if (onVideoListener == null) {
            return;
        }
        boolean bl2 = cloudCompositeQueryListResponse.success;
        if (bl2) {
            VideoResponse videoResponse = new VideoResponse(cloudCompositeQueryListResponse);
            onVideoListener.onSuccess(videoResponse);
        } else {
            String string2 = cloudCompositeQueryListResponse.message;
            int n10 = cloudCompositeQueryListResponse.code;
            RequestError requestError = new RequestError(string2, n10);
            onVideoListener.onFailure(requestError);
        }
    }

    public void onError(Throwable object) {
        OnVideoListener onVideoListener = this.a;
        if (onVideoListener == null) {
            return;
        }
        object = ((Throwable)object).getMessage();
        int n10 = OooO0O0.OooO0o0;
        RequestError requestError = new RequestError((String)object, n10);
        onVideoListener.onFailure(requestError);
    }
}

