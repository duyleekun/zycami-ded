/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.account.set.privacy.BindSuccessFragment;
import d.v.f.f.a;

public final class e
implements a {
    public final /* synthetic */ BindSuccessFragment a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ e(BindSuccessFragment bindSuccessFragment, boolean bl2) {
        this.a = bindSuccessFragment;
        this.b = bl2;
    }

    public final void a(DialogFragment dialogFragment) {
        BindSuccessFragment bindSuccessFragment = this.a;
        boolean bl2 = this.b;
        bindSuccessFragment.w(bl2, dialogFragment);
    }
}

