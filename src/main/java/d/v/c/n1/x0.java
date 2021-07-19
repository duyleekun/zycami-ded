/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.PublishFragment;

public final class x0
implements Observer {
    public static final /* synthetic */ x0 a;

    static {
        x0 x02;
        a = x02 = new x0();
    }

    public final void onChanged(Object object) {
        PublishFragment.l0((Exception)object);
    }
}

