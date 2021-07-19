/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.fragment.app;

import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import java.util.ArrayList;
import java.util.Map;

public class FragmentManager$11
implements ActivityResultCallback {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$11(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void onActivityResult(Map object) {
        Object object2;
        int n10;
        String[] stringArray = object.keySet();
        int n11 = 0;
        FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = null;
        Object object3 = new String[]{};
        stringArray = stringArray.toArray((T[])object3);
        object = object.values();
        object3 = new ArrayList(object);
        int n12 = ((ArrayList)object3).size();
        object = new int[n12];
        String string2 = null;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)object3).size()); ++i10) {
            object2 = (Boolean)((ArrayList)object3).get(i10);
            n10 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
            if (n10 != 0) {
                n10 = 0;
                object2 = null;
            } else {
                n10 = -1;
            }
            object[i10] = n10;
        }
        fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo)this.this$0.mLaunchedFragments.pollFirst();
        object3 = "FragmentManager";
        if (fragmentManager$LaunchedFragmentInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No permissions were requested for ");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            Log.w((String)object3, (String)object);
            return;
        }
        string2 = fragmentManager$LaunchedFragmentInfo.mWho;
        n11 = fragmentManager$LaunchedFragmentInfo.mRequestCode;
        object2 = FragmentManager.access$200(this.this$0).findFragmentByWho(string2);
        if (object2 == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Permission request result delivered for unknown Fragment ");
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.w((String)object3, (String)object);
            return;
        }
        ((Fragment)object2).onRequestPermissionsResult(n11, stringArray, (int[])object);
    }
}

