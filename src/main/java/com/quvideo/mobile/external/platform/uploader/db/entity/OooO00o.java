/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader.db.entity;

public class OooO00o {
    private int OooO00o;
    private String OooO0O0 = "";
    private int OooO0OO;
    private long OooO0Oo;
    private int OooO0o0;

    public int OooO00o() {
        return this.OooO0o0;
    }

    public void OooO00o(int n10) {
        this.OooO0o0 = n10;
    }

    public void OooO00o(long l10) {
        this.OooO0Oo = l10;
    }

    public void OooO00o(String string2) {
        this.OooO0O0 = string2;
    }

    public long OooO0O0() {
        return this.OooO0Oo;
    }

    public void OooO0O0(int n10) {
        this.OooO00o = n10;
    }

    public String OooO0OO() {
        return this.OooO0O0;
    }

    public void OooO0OO(int n10) {
        this.OooO0OO = n10;
    }

    public int OooO0Oo() {
        return this.OooO0OO;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UploadTaskHistory{id=");
        int n10 = this.OooO00o;
        stringBuilder.append(n10);
        stringBuilder.append(", unique_key='");
        String string2 = this.OooO0O0;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append(", upload_id=");
        n10 = this.OooO0OO;
        stringBuilder.append(n10);
        stringBuilder.append(", createTime=");
        long l10 = this.OooO0Oo;
        stringBuilder.append(l10);
        stringBuilder.append(", cloud_type=");
        n10 = this.OooO0o0;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

