/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.n1;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.publish.UploadWorksFragment;

public final class r1
implements OnItemClickListener {
    public final /* synthetic */ UploadWorksFragment a;

    public /* synthetic */ r1(UploadWorksFragment uploadWorksFragment) {
        this.a = uploadWorksFragment;
    }

    public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.a.s(baseQuickAdapter, view, n10);
    }
}

