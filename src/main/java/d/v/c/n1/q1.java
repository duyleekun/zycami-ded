/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.UploadWorksFragment;

public final class q1
implements Observer {
    public final /* synthetic */ UploadWorksFragment a;

    public /* synthetic */ q1(UploadWorksFragment uploadWorksFragment) {
        this.a = uploadWorksFragment;
    }

    public final void onChanged(Object object) {
        UploadWorksFragment uploadWorksFragment = this.a;
        object = (Boolean)object;
        uploadWorksFragment.w((Boolean)object);
    }
}

