/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.SpannableString
 */
package d.v.c.p0;

import android.text.SpannableString;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.appeal.AppealActivity;

public final class d
implements Observer {
    public final /* synthetic */ AppealActivity a;

    public /* synthetic */ d(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    public final void onChanged(Object object) {
        AppealActivity appealActivity = this.a;
        object = (SpannableString)object;
        AppealActivity.r(appealActivity, (SpannableString)object);
    }
}

