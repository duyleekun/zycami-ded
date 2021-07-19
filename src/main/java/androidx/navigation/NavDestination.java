/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.AttributeSet
 */
package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavAction;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDeepLink$Builder;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavDestination$DeepLinkMatch;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.common.R$styleable;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NavDestination {
    private static final HashMap sClasses;
    private SparseArrayCompat mActions;
    private HashMap mArguments;
    private ArrayList mDeepLinks;
    private int mId;
    private String mIdName;
    private CharSequence mLabel;
    private final String mNavigatorName;
    private NavGraph mParent;

    static {
        HashMap hashMap;
        sClasses = hashMap = new HashMap();
    }

    public NavDestination(Navigator object) {
        object = NavigatorProvider.getNameForNavigator(object.getClass());
        this((String)object);
    }

    public NavDestination(String string2) {
        this.mNavigatorName = string2;
    }

    public static String getDisplayName(Context context, int n10) {
        int n11 = 0xFFFFFF;
        if (n10 <= n11) {
            return Integer.toString(n10);
        }
        try {
            context = context.getResources();
        }
        catch (Resources.NotFoundException notFoundException) {
            return Integer.toString(n10);
        }
        return context.getResourceName(n10);
    }

    public static Class parseClassFromName(Context object, String object2, Class clazz) {
        boolean bl2;
        Class<?> clazz2;
        char c10;
        Serializable serializable = null;
        char c11 = ((String)object2).charAt(0);
        if (c11 == (c10 = '.')) {
            serializable = new StringBuilder();
            clazz2 = object.getPackageName();
            ((StringBuilder)serializable).append((String)((Object)clazz2));
            ((StringBuilder)serializable).append((String)object2);
            object2 = ((StringBuilder)serializable).toString();
        }
        if ((clazz2 = (Class)((HashMap)(serializable = sClasses)).get(object2)) == null) {
            c10 = '\u0001';
            try {
                object = object.getClassLoader();
            }
            catch (ClassNotFoundException classNotFoundException) {
                object2 = new IllegalArgumentException(classNotFoundException);
                throw object2;
            }
            clazz2 = Class.forName((String)object2, c10 != 0, (ClassLoader)object);
            ((HashMap)serializable).put(object2, clazz2);
        }
        if (bl2 = clazz.isAssignableFrom(clazz2)) {
            return clazz2;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append((String)object2);
        ((StringBuilder)serializable).append(" must be a subclass of ");
        ((StringBuilder)serializable).append(clazz);
        object2 = ((StringBuilder)serializable).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public final void addArgument(String string2, NavArgument navArgument) {
        HashMap hashMap = this.mArguments;
        if (hashMap == null) {
            this.mArguments = hashMap = new HashMap();
        }
        this.mArguments.put(string2, navArgument);
    }

    public final void addDeepLink(NavDeepLink navDeepLink) {
        ArrayList arrayList = this.mDeepLinks;
        if (arrayList == null) {
            this.mDeepLinks = arrayList = new ArrayList();
        }
        this.mDeepLinks.add(navDeepLink);
    }

    public final void addDeepLink(String object) {
        NavDeepLink$Builder navDeepLink$Builder = new NavDeepLink$Builder();
        object = navDeepLink$Builder.setUriPattern((String)object).build();
        this.addDeepLink((NavDeepLink)object);
    }

    public Bundle addInDefaultArgs(Bundle object) {
        Object object2;
        Object object3;
        boolean bl2;
        boolean bl3;
        Object object4;
        if (object == null && ((object4 = this.mArguments) == null || (bl3 = ((HashMap)object4).isEmpty()))) {
            return null;
        }
        object4 = new Bundle();
        Object object5 = this.mArguments;
        if (object5 != null) {
            object5 = ((HashMap)object5).entrySet().iterator();
            while (bl2 = object5.hasNext()) {
                object3 = (Map.Entry)object5.next();
                object2 = (NavArgument)object3.getValue();
                object3 = (String)object3.getKey();
                ((NavArgument)object2).putDefaultValue((String)object3, (Bundle)object4);
            }
        }
        if (object != null) {
            object4.putAll((Bundle)object);
            object = this.mArguments;
            if (object != null) {
                boolean bl4;
                object = ((HashMap)object).entrySet().iterator();
                while (bl4 = object.hasNext()) {
                    object5 = (Map.Entry)object.next();
                    object3 = (NavArgument)object5.getValue();
                    bl2 = ((NavArgument)object3).verify((String)(object2 = (String)object5.getKey()), (Bundle)object4);
                    if (bl2) continue;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("Wrong argument type for '");
                    object3 = (String)object5.getKey();
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append("' in argument bundle. ");
                    object5 = ((NavArgument)object5.getValue()).getType().getName();
                    ((StringBuilder)object4).append((String)object5);
                    ((StringBuilder)object4).append(" expected.");
                    object4 = ((StringBuilder)object4).toString();
                    object = new IllegalArgumentException((String)object4);
                    throw object;
                }
            }
        }
        return object4;
    }

    public int[] buildDeepLinkIds() {
        Object object = new ArrayDeque();
        Object object2 = this;
        while (true) {
            int n10;
            int n11;
            NavGraph navGraph;
            if ((navGraph = ((NavDestination)object2).getParent()) == null || (n11 = navGraph.getStartDestination()) != (n10 = ((NavDestination)object2).getId())) {
                ((ArrayDeque)object).addFirst(object2);
            }
            if (navGraph == null) {
                int n12 = ((ArrayDeque)object).size();
                object2 = new int[n12];
                int n13 = 0;
                navGraph = null;
                object = ((ArrayDeque)object).iterator();
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    NavDestination navDestination = (NavDestination)object.next();
                    n10 = n13 + 1;
                    n11 = navDestination.getId();
                    object2[n13] = n11;
                    n13 = n10;
                }
                return object2;
            }
            object2 = navGraph;
        }
    }

    public final NavAction getAction(int n10) {
        Object object = this.mActions;
        Object object2 = null;
        if ((object = object == null ? null : (NavAction)((SparseArrayCompat)object).get(n10)) != null) {
            object2 = object;
        } else {
            object = this.getParent();
            if (object != null) {
                object = this.getParent();
                object2 = ((NavDestination)object).getAction(n10);
            }
        }
        return object2;
    }

    public final Map getArguments() {
        Map map = this.mArguments;
        map = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        return map;
    }

    public String getDisplayName() {
        String string2 = this.mIdName;
        if (string2 == null) {
            int n10 = this.mId;
            this.mIdName = string2 = Integer.toString(n10);
        }
        return this.mIdName;
    }

    public final int getId() {
        return this.mId;
    }

    public final CharSequence getLabel() {
        return this.mLabel;
    }

    public final String getNavigatorName() {
        return this.mNavigatorName;
    }

    public final NavGraph getParent() {
        return this.mParent;
    }

    public boolean hasDeepLink(Uri uri) {
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(uri, null, null);
        return this.hasDeepLink(navDeepLinkRequest);
    }

    public boolean hasDeepLink(NavDeepLinkRequest object) {
        boolean bl2;
        if ((object = this.matchDeepLink((NavDeepLinkRequest)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public NavDestination$DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        int n10;
        Object object = this.mDeepLinks;
        if (object == null) {
            return null;
        }
        object = ((ArrayList)object).iterator();
        Object object2 = null;
        while ((n10 = object.hasNext()) != 0) {
            int n11;
            boolean bl2;
            Object object3;
            Object object4;
            NavDeepLink navDeepLink = (NavDeepLink)object.next();
            Object object5 = navDeepLinkRequest.getUri();
            if (object5 != null) {
                object4 = this.getArguments();
                object3 = object5 = navDeepLink.getMatchingArguments((Uri)object5, (Map)object4);
            } else {
                object3 = null;
            }
            object5 = navDeepLinkRequest.getAction();
            if (object5 != null && (bl2 = ((String)object5).equals(object4 = navDeepLink.getAction()))) {
                bl2 = true;
            } else {
                bl2 = false;
                object5 = null;
            }
            boolean bl3 = bl2;
            object5 = navDeepLinkRequest.getMimeType();
            int n12 = -1;
            if (object5 != null) {
                bl2 = navDeepLink.getMimeTypeMatchRating((String)object5);
                n11 = bl2;
            } else {
                n11 = n12;
            }
            if (object3 == null && !bl3 && n11 <= n12) continue;
            boolean bl4 = navDeepLink.isExactDeepLink();
            object4 = object5;
            object5 = new NavDestination$DeepLinkMatch(this, (Bundle)object3, bl4, bl3, n11);
            if (object2 != null && (n10 = ((NavDestination$DeepLinkMatch)object5).compareTo((NavDestination$DeepLinkMatch)object2)) <= 0) continue;
            object2 = object5;
        }
        return object2;
    }

    public void onInflate(Context object, AttributeSet attributeSet) {
        Resources resources = object.getResources();
        int[] nArray = R$styleable.Navigator;
        attributeSet = resources.obtainAttributes(attributeSet, nArray);
        int n10 = R$styleable.Navigator_android_id;
        n10 = attributeSet.getResourceId(n10, 0);
        this.setId(n10);
        n10 = this.mId;
        object = NavDestination.getDisplayName(object, n10);
        this.mIdName = object;
        int n11 = R$styleable.Navigator_android_label;
        object = attributeSet.getText(n11);
        this.setLabel((CharSequence)object);
        attributeSet.recycle();
    }

    public final void putAction(int n10, int n11) {
        NavAction navAction = new NavAction(n11);
        this.putAction(n10, navAction);
    }

    public final void putAction(int n10, NavAction object) {
        boolean bl2 = this.supportsActions();
        if (bl2) {
            if (n10 != 0) {
                SparseArrayCompat sparseArrayCompat = this.mActions;
                if (sparseArrayCompat == null) {
                    this.mActions = sparseArrayCompat = new SparseArrayCompat();
                }
                this.mActions.put(n10, object);
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot have an action with actionId 0");
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot add action ");
        stringBuilder.append(n10);
        stringBuilder.append(" to ");
        stringBuilder.append(this);
        stringBuilder.append(" as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        String string2 = stringBuilder.toString();
        object = new UnsupportedOperationException(string2);
        throw object;
    }

    public final void removeAction(int n10) {
        SparseArrayCompat sparseArrayCompat = this.mActions;
        if (sparseArrayCompat == null) {
            return;
        }
        sparseArrayCompat.remove(n10);
    }

    public final void removeArgument(String string2) {
        HashMap hashMap = this.mArguments;
        if (hashMap == null) {
            return;
        }
        hashMap.remove(string2);
    }

    public final void setId(int n10) {
        this.mId = n10;
        this.mIdName = null;
    }

    public final void setLabel(CharSequence charSequence) {
        this.mLabel = charSequence;
    }

    public final void setParent(NavGraph navGraph) {
        this.mParent = navGraph;
    }

    public boolean supportsActions() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = this.getClass().getSimpleName();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("(");
        charSequence = this.mIdName;
        if (charSequence == null) {
            stringBuilder.append("0x");
            int n10 = this.mId;
            charSequence = Integer.toHexString(n10);
            stringBuilder.append((String)charSequence);
        } else {
            stringBuilder.append((String)charSequence);
        }
        stringBuilder.append(")");
        charSequence = this.mLabel;
        if (charSequence != null) {
            stringBuilder.append(" label=");
            charSequence = this.mLabel;
            stringBuilder.append(charSequence);
        }
        return stringBuilder.toString();
    }
}

