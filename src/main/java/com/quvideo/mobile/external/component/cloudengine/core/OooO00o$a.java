/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudengine.core;

import com.quvideo.mobile.external.component.cloudengine.core.OooO00o;
import com.quvideo.mobile.external.component.cloudengine.core.OooO0O0;
import com.quvideo.mobile.external.component.cloudengine.core.OooO0OO;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateResponse;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnTemplateListener;
import com.quvideo.mobile.external.platform.api.template.model.TemplateInfoListV3Response;

public class OooO00o$a
extends OooO0OO {
    public final /* synthetic */ OnTemplateListener a;

    public OooO00o$a(OooO00o oooO00o, OnTemplateListener onTemplateListener) {
        this.a = onTemplateListener;
    }

    public void a(TemplateInfoListV3Response templateInfoListV3Response) {
        OnTemplateListener onTemplateListener = this.a;
        if (onTemplateListener == null) {
            return;
        }
        boolean bl2 = templateInfoListV3Response.success;
        if (bl2) {
            TemplateResponse templateResponse = new TemplateResponse(templateInfoListV3Response);
            onTemplateListener.onSuccess(templateResponse);
        } else {
            String string2 = templateInfoListV3Response.message;
            int n10 = templateInfoListV3Response.code;
            RequestError requestError = new RequestError(string2, n10);
            onTemplateListener.onFailure(requestError);
        }
    }

    public void onError(Throwable object) {
        OnTemplateListener onTemplateListener = this.a;
        if (onTemplateListener == null) {
            return;
        }
        object = ((Throwable)object).getMessage();
        int n10 = OooO0O0.OooO0o0;
        RequestError requestError = new RequestError((String)object, n10);
        onTemplateListener.onFailure(requestError);
    }
}

