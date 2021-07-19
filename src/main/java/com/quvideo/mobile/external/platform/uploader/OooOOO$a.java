/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse;
import com.quvideo.mobile.external.platform.httpcore.OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooOOO;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import d.o.a.a.b.c.e;

public final class OooOOO$a
implements e {
    public final /* synthetic */ OooO a;
    public final /* synthetic */ String b;

    public OooOOO$a(OooO oooO, String string2) {
        this.a = oooO;
        this.b = string2;
    }

    public void a(OSSUploadResponse object, String object2) {
        Object object3;
        if (object != null && (object3 = ((OSSUploadResponse)object).data) != null) {
            object2 = this.b;
            object3 = this.a;
            OooOo00.g((String)object2, (OooO)object3, (OSSUploadResponse)object);
            object = this.b;
            object2 = this.a;
            OooOOO.OooO00o((String)object, (OooO)object2);
            return;
        }
        object3 = this.a.OooO0oo;
        if (object3 != null) {
            int n10 = 2012;
            if (object == null) {
                object = this.b;
                if (object2 == null) {
                    object2 = "ossUploadResponse result error";
                }
                object3.OooO00o((String)object, n10, (String)object2);
            } else {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("responseCode:");
                int n11 = ((OooO00o)object).code;
                ((StringBuilder)object3).append(n11);
                String string2 = ",msg:";
                ((StringBuilder)object3).append(string2);
                object = ((OooO00o)object).message;
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                if (object2 != null) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)object);
                    ((StringBuilder)object3).append(",errorMsg:");
                    ((StringBuilder)object3).append((String)object2);
                    object = ((StringBuilder)object3).toString();
                }
                object2 = this.a.OooO0oo;
                object3 = this.b;
                object2.OooO00o((String)object3, n10, (String)object);
            }
        }
    }
}

