/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.provider.MediaStore$Images$Media
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.zhiyun.cama.me.help.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView$a;
import com.zhiyun.cama.me.help.view.AddImageRecyclerView$b;
import com.zhiyun.permission.Permission;
import d.v.c.j1.a.q0.a;
import d.v.c.n0.c;
import d.v.e.h.d;
import d.v.e.l.o1;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.g0.i;
import d.v.g0.i$c;
import d.v.g0.o;
import d.v.x.b;
import d.v.x.c$b;
import java.util.ArrayList;
import java.util.List;

public class AddImageRecyclerView
extends RecyclerView {
    public static final int e = 10001;
    private AddImageRecyclerView$b a;
    private final AddImageRecyclerView$a b;
    private final List c;
    private Fragment d;

    public AddImageRecyclerView(Context context) {
        this(context, null);
    }

    public AddImageRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AddImageRecyclerView(Context object, AttributeSet object2, int n10) {
        super((Context)object, (AttributeSet)object2, n10);
        super();
        this.b = object;
        super();
        this.c = object2;
        this.d = null;
        ((c)object).d((List)object2);
        Context context = this.getContext();
        super(context, 3);
        this.setLayoutManager((RecyclerView$LayoutManager)object2);
        this.setAdapter((RecyclerView$Adapter)object);
        super(this);
        ((AddImageRecyclerView$a)object).i((View.OnClickListener)object2);
        super(this);
        ((AddImageRecyclerView$a)object).j((d.v.f.f.b)object2);
    }

    private /* synthetic */ void a(View view) {
        this.j();
    }

    private /* synthetic */ void c(View object, int n10, Integer n11) {
        object = this.c;
        Integer n12 = n10;
        n10 = d.v.e.h.d.c(n12);
        object.remove(n10);
        this.b.notifyDataSetChanged();
        object = this.a;
        if (object != null) {
            object.a();
        }
    }

    private /* synthetic */ void e() {
        Fragment fragment = this.d;
        this.k(fragment);
    }

    private /* synthetic */ void g(Fragment fragment, int n10) {
        String string2;
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String string3 = "android.intent.action.PICK";
        Intent intent = new Intent(string3, uri);
        if (n10 == 0) {
            string2 = "image/*";
            intent.setType(string2);
        } else {
            int n11 = 1;
            if (n11 == n10) {
                string2 = "video/*";
                intent.setType(string2);
            }
        }
        string2 = this.getContext().getPackageManager();
        string2 = intent.resolveActivity((PackageManager)string2);
        if (string2 != null) {
            n10 = 10001;
            fragment.startActivityForResult(intent, n10);
        }
    }

    private void k(Fragment object) {
        Object object2 = new ArrayList();
        int n10 = o1.a(this.getContext(), 2131099739);
        String string2 = g.m(this.getContext(), 2131952304);
        o o10 = new o(string2, n10);
        object2.add(o10);
        string2 = g.m(this.getContext(), 2131952928);
        o10 = new o(string2, n10);
        object2.add(o10);
        object2 = i.w(false).B((List)object2);
        Object object3 = new a(this, (Fragment)object);
        object2 = ((i)object2).D((i$c)object3);
        object = ((Fragment)object).getChildFragmentManager();
        object3 = i.class.getName();
        ((DialogFragment)object2).show((FragmentManager)object, (String)object3);
    }

    public /* synthetic */ void b(View view) {
        this.a(view);
    }

    public /* synthetic */ void d(View view, int n10, Integer n11) {
        this.c(view, n10, n11);
    }

    public /* synthetic */ void f() {
        this.e();
    }

    public List getImages() {
        return this.c;
    }

    public /* synthetic */ void h(Fragment fragment, int n10) {
        this.g(fragment, n10);
    }

    public String i(int n10, int n11, Intent intent) {
        Object object;
        int n12 = -1;
        if (n12 == n11 && (n11 = 10001) == n10 && intent != null && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object = intent.getData().toString())) ? 1 : 0)) == 0) {
            long l10;
            long l11 = s1.x((String)object);
            long l12 = l11 - (l10 = 0x3200000L);
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 > 0) {
                return g.q((View)this, 2131952273);
            }
            List list = this.c;
            list.add(object);
            this.b.notifyDataSetChanged();
            object = this.a;
            if (object != null) {
                object.a();
            }
        }
        return null;
    }

    public void j() {
        Object object = this.d;
        if (object != null) {
            Object object2 = Permission.STORAGE;
            object = new c$b((Permission)((Object)object2));
            object2 = new d.v.c.j1.a.q0.b(this);
            object = ((c$b)object).a((b)object2);
            object2 = this.d.getChildFragmentManager();
            ((c$b)object).b((FragmentManager)object2);
        }
    }

    public void setFragment(Fragment fragment) {
        this.d = fragment;
    }

    public void setImages(List object) {
        this.c.clear();
        this.c.addAll(object);
        object = this.b;
        List list = this.c;
        ((c)object).d(list);
        object = this.a;
        if (object != null) {
            object.a();
        }
    }

    public void setOnImageChangedListener(AddImageRecyclerView$b addImageRecyclerView$b) {
        this.a = addImageRecyclerView$b;
    }
}

