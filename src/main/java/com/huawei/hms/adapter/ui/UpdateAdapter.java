/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.lang.ref.WeakReference;

public class UpdateAdapter
implements IBridgeActivityDelegate {
    public WeakReference a;
    public int b;
    public UpdateBean c;
    public String d;

    public final void a() {
        boolean bl2;
        Activity activity = this.b();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity.finish();
        }
    }

    public final boolean a(Context object, String string2, int n10) {
        boolean bl2;
        boolean bl3 = false;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && n10 != 0) {
            PackageManagerHelper packageManagerHelper = new PackageManagerHelper((Context)object);
            object = packageManagerHelper.getPackageStates(string2);
            PackageManagerHelper$PackageStates packageManagerHelper$PackageStates = PackageManagerHelper$PackageStates.NOT_INSTALLED;
            int n11 = packageManagerHelper$PackageStates.equals(object);
            boolean bl4 = true;
            if (n11 != 0) {
                return bl4;
            }
            n11 = packageManagerHelper.getPackageVersionCode(string2);
            if (n11 < n10) {
                bl3 = bl4;
            }
        }
        return bl3;
    }

    public final Activity b() {
        WeakReference weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    public final void c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        this.a();
    }

    public int getRequestCode() {
        return 1001;
    }

    public void onBridgeActivityCreate(Activity activity) {
        int n10;
        Object object = new WeakReference(activity);
        this.a = object;
        object = activity.getIntent();
        if (object == null) {
            this.c();
            return;
        }
        String string2 = "update_version";
        String string3 = null;
        this.b = n10 = object.getIntExtra(string2, 0);
        if (n10 == 0) {
            this.c();
            return;
        }
        string2 = "new_update";
        boolean bl2 = object.getBooleanExtra(string2, false);
        n10 = 1001;
        string3 = "UpdateAdapter";
        if (bl2) {
            HMSLog.i(string3, "4.0 framework HMSCore upgrade process");
            object = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            string3 = new ComponentName((String)object, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
            Intent intent = new Intent();
            String string4 = activity.getApplicationContext().getPackageName();
            intent.putExtra("kpms_key_caller_packagename", string4);
            intent.putExtra("kitUpdatePackageName", (String)object);
            intent.setComponent((ComponentName)string3);
            activity.startActivityForResult(intent, n10);
            return;
        }
        object = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        this.d = object;
        object = new UpdateBean();
        ((UpdateBean)object).setHmsOrApkUpgrade(true);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("target HMS Core packageName is ");
        String string5 = this.d;
        charSequence.append(string5);
        charSequence = charSequence.toString();
        HMSLog.i(string3, (String)charSequence);
        charSequence = this.d;
        ((UpdateBean)object).setClientPackageName((String)charSequence);
        int n11 = this.b;
        ((UpdateBean)object).setClientVersionCode(n11);
        ((UpdateBean)object).setClientAppId("C10132067");
        charSequence = ResourceLoaderUtil.getmContext();
        if (charSequence == null && activity != null) {
            charSequence = activity.getApplicationContext();
            ResourceLoaderUtil.setmContext((Context)charSequence);
        }
        charSequence = ResourceLoaderUtil.getString("hms_update_title");
        ((UpdateBean)object).setClientAppName((String)charSequence);
        this.c = object;
        HMSLog.i(string3, "old framework HMSCore upgrade process");
        UpdateManager.startUpdate(activity, n10, (UpdateBean)object);
        this.c = null;
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        this.a = null;
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent object) {
        int n12 = this.getRequestCode();
        if (n10 != n12) {
            this.c = null;
            return false;
        }
        Object object2 = "UpdateAdapter";
        String string2 = "onBridgeActivityResult";
        HMSLog.i((String)object2, string2);
        n12 = 1214;
        int n13 = 1;
        if (n11 == n12) {
            HMSLog.i((String)object2, "Enter update escape route");
            string2 = this.b();
            if (string2 == null) {
                HMSLog.e((String)object2, "bridgeActivity is null, update escape failed ");
                this.c = null;
                return n13;
            }
            UpdateBean updateBean = this.c;
            int n14 = 1001;
            UpdateManager.startUpdate((Activity)string2, n14, updateBean);
            this.c = null;
        }
        n12 = -1;
        int n15 = 13;
        if (n11 == n12) {
            if (object != null) {
                String string3 = "kit_update_result";
                n11 = object.getIntExtra(string3, 0);
                if (n11 == n13) {
                    HMSLog.i((String)object2, "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.c = null;
                    this.a();
                    return n13;
                }
                string3 = "intent.extra.RESULT";
                n11 = object.getIntExtra(string3, n12);
                if (n11 == 0) {
                    string3 = "Error resolved successfully!";
                    HMSLog.i((String)object2, string3);
                    object2 = SystemManager.getInstance();
                    ((SystemManager)object2).notifyUpdateResult(0);
                } else if (n11 == n15) {
                    string3 = "Resolve error process canceled by user!";
                    HMSLog.i((String)object2, string3);
                    object2 = SystemManager.getInstance();
                    ((SystemManager)object2).notifyUpdateResult(n15);
                } else {
                    int n16 = 8;
                    if (n11 == n16) {
                        string3 = "Internal error occurred, recommended retry.";
                        HMSLog.i((String)object2, string3);
                        object2 = SystemManager.getInstance();
                        ((SystemManager)object2).notifyUpdateResult(n16);
                    } else {
                        object = "Other error codes.";
                        HMSLog.i((String)object2, (String)object);
                        object2 = SystemManager.getInstance();
                        ((SystemManager)object2).notifyUpdateResult(n11);
                    }
                }
            }
        } else if (n11 == 0) {
            HMSLog.i((String)object2, "Activity.RESULT_CANCELED");
            this.c = null;
            Object object3 = this.b();
            if (object3 == null) {
                return n13;
            }
            object = HMSPackageManager.getInstance(object3.getApplicationContext()).getHMSPackageName();
            n11 = (int)(this.a((Context)object3, (String)object, n12 = this.b) ? 1 : 0);
            if (n11 != 0) {
                object3 = "Resolve error, process canceled by user clicking back button!";
                HMSLog.i((String)object2, (String)object3);
                object2 = SystemManager.getInstance();
                ((SystemManager)object2).notifyUpdateResult(n15);
            } else {
                object2 = SystemManager.getInstance();
                ((SystemManager)object2).notifyUpdateResult(0);
            }
        } else if (n11 == n13) {
            object2 = SystemManager.getInstance();
            n11 = 28;
            ((SystemManager)object2).notifyUpdateResult(n11);
        }
        this.a();
        return n13;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }
}

