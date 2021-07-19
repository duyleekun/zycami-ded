/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.protocal;

import com.quvideo.mobile.external.component.cloudcomposite.model.VideoResponse;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;

public interface OnVideoListener {
    public void onFailure(RequestError var1);

    public void onSuccess(VideoResponse var1);
}

