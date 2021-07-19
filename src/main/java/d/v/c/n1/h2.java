/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 */
package d.v.c.n1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.image.Images;
import com.zhiyun.nvseditor.data.NvsTimelineData;
import d.v.c.n1.h2$a;
import d.v.c.n1.h2$b;
import d.v.c.n1.s;
import d.v.c.u0.m;
import d.v.c.u0.n;
import d.v.c.w0.h6;
import d.v.c.y1.h.h;
import d.v.f.h.a;
import d.v.i0.b;
import d.v.l.f;

public class h2
extends a {
    private static final String g = "video_path";
    private h6 b;
    private m c;
    private String d;
    private n e;
    private h f;

    public static /* synthetic */ void j(h2 h22) {
        h22.o();
    }

    public static /* synthetic */ h6 k(h2 h22) {
        return h22.b;
    }

    public static /* synthetic */ void l(h2 h22) {
        h22.u();
    }

    public static /* synthetic */ void m(h2 h22) {
        h22.t();
    }

    public static /* synthetic */ m n(h2 h22) {
        return h22.c;
    }

    private void o() {
        this.getParentFragmentManager().beginTransaction().remove(this).commit();
    }

    private void p() {
        Object object = (m)d.v.i0.b.c(this.requireActivity()).get(m.class);
        this.c = object;
        this.d = object = this.getArguments().getString(g);
        this.e = object = n.J(n.B((String)object, 1));
        this.f = object = h.G(false, 4, 2);
    }

    private /* synthetic */ boolean q(View view, int n10, KeyEvent keyEvent) {
        int n11;
        int n12 = keyEvent.getAction();
        if (n12 == (n11 = 1) && n10 == (n12 = 4)) {
            this.o();
            return n11 != 0;
        }
        return false;
    }

    public static h2 s(String object) {
        Bundle bundle = new Bundle();
        bundle.putString(g, (String)object);
        object = new h2();
        ((Fragment)object).setArguments(bundle);
        return object;
    }

    private void t() {
        Object object = this.b;
        Object object2 = Boolean.FALSE;
        ((h6)object).B((Boolean)object2);
        object = this.getChildFragmentManager().beginTransaction();
        object2 = this.f;
        ((FragmentTransaction)object).replace(2131362467, (Fragment)object2).commit();
    }

    private void u() {
        Object object = this.b;
        Object object2 = Boolean.TRUE;
        ((h6)object).B((Boolean)object2);
        object = this.getChildFragmentManager().beginTransaction();
        object2 = this.e;
        ((FragmentTransaction)object).replace(2131362467, (Fragment)object2).commit();
    }

    public int h() {
        return 2131558565;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (h6)viewDataBinding;
        this.b = viewDataBinding;
        h2$b h2$b = new h2$b(this);
        ((h6)viewDataBinding).A(h2$b);
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        int n12 = -1;
        if (n11 == n12 && n10 == (n11 = 69) && object != null) {
            int n13;
            Object object2 = d.t.a.b.e(object);
            if (object2 == null) {
                return;
            }
            Object object3 = d.v.v.j.h.t().n();
            n11 = ((NvsTimelineData)object3).getAspectRadio();
            if (n11 != (n13 = 6)) {
                object3 = this.c;
                object2 = object2.getPath();
                ((m)object3).r((String)object2);
            } else {
                object3 = this.requireContext();
                object2 = object2.getPath();
                object = new h2$a(this);
                Images.x((Context)object3, object2, (f)object);
            }
            this.o();
        }
    }

    public void onViewCreated(View view, Bundle object) {
        super.onViewCreated(view, (Bundle)object);
        this.p();
        this.u();
        this.b.getRoot().setFocusableInTouchMode(true);
        this.b.getRoot().requestFocus();
        view = this.b.getRoot();
        object = new s(this);
        view.setOnKeyListener((View.OnKeyListener)object);
    }

    public /* synthetic */ boolean r(View view, int n10, KeyEvent keyEvent) {
        return this.q(view, n10, keyEvent);
    }
}

