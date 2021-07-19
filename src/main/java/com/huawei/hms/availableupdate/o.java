/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.content.Context
 *  android.os.Build$VERSION
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import com.huawei.hms.availableupdate.n;
import com.huawei.hms.availableupdate.o$a;
import com.huawei.hms.support.log.HMSLog;

public abstract class o {
    public AlertDialog a;
    public n b;

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public void a() {
        AlertDialog alertDialog = this.a;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void a(n n10) {
        boolean bl2;
        this.b = n10;
        n10 = this.e();
        if (n10 != null && !(bl2 = (n10 = this.e()).isFinishing())) {
            n10 = this.g();
            this.a = n10;
            n10.setCanceledOnTouchOutside(false);
            n10 = this.a;
            o$a o$a = new o$a(this);
            n10.setOnCancelListener(o$a);
            this.a.show();
            return;
        }
        HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
    }

    public void b() {
        AlertDialog alertDialog = this.a;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void c() {
        n n10 = this.b;
        if (n10 != null) {
            n10.a(this);
        }
    }

    public void d() {
        n n10 = this.b;
        if (n10 != null) {
            n10.b(this);
        }
    }

    public Activity e() {
        n n10 = this.b;
        if (n10 != null) {
            return n10.b();
        }
        return null;
    }

    public int f() {
        int n10;
        Activity activity = this.e();
        int n11 = o.a((Context)activity);
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 16)) {
            return 0;
        }
        return 3;
    }

    public abstract AlertDialog g();
}

