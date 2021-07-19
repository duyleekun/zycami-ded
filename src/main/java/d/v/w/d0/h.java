/*
 * Decompiled with CFR 0.151.
 */
package d.v.w.d0;

import androidx.lifecycle.Observer;
import com.zhiyun.pay.googleplay.GoogleBillingClientLifecycle;
import java.util.List;

public final class h
implements Observer {
    public final /* synthetic */ GoogleBillingClientLifecycle a;

    public /* synthetic */ h(GoogleBillingClientLifecycle googleBillingClientLifecycle) {
        this.a = googleBillingClientLifecycle;
    }

    public final void onChanged(Object object) {
        GoogleBillingClientLifecycle googleBillingClientLifecycle = this.a;
        object = (List)object;
        googleBillingClientLifecycle.x((List)object);
    }
}

