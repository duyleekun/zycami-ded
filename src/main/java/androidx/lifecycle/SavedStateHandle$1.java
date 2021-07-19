/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SavedStateHandle$1
implements SavedStateRegistry$SavedStateProvider {
    public final /* synthetic */ SavedStateHandle this$0;

    public SavedStateHandle$1(SavedStateHandle savedStateHandle) {
        this.this$0 = savedStateHandle;
    }

    public Bundle saveState() {
        Object object;
        Object object2;
        boolean bl2;
        Object object3 = this.this$0.mSavedStateProviders;
        Object object4 = new HashMap(object3);
        object4 = object4.entrySet().iterator();
        while (bl2 = object4.hasNext()) {
            object3 = (Map.Entry)object4.next();
            object2 = ((SavedStateRegistry$SavedStateProvider)object3.getValue()).saveState();
            object = this.this$0;
            object3 = (String)object3.getKey();
            ((SavedStateHandle)object).set((String)object3, object2);
        }
        object4 = this.this$0.mRegular.keySet();
        int n10 = object4.size();
        object3 = new ArrayList(n10);
        int n11 = ((ArrayList)object3).size();
        object2 = new ArrayList(n11);
        object4 = object4.iterator();
        while ((n11 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
            object = (String)object4.next();
            ((ArrayList)object3).add(object);
            Map map = this.this$0.mRegular;
            object = map.get(object);
            ((ArrayList)object2).add(object);
        }
        object4 = new Bundle();
        object4.putParcelableArrayList("keys", (ArrayList)object3);
        object4.putParcelableArrayList("values", (ArrayList)object2);
        return object4;
    }
}

