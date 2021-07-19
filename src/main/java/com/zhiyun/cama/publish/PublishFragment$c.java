/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Address
 *  android.location.Geocoder
 *  android.text.TextUtils
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.text.TextUtils;
import com.zhiyun.cama.publish.PublishFragment;
import d.v.c.n1.a0;
import d.v.c.n1.z;
import d.v.e.l.c1;
import d.v.p.a$c;
import java.util.concurrent.Executor;

public class PublishFragment$c
implements a$c {
    public final /* synthetic */ PublishFragment a;

    public PublishFragment$c(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    private /* synthetic */ void c(String string2, String string3) {
        PublishFragment.D(this.a, string2, string3);
    }

    private /* synthetic */ void e(double d10, double d11) {
        Object object;
        Object object2;
        Object object3;
        CharSequence charSequence;
        block19: {
            boolean bl2;
            block18: {
                charSequence = new StringBuilder();
                charSequence.append(d10);
                charSequence.append(",");
                charSequence.append(d11);
                charSequence = charSequence.toString();
                object3 = "";
                PublishFragment publishFragment = this.a;
                publishFragment = publishFragment.getContext();
                Geocoder geocoder = new Geocoder((Context)publishFragment);
                int n10 = 1;
                object2 = geocoder.getFromLocation(d10, d11, n10);
                bl2 = false;
                object = null;
                object2 = object2.get(0);
                object2 = (Address)object2;
                object = object2.getCountryName();
                object2 = object2.getLocality();
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                if (bl3) break block18;
                object3 = object;
            }
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) break block19;
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object3);
            String string2 = " \u00b7 ";
            ((StringBuilder)object).append(string2);
            try {
                ((StringBuilder)object).append((String)object2);
                object3 = ((StringBuilder)object).toString();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        PublishFragment.C(this.a);
        object2 = this.a.getActivity();
        if (object2 == null) {
            return;
        }
        object2 = this.a.getActivity();
        object = new a0(this, (String)charSequence, (String)object3);
        object2.runOnUiThread((Runnable)object);
    }

    public void a() {
        PublishFragment.C(this.a);
        PublishFragment.B(this.a);
    }

    public void b(double d10, double d11) {
        Executor executor = c1.b().e();
        z z10 = new z(this, d11, d10);
        executor.execute(z10);
    }

    public /* synthetic */ void d(String string2, String string3) {
        this.c(string2, string3);
    }

    public /* synthetic */ void f(double d10, double d11) {
        this.e(d10, d11);
    }
}

