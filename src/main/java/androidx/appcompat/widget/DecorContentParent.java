/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.util.SparseArray
 *  android.view.Menu
 *  android.view.Window$Callback
 */
package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

public interface DecorContentParent {
    public boolean canShowOverflowMenu();

    public void dismissPopups();

    public CharSequence getTitle();

    public boolean hasIcon();

    public boolean hasLogo();

    public boolean hideOverflowMenu();

    public void initFeature(int var1);

    public boolean isOverflowMenuShowPending();

    public boolean isOverflowMenuShowing();

    public void restoreToolbarHierarchyState(SparseArray var1);

    public void saveToolbarHierarchyState(SparseArray var1);

    public void setIcon(int var1);

    public void setIcon(Drawable var1);

    public void setLogo(int var1);

    public void setMenu(Menu var1, MenuPresenter$Callback var2);

    public void setMenuPrepared();

    public void setUiOptions(int var1);

    public void setWindowCallback(Window.Callback var1);

    public void setWindowTitle(CharSequence var1);

    public boolean showOverflowMenu();
}

