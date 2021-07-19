/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.exoplayer2.source.ads;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.source.ads.AdsLoader$OverlayInfo;
import com.google.common.collect.ImmutableList$Builder;
import java.util.List;

public interface AdsLoader$AdViewProvider {
    default public List getAdOverlayInfos() {
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        for (View view : this.getAdOverlayViews()) {
            AdsLoader$OverlayInfo adsLoader$OverlayInfo = new AdsLoader$OverlayInfo(view, 0);
            immutableList$Builder.add(adsLoader$OverlayInfo);
        }
        return immutableList$Builder.build();
    }

    default public View[] getAdOverlayViews() {
        return new View[0];
    }

    public ViewGroup getAdViewGroup();
}

