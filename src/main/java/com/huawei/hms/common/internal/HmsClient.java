/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.adapter.BaseAdapter$BaseCallBack;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.AnyClient$CallBack;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BaseHmsClient$ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient$OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient$BaseAdapterCallBack;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONObject;

public abstract class HmsClient
extends BaseHmsClient
implements AnyClient {
    private static final String TAG = "HmsClient";

    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient$OnConnectionFailedListener baseHmsClient$OnConnectionFailedListener, BaseHmsClient$ConnectionCallbacks baseHmsClient$ConnectionCallbacks) {
        super(context, clientSettings, baseHmsClient$OnConnectionFailedListener, baseHmsClient$ConnectionCallbacks);
    }

    public void post(IMessageEntity iMessageEntity, String string2, AnyClient$CallBack anyClient$CallBack) {
        Object object = TAG;
        if (anyClient$CallBack == null) {
            HMSLog.e((String)object, "callback is invalid, discard.");
            return;
        }
        boolean bl2 = iMessageEntity instanceof RequestHeader;
        int n10 = 1;
        if (bl2 && string2 != null) {
            bl2 = this.isConnected();
            if (!bl2) {
                HMSLog.e((String)object, "post failed for no connected.");
                iMessageEntity = new ResponseHeader(n10, 907135001, "Not Connected");
                string2 = new JSONObject();
                string2 = string2.toString();
                anyClient$CallBack.onCallback(iMessageEntity, string2);
                return;
            }
            iMessageEntity = (RequestHeader)iMessageEntity;
            Object object2 = new StringBuilder();
            Object object3 = "post msg ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(iMessageEntity);
            object2 = ((StringBuilder)object2).toString();
            HMSLog.i((String)object, (String)object2);
            object = this.getClientSettings().getCpActivity();
            object = object == null ? new BaseAdapter(this) : (object2 = new BaseAdapter(this, (Activity)object));
            object2 = ((RequestHeader)iMessageEntity).toJson();
            iMessageEntity = ((RequestHeader)iMessageEntity).getParcelable();
            object3 = new HmsClient$BaseAdapterCallBack(this, anyClient$CallBack);
            ((BaseAdapter)object).baseRequest((String)object2, string2, (Parcelable)iMessageEntity, (BaseAdapter$BaseCallBack)object3);
            return;
        }
        HMSLog.e((String)object, "arguments is invalid.");
        iMessageEntity = new ResponseHeader(n10, 907135000, "Args is invalid");
        string2 = new JSONObject();
        string2 = string2.toString();
        anyClient$CallBack.onCallback(iMessageEntity, string2);
    }

    public void updateSessionId(String string2) {
        String string3 = this.sessionId;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            this.sessionId = string2;
        }
    }
}

