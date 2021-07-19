/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j;

import androidx.lifecycle.Observer;
import com.zhiyun.account.set.PrivateBindActivity;

public final class b
implements Observer {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final void onChanged(Object object) {
        PrivateBindActivity.f((Integer)object);
    }
}

