/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0;

import android.view.View;
import com.zhiyun.cama.appeal.AppealActivity;

public final class c
implements View.OnClickListener {
    public final /* synthetic */ AppealActivity a;

    public /* synthetic */ c(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    public final void onClick(View view) {
        this.a.t(view);
    }
}

