/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCharacteristics
 *  android.hardware.camera2.CameraCharacteristics$Key
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.CameraUnavailableExceptionHelper;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    private static String decideSkippedCameraIdByHeuristic(CameraManagerCompat object, Integer n10, List list) {
        String string2;
        int n11;
        String string3 = null;
        if (n10 == null) {
            return null;
        }
        String string4 = "0";
        boolean bl2 = list.contains(string4);
        if (bl2 && (n11 = list.contains(string2 = "1")) != 0) {
            int n12;
            n11 = n10;
            if (n11 == (n12 = 1)) {
                object = ((CameraManagerCompat)object).getCameraCharacteristicsCompat(string4);
                n10 = CameraCharacteristics.LENS_FACING;
                int n13 = (Integer)(object = (Integer)((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)n10));
                if (n13 == n12) {
                    string3 = string2;
                }
            } else {
                int n14 = n10;
                if (n14 == 0) {
                    object = ((CameraManagerCompat)object).getCameraCharacteristicsCompat(string2);
                    n10 = CameraCharacteristics.LENS_FACING;
                    int n15 = (Integer)(object = (Integer)((CameraCharacteristicsCompat)object).get((CameraCharacteristics.Key)n10));
                    if (n15 == 0) {
                        string3 = string4;
                    }
                }
            }
        }
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List getSelectedAvailableCameraIds(Camera2CameraFactory iterator2, CameraSelector object) {
        try {
            boolean bl3;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object2 = ((Camera2CameraFactory)((Object)iterator2)).getCameraManager();
            object2 = ((CameraManagerCompat)object2).getCameraIdList();
            object2 = Arrays.asList(object2);
            if (object == null) {
                iterator2 = object2.iterator();
                while (true) {
                    boolean bl2;
                    if (!(bl2 = iterator2.hasNext())) {
                        return arrayList;
                    }
                    object = iterator2.next();
                    object = (String)object;
                    arrayList.add(object);
                }
            }
            Object object3 = ((CameraSelector)object).getLensFacing();
            ArrayList<Object> arrayList2 = ((Camera2CameraFactory)((Object)iterator2)).getCameraManager();
            object3 = CameraSelectionOptimizer.decideSkippedCameraIdByHeuristic((CameraManagerCompat)((Object)arrayList2), (Integer)object3, (List)object2);
            arrayList2 = new ArrayList<Object>();
            object2 = object2.iterator();
            while (bl3 = object2.hasNext()) {
                Object object4 = object2.next();
                boolean bl4 = ((String)(object4 = (String)object4)).equals(object3);
                if (bl4) continue;
                object4 = ((Camera2CameraFactory)((Object)iterator2)).getCameraInfo((String)object4);
                arrayList2.add(object4);
            }
            try {
                boolean bl5;
                iterator2 = ((CameraSelector)object).filter(arrayList2);
                iterator2 = iterator2.iterator();
                while (bl5 = iterator2.hasNext()) {
                    object = iterator2.next();
                    object = (CameraInfo)object;
                    object = (CameraInfoInternal)object;
                    object = object.getCameraId();
                    arrayList.add(object);
                }
                return arrayList;
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            return arrayList;
        }
        catch (CameraUnavailableException cameraUnavailableException) {
            object = new InitializationException(cameraUnavailableException);
            throw object;
        }
        catch (CameraAccessExceptionCompat cameraAccessExceptionCompat) {
            cameraUnavailableException = CameraUnavailableExceptionHelper.createFrom(cameraAccessExceptionCompat);
            object = new InitializationException(cameraUnavailableException);
            throw object;
        }
    }
}

