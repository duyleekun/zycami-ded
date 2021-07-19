/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.CheckedTextView
 *  android.widget.LinearLayout
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.ui.DefaultTrackNameProvider;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.TrackNameProvider;
import com.google.android.exoplayer2.ui.TrackSelectionView$ComponentListener;
import com.google.android.exoplayer2.ui.TrackSelectionView$TrackInfo;
import com.google.android.exoplayer2.ui.TrackSelectionView$TrackSelectionListener;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.p0.e0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TrackSelectionView
extends LinearLayout {
    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final TrackSelectionView$ComponentListener componentListener;
    private final CheckedTextView defaultView;
    private final CheckedTextView disableView;
    private final LayoutInflater inflater;
    private boolean isDisabled;
    private TrackSelectionView$TrackSelectionListener listener;
    private MappingTrackSelector$MappedTrackInfo mappedTrackInfo;
    private final SparseArray overrides;
    private int rendererIndex;
    private final int selectableItemBackgroundResourceId;
    private TrackGroupArray trackGroups;
    private Comparator trackInfoComparator;
    private TrackNameProvider trackNameProvider;
    private CheckedTextView[][] trackViews;

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        SparseArray sparseArray;
        boolean bl2 = true;
        this.setOrientation((int)(bl2 ? 1 : 0));
        this.overrides = sparseArray = new SparseArray();
        this.setSaveFromParentEnabled(false);
        Object object = context.getTheme();
        int[] nArray = new int[bl2];
        nArray[0] = 16843534;
        object = object.obtainStyledAttributes(nArray);
        this.selectableItemBackgroundResourceId = n11 = object.getResourceId(0, 0);
        object.recycle();
        context = LayoutInflater.from((Context)context);
        this.inflater = context;
        super(this, null);
        this.componentListener = object;
        Resources resources = this.getResources();
        Object object2 = new DefaultTrackNameProvider(resources);
        this.trackNameProvider = object2;
        this.trackGroups = object2 = TrackGroupArray.EMPTY;
        int n12 = 17367055;
        resources = (CheckedTextView)context.inflate(n12, (ViewGroup)this, false);
        this.disableView = resources;
        resources.setBackgroundResource(n11);
        int n13 = R$string.exo_track_selection_none;
        resources.setText(n13);
        resources.setEnabled(false);
        resources.setFocusable(bl2);
        resources.setOnClickListener((View.OnClickListener)object);
        resources.setVisibility(8);
        this.addView((View)resources);
        int n14 = R$layout.exo_list_divider;
        resources = context.inflate(n14, (ViewGroup)this, false);
        this.addView((View)resources);
        context = (CheckedTextView)context.inflate(n12, (ViewGroup)this, false);
        this.defaultView = context;
        context.setBackgroundResource(n11);
        n11 = R$string.exo_track_selection_auto;
        context.setText(n11);
        context.setEnabled(false);
        context.setFocusable(bl2);
        context.setOnClickListener((View.OnClickListener)object);
        this.addView((View)context);
    }

    public static /* synthetic */ int a(Comparator comparator, TrackSelectionView$TrackInfo object, TrackSelectionView$TrackInfo object2) {
        object = ((TrackSelectionView$TrackInfo)object).format;
        object2 = ((TrackSelectionView$TrackInfo)object2).format;
        return comparator.compare(object, object2);
    }

    public static /* synthetic */ void access$100(TrackSelectionView trackSelectionView, View view) {
        trackSelectionView.onClick(view);
    }

    private static int[] getTracksAdding(int[] nArray, int n10) {
        int n11 = nArray.length + 1;
        nArray = Arrays.copyOf(nArray, n11);
        n11 = nArray.length + -1;
        nArray[n11] = n10;
        return nArray;
    }

    private static int[] getTracksRemoving(int[] nArray, int n10) {
        int n11 = nArray.length + -1;
        int[] nArray2 = new int[n11];
        int n12 = nArray.length;
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14 = nArray[i10];
            if (n14 == n10) continue;
            int n15 = n13 + 1;
            nArray2[n13] = n14;
            n13 = n15;
        }
        return nArray2;
    }

    private void onClick(View object) {
        CheckedTextView checkedTextView = this.disableView;
        if (object == checkedTextView) {
            this.onDisableViewClicked();
        } else {
            checkedTextView = this.defaultView;
            if (object == checkedTextView) {
                this.onDefaultViewClicked();
            } else {
                this.onTrackViewClicked((View)object);
            }
        }
        this.updateViewStates();
        object = this.listener;
        if (object != null) {
            boolean bl2 = this.getIsDisabled();
            List list = this.getOverrides();
            object.onTrackSelectionChanged(bl2, list);
        }
    }

    private void onDefaultViewClicked() {
        this.isDisabled = false;
        this.overrides.clear();
    }

    private void onDisableViewClicked() {
        this.isDisabled = true;
        this.overrides.clear();
    }

    private void onTrackViewClicked(View object) {
        SparseArray sparseArray = null;
        this.isDisabled = false;
        Object object2 = (TrackSelectionView$TrackInfo)Assertions.checkNotNull(object.getTag());
        int n10 = ((TrackSelectionView$TrackInfo)object2).groupIndex;
        int n11 = ((TrackSelectionView$TrackInfo)object2).trackIndex;
        Object object3 = (DefaultTrackSelector$SelectionOverride)this.overrides.get(n10);
        Object object4 = this.mappedTrackInfo;
        Assertions.checkNotNull(object4);
        int n12 = 1;
        if (object3 == null) {
            int n13 = this.allowMultipleOverrides;
            if (n13 == 0 && (n13 = (object = this.overrides).size()) > 0) {
                object = this.overrides;
                object.clear();
            }
            object = this.overrides;
            object4 = new int[n12];
            object4[0] = n11;
            object3 = new DefaultTrackSelector$SelectionOverride(n10, (int[])object4);
            object.put(n10, object3);
        } else {
            int n14;
            int n15 = ((DefaultTrackSelector$SelectionOverride)object3).length;
            object3 = ((DefaultTrackSelector$SelectionOverride)object3).tracks;
            object = (CheckedTextView)object;
            boolean bl2 = object.isChecked();
            boolean bl3 = this.shouldEnableAdaptiveSelection(n10);
            n14 = !bl3 && (n14 = (int)(this.shouldEnableMultiGroupSelection() ? 1 : 0)) == 0 ? 0 : n12;
            if (bl2 && n14 != 0) {
                if (n15 == n12) {
                    object = this.overrides;
                    object.remove(n10);
                } else {
                    object = TrackSelectionView.getTracksRemoving((int[])object3, n11);
                    sparseArray = this.overrides;
                    object2 = new DefaultTrackSelector$SelectionOverride(n10, (int[])object);
                    sparseArray.put(n10, object2);
                }
            } else if (!bl2) {
                if (bl3) {
                    object = TrackSelectionView.getTracksAdding((int[])object3, n11);
                    sparseArray = this.overrides;
                    object2 = new DefaultTrackSelector$SelectionOverride(n10, (int[])object);
                    sparseArray.put(n10, object2);
                } else {
                    object = this.overrides;
                    object4 = new int[n12];
                    object4[0] = n11;
                    object3 = new DefaultTrackSelector$SelectionOverride(n10, (int[])object4);
                    object.put(n10, object3);
                }
            }
        }
    }

    private boolean shouldEnableAdaptiveSelection(int n10) {
        int n11;
        block3: {
            block2: {
                int n12;
                int n13 = this.allowAdaptiveSelections;
                n11 = 1;
                if (n13 == 0) break block2;
                Object object = this.trackGroups.get(n10);
                n13 = ((TrackGroup)object).length;
                if (n13 > n11 && (n10 = ((MappingTrackSelector$MappedTrackInfo)(object = this.mappedTrackInfo)).getAdaptiveSupport(n12 = this.rendererIndex, n10, false)) != 0) break block3;
            }
            n11 = 0;
        }
        return n11 != 0;
    }

    private boolean shouldEnableMultiGroupSelection() {
        int n10;
        block3: {
            block2: {
                int n11 = this.allowMultipleOverrides;
                n10 = 1;
                if (n11 == 0) break block2;
                TrackGroupArray trackGroupArray = this.trackGroups;
                n11 = trackGroupArray.length;
                if (n11 > n10) break block3;
            }
            n10 = 0;
        }
        return n10 != 0;
    }

    private void updateViewStates() {
        Object object;
        CheckedTextView checkedTextView = this.disableView;
        int n10 = this.isDisabled;
        checkedTextView.setChecked(n10 != 0);
        checkedTextView = this.defaultView;
        n10 = this.isDisabled;
        if (n10 == 0 && (n10 = (object = this.overrides).size()) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        checkedTextView.setChecked(n10 != 0);
        checkedTextView = null;
        for (int i10 = 0; i10 < (n10 = ((CheckedTextView[][])(object = this.trackViews)).length); ++i10) {
            Object object2;
            CheckedTextView checkedTextView2;
            int n11;
            object = (DefaultTrackSelector$SelectionOverride)this.overrides.get(i10);
            for (int i11 = 0; i11 < (n11 = ((CheckedTextView[])(checkedTextView2 = (object2 = this.trackViews)[i10])).length); ++i11) {
                if (object != null) {
                    object2 = (TrackSelectionView$TrackInfo)Assertions.checkNotNull(object2[i10][i11].getTag());
                    checkedTextView2 = this.trackViews[i10][i11];
                    boolean bl2 = object2.trackIndex;
                    bl2 = ((DefaultTrackSelector$SelectionOverride)object).containsTrack((int)(bl2 ? 1 : 0));
                    checkedTextView2.setChecked(bl2);
                    continue;
                }
                object2 = object2[i10][i11];
                object2.setChecked(false);
            }
        }
    }

    private void updateViews() {
        int n10;
        int n11 = this.getChildCount();
        int n12 = 1;
        n11 -= n12;
        while (n11 >= (n10 = 3)) {
            this.removeViewAt(n11);
            n11 += -1;
        }
        CheckedTextView[][] checkedTextViewArrayArray = this.mappedTrackInfo;
        n10 = 0;
        if (checkedTextViewArrayArray == null) {
            this.disableView.setEnabled(false);
            this.defaultView.setEnabled(false);
            return;
        }
        this.disableView.setEnabled(n12 != 0);
        this.defaultView.setEnabled(n12 != 0);
        checkedTextViewArrayArray = this.mappedTrackInfo;
        int n13 = this.rendererIndex;
        checkedTextViewArrayArray = checkedTextViewArrayArray.getTrackGroups(n13);
        this.trackGroups = checkedTextViewArrayArray;
        checkedTextViewArrayArray = new CheckedTextView[checkedTextViewArrayArray.length][];
        this.trackViews = checkedTextViewArrayArray;
        n11 = (int)(this.shouldEnableMultiGroupSelection() ? 1 : 0);
        n13 = 0;
        while (true) {
            Object object;
            Format format;
            int n14;
            int n15;
            Object object2 = this.trackGroups;
            int n16 = ((TrackGroupArray)object2).length;
            if (n13 >= n16) break;
            object2 = ((TrackGroupArray)object2).get(n13);
            n16 = (int)(this.shouldEnableAdaptiveSelection(n13) ? 1 : 0);
            CheckedTextView[][] checkedTextViewArray = this.trackViews;
            int n17 = ((TrackGroup)object2).length;
            LayoutInflater layoutInflater = new CheckedTextView[n17];
            checkedTextViewArray[n13] = layoutInflater;
            checkedTextViewArray = new TrackSelectionView$TrackInfo[n17];
            layoutInflater = null;
            for (n15 = 0; n15 < (n14 = ((TrackGroup)object2).length); ++n15) {
                format = ((TrackGroup)object2).getFormat(n15);
                object = new TrackSelectionView$TrackInfo(n13, n15, format);
                checkedTextViewArray[n15] = object;
            }
            object2 = this.trackInfoComparator;
            if (object2 != null) {
                Arrays.sort(checkedTextViewArray, object2);
            }
            object2 = null;
            for (int i10 = 0; i10 < n17; ++i10) {
                if (i10 == 0) {
                    layoutInflater = this.inflater;
                    n14 = R$layout.exo_list_divider;
                    layoutInflater = layoutInflater.inflate(n14, (ViewGroup)this, false);
                    this.addView((View)layoutInflater);
                }
                n15 = n16 == 0 && n11 == 0 ? 17367055 : 0x1090010;
                layoutInflater = (CheckedTextView)this.inflater.inflate(n15, (ViewGroup)this, false);
                n14 = this.selectableItemBackgroundResourceId;
                layoutInflater.setBackgroundResource(n14);
                object = this.trackNameProvider;
                format = checkedTextViewArray[i10].format;
                object = object.getTrackName(format);
                layoutInflater.setText((CharSequence)object);
                object = checkedTextViewArray[i10];
                layoutInflater.setTag(object);
                object = this.mappedTrackInfo;
                int n18 = this.rendererIndex;
                n14 = ((MappingTrackSelector$MappedTrackInfo)object).getTrackSupport(n18, n13, i10);
                n18 = 4;
                if (n14 == n18) {
                    layoutInflater.setFocusable(n12 != 0);
                    object = this.componentListener;
                    layoutInflater.setOnClickListener((View.OnClickListener)object);
                } else {
                    layoutInflater.setFocusable(false);
                    layoutInflater.setEnabled(false);
                }
                object = this.trackViews[n13];
                object[i10] = layoutInflater;
                this.addView((View)layoutInflater);
            }
            ++n13;
        }
        this.updateViewStates();
    }

    public boolean getIsDisabled() {
        return this.isDisabled;
    }

    public List getOverrides() {
        Object object;
        int n10;
        int n11 = this.overrides.size();
        ArrayList<SparseArray> arrayList = new ArrayList<SparseArray>(n11);
        for (n11 = 0; n11 < (n10 = (object = this.overrides).size()); ++n11) {
            object = (DefaultTrackSelector$SelectionOverride)this.overrides.valueAt(n11);
            arrayList.add((SparseArray)object);
        }
        return arrayList;
    }

    public void init(MappingTrackSelector$MappedTrackInfo object, int n10, boolean bl2, List list, Comparator comparator, TrackSelectionView$TrackSelectionListener trackSelectionView$TrackSelectionListener) {
        int n11;
        this.mappedTrackInfo = object;
        this.rendererIndex = n10;
        this.isDisabled = bl2;
        if (comparator == null) {
            n11 = 0;
            object = null;
        } else {
            object = new e0(comparator);
        }
        this.trackInfoComparator = object;
        this.listener = trackSelectionView$TrackSelectionListener;
        n11 = this.allowMultipleOverrides;
        if (n11 != 0) {
            n11 = list.size();
        } else {
            n11 = list.size();
            n10 = 1;
            n11 = Math.min(n11, n10);
        }
        for (n10 = 0; n10 < n11; ++n10) {
            DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = (DefaultTrackSelector$SelectionOverride)list.get(n10);
            comparator = this.overrides;
            int n12 = defaultTrackSelector$SelectionOverride.groupIndex;
            comparator.put(n12, defaultTrackSelector$SelectionOverride);
        }
        this.updateViews();
    }

    public void setAllowAdaptiveSelections(boolean bl2) {
        boolean bl3 = this.allowAdaptiveSelections;
        if (bl3 != bl2) {
            this.allowAdaptiveSelections = bl2;
            this.updateViews();
        }
    }

    public void setAllowMultipleOverrides(boolean n10) {
        int n11 = (int)(this.allowMultipleOverrides ? 1 : 0);
        if (n11 != n10) {
            SparseArray sparseArray;
            this.allowMultipleOverrides = n10;
            if (n10 == 0 && (n10 = (sparseArray = this.overrides).size()) > (n11 = 1)) {
                sparseArray = this.overrides;
                for (n10 = sparseArray.size() - n11; n10 > 0; n10 += -1) {
                    SparseArray sparseArray2 = this.overrides;
                    sparseArray2.remove(n10);
                }
            }
            this.updateViews();
        }
    }

    public void setShowDisableOption(boolean n10) {
        CheckedTextView checkedTextView = this.disableView;
        n10 = n10 != 0 ? 0 : 8;
        checkedTextView.setVisibility(n10);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.trackNameProvider = trackNameProvider = (TrackNameProvider)Assertions.checkNotNull(trackNameProvider);
        this.updateViews();
    }
}

