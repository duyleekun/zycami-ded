/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.ListView
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ListView;
import com.mob.tools.gui.Scrollable;
import com.mob.tools.gui.Scrollable$OnScrollListener;
import com.mob.tools.gui.ScrollableListView$1;

public class ScrollableListView
extends ListView
implements Scrollable {
    private Scrollable$OnScrollListener osListener;
    private boolean pullEnable;

    public ScrollableListView(Context context) {
        super(context);
        this.init(context);
    }

    public ScrollableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public ScrollableListView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(context);
    }

    public static /* synthetic */ boolean access$002(ScrollableListView scrollableListView, boolean bl2) {
        scrollableListView.pullEnable = bl2;
        return bl2;
    }

    private void init(Context object) {
        this.setCacheColorHint(0);
        ColorDrawable colorDrawable = new ColorDrawable();
        this.setSelector((Drawable)colorDrawable);
        this.setDividerHeight(0);
        this.pullEnable = true;
        object = new ScrollableListView$1(this);
        this.osListener = object;
    }

    public int computeVerticalScrollOffset() {
        int n10 = super.computeVerticalScrollOffset();
        Scrollable$OnScrollListener scrollable$OnScrollListener = this.osListener;
        if (scrollable$OnScrollListener != null) {
            scrollable$OnScrollListener.onScrollChanged(this, 0, n10, 0, 0);
        }
        return n10;
    }

    public boolean isReadyToPull() {
        return this.pullEnable;
    }
}

