/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.fragment.app.FragmentActivity;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiLoginCallback;
import com.zhiyun.cama.data.me.remote.data.KwaiTokenInfo;
import d.v.c.s0.d7.u;
import d.v.n.l.d;

public class u$c
implements KWaiManager$OnKWaiLoginCallback {
    public final /* synthetic */ u a;

    public u$c(u u10) {
        this.a = u10;
    }

    public void onFailed(String string2) {
        d d10 = d.i();
        FragmentActivity fragmentActivity = u.a(this.a).requireActivity();
        d10.j(fragmentActivity, string2);
    }

    public void onSuccess(KwaiTokenInfo kwaiTokenInfo) {
        d d10 = d.i();
        String string2 = kwaiTokenInfo.getOpen_id();
        String string3 = kwaiTokenInfo.getAccess_token();
        int n10 = kwaiTokenInfo.getExpires_in();
        d10.k(string2, string3, n10);
    }
}

