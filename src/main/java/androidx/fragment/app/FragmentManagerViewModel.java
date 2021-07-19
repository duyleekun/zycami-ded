/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerNonConfig;
import androidx.fragment.app.FragmentManagerViewModel$1;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class FragmentManagerViewModel
extends ViewModel {
    private static final ViewModelProvider$Factory FACTORY;
    private static final String TAG = "FragmentManager";
    private final HashMap mChildNonConfigs;
    private boolean mHasBeenCleared;
    private boolean mHasSavedSnapshot;
    private boolean mIsStateSaved;
    private final HashMap mRetainedFragments;
    private final boolean mStateAutomaticallySaved;
    private final HashMap mViewModelStores;

    static {
        FragmentManagerViewModel$1 fragmentManagerViewModel$1 = new FragmentManagerViewModel$1();
        FACTORY = fragmentManagerViewModel$1;
    }

    public FragmentManagerViewModel(boolean bl2) {
        HashMap hashMap;
        this.mRetainedFragments = hashMap = new HashMap();
        this.mChildNonConfigs = hashMap = new HashMap();
        this.mViewModelStores = hashMap = new HashMap();
        this.mHasBeenCleared = false;
        this.mHasSavedSnapshot = false;
        this.mIsStateSaved = false;
        this.mStateAutomaticallySaved = bl2;
    }

    public static FragmentManagerViewModel getInstance(ViewModelStore viewModelStore) {
        ViewModelProvider$Factory viewModelProvider$Factory = FACTORY;
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStore, viewModelProvider$Factory);
        return (FragmentManagerViewModel)viewModelProvider.get(FragmentManagerViewModel.class);
    }

    public void addRetainedFragment(Fragment object) {
        boolean bl2 = this.mIsStateSaved;
        String string2 = TAG;
        int n10 = 2;
        if (bl2) {
            boolean bl3 = FragmentManager.isLoggingEnabled(n10);
            if (bl3) {
                object = "Ignoring addRetainedFragment as the state is already saved";
                Log.v((String)string2, (String)object);
            }
            return;
        }
        Serializable serializable = this.mRetainedFragments;
        String string3 = ((Fragment)object).mWho;
        bl2 = ((HashMap)serializable).containsKey(string3);
        if (bl2) {
            return;
        }
        serializable = this.mRetainedFragments;
        string3 = ((Fragment)object).mWho;
        ((HashMap)serializable).put(string3, object);
        bl2 = FragmentManager.isLoggingEnabled(n10);
        if (bl2) {
            serializable = new StringBuilder();
            String string4 = "Updating retained Fragments: Added ";
            ((StringBuilder)serializable).append(string4);
            ((StringBuilder)serializable).append(object);
            object = ((StringBuilder)serializable).toString();
            Log.v((String)string2, (String)object);
        }
    }

    public void clearNonConfigState(Fragment object) {
        String string2;
        Object object2;
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Clearing non-config state for ");
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            string2 = TAG;
            Log.d((String)string2, (String)object2);
        }
        object2 = this.mChildNonConfigs;
        string2 = ((Fragment)object).mWho;
        if ((object2 = (FragmentManagerViewModel)((HashMap)object2).get(string2)) != null) {
            ((FragmentManagerViewModel)object2).onCleared();
            object2 = this.mChildNonConfigs;
            string2 = ((Fragment)object).mWho;
            ((HashMap)object2).remove(string2);
        }
        object2 = this.mViewModelStores;
        string2 = ((Fragment)object).mWho;
        if ((object2 = (ViewModelStore)((HashMap)object2).get(string2)) != null) {
            ((ViewModelStore)object2).clear();
            object2 = this.mViewModelStores;
            object = ((Fragment)object).mWho;
            ((HashMap)object2).remove(object);
        }
    }

    public boolean equals(Object object) {
        Serializable serializable;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = FragmentManagerViewModel.class) == (serializable = object.getClass())) {
            boolean bl3;
            object = (FragmentManagerViewModel)object;
            object2 = this.mRetainedFragments;
            serializable = ((FragmentManagerViewModel)object).mRetainedFragments;
            boolean bl4 = ((AbstractMap)object2).equals(serializable);
            if (!(bl4 && (bl4 = ((AbstractMap)(object2 = this.mChildNonConfigs)).equals(serializable = ((FragmentManagerViewModel)object).mChildNonConfigs)) && (bl3 = ((AbstractMap)(object2 = this.mViewModelStores)).equals(object = ((FragmentManagerViewModel)object).mViewModelStores)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Fragment findRetainedFragmentByWho(String string2) {
        return (Fragment)this.mRetainedFragments.get(string2);
    }

    public FragmentManagerViewModel getChildNonConfig(Fragment object) {
        Object object2 = this.mChildNonConfigs;
        Object object3 = ((Fragment)object).mWho;
        if ((object2 = (FragmentManagerViewModel)((HashMap)object2).get(object3)) == null) {
            boolean bl2 = this.mStateAutomaticallySaved;
            object2 = new FragmentManagerViewModel(bl2);
            object3 = this.mChildNonConfigs;
            object = ((Fragment)object).mWho;
            ((HashMap)object3).put(object, object2);
        }
        return object2;
    }

    public Collection getRetainedFragments() {
        Collection collection = this.mRetainedFragments.values();
        ArrayList arrayList = new ArrayList(collection);
        return arrayList;
    }

    public FragmentManagerNonConfig getSnapshot() {
        Object object;
        Object object2;
        boolean bl2;
        HashMap hashMap = this.mRetainedFragments;
        boolean bl3 = hashMap.isEmpty();
        FragmentManagerNonConfig fragmentManagerNonConfig = null;
        if (bl3 && (bl3 = (hashMap = this.mChildNonConfigs).isEmpty()) && (bl3 = (hashMap = this.mViewModelStores).isEmpty())) {
            return null;
        }
        hashMap = new HashMap();
        Cloneable cloneable = this.mChildNonConfigs.entrySet().iterator();
        while (bl2 = cloneable.hasNext()) {
            object2 = cloneable.next();
            object = ((FragmentManagerViewModel)object2.getValue()).getSnapshot();
            if (object == null) continue;
            object2 = object2.getKey();
            hashMap.put(object2, object);
        }
        this.mHasSavedSnapshot = true;
        cloneable = this.mRetainedFragments;
        boolean bl4 = ((HashMap)cloneable).isEmpty();
        if (bl4 && (bl4 = hashMap.isEmpty()) && (bl4 = ((HashMap)(cloneable = this.mViewModelStores)).isEmpty())) {
            return null;
        }
        object2 = this.mRetainedFragments.values();
        cloneable = new Cloneable(object2);
        object = this.mViewModelStores;
        object2 = new Object(object);
        fragmentManagerNonConfig = new FragmentManagerNonConfig((Collection)((Object)cloneable), hashMap, (Map)object2);
        return fragmentManagerNonConfig;
    }

    public ViewModelStore getViewModelStore(Fragment object) {
        Object object2 = this.mViewModelStores;
        Object object3 = ((Fragment)object).mWho;
        if ((object2 = (ViewModelStore)((HashMap)object2).get(object3)) == null) {
            object2 = new ViewModelStore();
            object3 = this.mViewModelStores;
            object = ((Fragment)object).mWho;
            ((HashMap)object3).put(object, object2);
        }
        return object2;
    }

    public int hashCode() {
        int n10 = this.mRetainedFragments.hashCode() * 31;
        int n11 = this.mChildNonConfigs.hashCode();
        n10 = (n10 + n11) * 31;
        n11 = this.mViewModelStores.hashCode();
        return n10 + n11;
    }

    public boolean isCleared() {
        return this.mHasBeenCleared;
    }

    public void onCleared() {
        boolean bl2 = FragmentManager.isLoggingEnabled(3);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("onCleared called for ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            String string2 = TAG;
            Log.d((String)string2, (String)charSequence);
        }
        this.mHasBeenCleared = true;
    }

    public void removeRetainedFragment(Fragment object) {
        boolean bl2 = this.mIsStateSaved;
        String string2 = TAG;
        int n10 = 2;
        if (bl2) {
            boolean bl3 = FragmentManager.isLoggingEnabled(n10);
            if (bl3) {
                object = "Ignoring removeRetainedFragment as the state is already saved";
                Log.v((String)string2, (String)object);
            }
            return;
        }
        Serializable serializable = this.mRetainedFragments;
        String string3 = ((Fragment)object).mWho;
        if ((serializable = ((HashMap)serializable).remove(string3)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            serializable = null;
        }
        if (bl2 && (bl2 = FragmentManager.isLoggingEnabled(n10))) {
            serializable = new StringBuilder();
            String string4 = "Updating retained Fragments: Removed ";
            ((StringBuilder)serializable).append(string4);
            ((StringBuilder)serializable).append(object);
            object = ((StringBuilder)serializable).toString();
            Log.v((String)string2, (String)object);
        }
    }

    public void restoreFromSnapshot(FragmentManagerNonConfig object) {
        this.mRetainedFragments.clear();
        this.mChildNonConfigs.clear();
        Object object2 = this.mViewModelStores;
        ((HashMap)object2).clear();
        if (object != null) {
            Object object3;
            Object object4;
            Object object5;
            boolean bl2;
            object2 = ((FragmentManagerNonConfig)object).getFragments();
            if (object2 != null) {
                object2 = object2.iterator();
                while (bl2 = object2.hasNext()) {
                    object5 = (Fragment)((Object)object2.next());
                    if (object5 == null) continue;
                    object4 = this.mRetainedFragments;
                    object3 = ((Fragment)object5).mWho;
                    ((HashMap)object4).put(object3, object5);
                }
            }
            if ((object2 = ((FragmentManagerNonConfig)object).getChildNonConfigs()) != null) {
                object2 = object2.entrySet().iterator();
                while (bl2 = object2.hasNext()) {
                    object5 = (Map.Entry)object2.next();
                    boolean bl3 = this.mStateAutomaticallySaved;
                    object4 = new FragmentManagerViewModel(bl3);
                    object3 = (FragmentManagerNonConfig)object5.getValue();
                    ((FragmentManagerViewModel)object4).restoreFromSnapshot((FragmentManagerNonConfig)object3);
                    object3 = this.mChildNonConfigs;
                    object5 = object5.getKey();
                    ((HashMap)object3).put(object5, object4);
                }
            }
            if ((object = ((FragmentManagerNonConfig)object).getViewModelStores()) != null) {
                object2 = this.mViewModelStores;
                ((HashMap)object2).putAll(object);
            }
        }
        this.mHasSavedSnapshot = false;
    }

    public void setIsStateSaved(boolean bl2) {
        this.mIsStateSaved = bl2;
    }

    public boolean shouldDestroy(Fragment object) {
        HashMap hashMap = this.mRetainedFragments;
        object = ((Fragment)object).mWho;
        boolean bl2 = hashMap.containsKey(object);
        boolean bl3 = true;
        if (!bl2) {
            return bl3;
        }
        bl2 = this.mStateAutomaticallySaved;
        if (bl2) {
            return this.mHasBeenCleared;
        }
        return this.mHasSavedSnapshot ^ bl3;
    }

    public String toString() {
        Object object;
        String string2;
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder("FragmentManagerViewModel{");
        int n10 = System.identityHashCode(this);
        Iterator iterator2 = Integer.toHexString(n10);
        stringBuilder.append((String)((Object)iterator2));
        stringBuilder.append("} Fragments (");
        iterator2 = this.mRetainedFragments.values().iterator();
        while (true) {
            bl2 = iterator2.hasNext();
            string2 = ", ";
            if (!bl2) break;
            object = iterator2.next();
            stringBuilder.append(object);
            bl2 = iterator2.hasNext();
            if (!bl2) continue;
            stringBuilder.append(string2);
        }
        stringBuilder.append(") Child Non Config (");
        iterator2 = this.mChildNonConfigs.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (String)iterator2.next();
            stringBuilder.append((String)object);
            bl2 = iterator2.hasNext();
            if (!bl2) continue;
            stringBuilder.append(string2);
        }
        stringBuilder.append(") ViewModelStores (");
        iterator2 = this.mViewModelStores.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (String)iterator2.next();
            stringBuilder.append((String)object);
            bl2 = iterator2.hasNext();
            if (!bl2) continue;
            stringBuilder.append(string2);
        }
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

