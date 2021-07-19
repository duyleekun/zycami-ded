/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunCallback;
import d.v.a.f.b.a;
import d.v.c.v0.u.v;

public class v$i
implements AliyunManager$OnAliyunCallback {
    public final /* synthetic */ UserInfo a;
    public final /* synthetic */ a b;
    public final /* synthetic */ v c;

    public v$i(v v10, UserInfo userInfo, a a10) {
        this.c = v10;
        this.a = userInfo;
        this.b = a10;
    }

    public void onFailed(ClientException object, ServiceException serviceException) {
        object = this.b;
        if (object != null) {
            int n10 = -1;
            String string2 = "";
            object.onError(null, n10, string2);
        }
    }

    public void onProgress(int n10) {
    }

    public void onSuccess(String object) {
        this.a.setAvatar((String)object);
        object = this.a;
        a a10 = this.b;
        AccountManager.updateUserDetail((UserInfo)object, a10);
    }
}

