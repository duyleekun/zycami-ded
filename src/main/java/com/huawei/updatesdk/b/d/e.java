/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.huawei.updatesdk.b.d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.a.a.c.a.a.a;
import com.huawei.updatesdk.a.b.b.b;
import com.huawei.updatesdk.b.f.c;
import com.huawei.updatesdk.support.pm.PackageInstallerActivity;
import java.io.File;

public class e {
    public static void a(int n10, int n11) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("INSTALL_STATE", n10);
        bundle.putInt("INSTALL_TYPE", n11);
        intent.putExtras(bundle);
        b b10 = b.a(intent);
        c.b().c(b10);
    }

    public static void a(Context object, String string2, String string3) {
        long l10;
        long l11;
        long l12;
        int n10 = 3;
        e.a(n10, 1);
        File file = new File(string2);
        boolean bl2 = file.exists();
        int n11 = 4;
        String string4 = "InstallProcess";
        if (bl2 && (bl2 = file.isFile()) && (n10 = (int)((l12 = (l11 = file.length()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
            file = new Intent((Context)object, PackageInstallerActivity.class);
            String string5 = "install_path";
            file.putExtra(string5, string2);
            string2 = "install_packagename";
            file.putExtra(string2, string3);
            int n12 = object instanceof Activity;
            if (n12 == 0) {
                n12 = 0x18000000;
                file.setFlags(n12);
            }
            try {
                ((Context)object).startActivity((Intent)file);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                n12 = -10002;
                e.a(n11, n12);
                string2 = " can not start install !";
                a.a(string4, string2, activityNotFoundException);
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("system install failed,file not existed filePath:");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        a.b(string4, (String)object);
        e.a(n11, -10003);
    }
}

