/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 */
package androidx.appcompat.widget;

import android.database.DataSetObserver;
import androidx.appcompat.widget.ActivityChooserView;

public class ActivityChooserView$1
extends DataSetObserver {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$1(ActivityChooserView activityChooserView) {
        this.this$0 = activityChooserView;
    }

    public void onChanged() {
        super.onChanged();
        this.this$0.mAdapter.notifyDataSetChanged();
    }

    public void onInvalidated() {
        super.onInvalidated();
        this.this$0.mAdapter.notifyDataSetInvalidated();
    }
}

