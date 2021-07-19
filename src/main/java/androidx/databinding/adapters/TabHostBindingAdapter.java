/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.TabHost
 *  android.widget.TabHost$OnTabChangeListener
 */
package androidx.databinding.adapters;

import android.widget.TabHost;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.TabHostBindingAdapter$1;

public class TabHostBindingAdapter {
    public static int getCurrentTab(TabHost tabHost) {
        return tabHost.getCurrentTab();
    }

    public static String getCurrentTabTag(TabHost tabHost) {
        return tabHost.getCurrentTabTag();
    }

    public static void setCurrentTab(TabHost tabHost, int n10) {
        int n11 = tabHost.getCurrentTab();
        if (n11 != n10) {
            tabHost.setCurrentTab(n10);
        }
    }

    public static void setCurrentTabTag(TabHost tabHost, String string2) {
        boolean bl2;
        String string3 = tabHost.getCurrentTabTag();
        if (string3 != null && !(bl2 = string3.equals(string2)) || string3 == null && string2 != null) {
            tabHost.setCurrentTabByTag(string2);
        }
    }

    public static void setListeners(TabHost tabHost, TabHost.OnTabChangeListener onTabChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            tabHost.setOnTabChangedListener(onTabChangeListener);
        } else {
            TabHostBindingAdapter$1 tabHostBindingAdapter$1 = new TabHostBindingAdapter$1(onTabChangeListener, inverseBindingListener);
            tabHost.setOnTabChangedListener((TabHost.OnTabChangeListener)tabHostBindingAdapter$1);
        }
    }
}

