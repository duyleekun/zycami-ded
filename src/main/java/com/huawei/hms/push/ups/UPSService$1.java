/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.push.ups;

import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.ups.entity.CodeResult;
import com.huawei.hms.push.ups.entity.UPSTurnCallBack;
import d.j.d.a.g;
import d.j.d.a.k;

public final class UPSService$1
implements g {
    public final /* synthetic */ UPSTurnCallBack a;

    public UPSService$1(UPSTurnCallBack uPSTurnCallBack) {
        this.a = uPSTurnCallBack;
    }

    public void onComplete(k object) {
        boolean bl2 = ((k)object).v();
        if (bl2) {
            object = this.a;
            CodeResult codeResult = new CodeResult();
            object.onResult(codeResult);
        } else {
            object = (ApiException)((k)object).q();
            UPSTurnCallBack uPSTurnCallBack = this.a;
            int n10 = ((ApiException)object).getStatusCode();
            object = ((Throwable)object).getMessage();
            CodeResult codeResult = new CodeResult(n10, (String)object);
            uPSTurnCallBack.onResult(codeResult);
        }
    }
}

