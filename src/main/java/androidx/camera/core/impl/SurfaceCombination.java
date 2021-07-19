/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SurfaceCombination {
    private final List mSurfaceConfigList;

    public SurfaceCombination() {
        ArrayList arrayList;
        this.mSurfaceConfigList = arrayList = new ArrayList();
    }

    private static void generateArrangements(List list, int n10, int[] nArray, int n11) {
        int n12 = nArray.length;
        if (n11 >= n12) {
            int[] nArray2 = (int[])nArray.clone();
            list.add(nArray2);
            return;
        }
        n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n13;
            block3: {
                for (n13 = 0; n13 < n11; ++n13) {
                    int n14 = nArray[n13];
                    if (i10 != n14) continue;
                    n13 = 1;
                    break block3;
                }
                n13 = 0;
            }
            if (n13 != 0) continue;
            nArray[n11] = i10;
            n13 = n11 + 1;
            SurfaceCombination.generateArrangements(list, n10, nArray, n13);
        }
    }

    private List getElementsArrangements(int n10) {
        ArrayList arrayList = new ArrayList();
        int[] nArray = new int[n10];
        SurfaceCombination.generateArrangements(arrayList, n10, nArray, 0);
        return arrayList;
    }

    public boolean addSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.add(surfaceConfig);
    }

    public List getSurfaceConfigList() {
        return this.mSurfaceConfigList;
    }

    public boolean isSupported(List list) {
        int n10;
        block4: {
            Object object;
            int n11;
            int n12 = list.isEmpty();
            n10 = 1;
            if (n12 != 0) {
                return n10 != 0;
            }
            n12 = list.size();
            if (n12 > (n11 = (object = this.mSurfaceConfigList).size())) {
                return false;
            }
            n12 = this.mSurfaceConfigList.size();
            Iterator iterator2 = this.getElementsArrangements(n12).iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                SurfaceConfig surfaceConfig;
                Object object2;
                Object object3;
                Object object4;
                object = (int[])iterator2.next();
                int n13 = n10;
                for (int i10 = 0; i10 < (object4 = (object3 = this.mSurfaceConfigList).size()) && ((object4 = (Object)object[i10]) >= (object2 = list.size()) || (n13 &= (object4 = (Object)((SurfaceConfig)(object3 = (SurfaceConfig)this.mSurfaceConfigList.get(i10))).isSupported(surfaceConfig = (SurfaceConfig)list.get((int)(object2 = (Object)object[i10]))))) != 0); ++i10) {
                }
                if (n13 == 0) continue;
                break block4;
            }
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean removeSurfaceConfig(SurfaceConfig surfaceConfig) {
        return this.mSurfaceConfigList.remove(surfaceConfig);
    }
}

