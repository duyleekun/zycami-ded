/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ResolveInfo
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.KeyEvent
 */
package androidx.media.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.session.MediaButtonReceiver$MediaButtonConnectionCallback;

public class MediaButtonReceiver
extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    public static PendingIntent buildMediaButtonPendingIntent(Context context, long l10) {
        ComponentName componentName = MediaButtonReceiver.getMediaButtonReceiverComponent(context);
        if (componentName == null) {
            Log.w((String)TAG, (String)"A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
            return null;
        }
        return MediaButtonReceiver.buildMediaButtonPendingIntent(context, componentName, l10);
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context object, ComponentName componentName, long l10) {
        String string2 = TAG;
        if (componentName == null) {
            Log.w((String)string2, (String)"The component name of media button receiver should be provided.");
            return null;
        }
        int n10 = PlaybackStateCompat.toKeyCode(l10);
        if (n10 == 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot build a media button pending intent with the given action: ");
            ((StringBuilder)object).append(l10);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
            return null;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        componentName = new KeyEvent(0, n10);
        intent.putExtra("android.intent.extra.KEY_EVENT", (Parcelable)componentName);
        return PendingIntent.getBroadcast((Context)object, (int)n10, (Intent)intent, (int)0);
    }

    public static ComponentName getMediaButtonReceiverComponent(Context object) {
        Object object2 = new Intent("android.intent.action.MEDIA_BUTTON");
        String string2 = object.getPackageName();
        object2.setPackage(string2);
        object = object.getPackageManager();
        string2 = null;
        object = object.queryBroadcastReceivers(object2, 0);
        int n10 = object.size();
        int n11 = 1;
        if (n10 == n11) {
            object = (ResolveInfo)object.get(0);
            object = ((ResolveInfo)object).activityInfo;
            string2 = ((ActivityInfo)object).packageName;
            object = ((ActivityInfo)object).name;
            object2 = new ComponentName(string2, (String)object);
            return object2;
        }
        int n12 = object.size();
        if (n12 > n11) {
            object = TAG;
            object2 = "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.";
            Log.w((String)object, (String)object2);
        }
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context object, String string2) {
        Object object2 = object.getPackageManager();
        Object object3 = new Intent(string2);
        object = object.getPackageName();
        object3.setPackage((String)object);
        boolean bl2 = false;
        object = null;
        object2 = object2.queryIntentServices((Intent)object3, 0);
        int n10 = object2.size();
        int n11 = 1;
        if (n10 == n11) {
            object = (ResolveInfo)object2.get(0);
            object = object.serviceInfo;
            object2 = object.packageName;
            object = object.name;
            string2 = new ComponentName((String)object2, (String)object);
            return string2;
        }
        bl2 = object2.isEmpty();
        if (bl2) {
            return null;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Expected 1 service that handles ");
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append(", found ");
        int n12 = object2.size();
        ((StringBuilder)object3).append(n12);
        string2 = ((StringBuilder)object3).toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public static KeyEvent handleIntent(MediaSessionCompat mediaSessionCompat, Intent intent) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3;
        if (mediaSessionCompat != null && intent != null && (bl3 = (string3 = "android.intent.action.MEDIA_BUTTON").equals(string2 = intent.getAction())) && (bl2 = intent.hasExtra(string2 = "android.intent.extra.KEY_EVENT"))) {
            intent = (KeyEvent)intent.getParcelableExtra(string2);
            mediaSessionCompat.getController().dispatchMediaButtonEvent((KeyEvent)intent);
            return intent;
        }
        return null;
    }

    private static void startForegroundService(Context context, Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public void onReceive(Context object, Intent object2) {
        String string2;
        String string3;
        boolean bl2;
        if (object2 != null && (bl2 = (string3 = "android.intent.action.MEDIA_BUTTON").equals(string2 = object2.getAction())) && (bl2 = object2.hasExtra(string2 = "android.intent.extra.KEY_EVENT"))) {
            string2 = MediaButtonReceiver.getServiceComponentByAction((Context)object, string3);
            if (string2 != null) {
                object2.setComponent((ComponentName)string2);
                MediaButtonReceiver.startForegroundService((Context)object, (Intent)object2);
                return;
            }
            string2 = MediaButtonReceiver.getServiceComponentByAction((Context)object, "android.media.browse.MediaBrowserService");
            if (string2 != null) {
                string3 = this.goAsync();
                object = object.getApplicationContext();
                MediaButtonReceiver$MediaButtonConnectionCallback mediaButtonReceiver$MediaButtonConnectionCallback = new MediaButtonReceiver$MediaButtonConnectionCallback((Context)object, (Intent)object2, (BroadcastReceiver.PendingResult)string3);
                object2 = new MediaBrowserCompat((Context)object, (ComponentName)string2, mediaButtonReceiver$MediaButtonConnectionCallback, null);
                mediaButtonReceiver$MediaButtonConnectionCallback.setMediaBrowser((MediaBrowserCompat)object2);
                ((MediaBrowserCompat)object2).connect();
                return;
            }
            object = new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Ignore unsupported intent: ");
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        Log.d((String)TAG, (String)object);
    }
}

