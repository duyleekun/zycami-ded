/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {
    public HashMap map;

    public KeyCache() {
        HashMap hashMap;
        this.map = hashMap = new HashMap();
    }

    public float getFloatValue(Object object, String string2, int n10) {
        HashMap hashMap = this.map;
        boolean bl2 = hashMap.containsKey(object);
        float f10 = 0.0f / 0.0f;
        if (!bl2) {
            return f10;
        }
        hashMap = this.map;
        bl2 = ((HashMap)(object = (HashMap)hashMap.get(object))).containsKey(string2);
        if (!bl2) {
            return f10;
        }
        int n11 = ((Object)(object = (Object)((float[])((HashMap)object).get(string2)))).length;
        if (n11 > n10) {
            return (float)object[n10];
        }
        return f10;
    }

    public void setFloatValue(Object object, String object2, int n10, float f10) {
        HashMap hashMap = this.map;
        boolean bl2 = hashMap.containsKey(object);
        if (!bl2) {
            hashMap = new HashMap();
            int n11 = n10 + 1;
            float[] fArray = new float[n11];
            fArray[n10] = f10;
            hashMap.put(object2, fArray);
            object2 = this.map;
            ((HashMap)object2).put(object, hashMap);
        } else {
            hashMap = (HashMap)this.map.get(object);
            int n12 = hashMap.containsKey(object2);
            if (n12 == 0) {
                n12 = n10 + 1;
                float[] fArray = new float[n12];
                fArray[n10] = f10;
                hashMap.put(object2, fArray);
                object2 = this.map;
                ((HashMap)object2).put(object, hashMap);
            } else {
                object = (float[])hashMap.get(object2);
                n12 = ((Object)object).length;
                if (n12 <= n10) {
                    n12 = n10 + 1;
                    object = Arrays.copyOf((float[])object, n12);
                }
                object[n10] = f10;
                hashMap.put(object2, object);
            }
        }
    }
}

