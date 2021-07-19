/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.widget.Toast
 */
package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.huawei.updatesdk.b.b.a;
import com.huawei.updatesdk.b.g.b;
import com.huawei.updatesdk.b.h.c;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import com.huawei.updatesdk.service.otaupdate.UpdateParams;
import com.huawei.updatesdk.service.otaupdate.d;
import com.huawei.updatesdk.service.otaupdate.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class e
extends AsyncTask {
    private Context a;
    private CheckUpdateCallBack b;
    private UpdateParams c;
    private Toast d;
    private boolean e = false;
    private List f;
    private com.huawei.updatesdk.a.b.c.b g;
    private boolean h;

    public e(Context object, UpdateParams object2, CheckUpdateCallBack checkUpdateCallBack) {
        ArrayList arrayList;
        this.f = arrayList = new ArrayList();
        this.h = false;
        this.c = object2;
        this.a = object;
        this.b = checkUpdateCallBack;
        object = com.huawei.updatesdk.service.otaupdate.f.f();
        object2 = ((UpdateParams)object2).getServiceZone();
        ((f)object).b((String)object2);
    }

    private PackageInfo a(Context context, String string2) {
        if ((context = com.huawei.updatesdk.b.h.b.a(string2, context)) == null) {
            int n10;
            int n11;
            context = new PackageInfo();
            context.packageName = string2;
            context.versionName = "1.0";
            context.versionCode = n11 = 1;
            string2 = new ApplicationInfo();
            ((ApplicationInfo)string2).targetSdkVersion = n10 = 19;
            context.applicationInfo = string2;
        }
        return context;
    }

    private com.huawei.updatesdk.a.b.c.c.d a(Context object, List object2) {
        String string2;
        boolean bl2;
        Object object3 = new ArrayList();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            string2 = (String)object2.next();
            string2 = this.a((Context)object, string2);
            ((ArrayList)object3).add(string2);
        }
        object2 = this.c.getParamList();
        boolean bl3 = com.huawei.updatesdk.b.h.d.a((List)object2);
        if (!bl3) {
            object3 = this.c.getParamList();
            object2 = new com.huawei.updatesdk.service.appmgr.bean.d((List)object3);
        } else {
            object2 = com.huawei.updatesdk.service.appmgr.bean.d.a(object3);
        }
        int n10 = this.h;
        bl2 = false;
        string2 = null;
        if (n10 != 0) {
            n10 = 34;
        } else {
            n10 = 0;
            object3 = null;
        }
        ((com.huawei.updatesdk.service.appmgr.bean.d)object2).d(n10);
        ((com.huawei.updatesdk.service.appmgr.bean.d)object2).b(0);
        n10 = (int)(this.h ? 1 : 0);
        object3 = n10 != 0 ? "apptouch" : "default";
        object3 = com.huawei.updatesdk.b.e.e.a((String)object3).b();
        object = com.huawei.updatesdk.a.a.d.h.c.b((Context)object, (String)object3);
        ((com.huawei.updatesdk.service.appmgr.bean.d)object2).d((String)object);
        boolean bl4 = this.isCancelled();
        n10 = 0;
        object3 = null;
        if (bl4) {
            com.huawei.updatesdk.a.a.a.c("UpdateSDKCheckTask", "UpdateSDK task is canceled and return empty upgradeInfo");
            return null;
        }
        object = new com.huawei.updatesdk.a.b.c.b((com.huawei.updatesdk.a.b.c.c.c)object2, null);
        this.g = object;
        return ((com.huawei.updatesdk.a.b.c.b)((Object)object)).c();
    }

    private void a() {
        Toast toast = this.d;
        if (toast != null) {
            toast.cancel();
        }
    }

    private void a(Context context, ApkUpgradeInfo object) {
        if (context == null) {
            return;
        }
        Object object2 = new Intent(context, AppUpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("app_update_parm", (Serializable)object);
        object = this.c;
        boolean n10 = ((UpdateParams)object).isMustBtnOne();
        bundle.putBoolean("app_must_btn", n10);
        boolean bl2 = this.h;
        String string2 = "is_apptouch";
        bundle.putBoolean(string2, bl2);
        object2.putExtras(bundle);
        boolean bl3 = context instanceof Activity;
        if (!bl3) {
            int n11 = 0x10000000;
            object2.setFlags(n11);
        }
        try {
            context.startActivity(object2);
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            object = new StringBuilder();
            object2 = "go AppUpdateActivity error: ";
            ((StringBuilder)object).append((String)object2);
            String string3 = activityNotFoundException.toString();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            object = "UpdateSDKCheckTask";
            com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string3);
        }
    }

    private void a(List object) {
        boolean bl2 = com.huawei.updatesdk.b.h.d.a((List)object);
        if (bl2) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            int n10;
            ApkUpgradeInfo apkUpgradeInfo = (ApkUpgradeInfo)object.next();
            if (apkUpgradeInfo == null || (n10 = TextUtils.isEmpty((CharSequence)(string2 = apkUpgradeInfo.getFullDownUrl_()))) != 0) continue;
            n10 = apkUpgradeInfo.getDiffSize_();
            if (n10 > 0) {
                string2 = apkUpgradeInfo.getDownurl_();
                apkUpgradeInfo.setDiffDownUrl_(string2);
            }
            string2 = apkUpgradeInfo.getFullDownUrl_();
            apkUpgradeInfo.setDownurl_(string2);
        }
    }

    private void b(com.huawei.updatesdk.a.b.c.c.d d10) {
        CheckUpdateCallBack checkUpdateCallBack = this.b;
        if (checkUpdateCallBack != null) {
            checkUpdateCallBack = new Intent();
            int n10 = 6;
            String string2 = "status";
            checkUpdateCallBack.putExtra(string2, n10);
            Object object = d10.a();
            if (object != null) {
                object = d10.a();
                n10 = ((Enum)object).ordinal();
                string2 = "failcause";
                checkUpdateCallBack.putExtra(string2, n10);
            }
            object = d10.c();
            checkUpdateCallBack.putExtra("failreason", (String)object);
            n10 = d10.b();
            string2 = "responsecode";
            checkUpdateCallBack.putExtra(string2, n10);
            object = this.b;
            object.onUpdateInfo((Intent)checkUpdateCallBack);
            checkUpdateCallBack = this.b;
            int n11 = d10.d();
            checkUpdateCallBack.onUpdateStoreError(n11);
        }
    }

    private boolean b() {
        Object object;
        boolean bl2 = this.e;
        return !bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(object = this.c.getTargetPkgName()))) && (bl2 = com.huawei.updatesdk.b.h.d.a((List)(object = this.c.getPackageList()))) && (bl2 = com.huawei.updatesdk.b.h.d.a((List)(object = this.c.getParamList())));
    }

    public com.huawei.updatesdk.a.b.c.c.d a(Void ... object) {
        Object object2 = "CheckOtaAndUpdataTask doInBackground";
        com.huawei.updatesdk.a.a.c.a.a.a.a("UpdateSDKCheckTask", (String)object2);
        object = com.huawei.updatesdk.b.b.a.d();
        ((a)object).c();
        com.huawei.updatesdk.b.g.b.a(this);
        boolean bl2 = this.h;
        object = bl2 ? "apptouch" : "default";
        object = com.huawei.updatesdk.b.e.e.a((String)object);
        ((com.huawei.updatesdk.b.e.a)object).d();
        ((com.huawei.updatesdk.b.e.a)object).c();
        object2 = this.a;
        com.huawei.updatesdk.a.b.c.c.c.c(((com.huawei.updatesdk.b.e.a)object).b((Context)object2));
        object = this.c.getTargetPkgName();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            object = this.a.getPackageName();
        }
        if (bl3 = com.huawei.updatesdk.b.h.d.a((List)(object2 = this.c.getPackageList()))) {
            bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3) {
                object2 = this.f;
                object2.add(object);
            }
        } else {
            object = this.f;
            object2 = this.c.getPackageList();
            object.addAll(object2);
        }
        object = com.huawei.updatesdk.b.b.a.d();
        object2 = com.huawei.updatesdk.service.otaupdate.f.f().a();
        ((a)object).e((String)object2);
        object = this.a;
        object2 = this.f;
        return this.a((Context)object, (List)object2);
    }

    public void a(com.huawei.updatesdk.a.b.c.c.d object) {
        int n10;
        Object object2;
        com.huawei.updatesdk.b.g.b.a().remove((Object)this);
        this.a();
        Object object3 = this.b;
        String string2 = "UpdateSDKCheckTask";
        if (object3 == null) {
            object3 = "UpdateSDK callback is null";
            com.huawei.updatesdk.a.a.a.c(string2, (String)object3);
        }
        int n11 = 3;
        Object object4 = "status";
        if (object == null) {
            object = this.b;
            if (object != null) {
                object = new Intent();
                object.putExtra((String)object4, n11);
                object3 = this.b;
                object3.onUpdateInfo((Intent)object);
            }
            return;
        }
        int n12 = ((com.huawei.updatesdk.a.b.c.c.d)object).b();
        int n13 = 0;
        ArrayList arrayList = null;
        boolean n14 = ((com.huawei.updatesdk.a.b.c.c.d)object).f();
        String string3 = "responsecode";
        if (n14) {
            object = (com.huawei.updatesdk.service.appmgr.bean.e)object;
            arrayList = ((com.huawei.updatesdk.service.appmgr.bean.e)object).list;
            object2 = ((com.huawei.updatesdk.service.appmgr.bean.e)object).notRcmList;
            boolean bl2 = com.huawei.updatesdk.b.h.d.a((List)object2);
            if (!bl2) {
                object = (ApkUpgradeInfo)((com.huawei.updatesdk.service.appmgr.bean.e)object).notRcmList.get(0);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("UpdateSDK get update info is not recommend,reason: ");
                String string4 = ((ApkUpgradeInfo)object).getNotRcmReason_();
                ((StringBuilder)object2).append(string4);
                string4 = ",is same signature: ";
                ((StringBuilder)object2).append(string4);
                n10 = ((ApkUpgradeInfo)object).getSameS_();
                ((StringBuilder)object2).append(n10);
                object = ((StringBuilder)object2).toString();
                com.huawei.updatesdk.a.a.a.c(string2, (String)object);
            }
            this.a(arrayList);
            n10 = com.huawei.updatesdk.b.h.d.a(arrayList);
            if (n10 != 0 && (object = this.b) != null) {
                com.huawei.updatesdk.a.a.a.b(string2, "no upgrade info");
                object = new Intent();
                object.putExtra((String)object4, n11);
                object.putExtra(string3, n12);
                object3 = this.b;
                object3.onUpdateInfo((Intent)object);
            }
        } else {
            this.b((com.huawei.updatesdk.a.b.c.c.d)object);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("get app update msg failed,responseCode is ");
            int n15 = ((com.huawei.updatesdk.a.b.c.c.d)object).d();
            ((StringBuilder)object3).append(n15);
            object2 = ",failreason: ";
            ((StringBuilder)object3).append((String)object2);
            object = ((com.huawei.updatesdk.a.b.c.c.d)object).c();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            com.huawei.updatesdk.a.a.a.a(string2, (String)object);
        }
        if ((n10 = com.huawei.updatesdk.b.h.d.a(arrayList)) == 0) {
            object = (ApkUpgradeInfo)arrayList.get(0);
            object3 = this.b;
            if (object3 != null) {
                object3 = new Intent();
                object3.putExtra("updatesdk_update_info", (Serializable)object);
                object2 = "updatesdk_update_info_list";
                object3.putParcelableArrayListExtra((String)object2, arrayList);
                n13 = 7;
                object3.putExtra((String)object4, n13);
                object3.putExtra(string3, n12);
                object4 = this.b;
                object4.onUpdateInfo((Intent)object3);
            }
            if (object != null) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("ApkUpgradeInfo,version = ");
                object4 = ((ApkUpgradeInfo)object).getVersion_();
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(",versionCode = ");
                int n16 = ((ApkUpgradeInfo)object).getVersionCode_();
                ((StringBuilder)object3).append(n16);
                ((StringBuilder)object3).append(",detailId = ");
                object4 = ((ApkUpgradeInfo)object).getDetailId_();
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(",devType = ");
                n16 = ((ApkUpgradeInfo)object).getDevType_();
                ((StringBuilder)object3).append(n16);
                ((StringBuilder)object3).append(",packageName = ");
                object4 = ((ApkUpgradeInfo)object).getPackage_();
                ((StringBuilder)object3).append((String)object4);
                object4 = ",oldVersionCode = ";
                ((StringBuilder)object3).append((String)object4);
                n16 = ((ApkUpgradeInfo)object).getOldVersionCode_();
                ((StringBuilder)object3).append(n16);
                object3 = ((StringBuilder)object3).toString();
                com.huawei.updatesdk.a.a.a.b(string2, (String)object3);
            } else {
                object3 = "info == null";
                com.huawei.updatesdk.a.a.a.a(string2, (String)object3);
            }
            object3 = this.c;
            n11 = (int)(((UpdateParams)object3).isShowImmediate() ? 1 : 0);
            if (n11 != 0) {
                object3 = this.a;
                this.a((Context)object3, (ApkUpgradeInfo)object);
            }
        } else {
            n10 = this.b();
            if (n10 != 0) {
                com.huawei.updatesdk.a.a.a.b(string2, "show no upgrade info toast.");
                object = this.a;
                object3 = "upsdk_update_check_no_new_version";
                n11 = com.huawei.updatesdk.b.h.c.c((Context)object, (String)object3);
                object = Toast.makeText((Context)object, (int)n11, (int)0);
                object.show();
            }
        }
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public void b(boolean bl2) {
        this.e = bl2;
    }

    public void onCancelled() {
        super.onCancelled();
        com.huawei.updatesdk.a.b.c.b b10 = this.g;
        if (b10 != null) {
            b10.b();
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
        d d10 = com.huawei.updatesdk.service.otaupdate.d.a();
        Object object = this.b;
        d10.a((CheckUpdateCallBack)object);
        boolean bl2 = this.b();
        if (bl2) {
            d10 = this.a;
            object = "upsdk_checking_update_prompt";
            int n10 = com.huawei.updatesdk.b.h.c.c((Context)d10, (String)object);
            int n11 = 1;
            d10 = Toast.makeText((Context)d10, (int)n10, (int)n11);
            this.d = d10;
            d10.show();
        }
    }
}

