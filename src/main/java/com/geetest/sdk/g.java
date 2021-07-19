/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.View
 */
package com.geetest.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.GT3LoadImageView;
import com.geetest.sdk.a$d;
import com.geetest.sdk.av;
import com.geetest.sdk.d;
import com.geetest.sdk.dialog.views.FailedView;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.LoadingView;
import com.geetest.sdk.dialog.views.SuccessView;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.e;
import com.geetest.sdk.f;
import com.geetest.sdk.g$a;
import com.geetest.sdk.g$b;
import com.geetest.sdk.g$c;
import com.geetest.sdk.g$d;
import com.geetest.sdk.g$e;
import com.geetest.sdk.g$f;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.utils.l;

public class g {
    private Context a;
    private GT3ConfigBean b;
    private f c;
    private f d;
    private LoadingView e;
    private GtWebView f;
    private g$e g;
    private a h;
    private a$d i;
    private int j = 1;
    private boolean k;
    public g$f l;

    public g(Context object, GT3ConfigBean gT3ConfigBean) {
        Object object2 = g$f.INIT;
        this.l = object2;
        this.a = object;
        this.b = gT3ConfigBean;
        super((Context)object);
        this.c = object2;
        int bl2 = gT3ConfigBean.getDialogOffsetY();
        ((e)((Object)object2)).a(bl2);
        object2 = this.c;
        boolean bl3 = gT3ConfigBean.isCanceledOnTouchOutside();
        object2.setCanceledOnTouchOutside(bl3);
        super((Context)object);
        this.d = object2;
        int n10 = gT3ConfigBean.getDialogOffsetY();
        ((e)((Object)object2)).a(n10);
        object = this.d;
        boolean bl4 = gT3ConfigBean.isCanceledOnTouchOutside();
        object.setCanceledOnTouchOutside(bl4);
        object = this.c;
        object2 = new g$a(this, gT3ConfigBean);
        object.setOnCancelListener((DialogInterface.OnCancelListener)object2);
        object = this.c;
        object2 = new g$b(this, gT3ConfigBean);
        object.setOnKeyListener((DialogInterface.OnKeyListener)object2);
    }

    public static /* synthetic */ a$d a(g g10) {
        return g10.i;
    }

    public static /* synthetic */ GT3ConfigBean b(g g10) {
        return g10.b;
    }

    private void n() {
    }

    public void a() {
        Object object;
        Object object2 = this.h;
        if (object2 != null && (object = this.c) != null) {
            ((a)object2).d();
            object2 = this.c;
            object = this.f;
            ((f)((Object)object2)).c((View)object);
        }
    }

    public void a(int n10) {
        this.j = n10;
    }

    public void a(GT3ErrorBean object) {
        Object object2 = this.d;
        Object object3 = new g$c(this, (GT3ErrorBean)object);
        object2.setOnDismissListener((DialogInterface.OnDismissListener)object3);
        object2 = g$f.DISMISS;
        this.l = object2;
        int n10 = this.f();
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                this.n();
                object2 = new g$e(this);
                this.g = object2;
                Context context = this.a;
                g$e g$e = this.g;
                GT3ConfigBean gT3ConfigBean = this.b;
                object3 = object2;
                object2 = new FailedView(context, this, (GT3ErrorBean)object, g$e, gT3ConfigBean);
                object = this.d;
                ((f)((Object)object)).c((View)object2);
                object = this.d;
                try {
                    ((d)((Object)object)).show();
                    this.b();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                this.b();
                object2 = this.b;
                if (object2 != null && (object2 = ((GT3ConfigBean)object2).getListener()) != null) {
                    object2 = this.b.getListener();
                    object2.onFailed((GT3ErrorBean)object);
                }
            }
        } else {
            this.b();
            object2 = this.i;
            if (object2 != null) {
                object3 = ((GT3ErrorBean)object).errorDesc;
                String string2 = ((GT3ErrorBean)object).errorCode;
                object2.a((String)object3, string2);
            }
            if ((object2 = this.b) != null && (object2 = ((GT3ConfigBean)object2).getListener()) != null) {
                object2 = this.b.getListener();
                object2.onFailed((GT3ErrorBean)object);
            }
        }
    }

    public void a(g$f g$f) {
        this.l = g$f;
    }

    public void a(b object, av av2) {
        Context context = this.a;
        f f10 = this.c;
        Object object2 = new a(context, f10);
        this.h = object2;
        ((a)object2).a((b)object);
        object = this.h;
        object2 = this.b;
        ((a)object).a((GT3ConfigBean)object2);
        this.h.a(av2);
        object = this.h.a();
        this.f = object;
    }

    public void a(boolean bl2) {
        this.k = bl2;
    }

    public void b() {
        block5: {
            f f10 = this.c;
            if (f10 == null) break block5;
            boolean bl2 = f10.isShowing();
            if (!bl2) break block5;
            f10 = this.c;
            try {
                f10.dismiss();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void c() {
        Object object = g$f.DISMISS;
        this.l = object;
        this.b();
        int n10 = this.f();
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11 && (object = this.i) != null) {
                object.h();
            }
        } else {
            this.d();
        }
    }

    public void d() {
        block5: {
            f f10 = this.d;
            if (f10 == null) break block5;
            boolean bl2 = f10.isShowing();
            if (!bl2) break block5;
            f10 = this.d;
            try {
                f10.dismiss();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public boolean e() {
        return this.f.b() ^ true;
    }

    public int f() {
        return this.j;
    }

    public f g() {
        return this.c;
    }

    public g$f h() {
        return this.l;
    }

    public boolean i() {
        return this.k;
    }

    public void j() {
        this.b();
        a a10 = this.h;
        if (a10 != null) {
            a10.b();
            a10 = null;
            this.h = null;
        }
    }

    public void k() {
        int n10;
        int n11 = this.f();
        if (n11 != (n10 = 2) && n11 != (n10 = 3)) {
            boolean bl2;
            Object object;
            Object object2 = this.a;
            GT3LoadImageView gT3LoadImageView = this.b.getLoadImageView();
            GT3ConfigBean gT3ConfigBean = this.b;
            this.e = object = new LoadingView((Context)object2, gT3LoadImageView, gT3ConfigBean);
            this.d.b((View)object);
            object = this.a;
            object2 = "DialogController";
            if (object != null && (bl2 = object instanceof Activity) && (n11 = (int)((object = (Activity)object).isFinishing() ? 1 : 0)) == 0) {
                object = "showLoading-->Success !";
                com.geetest.sdk.utils.l.b((String)object2, (String)object);
                object = this.d;
                try {
                    ((d)((Object)object)).show();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                object = g$f.SHOW_LOADING;
                this.l = object;
            } else {
                object = "showLoading-->error";
                com.geetest.sdk.utils.l.b((String)object2, (String)object);
            }
        }
    }

    public void l() {
        int n10;
        int n11 = this.f();
        boolean bl2 = true;
        int n12 = 2;
        if (n11 != n12 && n11 != (n10 = 3)) {
            Object object = this.c;
            GtWebView gtWebView = this.f;
            object.b((View)gtWebView);
            object = this.a;
            if (object != null && (n12 = object instanceof Activity) != 0 && (n11 = (int)((object = (Activity)object).isFinishing() ? 1 : 0)) == 0) {
                object = this.c;
                n11 = (int)(object.isShowing() ? 1 : 0);
                if (n11 == 0) {
                    com.geetest.sdk.utils.d.a = bl2;
                    object = this.d;
                    if (object != null && (n11 = (int)(object.isShowing() ? 1 : 0)) != 0) {
                        object = this.c;
                        try {
                            object.show();
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    object = g$f.SHOW_WEB;
                    this.l = object;
                } else {
                    object = this.c;
                    GtWebView gtWebView2 = this.f;
                    object.c((View)gtWebView2);
                }
            }
            com.geetest.sdk.utils.d.a = false;
            object = this.d;
            if (object != null && (n11 = (int)(object.isShowing() ? 1 : 0)) != 0) {
                object = this.d;
                object.dismiss();
            }
        } else {
            n11 = this.f();
            if (n11 == n12 && (n11 = (int)(this.i() ? 1 : 0)) == 0) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Mode configuration error !");
                throw illegalArgumentException;
            }
            Object object = this.c;
            GtWebView gtWebView = this.f;
            object.b((View)gtWebView);
            object = this.a;
            if (object != null && (n12 = object instanceof Activity) != 0 && (n11 = (int)((object = (Activity)object).isFinishing() ? 1 : 0)) == 0) {
                object = this.c;
                n11 = (int)(object.isShowing() ? 1 : 0);
                if (n11 == 0) {
                    com.geetest.sdk.utils.d.a = bl2;
                    object = this.c;
                    try {
                        object.show();
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    object = g$f.SHOW_WEB;
                    this.l = object;
                } else {
                    object = this.c;
                    GtWebView gtWebView3 = this.f;
                    object.c((View)gtWebView3);
                }
            }
            com.geetest.sdk.utils.d.a = false;
        }
    }

    public void m() {
        Object object = this.d;
        Object object2 = new g$d(this);
        object.setOnDismissListener((DialogInterface.OnDismissListener)object2);
        object = g$f.DISMISS;
        this.l = object;
        int n10 = this.f();
        object2 = "";
        int n11 = 2;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                this.n();
                object2 = this.a;
                GT3ConfigBean gT3ConfigBean = this.b;
                object = new SuccessView((Context)object2, this, gT3ConfigBean);
                object2 = this.d;
                ((f)((Object)object2)).c((View)object);
                object = this.d;
                try {
                    ((d)((Object)object)).show();
                    this.b();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            } else {
                this.b();
                object = this.b;
                if (object != null && (object = ((GT3ConfigBean)object).getListener()) != null) {
                    object = this.b.getListener();
                    object.onSuccess((String)object2);
                }
            }
        } else {
            this.b();
            object = this.i;
            if (object != null) {
                object.a();
            }
            if ((object = this.b) != null && (object = ((GT3ConfigBean)object).getListener()) != null) {
                object = this.b.getListener();
                object.onSuccess((String)object2);
            }
        }
    }

    public void setButtonListener(a$d a$d) {
        this.i = a$d;
    }
}

