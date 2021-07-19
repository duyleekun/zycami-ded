/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.nvseditor.data;

import com.zhiyun.nvseditor.data.NvsAssetInfo;

public class CustomerAssetInfo
extends NvsAssetInfo {
    private String customerPath;
    private String customerUuid;

    public CustomerAssetInfo() {
    }

    public CustomerAssetInfo(NvsAssetInfo nvsAssetInfo) {
        if (nvsAssetInfo == null) {
            return;
        }
        int n10 = nvsAssetInfo.getAspectRation();
        this.setAspectRation(n10);
        n10 = nvsAssetInfo.getAssetType();
        this.setAssetType(n10);
        CharSequence charSequence = nvsAssetInfo.getFileName();
        this.setFileName((String)charSequence);
        charSequence = nvsAssetInfo.getFilePath();
        this.setFilePath((String)charSequence);
        charSequence = nvsAssetInfo.getPackageId();
        this.setPackageId((StringBuilder)charSequence);
        n10 = nvsAssetInfo.getStatus();
        this.setStatus(n10);
        n10 = nvsAssetInfo.getPackageType();
        this.setPackageType(n10);
        charSequence = nvsAssetInfo.getUuid();
        this.setUuid((String)charSequence);
        int n11 = nvsAssetInfo.getVersion();
        this.setVersion(n11);
    }

    public String getCustomerPath() {
        return this.customerPath;
    }

    public String getCustomerUuid() {
        return this.customerUuid;
    }

    public void setCustomerPath(String string2) {
        this.customerPath = string2;
    }

    public void setCustomerUuid(String string2) {
        this.customerUuid = string2;
    }
}

