/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  android.util.Pair
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import android.util.Pair;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TagBundle {
    private static final TagBundle EMPTY_TAGBUNDLE;
    public final Map mTagMap;

    static {
        TagBundle tagBundle;
        ArrayMap arrayMap = new ArrayMap();
        EMPTY_TAGBUNDLE = tagBundle = new TagBundle((Map)arrayMap);
    }

    public TagBundle(Map map) {
        this.mTagMap = map;
    }

    public static TagBundle create(Pair object) {
        ArrayMap arrayMap = new ArrayMap();
        String string2 = (String)object.first;
        object = (Integer)object.second;
        arrayMap.put(string2, object);
        object = new TagBundle((Map)arrayMap);
        return object;
    }

    public static TagBundle emptyBundle() {
        return EMPTY_TAGBUNDLE;
    }

    public static TagBundle from(TagBundle tagBundle) {
        boolean bl2;
        ArrayMap arrayMap = new ArrayMap();
        Iterator iterator2 = tagBundle.listKeys().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            Integer n10 = tagBundle.getTag(string2);
            arrayMap.put(string2, n10);
        }
        tagBundle = new TagBundle((Map)arrayMap);
        return tagBundle;
    }

    public Integer getTag(String string2) {
        return (Integer)this.mTagMap.get(string2);
    }

    public Set listKeys() {
        return this.mTagMap.keySet();
    }
}

