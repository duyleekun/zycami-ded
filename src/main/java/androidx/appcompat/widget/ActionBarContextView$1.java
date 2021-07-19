/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.ActionBarContextView;

public class ActionBarContextView$1
implements View.OnClickListener {
    public final /* synthetic */ ActionBarContextView this$0;
    public final /* synthetic */ ActionMode val$mode;

    public ActionBarContextView$1(ActionBarContextView actionBarContextView, ActionMode actionMode) {
        this.this$0 = actionBarContextView;
        this.val$mode = actionMode;
    }

    public void onClick(View view) {
        this.val$mode.finish();
    }
}

