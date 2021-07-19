/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package d.v.c.z0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.account.SimpleWebViewActivity;
import d.v.c.w0.v;
import d.v.c.z0.a;
import d.v.c.z0.b;
import d.v.c.z0.c;
import d.v.c.z0.h$a;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.e.l.t1;
import d.v.f.i.g;

public class h
extends d.v.f.g.a {
    public static final String h = "AgreePrivateDialog";
    private v f;
    private View.OnClickListener g;

    private void A(Activity activity, TextView textView) {
        String string2 = d.v.f.i.g.m((Context)activity, 2131951745);
        String string3 = d.v.f.i.g.m((Context)activity, 2131953235);
        String string4 = d.v.f.i.g.m((Context)activity, 2131953236);
        Object object = activity.getResources();
        int n10 = 2131099756;
        int n11 = o1.c(object, n10);
        Object object2 = new b(activity, string3, string4);
        boolean bl2 = true;
        object = string2;
        string4 = t1.a(null, string2, string3, n11, bl2, object2);
        string3 = d.v.f.i.g.m((Context)activity, 2131952719);
        object = d.v.f.i.g.m((Context)activity, 2131952720);
        MovementMethod movementMethod = LinkMovementMethod.getInstance();
        textView.setMovementMethod(movementMethod);
        n11 = o1.c(activity.getResources(), n10);
        object2 = new c(activity, string3, (String)object);
        object = string2;
        activity = t1.a((SpannableString)string4, string2, string3, n11, bl2, object2);
        textView.setText((CharSequence)activity);
    }

    private void C() {
        float f10 = 300.0f;
        int n10 = h2.b(f10);
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            dialog.setLayout(n10, -2);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
        }
    }

    public static /* synthetic */ View.OnClickListener u(h h10) {
        return h10.g;
    }

    private /* synthetic */ boolean v(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = keyEvent.getKeyCode();
        if (n11 == (n10 = 4) && (object = this.getActivity()) != null) {
            this.getActivity().finish();
            return true;
        }
        return false;
    }

    public static /* synthetic */ void x(Activity activity, String string2, String string3, View view) {
        SimpleWebViewActivity.j((Context)activity, string2, string3);
    }

    public static /* synthetic */ void y(Activity activity, String string2, String string3, View view) {
        SimpleWebViewActivity.j((Context)activity, string2, string3);
    }

    public static h z() {
        h h10 = new h();
        return h10;
    }

    public h B(View.OnClickListener onClickListener) {
        this.g = onClickListener;
        return this;
    }

    public void onResume() {
        super.onResume();
        this.C();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.getDialog();
        if (object != null) {
            object.setCanceledOnTouchOutside(false);
            object.setCancelable(false);
            object2 = new a(this);
            object.setOnKeyListener((DialogInterface.OnKeyListener)object2);
        }
        object = this.requireActivity();
        object2 = this.f.c;
        this.A((Activity)object, (TextView)object2);
    }

    public int s() {
        return 2131558447;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (v)viewDataBinding;
        this.f = viewDataBinding;
        h$a h$a = new h$a(this);
        ((v)viewDataBinding).z(h$a);
    }

    public /* synthetic */ boolean w(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.v(dialogInterface, n10, keyEvent);
    }
}

