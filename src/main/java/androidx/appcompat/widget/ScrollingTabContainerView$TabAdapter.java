/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 */
package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.ScrollingTabContainerView$TabView;

public class ScrollingTabContainerView$TabAdapter
extends BaseAdapter {
    public final /* synthetic */ ScrollingTabContainerView this$0;

    public ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView scrollingTabContainerView) {
        this.this$0 = scrollingTabContainerView;
    }

    public int getCount() {
        return this.this$0.mTabLayout.getChildCount();
    }

    public Object getItem(int n10) {
        return ((ScrollingTabContainerView$TabView)this.this$0.mTabLayout.getChildAt(n10)).getTab();
    }

    public long getItemId(int n10) {
        return n10;
    }

    public View getView(int n10, View object, ViewGroup object2) {
        if (object == null) {
            object = this.this$0;
            ActionBar$Tab actionBar$Tab = (ActionBar$Tab)this.getItem(n10);
            boolean bl2 = true;
            object = object.createTabView(actionBar$Tab, bl2);
        } else {
            object2 = object;
            object2 = (ScrollingTabContainerView$TabView)((Object)object);
            ActionBar$Tab actionBar$Tab = (ActionBar$Tab)this.getItem(n10);
            ((ScrollingTabContainerView$TabView)((Object)object2)).bindTab(actionBar$Tab);
        }
        return object;
    }
}

