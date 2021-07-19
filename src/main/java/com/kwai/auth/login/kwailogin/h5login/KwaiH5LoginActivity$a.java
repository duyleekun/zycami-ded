/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.view.View;
import com.kwai.auth.common.InternalResponse;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity;
import d.l.a.c;

public class KwaiH5LoginActivity$a
implements View.OnClickListener {
    public final /* synthetic */ KwaiH5LoginActivity a;

    public KwaiH5LoginActivity$a(KwaiH5LoginActivity kwaiH5LoginActivity) {
        this.a = kwaiH5LoginActivity;
    }

    public void onClick(View object) {
        object = c.f();
        InternalResponse internalResponse = KwaiH5LoginActivity.a(this.a);
        KwaiH5LoginActivity kwaiH5LoginActivity = this.a;
        ((c)object).h(internalResponse, kwaiH5LoginActivity);
    }
}

