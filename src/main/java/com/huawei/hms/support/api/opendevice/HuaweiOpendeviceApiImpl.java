/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.opendevice.u;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.opendevice.OdidReq;
import com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApi;
import com.huawei.hms.support.log.HMSLog;

public class HuaweiOpendeviceApiImpl
implements HuaweiOpendeviceApi {
    public PendingResult getOdid(HuaweiApiClient huaweiApiClient) {
        HMSLog.i("OpenIdentifierApiImpl", "Enter getOdid");
        OdidReq odidReq = new OdidReq();
        u u10 = new u(this, huaweiApiClient, "opendevice.getodid", odidReq);
        return u10;
    }
}

