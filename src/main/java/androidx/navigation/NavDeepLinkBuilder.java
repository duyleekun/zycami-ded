/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.navigation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.TaskStackBuilder;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLinkBuilder$PermissiveNavigatorProvider;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import java.util.ArrayDeque;

public final class NavDeepLinkBuilder {
    private Bundle mArgs;
    private final Context mContext;
    private int mDestId;
    private NavGraph mGraph;
    private final Intent mIntent;

    public NavDeepLinkBuilder(Context object) {
        this.mContext = object;
        boolean bl2 = object instanceof Activity;
        if (bl2) {
            Intent intent;
            Class<?> clazz = object.getClass();
            this.mIntent = intent = new Intent(object, clazz);
        } else {
            PackageManager packageManager = object.getPackageManager();
            object = object.getPackageName();
            if ((object = packageManager.getLaunchIntentForPackage((String)object)) == null) {
            }
            this.mIntent = object;
        }
        this.mIntent.addFlags(0x10008000);
    }

    public NavDeepLinkBuilder(NavController object) {
        Context context = ((NavController)object).getContext();
        this(context);
        this.mGraph = object = ((NavController)object).getGraph();
    }

    private void fillInIntent() {
        Object object;
        boolean bl2;
        Object object2 = new ArrayDeque();
        Object object3 = this.mGraph;
        ((ArrayDeque)object2).add(object3);
        int n10 = 0;
        object3 = null;
        while (!(bl2 = ((ArrayDeque)object2).isEmpty()) && object3 == null) {
            int n11;
            object = (NavDestination)((ArrayDeque)object2).poll();
            int n12 = ((NavDestination)object).getId();
            if (n12 == (n11 = this.mDestId)) {
                object3 = object;
                continue;
            }
            n12 = object instanceof NavGraph;
            if (n12 == 0) continue;
            object = ((NavGraph)object).iterator();
            while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                NavDestination navDestination = (NavDestination)object.next();
                ((ArrayDeque)object2).add(navDestination);
            }
        }
        if (object3 != null) {
            object2 = this.mIntent;
            object3 = ((NavDestination)object3).buildDeepLinkIds();
            object2.putExtra("android-support-nav:controller:deepLinkIds", (int[])object3);
            return;
        }
        object2 = this.mContext;
        n10 = this.mDestId;
        object2 = NavDestination.getDisplayName((Context)object2, n10);
        object = new StringBuilder();
        ((StringBuilder)object).append("Navigation destination ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" cannot be found in the navigation graph ");
        object2 = this.mGraph;
        ((StringBuilder)object).append(object2);
        object2 = ((StringBuilder)object).toString();
        object3 = new IllegalArgumentException((String)object2);
        throw object3;
    }

    public PendingIntent createPendingIntent() {
        Object object = this.mArgs;
        int n10 = 0;
        if (object != null) {
            int n11;
            object = object.keySet().iterator();
            int n12 = 0;
            while ((n11 = object.hasNext()) != 0) {
                Object object2 = (String)object.next();
                Bundle bundle = this.mArgs;
                object2 = bundle.get((String)object2);
                n12 *= 31;
                if (object2 != null) {
                    n11 = object2.hashCode();
                } else {
                    n11 = 0;
                    object2 = null;
                }
                n12 += n11;
            }
            n10 = n12;
        }
        n10 *= 31;
        int n13 = this.mDestId;
        return this.createTaskStackBuilder().getPendingIntent(n10 += n13, 0x8000000);
    }

    public TaskStackBuilder createTaskStackBuilder() {
        int n10;
        Object object = this.mIntent;
        String string2 = "android-support-nav:controller:deepLinkIds";
        if ((object = (Object)object.getIntArrayExtra(string2)) == null) {
            object = this.mGraph;
            if (object == null) {
                object = new IllegalStateException("You must call setGraph() before constructing the deep link");
                throw object;
            }
            object = new IllegalStateException("You must call setDestination() before constructing the deep link");
            throw object;
        }
        object = TaskStackBuilder.create(this.mContext);
        Intent intent = this.mIntent;
        string2 = new Intent(intent);
        object = ((TaskStackBuilder)object).addNextIntentWithParentStack((Intent)string2);
        string2 = null;
        for (int i10 = 0; i10 < (n10 = ((TaskStackBuilder)object).getIntentCount()); ++i10) {
            intent = ((TaskStackBuilder)object).editIntentAt(i10);
            Intent intent2 = this.mIntent;
            String string3 = "android-support-nav:controller:deepLinkIntent";
            intent.putExtra(string3, (Parcelable)intent2);
        }
        return object;
    }

    public NavDeepLinkBuilder setArguments(Bundle bundle) {
        this.mArgs = bundle;
        this.mIntent.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public NavDeepLinkBuilder setComponentName(ComponentName componentName) {
        this.mIntent.setComponent(componentName);
        return this;
    }

    public NavDeepLinkBuilder setComponentName(Class clazz) {
        Context context = this.mContext;
        ComponentName componentName = new ComponentName(context, clazz);
        return this.setComponentName(componentName);
    }

    public NavDeepLinkBuilder setDestination(int n10) {
        this.mDestId = n10;
        NavGraph navGraph = this.mGraph;
        if (navGraph != null) {
            this.fillInIntent();
        }
        return this;
    }

    public NavDeepLinkBuilder setGraph(int n10) {
        Context context = this.mContext;
        NavDeepLinkBuilder$PermissiveNavigatorProvider navDeepLinkBuilder$PermissiveNavigatorProvider = new NavDeepLinkBuilder$PermissiveNavigatorProvider();
        NavInflater navInflater = new NavInflater(context, navDeepLinkBuilder$PermissiveNavigatorProvider);
        NavGraph navGraph = navInflater.inflate(n10);
        return this.setGraph(navGraph);
    }

    public NavDeepLinkBuilder setGraph(NavGraph navGraph) {
        this.mGraph = navGraph;
        int n10 = this.mDestId;
        if (n10 != 0) {
            this.fillInIntent();
        }
        return this;
    }
}

