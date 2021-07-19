/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.ForegroundBusDelegate$MyAvailableCallBack;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.AvailableAdapter$AvailableCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

public class ForegroundBusDelegate
implements IBridgeActivityDelegate {
    private static final String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
    private static final String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    private static final int REQUEST_CODE_BUS = 431057;
    private static final String TAG = "ForegroundBusDelegate";
    private static final String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
    private String foregroundBody;
    private RequestHeader foregroundHeader;
    private ForegroundInnerHeader innerHeader;
    private WeakReference mThisWeakRef;
    private ResponseHeader responseHeader;

    public ForegroundBusDelegate() {
        ForegroundInnerHeader foregroundInnerHeader;
        this.innerHeader = foregroundInnerHeader = new ForegroundInnerHeader();
    }

    public static /* synthetic */ void access$100(ForegroundBusDelegate foregroundBusDelegate) {
        foregroundBusDelegate.startApkHubActivity();
    }

    public static /* synthetic */ void access$200(ForegroundBusDelegate foregroundBusDelegate, int n10, String string2) {
        foregroundBusDelegate.errorReturn(n10, string2);
    }

    private void biReportRequestEntryForegroundBus() {
        Object object = HiAnalyticsUtil.getInstance();
        Object object2 = this.foregroundHeader;
        object = ((HiAnalyticsUtil)object).getMapFromForegroundRequestHeader((RequestHeader)object2);
        object.put("direction", "req");
        int n10 = this.foregroundHeader.getKitSdkVersion();
        object2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(n10));
        String string2 = "version";
        object.put(string2, object2);
        object2 = this.getActivity();
        if (object2 != null) {
            object2 = HiAnalyticsUtil.getInstance();
            string2 = this.getActivity().getApplicationContext();
            String string3 = "HMS_SDK_BASE_ACTIVITY_STARTED";
            ((HiAnalyticsUtil)object2).onNewEvent((Context)string2, string3, (Map)object);
        }
    }

    private void biReportRequestEntryStartCore() {
        Object object = HiAnalyticsUtil.getInstance();
        Object object2 = this.foregroundHeader;
        object = ((HiAnalyticsUtil)object).getMapFromForegroundRequestHeader((RequestHeader)object2);
        object.put("direction", "req");
        int n10 = this.foregroundHeader.getKitSdkVersion();
        object2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(n10));
        String string2 = "version";
        object.put(string2, object2);
        object2 = this.getActivity();
        if (object2 != null) {
            object2 = HiAnalyticsUtil.getInstance();
            string2 = this.getActivity().getApplicationContext();
            String string3 = "HMS_SDK_BASE_START_CORE_ACTIVITY";
            ((HiAnalyticsUtil)object2).onNewEvent((Context)string2, string3, (Map)object);
        }
    }

    private void biReportRequestReturnForegroundBus() {
        Object object = this.foregroundHeader;
        if (object != null) {
            object = HiAnalyticsUtil.getInstance();
            Object object2 = this.foregroundHeader;
            object = ((HiAnalyticsUtil)object).getMapFromForegroundRequestHeader((RequestHeader)object2);
            object.put("direction", "rsp");
            int n10 = this.foregroundHeader.getKitSdkVersion();
            object2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(n10));
            String string2 = "version";
            object.put(string2, object2);
            object2 = this.responseHeader;
            if (object2 != null) {
                object2 = String.valueOf(((ResponseHeader)object2).getStatusCode());
                object.put("statusCode", object2);
                n10 = this.responseHeader.getErrorCode();
                object2 = String.valueOf(n10);
                string2 = "result";
                object.put(string2, object2);
            }
            if ((object2 = this.getActivity()) != null) {
                object2 = HiAnalyticsUtil.getInstance();
                string2 = this.getActivity().getApplicationContext();
                String string3 = "HMS_SDK_BASE_ACTIVITY_STARTED";
                ((HiAnalyticsUtil)object2).onNewEvent((Context)string2, string3, (Map)object);
            }
        }
    }

    private void biReportRequestReturnStartCore() {
        Object object = HiAnalyticsUtil.getInstance();
        Object object2 = this.foregroundHeader;
        object = ((HiAnalyticsUtil)object).getMapFromForegroundRequestHeader((RequestHeader)object2);
        object.put("direction", "rsp");
        int n10 = this.foregroundHeader.getKitSdkVersion();
        object2 = HiAnalyticsUtil.versionCodeToName(String.valueOf(n10));
        String string2 = "version";
        object.put(string2, object2);
        object2 = this.responseHeader;
        if (object2 != null) {
            object2 = String.valueOf(((ResponseHeader)object2).getStatusCode());
            object.put("statusCode", object2);
            n10 = this.responseHeader.getErrorCode();
            object2 = String.valueOf(n10);
            string2 = "result";
            object.put(string2, object2);
        }
        if ((object2 = this.getActivity()) != null) {
            object2 = HiAnalyticsUtil.getInstance();
            string2 = this.getActivity().getApplicationContext();
            String string3 = "HMS_SDK_BASE_START_CORE_ACTIVITY";
            ((HiAnalyticsUtil)object2).onNewEvent((Context)string2, string3, (Map)object);
        }
    }

    private void checkMinVersion() {
        Object object = this.getActivity();
        Object object2 = TAG;
        if (object == null) {
            HMSLog.e((String)object2, "checkMinVersion failed, activity must not be null.");
            return;
        }
        object = this.getActivity().getApplicationContext();
        int n10 = Util.isAvailableLibExist((Context)object);
        if (n10 == 0) {
            ForegroundInnerHeader foregroundInnerHeader;
            int n11;
            Context context;
            object = HuaweiApiAvailability.getInstance();
            n10 = ((HuaweiApiAvailability)object).isHuaweiMobileServicesAvailable(context = this.getActivity().getApplicationContext(), n11 = (foregroundInnerHeader = this.innerHeader).getApkVersion());
            if (n10 != 0) {
                HMSLog.e((String)object2, "checkMinVersion failed, and no available lib exists.");
                return;
            }
            this.startApkHubActivity();
        } else {
            object = new ForegroundBusDelegate$MyAvailableCallBack(this, null);
            int n12 = this.innerHeader.getApkVersion();
            object2 = new AvailableAdapter(n12);
            Activity activity = this.getActivity();
            if ((n12 = ((AvailableAdapter)object2).isHuaweiMobileServicesAvailable((Context)activity)) == 0) {
                ((ForegroundBusDelegate$MyAvailableCallBack)object).onComplete(n12);
            } else {
                boolean bl2 = ((AvailableAdapter)object2).isUserResolvableError(n12);
                if (bl2) {
                    activity = this.getActivity();
                    ForegroundBusDelegate.resolution(activity, (AvailableAdapter)object2, (AvailableAdapter$AvailableCallBack)object);
                } else {
                    ((ForegroundBusDelegate$MyAvailableCallBack)object).onComplete(n12);
                }
            }
        }
    }

    private void errorReturn(int n10, String string2) {
        HMSLog.e(TAG, string2);
        Activity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        Object object = this.innerHeader.getResponseCallbackKey();
        if ((object = this.getResponseCallback((String)object)) != null) {
            Activity activity2 = (Activity)this.mThisWeakRef.get();
            BusResponseResult busResponseResult = object.innerError(activity2, n10, string2);
            if (busResponseResult == null) {
                activity.setResult(0);
            } else {
                int n11 = busResponseResult.getCode();
                busResponseResult = busResponseResult.getIntent();
                activity.setResult(n11, (Intent)busResponseResult);
            }
        } else {
            activity.setResult(0);
        }
        this.finishBridgeActivity();
    }

    private void finishBridgeActivity() {
        boolean bl2;
        Activity activity = this.getActivity();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity.finish();
        }
    }

    private Activity getActivity() {
        WeakReference weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    private BusResponseCallback getResponseCallback(String string2) {
        return ForegroundBusResponseMgr.getInstance().get(string2);
    }

    private static void resolution(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter$AvailableCallBack availableAdapter$AvailableCallBack) {
        if (activity == null) {
            String string2 = TAG;
            String string3 = "null activity, could not start resolution intent";
            HMSLog.i(string2, string3);
        }
        availableAdapter.startResolution(activity, availableAdapter$AvailableCallBack);
    }

    private void startApkHubActivity() {
        String string2 = TAG;
        HMSLog.i(string2, "startApkHubActivity");
        Activity activity = this.getActivity();
        if (activity == null) {
            HMSLog.e(string2, "startApkHubActivity but activity is null");
            return;
        }
        String string3 = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        String string4 = this.innerHeader.getAction();
        Intent intent = new Intent(string4);
        string4 = this.foregroundBody;
        String string5 = HMS_FOREGROUND_REQ_BODY;
        intent.putExtra(string5, string4);
        intent.setPackage(string3);
        intent.setClassName(string3, UI_JUMP_ACTIVITY_NAME);
        string3 = this.foregroundHeader.toJson();
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, string3);
        string3 = EXTRA_DELEGATE_NAME;
        string4 = EXTRA_DELEGATE_VALUE;
        intent.putExtra(string3, string4);
        this.biReportRequestEntryStartCore();
        int n10 = 431057;
        try {
            activity.startActivityForResult(intent, n10);
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            string3 = "Launch sign in Intent failed. hms is probably being updated\uff1a";
            HMSLog.e(string2, string3, activityNotFoundException);
            string2 = null;
            String string6 = "launch bus intent failed";
            this.errorReturn(0, string6);
        }
    }

    private void succeedReturn(int n10, Intent intent) {
        String string2 = "succeedReturn";
        HMSLog.i(TAG, string2);
        Activity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        activity.setResult(n10, intent);
        this.finishBridgeActivity();
    }

    public int getRequestCode() {
        return 431057;
    }

    public void onBridgeActivityCreate(Activity object) {
        RequestHeader requestHeader;
        Object object2 = new WeakReference(object);
        this.mThisWeakRef = object2;
        object = object.getIntent();
        object2 = object.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
        this.foregroundHeader = requestHeader = new RequestHeader();
        boolean bl2 = requestHeader.fromJson((String)object2);
        requestHeader = null;
        if (!bl2) {
            this.errorReturn(0, "header is invalid");
            return;
        }
        this.foregroundBody = object2 = object.getStringExtra(HMS_FOREGROUND_REQ_BODY);
        object2 = this.innerHeader;
        String string2 = HMS_FOREGROUND_REQ_INNER;
        object = object.getStringExtra(string2);
        ((ForegroundInnerHeader)object2).fromJson((String)object);
        object = this.innerHeader;
        if (object == null) {
            this.errorReturn(0, "inner header is invalid");
            return;
        }
        object = this.foregroundHeader.getApiName();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            this.errorReturn(0, "action is invalid");
            return;
        }
        this.biReportRequestEntryForegroundBus();
        this.checkMinVersion();
    }

    public void onBridgeActivityDestroy() {
        this.biReportRequestReturnForegroundBus();
        this.mThisWeakRef = null;
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent intent) {
        int n12 = 431057;
        if (n10 == n12) {
            ResponseHeader responseHeader;
            Object object;
            if (intent != null && (n12 = (int)(intent.hasExtra((String)(object = HMS_FOREGROUND_RESP_HEADER)) ? 1 : 0)) != 0) {
                object = intent.getStringExtra((String)object);
                this.responseHeader = responseHeader = new ResponseHeader();
                JsonUtil.jsonToEntity((String)object, responseHeader);
            }
            this.biReportRequestReturnStartCore();
            object = this.innerHeader.getResponseCallbackKey();
            object = this.getResponseCallback((String)object);
            if (object == null) {
                this.succeedReturn(n11, intent);
            } else {
                responseHeader = (Activity)this.mThisWeakRef.get();
                if ((object = object.succeedReturn((Activity)responseHeader, n11, intent)) == null) {
                    this.succeedReturn(n11, intent);
                } else {
                    n11 = ((BusResponseResult)object).getCode();
                    object = ((BusResponseResult)object).getIntent();
                    this.succeedReturn(n11, (Intent)object);
                }
            }
            return true;
        }
        return false;
    }

    public void onBridgeConfigurationChanged() {
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
    }
}

