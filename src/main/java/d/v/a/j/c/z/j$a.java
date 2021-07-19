/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c.z;

import androidx.fragment.app.Fragment;
import com.zhiyun.account.R$string;
import d.v.a.i.a.y0.d$b;
import d.v.a.j.c.z.j;

public class j$a
implements d$b {
    public final /* synthetic */ j a;

    public j$a(j j10) {
        this.a = j10;
    }

    public void a(String string2, String string3, String string4) {
        j.j(this.a, string2, string3, string4);
    }

    public void onFailed(String object) {
        object = j.k((j)this.a).q;
        Object object2 = this.a;
        int n10 = R$string.me_code_send_failed;
        object2 = ((Fragment)object2).getString(n10);
        ((d.v.e.i.j)object).setValue(object2);
    }
}

