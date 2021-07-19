/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p0.o;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.zhiyun.net.Punish;
import d.v.c.p0.o.f;

public final class a
implements d.v.f.f.a {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ Punish b;

    public /* synthetic */ a(FragmentActivity fragmentActivity, Punish punish) {
        this.a = fragmentActivity;
        this.b = punish;
    }

    public final void a(DialogFragment dialogFragment) {
        FragmentActivity fragmentActivity = this.a;
        Punish punish = this.b;
        f.b(fragmentActivity, punish, dialogFragment);
    }
}

