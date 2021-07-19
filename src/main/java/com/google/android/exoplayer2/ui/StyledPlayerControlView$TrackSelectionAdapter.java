/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackInfo;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionViewHolder;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.p0.l;
import java.util.Collections;
import java.util.List;

public abstract class StyledPlayerControlView$TrackSelectionAdapter
extends RecyclerView$Adapter {
    public MappingTrackSelector$MappedTrackInfo mappedTrackInfo;
    public List rendererIndices;
    public final /* synthetic */ StyledPlayerControlView this$0;
    public List tracks;

    public StyledPlayerControlView$TrackSelectionAdapter(StyledPlayerControlView object) {
        this.this$0 = object;
        this.rendererIndices = object;
        super();
        this.tracks = object;
        this.mappedTrackInfo = null;
    }

    private /* synthetic */ void a(StyledPlayerControlView$TrackInfo object, View object2) {
        object2 = this.mappedTrackInfo;
        if (object2 != null && (object2 = StyledPlayerControlView.access$4500(this.this$0)) != null) {
            Object object3;
            int n10;
            object2 = StyledPlayerControlView.access$4500(this.this$0).getParameters().buildUpon();
            DefaultTrackSelector defaultTrackSelector = null;
            for (int i10 = 0; i10 < (n10 = (object3 = this.rendererIndices).size()); ++i10) {
                object3 = (Integer)this.rendererIndices.get(i10);
                n10 = (Integer)object3;
                int n11 = ((StyledPlayerControlView$TrackInfo)object).rendererIndex;
                int n12 = 1;
                if (n10 == n11) {
                    int n13;
                    TrackGroupArray trackGroupArray = ((MappingTrackSelector$MappedTrackInfo)Assertions.checkNotNull(this.mappedTrackInfo)).getTrackGroups(n10);
                    int n14 = ((StyledPlayerControlView$TrackInfo)object).groupIndex;
                    int[] nArray = new int[n12];
                    nArray[0] = n13 = ((StyledPlayerControlView$TrackInfo)object).trackIndex;
                    DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = new DefaultTrackSelector$SelectionOverride(n14, nArray);
                    object2 = ((DefaultTrackSelector$ParametersBuilder)object2).setSelectionOverride(n10, trackGroupArray, defaultTrackSelector$SelectionOverride).setRendererDisabled(n10, false);
                    continue;
                }
                object2 = ((DefaultTrackSelector$ParametersBuilder)object2).clearSelectionOverrides(n10).setRendererDisabled(n10, n12 != 0);
            }
            defaultTrackSelector = (DefaultTrackSelector)Assertions.checkNotNull(StyledPlayerControlView.access$4500(this.this$0));
            defaultTrackSelector.setParameters((DefaultTrackSelector$ParametersBuilder)object2);
            object = ((StyledPlayerControlView$TrackInfo)object).trackName;
            this.onTrackSelection((String)object);
            object = StyledPlayerControlView.access$4600(this.this$0);
            object.dismiss();
        }
    }

    public /* synthetic */ void b(StyledPlayerControlView$TrackInfo styledPlayerControlView$TrackInfo, View view) {
        this.a(styledPlayerControlView$TrackInfo, view);
    }

    public void clear() {
        List list;
        this.tracks = list = Collections.emptyList();
        this.mappedTrackInfo = null;
    }

    public int getItemCount() {
        List list = this.tracks;
        int n10 = (int)(list.isEmpty() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            list = null;
        } else {
            list = this.tracks;
            n10 = list.size() + 1;
        }
        return n10;
    }

    public abstract void init(List var1, List var2, MappingTrackSelector$MappedTrackInfo var3);

    public void onBindViewHolder(StyledPlayerControlView$TrackSelectionViewHolder styledPlayerControlView$TrackSelectionViewHolder, int n10) {
        Object object = StyledPlayerControlView.access$4500(this.this$0);
        if (object != null && (object = this.mappedTrackInfo) != null) {
            if (n10 == 0) {
                this.onBindViewHolderAtZeroPosition(styledPlayerControlView$TrackSelectionViewHolder);
            } else {
                object = this.tracks;
                int n11 = 1;
                StyledPlayerControlView$TrackInfo styledPlayerControlView$TrackInfo = (StyledPlayerControlView$TrackInfo)object.get(n10 -= n11);
                object = this.mappedTrackInfo;
                int n12 = styledPlayerControlView$TrackInfo.rendererIndex;
                object = ((MappingTrackSelector$MappedTrackInfo)object).getTrackGroups(n12);
                DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = ((DefaultTrackSelector)Assertions.checkNotNull(StyledPlayerControlView.access$4500(this.this$0))).getParameters();
                int n13 = styledPlayerControlView$TrackInfo.rendererIndex;
                boolean bl2 = defaultTrackSelector$Parameters.hasSelectionOverride(n13, (TrackGroupArray)object);
                n12 = 0;
                defaultTrackSelector$Parameters = null;
                if (!bl2 || !(bl2 = styledPlayerControlView$TrackInfo.selected)) {
                    n11 = 0;
                }
                object = styledPlayerControlView$TrackSelectionViewHolder.textView;
                String string2 = styledPlayerControlView$TrackInfo.trackName;
                object.setText((CharSequence)string2);
                object = styledPlayerControlView$TrackSelectionViewHolder.checkView;
                if (n11 == 0) {
                    n12 = 4;
                }
                object.setVisibility(n12);
                styledPlayerControlView$TrackSelectionViewHolder = styledPlayerControlView$TrackSelectionViewHolder.itemView;
                object = new l(this, styledPlayerControlView$TrackInfo);
                styledPlayerControlView$TrackSelectionViewHolder.setOnClickListener((View.OnClickListener)object);
            }
        }
    }

    public abstract void onBindViewHolderAtZeroPosition(StyledPlayerControlView$TrackSelectionViewHolder var1);

    public StyledPlayerControlView$TrackSelectionViewHolder onCreateViewHolder(ViewGroup viewGroup, int n10) {
        viewGroup = LayoutInflater.from((Context)this.this$0.getContext());
        n10 = R$layout.exo_styled_sub_settings_list_item;
        viewGroup = viewGroup.inflate(n10, null);
        StyledPlayerControlView$TrackSelectionViewHolder styledPlayerControlView$TrackSelectionViewHolder = new StyledPlayerControlView$TrackSelectionViewHolder((View)viewGroup);
        return styledPlayerControlView$TrackSelectionViewHolder;
    }

    public abstract void onTrackSelection(String var1);
}

