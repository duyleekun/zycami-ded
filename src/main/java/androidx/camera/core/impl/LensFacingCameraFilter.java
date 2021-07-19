/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

public class LensFacingCameraFilter
implements CameraFilter {
    private int mLensFacing;

    public LensFacingCameraFilter(int n10) {
        this.mLensFacing = n10;
    }

    public List filter(List object) {
        boolean bl2;
        ArrayList<CameraInfo> arrayList = new ArrayList<CameraInfo>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            int n10;
            CameraInfo cameraInfo = (CameraInfo)object.next();
            int n11 = cameraInfo instanceof CameraInfoInternal;
            String string2 = "The camera info doesn't contain internal implementation.";
            Preconditions.checkArgument(n11 != 0, string2);
            Object object2 = cameraInfo;
            object2 = ((CameraInfoInternal)cameraInfo).getLensFacing();
            if (object2 == null || (n11 = ((Integer)object2).intValue()) != (n10 = this.mLensFacing)) continue;
            arrayList.add(cameraInfo);
        }
        return arrayList;
    }

    public int getLensFacing() {
        return this.mLensFacing;
    }
}

