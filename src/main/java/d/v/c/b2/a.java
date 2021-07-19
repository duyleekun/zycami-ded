/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 */
package d.v.c.b2;

import android.view.View;
import com.zhiyun.cama.widget.AudioBeatView;

public final class a
implements View.OnScrollChangeListener {
    public final /* synthetic */ AudioBeatView a;

    public /* synthetic */ a(AudioBeatView audioBeatView) {
        this.a = audioBeatView;
    }

    public final void onScrollChange(View view, int n10, int n11, int n12, int n13) {
        this.a.r(view, n10, n11, n12, n13);
    }
}

