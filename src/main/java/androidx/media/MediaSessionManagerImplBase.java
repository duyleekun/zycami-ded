/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.provider.Settings$Secure
 *  android.util.Log
 */
package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import androidx.media.MediaSessionManager;
import androidx.media.MediaSessionManager$MediaSessionManagerImpl;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;

public class MediaSessionManagerImplBase
implements MediaSessionManager$MediaSessionManagerImpl {
    private static final boolean DEBUG = false;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    public ContentResolver mContentResolver;
    public Context mContext;

    static {
        DEBUG = MediaSessionManager.DEBUG;
    }

    public MediaSessionManagerImplBase(Context context) {
        this.mContext = context;
        context = context.getContentResolver();
        this.mContentResolver = context;
    }

    private boolean isPermissionGranted(MediaSessionManager$RemoteUserInfoImpl object, String string2) {
        int n10 = object.getPid();
        boolean bl2 = true;
        if (n10 < 0) {
            PackageManager packageManager = this.mContext.getPackageManager();
            int n11 = packageManager.checkPermission(string2, (String)(object = object.getPackageName()));
            if (n11 != 0) {
                bl2 = false;
            }
            return bl2;
        }
        Context context = this.mContext;
        int n12 = object.getPid();
        int n13 = object.getUid();
        if ((n13 = context.checkPermission(string2, n12, n13)) != 0) {
            bl2 = false;
        }
        return bl2;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isEnabledNotificationListener(MediaSessionManager$RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl) {
        String[] stringArray = Settings.Secure.getString((ContentResolver)this.mContentResolver, (String)ENABLED_NOTIFICATION_LISTENERS);
        if (stringArray != null) {
            int n10;
            stringArray = stringArray.split(":");
            for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
                String string2;
                Object object = ComponentName.unflattenFromString((String)stringArray[i10]);
                if (object == null || (n10 = (int)(((String)(object = object.getPackageName())).equals(string2 = mediaSessionManager$RemoteUserInfoImpl.getPackageName()) ? 1 : 0)) == 0) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isTrustedForMediaControl(MediaSessionManager$RemoteUserInfoImpl object) {
        boolean bl2;
        int n10;
        String string2;
        Object object2;
        boolean bl3 = false;
        try {
            object2 = this.mContext;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            boolean bl4 = DEBUG;
            if (bl4) {
                object2 = new StringBuilder();
                string2 = "Package ";
                ((StringBuilder)object2).append(string2);
                object = object.getPackageName();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" doesn't exist");
                object = ((StringBuilder)object2).toString();
                object2 = TAG;
                Log.d((String)object2, (String)object);
            }
            return false;
        }
        object2 = object2.getPackageManager();
        string2 = object.getPackageName();
        object2 = object2.getApplicationInfo(string2, 0);
        if (object2 == null) {
            return false;
        }
        object2 = PERMISSION_STATUS_BAR_SERVICE;
        int n11 = this.isPermissionGranted((MediaSessionManager$RemoteUserInfoImpl)object, (String)object2);
        if (n11 != 0 || (n11 = this.isPermissionGranted((MediaSessionManager$RemoteUserInfoImpl)object, (String)(object2 = PERMISSION_MEDIA_CONTENT_CONTROL))) != 0 || (n11 = object.getUid()) == (n10 = 1000) || (bl2 = this.isEnabledNotificationListener((MediaSessionManager$RemoteUserInfoImpl)object))) {
            bl3 = true;
        }
        return bl3;
    }
}

