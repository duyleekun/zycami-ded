/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.TabHost$OnTabChangeListener
 */
package androidx.databinding.adapters;

import android.widget.TabHost;
import androidx.databinding.InverseBindingListener;

public final class TabHostBindingAdapter$1
implements TabHost.OnTabChangeListener {
    public final /* synthetic */ InverseBindingListener val$attrChange;
    public final /* synthetic */ TabHost.OnTabChangeListener val$listener;

    public TabHostBindingAdapter$1(TabHost.OnTabChangeListener onTabChangeListener, InverseBindingListener inverseBindingListener) {
        this.val$listener = onTabChangeListener;
        this.val$attrChange = inverseBindingListener;
    }

    public void onTabChanged(String string2) {
        TabHost.OnTabChangeListener onTabChangeListener = this.val$listener;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(string2);
        }
        this.val$attrChange.onChange();
    }
}

