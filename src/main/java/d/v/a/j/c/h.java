/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.account.data.api.entity.BindThirdEntity;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.set.privacy.BindThirdFragment$b;
import d.v.f.f.a;

public final class h
implements a {
    public final /* synthetic */ BindThirdFragment$b a;
    public final /* synthetic */ ThirdPlatform b;
    public final /* synthetic */ BindThirdEntity c;

    public /* synthetic */ h(BindThirdFragment$b bindThirdFragment$b, ThirdPlatform thirdPlatform, BindThirdEntity bindThirdEntity) {
        this.a = bindThirdFragment$b;
        this.b = thirdPlatform;
        this.c = bindThirdEntity;
    }

    public final void a(DialogFragment dialogFragment) {
        BindThirdFragment$b bindThirdFragment$b = this.a;
        ThirdPlatform thirdPlatform = this.b;
        BindThirdEntity bindThirdEntity = this.c;
        bindThirdFragment$b.e(thirdPlatform, bindThirdEntity, dialogFragment);
    }
}

