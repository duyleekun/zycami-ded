/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.kwai.opensdk.sdk.openapi;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.kwai.opensdk.sdk.LoadingActivity;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.model.base.BaseResp;
import com.kwai.opensdk.sdk.model.base.OpenSdkConfig;
import com.kwai.opensdk.sdk.model.base.OpenSdkConfig$Builder;
import com.kwai.opensdk.sdk.model.postshare.AICutMedias$Resp;
import com.kwai.opensdk.sdk.model.postshare.MultiMediaClip$Resp;
import com.kwai.opensdk.sdk.model.postshare.SinglePictureEdit$Resp;
import com.kwai.opensdk.sdk.model.postshare.SinglePicturePublish$Resp;
import com.kwai.opensdk.sdk.model.postshare.SingleVideoClip$Resp;
import com.kwai.opensdk.sdk.model.postshare.SingleVideoEdit$Resp;
import com.kwai.opensdk.sdk.model.postshare.SingleVideoPublish$Resp;
import com.kwai.opensdk.sdk.model.socialshare.ShareMessage$Resp;
import com.kwai.opensdk.sdk.model.socialshare.ShareMessageToBuddy$Resp;
import com.kwai.opensdk.sdk.model.socialshare.ShowProfile$Resp;
import com.kwai.opensdk.sdk.openapi.EventListenerManager;
import com.kwai.opensdk.sdk.openapi.IKwaiAPIEventListener;
import com.kwai.opensdk.sdk.openapi.IKwaiOpenAPI;
import com.kwai.opensdk.sdk.openapi.KwaiOpenAPI$1;
import com.kwai.opensdk.sdk.utils.AppInfoUtil;
import com.kwai.opensdk.sdk.utils.KwaiPlatformUtil;
import com.kwai.opensdk.sdk.utils.LogUtil;
import com.kwai.opensdk.sdk.utils.MarketUtil;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class KwaiOpenAPI
implements IKwaiOpenAPI {
    private static final String TAG = "KwaiOpenAPIImpl";
    public static volatile boolean isKwaiOpenApiInit = false;
    private String mAppId;
    private Context mContext;
    private volatile OpenSdkConfig mOpenSdkConfig;
    private String mSessionId;

    public KwaiOpenAPI(Context context) {
        String string2;
        this.mContext = context;
        this.mSessionId = string2 = String.valueOf(System.currentTimeMillis());
        this.initAppId(context);
        isKwaiOpenApiInit = true;
    }

    private BaseResp getEmptyResp(BaseReq object) {
        Object object2 = KwaiOpenAPI$1.$SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
        KwaiOpenSdkCmdEnum kwaiOpenSdkCmdEnum = ((BaseReq)object).getCommand();
        int n10 = kwaiOpenSdkCmdEnum.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                n11 = 0;
                object2 = null;
                break;
            }
            case 10: {
                object2 = new AICutMedias$Resp;
                object2();
                break;
            }
            case 9: {
                object2 = new MultiMediaClip$Resp;
                object2();
                break;
            }
            case 8: {
                object2 = new SingleVideoClip$Resp;
                object2();
                break;
            }
            case 7: {
                object2 = new SingleVideoPublish$Resp;
                object2();
                break;
            }
            case 6: {
                object2 = new SingleVideoEdit$Resp;
                object2();
                break;
            }
            case 5: {
                object2 = new SinglePicturePublish$Resp;
                object2();
                break;
            }
            case 4: {
                object2 = new SinglePictureEdit$Resp;
                object2();
                break;
            }
            case 3: {
                object2 = new ShowProfile$Resp;
                object2();
                break;
            }
            case 2: {
                object2 = new ShareMessageToBuddy$Resp;
                object2();
                break;
            }
            case 1: {
                object2 = new ShareMessage$Resp;
                object2();
            }
        }
        if (object2 != null) {
            object2.transaction = object = ((BaseReq)object).transaction;
            object2.sessionId = object = this.mSessionId;
        }
        return object2;
    }

    private OpenSdkConfig getKwaiConfig() {
        Object object = this.mOpenSdkConfig;
        if (object == null) {
            object = new OpenSdkConfig$Builder();
            this.mOpenSdkConfig = object = ((OpenSdkConfig$Builder)object).build();
        }
        return this.mOpenSdkConfig;
    }

    private String getReqToKwaiPlatform(BaseReq object) {
        int n10;
        Object object2 = this.getEmptyResp((BaseReq)object);
        if (object != null && (n10 = ((BaseReq)object).checkArgs()) != 0) {
            Object object3 = this.mContext;
            String[] stringArray = ((BaseReq)object).getPlatformArray();
            boolean bl2 = ((ArrayList)(object3 = KwaiPlatformUtil.validateAppInstalled((Context)object3, stringArray))).isEmpty();
            if (bl2) {
                ((BaseResp)object2).errorCode = n10 = -1005;
                ((BaseResp)object2).errorMsg = object3 = "Please install latest kwai app";
                this.notifyResp((BaseResp)object2);
                object2 = this.getKwaiConfig();
                boolean bl3 = ((OpenSdkConfig)object2).isGoToMargetAppNotInstall();
                if (bl3) {
                    object2 = this.mContext;
                    object = KwaiPlatformUtil.getPlatformPackageName(((BaseReq)object).getPlatformArray()[0]);
                    MarketUtil.gotoMarket((Context)object2, (String)object);
                }
                return null;
            }
            stringArray = this.mContext;
            bl2 = ((ArrayList)(object3 = KwaiPlatformUtil.matchSupportAPI((Context)stringArray, (ArrayList)object3))).isEmpty();
            if (bl2) {
                ((BaseResp)object2).errorCode = n10 = -1006;
                ((BaseResp)object2).errorMsg = object3 = "Please install latest kwai app that support kwai open social api";
                this.notifyResp((BaseResp)object2);
                object2 = this.getKwaiConfig();
                boolean bl4 = ((OpenSdkConfig)object2).isGoToMargetAppVersionNotSupport();
                if (bl4) {
                    object2 = this.mContext;
                    object = KwaiPlatformUtil.getPlatformPackageName(((BaseReq)object).getPlatformArray()[0]);
                    MarketUtil.gotoMarket((Context)object2, (String)object);
                }
                return null;
            }
            return (String)((ArrayList)object3).get(0);
        }
        ((BaseResp)object2).errorCode = -1010;
        ((BaseResp)object2).errorMsg = "Please set correct req params";
        this.notifyResp((BaseResp)object2);
        return null;
    }

    private void initAppId(Context object) {
        String string2 = this.mAppId;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = object.getPackageManager();
            object = object.getPackageName();
            int n10 = 128;
            object = string2.getApplicationInfo((String)object, n10);
            object = object.metaData;
            string2 = "APP_ID";
            object = object.getString(string2);
            try {
                this.mAppId = object;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
            }
        }
    }

    private void notifyResp(BaseResp baseResp) {
        Object object;
        int n10 = baseResp.checkArgs();
        if (n10 == 0) {
            baseResp.errorCode = n10 = -1010;
            object = "Please set correct resp params";
            baseResp.errorMsg = object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("notifyResp: resp.errorCode=");
        int n11 = baseResp.errorCode;
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(" resp.errorMsg=");
        String string2 = baseResp.errorMsg;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        string2 = TAG;
        LogUtil.d(string2, (String)object);
        object = EventListenerManager.getListener(baseResp.sessionId);
        if (object != null && (string2 = ((SoftReference)object).get()) != null) {
            object = (IKwaiAPIEventListener)((SoftReference)object).get();
            object.onRespResult(baseResp);
        }
    }

    public void addKwaiAPIEventListerer(IKwaiAPIEventListener iKwaiAPIEventListener) {
        String string2 = this.mSessionId;
        SoftReference<IKwaiAPIEventListener> softReference = new SoftReference<IKwaiAPIEventListener>(iKwaiAPIEventListener);
        EventListenerManager.addListener(string2, softReference);
    }

    public Bundle generateBaseBundle() {
        Bundle bundle = new Bundle();
        String string2 = this.mAppId;
        bundle.putString("kwai_bundle_app_id", string2);
        string2 = AppInfoUtil.getAppName(this.mContext);
        bundle.putString("kwai_bundle_app_name", string2);
        string2 = AppInfoUtil.getPackageName(this.mContext);
        bundle.putString("kwai_bundle_calling_package_name", string2);
        return bundle;
    }

    public String getOpenAPISessionId() {
        return this.mSessionId;
    }

    public void handleIntent(Intent intent) {
        Object object;
        boolean bl2;
        if (intent != null && (bl2 = intent.hasExtra((String)(object = "kwai_bundle_command")))) {
            object = intent.getStringExtra((String)object);
            bl2 = false;
            BaseResp baseResp = null;
            int[] nArray = KwaiOpenAPI$1.$SwitchMap$com$kwai$opensdk$sdk$constants$KwaiOpenSdkCmdEnum;
            object = KwaiOpenSdkCmdEnum.getOpenSdkCmd((String)object);
            int n10 = ((Enum)object).ordinal();
            n10 = nArray[n10];
            switch (n10) {
                default: {
                    break;
                }
                case 10: {
                    intent = intent.getExtras();
                    baseResp = new AICutMedias$Resp((Bundle)intent);
                    break;
                }
                case 9: {
                    intent = intent.getExtras();
                    baseResp = new MultiMediaClip$Resp((Bundle)intent);
                    break;
                }
                case 8: {
                    intent = intent.getExtras();
                    baseResp = new SingleVideoClip$Resp((Bundle)intent);
                    break;
                }
                case 7: {
                    intent = intent.getExtras();
                    baseResp = new SingleVideoPublish$Resp((Bundle)intent);
                    break;
                }
                case 6: {
                    intent = intent.getExtras();
                    baseResp = new SingleVideoEdit$Resp((Bundle)intent);
                    break;
                }
                case 5: {
                    intent = intent.getExtras();
                    baseResp = new SinglePicturePublish$Resp((Bundle)intent);
                    break;
                }
                case 4: {
                    intent = intent.getExtras();
                    baseResp = new SinglePictureEdit$Resp((Bundle)intent);
                    break;
                }
                case 3: {
                    intent = intent.getExtras();
                    baseResp = new ShowProfile$Resp((Bundle)intent);
                    break;
                }
                case 2: {
                    intent = intent.getExtras();
                    baseResp = new ShareMessageToBuddy$Resp((Bundle)intent);
                    break;
                }
                case 1: {
                    intent = intent.getExtras();
                    baseResp = new ShareMessage$Resp((Bundle)intent);
                }
            }
            this.notifyResp(baseResp);
        }
    }

    public boolean isAppSupportUri(Context object, BaseReq baseReq) {
        object = KwaiPlatformUtil.getPackageNameByReq(object, baseReq);
        return KwaiPlatformUtil.isAppSupportUri(this.mContext, (String)object);
    }

    public void removeKwaiAPIEventListerer() {
        EventListenerManager.clearListener(this.mSessionId);
    }

    public boolean sendReq(BaseReq object, Activity activity) {
        Object object2 = this.mContext;
        if (object2 != null) {
            object2 = this.mAppId;
            if (object2 != null) {
                String string2;
                Object object3;
                object2 = this.getReqToKwaiPlatform((BaseReq)object);
                boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (bl2) {
                    return false;
                }
                OpenSdkConfig openSdkConfig = this.getKwaiConfig();
                bl2 = openSdkConfig.isShowDefaultLoading();
                int n10 = 0x10000000;
                if (bl2) {
                    object3 = this.mContext;
                    openSdkConfig = new Intent(object3, LoadingActivity.class);
                    object3 = ((BaseReq)object).getCommand().getCmdString();
                    openSdkConfig.putExtra("cmd_bundle_key", (String)object3);
                    object3 = this.getKwaiConfig();
                    string2 = "kwai_config_key";
                    openSdkConfig.putExtra(string2, (Serializable)object3);
                    object3 = "kwai_platform_key";
                    openSdkConfig.putExtra((String)object3, (String)object2);
                } else {
                    object3 = Uri.parse((String)KwaiPlatformUtil.getPlatformScheme((String)object2));
                    string2 = "android.intent.action.VIEW";
                    openSdkConfig = new Intent(string2, (Uri)object3);
                    object2 = KwaiPlatformUtil.getPlatformPackageName((String)object2);
                    openSdkConfig.setPackage((String)object2);
                    openSdkConfig.addCategory("android.intent.category.DEFAULT");
                    object2 = this.getKwaiConfig();
                    boolean n11 = ((OpenSdkConfig)object2).isSetNewTaskFlag();
                    if (n11) {
                        openSdkConfig.addFlags(n10);
                        object2 = this.getKwaiConfig();
                        boolean bl3 = ((OpenSdkConfig)object2).isSetClearTaskFlag();
                        if (bl3) {
                            int n12 = 32768;
                            openSdkConfig.addFlags(n12);
                        }
                    }
                }
                object2 = this.generateBaseBundle();
                string2 = "unspecified";
                object2.putString("kwai_open_sdk_version", string2);
                openSdkConfig.putExtra("kwai_bundle_app_info_params", (Bundle)object2);
                object2 = new Bundle();
                ((BaseReq)object).toBundle((Bundle)object2);
                object3 = ((BaseReq)object).getBundleKey();
                openSdkConfig.putExtra((String)object3, (Bundle)object2);
                int n13 = ((BaseReq)object).getCommand().getType();
                openSdkConfig.putExtra("kwai_bundle_req_type", n13);
                object = new Bundle();
                this.getKwaiConfig().toBundle((Bundle)object);
                object2 = "kwai_bundle_config_params";
                openSdkConfig.putExtra((String)object2, (Bundle)object);
                object = "KwaiOpenSdk";
                if (activity != null) {
                    activity.startActivity((Intent)openSdkConfig);
                }
                openSdkConfig.addFlags(n10);
                activity = this.mContext;
                try {
                    activity.startActivity((Intent)openSdkConfig);
                }
                catch (SecurityException securityException) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("security exception, ");
                    ((StringBuilder)object2).append(securityException);
                    String string3 = ((StringBuilder)object2).toString();
                    LogUtil.e((String)object, string3);
                    return false;
                }
                catch (ActivityNotFoundException activityNotFoundException) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("not found activity, ");
                    ((StringBuilder)object2).append((Object)activityNotFoundException);
                    String string4 = ((StringBuilder)object2).toString();
                    LogUtil.e((String)object, string4);
                    return false;
                }
                return true;
            }
            object = new IllegalArgumentException("appId is empty, please set in meta-data.");
            throw object;
        }
        object = new IllegalArgumentException("context must be initialized in constructor.");
        throw object;
    }

    public void setOpenSdkConfig(OpenSdkConfig openSdkConfig) {
        this.mOpenSdkConfig = openSdkConfig;
    }

    public void updateKwaiAppId(String string2) {
        this.mAppId = string2;
    }
}

