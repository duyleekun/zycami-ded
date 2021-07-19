/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentLayoutInflaterFactory$1;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;

public class FragmentLayoutInflaterFactory
implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public View onCreateView(View object, String object2, Context object3, AttributeSet object4) {
        block18: {
            int n10;
            String string2;
            int n11;
            block21: {
                String string3;
                Object object5;
                block20: {
                    boolean bl2;
                    int n12;
                    String string4;
                    Object object6;
                    block19: {
                        object5 = FragmentContainerView.class.getName();
                        boolean bl3 = ((String)object5).equals(object2);
                        if (bl3) {
                            object2 = this.mFragmentManager;
                            object = new FragmentContainerView((Context)object3, (AttributeSet)object4, (FragmentManager)object2);
                            return object;
                        }
                        int n13 = "fragment".equals(object2);
                        bl3 = false;
                        object5 = null;
                        if (n13 == 0) {
                            return null;
                        }
                        object2 = object4.getAttributeValue(null, "class");
                        object6 = R$styleable.Fragment;
                        object6 = object3.obtainStyledAttributes((AttributeSet)object4, object6);
                        if (object2 == null) {
                            n13 = R$styleable.Fragment_android_name;
                            object2 = object6.getString(n13);
                        }
                        n11 = R$styleable.Fragment_android_id;
                        int n14 = -1;
                        n11 = object6.getResourceId(n11, n14);
                        int n15 = R$styleable.Fragment_android_tag;
                        string2 = object6.getString(n15);
                        object6.recycle();
                        if (object2 == null || (n10 = FragmentFactory.isFragmentClass((ClassLoader)(object6 = (Object)object3.getClassLoader()), (String)object2)) == 0) break block18;
                        if (object != null) {
                            n10 = object.getId();
                        } else {
                            n10 = 0;
                            object6 = null;
                        }
                        if (n10 == n14 && n11 == n14 && string2 == null) {
                            object3 = new StringBuilder();
                            object4 = object4.getPositionDescription();
                            ((StringBuilder)object3).append((String)object4);
                            ((StringBuilder)object3).append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
                            ((StringBuilder)object3).append((String)object2);
                            object2 = ((StringBuilder)object3).toString();
                            object = new IllegalArgumentException((String)object2);
                            throw object;
                        }
                        if (n11 != n14) {
                            object5 = this.mFragmentManager.findFragmentById(n11);
                        }
                        if (object5 == null && string2 != null) {
                            object5 = this.mFragmentManager.findFragmentByTag(string2);
                        }
                        if (object5 == null && n10 != n14) {
                            object5 = this.mFragmentManager.findFragmentById(n10);
                        }
                        string3 = "Fragment ";
                        string4 = TAG;
                        n12 = 2;
                        bl2 = true;
                        if (object5 != null) break block19;
                        object5 = this.mFragmentManager.getFragmentFactory();
                        object3 = object3.getClassLoader();
                        object5 = ((FragmentFactory)object5).instantiate((ClassLoader)object3, (String)object2);
                        ((Fragment)object5).mFromLayout = bl2;
                        int n16 = n11 != 0 ? n11 : n10;
                        ((Fragment)object5).mFragmentId = n16;
                        ((Fragment)object5).mContainerId = n10;
                        ((Fragment)object5).mTag = string2;
                        ((Fragment)object5).mInLayout = bl2;
                        ((Fragment)object5).mFragmentManager = object3 = this.mFragmentManager;
                        ((Fragment)object5).mHost = object3 = ((FragmentManager)object3).getHost();
                        object3 = this.mFragmentManager.getHost().getContext();
                        object6 = ((Fragment)object5).mSavedFragmentState;
                        ((Fragment)object5).onInflate((Context)object3, (AttributeSet)object4, (Bundle)object6);
                        object3 = this.mFragmentManager.addFragment((Fragment)object5);
                        boolean bl4 = FragmentManager.isLoggingEnabled(n12);
                        if (bl4) {
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append(string3);
                            ((StringBuilder)object4).append(object5);
                            ((StringBuilder)object4).append(" has been inflated via the <fragment> tag: id=0x");
                            object6 = Integer.toHexString(n11);
                            ((StringBuilder)object4).append((String)object6);
                            object4 = ((StringBuilder)object4).toString();
                            Log.v((String)string4, (String)object4);
                        }
                        break block20;
                    }
                    boolean bl5 = ((Fragment)object5).mInLayout;
                    if (bl5) break block21;
                    ((Fragment)object5).mInLayout = bl2;
                    ((Fragment)object5).mFragmentManager = object3 = this.mFragmentManager;
                    ((Fragment)object5).mHost = object3 = ((FragmentManager)object3).getHost();
                    object3 = this.mFragmentManager.getHost().getContext();
                    object6 = ((Fragment)object5).mSavedFragmentState;
                    ((Fragment)object5).onInflate((Context)object3, (AttributeSet)object4, (Bundle)object6);
                    object3 = this.mFragmentManager.createOrGetFragmentStateManager((Fragment)object5);
                    boolean bl6 = FragmentManager.isLoggingEnabled(n12);
                    if (bl6) {
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("Retained Fragment ");
                        ((StringBuilder)object4).append(object5);
                        ((StringBuilder)object4).append(" has been re-attached via the <fragment> tag: id=0x");
                        object6 = Integer.toHexString(n11);
                        ((StringBuilder)object4).append((String)object6);
                        object4 = ((StringBuilder)object4).toString();
                        Log.v((String)string4, (String)object4);
                    }
                }
                object = (ViewGroup)object;
                ((Fragment)object5).mContainer = object;
                ((FragmentStateManager)object3).moveToExpectedState();
                ((FragmentStateManager)object3).ensureInflatedView();
                object = ((Fragment)object5).mView;
                if (object != null) {
                    if (n11 != 0) {
                        object.setId(n11);
                    }
                    if ((object = ((Fragment)object5).mView.getTag()) == null) {
                        object = ((Fragment)object5).mView;
                        object.setTag((Object)string2);
                    }
                    object = ((Fragment)object5).mView;
                    object2 = new FragmentLayoutInflaterFactory$1(this, (FragmentStateManager)object3);
                    object.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)object2);
                    return ((Fragment)object5).mView;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(" did not create a view.");
                object2 = ((StringBuilder)object3).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object3 = new StringBuilder();
            object4 = object4.getPositionDescription();
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(": Duplicate id 0x");
            object4 = Integer.toHexString(n11);
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(", tag ");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(", or parent id 0x");
            object4 = Integer.toHexString(n10);
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(" with another fragment for ");
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        return null;
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string2, context, attributeSet);
    }
}

