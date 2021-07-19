/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.uploader.OooO$a;

public class OooO$OooO0OO {
    public String OooO;
    public String OooO00o;
    public long OooO0O0;
    public String OooO0OO;
    public String OooO0Oo;
    public String OooO0o;
    public String OooO0o0;
    public String OooO0oO;
    public String OooO0oo;
    public String OooOO0;
    public boolean OooOO0O;

    private OooO$OooO0OO(OooO$OooO0OO object) {
        long l10;
        String string2;
        boolean bl2;
        this.OooOO0O = bl2 = true;
        if (object == null) {
            return;
        }
        this.OooO00o = string2 = ((OooO$OooO0OO)object).OooO00o;
        this.OooO0O0 = l10 = ((OooO$OooO0OO)object).OooO0O0;
        this.OooO0OO = string2 = ((OooO$OooO0OO)object).OooO0OO;
        this.OooO0Oo = string2 = ((OooO$OooO0OO)object).OooO0Oo;
        this.OooO0o0 = string2 = ((OooO$OooO0OO)object).OooO0o0;
        this.OooO0o = string2 = ((OooO$OooO0OO)object).OooO0o;
        this.OooO0oO = string2 = ((OooO$OooO0OO)object).OooO0oO;
        this.OooO0oo = string2 = ((OooO$OooO0OO)object).OooO0oo;
        this.OooO = string2 = ((OooO$OooO0OO)object).OooO;
        this.OooOO0 = object = ((OooO$OooO0OO)object).OooOO0;
    }

    public /* synthetic */ OooO$OooO0OO(OooO$OooO0OO oooO$OooO0OO, OooO.a a10) {
        this(oooO$OooO0OO);
    }

    public OooO$OooO0OO(String string2, long l10, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {
        this.OooOO0O = true;
        this.OooO00o = string2;
        this.OooO0O0 = l10;
        this.OooO0OO = string3;
        this.OooO0Oo = string4;
        this.OooO0o0 = string5;
        this.OooO0o = string6;
        this.OooO0oO = string7;
        this.OooO0oo = string8;
        this.OooO = string9;
        this.OooOO0 = string10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OSSUploadToken{ossType='");
        String string2 = this.OooO00o;
        stringBuilder.append(string2);
        char bl2 = '\'';
        stringBuilder.append(bl2);
        stringBuilder.append(", expirySeconds=");
        long l10 = this.OooO0O0;
        stringBuilder.append(l10);
        stringBuilder.append(", accessKey='");
        String string3 = this.OooO0OO;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", accessSecret='");
        string3 = this.OooO0Oo;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", securityToken='");
        string3 = this.OooO0o0;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", uploadHost='");
        string3 = this.OooO0o;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", filePath='");
        string3 = this.OooO0oO;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", region='");
        string3 = this.OooO0oo;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", bucket='");
        string3 = this.OooO;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", accessUrl='");
        string3 = this.OooOO0;
        stringBuilder.append(string3);
        stringBuilder.append(bl2);
        stringBuilder.append(", isUseHttps=");
        boolean bl3 = this.OooOO0O;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

