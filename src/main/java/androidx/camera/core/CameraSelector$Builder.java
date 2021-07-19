/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.LensFacingCameraFilter;
import java.util.LinkedHashSet;

public final class CameraSelector$Builder {
    private final LinkedHashSet mCameraFilterSet;

    public CameraSelector$Builder() {
        LinkedHashSet linkedHashSet;
        this.mCameraFilterSet = linkedHashSet = new LinkedHashSet();
    }

    private CameraSelector$Builder(LinkedHashSet linkedHashSet) {
        LinkedHashSet linkedHashSet2;
        this.mCameraFilterSet = linkedHashSet2 = new LinkedHashSet(linkedHashSet);
    }

    public static CameraSelector$Builder fromSelector(CameraSelector object) {
        object = ((CameraSelector)object).getCameraFilterSet();
        CameraSelector$Builder cameraSelector$Builder = new CameraSelector$Builder((LinkedHashSet)object);
        return cameraSelector$Builder;
    }

    public CameraSelector$Builder addCameraFilter(CameraFilter cameraFilter) {
        this.mCameraFilterSet.add(cameraFilter);
        return this;
    }

    public CameraSelector build() {
        LinkedHashSet linkedHashSet = this.mCameraFilterSet;
        CameraSelector cameraSelector = new CameraSelector(linkedHashSet);
        return cameraSelector;
    }

    public CameraSelector$Builder requireLensFacing(int n10) {
        LinkedHashSet linkedHashSet = this.mCameraFilterSet;
        LensFacingCameraFilter lensFacingCameraFilter = new LensFacingCameraFilter(n10);
        linkedHashSet.add(lensFacingCameraFilter);
        return this;
    }
}

