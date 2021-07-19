/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.view.LayoutInflater
 *  android.view.View
 */
package com.google.android.exoplayer2.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelectionUtil;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.TrackNameProvider;
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder$DialogCallback;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.p0.c0;
import d.h.a.a.p0.d0;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class TrackSelectionDialogBuilder {
    private boolean allowAdaptiveSelections;
    private boolean allowMultipleOverrides;
    private final TrackSelectionDialogBuilder$DialogCallback callback;
    private final Context context;
    private boolean isDisabled;
    private final MappingTrackSelector$MappedTrackInfo mappedTrackInfo;
    private List overrides;
    private final int rendererIndex;
    private boolean showDisableOption;
    private int themeResId;
    private final CharSequence title;
    private Comparator trackFormatComparator;
    private TrackNameProvider trackNameProvider;

    public TrackSelectionDialogBuilder(Context object, CharSequence object2, DefaultTrackSelector defaultTrackSelector, int n10) {
        boolean bl2;
        this.context = object;
        this.title = object2;
        object = (MappingTrackSelector$MappedTrackInfo)Assertions.checkNotNull(defaultTrackSelector.getCurrentMappedTrackInfo());
        this.mappedTrackInfo = object;
        this.rendererIndex = n10;
        object = ((MappingTrackSelector$MappedTrackInfo)object).getTrackGroups(n10);
        object2 = defaultTrackSelector.getParameters();
        this.isDisabled = bl2 = ((DefaultTrackSelector$Parameters)object2).getRendererDisabled(n10);
        List<Object> list = ((DefaultTrackSelector$Parameters)object2).getSelectionOverride(n10, (TrackGroupArray)object);
        list = list == null ? Collections.emptyList() : Collections.singletonList(list);
        this.overrides = list;
        this.callback = list = new c0(defaultTrackSelector, (DefaultTrackSelector$Parameters)object2, n10, (TrackGroupArray)object);
    }

    public TrackSelectionDialogBuilder(Context object, CharSequence charSequence, MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, int n10, TrackSelectionDialogBuilder$DialogCallback trackSelectionDialogBuilder$DialogCallback) {
        this.context = object;
        this.title = charSequence;
        this.mappedTrackInfo = mappingTrackSelector$MappedTrackInfo;
        this.rendererIndex = n10;
        this.callback = trackSelectionDialogBuilder$DialogCallback;
        object = Collections.emptyList();
        this.overrides = object;
    }

    public static /* synthetic */ void a(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int n10, TrackGroupArray trackGroupArray, boolean bl2, List object) {
        boolean bl3 = object.isEmpty();
        if (bl3) {
            object = null;
        } else {
            bl3 = false;
            object = (DefaultTrackSelector$SelectionOverride)object.get(0);
        }
        defaultTrackSelector$Parameters = TrackSelectionUtil.updateParametersWithOverride(defaultTrackSelector$Parameters, n10, trackGroupArray, bl2, (DefaultTrackSelector$SelectionOverride)object);
        defaultTrackSelector.setParameters(defaultTrackSelector$Parameters);
    }

    private /* synthetic */ void b(TrackSelectionView object, DialogInterface object2, int n10) {
        object2 = this.callback;
        n10 = (int)(object.getIsDisabled() ? 1 : 0);
        object = object.getOverrides();
        object2.onTracksSelected(n10 != 0, (List)object);
    }

    private Dialog buildForAndroidX() {
        Object var1_1 = null;
        Object object = "androidx.appcompat.app.AlertDialog$Builder";
        object = Class.forName((String)object);
        int n10 = 2;
        Object object2 = new Class[n10];
        Class[] classArray = Context.class;
        object2[0] = classArray;
        classArray = Integer.TYPE;
        int n11 = 1;
        object2[n11] = classArray;
        object2 = ((Class)object).getConstructor((Class<?>)object2);
        Object object3 = new Object[n10];
        Object[] objectArray = this.context;
        object3[0] = objectArray;
        int n12 = this.themeResId;
        objectArray = n12;
        object3[n11] = objectArray;
        object2 = object2.newInstance((Object[])object3);
        object3 = "getContext";
        objectArray = new Class[]{};
        object3 = ((Class)object).getMethod((String)object3, (Class<?>[])objectArray);
        objectArray = new Object[]{};
        object3 = ((Method)object3).invoke(object2, objectArray);
        object3 = (Context)object3;
        object3 = LayoutInflater.from((Context)object3);
        n12 = R$layout.exo_track_selection_dialog;
        object3 = object3.inflate(n12, null);
        objectArray = this.setUpDialogView((View)object3);
        Object[] objectArray2 = "setTitle";
        Object object4 = new Class[n11];
        Class<View> clazz = CharSequence.class;
        object4[0] = clazz;
        objectArray2 = ((Class)object).getMethod((String)objectArray2, (Class<?>[])object4);
        object4 = new Object[n11];
        clazz = this.title;
        object4[0] = clazz;
        objectArray2.invoke(object2, object4);
        objectArray2 = "setView";
        object4 = new Class[n11];
        clazz = View.class;
        object4[0] = clazz;
        objectArray2 = ((Class)object).getMethod((String)objectArray2, (Class<?>[])object4);
        object4 = new Object[n11];
        object4[0] = object3;
        objectArray2.invoke(object2, object4);
        object3 = "setPositiveButton";
        objectArray2 = new Class[n10];
        objectArray2[0] = classArray;
        object4 = DialogInterface.OnClickListener.class;
        objectArray2[n11] = object4;
        object3 = ((Class)object).getMethod((String)object3, (Class<?>[])objectArray2);
        objectArray2 = new Object[n10];
        int n13 = 17039370;
        object4 = n13;
        objectArray2[0] = object4;
        objectArray2[n11] = objectArray;
        ((Method)object3).invoke(object2, objectArray2);
        object3 = "setNegativeButton";
        objectArray = new Class[n10];
        objectArray[0] = classArray;
        classArray = DialogInterface.OnClickListener.class;
        objectArray[n11] = classArray;
        classArray = ((Class)object).getMethod((String)object3, (Class<?>[])objectArray);
        Object[] objectArray3 = new Object[n10];
        int n14 = 0x1040000;
        object3 = n14;
        objectArray3[0] = object3;
        objectArray3[n11] = null;
        classArray.invoke(object2, objectArray3);
        objectArray3 = "create";
        classArray = new Class[]{};
        object = ((Class)object).getMethod((String)objectArray3, classArray);
        objectArray3 = new Object[]{};
        object = ((Method)object).invoke(object2, objectArray3);
        try {
            return (Dialog)object;
        }
        catch (Exception exception) {
            object = new IllegalStateException(exception);
            throw object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    private Dialog buildForPlatform() {
        Context context = this.context;
        int n10 = this.themeResId;
        AlertDialog.Builder builder = new AlertDialog.Builder(context, n10);
        context = LayoutInflater.from((Context)builder.getContext());
        n10 = R$layout.exo_track_selection_dialog;
        context = context.inflate(n10, null);
        DialogInterface.OnClickListener onClickListener = this.setUpDialogView((View)context);
        CharSequence charSequence = this.title;
        return builder.setTitle(charSequence).setView((View)context).setPositiveButton(17039370, onClickListener).setNegativeButton(0x1040000, null).create();
    }

    private DialogInterface.OnClickListener setUpDialogView(View object) {
        int bl2 = R$id.exo_track_selection_view;
        object = (TrackSelectionView)object.findViewById(bl2);
        boolean bl3 = this.allowMultipleOverrides;
        ((TrackSelectionView)((Object)object)).setAllowMultipleOverrides(bl3);
        boolean bl4 = this.allowAdaptiveSelections;
        ((TrackSelectionView)((Object)object)).setAllowAdaptiveSelections(bl4);
        boolean bl5 = this.showDisableOption;
        ((TrackSelectionView)((Object)object)).setShowDisableOption(bl5);
        Object object2 = this.trackNameProvider;
        if (object2 != null) {
            ((TrackSelectionView)((Object)object)).setTrackNameProvider((TrackNameProvider)object2);
        }
        MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo = this.mappedTrackInfo;
        int n10 = this.rendererIndex;
        boolean bl6 = this.isDisabled;
        List list = this.overrides;
        Comparator comparator = this.trackFormatComparator;
        object2 = object;
        ((TrackSelectionView)((Object)object)).init(mappingTrackSelector$MappedTrackInfo, n10, bl6, list, comparator, null);
        object2 = new d0(this, (TrackSelectionView)((Object)object));
        return object2;
    }

    public Dialog build() {
        Dialog dialog = this.buildForAndroidX();
        if (dialog == null) {
            dialog = this.buildForPlatform();
        }
        return dialog;
    }

    public /* synthetic */ void c(TrackSelectionView trackSelectionView, DialogInterface dialogInterface, int n10) {
        this.b(trackSelectionView, dialogInterface, n10);
    }

    public TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean bl2) {
        this.allowAdaptiveSelections = bl2;
        return this;
    }

    public TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean bl2) {
        this.allowMultipleOverrides = bl2;
        return this;
    }

    public TrackSelectionDialogBuilder setIsDisabled(boolean bl2) {
        this.isDisabled = bl2;
        return this;
    }

    public TrackSelectionDialogBuilder setOverride(DefaultTrackSelector$SelectionOverride list) {
        list = list == null ? Collections.emptyList() : Collections.singletonList(list);
        return this.setOverrides(list);
    }

    public TrackSelectionDialogBuilder setOverrides(List list) {
        this.overrides = list;
        return this;
    }

    public TrackSelectionDialogBuilder setShowDisableOption(boolean bl2) {
        this.showDisableOption = bl2;
        return this;
    }

    public TrackSelectionDialogBuilder setTheme(int n10) {
        this.themeResId = n10;
        return this;
    }

    public void setTrackFormatComparator(Comparator comparator) {
        this.trackFormatComparator = comparator;
    }

    public TrackSelectionDialogBuilder setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.trackNameProvider = trackNameProvider;
        return this;
    }
}

