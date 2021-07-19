/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.main.me.MeFragment;

public final class i
implements Observer {
    public final /* synthetic */ MeFragment a;

    public /* synthetic */ i(MeFragment meFragment) {
        this.a = meFragment;
    }

    public final void onChanged(Object object) {
        MeFragment meFragment = this.a;
        object = (PublishWorks)object;
        meFragment.H((PublishWorks)object);
    }
}

