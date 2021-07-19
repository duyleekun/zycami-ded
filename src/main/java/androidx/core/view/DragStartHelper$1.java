/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package androidx.core.view;

import android.view.View;
import androidx.core.view.DragStartHelper;

public class DragStartHelper$1
implements View.OnLongClickListener {
    public final /* synthetic */ DragStartHelper this$0;

    public DragStartHelper$1(DragStartHelper dragStartHelper) {
        this.this$0 = dragStartHelper;
    }

    public boolean onLongClick(View view) {
        return this.this$0.onLongClick(view);
    }
}

