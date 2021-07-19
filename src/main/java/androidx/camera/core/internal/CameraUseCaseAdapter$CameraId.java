/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.CameraInternal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public final class CameraUseCaseAdapter$CameraId {
    private final List mIds;

    public CameraUseCaseAdapter$CameraId(LinkedHashSet object) {
        boolean bl2;
        Object object2 = new ArrayList();
        this.mIds = object2;
        object = ((HashSet)object).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (CameraInternal)object.next();
            List list = this.mIds;
            object2 = object2.getCameraInfoInternal().getCameraId();
            list.add(object2);
        }
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof CameraUseCaseAdapter$CameraId;
        if (bl2) {
            List list = this.mIds;
            object = ((CameraUseCaseAdapter$CameraId)object).mIds;
            return list.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.mIds.hashCode() * 53;
    }
}

