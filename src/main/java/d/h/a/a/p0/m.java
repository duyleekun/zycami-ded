/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.h.a.a.p0;

import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final class m
implements View.OnClickListener {
    public final /* synthetic */ StyledPlayerControlView a;

    public /* synthetic */ m(StyledPlayerControlView styledPlayerControlView) {
        this.a = styledPlayerControlView;
    }

    public final void onClick(View view) {
        StyledPlayerControlView.a(this.a, view);
    }
}

