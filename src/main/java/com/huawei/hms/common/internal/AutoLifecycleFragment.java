/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.FragmentTransaction
 *  android.os.Bundle
 *  android.util.SparseArray
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.internal.AutoLifecycleFragment$ClientInfo;
import com.huawei.hms.common.internal.Preconditions;

public class AutoLifecycleFragment
extends Fragment {
    private static final String TAG = "HmsAutoLifecycleFrag";
    private final SparseArray mAutoClientInfoMap;
    private boolean mStarted;

    public AutoLifecycleFragment() {
        SparseArray sparseArray;
        this.mAutoClientInfoMap = sparseArray = new SparseArray();
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Object object;
        block9: {
            Object object2 = TAG;
            object = "Must be called on the main thread";
            Preconditions.checkMainThread(object);
            try {
                object = activity.getFragmentManager();
            }
            catch (ClassCastException classCastException) {
                object2 = new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", classCastException);
                throw object2;
            }
            object = object.findFragmentByTag((String)object2);
            object = (AutoLifecycleFragment)((Object)object);
            activity = activity.getFragmentManager();
            if (object != null) break block9;
            object = new AutoLifecycleFragment();
            FragmentTransaction fragmentTransaction = activity.beginTransaction();
            object2 = fragmentTransaction.add((Fragment)object, (String)object2);
            object2.commitAllowingStateLoss();
            activity.executePendingTransactions();
        }
        return object;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onStart() {
        Object object;
        int n10;
        super.onStart();
        this.mStarted = true;
        for (int i10 = 0; i10 < (n10 = (object = this.mAutoClientInfoMap).size()); ++i10) {
            object = ((AutoLifecycleFragment$ClientInfo)this.mAutoClientInfoMap.valueAt((int)i10)).apiClient;
            ((HuaweiApiClient)object).connect(null);
        }
    }

    public void onStop() {
        Object object;
        int n10;
        super.onStop();
        this.mStarted = false;
        for (int i10 = 0; i10 < (n10 = (object = this.mAutoClientInfoMap).size()); ++i10) {
            object = ((AutoLifecycleFragment$ClientInfo)this.mAutoClientInfoMap.valueAt((int)i10)).apiClient;
            ((HuaweiApiClient)object).disconnect();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void startAutoMange(int n10, HuaweiApiClient huaweiApiClient) {
        void var4_7;
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        SparseArray sparseArray = this.mAutoClientInfoMap;
        int bl2 = sparseArray.indexOfKey(n10);
        if (bl2 < 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            sparseArray = null;
        }
        Object object = new StringBuilder();
        String string2 = "Already managing a HuaweiApiClient with this clientId: ";
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Preconditions.checkState((boolean)var4_7, object);
        sparseArray = this.mAutoClientInfoMap;
        object = new AutoLifecycleFragment$ClientInfo(this, n10, huaweiApiClient);
        sparseArray.put(n10, object);
        n10 = (int)(this.mStarted ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            huaweiApiClient.connect(null);
        }
    }

    public void stopAutoManage(int n10) {
        AutoLifecycleFragment$ClientInfo autoLifecycleFragment$ClientInfo = (AutoLifecycleFragment$ClientInfo)this.mAutoClientInfoMap.get(n10);
        SparseArray sparseArray = this.mAutoClientInfoMap;
        sparseArray.remove(n10);
        if (autoLifecycleFragment$ClientInfo != null) {
            autoLifecycleFragment$ClientInfo.stopAutoManage();
        }
    }
}

