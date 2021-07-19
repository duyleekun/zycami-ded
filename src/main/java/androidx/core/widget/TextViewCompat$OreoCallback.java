/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.text.Editable
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.widget.TextView
 */
package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TextViewCompat$OreoCallback
implements ActionMode.Callback {
    private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
    private final ActionMode.Callback mCallback;
    private boolean mCanUseMenuBuilderReferences;
    private boolean mInitializedMenuBuilderReferences;
    private Class mMenuBuilderClass;
    private Method mMenuBuilderRemoveItemAtMethod;
    private final TextView mTextView;

    public TextViewCompat$OreoCallback(ActionMode.Callback callback, TextView textView) {
        this.mCallback = callback;
        this.mTextView = textView;
        this.mInitializedMenuBuilderReferences = false;
    }

    private Intent createProcessTextIntent() {
        Intent intent = new Intent();
        return intent.setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    private Intent createProcessTextIntentForResolveInfo(ResolveInfo object, TextView textView) {
        Object object2 = this.createProcessTextIntent();
        boolean bl2 = this.isEditable(textView) ^ true;
        textView = object2.putExtra("android.intent.extra.PROCESS_TEXT_READONLY", bl2);
        object = object.activityInfo;
        object2 = object.packageName;
        object = object.name;
        return textView.setClassName((String)object2, (String)object);
    }

    private List getSupportedActivities(Context context, PackageManager object) {
        ArrayList<Intent> arrayList = new ArrayList<Intent>();
        boolean bl2 = context instanceof Activity;
        if (!bl2) {
            return arrayList;
        }
        Intent intent = this.createProcessTextIntent();
        boolean bl3 = false;
        object = object.queryIntentActivities(intent, 0).iterator();
        while (bl2 = object.hasNext()) {
            intent = (ResolveInfo)object.next();
            bl3 = this.isSupportedActivity((ResolveInfo)intent, context);
            if (!bl3) continue;
            arrayList.add(intent);
        }
        return arrayList;
    }

    private boolean isEditable(TextView textView) {
        boolean bl2;
        boolean bl3 = textView instanceof Editable;
        if (bl3 && (bl3 = textView.onCheckIsTextEditor()) && (bl2 = textView.isEnabled())) {
            bl2 = true;
        } else {
            bl2 = false;
            textView = null;
        }
        return bl2;
    }

    private boolean isSupportedActivity(ResolveInfo object, Context context) {
        int n10;
        String string2 = context.getPackageName();
        String string3 = object.activityInfo.packageName;
        boolean bl2 = string2.equals(string3);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        object = object.activityInfo;
        bl2 = object.exported;
        if (!bl2) {
            return false;
        }
        object = object.permission;
        if (object != null && (n10 = context.checkSelfPermission((String)object)) != 0) {
            bl3 = false;
            string3 = null;
        }
        return bl3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void recomputeProcessTextMenuItems(Menu menu2) {
        int n10;
        int n11;
        Object object;
        MenuItem menuItem;
        GenericDeclaration genericDeclaration;
        int n12;
        String string2;
        int n13;
        PackageManager packageManager;
        Object object2;
        block9: {
            object2 = this.mTextView.getContext();
            packageManager = object2.getPackageManager();
            n13 = this.mInitializedMenuBuilderReferences;
            string2 = "removeItemAt";
            n12 = 1;
            if (n13 == 0) {
                this.mInitializedMenuBuilderReferences = n12;
                genericDeclaration = "com.android.internal.view.menu.MenuBuilder";
                try {
                    genericDeclaration = Class.forName((String)((Object)genericDeclaration));
                    this.mMenuBuilderClass = genericDeclaration;
                    menuItem = new Class[n12];
                    object = Integer.TYPE;
                    menuItem[0] = object;
                    genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, (Class<?>)menuItem);
                    this.mMenuBuilderRemoveItemAtMethod = genericDeclaration;
                    this.mCanUseMenuBuilderReferences = n12;
                }
                catch (ClassNotFoundException | NoSuchMethodException reflectiveOperationException) {
                    n13 = 0;
                    genericDeclaration = null;
                    this.mMenuBuilderClass = null;
                    this.mMenuBuilderRemoveItemAtMethod = null;
                    this.mCanUseMenuBuilderReferences = false;
                }
            }
            try {
                n13 = this.mCanUseMenuBuilderReferences;
                if (n13 != 0 && (n13 = ((Class)(genericDeclaration = this.mMenuBuilderClass)).isInstance(menu2)) != 0) {
                    genericDeclaration = this.mMenuBuilderRemoveItemAtMethod;
                    break block9;
                }
                genericDeclaration = menu2.getClass();
                menuItem = new Class[n12];
                object = Integer.TYPE;
                menuItem[0] = object;
                genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, (Class<?>)menuItem);
            }
            catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException reflectiveOperationException) {}
        }
        for (n11 = menu2.size() - n12; n11 >= 0; n11 += -1) {
            menuItem = menu2.getItem(n11);
            object = menuItem.getIntent();
            if (object == null) continue;
            object = "android.intent.action.PROCESS_TEXT";
            menuItem = menuItem.getIntent();
            n10 = ((String)object).equals(menuItem = menuItem.getAction());
            if (n10 == 0) continue;
            menuItem = new Object[n12];
            menuItem[0] = object = Integer.valueOf(n11);
            ((Method)genericDeclaration).invoke(menu2, (Object[])menuItem);
            continue;
        }
        object2 = this.getSupportedActivities((Context)object2, packageManager);
        genericDeclaration = null;
        for (n13 = 0; n13 < (n11 = object2.size()); ++n13) {
            string2 = (ResolveInfo)object2.get(n13);
            n10 = n13 + 100;
            object = string2.loadLabel(packageManager);
            menuItem = menu2.add(0, 0, n10, (CharSequence)object);
            object = this.mTextView;
            string2 = this.createProcessTextIntentForResolveInfo((ResolveInfo)string2, (TextView)object);
            string2 = menuItem.setIntent((Intent)string2);
            string2.setShowAsAction(n12);
        }
        return;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked(actionMode, menuItem);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu2) {
        return this.mCallback.onCreateActionMode(actionMode, menu2);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.mCallback.onDestroyActionMode(actionMode);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu2) {
        this.recomputeProcessTextMenuItems(menu2);
        return this.mCallback.onPrepareActionMode(actionMode, menu2);
    }
}

