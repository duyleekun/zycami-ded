/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.dialog;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel;
import com.zhiyun.cama.prime.dialog.PrimeGetDialogViewModel$PRIME_STATUS;
import com.zhiyun.cama.prime.model.ActivatePrimeInfo;
import com.zhiyun.cama.prime.model.PrimeInfo;
import d.v.a.f.b.a;
import d.v.a.f.c.b;

public class PrimeGetDialogViewModel$a
extends a {
    public final /* synthetic */ PrimeGetDialogViewModel a;

    public PrimeGetDialogViewModel$a(PrimeGetDialogViewModel primeGetDialogViewModel) {
        this.a = primeGetDialogViewModel;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = PrimeGetDialogViewModel.c(this.a);
        PrimeGetDialogViewModel$PRIME_STATUS primeGetDialogViewModel$PRIME_STATUS = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_FAIL;
        ((MutableLiveData)object).setValue((Object)primeGetDialogViewModel$PRIME_STATUS);
    }

    public void onSuccess(ActivatePrimeInfo object) {
        Object object2 = PrimeGetDialogViewModel.b(this.a);
        object2.setValue(object);
        int n10 = b.N().i().getId();
        object = PrimeManager.getLocalPrimeInfo(n10);
        if (object != null) {
            object2 = null;
            ((PrimeInfo)object).setIsShowDialog(false);
            PrimeManager.savePrimeInfo((PrimeInfo)object);
        }
        object = PrimeGetDialogViewModel.c(this.a);
        object2 = PrimeGetDialogViewModel$PRIME_STATUS.PRIME_STATUS_SUCCESS;
        ((MutableLiveData)object).setValue(object2);
    }
}

