/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.protocal;

import com.quvideo.mobile.external.component.cloudcomposite.model.CompositeFinishResponse;
import com.quvideo.mobile.external.component.cloudcomposite.model.CompositePreResponse;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.ICompositeTask;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;

public interface OnCompositeListener {
    public void onFailure(ICompositeTask var1, RequestError var2, OnCompositeListener$State var3, boolean var4);

    public void onNext(ICompositeTask var1, OnCompositeListener$State var2);

    public void onPreComposite(ICompositeTask var1, CompositePreResponse var2);

    public void onSuccess(ICompositeTask var1, CompositeFinishResponse var2);

    public void onUploadProgress(ICompositeTask var1, int var2);
}

