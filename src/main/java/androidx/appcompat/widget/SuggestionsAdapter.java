/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.SearchableInfo
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.database.Cursor
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.style.TextAppearanceSpan
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SuggestionsAdapter$ChildViewCache;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.util.WeakHashMap;

public class SuggestionsAdapter
extends ResourceCursorAdapter
implements View.OnClickListener {
    private static final boolean DBG = false;
    public static final int INVALID_INDEX = 255;
    private static final String LOG_TAG = "SuggestionsAdapter";
    private static final int QUERY_LIMIT = 50;
    public static final int REFINE_ALL = 2;
    public static final int REFINE_BY_ENTRY = 1;
    public static final int REFINE_NONE;
    private boolean mClosed;
    private final int mCommitIconResId;
    private int mFlagsCol;
    private int mIconName1Col;
    private int mIconName2Col;
    private final WeakHashMap mOutsideDrawablesCache;
    private final Context mProviderContext;
    private int mQueryRefinement;
    private final SearchView mSearchView;
    private final SearchableInfo mSearchable;
    private int mText1Col;
    private int mText2Col;
    private int mText2UrlCol;
    private ColorStateList mUrlColor;

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int n10;
        int n11 = searchView.getSuggestionRowLayout();
        int n12 = 1;
        super(context, n11, null, n12 != 0);
        this.mClosed = false;
        this.mQueryRefinement = n12;
        this.mText1Col = n11 = -1;
        this.mText2Col = n11;
        this.mText2UrlCol = n11;
        this.mIconName1Col = n11;
        this.mIconName2Col = n11;
        this.mFlagsCol = n11;
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = n10 = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    private Drawable checkIconCache(String string2) {
        WeakHashMap weakHashMap = this.mOutsideDrawablesCache;
        if ((string2 = (Drawable.ConstantState)weakHashMap.get(string2)) == null) {
            return null;
        }
        return string2.newDrawable();
    }

    private CharSequence formatUrl(CharSequence charSequence) {
        TextAppearanceSpan textAppearanceSpan;
        Resources.Theme theme;
        ColorStateList colorStateList = this.mUrlColor;
        if (colorStateList == null) {
            colorStateList = new TypedValue();
            theme = this.mProviderContext.getTheme();
            int n10 = R$attr.textColorSearchUrl;
            boolean bl2 = true;
            theme.resolveAttribute(n10, (TypedValue)colorStateList, bl2);
            theme = this.mProviderContext.getResources();
            int n11 = colorStateList.resourceId;
            this.mUrlColor = colorStateList = theme.getColorStateList(n11);
        }
        colorStateList = new SpannableString(charSequence);
        ColorStateList colorStateList2 = this.mUrlColor;
        theme = textAppearanceSpan;
        textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, colorStateList2, null);
        int n12 = charSequence.length();
        colorStateList.setSpan((Object)textAppearanceSpan, 0, n12, 33);
        return colorStateList;
    }

    private Drawable getActivityIcon(ComponentName object) {
        ActivityInfo activityInfo;
        String string2 = LOG_TAG;
        Object object2 = this.mProviderContext.getPackageManager();
        int n10 = 128;
        try {
            activityInfo = object2.getActivityInfo(object, n10);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = nameNotFoundException.toString();
            Log.w((String)string2, (String)object);
            return null;
        }
        int n11 = activityInfo.getIconResource();
        if (n11 == 0) {
            return null;
        }
        String string3 = object.getPackageName();
        if ((object2 = object2.getDrawable(string3, n11, (ApplicationInfo)(activityInfo = activityInfo.applicationInfo))) == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Invalid icon resource ");
            ((StringBuilder)object2).append(n11);
            ((StringBuilder)object2).append(" for ");
            object = object.flattenToShortString();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            Log.w((String)string2, (String)object);
            return null;
        }
        return object2;
    }

    private Drawable getActivityIconWithCache(ComponentName componentName) {
        String string2 = componentName.flattenToShortString();
        WeakHashMap weakHashMap = this.mOutsideDrawablesCache;
        boolean bl2 = weakHashMap.containsKey(string2);
        Drawable.ConstantState constantState = null;
        if (bl2) {
            componentName = (Drawable.ConstantState)this.mOutsideDrawablesCache.get(string2);
            if (componentName != null) {
                string2 = this.mProviderContext.getResources();
                constantState = componentName.newDrawable((Resources)string2);
            }
            return constantState;
        }
        if ((componentName = this.getActivityIcon(componentName)) != null) {
            constantState = componentName.getConstantState();
        }
        this.mOutsideDrawablesCache.put(string2, constantState);
        return componentName;
    }

    public static String getColumnString(Cursor cursor, String string2) {
        int n10 = cursor.getColumnIndex(string2);
        return SuggestionsAdapter.getStringOrNull(cursor, n10);
    }

    private Drawable getDefaultIcon1() {
        ComponentName componentName = this.mSearchable.getSearchActivity();
        if ((componentName = this.getActivityIconWithCache(componentName)) != null) {
            return componentName;
        }
        return this.mProviderContext.getPackageManager().getDefaultActivityIcon();
    }

    /*
     * Exception decompiling
     */
    private Drawable getDrawable(Uri var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private Drawable getDrawableFromResourceValue(String string2) {
        CharSequence charSequence;
        int n10;
        Drawable drawable2 = null;
        if (string2 != null && (n10 = string2.isEmpty()) == 0 && (n10 = ((String)(charSequence = "0")).equals(string2)) == 0) {
            String string3;
            CharSequence charSequence2;
            block16: {
                n10 = Integer.parseInt(string2);
                charSequence2 = new StringBuilder();
                string3 = "android.resource://";
                charSequence2.append(string3);
                string3 = this.mProviderContext;
                string3 = string3.getPackageName();
                charSequence2.append(string3);
                string3 = "/";
                charSequence2.append(string3);
                charSequence2.append(n10);
                charSequence2 = charSequence2.toString();
                string3 = this.checkIconCache((String)charSequence2);
                if (string3 == null) break block16;
                return string3;
            }
            string3 = this.mProviderContext;
            charSequence = ContextCompat.getDrawable((Context)string3, n10);
            try {
                this.storeInIconCache((String)charSequence2, (Drawable)charSequence);
                return charSequence;
            }
            catch (Resources.NotFoundException notFoundException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Icon resource not found: ");
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                Log.w((String)LOG_TAG, (String)string2);
                return null;
            }
            catch (NumberFormatException numberFormatException) {
                drawable2 = this.checkIconCache(string2);
                if (drawable2 != null) {
                    return drawable2;
                }
                drawable2 = Uri.parse((String)string2);
                drawable2 = this.getDrawable((Uri)drawable2);
                this.storeInIconCache(string2, drawable2);
            }
        }
        return drawable2;
    }

    private Drawable getIcon1(Cursor object) {
        int n10 = this.mIconName1Col;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        object = object.getString(n10);
        if ((object = this.getDrawableFromResourceValue((String)object)) != null) {
            return object;
        }
        return this.getDefaultIcon1();
    }

    private Drawable getIcon2(Cursor object) {
        int n10 = this.mIconName2Col;
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        object = object.getString(n10);
        return this.getDrawableFromResourceValue((String)object);
    }

    private static String getStringOrNull(Cursor cursor, int n10) {
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        try {
            return cursor.getString(n10);
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"unexpected error retrieving valid column from cursor, did the remote process die?", (Throwable)exception);
            return null;
        }
    }

    private void setViewDrawable(ImageView imageView, Drawable drawable2, int n10) {
        imageView.setImageDrawable(drawable2);
        if (drawable2 == null) {
            imageView.setVisibility(n10);
        } else {
            n10 = 0;
            imageView.setVisibility(0);
            drawable2.setVisible(false, false);
            boolean bl2 = true;
            drawable2.setVisible(bl2, false);
        }
    }

    private void setViewText(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        int n10 = TextUtils.isEmpty((CharSequence)charSequence);
        if (n10 != 0) {
            n10 = 8;
            textView.setVisibility(n10);
        } else {
            n10 = 0;
            charSequence = null;
            textView.setVisibility(0);
        }
    }

    private void storeInIconCache(String string2, Drawable drawable2) {
        if (drawable2 != null) {
            WeakHashMap weakHashMap = this.mOutsideDrawablesCache;
            drawable2 = drawable2.getConstantState();
            weakHashMap.put(string2, drawable2);
        }
    }

    private void updateSpinnerState(Cursor cursor) {
        String string2;
        boolean bl2;
        if (cursor != null) {
            cursor = cursor.getExtras();
        } else {
            bl2 = false;
            cursor = null;
        }
        if (cursor == null || (bl2 = cursor.getBoolean(string2 = "in_progress"))) {
            // empty if block
        }
    }

    public void bindView(View object, Context context, Cursor object2) {
        int n10;
        Drawable drawable2;
        int n11;
        object = (SuggestionsAdapter$ChildViewCache)object.getTag();
        int n12 = this.mFlagsCol;
        int n13 = -1;
        if (n12 != n13) {
            n12 = object2.getInt(n12);
        } else {
            n12 = 0;
            context = null;
        }
        Object object3 = object.mText1;
        if (object3 != null) {
            n13 = this.mText1Col;
            object3 = SuggestionsAdapter.getStringOrNull(object2, n13);
            TextView textView = object.mText1;
            this.setViewText(textView, (CharSequence)object3);
        }
        object3 = object.mText2;
        int n14 = 2;
        int n15 = 1;
        if (object3 != null) {
            n13 = this.mText2UrlCol;
            object3 = SuggestionsAdapter.getStringOrNull(object2, n13);
            if (object3 != null) {
                object3 = this.formatUrl((CharSequence)object3);
            } else {
                n13 = this.mText2Col;
                object3 = SuggestionsAdapter.getStringOrNull(object2, n13);
            }
            n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
            if (n11 != 0) {
                drawable2 = object.mText1;
                if (drawable2 != null) {
                    drawable2.setSingleLine(false);
                    drawable2 = object.mText1;
                    drawable2.setMaxLines(n14);
                }
            } else {
                drawable2 = object.mText1;
                if (drawable2 != null) {
                    drawable2.setSingleLine(n15 != 0);
                    drawable2 = object.mText1;
                    drawable2.setMaxLines(n15);
                }
            }
            drawable2 = object.mText2;
            this.setViewText((TextView)drawable2, (CharSequence)object3);
        }
        if ((object3 = object.mIcon1) != null) {
            drawable2 = this.getIcon1((Cursor)object2);
            int n16 = 4;
            this.setViewDrawable((ImageView)object3, drawable2, n16);
        }
        object3 = object.mIcon2;
        n11 = 8;
        if (object3 != null) {
            object2 = this.getIcon2((Cursor)object2);
            this.setViewDrawable((ImageView)object3, (Drawable)object2, n11);
        }
        if ((n10 = this.mQueryRefinement) != n14 && (n10 != n15 || (n12 &= n15) == 0)) {
            object = object.mIconRefine;
            object.setVisibility(n11);
        } else {
            object.mIconRefine.setVisibility(0);
            context = object.mIconRefine;
            object2 = object.mText1.getText();
            context.setTag(object2);
            object = object.mIconRefine;
            object.setOnClickListener((View.OnClickListener)this);
        }
    }

    public void changeCursor(Cursor cursor) {
        block16: {
            int n10 = this.mClosed;
            String string2 = LOG_TAG;
            if (n10 != 0) {
                String string3 = "Tried to change cursor after adapter was closed.";
                Log.w((String)string2, (String)string3);
                if (cursor != null) {
                    cursor.close();
                }
                return;
            }
            super.changeCursor(cursor);
            if (cursor == null) break block16;
            String string4 = "suggest_text_1";
            n10 = cursor.getColumnIndex(string4);
            this.mText1Col = n10;
            string4 = "suggest_text_2";
            n10 = cursor.getColumnIndex(string4);
            this.mText2Col = n10;
            string4 = "suggest_text_2_url";
            n10 = cursor.getColumnIndex(string4);
            this.mText2UrlCol = n10;
            string4 = "suggest_icon_1";
            n10 = cursor.getColumnIndex(string4);
            this.mIconName1Col = n10;
            string4 = "suggest_icon_2";
            n10 = cursor.getColumnIndex(string4);
            this.mIconName2Col = n10;
            string4 = "suggest_flags";
            int n11 = cursor.getColumnIndex(string4);
            try {
                this.mFlagsCol = n11;
            }
            catch (Exception exception) {
                string4 = "error changing cursor and caching columns";
                Log.e((String)string2, (String)string4, (Throwable)exception);
            }
        }
    }

    public void close() {
        this.changeCursor(null);
        this.mClosed = true;
    }

    public CharSequence convertToString(Cursor object) {
        if (object == null) {
            return null;
        }
        String string2 = SuggestionsAdapter.getColumnString(object, "suggest_intent_query");
        if (string2 != null) {
            return string2;
        }
        string2 = this.mSearchable;
        boolean bl2 = string2.shouldRewriteQueryFromData();
        if (bl2 && (string2 = SuggestionsAdapter.getColumnString(object, "suggest_intent_data")) != null) {
            return string2;
        }
        string2 = this.mSearchable;
        bl2 = string2.shouldRewriteQueryFromText();
        if (bl2 && (object = SuggestionsAdapter.getColumnString(object, string2 = "suggest_text_1")) != null) {
            return object;
        }
        return null;
    }

    public Drawable getDrawableFromResourceUri(Uri object) {
        Object object2;
        block14: {
            Object object3;
            block15: {
                block16: {
                    int n10;
                    int n11;
                    object2 = object.getAuthority();
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
                    if (bl2) break block14;
                    object3 = this.mProviderContext;
                    object3 = object3.getPackageManager();
                    try {
                        object3 = object3.getResourcesForApplication((String)object2);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("No package found for authority: ");
                        ((StringBuilder)object3).append(object);
                        object = ((StringBuilder)object3).toString();
                        object2 = new FileNotFoundException((String)object);
                        throw object2;
                    }
                    Object object4 = object.getPathSegments();
                    if (object4 == null) break block15;
                    int n12 = object4.size();
                    if (n12 == (n11 = 1)) {
                        try {
                            object2 = object4.get(0);
                        }
                        catch (NumberFormatException numberFormatException) {
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append("Single path segment is not a resource ID: ");
                            ((StringBuilder)object3).append(object);
                            object = ((StringBuilder)object3).toString();
                            object2 = new FileNotFoundException((String)object);
                            throw object2;
                        }
                        object2 = (String)object2;
                        n10 = Integer.parseInt((String)object2);
                    }
                    int n13 = 2;
                    if (n12 != n13) break block16;
                    String string2 = (String)object4.get(n11);
                    object4 = (String)object4.get(0);
                    n10 = object3.getIdentifier(string2, (String)object4, (String)object2);
                    if (n10 != 0) {
                        return object3.getDrawable(n10);
                    }
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("No resource found for: ");
                    ((StringBuilder)object3).append(object);
                    object = ((StringBuilder)object3).toString();
                    object2 = new FileNotFoundException((String)object);
                    throw object2;
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("More than two path segments: ");
                ((StringBuilder)object3).append(object);
                object = ((StringBuilder)object3).toString();
                object2 = new FileNotFoundException((String)object);
                throw object2;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("No path: ");
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            object2 = new FileNotFoundException((String)object);
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No authority: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new FileNotFoundException((String)object);
        throw object2;
    }

    public View getDropDownView(int n10, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(n10, view, viewGroup);
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)LOG_TAG, (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            view = this.mProviderContext;
            Cursor cursor = this.getCursor();
            view = this.newDropDownView((Context)view, cursor, viewGroup);
            if (view != null) {
                viewGroup = ((SuggestionsAdapter$ChildViewCache)view.getTag()).mText1;
                String string2 = runtimeException.toString();
                viewGroup.setText((CharSequence)string2);
            }
            return view;
        }
    }

    public int getQueryRefinement() {
        return this.mQueryRefinement;
    }

    public Cursor getSearchManagerSuggestions(SearchableInfo object, String string2, int n10) {
        String[] stringArray = null;
        if (object == null) {
            return null;
        }
        String string3 = object.getSuggestAuthority();
        if (string3 == null) {
            return null;
        }
        Object object2 = new Uri.Builder();
        String string4 = "content";
        string3 = object2.scheme(string4).authority(string3);
        object2 = "";
        string3 = string3.query((String)object2).fragment((String)object2);
        object2 = object.getSuggestPath();
        if (object2 != null) {
            string3.appendEncodedPath((String)object2);
        }
        object2 = "search_suggest_query";
        string3.appendPath((String)object2);
        String string5 = object.getSuggestSelection();
        if (string5 != null) {
            stringArray = new String[1];
            object = null;
            stringArray[0] = string2;
        } else {
            string3.appendPath(string2);
        }
        String[] stringArray2 = stringArray;
        if (n10 > 0) {
            object = String.valueOf(n10);
            string2 = "limit";
            string3.appendQueryParameter(string2, (String)object);
        }
        Uri uri = string3.build();
        return this.mProviderContext.getContentResolver().query(uri, null, string5, stringArray2, null);
    }

    public View getView(int n10, View view, ViewGroup viewGroup) {
        try {
            return super.getView(n10, view, viewGroup);
        }
        catch (RuntimeException runtimeException) {
            Log.w((String)LOG_TAG, (String)"Search suggestions cursor threw exception.", (Throwable)runtimeException);
            view = this.mProviderContext;
            Cursor cursor = this.getCursor();
            view = this.newView((Context)view, cursor, viewGroup);
            if (view != null) {
                viewGroup = ((SuggestionsAdapter$ChildViewCache)view.getTag()).mText1;
                String string2 = runtimeException.toString();
                viewGroup.setText((CharSequence)string2);
            }
            return view;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public View newView(Context context, Cursor object, ViewGroup viewGroup) {
        context = super.newView(context, (Cursor)object, viewGroup);
        object = new SuggestionsAdapter$ChildViewCache((View)context);
        context.setTag(object);
        int n10 = R$id.edit_query;
        object = (ImageView)context.findViewById(n10);
        int n11 = this.mCommitIconResId;
        object.setImageResource(n11);
        return context;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.getCursor();
        this.updateSpinnerState(cursor);
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.getCursor();
        this.updateSpinnerState(cursor);
    }

    public void onClick(View object) {
        boolean bl2 = (object = object.getTag()) instanceof CharSequence;
        if (bl2) {
            SearchView searchView = this.mSearchView;
            object = (CharSequence)object;
            searchView.onQueryRefine((CharSequence)object);
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        block5: {
            charSequence = charSequence == null ? "" : charSequence.toString();
            Object object = this.mSearchView;
            int n10 = object.getVisibility();
            if (n10 == 0 && (n10 = (object = this.mSearchView).getWindowVisibility()) == 0) {
                object = this.mSearchable;
                int n11 = 50;
                charSequence = this.getSearchManagerSuggestions((SearchableInfo)object, (String)charSequence, n11);
                if (charSequence == null) break block5;
                try {
                    charSequence.getCount();
                    return charSequence;
                }
                catch (RuntimeException runtimeException) {
                    object = LOG_TAG;
                    String string2 = "Search suggestions query threw an exception.";
                    Log.w((String)object, (String)string2, (Throwable)runtimeException);
                }
            }
        }
        return null;
    }

    public void setQueryRefinement(int n10) {
        this.mQueryRefinement = n10;
    }
}

