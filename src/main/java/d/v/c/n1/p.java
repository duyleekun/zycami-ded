/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.n1;

import android.view.View;
import com.zhiyun.cama.publish.CropImageActivity;

public final class p
implements View.OnClickListener {
    public final /* synthetic */ CropImageActivity a;

    public /* synthetic */ p(CropImageActivity cropImageActivity) {
        this.a = cropImageActivity;
    }

    public final void onClick(View view) {
        this.a.S(view);
    }
}

