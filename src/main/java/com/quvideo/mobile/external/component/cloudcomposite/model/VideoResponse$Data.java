/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.model;

import com.quvideo.mobile.external.component.cloudcomposite.model.VideoResponse;

public class VideoResponse$Data {
    private String OooO00o;
    private String OooO0O0;
    private String OooO0OO;
    private String OooO0Oo;
    private String OooO0o0;

    public VideoResponse$Data(VideoResponse videoResponse, String string2, String string3, String string4, String string5, String string6) {
        this.OooO00o = string2;
        this.OooO0O0 = string3;
        this.OooO0OO = string5;
        this.OooO0Oo = string6;
        this.OooO0o0 = string4;
    }

    public String getBusinessId() {
        return this.OooO0Oo;
    }

    public String getCoverImageUrl() {
        return this.OooO0o0;
    }

    public String getDuration() {
        return this.OooO0OO;
    }

    public String getFileId() {
        return this.OooO00o;
    }

    public String getFileUrl() {
        return this.OooO0O0;
    }
}

