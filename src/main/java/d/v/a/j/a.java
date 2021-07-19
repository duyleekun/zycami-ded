/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j;

import androidx.lifecycle.Observer;
import com.zhiyun.account.set.ModifyPassActivity;

public final class a
implements Observer {
    public final /* synthetic */ ModifyPassActivity a;

    public /* synthetic */ a(ModifyPassActivity modifyPassActivity) {
        this.a = modifyPassActivity;
    }

    public final void onChanged(Object object) {
        ModifyPassActivity modifyPassActivity = this.a;
        object = (Integer)object;
        modifyPassActivity.i((Integer)object);
    }
}

