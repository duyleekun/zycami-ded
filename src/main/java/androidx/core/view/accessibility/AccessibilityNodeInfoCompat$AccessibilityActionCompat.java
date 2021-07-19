/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$MoveAtGranularityArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$MoveHtmlArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$MoveWindowArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$ScrollToPositionArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$SetProgressArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$SetSelectionArguments;
import androidx.core.view.accessibility.AccessibilityViewCommand$SetTextArguments;
import java.lang.reflect.Constructor;

public class AccessibilityNodeInfoCompat$AccessibilityActionCompat {
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COLLAPSE;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_COPY;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_CUT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_DISMISS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_EXPAND;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_FOCUS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_IME_ENTER;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_LONG_CLICK;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_MOVE_WINDOW;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_DOWN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_LEFT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_RIGHT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PAGE_UP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PASTE;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_DOWN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_LEFT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SCROLL_UP;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SELECT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_PROGRESS;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_SELECTION;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SET_TEXT;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    public static final AccessibilityNodeInfoCompat$AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
    private static final String TAG = "A11yActionCompat";
    public final Object mAction;
    public final AccessibilityViewCommand mCommand;
    private final int mId;
    private final Class mViewCommandArgumentClass;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat;
        Object object = AccessibilityViewCommand.MoveHtmlArguments.class;
        Class<AccessibilityViewCommand.SetTextArguments> clazz = AccessibilityViewCommand.MoveAtGranularityArguments.class;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2 = null;
        ACTION_FOCUS = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(1, null);
        ACTION_CLEAR_FOCUS = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(2, null);
        ACTION_SELECT = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4, null);
        ACTION_CLEAR_SELECTION = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8, null);
        ACTION_CLICK = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16, null);
        ACTION_LONG_CLICK = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32, null);
        ACTION_ACCESSIBILITY_FOCUS = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(64, null);
        ACTION_CLEAR_ACCESSIBILITY_FOCUS = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(128, null);
        ACTION_NEXT_AT_MOVEMENT_GRANULARITY = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(256, null, clazz);
        int n10 = 512;
        ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(n10, null, clazz);
        clazz = new Class<AccessibilityViewCommand.SetTextArguments>(1024, null, object);
        ACTION_NEXT_HTML_ELEMENT = clazz;
        clazz = new Class<AccessibilityViewCommand.SetTextArguments>(2048, null, object);
        ACTION_PREVIOUS_HTML_ELEMENT = clazz;
        ACTION_SCROLL_FORWARD = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(4096, null);
        ACTION_SCROLL_BACKWARD = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(8192, null);
        ACTION_COPY = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(16384, null);
        ACTION_PASTE = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(32768, null);
        ACTION_CUT = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(65536, null);
        ACTION_SET_SELECTION = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
        ACTION_EXPAND = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(262144, null);
        ACTION_COLLAPSE = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(524288, null);
        ACTION_DISMISS = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(0x100000, null);
        clazz = AccessibilityViewCommand.SetTextArguments.class;
        ACTION_SET_TEXT = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(0x200000, null, clazz);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        Object object2 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN) : null;
        int n13 = 16908342;
        Class<AccessibilityViewCommand.MoveWindowArguments> clazz2 = null;
        Object object3 = object;
        ACTION_SHOW_ON_SCREEN = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        Object object4 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION) : null;
        int n14 = 16908343;
        Class clazz3 = AccessibilityViewCommand.ScrollToPositionArguments.class;
        ACTION_SCROLL_TO_POSITION = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, clazz3);
        object2 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP) : null;
        n13 = 16908344;
        clazz2 = null;
        object3 = object;
        ACTION_SCROLL_UP = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        object4 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT) : null;
        n14 = 16908345;
        clazz3 = null;
        ACTION_SCROLL_LEFT = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, null);
        object2 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN) : null;
        n13 = 16908346;
        clazz2 = null;
        object3 = object;
        ACTION_SCROLL_DOWN = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        object4 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT) : null;
        n14 = 16908347;
        clazz3 = null;
        ACTION_SCROLL_RIGHT = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, null);
        n10 = 29;
        if (n11 >= n10) {
            object3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            object2 = object3;
        } else {
            object2 = null;
        }
        n13 = 16908358;
        clazz2 = null;
        object3 = object;
        ACTION_PAGE_UP = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        if (n11 >= n10) {
            object3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            object4 = object3;
        } else {
            object4 = null;
        }
        n14 = 16908359;
        clazz3 = null;
        ACTION_PAGE_DOWN = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, null);
        if (n11 >= n10) {
            object3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            object2 = object3;
        } else {
            object2 = null;
        }
        n13 = 16908360;
        clazz2 = null;
        object3 = object;
        ACTION_PAGE_LEFT = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        object4 = n11 >= n10 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT) : null;
        n14 = 16908361;
        clazz3 = null;
        ACTION_PAGE_RIGHT = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, null);
        if (n11 >= n12) {
            accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
            object2 = accessibilityNodeInfoCompat$AccessibilityActionCompat;
        } else {
            object2 = null;
        }
        n13 = 16908348;
        clazz2 = null;
        object3 = object;
        ACTION_CONTEXT_CLICK = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        n12 = 24;
        if (n11 >= n12) {
            accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            object4 = accessibilityNodeInfoCompat$AccessibilityActionCompat;
        } else {
            object4 = null;
        }
        n14 = 16908349;
        clazz3 = AccessibilityViewCommand$SetProgressArguments.class;
        ACTION_SET_PROGRESS = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, clazz3);
        n12 = 26;
        if (n11 >= n12) {
            accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            object2 = accessibilityNodeInfoCompat$AccessibilityActionCompat;
        } else {
            object2 = null;
        }
        n13 = 16908354;
        clazz2 = AccessibilityViewCommand.MoveWindowArguments.class;
        object3 = object;
        ACTION_MOVE_WINDOW = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, clazz2);
        n12 = 28;
        object4 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP) : null;
        n14 = 16908356;
        clazz3 = null;
        ACTION_SHOW_TOOLTIP = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, null);
        if (n11 >= n12) {
            accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            object2 = accessibilityNodeInfoCompat$AccessibilityActionCompat;
        } else {
            object2 = null;
        }
        n13 = 16908357;
        clazz2 = null;
        object3 = object;
        ACTION_HIDE_TOOLTIP = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object2, n13, null, null, null);
        n12 = 30;
        object4 = n11 >= n12 ? (accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD) : null;
        n14 = 16908362;
        clazz3 = null;
        ACTION_PRESS_AND_HOLD = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(object4, n14, null, null, null);
        if (n11 >= n12) {
            accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        }
        object2 = accessibilityAction2;
        object3 = object;
        ACTION_IME_ENTER = object = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(accessibilityAction2, 16908372, null, null, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int n10, CharSequence charSequence) {
        this(null, n10, charSequence, null, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int n10, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        this(null, n10, charSequence, accessibilityViewCommand, null);
    }

    private AccessibilityNodeInfoCompat$AccessibilityActionCompat(int n10, CharSequence charSequence, Class clazz) {
        this(null, n10, charSequence, null, clazz);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object object) {
        this(object, 0, null, null, null);
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object object, int n10, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class clazz) {
        this.mId = n10;
        this.mCommand = accessibilityViewCommand;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        this.mAction = n11 >= n12 && object == null ? (object = new AccessibilityNodeInfo.AccessibilityAction(n10, charSequence)) : object;
        this.mViewCommandArgumentClass = clazz;
    }

    public AccessibilityNodeInfoCompat$AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
        int n10 = this.mId;
        Class clazz = this.mViewCommandArgumentClass;
        AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(null, n10, charSequence, accessibilityViewCommand, clazz);
        return accessibilityNodeInfoCompat$AccessibilityActionCompat;
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (object == null) {
            return false;
        }
        boolean bl3 = object instanceof AccessibilityNodeInfoCompat$AccessibilityActionCompat;
        if (!bl3) {
            return false;
        }
        object = (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object;
        Object object2 = this.mAction;
        return !(object2 == null ? (object = ((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object).mAction) != null : !(bl2 = object2.equals(object = ((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object).mAction)));
    }

    public int getId() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getId();
        }
        return 0;
    }

    public CharSequence getLabel() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getLabel();
        }
        return null;
    }

    public int hashCode() {
        int n10;
        Object object = this.mAction;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean perform(View view, Bundle bundle) {
        void var2_5;
        Object object4;
        Object object3;
        Object object2;
        Object object;
        block4: {
            object = this.mCommand;
            object2 = null;
            if (object == null) return false;
            object = null;
            object3 = this.mViewCommandArgumentClass;
            if (object3 == null) return this.mCommand.perform(view, (AccessibilityViewCommand$CommandArguments)object);
            try {
                object4 = new Class[]{};
                object3 = ((Class)object3).getDeclaredConstructor((Class<?>)object4);
                object2 = new Object[]{};
                object2 = ((Constructor)object3).newInstance((Object[])object2);
                object2 = (AccessibilityViewCommand$CommandArguments)object2;
            }
            catch (Exception exception) {
                // empty catch block
                break block4;
            }
            try {
                ((AccessibilityViewCommand$CommandArguments)object2).setBundle(bundle);
                object = object2;
                return this.mCommand.perform(view, (AccessibilityViewCommand$CommandArguments)object);
            }
            catch (Exception exception) {
                object = object2;
            }
        }
        object2 = this.mViewCommandArgumentClass;
        object2 = object2 == null ? "null" : ((Class)object2).getName();
        object3 = new StringBuilder();
        object4 = "Failed to execute command with argument class ViewCommandArgument: ";
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        object3 = TAG;
        Log.e((String)object3, (String)object2, (Throwable)var2_5);
        return this.mCommand.perform(view, (AccessibilityViewCommand$CommandArguments)object);
    }
}

