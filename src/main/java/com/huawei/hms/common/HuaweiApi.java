/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api$ApiOptions;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.ConnectionManagerKey;
import com.huawei.hms.common.internal.HuaweiApiManager;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import d.j.d.a.b;
import d.j.d.a.k;
import d.j.d.a.l;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class HuaweiApi {
    private static final String TAG = "HuaweiApi";
    private int apiLevel = 1;
    private String innerHmsPkg;
    private boolean isFirstReqSent = false;
    private WeakReference mActivity;
    private String mAppID;
    private AbstractClientBuilder mClientBuilder;
    private ConnectionManagerKey mConnectionManagerKey;
    private Context mContext;
    private String mCpID;
    private String mHostAppid;
    private HuaweiApiManager mHuaweiApiManager;
    private int mKitSdkVersion;
    private Api$ApiOptions mOption;
    private SubAppInfo mSubAppInfo;

    public HuaweiApi(Activity activity, Api api, Api$ApiOptions api$ApiOptions, AbstractClientBuilder abstractClientBuilder) {
        WeakReference<Activity> weakReference;
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = weakReference = new WeakReference<Activity>(activity);
        this.init((Context)activity, api, api$ApiOptions, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(Activity activity, Api api, Api$ApiOptions api$ApiOptions, AbstractClientBuilder abstractClientBuilder, int n10) {
        WeakReference<Activity> weakReference;
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = weakReference = new WeakReference<Activity>(activity);
        this.init((Context)activity, api, api$ApiOptions, abstractClientBuilder, n10, null);
    }

    public HuaweiApi(Activity activity, Api api, Api$ApiOptions api$ApiOptions, AbstractClientBuilder abstractClientBuilder, int n10, String string2) {
        WeakReference<Activity> weakReference;
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.mActivity = weakReference = new WeakReference<Activity>(activity);
        this.init((Context)activity, api, api$ApiOptions, abstractClientBuilder, n10, string2);
    }

    public HuaweiApi(Context context, Api api, Api$ApiOptions api$ApiOptions, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        this.init(context, api, api$ApiOptions, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(Context context, Api api, Api$ApiOptions api$ApiOptions, AbstractClientBuilder abstractClientBuilder, int n10) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        this.init(context, api, api$ApiOptions, abstractClientBuilder, n10, null);
    }

    public HuaweiApi(Context context, Api api, Api$ApiOptions api$ApiOptions, AbstractClientBuilder abstractClientBuilder, int n10, String string2) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        this.init(context, api, api$ApiOptions, abstractClientBuilder, n10, string2);
    }

    private void init(Context context, Api object, Api$ApiOptions object2, AbstractClientBuilder object3, int n10, String string2) {
        Object object4;
        this.mContext = object4 = context.getApplicationContext();
        object4 = HuaweiApiManager.getInstance(object4);
        this.mHuaweiApiManager = object4;
        this.mConnectionManagerKey = object = ConnectionManagerKey.createConnectionManagerKey(context, (Api)object, (Api$ApiOptions)object2, string2);
        this.mOption = object2;
        this.mClientBuilder = object3;
        this.mHostAppid = object = Util.getAppId(context);
        this.mAppID = object;
        this.mCpID = object = Util.getCpId(context);
        object2 = "";
        this.mSubAppInfo = object = new SubAppInfo((String)object2);
        this.mKitSdkVersion = n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            object = this.mHostAppid;
            bl2 = string2.equals(object);
            object2 = TAG;
            if (bl2) {
                object = "subAppId is host appid";
                HMSLog.e((String)object2, (String)object);
            } else {
                object = new StringBuilder();
                object3 = "subAppId is ";
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                HMSLog.i((String)object2, (String)object);
                this.mSubAppInfo = object = new SubAppInfo(string2);
            }
        }
        this.initBI(context);
    }

    private void initBI(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    private k sendRequest(TaskApiCall taskApiCall) {
        Object object = taskApiCall.getToken();
        if (object == null) {
            object = new l();
        } else {
            b b10 = taskApiCall.getToken();
            object = new l(b10);
        }
        this.mHuaweiApiManager.sendRequest(this, taskApiCall, (l)object);
        return ((l)object).b();
    }

    public k disconnectService() {
        l l10 = new l();
        this.mHuaweiApiManager.disconnectService(this, l10);
        return l10.b();
    }

    public k doWrite(TaskApiCall object) {
        boolean bl2;
        this.isFirstReqSent = bl2 = true;
        if (object == null) {
            HMSLog.e(TAG, "in doWrite:taskApiCall is null");
            object = new l();
            Status status = Status.FAILURE;
            ApiException apiException = new ApiException(status);
            ((l)object).c(apiException);
            return ((l)object).b();
        }
        String string2 = this.mSubAppInfo.getSubAppID();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        string2 = bl2 ? this.mAppID : this.mSubAppInfo.getSubAppID();
        Context context = this.mContext;
        String string3 = ((TaskApiCall)object).getUri();
        String string4 = ((TaskApiCall)object).getTransactionId();
        String string5 = String.valueOf(this.getKitSdkVersion());
        com.huawei.hms.support.hianalytics.b.a(context, string3, string2, string4, string5);
        return this.sendRequest((TaskApiCall)object);
    }

    public Activity getActivity() {
        WeakReference weakReference = this.mActivity;
        if (weakReference != null) {
            return (Activity)weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getAppID() {
        return this.mAppID;
    }

    public AnyClient getClient(Looper object, HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager) {
        object = this.mClientBuilder;
        Context context = this.mContext;
        ClientSettings clientSettings = this.getClientSetting();
        return ((AbstractClientBuilder)object).buildClient(context, clientSettings, huaweiApiManager$ConnectionManager, huaweiApiManager$ConnectionManager);
    }

    public ClientSettings getClientSetting() {
        ClientSettings clientSettings;
        String string2 = this.mContext.getPackageName();
        String string3 = this.mContext.getClass().getName();
        List list = this.getScopes();
        String string4 = this.mHostAppid;
        SubAppInfo subAppInfo = this.mSubAppInfo;
        Object object = clientSettings;
        clientSettings = new ClientSettings(string2, string3, list, string4, null, subAppInfo);
        object = this.mCpID;
        clientSettings.setCpID((String)object);
        object = this.innerHmsPkg;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            this.innerHmsPkg = object = HMSPackageManager.getInstance(this.mContext).getHMSPackageName();
            object = new StringBuilder();
            ((StringBuilder)object).append("inner hms is empty,hms pkg name is ");
            string2 = this.innerHmsPkg;
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = TAG;
            HMSLog.i(string2, (String)object);
        }
        object = this.innerHmsPkg;
        clientSettings.setInnerHmsPkg((String)object);
        object = this.mActivity;
        if (object != null) {
            object = (Activity)((Reference)object).get();
            clientSettings.setCpActivity((Activity)object);
        }
        return clientSettings;
    }

    public ConnectionManagerKey getConnectionManagerKey() {
        return this.mConnectionManagerKey;
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getKitSdkVersion() {
        return this.mKitSdkVersion;
    }

    public Api$ApiOptions getOption() {
        return this.mOption;
    }

    public List getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.mSubAppInfo.getSubAppID();
    }

    public void setApiLevel(int n10) {
        this.apiLevel = n10;
    }

    public void setInnerHms() {
        CharSequence charSequence = this.mContext.getPackageName();
        this.innerHmsPkg = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("init inner hms pkg info:");
        String string2 = this.innerHmsPkg;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        HMSLog.i(TAG, (String)charSequence);
    }

    public void setKitSdkVersion(int n10) {
        this.mKitSdkVersion = n10;
    }

    public void setSubAppId(String object) {
        Object object2 = new SubAppInfo((String)object);
        boolean bl2 = this.setSubAppInfo((SubAppInfo)object2);
        if (bl2) {
            return;
        }
        object2 = Status.FAILURE;
        object = new ApiException((Status)object2);
        throw object;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        boolean bl2;
        Object object = TAG;
        HMSLog.i((String)object, "Enter setSubAppInfo");
        Object object2 = this.mSubAppInfo;
        if (object2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((SubAppInfo)object2).getSubAppID())))) {
            HMSLog.e((String)object, "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.e((String)object, "subAppInfo is null");
            return false;
        }
        object2 = subAppInfo.getSubAppID();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (bl3) {
            HMSLog.e((String)object, "subAppId is empty");
            return false;
        }
        String string2 = this.mHostAppid;
        bl2 = ((String)object2).equals(string2);
        if (bl2) {
            HMSLog.e((String)object, "subAppId is host appid");
            return false;
        }
        bl2 = this.isFirstReqSent;
        if (bl2) {
            HMSLog.e((String)object, "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.mSubAppInfo = object = new SubAppInfo(subAppInfo);
        return true;
    }
}

