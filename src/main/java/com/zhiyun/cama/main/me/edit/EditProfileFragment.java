/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.InputFilter
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.view.View
 *  android.widget.ImageView
 */
package com.zhiyun.cama.main.me.edit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$a;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$b;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$c;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$d;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$e;
import com.zhiyun.image.Images;
import com.zhiyun.image.Images$CacheStrategy;
import com.zhiyun.image.Images$d;
import com.zhiyun.permission.Permission;
import d.v.c.i1.t2.i0;
import d.v.c.i1.t2.p0.a;
import d.v.c.i1.t2.p0.d;
import d.v.c.i1.t2.p0.e;
import d.v.c.i1.t2.p0.f;
import d.v.c.i1.t2.p0.g;
import d.v.c.i1.t2.p0.h;
import d.v.c.i1.t2.p0.h$b;
import d.v.c.w0.ie;
import d.v.e.l.n2;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.j.e.h.k;
import d.v.x.b;
import d.v.x.c$b;

public class EditProfileFragment
extends d.v.f.h.a {
    private ie b;
    private i0 c;

    public static /* synthetic */ CharSequence A(CharSequence charSequence, int n10, int n11, Spanned spanned, int n12, int n13) {
        return charSequence.toString().replace("\n", "");
    }

    private /* synthetic */ void B(DialogFragment dialogFragment) {
        dialogFragment.dismissAllowingStateLoss();
        this.o();
    }

    private void E(String string2) {
        n2.e(string2);
    }

    private void F() {
        Object object = this.requireContext();
        k$b k$b = new k$b((Context)object);
        object = d.v.f.i.g.s(this, 2131953238);
        k$b = (k$b)k$b.B((String)object);
        object = d.v.f.i.g.s(this, 2131952621);
        f f10 = new f(this);
        k$b = (k$b)((k$b)k$b.x((String)object, f10)).s();
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    private void I(String object, String object2, int n10, String string2, String string3) {
        this.D();
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatar((String)object);
        userInfo.setNickname((String)object2);
        userInfo.setSex(n10);
        userInfo.setCountry(string2);
        userInfo.setIntroduction(string3);
        object = this.c;
        object2 = new EditProfileFragment$d(this);
        ((i0)object).P(userInfo, (d.v.a.f.b.a)object2);
    }

    public static /* synthetic */ ie j(EditProfileFragment editProfileFragment) {
        return editProfileFragment.b;
    }

    public static /* synthetic */ void k(EditProfileFragment editProfileFragment, String string2) {
        editProfileFragment.E(string2);
    }

    public static /* synthetic */ void l(EditProfileFragment editProfileFragment) {
        editProfileFragment.F();
    }

    public static /* synthetic */ i0 m(EditProfileFragment editProfileFragment) {
        return editProfileFragment.c;
    }

    public static /* synthetic */ void n(EditProfileFragment editProfileFragment, String string2, String string3, int n10, String string4, String string5) {
        editProfileFragment.I(string2, string3, n10, string4, string5);
    }

    private void o() {
        this.b.b.setText(null);
        this.b.a.setText(null);
    }

    private int p(int n10) {
        int n11 = 1;
        n10 = n10 != n11 ? (n10 != (n11 = 2) ? 2131952573 : 2131952575) : 2131952542;
        return n10;
    }

    private void r() {
        this.b.l.setVisibility(8);
        Object object = (i0)d.v.i0.b.c(this.requireActivity()).get(i0.class);
        this.c = object;
        ((i0)object).F();
        object = this.c.k();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new a(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
        object = this.c.c();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new g(this);
        ((LiveData)object).observe(lifecycleOwner, observer);
    }

    private void s() {
        h h10 = h.b();
        Object object = new e(this);
        h10.e((h$b)object);
        h10 = this.b.a;
        InputFilter inputFilter = h10.getFilters()[0];
        object = new InputFilter[]{inputFilter, inputFilter = d.a};
        h10.setFilters((InputFilter[])object);
        h10 = this.b.a;
        object = new EditProfileFragment$a(this);
        h10.addTextChangedListener((TextWatcher)object);
    }

    private void t(UserInfo object) {
        Object object2 = this.b.d;
        String string2 = ((UserInfo)object).getAvatar();
        int n10 = 2131231027;
        Images.A((ImageView)object2, string2, n10);
        object2 = this.b.b;
        string2 = ((UserInfo)object).getNickname();
        object2.setText((CharSequence)string2);
        object2 = ((UserInfo)object).getNickname();
        int n11 = ((String)object2).length();
        int n12 = 20;
        if (n11 >= n12) {
            object2 = this.b.b;
            object2.setSelection(n12);
        } else {
            object2 = this.b.b;
            string2 = ((UserInfo)object).getNickname();
            n12 = string2.length();
            object2.setSelection(n12);
        }
        n11 = ((UserInfo)object).getSex();
        n11 = this.p(n11);
        string2 = this.b.m;
        Object object3 = this.getResources();
        object2 = d.v.f.i.g.o(object3, n11);
        string2.setText((CharSequence)object2);
        object2 = this.c;
        n12 = ((UserInfo)object).getSex();
        ((i0)object2).K(n12);
        object2 = ((UserInfo)object).getIntroduction();
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n11 == 0) {
            object2 = this.b.a;
            string2 = ((UserInfo)object).getIntroduction();
            object3 = "\n";
            String string3 = "";
            string2 = string2.replace((CharSequence)object3, string3);
            object2.setText((CharSequence)string2);
        }
        object2 = this.c;
        object = ((UserInfo)object).getCountry();
        ((i0)object2).I((String)object);
    }

    private /* synthetic */ void u(k object) {
        if (object != null && (object = ((k)object).c) != null) {
            object = (UserInfo)object;
            this.t((UserInfo)object);
        }
    }

    private /* synthetic */ void w(String string2) {
        this.b.g.setText((CharSequence)string2);
    }

    private /* synthetic */ void y(Uri object) {
        this.c.H((Uri)object);
        Images$d images$d = new Images$d();
        images$d.q(true);
        Images$CacheStrategy images$CacheStrategy = Images$CacheStrategy.NONE;
        images$d.p(images$CacheStrategy);
        images$CacheStrategy = this.b.d;
        object = object.getPath();
        Images.j((ImageView)images$CacheStrategy, object, images$d);
    }

    public /* synthetic */ void C(DialogFragment dialogFragment) {
        this.B(dialogFragment);
    }

    public void D() {
        s.t(this.requireActivity());
    }

    public void G() {
        Object object = Permission.STORAGE;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new EditProfileFragment$c(this);
        c$b = c$b.a((b)object);
        object = this.getChildFragmentManager();
        c$b.b((FragmentManager)object);
    }

    public void H() {
        Object object = Permission.CAMERA_GROUP;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new EditProfileFragment$b(this);
        c$b = c$b.a((b)object);
        object = this.getChildFragmentManager();
        c$b.b((FragmentManager)object);
    }

    public int h() {
        return 2131558692;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (ie)viewDataBinding;
        this.b = viewDataBinding;
        EditProfileFragment$e editProfileFragment$e = new EditProfileFragment$e(this);
        ((ie)viewDataBinding).z(editProfileFragment$e);
    }

    public void onDestroy() {
        this.c.K(3);
        this.c.H(null);
        h.b().e(null);
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r();
        this.s();
    }

    public void q() {
        s.j();
    }

    public /* synthetic */ void v(k k10) {
        this.u(k10);
    }

    public /* synthetic */ void x(String string2) {
        this.w(string2);
    }

    public /* synthetic */ void z(Uri uri) {
        this.y(uri);
    }
}

