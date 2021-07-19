/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.main.MainFragment;

public final class x1
implements Observer {
    public final /* synthetic */ MainFragment a;

    public /* synthetic */ x1(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public final void onChanged(Object object) {
        MainFragment mainFragment = this.a;
        object = (PublishWorks)object;
        mainFragment.z((PublishWorks)object);
    }
}

