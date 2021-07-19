/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$SettingViewHolder;

public class StyledPlayerControlView$SettingsAdapter
extends RecyclerView$Adapter {
    private final Drawable[] iconIds;
    private final String[] mainTexts;
    private final String[] subTexts;
    public final /* synthetic */ StyledPlayerControlView this$0;

    public StyledPlayerControlView$SettingsAdapter(StyledPlayerControlView stringArray, String[] stringArray2, Drawable[] drawableArray) {
        this.this$0 = stringArray;
        this.mainTexts = stringArray2;
        stringArray = new String[stringArray2.length];
        this.subTexts = stringArray;
        this.iconIds = drawableArray;
    }

    public int getItemCount() {
        return this.mainTexts.length;
    }

    public long getItemId(int n10) {
        return n10;
    }

    public void onBindViewHolder(StyledPlayerControlView$SettingViewHolder styledPlayerControlView$SettingViewHolder, int n10) {
        Drawable[] drawableArray = StyledPlayerControlView$SettingViewHolder.access$3400(styledPlayerControlView$SettingViewHolder);
        String string2 = this.mainTexts[n10];
        drawableArray.setText((CharSequence)string2);
        drawableArray = this.subTexts[n10];
        int n11 = 8;
        if (drawableArray == null) {
            drawableArray = StyledPlayerControlView$SettingViewHolder.access$3500(styledPlayerControlView$SettingViewHolder);
            drawableArray.setVisibility(n11);
        } else {
            drawableArray = StyledPlayerControlView$SettingViewHolder.access$3500(styledPlayerControlView$SettingViewHolder);
            String string3 = this.subTexts[n10];
            drawableArray.setText((CharSequence)string3);
        }
        drawableArray = this.iconIds[n10];
        if (drawableArray == null) {
            styledPlayerControlView$SettingViewHolder = StyledPlayerControlView$SettingViewHolder.access$3600(styledPlayerControlView$SettingViewHolder);
            styledPlayerControlView$SettingViewHolder.setVisibility(n11);
        } else {
            styledPlayerControlView$SettingViewHolder = StyledPlayerControlView$SettingViewHolder.access$3600(styledPlayerControlView$SettingViewHolder);
            drawableArray = this.iconIds;
            Drawable drawable2 = drawableArray[n10];
            styledPlayerControlView$SettingViewHolder.setImageDrawable(drawable2);
        }
    }

    public StyledPlayerControlView$SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        viewGroup = LayoutInflater.from((Context)this.this$0.getContext());
        n10 = R$layout.exo_styled_settings_list_item;
        viewGroup = viewGroup.inflate(n10, null);
        StyledPlayerControlView styledPlayerControlView = this.this$0;
        StyledPlayerControlView$SettingViewHolder styledPlayerControlView$SettingViewHolder = new StyledPlayerControlView$SettingViewHolder(styledPlayerControlView, (View)viewGroup);
        return styledPlayerControlView$SettingViewHolder;
    }

    public void setSubTextAtPosition(int n10, String string2) {
        this.subTexts[n10] = string2;
    }
}

