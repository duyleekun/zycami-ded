/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.support.api.core;

import android.text.TextUtils;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.core.ConnectService$a;
import com.huawei.hms.support.api.core.ConnectService$b;
import com.huawei.hms.support.api.core.ConnectService$c;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;

public final class ConnectService {
    private ConnectService() {
    }

    public static InnerPendingResult checkconnect(ApiClient apiClient, CheckConnectInfo checkConnectInfo) {
        return ResolvePendingResult.build(apiClient, "core.checkconnect", checkConnectInfo, CheckConnectResp.class);
    }

    public static PendingResult connect(ApiClient apiClient, ConnectInfo connectInfo) {
        ConnectService$a connectService$a = new ConnectService$a(apiClient, "core.connect", connectInfo);
        return connectService$a;
    }

    public static ResolvePendingResult disconnect(ApiClient apiClient, DisconnectInfo disconnectInfo) {
        return ResolvePendingResult.build(apiClient, "core.disconnect", disconnectInfo, DisconnectResp.class);
    }

    public static PendingResult forceConnect(ApiClient apiClient, ConnectInfo connectInfo) {
        ConnectService$b connectService$b = new ConnectService$b(apiClient, "core.foreconnect", connectInfo);
        return connectService$b;
    }

    public static PendingResult getNotice(ApiClient apiClient, int n10, String string2) {
        JosGetNoticeReq josGetNoticeReq = new JosGetNoticeReq();
        josGetNoticeReq.setNoticeType(n10);
        josGetNoticeReq.setHmsSdkVersionName(string2);
        Object object = apiClient.getCpID();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object = apiClient.getCpID();
            josGetNoticeReq.setCpID((String)object);
        }
        object = new ConnectService$c(apiClient, "core.getNoticeIntent", josGetNoticeReq);
        return object;
    }
}

