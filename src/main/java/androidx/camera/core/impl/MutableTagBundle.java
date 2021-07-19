/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 */
package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.core.impl.TagBundle;
import java.util.Iterator;
import java.util.Map;

public class MutableTagBundle
extends TagBundle {
    private MutableTagBundle(Map map) {
        super(map);
    }

    public static MutableTagBundle create() {
        ArrayMap arrayMap = new ArrayMap();
        MutableTagBundle mutableTagBundle = new MutableTagBundle((Map)arrayMap);
        return mutableTagBundle;
    }

    public static MutableTagBundle from(TagBundle tagBundle) {
        boolean bl2;
        ArrayMap arrayMap = new ArrayMap();
        Iterator iterator2 = tagBundle.listKeys().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            Integer n10 = tagBundle.getTag(string2);
            arrayMap.put(string2, n10);
        }
        tagBundle = new MutableTagBundle((Map)arrayMap);
        return tagBundle;
    }

    public void addTagBundle(TagBundle object) {
        Map map = this.mTagMap;
        if (map != null && (object = ((TagBundle)object).mTagMap) != null) {
            map.putAll(object);
        }
    }

    public void putTag(String string2, Integer n10) {
        this.mTagMap.put(string2, n10);
    }
}

