/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.data.me.remote.UpdateManager$OnUpdateVersionCallback;
import d.v.c.i1.r2;
import d.v.e.i.j;

public class r2$a
implements UpdateManager$OnUpdateVersionCallback {
    public final /* synthetic */ r2 a;

    public r2$a(r2 r22) {
        this.a = r22;
    }

    public void onError() {
    }

    public void onVersionInfo(VersionInfo versionInfo) {
        j j10 = this.a.f;
        boolean bl2 = j10.hasActiveObservers();
        if (bl2 && versionInfo != null && (bl2 = versionInfo.isValid())) {
            j10 = this.a.f;
            j10.setValue(versionInfo);
        }
    }
}

