/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 *  android.text.TextUtils
 */
package com.huawei.hms.availableupdate;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.availableupdate.a;
import com.huawei.hms.availableupdate.b;
import com.huawei.hms.availableupdate.d$a;
import com.huawei.hms.availableupdate.e;
import com.huawei.hms.availableupdate.f;
import com.huawei.hms.availableupdate.g;
import com.huawei.hms.availableupdate.i;
import com.huawei.hms.availableupdate.j;
import com.huawei.hms.availableupdate.k;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.IOUtils;
import java.io.File;
import java.io.IOException;

public class d
implements e {
    public final Context a;
    public final k b;
    public final a c;
    public f d;
    public File e;

    public d(Context context) {
        Object object = new j();
        this.b = object;
        this.c = object = new a();
        this.a = context = context.getApplicationContext();
    }

    public static /* synthetic */ a a(d d10) {
        return d10.c;
    }

    public static /* synthetic */ void a(d d10, int n10, int n11, int n12) {
        d10.a(n10, n11, n12);
    }

    public final b a(File file, int n10, String string2) {
        d$a d$a = new d$a(this, file, n10, n10, string2);
        return d$a;
    }

    public void a() {
        HMSLog.i("UpdateDownload", "Enter cancel.");
        this.a((f)null);
        this.b.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(int n10, int n11, int n12) {
        synchronized (this) {
            f f10 = this.d;
            if (f10 != null) {
                File file = this.e;
                f10.a(n10, n11, n12, file);
            }
            return;
        }
    }

    public final void a(f f10) {
        synchronized (this) {
            this.d = f10;
            return;
        }
    }

    public void a(f object, g g10) {
        boolean bl2;
        Checker.checkNonNull(object, "callback must not be null.");
        String string2 = "UpdateDownload";
        HMSLog.i(string2, "Enter downloadPackage.");
        this.a((f)object);
        int n10 = 2201;
        if (g10 != null && (bl2 = g10.a())) {
            Object object2 = Environment.getExternalStorageState();
            String string3 = "mounted";
            bl2 = string3.equals(object2);
            int n11 = 2204;
            if (!bl2) {
                HMSLog.e(string2, "In downloadPackage, Invalid external storage for downloading file.");
                this.a(n11, 0, 0);
                return;
            }
            object2 = g10.b;
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3) {
                HMSLog.e(string2, "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
                this.a(n10, 0, 0);
                return;
            }
            Context context = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            stringBuilder.append(".apk");
            object2 = stringBuilder.toString();
            this.e = object2 = UpdateProvider.getLocalFile(context, (String)object2);
            if (object2 == null) {
                HMSLog.e(string2, "In downloadPackage, Failed to get local file for downloading.");
                this.a(n11, 0, 0);
                return;
            }
            if ((object2 = ((File)object2).getParentFile()) != null && ((n11 = (int)(((File)object2).mkdirs() ? 1 : 0)) != 0 || (n11 = (int)(((File)object2).isDirectory() ? 1 : 0)) != 0)) {
                long l10;
                long l11 = ((File)object2).getUsableSpace();
                long l12 = l11 - (l10 = (long)(g10.d * 3));
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 < 0) {
                    HMSLog.e(string2, "In downloadPackage, No space for downloading file.");
                    this.a(2203, 0, 0);
                    return;
                }
                try {
                    this.a(g10);
                }
                catch (i i10) {
                    object = "In downloadPackage, Canceled to download the update file.";
                    HMSLog.w(string2, (String)object);
                    n10 = 2101;
                    this.a(n10, 0, 0);
                }
                return;
            }
            HMSLog.e(string2, "In downloadPackage, Failed to create directory for downloading file.");
            this.a(n10, 0, 0);
            return;
        }
        HMSLog.e(string2, "In downloadPackage, Invalid update info.");
        this.a(n10, 0, 0);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(g var1_1) {
        block13: {
            block9: {
                block11: {
                    block12: {
                        block10: {
                            block8: {
                                var2_5 = "UpdateDownload";
                                var3_6 = "Enter downloadPackage.";
                                HMSLog.i(var2_5, var3_6);
                                var4_7 = 2201;
                                var5_8 = null;
                                try {
                                    var6_9 = var1_1.b;
                                    var7_10 = TextUtils.isEmpty((CharSequence)var6_9);
                                    if (var7_10 == 0) break block8;
                                    var1_1 = "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ";
                                    HMSLog.e(var2_5, (String)var1_1);
                                    this.a(var4_7, 0, 0);
                                    this.b.close();
                                }
                                catch (IOException var1_3) {
                                    var6_9 = new StringBuilder();
                                    var8_11 = "In DownloadHelper.downloadPackage, Failed to download.";
                                    var6_9.append((String)var8_11);
                                    var1_4 = var1_3.getMessage();
                                    var6_9.append(var1_4);
                                    var1_4 = var6_9.toString();
                                    HMSLog.e(var2_5, var1_4);
                                    this.a(var4_7, 0, 0);
                                    break block9;
                                }
                                IOUtils.closeQuietly(null);
                                return;
                            }
                            try {
                                var8_11 = this.c;
                                var9_12 /* !! */  = this.b();
                                var8_11.a(var9_12 /* !! */ , (String)var6_9);
                                var8_11 = this.c;
                                var9_12 /* !! */  = var1_1.c;
                                var10_13 = var1_1.d;
                                var11_14 = var1_1.e;
                                var7_10 = var8_11.b((String)var9_12 /* !! */ , var10_13, var11_14);
                                var12_15 = 2000;
                                if (var7_10 == 0) ** GOTO lbl72
                                var8_11 = this.c;
                                var7_10 = var8_11.a();
                                if (var7_10 != (var10_13 = (var13_16 = this.c).b())) ** GOTO lbl64
                                var8_11 = var1_1.e;
                                var13_16 = this.e;
                                var7_10 = (int)FileUtil.verifyHash((String)var8_11, (File)var13_16);
                                if (var7_10 == 0) break block10;
                                this.a(var12_15, 0, 0);
                                this.b.close();
                            }
                            catch (Throwable var1_2) {}
                            IOUtils.closeQuietly(null);
                            return;
                        }
                        var8_11 = this.c;
                        var13_16 = var1_1.c;
                        var14_17 = var1_1.d;
                        var15_19 = var1_1.e;
                        var8_11.a((String)var13_16, var14_17, (String)var15_19);
                        var8_11 = this.e;
                        var10_13 = var1_1.d;
                        var5_8 = this.a((File)var8_11, var10_13, (String)var6_9);
                        break block12;
lbl64:
                        // 1 sources

                        var8_11 = this.e;
                        var10_13 = var1_1.d;
                        var5_8 = this.a((File)var8_11, var10_13, (String)var6_9);
                        var6_9 = this.c;
                        var16_20 = var6_9.a();
                        var17_21 = var16_20;
                        var5_8.a(var17_21);
                        break block12;
lbl72:
                        // 1 sources

                        var8_11 = this.c;
                        var13_16 = var1_1.c;
                        var14_18 = var1_1.d;
                        var15_19 = var1_1.e;
                        var8_11.a((String)var13_16, var14_18, (String)var15_19);
                        var8_11 = this.e;
                        var10_13 = var1_1.d;
                        var5_8 = this.a((File)var8_11, var10_13, (String)var6_9);
                    }
                    var13_16 = this.b;
                    var11_14 = var1_1.c;
                    var6_9 = this.c;
                    var19_22 = var6_9.a();
                    var6_9 = this.c;
                    var20_23 = var6_9.b();
                    var21_24 = this.a;
                    var15_19 = var5_8;
                    var16_20 = var13_16.a(var11_14, var5_8, var19_22, var20_23, var21_24);
                    var7_10 = 200;
                    if (var16_20 == var7_10 || var16_20 == (var7_10 = 206)) break block11;
                    var1_1 = new StringBuilder();
                    var8_11 = "In DownloadHelper.downloadPackage, Download the package, HTTP code: ";
                    var1_1.append((String)var8_11);
                    var1_1.append(var16_20);
                    var1_1 = var1_1.toString();
                    HMSLog.e(var2_5, (String)var1_1);
                    this.a(var4_7, 0, 0);
                    this.b.close();
                    IOUtils.closeQuietly(var5_8);
                    return;
                }
                var1_1 = var1_1.e;
                var6_9 = this.e;
                var22_25 = FileUtil.verifyHash((String)var1_1, (File)var6_9);
                if (var22_25 != 0) ** GOTO lbl-1000
                var22_25 = 2202;
                this.a(var22_25, 0, 0);
                this.b.close();
                IOUtils.closeQuietly(var5_8);
                return;
lbl-1000:
                // 1 sources

                {
                    this.a(var12_15, 0, 0);
                    break block9;
                }
                break block13;
            }
            this.b.close();
            IOUtils.closeQuietly(var5_8);
            return;
        }
        this.b.close();
        IOUtils.closeQuietly(var5_8);
        throw var1_2;
    }

    public Context b() {
        return this.a;
    }
}

