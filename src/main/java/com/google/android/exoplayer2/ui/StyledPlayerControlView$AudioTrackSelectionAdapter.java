/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.exoplayer2.ui;

import android.view.View;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$1;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$SettingsAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackInfo;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionViewHolder;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.p0.h;
import java.util.List;

public final class StyledPlayerControlView$AudioTrackSelectionAdapter
extends StyledPlayerControlView$TrackSelectionAdapter {
    public final /* synthetic */ StyledPlayerControlView this$0;

    private StyledPlayerControlView$AudioTrackSelectionAdapter(StyledPlayerControlView styledPlayerControlView) {
        this.this$0 = styledPlayerControlView;
        super(styledPlayerControlView);
    }

    public /* synthetic */ StyledPlayerControlView$AudioTrackSelectionAdapter(StyledPlayerControlView styledPlayerControlView, StyledPlayerControlView$1 styledPlayerControlView$1) {
        this(styledPlayerControlView);
    }

    private /* synthetic */ void c(View object) {
        int n10;
        Object object2;
        object = StyledPlayerControlView.access$4500(this.this$0);
        if (object != null) {
            Object object3;
            object = StyledPlayerControlView.access$4500(this.this$0).getParameters().buildUpon();
            object2 = null;
            for (int i10 = 0; i10 < (n10 = (object3 = this.rendererIndices).size()); ++i10) {
                object3 = (Integer)this.rendererIndices.get(i10);
                n10 = (Integer)object3;
                object = ((DefaultTrackSelector$ParametersBuilder)object).clearSelectionOverrides(n10);
            }
            object2 = (DefaultTrackSelector)Assertions.checkNotNull(StyledPlayerControlView.access$4500(this.this$0));
            ((DefaultTrackSelector)object2).setParameters((DefaultTrackSelector$ParametersBuilder)object);
        }
        object = StyledPlayerControlView.access$3000(this.this$0);
        object2 = this.this$0.getResources();
        n10 = R$string.exo_track_selection_auto;
        object2 = object2.getString(n10);
        ((StyledPlayerControlView$SettingsAdapter)object).setSubTextAtPosition(1, (String)object2);
        StyledPlayerControlView.access$4600(this.this$0).dismiss();
    }

    public /* synthetic */ void d(View view) {
        this.c(view);
    }

    public void init(List list, List list2, MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo) {
        int n10;
        int n11;
        Object object;
        int n12;
        StyledPlayerControlView$SettingsAdapter styledPlayerControlView$SettingsAdapter;
        int n13;
        block8: {
            n13 = 0;
            styledPlayerControlView$SettingsAdapter = null;
            n12 = 0;
            object = null;
            while (true) {
                n11 = list.size();
                n10 = 1;
                if (n12 >= n11) break;
                Integer n14 = (Integer)list.get(n12);
                n11 = n14;
                TrackGroupArray trackGroupArray = mappingTrackSelector$MappedTrackInfo.getTrackGroups(n11);
                Object object2 = StyledPlayerControlView.access$4500(this.this$0);
                if (object2 != null && (n11 = (int)(((DefaultTrackSelector$Parameters)(object2 = StyledPlayerControlView.access$4500(this.this$0).getParameters())).hasSelectionOverride(n11, trackGroupArray) ? 1 : 0)) != 0) {
                    n12 = n10;
                    break block8;
                }
                ++n12;
            }
            n12 = 0;
            object = null;
        }
        n11 = (int)(list2.isEmpty() ? 1 : 0);
        if (n11 != 0) {
            styledPlayerControlView$SettingsAdapter = StyledPlayerControlView.access$3000(this.this$0);
            object = this.this$0.getResources();
            n11 = R$string.exo_track_selection_none;
            object = object.getString(n11);
            styledPlayerControlView$SettingsAdapter.setSubTextAtPosition(n10, (String)object);
        } else if (n12 == 0) {
            styledPlayerControlView$SettingsAdapter = StyledPlayerControlView.access$3000(this.this$0);
            object = this.this$0.getResources();
            n11 = R$string.exo_track_selection_auto;
            object = object.getString(n11);
            styledPlayerControlView$SettingsAdapter.setSubTextAtPosition(n10, (String)object);
        } else {
            while (n13 < (n12 = list2.size())) {
                object = (StyledPlayerControlView$TrackInfo)list2.get(n13);
                n11 = (int)(object.selected ? 1 : 0);
                if (n11 != 0) {
                    styledPlayerControlView$SettingsAdapter = StyledPlayerControlView.access$3000(this.this$0);
                    object = object.trackName;
                    styledPlayerControlView$SettingsAdapter.setSubTextAtPosition(n10, (String)object);
                    break;
                }
                ++n13;
            }
        }
        this.rendererIndices = list;
        this.tracks = list2;
        this.mappedTrackInfo = mappingTrackSelector$MappedTrackInfo;
    }

    public void onBindViewHolderAtZeroPosition(StyledPlayerControlView$TrackSelectionViewHolder styledPlayerControlView$TrackSelectionViewHolder) {
        boolean bl2;
        View view;
        int n10;
        Object object;
        block2: {
            Object object2;
            int n11;
            object = styledPlayerControlView$TrackSelectionViewHolder.textView;
            n10 = R$string.exo_track_selection_auto;
            object.setText(n10);
            object = ((DefaultTrackSelector)Assertions.checkNotNull(StyledPlayerControlView.access$4500(this.this$0))).getParameters();
            n10 = 0;
            view = null;
            for (int i10 = 0; i10 < (n11 = (object2 = this.rendererIndices).size()); ++i10) {
                object2 = (Integer)this.rendererIndices.get(i10);
                n11 = (Integer)object2;
                TrackGroupArray trackGroupArray = ((MappingTrackSelector$MappedTrackInfo)Assertions.checkNotNull(this.mappedTrackInfo)).getTrackGroups(n11);
                if ((n11 = (int)(object.hasSelectionOverride(n11, trackGroupArray) ? 1 : 0)) == 0) continue;
                bl2 = true;
                break block2;
            }
            bl2 = false;
            object = null;
        }
        view = styledPlayerControlView$TrackSelectionViewHolder.checkView;
        if (bl2) {
            n10 = 4;
        }
        view.setVisibility(n10);
        styledPlayerControlView$TrackSelectionViewHolder = styledPlayerControlView$TrackSelectionViewHolder.itemView;
        object = new h(this);
        styledPlayerControlView$TrackSelectionViewHolder.setOnClickListener((View.OnClickListener)object);
    }

    public void onTrackSelection(String string2) {
        StyledPlayerControlView.access$3000(this.this$0).setSubTextAtPosition(1, string2);
    }
}

