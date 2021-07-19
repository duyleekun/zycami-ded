/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

public class ProductPlatformListBean$ProductOfPlatform {
    private String desc;
    private String packageName;
    private String platform;
    private int platformProductId;
    private int productId;
    private int sort;
    private String supportChannel;
    private String thirdProductId;
    private String thirdProductType;

    public String getDesc() {
        return this.desc;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getPlatformProductId() {
        return this.platformProductId;
    }

    public int getProductId() {
        return this.productId;
    }

    public int getSort() {
        return this.sort;
    }

    public String getSupportChannel() {
        return this.supportChannel;
    }

    public String getThirdProductId() {
        return this.thirdProductId;
    }

    public String getThirdProductType() {
        return this.thirdProductType;
    }

    public void setDesc(String string2) {
        this.desc = string2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void setPlatform(String string2) {
        this.platform = string2;
    }

    public void setPlatformProductId(int n10) {
        this.platformProductId = n10;
    }

    public void setProductId(int n10) {
        this.productId = n10;
    }

    public void setSort(int n10) {
        this.sort = n10;
    }

    public void setSupportChannel(String string2) {
        this.supportChannel = string2;
    }

    public void setThirdProductId(String string2) {
        this.thirdProductId = string2;
    }

    public void setThirdProductType(String string2) {
        this.thirdProductType = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Data{platformProductId=");
        int c10 = this.platformProductId;
        stringBuilder.append(c10);
        stringBuilder.append(", productId=");
        int n10 = this.productId;
        stringBuilder.append(n10);
        stringBuilder.append(", platform='");
        String string2 = this.platform;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", thirdProductId='");
        String string3 = this.thirdProductId;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", thirdProductType='");
        string3 = this.thirdProductType;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", packageName='");
        string3 = this.packageName;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", supportChannel='");
        string3 = this.supportChannel;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", sort=");
        int n11 = this.sort;
        stringBuilder.append(n11);
        stringBuilder.append(", desc='");
        string3 = this.desc;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

