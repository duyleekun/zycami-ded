/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import java.util.Map;

public class Maps$MapDifferenceImpl
implements MapDifference {
    public final Map differences;
    public final Map onBoth;
    public final Map onlyOnLeft;
    public final Map onlyOnRight;

    public Maps$MapDifferenceImpl(Map map, Map map2, Map map3, Map map4) {
        this.onlyOnLeft = map = Maps.access$100(map);
        this.onlyOnRight = map = Maps.access$100(map2);
        this.onBoth = map = Maps.access$100(map3);
        this.differences = map = Maps.access$100(map4);
    }

    public boolean areEqual() {
        Map map = this.onlyOnLeft;
        boolean bl2 = map.isEmpty();
        if (bl2 && (bl2 = (map = this.onlyOnRight).isEmpty()) && (bl2 = (map = this.differences).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            map = null;
        }
        return bl2;
    }

    public Map entriesDiffering() {
        return this.differences;
    }

    public Map entriesInCommon() {
        return this.onBoth;
    }

    public Map entriesOnlyOnLeft() {
        return this.onlyOnLeft;
    }

    public Map entriesOnlyOnRight() {
        return this.onlyOnRight;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof MapDifference;
        if (bl3) {
            boolean bl4;
            Map map;
            object = (MapDifference)object;
            Map map2 = this.entriesOnlyOnLeft();
            bl3 = map2.equals(map = object.entriesOnlyOnLeft());
            if (!(bl3 && (bl3 = (map2 = this.entriesOnlyOnRight()).equals(map = object.entriesOnlyOnRight())) && (bl3 = (map2 = this.entriesInCommon()).equals(map = object.entriesInCommon())) && (bl4 = (map2 = this.entriesDiffering()).equals(object = object.entriesDiffering())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[4];
        Map map = this.entriesOnlyOnLeft();
        objectArray[0] = map;
        map = this.entriesOnlyOnRight();
        objectArray[1] = map;
        map = this.entriesInCommon();
        objectArray[2] = map;
        map = this.entriesDiffering();
        objectArray[3] = map;
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        boolean bl2 = this.areEqual();
        if (bl2) {
            return "equal";
        }
        StringBuilder stringBuilder = new StringBuilder("not equal");
        Map map = this.onlyOnLeft;
        boolean bl3 = map.isEmpty();
        if (!bl3) {
            stringBuilder.append(": only on left=");
            map = this.onlyOnLeft;
            stringBuilder.append(map);
        }
        if (!(bl3 = (map = this.onlyOnRight).isEmpty())) {
            stringBuilder.append(": only on right=");
            map = this.onlyOnRight;
            stringBuilder.append(map);
        }
        if (!(bl3 = (map = this.differences).isEmpty())) {
            stringBuilder.append(": value differences=");
            map = this.differences;
            stringBuilder.append(map);
        }
        return stringBuilder.toString();
    }
}

