/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.ArrayList;

public class GetBucketRefererResult
extends OSSResult {
    private String mAllowEmpty;
    private ArrayList mReferers;

    public void addReferer(String string2) {
        ArrayList arrayList = this.mReferers;
        if (arrayList == null) {
            this.mReferers = arrayList = new ArrayList();
        }
        this.mReferers.add(string2);
    }

    public String getAllowEmpty() {
        return this.mAllowEmpty;
    }

    public ArrayList getReferers() {
        return this.mReferers;
    }

    public void setAllowEmpty(String string2) {
        this.mAllowEmpty = string2;
    }

    public void setReferers(ArrayList arrayList) {
        this.mReferers = arrayList;
    }
}

