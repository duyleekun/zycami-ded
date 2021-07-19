/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$SubSettingViewHolder;

public class StyledPlayerControlView$SubSettingsAdapter
extends RecyclerView$Adapter {
    private int selectedIndex;
    private String[] texts;
    public final /* synthetic */ StyledPlayerControlView this$0;

    public StyledPlayerControlView$SubSettingsAdapter(StyledPlayerControlView stringArray) {
        this.this$0 = stringArray;
        stringArray = new String[]{};
        this.texts = stringArray;
    }

    public int getItemCount() {
        return this.texts.length;
    }

    public void init(String[] stringArray, int n10) {
        this.texts = stringArray;
        this.selectedIndex = n10;
    }

    public void onBindViewHolder(StyledPlayerControlView$SubSettingViewHolder styledPlayerControlView$SubSettingViewHolder, int n10) {
        TextView textView = this.texts;
        int n11 = ((String[])textView).length;
        if (n10 < n11) {
            textView = StyledPlayerControlView$SubSettingViewHolder.access$3800(styledPlayerControlView$SubSettingViewHolder);
            String string2 = this.texts[n10];
            textView.setText((CharSequence)string2);
        }
        styledPlayerControlView$SubSettingViewHolder = StyledPlayerControlView$SubSettingViewHolder.access$3900(styledPlayerControlView$SubSettingViewHolder);
        n11 = this.selectedIndex;
        n10 = n10 == n11 ? 0 : 4;
        styledPlayerControlView$SubSettingViewHolder.setVisibility(n10);
    }

    public StyledPlayerControlView$SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        viewGroup = LayoutInflater.from((Context)this.this$0.getContext());
        n10 = R$layout.exo_styled_sub_settings_list_item;
        viewGroup = viewGroup.inflate(n10, null);
        StyledPlayerControlView styledPlayerControlView = this.this$0;
        StyledPlayerControlView$SubSettingViewHolder styledPlayerControlView$SubSettingViewHolder = new StyledPlayerControlView$SubSettingViewHolder(styledPlayerControlView, (View)viewGroup);
        return styledPlayerControlView$SubSettingViewHolder;
    }
}

