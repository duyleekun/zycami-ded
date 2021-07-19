/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  org.json.JSONObject
 */
package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hms.adapter.BaseAdapter$BaseCallBack;
import com.huawei.hms.common.internal.AnyClient$CallBack;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class HmsClient$BaseAdapterCallBack
implements BaseAdapter$BaseCallBack {
    private final AnyClient$CallBack callback;
    private final WeakReference hmsClient;

    public HmsClient$BaseAdapterCallBack(HmsClient hmsClient, AnyClient$CallBack weakReference) {
        this.callback = weakReference;
        this.hmsClient = weakReference = new WeakReference<HmsClient>(hmsClient);
    }

    private void doCallback(String object, String object2) {
        Object object3 = new ResponseHeader();
        boolean bl2 = ((ResponseHeader)object3).fromJson((String)object);
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("receive msg ");
            ((StringBuilder)object).append(object3);
            object = ((StringBuilder)object).toString();
            String string2 = "HmsClient";
            HMSLog.i(string2, (String)object);
            object = ((ResponseHeader)object3).getSessionId();
            this.updateSessionId((String)object);
            object = this.callback;
            object.onCallback((IMessageEntity)object3, (String)object2);
        } else {
            object = this.callback;
            int n10 = 1;
            int n11 = 907135000;
            String string3 = "response header json error";
            object2 = new ResponseHeader(n10, n11, string3);
            object3 = new JSONObject();
            object3 = object3.toString();
            object.onCallback((IMessageEntity)object2, (String)object3);
        }
    }

    private void doCallback(String object, String object2, Parcelable object3) {
        ResponseHeader responseHeader = new ResponseHeader();
        boolean bl2 = responseHeader.fromJson((String)object);
        if (bl2) {
            responseHeader.setParcelable((Parcelable)object3);
            object = new StringBuilder();
            ((StringBuilder)object).append("receive msg ");
            ((StringBuilder)object).append(responseHeader);
            object = ((StringBuilder)object).toString();
            object3 = "HmsClient";
            HMSLog.i((String)object3, (String)object);
            object = responseHeader.getSessionId();
            this.updateSessionId((String)object);
            object = this.callback;
            object.onCallback(responseHeader, (String)object2);
        } else {
            object = this.callback;
            int n10 = 1;
            int n11 = 907135000;
            String string2 = "response header json error";
            object2 = new ResponseHeader(n10, n11, string2);
            object3 = new JSONObject();
            object3 = object3.toString();
            object.onCallback((IMessageEntity)object2, (String)object3);
        }
    }

    private void updateSessionId(String string2) {
        HmsClient hmsClient = (HmsClient)this.hmsClient.get();
        if (hmsClient != null) {
            hmsClient.updateSessionId(string2);
        }
    }

    public void onComplete(String string2, String string3, Parcelable parcelable) {
        if (parcelable == null) {
            this.doCallback(string2, string3);
        } else {
            this.doCallback(string2, string3, parcelable);
        }
    }

    public void onError(String object) {
        Object object2 = new ResponseHeader();
        Object object3 = new ResponseWrap((ResponseHeader)object2);
        boolean bl2 = ((ResponseWrap)object3).fromJson((String)object);
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("receive msg ");
            ((StringBuilder)object).append(object3);
            object = ((StringBuilder)object).toString();
            HMSLog.i("HmsClient", (String)object);
            object = ((ResponseWrap)object3).getResponseHeader();
            object2 = ((ResponseHeader)object).getSessionId();
            this.updateSessionId((String)object2);
            object2 = this.callback;
            object3 = ((ResponseWrap)object3).getBody();
            object2.onCallback((IMessageEntity)object, (String)object3);
        } else {
            object = this.callback;
            int n10 = 1;
            int n11 = 907135000;
            String string2 = "response header json error";
            object3 = new ResponseHeader(n10, n11, string2);
            object2 = new JSONObject();
            object2 = object2.toString();
            object.onCallback((IMessageEntity)object3, (String)object2);
        }
    }
}

