/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewStub
 *  android.view.Window
 *  android.widget.AbsListView$OnScrollListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  android.widget.TextView
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AlertController$1;
import androidx.appcompat.app.AlertController$2;
import androidx.appcompat.app.AlertController$3;
import androidx.appcompat.app.AlertController$4;
import androidx.appcompat.app.AlertController$5;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;

public class AlertController {
    public ListAdapter mAdapter;
    private int mAlertDialogLayout;
    private final View.OnClickListener mButtonHandler;
    private final int mButtonIconDimen;
    public Button mButtonNegative;
    private Drawable mButtonNegativeIcon;
    public Message mButtonNegativeMessage;
    private CharSequence mButtonNegativeText;
    public Button mButtonNeutral;
    private Drawable mButtonNeutralIcon;
    public Message mButtonNeutralMessage;
    private CharSequence mButtonNeutralText;
    private int mButtonPanelLayoutHint = 0;
    private int mButtonPanelSideLayout;
    public Button mButtonPositive;
    private Drawable mButtonPositiveIcon;
    public Message mButtonPositiveMessage;
    private CharSequence mButtonPositiveText;
    public int mCheckedItem = -1;
    private final Context mContext;
    private View mCustomTitleView;
    public final AppCompatDialog mDialog;
    public Handler mHandler;
    private Drawable mIcon;
    private int mIconId = 0;
    private ImageView mIconView;
    public int mListItemLayout;
    public int mListLayout;
    public ListView mListView;
    private CharSequence mMessage;
    private TextView mMessageView;
    public int mMultiChoiceItemLayout;
    public NestedScrollView mScrollView;
    private boolean mShowTitle;
    public int mSingleChoiceItemLayout;
    private CharSequence mTitle;
    private TextView mTitleView;
    private View mView;
    private int mViewLayoutResId;
    private int mViewSpacingBottom;
    private int mViewSpacingLeft;
    private int mViewSpacingRight;
    private boolean mViewSpacingSpecified = false;
    private int mViewSpacingTop;
    private final Window mWindow;

    public AlertController(Context context, AppCompatDialog appCompatDialog, Window object) {
        AlertController$1 alertController$1 = new AlertController$1(this);
        this.mButtonHandler = alertController$1;
        this.mContext = context;
        this.mDialog = appCompatDialog;
        this.mWindow = object;
        super((DialogInterface)appCompatDialog);
        this.mHandler = object;
        object = R$styleable.AlertDialog;
        int n10 = R$attr.alertDialogStyle;
        context = context.obtainStyledAttributes(null, (int[])object, n10, 0);
        int n11 = R$styleable.AlertDialog_android_layout;
        this.mAlertDialogLayout = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.AlertDialog_buttonPanelSideLayout;
        this.mButtonPanelSideLayout = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.AlertDialog_listLayout;
        this.mListLayout = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.AlertDialog_multiChoiceItemLayout;
        this.mMultiChoiceItemLayout = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.AlertDialog_singleChoiceItemLayout;
        this.mSingleChoiceItemLayout = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.AlertDialog_listItemLayout;
        this.mListItemLayout = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.AlertDialog_showTitle;
        n10 = 1;
        n11 = context.getBoolean(n11, n10 != 0) ? 1 : 0;
        this.mShowTitle = n11;
        n11 = R$styleable.AlertDialog_buttonIconDimen;
        this.mButtonIconDimen = n11 = context.getDimensionPixelSize(n11, 0);
        context.recycle();
        appCompatDialog.supportRequestWindowFeature(n10);
    }

    public static boolean canTextInput(View view) {
        int n10 = view.onCheckIsTextEditor();
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        n10 = view instanceof ViewGroup;
        if (n10 == 0) {
            return false;
        }
        view = (ViewGroup)view;
        n10 = view.getChildCount();
        while (n10 > 0) {
            View view2 = view.getChildAt(n10 += -1);
            boolean bl3 = AlertController.canTextInput(view2);
            if (!bl3) continue;
            return bl2;
        }
        return false;
    }

    private void centerButton(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public static void manageScrollIndicators(View view, View view2, View view3) {
        int n10 = 0;
        int n11 = 4;
        if (view2 != null) {
            int n12 = view.canScrollVertically(-1);
            n12 = n12 != 0 ? 0 : n11;
            view2.setVisibility(n12);
        }
        if (view3 != null) {
            int n13 = 1;
            boolean bl2 = view.canScrollVertically(n13);
            if (!bl2) {
                n10 = n11;
            }
            view3.setVisibility(n10);
        }
    }

    private ViewGroup resolvePanel(View view, View view2) {
        boolean bl2;
        ViewParent viewParent;
        boolean bl3;
        if (view == null) {
            boolean bl4 = view2 instanceof ViewStub;
            if (bl4) {
                view2 = ((ViewStub)view2).inflate();
            }
            return (ViewGroup)view2;
        }
        if (view2 != null && (bl3 = (viewParent = view2.getParent()) instanceof ViewGroup)) {
            viewParent = (ViewGroup)viewParent;
            viewParent.removeView(view2);
        }
        if (bl2 = view instanceof ViewStub) {
            view = ((ViewStub)view).inflate();
        }
        return (ViewGroup)view;
    }

    private int selectContentView() {
        int n10 = this.mButtonPanelSideLayout;
        if (n10 == 0) {
            return this.mAlertDialogLayout;
        }
        int n11 = this.mButtonPanelLayoutHint;
        int n12 = 1;
        if (n11 == n12) {
            return n10;
        }
        return this.mAlertDialogLayout;
    }

    private void setScrollIndicators(ViewGroup object, View object2, int n10, int n11) {
        Window window = this.mWindow;
        int n12 = R$id.scrollIndicatorUp;
        window = window.findViewById(n12);
        Window window2 = this.mWindow;
        int n13 = R$id.scrollIndicatorDown;
        window2 = window2.findViewById(n13);
        n13 = Build.VERSION.SDK_INT;
        int n14 = 23;
        if (n13 >= n14) {
            ViewCompat.setScrollIndicators(object2, n10, n11);
            if (window != null) {
                object.removeView((View)window);
            }
            if (window2 != null) {
                object.removeView((View)window2);
            }
        } else {
            object2 = null;
            if (window != null && (n11 = n10 & 1) == 0) {
                object.removeView((View)window);
                window = null;
            }
            if (window2 != null && (n10 &= 2) == 0) {
                object.removeView((View)window2);
                n12 = 0;
                window2 = null;
            }
            if (window != null || window2 != null) {
                object2 = this.mMessage;
                if (object2 != null) {
                    object = this.mScrollView;
                    object2 = new AlertController$2(this, (View)window, (View)window2);
                    ((NestedScrollView)object).setOnScrollChangeListener((NestedScrollView$OnScrollChangeListener)object2);
                    object = this.mScrollView;
                    object2 = new AlertController$3(this, (View)window, (View)window2);
                    object.post((Runnable)object2);
                } else {
                    object2 = this.mListView;
                    if (object2 != null) {
                        object = new AlertController$4(this, (View)window, (View)window2);
                        object2.setOnScrollListener((AbsListView.OnScrollListener)object);
                        object = this.mListView;
                        object2 = new AlertController$5(this, (View)window, (View)window2);
                        object.post((Runnable)object2);
                    } else {
                        if (window != null) {
                            object.removeView((View)window);
                        }
                        if (window2 != null) {
                            object.removeView((View)window2);
                        }
                    }
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void setupButtons(ViewGroup viewGroup) {
        int n10;
        int n11;
        int n12;
        int n13;
        CharSequence charSequence;
        Object object;
        this.mButtonPositive = object = (Button)viewGroup.findViewById(16908313);
        View.OnClickListener onClickListener = this.mButtonHandler;
        object.setOnClickListener(onClickListener);
        object = this.mButtonPositiveText;
        boolean n122 = TextUtils.isEmpty((CharSequence)object);
        int n14 = 1;
        int n15 = 8;
        int n16 = 0;
        Button button = null;
        if (n122 && (object = this.mButtonPositiveIcon) == null) {
            this.mButtonPositive.setVisibility(n15);
            boolean bl2 = false;
            object = null;
        } else {
            object = this.mButtonPositive;
            charSequence = this.mButtonPositiveText;
            object.setText(charSequence);
            object = this.mButtonPositiveIcon;
            if (object != null) {
                n13 = this.mButtonIconDimen;
                object.setBounds(0, 0, n13, n13);
                object = this.mButtonPositive;
                charSequence = this.mButtonPositiveIcon;
                object.setCompoundDrawables((Drawable)charSequence, null, null, null);
            }
            object = this.mButtonPositive;
            object.setVisibility(0);
            int n17 = n14;
        }
        charSequence = (Button)viewGroup.findViewById(16908314);
        this.mButtonNegative = charSequence;
        Object object2 = this.mButtonHandler;
        charSequence.setOnClickListener((View.OnClickListener)object2);
        charSequence = this.mButtonNegativeText;
        n13 = TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0;
        if (n13 != 0 && (charSequence = this.mButtonNegativeIcon) == null) {
            charSequence = this.mButtonNegative;
            charSequence.setVisibility(n15);
        } else {
            void var4_7;
            charSequence = this.mButtonNegative;
            object2 = this.mButtonNegativeText;
            charSequence.setText((CharSequence)object2);
            charSequence = this.mButtonNegativeIcon;
            if (charSequence != null) {
                n12 = this.mButtonIconDimen;
                charSequence.setBounds(0, 0, n12, n12);
                charSequence = this.mButtonNegative;
                object2 = this.mButtonNegativeIcon;
                charSequence.setCompoundDrawables((Drawable)object2, null, null, null);
            }
            charSequence = this.mButtonNegative;
            charSequence.setVisibility(0);
            n11 = var4_7 | 2;
        }
        charSequence = (Button)viewGroup.findViewById(16908315);
        this.mButtonNeutral = charSequence;
        object2 = this.mButtonHandler;
        charSequence.setOnClickListener((View.OnClickListener)object2);
        charSequence = this.mButtonNeutralText;
        n13 = TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0;
        if (n13 != 0 && (charSequence = this.mButtonNeutralIcon) == null) {
            button = this.mButtonNeutral;
            button.setVisibility(n15);
        } else {
            charSequence = this.mButtonNeutral;
            object2 = this.mButtonNeutralText;
            charSequence.setText((CharSequence)object2);
            charSequence = this.mButtonNeutralIcon;
            if (charSequence != null) {
                n12 = this.mButtonIconDimen;
                charSequence.setBounds(0, 0, n12, n12);
                charSequence = this.mButtonNeutral;
                object2 = this.mButtonNeutralIcon;
                charSequence.setCompoundDrawables((Drawable)object2, null, null, null);
            }
            button = this.mButtonNeutral;
            button.setVisibility(0);
            n10 = n11 | 4;
        }
        button = this.mContext;
        n16 = AlertController.shouldCenterSingleButton((Context)button);
        if (n16 != 0) {
            if (n10 == n14) {
                button = this.mButtonPositive;
                this.centerButton(button);
            } else {
                n16 = 2;
                if (n10 == n16) {
                    button = this.mButtonNegative;
                    this.centerButton(button);
                } else {
                    n16 = 4;
                    if (n10 == n16) {
                        button = this.mButtonNeutral;
                        this.centerButton(button);
                    }
                }
            }
        }
        if (n10 == 0) {
            n14 = 0;
            onClickListener = null;
        }
        if (!n14) {
            viewGroup.setVisibility(n15);
        }
    }

    private void setupContent(ViewGroup viewGroup) {
        Object object = this.mWindow;
        int n10 = R$id.scrollView;
        object = (NestedScrollView)object.findViewById(n10);
        this.mScrollView = object;
        n10 = 0;
        CharSequence charSequence = null;
        object.setFocusable(false);
        this.mScrollView.setNestedScrollingEnabled(false);
        int n11 = 16908299;
        object = (TextView)viewGroup.findViewById(n11);
        this.mMessageView = object;
        if (object == null) {
            return;
        }
        charSequence = this.mMessage;
        if (charSequence != null) {
            object.setText(charSequence);
        } else {
            n10 = 8;
            object.setVisibility(n10);
            object = this.mScrollView;
            TextView textView = this.mMessageView;
            object.removeView((View)textView);
            object = this.mListView;
            if (object != null) {
                viewGroup = (ViewGroup)this.mScrollView.getParent();
                object = this.mScrollView;
                n11 = viewGroup.indexOfChild((View)object);
                viewGroup.removeViewAt(n11);
                charSequence = this.mListView;
                int n12 = -1;
                textView = new ViewGroup.LayoutParams(n12, n12);
                viewGroup.addView((View)charSequence, n11, (ViewGroup.LayoutParams)textView);
            } else {
                viewGroup.setVisibility(n10);
            }
        }
    }

    private void setupCustomContent(ViewGroup object) {
        int n10;
        Window window;
        int n11;
        int n12;
        View view = this.mView;
        boolean bl2 = false;
        Window window2 = null;
        if (view == null) {
            n12 = this.mViewLayoutResId;
            if (n12 != 0) {
                view = LayoutInflater.from((Context)this.mContext);
                n11 = this.mViewLayoutResId;
                view = view.inflate(n11, object, false);
            } else {
                n12 = 0;
                view = null;
            }
        }
        if (view != null) {
            bl2 = true;
        }
        if (!bl2 || (n11 = AlertController.canTextInput(view)) == 0) {
            window = this.mWindow;
            n10 = 131072;
            window.setFlags(n10, n10);
        }
        if (bl2) {
            window2 = this.mWindow;
            n11 = R$id.custom;
            window2 = (FrameLayout)window2.findViewById(n11);
            n10 = -1;
            window = new ViewGroup.LayoutParams(n10, n10);
            window2.addView(view, (ViewGroup.LayoutParams)window);
            n12 = this.mViewSpacingSpecified ? 1 : 0;
            if (n12 != 0) {
                n12 = this.mViewSpacingLeft;
                n11 = this.mViewSpacingTop;
                n10 = this.mViewSpacingRight;
                int n13 = this.mViewSpacingBottom;
                window2.setPadding(n12, n11, n10, n13);
            }
            if ((view = this.mListView) != null) {
                object = (LinearLayoutCompat$LayoutParams)object.getLayoutParams();
                n12 = 0;
                view = null;
                object.weight = 0.0f;
            }
        } else {
            n12 = 8;
            object.setVisibility(n12);
        }
    }

    private void setupTitle(ViewGroup viewGroup) {
        Object object = this.mCustomTitleView;
        int n10 = 8;
        if (object != null) {
            int n11 = -1;
            object = new ViewGroup.LayoutParams(n11, -2);
            View view = this.mCustomTitleView;
            boolean bl2 = false;
            Object var7_10 = null;
            viewGroup.addView(view, 0, (ViewGroup.LayoutParams)object);
            viewGroup = this.mWindow;
            int n12 = R$id.title_template;
            viewGroup = viewGroup.findViewById(n12);
            viewGroup.setVisibility(n10);
        } else {
            object = this.mWindow;
            int n13 = 16908294;
            object = (ImageView)object.findViewById(n13);
            this.mIconView = object;
            object = this.mTitle;
            int n14 = TextUtils.isEmpty((CharSequence)object) ^ 1;
            if (n14 != 0 && (n14 = this.mShowTitle) != 0) {
                viewGroup = this.mWindow;
                n14 = R$id.alertTitle;
                viewGroup = (TextView)viewGroup.findViewById(n14);
                this.mTitleView = viewGroup;
                object = this.mTitle;
                viewGroup.setText((CharSequence)object);
                int n15 = this.mIconId;
                if (n15 != 0) {
                    object = this.mIconView;
                    object.setImageResource(n15);
                } else {
                    viewGroup = this.mIcon;
                    if (viewGroup != null) {
                        object = this.mIconView;
                        object.setImageDrawable((Drawable)viewGroup);
                    } else {
                        viewGroup = this.mTitleView;
                        object = this.mIconView;
                        n14 = object.getPaddingLeft();
                        ImageView imageView = this.mIconView;
                        n13 = imageView.getPaddingTop();
                        ImageView imageView2 = this.mIconView;
                        int n16 = imageView2.getPaddingRight();
                        ImageView imageView3 = this.mIconView;
                        int n17 = imageView3.getPaddingBottom();
                        viewGroup.setPadding(n14, n13, n16, n17);
                        viewGroup = this.mIconView;
                        viewGroup.setVisibility(n10);
                    }
                }
            } else {
                object = this.mWindow;
                n13 = R$id.title_template;
                object.findViewById(n13).setVisibility(n10);
                object = this.mIconView;
                object.setVisibility(n10);
                viewGroup.setVisibility(n10);
            }
        }
    }

    private void setupView() {
        int n10;
        Object object = this.mWindow;
        int n11 = R$id.parentPanel;
        object = object.findViewById(n11);
        n11 = R$id.topPanel;
        View view = object.findViewById(n11);
        int n12 = R$id.contentPanel;
        Object object2 = object.findViewById(n12);
        int n13 = R$id.buttonPanel;
        View view2 = object.findViewById(n13);
        int n14 = R$id.customPanel;
        object = (ViewGroup)object.findViewById(n14);
        this.setupCustomContent((ViewGroup)object);
        Object object3 = object.findViewById(n11);
        View view3 = object.findViewById(n12);
        View view4 = object.findViewById(n13);
        object3 = this.resolvePanel((View)object3, view);
        view = this.resolvePanel(view3, (View)object2);
        view3 = this.resolvePanel(view4, view2);
        this.setupContent((ViewGroup)view);
        this.setupButtons((ViewGroup)view3);
        this.setupTitle((ViewGroup)object3);
        int n15 = 8;
        n13 = 1;
        int n16 = 0;
        view2 = null;
        if (object != null && (n10 = object.getVisibility()) != n15) {
            n10 = n13;
        } else {
            n10 = 0;
            object = null;
        }
        n14 = object3 != null && (n14 = object3.getVisibility()) != n15 ? n13 : 0;
        if (view3 != null && (n12 = view3.getVisibility()) != n15) {
            n12 = n13;
        } else {
            n12 = 0;
            view3 = null;
        }
        if (n12 == 0 && view != null && (object2 = view.findViewById(n15 = R$id.textSpacerNoButtons)) != null) {
            object2.setVisibility(0);
        }
        if (n14 != 0) {
            object2 = this.mScrollView;
            if (object2 != null) {
                object2.setClipToPadding(n13 != 0);
            }
            n15 = 0;
            object2 = null;
            CharSequence charSequence = this.mMessage;
            if (charSequence != null || (charSequence = this.mListView) != null) {
                n15 = R$id.titleDividerNoCustom;
                object2 = object3.findViewById(n15);
            }
            if (object2 != null) {
                object2.setVisibility(0);
            }
        } else if (view != null && (object3 = view.findViewById(n11 = R$id.textSpacerNoTitle)) != null) {
            object3.setVisibility(0);
        }
        if ((n15 = (object3 = this.mListView) instanceof AlertController$RecycleListView) != 0) {
            object3 = (AlertController$RecycleListView)((Object)object3);
            ((AlertController$RecycleListView)((Object)object3)).setHasDecor(n14 != 0, n12 != 0);
        }
        if (n10 == 0) {
            object = this.mListView;
            if (object == null) {
                object = this.mScrollView;
            }
            if (object != null) {
                if (n12 != 0) {
                    n16 = 2;
                }
                n11 = n14 | n16;
                n12 = 3;
                this.setScrollIndicators((ViewGroup)view, (View)object, n11, n12);
            }
        }
        if ((object = this.mListView) != null && (object3 = this.mAdapter) != null) {
            object.setAdapter((ListAdapter)object3);
            n11 = this.mCheckedItem;
            int n17 = -1;
            if (n11 > n17) {
                object.setItemChecked(n11, n13 != 0);
                object.setSelection(n11);
            }
        }
    }

    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue typedValue = new TypedValue();
        context = context.getTheme();
        int n10 = R$attr.alertDialogCenterButtons;
        boolean bl2 = true;
        context.resolveAttribute(n10, typedValue, bl2);
        int n11 = typedValue.data;
        if (n11 == 0) {
            bl2 = false;
        }
        return bl2;
    }

    public Button getButton(int n10) {
        int n11 = -3;
        if (n10 != n11) {
            n11 = -2;
            if (n10 != n11) {
                n11 = -1;
                if (n10 != n11) {
                    return null;
                }
                return this.mButtonPositive;
            }
            return this.mButtonNegative;
        }
        return this.mButtonNeutral;
    }

    public int getIconAttributeResId(int n10) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(n10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public void installContent() {
        int n10 = this.selectContentView();
        this.mDialog.setContentView(n10);
        this.setupView();
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        if (nestedScrollView != null && (n10 = (int)(nestedScrollView.executeKeyEvent(keyEvent) ? 1 : 0)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            nestedScrollView = null;
        }
        return n10 != 0;
    }

    public boolean onKeyUp(int n10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.mScrollView;
        if (nestedScrollView != null && (n10 = (int)(nestedScrollView.executeKeyEvent(keyEvent) ? 1 : 0)) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            nestedScrollView = null;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setButton(int n10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable2) {
        int n11;
        if (message == null && onClickListener != null) {
            message = this.mHandler.obtainMessage(n10, (Object)onClickListener);
        }
        if (n10 == (n11 = -3)) {
            this.mButtonNeutralText = charSequence;
            this.mButtonNeutralMessage = message;
            this.mButtonNeutralIcon = drawable2;
            return;
        }
        n11 = -2;
        if (n10 == n11) {
            this.mButtonNegativeText = charSequence;
            this.mButtonNegativeMessage = message;
            this.mButtonNegativeIcon = drawable2;
            return;
        }
        n11 = -1;
        if (n10 == n11) {
            this.mButtonPositiveText = charSequence;
            this.mButtonPositiveMessage = message;
            this.mButtonPositiveIcon = drawable2;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Button does not exist");
        throw illegalArgumentException;
    }

    public void setButtonPanelLayoutHint(int n10) {
        this.mButtonPanelLayoutHint = n10;
    }

    public void setCustomTitle(View view) {
        this.mCustomTitleView = view;
    }

    public void setIcon(int n10) {
        int n11 = 0;
        this.mIcon = null;
        this.mIconId = n10;
        ImageView imageView = this.mIconView;
        if (imageView != null) {
            if (n10 != 0) {
                n10 = 0;
                imageView.setVisibility(0);
                ImageView imageView2 = this.mIconView;
                n11 = this.mIconId;
                imageView2.setImageResource(n11);
            } else {
                n10 = 8;
                imageView.setVisibility(n10);
            }
        }
    }

    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        ImageView imageView = null;
        this.mIconId = 0;
        ImageView imageView2 = this.mIconView;
        if (imageView2 != null) {
            if (drawable2 != null) {
                imageView2.setVisibility(0);
                imageView = this.mIconView;
                imageView.setImageDrawable(drawable2);
            } else {
                int n10 = 8;
                imageView2.setVisibility(n10);
            }
        }
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        TextView textView = this.mMessageView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setView(int n10) {
        this.mView = null;
        this.mViewLayoutResId = n10;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = false;
    }

    public void setView(View view, int n10, int n11, int n12, int n13) {
        this.mView = view;
        this.mViewLayoutResId = 0;
        this.mViewSpacingSpecified = true;
        this.mViewSpacingLeft = n10;
        this.mViewSpacingTop = n11;
        this.mViewSpacingRight = n12;
        this.mViewSpacingBottom = n13;
    }
}

