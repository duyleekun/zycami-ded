/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.uploader.OooO$OooO0O0;
import com.quvideo.mobile.external.platform.uploader.OooO$OooO0OO;
import com.quvideo.mobile.external.platform.uploader.OooO$a;
import com.quvideo.mobile.external.platform.uploader.listener.OooO0O0;
import com.quvideo.mobile.external.platform.uploader.listener.OooO0OO;
import com.quvideo.mobile.external.platform.uploader.utils.OooO00o;

public class OooO {
    public OooO0OO OooO;
    public String OooO00o;
    public long OooO0O0;
    public boolean OooO0OO;
    public boolean OooO0Oo;
    public String OooO0o;
    public boolean OooO0o0;
    public volatile OooO$OooO0OO OooO0oO;
    public OooO0O0 OooO0oo;

    private OooO(OooO$OooO0O0 object) {
        boolean bl2;
        long l10;
        Object object2 = OooO$OooO0O0.OooO00o((OooO$OooO0O0)object);
        this.OooO00o = object2;
        this.OooO0O0 = l10 = OooO$OooO0O0.OooO0O0((OooO$OooO0O0)object);
        this.OooO0OO = bl2 = OooO$OooO0O0.OooO0OO((OooO$OooO0O0)object);
        this.OooO0Oo = bl2 = OooO$OooO0O0.OooO0Oo((OooO$OooO0O0)object);
        this.OooO0o0 = bl2 = OooO$OooO0O0.OooO0o0((OooO$OooO0O0)object);
        object2 = OooO$OooO0O0.OooO0o((OooO$OooO0O0)object);
        this.OooO0o = object2;
        this.OooO0oO = object2 = OooO$OooO0O0.OooO0oO((OooO$OooO0O0)object);
        this.OooO0oo = object2 = OooO$OooO0O0.OooO0oo((OooO$OooO0O0)object);
        this.OooO = object = OooO$OooO0O0.OooO((OooO$OooO0O0)object);
    }

    public /* synthetic */ OooO(OooO$OooO0O0 oooO$OooO0O0, OooO$a oooO$a) {
        this(oooO$OooO0O0);
    }

    public OooO(OooO object) {
        boolean bl2;
        long l10;
        if (object == null) {
            return;
        }
        Object object2 = ((OooO)object).OooO00o;
        this.OooO00o = object2;
        this.OooO0O0 = l10 = ((OooO)object).OooO0O0;
        this.OooO0OO = bl2 = ((OooO)object).OooO0OO;
        this.OooO0Oo = bl2 = ((OooO)object).OooO0Oo;
        this.OooO0o0 = bl2 = ((OooO)object).OooO0o0;
        object2 = ((OooO)object).OooO0o;
        this.OooO0o = object2;
        object2 = ((OooO)object).OooO0oO;
        if (object2 != null) {
            object = ((OooO)object).OooO0oO;
            this.OooO0oO = object2 = new OooO$OooO0OO((OooO$OooO0OO)object, null);
        }
    }

    public int OooO00o() {
        String string2 = this.OooO00o;
        try {
            boolean bl2 = com.quvideo.mobile.external.platform.uploader.utils.OooO00o.OooO0o0(string2);
            if (!bl2) {
                return 2001;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UploadFileEntity{localFilePath='");
        Object object = this.OooO00o;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", configId=");
        long l10 = this.OooO0O0;
        stringBuilder.append(l10);
        stringBuilder.append(", ossUploadToken=");
        object = this.OooO0oO;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

