/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.KeyEvent
 *  android.view.KeyEvent$DispatcherState
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputMethodManager
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView$PreQAutoCompleteTextViewReflector;

public class SearchView$SearchAutoComplete
extends AppCompatAutoCompleteTextView {
    private boolean mHasPendingShowSoftInputRequest;
    public final Runnable mRunShowSoftInputIfNecessary;
    private SearchView mSearchView;
    private int mThreshold;

    public SearchView$SearchAutoComplete(Context context) {
        this(context, null);
    }

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.autoCompleteTextViewStyle;
        this(context, attributeSet, n10);
    }

    public SearchView$SearchAutoComplete(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int n11;
        super(this);
        this.mRunShowSoftInputIfNecessary = object;
        this.mThreshold = n11 = this.getThreshold();
    }

    private int getSearchViewTextMinWidthDp() {
        int n10;
        Configuration configuration = this.getResources().getConfiguration();
        int n11 = configuration.screenWidthDp;
        int n12 = configuration.screenHeightDp;
        int n13 = 960;
        if (n11 >= n13 && n12 >= (n13 = 720) && (n10 = configuration.orientation) == (n13 = 2)) {
            return 256;
        }
        n10 = 600;
        if (n11 < n10 && (n11 < (n10 = 640) || n12 < (n10 = 480))) {
            return 160;
        }
        return 192;
    }

    public boolean enoughToFilter() {
        int n10 = this.mThreshold;
        n10 = n10 > 0 && !(n10 = (int)(super.enoughToFilter() ? 1 : 0)) ? 0 : 1;
        return n10 != 0;
    }

    public void ensureImeVisible() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            this.setInputMethodMode(1);
            n10 = (int)(this.enoughToFilter() ? 1 : 0);
            if (n10 != 0) {
                this.showDropDown();
            }
        } else {
            SearchView$PreQAutoCompleteTextViewReflector searchView$PreQAutoCompleteTextViewReflector = SearchView.PRE_API_29_HIDDEN_METHOD_INVOKER;
            searchView$PreQAutoCompleteTextViewReflector.ensureImeVisible(this);
        }
    }

    public boolean isEmpty() {
        Editable editable = this.getText();
        int n10 = TextUtils.getTrimmedLength((CharSequence)editable);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            editable = null;
        }
        return n10 != 0;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo = super.onCreateInputConnection(editorInfo);
        boolean bl2 = this.mHasPendingShowSoftInputRequest;
        if (bl2) {
            Runnable runnable = this.mRunShowSoftInputIfNecessary;
            this.removeCallbacks(runnable);
            runnable = this.mRunShowSoftInputIfNecessary;
            this.post(runnable);
        }
        return editorInfo;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        float f10 = this.getSearchViewTextMinWidthDp();
        int n10 = (int)TypedValue.applyDimension((int)1, (float)f10, (DisplayMetrics)displayMetrics);
        this.setMinWidth(n10);
    }

    public void onFocusChanged(boolean bl2, int n10, Rect rect) {
        super.onFocusChanged(bl2, n10, rect);
        this.mSearchView.onTextFocusChanged();
    }

    public boolean onKeyPreIme(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11) {
            n11 = keyEvent.getAction();
            int n12 = 1;
            if (!n11 && !(n11 = keyEvent.getRepeatCount())) {
                KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
                if (dispatcherState != null) {
                    dispatcherState.startTracking(keyEvent, (Object)this);
                }
                return n12;
            }
            n11 = keyEvent.getAction();
            if (n11 == n12) {
                KeyEvent.DispatcherState dispatcherState = this.getKeyDispatcherState();
                if (dispatcherState != null) {
                    dispatcherState.handleUpEvent(keyEvent);
                }
                if ((n11 = keyEvent.isTracking()) && !(n11 = keyEvent.isCanceled())) {
                    this.mSearchView.clearFocus();
                    this.setImeVisibility(false);
                    return n12;
                }
            }
        }
        return super.onKeyPreIme(n10, keyEvent);
    }

    public void onWindowFocusChanged(boolean bl2) {
        SearchView searchView;
        super.onWindowFocusChanged(bl2);
        if (bl2 && (bl2 = (searchView = this.mSearchView).hasFocus()) && !(bl2 = this.getVisibility())) {
            this.mHasPendingShowSoftInputRequest = true;
            searchView = this.getContext();
            bl2 = SearchView.isLandscapeMode((Context)searchView);
            if (bl2) {
                this.ensureImeVisible();
            }
        }
    }

    public void performCompletion() {
    }

    public void replaceText(CharSequence charSequence) {
    }

    public void setImeVisibility(boolean bl2) {
        InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
        if (!bl2) {
            this.mHasPendingShowSoftInputRequest = false;
            Runnable runnable = this.mRunShowSoftInputIfNecessary;
            this.removeCallbacks(runnable);
            runnable = this.getWindowToken();
            inputMethodManager.hideSoftInputFromWindow((IBinder)runnable, 0);
            return;
        }
        bl2 = inputMethodManager.isActive((View)this);
        if (bl2) {
            this.mHasPendingShowSoftInputRequest = false;
            Runnable runnable = this.mRunShowSoftInputIfNecessary;
            this.removeCallbacks(runnable);
            inputMethodManager.showSoftInput((View)this, 0);
            return;
        }
        this.mHasPendingShowSoftInputRequest = true;
    }

    public void setSearchView(SearchView searchView) {
        this.mSearchView = searchView;
    }

    public void setThreshold(int n10) {
        super.setThreshold(n10);
        this.mThreshold = n10;
    }

    public void showSoftInputIfNecessary() {
        boolean bl2 = this.mHasPendingShowSoftInputRequest;
        if (bl2) {
            InputMethodManager inputMethodManager = (InputMethodManager)this.getContext().getSystemService("input_method");
            inputMethodManager.showSoftInput((View)this, 0);
            this.mHasPendingShowSoftInputRequest = false;
        }
    }
}

