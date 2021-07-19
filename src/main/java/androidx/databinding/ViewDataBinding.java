/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.LongSparseArray
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 *  android.util.SparseLongArray
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 */
package androidx.databinding;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.databinding.BaseObservable;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.CallbackRegistry$NotifierCallback;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.Observable;
import androidx.databinding.Observable$OnPropertyChangedCallback;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.OnRebindCallback;
import androidx.databinding.ViewDataBinding$6;
import androidx.databinding.ViewDataBinding$7;
import androidx.databinding.ViewDataBinding$CreateWeakListener;
import androidx.databinding.ViewDataBinding$IncludedLayouts;
import androidx.databinding.ViewDataBinding$OnStartListener;
import androidx.databinding.ViewDataBinding$PropertyChangedInverseListener;
import androidx.databinding.ViewDataBinding$WeakListener;
import androidx.databinding.library.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;

public abstract class ViewDataBinding
extends BaseObservable
implements ViewBinding {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final ViewDataBinding$CreateWeakListener CREATE_LIST_LISTENER;
    private static final ViewDataBinding$CreateWeakListener CREATE_LIVE_DATA_LISTENER;
    private static final ViewDataBinding$CreateWeakListener CREATE_MAP_LISTENER;
    private static final ViewDataBinding$CreateWeakListener CREATE_PROPERTY_LISTENER;
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final CallbackRegistry$NotifierCallback REBIND_NOTIFIER;
    private static final int REBOUND = 3;
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    public static int SDK_INT;
    private static final boolean USE_CHOREOGRAPHER;
    private static final ReferenceQueue sReferenceQueue;
    public final DataBindingComponent mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private LifecycleOwner mLifecycleOwner;
    private ViewDataBinding$WeakListener[] mLocalFieldObservers;
    private ViewDataBinding$OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private CallbackRegistry mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;

    static {
        ReferenceQueue referenceQueue;
        int n10;
        SDK_INT = n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            n11 = 1;
        } else {
            n11 = 0;
            referenceQueue = null;
        }
        USE_CHOREOGRAPHER = n11;
        referenceQueue = new ReferenceQueue();
        CREATE_PROPERTY_LISTENER = referenceQueue;
        referenceQueue = new ReferenceQueue();
        CREATE_LIST_LISTENER = referenceQueue;
        referenceQueue = new ReferenceQueue();
        CREATE_MAP_LISTENER = referenceQueue;
        referenceQueue = new ReferenceQueue();
        CREATE_LIVE_DATA_LISTENER = referenceQueue;
        referenceQueue = new ReferenceQueue();
        REBIND_NOTIFIER = referenceQueue;
        sReferenceQueue = referenceQueue = new ReferenceQueue();
        n11 = 19;
        if (n10 < n11) {
            n10 = 0;
            Object var3_3 = null;
            ROOT_REATTACHED_LISTENER = null;
        } else {
            ViewDataBinding$6 viewDataBinding$6 = new ViewDataBinding$6();
            ROOT_REATTACHED_LISTENER = viewDataBinding$6;
        }
    }

    public ViewDataBinding(DataBindingComponent object, View view, int n10) {
        ViewDataBinding$7 viewDataBinding$7 = new ViewDataBinding$7(this);
        this.mRebindRunnable = viewDataBinding$7;
        viewDataBinding$7 = null;
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = object;
        object = new ViewDataBinding$WeakListener[n10];
        this.mLocalFieldObservers = object;
        this.mRoot = view;
        object = Looper.myLooper();
        if (object != null) {
            boolean bl2 = USE_CHOREOGRAPHER;
            if (bl2) {
                object = Choreographer.getInstance();
                this.mChoreographer = object;
                super(this);
                this.mFrameCallback = object;
            } else {
                bl2 = false;
                this.mFrameCallback = null;
                view = Looper.myLooper();
                super((Looper)view);
                this.mUIThreadHandler = object;
            }
            return;
        }
        super("DataBinding must be created in view's UI Thread");
        throw object;
    }

    public ViewDataBinding(Object object, View view, int n10) {
        object = ViewDataBinding.checkAndCastToBindingComponent(object);
        this((DataBindingComponent)object, view, n10);
    }

    public static /* synthetic */ boolean access$002(ViewDataBinding viewDataBinding, boolean bl2) {
        viewDataBinding.mRebindHalted = bl2;
        return bl2;
    }

    public static /* synthetic */ Runnable access$100(ViewDataBinding viewDataBinding) {
        return viewDataBinding.mRebindRunnable;
    }

    public static /* synthetic */ boolean access$202(ViewDataBinding viewDataBinding, boolean bl2) {
        viewDataBinding.mPendingRebind = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$300() {
        ViewDataBinding.processReferenceQueue();
    }

    public static /* synthetic */ View access$400(ViewDataBinding viewDataBinding) {
        return viewDataBinding.mRoot;
    }

    public static /* synthetic */ View.OnAttachStateChangeListener access$500() {
        return ROOT_REATTACHED_LISTENER;
    }

    public static /* synthetic */ ReferenceQueue access$700() {
        return sReferenceQueue;
    }

    public static /* synthetic */ void access$800(ViewDataBinding viewDataBinding, int n10, Object object, int n11) {
        viewDataBinding.handleFieldChange(n10, object, n11);
    }

    public static ViewDataBinding bind(Object object, View view, int n10) {
        return DataBindingUtil.bind(ViewDataBinding.checkAndCastToBindingComponent(object), view, n10);
    }

    private static DataBindingComponent checkAndCastToBindingComponent(Object object) {
        if (object == null) {
            return null;
        }
        boolean bl2 = object instanceof DataBindingComponent;
        if (bl2) {
            return (DataBindingComponent)object;
        }
        object = new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
        throw object;
    }

    private void executeBindingsInternal() {
        int n10;
        CallbackRegistry callbackRegistry;
        int n11 = (int)(this.mIsExecutingPendingBindings ? 1 : 0);
        if (n11 != 0) {
            this.requestRebind();
            return;
        }
        n11 = this.hasPendingBindings();
        if (n11 == 0) {
            return;
        }
        n11 = 1;
        this.mIsExecutingPendingBindings = n11;
        this.mRebindHalted = false;
        CallbackRegistry callbackRegistry2 = this.mRebindCallbacks;
        if (callbackRegistry2 != null) {
            callbackRegistry2.notifyCallbacks(this, n11, null);
            n11 = (int)(this.mRebindHalted ? 1 : 0);
            if (n11 != 0) {
                callbackRegistry = this.mRebindCallbacks;
                n10 = 2;
                callbackRegistry.notifyCallbacks(this, n10, null);
            }
        }
        if ((n11 = this.mRebindHalted) == 0) {
            this.executeBindings();
            callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                n10 = 3;
                callbackRegistry.notifyCallbacks(this, n10, null);
            }
        }
        this.mIsExecutingPendingBindings = false;
    }

    public static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String charSequence, int n10, ViewDataBinding$IncludedLayouts stringArray, int n11) {
        int n12 = charSequence.indexOf(47) + 1;
        int n13 = charSequence.length() + -2;
        charSequence = charSequence.subSequence(n12, n13);
        stringArray = stringArray.layouts[n11];
        n11 = stringArray.length;
        while (n10 < n11) {
            String string2 = stringArray[n10];
            n12 = (int)(TextUtils.equals((CharSequence)charSequence, (CharSequence)string2) ? 1 : 0);
            if (n12 != 0) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int n10) {
        String string2 = (String)viewGroup.getChildAt(n10).getTag();
        int n11 = string2.length() + -1;
        String string3 = string2.substring(0, n11);
        int n12 = string3.length();
        int n13 = viewGroup.getChildCount();
        for (int i10 = n10 + 1; i10 < n13; ++i10) {
            int n14;
            boolean bl2;
            Object object = viewGroup.getChildAt(i10);
            Object object2 = object.getTag();
            int n15 = object2 instanceof String;
            if (n15 != 0) {
                object = (String)object.getTag();
            } else {
                bl2 = false;
                object = null;
            }
            if (object == null || (n15 = ((String)object).startsWith(string3)) == 0) continue;
            n15 = ((String)object).length();
            if (n15 == (n14 = string2.length())) {
                n15 = ((String)object).length() + -1;
                if ((n15 = (int)((String)object).charAt(n15)) == (n14 = 48)) {
                    return n10;
                }
            }
            if (!(bl2 = ViewDataBinding.isNumeric((String)object, n12))) continue;
            n10 = i10;
        }
        return n10;
    }

    public static ViewDataBinding getBinding(View view) {
        if (view != null) {
            int n10 = R$id.dataBinding;
            return (ViewDataBinding)view.getTag(n10);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public static int getColorFromResource(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return view.getContext().getColor(n10);
        }
        return view.getResources().getColor(n10);
    }

    public static ColorStateList getColorStateListFromResource(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return view.getContext().getColorStateList(n10);
        }
        return view.getResources().getColorStateList(n10);
    }

    public static Drawable getDrawableFromResource(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return view.getContext().getDrawable(n10);
        }
        return view.getResources().getDrawable(n10);
    }

    public static Object getFrom(Map map, Object object) {
        if (map == null) {
            return null;
        }
        return map.get(object);
    }

    public static byte getFromArray(byte[] byArray, int n10) {
        int n11;
        if (byArray != null && n10 >= 0 && n10 < (n11 = byArray.length)) {
            return byArray[n10];
        }
        return 0;
    }

    public static char getFromArray(char[] cArray, int n10) {
        int n11;
        if (cArray != null && n10 >= 0 && n10 < (n11 = cArray.length)) {
            return cArray[n10];
        }
        return '\u0000';
    }

    public static double getFromArray(double[] dArray, int n10) {
        int n11;
        if (dArray != null && n10 >= 0 && n10 < (n11 = dArray.length)) {
            return dArray[n10];
        }
        return 0.0;
    }

    public static float getFromArray(float[] fArray, int n10) {
        int n11;
        if (fArray != null && n10 >= 0 && n10 < (n11 = fArray.length)) {
            return fArray[n10];
        }
        return 0.0f;
    }

    public static int getFromArray(int[] nArray, int n10) {
        int n11;
        if (nArray != null && n10 >= 0 && n10 < (n11 = nArray.length)) {
            return nArray[n10];
        }
        return 0;
    }

    public static long getFromArray(long[] lArray, int n10) {
        int n11;
        if (lArray != null && n10 >= 0 && n10 < (n11 = lArray.length)) {
            return lArray[n10];
        }
        return 0L;
    }

    public static Object getFromArray(Object[] objectArray, int n10) {
        int n11;
        if (objectArray != null && n10 >= 0 && n10 < (n11 = objectArray.length)) {
            return objectArray[n10];
        }
        return null;
    }

    public static short getFromArray(short[] sArray, int n10) {
        int n11;
        if (sArray != null && n10 >= 0 && n10 < (n11 = sArray.length)) {
            return sArray[n10];
        }
        return 0;
    }

    public static boolean getFromArray(boolean[] blArray, int n10) {
        int n11;
        if (blArray != null && n10 >= 0 && n10 < (n11 = blArray.length)) {
            return blArray[n10];
        }
        return false;
    }

    public static int getFromList(SparseIntArray sparseIntArray, int n10) {
        if (sparseIntArray != null && n10 >= 0) {
            return sparseIntArray.get(n10);
        }
        return 0;
    }

    public static long getFromList(SparseLongArray sparseLongArray, int n10) {
        if (sparseLongArray != null && n10 >= 0) {
            return sparseLongArray.get(n10);
        }
        return 0L;
    }

    public static Object getFromList(android.util.LongSparseArray longSparseArray, int n10) {
        if (longSparseArray != null && n10 >= 0) {
            long l10 = n10;
            return longSparseArray.get(l10);
        }
        return null;
    }

    public static Object getFromList(SparseArray sparseArray, int n10) {
        if (sparseArray != null && n10 >= 0) {
            return sparseArray.get(n10);
        }
        return null;
    }

    public static Object getFromList(LongSparseArray longSparseArray, int n10) {
        if (longSparseArray != null && n10 >= 0) {
            long l10 = n10;
            return longSparseArray.get(l10);
        }
        return null;
    }

    public static Object getFromList(List list, int n10) {
        int n11;
        if (list != null && n10 >= 0 && n10 < (n11 = list.size())) {
            return list.get(n10);
        }
        return null;
    }

    public static boolean getFromList(SparseBooleanArray sparseBooleanArray, int n10) {
        if (sparseBooleanArray != null && n10 >= 0) {
            return sparseBooleanArray.get(n10);
        }
        return false;
    }

    private void handleFieldChange(int n10, Object object, int n11) {
        boolean bl2 = this.mInLiveDataRegisterObserver;
        if (bl2) {
            return;
        }
        if ((n10 = (int)(this.onFieldChange(n10, object, n11) ? 1 : 0)) != 0) {
            this.requestRebind();
        }
    }

    public static ViewDataBinding inflateInternal(LayoutInflater layoutInflater, int n10, ViewGroup viewGroup, boolean bl2, Object object) {
        object = ViewDataBinding.checkAndCastToBindingComponent(object);
        return DataBindingUtil.inflate(layoutInflater, n10, viewGroup, bl2, (DataBindingComponent)object);
    }

    private static boolean isNumeric(String string2, int n10) {
        int n11 = string2.length();
        if (n11 == n10) {
            return false;
        }
        while (n10 < n11) {
            boolean bl2 = Character.isDigit(string2.charAt(n10));
            if (!bl2) {
                return false;
            }
            ++n10;
        }
        return true;
    }

    private static void mapBindings(DataBindingComponent dataBindingComponent, View view, Object[] objectArray, ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts, SparseIntArray sparseIntArray, boolean bl2) {
        Object[] objectArray2;
        int n10;
        Object object;
        Object object2;
        int n11;
        int n12;
        DataBindingComponent dataBindingComponent2 = dataBindingComponent;
        Object object3 = view;
        ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts2 = viewDataBinding$IncludedLayouts;
        SparseIntArray sparseIntArray2 = sparseIntArray;
        Object object4 = ViewDataBinding.getBinding(view);
        if (object4 != null) {
            return;
        }
        object4 = view.getTag();
        int n13 = object4 instanceof String;
        if (n13 != 0) {
            object4 = (String)object4;
        } else {
            n12 = 0;
            object4 = null;
        }
        String string2 = "layout";
        n13 = -1;
        int n14 = 1;
        float f10 = Float.MIN_VALUE;
        if (bl2 && object4 != null && (n11 = ((String)object4).startsWith(string2)) != 0) {
            n11 = ((String)object4).lastIndexOf(95);
            if (n11 > 0 && (object2 = ViewDataBinding.isNumeric((String)object4, n11 += n14)) != 0) {
                n12 = ViewDataBinding.parseTagInt((String)object4, n11);
                object = objectArray[n12];
                if (object == null) {
                    objectArray[n12] = object3;
                }
                if (viewDataBinding$IncludedLayouts2 == null) {
                    n12 = n13;
                }
                n11 = n14;
            } else {
                n12 = n13;
                n11 = 0;
                object = null;
            }
            n10 = n12;
        } else if (object4 != null && (n11 = ((String)object4).startsWith((String)(object = BINDING_TAG_PREFIX))) != 0) {
            n11 = BINDING_NUMBER_START;
            n12 = ViewDataBinding.parseTagInt((String)object4, n11);
            object = objectArray[n12];
            if (object == null) {
                objectArray[n12] = object3;
            }
            if (viewDataBinding$IncludedLayouts2 == null) {
                n12 = n13;
            }
            n10 = n12;
            n11 = n14;
        } else {
            n10 = n13;
            n11 = 0;
            object = null;
        }
        if (n11 == 0 && (n12 = view.getId()) > 0 && sparseIntArray2 != null && (n12 = sparseIntArray2.get(n12, n13)) >= 0 && (objectArray2 = objectArray[n12]) == null) {
            objectArray[n12] = object3;
        }
        if ((n12 = object3 instanceof ViewGroup) != 0) {
            View view2 = object3;
            view2 = (ViewGroup)object3;
            int n15 = view2.getChildCount();
            int n16 = 0;
            float f11 = 0.0f;
            object3 = null;
            n12 = 0;
            object4 = null;
            while (n16 < n15) {
                int n17;
                int n18;
                int[] nArray;
                Object object5;
                objectArray2 = view2.getChildAt(n16);
                if (n10 >= 0 && (n11 = (object = objectArray2.getTag()) instanceof String) != 0 && (object2 = ((String)(object = (String)objectArray2.getTag())).endsWith((String)(object5 = "_0"))) != 0 && (object2 = ((String)object).startsWith(string2)) != 0 && (object2 = ((String)object).indexOf(47)) > 0 && (n11 = ViewDataBinding.findIncludeIndex((String)object, n12, viewDataBinding$IncludedLayouts2, n10)) >= 0) {
                    n12 = n11 + 1;
                    object5 = viewDataBinding$IncludedLayouts2.indexes[n10];
                    object2 = object5[n11];
                    nArray = viewDataBinding$IncludedLayouts2.layoutIds[n10];
                    n11 = nArray[n11];
                    n18 = ViewDataBinding.findLastMatching((ViewGroup)view2, n16);
                    if (n18 == n16) {
                        objectArray[object2] = object = DataBindingUtil.bind(dataBindingComponent2, (View)objectArray2, n11);
                        n17 = n16;
                        n16 = n14;
                        f11 = f10;
                        n14 = n12;
                    } else {
                        n18 = n18 - n16 + n14;
                        View[] viewArray = new View[n18];
                        for (n17 = 0; n17 < n18; ++n17) {
                            View view3;
                            n14 = n16 + n17;
                            viewArray[n17] = view3 = view2.getChildAt(n14);
                            n14 = 1;
                            f10 = Float.MIN_VALUE;
                        }
                        objectArray[object2] = object = DataBindingUtil.bind(dataBindingComponent2, viewArray, n11);
                        n17 = n16 + (n18 += -1);
                        n14 = n12;
                        n16 = 1;
                        f11 = Float.MIN_VALUE;
                    }
                } else {
                    n17 = n16;
                    n14 = n12;
                    n16 = 0;
                    f11 = 0.0f;
                    object3 = null;
                }
                if (n16 == 0) {
                    n18 = 0;
                    nArray = null;
                    object3 = dataBindingComponent;
                    object4 = objectArray2;
                    objectArray2 = objectArray;
                    object = viewDataBinding$IncludedLayouts;
                    object5 = sparseIntArray;
                    ViewDataBinding.mapBindings(dataBindingComponent, (View)object4, objectArray, viewDataBinding$IncludedLayouts, sparseIntArray, false);
                }
                f11 = Float.MIN_VALUE;
                n12 = n17 + 1;
                int n19 = n14;
                n14 = 1;
                f10 = f11;
                n16 = n12;
                n12 = n19;
            }
        }
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int n10, ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts, SparseIntArray sparseIntArray) {
        Object[] objectArray = new Object[n10];
        ViewDataBinding.mapBindings(dataBindingComponent, view, objectArray, viewDataBinding$IncludedLayouts, sparseIntArray, true);
        return objectArray;
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View[] viewArray, int n10, ViewDataBinding$IncludedLayouts viewDataBinding$IncludedLayouts, SparseIntArray sparseIntArray) {
        Object[] objectArray = new Object[n10];
        int n11 = 0;
        for (int i10 = 0; i10 < (n11 = viewArray.length); ++i10) {
            View view = viewArray[i10];
            boolean bl2 = true;
            ViewDataBinding.mapBindings(dataBindingComponent, view, objectArray, viewDataBinding$IncludedLayouts, sparseIntArray, bl2);
        }
        return objectArray;
    }

    public static byte parse(String string2, byte by2) {
        try {
            return Byte.parseByte(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return by2;
        }
    }

    public static char parse(String string2, char c10) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            return string2.charAt(0);
        }
        return c10;
    }

    public static double parse(String string2, double d10) {
        try {
            return Double.parseDouble(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return d10;
        }
    }

    public static float parse(String string2, float f10) {
        try {
            return Float.parseFloat(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return f10;
        }
    }

    public static int parse(String string2, int n10) {
        try {
            return Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
    }

    public static long parse(String string2, long l10) {
        try {
            return Long.parseLong(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return l10;
        }
    }

    public static short parse(String string2, short s10) {
        try {
            return Short.parseShort(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return s10;
        }
    }

    public static boolean parse(String string2, boolean bl2) {
        if (string2 == null) {
            return bl2;
        }
        return Boolean.parseBoolean(string2);
    }

    private static int parseTagInt(String string2, int n10) {
        int n11 = string2.length();
        int n12 = 0;
        while (n10 < n11) {
            n12 *= 10;
            int n13 = string2.charAt(n10) + -48;
            n12 += n13;
            ++n10;
        }
        return n12;
    }

    private static void processReferenceQueue() {
        ViewDataBinding$WeakListener viewDataBinding$WeakListener;
        while ((viewDataBinding$WeakListener = sReferenceQueue.poll()) != null) {
            boolean bl2 = viewDataBinding$WeakListener instanceof ViewDataBinding$WeakListener;
            if (!bl2) continue;
            viewDataBinding$WeakListener = viewDataBinding$WeakListener;
            viewDataBinding$WeakListener.unregister();
        }
    }

    public static byte safeUnbox(Byte by2) {
        byte by3;
        if (by2 == null) {
            by3 = 0;
            by2 = null;
        } else {
            by3 = by2;
        }
        return by3;
    }

    public static char safeUnbox(Character c10) {
        char c11;
        if (c10 == null) {
            c11 = '\u0000';
            c10 = null;
        } else {
            c11 = c10.charValue();
        }
        return c11;
    }

    public static double safeUnbox(Double d10) {
        double d11 = d10 == null ? 0.0 : d10;
        return d11;
    }

    public static float safeUnbox(Float f10) {
        float f11;
        if (f10 == null) {
            f11 = 0.0f;
            f10 = null;
        } else {
            f11 = f10.floatValue();
        }
        return f11;
    }

    public static int safeUnbox(Integer n10) {
        int n11;
        if (n10 == null) {
            n11 = 0;
            n10 = null;
        } else {
            n11 = n10;
        }
        return n11;
    }

    public static long safeUnbox(Long l10) {
        long l11 = l10 == null ? 0L : l10;
        return l11;
    }

    public static short safeUnbox(Short s10) {
        short s11;
        if (s10 == null) {
            s11 = 0;
            s10 = null;
        } else {
            s11 = s10;
        }
        return s11;
    }

    public static boolean safeUnbox(Boolean bl2) {
        boolean bl3;
        if (bl2 == null) {
            bl3 = false;
            bl2 = null;
        } else {
            bl3 = bl2;
        }
        return bl3;
    }

    public static void setBindingInverseListener(ViewDataBinding viewDataBinding, InverseBindingListener inverseBindingListener, ViewDataBinding$PropertyChangedInverseListener viewDataBinding$PropertyChangedInverseListener) {
        if (inverseBindingListener != viewDataBinding$PropertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                inverseBindingListener = (ViewDataBinding$PropertyChangedInverseListener)inverseBindingListener;
                viewDataBinding.removeOnPropertyChangedCallback((Observable$OnPropertyChangedCallback)((Object)inverseBindingListener));
            }
            if (viewDataBinding$PropertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(viewDataBinding$PropertyChangedInverseListener);
            }
        }
    }

    public static void setTo(android.util.LongSparseArray longSparseArray, int n10, Object object) {
        int n11;
        if (longSparseArray != null && n10 >= 0 && n10 < (n11 = longSparseArray.size())) {
            long l10 = n10;
            longSparseArray.put(l10, object);
        }
    }

    public static void setTo(SparseArray sparseArray, int n10, Object object) {
        int n11;
        if (sparseArray != null && n10 >= 0 && n10 < (n11 = sparseArray.size())) {
            sparseArray.put(n10, object);
        }
    }

    public static void setTo(SparseBooleanArray sparseBooleanArray, int n10, boolean bl2) {
        int n11;
        if (sparseBooleanArray != null && n10 >= 0 && n10 < (n11 = sparseBooleanArray.size())) {
            sparseBooleanArray.put(n10, bl2);
        }
    }

    public static void setTo(SparseIntArray sparseIntArray, int n10, int n11) {
        int n12;
        if (sparseIntArray != null && n10 >= 0 && n10 < (n12 = sparseIntArray.size())) {
            sparseIntArray.put(n10, n11);
        }
    }

    public static void setTo(SparseLongArray sparseLongArray, int n10, long l10) {
        int n11;
        if (sparseLongArray != null && n10 >= 0 && n10 < (n11 = sparseLongArray.size())) {
            sparseLongArray.put(n10, l10);
        }
    }

    public static void setTo(LongSparseArray longSparseArray, int n10, Object object) {
        int n11;
        if (longSparseArray != null && n10 >= 0 && n10 < (n11 = longSparseArray.size())) {
            long l10 = n10;
            longSparseArray.put(l10, object);
        }
    }

    public static void setTo(List list, int n10, Object object) {
        int n11;
        if (list != null && n10 >= 0 && n10 < (n11 = list.size())) {
            list.set(n10, object);
        }
    }

    public static void setTo(Map map, Object object, Object object2) {
        if (map == null) {
            return;
        }
        map.put(object, object2);
    }

    public static void setTo(byte[] byArray, int n10, byte by2) {
        int n11;
        if (byArray != null && n10 >= 0 && n10 < (n11 = byArray.length)) {
            byArray[n10] = by2;
        }
    }

    public static void setTo(char[] cArray, int n10, char c10) {
        int n11;
        if (cArray != null && n10 >= 0 && n10 < (n11 = cArray.length)) {
            cArray[n10] = c10;
        }
    }

    public static void setTo(double[] dArray, int n10, double d10) {
        int n11;
        if (dArray != null && n10 >= 0 && n10 < (n11 = dArray.length)) {
            dArray[n10] = d10;
        }
    }

    public static void setTo(float[] fArray, int n10, float f10) {
        int n11;
        if (fArray != null && n10 >= 0 && n10 < (n11 = fArray.length)) {
            fArray[n10] = f10;
        }
    }

    public static void setTo(int[] nArray, int n10, int n11) {
        int n12;
        if (nArray != null && n10 >= 0 && n10 < (n12 = nArray.length)) {
            nArray[n10] = n11;
        }
    }

    public static void setTo(long[] lArray, int n10, long l10) {
        int n11;
        if (lArray != null && n10 >= 0 && n10 < (n11 = lArray.length)) {
            lArray[n10] = l10;
        }
    }

    public static void setTo(Object[] objectArray, int n10, Object object) {
        int n11;
        if (objectArray != null && n10 >= 0 && n10 < (n11 = objectArray.length)) {
            objectArray[n10] = object;
        }
    }

    public static void setTo(short[] sArray, int n10, short s10) {
        int n11;
        if (sArray != null && n10 >= 0 && n10 < (n11 = sArray.length)) {
            sArray[n10] = s10;
        }
    }

    public static void setTo(boolean[] blArray, int n10, boolean bl2) {
        int n11;
        if (blArray != null && n10 >= 0 && n10 < (n11 = blArray.length)) {
            blArray[n10] = bl2;
        }
    }

    private boolean updateRegistration(int n10, Object object, ViewDataBinding$CreateWeakListener viewDataBinding$CreateWeakListener) {
        if (object == null) {
            return this.unregisterFrom(n10);
        }
        Object object2 = this.mLocalFieldObservers[n10];
        boolean bl2 = true;
        if (object2 == null) {
            this.registerTo(n10, object, viewDataBinding$CreateWeakListener);
            return bl2;
        }
        if ((object2 = ((ViewDataBinding$WeakListener)object2).getTarget()) == object) {
            return false;
        }
        this.unregisterFrom(n10);
        this.registerTo(n10, object, viewDataBinding$CreateWeakListener);
        return bl2;
    }

    public void addOnRebindCallback(OnRebindCallback onRebindCallback) {
        CallbackRegistry callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry == null) {
            CallbackRegistry$NotifierCallback callbackRegistry$NotifierCallback = REBIND_NOTIFIER;
            this.mRebindCallbacks = callbackRegistry = new CallbackRegistry(callbackRegistry$NotifierCallback);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    public void ensureBindingComponentIsNotNull(Class object) {
        Object object2 = this.mBindingComponent;
        if (object2 != null) {
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Required DataBindingComponent is null in class ");
        String string2 = this.getClass().getSimpleName();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(". A BindingAdapter in ");
        object = ((Class)object).getCanonicalName();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
        object = ((StringBuilder)object2).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            this.executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    public void forceExecuteBindings() {
        this.executeBindings();
    }

    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public Object getObservedField(int n10) {
        ViewDataBinding$WeakListener[] viewDataBinding$WeakListenerArray = this.mLocalFieldObservers;
        ViewDataBinding$WeakListener viewDataBinding$WeakListener = viewDataBinding$WeakListenerArray[n10];
        if (viewDataBinding$WeakListener == null) {
            return null;
        }
        return viewDataBinding$WeakListener.getTarget();
    }

    public View getRoot() {
        return this.mRoot;
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    public abstract boolean onFieldChange(int var1, Object var2, int var3);

    public void registerTo(int n10, Object object, ViewDataBinding$CreateWeakListener viewDataBinding$WeakListenerArray) {
        if (object == null) {
            return;
        }
        ViewDataBinding$WeakListener viewDataBinding$WeakListener = this.mLocalFieldObservers[n10];
        if (viewDataBinding$WeakListener == null) {
            viewDataBinding$WeakListener = viewDataBinding$WeakListenerArray.create(this, n10);
            viewDataBinding$WeakListenerArray = this.mLocalFieldObservers;
            viewDataBinding$WeakListenerArray[n10] = viewDataBinding$WeakListener;
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                viewDataBinding$WeakListener.setLifecycleOwner(lifecycleOwner);
            }
        }
        viewDataBinding$WeakListener.setTarget(object);
    }

    public void removeOnRebindCallback(OnRebindCallback onRebindCallback) {
        CallbackRegistry callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void requestRebind() {
        Object object;
        boolean bl2;
        Object object2 = this.mContainingBinding;
        if (object2 != null) {
            ((ViewDataBinding)object2).requestRebind();
            return;
        }
        object2 = this.mLifecycleOwner;
        if (object2 != null && !(bl2 = ((Lifecycle$State)((Object)(object2 = object2.getLifecycle().getCurrentState()))).isAtLeast((Lifecycle$State)((Object)(object = Lifecycle$State.STARTED))))) {
            return;
        }
        synchronized (this) {
            bl2 = this.mPendingRebind;
            if (bl2) {
                return;
            }
            this.mPendingRebind = bl2 = true;
        }
        bl2 = USE_CHOREOGRAPHER;
        if (bl2) {
            object2 = this.mChoreographer;
            object = this.mFrameCallback;
            object2.postFrameCallback((Choreographer.FrameCallback)object);
            return;
        }
        object2 = this.mUIThreadHandler;
        object = this.mRebindRunnable;
        object2.post((Runnable)object);
    }

    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        ViewDataBinding$OnStartListener viewDataBinding$OnStartListener;
        Object object = this.mLifecycleOwner;
        if (object == lifecycleOwner) {
            return;
        }
        if (object != null) {
            object = object.getLifecycle();
            viewDataBinding$OnStartListener = this.mOnStartListener;
            ((Lifecycle)object).removeObserver(viewDataBinding$OnStartListener);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null) {
            object = this.mOnStartListener;
            if (object == null) {
                int n10 = 0;
                viewDataBinding$OnStartListener = null;
                this.mOnStartListener = object = new ViewDataBinding$OnStartListener(this, null);
            }
            object = lifecycleOwner.getLifecycle();
            viewDataBinding$OnStartListener = this.mOnStartListener;
            ((Lifecycle)object).addObserver(viewDataBinding$OnStartListener);
        }
        for (ViewDataBinding$WeakListener viewDataBinding$WeakListener : this.mLocalFieldObservers) {
            if (viewDataBinding$WeakListener == null) continue;
            viewDataBinding$WeakListener.setLifecycleOwner(lifecycleOwner);
        }
    }

    public void setRootTag(View view) {
        int n10 = R$id.dataBinding;
        view.setTag(n10, (Object)this);
    }

    public void setRootTag(View[] viewArray) {
        for (View view : viewArray) {
            int n10 = R$id.dataBinding;
            view.setTag(n10, (Object)this);
        }
    }

    public abstract boolean setVariable(int var1, Object var2);

    public void unbind() {
        for (ViewDataBinding$WeakListener viewDataBinding$WeakListener : this.mLocalFieldObservers) {
            if (viewDataBinding$WeakListener == null) continue;
            viewDataBinding$WeakListener.unregister();
        }
    }

    public boolean unregisterFrom(int n10) {
        ViewDataBinding$WeakListener[] viewDataBinding$WeakListenerArray = this.mLocalFieldObservers;
        ViewDataBinding$WeakListener viewDataBinding$WeakListener = viewDataBinding$WeakListenerArray[n10];
        if (viewDataBinding$WeakListener != null) {
            return viewDataBinding$WeakListener.unregister();
        }
        return false;
    }

    public boolean updateLiveDataRegistration(int n10, LiveData liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            ViewDataBinding$CreateWeakListener viewDataBinding$CreateWeakListener = CREATE_LIVE_DATA_LISTENER;
            n10 = (int)(this.updateRegistration(n10, liveData, viewDataBinding$CreateWeakListener) ? 1 : 0);
            return n10 != 0;
        }
        finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    public boolean updateRegistration(int n10, Observable observable) {
        ViewDataBinding$CreateWeakListener viewDataBinding$CreateWeakListener = CREATE_PROPERTY_LISTENER;
        return this.updateRegistration(n10, observable, viewDataBinding$CreateWeakListener);
    }

    public boolean updateRegistration(int n10, ObservableList observableList) {
        ViewDataBinding$CreateWeakListener viewDataBinding$CreateWeakListener = CREATE_LIST_LISTENER;
        return this.updateRegistration(n10, observableList, viewDataBinding$CreateWeakListener);
    }

    public boolean updateRegistration(int n10, ObservableMap observableMap) {
        ViewDataBinding$CreateWeakListener viewDataBinding$CreateWeakListener = CREATE_MAP_LISTENER;
        return this.updateRegistration(n10, observableMap, viewDataBinding$CreateWeakListener);
    }
}

