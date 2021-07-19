/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.help.FeedbackEditAddFragment;

public final class p
implements Observer {
    public static final /* synthetic */ p a;

    static {
        p p10;
        a = p10 = new p();
    }

    public final void onChanged(Object object) {
        FeedbackEditAddFragment.u((Boolean)object);
    }
}

