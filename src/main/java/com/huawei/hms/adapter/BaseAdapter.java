/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.BaseAdapter$1;
import com.huawei.hms.adapter.BaseAdapter$BaseCallBack;
import com.huawei.hms.adapter.BaseAdapter$BaseRequestResultCallback;
import com.huawei.hms.adapter.BaseAdapter$MPendingResultImpl;
import com.huawei.hms.adapter.CoreBaseRequest;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.BaseResolutionAdapter;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseAdapter {
    private static final String TAG = "BaseAdapter";
    private WeakReference activityWeakReference;
    private WeakReference api;
    private Context appContext;
    private BaseAdapter$BaseCallBack baseCallBackReplay;
    private BaseAdapter$BaseCallBack callback;
    private String jsonHeaderReplay;
    private String jsonObjectReplay;
    private SystemObserver observer;
    private Parcelable parcelableReplay;
    private RequestHeader requestHeader;
    private ResponseHeader responseHeader;
    private String transactionId;

    public BaseAdapter(ApiClient apiClient) {
        WeakReference<ApiClient> weakReference = new WeakReference<ApiClient>();
        this.requestHeader = weakReference;
        this.responseHeader = weakReference;
        this.api = weakReference = new WeakReference<ApiClient>(apiClient);
    }

    public BaseAdapter(ApiClient context, Activity activity) {
        WeakReference<ApiClient> weakReference = new WeakReference<ApiClient>();
        this.requestHeader = weakReference;
        this.responseHeader = weakReference;
        this.api = weakReference = new WeakReference<ApiClient>((ApiClient)context);
        this.activityWeakReference = context = new WeakReference(activity);
        this.appContext = context = activity.getApplicationContext();
    }

    public static /* synthetic */ BaseAdapter$BaseCallBack access$000(BaseAdapter baseAdapter) {
        return baseAdapter.getCallBack();
    }

    public static /* synthetic */ String access$100(BaseAdapter baseAdapter, int n10) {
        return baseAdapter.getResponseHeaderForError(n10);
    }

    public static /* synthetic */ String access$1000(BaseAdapter baseAdapter, int n10) {
        return baseAdapter.buildBodyStr(n10);
    }

    public static /* synthetic */ ResponseWrap access$1100(BaseAdapter baseAdapter, int n10, String string2) {
        return baseAdapter.buildResponseWrap(n10, string2);
    }

    public static /* synthetic */ ResponseHeader access$200(BaseAdapter baseAdapter) {
        return baseAdapter.responseHeader;
    }

    public static /* synthetic */ Context access$300(BaseAdapter baseAdapter) {
        return baseAdapter.appContext;
    }

    public static /* synthetic */ void access$400(BaseAdapter baseAdapter, Context context, ResponseHeader responseHeader) {
        baseAdapter.biReportRequestReturnIpc(context, responseHeader);
    }

    public static /* synthetic */ Activity access$500(BaseAdapter baseAdapter) {
        return baseAdapter.getCpActivity();
    }

    public static /* synthetic */ void access$600(BaseAdapter baseAdapter, Activity activity, Parcelable parcelable) {
        baseAdapter.startResolution(activity, parcelable);
    }

    public static /* synthetic */ String access$700(BaseAdapter baseAdapter) {
        return baseAdapter.transactionId;
    }

    public static /* synthetic */ void access$800(BaseAdapter baseAdapter, Context context, ResponseHeader responseHeader, long l10) {
        baseAdapter.biReportRequestReturnSolution(context, responseHeader, l10);
    }

    public static /* synthetic */ void access$900(BaseAdapter baseAdapter) {
        baseAdapter.replayRequest();
    }

    private PendingResult baseRequest(ApiClient apiClient, String string2, CoreBaseRequest coreBaseRequest) {
        BaseAdapter$MPendingResultImpl baseAdapter$MPendingResultImpl = new BaseAdapter$MPendingResultImpl(apiClient, string2, coreBaseRequest);
        return baseAdapter$MPendingResultImpl;
    }

    private void biReportRequestEntryIpc(Context context, RequestHeader object) {
        Map map = HiAnalyticsUtil.getInstance().getMapFromRequestHeader((RequestHeader)object);
        map.put("direction", "req");
        object = HiAnalyticsUtil.versionCodeToName(String.valueOf(((RequestHeader)object).getKitSdkVersion()));
        map.put("version", object);
        object = Util.getSystemProperties("ro.logsystem.usertype", "");
        map.put("phoneType", object);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_CALL_AIDL", map);
    }

    private void biReportRequestEntrySolution(Context context, RequestHeader object) {
        Map map = HiAnalyticsUtil.getInstance().getMapFromRequestHeader((RequestHeader)object);
        map.put("direction", "req");
        object = HiAnalyticsUtil.versionCodeToName(String.valueOf(((RequestHeader)object).getKitSdkVersion()));
        map.put("version", object);
        object = Util.getSystemProperties("ro.logsystem.usertype", "");
        map.put("phoneType", object);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_START_RESOLUTION", map);
    }

    private void biReportRequestReturnIpc(Context context, ResponseHeader object) {
        HiAnalyticsUtil.getInstance();
        object = HiAnalyticsUtil.getMapFromRequestHeader((ResponseHeader)object);
        object.put("direction", "rsp");
        String string2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion()));
        object.put("version", string2);
        string2 = Util.getSystemProperties("ro.logsystem.usertype", "");
        object.put("phoneType", string2);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_CALL_AIDL", (Map)object);
    }

    private void biReportRequestReturnSolution(Context context, ResponseHeader object, long l10) {
        HiAnalyticsUtil.getInstance();
        object = HiAnalyticsUtil.getMapFromRequestHeader((ResponseHeader)object);
        object.put("direction", "rsp");
        String string2 = String.valueOf(l10);
        object.put("waitTime", string2);
        string2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(this.requestHeader.getKitSdkVersion()));
        object.put("version", string2);
        string2 = Util.getSystemProperties("ro.logsystem.usertype", "");
        object.put("phoneType", string2);
        HiAnalyticsUtil.getInstance().onNewEvent(context, "HMS_SDK_BASE_START_RESOLUTION", (Map)object);
    }

    private String buildBodyStr(int n10) {
        JSONObject jSONObject = new JSONObject();
        CharSequence charSequence = "errorCode";
        try {
            jSONObject.put((String)charSequence, n10);
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            String string2 = "buildBodyStr failed: ";
            ((StringBuilder)charSequence).append(string2);
            String string3 = jSONException.getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            charSequence = TAG;
            HMSLog.e((String)charSequence, string3);
        }
        return jSONObject.toString();
    }

    private ResponseWrap buildResponseWrap(int n10, String string2) {
        this.setResponseHeader(n10);
        ResponseHeader responseHeader = this.responseHeader;
        ResponseWrap responseWrap = new ResponseWrap(responseHeader);
        responseWrap.setBody(string2);
        return responseWrap;
    }

    private BaseAdapter$BaseCallBack getBaseCallBackReplay() {
        return this.baseCallBackReplay;
    }

    private BaseAdapter$BaseCallBack getCallBack() {
        BaseAdapter$BaseCallBack baseAdapter$BaseCallBack = this.callback;
        if (baseAdapter$BaseCallBack == null) {
            String string2 = "callback null";
            HMSLog.e(TAG, string2);
            baseAdapter$BaseCallBack = null;
        }
        return baseAdapter$BaseCallBack;
    }

    private Activity getCpActivity() {
        Object object = this.activityWeakReference;
        CharSequence charSequence = null;
        String string2 = TAG;
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("activityWeakReference is ");
            WeakReference weakReference = this.activityWeakReference;
            ((StringBuilder)object).append(weakReference);
            object = ((StringBuilder)object).toString();
            HMSLog.i(string2, (String)object);
            return null;
        }
        object = (ApiClient)this.api.get();
        if (object == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tmpApi is ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            HMSLog.i(string2, (String)object);
            return null;
        }
        charSequence = new StringBuilder();
        charSequence.append("activityWeakReference has ");
        Object t10 = this.activityWeakReference.get();
        charSequence.append(t10);
        charSequence = charSequence.toString();
        HMSLog.i(string2, (String)charSequence);
        charSequence = (Activity)this.activityWeakReference.get();
        object = object.getContext();
        return Util.getActiveActivity((Activity)charSequence, (Context)object);
    }

    private String getJsonHeaderReplay() {
        return this.jsonHeaderReplay;
    }

    private String getJsonObjectReplay() {
        return this.jsonObjectReplay;
    }

    private Parcelable getParcelableReplay() {
        return this.parcelableReplay;
    }

    private String getResponseHeaderForError(int n10) {
        this.setResponseHeader(n10);
        return this.responseHeader.toJson();
    }

    private void initObserver() {
        BaseAdapter$1 baseAdapter$1 = new BaseAdapter$1(this);
        this.observer = baseAdapter$1;
    }

    private void replayRequest() {
        Object object = this.jsonHeaderReplay;
        if (object != null && (object = this.baseCallBackReplay) != null) {
            this.responseHeader = null;
            this.responseHeader = object = new ResponseHeader();
            object = this.getJsonHeaderReplay();
            String string2 = this.getJsonObjectReplay();
            Parcelable parcelable = this.getParcelableReplay();
            BaseAdapter$BaseCallBack baseAdapter$BaseCallBack = this.getBaseCallBackReplay();
            this.baseRequest((String)object, string2, parcelable, baseAdapter$BaseCallBack);
        }
    }

    private void setBaseCallBackReplay(BaseAdapter$BaseCallBack baseAdapter$BaseCallBack) {
        this.baseCallBackReplay = baseAdapter$BaseCallBack;
    }

    private void setJsonHeaderReplay(String string2) {
        this.jsonHeaderReplay = string2;
    }

    private void setJsonObjectReplay(String string2) {
        this.jsonObjectReplay = string2;
    }

    private void setParcelableReplay(Parcelable parcelable) {
        this.parcelableReplay = parcelable;
    }

    private void setReplayData(String string2, String string3, Parcelable parcelable, BaseAdapter$BaseCallBack baseAdapter$BaseCallBack) {
        this.setJsonHeaderReplay(string2);
        this.setJsonObjectReplay(string3);
        this.setParcelableReplay(parcelable);
        this.setBaseCallBackReplay(baseAdapter$BaseCallBack);
    }

    private void setResponseHeader(int n10) {
        ResponseHeader responseHeader = this.responseHeader;
        String string2 = this.requestHeader.getTransactionId();
        responseHeader.setTransactionId(string2);
        responseHeader = this.responseHeader;
        string2 = this.requestHeader.getAppID();
        responseHeader.setAppID(string2);
        responseHeader = this.responseHeader;
        string2 = this.requestHeader.getApiName();
        responseHeader.setApiName(string2);
        responseHeader = this.responseHeader;
        string2 = this.requestHeader.getSrvName();
        responseHeader.setSrvName(string2);
        responseHeader = this.responseHeader;
        string2 = this.requestHeader.getPkgName();
        responseHeader.setPkgName(string2);
        this.responseHeader.setStatusCode(1);
        this.responseHeader.setErrorCode(n10);
        this.responseHeader.setErrorReason("Core error");
    }

    private void startResolution(Activity activity, Parcelable object) {
        Object object2 = "startResolution";
        HMSLog.i(TAG, (String)object2);
        Object object3 = this.requestHeader;
        if (object3 != null) {
            object2 = this.appContext;
            this.biReportRequestEntrySolution((Context)object2, (RequestHeader)object3);
        }
        if ((object3 = this.observer) == null) {
            this.initObserver();
        }
        object3 = SystemManager.getSystemNotifier();
        object2 = this.observer;
        object3.registerObserver((SystemObserver)object2);
        object3 = BaseResolutionAdapter.class.getName();
        object3 = BridgeActivity.getIntentStartBridgeActivity(activity, (String)object3);
        object2 = new Bundle();
        object2.putParcelable("resolution", object);
        object3.putExtras((Bundle)object2);
        object = this.transactionId;
        object3.putExtra("transaction_id", (String)object);
        activity.startActivity((Intent)object3);
    }

    public void baseRequest(String object, String object2, Parcelable object3, BaseAdapter$BaseCallBack baseAdapter$BaseCallBack) {
        this.setReplayData((String)object, (String)object2, (Parcelable)object3, baseAdapter$BaseCallBack);
        Object object4 = this.api;
        String string2 = TAG;
        if (object4 == null) {
            HMSLog.e(string2, "client is null");
            object = this.getResponseHeaderForError(-2);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        this.callback = baseAdapter$BaseCallBack;
        object4 = this.requestHeader;
        JsonUtil.jsonToEntity((String)object, (IMessageEntity)object4);
        object4 = new CoreBaseRequest();
        ((CoreBaseRequest)object4).setJsonObject((String)object2);
        ((CoreBaseRequest)object4).setJsonHeader((String)object);
        ((CoreBaseRequest)object4).setParcelable((Parcelable)object3);
        object = this.requestHeader.getApiName();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            HMSLog.e(string2, "get uri null");
            object = this.getResponseHeaderForError(-5);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        object2 = this.requestHeader.getTransactionId();
        this.transactionId = object2;
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            HMSLog.e(string2, "get transactionId null");
            object = this.getResponseHeaderForError(-6);
            baseAdapter$BaseCallBack.onError((String)object);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("in baseRequest + uri is :");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(", transactionId is : ");
        object3 = this.transactionId;
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        HMSLog.i(string2, (String)object2);
        object2 = this.appContext;
        object3 = this.requestHeader;
        this.biReportRequestEntryIpc((Context)object2, (RequestHeader)object3);
        object2 = (ApiClient)this.api.get();
        object = this.baseRequest((ApiClient)object2, (String)object, (CoreBaseRequest)object4);
        object2 = new BaseAdapter$BaseRequestResultCallback(this);
        ((PendingResult)object).setResultCallback((ResultCallback)object2);
    }
}

