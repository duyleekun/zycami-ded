/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.device.active.ActivationPrepareFragment;

public final class e
implements Observer {
    public final /* synthetic */ ActivationPrepareFragment a;

    public /* synthetic */ e(ActivationPrepareFragment activationPrepareFragment) {
        this.a = activationPrepareFragment;
    }

    public final void onChanged(Object object) {
        ActivationPrepareFragment activationPrepareFragment = this.a;
        object = (UserInfo)object;
        activationPrepareFragment.A((UserInfo)object);
    }
}

