/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.mediacontent.media;

import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ObservableArrayList;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.k1.a.v;
import d.v.c.k1.a.w;
import d.v.f.d.b;
import d.v.h.e.a;
import java.util.ArrayList;
import java.util.List;

public class AddVideoFragment$b {
    public final /* synthetic */ AddVideoFragment a;

    public AddVideoFragment$b(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public void a(View object) {
        int n10;
        object = this.a;
        int n11 = AddVideoFragment.y((AddVideoFragment)object);
        if (n11 == (n10 = 5)) {
            NavHostFragment.findNavController(this.a).popBackStack();
            return;
        }
        ActivityCompat.finishAfterTransition(this.a.requireActivity());
    }

    public void b(MediaType object) {
        Object object2 = AddVideoFragment.x(this.a).x();
        if (object2 == object) {
            return;
        }
        AddVideoFragment.A(this.a).L();
        AddVideoFragment.x(this.a).F((MediaType)((Object)object));
        object2 = AddVideoFragment.B(this.a);
        w w10 = AddVideoFragment.A(this.a);
        object = w10.z((MediaType)((Object)object));
        ((b)object2).l((List)object);
        object = AddVideoFragment.B(this.a).d();
        boolean bl2 = ((ArrayList)object).isEmpty();
        if (bl2) {
            object = AddVideoFragment.x((AddVideoFragment)this.a).k;
            ((StatusView)((Object)object)).c();
        } else {
            AddVideoFragment.x((AddVideoFragment)this.a).k.a();
            object = AddVideoFragment.B(this.a);
            ((RecyclerView$Adapter)object).notifyDataSetChanged();
        }
    }

    public void c(View view) {
        this.a.F();
    }

    public void d(int n10) {
        a a10 = (a)AddVideoFragment.z(this.a).d().get(n10);
        AddVideoFragment.z(this.a).d().remove(n10);
        ObservableArrayList observableArrayList = AddVideoFragment.z(this.a).d();
        a10 = a10.c();
        String string2 = "";
        a10 = a10.l(string2).p(string2);
        observableArrayList.add(n10, a10);
        AddVideoFragment.z(this.a).notifyDataSetChanged();
    }

    public void e(boolean n10, int n11, a object) {
        Object object2;
        Object object3;
        if (n10 == 0) {
            object3 = AddVideoFragment.z(this.a).d();
            ((ObservableArrayList)object3).set(n11, object);
        } else {
            object3 = AddVideoFragment.A(this.a);
            object = AddVideoFragment.x((AddVideoFragment)this.a).g;
            v v10 = AddVideoFragment.z(this.a);
            ((w)object3).K((RecyclerView)object, v10, n11);
        }
        object3 = this.a;
        n10 = AddVideoFragment.y((AddVideoFragment)object3);
        n11 = 1;
        if (n10 == n11 && (n10 = ((w)(object3 = AddVideoFragment.A(this.a))).n((List)(object2 = AddVideoFragment.z(this.a).d()))) != (n11 = -1)) {
            object2 = AddVideoFragment.z(this.a);
            ((v)object2).q(n10);
        }
        object3 = AddVideoFragment.A(this.a);
        object2 = AddVideoFragment.z(this.a).d();
        ((w)object3).r((List)object2);
        AddVideoFragment.A(this.a).l();
    }
}

