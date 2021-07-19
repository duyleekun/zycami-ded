/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.os.Bundle
 */
package d.v.f.g;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import d.v.f.f.e;
import d.v.f.g.b$a;
import d.v.f.g.b$b;
import d.v.f.g.b$c;
import d.v.f.i.g;
import l.a.q.z;

public class b
extends DialogFragment
implements z {
    private e a;
    private int b = 3;
    private b$b c;
    private b$c d;

    public static /* synthetic */ int h(b b10, int n10) {
        b10.b = n10;
        return n10;
    }

    private void l() {
        FragmentActivity fragmentActivity = this.getActivity();
        if (fragmentActivity == null) {
            return;
        }
        b$a b$a = new b$a(this, (Context)fragmentActivity);
        this.a = b$a;
    }

    public void e() {
        Object object = this.getHost();
        if (object == null) {
            return;
        }
        g.b(this.getChildFragmentManager());
    }

    public void i() {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        this.getDialog().dismiss();
    }

    public String j() {
        return this.getClass().getSimpleName();
    }

    public int k() {
        return this.b;
    }

    public void m(boolean bl2) {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        this.getDialog().setCanceledOnTouchOutside(bl2);
    }

    public void n(b$b b$b) {
        this.c = b$b;
    }

    public void o(b$c b$c) {
        this.d = b$c;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = this.getDialog();
        if (bundle != null && (bundle = this.getDialog().getWindow()) != null) {
            bundle = this.getDialog().getWindow();
            int n10 = 8;
            bundle.addFlags(n10);
        }
        this.l();
    }

    public void onDismiss(DialogInterface object) {
        super.onDismiss((DialogInterface)object);
        object = this.c;
        if (object != null) {
            object.onDismiss();
        }
    }

    public void onPause() {
        super.onPause();
        e e10 = this.a;
        if (e10 != null) {
            e10.disable();
        }
    }

    public void onResume() {
        super.onResume();
        Object object = this.a;
        if (object != null) {
            object.enable();
        }
        if ((object = this.d) != null) {
            object.a();
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = dialog.getWindow()) != null) {
            int n10 = 8;
            dialog.clearFlags(n10);
        }
    }

    public void p(int n10) {
    }

    /*
     * Unable to fully structure code
     */
    public void q(FragmentManager var1_1) {
        block23: {
            block22: {
                var2_3 = var1_1.isDestroyed();
                if (var2_3 == 0) break block22;
                return;
            }
            var3_4 = this.j();
            if (var3_4 == null) break block23;
            var4_5 = this.getClass();
            var4_5 = var4_5.getSimpleName();
            var5_6 = var3_4.equals(var4_5);
            if (!var5_6) break block23;
            var4_5 = var1_1.findFragmentByTag((String)var3_4);
            if (var4_5 != null) ** GOTO lbl25
            super.show((FragmentManager)var1_1, (String)var3_4);
            ** GOTO lbl25
        }
        super.show((FragmentManager)var1_1, (String)var3_4);
lbl25:
        // 3 sources

        var1_1.executePendingTransactions();
        var1_1 = this.getDialog();
        if (var1_1 == null) ** GOTO lbl56
        var1_1 = this.getDialog();
        var1_1 = var1_1.getWindow();
        if (var1_1 == null) ** GOTO lbl56
        var1_1 = this.getDialog();
        var1_1 = var1_1.getWindow();
        var1_1 = var1_1.getDecorView();
        var3_4 = this.getActivity();
        var3_4 = var3_4.getWindow();
        var3_4 = var3_4.getDecorView();
        var2_3 = var3_4.getSystemUiVisibility();
        var1_1.setSystemUiVisibility(var2_3);
        var1_1 = this.getDialog();
        var1_1 = var1_1.getWindow();
        var2_3 = 8;
        var1_1.clearFlags(var2_3);
lbl56:
        // 3 sources

        if ((var1_1 = this.d) == null) ** GOTO lbl59
        try {
            var1_1.a();
lbl59:
            // 2 sources

            this.e();
        }
        catch (Exception var1_2) {
            var1_2.printStackTrace();
        }
    }

    public void r(FragmentManager fragmentManager, int n10) {
        this.b = n10;
        this.q(fragmentManager);
    }
}

