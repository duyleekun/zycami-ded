/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyCharacterMap$KeyData
 *  android.view.KeyEvent
 *  android.view.MenuItem
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewConfiguration
 */
package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewConfigurationCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuBuilder
implements SupportMenu {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder;
    private ArrayList mActionItems;
    private MenuBuilder$Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction = 0;
    private MenuItemImpl mExpandedItem;
    private boolean mGroupDividerEnabled;
    public Drawable mHeaderIcon;
    public CharSequence mHeaderTitle;
    public View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing = false;
    private boolean mIsVisibleItemsStale;
    private ArrayList mItems;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private ArrayList mNonActionItems;
    private boolean mOptionalIconsVisible = false;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList mPresenters;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private ArrayList mTempShortcutItemList;
    private ArrayList mVisibleItems;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[6];
        int[] nArray3 = nArray;
        nArray2[0] = 1;
        nArray3[1] = 4;
        nArray2[2] = 5;
        nArray3[3] = 3;
        nArray2[4] = 2;
        nArray3[5] = 0;
        sCategoryToOrder = nArray;
    }

    public MenuBuilder(Context object) {
        ArrayList arrayList;
        boolean bl2;
        List list;
        this.mTempShortcutItemList = list = new List();
        this.mPresenters = list;
        this.mGroupDividerEnabled = false;
        this.mContext = object;
        object = object.getResources();
        this.mResources = object;
        super();
        this.mItems = object;
        super();
        this.mVisibleItems = object;
        this.mIsVisibleItemsStale = bl2 = true;
        this.mActionItems = arrayList = new ArrayList();
        this.mNonActionItems = arrayList = new ArrayList();
        this.mIsActionItemsStale = bl2;
        this.setShortcutsVisibleInner(bl2);
    }

    private MenuItemImpl createNewMenuItem(int n10, int n11, int n12, int n13, CharSequence charSequence, int n14) {
        MenuItemImpl menuItemImpl = new MenuItemImpl(this, n10, n11, n12, n13, charSequence, n14);
        return menuItemImpl;
    }

    private void dispatchPresenterUpdate(boolean bl2) {
        boolean bl3;
        Object object = this.mPresenters;
        boolean bl4 = ((CopyOnWriteArrayList)object).isEmpty();
        if (bl4) {
            return;
        }
        this.stopDispatchingItemsChanged();
        object = this.mPresenters.iterator();
        while (bl3 = object.hasNext()) {
            WeakReference weakReference = (WeakReference)object.next();
            Object object2 = (MenuPresenter)weakReference.get();
            if (object2 == null) {
                object2 = this.mPresenters;
                ((CopyOnWriteArrayList)object2).remove(weakReference);
                continue;
            }
            object2.updateMenuView(bl2);
        }
        this.startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        boolean bl2;
        Object object = PRESENTER_KEY;
        if ((bundle = bundle.getSparseParcelableArray((String)object)) != null && !(bl2 = ((CopyOnWriteArrayList)(object = this.mPresenters)).isEmpty())) {
            int n10;
            object = this.mPresenters.iterator();
            while ((n10 = object.hasNext()) != 0) {
                WeakReference weakReference = (WeakReference)object.next();
                Object object2 = (MenuPresenter)weakReference.get();
                if (object2 == null) {
                    object2 = this.mPresenters;
                    ((CopyOnWriteArrayList)object2).remove(weakReference);
                    continue;
                }
                n10 = object2.getId();
                if (n10 <= 0 || (weakReference = (Parcelable)bundle.get(n10)) == null) continue;
                object2.onRestoreInstanceState((Parcelable)weakReference);
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        int n10;
        CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
        boolean bl2 = copyOnWriteArrayList.isEmpty();
        if (bl2) {
            return;
        }
        copyOnWriteArrayList = new SparseArray();
        Iterator iterator2 = this.mPresenters.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            WeakReference weakReference = (WeakReference)iterator2.next();
            Object object = (MenuPresenter)weakReference.get();
            if (object == null) {
                object = this.mPresenters;
                ((CopyOnWriteArrayList)object).remove(weakReference);
                continue;
            }
            n10 = object.getId();
            if (n10 <= 0 || (object = object.onSaveInstanceState()) == null) continue;
            copyOnWriteArrayList.put(n10, object);
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, (SparseArray)copyOnWriteArrayList);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuBuilder, MenuPresenter object) {
        Object object2 = this.mPresenters;
        boolean bl2 = ((CopyOnWriteArrayList)object2).isEmpty();
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        if (object != null) {
            bl3 = object.onSubMenuSelected(subMenuBuilder);
        }
        object = this.mPresenters.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (WeakReference)object.next();
            Object object3 = (MenuPresenter)((Reference)object2).get();
            if (object3 == null) {
                object3 = this.mPresenters;
                ((CopyOnWriteArrayList)object3).remove(object2);
                continue;
            }
            if (bl3) continue;
            bl3 = bl2 = object3.onSubMenuSelected(subMenuBuilder);
        }
        return bl3;
    }

    private static int findInsertIndex(ArrayList arrayList, int n10) {
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)arrayList.get(i10);
            int n11 = menuItemImpl.getOrdering();
            if (n11 > n10) continue;
            return i10 + 1;
        }
        return 0;
    }

    private static int getOrdering(int n10) {
        int[] nArray;
        int n11;
        int n12 = (0xFFFF0000 & n10) >> 16;
        if (n12 >= 0 && n12 < (n11 = (nArray = sCategoryToOrder).length)) {
            n12 = nArray[n12] << 16;
            return n10 & (char)-1 | n12;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("order does not contain a valid category.");
        throw illegalArgumentException;
    }

    private void removeItemAtInt(int n10, boolean bl2) {
        ArrayList arrayList;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (arrayList = this.mItems).size())) {
            arrayList = this.mItems;
            arrayList.remove(n10);
            if (bl2) {
                n10 = 1;
                this.onItemsChanged(n10 != 0);
            }
        }
    }

    private void setHeaderInternal(int n10, CharSequence charSequence, int n11, Drawable drawable2, View view) {
        Resources resources = this.getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            CharSequence charSequence2;
            if (n10 > 0) {
                this.mHeaderTitle = charSequence2 = resources.getText(n10);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (n11 > 0) {
                charSequence2 = ContextCompat.getDrawable(this.getContext(), n11);
                this.mHeaderIcon = charSequence2;
            } else if (drawable2 != null) {
                this.mHeaderIcon = drawable2;
            }
            this.mHeaderView = null;
        }
        this.onItemsChanged(false);
    }

    private void setShortcutsVisibleInner(boolean bl2) {
        int n10;
        block3: {
            block2: {
                Context context;
                boolean bl3;
                n10 = 1;
                if (!bl2) break block2;
                Configuration configuration = this.mResources.getConfiguration();
                int n11 = configuration.keyboard;
                if (n11 != n10 && (bl3 = ViewConfigurationCompat.shouldShowMenuShortcutsWhenKeyboardPresent((ViewConfiguration)(configuration = ViewConfiguration.get((Context)this.mContext)), context = this.mContext))) break block3;
            }
            n10 = 0;
        }
        this.mShortcutsVisible = n10;
    }

    public MenuItem add(int n10) {
        String string2 = this.mResources.getString(n10);
        return this.addInternal(0, 0, 0, string2);
    }

    public MenuItem add(int n10, int n11, int n12, int n13) {
        String string2 = this.mResources.getString(n13);
        return this.addInternal(n10, n11, n12, string2);
    }

    public MenuItem add(int n10, int n11, int n12, CharSequence charSequence) {
        return this.addInternal(n10, n11, n12, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return this.addInternal(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int n10, int n11, int n12, ComponentName object, Intent[] intentArray, Intent intent, int n13, MenuItem[] menuItemArray) {
        PackageManager packageManager = this.mContext.getPackageManager();
        int n14 = 0;
        int n15 = (object = packageManager.queryIntentActivityOptions((ComponentName)object, intentArray, intent, 0)) != null ? object.size() : 0;
        if ((n13 &= 1) == 0) {
            this.removeGroup(n10);
        }
        while (n14 < n15) {
            ResolveInfo resolveInfo = (ResolveInfo)object.get(n14);
            int n16 = resolveInfo.specificIndex;
            Object object2 = n16 < 0 ? intent : intentArray[n16];
            Intent intent2 = new Intent(object2);
            Object object3 = resolveInfo.activityInfo;
            String string2 = object3.applicationInfo.packageName;
            object3 = object3.name;
            object2 = new ComponentName(string2, (String)object3);
            intent2.setComponent((ComponentName)object2);
            object2 = resolveInfo.loadLabel(packageManager);
            object2 = this.add(n10, n11, n12, (CharSequence)object2);
            object3 = resolveInfo.loadIcon(packageManager);
            object2 = object2.setIcon((Drawable)object3);
            intent2 = object2.setIntent(intent2);
            if (menuItemArray != null && (n13 = resolveInfo.specificIndex) >= 0) {
                menuItemArray[n13] = intent2;
            }
            ++n14;
        }
        return n15;
    }

    public MenuItem addInternal(int n10, int n11, int n12, CharSequence charSequence) {
        int n13 = MenuBuilder.getOrdering(n12);
        int n14 = this.mDefaultShowAsAction;
        MenuItemImpl menuItemImpl = this.createNewMenuItem(n10, n11, n12, n13, charSequence, n14);
        Object object = this.mCurrentMenuInfo;
        if (object != null) {
            menuItemImpl.setMenuInfo((ContextMenu.ContextMenuInfo)object);
        }
        object = this.mItems;
        n12 = MenuBuilder.findInsertIndex((ArrayList)object, n13);
        ((ArrayList)object).add(n12, menuItemImpl);
        this.onItemsChanged(true);
        return menuItemImpl;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        Context context = this.mContext;
        this.addMenuPresenter(menuPresenter, context);
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.mPresenters;
        WeakReference<MenuPresenter> weakReference = new WeakReference<MenuPresenter>(menuPresenter);
        copyOnWriteArrayList.add(weakReference);
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int n10) {
        String string2 = this.mResources.getString(n10);
        return this.addSubMenu(0, 0, 0, string2);
    }

    public SubMenu addSubMenu(int n10, int n11, int n12, int n13) {
        String string2 = this.mResources.getString(n13);
        return this.addSubMenu(n10, n11, n12, string2);
    }

    public SubMenu addSubMenu(int n10, int n11, int n12, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl)this.addInternal(n10, n11, n12, charSequence);
        Context context = this.mContext;
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(context, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return this.addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        MenuBuilder$Callback menuBuilder$Callback = this.mCallback;
        if (menuBuilder$Callback != null) {
            menuBuilder$Callback.onMenuModeChange(this);
        }
    }

    public void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            this.collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        this.onItemsChanged(true);
    }

    public void clearAll() {
        boolean bl2;
        this.mPreventDispatchingItemsChanged = bl2 = true;
        this.clear();
        this.clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        this.onItemsChanged(bl2);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        this.onItemsChanged(false);
    }

    public void close() {
        this.close(true);
    }

    public final void close(boolean bl2) {
        boolean bl3;
        boolean bl4 = this.mIsClosing;
        if (bl4) {
            return;
        }
        this.mIsClosing = bl4 = true;
        Iterator iterator2 = this.mPresenters.iterator();
        while (bl3 = iterator2.hasNext()) {
            WeakReference weakReference = (WeakReference)iterator2.next();
            Object object = (MenuPresenter)weakReference.get();
            if (object == null) {
                object = this.mPresenters;
                ((CopyOnWriteArrayList)object).remove(weakReference);
                continue;
            }
            object.onCloseMenu(this, bl2);
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        Iterator iterator2 = this.mPresenters;
        boolean bl2 = ((CopyOnWriteArrayList)((Object)iterator2)).isEmpty();
        boolean bl3 = false;
        if (!bl2 && (iterator2 = this.mExpandedItem) == menuItemImpl) {
            boolean bl4;
            this.stopDispatchingItemsChanged();
            iterator2 = this.mPresenters.iterator();
            while (bl4 = iterator2.hasNext()) {
                WeakReference weakReference = (WeakReference)iterator2.next();
                Object object = (MenuPresenter)weakReference.get();
                if (object == null) {
                    object = this.mPresenters;
                    ((CopyOnWriteArrayList)object).remove(weakReference);
                    continue;
                }
                bl3 = object.collapseItemActionView(this, menuItemImpl);
                if (!bl3) continue;
            }
            this.startDispatchingItemsChanged();
            if (bl3) {
                menuItemImpl = null;
                this.mExpandedItem = null;
            }
        }
        return bl3;
    }

    public boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean bl2;
        MenuBuilder$Callback menuBuilder$Callback = this.mCallback;
        if (menuBuilder$Callback != null && (bl2 = menuBuilder$Callback.onMenuItemSelected(menuBuilder, menuItem))) {
            bl2 = true;
        } else {
            bl2 = false;
            menuBuilder = null;
        }
        return bl2;
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean bl2;
        Object object = this.mPresenters;
        boolean bl3 = ((CopyOnWriteArrayList)object).isEmpty();
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        this.stopDispatchingItemsChanged();
        object = this.mPresenters.iterator();
        while (bl2 = object.hasNext()) {
            WeakReference weakReference = (WeakReference)object.next();
            Object object2 = (MenuPresenter)weakReference.get();
            if (object2 == null) {
                object2 = this.mPresenters;
                ((CopyOnWriteArrayList)object2).remove(weakReference);
                continue;
            }
            bl4 = object2.expandItemActionView(this, menuItemImpl);
            if (!bl4) continue;
        }
        this.startDispatchingItemsChanged();
        if (bl4) {
            this.mExpandedItem = menuItemImpl;
        }
        return bl4;
    }

    public int findGroupIndex(int n10) {
        return this.findGroupIndex(n10, 0);
    }

    public int findGroupIndex(int n10, int n11) {
        int n12 = this.size();
        if (n11 < 0) {
            n11 = 0;
        }
        while (n11 < n12) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(n11);
            int n13 = menuItemImpl.getGroupId();
            if (n13 == n10) {
                return n11;
            }
            ++n11;
        }
        return -1;
    }

    public MenuItem findItem(int n10) {
        int n11 = this.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            int n12 = menuItemImpl.getItemId();
            if (n12 == n10) {
                return menuItemImpl;
            }
            n12 = (int)(menuItemImpl.hasSubMenu() ? 1 : 0);
            if (n12 == 0 || (menuItemImpl = menuItemImpl.getSubMenu().findItem(n10)) == null) continue;
            return menuItemImpl;
        }
        return null;
    }

    public int findItemIndex(int n10) {
        int n11 = this.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            int n12 = menuItemImpl.getItemId();
            if (n12 != n10) continue;
            return i10;
        }
        return -1;
    }

    public MenuItemImpl findItemWithShortcutForKey(int n10, KeyEvent keyEvent) {
        ArrayList arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        this.findItemsWithShortcutForKey(arrayList, n10, keyEvent);
        int n11 = arrayList.isEmpty();
        if (n11 != 0) {
            return null;
        }
        n11 = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int n12 = arrayList.size();
        int n13 = 1;
        if (n12 == n13) {
            return (MenuItemImpl)arrayList.get(0);
        }
        n13 = (int)(this.isQwertyMode() ? 1 : 0);
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14;
            MenuItemImpl menuItemImpl = (MenuItemImpl)arrayList.get(i10);
            int n15 = n13 != 0 ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            char[] cArray = keyData.meta;
            int n16 = cArray[0];
            if (!(n15 == n16 && (n16 = n11 & 2) == 0 || n15 == (n14 = cArray[n16 = 2]) && (n14 = n11 & 2) != 0) && (n13 == 0 || n15 != (n14 = 8) || n10 != (n15 = 67))) continue;
            return menuItemImpl;
        }
        return null;
    }

    public void findItemsWithShortcutForKey(List list, int n10, KeyEvent keyEvent) {
        boolean bl2 = this.isQwertyMode();
        int n11 = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        int n12 = keyEvent.getKeyData(keyData);
        int n13 = 67;
        if (n12 == 0 && n10 != n13) {
            return;
        }
        ArrayList arrayList = this.mItems;
        n12 = arrayList.size();
        for (int i10 = 0; i10 < n12; ++i10) {
            char[] cArray;
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            int n14 = menuItemImpl.hasSubMenu();
            if (n14 != 0) {
                MenuBuilder menuBuilder = (MenuBuilder)menuItemImpl.getSubMenu();
                menuBuilder.findItemsWithShortcutForKey(list, n10, keyEvent);
            }
            n14 = bl2 ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            int n15 = bl2 ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers();
            int n16 = 69647;
            int n17 = n11 & n16;
            if (n17 == (n15 &= n16)) {
                n15 = 1;
            } else {
                n15 = 0;
                cArray = null;
            }
            if (n15 == 0 || n14 == 0 || n14 != (n16 = (cArray = keyData.meta)[0]) && n14 != (n15 = cArray[n16 = 2]) && (!bl2 || n14 != (n15 = 8) || n10 != n13) || (n14 = (int)(menuItemImpl.isEnabled() ? 1 : 0)) == 0) continue;
            list.add(menuItemImpl);
        }
    }

    public void flagActionItems() {
        Object object;
        Object object2;
        int n10;
        ArrayList arrayList = this.getVisibleItems();
        int n11 = this.mIsActionItemsStale;
        if (n11 == 0) {
            return;
        }
        Object object3 = this.mPresenters.iterator();
        int n12 = 0;
        while ((n10 = object3.hasNext()) != 0) {
            object2 = (WeakReference)object3.next();
            object = (MenuPresenter)((Reference)object2).get();
            if (object == null) {
                object = this.mPresenters;
                ((CopyOnWriteArrayList)object).remove(object2);
                continue;
            }
            n10 = object.flagActionItems();
            n12 |= n10;
        }
        if (n12 != 0) {
            this.mActionItems.clear();
            object3 = this.mNonActionItems;
            ((ArrayList)object3).clear();
            n11 = arrayList.size();
            for (n12 = 0; n12 < n11; ++n12) {
                object2 = (MenuItemImpl)arrayList.get(n12);
                boolean bl2 = ((MenuItemImpl)object2).isActionButton();
                if (bl2) {
                    object = this.mActionItems;
                    ((ArrayList)object).add(object2);
                    continue;
                }
                object = this.mNonActionItems;
                ((ArrayList)object).add(object2);
            }
        } else {
            this.mActionItems.clear();
            this.mNonActionItems.clear();
            arrayList = this.mNonActionItems;
            object3 = this.getVisibleItems();
            arrayList.addAll(object3);
        }
        this.mIsActionItemsStale = false;
    }

    public ArrayList getActionItems() {
        this.flagActionItems();
        return this.mActionItems;
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public MenuItem getItem(int n10) {
        return (MenuItem)this.mItems.get(n10);
    }

    public ArrayList getNonActionItems() {
        this.flagActionItems();
        return this.mNonActionItems;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public ArrayList getVisibleItems() {
        int n10 = this.mIsVisibleItemsStale;
        if (n10 == 0) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        ArrayList arrayList = this.mItems;
        n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            boolean bl2 = menuItemImpl.isVisible();
            if (!bl2) continue;
            ArrayList arrayList2 = this.mVisibleItems;
            arrayList2.add(menuItemImpl);
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public boolean hasVisibleItems() {
        int n10 = this.mOverrideVisibleItems;
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            boolean bl3 = menuItemImpl.isVisible();
            if (!bl3) continue;
            return bl2;
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutKey(int n10, KeyEvent keyEvent) {
        MenuItemImpl menuItemImpl = this.findItemWithShortcutForKey(n10, keyEvent);
        if (menuItemImpl != null) {
            n10 = 1;
        } else {
            n10 = 0;
            menuItemImpl = null;
        }
        return n10 != 0;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    public void onItemActionRequestChanged(MenuItemImpl menuItemImpl) {
        boolean bl2;
        this.mIsActionItemsStale = bl2 = true;
        this.onItemsChanged(bl2);
    }

    public void onItemVisibleChanged(MenuItemImpl menuItemImpl) {
        boolean bl2;
        this.mIsVisibleItemsStale = bl2 = true;
        this.onItemsChanged(bl2);
    }

    public void onItemsChanged(boolean bl2) {
        boolean bl3 = this.mPreventDispatchingItemsChanged;
        boolean bl4 = true;
        if (!bl3) {
            if (bl2) {
                this.mIsVisibleItemsStale = bl4;
                this.mIsActionItemsStale = bl4;
            }
            this.dispatchPresenterUpdate(bl2);
        } else {
            this.mItemsChangedWhileDispatchPrevented = bl4;
            if (bl2) {
                this.mStructureChangedWhileDispatchPrevented = bl4;
            }
        }
    }

    public boolean performIdentifierAction(int n10, int n11) {
        MenuItem menuItem = this.findItem(n10);
        return this.performItemAction(menuItem, n11);
    }

    public boolean performItemAction(MenuItem menuItem, int n10) {
        return this.performItemAction(menuItem, null, n10);
    }

    public boolean performItemAction(MenuItem object, MenuPresenter menuPresenter, int n10) {
        boolean bl2;
        object = (MenuItemImpl)object;
        Context context = null;
        if (object != null && (bl2 = ((MenuItemImpl)object).isEnabled())) {
            boolean bl3;
            bl2 = ((MenuItemImpl)object).invoke();
            ActionProvider actionProvider = ((MenuItemImpl)object).getSupportActionProvider();
            boolean bl4 = true;
            bl3 = actionProvider != null && (bl3 = actionProvider.hasSubMenu()) ? bl4 : false;
            boolean bl5 = ((MenuItemImpl)object).hasCollapsibleActionView();
            if (bl5) {
                boolean bl6 = ((MenuItemImpl)object).expandActionView();
                if (bl2 |= bl6) {
                    this.close(bl4);
                }
            } else {
                bl5 = ((MenuItemImpl)object).hasSubMenu();
                if (!bl5 && !bl3) {
                    int n11 = n10 & 1;
                    if (n11 == 0) {
                        this.close(bl4);
                    }
                } else {
                    boolean bl7;
                    if ((n10 &= 4) == 0) {
                        this.close(false);
                    }
                    if ((n10 = (int)(((MenuItemImpl)object).hasSubMenu() ? 1 : 0)) == 0) {
                        context = this.getContext();
                        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(context, this, (MenuItemImpl)object);
                        ((MenuItemImpl)object).setSubMenu(subMenuBuilder);
                    }
                    object = (SubMenuBuilder)((MenuItemImpl)object).getSubMenu();
                    if (bl3) {
                        actionProvider.onPrepareSubMenu((SubMenu)object);
                    }
                    if (!(bl2 |= (bl7 = this.dispatchSubMenuSelected((SubMenuBuilder)object, menuPresenter)))) {
                        this.close(bl4);
                    }
                }
            }
            return bl2;
        }
        return false;
    }

    public boolean performShortcut(int n10, KeyEvent keyEvent, int n11) {
        MenuItemImpl menuItemImpl = this.findItemWithShortcutForKey(n10, keyEvent);
        if (menuItemImpl != null) {
            n10 = (int)(this.performItemAction(menuItemImpl, n11) ? 1 : 0);
        } else {
            n10 = 0;
            menuItemImpl = null;
        }
        int bl2 = n11 & 2;
        if (bl2 != 0) {
            boolean bl3 = true;
            this.close(bl3);
        }
        return n10 != 0;
    }

    public void removeGroup(int n10) {
        int n11 = this.findGroupIndex(n10);
        if (n11 >= 0) {
            ArrayList arrayList = this.mItems;
            int n12 = arrayList.size() - n11;
            int n13 = 0;
            MenuItemImpl menuItemImpl = null;
            while (true) {
                int n14 = n13 + 1;
                if (n13 >= n12 || (n13 = (menuItemImpl = (MenuItemImpl)this.mItems.get(n11)).getGroupId()) != n10) break;
                this.removeItemAtInt(n11, false);
                n13 = n14;
            }
            n10 = 1;
            this.onItemsChanged(n10 != 0);
        }
    }

    public void removeItem(int n10) {
        n10 = this.findItemIndex(n10);
        this.removeItemAtInt(n10, true);
    }

    public void removeItemAt(int n10) {
        this.removeItemAtInt(n10, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        boolean bl2;
        Iterator iterator2 = this.mPresenters.iterator();
        while (bl2 = iterator2.hasNext()) {
            WeakReference weakReference = (WeakReference)iterator2.next();
            Object object = (MenuPresenter)weakReference.get();
            if (object != null && object != menuPresenter) continue;
            object = this.mPresenters;
            ((CopyOnWriteArrayList)object).remove(weakReference);
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string2 = this.getActionViewStatesKey();
        string2 = bundle.getSparseParcelableArray(string2);
        int n10 = this.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            int n11;
            int n12;
            Object object = this.getItem(i10);
            View view = object.getActionView();
            if (view != null && (n12 = view.getId()) != (n11 = -1)) {
                view.restoreHierarchyState((SparseArray)string2);
            }
            if (!(bl2 = object.hasSubMenu())) continue;
            object = (SubMenuBuilder)object.getSubMenu();
            ((MenuBuilder)object).restoreActionViewStates(bundle);
        }
        string2 = EXPANDED_ACTION_VIEW_ID;
        int n13 = bundle.getInt(string2);
        if (n13 > 0 && (bundle = this.findItem(n13)) != null) {
            bundle.expandActionView();
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        this.dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int n10 = this.size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12;
            int n13;
            Object object = this.getItem(i10);
            View view = object.getActionView();
            if (view != null && (n13 = view.getId()) != (n12 = -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                view.saveHierarchyState(sparseArray);
                n11 = object.isActionViewExpanded();
                if (n11 != 0) {
                    n11 = object.getItemId();
                    String string2 = EXPANDED_ACTION_VIEW_ID;
                    bundle.putInt(string2, n11);
                }
            }
            if ((n11 = object.hasSubMenu()) == 0) continue;
            object = (SubMenuBuilder)object.getSubMenu();
            ((MenuBuilder)object).saveActionViewStates(bundle);
        }
        if (sparseArray != null) {
            String string3 = this.getActionViewStatesKey();
            bundle.putSparseParcelableArray(string3, sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        this.dispatchSaveInstanceState(bundle);
    }

    public void setCallback(MenuBuilder$Callback menuBuilder$Callback) {
        this.mCallback = menuBuilder$Callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int n10) {
        this.mDefaultShowAsAction = n10;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        int n10 = menuItem.getGroupId();
        ArrayList arrayList = this.mItems;
        int n11 = arrayList.size();
        this.stopDispatchingItemsChanged();
        for (int i10 = 0; i10 < n11; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            int n12 = menuItemImpl.getGroupId();
            if (n12 != n10 || !(n12 = (int)(menuItemImpl.isExclusiveCheckable() ? 1 : 0)) || !(n12 = (int)(menuItemImpl.isCheckable() ? 1 : 0))) continue;
            n12 = menuItemImpl == menuItem ? 1 : 0;
            menuItemImpl.setCheckedInt(n12 != 0);
        }
        this.startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int n10, boolean bl2, boolean bl3) {
        ArrayList arrayList = this.mItems;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            int n12 = menuItemImpl.getGroupId();
            if (n12 != n10) continue;
            menuItemImpl.setExclusiveCheckable(bl3);
            menuItemImpl.setCheckable(bl2);
        }
    }

    public void setGroupDividerEnabled(boolean bl2) {
        this.mGroupDividerEnabled = bl2;
    }

    public void setGroupEnabled(int n10, boolean bl2) {
        ArrayList arrayList = this.mItems;
        int n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(i10);
            int n12 = menuItemImpl.getGroupId();
            if (n12 != n10) continue;
            menuItemImpl.setEnabled(bl2);
        }
    }

    public void setGroupVisible(int n10, boolean bl2) {
        boolean bl3;
        ArrayList arrayList = this.mItems;
        int n11 = arrayList.size();
        int n12 = 0;
        boolean bl4 = false;
        while (true) {
            boolean bl5;
            bl3 = true;
            if (n12 >= n11) break;
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.mItems.get(n12);
            int n13 = menuItemImpl.getGroupId();
            if (n13 == n10 && (bl5 = menuItemImpl.setVisibleInt(bl2))) {
                bl4 = bl3;
            }
            ++n12;
        }
        if (bl4) {
            this.onItemsChanged(bl3);
        }
    }

    public MenuBuilder setHeaderIconInt(int n10) {
        this.setHeaderInternal(0, null, n10, null, null);
        return this;
    }

    public MenuBuilder setHeaderIconInt(Drawable drawable2) {
        this.setHeaderInternal(0, null, 0, drawable2, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(int n10) {
        this.setHeaderInternal(n10, null, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        this.setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    public MenuBuilder setHeaderViewInt(View view) {
        this.setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean bl2) {
        this.mOptionalIconsVisible = bl2;
    }

    public void setOverrideVisibleItems(boolean bl2) {
        this.mOverrideVisibleItems = bl2;
    }

    public void setQwertyMode(boolean bl2) {
        this.mQwertyMode = bl2;
        this.onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean bl2) {
        boolean bl3 = this.mShortcutsVisible;
        if (bl3 == bl2) {
            return;
        }
        this.setShortcutsVisibleInner(bl2);
        this.onItemsChanged(false);
    }

    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        boolean bl2 = false;
        this.mPreventDispatchingItemsChanged = false;
        boolean bl3 = this.mItemsChangedWhileDispatchPrevented;
        if (bl3) {
            this.mItemsChangedWhileDispatchPrevented = false;
            bl2 = this.mStructureChangedWhileDispatchPrevented;
            this.onItemsChanged(bl2);
        }
    }

    public void stopDispatchingItemsChanged() {
        boolean bl2 = this.mPreventDispatchingItemsChanged;
        if (!bl2) {
            this.mPreventDispatchingItemsChanged = true;
            bl2 = false;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }
}

