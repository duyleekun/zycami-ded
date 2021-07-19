/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.v0.u.c0;

import android.content.Context;
import com.kwai.opensdk.sdk.model.base.BaseResp;
import com.kwai.opensdk.sdk.openapi.IKwaiAPIEventListener;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiCallback;

public final class g
implements IKwaiAPIEventListener {
    public final /* synthetic */ KWaiManager a;
    public final /* synthetic */ KWaiManager$OnKWaiCallback b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Context e;

    public /* synthetic */ g(KWaiManager kWaiManager, KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback, int n10, int n11, Context context) {
        this.a = kWaiManager;
        this.b = kWaiManager$OnKWaiCallback;
        this.c = n10;
        this.d = n11;
        this.e = context;
    }

    public final void onRespResult(BaseResp baseResp) {
        KWaiManager kWaiManager = this.a;
        KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback = this.b;
        int n10 = this.c;
        int n11 = this.d;
        Context context = this.e;
        kWaiManager.b(kWaiManager$OnKWaiCallback, n10, n11, context, baseResp);
    }
}

