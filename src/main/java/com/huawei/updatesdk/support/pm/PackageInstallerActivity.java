/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.Window
 */
package com.huawei.updatesdk.support.pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import com.huawei.updatesdk.a.a.c.a.a.a;
import com.huawei.updatesdk.a.a.d.h.c;
import com.huawei.updatesdk.a.b.b.b;
import com.huawei.updatesdk.b.d.e;
import com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider;
import java.io.File;

public class PackageInstallerActivity
extends Activity {
    private Intent a(Context object, String string2) {
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!(bl2 || (bl2 = string2.contains(string3 = "../")) || (bl2 = string2.contains(string3 = "..")) || (bl2 = string2.contains(string3 = "%00")) || (bl2 = string2.contains(string3 = ".\\.\\")) || (bl2 = string2.contains(string3 = "./")))) {
            string3 = new Intent();
            Object object2 = "android.intent.action.INSTALL_PACKAGE";
            string3.setAction((String)object2);
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if (n10 >= n11) {
                n10 = 1;
                string3.addFlags(n10);
                object2 = new StringBuilder();
                Object object3 = object.getApplicationContext().getPackageName();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(".updateSdk.fileProvider");
                object2 = ((StringBuilder)object2).toString();
                object3 = new File(string2);
                string2 = UpdateSdkFileProvider.getUriForFile(object, (String)object2, (File)object3);
            } else {
                object2 = new File(string2);
                string2 = Uri.fromFile((File)object2);
            }
            string3.setData((Uri)string2);
            int n12 = object instanceof Activity;
            if (n12 == 0) {
                n12 = 0x10000000;
                string3.addFlags(n12);
            }
            return string3;
        }
        object = new IllegalArgumentException("getNomalInstallIntent: Not a standard path");
        throw object;
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        super.onActivityResult(n10, n11, object);
        int n12 = 1000;
        if (n12 == n10) {
            if (n11 == 0) {
                n10 = 7;
                n11 = 0;
                Object var5_5 = null;
                e.a(n10, 0);
            } else {
                n10 = -10004;
                if (object != null) {
                    b b10 = b.a(object);
                    object = "android.intent.extra.INSTALL_RESULT";
                    n10 = b10.a((String)object, n10);
                }
                if (n10 != 0 && n10 != (n11 = 1)) {
                    n11 = 4;
                    e.a(n11, n10);
                }
            }
        }
        this.finish();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(Bundle object) {
        int n10;
        String string2;
        String string3;
        Object object2;
        boolean bl2;
        block6: {
            block5: {
                block4: {
                    bl2 = true;
                    this.requestWindowFeature((int)(bl2 ? 1 : 0));
                    object2 = c.d();
                    Window window = this.getWindow();
                    ((c)object2).a(window);
                    super.onCreate((Bundle)object);
                    object = this.getIntent();
                    object2 = "PackageInstallerActivity";
                    if (object != null) break block4;
                    this.finish();
                    object = "PackageInstallerActivity error intent";
                    break block5;
                }
                object = b.a((Intent)object);
                string3 = ((b)object).a("install_path");
                string2 = "install_packagename";
                object = ((b)object).a(string2);
                boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
                n10 = 4;
                if (!bl3) break block6;
                int n11 = -3;
                e.a(n10, n11);
                this.finish();
                object = "PackageInstallerActivity can not find filePath.";
            }
            a.b((String)object2, (String)object);
            return;
        }
        try {
            string2 = this.a((Context)this, string3);
            String string4 = "android.intent.extra.NOT_UNKNOWN_SOURCE";
            string2.putExtra(string4, bl2);
            string4 = "android.intent.extra.RETURN_RESULT";
            string2.putExtra(string4, bl2);
            StringBuilder stringBuilder = new StringBuilder();
            string4 = " onCreate filePath:";
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            String string5 = ",packageName:";
            stringBuilder.append(string5);
            stringBuilder.append((String)object);
            object = ",taskId:";
            stringBuilder.append((String)object);
            int n12 = this.getTaskId();
            stringBuilder.append(n12);
            object = stringBuilder.toString();
            a.c((String)object2, (String)object);
            n12 = 1000;
            this.startActivityForResult((Intent)string2, n12);
            return;
        }
        catch (Exception exception) {
            object = "can not start install action";
            a.b((String)object2, (String)object);
            int n13 = -2;
            e.a(n10, n13);
            this.finish();
        }
    }

    public void onDestroy() {
        this.finishActivity(1000);
        super.onDestroy();
    }
}

