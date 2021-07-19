/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.vision.common.internal;

import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$DetectorCreator;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$DetectorOptions;
import com.google.mlkit.vision.common.internal.MultiFlavorDetectorCreator$Registration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultiFlavorDetectorCreator {
    private final Map zza;

    public MultiFlavorDetectorCreator(Set object) {
        int n10;
        HashMap<Class, Object> hashMap;
        this.zza = hashMap = new HashMap<Class, Object>();
        hashMap = new HashMap<Class, Object>();
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object2;
            int n11;
            Map map = this.zza;
            Object object3 = (MultiFlavorDetectorCreator$Registration)object.next();
            Class clazz = ((MultiFlavorDetectorCreator$Registration)object3).zza();
            int n12 = map.containsKey(clazz);
            if (n12 != 0 && (n12 = ((MultiFlavorDetectorCreator$Registration)object3).zzc()) < (n11 = ((Integer)(object2 = (Integer)hashMap.get(clazz))).intValue())) continue;
            map = this.zza;
            object2 = ((MultiFlavorDetectorCreator$Registration)object3).zzb();
            map.put(clazz, object2);
            n10 = ((MultiFlavorDetectorCreator$Registration)object3).zzc();
            object3 = n10;
            hashMap.put(clazz, object3);
        }
    }

    public static MultiFlavorDetectorCreator getInstance() {
        Class<MultiFlavorDetectorCreator> clazz = MultiFlavorDetectorCreator.class;
        synchronized (clazz) {
            Object object = MlKitContext.getInstance();
            object = ((MlKitContext)object).get(clazz);
            object = (MultiFlavorDetectorCreator)object;
            return object;
        }
    }

    public MobileVisionBase create(MultiFlavorDetectorCreator$DetectorOptions multiFlavorDetectorCreator$DetectorOptions) {
        Map map = this.zza;
        Class<?> clazz = multiFlavorDetectorCreator$DetectorOptions.getClass();
        return ((MultiFlavorDetectorCreator$DetectorCreator)((Provider)map.get(clazz)).get()).create(multiFlavorDetectorCreator$DetectorOptions);
    }
}

