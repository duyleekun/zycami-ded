/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle$State;

public final class FragmentTransaction$Op {
    public int mCmd;
    public Lifecycle$State mCurrentMaxState;
    public int mEnterAnim;
    public int mExitAnim;
    public Fragment mFragment;
    public Lifecycle$State mOldMaxState;
    public int mPopEnterAnim;
    public int mPopExitAnim;

    public FragmentTransaction$Op() {
    }

    public FragmentTransaction$Op(int n10, Fragment fragment) {
        Lifecycle$State lifecycle$State;
        this.mCmd = n10;
        this.mFragment = fragment;
        this.mOldMaxState = lifecycle$State = Lifecycle$State.RESUMED;
        this.mCurrentMaxState = lifecycle$State;
    }

    public FragmentTransaction$Op(int n10, Fragment fragment, Lifecycle$State lifecycle$State) {
        Lifecycle$State lifecycle$State2;
        this.mCmd = n10;
        this.mFragment = fragment;
        this.mOldMaxState = lifecycle$State2 = fragment.mMaxState;
        this.mCurrentMaxState = lifecycle$State;
    }
}

