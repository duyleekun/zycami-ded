/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.cloud_engine.CECompositingDialog;
import d.v.e.i.e;

public final class j
implements Observer {
    public final /* synthetic */ CECompositingDialog a;

    public /* synthetic */ j(CECompositingDialog cECompositingDialog) {
        this.a = cECompositingDialog;
    }

    public final void onChanged(Object object) {
        CECompositingDialog cECompositingDialog = this.a;
        object = (e)object;
        CECompositingDialog.v(cECompositingDialog, (e)object);
    }
}

