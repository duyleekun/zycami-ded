/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentState;
import androidx.fragment.app.FragmentStateManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FragmentStore {
    private static final String TAG = "FragmentManager";
    private final HashMap mActive;
    private final ArrayList mAdded;
    private FragmentManagerViewModel mNonConfig;

    public FragmentStore() {
        Cloneable cloneable;
        this.mAdded = cloneable = new Cloneable();
        this.mActive = cloneable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addFragment(Fragment object) {
        Serializable serializable = this.mAdded;
        boolean bl2 = serializable.contains(object);
        if (!bl2) {
            serializable = this.mAdded;
            synchronized (serializable) {
                ArrayList arrayList = this.mAdded;
                arrayList.add(object);
            }
            ((Fragment)object).mAdded = true;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fragment already added: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        serializable = new IllegalStateException((String)object);
        throw serializable;
    }

    public void burpActive() {
        Collection collection = this.mActive.values();
        Set<Object> set = Collections.singleton(null);
        collection.removeAll(set);
    }

    public boolean containsActiveFragment(String string2) {
        boolean bl2;
        HashMap hashMap = this.mActive;
        if ((string2 = hashMap.get(string2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public void dispatchStateChange(int n10) {
        boolean bl2;
        Iterator iterator2 = this.mActive.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager)iterator2.next();
            if (fragmentStateManager == null) continue;
            fragmentStateManager.setFragmentManagerState(n10);
        }
    }

    public void dump(String string2, FileDescriptor object, PrintWriter printWriter, String[] stringArray) {
        int n10;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append("    ");
        object2 = ((StringBuilder)object2).toString();
        Object object3 = this.mActive;
        boolean bl2 = ((HashMap)object3).isEmpty();
        if (!bl2) {
            boolean bl3;
            printWriter.print(string2);
            printWriter.println("Active Fragments:");
            object3 = this.mActive.values().iterator();
            while (bl3 = object3.hasNext()) {
                Object object4 = (FragmentStateManager)object3.next();
                printWriter.print(string2);
                if (object4 != null) {
                    object4 = ((FragmentStateManager)object4).getFragment();
                    printWriter.println(object4);
                    ((Fragment)object4).dump((String)object2, (FileDescriptor)object, printWriter, stringArray);
                    continue;
                }
                object4 = "null";
                printWriter.println((String)object4);
            }
        }
        if ((n10 = ((ArrayList)(object = this.mAdded)).size()) > 0) {
            printWriter.print(string2);
            printWriter.println("Added Fragments:");
            stringArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                object2 = (Fragment)this.mAdded.get(i10);
                printWriter.print(string2);
                printWriter.print("  #");
                printWriter.print(i10);
                object3 = ": ";
                printWriter.print((String)object3);
                object2 = ((Fragment)object2).toString();
                printWriter.println((String)object2);
            }
        }
    }

    public Fragment findActiveFragment(String object) {
        HashMap hashMap = this.mActive;
        if ((object = (FragmentStateManager)hashMap.get(object)) != null) {
            return ((FragmentStateManager)object).getFragment();
        }
        return null;
    }

    public Fragment findFragmentById(int n10) {
        boolean bl2;
        int n11;
        Object object;
        Object object2 = this.mAdded;
        for (int i10 = ((ArrayList)object2).size() + -1; i10 >= 0; i10 += -1) {
            object = (Fragment)this.mAdded.get(i10);
            if (object == null || (n11 = ((Fragment)object).mFragmentId) != n10) continue;
            return object;
        }
        object2 = this.mActive.values().iterator();
        while (bl2 = object2.hasNext()) {
            object = (FragmentStateManager)object2.next();
            if (object == null) continue;
            object = ((FragmentStateManager)object).getFragment();
            n11 = ((Fragment)object).mFragmentId;
            if (n11 != n10) continue;
            return object;
        }
        return null;
    }

    public Fragment findFragmentByTag(String string2) {
        String string3;
        boolean bl2;
        Object object;
        Object object2;
        if (string2 != null) {
            object2 = this.mAdded;
            for (int i10 = ((ArrayList)object2).size() + -1; i10 >= 0; i10 += -1) {
                object = (Fragment)this.mAdded.get(i10);
                if (object == null || !(bl2 = string2.equals(string3 = ((Fragment)object).mTag))) continue;
                return object;
            }
        }
        if (string2 != null) {
            boolean bl3;
            object2 = this.mActive.values().iterator();
            while (bl3 = object2.hasNext()) {
                object = (FragmentStateManager)object2.next();
                if (object == null) continue;
                object = ((FragmentStateManager)object).getFragment();
                string3 = ((Fragment)object).mTag;
                bl2 = string2.equals(string3);
                if (!bl2) continue;
                return object;
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String string2) {
        boolean bl2;
        Iterator iterator2 = this.mActive.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (FragmentStateManager)iterator2.next();
            if (object == null || (object = ((FragmentStateManager)object).getFragment().findFragmentByWho(string2)) == null) continue;
            return object;
        }
        return null;
    }

    public int findFragmentIndexInContainer(Fragment fragment) {
        Fragment fragment2;
        int n10;
        ViewGroup viewGroup = fragment.mContainer;
        int n11 = -1;
        if (viewGroup == null) {
            return n11;
        }
        Object object = this.mAdded;
        int n12 = ((ArrayList)object).indexOf(fragment);
        for (n10 = n12 + -1; n10 >= 0; n10 += -1) {
            fragment2 = (Fragment)this.mAdded.get(n10);
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != viewGroup || (fragment2 = fragment2.mView) == null) continue;
            return viewGroup.indexOfChild((View)fragment2) + 1;
        }
        while (++n12 < (n10 = ((ArrayList)(object = this.mAdded)).size())) {
            object = (Fragment)this.mAdded.get(n12);
            fragment2 = ((Fragment)object).mContainer;
            if (fragment2 != viewGroup || (object = ((Fragment)object).mView) == null) continue;
            return viewGroup.indexOfChild((View)object);
        }
        return n11;
    }

    public int getActiveFragmentCount() {
        return this.mActive.size();
    }

    public List getActiveFragmentStateManagers() {
        boolean bl2;
        ArrayList<FragmentStateManager> arrayList = new ArrayList<FragmentStateManager>();
        Iterator iterator2 = this.mActive.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager)iterator2.next();
            if (fragmentStateManager == null) continue;
            arrayList.add(fragmentStateManager);
        }
        return arrayList;
    }

    public List getActiveFragments() {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.mActive.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (FragmentStateManager)iterator2.next();
            if (object != null) {
                object = ((FragmentStateManager)object).getFragment();
                arrayList.add(object);
                continue;
            }
            bl2 = false;
            object = null;
            arrayList.add(null);
        }
        return arrayList;
    }

    public FragmentStateManager getFragmentStateManager(String string2) {
        return (FragmentStateManager)this.mActive.get(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getFragments() {
        ArrayList arrayList = this.mAdded;
        boolean bl2 = arrayList.isEmpty();
        if (bl2) {
            return Collections.emptyList();
        }
        arrayList = this.mAdded;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.mAdded;
            return new ArrayList(arrayList2);
        }
    }

    public FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    public void makeActive(FragmentStateManager object) {
        Object object2 = ((FragmentStateManager)object).getFragment();
        Object object3 = ((Fragment)object2).mWho;
        boolean bl2 = this.containsActiveFragment((String)object3);
        if (bl2) {
            return;
        }
        object3 = this.mActive;
        String string2 = ((Fragment)object2).mWho;
        ((HashMap)object3).put(string2, object);
        boolean bl3 = ((Fragment)object2).mRetainInstanceChangedWhileDetached;
        if (bl3) {
            bl3 = ((Fragment)object2).mRetainInstance;
            if (bl3) {
                object = this.mNonConfig;
                ((FragmentManagerViewModel)object).addRetainedFragment((Fragment)object2);
            } else {
                object = this.mNonConfig;
                ((FragmentManagerViewModel)object).removeRetainedFragment((Fragment)object2);
            }
            bl3 = false;
            object = null;
            ((Fragment)object2).mRetainInstanceChangedWhileDetached = false;
        }
        if (bl3 = FragmentManager.isLoggingEnabled(2)) {
            object = new StringBuilder();
            object3 = "Added fragment to active set ";
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = TAG;
            Log.v((String)object2, (String)object);
        }
    }

    public void makeInactive(FragmentStateManager object) {
        Object object2;
        object = ((FragmentStateManager)object).getFragment();
        boolean bl2 = ((Fragment)object).mRetainInstance;
        if (bl2) {
            object2 = this.mNonConfig;
            ((FragmentManagerViewModel)object2).removeRetainedFragment((Fragment)object);
        }
        object2 = this.mActive;
        String string2 = ((Fragment)object).mWho;
        if ((object2 = (FragmentStateManager)((HashMap)object2).put(string2, null)) == null) {
            return;
        }
        bl2 = FragmentManager.isLoggingEnabled(2);
        if (bl2) {
            object2 = new StringBuilder();
            string2 = "Removed fragment from active set ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            object2 = TAG;
            Log.v((String)object2, (String)object);
        }
    }

    public void moveToExpectedState() {
        Object object;
        Object object2;
        boolean bl2;
        Iterator<Object> iterator2 = this.mAdded.iterator();
        while (bl2 = iterator2.hasNext()) {
            object2 = (Fragment)iterator2.next();
            object = this.mActive;
            object2 = ((Fragment)object2).mWho;
            if ((object2 = (FragmentStateManager)((HashMap)object).get(object2)) == null) continue;
            ((FragmentStateManager)object2).moveToExpectedState();
        }
        iterator2 = this.mActive.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            object2 = (FragmentStateManager)iterator2.next();
            if (object2 == null) continue;
            ((FragmentStateManager)object2).moveToExpectedState();
            object = ((FragmentStateManager)object2).getFragment();
            boolean bl4 = ((Fragment)object).mRemoving;
            if (bl4 && !(bl3 = ((Fragment)object).isInBackStack())) {
                bl3 = true;
            } else {
                bl3 = false;
                object = null;
            }
            if (!bl3) continue;
            this.makeInactive((FragmentStateManager)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeFragment(Fragment fragment) {
        ArrayList arrayList = this.mAdded;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.mAdded;
            arrayList2.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void resetActiveFragments() {
        this.mActive.clear();
    }

    public void restoreAddedFragments(List object) {
        Object object2 = this.mAdded;
        ((ArrayList)object2).clear();
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (String)object.next();
                Object object3 = this.findActiveFragment((String)object2);
                if (object3 != null) {
                    boolean bl3 = FragmentManager.isLoggingEnabled(2);
                    if (bl3) {
                        CharSequence charSequence = new StringBuilder();
                        String string2 = "restoreSaveState: added (";
                        charSequence.append(string2);
                        charSequence.append((String)object2);
                        charSequence.append("): ");
                        charSequence.append(object3);
                        object2 = charSequence.toString();
                        charSequence = TAG;
                        Log.v((String)charSequence, (String)object2);
                    }
                    this.addFragment((Fragment)object3);
                    continue;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("No instantiated fragment for (");
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(")");
                object2 = ((StringBuilder)object3).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
        }
    }

    public ArrayList saveActiveFragments() {
        boolean bl2;
        int n10 = this.mActive.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        Iterator iterator2 = this.mActive.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (FragmentStateManager)iterator2.next();
            if (object == null) continue;
            Object object2 = ((FragmentStateManager)object).getFragment();
            object = ((FragmentStateManager)object).saveState();
            arrayList.add(object);
            boolean bl3 = FragmentManager.isLoggingEnabled(2);
            if (!bl3) continue;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Saved state of ";
            stringBuilder.append(string2);
            stringBuilder.append(object2);
            stringBuilder.append(": ");
            object = ((FragmentState)object).mSavedFragmentState;
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = TAG;
            Log.v((String)object2, (String)object);
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList saveAddedFragments() {
        ArrayList arrayList = this.mAdded;
        synchronized (arrayList) {
            ArrayList<String> arrayList2 = this.mAdded;
            boolean bl2 = arrayList2.isEmpty();
            if (bl2) {
                return null;
            }
            Object object = this.mAdded;
            int n10 = ((ArrayList)object).size();
            arrayList2 = new ArrayList<String>(n10);
            object = this.mAdded;
            object = ((ArrayList)object).iterator();
            boolean bl3;
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (Fragment)object2;
                String string2 = ((Fragment)object2).mWho;
                arrayList2.add(string2);
                int n11 = 2;
                if ((n11 = (int)(FragmentManager.isLoggingEnabled(n11) ? 1 : 0)) == 0) continue;
                string2 = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "saveAllState: adding fragment (";
                stringBuilder.append(string3);
                string3 = ((Fragment)object2).mWho;
                stringBuilder.append(string3);
                string3 = "): ";
                stringBuilder.append(string3);
                stringBuilder.append(object2);
                object2 = stringBuilder.toString();
                Log.v((String)string2, object2);
            }
            return arrayList2;
        }
    }

    public void setNonConfig(FragmentManagerViewModel fragmentManagerViewModel) {
        this.mNonConfig = fragmentManagerViewModel;
    }
}

