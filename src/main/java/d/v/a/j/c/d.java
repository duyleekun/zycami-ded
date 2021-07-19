/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.a.j.c;

import android.view.View;
import com.zhiyun.account.set.privacy.BindSuccessFragment;
import d.v.g0.i$c;

public final class d
implements i$c {
    public final /* synthetic */ BindSuccessFragment a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ View c;

    public /* synthetic */ d(BindSuccessFragment bindSuccessFragment, boolean bl2, View view) {
        this.a = bindSuccessFragment;
        this.b = bl2;
        this.c = view;
    }

    public final void a(int n10) {
        BindSuccessFragment bindSuccessFragment = this.a;
        boolean bl2 = this.b;
        View view = this.c;
        bindSuccessFragment.t(bl2, view, n10);
    }
}

