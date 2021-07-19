/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector$Builder;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public final class CameraSelector {
    public static final CameraSelector DEFAULT_BACK_CAMERA;
    public static final CameraSelector DEFAULT_FRONT_CAMERA;
    public static final int LENS_FACING_BACK = 1;
    public static final int LENS_FACING_FRONT;
    private LinkedHashSet mCameraFilterSet;

    static {
        CameraSelector$Builder cameraSelector$Builder = new CameraSelector$Builder();
        DEFAULT_FRONT_CAMERA = cameraSelector$Builder.requireLensFacing(0).build();
        cameraSelector$Builder = new CameraSelector$Builder();
        DEFAULT_BACK_CAMERA = cameraSelector$Builder.requireLensFacing(1).build();
    }

    public CameraSelector(LinkedHashSet linkedHashSet) {
        this.mCameraFilterSet = linkedHashSet;
    }

    public LinkedHashSet filter(LinkedHashSet object) {
        Object object2;
        boolean bl2;
        List<CameraInfo> list = new List<CameraInfo>();
        LinkedHashSet<Object> linkedHashSet = ((HashSet)object).iterator();
        while (bl2 = linkedHashSet.hasNext()) {
            object2 = ((CameraInternal)linkedHashSet.next()).getCameraInfo();
            list.add((CameraInfo)object2);
        }
        list = this.filter(list);
        linkedHashSet = new LinkedHashSet<Object>();
        object = ((HashSet)object).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (CameraInternal)object.next();
            CameraInfo cameraInfo = object2.getCameraInfo();
            boolean bl3 = list.contains(cameraInfo);
            if (!bl3) continue;
            linkedHashSet.add(object2);
        }
        return linkedHashSet;
    }

    public List filter(List object) {
        boolean bl2;
        ArrayList arrayList = new ArrayList(object);
        List list = new List(object);
        object = this.mCameraFilterSet.iterator();
        while (bl2 = object.hasNext()) {
            CameraFilter cameraFilter = (CameraFilter)object.next();
            list = Collections.unmodifiableList(list);
            bl2 = (list = cameraFilter.filter(list)).isEmpty();
            if (!bl2) {
                bl2 = arrayList.containsAll(list);
                if (bl2) {
                    arrayList.retainAll(list);
                    continue;
                }
                object = new IllegalArgumentException("The output isn't contained in the input.");
                throw object;
            }
            object = new IllegalArgumentException("No available camera can be found.");
            throw object;
        }
        return list;
    }

    public LinkedHashSet getCameraFilterSet() {
        return this.mCameraFilterSet;
    }

    public Integer getLensFacing() {
        int n10;
        Object object = this.mCameraFilterSet.iterator();
        Object object2 = null;
        while ((n10 = object.hasNext()) != 0) {
            Object object3 = (CameraFilter)object.next();
            boolean bl2 = object3 instanceof LensFacingCameraFilter;
            if (!bl2) continue;
            n10 = ((LensFacingCameraFilter)object3).getLensFacing();
            object3 = n10;
            if (object2 == null) {
                object2 = object3;
                continue;
            }
            n10 = ((Integer)object2).equals(object3) ? 1 : 0;
            if (n10 != 0) continue;
            object = new IllegalStateException("Multiple conflicting lens facing requirements exist.");
            throw object;
        }
        return object2;
    }

    public CameraInternal select(LinkedHashSet linkedHashSet) {
        return (CameraInternal)this.filter(linkedHashSet).iterator().next();
    }
}

