/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.w1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import d.v.c.v0.u.z;
import d.v.c.w0.ki;
import d.v.c.w1.a;
import d.v.c.w1.b;
import d.v.c.w1.c$a;
import d.v.e.l.h2;
import d.v.f.i.g;
import java.util.Objects;

public class c
extends d.v.f.g.a {
    private VersionInfo f;
    private ki g;

    private void A() {
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

    public static /* synthetic */ VersionInfo u(c c10) {
        return c10.f;
    }

    private void v() {
        Object object;
        Object object2 = this.f;
        if (object2 == null) {
            return;
        }
        object2 = ((VersionInfo)object2).getVersionType();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        a a10 = null;
        if (!bl2 && (bl2 = ((String)(object = "dev")).equals(object2 = this.f.getVersionType()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object = this.g;
        Object object3 = this.f;
        ((ki)object).D((VersionInfo)object3);
        object = this.g;
        ((ki)object).C(bl2);
        int n10 = 2131953241;
        if (bl2) {
            object2 = this.g.c;
            object3 = b.a;
            object2.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object3);
            object2 = new StringBuilder();
            object3 = this.getResources();
            int n11 = 2131953202;
            object3 = d.v.f.i.g.o((Resources)object3, n11);
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append("\n");
            object3 = this.getResources();
            object = d.v.f.i.g.o((Resources)object3, n10);
            ((StringBuilder)object2).append((String)object);
            object = this.f.getVersion();
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = new StringBuilder();
            object3 = this.getResources();
            object = d.v.f.i.g.o((Resources)object3, n10);
            ((StringBuilder)object2).append((String)object);
            object = this.f.getVersion();
            ((StringBuilder)object2).append((String)object);
            object = this.getResources();
            int n12 = 2131953201;
            object = d.v.f.i.g.o((Resources)object, n12);
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
        }
        object = this.g.d;
        object.setText((CharSequence)object2);
        object2 = this.getDialog();
        if (object2 != null) {
            object2.setCanceledOnTouchOutside(false);
            object2.setCancelable(false);
            a10 = new a(this);
            object2.setOnKeyListener((DialogInterface.OnKeyListener)a10);
        }
    }

    public static /* synthetic */ void w(CompoundButton object, boolean bl2) {
        object = z.m();
        ((z)object).I(bl2 ^= true);
    }

    private /* synthetic */ boolean x(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11;
        object = this.f;
        boolean n112 = ((VersionInfo)object).isForceUpdate();
        if (n112 && (n11 = keyEvent.getKeyCode()) == (n10 = 4)) {
            this.getActivity().finish();
            return true;
        }
        return false;
    }

    public static c z(VersionInfo versionInfo) {
        c c10 = new c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("VersionInfo", (Parcelable)versionInfo);
        c10.setArguments(bundle);
        return c10;
    }

    public void onResume() {
        super.onResume();
        this.A();
    }

    public void onViewCreated(View object, Bundle bundle) {
        super.onViewCreated((View)object, bundle);
        object = this.getArguments();
        Objects.requireNonNull(object);
        object = (VersionInfo)((Bundle)object).getParcelable("VersionInfo");
        this.f = object;
        this.v();
    }

    public int s() {
        return 2131558804;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (ki)viewDataBinding;
        this.g = viewDataBinding;
        c$a c$a = new c$a(this);
        ((ki)viewDataBinding).B(c$a);
    }

    public /* synthetic */ boolean y(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.x(dialogInterface, n10, keyEvent);
    }
}

