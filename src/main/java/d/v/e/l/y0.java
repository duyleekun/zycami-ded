/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.content.Context
 *  android.content.Intent
 */
package d.v.e.l;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class y0 {
    public static void a(FragmentActivity object) {
        boolean bl2;
        object = ((FragmentActivity)object).getSupportFragmentManager().getFragments().iterator();
        while (bl2 = object.hasNext()) {
            Fragment fragment = (Fragment)object.next();
            boolean bl3 = fragment instanceof AppCompatDialogFragment;
            if (!bl3) continue;
            fragment = (AppCompatDialogFragment)fragment;
            ((DialogFragment)fragment).dismissAllowingStateLoss();
        }
    }

    public static void b(Activity activity, String[] stringArray, int n10) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.MIME_TYPES", stringArray);
        activity.startActivityForResult(intent, n10);
    }

    public static boolean c(Context object, Class object2) {
        boolean bl2;
        object2 = ((Class)object2).getName();
        String string2 = "activity";
        object = (ActivityManager)object.getSystemService(string2);
        boolean bl3 = true;
        int n10 = (object = object.getRunningTasks((int)(bl3 ? 1 : 0))).size();
        if (n10 <= 0 || !(bl2 = ((String)object2).equals(object = ((ActivityManager.RunningTaskInfo)object.get((int)0)).topActivity.getClassName()))) {
            bl3 = false;
            string2 = null;
        }
        return bl3;
    }

    public static boolean d(Context object) {
        boolean bl2;
        String string2 = object.getPackageName();
        String string3 = "activity";
        object = (ActivityManager)object.getSystemService(string3);
        boolean bl3 = true;
        int n10 = (object = object.getRunningTasks((int)(bl3 ? 1 : 0))).size();
        if (n10 <= 0 || !(bl2 = ((String)(object = ((ActivityManager.RunningTaskInfo)object.get((int)0)).topActivity.getPackageName().trim())).equals(string2))) {
            bl3 = false;
            string3 = null;
        }
        return bl3;
    }

    public static boolean e(Context object) {
        Object object2 = ((ActivityManager)object.getSystemService("activity")).getRunningAppProcesses();
        if (object2 != null) {
            int n10;
            object = object.getPackageName();
            object2 = object2.iterator();
            while ((n10 = object2.hasNext()) != 0) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)object2.next();
                String string2 = runningAppProcessInfo.processName;
                int n11 = string2.equals(object);
                if (n11 == 0 || (n10 = runningAppProcessInfo.importance) != (n11 = 100)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean f(Context object, String string2) {
        String string3 = "activity";
        if ((object = ((ActivityManager)object.getSystemService(string3)).getRunningAppProcesses()) != null) {
            int n10;
            object = object.iterator();
            while ((n10 = object.hasNext()) != 0) {
                string3 = (ActivityManager.RunningAppProcessInfo)object.next();
                String string4 = ((ActivityManager.RunningAppProcessInfo)string3).processName;
                int n11 = string4.equals(string2);
                if (n11 == 0 || (n10 = ((ActivityManager.RunningAppProcessInfo)string3).importance) != (n11 = 100)) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean g(Context object) {
        int n10;
        Object object2 = ((ActivityManager)object.getSystemService("activity")).getRunningTasks(-1 >>> 1);
        boolean bl2 = false;
        if (object2 != null && (n10 = object2.size()) > 0) {
            object2 = ((ActivityManager.RunningTaskInfo)object2.get((int)0)).topActivity.getClassName();
            boolean bl3 = ((String)(object = object.getClass().getName())).equals(object2);
            if (bl3) {
                bl2 = true;
            }
        }
        return bl2;
    }
}

