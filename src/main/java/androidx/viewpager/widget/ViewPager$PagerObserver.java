/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 */
package androidx.viewpager.widget;

import android.database.DataSetObserver;
import androidx.viewpager.widget.ViewPager;

public class ViewPager$PagerObserver
extends DataSetObserver {
    public final /* synthetic */ ViewPager this$0;

    public ViewPager$PagerObserver(ViewPager viewPager) {
        this.this$0 = viewPager;
    }

    public void onChanged() {
        this.this$0.dataSetChanged();
    }

    public void onInvalidated() {
        this.this$0.dataSetChanged();
    }
}

