/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.app.SearchableInfo
 *  android.content.ActivityNotFoundException
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.database.Cursor
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.Editable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.style.ImageSpan
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.TouchDelegate
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnFocusChangeListener
 *  android.view.View$OnKeyListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.TextView$OnEditorActionListener
 */
package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.SearchView$10;
import androidx.appcompat.widget.SearchView$4;
import androidx.appcompat.widget.SearchView$6;
import androidx.appcompat.widget.SearchView$7;
import androidx.appcompat.widget.SearchView$8;
import androidx.appcompat.widget.SearchView$9;
import androidx.appcompat.widget.SearchView$OnCloseListener;
import androidx.appcompat.widget.SearchView$OnQueryTextListener;
import androidx.appcompat.widget.SearchView$OnSuggestionListener;
import androidx.appcompat.widget.SearchView$PreQAutoCompleteTextViewReflector;
import androidx.appcompat.widget.SearchView$SavedState;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;
import androidx.appcompat.widget.SearchView$UpdatableTouchDelegate;
import androidx.appcompat.widget.SuggestionsAdapter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.ViewCompat;
import androidx.cursoradapter.widget.CursorAdapter;
import java.util.WeakHashMap;

public class SearchView
extends LinearLayoutCompat
implements CollapsibleActionView {
    public static final boolean DBG = false;
    private static final String IME_OPTION_NO_MICROPHONE = "nm";
    public static final String LOG_TAG = "SearchView";
    public static final SearchView$PreQAutoCompleteTextViewReflector PRE_API_29_HIDDEN_METHOD_INVOKER;
    private Bundle mAppSearchData;
    private boolean mClearingFocus;
    public final ImageView mCloseButton;
    private final ImageView mCollapsedIcon;
    private int mCollapsedImeOptions;
    private final CharSequence mDefaultQueryHint;
    private final View mDropDownAnchor;
    private boolean mExpandedInActionView;
    public final ImageView mGoButton;
    private boolean mIconified;
    private boolean mIconifiedByDefault;
    private int mMaxWidth;
    private CharSequence mOldQueryText;
    private final View.OnClickListener mOnClickListener;
    private SearchView$OnCloseListener mOnCloseListener;
    private final TextView.OnEditorActionListener mOnEditorActionListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;
    private final AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private SearchView$OnQueryTextListener mOnQueryChangeListener;
    public View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
    private View.OnClickListener mOnSearchClickListener;
    private SearchView$OnSuggestionListener mOnSuggestionListener;
    private final WeakHashMap mOutsideDrawablesCache;
    private CharSequence mQueryHint;
    private boolean mQueryRefinement;
    private Runnable mReleaseCursorRunnable;
    public final ImageView mSearchButton;
    private final View mSearchEditFrame;
    private final Drawable mSearchHintIcon;
    private final View mSearchPlate;
    public final SearchView$SearchAutoComplete mSearchSrcTextView;
    private Rect mSearchSrcTextViewBounds;
    private Rect mSearchSrtTextViewBoundsExpanded;
    public SearchableInfo mSearchable;
    private final View mSubmitArea;
    private boolean mSubmitButtonEnabled;
    private final int mSuggestionCommitIconResId;
    private final int mSuggestionRowLayout;
    public CursorAdapter mSuggestionsAdapter;
    private int[] mTemp;
    private int[] mTemp2;
    public View.OnKeyListener mTextKeyListener;
    private TextWatcher mTextWatcher;
    private SearchView$UpdatableTouchDelegate mTouchDelegate;
    private final Runnable mUpdateDrawableStateRunnable;
    private CharSequence mUserQuery;
    private final Intent mVoiceAppSearchIntent;
    public final ImageView mVoiceButton;
    private boolean mVoiceButtonEnabled;
    private final Intent mVoiceWebSearchIntent;

    static {
        SearchView$PreQAutoCompleteTextViewReflector searchView$PreQAutoCompleteTextViewReflector;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 < n11) {
            searchView$PreQAutoCompleteTextViewReflector = new SearchView$PreQAutoCompleteTextViewReflector();
        } else {
            n10 = 0;
            searchView$PreQAutoCompleteTextViewReflector = null;
        }
        PRE_API_29_HIDDEN_METHOD_INVOKER = searchView$PreQAutoCompleteTextViewReflector;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.searchViewStyle;
        this(context, attributeSet, n10);
    }

    public SearchView(Context context, AttributeSet attributeSet, int n10) {
        int n11;
        int n12;
        int n13;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        View view;
        Object object;
        SearchView searchView = this;
        super(context, attributeSet, n10);
        this.mSearchSrcTextViewBounds = object = new Rect();
        this.mSearchSrtTextViewBoundsExpanded = object = new Rect();
        int bl2 = 2;
        Object object2 = new int[bl2];
        this.mTemp = object2;
        object = new int[bl2];
        this.mTemp2 = (int[])object;
        super(this);
        this.mUpdateDrawableStateRunnable = object;
        super(this);
        this.mReleaseCursorRunnable = object;
        super();
        this.mOutsideDrawablesCache = object;
        super(this);
        this.mOnClickListener = object;
        object2 = new SearchView$6;
        super(this);
        this.mTextKeyListener = (View.OnKeyListener)object2;
        object2 = new SearchView$7;
        super(this);
        this.mOnEditorActionListener = (TextView.OnEditorActionListener)object2;
        Object object3 = new SearchView$8(this);
        this.mOnItemClickListener = object3;
        Object object4 = new SearchView$9(this);
        this.mOnItemSelectedListener = object4;
        Object object5 = new SearchView$10(this);
        this.mTextWatcher = object5;
        object5 = R$styleable.SearchView;
        Object object6 = context;
        Object object7 = attributeSet;
        int n14 = n10;
        object5 = TintTypedArray.obtainStyledAttributes(context, attributeSet, (int[])object5, n10, 0);
        object6 = LayoutInflater.from((Context)context);
        int n15 = R$styleable.SearchView_layout;
        n14 = R$layout.abc_search_view;
        n15 = ((TintTypedArray)object5).getResourceId(n15, n14);
        object6.inflate(n15, (ViewGroup)this, true);
        int n16 = R$id.search_src_text;
        object6 = (SearchView$SearchAutoComplete)this.findViewById(n16);
        this.mSearchSrcTextView = object6;
        ((SearchView$SearchAutoComplete)object6).setSearchView(this);
        n15 = R$id.search_edit_frame;
        object7 = this.findViewById(n15);
        this.mSearchEditFrame = object7;
        n15 = R$id.search_plate;
        object7 = this.findViewById(n15);
        this.mSearchPlate = object7;
        int n17 = R$id.submit_area;
        this.mSubmitArea = view = this.findViewById(n17);
        int n18 = R$id.search_button;
        this.mSearchButton = imageView5 = (ImageView)this.findViewById(n18);
        int n19 = R$id.search_go_btn;
        this.mGoButton = imageView4 = (ImageView)this.findViewById(n19);
        int n20 = R$id.search_close_btn;
        this.mCloseButton = imageView3 = (ImageView)this.findViewById(n20);
        int n21 = R$id.search_voice_btn;
        this.mVoiceButton = imageView2 = (ImageView)this.findViewById(n21);
        int n22 = R$id.search_mag_icon;
        this.mCollapsedIcon = imageView = (ImageView)this.findViewById(n22);
        n14 = R$styleable.SearchView_queryBackground;
        Drawable drawable2 = ((TintTypedArray)object5).getDrawable(n14);
        ViewCompat.setBackground((View)object7, drawable2);
        n15 = R$styleable.SearchView_submitBackground;
        object7 = ((TintTypedArray)object5).getDrawable(n15);
        ViewCompat.setBackground(view, (Drawable)object7);
        n15 = R$styleable.SearchView_searchIcon;
        drawable2 = ((TintTypedArray)object5).getDrawable(n15);
        imageView5.setImageDrawable(drawable2);
        n14 = R$styleable.SearchView_goIcon;
        drawable2 = ((TintTypedArray)object5).getDrawable(n14);
        imageView4.setImageDrawable(drawable2);
        n14 = R$styleable.SearchView_closeIcon;
        drawable2 = ((TintTypedArray)object5).getDrawable(n14);
        imageView3.setImageDrawable(drawable2);
        n14 = R$styleable.SearchView_voiceIcon;
        drawable2 = ((TintTypedArray)object5).getDrawable(n14);
        imageView2.setImageDrawable(drawable2);
        object7 = ((TintTypedArray)object5).getDrawable(n15);
        imageView.setImageDrawable((Drawable)object7);
        n15 = R$styleable.SearchView_searchHintIcon;
        object7 = ((TintTypedArray)object5).getDrawable(n15);
        this.mSearchHintIcon = object7;
        object7 = this.getResources();
        n14 = R$string.abc_searchview_description_search;
        object7 = object7.getString(n14);
        TooltipCompat.setTooltipText((View)imageView5, (CharSequence)object7);
        n15 = R$styleable.SearchView_suggestionRowLayout;
        n14 = R$layout.abc_search_dropdown_item_icons_2line;
        this.mSuggestionRowLayout = n15 = ((TintTypedArray)object5).getResourceId(n15, n14);
        n15 = R$styleable.SearchView_commitIcon;
        this.mSuggestionCommitIconResId = n13 = ((TintTypedArray)object5).getResourceId(n15, 0);
        imageView5.setOnClickListener((View.OnClickListener)object);
        imageView3.setOnClickListener((View.OnClickListener)object);
        imageView4.setOnClickListener((View.OnClickListener)object);
        imageView2.setOnClickListener((View.OnClickListener)object);
        object6.setOnClickListener((View.OnClickListener)object);
        object = this.mTextWatcher;
        object6.addTextChangedListener((TextWatcher)object);
        object6.setOnEditorActionListener((TextView.OnEditorActionListener)object2);
        object6.setOnItemClickListener((AdapterView.OnItemClickListener)object3);
        object6.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)object4);
        object = this.mTextKeyListener;
        object6.setOnKeyListener((View.OnKeyListener)object);
        super(this);
        object6.setOnFocusChangeListener((View.OnFocusChangeListener)object);
        int n23 = R$styleable.SearchView_iconifiedByDefault;
        boolean bl3 = ((TintTypedArray)object5).getBoolean(n23, true);
        this.setIconifiedByDefault(bl3);
        int n24 = R$styleable.SearchView_android_maxWidth;
        int n25 = -1;
        int n26 = ((TintTypedArray)object5).getDimensionPixelSize(n24, n25);
        if (n26 != n25) {
            this.setMaxWidth(n26);
        }
        int n27 = R$styleable.SearchView_defaultQueryHint;
        object = ((TintTypedArray)object5).getText(n27);
        searchView.mDefaultQueryHint = object;
        int n28 = R$styleable.SearchView_queryHint;
        object = ((TintTypedArray)object5).getText(n28);
        searchView.mQueryHint = object;
        int n30 = R$styleable.SearchView_android_imeOptions;
        n30 = ((TintTypedArray)object5).getInt(n30, n25);
        if (n30 != n25) {
            searchView.setImeOptions(n30);
        }
        if ((n12 = ((TintTypedArray)object5).getInt(n11 = R$styleable.SearchView_android_inputType, n25)) != n25) {
            searchView.setInputType(n12);
        }
        int n31 = R$styleable.SearchView_android_focusable;
        boolean bl4 = ((TintTypedArray)object5).getBoolean(n31, true);
        searchView.setFocusable(bl4);
        ((TintTypedArray)object5).recycle();
        object2 = "android.speech.action.WEB_SEARCH";
        super((String)object2);
        searchView.mVoiceWebSearchIntent = object;
        int n32 = 0x10000000;
        object.addFlags(n32);
        object4 = "web_search";
        object.putExtra("android.speech.extra.LANGUAGE_MODEL", (String)object4);
        object3 = "android.speech.action.RECOGNIZE_SPEECH";
        super((String)object3);
        searchView.mVoiceAppSearchIntent = object;
        object.addFlags(n32);
        int n33 = object6.getDropDownAnchor();
        object = searchView.findViewById(n33);
        searchView.mDropDownAnchor = object;
        if (object != null) {
            object2 = new SearchView$4;
            super(searchView);
            object.addOnLayoutChangeListener((View.OnLayoutChangeListener)object2);
        }
        boolean bl5 = searchView.mIconifiedByDefault;
        searchView.updateViewsVisibility(bl5);
        this.updateQueryHint();
    }

    private Intent createIntent(String charSequence, Uri object, String string2, String string3, int n10, String string4) {
        Intent intent = new Intent(charSequence);
        int n11 = 0x10000000;
        intent.addFlags(n11);
        if (object != null) {
            intent.setData(object);
        }
        charSequence = this.mUserQuery;
        object = "user_query";
        intent.putExtra((String)object, charSequence);
        if (string3 != null) {
            charSequence = "query";
            intent.putExtra(charSequence, string3);
        }
        if (string2 != null) {
            charSequence = "intent_extra_data_key";
            intent.putExtra(charSequence, string2);
        }
        if ((charSequence = this.mAppSearchData) != null) {
            object = "app_data";
            intent.putExtra((String)object, (Bundle)charSequence);
        }
        if (n10 != 0) {
            intent.putExtra("action_key", n10);
            charSequence = "action_msg";
            intent.putExtra(charSequence, string4);
        }
        charSequence = this.mSearchable.getSearchActivity();
        intent.setComponent((ComponentName)charSequence);
        return intent;
    }

    private Intent createIntentFromSuggestion(Cursor object, int n10, String charSequence) {
        CharSequence charSequence2;
        String string2;
        String string3;
        Object object2;
        block25: {
            block24: {
                block23: {
                    object2 = "suggest_intent_action";
                    try {
                        object2 = SuggestionsAdapter.getColumnString(object, (String)object2);
                        if (object2 != null) break block23;
                    }
                    catch (RuntimeException runtimeException) {
                        int n11;
                        try {
                            n11 = object.getPosition();
                        }
                        catch (RuntimeException runtimeException2) {
                            n11 = -1;
                        }
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Search suggestions cursor at row ");
                        ((StringBuilder)charSequence).append(n11);
                        ((StringBuilder)charSequence).append(" returned exception.");
                        object = ((StringBuilder)charSequence).toString();
                        Log.w((String)LOG_TAG, (String)object, (Throwable)runtimeException);
                        return null;
                    }
                    object2 = this.mSearchable;
                    object2 = object2.getSuggestIntentAction();
                }
                if (object2 == null) {
                    object2 = "android.intent.action.SEARCH";
                }
                string3 = object2;
                object2 = "suggest_intent_data";
                object2 = SuggestionsAdapter.getColumnString(object, (String)object2);
                if (object2 != null) break block24;
                object2 = this.mSearchable;
                object2 = object2.getSuggestIntentData();
            }
            if (object2 != null) {
                string2 = "suggest_intent_data_id";
                string2 = SuggestionsAdapter.getColumnString(object, string2);
                if (string2 == null) break block25;
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)object2);
                object2 = "/";
                ((StringBuilder)charSequence2).append((String)object2);
                object2 = Uri.encode((String)string2);
                ((StringBuilder)charSequence2).append((String)object2);
                object2 = ((StringBuilder)charSequence2).toString();
            }
        }
        if (object2 == null) {
            string2 = null;
        } else {
            object2 = Uri.parse((String)object2);
            string2 = object2;
        }
        object2 = "suggest_intent_query";
        String string4 = SuggestionsAdapter.getColumnString(object, (String)object2);
        object2 = "suggest_intent_extra_data";
        charSequence2 = SuggestionsAdapter.getColumnString(object, (String)object2);
        object2 = this;
        return this.createIntent(string3, (Uri)string2, (String)charSequence2, string4, n10, (String)charSequence);
    }

    private Intent createVoiceAppSearchIntent(Intent intent, SearchableInfo object) {
        String string2;
        String string3;
        String string4;
        ComponentName componentName = object.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(componentName);
        Context context = this.getContext();
        int n10 = 0x40000000;
        intent2 = PendingIntent.getActivity((Context)context, (int)0, (Intent)intent2, (int)n10);
        context = new Bundle();
        Bundle bundle = this.mAppSearchData;
        if (bundle != null) {
            string4 = "app_data";
            context.putParcelable(string4, (Parcelable)bundle);
        }
        bundle = new Intent(intent);
        int n11 = 1;
        string4 = this.getResources();
        int n12 = object.getVoiceLanguageModeId();
        if (n12 != 0) {
            n12 = object.getVoiceLanguageModeId();
            string3 = string4.getString(n12);
        } else {
            string3 = "free_form";
        }
        int n13 = object.getVoicePromptTextId();
        String string5 = null;
        if (n13 != 0) {
            n13 = object.getVoicePromptTextId();
            string2 = string4.getString(n13);
        } else {
            n13 = 0;
            string2 = null;
        }
        int n14 = object.getVoiceLanguageId();
        if (n14 != 0) {
            n14 = object.getVoiceLanguageId();
            string4 = string4.getString(n14);
        } else {
            n10 = 0;
            string4 = null;
        }
        n14 = object.getVoiceMaxResults();
        if (n14 != 0) {
            n11 = object.getVoiceMaxResults();
        }
        bundle.putExtra("android.speech.extra.LANGUAGE_MODEL", string3);
        bundle.putExtra("android.speech.extra.PROMPT", string2);
        bundle.putExtra("android.speech.extra.LANGUAGE", string4);
        object = "android.speech.extra.MAX_RESULTS";
        bundle.putExtra((String)object, n11);
        if (componentName != null) {
            string5 = componentName.flattenToShortString();
        }
        bundle.putExtra("calling_package", string5);
        bundle.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", (Parcelable)intent2);
        bundle.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", (Bundle)context);
        return bundle;
    }

    private Intent createVoiceWebSearchIntent(Intent object, SearchableInfo searchableInfo) {
        Intent intent = new Intent(object);
        object = searchableInfo.getSearchActivity();
        object = object == null ? null : object.flattenToShortString();
        intent.putExtra("calling_package", (String)object);
        return intent;
    }

    private void dismissSuggestions() {
        this.mSearchSrcTextView.dismissDropDown();
    }

    private void getChildBoundsWithinSearchView(View view, Rect rect) {
        int[] nArray = this.mTemp;
        view.getLocationInWindow(nArray);
        nArray = this.mTemp2;
        this.getLocationInWindow(nArray);
        nArray = this.mTemp;
        int n10 = 1;
        int n11 = nArray[n10];
        int[] nArray2 = this.mTemp2;
        n10 = nArray2[n10];
        n11 -= n10;
        int n12 = nArray[0];
        n10 = nArray2[0];
        n12 -= n10;
        n10 = view.getWidth() + n12;
        int n13 = view.getHeight() + n11;
        rect.set(n12, n11, n10, n13);
    }

    private CharSequence getDecoratedHint(CharSequence charSequence) {
        Drawable drawable2;
        int n10 = this.mIconifiedByDefault;
        if (n10 != 0 && (drawable2 = this.mSearchHintIcon) != null) {
            n10 = (int)((double)this.mSearchSrcTextView.getTextSize() * 1.25);
            this.mSearchHintIcon.setBounds(0, 0, n10, n10);
            drawable2 = new SpannableStringBuilder((CharSequence)"   ");
            Drawable drawable3 = this.mSearchHintIcon;
            ImageSpan imageSpan = new ImageSpan(drawable3);
            drawable2.setSpan((Object)imageSpan, 1, 2, 33);
            drawable2.append(charSequence);
            return drawable2;
        }
        return charSequence;
    }

    private int getPreferredHeight() {
        Resources resources = this.getContext().getResources();
        int n10 = R$dimen.abc_search_view_preferred_height;
        return resources.getDimensionPixelSize(n10);
    }

    private int getPreferredWidth() {
        Resources resources = this.getContext().getResources();
        int n10 = R$dimen.abc_search_view_preferred_width;
        return resources.getDimensionPixelSize(n10);
    }

    private boolean hasVoiceSearch() {
        boolean bl2;
        SearchableInfo searchableInfo = this.mSearchable;
        boolean bl3 = false;
        if (searchableInfo != null && (bl2 = searchableInfo.getVoiceSearchEnabled())) {
            int n10;
            bl2 = false;
            searchableInfo = null;
            SearchableInfo searchableInfo2 = this.mSearchable;
            boolean bl4 = searchableInfo2.getVoiceSearchLaunchWebSearch();
            if (bl4) {
                searchableInfo = this.mVoiceWebSearchIntent;
            } else {
                searchableInfo2 = this.mSearchable;
                bl4 = searchableInfo2.getVoiceSearchLaunchRecognizer();
                if (bl4) {
                    searchableInfo = this.mVoiceAppSearchIntent;
                }
            }
            if (searchableInfo != null && (searchableInfo = (searchableInfo2 = this.getContext().getPackageManager()).resolveActivity((Intent)searchableInfo, n10 = 65536)) != null) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public static boolean isLandscapeMode(Context context) {
        context = context.getResources().getConfiguration();
        int n10 = context.orientation;
        int n11 = 2;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    private boolean isSubmitAreaEnabled() {
        boolean bl2 = this.mSubmitButtonEnabled;
        bl2 = (bl2 || (bl2 = this.mVoiceButtonEnabled)) && !(bl2 = this.isIconified());
        return bl2;
    }

    private void launchIntent(Intent object) {
        if (object == null) {
            return;
        }
        Context context = this.getContext();
        try {
            context.startActivity(object);
        }
        catch (RuntimeException runtimeException) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "Failed launch activity: ";
            charSequence.append(string2);
            charSequence.append(object);
            object = charSequence.toString();
            charSequence = LOG_TAG;
            Log.e((String)charSequence, (String)object, (Throwable)runtimeException);
        }
    }

    private boolean launchSuggestion(int n10, int n11, String string2) {
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor != null && (n10 = (int)(cursor.moveToPosition(n10) ? 1 : 0)) != 0) {
            Intent intent = this.createIntentFromSuggestion(cursor, n11, string2);
            this.launchIntent(intent);
            return true;
        }
        return false;
    }

    private void postUpdateFocusedState() {
        Runnable runnable = this.mUpdateDrawableStateRunnable;
        this.post(runnable);
    }

    private void rewriteQueryFromSuggestion(int n10) {
        Editable editable = this.mSearchSrcTextView.getText();
        Cursor cursor = this.mSuggestionsAdapter.getCursor();
        if (cursor == null) {
            return;
        }
        if ((n10 = (int)(cursor.moveToPosition(n10) ? 1 : 0)) != 0) {
            CharSequence charSequence = this.mSuggestionsAdapter.convertToString(cursor);
            if (charSequence != null) {
                this.setQuery(charSequence);
            } else {
                this.setQuery((CharSequence)editable);
            }
        } else {
            this.setQuery((CharSequence)editable);
        }
    }

    private void setQuery(CharSequence charSequence) {
        int n10;
        this.mSearchSrcTextView.setText(charSequence);
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            n10 = 0;
            charSequence = null;
        } else {
            n10 = charSequence.length();
        }
        searchView$SearchAutoComplete.setSelection(n10);
    }

    private void updateCloseButton() {
        Drawable drawable2;
        boolean bl2;
        Object object = this.mSearchSrcTextView.getText();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        boolean bl4 = true;
        int n10 = 0;
        if (!((bl3 ^= bl4) || (bl2 = this.mIconifiedByDefault) && !(bl2 = this.mExpandedInActionView))) {
            bl4 = false;
            drawable2 = null;
        }
        ImageView imageView = this.mCloseButton;
        if (!bl4) {
            n10 = 8;
        }
        imageView.setVisibility(n10);
        drawable2 = this.mCloseButton.getDrawable();
        if (drawable2 != null) {
            object = bl3 ? (Object)ViewGroup.ENABLED_STATE_SET : (Object)ViewGroup.EMPTY_STATE_SET;
            drawable2.setState((int[])object);
        }
    }

    private void updateQueryHint() {
        CharSequence charSequence = this.getQueryHint();
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        if (charSequence == null) {
            charSequence = "";
        }
        charSequence = this.getDecoratedHint(charSequence);
        searchView$SearchAutoComplete.setHint(charSequence);
    }

    private void updateSearchAutoComplete() {
        Object object = this.mSearchSrcTextView;
        int n10 = this.mSearchable.getSuggestThreshold();
        ((SearchView$SearchAutoComplete)object).setThreshold(n10);
        object = this.mSearchSrcTextView;
        Object object2 = this.mSearchable;
        n10 = object2.getImeOptions();
        object.setImeOptions(n10);
        object = this.mSearchable;
        int n11 = object.getInputType();
        n10 = n11 & 0xF;
        int n12 = 1;
        if (n10 == n12) {
            n10 = -65537;
            n11 &= n10;
            object2 = this.mSearchable.getSuggestAuthority();
            if (object2 != null) {
                n11 |= 0x10000;
                n10 = 524288;
                n11 |= n10;
            }
        }
        object2 = this.mSearchSrcTextView;
        object2.setInputType(n11);
        object = this.mSuggestionsAdapter;
        if (object != null) {
            n10 = 0;
            object2 = null;
            ((CursorAdapter)object).changeCursor(null);
        }
        if ((object = this.mSearchable.getSuggestAuthority()) != null) {
            object2 = this.getContext();
            SearchableInfo searchableInfo = this.mSearchable;
            WeakHashMap weakHashMap = this.mOutsideDrawablesCache;
            this.mSuggestionsAdapter = object = new SuggestionsAdapter((Context)object2, this, searchableInfo, weakHashMap);
            object2 = this.mSearchSrcTextView;
            object2.setAdapter((ListAdapter)object);
            object = (SuggestionsAdapter)this.mSuggestionsAdapter;
            n10 = (int)(this.mQueryRefinement ? 1 : 0);
            if (n10 != 0) {
                n12 = 2;
            }
            ((SuggestionsAdapter)object).setQueryRefinement(n12);
        }
    }

    private void updateSubmitArea() {
        ImageView imageView;
        int n10 = this.isSubmitAreaEnabled();
        if (n10 != 0 && ((n10 = (imageView = this.mGoButton).getVisibility()) == 0 || (n10 = (imageView = this.mVoiceButton).getVisibility()) == 0)) {
            n10 = 0;
            imageView = null;
        } else {
            n10 = 8;
        }
        this.mSubmitArea.setVisibility(n10);
    }

    private void updateSubmitButton(boolean n10) {
        boolean bl2 = this.mSubmitButtonEnabled;
        n10 = bl2 && (bl2 = this.isSubmitAreaEnabled()) && (bl2 = this.hasFocus()) && (n10 != 0 || (n10 = this.mVoiceButtonEnabled) == 0) ? 0 : 8;
        this.mGoButton.setVisibility(n10);
    }

    /*
     * WARNING - void declaration
     */
    private void updateViewsVisibility(boolean bl2) {
        boolean bl3;
        void var1_4;
        Drawable drawable2;
        View view;
        int n10;
        this.mIconified = bl2;
        int n11 = 0;
        int n12 = 8;
        if (bl2) {
            n10 = 0;
            view = null;
        } else {
            n10 = n12;
        }
        Editable editable = this.mSearchSrcTextView.getText();
        boolean bl4 = TextUtils.isEmpty((CharSequence)editable) ^ true;
        ImageView imageView = this.mSearchButton;
        imageView.setVisibility(n10);
        this.updateSubmitButton(bl4);
        view = this.mSearchEditFrame;
        if (bl2) {
            int n13 = n12;
        } else {
            boolean bl5 = false;
            drawable2 = null;
        }
        view.setVisibility((int)var1_4);
        drawable2 = this.mCollapsedIcon.getDrawable();
        if (drawable2 == null || (bl3 = this.mIconifiedByDefault)) {
            n11 = n12;
        }
        this.mCollapsedIcon.setVisibility(n11);
        this.updateCloseButton();
        boolean bl6 = bl4 ^ true;
        this.updateVoiceButton(bl6);
        this.updateSubmitArea();
    }

    private void updateVoiceButton(boolean bl2) {
        boolean bl3 = this.mVoiceButtonEnabled;
        int n10 = 8;
        if (bl3 && !(bl3 = this.isIconified()) && bl2) {
            bl2 = false;
            ImageView imageView = this.mGoButton;
            imageView.setVisibility(n10);
            n10 = 0;
        }
        this.mVoiceButton.setVisibility(n10);
    }

    public void adjustDropDownSizeAndPosition() {
        int n10;
        View view = this.mDropDownAnchor;
        int n11 = view.getWidth();
        if (n11 > (n10 = 1)) {
            view = this.getContext().getResources();
            Object object = this.mSearchPlate;
            n10 = object.getPaddingLeft();
            Rect rect = new Rect();
            int n12 = ViewUtils.isLayoutRtl((View)this);
            int n13 = this.mIconifiedByDefault;
            if (n13 != 0) {
                n13 = R$dimen.abc_dropdownitem_icon_width;
                n13 = view.getDimensionPixelSize(n13);
                int n14 = R$dimen.abc_dropdownitem_text_padding_left;
                n11 = view.getDimensionPixelSize(n14);
                n13 += n11;
            } else {
                n13 = 0;
            }
            view = this.mSearchSrcTextView.getDropDownBackground();
            view.getPadding(rect);
            if (n12 != 0) {
                n11 = -rect.left;
            } else {
                n11 = rect.left + n13;
                n11 = n10 - n11;
            }
            SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
            searchView$SearchAutoComplete.setDropDownHorizontalOffset(n11);
            view = this.mDropDownAnchor;
            n11 = view.getWidth();
            n12 = rect.left;
            n11 += n12;
            int n15 = rect.right;
            n11 = n11 + n15 + n13 - n10;
            object = this.mSearchSrcTextView;
            object.setDropDownWidth(n11);
        }
    }

    public void clearFocus() {
        this.mClearingFocus = true;
        super.clearFocus();
        this.mSearchSrcTextView.clearFocus();
        this.mSearchSrcTextView.setImeVisibility(false);
        this.mClearingFocus = false;
    }

    public void forceSuggestionQuery() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
            searchView$SearchAutoComplete.refreshAutoCompleteResults();
        } else {
            SearchView$PreQAutoCompleteTextViewReflector searchView$PreQAutoCompleteTextViewReflector = PRE_API_29_HIDDEN_METHOD_INVOKER;
            SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
            searchView$PreQAutoCompleteTextViewReflector.doBeforeTextChanged(searchView$SearchAutoComplete);
            searchView$SearchAutoComplete = this.mSearchSrcTextView;
            searchView$PreQAutoCompleteTextViewReflector.doAfterTextChanged(searchView$SearchAutoComplete);
        }
    }

    public int getImeOptions() {
        return this.mSearchSrcTextView.getImeOptions();
    }

    public int getInputType() {
        return this.mSearchSrcTextView.getInputType();
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public CharSequence getQuery() {
        return this.mSearchSrcTextView.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.mQueryHint;
        if (charSequence == null) {
            int n10;
            charSequence = this.mSearchable;
            if (charSequence != null && (n10 = charSequence.getHintId()) != 0) {
                charSequence = this.getContext();
                SearchableInfo searchableInfo = this.mSearchable;
                int n11 = searchableInfo.getHintId();
                charSequence = charSequence.getText(n11);
            } else {
                charSequence = this.mDefaultQueryHint;
            }
        }
        return charSequence;
    }

    public int getSuggestionCommitIconResId() {
        return this.mSuggestionCommitIconResId;
    }

    public int getSuggestionRowLayout() {
        return this.mSuggestionRowLayout;
    }

    public CursorAdapter getSuggestionsAdapter() {
        return this.mSuggestionsAdapter;
    }

    public boolean isIconfiedByDefault() {
        return this.mIconifiedByDefault;
    }

    public boolean isIconified() {
        return this.mIconified;
    }

    public boolean isQueryRefinementEnabled() {
        return this.mQueryRefinement;
    }

    public boolean isSubmitButtonEnabled() {
        return this.mSubmitButtonEnabled;
    }

    public void launchQuerySearch(int n10, String string2, String string3) {
        Intent intent = this.createIntent("android.intent.action.SEARCH", null, null, string3, n10, string2);
        this.getContext().startActivity(intent);
    }

    public void onActionViewCollapsed() {
        this.setQuery("", false);
        this.clearFocus();
        this.updateViewsVisibility(true);
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        int n10 = this.mCollapsedImeOptions;
        searchView$SearchAutoComplete.setImeOptions(n10);
        this.mExpandedInActionView = false;
    }

    public void onActionViewExpanded() {
        int n10 = this.mExpandedInActionView;
        if (n10 != 0) {
            return;
        }
        this.mExpandedInActionView = true;
        this.mCollapsedImeOptions = n10 = this.mSearchSrcTextView.getImeOptions();
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        searchView$SearchAutoComplete.setImeOptions(n10 |= 0x2000000);
        this.mSearchSrcTextView.setText("");
        this.setIconified(false);
    }

    public void onCloseClicked() {
        Object object = this.mSearchSrcTextView.getText();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        boolean bl3 = true;
        if (bl2) {
            bl2 = this.mIconifiedByDefault;
            if (bl2 && ((object = this.mOnCloseListener) == null || !(bl2 = object.onClose()))) {
                this.clearFocus();
                this.updateViewsVisibility(bl3);
            }
        } else {
            object = this.mSearchSrcTextView;
            String string2 = "";
            object.setText((CharSequence)string2);
            this.mSearchSrcTextView.requestFocus();
            object = this.mSearchSrcTextView;
            ((SearchView$SearchAutoComplete)object).setImeVisibility(bl3);
        }
    }

    public void onDetachedFromWindow() {
        Runnable runnable = this.mUpdateDrawableStateRunnable;
        this.removeCallbacks(runnable);
        runnable = this.mReleaseCursorRunnable;
        this.post(runnable);
        super.onDetachedFromWindow();
    }

    public boolean onItemClicked(int n10, int n11, String string2) {
        SearchView$OnSuggestionListener searchView$OnSuggestionListener = this.mOnSuggestionListener;
        if (searchView$OnSuggestionListener != null && (n11 = (int)(searchView$OnSuggestionListener.onSuggestionClick(n10) ? 1 : 0)) != 0) {
            return false;
        }
        this.launchSuggestion(n10, 0, null);
        this.mSearchSrcTextView.setImeVisibility(false);
        this.dismissSuggestions();
        return true;
    }

    public boolean onItemSelected(int n10) {
        boolean bl2;
        SearchView$OnSuggestionListener searchView$OnSuggestionListener = this.mOnSuggestionListener;
        if (searchView$OnSuggestionListener != null && (bl2 = searchView$OnSuggestionListener.onSuggestionSelect(n10))) {
            return false;
        }
        this.rewriteQueryFromSuggestion(n10);
        return true;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        if (bl2) {
            Object object = this.mSearchSrcTextView;
            Rect rect = this.mSearchSrcTextViewBounds;
            this.getChildBoundsWithinSearchView((View)object, rect);
            object = this.mSearchSrtTextViewBoundsExpanded;
            rect = this.mSearchSrcTextViewBounds;
            n12 = rect.left;
            n10 = rect.right;
            object.set(n12, 0, n10, n13 -= n11);
            object = this.mTouchDelegate;
            if (object == null) {
                rect = this.mSearchSrtTextViewBoundsExpanded;
                Rect rect2 = this.mSearchSrcTextViewBounds;
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
                object = new SearchView$UpdatableTouchDelegate(rect, rect2, (View)searchView$SearchAutoComplete);
                this.mTouchDelegate = object;
                this.setTouchDelegate((TouchDelegate)object);
            } else {
                rect = this.mSearchSrtTextViewBoundsExpanded;
                Rect rect3 = this.mSearchSrcTextViewBounds;
                ((SearchView$UpdatableTouchDelegate)((Object)object)).setBounds(rect, rect3);
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.isIconified();
        if (n12 != 0) {
            super.onMeasure(n10, n11);
            return;
        }
        n12 = View.MeasureSpec.getMode((int)n10);
        n10 = View.MeasureSpec.getSize((int)n10);
        int n13 = -1 << -1;
        int n14 = 0x40000000;
        if (n12 != n13) {
            if (n12 != 0) {
                if (n12 == n14 && (n12 = this.mMaxWidth) > 0) {
                    n10 = Math.min(n12, n10);
                }
            } else {
                n10 = this.mMaxWidth;
                if (n10 <= 0) {
                    n10 = this.getPreferredWidth();
                }
            }
        } else {
            n12 = this.mMaxWidth;
            if (n12 > 0) {
                n10 = Math.min(n12, n10);
            } else {
                n12 = this.getPreferredWidth();
                n10 = Math.min(n12, n10);
            }
        }
        n12 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        if (n12 != n13) {
            if (n12 == 0) {
                n11 = this.getPreferredHeight();
            }
        } else {
            n12 = this.getPreferredHeight();
            n11 = Math.min(n12, n11);
        }
        n10 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n14);
        n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n14);
        super.onMeasure(n10, n11);
    }

    public void onQueryRefine(CharSequence charSequence) {
        this.setQuery(charSequence);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof SearchView$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SearchView$SavedState)parcelable;
        Parcelable parcelable2 = parcelable.getSuperState();
        super.onRestoreInstanceState(parcelable2);
        boolean bl3 = parcelable.isIconified;
        this.updateViewsVisibility(bl3);
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        boolean bl2;
        Parcelable parcelable = super.onSaveInstanceState();
        SearchView$SavedState searchView$SavedState = new SearchView$SavedState(parcelable);
        searchView$SavedState.isIconified = bl2 = this.isIconified();
        return searchView$SavedState;
    }

    public void onSearchClicked() {
        this.updateViewsVisibility(false);
        this.mSearchSrcTextView.requestFocus();
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        boolean bl2 = true;
        searchView$SearchAutoComplete.setImeVisibility(bl2);
        searchView$SearchAutoComplete = this.mOnSearchClickListener;
        if (searchView$SearchAutoComplete != null) {
            searchView$SearchAutoComplete.onClick((View)this);
        }
    }

    public void onSubmitQuery() {
        String string2;
        SearchView$OnQueryTextListener searchView$OnQueryTextListener;
        int n10;
        Object object = this.mSearchSrcTextView.getText();
        if (object != null && (n10 = TextUtils.getTrimmedLength((CharSequence)object)) > 0 && ((searchView$OnQueryTextListener = this.mOnQueryChangeListener) == null || (n10 = (int)(searchView$OnQueryTextListener.onQueryTextSubmit(string2 = object.toString()) ? 1 : 0)) == 0)) {
            searchView$OnQueryTextListener = this.mSearchable;
            string2 = null;
            if (searchView$OnQueryTextListener != null) {
                n10 = 0;
                searchView$OnQueryTextListener = null;
                object = object.toString();
                this.launchQuerySearch(0, null, (String)object);
            }
            object = this.mSearchSrcTextView;
            ((SearchView$SearchAutoComplete)object).setImeVisibility(false);
            this.dismissSuggestions();
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean onSuggestionsKey(View object, int n10, KeyEvent keyEvent) {
        void var2_7;
        void var3_8;
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo == null) {
            return false;
        }
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        if (cursorAdapter == null) {
            return false;
        }
        int n11 = var3_8.getAction();
        if (n11 != 0 || (n11 = (int)(var3_8.hasNoModifiers() ? 1 : 0)) == 0) return false;
        n11 = 66;
        if (var2_7 != n11 && var2_7 != (n11 = 84) && var2_7 != (n11 = 61)) {
            int n12;
            n11 = 21;
            if (var2_7 != n11 && var2_7 != (n12 = 22)) {
                SearchView$SearchAutoComplete searchView$SearchAutoComplete;
                n11 = 19;
                if (var2_7 != n11 || (n11 = (searchView$SearchAutoComplete = this.mSearchSrcTextView).getListSelection()) != 0) return false;
                return false;
            }
            if (var2_7 == n11) {
                n11 = 0;
                Object var1_5 = null;
            } else {
                SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
                n11 = searchView$SearchAutoComplete.length();
            }
            this.mSearchSrcTextView.setSelection(n11);
            this.mSearchSrcTextView.setListSelection(0);
            this.mSearchSrcTextView.clearListSelection();
            this.mSearchSrcTextView.ensureImeVisible();
            return true;
        }
        n11 = this.mSearchSrcTextView.getListSelection();
        return this.onItemClicked(n11, 0, null);
    }

    public void onTextChanged(CharSequence charSequence) {
        Object object = this.mSearchSrcTextView.getText();
        this.mUserQuery = object;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object) ^ true;
        this.updateSubmitButton(bl2);
        this.updateVoiceButton(bl2 ^= true);
        this.updateCloseButton();
        this.updateSubmitArea();
        object = this.mOnQueryChangeListener;
        if (object != null && !(bl2 = TextUtils.equals((CharSequence)charSequence, (CharSequence)(object = this.mOldQueryText)))) {
            object = this.mOnQueryChangeListener;
            String string2 = charSequence.toString();
            object.onQueryTextChange(string2);
        }
        this.mOldQueryText = charSequence = charSequence.toString();
    }

    public void onTextFocusChanged() {
        boolean bl2 = this.isIconified();
        this.updateViewsVisibility(bl2);
        this.postUpdateFocusedState();
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        bl2 = searchView$SearchAutoComplete.hasFocus();
        if (bl2) {
            this.forceSuggestionQuery();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onVoiceClicked() {
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo == null) {
            return;
        }
        try {
            boolean bl2 = searchableInfo.getVoiceSearchLaunchWebSearch();
            if (bl2) {
                Intent intent = this.mVoiceWebSearchIntent;
                Intent intent2 = this.createVoiceWebSearchIntent(intent, searchableInfo);
                intent = this.getContext();
                intent.startActivity(intent2);
                return;
            }
            bl2 = searchableInfo.getVoiceSearchLaunchRecognizer();
            if (!bl2) return;
            Intent intent = this.mVoiceAppSearchIntent;
            Intent intent3 = this.createVoiceAppSearchIntent(intent, searchableInfo);
            intent = this.getContext();
            intent.startActivity(intent3);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            String string2 = LOG_TAG;
            String string3 = "Could not find voice search activity";
            Log.w((String)string2, (String)string3);
        }
    }

    public void onWindowFocusChanged(boolean bl2) {
        super.onWindowFocusChanged(bl2);
        this.postUpdateFocusedState();
    }

    public boolean requestFocus(int n10, Rect rect) {
        boolean bl2 = this.mClearingFocus;
        if (bl2) {
            return false;
        }
        bl2 = this.isFocusable();
        if (!bl2) {
            return false;
        }
        bl2 = this.isIconified();
        if (!bl2) {
            SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
            if ((n10 = (int)(searchView$SearchAutoComplete.requestFocus(n10, rect) ? 1 : 0)) != 0) {
                this.updateViewsVisibility(false);
            }
            return n10 != 0;
        }
        return super.requestFocus(n10, rect);
    }

    public void setAppSearchData(Bundle bundle) {
        this.mAppSearchData = bundle;
    }

    public void setIconified(boolean bl2) {
        if (bl2) {
            this.onCloseClicked();
        } else {
            this.onSearchClicked();
        }
    }

    public void setIconifiedByDefault(boolean bl2) {
        boolean bl3 = this.mIconifiedByDefault;
        if (bl3 == bl2) {
            return;
        }
        this.mIconifiedByDefault = bl2;
        this.updateViewsVisibility(bl2);
        this.updateQueryHint();
    }

    public void setImeOptions(int n10) {
        this.mSearchSrcTextView.setImeOptions(n10);
    }

    public void setInputType(int n10) {
        this.mSearchSrcTextView.setInputType(n10);
    }

    public void setMaxWidth(int n10) {
        this.mMaxWidth = n10;
        this.requestLayout();
    }

    public void setOnCloseListener(SearchView$OnCloseListener searchView$OnCloseListener) {
        this.mOnCloseListener = searchView$OnCloseListener;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.mOnQueryTextFocusChangeListener = onFocusChangeListener;
    }

    public void setOnQueryTextListener(SearchView$OnQueryTextListener searchView$OnQueryTextListener) {
        this.mOnQueryChangeListener = searchView$OnQueryTextListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mOnSearchClickListener = onClickListener;
    }

    public void setOnSuggestionListener(SearchView$OnSuggestionListener searchView$OnSuggestionListener) {
        this.mOnSuggestionListener = searchView$OnSuggestionListener;
    }

    public void setQuery(CharSequence charSequence, boolean bl2) {
        boolean bl3;
        SearchView$SearchAutoComplete searchView$SearchAutoComplete = this.mSearchSrcTextView;
        searchView$SearchAutoComplete.setText(charSequence);
        if (charSequence != null) {
            searchView$SearchAutoComplete = this.mSearchSrcTextView;
            int n10 = searchView$SearchAutoComplete.length();
            searchView$SearchAutoComplete.setSelection(n10);
            this.mUserQuery = charSequence;
        }
        if (bl2 && !(bl3 = TextUtils.isEmpty((CharSequence)charSequence))) {
            this.onSubmitQuery();
        }
    }

    public void setQueryHint(CharSequence charSequence) {
        this.mQueryHint = charSequence;
        this.updateQueryHint();
    }

    /*
     * WARNING - void declaration
     */
    public void setQueryRefinementEnabled(boolean bl2) {
        this.mQueryRefinement = bl2;
        CursorAdapter cursorAdapter = this.mSuggestionsAdapter;
        boolean bl3 = cursorAdapter instanceof SuggestionsAdapter;
        if (bl3) {
            void var1_4;
            cursorAdapter = (SuggestionsAdapter)cursorAdapter;
            if (bl2) {
                int n10 = 2;
            } else {
                boolean bl4 = true;
            }
            ((SuggestionsAdapter)cursorAdapter).setQueryRefinement((int)var1_4);
        }
    }

    public void setSearchableInfo(SearchableInfo object) {
        boolean bl2;
        this.mSearchable = object;
        if (object != null) {
            this.updateSearchAutoComplete();
            this.updateQueryHint();
        }
        this.mVoiceButtonEnabled = bl2 = this.hasVoiceSearch();
        if (bl2) {
            object = this.mSearchSrcTextView;
            String string2 = IME_OPTION_NO_MICROPHONE;
            object.setPrivateImeOptions(string2);
        }
        bl2 = this.isIconified();
        this.updateViewsVisibility(bl2);
    }

    public void setSubmitButtonEnabled(boolean bl2) {
        this.mSubmitButtonEnabled = bl2;
        bl2 = this.isIconified();
        this.updateViewsVisibility(bl2);
    }

    public void setSuggestionsAdapter(CursorAdapter cursorAdapter) {
        this.mSuggestionsAdapter = cursorAdapter;
        this.mSearchSrcTextView.setAdapter((ListAdapter)cursorAdapter);
    }

    public void updateFocusedState() {
        Object object = this.mSearchSrcTextView;
        boolean bl2 = object.hasFocus();
        object = bl2 ? (Object)ViewGroup.FOCUSED_STATE_SET : (Object)ViewGroup.EMPTY_STATE_SET;
        Drawable drawable2 = this.mSearchPlate.getBackground();
        if (drawable2 != null) {
            drawable2.setState((int[])object);
        }
        if ((drawable2 = this.mSubmitArea.getBackground()) != null) {
            drawable2.setState((int[])object);
        }
        this.invalidate();
    }
}

