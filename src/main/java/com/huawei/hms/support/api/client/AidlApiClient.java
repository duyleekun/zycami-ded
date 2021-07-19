/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.client.ApiClient;
import java.util.List;

public interface AidlApiClient
extends ApiClient {
    public List getApiNameList();

    public d getService();
}

