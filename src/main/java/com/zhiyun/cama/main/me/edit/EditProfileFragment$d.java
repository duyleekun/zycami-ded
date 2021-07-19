/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.main.me.edit;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle$State;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.main.me.edit.EditProfileFragment;
import d.v.a.f.b.a;
import d.v.c.x1.l;
import d.v.f.i.g;

public class EditProfileFragment$d
extends a {
    public final /* synthetic */ EditProfileFragment a;

    public EditProfileFragment$d(EditProfileFragment editProfileFragment) {
        this.a = editProfileFragment;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.a;
        ((EditProfileFragment)object).q();
        int n11 = 10081;
        if (n10 != n11) {
            n11 = 10180;
            if (n10 != n11) {
                n11 = 10184;
                if (n10 != n11) {
                    object = this.a;
                    n10 = 2131952559;
                    String string3 = g.s((Fragment)object, n10);
                    EditProfileFragment.k((EditProfileFragment)object, string3);
                }
            } else {
                object = this.a;
                EditProfileFragment.k((EditProfileFragment)object, string2);
            }
        } else {
            object = this.a;
            EditProfileFragment.l((EditProfileFragment)object);
        }
    }

    public void onSuccess(UserInfo object) {
        this.a.q();
        object = this.a;
        Object object2 = ((Fragment)object).requireContext();
        int n10 = 2131952560;
        object2 = g.m(object2, n10);
        EditProfileFragment.k((EditProfileFragment)object, (String)object2);
        object = this.a.getLifecycle().getCurrentState();
        object2 = Lifecycle$State.RESUMED;
        boolean bl2 = ((Lifecycle$State)((Object)object)).isAtLeast((Lifecycle$State)((Object)object2));
        if (bl2) {
            object = this.a;
            l.h((Fragment)object);
        }
    }
}

