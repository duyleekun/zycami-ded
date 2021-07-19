/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;
import com.sina.weibo.sdk.web.b.b$a;

public abstract class b {
    public WebData aH;
    public String aI;
    public Context ae;

    public b() {
    }

    public b(AuthInfo object, int n10, String string2, String string3) {
        WebData webData;
        this.aH = webData = new WebData((AuthInfo)object, n10, string2, string3);
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object).append(l10);
        this.aI = object = ((StringBuilder)object).toString();
    }

    public abstract void a(Bundle var1);

    public void a(b$a b$a) {
    }

    public abstract void b(Bundle var1);

    public abstract String getUrl();

    public final void readFromBundle(Bundle bundle) {
        Object object = (WebData)bundle.getParcelable("web_data");
        this.aH = object;
        this.aI = object = bundle.getString("_weibo_transaction");
        this.b(bundle);
    }

    public final void setContext(Context context) {
        this.ae = context;
    }

    public boolean w() {
        return false;
    }

    public final Bundle writeToBundle(Bundle bundle) {
        Object object = this.aH;
        String string2 = "web_data";
        bundle.putParcelable(string2, (Parcelable)object);
        object = this.aH;
        int n10 = ((WebData)object).getType();
        int n11 = 1;
        String string3 = "web_type";
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 == n11) {
                    bundle.putInt(string3, n11);
                }
            } else {
                bundle.putInt(string3, n11);
            }
        } else {
            bundle.putInt(string3, n11);
        }
        object = this.aI;
        bundle.putString("_weibo_transaction", (String)object);
        this.a(bundle);
        return bundle;
    }

    public final WebData x() {
        return this.aH;
    }
}

