/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$TabView;

public class TabLayout$Tab {
    public static final int INVALID_POSITION = 255;
    private CharSequence contentDesc;
    private View customView;
    private Drawable icon;
    public TabLayout parent;
    private int position = -1;
    private Object tag;
    private CharSequence text;
    public TabLayout$TabView view;

    public static /* synthetic */ CharSequence access$100(TabLayout$Tab tabLayout$Tab) {
        return tabLayout$Tab.contentDesc;
    }

    public static /* synthetic */ CharSequence access$200(TabLayout$Tab tabLayout$Tab) {
        return tabLayout$Tab.text;
    }

    public CharSequence getContentDescription() {
        Object object = this.view;
        object = object == null ? null : object.getContentDescription();
        return object;
    }

    public View getCustomView() {
        return this.customView;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getPosition() {
        return this.position;
    }

    public Object getTag() {
        return this.tag;
    }

    public CharSequence getText() {
        return this.text;
    }

    public boolean isSelected() {
        Object object = this.parent;
        if (object != null) {
            int n10;
            int n11 = object.getSelectedTabPosition();
            if (n11 == (n10 = this.position)) {
                n11 = 1;
            } else {
                n11 = 0;
                object = null;
            }
            return n11 != 0;
        }
        object = new IllegalArgumentException("Tab not attached to a TabLayout");
        throw object;
    }

    public void reset() {
        this.parent = null;
        this.view = null;
        this.tag = null;
        this.icon = null;
        this.text = null;
        this.contentDesc = null;
        this.position = -1;
        this.customView = null;
    }

    public void select() {
        Object object = this.parent;
        if (object != null) {
            object.selectTab(this);
            return;
        }
        object = new IllegalArgumentException("Tab not attached to a TabLayout");
        throw object;
    }

    public TabLayout$Tab setContentDescription(int n10) {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            CharSequence charSequence = tabLayout.getResources().getText(n10);
            return this.setContentDescription(charSequence);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        throw illegalArgumentException;
    }

    public TabLayout$Tab setContentDescription(CharSequence charSequence) {
        this.contentDesc = charSequence;
        this.updateView();
        return this;
    }

    public TabLayout$Tab setCustomView(int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.view.getContext());
        TabLayout$TabView tabLayout$TabView = this.view;
        View view = layoutInflater.inflate(n10, (ViewGroup)tabLayout$TabView, false);
        return this.setCustomView(view);
    }

    public TabLayout$Tab setCustomView(View view) {
        this.customView = view;
        this.updateView();
        return this;
    }

    public TabLayout$Tab setIcon(int n10) {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            Drawable drawable2 = AppCompatResources.getDrawable(tabLayout.getContext(), n10);
            return this.setIcon(drawable2);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        throw illegalArgumentException;
    }

    public TabLayout$Tab setIcon(Drawable drawable2) {
        this.icon = drawable2;
        this.updateView();
        return this;
    }

    public void setPosition(int n10) {
        this.position = n10;
    }

    public TabLayout$Tab setTag(Object object) {
        this.tag = object;
        return this;
    }

    public TabLayout$Tab setText(int n10) {
        TabLayout tabLayout = this.parent;
        if (tabLayout != null) {
            CharSequence charSequence = tabLayout.getResources().getText(n10);
            return this.setText(charSequence);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tab not attached to a TabLayout");
        throw illegalArgumentException;
    }

    public TabLayout$Tab setText(CharSequence charSequence) {
        Object object = this.contentDesc;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)charSequence))) {
            object = this.view;
            object.setContentDescription(charSequence);
        }
        this.text = charSequence;
        this.updateView();
        return this;
    }

    public void updateView() {
        TabLayout$TabView tabLayout$TabView = this.view;
        if (tabLayout$TabView != null) {
            tabLayout$TabView.update();
        }
    }
}

