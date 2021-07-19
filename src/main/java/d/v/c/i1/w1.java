/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.main.MainFragment;

public final class w1
implements Observer {
    public final /* synthetic */ MainFragment a;

    public /* synthetic */ w1(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public final void onChanged(Object object) {
        MainFragment mainFragment = this.a;
        object = (UserInfo)object;
        mainFragment.x((UserInfo)object);
    }
}

