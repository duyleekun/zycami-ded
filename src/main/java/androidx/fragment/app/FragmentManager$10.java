/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.util.Log
 */
package androidx.fragment.app;

import android.content.Intent;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;

public class FragmentManager$10
implements ActivityResultCallback {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$10(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public void onActivityResult(ActivityResult object) {
        FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo)this.this$0.mLaunchedFragments.pollFirst();
        String string2 = "FragmentManager";
        if (fragmentManager$LaunchedFragmentInfo == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("No IntentSenders were started for ");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
            return;
        }
        String string3 = fragmentManager$LaunchedFragmentInfo.mWho;
        int n10 = fragmentManager$LaunchedFragmentInfo.mRequestCode;
        Fragment fragment = FragmentManager.access$200(this.this$0).findFragmentByWho(string3);
        if (fragment == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Intent Sender result delivered for unknown Fragment ");
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
            return;
        }
        int n11 = ((ActivityResult)object).getResultCode();
        object = ((ActivityResult)object).getData();
        fragment.onActivityResult(n10, n11, (Intent)object);
    }
}

