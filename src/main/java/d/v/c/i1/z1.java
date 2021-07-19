/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.MainFragment;

public final class z1
implements Observer {
    public final /* synthetic */ MainFragment a;

    public /* synthetic */ z1(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public final void onChanged(Object object) {
        MainFragment mainFragment = this.a;
        object = (Boolean)object;
        mainFragment.D((Boolean)object);
    }
}

