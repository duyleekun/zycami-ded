/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.api.IPCCallback;
import com.huawei.hms.api.ProtocolNegotiate;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.api.transport.DatagramTransport$a;
import com.huawei.hms.support.log.HMSLog;
import java.util.List;

public class IPCTransport
implements DatagramTransport {
    private final String a;
    private final IMessageEntity b;
    private final Class c;
    private int d;

    public IPCTransport(String string2, IMessageEntity iMessageEntity, Class clazz) {
        this.a = string2;
        this.b = iMessageEntity;
        this.c = clazz;
    }

    public IPCTransport(String string2, IMessageEntity iMessageEntity, Class clazz, int n10) {
        this.a = string2;
        this.b = iMessageEntity;
        this.c = clazz;
        this.d = n10;
    }

    private int a(ApiClient object, c object2) {
        int n10 = object instanceof HuaweiApiClientImpl;
        String string2 = "sync call ex:";
        String string3 = "IPCTransport";
        int n11 = 907135001;
        if (n10 != 0) {
            b b10;
            block11: {
                Object object3 = this.a;
                int n12 = ProtocolNegotiate.getInstance().getVersion();
                b10 = new b((String)object3, n12);
                int n13 = b10.c();
                object3 = com.huawei.hms.core.aidl.a.a(n13);
                IMessageEntity iMessageEntity = this.b;
                Object object4 = new Bundle();
                iMessageEntity = ((e)object3).a(iMessageEntity, (Bundle)object4);
                b10.a((Bundle)iMessageEntity);
                iMessageEntity = new RequestHeader();
                object4 = object.getAppID();
                ((RequestHeader)iMessageEntity).setAppID((String)object4);
                object4 = object.getPackageName();
                ((RequestHeader)iMessageEntity).setPackageName((String)object4);
                ((RequestHeader)iMessageEntity).setSdkVersion(50200300);
                object4 = object;
                object4 = ((HuaweiApiClientImpl)object).getApiNameList();
                ((RequestHeader)iMessageEntity).setApiNameList((List)object4);
                object4 = object.getSessionId();
                ((RequestHeader)iMessageEntity).setSessionId((String)object4);
                int n14 = this.d;
                ((RequestHeader)iMessageEntity).setApiLevel(n14);
                object4 = new Bundle();
                object3 = ((e)object3).a(iMessageEntity, (Bundle)object4);
                b10.b = object3;
                try {
                    object = (HuaweiApiClientImpl)object;
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(exception);
                    String string4 = ((StringBuilder)object2).toString();
                    HMSLog.e(string3, string4);
                    return n11;
                }
                object3 = ((HuaweiApiClientImpl)object).getService();
                if (object3 != null) break block11;
                object = "HuaweiApiClient is not binded to service yet.";
                HMSLog.e(string3, (String)object);
                return n11;
            }
            object = ((HuaweiApiClientImpl)object).getService();
            object.a(b10, (c)object2);
            return 0;
        }
        n10 = object instanceof AidlApiClient;
        if (n10 != 0) {
            object = (AidlApiClient)object;
            n10 = ProtocolNegotiate.getInstance().getVersion();
            Object object5 = this.a;
            b b11 = new b((String)object5, n10);
            n10 = b11.c();
            e e10 = com.huawei.hms.core.aidl.a.a(n10);
            object5 = this.b;
            Bundle bundle = new Bundle();
            e10 = e10.a((IMessageEntity)object5, bundle);
            b11.a((Bundle)e10);
            object = object.getService();
            try {
                object.a(b11, (c)object2);
                return 0;
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(exception);
                String string5 = ((StringBuilder)object2).toString();
                HMSLog.e(string3, string5);
            }
        }
        return n11;
    }

    public final void post(ApiClient apiClient, DatagramTransport$a datagramTransport$a) {
        this.send(apiClient, datagramTransport$a);
    }

    public final void send(ApiClient apiClient, DatagramTransport$a datagramTransport$a) {
        Class clazz = this.c;
        IPCCallback iPCCallback = new IPCCallback(clazz, datagramTransport$a);
        int n10 = this.a(apiClient, iPCCallback);
        if (n10 != 0) {
            iPCCallback = null;
            datagramTransport$a.a(n10, null);
        }
    }
}

