/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.nvseditor.data;

public class NvsAssetInfo {
    public static final int ASSET_ANIMATED_STICKER = 2;
    public static final int ASSET_CAPTION_STYLE = 4;
    public static final int ASSET_FILTER = 1;
    public static final int ASSET_STATE_INSTALLED = 1;
    public static final int ASSET_STATE_INSTALL_FAIL = 2;
    public static final int ASSET_STATE_NONE = 0;
    public static final int ASSET_VIDEO_TRANSITION = 3;
    private int aspectRation;
    private int assetType;
    private String fileName;
    private String filePath;
    private StringBuilder packageId;
    private int packageType;
    private int status = 0;
    private String uuid;
    private int version;

    private int changeAssertType2PackageType() {
        int n10 = this.assetType;
        int n11 = 3;
        int n12 = 2;
        if (n10 != n12) {
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    return 0;
                }
                return n12;
            }
            return 1;
        }
        return n11;
    }

    public int getAspectRation() {
        return this.aspectRation;
    }

    public int getAssetType() {
        return this.assetType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public StringBuilder getPackageId() {
        return this.packageId;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAspectRation(int n10) {
        this.aspectRation = n10;
    }

    public void setAssetType(int n10) {
        this.assetType = n10;
        this.packageType = n10 = this.changeAssertType2PackageType();
    }

    public void setFileName(String string2) {
        this.fileName = string2;
    }

    public void setFilePath(String string2) {
        this.filePath = string2;
    }

    public void setPackageId(StringBuilder stringBuilder) {
        this.packageId = stringBuilder;
    }

    public void setPackageType(int n10) {
        this.packageType = n10;
    }

    public void setStatus(int n10) {
        this.status = n10;
    }

    public void setUuid(String string2) {
        this.uuid = string2;
    }

    public void setVersion(int n10) {
        this.version = n10;
    }
}

