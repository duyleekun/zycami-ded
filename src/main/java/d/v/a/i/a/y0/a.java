/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.i.a.y0;

import android.view.View;
import com.zhiyun.account.me.account.widget.MeGetCodeView;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ MeGetCodeView a;

    public /* synthetic */ a(MeGetCodeView meGetCodeView) {
        this.a = meGetCodeView;
    }

    public final void onClick(View view) {
        MeGetCodeView.d(this.a, view);
    }
}

