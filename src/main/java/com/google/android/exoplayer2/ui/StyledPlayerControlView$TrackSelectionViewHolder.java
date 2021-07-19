/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.google.android.exoplayer2.ui.R$id;

public class StyledPlayerControlView$TrackSelectionViewHolder
extends RecyclerView$ViewHolder {
    public final View checkView;
    public final TextView textView;

    public StyledPlayerControlView$TrackSelectionViewHolder(View view) {
        super(view);
        TextView textView;
        int n10 = R$id.exo_text;
        this.textView = textView = (TextView)view.findViewById(n10);
        n10 = R$id.exo_check;
        this.checkView = view = view.findViewById(n10);
    }
}

