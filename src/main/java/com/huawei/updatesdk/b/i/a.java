/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.DialogInterface$OnShowListener
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ImageView
 */
package com.huawei.updatesdk.b.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.huawei.updatesdk.b.h.c;
import com.huawei.updatesdk.b.i.a$a;
import com.huawei.updatesdk.b.i.a$b;
import com.huawei.updatesdk.b.i.a$c;
import com.huawei.updatesdk.b.i.a$d;
import com.huawei.updatesdk.b.i.b;

public class a {
    private b a;
    private Context b;
    private String c;
    private CharSequence d;
    private AlertDialog e;
    private AlertDialog.Builder f;
    private DialogInterface.OnShowListener g;
    private DialogInterface.OnDismissListener h;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public a(Context context, String charSequence, CharSequence charSequence2) {
        void var2_4;
        int n10;
        String string2;
        this.b = context;
        this.c = charSequence;
        this.d = string2;
        int n11 = com.huawei.updatesdk.a.a.d.h.c.i();
        if (n11 != 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
        } else {
            Configuration configuration = context.getResources().getConfiguration();
            n11 = configuration.uiMode & 0x30;
            n10 = 32;
            if (n11 == n10 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 29)) {
                n10 = 16974545;
                AlertDialog.Builder builder = new AlertDialog.Builder(context, n10);
            } else {
                n10 = 16974546;
                AlertDialog.Builder builder = new AlertDialog.Builder(context, n10);
            }
        }
        this.f = var2_4;
        AlertDialog.Builder builder = this.f;
        string2 = this.c;
        builder.setTitle((CharSequence)string2);
        AlertDialog.Builder builder2 = this.f;
        n10 = com.huawei.updatesdk.b.h.c.c(context, "upsdk_third_app_dl_sure_cancel_download");
        builder2.setPositiveButton(n10, null);
        AlertDialog.Builder builder3 = this.f;
        int n12 = com.huawei.updatesdk.b.h.c.c(context, "upsdk_cancel");
        builder3.setNegativeButton(n12, null);
        context = this.f;
        CharSequence charSequence3 = this.d;
        context.setMessage(charSequence3);
    }

    public static a a(Context context, String string2, CharSequence charSequence) {
        a a10 = new a(context, string2, charSequence);
        return a10;
    }

    public static /* synthetic */ b a(a a10) {
        return a10.a;
    }

    public static /* synthetic */ DialogInterface.OnShowListener b(a a10) {
        return a10.g;
    }

    public static /* synthetic */ DialogInterface.OnDismissListener c(a a10) {
        return a10.h;
    }

    public void a() {
        block4: {
            Object object = this.e;
            if (object == null) break block4;
            object.dismiss();
            object = null;
            try {
                this.e = null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = "BaseAlertDialog";
                String string2 = "dialog dismiss IllegalArgumentException";
                com.huawei.updatesdk.a.a.a.b((String)object, string2);
            }
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.h = onDismissListener;
    }

    public void a(DialogInterface.OnKeyListener onKeyListener) {
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.setOnKeyListener(onKeyListener);
        }
    }

    public void a(DialogInterface.OnShowListener onShowListener) {
        this.g = onShowListener;
    }

    public void a(View view) {
        Object object = this.f;
        if (object != null) {
            String string2;
            int n10;
            object = com.huawei.updatesdk.b.h.a.d();
            int n11 = ((com.huawei.updatesdk.b.h.a)object).a();
            if (n11 >= (n10 = 17)) {
                object = view.getContext();
                string2 = "divider";
                n11 = com.huawei.updatesdk.b.h.c.a((Context)object, string2);
                if ((object = (ImageView)view.findViewById(n11)) != null) {
                    n10 = 8;
                    object.setVisibility(n10);
                }
            }
            object = this.f;
            n10 = 0;
            string2 = null;
            object.setMessage(null);
            object = this.f;
            object.setView(view);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(a$c a$c, String string2) {
        int n10;
        AlertDialog alertDialog = this.e;
        if (alertDialog == null) {
            return;
        }
        a$c a$c2 = a$c.a;
        if (a$c == a$c2) {
            n10 = -1;
        } else {
            a$c2 = a$c.b;
            if (a$c != a$c2) return;
            n10 = -2;
        }
        a$c = alertDialog.getButton(n10);
        if (a$c == null) {
            return;
        }
        a$c.setText(string2);
        a$c.setAllCaps(true);
    }

    public void a(a$d object) {
        boolean bl2;
        Object object2 = this.b;
        String string2 = "BaseAlertDialog";
        if (object2 != null && !(bl2 = (object2 = (Activity)object2).isFinishing())) {
            block21: {
                bl2 = this.b();
                if (!bl2) {
                    object2 = this.f;
                    object2 = object2.create();
                    this.e = object2;
                    int n10 = 0;
                    Object object3 = null;
                    object2.setCanceledOnTouchOutside(false);
                    object2 = this.e;
                    object3 = new a$a(this);
                    object2.setOnShowListener((DialogInterface.OnShowListener)object3);
                    object2 = this.e;
                    object3 = new a$b(this);
                    object2.setOnDismissListener((DialogInterface.OnDismissListener)object3);
                    object2 = this.e;
                    object2.show();
                    object2 = this.e;
                    n10 = -1;
                    object2 = object2.getButton(n10);
                    try {
                        object2.requestFocus();
                        break block21;
                    }
                    catch (Exception exception) {
                        if (object != null) {
                            object.a();
                        }
                        object = new StringBuilder();
                        object3 = "show dlg error, e: ";
                        ((StringBuilder)object).append((String)object3);
                        String string3 = exception.toString();
                        ((StringBuilder)object).append(string3);
                    }
                } else {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("show dlg error, mContext = ");
                    object2 = this.b;
                    ((StringBuilder)object).append(object2);
                    ((StringBuilder)object).append(", mContext.isFinishing is ");
                    object2 = this.b;
                    if (object2 == null) {
                        object2 = "mContext == null";
                    } else {
                        bl2 = ((Activity)object2).isFinishing();
                        object2 = bl2;
                    }
                    ((StringBuilder)object).append(object2);
                }
                object = ((StringBuilder)object).toString();
                com.huawei.updatesdk.a.a.a.a(string2, (String)object);
            }
            return;
        }
        object2 = "context == null or activity isFinishing";
        com.huawei.updatesdk.a.a.a.b(string2, (String)object2);
        if (object != null) {
            object.a();
        }
    }

    public void a(b b10) {
        this.a = b10;
    }

    public void a(boolean bl2) {
        AlertDialog alertDialog = this.e;
        if (alertDialog != null) {
            alertDialog.setCancelable(bl2);
        }
    }

    public boolean b() {
        boolean bl2;
        AlertDialog alertDialog = this.e;
        if (alertDialog != null && (bl2 = alertDialog.isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            alertDialog = null;
        }
        return bl2;
    }

    public void c() {
        AlertDialog.Builder builder = this.f;
        if (builder == null) {
            return;
        }
        builder.setNegativeButton(null, null);
    }
}

