/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.Intent
 *  android.content.res.Resources
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.DialogRedirect;

public final class GooglePlayServicesUtil
extends GooglePlayServicesUtilLight {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    private GooglePlayServicesUtil() {
    }

    public static Dialog getErrorDialog(int n10, Activity activity, int n11) {
        return GooglePlayServicesUtil.getErrorDialog(n10, activity, n11, null);
    }

    public static Dialog getErrorDialog(int n10, Activity activity, int n11, DialogInterface.OnCancelListener onCancelListener) {
        boolean bl2 = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)activity, n10);
        if (bl2) {
            n10 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, n10, n11, onCancelListener);
    }

    public static PendingIntent getErrorPendingIntent(int n10, Context context, int n11) {
        return GooglePlayServicesUtilLight.getErrorPendingIntent(n10, context, n11);
    }

    public static String getErrorString(int n10) {
        return GooglePlayServicesUtilLight.getErrorString(n10);
    }

    public static Context getRemoteContext(Context context) {
        return GooglePlayServicesUtilLight.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return GooglePlayServicesUtilLight.getRemoteResource(context);
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context);
    }

    public static int isGooglePlayServicesAvailable(Context context, int n10) {
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, n10);
    }

    public static boolean isUserRecoverableError(int n10) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(n10);
    }

    public static boolean showErrorDialogFragment(int n10, Activity activity, int n11) {
        return GooglePlayServicesUtil.showErrorDialogFragment(n10, activity, n11, null);
    }

    public static boolean showErrorDialogFragment(int n10, Activity activity, int n11, DialogInterface.OnCancelListener onCancelListener) {
        return GooglePlayServicesUtil.showErrorDialogFragment(n10, activity, null, n11, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int n10, Activity activity, Fragment object, int n11, DialogInterface.OnCancelListener onCancelListener) {
        boolean bl2 = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)activity, n10);
        if (bl2) {
            n10 = 18;
        }
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        if (object == null) {
            return googleApiAvailability.showErrorDialogFragment(activity, n10, n11, onCancelListener);
        }
        googleApiAvailability = GoogleApiAvailability.getInstance();
        String string2 = "d";
        Dialog dialog = GoogleApiAvailability.zaa((Context)activity, n10, (DialogRedirect)(object = DialogRedirect.getInstance((Fragment)object, (Intent)(googleApiAvailability = googleApiAvailability.getErrorResolutionIntent((Context)activity, n10, string2)), n11)), onCancelListener);
        if (dialog == null) {
            return false;
        }
        GoogleApiAvailability.zaa(activity, dialog, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    public static void showErrorNotification(int n10, Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        boolean bl2 = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, n10);
        if (!bl2 && !(bl2 = GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, n10))) {
            googleApiAvailability.showErrorNotification(context, n10);
            return;
        }
        googleApiAvailability.zaa(context);
    }
}

