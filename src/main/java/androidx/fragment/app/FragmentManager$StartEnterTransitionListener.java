/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$OnStartEnterTransitionListener;
import androidx.fragment.app.FragmentManager;

public class FragmentManager$StartEnterTransitionListener
implements Fragment$OnStartEnterTransitionListener {
    public final boolean mIsBack;
    private int mNumPostponed;
    public final BackStackRecord mRecord;

    public FragmentManager$StartEnterTransitionListener(BackStackRecord backStackRecord, boolean bl2) {
        this.mIsBack = bl2;
        this.mRecord = backStackRecord;
    }

    public void cancelTransaction() {
        BackStackRecord backStackRecord = this.mRecord;
        FragmentManager fragmentManager = backStackRecord.mManager;
        boolean bl2 = this.mIsBack;
        fragmentManager.completeExecute(backStackRecord, bl2, false, false);
    }

    /*
     * WARNING - void declaration
     */
    public void completeTransaction() {
        void var1_4;
        boolean bl2;
        Object object;
        boolean bl3;
        int bl4 = this.mNumPostponed;
        int n10 = 1;
        if (bl4 > 0) {
            int n11 = n10;
        } else {
            boolean bl5 = false;
        }
        Object object2 = this.mRecord.mManager.getFragments().iterator();
        while (bl3 = object2.hasNext()) {
            object = (Fragment)object2.next();
            bl2 = false;
            ((Fragment)object).setOnStartEnterTransitionListener(null);
            if (var1_4 == false || !(bl2 = ((Fragment)object).isPostponed())) continue;
            ((Fragment)object).startPostponedEnterTransition();
        }
        object2 = this.mRecord;
        object = ((BackStackRecord)object2).mManager;
        bl2 = this.mIsBack;
        boolean bl6 = var1_4 ^ n10;
        ((FragmentManager)object).completeExecute((BackStackRecord)object2, bl2, bl6, n10 != 0);
    }

    public boolean isReady() {
        int n10 = this.mNumPostponed;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void onStartEnterTransition() {
        int n10;
        this.mNumPostponed = n10 = this.mNumPostponed + -1;
        if (n10 != 0) {
            return;
        }
        this.mRecord.mManager.scheduleCommit();
    }

    public void startListening() {
        int n10;
        this.mNumPostponed = n10 = this.mNumPostponed + 1;
    }
}

