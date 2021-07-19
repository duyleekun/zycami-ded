/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActionBar
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.os.Build$VERSION
 *  android.view.KeyEvent
 *  android.view.KeyEvent$Callback
 *  android.view.KeyEvent$DispatcherState
 *  android.view.View
 *  android.view.Window$Callback
 */
package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched = false;
    private static Method sActionBarOnMenuKeyMethod;
    private static boolean sDialogFieldsFetched = false;
    private static Field sDialogKeyListenerField;

    private KeyEventDispatcher() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean actionBarOnMenuKeyEventPre28(ActionBar object, KeyEvent keyEvent) {
        GenericDeclaration genericDeclaration;
        boolean bl2 = sActionBarFieldsFetched;
        int n10 = 1;
        if (!bl2) {
            try {
                Class<KeyEvent> clazz;
                genericDeclaration = object.getClass();
                String string2 = "onMenuKeyEvent";
                Class[] classArray = new Class[n10];
                classArray[0] = clazz = KeyEvent.class;
                genericDeclaration = ((Class)genericDeclaration).getMethod(string2, classArray);
                sActionBarOnMenuKeyMethod = genericDeclaration;
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            sActionBarFieldsFetched = n10;
        }
        if ((genericDeclaration = sActionBarOnMenuKeyMethod) != null) {
            try {
                Object[] objectArray = new Object[n10];
                objectArray[0] = keyEvent;
                object = ((Method)genericDeclaration).invoke(object, objectArray);
                object = (Boolean)object;
                return (Boolean)object;
            }
            catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {}
        }
        return false;
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Object object = activity.getWindow();
        boolean bl2 = object.hasFeature(8);
        boolean bl3 = true;
        if (bl2) {
            int n10;
            ActionBar actionBar = activity.getActionBar();
            int n11 = keyEvent.getKeyCode();
            if (n11 == (n10 = 82) && actionBar != null && (bl2 = KeyEventDispatcher.actionBarOnMenuKeyEventPre28(actionBar, keyEvent))) {
                return bl3;
            }
        }
        if (bl2 = object.superDispatchKeyEvent(keyEvent)) {
            return bl3;
        }
        bl2 = ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)(object = object.getDecorView()), keyEvent);
        if (bl2) {
            return bl3;
        }
        object = object != null ? object.getKeyDispatcherState() : null;
        return keyEvent.dispatch((KeyEvent.Callback)activity, (KeyEvent.DispatcherState)object, (Object)activity);
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog dialog, KeyEvent keyEvent) {
        int n10;
        boolean bl2;
        DialogInterface.OnKeyListener onKeyListener = KeyEventDispatcher.getDialogKeyListenerPre28(dialog);
        boolean bl3 = true;
        if (onKeyListener != null && (bl2 = onKeyListener.onKey((DialogInterface)dialog, n10 = keyEvent.getKeyCode(), keyEvent))) {
            return bl3;
        }
        onKeyListener = dialog.getWindow();
        n10 = (int)(onKeyListener.superDispatchKeyEvent(keyEvent) ? 1 : 0);
        if (n10 != 0) {
            return bl3;
        }
        n10 = (int)(ViewCompat.dispatchUnhandledKeyEventBeforeCallback((View)(onKeyListener = onKeyListener.getDecorView()), keyEvent) ? 1 : 0);
        if (n10 != 0) {
            return bl3;
        }
        if (onKeyListener != null) {
            onKeyListener = onKeyListener.getKeyDispatcherState();
        } else {
            bl2 = false;
            onKeyListener = null;
        }
        return keyEvent.dispatch((KeyEvent.Callback)dialog, (KeyEvent.DispatcherState)onKeyListener, (Object)dialog);
    }

    public static boolean dispatchBeforeHierarchy(View view, KeyEvent keyEvent) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(view, keyEvent);
    }

    public static boolean dispatchKeyEvent(KeyEventDispatcher$Component keyEventDispatcher$Component, View view, Window.Callback callback, KeyEvent keyEvent) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = false;
        if (keyEventDispatcher$Component == null) {
            return false;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent);
        }
        n10 = callback instanceof Activity;
        if (n10 != 0) {
            return KeyEventDispatcher.activitySuperDispatchKeyEventPre28((Activity)callback, keyEvent);
        }
        n10 = callback instanceof Dialog;
        if (n10 != 0) {
            return KeyEventDispatcher.dialogSuperDispatchKeyEventPre28((Dialog)callback, keyEvent);
        }
        if (view != null && (bl3 = ViewCompat.dispatchUnhandledKeyEventBeforeCallback(view, keyEvent)) || (bl2 = keyEventDispatcher$Component.superDispatchKeyEvent(keyEvent))) {
            bl4 = true;
        }
        return bl4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog object) {
        Field field;
        boolean bl2 = sDialogFieldsFetched;
        if (!bl2) {
            bl2 = true;
            Object object2 = Dialog.class;
            String string2 = "mOnKeyListener";
            try {
                sDialogKeyListenerField = object2 = ((Class)object2).getDeclaredField(string2);
                ((Field)object2).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {}
            sDialogFieldsFetched = bl2;
        }
        if ((field = sDialogKeyListenerField) != null) {
            try {
                object = field.get(object);
                return (DialogInterface.OnKeyListener)object;
            }
            catch (IllegalAccessException illegalAccessException) {}
        }
        return null;
    }
}

