/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.Log
 */
package com.google.mediapipe.components;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionHelper {
    private static final String AUDIO_PERMISSION = "android.permission.RECORD_AUDIO";
    private static final String CAMERA_PERMISSION = "android.permission.CAMERA";
    private static final int REQUEST_CODE = 0;
    private static final String TAG = "PermissionHelper";

    public static boolean audioPermissionsGranted(Activity activity) {
        String[] stringArray = new String[]{AUDIO_PERMISSION};
        return PermissionHelper.permissionsGranted(activity, stringArray);
    }

    public static boolean cameraPermissionsGranted(Activity activity) {
        String[] stringArray = new String[]{CAMERA_PERMISSION};
        return PermissionHelper.permissionsGranted(activity, stringArray);
    }

    public static void checkAndRequestAudioPermissions(Activity activity) {
        Log.d((String)TAG, (String)"checkAndRequestAudioPermissions");
        String[] stringArray = new String[]{AUDIO_PERMISSION};
        PermissionHelper.checkAndRequestPermissions(activity, stringArray);
    }

    public static void checkAndRequestCameraPermissions(Activity activity) {
        Log.d((String)TAG, (String)"checkAndRequestCameraPermissions");
        String[] stringArray = new String[]{CAMERA_PERMISSION};
        PermissionHelper.checkAndRequestPermissions(activity, stringArray);
    }

    public static void checkAndRequestPermissions(Activity activity, String[] stringArray) {
        boolean bl2 = PermissionHelper.permissionsGranted(activity, stringArray);
        if (!bl2) {
            bl2 = false;
            ActivityCompat.requestPermissions(activity, stringArray, 0);
        }
    }

    public static void onRequestPermissionsResult(int n10, String[] stringArray, int[] nArray) {
        int n11;
        String string2 = TAG;
        String string3 = "onRequestPermissionsResult";
        Log.d((String)string2, (String)string3);
        int n12 = stringArray.length;
        if (n12 > 0 && (n12 = nArray.length) != (n11 = stringArray.length)) {
            Log.d((String)string2, (String)"Permission denied.");
            return;
        }
        string3 = null;
        for (n12 = 0; n12 < (n11 = nArray.length); ++n12) {
            n11 = nArray[n12];
            if (n11 != 0) continue;
            CharSequence charSequence = new StringBuilder();
            String string4 = stringArray[n12];
            charSequence.append(string4);
            string4 = " permission granted.";
            charSequence.append(string4);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
        }
    }

    public static boolean permissionsGranted(Activity activity, String[] stringArray) {
        for (String string2 : stringArray) {
            int n10 = ContextCompat.checkSelfPermission((Context)activity, string2);
            if (n10 == 0) continue;
            return false;
        }
        return true;
    }
}

