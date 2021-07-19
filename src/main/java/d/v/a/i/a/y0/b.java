/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.a.i.a.y0;

import android.widget.CompoundButton;
import com.zhiyun.account.me.account.widget.MePassView;

public final class b
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ MePassView a;

    public /* synthetic */ b(MePassView mePassView) {
        this.a = mePassView;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.d(compoundButton, bl2);
    }
}

