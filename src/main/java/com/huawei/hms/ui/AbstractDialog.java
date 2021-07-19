/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.Build$VERSION
 */
package com.huawei.hms.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.AbstractDialog$Callback;
import com.huawei.hms.ui.AbstractDialog$a;
import com.huawei.hms.ui.AbstractDialog$b;
import com.huawei.hms.ui.AbstractDialog$c;
import com.huawei.hms.ui.AbstractDialog$d;

public abstract class AbstractDialog {
    public Activity a;
    public AlertDialog b;
    public AbstractDialog$Callback c;

    public static int a(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
    }

    public void cancel() {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void fireCancel() {
        AbstractDialog$Callback abstractDialog$Callback = this.c;
        if (abstractDialog$Callback != null) {
            abstractDialog$Callback.onCancel(this);
        }
    }

    public void fireDoWork() {
        AbstractDialog$Callback abstractDialog$Callback = this.c;
        if (abstractDialog$Callback != null) {
            abstractDialog$Callback.onDoWork(this);
        }
    }

    public Activity getActivity() {
        return this.a;
    }

    public int getDialogThemeId() {
        int n10;
        Activity activity = this.a;
        int n11 = AbstractDialog.a((Context)activity);
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 16)) {
            return 0;
        }
        return 3;
    }

    public AlertDialog onCreateDialog(Activity object) {
        Object object2 = this.getActivity();
        int n10 = this.getDialogThemeId();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)object2, n10);
        object2 = this.onGetTitleString((Context)object);
        if (object2 != null) {
            builder.setTitle((CharSequence)object2);
        }
        if ((object2 = this.onGetMessageString((Context)object)) != null) {
            builder.setMessage((CharSequence)object2);
        }
        if ((object2 = this.onGetPositiveButtonString((Context)object)) != null) {
            AbstractDialog$a abstractDialog$a = new AbstractDialog$a(this);
            builder.setPositiveButton((CharSequence)object2, (DialogInterface.OnClickListener)abstractDialog$a);
        }
        if ((object = this.onGetNegativeButtonString((Context)object)) != null) {
            object2 = new AbstractDialog$b(this);
            builder.setNegativeButton((CharSequence)object, (DialogInterface.OnClickListener)object2);
        }
        return builder.create();
    }

    public abstract String onGetMessageString(Context var1);

    public abstract String onGetNegativeButtonString(Context var1);

    public abstract String onGetPositiveButtonString(Context var1);

    public abstract String onGetTitleString(Context var1);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, AbstractDialog$Callback object) {
        boolean bl2;
        this.a = activity;
        this.c = object;
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity = this.a;
            activity = this.onCreateDialog(activity);
            this.b = activity;
            activity.setCanceledOnTouchOutside(false);
            activity = this.b;
            object = new AbstractDialog$c(this);
            activity.setOnCancelListener((DialogInterface.OnCancelListener)object);
            activity = this.b;
            object = new AbstractDialog$d(this);
            activity.setOnKeyListener((DialogInterface.OnKeyListener)object);
            this.b.show();
            return;
        }
        HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
    }
}

