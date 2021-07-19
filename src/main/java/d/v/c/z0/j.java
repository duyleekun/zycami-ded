/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.Intent
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 */
package d.v.c.z0;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.c.m1.b;
import d.v.c.w0.f4;
import d.v.c.z0.f;
import d.v.c.z0.j$a;
import d.v.c.z0.j$b;
import d.v.f.g.a;

public class j
extends a {
    private f4 f;
    private j$b g;

    public static /* synthetic */ j$b u(j j10) {
        return j10.g;
    }

    private void v() {
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            f f10 = new f(this);
            dialog.setOnKeyListener((DialogInterface.OnKeyListener)f10);
        }
    }

    private /* synthetic */ boolean w(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = keyEvent.getKeyCode();
        if (n11 == (n10 = 4) && (object = this.getActivity()) != null) {
            this.dismiss();
            return true;
        }
        return false;
    }

    private void z() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n10 = -1;
            dialog.setLayout(n10, n10);
            n10 = 17;
            dialog.setGravity(n10);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
        }
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n11 = 4097;
        if (n10 == n11 && (n10 = (int)(b.a() ? 1 : 0)) != 0) {
            j$b j$b = this.g;
            if (j$b != null) {
                ComposeParams$Resolution composeParams$Resolution = ComposeParams$Resolution.RESOLUTION_4K;
                j$b.a(composeParams$Resolution);
            }
            this.i();
        }
    }

    public void onResume() {
        super.onResume();
        this.z();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.v();
    }

    public int s() {
        return 2131558527;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (f4)viewDataBinding;
        this.f = viewDataBinding;
        j$a j$a = new j$a(this);
        ((f4)viewDataBinding).z(j$a);
    }

    public /* synthetic */ boolean x(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.w(dialogInterface, n10, keyEvent);
    }

    public j y(j$b j$b) {
        this.g = j$b;
        return this;
    }
}

