/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse;
import d.o.a.a.b.c.e;
import e.a.g0;
import e.a.s0.b;

public final class OooOo00$b
implements g0 {
    public final /* synthetic */ e a;

    public OooOo00$b(e e10) {
        this.a = e10;
    }

    public void a(OSSUploadResponse oSSUploadResponse) {
        e e10 = this.a;
        if (e10 != null) {
            e10.a(oSSUploadResponse, null);
        }
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        e e10 = this.a;
        if (e10 != null) {
            object = ((Throwable)object).getMessage();
            e10.a(null, (String)object);
        }
    }

    public void onSubscribe(b b10) {
    }
}

