/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 */
package androidx.navigation.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;
import androidx.navigation.fragment.FragmentNavigator$Destination;
import androidx.navigation.fragment.FragmentNavigator$Extras;
import java.util.ArrayDeque;
import java.util.Iterator;

public class FragmentNavigator
extends Navigator {
    private static final String KEY_BACK_STACK_IDS = "androidx-nav-fragment:navigator:backStackIds";
    private static final String TAG = "FragmentNavigator";
    private ArrayDeque mBackStack;
    private final int mContainerId;
    private final Context mContext;
    private final FragmentManager mFragmentManager;

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int n10) {
        ArrayDeque arrayDeque;
        this.mBackStack = arrayDeque = new ArrayDeque();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = n10;
    }

    private String generateBackStackName(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("-");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    public FragmentNavigator$Destination createDestination() {
        FragmentNavigator$Destination fragmentNavigator$Destination = new FragmentNavigator$Destination(this);
        return fragmentNavigator$Destination;
    }

    public Fragment instantiateFragment(Context object, FragmentManager object2, String string2, Bundle bundle) {
        object2 = ((FragmentManager)object2).getFragmentFactory();
        object = object.getClassLoader();
        return ((FragmentFactory)object2).instantiate((ClassLoader)object, string2);
    }

    /*
     * Unable to fully structure code
     */
    public NavDestination navigate(FragmentNavigator$Destination var1_1, Bundle var2_2, NavOptions var3_3, Navigator$Extras var4_4) {
        var5_5 = this.mFragmentManager;
        var6_6 = var5_5.isStateSaved();
        if (var6_6 != 0) {
            Log.i((String)"FragmentNavigator", (String)"Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        var5_5 = var1_1.getClassName();
        var7_7 = 0;
        var8_8 = var5_5.charAt(0);
        if (var8_8 == (var9_9 = 46)) {
            var10_10 = new StringBuilder();
            var11_11 = this.mContext.getPackageName();
            var10_10.append((String)var11_11);
            var10_10.append((String)var5_5);
            var5_5 = var10_10.toString();
        }
        var10_10 = this.mContext;
        var11_11 = this.mFragmentManager;
        var5_5 = this.instantiateFragment((Context)var10_10, (FragmentManager)var11_11, (String)var5_5, (Bundle)var2_2);
        var5_5.setArguments((Bundle)var2_2);
        var2_2 = this.mFragmentManager.beginTransaction();
        var8_8 = -1;
        var12_12 = 0.0f / 0.0f;
        var9_9 = var3_3 != null ? var3_3.getEnterAnim() : var8_8;
        var13_13 = var3_3 != null ? var3_3.getExitAnim() : var8_8;
        var14_14 = var3_3 != null ? var3_3.getPopEnterAnim() : var8_8;
        var15_15 = var3_3 != null ? var3_3.getPopExitAnim() : var8_8;
        if (var9_9 != var8_8 || var13_13 != var8_8 || var14_14 != var8_8 || var15_15 != var8_8) {
            if (var9_9 == var8_8) {
                var9_9 = 0;
                var11_11 = null;
            }
            if (var13_13 == var8_8) {
                var13_13 = 0;
                var16_16 = null;
            }
            if (var14_14 == var8_8) {
                var14_14 = 0;
            }
            if (var15_15 == var8_8) {
                var15_15 = 0;
            }
            var2_2.setCustomAnimations(var9_9, var13_13, var14_14, var15_15);
        }
        var8_8 = this.mContainerId;
        var2_2.replace(var8_8, (Fragment)var5_5);
        var2_2.setPrimaryNavigationFragment((Fragment)var5_5);
        var6_6 = var1_1.getId();
        var10_10 = this.mBackStack;
        var8_8 = (int)var10_10.isEmpty();
        var9_9 = 1;
        if (var3_3 != null && var8_8 == 0 && (var17_17 = var3_3.shouldLaunchSingleTop()) != 0 && (var17_17 = (var3_3 = (Integer)this.mBackStack.peekLast()).intValue()) == var6_6) {
            var17_17 = var9_9;
        } else {
            var17_17 = 0;
            var3_3 = null;
        }
        if (var8_8 != 0) lbl-1000:
        // 2 sources

        {
            while (true) {
                var7_7 = var9_9;
                break;
            }
        } else if (var17_17 != 0) {
            var3_3 = this.mBackStack;
            var17_17 = var3_3.size();
            if (var17_17 > var9_9) {
                var3_3 = this.mFragmentManager;
                var8_8 = this.mBackStack.size();
                var16_16 = (Integer)this.mBackStack.peekLast();
                var13_13 = var16_16;
                var10_10 = this.generateBackStackName(var8_8, var13_13);
                var3_3.popBackStack((String)var10_10, var9_9);
                var17_17 = this.mBackStack.size();
                var3_3 = this.generateBackStackName(var17_17, var6_6);
                var2_2.addToBackStack((String)var3_3);
            }
        } else {
            var17_17 = this.mBackStack.size() + var9_9;
            var3_3 = this.generateBackStackName(var17_17, var6_6);
            var2_2.addToBackStack((String)var3_3);
            ** continue;
        }
        var17_17 = var4_4 instanceof FragmentNavigator$Extras;
        if (var17_17 != 0) {
            var4_4 = (FragmentNavigator$Extras)var4_4;
            var3_3 = var4_4.getSharedElements().entrySet().iterator();
            while (var18_18 = var3_3.hasNext()) {
                var4_4 = var3_3.next();
                var10_10 = (View)var4_4.getKey();
                var4_4 = (String)var4_4.getValue();
                var2_2.addSharedElement((View)var10_10, (String)var4_4);
            }
        }
        var2_2.setReorderingAllowed((boolean)var9_9);
        var2_2.commit();
        if (var7_7 != 0) {
            var2_2 = this.mBackStack;
            var3_3 = var6_6;
            var2_2.add(var3_3);
            return var1_1;
        }
        return null;
    }

    public void onRestoreState(Bundle object) {
        Object object2;
        int[] nArray;
        if (object != null && (nArray = object.getIntArray((String)(object2 = KEY_BACK_STACK_IDS))) != null) {
            object2 = this.mBackStack;
            ((ArrayDeque)object2).clear();
            for (int n10 : nArray) {
                ArrayDeque arrayDeque = this.mBackStack;
                Integer n11 = n10;
                arrayDeque.add(n11);
            }
        }
    }

    public Bundle onSaveState() {
        int n10;
        Bundle bundle = new Bundle();
        int n11 = this.mBackStack.size();
        int[] nArray = new int[n11];
        Iterator iterator2 = this.mBackStack.iterator();
        int n12 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            Integer n13 = (Integer)iterator2.next();
            int n14 = n12 + 1;
            nArray[n12] = n10 = n13.intValue();
            n12 = n14;
        }
        bundle.putIntArray(KEY_BACK_STACK_IDS, nArray);
        return bundle;
    }

    public boolean popBackStack() {
        Object object = this.mBackStack;
        boolean bl2 = ((ArrayDeque)object).isEmpty();
        int n10 = 0;
        String string2 = null;
        if (bl2) {
            return false;
        }
        object = this.mFragmentManager;
        bl2 = ((FragmentManager)object).isStateSaved();
        if (bl2) {
            Log.i((String)TAG, (String)"Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        object = this.mFragmentManager;
        n10 = this.mBackStack.size();
        int bl3 = (Integer)this.mBackStack.peekLast();
        string2 = this.generateBackStackName(n10, bl3);
        boolean bl4 = true;
        ((FragmentManager)object).popBackStack(string2, (int)(bl4 ? 1 : 0));
        this.mBackStack.removeLast();
        return bl4;
    }
}

