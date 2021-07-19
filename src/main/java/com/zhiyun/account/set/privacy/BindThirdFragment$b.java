/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.api.entity.BindThirdEntity;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.set.privacy.BindThirdFragment;
import d.v.a.j.c.h;
import d.v.a.j.c.y;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class BindThirdFragment$b {
    public final /* synthetic */ BindThirdFragment a;

    public BindThirdFragment$b(BindThirdFragment bindThirdFragment) {
        this.a = bindThirdFragment;
    }

    public static /* synthetic */ void c(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void d(ThirdPlatform thirdPlatform, BindThirdEntity bindThirdEntity, DialogFragment object) {
        object = BindThirdFragment.j(this.a);
        Resources resources = this.a.getResources();
        int n10 = bindThirdEntity.id;
        ((y)object).w(resources, thirdPlatform, n10);
    }

    public void a(ThirdPlatform object, BindThirdEntity object2) {
        Object object3 = BindThirdFragment.j(this.a);
        boolean bl2 = ((y)object3).p((BindThirdEntity)object2);
        if (bl2) {
            Object object4 = this.a.getContext();
            object3 = new k$b((Context)object4);
            object4 = this.a.getResources();
            int n10 = R$string.set_remove_bind_confirm;
            int n11 = 1;
            Object[] objectArray = new Object[n11];
            Object object5 = this.a.getResources();
            int n12 = ((ThirdPlatform)((Object)object)).getAppName();
            object5 = g.o(object5, n12);
            objectArray[0] = object5;
            object4 = g.p((Resources)object4, n10, objectArray);
            object3 = (k$b)((k$a)object3).B((String)object4);
            object4 = d.v.a.j.c.g.a;
            object3 = (k$b)((k$a)object3).p((a)object4);
            object4 = new h(this, (ThirdPlatform)((Object)object), (BindThirdEntity)object2);
            object = (k$b)((k$a)object3).w((a)object4);
            object2 = this.a.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        } else {
            object2 = BindThirdFragment.j(this.a);
            object3 = this.a.requireContext();
            ((y)object2).i((Context)object3, (ThirdPlatform)((Object)object));
        }
    }

    public void b(View view) {
        d.v.a.k.a.g(view);
    }

    public /* synthetic */ void e(ThirdPlatform thirdPlatform, BindThirdEntity bindThirdEntity, DialogFragment dialogFragment) {
        this.d(thirdPlatform, bindThirdEntity, dialogFragment);
    }
}

