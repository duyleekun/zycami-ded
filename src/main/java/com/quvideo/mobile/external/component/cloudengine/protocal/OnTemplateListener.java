/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.protocal;

import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse;

public interface OnTemplateListener {
    public void onFailure(RequestError var1);

    public void onSuccess(TemplateResponse var1);
}

