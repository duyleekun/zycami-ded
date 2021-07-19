/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.set.SetAboutFragment;
import d.v.f.f.a;

public final class e
implements a {
    public final /* synthetic */ SetAboutFragment a;
    public final /* synthetic */ VersionInfo b;

    public /* synthetic */ e(SetAboutFragment setAboutFragment, VersionInfo versionInfo) {
        this.a = setAboutFragment;
        this.b = versionInfo;
    }

    public final void a(DialogFragment dialogFragment) {
        SetAboutFragment setAboutFragment = this.a;
        VersionInfo versionInfo = this.b;
        setAboutFragment.r(versionInfo, dialogFragment);
    }
}

