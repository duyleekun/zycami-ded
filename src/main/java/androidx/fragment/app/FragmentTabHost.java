/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TabHost
 *  android.widget.TabHost$OnTabChangeListener
 *  android.widget.TabHost$TabContentFactory
 *  android.widget.TabHost$TabSpec
 *  android.widget.TabWidget
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTabHost$DummyTabFactory;
import androidx.fragment.app.FragmentTabHost$SavedState;
import androidx.fragment.app.FragmentTabHost$TabInfo;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

public class FragmentTabHost
extends TabHost
implements TabHost.OnTabChangeListener {
    private boolean mAttached;
    private int mContainerId;
    private Context mContext;
    private FragmentManager mFragmentManager;
    private FragmentTabHost$TabInfo mLastTab;
    private TabHost.OnTabChangeListener mOnTabChangeListener;
    private FrameLayout mRealTabContent;
    private final ArrayList mTabs;

    public FragmentTabHost(Context context) {
        super(context, null);
        ArrayList arrayList;
        this.mTabs = arrayList = new ArrayList();
        this.initFragmentTabHost(context, null);
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList arrayList;
        this.mTabs = arrayList = new ArrayList();
        this.initFragmentTabHost(context, attributeSet);
    }

    private FragmentTransaction doTabChanged(String object, FragmentTransaction fragmentTransaction) {
        Object object2 = this.mLastTab;
        if (object2 != (object = this.getTabInfoForTag((String)object))) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            if ((object2 = this.mLastTab) != null && (object2 = ((FragmentTabHost$TabInfo)object2).fragment) != null) {
                fragmentTransaction.detach((Fragment)object2);
            }
            if (object != null) {
                object2 = ((FragmentTabHost$TabInfo)object).fragment;
                if (object2 == null) {
                    object2 = this.mFragmentManager.getFragmentFactory();
                    Object object3 = this.mContext.getClassLoader();
                    String string2 = ((FragmentTabHost$TabInfo)object).clss.getName();
                    ((FragmentTabHost$TabInfo)object).fragment = object2 = ((FragmentFactory)object2).instantiate((ClassLoader)object3, string2);
                    object3 = ((FragmentTabHost$TabInfo)object).args;
                    ((Fragment)object2).setArguments((Bundle)object3);
                    int n10 = this.mContainerId;
                    object3 = ((FragmentTabHost$TabInfo)object).fragment;
                    string2 = ((FragmentTabHost$TabInfo)object).tag;
                    fragmentTransaction.add(n10, (Fragment)object3, string2);
                } else {
                    fragmentTransaction.attach((Fragment)object2);
                }
            }
            this.mLastTab = object;
        }
        return fragmentTransaction;
    }

    private void ensureContent() {
        Object object = this.mRealTabContent;
        if (object == null) {
            int n10 = this.mContainerId;
            this.mRealTabContent = object = (FrameLayout)this.findViewById(n10);
            if (object == null) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("No tab content FrameLayout found for id ");
                int n11 = this.mContainerId;
                charSequence.append(n11);
                charSequence = charSequence.toString();
                object = new IllegalStateException((String)charSequence);
                throw object;
            }
        }
    }

    private void ensureHierarchy(Context context) {
        int n10 = 16908307;
        View view = this.findViewById(n10);
        if (view == null) {
            view = new LinearLayout(context);
            int n11 = 1;
            view.setOrientation(n11);
            int n12 = -1;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n12, n12);
            this.addView(view, (ViewGroup.LayoutParams)layoutParams);
            layoutParams = new TabWidget(context);
            layoutParams.setId(n10);
            n10 = 0;
            layoutParams.setOrientation(0);
            int n13 = -2;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(n12, n13, 0.0f);
            view.addView((View)layoutParams, (ViewGroup.LayoutParams)layoutParams2);
            layoutParams = new FrameLayout(context);
            layoutParams.setId(0x1020011);
            layoutParams2 = new LinearLayout.LayoutParams(0, 0, 0.0f);
            view.addView((View)layoutParams, (ViewGroup.LayoutParams)layoutParams2);
            layoutParams = new FrameLayout(context);
            this.mRealTabContent = layoutParams;
            int n14 = this.mContainerId;
            layoutParams.setId(n14);
            float f10 = 1.0f;
            context = new LinearLayout.LayoutParams(n12, 0, f10);
            view.addView((View)layoutParams, (ViewGroup.LayoutParams)context);
        }
    }

    private FragmentTabHost$TabInfo getTabInfoForTag(String string2) {
        ArrayList arrayList = this.mTabs;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            FragmentTabHost$TabInfo fragmentTabHost$TabInfo = (FragmentTabHost$TabInfo)this.mTabs.get(i10);
            String string3 = fragmentTabHost$TabInfo.tag;
            boolean bl2 = string3.equals(string2);
            if (!bl2) continue;
            return fragmentTabHost$TabInfo;
        }
        return null;
    }

    private void initFragmentTabHost(Context context, AttributeSet attributeSet) {
        int n10;
        int[] nArray = new int[]{16842995};
        context = context.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        this.mContainerId = n10 = context.getResourceId(0, 0);
        context.recycle();
        super.setOnTabChangedListener((TabHost.OnTabChangeListener)this);
    }

    public void addTab(TabHost.TabSpec tabSpec, Class object, Bundle object2) {
        Object object3 = this.mContext;
        Object object4 = new FragmentTabHost$DummyTabFactory((Context)object3);
        tabSpec.setContent((TabHost.TabContentFactory)object4);
        object4 = tabSpec.getTag();
        object3 = new FragmentTabHost$TabInfo((String)object4, (Class)object, (Bundle)object2);
        boolean bl2 = this.mAttached;
        if (bl2) {
            object3.fragment = object = this.mFragmentManager.findFragmentByTag((String)object4);
            if (object != null && !(bl2 = ((Fragment)object).isDetached())) {
                object = this.mFragmentManager.beginTransaction();
                object2 = object3.fragment;
                ((FragmentTransaction)object).detach((Fragment)object2);
                ((FragmentTransaction)object).commit();
            }
        }
        this.mTabs.add(object3);
        this.addTab(tabSpec);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object object = this.getCurrentTabTag();
        ArrayList arrayList = this.mTabs;
        int n10 = arrayList.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Object object2 = (FragmentTabHost$TabInfo)this.mTabs.get(i10);
            Object object3 = this.mFragmentManager;
            String string2 = ((FragmentTabHost$TabInfo)object2).tag;
            ((FragmentTabHost$TabInfo)object2).fragment = object3 = ((FragmentManager)object3).findFragmentByTag(string2);
            if (object3 == null || (bl2 = ((Fragment)object3).isDetached())) continue;
            object3 = ((FragmentTabHost$TabInfo)object2).tag;
            bl2 = ((String)object3).equals(object);
            if (bl2) {
                this.mLastTab = object2;
                continue;
            }
            if (fragmentTransaction == null) {
                fragmentTransaction = this.mFragmentManager.beginTransaction();
            }
            object2 = ((FragmentTabHost$TabInfo)object2).fragment;
            fragmentTransaction.detach((Fragment)object2);
        }
        n10 = 1;
        this.mAttached = n10;
        if ((object = this.doTabChanged((String)object, fragmentTransaction)) != null) {
            ((FragmentTransaction)object).commit();
            object = this.mFragmentManager;
            ((FragmentManager)object).executePendingTransactions();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
    }

    public void onRestoreInstanceState(Parcelable object) {
        boolean bl2 = object instanceof FragmentTabHost$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (FragmentTabHost$SavedState)((Object)object);
        Parcelable parcelable = object.getSuperState();
        super.onRestoreInstanceState(parcelable);
        object = object.curTab;
        this.setCurrentTabByTag((String)object);
    }

    public Parcelable onSaveInstanceState() {
        Object object = super.onSaveInstanceState();
        FragmentTabHost$SavedState fragmentTabHost$SavedState = new FragmentTabHost$SavedState((Parcelable)object);
        object = this.getCurrentTabTag();
        fragmentTabHost$SavedState.curTab = object;
        return fragmentTabHost$SavedState;
    }

    public void onTabChanged(String string2) {
        Object object;
        boolean bl2 = this.mAttached;
        if (bl2) {
            bl2 = false;
            object = this.doTabChanged(string2, null);
            if (object != null) {
                ((FragmentTransaction)object).commit();
            }
        }
        if ((object = this.mOnTabChangeListener) != null) {
            object.onTabChanged(string2);
        }
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.mOnTabChangeListener = onTabChangeListener;
    }

    public void setup() {
        IllegalStateException illegalStateException = new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
        throw illegalStateException;
    }

    public void setup(Context context, FragmentManager fragmentManager) {
        this.ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.ensureContent();
    }

    public void setup(Context context, FragmentManager fragmentManager, int n10) {
        this.ensureHierarchy(context);
        super.setup();
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = n10;
        this.ensureContent();
        context = this.mRealTabContent;
        context.setId(n10);
        int n11 = this.getId();
        int n12 = -1;
        if (n11 == n12) {
            n11 = 0x1020012;
            this.setId(n11);
        }
    }
}

