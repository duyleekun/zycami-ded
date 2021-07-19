/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.main.me.WebViewFragment;

public final class e0
implements Observer {
    public final /* synthetic */ WebViewFragment a;

    public /* synthetic */ e0(WebViewFragment webViewFragment) {
        this.a = webViewFragment;
    }

    public final void onChanged(Object object) {
        WebViewFragment webViewFragment = this.a;
        object = (UserInfo)object;
        webViewFragment.C((UserInfo)object);
    }
}

