/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.list;

import com.google.android.material.tabs.TabLayout$OnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;

public class EditorTemplateListFragment$b
implements TabLayout$OnTabSelectedListener {
    public final /* synthetic */ EditorTemplateListFragment a;

    public EditorTemplateListFragment$b(EditorTemplateListFragment editorTemplateListFragment) {
        this.a = editorTemplateListFragment;
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void onTabSelected(TabLayout.Tab tab) {
        EditorTemplateListFragment.y(this.a, tab, true);
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        EditorTemplateListFragment.y(this.a, tab, false);
    }
}

