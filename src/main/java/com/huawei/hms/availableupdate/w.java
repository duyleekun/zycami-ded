/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.View
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.w$b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.text.NumberFormat;

public class w
extends o {
    public ProgressBar c;
    public TextView d;
    public int e = 0;
    public DialogInterface.OnKeyListener f;

    public w() {
        w$b w$b = new w$b(null);
        this.f = w$b;
    }

    public void a(int n10) {
        this.e = n10;
    }

    public void b(int n10) {
        boolean bl2;
        Object object = this.e();
        if (object != null && !(bl2 = object.isFinishing())) {
            object = this.d;
            if (object != null && (object = this.c) != null) {
                object.setProgress(n10);
                object = NumberFormat.getPercentInstance();
                float f10 = n10;
                float f11 = 100.0f;
                double d10 = f10 /= f11;
                String string2 = ((NumberFormat)object).format(d10);
                object = this.d;
                object.setText((CharSequence)string2);
            }
            return;
        }
        HMSLog.w("DownloadProgress", "In setDownloading, The activity is null or finishing.");
    }

    public AlertDialog g() {
        Activity activity = this.e();
        int n10 = this.f();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, n10);
        activity = this.e();
        n10 = ResourceLoaderUtil.getLayoutId("hms_download_progress");
        activity = View.inflate((Context)activity, (int)n10, null);
        builder.setView((View)activity);
        builder.setCancelable(false);
        DialogInterface.OnKeyListener onKeyListener = this.f;
        builder.setOnKeyListener(onKeyListener);
        n10 = ResourceLoaderUtil.getIdId("download_info_progress");
        onKeyListener = (ProgressBar)activity.findViewById(n10);
        this.c = onKeyListener;
        n10 = ResourceLoaderUtil.getIdId("hms_progress_text");
        activity = (TextView)activity.findViewById(n10);
        this.d = activity;
        int n11 = this.e;
        this.b(n11);
        return builder.create();
    }
}

