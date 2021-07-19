/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.transition.Transition
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MenuItem
 *  android.widget.PopupWindow
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow$MenuDropDownListView;
import java.lang.reflect.Method;

public class MenuPopupWindow
extends ListPopupWindow
implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    static {
        block7: {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 28;
            if (n10 > n11) break block7;
            Object object = PopupWindow.class;
            String string2 = "setTouchModal";
            int n12 = 1;
            Class[] classArray = new Class[n12];
            Class<Boolean> clazz = Boolean.TYPE;
            classArray[0] = clazz;
            object = ((Class)object).getDeclaredMethod(string2, classArray);
            try {
                sSetTouchModalMethod = object;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = TAG;
                string2 = "Could not find method setTouchModal() on PopupWindow. Oh well.";
                Log.i((String)object, (String)string2);
            }
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
    }

    public DropDownListView createDropDownListView(Context context, boolean bl2) {
        MenuPopupWindow$MenuDropDownListView menuPopupWindow$MenuDropDownListView = new MenuPopupWindow$MenuDropDownListView(context, bl2);
        menuPopupWindow$MenuDropDownListView.setHoverListener(this);
        return menuPopupWindow$MenuDropDownListView;
    }

    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.mHoverListener;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.onItemHoverExit(menuBuilder, menuItem);
        }
    }

    public void setEnterTransition(Object object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            PopupWindow popupWindow = this.mPopup;
            object = (Transition)object;
            popupWindow.setEnterTransition((Transition)object);
        }
    }

    public void setExitTransition(Object object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            PopupWindow popupWindow = this.mPopup;
            object = (Transition)object;
            popupWindow.setExitTransition((Transition)object);
        }
    }

    public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
        this.mHoverListener = menuItemHoverListener;
    }

    public void setTouchModal(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 <= n11) {
            Object object = sSetTouchModalMethod;
            if (object != null) {
                PopupWindow popupWindow = this.mPopup;
                int n12 = 1;
                Object[] objectArray = new Object[n12];
                Object object2 = bl2;
                objectArray[0] = object2;
                try {
                    ((Method)object).invoke(popupWindow, objectArray);
                }
                catch (Exception exception) {
                    object2 = TAG;
                    object = "Could not invoke setTouchModal() on PopupWindow. Oh well.";
                    Log.i((String)object2, (String)object);
                }
            }
        } else {
            PopupWindow popupWindow = this.mPopup;
            popupWindow.setTouchModal(bl2);
        }
    }
}

