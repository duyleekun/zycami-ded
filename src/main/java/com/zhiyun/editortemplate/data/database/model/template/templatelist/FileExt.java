/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

public class FileExt {
    private String licenseName;
    private String licensePath;
    private String licenseUrl;

    public FileExt() {
    }

    public FileExt(String string2, String string3, String string4) {
        this.licenseUrl = string2;
        this.licenseName = string3;
        this.licensePath = string4;
    }

    public static FileExt create(String string2, String string3, String string4) {
        FileExt fileExt = new FileExt(string2, string3, string4);
        return fileExt;
    }

    public String getLicenseName() {
        return this.licenseName;
    }

    public String getLicensePath() {
        return this.licensePath;
    }

    public String getLicenseUrl() {
        return this.licenseUrl;
    }

    public void setLicenseName(String string2) {
        this.licenseName = string2;
    }

    public void setLicensePath(String string2) {
        this.licensePath = string2;
    }

    public void setLicenseUrl(String string2) {
        this.licenseUrl = string2;
    }
}

