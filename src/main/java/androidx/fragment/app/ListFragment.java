/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.Animation
 *  android.view.animation.AnimationUtils
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.ProgressBar
 *  android.widget.TextView
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ListFragment
extends Fragment {
    public static final int INTERNAL_EMPTY_ID = 0xFF0001;
    public static final int INTERNAL_LIST_CONTAINER_ID = 0xFF0003;
    public static final int INTERNAL_PROGRESS_CONTAINER_ID = 0xFF0002;
    public ListAdapter mAdapter;
    public CharSequence mEmptyText;
    public View mEmptyView;
    private final Handler mHandler;
    public ListView mList;
    public View mListContainer;
    public boolean mListShown;
    private final AdapterView.OnItemClickListener mOnClickListener;
    public View mProgressContainer;
    private final Runnable mRequestFocus;
    public TextView mStandardEmptyView;

    public ListFragment() {
        Object object;
        this.mHandler = object = new Handler();
        super(this);
        this.mRequestFocus = object;
        super(this);
        this.mOnClickListener = object;
    }

    private void ensureList() {
        Object object = this.mList;
        if (object != null) {
            return;
        }
        object = this.getView();
        if (object != null) {
            boolean bl2;
            Object object2;
            int n10 = object instanceof ListView;
            if (n10 != 0) {
                this.mList = object;
            } else {
                n10 = 0xFF0001;
                this.mStandardEmptyView = object2 = (TextView)object.findViewById(n10);
                if (object2 == null) {
                    n10 = 16908292;
                    object2 = object.findViewById(n10);
                    this.mEmptyView = object2;
                } else {
                    int n11 = 8;
                    object2.setVisibility(n11);
                }
                object2 = object.findViewById(0xFF0002);
                this.mProgressContainer = object2;
                object2 = object.findViewById(0xFF0003);
                this.mListContainer = object2;
                object = object.findViewById(16908298);
                n10 = object instanceof ListView;
                if (n10 == 0) {
                    if (object == null) {
                        object = new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                        throw object;
                    }
                    object = new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                    throw object;
                }
                this.mList = object;
                object2 = this.mEmptyView;
                if (object2 != null) {
                    object.setEmptyView((View)object2);
                } else {
                    object = this.mEmptyText;
                    if (object != null) {
                        this.mStandardEmptyView.setText((CharSequence)object);
                        object = this.mList;
                        object2 = this.mStandardEmptyView;
                        object.setEmptyView((View)object2);
                    }
                }
            }
            this.mListShown = bl2 = true;
            object = this.mList;
            object2 = this.mOnClickListener;
            object.setOnItemClickListener((AdapterView.OnItemClickListener)object2);
            object = this.mAdapter;
            if (object != null) {
                n10 = 0;
                object2 = null;
                this.mAdapter = null;
                this.setListAdapter((ListAdapter)object);
            } else {
                object = this.mProgressContainer;
                if (object != null) {
                    bl2 = false;
                    object = null;
                    this.setListShown(false, false);
                }
            }
            object = this.mHandler;
            object2 = this.mRequestFocus;
            object.post((Runnable)object2);
            return;
        }
        object = new IllegalStateException("Content view not yet created");
        throw object;
    }

    private void setListShown(boolean n10, boolean bl2) {
        this.ensureList();
        View view = this.mProgressContainer;
        if (view != null) {
            int n11 = this.mListShown;
            if (n11 == n10) {
                return;
            }
            this.mListShown = n10;
            n11 = 8;
            int n12 = 0x10A0001;
            int n13 = 0x10A0000;
            if (n10) {
                Animation animation;
                if (bl2) {
                    animation = AnimationUtils.loadAnimation((Context)this.getContext(), (int)n12);
                    view.startAnimation(animation);
                    animation = this.mListContainer;
                    Animation animation2 = AnimationUtils.loadAnimation((Context)this.getContext(), (int)n13);
                    animation.startAnimation(animation2);
                } else {
                    view.clearAnimation();
                    animation = this.mListContainer;
                    animation.clearAnimation();
                }
                this.mProgressContainer.setVisibility(n11);
                animation = this.mListContainer;
                animation.setVisibility(0);
            } else {
                Animation animation;
                if (bl2) {
                    animation = AnimationUtils.loadAnimation((Context)this.getContext(), (int)n13);
                    view.startAnimation(animation);
                    animation = this.mListContainer;
                    Animation animation3 = AnimationUtils.loadAnimation((Context)this.getContext(), (int)n12);
                    animation.startAnimation(animation3);
                } else {
                    view.clearAnimation();
                    animation = this.mListContainer;
                    animation.clearAnimation();
                }
                this.mProgressContainer.setVisibility(0);
                animation = this.mListContainer;
                animation.setVisibility(n11);
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't be used with a custom content view");
        throw illegalStateException;
    }

    public ListAdapter getListAdapter() {
        return this.mAdapter;
    }

    public ListView getListView() {
        this.ensureList();
        return this.mList;
    }

    public long getSelectedItemId() {
        this.ensureList();
        return this.mList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        this.ensureList();
        return this.mList.getSelectedItemPosition();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = this.requireContext();
        viewGroup = new FrameLayout((Context)layoutInflater);
        bundle = new LinearLayout((Context)layoutInflater);
        bundle.setId(0xFF0002);
        bundle.setOrientation(1);
        bundle.setVisibility(8);
        int n10 = 17;
        bundle.setGravity(n10);
        ProgressBar progressBar = new ProgressBar((Context)layoutInflater, null, 16842874);
        int n11 = -2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n11, n11);
        bundle.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams);
        int n12 = -1;
        progressBar = new FrameLayout.LayoutParams(n12, n12);
        viewGroup.addView((View)bundle, (ViewGroup.LayoutParams)progressBar);
        bundle = new FrameLayout((Context)layoutInflater);
        bundle.setId(0xFF0003);
        progressBar = new TextView((Context)layoutInflater);
        progressBar.setId(0xFF0001);
        progressBar.setGravity(n10);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(n12, n12);
        bundle.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams2);
        layoutParams2 = new ListView((Context)layoutInflater);
        layoutParams2.setId(16908298);
        layoutParams2.setDrawSelectorOnTop(false);
        layoutInflater = new FrameLayout.LayoutParams(n12, n12);
        bundle.addView((View)layoutParams2, (ViewGroup.LayoutParams)layoutInflater);
        layoutInflater = new FrameLayout.LayoutParams(n12, n12);
        viewGroup.addView((View)bundle, (ViewGroup.LayoutParams)layoutInflater);
        layoutInflater = new FrameLayout.LayoutParams(n12, n12);
        viewGroup.setLayoutParams((ViewGroup.LayoutParams)layoutInflater);
        return viewGroup;
    }

    public void onDestroyView() {
        Handler handler = this.mHandler;
        Runnable runnable = this.mRequestFocus;
        handler.removeCallbacks(runnable);
        this.mList = null;
        this.mListShown = false;
        this.mListContainer = null;
        this.mProgressContainer = null;
        this.mEmptyView = null;
        this.mStandardEmptyView = null;
        super.onDestroyView();
    }

    public void onListItemClick(ListView listView, View view, int n10, long l10) {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.ensureList();
    }

    public final ListAdapter requireListAdapter() {
        Object object = this.getListAdapter();
        if (object != null) {
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("ListFragment ");
        charSequence.append(this);
        charSequence.append(" does not have a ListAdapter.");
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public void setEmptyText(CharSequence object) {
        this.ensureList();
        Object object2 = this.mStandardEmptyView;
        if (object2 != null) {
            object2.setText((CharSequence)object);
            object2 = this.mEmptyText;
            if (object2 == null) {
                object2 = this.mList;
                TextView textView = this.mStandardEmptyView;
                object2.setEmptyView((View)textView);
            }
            this.mEmptyText = object;
            return;
        }
        object = new IllegalStateException("Can't be used with a custom content view");
        throw object;
    }

    public void setListAdapter(ListAdapter listAdapter) {
        boolean bl2;
        ListAdapter listAdapter2 = this.mAdapter;
        boolean bl3 = false;
        boolean bl4 = true;
        if (listAdapter2 != null) {
            bl2 = bl4;
        } else {
            bl2 = false;
            listAdapter2 = null;
        }
        this.mAdapter = listAdapter;
        ListView listView = this.mList;
        if (listView != null) {
            listView.setAdapter(listAdapter);
            boolean bl5 = this.mListShown;
            if (!bl5 && !bl2) {
                listAdapter = this.requireView().getWindowToken();
                if (listAdapter != null) {
                    bl3 = bl4;
                }
                this.setListShown(bl4, bl3);
            }
        }
    }

    public void setListShown(boolean bl2) {
        this.setListShown(bl2, true);
    }

    public void setListShownNoAnimation(boolean bl2) {
        this.setListShown(bl2, false);
    }

    public void setSelection(int n10) {
        this.ensureList();
        this.mList.setSelection(n10);
    }
}

