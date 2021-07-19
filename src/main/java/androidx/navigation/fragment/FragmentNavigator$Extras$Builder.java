/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.navigation.fragment;

import android.view.View;
import androidx.navigation.fragment.FragmentNavigator$Extras;
import java.util.LinkedHashMap;
import java.util.Map;

public final class FragmentNavigator$Extras$Builder {
    private final LinkedHashMap mSharedElements;

    public FragmentNavigator$Extras$Builder() {
        LinkedHashMap linkedHashMap;
        this.mSharedElements = linkedHashMap = new LinkedHashMap();
    }

    public FragmentNavigator$Extras$Builder addSharedElement(View view, String string2) {
        this.mSharedElements.put(view, string2);
        return this;
    }

    public FragmentNavigator$Extras$Builder addSharedElements(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            View view = (View)object2.getKey();
            object2 = (String)object2.getValue();
            if (view == null || object2 == null) continue;
            this.addSharedElement(view, (String)object2);
        }
        return this;
    }

    public FragmentNavigator$Extras build() {
        LinkedHashMap linkedHashMap = this.mSharedElements;
        FragmentNavigator$Extras fragmentNavigator$Extras = new FragmentNavigator$Extras(linkedHashMap);
        return fragmentNavigator$Extras;
    }
}

