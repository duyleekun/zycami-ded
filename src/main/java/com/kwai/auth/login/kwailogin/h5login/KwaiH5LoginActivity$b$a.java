/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.app.Activity;
import android.content.Intent;
import com.kwai.auth.login.kwailogin.h5login.H5LoginResponse;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity$b;
import d.l.a.c;

public class KwaiH5LoginActivity$b$a
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ KwaiH5LoginActivity$b b;

    public KwaiH5LoginActivity$b$a(KwaiH5LoginActivity$b b10, String string2) {
        this.b = b10;
        this.a = string2;
    }

    public void run() {
        Object object = new Intent();
        Object object2 = this.a;
        object.putExtra("result", (String)object2);
        object2 = KwaiH5LoginActivity.c(this.b.a);
        object.putExtra("state", (String)object2);
        object2 = c.f();
        H5LoginResponse h5LoginResponse = new H5LoginResponse((Intent)object);
        object = this.b.a;
        ((c)object2).h(h5LoginResponse, (Activity)object);
    }
}

