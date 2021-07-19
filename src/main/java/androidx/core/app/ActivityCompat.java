/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.SharedElementCallback
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.DragEvent
 *  android.view.View
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.core.app.ActivityCompat$1;
import androidx.core.app.ActivityCompat$2;
import androidx.core.app.ActivityCompat$Api30Impl;
import androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback;
import androidx.core.app.ActivityCompat$PermissionCompatDelegate;
import androidx.core.app.ActivityCompat$RequestPermissionsRequestCodeValidator;
import androidx.core.app.ActivityCompat$SharedElementCallback21Impl;
import androidx.core.app.ActivityRecreator;
import androidx.core.app.SharedElementCallback;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.Arrays;

public class ActivityCompat
extends ContextCompat {
    private static ActivityCompat$PermissionCompatDelegate sDelegate;

    public static void finishAffinity(Activity activity) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void finishAfterTransition(Activity activity) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static ActivityCompat$PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    public static Uri getReferrer(Activity object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            return object.getReferrer();
        }
        Object object2 = (Uri)(object = object.getIntent()).getParcelableExtra("android.intent.extra.REFERRER");
        if (object2 != null) {
            return object2;
        }
        object2 = "android.intent.extra.REFERRER_NAME";
        if ((object = object.getStringExtra((String)object2)) != null) {
            return Uri.parse((String)object);
        }
        return null;
    }

    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static void postponeEnterTransition(Activity activity) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            activity.postponeEnterTransition();
        }
    }

    public static void recreate(Activity activity) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            activity.recreate();
        } else {
            n11 = 23;
            if (n10 <= n11) {
                Object object = activity.getMainLooper();
                Handler handler = new Handler(object);
                object = new ActivityCompat$2(activity);
                handler.post((Runnable)object);
            } else {
                n10 = (int)(ActivityRecreator.recreate(activity) ? 1 : 0);
                if (n10 == 0) {
                    activity.recreate();
                }
            }
        }
    }

    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity activity, DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    public static void requestPermissions(Activity object, String[] object2, int n10) {
        int n11;
        int n12;
        Object object3 = sDelegate;
        if (object3 != null && (n12 = (int)(object3.requestPermissions((Activity)object, (String[])object2, n10) ? 1 : 0)) != 0) {
            return;
        }
        n12 = ((String[])object2).length;
        Object object4 = null;
        for (n11 = 0; n11 < n12; ++n11) {
            String string2 = object2[n11];
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Permission request for permissions ");
            object2 = Arrays.toString(object2);
            stringBuilder.append((String)object2);
            stringBuilder.append(" must not contain null or empty values");
            object2 = stringBuilder.toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        n12 = Build.VERSION.SDK_INT;
        n11 = 23;
        if (n12 >= n11) {
            n12 = object instanceof ActivityCompat$RequestPermissionsRequestCodeValidator;
            if (n12 != 0) {
                object3 = object;
                object3 = (ActivityCompat$RequestPermissionsRequestCodeValidator)object;
                object3.validateRequestPermissionsRequestCode(n10);
            }
            object.requestPermissions(object2, n10);
        } else {
            n12 = object instanceof ActivityCompat$OnRequestPermissionsResultCallback;
            if (n12 != 0) {
                object4 = Looper.getMainLooper();
                object3 = new Handler(object4);
                object4 = new ActivityCompat$1((String[])object2, (Activity)object, n10);
                object3.post((Runnable)object4);
            }
        }
    }

    public static View requireViewById(Activity object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            return object.requireViewById(n10);
        }
        if ((object = object.findViewById(n10)) != null) {
            return object;
        }
        object = new IllegalArgumentException("ID does not reference a View inside this Activity");
        throw object;
    }

    public static void setEnterSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            ActivityCompat$SharedElementCallback21Impl activityCompat$SharedElementCallback21Impl;
            if (sharedElementCallback != null) {
                activityCompat$SharedElementCallback21Impl = new ActivityCompat$SharedElementCallback21Impl(sharedElementCallback);
            } else {
                n10 = 0;
                activityCompat$SharedElementCallback21Impl = null;
            }
            activity.setEnterSharedElementCallback((android.app.SharedElementCallback)activityCompat$SharedElementCallback21Impl);
        }
    }

    public static void setExitSharedElementCallback(Activity activity, SharedElementCallback sharedElementCallback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            ActivityCompat$SharedElementCallback21Impl activityCompat$SharedElementCallback21Impl;
            if (sharedElementCallback != null) {
                activityCompat$SharedElementCallback21Impl = new ActivityCompat$SharedElementCallback21Impl(sharedElementCallback);
            } else {
                n10 = 0;
                activityCompat$SharedElementCallback21Impl = null;
            }
            activity.setExitSharedElementCallback((android.app.SharedElementCallback)activityCompat$SharedElementCallback21Impl);
        }
    }

    public static void setLocusContext(Activity activity, LocusIdCompat locusIdCompat, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            ActivityCompat$Api30Impl.setLocusContext(activity, locusIdCompat, bundle);
        }
    }

    public static void setPermissionCompatDelegate(ActivityCompat$PermissionCompatDelegate activityCompat$PermissionCompatDelegate) {
        sDelegate = activityCompat$PermissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return activity.shouldShowRequestPermissionRationale(string2);
        }
        return false;
    }

    public static void startActivityForResult(Activity activity, Intent intent, int n10, Bundle bundle) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            activity.startActivityForResult(intent, n10, bundle);
        } else {
            activity.startActivityForResult(intent, n10);
        }
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int n10, Intent intent, int n11, int n12, int n13, Bundle bundle) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 16;
        if (n14 >= n15) {
            activity.startIntentSenderForResult(intentSender, n10, intent, n11, n12, n13, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, n10, intent, n11, n12, n13);
        }
    }

    public static void startPostponedEnterTransition(Activity activity) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            activity.startPostponedEnterTransition();
        }
    }
}

