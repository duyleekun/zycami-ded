/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.ActivityNotFoundException
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.style.StrikethroughSpan
 *  android.text.style.TextAppearanceSpan
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.view.WindowManager
 *  android.widget.ProgressBar
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  android.widget.Toast
 */
package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.TextAppearanceSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.updatesdk.b.d.f;
import com.huawei.updatesdk.b.e.e;
import com.huawei.updatesdk.b.f.c;
import com.huawei.updatesdk.b.h.b$b;
import com.huawei.updatesdk.b.i.a$c;
import com.huawei.updatesdk.b.i.a$d;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$a;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$b;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$c;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$d;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$e;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$f;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$g;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$h;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$i;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$j;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$k;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$l;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$m;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$o;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$p;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$q;
import com.huawei.updatesdk.service.otaupdate.a;
import com.huawei.updatesdk.service.otaupdate.b;
import com.huawei.updatesdk.service.otaupdate.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppUpdateActivity
extends Activity
implements b,
com.huawei.updatesdk.b.f.b {
    private String a;
    private AlertDialog b;
    private com.huawei.updatesdk.b.i.a c;
    private com.huawei.updatesdk.b.i.a d;
    private ProgressBar e;
    private TextView f;
    private boolean g = false;
    private boolean h = false;
    private ApkUpgradeInfo i = null;
    private boolean j = false;
    private boolean k = false;
    private com.huawei.updatesdk.b.d.c l;
    private int m;
    private int n;
    private int o;
    private Intent p;
    private AppUpdateActivity$q q;
    private boolean r;

    public AppUpdateActivity() {
        int n10;
        this.m = n10 = -99;
        this.n = n10;
        this.o = n10;
        this.p = null;
        this.r = false;
    }

    private long a(ApkUpgradeInfo apkUpgradeInfo) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14 = apkUpgradeInfo.getLongSize_();
        int n10 = apkUpgradeInfo.getPackingType_();
        long l15 = 0L;
        int n11 = 1;
        if (n10 == n11 && (n10 = (int)((l13 = (l12 = apkUpgradeInfo.getBundleSize_()) - l15) == 0L ? 0 : (l13 < 0L ? -1 : 1))) > 0) {
            return apkUpgradeInfo.getBundleSize_();
        }
        n10 = apkUpgradeInfo.getPackingType_();
        if (n10 == (n11 = 3) && (n10 = (int)((l11 = (l10 = apkUpgradeInfo.getObbSize_()) - l15) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0) {
            l10 = apkUpgradeInfo.getObbSize_();
            l14 += l10;
        }
        if ((n10 = apkUpgradeInfo.getDiffSize_()) > 0) {
            long l16;
            int n12 = apkUpgradeInfo.getDiffSize_();
            l14 = n12;
            n10 = apkUpgradeInfo.getPackingType_();
            if (n10 == n11 && (n10 = (int)((l16 = (l12 = apkUpgradeInfo.getObbSize_()) - l15) == 0L ? 0 : (l16 < 0L ? -1 : 1))) > 0) {
                long l17 = apkUpgradeInfo.getObbSize_();
                l14 += l17;
            }
        }
        return l14;
    }

    private Intent a(int n10, int n11, int n12) {
        Intent intent = new Intent();
        intent.putExtra("downloadStatus", n12);
        intent.putExtra("installState", n10);
        intent.putExtra("installType", n11);
        return intent;
    }

    public static /* synthetic */ Intent a(AppUpdateActivity appUpdateActivity, int n10, int n11, int n12) {
        return appUpdateActivity.a(n10, n11, n12);
    }

    private void a() {
        block6: {
            Object object = this.b;
            if (object == null) break block6;
            boolean bl2 = object.isShowing();
            if (!bl2) break block6;
            object = this.b;
            object.dismiss();
            bl2 = false;
            object = null;
            try {
                this.b = null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = "AppUpdateActivity";
                String string2 = "progressDialog dismiss IllegalArgumentException";
                com.huawei.updatesdk.a.a.c.a.a.a.a((String)object, string2);
            }
        }
    }

    private void a(View object) {
        block16: {
            int n10 = com.huawei.updatesdk.a.a.d.h.c.i();
            if (n10 == 0) {
                return;
            }
            String string2 = "scroll_layout";
            n10 = com.huawei.updatesdk.b.h.c.a((Context)this, string2);
            object = object.findViewById(n10);
            object = (ScrollView)object;
            n10 = Build.VERSION.SDK_INT;
            int n11 = 22;
            if (n10 < n11) break block16;
            string2 = new TypedValue();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object object2 = this.getTheme();
            int n12 = 16843987;
            boolean bl2 = true;
            object2.resolveAttribute(n12, (TypedValue)string2, bl2);
            object2 = "window";
            object2 = this.getSystemService((String)object2);
            object2 = (WindowManager)object2;
            object2 = object2.getDefaultDisplay();
            object2.getMetrics(displayMetrics);
            n10 = ((TypedValue)string2).data;
            n10 = TypedValue.complexToDimensionPixelSize((int)n10, (DisplayMetrics)displayMetrics);
            n11 = 0;
            displayMetrics = null;
            try {
                object.setPadding(n10, 0, n10, 0);
            }
            catch (Exception exception) {
                object = exception.toString();
                string2 = "AppUpdateActivity";
                com.huawei.updatesdk.a.a.c.a.a.a.b(string2, (String)object);
            }
        }
    }

    private void a(com.huawei.updatesdk.a.b.b.b object) {
        if ((object = ((com.huawei.updatesdk.a.b.b.b)object).b()) != null) {
            int n10 = -1;
            int n11 = object.getInt("download_status_param", n10);
            d d10 = com.huawei.updatesdk.service.otaupdate.d.a();
            Intent intent = this.a(n10, n10, n11);
            d10.a(intent);
            boolean bl2 = com.huawei.updatesdk.b.d.a.a(n11);
            if (!bl2) {
                this.a();
                n11 = (int)(com.huawei.updatesdk.b.d.a.b(n11) ? 1 : 0);
                if (n11 != 0) {
                    n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_third_app_dl_install_failed");
                    object = this.getString(n11);
                    bl2 = false;
                    d10 = null;
                    object = Toast.makeText((Context)this, (CharSequence)object, (int)0);
                    object.show();
                    this.finish();
                }
            }
        }
    }

    private void a(ApkUpgradeInfo object, TextView textView) {
        if (textView == null) {
            return;
        }
        int n10 = ((ApkUpgradeInfo)object).getDiffSize_();
        if (n10 > 0) {
            long l10;
            long l11;
            long l12;
            n10 = ((ApkUpgradeInfo)object).getPackingType_();
            int n11 = 3;
            float f10 = 4.2E-45f;
            if (n10 == n11 && (n10 = (int)((l12 = (l11 = ((ApkUpgradeInfo)object).getObbSize_()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
                l11 = ((ApkUpgradeInfo)object).getLongSize_();
                l10 = ((ApkUpgradeInfo)object).getObbSize_();
                l11 += l10;
            } else {
                l11 = ((ApkUpgradeInfo)object).getLongSize_();
            }
            object = com.huawei.updatesdk.b.h.d.a((Context)this, l11);
            SpannableString spannableString = new SpannableString((CharSequence)object);
            StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
            int n12 = ((String)object).length();
            int n13 = 33;
            spannableString.setSpan((Object)strikethroughSpan, 0, n12, n13);
            f10 = textView.getTextSize();
            int n14 = (int)f10;
            String string2 = "HwChinese-medium";
            object = new TextAppearanceSpan(string2, 0, n14, null, null);
            n11 = spannableString.length();
            spannableString.setSpan(object, 0, n11, n13);
            textView.setText((CharSequence)spannableString);
        } else {
            int n15 = 8;
            textView.setVisibility(n15);
        }
    }

    public static /* synthetic */ void a(AppUpdateActivity appUpdateActivity) {
        appUpdateActivity.e();
    }

    public static /* synthetic */ void a(AppUpdateActivity appUpdateActivity, int n10) {
        appUpdateActivity.c(n10);
    }

    public static /* synthetic */ void a(AppUpdateActivity appUpdateActivity, ApkUpgradeInfo apkUpgradeInfo) {
        appUpdateActivity.b(apkUpgradeInfo);
    }

    public static /* synthetic */ void a(AppUpdateActivity appUpdateActivity, com.huawei.updatesdk.service.appmgr.bean.c c10) {
        appUpdateActivity.c(c10);
    }

    public static /* synthetic */ void a(AppUpdateActivity appUpdateActivity, String string2) {
        appUpdateActivity.c(string2);
    }

    public static /* synthetic */ void a(AppUpdateActivity appUpdateActivity, String string2, String string3) {
        appUpdateActivity.a(string2, string3);
    }

    private void a(String string2) {
        Object object = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        String string3 = this.a;
        object.setPackage(string3);
        object.putExtra("APP_PACKAGENAME", string2);
        int n10 = this.k;
        string3 = "APP_MUST_UPDATE_BTN";
        object.putExtra(string3, n10 != 0);
        n10 = 0;
        string2 = null;
        this.h = false;
        n10 = 1002;
        try {
            this.startActivityForResult((Intent)object, n10);
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("goHiappUpgrade error: ");
            Object object2 = activityNotFoundException.toString();
            ((StringBuilder)object).append((String)object2);
            object2 = ((StringBuilder)object).toString();
            com.huawei.updatesdk.a.a.c.a.a.a.b("AppUpdateActivity", (String)object2);
            n10 = 1;
            this.h = n10;
            object2 = new Intent();
            int n11 = 8;
            string3 = "status";
            object2.putExtra(string3, n11);
            object = com.huawei.updatesdk.service.otaupdate.d.a();
            ((d)object).b((Intent)object2);
            object2 = this.i;
            this.b((ApkUpgradeInfo)object2);
        }
    }

    private void a(String string2, String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            Object object2 = new Intent("com.huawei.appmarket.appmarket.intent.action.AppDetail.withdetailId");
            String string3 = this.a;
            object2.setPackage(string3);
            string3 = "appDetailId";
            object2.putExtra(string3, (String)object);
            object = "thirdId";
            object2.putExtra((String)object, string2);
            int bl3 = 0x10008000;
            object2.addFlags(bl3);
            try {
                this.startActivity((Intent)object2);
                boolean bl4 = this.j;
                if (!bl4) {
                    this.finish();
                }
                return;
            }
            catch (Exception exception) {
                object = new StringBuilder();
                ((StringBuilder)object).append("openMarketUpdateDetail error: ");
                Object object3 = exception.toString();
                ((StringBuilder)object).append((String)object3);
                object3 = ((StringBuilder)object).toString();
                com.huawei.updatesdk.a.a.a.a("AppUpdateActivity", (String)object3);
                com.huawei.updatesdk.b.d.f.a(this);
                boolean bl5 = this.r;
                com.huawei.updatesdk.b.d.f.a(bl5);
                object3 = new Intent();
                int n10 = 8;
                object2 = "status";
                object3.putExtra((String)object2, n10);
                object = com.huawei.updatesdk.service.otaupdate.d.a();
                ((d)object).b((Intent)object3);
                object3 = this.d;
                if (object3 != null) {
                    ((com.huawei.updatesdk.b.i.a)object3).a();
                }
                return;
            }
        }
        this.m = 1;
        this.finish();
    }

    public static /* synthetic */ int b(AppUpdateActivity appUpdateActivity, int n10) {
        appUpdateActivity.m = n10;
        return n10;
    }

    public static /* synthetic */ com.huawei.updatesdk.b.i.a b(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.d;
    }

    private void b() {
        AppUpdateActivity$q appUpdateActivity$q;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.q = appUpdateActivity$q = new AppUpdateActivity$q(this, null);
        com.huawei.updatesdk.service.otaupdate.a.a((Context)this, intentFilter, appUpdateActivity$q);
    }

    private void b(com.huawei.updatesdk.a.b.b.b object) {
        ProgressBar progressBar = this.e;
        if (progressBar == null) {
            return;
        }
        long l10 = ((com.huawei.updatesdk.a.b.b.b)object).b("download_apk_size", 0);
        int n10 = com.huawei.updatesdk.b.h.d.a(((com.huawei.updatesdk.a.b.b.b)object).b("download_apk_already", 0), l10);
        this.e.setProgress(n10);
        float f10 = this.e.getProgress();
        float f11 = this.e.getMax();
        n10 = (int)(f10 / f11 * 100.0f);
        progressBar = this.f;
        object = com.huawei.updatesdk.b.h.d.a(n10);
        progressBar.setText((CharSequence)object);
    }

    private void b(ApkUpgradeInfo object) {
        Object object2 = "AppUpdateActivity";
        String string2 = "showOtaDialog";
        com.huawei.updatesdk.a.a.a.b((String)object2, string2);
        if (object == null) {
            this.finish();
            return;
        }
        int n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_ota_title");
        object2 = this.getString(n10);
        int n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_ota_notify_updatebtn");
        string2 = this.getString(n11);
        int n12 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_ota_cancel");
        String string3 = this.getString(n12);
        this.b((String)object2);
        int n13 = ((ApkUpgradeInfo)object).getIsCompulsoryUpdate_();
        n10 = 1;
        if (n10 == n13) {
            object = "upsdk_ota_force_cancel_new";
            n13 = com.huawei.updatesdk.b.h.c.c((Context)this, (String)object);
            string3 = this.getString(n13);
            n13 = (int)(this.k ? 1 : 0);
            if (n13 != 0) {
                object = this.d;
                ((com.huawei.updatesdk.b.i.a)object).c();
            }
            this.g = n10;
        }
        object = this.d;
        object2 = new AppUpdateActivity$l(this);
        ((com.huawei.updatesdk.b.i.a)object).a((com.huawei.updatesdk.b.i.b)object2);
        this.c();
        object = this.d;
        object2 = new AppUpdateActivity$m(this);
        ((com.huawei.updatesdk.b.i.a)object).a((a$d)object2);
        n13 = (int)(this.g ? 1 : 0);
        if (n13 != 0) {
            object = this.d;
            n10 = 0;
            object2 = null;
            ((com.huawei.updatesdk.b.i.a)object).a(false);
        } else {
            object = this.d;
            object2 = new AppUpdateActivity$a(this);
            ((com.huawei.updatesdk.b.i.a)object).a((DialogInterface.OnKeyListener)object2);
        }
        object = this.d;
        object2 = a$c.a;
        ((com.huawei.updatesdk.b.i.a)object).a((a$c)((Object)object2), string2);
        object = this.d;
        object2 = a$c.b;
        ((com.huawei.updatesdk.b.i.a)object).a((a$c)((Object)object2), string3);
    }

    private void b(com.huawei.updatesdk.service.appmgr.bean.c object) {
        int n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_appstore_install");
        Object object2 = new Object[1];
        String string2 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).a();
        object2[0] = string2;
        Object object3 = this.getString(n10, (Object[])object2);
        object3 = com.huawei.updatesdk.b.i.a.a((Context)this, null, (CharSequence)object3);
        object2 = new AppUpdateActivity$i(this, (com.huawei.updatesdk.service.appmgr.bean.c)object, (com.huawei.updatesdk.b.i.a)object3);
        ((com.huawei.updatesdk.b.i.a)object3).a((com.huawei.updatesdk.b.i.b)object2);
        int n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_app_download_info_new");
        object = this.getString(n11);
        object2 = new AppUpdateActivity$j(this);
        ((com.huawei.updatesdk.b.i.a)object3).a((a$d)object2);
        object2 = a$c.a;
        ((com.huawei.updatesdk.b.i.a)object3).a((a$c)((Object)object2), (String)object);
        object = new AppUpdateActivity$k(this, (com.huawei.updatesdk.b.i.a)object3);
        ((com.huawei.updatesdk.b.i.a)object3).a((DialogInterface.OnKeyListener)object);
    }

    public static /* synthetic */ void b(AppUpdateActivity appUpdateActivity, com.huawei.updatesdk.service.appmgr.bean.c c10) {
        appUpdateActivity.d(c10);
    }

    private void b(String object) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this);
        int n10 = com.huawei.updatesdk.b.h.c.b((Context)this, "upsdk_ota_update_view");
        layoutInflater = layoutInflater.inflate(n10, null);
        Object object2 = this.i.getNewFeatures_();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n10 != 0) {
            n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_choice_update");
            object2 = this.getString(n10);
        } else {
            object2 = this.i.getNewFeatures_();
        }
        int n11 = com.huawei.updatesdk.b.h.c.a((Context)this, "content_textview");
        ((TextView)layoutInflater.findViewById(n11)).setText((CharSequence)object2);
        object2 = this.i.getVersion_();
        n11 = com.huawei.updatesdk.b.h.c.a((Context)this, "version_textview");
        ((TextView)layoutInflater.findViewById(n11)).setText((CharSequence)object2);
        object2 = this.i;
        long l10 = this.a((ApkUpgradeInfo)object2);
        object2 = com.huawei.updatesdk.b.h.d.a((Context)this, l10);
        n11 = com.huawei.updatesdk.b.h.c.a((Context)this, "appsize_textview");
        ((TextView)layoutInflater.findViewById(n11)).setText((CharSequence)object2);
        object2 = this.i.getName_();
        n11 = com.huawei.updatesdk.b.h.c.a((Context)this, "name_textview");
        ((TextView)layoutInflater.findViewById(n11)).setText((CharSequence)object2);
        n10 = com.huawei.updatesdk.b.h.c.a((Context)this, "allsize_textview");
        object2 = (TextView)layoutInflater.findViewById(n10);
        ApkUpgradeInfo apkUpgradeInfo = this.i;
        this.a(apkUpgradeInfo, (TextView)object2);
        this.a((View)layoutInflater);
        this.d = object = com.huawei.updatesdk.b.i.a.a((Context)this, (String)object, null);
        ((com.huawei.updatesdk.b.i.a)object).a((View)layoutInflater);
    }

    private void b(String string2, String string3) {
        int n10;
        int n11;
        AlertDialog alertDialog = this.b;
        if (alertDialog != null && (n11 = alertDialog.isShowing()) != 0) {
            return;
        }
        n11 = com.huawei.updatesdk.a.a.d.h.c.i();
        if (n11 != 0) {
            alertDialog = new AlertDialog.Builder((Context)this);
        } else {
            alertDialog = this.getResources().getConfiguration();
            n11 = alertDialog.uiMode & 0x30;
            n10 = 32;
            if (n11 == n10 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 29)) {
                n10 = 16974545;
                alertDialog = new AlertDialog.Builder((Context)this, n10);
            } else {
                n10 = 16974546;
                alertDialog = new AlertDialog.Builder((Context)this, n10);
            }
        }
        this.b = alertDialog = alertDialog.create();
        alertDialog = LayoutInflater.from((Context)this);
        n10 = com.huawei.updatesdk.b.h.c.b((Context)this, "upsdk_app_dl_progress_dialog");
        alertDialog = alertDialog.inflate(n10, null);
        n10 = com.huawei.updatesdk.b.h.c.a((Context)this, "third_app_warn_text");
        Object object = (TextView)alertDialog.findViewById(n10);
        String string4 = "upsdk_app_download_installing";
        int n12 = com.huawei.updatesdk.b.h.c.c((Context)this, string4);
        int n13 = 1;
        Object[] objectArray = new Object[n13];
        objectArray[0] = string3;
        string3 = this.getString(n12, objectArray);
        object.setText((CharSequence)string3);
        int n14 = com.huawei.updatesdk.b.h.c.a((Context)this, "third_app_dl_progressbar");
        string3 = (ProgressBar)alertDialog.findViewById(n14);
        this.e = string3;
        n10 = 100;
        string3.setMax(n10);
        n14 = com.huawei.updatesdk.b.h.c.a((Context)this, "third_app_dl_progress_text");
        string3 = (TextView)alertDialog.findViewById(n14);
        this.f = string3;
        n14 = com.huawei.updatesdk.b.h.c.a((Context)this, "cancel_bg");
        string3 = alertDialog.findViewById(n14);
        object = new AppUpdateActivity$h(this, string2);
        string3.setOnClickListener((View.OnClickListener)object);
        this.b.setView((View)alertDialog);
        this.b.setCancelable(false);
        string2 = this.b;
        string2.setCanceledOnTouchOutside(false);
        boolean bl2 = com.huawei.updatesdk.service.otaupdate.a.a((Context)this);
        if (!bl2) {
            string2 = this.b;
            string2.show();
        }
        string2 = this.f;
        string3 = com.huawei.updatesdk.b.h.d.a(0);
        string2.setText((CharSequence)string3);
    }

    public static /* synthetic */ int c(AppUpdateActivity appUpdateActivity, int n10) {
        appUpdateActivity.o = n10;
        return n10;
    }

    public static /* synthetic */ String c(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.a;
    }

    private void c() {
        com.huawei.updatesdk.b.i.a a10 = this.d;
        if (a10 != null) {
            Object object = new AppUpdateActivity$o(null);
            a10.a((DialogInterface.OnDismissListener)object);
            a10 = this.d;
            object = new AppUpdateActivity$p(null);
            a10.a((DialogInterface.OnShowListener)object);
        }
    }

    private void c(int n10) {
        int n11 = 5;
        if (n10 == n11 || n10 == (n11 = 4)) {
            n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_third_app_dl_install_failed");
            String string2 = this.getString(n11);
            string2 = Toast.makeText((Context)this, (CharSequence)string2, (int)0);
            string2.show();
            com.huawei.updatesdk.b.h.b.a();
            this.finish();
        }
        if (n10 == (n11 = 7)) {
            com.huawei.updatesdk.b.h.b.a();
            n10 = (int)(this.g ? 1 : 0);
            if (n10 != 0) {
                ApkUpgradeInfo apkUpgradeInfo = this.i;
                this.b(apkUpgradeInfo);
                return;
            }
            this.finish();
        }
    }

    private void c(com.huawei.updatesdk.a.b.b.b b10) {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new AppUpdateActivity$e(this, b10);
        handler.post((Runnable)object);
    }

    private void c(com.huawei.updatesdk.service.appmgr.bean.c object) {
        long l10 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).c();
        Object object2 = com.huawei.updatesdk.b.h.d.a((Context)this, l10);
        int n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_mobile_dld_warn");
        Object[] objectArray = new Object[]{object2};
        object2 = this.getString(n10, objectArray);
        object2 = com.huawei.updatesdk.b.i.a.a((Context)this, null, (CharSequence)object2);
        Object object3 = new AppUpdateActivity$b(this, (com.huawei.updatesdk.service.appmgr.bean.c)object, (com.huawei.updatesdk.b.i.a)object2);
        ((com.huawei.updatesdk.b.i.a)object2).a((com.huawei.updatesdk.b.i.b)object3);
        int n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_app_download_info_new");
        object = this.getString(n11);
        object3 = new AppUpdateActivity$c(this);
        ((com.huawei.updatesdk.b.i.a)object2).a((a$d)object3);
        object3 = a$c.a;
        ((com.huawei.updatesdk.b.i.a)object2).a((a$c)((Object)object3), (String)object);
        object = new AppUpdateActivity$d(this, (com.huawei.updatesdk.b.i.a)object2);
        ((com.huawei.updatesdk.b.i.a)object2).a((DialogInterface.OnKeyListener)object);
    }

    private void c(String object) {
        int n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_third_app_dl_cancel_download_prompt_ex");
        object = this.getString(n10);
        this.c = object = com.huawei.updatesdk.b.i.a.a((Context)this, null, (CharSequence)object);
        Object object2 = new AppUpdateActivity$f(this);
        ((com.huawei.updatesdk.b.i.a)object).a((com.huawei.updatesdk.b.i.b)object2);
        n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_third_app_dl_sure_cancel_download");
        object = this.getString(n10);
        object2 = this.c;
        Object object3 = new AppUpdateActivity$g(this);
        ((com.huawei.updatesdk.b.i.a)object2).a((a$d)object3);
        object2 = this.c;
        object3 = a$c.a;
        ((com.huawei.updatesdk.b.i.a)object2).a((a$c)((Object)object3), (String)object);
    }

    public static /* synthetic */ ProgressBar d(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.e;
    }

    private void d() {
        Object object = this.q;
        com.huawei.updatesdk.service.otaupdate.a.a((Context)this, (BroadcastReceiver)object);
        com.huawei.updatesdk.b.f.c.a().b(this);
        object = this.l;
        if (object != null) {
            ((com.huawei.updatesdk.b.d.c)((Object)object)).b();
        }
        com.huawei.updatesdk.b.d.f.a(null);
    }

    private void d(com.huawei.updatesdk.service.appmgr.bean.c object) {
        this.b();
        Object object2 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).d();
        Object[] objectArray = ((com.huawei.updatesdk.service.appmgr.bean.c)object).a();
        this.b((String)object2, (String)objectArray);
        objectArray = ((com.huawei.updatesdk.service.appmgr.bean.c)object).b();
        long l10 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).c();
        String string2 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).e();
        object2 = new com.huawei.updatesdk.b.d.b((String)objectArray, l10, string2);
        object = ((com.huawei.updatesdk.service.appmgr.bean.c)object).d();
        ((com.huawei.updatesdk.b.d.b)object2).a((String)object);
        object = new com.huawei.updatesdk.b.d.c((com.huawei.updatesdk.b.d.b)object2);
        this.l = object;
        object2 = Executors.newSingleThreadExecutor();
        objectArray = new Void[]{};
        object.executeOnExecutor((Executor)object2, objectArray);
    }

    public static /* synthetic */ TextView e(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.f;
    }

    private void e() {
        Object object = this.a;
        boolean bl2 = com.huawei.updatesdk.b.h.b.c((Context)this, (String)object);
        if (!bl2) {
            com.huawei.updatesdk.b.d.f.a(this);
            bl2 = this.r;
            com.huawei.updatesdk.b.d.f.a(bl2);
            object = this.d;
            ((com.huawei.updatesdk.b.i.a)object).a();
        } else {
            object = this.i.getPackage_();
            String string2 = this.i.getDetailId_();
            this.a((String)object, string2);
        }
    }

    public static /* synthetic */ void f(AppUpdateActivity appUpdateActivity) {
        appUpdateActivity.a();
    }

    public static /* synthetic */ com.huawei.updatesdk.b.d.c g(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.l;
    }

    public static /* synthetic */ com.huawei.updatesdk.b.i.a h(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.c;
    }

    public static /* synthetic */ boolean i(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.j;
    }

    public static /* synthetic */ ApkUpgradeInfo j(AppUpdateActivity appUpdateActivity) {
        return appUpdateActivity.i;
    }

    public void a(int n10) {
        int n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_getting_message_fail_prompt_toast");
        String string2 = this.getString(n11);
        Toast.makeText((Context)this, (CharSequence)string2, (int)0).show();
        com.huawei.updatesdk.service.otaupdate.d.a().a(n10);
        this.finish();
    }

    public void a(int n10, com.huawei.updatesdk.a.b.b.b b10) {
        if (b10 == null) {
            return;
        }
        if (n10 == 0) {
            this.a(b10);
        } else {
            int n11 = 1;
            if (n11 == n10) {
                this.b(b10);
            } else {
                n11 = 2;
                if (n11 == n10) {
                    this.c(b10);
                }
            }
        }
    }

    public void a(com.huawei.updatesdk.service.appmgr.bean.c object) {
        boolean bl2;
        if (object != null && (bl2 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).f())) {
            String string2;
            com.huawei.updatesdk.b.f.c.a().a(this);
            this.a = string2 = ((com.huawei.updatesdk.service.appmgr.bean.c)object).d();
            this.b((com.huawei.updatesdk.service.appmgr.bean.c)object);
        } else {
            int n10 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_getting_message_fail_prompt_toast");
            object = this.getString(n10);
            bl2 = false;
            Object var3_4 = null;
            object = Toast.makeText((Context)this, (CharSequence)object, (int)0);
            object.show();
            this.finish();
        }
    }

    public void b(int n10) {
        int n11 = com.huawei.updatesdk.b.h.c.c((Context)this, "upsdk_getting_message_fail_prompt_toast");
        String string2 = this.getString(n11);
        Toast.makeText((Context)this, (CharSequence)string2, (int)0).show();
        com.huawei.updatesdk.service.otaupdate.d.a().a(n10);
        this.finish();
    }

    public void finish() {
        Object object;
        boolean bl2 = this.g;
        if (bl2) {
            bl2 = false;
            object = null;
            this.overridePendingTransition(0, 0);
        }
        object = new Intent();
        this.p = object;
        int n10 = this.m;
        object.putExtra("status", n10);
        object = this.p;
        n10 = this.n;
        object.putExtra("failcause", n10);
        object = this.p;
        n10 = (int)(this.g ? 1 : 0);
        object.putExtra("compulsoryUpdateCancel", n10 != 0);
        object = this.p;
        n10 = this.o;
        object.putExtra("buttonstatus", n10);
        object = com.huawei.updatesdk.service.otaupdate.d.a();
        Intent intent = this.p;
        ((d)object).b(intent);
        super.finish();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        int n12 = 1002;
        if (n10 == n12) {
            if (intent != null) {
                int n13;
                com.huawei.updatesdk.a.b.b.b b10 = com.huawei.updatesdk.a.b.b.b.a(intent);
                this.m = n11;
                this.n = n13 = b10.a("installResultCode", -99);
                n13 = 0;
                intent = null;
                String string2 = "compulsoryUpdateCancel";
                n10 = (int)(b10.a(string2, false) ? 1 : 0);
                this.g = n10;
            }
            n10 = n11 == (n10 = 4) ? 100 : 101;
            this.o = n10;
            n10 = (int)(this.h ? 1 : 0);
            if (n10 == 0) {
                this.finish();
            }
        }
    }

    public void onCreate(Bundle object) {
        boolean bl2;
        String string2;
        Object object2;
        int n10 = 1;
        this.requestWindowFeature(n10);
        com.huawei.updatesdk.a.a.d.h.c c10 = com.huawei.updatesdk.a.a.d.h.c.d();
        Window window = this.getWindow();
        c10.a(window);
        super.onCreate(object);
        Bundle bundle = com.huawei.updatesdk.a.b.b.b.a(this.getIntent()).b();
        com.huawei.updatesdk.a.b.a.a.a((Context)this);
        c10 = null;
        String string3 = "AppUpdateActivity";
        if (bundle != null) {
            object2 = "app_update_parm";
            try {
                object2 = bundle.getSerializable((String)object2);
                string2 = "is_apptouch";
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Type Conversion Error: ");
                String string4 = exception.toString();
                stringBuilder.append(string4);
                String string5 = stringBuilder.toString();
                com.huawei.updatesdk.a.a.a.a(string3, string5);
                super.finish();
                return;
            }
            bl2 = bundle.getBoolean(string2, false);
            this.r = bl2;
        } else {
            object2 = null;
        }
        bl2 = this.r;
        string2 = bl2 ? "apptouch" : "default";
        this.a = string2 = com.huawei.updatesdk.b.e.e.a(string2).b();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("finish activity and appStorePkgName is: ");
            String string6 = this.a;
            stringBuilder.append(string6);
            String string7 = stringBuilder.toString();
            com.huawei.updatesdk.a.a.a.a(string3, string7);
            super.finish();
            return;
        }
        boolean bl3 = object2 instanceof ApkUpgradeInfo;
        if (bl3) {
            b$b b$b;
            String string8;
            b$b b$b2;
            ApkUpgradeInfo apkUpgradeInfo;
            int n11;
            this.i = object2 = (ApkUpgradeInfo)object2;
            String string9 = "app_must_btn";
            this.k = n11 = bundle.getBoolean(string9, false);
            ApkUpgradeInfo apkUpgradeInfo2 = this.i;
            n11 = apkUpgradeInfo2.getIsCompulsoryUpdate_();
            if (n11 == n10) {
                this.j = n10;
            }
            if ((n11 = (apkUpgradeInfo = this.i).getDevType_()) == n10 && (b$b2 = com.huawei.updatesdk.b.h.b.a((Context)this, string8 = this.a)) == (b$b = b$b.b)) {
                String string10 = this.i.getPackage_();
                this.a(string10);
            } else {
                ApkUpgradeInfo apkUpgradeInfo3 = this.i;
                this.b(apkUpgradeInfo3);
            }
            return;
        }
        this.m = 3;
        this.finish();
    }

    public void onDestroy() {
        com.huawei.updatesdk.b.i.a a10 = this.c;
        if (a10 != null) {
            a10.a();
            this.c = null;
        }
        if ((a10 = this.d) != null) {
            a10.a();
            this.d = null;
        }
        this.a();
        this.d();
        super.onDestroy();
        this.finishActivity(1002);
    }
}

