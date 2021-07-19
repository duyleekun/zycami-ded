/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package com.google.android.exoplayer2.ui;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$1;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackInfo;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionViewHolder;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.p0.k;
import java.util.List;

public final class StyledPlayerControlView$TextTrackSelectionAdapter
extends StyledPlayerControlView$TrackSelectionAdapter {
    public final /* synthetic */ StyledPlayerControlView this$0;

    private StyledPlayerControlView$TextTrackSelectionAdapter(StyledPlayerControlView styledPlayerControlView) {
        this.this$0 = styledPlayerControlView;
        super(styledPlayerControlView);
    }

    public /* synthetic */ StyledPlayerControlView$TextTrackSelectionAdapter(StyledPlayerControlView styledPlayerControlView, StyledPlayerControlView$1 styledPlayerControlView$1) {
        this(styledPlayerControlView);
    }

    private /* synthetic */ void c(View object) {
        object = StyledPlayerControlView.access$4500(this.this$0);
        if (object != null) {
            Object object2;
            int n10;
            object = StyledPlayerControlView.access$4500(this.this$0).getParameters().buildUpon();
            DefaultTrackSelector defaultTrackSelector = null;
            for (int i10 = 0; i10 < (n10 = (object2 = this.rendererIndices).size()); ++i10) {
                object2 = (Integer)this.rendererIndices.get(i10);
                n10 = (Integer)object2;
                object = ((DefaultTrackSelector$ParametersBuilder)object).clearSelectionOverrides(n10);
                boolean bl2 = true;
                object = ((DefaultTrackSelector$ParametersBuilder)object).setRendererDisabled(n10, bl2);
            }
            defaultTrackSelector = (DefaultTrackSelector)Assertions.checkNotNull(StyledPlayerControlView.access$4500(this.this$0));
            defaultTrackSelector.setParameters((DefaultTrackSelector$ParametersBuilder)object);
            object = StyledPlayerControlView.access$4600(this.this$0);
            object.dismiss();
        }
    }

    public /* synthetic */ void d(View view) {
        this.c(view);
    }

    public void init(List list, List list2, MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo) {
        Object object;
        int n10;
        boolean bl2 = false;
        String string2 = null;
        ImageView imageView = null;
        for (int i10 = 0; i10 < (n10 = list2.size()); ++i10) {
            object = (StyledPlayerControlView$TrackInfo)list2.get(i10);
            n10 = (int)(object.selected ? 1 : 0);
            if (n10 == 0) continue;
            bl2 = true;
            break;
        }
        if ((imageView = StyledPlayerControlView.access$3200(this.this$0)) != null) {
            imageView = StyledPlayerControlView.access$3200(this.this$0);
            object = this.this$0;
            object = bl2 ? StyledPlayerControlView.access$4100((StyledPlayerControlView)((Object)object)) : StyledPlayerControlView.access$4200((StyledPlayerControlView)((Object)object));
            imageView.setImageDrawable((Drawable)object);
            imageView = StyledPlayerControlView.access$3200(this.this$0);
            string2 = bl2 ? StyledPlayerControlView.access$4300(this.this$0) : StyledPlayerControlView.access$4400(this.this$0);
            imageView.setContentDescription((CharSequence)string2);
        }
        this.rendererIndices = list;
        this.tracks = list2;
        this.mappedTrackInfo = mappingTrackSelector$MappedTrackInfo;
    }

    public void onBindViewHolder(StyledPlayerControlView$TrackSelectionViewHolder styledPlayerControlView$TrackSelectionViewHolder, int n10) {
        super.onBindViewHolder(styledPlayerControlView$TrackSelectionViewHolder, n10);
        if (n10 > 0) {
            List list = this.tracks;
            StyledPlayerControlView$TrackInfo styledPlayerControlView$TrackInfo = (StyledPlayerControlView$TrackInfo)list.get(n10 += -1);
            styledPlayerControlView$TrackSelectionViewHolder = styledPlayerControlView$TrackSelectionViewHolder.checkView;
            n10 = (int)(styledPlayerControlView$TrackInfo.selected ? 1 : 0);
            if (n10 != 0) {
                n10 = 0;
                styledPlayerControlView$TrackInfo = null;
            } else {
                n10 = 4;
            }
            styledPlayerControlView$TrackSelectionViewHolder.setVisibility(n10);
        }
    }

    public void onBindViewHolderAtZeroPosition(StyledPlayerControlView$TrackSelectionViewHolder styledPlayerControlView$TrackSelectionViewHolder) {
        Object object;
        int n10;
        int n11;
        Object object2;
        block2: {
            int n12;
            object2 = styledPlayerControlView$TrackSelectionViewHolder.textView;
            n11 = R$string.exo_track_selection_none;
            object2.setText(n11);
            n10 = 0;
            object2 = null;
            for (n11 = 0; n11 < (n12 = (object = this.tracks).size()); ++n11) {
                object = (StyledPlayerControlView$TrackInfo)this.tracks.get(n11);
                n12 = (int)(((StyledPlayerControlView$TrackInfo)object).selected ? 1 : 0);
                if (n12 == 0) continue;
                n11 = 0;
                break block2;
            }
            n11 = 1;
        }
        object = styledPlayerControlView$TrackSelectionViewHolder.checkView;
        if (n11 == 0) {
            n10 = 4;
        }
        object.setVisibility(n10);
        styledPlayerControlView$TrackSelectionViewHolder = styledPlayerControlView$TrackSelectionViewHolder.itemView;
        object2 = new k(this);
        styledPlayerControlView$TrackSelectionViewHolder.setOnClickListener((View.OnClickListener)object2);
    }

    public void onTrackSelection(String string2) {
    }
}

