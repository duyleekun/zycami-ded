/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityRecord
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.core.view.accessibility.AccessibilityRecordCompat;

public final class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
    public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32;
    public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
    public static final int CONTENT_CHANGE_TYPE_STATE_DESCRIPTION = 64;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = 255;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 0x1000000;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 0x200000;
    public static final int TYPE_TOUCH_INTERACTION_START = 0x100000;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 0x800000;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 0x400000;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    private AccessibilityEventCompat() {
    }

    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        accessibilityRecordCompat = (AccessibilityRecord)accessibilityRecordCompat.getImpl();
        accessibilityEvent.appendRecord((AccessibilityRecord)accessibilityRecordCompat);
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        AccessibilityRecordCompat accessibilityRecordCompat = new AccessibilityRecordCompat(accessibilityEvent);
        return accessibilityRecordCompat;
    }

    public static int getAction(AccessibilityEvent accessibilityEvent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return accessibilityEvent.getAction();
        }
        return 0;
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }

    public static int getMovementGranularity(AccessibilityEvent accessibilityEvent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return accessibilityEvent.getMovementGranularity();
        }
        return 0;
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int n10) {
        accessibilityEvent = accessibilityEvent.getRecord(n10);
        AccessibilityRecordCompat accessibilityRecordCompat = new AccessibilityRecordCompat(accessibilityEvent);
        return accessibilityRecordCompat;
    }

    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        return accessibilityEvent.getRecordCount();
    }

    public static void setAction(AccessibilityEvent accessibilityEvent, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            accessibilityEvent.setAction(n10);
        }
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            accessibilityEvent.setContentChangeTypes(n10);
        }
    }

    public static void setMovementGranularity(AccessibilityEvent accessibilityEvent, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            accessibilityEvent.setMovementGranularity(n10);
        }
    }
}

