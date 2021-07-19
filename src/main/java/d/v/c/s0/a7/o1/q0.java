/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7.o1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.dialog.more.WhiteBalanceFragment;
import com.zhiyun.cama.data.database.model.CameraParam;

public final class q0
implements Observer {
    public final /* synthetic */ WhiteBalanceFragment a;

    public /* synthetic */ q0(WhiteBalanceFragment whiteBalanceFragment) {
        this.a = whiteBalanceFragment;
    }

    public final void onChanged(Object object) {
        WhiteBalanceFragment whiteBalanceFragment = this.a;
        object = (CameraParam)object;
        whiteBalanceFragment.q((CameraParam)object);
    }
}

