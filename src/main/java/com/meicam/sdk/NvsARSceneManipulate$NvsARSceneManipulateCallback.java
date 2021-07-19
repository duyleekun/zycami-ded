/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import java.util.List;

public interface NvsARSceneManipulate$NvsARSceneManipulateCallback {
    public void notifyCustomAvatarRealtimeResourcesPreloaded(boolean var1);

    public void notifyDetectionTimeCost(float var1);

    public void notifyFaceBoundingRect(List var1);

    public void notifyFaceFeatureInfos(List var1);

    public void notifyTotalTimeCost(float var1);
}

