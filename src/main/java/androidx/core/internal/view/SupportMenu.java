/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 */
package androidx.core.internal.view;

import android.view.Menu;

public interface SupportMenu
extends Menu {
    public static final int CATEGORY_MASK = 0xFF0000;
    public static final int CATEGORY_SHIFT = 16;
    public static final int FLAG_KEEP_OPEN_ON_SUBMENU_OPENED = 4;
    public static final int SUPPORTED_MODIFIERS_MASK = 69647;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT;

    public void setGroupDividerEnabled(boolean var1);
}

