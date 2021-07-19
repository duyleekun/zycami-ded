/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$id;
import com.zhiyun.account.set.privacy.BindSuccessFragment;
import d.v.a.k.a;

public class BindSuccessFragment$a {
    public final /* synthetic */ BindSuccessFragment a;

    public BindSuccessFragment$a(BindSuccessFragment bindSuccessFragment) {
        this.a = bindSuccessFragment;
    }

    public void a(View view) {
        d.v.a.k.a.g(view);
    }

    public void b(View view) {
        int n10;
        Object object = BindSuccessFragment.j((BindSuccessFragment)this.a).g;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
        object = this.a;
        int n11 = BindSuccessFragment.k((BindSuccessFragment)object);
        if (n11 != 0 && n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 == n10) {
                    object = this.a;
                    n10 = 0;
                    bl2 = null;
                    BindSuccessFragment.l((BindSuccessFragment)object, view, false);
                }
            } else {
                n11 = R$id.bindChangeFirstFragment;
                d.v.a.k.a.a(view, n11);
            }
        } else {
            n11 = R$id.bindNormalFragment;
            d.v.a.k.a.a(view, n11);
        }
    }

    public void c(View view) {
        block3: {
            block1: {
                block2: {
                    Object object = BindSuccessFragment.j((BindSuccessFragment)this.a).g;
                    Boolean bl3 = Boolean.TRUE;
                    ((MutableLiveData)object).setValue(bl3);
                    object = this.a;
                    boolean bl2 = BindSuccessFragment.k((BindSuccessFragment)object);
                    if (!bl2) break block1;
                    boolean bl4 = true;
                    if (bl2 == bl4) break block2;
                    boolean bl5 = 2 != 0;
                    if (bl2 == bl5) break block1;
                    boolean bl6 = 3 != 0;
                    if (bl2 == bl6) {
                        object = this.a;
                        BindSuccessFragment.l((BindSuccessFragment)object, view, bl4);
                    }
                    break block3;
                }
                int n10 = R$id.bindChangeFirstFragment;
                d.v.a.k.a.a(view, n10);
                break block3;
            }
            int n11 = R$id.bindNormalFragment;
            d.v.a.k.a.a(view, n11);
        }
    }
}

