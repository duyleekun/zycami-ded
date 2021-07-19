/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.geetest.sdk;

import android.text.TextUtils;
import com.geetest.sdk.al;
import com.geetest.sdk.ao$a;
import java.io.File;

public abstract class ao
implements Runnable {
    private al a;
    private ao$a b;

    public void a() {
        ao$a ao$a = this.b;
        if (ao$a != null) {
            int n10 = 10002;
            ao$a.a(n10);
        }
    }

    public void a(al al2) {
        this.a = al2;
    }

    public abstract void a(File var1);

    public void run() {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((al)object).b)))) {
            object = this.a.c;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                this.a();
                return;
            }
            String string2 = this.a.c;
            object = new File(string2);
            this.a((File)object);
            return;
        }
        this.a();
    }

    public void setCallBackListener(ao$a ao$a) {
        this.b = ao$a;
    }
}

