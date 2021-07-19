/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.app.Activity;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.set.privacy.ChooseModifyPassFragment;
import d.v.a.k.a;

public class ChooseModifyPassFragment$a {
    public final /* synthetic */ ChooseModifyPassFragment a;

    public ChooseModifyPassFragment$a(ChooseModifyPassFragment chooseModifyPassFragment) {
        this.a = chooseModifyPassFragment;
    }

    public void a(View object) {
        boolean bl2 = d.v.a.k.a.g(object);
        if (!bl2) {
            object = this.a.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    public void b(View view) {
        MutableLiveData mutableLiveData = ChooseModifyPassFragment.j((ChooseModifyPassFragment)this.a).g;
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.setValue(bl2);
        int n10 = R$id.modifyPassFragment;
        d.v.a.k.a.a(view, n10);
    }

    public void c(View view) {
        MutableLiveData mutableLiveData = ChooseModifyPassFragment.j((ChooseModifyPassFragment)this.a).g;
        Boolean bl2 = Boolean.TRUE;
        mutableLiveData.setValue(bl2);
        int n10 = R$id.modifyPassFragment;
        d.v.a.k.a.a(view, n10);
    }
}

