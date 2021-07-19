/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.cloud_engine.CECompositingDialog;

public final class i
implements Observer {
    public final /* synthetic */ CECompositingDialog a;

    public /* synthetic */ i(CECompositingDialog cECompositingDialog) {
        this.a = cECompositingDialog;
    }

    public final void onChanged(Object object) {
        CECompositingDialog cECompositingDialog = this.a;
        object = (Integer)object;
        cECompositingDialog.x((Integer)object);
    }
}

