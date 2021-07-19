/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a.v0;

import androidx.fragment.app.Fragment;
import com.zhiyun.account.R$string;
import d.v.a.i.a.v0.m;
import d.v.a.i.a.y0.d$b;
import d.v.e.i.j;

public class m$a
implements d$b {
    public final /* synthetic */ m a;

    public m$a(m m10) {
        this.a = m10;
    }

    public void a(String string2, String string3, String string4) {
        m.j(this.a, string2, string3, string4);
    }

    public void onFailed(String object) {
        object = m.k((m)this.a).x;
        Object object2 = this.a;
        int n10 = R$string.me_code_send_failed;
        object2 = ((Fragment)object2).getString(n10);
        ((j)object).setValue(object2);
    }
}

