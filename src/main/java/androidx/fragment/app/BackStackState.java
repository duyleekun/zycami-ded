/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.BackStackState$1;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransaction$Op;
import androidx.lifecycle.Lifecycle$State;
import java.util.ArrayList;
import java.util.List;

public final class BackStackState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private static final String TAG = "FragmentManager";
    public final int mBreadCrumbShortTitleRes;
    public final CharSequence mBreadCrumbShortTitleText;
    public final int mBreadCrumbTitleRes;
    public final CharSequence mBreadCrumbTitleText;
    public final int[] mCurrentMaxLifecycleStates;
    public final ArrayList mFragmentWhos;
    public final int mIndex;
    public final String mName;
    public final int[] mOldMaxLifecycleStates;
    public final int[] mOps;
    public final boolean mReorderingAllowed;
    public final ArrayList mSharedElementSourceNames;
    public final ArrayList mSharedElementTargetNames;
    public final int mTransition;

    static {
        BackStackState$1 backStackState$1 = new BackStackState$1();
        CREATOR = backStackState$1;
    }

    public BackStackState(Parcel parcel) {
        int n10;
        Object object = parcel.createIntArray();
        this.mOps = object;
        object = parcel.createStringArrayList();
        this.mFragmentWhos = object;
        object = parcel.createIntArray();
        this.mOldMaxLifecycleStates = object;
        object = parcel.createIntArray();
        this.mCurrentMaxLifecycleStates = object;
        this.mTransition = n10 = parcel.readInt();
        object = parcel.readString();
        this.mName = object;
        this.mIndex = n10 = parcel.readInt();
        this.mBreadCrumbTitleRes = n10 = parcel.readInt();
        object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbTitleText = object;
        this.mBreadCrumbShortTitleRes = n10 = parcel.readInt();
        object = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mBreadCrumbShortTitleText = object;
        object = parcel.createStringArrayList();
        this.mSharedElementSourceNames = object;
        object = parcel.createStringArrayList();
        this.mSharedElementTargetNames = object;
        int n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = 1;
        } else {
            n11 = 0;
            parcel = null;
        }
        this.mReorderingAllowed = n11;
    }

    public BackStackState(BackStackRecord object) {
        Object object2 = ((FragmentTransaction)object).mOps;
        int n10 = ((ArrayList)object2).size();
        Object object3 = new int[n10 * 5];
        this.mOps = object3;
        int n11 = ((FragmentTransaction)object).mAddToBackStack;
        if (n11 != 0) {
            boolean bl2;
            object3 = new ArrayList;
            super(n10);
            this.mFragmentWhos = object3;
            object3 = new int[n10];
            this.mOldMaxLifecycleStates = object3;
            object3 = new int[n10];
            this.mCurrentMaxLifecycleStates = object3;
            object3 = null;
            int n12 = 0;
            Object object4 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                int n13;
                int n14;
                Object object5 = (FragmentTransaction$Op)((FragmentTransaction)object).mOps.get(n11);
                Object object6 = this.mOps;
                int n15 = n12 + 1;
                object6[n12] = n14 = ((FragmentTransaction$Op)object5).mCmd;
                object4 = this.mFragmentWhos;
                object6 = ((FragmentTransaction$Op)object5).mFragment;
                if (object6 != null) {
                    object6 = ((Fragment)object6).mWho;
                } else {
                    n13 = 0;
                    object6 = null;
                }
                ((ArrayList)object4).add(object6);
                object4 = this.mOps;
                n13 = n15 + 1;
                n14 = ((FragmentTransaction$Op)object5).mEnterAnim;
                object4[n15] = n14;
                n15 = n13 + 1;
                n14 = ((FragmentTransaction$Op)object5).mExitAnim;
                object4[n13] = n14;
                n13 = n15 + 1;
                n14 = ((FragmentTransaction$Op)object5).mPopEnterAnim;
                object4[n15] = n14;
                n15 = n13 + 1;
                n14 = ((FragmentTransaction$Op)object5).mPopExitAnim;
                object4[n13] = n14;
                object4 = this.mOldMaxLifecycleStates;
                object6 = (Object)((FragmentTransaction$Op)object5).mOldMaxState;
                n13 = ((Enum)object6).ordinal();
                object4[n11] = n13;
                object4 = this.mCurrentMaxLifecycleStates;
                object5 = ((FragmentTransaction$Op)object5).mCurrentMaxState;
                int n16 = ((Enum)object5).ordinal();
                object4[n11] = n16;
                n12 = n15;
            }
            this.mTransition = n10 = ((FragmentTransaction)object).mTransition;
            this.mName = object2 = ((FragmentTransaction)object).mName;
            this.mIndex = n10 = ((BackStackRecord)object).mIndex;
            this.mBreadCrumbTitleRes = n10 = ((FragmentTransaction)object).mBreadCrumbTitleRes;
            this.mBreadCrumbTitleText = object2 = ((FragmentTransaction)object).mBreadCrumbTitleText;
            this.mBreadCrumbShortTitleRes = n10 = ((FragmentTransaction)object).mBreadCrumbShortTitleRes;
            this.mBreadCrumbShortTitleText = object2 = ((FragmentTransaction)object).mBreadCrumbShortTitleText;
            this.mSharedElementSourceNames = object2 = ((FragmentTransaction)object).mSharedElementSourceNames;
            this.mSharedElementTargetNames = object2 = ((FragmentTransaction)object).mSharedElementTargetNames;
            this.mReorderingAllowed = bl2 = ((FragmentTransaction)object).mReorderingAllowed;
            return;
        }
        object = new IllegalStateException("Not on back stack");
        throw object;
    }

    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManager object) {
        int n10;
        Object object2;
        int n11;
        BackStackRecord backStackRecord = new BackStackRecord((FragmentManager)object);
        Object object3 = 0;
        Object object4 = null;
        int n12 = 0;
        while (object3 < (n11 = ((int[])(object2 = this.mOps)).length)) {
            Object object5;
            object2 = new FragmentTransaction$Op;
            object2();
            Object object6 = this.mOps;
            Object object7 = object3 + 1;
            object2.mCmd = object3 = object6[object3];
            object3 = FragmentManager.isLoggingEnabled(2);
            if (object3 != 0) {
                object4 = new StringBuilder();
                object4.append("Instantiate ");
                object4.append(backStackRecord);
                object4.append(" op #");
                object4.append(n12);
                object4.append(" base fragment #");
                object5 = this.mOps[object7];
                object4.append((int)object5);
                object4 = object4.toString();
                object6 = TAG;
                Log.v((String)object6, (String)object4);
            }
            if ((object4 = (String)this.mFragmentWhos.get(n12)) != null) {
                object4 = ((FragmentManager)object).findActiveFragment((String)object4);
                object2.mFragment = object4;
            } else {
                object3 = 0;
                object4 = null;
                object2.mFragment = null;
            }
            object4 = Lifecycle$State.values();
            object5 = this.mOldMaxLifecycleStates[n12];
            object4 = object4[object5];
            object2.mOldMaxState = object4;
            object4 = Lifecycle$State.values();
            object6 = this.mCurrentMaxLifecycleStates;
            object5 = object6[n12];
            object4 = object4[object5];
            object2.mCurrentMaxState = object4;
            object4 = this.mOps;
            object5 = object7 + 1;
            object2.mEnterAnim = object7 = (Object)((Object)object4[object7]);
            Object object8 = object5 + 1;
            object2.mExitAnim = object5 = (Object)((Object)object4[object5]);
            int n13 = object8 + 1;
            object2.mPopEnterAnim = object8 = (Object)((Object)object4[object8]);
            Object object9 = n13 + 1;
            object2.mPopExitAnim = object3 = (Object)((Object)object4[n13]);
            backStackRecord.mEnterAnim = object7;
            backStackRecord.mExitAnim = object5;
            backStackRecord.mPopEnterAnim = object8;
            backStackRecord.mPopExitAnim = object3;
            backStackRecord.addOp((FragmentTransaction$Op)object2);
            ++n12;
            object3 = object9;
        }
        backStackRecord.mTransition = n10 = this.mTransition;
        backStackRecord.mName = object = this.mName;
        backStackRecord.mIndex = n10 = this.mIndex;
        n10 = 1;
        backStackRecord.mAddToBackStack = n10;
        backStackRecord.mBreadCrumbTitleRes = object3 = this.mBreadCrumbTitleRes;
        object4 = this.mBreadCrumbTitleText;
        backStackRecord.mBreadCrumbTitleText = object4;
        backStackRecord.mBreadCrumbShortTitleRes = object3 = this.mBreadCrumbShortTitleRes;
        backStackRecord.mBreadCrumbShortTitleText = object4 = this.mBreadCrumbShortTitleText;
        object4 = this.mSharedElementSourceNames;
        backStackRecord.mSharedElementSourceNames = object4;
        object4 = this.mSharedElementTargetNames;
        backStackRecord.mSharedElementTargetNames = object4;
        object3 = this.mReorderingAllowed;
        backStackRecord.mReorderingAllowed = object3;
        backStackRecord.bumpBackStackNesting(n10);
        return backStackRecord;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.mOps;
        parcel.writeIntArray(object);
        object = this.mFragmentWhos;
        parcel.writeStringList((List)object);
        object = this.mOldMaxLifecycleStates;
        parcel.writeIntArray(object);
        object = this.mCurrentMaxLifecycleStates;
        parcel.writeIntArray(object);
        n10 = this.mTransition;
        parcel.writeInt(n10);
        object = this.mName;
        parcel.writeString((String)object);
        n10 = this.mIndex;
        parcel.writeInt(n10);
        n10 = this.mBreadCrumbTitleRes;
        parcel.writeInt(n10);
        TextUtils.writeToParcel((CharSequence)this.mBreadCrumbTitleText, (Parcel)parcel, (int)0);
        n10 = this.mBreadCrumbShortTitleRes;
        parcel.writeInt(n10);
        TextUtils.writeToParcel((CharSequence)this.mBreadCrumbShortTitleText, (Parcel)parcel, (int)0);
        object = this.mSharedElementSourceNames;
        parcel.writeStringList((List)object);
        object = this.mSharedElementTargetNames;
        parcel.writeStringList((List)object);
        n10 = (int)(this.mReorderingAllowed ? 1 : 0);
        parcel.writeInt(n10);
    }
}

