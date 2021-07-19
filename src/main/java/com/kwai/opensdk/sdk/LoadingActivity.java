/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 */
package com.kwai.opensdk.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.kwai.opensdk.sdk.IFinishLoadingListener;
import com.kwai.opensdk.sdk.LoadingActivity$1;
import com.kwai.opensdk.sdk.LoadingActivity$2;
import com.kwai.opensdk.sdk.LoadingActivity$3;
import com.kwai.opensdk.sdk.constants.KwaiOpenSdkCmdEnum;
import com.kwai.opensdk.sdk.model.base.OpenSdkConfig;
import com.kwai.opensdk.sdk.utils.KwaiPlatformUtil;
import java.lang.ref.WeakReference;

public class LoadingActivity
extends Activity
implements IFinishLoadingListener {
    public static final String CMD_BUNDLE_KEY = "cmd_bundle_key";
    public static final String KWAI_CONFIG_KEY = "kwai_config_key";
    public static final String KWAI_PLATFORM_KEY = "kwai_platform_key";
    private BroadcastReceiver mReceiver = null;

    private BroadcastReceiver createReceiver() {
        LoadingActivity$3 loadingActivity$3 = new LoadingActivity$3(this);
        return loadingActivity$3;
    }

    public static void delayStartAndFinish(Activity activity, Intent object) {
        WeakReference<Activity> weakReference = new WeakReference<Activity>(activity);
        Object object2 = Looper.getMainLooper();
        activity = new Handler(object2);
        object2 = new LoadingActivity$1(weakReference, (Intent)object);
        activity.postDelayed((Runnable)object2, 500L);
        object = new LoadingActivity$2(weakReference);
        activity.postDelayed((Runnable)object, 5000L);
    }

    private int getIdentifier(Context object, String string2, String string3) {
        Resources resources = object.getResources();
        object = object.getPackageName();
        return resources.getIdentifier(string2, string3, (String)object);
    }

    private void registerReceiver() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver == null) {
            BroadcastReceiver broadcastReceiver2;
            broadcastReceiver = new IntentFilter();
            broadcastReceiver.addAction("com.kwai.opensdk.ACTION_OPEN_SDK_CLOSE_LOADING");
            this.mReceiver = broadcastReceiver2 = this.createReceiver();
            this.registerReceiver(broadcastReceiver2, (IntentFilter)broadcastReceiver);
        }
    }

    private void removeReceiver() {
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            this.unregisterReceiver(broadcastReceiver);
            broadcastReceiver = null;
            this.mReceiver = null;
        }
    }

    public void finishLoading() {
        this.finish();
    }

    public void onBackPressed() {
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        String string2 = "activity_loading";
        String string3 = "layout";
        int n10 = this.getIdentifier((Context)this, string2, string3);
        this.setContentView(n10);
        if (object == null) {
            int n11;
            object = this.getIntent();
            int n12 = object.hasExtra(string2 = KWAI_PLATFORM_KEY);
            object = n12 != 0 ? this.getIntent().getStringExtra(string2) : "kwai_app";
            string3 = Uri.parse((String)KwaiPlatformUtil.getPlatformScheme((String)object));
            String string4 = "android.intent.action.VIEW";
            string2 = new Intent(string4, (Uri)string3);
            object = KwaiPlatformUtil.getPlatformPackageName((String)object);
            string2.setPackage((String)object);
            string2.addCategory("android.intent.category.DEFAULT");
            object = this.getIntent();
            string3 = "kwai_bundle_app_info_params";
            n12 = object.hasExtra(string3);
            if (n12 != 0) {
                object = this.getIntent().getBundleExtra(string3);
                string2.putExtra(string3, (Bundle)object);
            }
            if ((n12 = (object = this.getIntent()).hasExtra(string3 = CMD_BUNDLE_KEY)) != 0 && (object = KwaiOpenSdkCmdEnum.getOpenSdkCmd(this.getIntent().getStringExtra(string3))) != null) {
                string3 = ((KwaiOpenSdkCmdEnum)((Object)object)).getBundleKey();
                string4 = this.getIntent();
                object = ((KwaiOpenSdkCmdEnum)((Object)object)).getBundleKey();
                object = string4.getBundleExtra((String)object);
                string2.putExtra(string3, (Bundle)object);
            }
            if ((n12 = (object = this.getIntent()).hasExtra(string3 = "kwai_bundle_req_type")) != 0) {
                object = this.getIntent();
                string4 = null;
                n12 = object.getIntExtra(string3, 0);
                string2.putExtra(string3, n12);
            }
            if ((n12 = (object = this.getIntent()).hasExtra(string3 = "kwai_bundle_config_params")) != 0) {
                object = this.getIntent().getBundleExtra(string3);
                string2.putExtra(string3, (Bundle)object);
            }
            string2.putExtra("req_from_loading_activity", true);
            object = this.getIntent();
            string3 = KWAI_CONFIG_KEY;
            n12 = (int)(object.hasExtra(string3) ? 1 : 0);
            if (n12 != 0 && (object = (OpenSdkConfig)this.getIntent().getSerializableExtra(string3)) != null && (n11 = ((OpenSdkConfig)object).isSetNewTaskFlag()) != 0) {
                n11 = 0x10000000;
                string2.addFlags(n11);
                n12 = (int)(((OpenSdkConfig)object).isSetClearTaskFlag() ? 1 : 0);
                if (n12 != 0) {
                    n12 = 32768;
                    string2.addFlags(n12);
                }
            }
            LoadingActivity.delayStartAndFinish(this, (Intent)string2);
            this.registerReceiver();
        }
    }

    public void onDestroy() {
        this.removeReceiver();
        super.onDestroy();
    }

    public void overridePendingTransition(int n10, int n11) {
        super.overridePendingTransition(0, 0);
    }
}

