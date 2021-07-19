/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.connect.help.SingleBindingAdapter;
import com.zhiyun.cama.publish.UploadCEMediaInfo;

public final class d2
implements Observer {
    public final /* synthetic */ SingleBindingAdapter a;

    public /* synthetic */ d2(SingleBindingAdapter singleBindingAdapter) {
        this.a = singleBindingAdapter;
    }

    public final void onChanged(Object object) {
        SingleBindingAdapter singleBindingAdapter = this.a;
        object = (UploadCEMediaInfo)object;
        singleBindingAdapter.addData(object);
    }
}

