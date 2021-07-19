/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.f.c;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.c.b;

public final class a
implements Observer {
    public final /* synthetic */ MediatorLiveData a;
    public final /* synthetic */ MediatorLiveData b;

    public /* synthetic */ a(MediatorLiveData mediatorLiveData, MediatorLiveData mediatorLiveData2) {
        this.a = mediatorLiveData;
        this.b = mediatorLiveData2;
    }

    public final void onChanged(Object object) {
        MediatorLiveData mediatorLiveData = this.a;
        MediatorLiveData mediatorLiveData2 = this.b;
        object = (UserInfo)object;
        d.v.a.f.c.b.Q(mediatorLiveData, mediatorLiveData2, (UserInfo)object);
    }
}

