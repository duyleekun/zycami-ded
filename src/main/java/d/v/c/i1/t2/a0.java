/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.me.WebViewFragment;

public final class a0
implements Observer {
    public final /* synthetic */ WebViewFragment a;

    public /* synthetic */ a0(WebViewFragment webViewFragment) {
        this.a = webViewFragment;
    }

    public final void onChanged(Object object) {
        WebViewFragment webViewFragment = this.a;
        object = (Boolean)object;
        webViewFragment.Y((Boolean)object);
    }
}

