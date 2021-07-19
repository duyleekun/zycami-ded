/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.availableupdate.b0;
import com.huawei.hms.availableupdate.c;
import com.huawei.hms.availableupdate.c0;
import com.huawei.hms.availableupdate.d;
import com.huawei.hms.availableupdate.d0;
import com.huawei.hms.availableupdate.e;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.f0$a;
import com.huawei.hms.availableupdate.f0$b;
import com.huawei.hms.availableupdate.g;
import com.huawei.hms.availableupdate.h;
import com.huawei.hms.availableupdate.n;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.q;
import com.huawei.hms.availableupdate.t;
import com.huawei.hms.availableupdate.u;
import com.huawei.hms.availableupdate.v;
import com.huawei.hms.availableupdate.w;
import com.huawei.hms.availableupdate.y;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import java.io.File;

public class f0
extends n
implements f {
    public e j;
    public g k;
    public int l = 0;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static Uri a(Context var0, File var1_1) {
        var2_2 = new PackageManagerHelper(var0);
        var3_3 = var0.getPackageName();
        var4_4 /* !! */  = new StringBuilder();
        var4_4 /* !! */ .append(var3_3);
        var5_5 = ".hms.update.provider";
        var4_4 /* !! */ .append(var5_5);
        var4_4 /* !! */  = var4_4 /* !! */ .toString();
        var6_6 = Build.VERSION.SDK_INT;
        var7_7 = 23;
        if (var6_6 <= var7_7) ** GOTO lbl-1000
        var5_5 = var0.getApplicationInfo();
        var6_6 = var5_5.targetSdkVersion;
        if (var6_6 > var7_7 || (var8_8 = var2_2.hasProvider(var3_3, (String)var4_4 /* !! */ ))) {
            var8_8 = true;
        } else lbl-1000:
        // 2 sources

        {
            var8_8 = false;
            var2_2 = null;
        }
        if (var8_8) {
            return UpdateProvider.getUriForFile(var0, (String)var4_4 /* !! */ , var1_1);
        }
        return Uri.fromFile((File)var1_1);
    }

    public static /* synthetic */ void a(f0 f02, Intent intent, f f10) {
        f02.a(intent, f10);
    }

    public static void a(f f10, int n10, g g10) {
        if (f10 != null) {
            Object object = Looper.getMainLooper();
            Handler handler = new Handler(object);
            object = new f0$a(f10, n10, g10);
            handler.post((Runnable)object);
        }
    }

    public void a(int n10, int n11, int n12, File file) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter onDownloadPackage, status: ");
        String string2 = com.huawei.hms.availableupdate.h.a(n10);
        charSequence.append(string2);
        charSequence.append(", reveived: ");
        charSequence.append(n11);
        charSequence.append(", total: ");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        string2 = "UpdateWizard";
        HMSLog.i(string2, (String)charSequence);
        int n13 = 2000;
        if (n10 != n13) {
            int n14 = 2100;
            if (n10 != n14) {
                n11 = 2101;
                if (n10 != n11) {
                    switch (n10) {
                        default: {
                            break;
                        }
                        case 2203: 
                        case 2204: {
                            Class<d0> clazz = d0.class;
                            this.a(clazz);
                            break;
                        }
                        case 2202: {
                            Class<u> clazz = u.class;
                            this.a(clazz);
                            break;
                        }
                        case 2201: {
                            Class<c0> clazz = c0.class;
                            this.a(clazz);
                            break;
                        }
                    }
                }
            } else {
                o o10 = this.d;
                if (o10 != null && (n14 = o10 instanceof w) != 0) {
                    n14 = 0;
                    file = null;
                    if (n11 >= 0 && n12 > 0) {
                        long l10 = n11;
                        long l11 = 100;
                        l10 *= l11;
                        long l12 = n12;
                        n14 = (int)(l10 /= l12);
                    }
                    this.l = n14;
                    o10 = (w)o10;
                    ((w)o10).b(n14);
                }
            }
        } else {
            this.a();
            if (file == null) {
                this.e();
            } else {
                String string3 = this.k.e;
                n10 = (int)(FileUtil.verifyHash(string3, file) ? 1 : 0);
                if (n10 != 0) {
                    this.a(file);
                } else {
                    string3 = "Hash value mismatch for download file";
                    HMSLog.i(string2, string3);
                }
            }
        }
    }

    public void a(int n10, g g10) {
        Class<b0> clazz = b0.class;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter onCheckUpdate, status: ");
        String string2 = com.huawei.hms.availableupdate.h.a(n10);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = "UpdateWizard";
        HMSLog.i(string2, (String)charSequence);
        int n11 = 1000;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    this.a(clazz);
                    break;
                }
                case 1201: 
                case 1202: 
                case 1203: {
                    this.a(clazz);
                    break;
                }
            }
        } else {
            this.k = g10;
            this.d();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Intent object, f f10) {
        String string2;
        CharSequence charSequence;
        CharSequence charSequence2;
        int n10;
        String string3 = "UpdateWizard";
        int n11 = 1201;
        Object object2 = "status";
        int n12 = -99;
        try {
            n10 = object.getIntExtra((String)object2, n12);
            charSequence2 = new StringBuilder();
            charSequence = "CheckUpdateCallBack status is ";
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(n10);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            HMSLog.i(string3, (String)charSequence2);
        }
        catch (Exception exception) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("intent has some error");
            String string4 = exception.getMessage();
            ((StringBuilder)object2).append(string4);
            string4 = ((StringBuilder)object2).toString();
            HMSLog.e(string3, string4);
            f0.a(f10, n11, null);
            return;
        }
        charSequence2 = object.getStringExtra("failreason");
        int n13 = TextUtils.isEmpty((CharSequence)charSequence2);
        if (n13 == 0) {
            charSequence = new StringBuilder();
            string2 = "checkTargetAppUpdate reason is ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence2 = ((StringBuilder)charSequence).toString();
            HMSLog.e(string3, (String)charSequence2);
        }
        if (n10 == (n12 = 7)) {
            object2 = "updatesdk_update_info";
            n10 = (object = object.getSerializableExtra((String)object2)) instanceof ApkUpgradeInfo;
            if (n10 == 0) return;
            object = (ApkUpgradeInfo)object;
            charSequence2 = ((ApkUpgradeInfo)object).getPackage_();
            n13 = ((ApkUpgradeInfo)object).getVersionCode_();
            string2 = ((ApkUpgradeInfo)object).getDownurl_();
            int n14 = ((ApkUpgradeInfo)object).getSize_();
            String string5 = ((ApkUpgradeInfo)object).getSha256_();
            int n15 = TextUtils.isEmpty((CharSequence)charSequence2);
            if (n15 == 0 && (n15 = ((String)charSequence2).equals(object = this.c.b())) != 0) {
                object = this.c;
                n15 = ((UpdateBean)object).c();
                if (n13 < n15) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("CheckUpdateCallBack versionCode is ");
                    ((StringBuilder)object).append(n13);
                    ((StringBuilder)object).append("bean.getClientVersionCode() is ");
                    n11 = this.c.c();
                    ((StringBuilder)object).append(n11);
                    object = ((StringBuilder)object).toString();
                    HMSLog.e(string3, (String)object);
                    f0.a(f10, 1203, null);
                    return;
                }
                n15 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                if (n15 == 0 && (n15 = (int)(TextUtils.isEmpty((CharSequence)string5) ? 1 : 0)) == 0) {
                    object2 = object;
                    object = new g((String)charSequence2, n13, string2, n14, string5);
                    int n16 = 1000;
                    f0.a(f10, n16, (g)object);
                    return;
                }
                f0.a(f10, n11, null);
                return;
            }
            f0.a(f10, n11, null);
            return;
        }
        int n17 = 3;
        if (n10 == n17) {
            n17 = 1202;
            f0.a(f10, n17, null);
            return;
        }
        f0.a(f10, n11, null);
    }

    public final void a(f f10) {
        boolean bl2;
        if (f10 == null) {
            return;
        }
        Activity activity = this.b();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            bl2 = this.a(activity);
            if (!bl2) {
                return;
            }
            String string2 = this.c.b();
            f0$b f0$b = new f0$b(this, f10);
            UpdateSdkAPI.checkTargetAppUpdate((Context)activity, string2, f0$b);
            return;
        }
        f0.a(f10, 1201, null);
    }

    public void a(o clazz) {
        String string2 = "UpdateWizard";
        String string3 = "Enter onCancel.";
        HMSLog.i(string2, string3);
        boolean bl2 = clazz instanceof y;
        if (bl2) {
            this.g();
        } else {
            bl2 = clazz instanceof q;
            if (bl2) {
                this.c();
                this.g();
            } else {
                bl2 = clazz instanceof w;
                if (bl2) {
                    this.c();
                    clazz = v.class;
                    this.a(clazz);
                } else {
                    bl2 = clazz instanceof v;
                    if (bl2) {
                        clazz = w.class;
                        this.a(clazz);
                        this.f();
                    } else {
                        bl2 = clazz instanceof u;
                        if (bl2) {
                            this.g();
                        } else {
                            boolean bl3 = clazz instanceof t;
                            if (bl3) {
                                this.g();
                            } else {
                                this.e();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(File file) {
        boolean bl2;
        Object object = this.b();
        if (object != null && !(bl2 = object.isFinishing())) {
            file = f0.a((Context)object, file);
            String string2 = "UpdateWizard";
            if (file == null) {
                HMSLog.e(string2, "In startInstaller, Failed to creates a Uri from a file.");
                this.e();
                return;
            }
            boolean bl3 = this.a((Activity)object);
            if (!bl3) {
                return;
            }
            Object object2 = new Intent("android.intent.action.VIEW");
            object2.setDataAndType((Uri)file, "application/vnd.android.package-archive");
            object2.setFlags(3);
            int n10 = 1;
            String string3 = "android.intent.extra.NOT_UNKNOWN_SOURCE";
            object2.putExtra(string3, n10 != 0);
            n10 = this.getRequestCode();
            try {
                object.startActivityForResult(object2, n10);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                object = new StringBuilder();
                object2 = "In startInstaller, Failed to start package installer.";
                ((StringBuilder)object).append((String)object2);
                String string4 = activityNotFoundException.getMessage();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                HMSLog.e(string2, string4);
                this.e();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void a(Class var1_1) {
        block16: {
            var2_6 = this.b();
            var3_7 = this.a((Activity)var2_6);
            if (var3_7 == 0) {
                return;
            }
            this.a();
            var1_1 = var1_1.newInstance();
            var1_1 = (o)var1_1;
            var2_6 = this.h;
            var3_7 = TextUtils.isEmpty((CharSequence)var2_6);
            if (var3_7 == 0 && (var3_7 = var1_1 instanceof y) != 0) {
                var2_6 = "hms_update_title";
                var2_6 = ResourceLoaderUtil.getString((String)var2_6);
                this.h = var2_6;
                var4_8 = var1_1;
                var4_8 = (y)var1_1;
                var4_8.a((String)var2_6);
            }
            if ((var3_7 = this.l) <= 0 || !(var5_9 = var1_1 instanceof w)) ** GOTO lbl31
            var4_8 = var1_1;
            var4_8 = (w)var1_1;
            var4_8.a(var3_7);
lbl31:
            // 2 sources

            ((o)var1_1).a(this);
            try {
                this.d = (o)var1_1;
                break block16;
            }
            catch (IllegalStateException var1_2) {
            }
            catch (IllegalAccessException var1_3) {
            }
            catch (InstantiationException var1_4) {
                // empty catch block
            }
            var2_6 = new StringBuilder();
            var4_8 = "In showDialog, Failed to show the dialog.";
            var2_6.append((String)var4_8);
            var1_5 = var1_5.getMessage();
            var2_6.append(var1_5);
            var1_5 = var2_6.toString();
            var2_6 = "UpdateWizard";
            HMSLog.e((String)var2_6, var1_5);
        }
    }

    public final boolean a(Activity object) {
        UpdateBean updateBean;
        int n10;
        boolean bl2 = ((HMSPackageManager)(object = HMSPackageManager.getInstance((Context)object))).isApkUpdateNecessary(n10 = (updateBean = this.c).c());
        if (bl2) {
            return true;
        }
        this.a();
        SystemManager.getInstance().notifyUpdateResult(0);
        return false;
    }

    public void b(o object) {
        Class<w> clazz = w.class;
        String string2 = "UpdateWizard";
        String string3 = "Enter onDoWork.";
        HMSLog.i(string2, string3);
        boolean bl2 = object instanceof y;
        if (bl2) {
            ((o)object).b();
            object = q.class;
            this.a((Class)object);
            this.a(this);
        } else {
            bl2 = object instanceof v;
            if (bl2) {
                ((o)object).b();
                this.g();
            } else {
                bl2 = object instanceof u;
                if (bl2) {
                    this.a(clazz);
                    this.f();
                } else {
                    bl2 = object instanceof t;
                    if (bl2) {
                        this.a(clazz);
                        this.f();
                    } else {
                        boolean bl3 = object instanceof b0;
                        if (bl3) {
                            this.e();
                        } else {
                            bl3 = object instanceof c0;
                            if (bl3) {
                                this.e();
                            } else {
                                boolean bl4 = object instanceof d0;
                                if (bl4) {
                                    this.e();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c() {
        e e10 = this.j;
        if (e10 != null) {
            e10.a();
            e10 = null;
            this.j = null;
        }
    }

    public final void d() {
        Object object = this.b();
        object = object != null ? SystemUtils.getNetType(object.getBaseContext()) : "";
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("current network is ");
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        String string2 = "UpdateWizard";
        HMSLog.i(string2, (String)charSequence);
        charSequence = "WIFI";
        boolean bl2 = ((String)charSequence).equals(object);
        if (bl2) {
            this.a(w.class);
            this.f();
            object = "current network is wifi";
            HMSLog.i(string2, (String)object);
        } else {
            this.a(t.class);
            object = "current network is not wifi";
            HMSLog.i(string2, (String)object);
        }
    }

    public final void e() {
        int n10 = this.a(false);
        int n11 = 8;
        if (n10 == 0) {
            n10 = this.f;
            this.c(n11, n10);
        } else {
            n10 = this.f;
            this.a(n11, n10);
        }
    }

    public final void f() {
        boolean bl2;
        Object object = this.b();
        if (object != null && !(bl2 = object.isFinishing())) {
            bl2 = this.a((Activity)object);
            if (!bl2) {
                return;
            }
            this.c();
            d d10 = new d((Context)object);
            c c10 = new c(d10);
            this.j = c10;
            object = this.k;
            c10.a(this, (g)object);
            return;
        }
        this.a(c0.class);
    }

    public void g() {
        int n10 = this.f;
        this.c(13, n10);
    }

    public int getRequestCode() {
        return 2006;
    }

    public void onBridgeActivityCreate(Activity object) {
        int n10;
        super.onBridgeActivityCreate((Activity)object);
        UpdateBean updateBean = this.c;
        if (updateBean == null) {
            return;
        }
        this.f = n10 = 6;
        boolean bl2 = this.a((Activity)object);
        if (!bl2) {
            return;
        }
        object = this.c;
        bl2 = ((UpdateBean)object).isNeedConfirm();
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.h)))) {
            object = y.class;
            this.a((Class)object);
        } else {
            object = q.class;
            this.a((Class)object);
            this.a(this);
        }
    }

    public void onBridgeActivityDestroy() {
        this.c();
        super.onBridgeActivityDestroy();
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent intent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        boolean bl2 = this.e;
        if (bl2 && (iBridgeActivityDelegate = this.b) != null) {
            return iBridgeActivityDelegate.onBridgeActivityResult(n10, n11, intent);
        }
        n11 = this.f;
        int n12 = 6;
        bl2 = false;
        iBridgeActivityDelegate = null;
        if (n11 == n12 && n10 == (n11 = this.getRequestCode())) {
            String string2 = this.g;
            n11 = this.i;
            n10 = (int)(this.a(string2, n11) ? 1 : 0);
            if (n10 != 0) {
                n10 = this.f;
                this.c(0, n10);
            } else {
                this.e();
            }
            return true;
        }
        return false;
    }

    public void onKeyUp(int n10, KeyEvent object) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        boolean bl2 = this.e;
        if (bl2 && (iBridgeActivityDelegate = this.b) != null) {
            iBridgeActivityDelegate.onKeyUp(n10, (KeyEvent)object);
            return;
        }
        int n11 = 4;
        if (n11 == n10) {
            object = "In onKeyUp, Call finish.";
            HMSLog.i("UpdateWizard", (String)object);
            Activity activity = this.b();
            if (activity != null && (n11 = (int)(activity.isFinishing() ? 1 : 0)) == 0) {
                n11 = 0;
                object = null;
                bl2 = false;
                iBridgeActivityDelegate = null;
                activity.setResult(0, null);
                activity.finish();
            }
        }
    }
}

