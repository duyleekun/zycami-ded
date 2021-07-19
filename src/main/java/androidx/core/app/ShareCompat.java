/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.view.ActionProvider
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.ShareActionProvider
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.app.ShareCompat$IntentBuilder;

public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    private ShareCompat() {
    }

    public static void configureMenuItem(Menu object, int n10, ShareCompat$IntentBuilder object2) {
        if ((object = object.findItem(n10)) != null) {
            ShareCompat.configureMenuItem((MenuItem)object, (ShareCompat$IntentBuilder)object2);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Could not find menu item with id ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" in the supplied menu");
        String string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public static void configureMenuItem(MenuItem menuItem, ShareCompat$IntentBuilder shareCompat$IntentBuilder) {
        Object object;
        ActionProvider actionProvider = menuItem.getActionProvider();
        int n10 = actionProvider instanceof ShareActionProvider;
        if (n10 == 0) {
            object = shareCompat$IntentBuilder.getContext();
            actionProvider = new ShareActionProvider((Context)object);
        } else {
            actionProvider = (ShareActionProvider)actionProvider;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(HISTORY_FILENAME_PREFIX);
        String string2 = shareCompat$IntentBuilder.getContext().getClass().getName();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        actionProvider.setShareHistoryFileName((String)object);
        object = shareCompat$IntentBuilder.getIntent();
        actionProvider.setShareIntent((Intent)object);
        menuItem.setActionProvider(actionProvider);
        int n11 = Build.VERSION.SDK_INT;
        n10 = 16;
        if (n11 < n10 && (n11 = (int)(menuItem.hasSubMenu() ? 1 : 0)) == 0) {
            shareCompat$IntentBuilder = shareCompat$IntentBuilder.createChooserIntent();
            menuItem.setIntent((Intent)shareCompat$IntentBuilder);
        }
    }

    public static ComponentName getCallingActivity(Activity activity) {
        Intent intent = activity.getIntent();
        if ((activity = activity.getCallingActivity()) == null) {
            activity = ShareCompat.getCallingActivity(intent);
        }
        return activity;
    }

    public static ComponentName getCallingActivity(Intent intent) {
        ComponentName componentName = (ComponentName)intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        if (componentName == null) {
            intent = intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP);
            componentName = intent;
            componentName = (ComponentName)intent;
        }
        return componentName;
    }

    public static String getCallingPackage(Activity object) {
        Intent intent = object.getIntent();
        if ((object = object.getCallingPackage()) == null && intent != null) {
            object = ShareCompat.getCallingPackage(intent);
        }
        return object;
    }

    public static String getCallingPackage(Intent intent) {
        String string2 = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        if (string2 == null) {
            string2 = intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP);
        }
        return string2;
    }
}

