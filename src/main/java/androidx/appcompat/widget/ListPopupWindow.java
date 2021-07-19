/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.DataSetObserver
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow$1;
import androidx.appcompat.widget.ListPopupWindow$2;
import androidx.appcompat.widget.ListPopupWindow$3;
import androidx.appcompat.widget.ListPopupWindow$ListSelectorHider;
import androidx.appcompat.widget.ListPopupWindow$PopupDataSetObserver;
import androidx.appcompat.widget.ListPopupWindow$PopupScrollListener;
import androidx.appcompat.widget.ListPopupWindow$PopupTouchInterceptor;
import androidx.appcompat.widget.ListPopupWindow$ResizePopupRunnable;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow
implements ShowableListMenu {
    private static final boolean DEBUG = false;
    public static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = 255;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = 254;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    public DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    public final Handler mHandler;
    private final ListPopupWindow$ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    public int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    public PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    public final ListPopupWindow$ResizePopupRunnable mResizePopupRunnable;
    private final ListPopupWindow$PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final ListPopupWindow$PopupTouchInterceptor mTouchInterceptor;

    static {
        Object object;
        Object object2;
        Object object3;
        Object object4 = Boolean.TYPE;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        Class<Integer> clazz = null;
        int n12 = 1;
        String string2 = TAG;
        int n13 = 28;
        if (n10 <= n13) {
            object3 = PopupWindow.class;
            object2 = "setClipToScreenEnabled";
            object = new Class[n12];
            object[0] = object4;
            object3 = ((Class)object3).getDeclaredMethod((String)object2, (Class<?>)object);
            try {
                sSetClipToWindowEnabledMethod = object3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object3 = "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.";
                Log.i((String)string2, (String)object3);
            }
            object3 = PopupWindow.class;
            object2 = "setEpicenterBounds";
            object = new Class[n12];
            Class<Rect> clazz2 = Rect.class;
            object[0] = clazz2;
            object3 = ((Class)object3).getDeclaredMethod((String)object2, (Class<?>)object);
            try {
                sSetEpicenterBoundsMethod = object3;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object3 = "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.";
                Log.i((String)string2, (String)object3);
            }
        }
        if (n10 <= (n13 = 23)) {
            Class<PopupWindow> clazz3 = PopupWindow.class;
            object3 = "getMaxAvailableHeight";
            int n14 = 3;
            object2 = new Class[n14];
            object = View.class;
            object2[0] = object;
            clazz = Integer.TYPE;
            object2[n12] = clazz;
            n11 = 2;
            object2[n11] = object4;
            object4 = clazz3.getDeclaredMethod((String)object3, (Class<?>)object2);
            try {
                sGetMaxAvailableHeightMethod = object4;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object4 = "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.";
                Log.i((String)string2, (String)object4);
            }
        }
    }

    public ListPopupWindow(Context context) {
        int n10 = R$attr.listPopupWindowStyle;
        this(context, null, n10);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.listPopupWindowStyle;
        this(context, attributeSet, n10);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int n10, int n11) {
        int n12;
        int n13;
        this.mDropDownHeight = n13 = -2;
        this.mDropDownWidth = n13;
        this.mDropDownWindowLayoutType = 1002;
        AppCompatPopupWindow appCompatPopupWindow = null;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = n12 = -1 >>> 1;
        this.mPromptPosition = 0;
        Object object = new ListPopupWindow$ResizePopupRunnable(this);
        this.mResizePopupRunnable = object;
        this.mTouchInterceptor = object = new ListPopupWindow$PopupTouchInterceptor(this);
        this.mScrollListener = object = new ListPopupWindow$PopupScrollListener(this);
        this.mHideSelector = object = new ListPopupWindow$ListSelectorHider(this);
        object = new Rect();
        this.mTempRect = object;
        this.mContext = context;
        Looper looper = context.getMainLooper();
        object = new Handler(looper);
        this.mHandler = object;
        object = R$styleable.ListPopupWindow;
        object = context.obtainStyledAttributes(attributeSet, (int[])object, n10, n11);
        int n14 = R$styleable.ListPopupWindow_android_dropDownHorizontalOffset;
        this.mDropDownHorizontalOffset = n14 = object.getDimensionPixelOffset(n14, 0);
        n14 = R$styleable.ListPopupWindow_android_dropDownVerticalOffset;
        this.mDropDownVerticalOffset = n13 = object.getDimensionPixelOffset(n14, 0);
        n14 = 1;
        if (n13 != 0) {
            this.mDropDownVerticalOffsetSet = n14;
        }
        object.recycle();
        appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, n10, n11);
        this.mPopup = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(n14);
    }

    private int buildDropDown() {
        DropDownListView dropDownListView;
        int n10;
        int n11;
        int n12;
        int n13;
        float f10;
        Object object;
        int n14;
        Object object2;
        Object object3 = this.mDropDownList;
        int n15 = -1 << -1;
        int n16 = -1;
        int n17 = 1;
        int n18 = 0;
        View view = null;
        if (object3 == null) {
            object3 = this.mContext;
            object2 = new ListPopupWindow$2(this);
            this.mShowDropDownRunnable = object2;
            n14 = this.mModal ^ n17;
            object2 = this.createDropDownListView((Context)object3, n14 != 0);
            this.mDropDownList = object2;
            object = this.mDropDownListHighlight;
            if (object != null) {
                ((DropDownListView)((Object)object2)).setSelector((Drawable)object);
            }
            object2 = this.mDropDownList;
            object = this.mAdapter;
            object2.setAdapter((ListAdapter)object);
            object2 = this.mDropDownList;
            object = this.mItemClickListener;
            object2.setOnItemClickListener((AdapterView.OnItemClickListener)object);
            this.mDropDownList.setFocusable(n17 != 0);
            this.mDropDownList.setFocusableInTouchMode(n17 != 0);
            object2 = this.mDropDownList;
            object = new ListPopupWindow$3(this);
            object2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)object);
            object2 = this.mDropDownList;
            object = this.mScrollListener;
            object2.setOnScrollListener((AbsListView.OnScrollListener)object);
            object2 = this.mItemSelectedListener;
            if (object2 != null) {
                object = this.mDropDownList;
                object.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)object2);
            }
            object2 = this.mDropDownList;
            object = this.mPromptView;
            if (object != null) {
                LinearLayout linearLayout = new LinearLayout((Context)object3);
                linearLayout.setOrientation(n17);
                f10 = 1.0f;
                object3 = new LinearLayout.LayoutParams(n16, 0, f10);
                n13 = this.mPromptPosition;
                if (n13 != 0) {
                    if (n13 != n17) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Invalid hint position ");
                        n14 = this.mPromptPosition;
                        ((StringBuilder)object3).append(n14);
                        object3 = ((StringBuilder)object3).toString();
                        object2 = TAG;
                        Log.e((String)object2, (String)object3);
                    } else {
                        linearLayout.addView((View)object2, (ViewGroup.LayoutParams)object3);
                        linearLayout.addView((View)object);
                    }
                } else {
                    linearLayout.addView((View)object);
                    linearLayout.addView((View)object2, (ViewGroup.LayoutParams)object3);
                }
                n12 = this.mDropDownWidth;
                if (n12 >= 0) {
                    n14 = n15;
                } else {
                    n12 = 0;
                    object3 = null;
                    n14 = 0;
                    object2 = null;
                }
                n12 = View.MeasureSpec.makeMeasureSpec((int)n12, (int)n14);
                object.measure(n12, 0);
                object3 = (LinearLayout.LayoutParams)object.getLayoutParams();
                n14 = object.getMeasuredHeight();
                n11 = ((LinearLayout.LayoutParams)object3).topMargin;
                n14 += n11;
                n12 = ((LinearLayout.LayoutParams)object3).bottomMargin;
                n14 += n12;
                n12 = n14;
                object2 = linearLayout;
            } else {
                n12 = 0;
                object3 = null;
            }
            object = this.mPopup;
            object.setContentView((View)object2);
        } else {
            object3 = (ViewGroup)this.mPopup.getContentView();
            object3 = this.mPromptView;
            if (object3 != null) {
                object2 = (LinearLayout.LayoutParams)object3.getLayoutParams();
                n12 = object3.getMeasuredHeight();
                n11 = ((LinearLayout.LayoutParams)object2).topMargin;
                n12 += n11;
                n14 = ((LinearLayout.LayoutParams)object2).bottomMargin;
                n12 += n14;
            } else {
                n12 = 0;
                object3 = null;
            }
        }
        object2 = this.mPopup.getBackground();
        if (object2 != null) {
            object = this.mTempRect;
            object2.getPadding((Rect)object);
            object2 = this.mTempRect;
            n11 = ((Rect)object2).top;
            n14 = ((Rect)object2).bottom + n11;
            n10 = (int)(this.mDropDownVerticalOffsetSet ? 1 : 0);
            if (n10 == 0) {
                this.mDropDownVerticalOffset = n11 = -n11;
            }
        } else {
            this.mTempRect.setEmpty();
            n14 = 0;
            object2 = null;
        }
        if ((n11 = (object = this.mPopup).getInputMethodMode()) != (n10 = 2)) {
            n17 = 0;
            dropDownListView = null;
        }
        view = this.getAnchorView();
        n11 = this.mDropDownVerticalOffset;
        n17 = this.getMaxAvailableHeight(view, n11, n17 != 0);
        n18 = this.mDropDownAlwaysVisible;
        if (n18 == 0 && (n18 = this.mDropDownHeight) != n16) {
            Object object4;
            n18 = this.mDropDownWidth;
            n11 = -2;
            if (n18 != n11) {
                n15 = 0x40000000;
                if (n18 != n16) {
                    n15 = View.MeasureSpec.makeMeasureSpec((int)n18, (int)n15);
                } else {
                    object4 = this.mContext.getResources().getDisplayMetrics();
                    n16 = object4.widthPixels;
                    view = this.mTempRect;
                    n11 = view.left;
                    n18 = view.right;
                    n15 = View.MeasureSpec.makeMeasureSpec((int)(n16 -= (n11 += n18)), (int)n15);
                }
            } else {
                object4 = this.mContext.getResources().getDisplayMetrics();
                n16 = object4.widthPixels;
                view = this.mTempRect;
                n11 = view.left;
                n18 = view.right;
                n15 = View.MeasureSpec.makeMeasureSpec((int)(n16 -= (n11 += n18)), (int)n15);
            }
            n10 = n15;
            object = this.mDropDownList;
            n13 = 0;
            f10 = 0.0f;
            int n19 = -1;
            int n20 = n17 - n12;
            int n21 = -1;
            n15 = ((DropDownListView)((Object)object)).measureHeightOfChildrenCompat(n15, 0, n19, n20, n21);
            if (n15 > 0) {
                object4 = this.mDropDownList;
                n16 = object4.getPaddingTop();
                dropDownListView = this.mDropDownList;
                n17 = dropDownListView.getPaddingBottom();
                n12 += (n14 += (n16 += n17));
            }
            return n15 + n12;
        }
        return n17 + n14;
    }

    private int getMaxAvailableHeight(View view, int n10, boolean bl2) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 <= n12) {
            Object object = sGetMaxAvailableHeightMethod;
            if (object != null) {
                PopupWindow popupWindow = this.mPopup;
                int n13 = 3;
                Object[] objectArray = new Object[n13];
                int n14 = 0;
                objectArray[0] = view;
                n14 = 1;
                Integer n15 = n10;
                objectArray[n14] = n15;
                n14 = 2;
                Object object2 = bl2;
                objectArray[n14] = object2;
                object2 = ((Method)object).invoke(popupWindow, objectArray);
                object2 = (Integer)object2;
                try {
                    return (Integer)object2;
                }
                catch (Exception exception) {
                    object2 = TAG;
                    object = "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.";
                    Log.i((String)object2, (String)object);
                }
            }
            return this.mPopup.getMaxAvailableHeight(view, n10);
        }
        return this.mPopup.getMaxAvailableHeight(view, n10, bl2);
    }

    private static boolean isConfirmKey(int n10) {
        int n11 = 66;
        n10 = n10 != n11 && n10 != (n11 = 23) ? 0 : 1;
        return n10 != 0;
    }

    private void removePromptView() {
        boolean bl2;
        View view = this.mPromptView;
        if (view != null && (bl2 = (view = view.getParent()) instanceof ViewGroup)) {
            view = (ViewGroup)view;
            View view2 = this.mPromptView;
            view.removeView(view2);
        }
    }

    private void setPopupClipToScreenEnabled(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 <= n11) {
            Object object = sSetClipToWindowEnabledMethod;
            if (object != null) {
                PopupWindow popupWindow = this.mPopup;
                int n12 = 1;
                Object[] objectArray = new Object[n12];
                Object object2 = bl2;
                objectArray[0] = object2;
                try {
                    ((Method)object).invoke(popupWindow, objectArray);
                }
                catch (Exception exception) {
                    object2 = TAG;
                    object = "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.";
                    Log.i((String)object2, (String)object);
                }
            }
        } else {
            PopupWindow popupWindow = this.mPopup;
            popupWindow.setIsClippedToScreen(bl2);
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            boolean bl2 = true;
            dropDownListView.setListSelectionHidden(bl2);
            dropDownListView.requestLayout();
        }
    }

    public View.OnTouchListener createDragToOpenListener(View view) {
        ListPopupWindow$1 listPopupWindow$1 = new ListPopupWindow$1(this, view);
        return listPopupWindow$1;
    }

    public DropDownListView createDropDownListView(Context context, boolean bl2) {
        DropDownListView dropDownListView = new DropDownListView(context, bl2);
        return dropDownListView;
    }

    public void dismiss() {
        this.mPopup.dismiss();
        this.removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        Handler handler = this.mHandler;
        ListPopupWindow$ResizePopupRunnable listPopupWindow$ResizePopupRunnable = this.mResizePopupRunnable;
        handler.removeCallbacks((Runnable)listPopupWindow$ResizePopupRunnable);
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public Rect getEpicenterBounds() {
        Rect rect = this.mEpicenterBounds;
        if (rect != null) {
            Rect rect2 = this.mEpicenterBounds;
            rect = new Rect(rect2);
        } else {
            rect = null;
        }
        return rect;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public Object getSelectedItem() {
        boolean bl2 = this.isShowing();
        if (!bl2) {
            return null;
        }
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        boolean bl2 = this.isShowing();
        if (!bl2) {
            return Long.MIN_VALUE;
        }
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        boolean bl2 = this.isShowing();
        if (!bl2) {
            return -1;
        }
        return this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        boolean bl2 = this.isShowing();
        if (!bl2) {
            return null;
        }
        return this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        boolean bl2 = this.mDropDownVerticalOffsetSet;
        if (!bl2) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        int n10;
        PopupWindow popupWindow = this.mPopup;
        int n11 = popupWindow.getInputMethodMode();
        if (n11 == (n10 = 2)) {
            n11 = 1;
        } else {
            n11 = 0;
            popupWindow = null;
        }
        return n11 != 0;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int n10, KeyEvent object) {
        block13: {
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            boolean bl2;
            int n16;
            block15: {
                block14: {
                    DropDownListView dropDownListView;
                    n16 = this.isShowing();
                    if (n16 == 0 || n10 == (n16 = 62) || (n16 = (dropDownListView = this.mDropDownList).getSelectedItemPosition()) < 0 && (n16 = (int)(ListPopupWindow.isConfirmKey(n10) ? 1 : 0)) != 0) break block13;
                    dropDownListView = this.mDropDownList;
                    n16 = dropDownListView.getSelectedItemPosition();
                    PopupWindow popupWindow = this.mPopup;
                    bl2 = popupWindow.isAboveAnchor();
                    n15 = 1;
                    bl2 ^= n15;
                    ListAdapter listAdapter = this.mAdapter;
                    n14 = -1 >>> 1;
                    n13 = -1 << -1;
                    if (listAdapter != null) {
                        n14 = (int)(listAdapter.areAllItemsEnabled() ? 1 : 0);
                        if (n14 != 0) {
                            n13 = 0;
                            Object var11_11 = null;
                        } else {
                            DropDownListView dropDownListView2 = this.mDropDownList;
                            n13 = dropDownListView2.lookForSelectablePosition(0, n15 != 0);
                        }
                        if (n14 != 0) {
                            n12 = listAdapter.getCount() - n15;
                        } else {
                            DropDownListView dropDownListView3 = this.mDropDownList;
                            n12 = listAdapter.getCount() - n15;
                            n12 = dropDownListView3.lookForSelectablePosition(n12, false);
                        }
                        n14 = n13;
                        n13 = n12;
                    }
                    n12 = 19;
                    if (bl2 && n10 == n12 && n16 <= n14) break block14;
                    n11 = 20;
                    if (bl2 || n10 != n11 || n16 < n13) break block15;
                }
                this.clearListSelection();
                this.mPopup.setInputMethodMode(n15);
                this.show();
                return n15 != 0;
            }
            this.mDropDownList.setListSelectionHidden(false);
            DropDownListView dropDownListView = this.mDropDownList;
            int n17 = dropDownListView.onKeyDown(n10, (KeyEvent)object);
            if (n17 != 0) {
                object = this.mPopup;
                n16 = 2;
                object.setInputMethodMode(n16);
                object = this.mDropDownList;
                object.requestFocusFromTouch();
                this.show();
                if (n10 == n12 || n10 == n11 || n10 == (n17 = 23) || n10 == (n17 = 66)) {
                    return n15 != 0;
                }
            } else if (bl2 && n10 == n11 ? n16 == n13 : !bl2 && n10 == n12 && n16 == n14) {
                return n15 != 0;
            }
        }
        return false;
    }

    public boolean onKeyPreIme(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11 && (n10 = (int)(this.isShowing() ? 1 : 0)) != 0) {
            View view = this.mDropDownAnchorView;
            n11 = keyEvent.getAction();
            int n12 = 1;
            if (!n11 && !(n11 = keyEvent.getRepeatCount())) {
                if ((view = view.getKeyDispatcherState()) != null) {
                    view.startTracking(keyEvent, (Object)this);
                }
                return n12;
            }
            n11 = keyEvent.getAction();
            if (n11 == n12) {
                if ((view = view.getKeyDispatcherState()) != null) {
                    view.handleUpEvent(keyEvent);
                }
                if ((n10 = (int)(keyEvent.isTracking() ? 1 : 0)) != 0 && (n10 = (int)(keyEvent.isCanceled() ? 1 : 0)) == 0) {
                    this.dismiss();
                    return n12;
                }
            }
        }
        return false;
    }

    public boolean onKeyUp(int n10, KeyEvent keyEvent) {
        DropDownListView dropDownListView;
        int n11 = this.isShowing();
        if (n11 != 0 && (n11 = (dropDownListView = this.mDropDownList).getSelectedItemPosition()) >= 0) {
            dropDownListView = this.mDropDownList;
            boolean bl2 = dropDownListView.onKeyUp(n10, keyEvent);
            if (bl2 && (n10 = (int)(ListPopupWindow.isConfirmKey(n10) ? 1 : 0)) != 0) {
                this.dismiss();
            }
            return bl2;
        }
        return false;
    }

    public boolean performItemClick(int n10) {
        int n11 = this.isShowing();
        if (n11 != 0) {
            AdapterView.OnItemClickListener onItemClickListener = this.mItemClickListener;
            if (onItemClickListener != null) {
                DropDownListView dropDownListView = this.mDropDownList;
                n11 = dropDownListView.getFirstVisiblePosition();
                n11 = n10 - n11;
                View view = dropDownListView.getChildAt(n11);
                onItemClickListener = dropDownListView.getAdapter();
                AdapterView.OnItemClickListener onItemClickListener2 = this.mItemClickListener;
                long l10 = onItemClickListener.getItemId(n10);
                onItemClickListener2.onItemClick((AdapterView)dropDownListView, view, n10, l10);
            }
            return true;
        }
        return false;
    }

    public void postShow() {
        Handler handler = this.mHandler;
        Runnable runnable = this.mShowDropDownRunnable;
        handler.post(runnable);
    }

    public void setAdapter(ListAdapter object) {
        DataSetObserver dataSetObserver = this.mObserver;
        if (dataSetObserver == null) {
            this.mObserver = dataSetObserver = new ListPopupWindow$PopupDataSetObserver(this);
        } else {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.mAdapter = object;
        if (object != null) {
            dataSetObserver = this.mObserver;
            object.registerDataSetObserver(dataSetObserver);
        }
        if ((object = this.mDropDownList) != null) {
            dataSetObserver = this.mAdapter;
            object.setAdapter((ListAdapter)dataSetObserver);
        }
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int n10) {
        this.mPopup.setAnimationStyle(n10);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        this.mPopup.setBackgroundDrawable(drawable2);
    }

    public void setContentWidth(int n10) {
        Drawable drawable2 = this.mPopup.getBackground();
        if (drawable2 != null) {
            Rect rect = this.mTempRect;
            drawable2.getPadding(rect);
            drawable2 = this.mTempRect;
            int n11 = drawable2.left;
            int n12 = drawable2.right;
            this.mDropDownWidth = n11 = n11 + n12 + n10;
        } else {
            this.setWidth(n10);
        }
    }

    public void setDropDownAlwaysVisible(boolean bl2) {
        this.mDropDownAlwaysVisible = bl2;
    }

    public void setDropDownGravity(int n10) {
        this.mDropDownGravity = n10;
    }

    public void setEpicenterBounds(Rect rect) {
        Object object = rect != null ? new Rect(rect) : null;
        this.mEpicenterBounds = object;
    }

    public void setForceIgnoreOutsideTouch(boolean bl2) {
        this.mForceIgnoreOutsideTouch = bl2;
    }

    public void setHeight(int n10) {
        int n11;
        if (n10 < 0 && (n11 = -2) != n10 && (n11 = -1) != n10) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
            throw illegalArgumentException;
        }
        this.mDropDownHeight = n10;
    }

    public void setHorizontalOffset(int n10) {
        this.mDropDownHorizontalOffset = n10;
    }

    public void setInputMethodMode(int n10) {
        this.mPopup.setInputMethodMode(n10);
    }

    public void setListItemExpandMax(int n10) {
        this.mListItemExpandMaximum = n10;
    }

    public void setListSelector(Drawable drawable2) {
        this.mDropDownListHighlight = drawable2;
    }

    public void setModal(boolean bl2) {
        this.mModal = bl2;
        this.mPopup.setFocusable(bl2);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean bl2) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = bl2;
    }

    public void setPromptPosition(int n10) {
        this.mPromptPosition = n10;
    }

    public void setPromptView(View view) {
        boolean bl2 = this.isShowing();
        if (bl2) {
            this.removePromptView();
        }
        this.mPromptView = view;
        if (bl2) {
            this.show();
        }
    }

    public void setSelection(int n10) {
        DropDownListView dropDownListView = this.mDropDownList;
        boolean bl2 = this.isShowing();
        if (bl2 && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(n10);
            int n11 = dropDownListView.getChoiceMode();
            if (n11 != 0) {
                boolean bl3 = true;
                dropDownListView.setItemChecked(n10, bl3);
            }
        }
    }

    public void setSoftInputMode(int n10) {
        this.mPopup.setSoftInputMode(n10);
    }

    public void setVerticalOffset(int n10) {
        this.mDropDownVerticalOffset = n10;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int n10) {
        this.mDropDownWidth = n10;
    }

    public void setWindowLayoutType(int n10) {
        this.mDropDownWindowLayoutType = n10;
    }

    public void show() {
        int n10 = this.buildDropDown();
        int n11 = this.isInputMethodNotNeeded();
        View view = this.mPopup;
        int n12 = this.mDropDownWindowLayoutType;
        PopupWindowCompat.setWindowLayoutType((PopupWindow)view, n12);
        view = this.mPopup;
        int n13 = view.isShowing();
        n12 = 1;
        int n14 = -2;
        int n15 = -1;
        if (n13 != 0) {
            PopupWindow popupWindow;
            view = this.getAnchorView();
            n13 = ViewCompat.isAttachedToWindow(view);
            if (n13 == 0) {
                return;
            }
            n13 = this.mDropDownWidth;
            if (n13 == n15) {
                n13 = n15;
            } else if (n13 == n14) {
                view = this.getAnchorView();
                n13 = view.getWidth();
            }
            int n16 = this.mDropDownHeight;
            if (n16 == n15) {
                if (n11 == 0) {
                    n10 = n15;
                }
                if (n11 != 0) {
                    popupWindow = this.mPopup;
                    n14 = this.mDropDownWidth;
                    n14 = n14 == n15 ? n15 : 0;
                    popupWindow.setWidth(n14);
                    popupWindow = this.mPopup;
                    popupWindow.setHeight(0);
                } else {
                    popupWindow = this.mPopup;
                    n14 = this.mDropDownWidth;
                    n14 = n14 == n15 ? n15 : 0;
                    popupWindow.setWidth(n14);
                    popupWindow = this.mPopup;
                    popupWindow.setHeight(n15);
                }
            } else if (n16 != n14) {
                n10 = n16;
            }
            popupWindow = this.mPopup;
            n14 = (int)(this.mForceIgnoreOutsideTouch ? 1 : 0);
            if (n14 != 0 || (n14 = (int)(this.mDropDownAlwaysVisible ? 1 : 0)) != 0) {
                n12 = 0;
                Object var10_11 = null;
            }
            popupWindow.setOutsideTouchable(n12 != 0);
            PopupWindow popupWindow2 = this.mPopup;
            View view2 = this.getAnchorView();
            int n17 = this.mDropDownHorizontalOffset;
            int n18 = this.mDropDownVerticalOffset;
            int n19 = n13 < 0 ? n15 : n13;
            int n20 = n10 < 0 ? n15 : n10;
            popupWindow2.update(view2, n17, n18, n19, n20);
        } else {
            Object object;
            n11 = this.mDropDownWidth;
            if (n11 == n15) {
                n11 = n15;
            } else if (n11 == n14) {
                object = this.getAnchorView();
                n11 = object.getWidth();
            }
            n13 = this.mDropDownHeight;
            if (n13 == n15) {
                n10 = n15;
            } else if (n13 != n14) {
                n10 = n13;
            }
            view = this.mPopup;
            view.setWidth(n11);
            object = this.mPopup;
            object.setHeight(n10);
            this.setPopupClipToScreenEnabled(n12 != 0);
            Object object2 = this.mPopup;
            n11 = (int)(this.mForceIgnoreOutsideTouch ? 1 : 0);
            if (n11 == 0 && (n11 = (int)(this.mDropDownAlwaysVisible ? 1 : 0)) == 0) {
                n11 = n12;
            } else {
                n11 = 0;
                object = null;
            }
            object2.setOutsideTouchable(n11 != 0);
            object2 = this.mPopup;
            object = this.mTouchInterceptor;
            object2.setTouchInterceptor((View.OnTouchListener)object);
            n10 = (int)(this.mOverlapAnchorSet ? 1 : 0);
            if (n10 != 0) {
                object2 = this.mPopup;
                n11 = (int)(this.mOverlapAnchor ? 1 : 0);
                PopupWindowCompat.setOverlapAnchor((PopupWindow)object2, n11 != 0);
            }
            if ((n10 = Build.VERSION.SDK_INT) <= (n11 = 28)) {
                object2 = sSetEpicenterBoundsMethod;
                if (object2 != null) {
                    object = this.mPopup;
                    view = new Object[n12];
                    Rect rect = this.mEpicenterBounds;
                    view[0] = rect;
                    try {
                        ((Method)object2).invoke(object, (Object[])view);
                    }
                    catch (Exception exception) {
                        object = TAG;
                        view = "Could not invoke setEpicenterBounds on PopupWindow";
                        Log.e((String)object, (String)view, (Throwable)exception);
                    }
                }
            } else {
                object2 = this.mPopup;
                object = this.mEpicenterBounds;
                object2.setEpicenterBounds((Rect)object);
            }
            object2 = this.mPopup;
            object = this.getAnchorView();
            n13 = this.mDropDownHorizontalOffset;
            n12 = this.mDropDownVerticalOffset;
            n14 = this.mDropDownGravity;
            PopupWindowCompat.showAsDropDown((PopupWindow)object2, object, n13, n12, n14);
            object2 = this.mDropDownList;
            object2.setSelection(n15);
            n10 = (int)(this.mModal ? 1 : 0);
            if (n10 == 0 || (n10 = (int)(((DropDownListView)((Object)(object2 = this.mDropDownList))).isInTouchMode() ? 1 : 0)) != 0) {
                this.clearListSelection();
            }
            if ((n10 = (int)(this.mModal ? 1 : 0)) == 0) {
                object2 = this.mHandler;
                object = this.mHideSelector;
                object2.post((Runnable)object);
            }
        }
    }
}

