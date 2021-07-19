/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.SpannableString
 */
package d.v.c.p0.n;

import android.text.SpannableString;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;

public final class d
implements Observer {
    public final /* synthetic */ AppealDetailActivity a;

    public /* synthetic */ d(AppealDetailActivity appealDetailActivity) {
        this.a = appealDetailActivity;
    }

    public final void onChanged(Object object) {
        AppealDetailActivity appealDetailActivity = this.a;
        object = (SpannableString)object;
        appealDetailActivity.s((SpannableString)object);
    }
}

