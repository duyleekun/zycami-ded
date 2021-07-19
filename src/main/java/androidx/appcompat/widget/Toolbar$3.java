/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

public class Toolbar$3
implements View.OnClickListener {
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$3(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public void onClick(View view) {
        this.this$0.collapseActionView();
    }
}

