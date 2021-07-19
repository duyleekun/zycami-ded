/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

public final class ConnectionErrorMessages {
    private static final SimpleArrayMap zaog;

    static {
        SimpleArrayMap simpleArrayMap;
        zaog = simpleArrayMap = new SimpleArrayMap();
    }

    private ConnectionErrorMessages() {
    }

    public static String getAppName(Context object) {
        String string2 = object.getPackageName();
        Object object2 = Wrappers.packageManager(object);
        object2 = ((PackageManagerWrapper)object2).getApplicationLabel(string2);
        try {
            return object2.toString();
        }
        catch (PackageManager.NameNotFoundException | NullPointerException throwable) {
            object = object.getApplicationInfo().name;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                return string2;
            }
            return object;
        }
    }

    public static String getDefaultNotificationChannelName(Context context) {
        context = context.getResources();
        int n10 = com.google.android.gms.base.R$string.common_google_play_services_notification_channel_name;
        return context.getString(n10);
    }

    public static String getErrorDialogButtonMessage(Context context, int n10) {
        context = context.getResources();
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return context.getString(17039370);
                }
                n10 = com.google.android.gms.base.R$string.common_google_play_services_enable_button;
                return context.getString(n10);
            }
            n10 = com.google.android.gms.base.R$string.common_google_play_services_update_button;
            return context.getString(n10);
        }
        n10 = com.google.android.gms.base.R$string.common_google_play_services_install_button;
        return context.getString(n10);
    }

    public static String getErrorMessage(Context context, int n10) {
        Resources resources = context.getResources();
        String string2 = ConnectionErrorMessages.getAppName(context);
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n12 = 5;
                    if (n10 != n12) {
                        n12 = 7;
                        if (n10 != n12) {
                            n12 = 9;
                            if (n10 != n12) {
                                n12 = 20;
                                if (n10 != n12) {
                                    switch (n10) {
                                        default: {
                                            int n13 = R$string.common_google_play_services_unknown_issue;
                                            Object[] objectArray = new Object[n11];
                                            objectArray[0] = string2;
                                            return resources.getString(n13, objectArray);
                                        }
                                        case 18: {
                                            int n14 = com.google.android.gms.base.R$string.common_google_play_services_updating_text;
                                            Object[] objectArray = new Object[n11];
                                            objectArray[0] = string2;
                                            return resources.getString(n14, objectArray);
                                        }
                                        case 17: {
                                            return ConnectionErrorMessages.zaa(context, "common_google_play_services_sign_in_failed_text", string2);
                                        }
                                        case 16: 
                                    }
                                    return ConnectionErrorMessages.zaa(context, "common_google_play_services_api_unavailable_text", string2);
                                }
                                return ConnectionErrorMessages.zaa(context, "common_google_play_services_restricted_profile_text", string2);
                            }
                            int n15 = com.google.android.gms.base.R$string.common_google_play_services_unsupported_text;
                            Object[] objectArray = new Object[n11];
                            objectArray[0] = string2;
                            return resources.getString(n15, objectArray);
                        }
                        return ConnectionErrorMessages.zaa(context, "common_google_play_services_network_error_text", string2);
                    }
                    return ConnectionErrorMessages.zaa(context, "common_google_play_services_invalid_account_text", string2);
                }
                int n16 = com.google.android.gms.base.R$string.common_google_play_services_enable_text;
                Object[] objectArray = new Object[n11];
                objectArray[0] = string2;
                return resources.getString(n16, objectArray);
            }
            int n17 = DeviceProperties.isWearableWithoutPlayStore(context);
            if (n17 != 0) {
                n17 = com.google.android.gms.base.R$string.common_google_play_services_wear_update_text;
                return resources.getString(n17);
            }
            n17 = com.google.android.gms.base.R$string.common_google_play_services_update_text;
            Object[] objectArray = new Object[n11];
            objectArray[0] = string2;
            return resources.getString(n17, objectArray);
        }
        int n18 = com.google.android.gms.base.R$string.common_google_play_services_install_text;
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        return resources.getString(n18, objectArray);
    }

    public static String getErrorNotificationMessage(Context context, int n10) {
        int n11 = 6;
        if (n10 == n11) {
            String string2 = ConnectionErrorMessages.getAppName(context);
            return ConnectionErrorMessages.zaa(context, "common_google_play_services_resolution_required_text", string2);
        }
        return ConnectionErrorMessages.getErrorMessage(context, n10);
    }

    public static String getErrorNotificationTitle(Context context, int n10) {
        int n11 = 6;
        String string2 = n10 == n11 ? ConnectionErrorMessages.zaa(context, "common_google_play_services_resolution_required_title") : ConnectionErrorMessages.getErrorTitle(context, n10);
        if (string2 == null) {
            context = context.getResources();
            n10 = com.google.android.gms.base.R$string.common_google_play_services_notification_ticker;
            string2 = context.getString(n10);
        }
        return string2;
    }

    public static String getErrorTitle(Context object, int n10) {
        Object object2 = object.getResources();
        String string2 = "GoogleApiAvailability";
        switch (n10) {
            default: {
                object2 = new StringBuilder(33);
                ((StringBuilder)object2).append("Unexpected error code ");
                ((StringBuilder)object2).append(n10);
                object = ((StringBuilder)object2).toString();
                Log.e((String)string2, (String)object);
                return null;
            }
            case 20: {
                Log.e((String)string2, (String)"The current user profile is restricted and could not use authenticated features.");
                return ConnectionErrorMessages.zaa(object, "common_google_play_services_restricted_profile_title");
            }
            case 17: {
                Log.e((String)string2, (String)"The specified account could not be signed in.");
                return ConnectionErrorMessages.zaa(object, "common_google_play_services_sign_in_failed_title");
            }
            case 16: {
                Log.e((String)string2, (String)"One of the API components you attempted to connect to is not available.");
                return null;
            }
            case 11: {
                Log.e((String)string2, (String)"The application is not licensed to the user.");
                return null;
            }
            case 10: {
                Log.e((String)string2, (String)"Developer error occurred. Please see logs for detailed information");
                return null;
            }
            case 9: {
                Log.e((String)string2, (String)"Google Play services is invalid. Cannot recover.");
                return null;
            }
            case 8: {
                Log.e((String)string2, (String)"Internal error occurred. Please see logs for detailed information");
                return null;
            }
            case 7: {
                Log.e((String)string2, (String)"Network error occurred. Please retry request later.");
                return ConnectionErrorMessages.zaa(object, "common_google_play_services_network_error_title");
            }
            case 5: {
                Log.e((String)string2, (String)"An invalid account was specified when connecting. Please provide a valid account.");
                return ConnectionErrorMessages.zaa(object, "common_google_play_services_invalid_account_title");
            }
            case 4: 
            case 6: 
            case 18: {
                return null;
            }
            case 3: {
                int n11 = com.google.android.gms.base.R$string.common_google_play_services_enable_title;
                return object2.getString(n11);
            }
            case 2: {
                int n12 = com.google.android.gms.base.R$string.common_google_play_services_update_title;
                return object2.getString(n12);
            }
            case 1: 
        }
        int n13 = com.google.android.gms.base.R$string.common_google_play_services_install_title;
        return object2.getString(n13);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String zaa(Context object, String string2) {
        SimpleArrayMap simpleArrayMap = zaog;
        synchronized (simpleArrayMap) {
            Object object2 = simpleArrayMap.get(string2);
            object2 = (String)object2;
            if (object2 != null) {
                return object2;
            }
            object = GooglePlayServicesUtil.getRemoteResource(object);
            object2 = null;
            if (object == null) {
                return null;
            }
            String string3 = "string";
            String string4 = "com.google.android.gms";
            int n10 = object.getIdentifier(string2, string3, string4);
            if (n10 == 0) {
                object = "GoogleApiAvailability";
                string3 = "Missing resource: ";
                int n11 = (string2 = String.valueOf(string2)).length();
                string2 = n11 != 0 ? string3.concat(string2) : new String(string3);
                Log.w((String)object, (String)string2);
                return null;
            }
            if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = object.getString(n10))) ? 1 : 0)) == 0) {
                simpleArrayMap.put(string2, object);
                return object;
            }
            object = "GoogleApiAvailability";
            string3 = "Got empty resource: ";
            int n12 = (string2 = String.valueOf(string2)).length();
            string2 = n12 != 0 ? string3.concat(string2) : new String(string3);
            Log.w((String)object, (String)string2);
            return null;
        }
    }

    private static String zaa(Context object, String object2, String string2) {
        Object[] objectArray = object.getResources();
        if ((object = ConnectionErrorMessages.zaa(object, (String)object2)) == null) {
            int n10 = R$string.common_google_play_services_unknown_issue;
            object = objectArray.getString(n10);
        }
        object2 = objectArray.getConfiguration().locale;
        objectArray = new Object[]{string2};
        return String.format((Locale)object2, (String)object, objectArray);
    }
}

