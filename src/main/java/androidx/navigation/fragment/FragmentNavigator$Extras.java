/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation.fragment;

import androidx.navigation.Navigator$Extras;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class FragmentNavigator$Extras
implements Navigator$Extras {
    private final LinkedHashMap mSharedElements;

    public FragmentNavigator$Extras(Map map) {
        LinkedHashMap linkedHashMap;
        this.mSharedElements = linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
    }

    public Map getSharedElements() {
        return Collections.unmodifiableMap(this.mSharedElements);
    }
}

