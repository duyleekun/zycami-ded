/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

public final class StyledPlayerControlView$SubSettingViewHolder
extends RecyclerView$ViewHolder {
    private final View checkView;
    private final TextView textView;
    public final /* synthetic */ StyledPlayerControlView this$0;

    public StyledPlayerControlView$SubSettingViewHolder(StyledPlayerControlView object, View view) {
        this.this$0 = object;
        super(view);
        int n10 = R$id.exo_text;
        object = (TextView)view.findViewById(n10);
        this.textView = object;
        n10 = R$id.exo_check;
        object = view.findViewById(n10);
        this.checkView = object;
        super(this);
        view.setOnClickListener((View.OnClickListener)object);
    }

    private /* synthetic */ void a(View object) {
        object = this.this$0;
        int n10 = this.getAdapterPosition();
        StyledPlayerControlView.access$4000((StyledPlayerControlView)((Object)object), n10);
    }

    public static /* synthetic */ TextView access$3800(StyledPlayerControlView$SubSettingViewHolder styledPlayerControlView$SubSettingViewHolder) {
        return styledPlayerControlView$SubSettingViewHolder.textView;
    }

    public static /* synthetic */ View access$3900(StyledPlayerControlView$SubSettingViewHolder styledPlayerControlView$SubSettingViewHolder) {
        return styledPlayerControlView$SubSettingViewHolder.checkView;
    }

    public /* synthetic */ void b(View view) {
        this.a(view);
    }
}

