/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.FragmentManager
 *  android.app.Notification
 *  android.app.NotificationChannel
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.ProgressBar
 */
package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.ErrorDialogFragment;
import com.google.android.gms.common.GoogleApiAvailability$zaa;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabr;
import com.google.android.gms.common.api.internal.zabu;
import com.google.android.gms.common.api.internal.zal;
import com.google.android.gms.common.internal.ConnectionErrorMessages;
import com.google.android.gms.common.internal.DialogRedirect;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.zaa;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class GoogleApiAvailability
extends GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final Object mLock;
    private static final GoogleApiAvailability zaao;
    private String zaap;

    static {
        Object object;
        mLock = object = new Object();
        zaao = object = new GoogleApiAvailability();
        GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public static GoogleApiAvailability getInstance() {
        return zaao;
    }

    public static Dialog zaa(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        Object object = new ProgressBar((Context)activity, null, 16842874);
        object.setIndeterminate(true);
        object.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity);
        builder.setView((View)object);
        object = ConnectionErrorMessages.getErrorMessage((Context)activity, 18);
        builder.setMessage((CharSequence)object);
        builder.setPositiveButton((CharSequence)"", null);
        object = builder.create();
        GoogleApiAvailability.zaa(activity, (Dialog)object, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return object;
    }

    public static Dialog zaa(Context object, int n10, DialogRedirect dialogRedirect, DialogInterface.OnCancelListener object2) {
        AlertDialog.Builder builder = null;
        if (n10 == 0) {
            return null;
        }
        Object object3 = new TypedValue();
        Object object4 = object.getTheme();
        int n11 = 16843529;
        boolean bl2 = true;
        object4.resolveAttribute(n11, object3, bl2);
        object4 = object.getResources();
        int n12 = object3.resourceId;
        object3 = object4.getResourceEntryName(n12);
        object4 = "Theme.Dialog.Alert";
        n12 = (int)(((String)object4).equals(object3) ? 1 : 0);
        if (n12 != 0) {
            n12 = 5;
            builder = new AlertDialog.Builder(object, n12);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(object);
        }
        object3 = ConnectionErrorMessages.getErrorMessage(object, n10);
        builder.setMessage((CharSequence)object3);
        if (object2 != null) {
            builder.setOnCancelListener(object2);
        }
        if ((object2 = ConnectionErrorMessages.getErrorDialogButtonMessage(object, n10)) != null) {
            builder.setPositiveButton((CharSequence)object2, (DialogInterface.OnClickListener)dialogRedirect);
        }
        if ((object = ConnectionErrorMessages.getErrorTitle(object, n10)) != null) {
            builder.setTitle((CharSequence)object);
        }
        return builder.create();
    }

    public static void zaa(Activity object, Dialog dialog, String string2, DialogInterface.OnCancelListener onCancelListener) {
        boolean bl2 = object instanceof FragmentActivity;
        if (bl2) {
            object = ((FragmentActivity)object).getSupportFragmentManager();
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show((androidx.fragment.app.FragmentManager)object, string2);
            return;
        }
        object = object.getFragmentManager();
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show((FragmentManager)object, string2);
    }

    private final void zaa(Context object, int n10, String object2, PendingIntent object3) {
        int n11 = 18;
        if (n10 == n11) {
            this.zaa((Context)object);
            return;
        }
        if (object3 == null) {
            int n12 = 6;
            if (n10 == n12) {
                object = "GoogleApiAvailability";
                String string2 = "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.";
                Log.w((String)object, (String)string2);
            }
            return;
        }
        object2 = ConnectionErrorMessages.getErrorNotificationTitle((Context)object, n10);
        Object object4 = ConnectionErrorMessages.getErrorNotificationMessage((Context)object, n10);
        Object object5 = object.getResources();
        NotificationManager notificationManager = (NotificationManager)object.getSystemService("notification");
        Object object6 = new NotificationCompat$Builder((Context)object);
        int n13 = 1;
        object2 = ((NotificationCompat$Builder)object6).setLocalOnly(n13 != 0).setAutoCancel(n13 != 0).setContentTitle((CharSequence)object2);
        object6 = new NotificationCompat$BigTextStyle();
        object6 = ((NotificationCompat$BigTextStyle)object6).bigText((CharSequence)object4);
        object2 = ((NotificationCompat$Builder)object2).setStyle((NotificationCompat$Style)object6);
        int n14 = DeviceProperties.isWearable((Context)object);
        int n15 = 2;
        if (n14 != 0) {
            Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
            int n16 = object.getApplicationInfo().icon;
            object4 = ((NotificationCompat$Builder)object2).setSmallIcon(n16);
            ((NotificationCompat$Builder)object4).setPriority(n15);
            n16 = (int)(DeviceProperties.isWearableWithoutPlayStore((Context)object) ? 1 : 0);
            if (n16 != 0) {
                n16 = R$drawable.common_full_open_on_phone;
                n14 = R$string.common_open_on_phone;
                object5 = object5.getString(n14);
                ((NotificationCompat$Builder)object2).addAction(n16, (CharSequence)object5, (PendingIntent)object3);
            } else {
                ((NotificationCompat$Builder)object2).setContentIntent((PendingIntent)object3);
            }
        } else {
            n14 = 17301642;
            object6 = ((NotificationCompat$Builder)object2).setSmallIcon(n14);
            int n17 = R$string.common_google_play_services_notification_ticker;
            object5 = object5.getString(n17);
            object5 = ((NotificationCompat$Builder)object6).setTicker((CharSequence)object5);
            long l10 = System.currentTimeMillis();
            object5 = ((NotificationCompat$Builder)object5).setWhen(l10);
            object3 = ((NotificationCompat$Builder)object5).setContentIntent((PendingIntent)object3);
            ((NotificationCompat$Builder)object3).setContentText((CharSequence)object4);
        }
        boolean bl2 = PlatformVersion.isAtLeastO();
        if (bl2) {
            bl2 = PlatformVersion.isAtLeastO();
            Preconditions.checkState(bl2);
            object3 = this.zag();
            if (object3 == null) {
                object3 = "com.google.android.gms.availability";
                object4 = notificationManager.getNotificationChannel((String)object3);
                object = ConnectionErrorMessages.getDefaultNotificationChannelName((Context)object);
                if (object4 == null) {
                    int n18 = 4;
                    object4 = new NotificationChannel((String)object3, (CharSequence)object, n18);
                    notificationManager.createNotificationChannel((NotificationChannel)object4);
                } else {
                    object5 = object4.getName();
                    boolean bl3 = ((String)object).contentEquals((CharSequence)object5);
                    if (!bl3) {
                        object4.setName((CharSequence)object);
                        notificationManager.createNotificationChannel((NotificationChannel)object4);
                    }
                }
            }
            ((NotificationCompat$Builder)object2).setChannelId((String)object3);
        }
        object = ((NotificationCompat$Builder)object2).build();
        if (n10 != n13 && n10 != n15 && n10 != (n11 = 3)) {
            n10 = 39789;
        } else {
            n10 = 10436;
            object2 = GooglePlayServicesUtilLight.sCanceledAvailabilityNotification;
            bl2 = false;
            object3 = null;
            ((AtomicBoolean)object2).set(false);
        }
        notificationManager.notify(n10, (Notification)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final String zag() {
        Object object = mLock;
        synchronized (object) {
            return this.zaap;
        }
    }

    public Task checkApiAvailability(GoogleApi object, GoogleApi ... object2) {
        ArrayList arrayList = "Requested API must not be null.";
        Preconditions.checkNotNull(object, arrayList);
        for (Object object3 : object2) {
            Preconditions.checkNotNull(object3, arrayList);
        }
        int n10 = ((Object)object2).length + 1;
        arrayList = new ArrayList(n10);
        arrayList.add(object);
        object = Arrays.asList(object2);
        arrayList.addAll(object);
        object = GoogleApiManager.zabc().zaa(arrayList);
        zaa zaa2 = new zaa(this);
        return ((Task)object).continueWith(zaa2);
    }

    public int getClientVersion(Context context) {
        return super.getClientVersion(context);
    }

    public Dialog getErrorDialog(Activity activity, int n10, int n11) {
        return this.getErrorDialog(activity, n10, n11, null);
    }

    public Dialog getErrorDialog(Activity activity, int n10, int n11, DialogInterface.OnCancelListener onCancelListener) {
        Intent intent = this.getErrorResolutionIntent((Context)activity, n10, "d");
        DialogRedirect dialogRedirect = DialogRedirect.getInstance(activity, intent, n11);
        return GoogleApiAvailability.zaa((Context)activity, n10, dialogRedirect, onCancelListener);
    }

    public Intent getErrorResolutionIntent(Context context, int n10, String string2) {
        return super.getErrorResolutionIntent(context, n10, string2);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int n10, int n11) {
        return super.getErrorResolutionPendingIntent(context, n10, n11);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        boolean bl2 = connectionResult.hasResolution();
        if (bl2) {
            return connectionResult.getResolution();
        }
        int n10 = connectionResult.getErrorCode();
        return this.getErrorResolutionPendingIntent(context, n10, 0);
    }

    public final String getErrorString(int n10) {
        return super.getErrorString(n10);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    public int isGooglePlayServicesAvailable(Context context, int n10) {
        return super.isGooglePlayServicesAvailable(context, n10);
    }

    public final boolean isUserResolvableError(int n10) {
        return super.isUserResolvableError(n10);
    }

    public Task makeGooglePlayServicesAvailable(Activity object) {
        int n10 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
        n10 = this.isGooglePlayServicesAvailable((Context)object, n10);
        if (n10 == 0) {
            return Tasks.forResult(null);
        }
        object = zabu.zac((Activity)object);
        ConnectionResult connectionResult = new ConnectionResult(n10, null);
        ((zal)object).zab(connectionResult, 0);
        return ((zabu)object).getTask();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDefaultNotificationChannelId(Context object, String string2) {
        boolean bl2 = PlatformVersion.isAtLeastO();
        if (bl2) {
            String string3 = "notification";
            object = ((NotificationManager)object.getSystemService(string3)).getNotificationChannel(string2);
            Preconditions.checkNotNull(object);
        }
        object = mLock;
        synchronized (object) {
            this.zaap = string2;
            return;
        }
    }

    public boolean showErrorDialogFragment(Activity activity, int n10, int n11) {
        return this.showErrorDialogFragment(activity, n10, n11, null);
    }

    public boolean showErrorDialogFragment(Activity activity, int n10, int n11, DialogInterface.OnCancelListener onCancelListener) {
        Dialog dialog = this.getErrorDialog(activity, n10, n11, onCancelListener);
        if (dialog == null) {
            return false;
        }
        GoogleApiAvailability.zaa(activity, dialog, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void showErrorNotification(Context context, int n10) {
        PendingIntent pendingIntent = this.getErrorResolutionPendingIntent(context, n10, 0, "n");
        this.zaa(context, n10, null, pendingIntent);
    }

    public void showErrorNotification(Context context, ConnectionResult connectionResult) {
        PendingIntent pendingIntent = this.getErrorResolutionPendingIntent(context, connectionResult);
        int n10 = connectionResult.getErrorCode();
        this.zaa(context, n10, null, pendingIntent);
    }

    public final zabq zaa(Context context, zabr zabr2) {
        Object object = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        object.addDataScheme("package");
        zabq zabq2 = new zabq(zabr2);
        context.registerReceiver((BroadcastReceiver)zabq2, object);
        zabq2.zac(context);
        object = GOOGLE_PLAY_SERVICES_PACKAGE;
        boolean bl2 = this.isUninstalledAppPossiblyUpdating(context, (String)object);
        if (!bl2) {
            zabr2.zas();
            zabq2.unregister();
            return null;
        }
        return zabq2;
    }

    public final void zaa(Context context) {
        GoogleApiAvailability$zaa googleApiAvailability$zaa = new GoogleApiAvailability$zaa(this, context);
        googleApiAvailability$zaa.sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean zaa(Activity activity, LifecycleFragment object, int n10, int n11, DialogInterface.OnCancelListener onCancelListener) {
        Intent intent = this.getErrorResolutionIntent((Context)activity, n10, "d");
        int n12 = 2;
        object = DialogRedirect.getInstance((LifecycleFragment)object, intent, n12);
        if ((object = GoogleApiAvailability.zaa((Context)activity, n10, (DialogRedirect)object, onCancelListener)) == null) {
            return false;
        }
        GoogleApiAvailability.zaa(activity, (Dialog)object, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean zaa(Context context, ConnectionResult connectionResult, int n10) {
        PendingIntent pendingIntent = this.getErrorResolutionPendingIntent(context, connectionResult);
        if (pendingIntent != null) {
            int n11 = connectionResult.getErrorCode();
            PendingIntent pendingIntent2 = GoogleApiActivity.zaa(context, pendingIntent, n10);
            this.zaa(context, n11, null, pendingIntent2);
            return true;
        }
        return false;
    }
}

