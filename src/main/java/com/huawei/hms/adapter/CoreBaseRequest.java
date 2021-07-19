/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 */
package com.huawei.hms.adapter;

import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;

public class CoreBaseRequest
implements IMessageEntity {
    private String jsonHeader;
    private String jsonObject;
    private Parcelable parcelable;

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public String getJsonObject() {
        return this.jsonObject;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public void setJsonHeader(String string2) {
        this.jsonHeader = string2;
    }

    public void setJsonObject(String string2) {
        this.jsonObject = string2;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }
}

