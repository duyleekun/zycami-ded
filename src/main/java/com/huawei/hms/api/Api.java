/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.api;

import com.huawei.hms.api.Api$Options;
import java.util.List;

public class Api {
    private final String a;
    private final Api$Options b;
    public List mConnetctPostList;

    public Api(String string2) {
        this.a = string2;
        this.b = null;
    }

    public Api(String string2, Api$Options api$Options) {
        this.a = string2;
        this.b = api$Options;
    }

    public String getApiName() {
        return this.a;
    }

    public Api$Options getOptions() {
        return this.b;
    }

    public List getmConnetctPostList() {
        return this.mConnetctPostList;
    }

    public void setmConnetctPostList(List list) {
        this.mConnetctPostList = list;
    }
}

