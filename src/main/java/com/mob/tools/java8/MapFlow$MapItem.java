/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import java.util.Arrays;

public class MapFlow$MapItem
implements Comparable {
    public Object key;
    public Object value;

    public static MapFlow$MapItem of(Object object, Object object2) {
        MapFlow$MapItem mapFlow$MapItem = new MapFlow$MapItem();
        mapFlow$MapItem.key = object;
        mapFlow$MapItem.value = object2;
        return mapFlow$MapItem;
    }

    public int compareTo(MapFlow$MapItem object) {
        Object object2 = this.key;
        int n10 = -1;
        if (object2 == null) {
            if (object == null) {
                return 0;
            }
            object = ((MapFlow$MapItem)object).key;
            if (object == null) {
                return 0;
            }
            return n10;
        }
        int n11 = 1;
        if (object == null) {
            return n11;
        }
        Object object3 = ((MapFlow$MapItem)object).key;
        if (object3 == null) {
            return n11;
        }
        int n12 = 2;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object2;
        objectArray[n11] = object3;
        Arrays.sort(objectArray);
        object2 = this.key;
        object3 = objectArray[0];
        boolean bl2 = object2.equals(object3);
        if (bl2) {
            object2 = new Object[n12];
            object2[0] = object = ((MapFlow$MapItem)object).key;
            object2[n11] = object = this.key;
            Arrays.sort(object2);
            object = this.key;
            object2 = object2[0];
            boolean bl3 = object.equals(object2);
            if (bl3) {
                return n10;
            }
            return 0;
        }
        return n11;
    }
}

