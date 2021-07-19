/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.View
 */
package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat$1;
import androidx.core.view.MenuItemCompat$OnActionExpandListener;

public final class MenuItemCompat {
    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    private MenuItemCompat() {
    }

    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        boolean bl2 = menuItem instanceof SupportMenuItem;
        if (bl2) {
            return ((SupportMenuItem)menuItem).getSupportActionProvider();
        }
        Log.w((String)TAG, (String)"getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    }

    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            return ((SupportMenuItem)menuItem).getAlphabeticModifiers();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return menuItem.getAlphabeticModifiers();
        }
        return 0;
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            return ((SupportMenuItem)menuItem).getContentDescription();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return menuItem.getContentDescription();
        }
        return null;
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            return ((SupportMenuItem)menuItem).getIconTintList();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return menuItem.getIconTintList();
        }
        return null;
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            return ((SupportMenuItem)menuItem).getIconTintMode();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return menuItem.getIconTintMode();
        }
        return null;
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            return ((SupportMenuItem)menuItem).getNumericModifiers();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return menuItem.getNumericModifiers();
        }
        return 0;
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            return ((SupportMenuItem)menuItem).getTooltipText();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return menuItem.getTooltipText();
        }
        return null;
    }

    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        boolean bl2 = menuItem instanceof SupportMenuItem;
        if (bl2) {
            return ((SupportMenuItem)menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w((String)TAG, (String)"setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem setActionView(MenuItem menuItem, int n10) {
        return menuItem.setActionView(n10);
    }

    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c10, int n10) {
        int n11 = menuItem instanceof SupportMenuItem;
        if (n11 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setAlphabeticShortcut(c10, n10);
        } else {
            n11 = Build.VERSION.SDK_INT;
            int n12 = 26;
            if (n11 >= n12) {
                menuItem.setAlphabeticShortcut(c10, n10);
            }
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setContentDescription(charSequence);
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                menuItem.setContentDescription(charSequence);
            }
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setIconTintList(colorStateList);
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setIconTintMode(mode);
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                menuItem.setIconTintMode(mode);
            }
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c10, int n10) {
        int n11 = menuItem instanceof SupportMenuItem;
        if (n11 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setNumericShortcut(c10, n10);
        } else {
            n11 = Build.VERSION.SDK_INT;
            int n12 = 26;
            if (n11 >= n12) {
                menuItem.setNumericShortcut(c10, n10);
            }
        }
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuItem, MenuItemCompat$OnActionExpandListener menuItemCompat$OnActionExpandListener) {
        MenuItemCompat$1 menuItemCompat$1 = new MenuItemCompat$1(menuItemCompat$OnActionExpandListener);
        return menuItem.setOnActionExpandListener((MenuItem.OnActionExpandListener)menuItemCompat$1);
    }

    public static void setShortcut(MenuItem menuItem, char c10, char c11, int n10, int n11) {
        int n12 = menuItem instanceof SupportMenuItem;
        if (n12 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setShortcut(c10, c11, n10, n11);
        } else {
            n12 = Build.VERSION.SDK_INT;
            int n13 = 26;
            if (n12 >= n13) {
                menuItem.setShortcut(c10, c11, n10, n11);
            }
        }
    }

    public static void setShowAsAction(MenuItem menuItem, int n10) {
        menuItem.setShowAsAction(n10);
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        int n10 = menuItem instanceof SupportMenuItem;
        if (n10 != 0) {
            menuItem = (SupportMenuItem)menuItem;
            menuItem.setTooltipText(charSequence);
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 26;
            if (n10 >= n11) {
                menuItem.setTooltipText(charSequence);
            }
        }
    }
}

