/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.quvideo.mobile.external.platform.uploader;

import android.text.TextUtils;
import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse;
import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse$Data;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import com.quvideo.mobile.external.platform.uploader.db.OooO0OO;
import d.o.a.a.b.c.e;

public class OooO00o$b
implements e {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ OooO00o c;

    public OooO00o$b(OooO00o oooO00o, int n10, String string2) {
        this.c = oooO00o;
        this.a = n10;
        this.b = string2;
    }

    public void a(OSSUploadResponse object, String object2) {
        if (object != null && (object2 = ((OSSUploadResponse)object).data) != null) {
            Object object3;
            object2 = ((OSSUploadResponse$Data)object2).accessUrl;
            int n10 = TextUtils.isEmpty((CharSequence)object2);
            if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)(object2 = this.c.OooO0OO.OooO0oO.OooOO0))) == 0 && (object2 = this.c.OooO0OO.OooO0oO) != null && (n10 = ((String)(object2 = object.data.accessUrl)).equals(object3 = this.c.OooO0OO.OooO0oO.OooOO0)) != 0) {
                object2 = this.c.OooO0O0;
                object3 = this.c.OooO0OO;
                OooOo00.g((String)object2, (OooO)object3, (OSSUploadResponse)object);
                this.c.OooO0oO = true;
                object = this.c;
                ((OooO00o)object).OooO0oo = n10 = this.a;
                object = this.c;
                n10 = ((OooO00o)object).OooO0oo;
                OooO00o.OooO00o((OooO00o)object, n10);
                object = this.c;
                ((OooO00o)object).OooO0oo();
            } else {
                object2 = this.c.OooO0o0;
                object3 = this.c.OooO0O0;
                ((OooO0OO)object2).OooO00o((String)object3);
                object2 = this.c.OooOO0;
                object3 = this.c.OooO0O0;
                int n11 = this.a;
                String string2 = this.b;
                object2.OooO00o((String)object3, n11, string2);
                object2 = this.c;
                object3 = ((OooO00o)object2).OooO0O0;
                String string3 = this.c.OooO0OO.OooO0oO.OooOO0;
                object = object.data.accessUrl;
                OooO00o.OooO00o((OooO00o)object2, (String)object3, string3, (String)object);
            }
        } else {
            object = this.c.OooO0o0;
            object2 = this.c.OooO0O0;
            ((OooO0OO)object).OooO00o((String)object2);
            object = this.c.OooOO0;
            object2 = this.c.OooO0O0;
            int n12 = this.a;
            String string4 = this.b;
            object.OooO00o((String)object2, n12, string4);
        }
    }
}

