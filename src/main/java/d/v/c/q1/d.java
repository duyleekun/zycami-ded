/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.set.SetAboutFragment;

public final class d
implements Observer {
    public final /* synthetic */ SetAboutFragment a;

    public /* synthetic */ d(SetAboutFragment setAboutFragment) {
        this.a = setAboutFragment;
    }

    public final void onChanged(Object object) {
        SetAboutFragment setAboutFragment = this.a;
        object = (VersionInfo)object;
        SetAboutFragment.p(setAboutFragment, (VersionInfo)object);
    }
}

