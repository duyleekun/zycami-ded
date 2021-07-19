/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters$1;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters$Builder;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.List;

public class TrackSelectionParameters
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    public final ImmutableList preferredAudioLanguages;
    public final int preferredAudioRoleFlags;
    public final ImmutableList preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    static {
        Object object = new TrackSelectionParameters$Builder();
        DEFAULT_WITHOUT_CONTEXT = object = ((TrackSelectionParameters$Builder)object).build();
        DEFAULT = object;
        object = new TrackSelectionParameters$1();
        CREATOR = object;
    }

    public TrackSelectionParameters(Parcel parcel) {
        int n10;
        int n11;
        AbstractCollection abstractCollection = new AbstractCollection();
        parcel.readList(abstractCollection, null);
        abstractCollection = ImmutableList.copyOf(abstractCollection);
        this.preferredAudioLanguages = abstractCollection;
        this.preferredAudioRoleFlags = n11 = parcel.readInt();
        abstractCollection = new AbstractCollection();
        parcel.readList(abstractCollection, null);
        abstractCollection = ImmutableList.copyOf(abstractCollection);
        this.preferredTextLanguages = abstractCollection;
        this.preferredTextRoleFlags = n11 = parcel.readInt();
        n11 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        this.selectUndeterminedTextLanguage = n11;
        this.disabledTextTrackSelectionFlags = n10 = parcel.readInt();
    }

    public TrackSelectionParameters(ImmutableList immutableList, int n10, ImmutableList immutableList2, int n11, boolean bl2, int n12) {
        this.preferredAudioLanguages = immutableList;
        this.preferredAudioRoleFlags = n10;
        this.preferredTextLanguages = immutableList2;
        this.preferredTextRoleFlags = n11;
        this.selectUndeterminedTextLanguage = bl2;
        this.disabledTextTrackSelectionFlags = n12;
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        TrackSelectionParameters$Builder trackSelectionParameters$Builder = new TrackSelectionParameters$Builder(context);
        return trackSelectionParameters$Builder.build();
    }

    public TrackSelectionParameters$Builder buildUpon() {
        TrackSelectionParameters$Builder trackSelectionParameters$Builder = new TrackSelectionParameters$Builder(this);
        return trackSelectionParameters$Builder;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Serializable serializable;
        Serializable serializable2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (serializable2 = this.getClass()) == (serializable = object.getClass())) {
            int n10;
            int n11;
            int n12;
            int n13;
            boolean bl3;
            int n14;
            int n15;
            object = (TrackSelectionParameters)object;
            serializable2 = this.preferredAudioLanguages;
            serializable = ((TrackSelectionParameters)object).preferredAudioLanguages;
            boolean n122 = ((ImmutableList)serializable2).equals(serializable);
            if (!n122 || (n15 = this.preferredAudioRoleFlags) != (n14 = ((TrackSelectionParameters)object).preferredAudioRoleFlags) || !(bl3 = ((ImmutableList)(serializable2 = this.preferredTextLanguages)).equals(serializable = ((TrackSelectionParameters)object).preferredTextLanguages)) || (n13 = this.preferredTextRoleFlags) != (n14 = ((TrackSelectionParameters)object).preferredTextRoleFlags) || (n12 = this.selectUndeterminedTextLanguage) != (n14 = (int)(((TrackSelectionParameters)object).selectUndeterminedTextLanguage ? 1 : 0)) || (n11 = this.disabledTextTrackSelectionFlags) != (n10 = ((TrackSelectionParameters)object).disabledTextTrackSelectionFlags)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.preferredAudioLanguages.hashCode();
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        int n12 = this.preferredAudioRoleFlags;
        n10 = (n10 + n12) * n11;
        n12 = this.preferredTextLanguages.hashCode();
        n10 = (n10 + n12) * n11;
        n12 = this.preferredTextRoleFlags;
        n10 = (n10 + n12) * n11;
        n12 = (int)(this.selectUndeterminedTextLanguage ? 1 : 0);
        n10 = (n10 + n12) * n11;
        n11 = this.disabledTextTrackSelectionFlags;
        return n10 + n11;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        ImmutableList immutableList = this.preferredAudioLanguages;
        parcel.writeList((List)immutableList);
        n10 = this.preferredAudioRoleFlags;
        parcel.writeInt(n10);
        immutableList = this.preferredTextLanguages;
        parcel.writeList((List)immutableList);
        n10 = this.preferredTextRoleFlags;
        parcel.writeInt(n10);
        n10 = (int)(this.selectUndeterminedTextLanguage ? 1 : 0);
        Util.writeBoolean(parcel, n10 != 0);
        n10 = this.disabledTextTrackSelectionFlags;
        parcel.writeInt(n10);
    }
}

