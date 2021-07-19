/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accessibilityservice.AccessibilityServiceInfo
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 */
package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = 255;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    private AccessibilityServiceInfoCompat() {
    }

    public static String capabilityToString(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 8;
                    if (n10 != n11) {
                        return "UNKNOWN";
                    }
                    return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
                }
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            }
            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    }

    public static String feedbackTypeToString(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "[";
        stringBuilder.append(string2);
        while (n10 > 0) {
            int n11 = Integer.numberOfTrailingZeros(n10);
            int n12 = 1;
            n11 = n12 << n11;
            int n13 = ~n11;
            n10 &= n13;
            n13 = stringBuilder.length();
            if (n13 > n12) {
                String string3 = ", ";
                stringBuilder.append(string3);
            }
            if (n11 != n12) {
                n12 = 2;
                if (n11 != n12) {
                    n12 = 4;
                    if (n11 != n12) {
                        n12 = 8;
                        if (n11 != n12) {
                            n12 = 16;
                            if (n11 != n12) continue;
                            string2 = "FEEDBACK_GENERIC";
                            stringBuilder.append(string2);
                            continue;
                        }
                        string2 = "FEEDBACK_VISUAL";
                        stringBuilder.append(string2);
                        continue;
                    }
                    string2 = "FEEDBACK_AUDIBLE";
                    stringBuilder.append(string2);
                    continue;
                }
                string2 = "FEEDBACK_HAPTIC";
                stringBuilder.append(string2);
                continue;
            }
            string2 = "FEEDBACK_SPOKEN";
            stringBuilder.append(string2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String flagToString(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 8;
                    if (n10 != n11) {
                        n11 = 16;
                        if (n10 != n11) {
                            n11 = 32;
                            if (n10 != n11) {
                                return null;
                            }
                            return "FLAG_REQUEST_FILTER_KEY_EVENTS";
                        }
                        return "FLAG_REPORT_VIEW_IDS";
                    }
                    return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
                }
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            }
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        return "DEFAULT";
    }

    public static int getCapabilities(AccessibilityServiceInfo accessibilityServiceInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return accessibilityServiceInfo.getCapabilities();
        }
        boolean bl2 = accessibilityServiceInfo.getCanRetrieveWindowContent();
        if (bl2) {
            return 1;
        }
        return 0;
    }

    public static String loadDescription(AccessibilityServiceInfo accessibilityServiceInfo, PackageManager packageManager) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return accessibilityServiceInfo.loadDescription(packageManager);
        }
        return accessibilityServiceInfo.getDescription();
    }
}

