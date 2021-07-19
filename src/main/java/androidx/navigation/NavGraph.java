/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.AttributeSet
 */
package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestination$DeepLinkMatch;
import androidx.navigation.NavGraph$1;
import androidx.navigation.Navigator;
import androidx.navigation.common.R$styleable;
import java.util.Collection;
import java.util.Iterator;

public class NavGraph
extends NavDestination
implements Iterable {
    public final SparseArrayCompat mNodes;
    private int mStartDestId;
    private String mStartDestIdName;

    public NavGraph(Navigator object) {
        super((Navigator)object);
        this.mNodes = object = new SparseArrayCompat();
    }

    public final void addAll(NavGraph object) {
        boolean bl2;
        object = ((NavGraph)object).iterator();
        while (bl2 = object.hasNext()) {
            NavDestination navDestination = (NavDestination)object.next();
            object.remove();
            this.addDestination(navDestination);
        }
    }

    public final void addDestination(NavDestination object) {
        int n10 = ((NavDestination)object).getId();
        if (n10 != 0) {
            int n11 = this.getId();
            if (n10 != n11) {
                Object object2 = this.mNodes;
                Object object3 = (NavDestination)((SparseArrayCompat)object2).get(n10);
                if (object3 == object) {
                    return;
                }
                object2 = ((NavDestination)object).getParent();
                if (object2 == null) {
                    if (object3 != null) {
                        n11 = 0;
                        object2 = null;
                        ((NavDestination)object3).setParent(null);
                    }
                    ((NavDestination)object).setParent(this);
                    object3 = this.mNodes;
                    n11 = ((NavDestination)object).getId();
                    ((SparseArrayCompat)object3).put(n11, object);
                    return;
                }
                object = new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
                throw object;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Destination ");
            stringBuilder.append(object);
            stringBuilder.append(" cannot have the same id as graph ");
            stringBuilder.append(this);
            object = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        object = new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        throw object;
    }

    public final void addDestinations(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            NavDestination navDestination = (NavDestination)object.next();
            if (navDestination == null) continue;
            this.addDestination(navDestination);
        }
    }

    public final void addDestinations(NavDestination ... navDestinationArray) {
        for (NavDestination navDestination : navDestinationArray) {
            if (navDestination == null) continue;
            this.addDestination(navDestination);
        }
    }

    public final void clear() {
        boolean bl2;
        Iterator iterator2 = this.iterator();
        while (bl2 = iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }

    public final NavDestination findNode(int n10) {
        return this.findNode(n10, true);
    }

    public final NavDestination findNode(int n10, boolean bl2) {
        NavDestination navDestination = (NavDestination)this.mNodes.get(n10);
        if (navDestination == null) {
            NavGraph navGraph;
            if (bl2 && (navGraph = this.getParent()) != null) {
                navGraph = this.getParent();
                navDestination = navGraph.findNode(n10);
            } else {
                navDestination = null;
            }
        }
        return navDestination;
    }

    public String getDisplayName() {
        int n10 = this.getId();
        String string2 = n10 != 0 ? super.getDisplayName() : "the root navigation";
        return string2;
    }

    public String getStartDestDisplayName() {
        String string2 = this.mStartDestIdName;
        if (string2 == null) {
            int n10 = this.mStartDestId;
            this.mStartDestIdName = string2 = Integer.toString(n10);
        }
        return this.mStartDestIdName;
    }

    public final int getStartDestination() {
        return this.mStartDestId;
    }

    public final Iterator iterator() {
        NavGraph$1 navGraph$1 = new NavGraph$1(this);
        return navGraph$1;
    }

    public NavDestination$DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        boolean bl2;
        NavDestination$DeepLinkMatch navDestination$DeepLinkMatch = super.matchDeepLink(navDeepLinkRequest);
        Iterator iterator2 = this.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n10;
            NavDestination$DeepLinkMatch navDestination$DeepLinkMatch2 = ((NavDestination)iterator2.next()).matchDeepLink(navDeepLinkRequest);
            if (navDestination$DeepLinkMatch2 == null || navDestination$DeepLinkMatch != null && (n10 = navDestination$DeepLinkMatch2.compareTo(navDestination$DeepLinkMatch)) <= 0) continue;
            navDestination$DeepLinkMatch = navDestination$DeepLinkMatch2;
        }
        return navDestination$DeepLinkMatch;
    }

    public void onInflate(Context object, AttributeSet attributeSet) {
        super.onInflate((Context)object, attributeSet);
        Resources resources = object.getResources();
        int[] nArray = R$styleable.NavGraphNavigator;
        attributeSet = resources.obtainAttributes(attributeSet, nArray);
        int n10 = R$styleable.NavGraphNavigator_startDestination;
        n10 = attributeSet.getResourceId(n10, 0);
        this.setStartDestination(n10);
        n10 = this.mStartDestId;
        object = NavDestination.getDisplayName(object, n10);
        this.mStartDestIdName = object;
        attributeSet.recycle();
    }

    public final void remove(NavDestination navDestination) {
        SparseArrayCompat sparseArrayCompat = this.mNodes;
        int n10 = navDestination.getId();
        if ((n10 = sparseArrayCompat.indexOfKey(n10)) >= 0) {
            ((NavDestination)this.mNodes.valueAt(n10)).setParent(null);
            sparseArrayCompat = this.mNodes;
            sparseArrayCompat.removeAt(n10);
        }
    }

    public final void setStartDestination(int n10) {
        int n11 = this.getId();
        if (n10 != n11) {
            this.mStartDestId = n10;
            this.mStartDestIdName = null;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Start destination ");
        stringBuilder.append(n10);
        stringBuilder.append(" cannot use the same id as the graph ");
        stringBuilder.append(this);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(" startDestination=");
        int n10 = this.getStartDestination();
        object = this.findNode(n10);
        if (object == null) {
            object = this.mStartDestIdName;
            if (object == null) {
                stringBuilder.append("0x");
                n10 = this.mStartDestId;
                object = Integer.toHexString(n10);
                stringBuilder.append((String)object);
            } else {
                stringBuilder.append((String)object);
            }
        } else {
            String string2 = "{";
            stringBuilder.append(string2);
            object = ((NavDestination)object).toString();
            stringBuilder.append((String)object);
            object = "}";
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }
}

