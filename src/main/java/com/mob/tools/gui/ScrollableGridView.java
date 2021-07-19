/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.GridView
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridView;
import com.mob.tools.gui.Scrollable;
import com.mob.tools.gui.Scrollable$OnScrollListener;
import com.mob.tools.gui.ScrollableGridView$1;

public class ScrollableGridView
extends GridView
implements Scrollable {
    private Scrollable$OnScrollListener osListener;
    private boolean pullEnable;

    public ScrollableGridView(Context context) {
        super(context);
        this.init(context);
    }

    public ScrollableGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    public ScrollableGridView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init(context);
    }

    public static /* synthetic */ boolean access$002(ScrollableGridView scrollableGridView, boolean bl2) {
        scrollableGridView.pullEnable = bl2;
        return bl2;
    }

    private void init(Context object) {
        this.setCacheColorHint(0);
        object = new ColorDrawable();
        this.setSelector((Drawable)object);
        this.pullEnable = true;
        object = new ScrollableGridView$1(this);
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

