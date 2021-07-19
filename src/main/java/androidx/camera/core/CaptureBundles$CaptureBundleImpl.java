/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.impl.CaptureBundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CaptureBundles$CaptureBundleImpl
implements CaptureBundle {
    public final List mCaptureStageList;

    public CaptureBundles$CaptureBundleImpl(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            ArrayList arrayList = new ArrayList(list);
            this.mCaptureStageList = list = Collections.unmodifiableList(arrayList);
            return;
        }
        list = new List("Cannot set an empty CaptureStage list.");
        throw list;
    }

    public List getCaptureStages() {
        return this.mCaptureStageList;
    }
}

