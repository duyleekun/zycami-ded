/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package com.zhiyun.cama.template.edit;

import android.app.Activity;
import android.view.View;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;
import d.v.c.u1.m.b1;
import d.v.c.u1.m.c1;
import d.v.c.u1.m.v;
import d.v.e.i.h;
import d.v.f.f.d;
import d.v.h.e.a;

public class EditorTemplateEditActivity$e
implements d.v.c.q0.f.a {
    public final /* synthetic */ EditorTemplateEditActivity a;

    public EditorTemplateEditActivity$e(EditorTemplateEditActivity editorTemplateEditActivity) {
        this.a = editorTemplateEditActivity;
    }

    private /* synthetic */ void c(int n10, View object) {
        if (n10 >= 0) {
            object = this.a;
            int n11 = 2131362359;
            object = Navigation.findNavController((Activity)object, n11);
            ((NavController)object).navigate(n10);
        } else {
            int n12 = -1;
            if (n10 == n12) {
                EditorTemplateEditActivity.k(this.a).y0();
                n10 = 1;
                EditorTemplateListFragment editorTemplateListFragment = EditorTemplateListFragment.Q(n10);
                object = this.a;
                editorTemplateListFragment.S((c1)object);
                object = this.a.getSupportFragmentManager();
                editorTemplateListFragment.q((FragmentManager)object);
            }
        }
    }

    public void a(View object) {
        int n10;
        object = this.a;
        int n11 = EditorTemplateEditActivity.n((EditorTemplateEditActivity)object);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        EditorTemplateEditActivity.m((EditorTemplateEditActivity)object, n10 != 0, -1);
    }

    public void b(View object) {
        object = EditorTemplateEditActivity.k(this.a);
        int n10 = ((TemplateEditViewModel)object).c0();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                object = EditorTemplateEditActivity.k(this.a).d0();
                n11 = -1;
                Integer n12 = n11;
                h.g((MutableLiveData)object, n12);
            }
        } else {
            object = this.a;
            n10 = (int)(EditorTemplateEditActivity.o((EditorTemplateEditActivity)object) ? 1 : 0);
            if (n10 == 0) {
                return;
            }
            object = this.a;
            ((EditorTemplateEditActivity)object).r();
        }
    }

    public /* synthetic */ void d(int n10, View view) {
        this.c(n10, view);
    }

    public d e(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n10 = -2;
                } else {
                    NavDirections navDirections = b1.a();
                    n10 = navDirections.getActionId();
                }
            } else {
                NavDirections navDirections = b1.b();
                n10 = navDirections.getActionId();
            }
        } else {
            n10 = -1;
        }
        v v10 = new v(this, n10);
        return v10;
    }

    public void f(RecyclerView recyclerView, long l10) {
        EditorTemplateEditActivity.k(this.a).s(l10);
    }

    public void g(int n10) {
        a a10 = (a)EditorTemplateEditActivity.l(this.a).d().get(n10);
        EditorTemplateEditActivity.l(this.a).d().remove(n10);
        ObservableArrayList observableArrayList = EditorTemplateEditActivity.l(this.a).d();
        a10 = a10.c();
        String string2 = "";
        a10 = a10.l(string2).p(string2);
        observableArrayList.add(n10, a10);
    }

    public void h(boolean bl2, int n10, a a10) {
        if (!bl2) {
            ObservableArrayList observableArrayList = EditorTemplateEditActivity.l(this.a).d();
            observableArrayList.set(n10, a10);
        } else {
            EditorTemplateEditActivity editorTemplateEditActivity = this.a;
            boolean bl3 = true;
            EditorTemplateEditActivity.m(editorTemplateEditActivity, bl3, n10);
        }
    }

    public void i(int n10) {
        EditorTemplateEditActivity editorTemplateEditActivity = this.a;
        int n11 = 1;
        EditorAddVideoActivity.q(editorTemplateEditActivity, "autoEditReplace", n11, n11);
    }

    public void j() {
        EditorTemplateEditActivity.j((EditorTemplateEditActivity)this.a).m.animate().translationX(0.0f).start();
        EditorTemplateEditActivity.k(this.a).y();
    }

    public void k() {
        EditorTemplateEditActivity.k(this.a).R0();
    }
}

