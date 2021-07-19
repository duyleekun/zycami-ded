/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.main.MainFragment;

public final class v1
implements Observer {
    public final /* synthetic */ MainFragment a;

    public /* synthetic */ v1(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public final void onChanged(Object object) {
        MainFragment mainFragment = this.a;
        object = (VersionInfo)object;
        mainFragment.B((VersionInfo)object);
    }
}

