/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.view.accessibility.CaptioningManager
 */
package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import java.util.Locale;

public class TrackSelectionParameters$Builder {
    public int disabledTextTrackSelectionFlags;
    public ImmutableList preferredAudioLanguages;
    public int preferredAudioRoleFlags;
    public ImmutableList preferredTextLanguages;
    public int preferredTextRoleFlags;
    public boolean selectUndeterminedTextLanguage;

    public TrackSelectionParameters$Builder() {
        ImmutableList immutableList;
        ImmutableList immutableList2;
        this.preferredAudioLanguages = immutableList2 = ImmutableList.of();
        this.preferredAudioRoleFlags = 0;
        this.preferredTextLanguages = immutableList = ImmutableList.of();
        this.preferredTextRoleFlags = 0;
        this.selectUndeterminedTextLanguage = false;
        this.disabledTextTrackSelectionFlags = 0;
    }

    public TrackSelectionParameters$Builder(Context context) {
        this();
        this.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
    }

    public TrackSelectionParameters$Builder(TrackSelectionParameters trackSelectionParameters) {
        int n10;
        int n11;
        ImmutableList immutableList;
        this.preferredAudioLanguages = immutableList = trackSelectionParameters.preferredAudioLanguages;
        this.preferredAudioRoleFlags = n11 = trackSelectionParameters.preferredAudioRoleFlags;
        this.preferredTextLanguages = immutableList = trackSelectionParameters.preferredTextLanguages;
        this.preferredTextRoleFlags = n11 = trackSelectionParameters.preferredTextRoleFlags;
        n11 = (int)(trackSelectionParameters.selectUndeterminedTextLanguage ? 1 : 0);
        this.selectUndeterminedTextLanguage = n11;
        this.disabledTextTrackSelectionFlags = n10 = trackSelectionParameters.disabledTextTrackSelectionFlags;
    }

    private void setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(Context object) {
        Object object2;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 < n11 && (object2 = Looper.myLooper()) == null) {
            return;
        }
        object2 = "captioning";
        if ((object = (CaptioningManager)object.getSystemService((String)object2)) != null && (n10 = (int)(object.isEnabled() ? 1 : 0)) != 0) {
            this.preferredTextRoleFlags = n10 = 1088;
            if ((object = object.getLocale()) != null) {
                object = ImmutableList.of(Util.getLocaleLanguageTag((Locale)object));
                this.preferredTextLanguages = object;
            }
        }
    }

    public TrackSelectionParameters build() {
        ImmutableList immutableList = this.preferredAudioLanguages;
        int n10 = this.preferredAudioRoleFlags;
        ImmutableList immutableList2 = this.preferredTextLanguages;
        int n11 = this.preferredTextRoleFlags;
        boolean bl2 = this.selectUndeterminedTextLanguage;
        int n12 = this.disabledTextTrackSelectionFlags;
        TrackSelectionParameters trackSelectionParameters = new TrackSelectionParameters(immutableList, n10, immutableList2, n11, bl2, n12);
        return trackSelectionParameters;
    }

    public TrackSelectionParameters$Builder setDisabledTextTrackSelectionFlags(int n10) {
        this.disabledTextTrackSelectionFlags = n10;
        return this;
    }

    public TrackSelectionParameters$Builder setPreferredAudioLanguage(String object) {
        if (object == null) {
            object = new String[]{};
            object = this.setPreferredAudioLanguages((String)object);
        } else {
            int n10 = 1;
            String[] stringArray = new String[n10];
            stringArray[0] = object;
            object = this.setPreferredAudioLanguages(stringArray);
        }
        return object;
    }

    public TrackSelectionParameters$Builder setPreferredAudioLanguages(String ... object) {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        object = (String[])Assertions.checkNotNull(object);
        int n10 = ((String[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = Util.normalizeLanguageCode((String)Assertions.checkNotNull(object[i10]));
            immutableList$Builder.add(string2);
        }
        this.preferredAudioLanguages = object = immutableList$Builder.build();
        return this;
    }

    public TrackSelectionParameters$Builder setPreferredAudioRoleFlags(int n10) {
        this.preferredAudioRoleFlags = n10;
        return this;
    }

    public TrackSelectionParameters$Builder setPreferredTextLanguage(String object) {
        if (object == null) {
            object = new String[]{};
            object = this.setPreferredTextLanguages((String)object);
        } else {
            int n10 = 1;
            String[] stringArray = new String[n10];
            stringArray[0] = object;
            object = this.setPreferredTextLanguages(stringArray);
        }
        return object;
    }

    public TrackSelectionParameters$Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
        int n10 = Util.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            this.setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettingsV19(context);
        }
        return this;
    }

    public TrackSelectionParameters$Builder setPreferredTextLanguages(String ... object) {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        object = (String[])Assertions.checkNotNull(object);
        int n10 = ((String[])object).length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = Util.normalizeLanguageCode((String)Assertions.checkNotNull(object[i10]));
            immutableList$Builder.add(string2);
        }
        this.preferredTextLanguages = object = immutableList$Builder.build();
        return this;
    }

    public TrackSelectionParameters$Builder setPreferredTextRoleFlags(int n10) {
        this.preferredTextRoleFlags = n10;
        return this;
    }

    public TrackSelectionParameters$Builder setSelectUndeterminedTextLanguage(boolean bl2) {
        this.selectUndeterminedTextLanguage = bl2;
        return this;
    }
}

