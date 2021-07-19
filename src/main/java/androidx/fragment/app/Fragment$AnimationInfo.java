/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.View
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.view.View;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$OnStartEnterTransitionListener;
import java.util.ArrayList;

public class Fragment$AnimationInfo {
    public Boolean mAllowEnterTransitionOverlap;
    public Boolean mAllowReturnTransitionOverlap;
    public View mAnimatingAway;
    public Animator mAnimator;
    public int mEnterAnim;
    public Object mEnterTransition = null;
    public SharedElementCallback mEnterTransitionCallback;
    public boolean mEnterTransitionPostponed;
    public int mExitAnim;
    public Object mExitTransition;
    public SharedElementCallback mExitTransitionCallback;
    public View mFocusedView;
    public boolean mIsHideReplaced;
    public boolean mIsPop;
    public int mNextTransition;
    public int mPopEnterAnim;
    public int mPopExitAnim;
    public float mPostOnViewCreatedAlpha;
    public Object mReenterTransition;
    public Object mReturnTransition;
    public Object mSharedElementEnterTransition;
    public Object mSharedElementReturnTransition;
    public ArrayList mSharedElementSourceNames;
    public ArrayList mSharedElementTargetNames;
    public Fragment.OnStartEnterTransitionListener mStartEnterTransitionListener;

    public Fragment$AnimationInfo() {
        Object object;
        this.mReturnTransition = object = Fragment.USE_DEFAULT_TRANSITION;
        this.mExitTransition = null;
        this.mReenterTransition = object;
        this.mSharedElementEnterTransition = null;
        this.mSharedElementReturnTransition = object;
        this.mEnterTransitionCallback = null;
        this.mExitTransitionCallback = null;
        this.mPostOnViewCreatedAlpha = 1.0f;
        this.mFocusedView = null;
    }
}

