/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final class StyledPlayerControlView$SettingViewHolder
extends RecyclerView$ViewHolder {
    private final ImageView iconView;
    private final TextView mainTextView;
    private final TextView subTextView;
    public final /* synthetic */ StyledPlayerControlView this$0;

    public StyledPlayerControlView$SettingViewHolder(StyledPlayerControlView object, View view) {
        this.this$0 = object;
        super(view);
        int n10 = R$id.exo_main_text;
        object = (TextView)view.findViewById(n10);
        this.mainTextView = object;
        n10 = R$id.exo_sub_text;
        object = (TextView)view.findViewById(n10);
        this.subTextView = object;
        n10 = R$id.exo_icon;
        object = (ImageView)view.findViewById(n10);
        this.iconView = object;
        super(this);
        view.setOnClickListener((View.OnClickListener)object);
    }

    private /* synthetic */ void a(View object) {
        object = this.this$0;
        int n10 = this.getAdapterPosition();
        StyledPlayerControlView.access$3700((StyledPlayerControlView)((Object)object), n10);
    }

    public static /* synthetic */ TextView access$3400(StyledPlayerControlView$SettingViewHolder styledPlayerControlView$SettingViewHolder) {
        return styledPlayerControlView$SettingViewHolder.mainTextView;
    }

    public static /* synthetic */ TextView access$3500(StyledPlayerControlView$SettingViewHolder styledPlayerControlView$SettingViewHolder) {
        return styledPlayerControlView$SettingViewHolder.subTextView;
    }

    public static /* synthetic */ ImageView access$3600(StyledPlayerControlView$SettingViewHolder styledPlayerControlView$SettingViewHolder) {
        return styledPlayerControlView$SettingViewHolder.iconView;
    }

    public /* synthetic */ void b(View view) {
        this.a(view);
    }
}

