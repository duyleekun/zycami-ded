/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Handler
 *  android.widget.TextView
 */
package d.v.g0;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.common.util.Windows;
import com.zhiyun.ui.R$id;
import com.zhiyun.ui.R$layout;
import d.v.e.l.h2;
import d.v.g0.b;
import d.v.g0.s$a;

public class s
extends DialogFragment {
    private static final String b = "WaitingDialog";
    private static final String c = "intent_extra_message";
    private static s d;
    private boolean a = false;

    public static /* synthetic */ boolean h(s s10) {
        return s10.a;
    }

    private void i(AppCompatDialog appCompatDialog) {
        s$a s$a = new s$a(this);
        appCompatDialog.setOnKeyListener(s$a);
    }

    public static void j() {
        s s10 = d;
        if (s10 != null) {
            s10.dismissAllowingStateLoss();
            s10 = null;
            try {
                d = null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void k(long l10) {
        Handler handler = new Handler();
        b b10 = d.v.g0.b.a;
        handler.postDelayed((Runnable)b10, l10);
    }

    public static boolean l() {
        boolean bl2;
        s s10 = d;
        if (s10 != null && (s10 = s10.getDialog()) != null && (bl2 = (s10 = d.getDialog()).isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            s10 = null;
        }
        return bl2;
    }

    public static s m(String string2) {
        s s10 = new s();
        Bundle bundle = new Bundle();
        bundle.putString(c, string2);
        s10.setArguments(bundle);
        return s10;
    }

    public static void o(FragmentActivity fragmentActivity) {
        s.q(fragmentActivity, true, null);
    }

    public static void p(FragmentActivity fragmentActivity, String string2) {
        s.q(fragmentActivity, true, string2);
    }

    private static void q(FragmentActivity object, boolean bl2, String object2) {
        boolean bl3 = s.l();
        if (!bl3) {
            d = object2 = s.m((String)object2);
            ((DialogFragment)object2).setCancelable(bl2);
            s s10 = d;
            object = ((FragmentActivity)object).getSupportFragmentManager();
            object2 = b;
            s10.show((FragmentManager)object, (String)object2);
        }
    }

    public static void r(FragmentActivity fragmentActivity) {
        boolean bl2 = true;
        s.q(fragmentActivity, bl2, null);
        d.n(bl2);
    }

    public static void s(FragmentActivity fragmentActivity, String string2) {
        boolean bl2 = true;
        s.q(fragmentActivity, bl2, string2);
        d.n(bl2);
    }

    public static void t(FragmentActivity fragmentActivity) {
        s.q(fragmentActivity, false, null);
    }

    public static void u(FragmentActivity fragmentActivity, String string2) {
        s.q(fragmentActivity, false, string2);
    }

    public void n(boolean bl2) {
        this.a = bl2;
    }

    public Dialog onCreateDialog(Bundle object) {
        object = this.getArguments().getString(c, "");
        FragmentActivity fragmentActivity = this.getActivity();
        AppCompatDialog appCompatDialog = new AppCompatDialog((Context)fragmentActivity);
        int n10 = R$layout.zyui_dialog_waiting;
        appCompatDialog.setContentView(n10);
        n10 = R$id.waiting_tv;
        fragmentActivity = (TextView)appCompatDialog.findViewById(n10);
        if (fragmentActivity != null) {
            fragmentActivity.setText((CharSequence)object);
        }
        appCompatDialog.setCanceledOnTouchOutside(false);
        this.i(appCompatDialog);
        return appCompatDialog;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n10 = -1;
            int n11 = Windows.l(this.requireContext()).getHeight();
            float f10 = 100.0f;
            int n12 = h2.b(f10);
            dialog.setLayout(n10, n11 -= n12);
            dialog = this.getDialog().getWindow();
            n11 = 0;
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
        }
    }
}

