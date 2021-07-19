/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spanned
 */
package com.zhiyun.cama.publish;

import android.text.InputFilter;
import android.text.Spanned;
import com.zhiyun.cama.publish.PublishFragment;
import d.v.c.n1.j2;
import d.v.f.i.g;

public class PublishFragment$g
implements InputFilter {
    private int a;
    public final /* synthetic */ PublishFragment b;

    public PublishFragment$g(PublishFragment publishFragment, int n10) {
        this.b = publishFragment;
        this.a = n10;
    }

    public CharSequence filter(CharSequence charSequence, int n10, int n11, Spanned object, int n12, int n13) {
        int n14 = this.a;
        int n15 = object.length();
        if ((n14 -= (n15 -= (n13 -= n12))) < (n11 -= n10)) {
            object = PublishFragment.v(this.b);
            Object object2 = this.b.requireContext();
            n13 = 2131952795;
            object2 = g.m(object2, n13);
            ((j2)object).t0((String)object2);
        }
        if (n14 <= 0) {
            return "";
        }
        if (n14 >= n11) {
            return null;
        }
        return charSequence.subSequence(n10, n14 += n10);
    }
}

