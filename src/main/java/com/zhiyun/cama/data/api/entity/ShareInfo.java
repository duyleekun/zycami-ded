/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import java.io.Serializable;

public class ShareInfo
implements Serializable {
    private int circleId;
    private String fileUrl;
    private boolean isShareImage;
    private String postUrl;
    private String shareContent;
    private String smallImgUrl;
    private int worksId;

    public ShareInfo(int n10, int n11, String string2, String string3, String string4, String string5) {
        String string6;
        this.shareContent = string6 = "";
        this.postUrl = string6;
        this.smallImgUrl = string6;
        this.fileUrl = string6;
        this.worksId = n10;
        this.circleId = n11;
        this.shareContent = string2;
        this.postUrl = string3;
        this.smallImgUrl = string4;
        this.fileUrl = string5;
    }

    public int getCircleId() {
        return this.circleId;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getPostUrl() {
        return this.postUrl;
    }

    public String getShareContent() {
        return this.shareContent;
    }

    public String getSmallImgUrl() {
        return this.smallImgUrl;
    }

    public int getWorksId() {
        return this.worksId;
    }

    public boolean isShareImage() {
        return this.isShareImage;
    }

    public void setCircleId(int n10) {
        this.circleId = n10;
    }

    public void setFileUrl(String string2) {
        this.fileUrl = string2;
    }

    public void setPostUrl(String string2) {
        this.postUrl = string2;
    }

    public void setShareContent(String string2) {
        this.shareContent = string2;
    }

    public void setShareImage(boolean bl2) {
        this.isShareImage = bl2;
    }

    public void setSmallImgUrl(String string2) {
        this.smallImgUrl = string2;
    }

    public void setWorksId(int n10) {
        this.worksId = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShareInfo{worksId=");
        int bl2 = this.worksId;
        stringBuilder.append(bl2);
        stringBuilder.append(", circleId=");
        int n10 = this.circleId;
        stringBuilder.append(n10);
        stringBuilder.append(", shareContent='");
        String string2 = this.shareContent;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", postUrl='");
        String string3 = this.postUrl;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", smallImgUrl='");
        string3 = this.smallImgUrl;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", fileUrl='");
        string3 = this.fileUrl;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", isShareImage=");
        boolean bl3 = this.isShareImage;
        stringBuilder.append(bl3);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

