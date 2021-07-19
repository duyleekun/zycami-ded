/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.DataSetObserver
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.Filter
 *  android.widget.FilterQueryProvider
 *  android.widget.Filterable
 */
package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.cursoradapter.widget.CursorAdapter$ChangeObserver;
import androidx.cursoradapter.widget.CursorAdapter$MyDataSetObserver;
import androidx.cursoradapter.widget.CursorFilter;
import androidx.cursoradapter.widget.CursorFilter$CursorFilterClient;

public abstract class CursorAdapter
extends BaseAdapter
implements Filterable,
CursorFilter$CursorFilterClient {
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    public boolean mAutoRequery;
    public CursorAdapter$ChangeObserver mChangeObserver;
    public Context mContext;
    public Cursor mCursor;
    public CursorFilter mCursorFilter;
    public DataSetObserver mDataSetObserver;
    public boolean mDataValid;
    public FilterQueryProvider mFilterQueryProvider;
    public int mRowIDColumn;

    public CursorAdapter(Context context, Cursor cursor) {
        this.init(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int n10) {
        this.init(context, cursor, n10);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean n10) {
        n10 = n10 != 0 ? 1 : 2;
        this.init(context, cursor, n10);
    }

    public abstract void bindView(View var1, Context var2, Cursor var3);

    public void changeCursor(Cursor cursor) {
        if ((cursor = this.swapCursor(cursor)) != null) {
            cursor.close();
        }
    }

    public CharSequence convertToString(Cursor object) {
        object = object == null ? "" : object.toString();
        return object;
    }

    public int getCount() {
        Cursor cursor;
        boolean bl2 = this.mDataValid;
        if (bl2 && (cursor = this.mCursor) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    public Cursor getCursor() {
        return this.mCursor;
    }

    public View getDropDownView(int n10, View view, ViewGroup viewGroup) {
        boolean bl2 = this.mDataValid;
        if (bl2) {
            Context context;
            Cursor cursor = this.mCursor;
            cursor.moveToPosition(n10);
            if (view == null) {
                context = this.mContext;
                view = this.mCursor;
                view = this.newDropDownView(context, (Cursor)view, viewGroup);
            }
            context = this.mContext;
            viewGroup = this.mCursor;
            this.bindView(view, context, (Cursor)viewGroup);
            return view;
        }
        return null;
    }

    public Filter getFilter() {
        CursorFilter cursorFilter = this.mCursorFilter;
        if (cursorFilter == null) {
            this.mCursorFilter = cursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    public Object getItem(int n10) {
        Cursor cursor;
        boolean bl2 = this.mDataValid;
        if (bl2 && (cursor = this.mCursor) != null) {
            cursor.moveToPosition(n10);
            return this.mCursor;
        }
        return null;
    }

    public long getItemId(int n10) {
        Cursor cursor;
        int n11 = this.mDataValid;
        long l10 = 0L;
        if (n11 != 0 && (cursor = this.mCursor) != null && (n10 = (int)(cursor.moveToPosition(n10) ? 1 : 0)) != 0) {
            Cursor cursor2 = this.mCursor;
            n11 = this.mRowIDColumn;
            return cursor2.getLong(n11);
        }
        return l10;
    }

    public View getView(int n10, View object, ViewGroup object2) {
        boolean bl2 = this.mDataValid;
        if (bl2) {
            Cursor cursor = this.mCursor;
            bl2 = cursor.moveToPosition(n10);
            if (bl2) {
                Context context;
                if (object == null) {
                    context = this.mContext;
                    object = this.mCursor;
                    object = this.newView(context, (Cursor)object, (ViewGroup)object2);
                }
                context = this.mContext;
                object2 = this.mCursor;
                this.bindView((View)object, context, (Cursor)object2);
                return object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("couldn't move cursor to position ");
            ((StringBuilder)object2).append(n10);
            String string2 = ((StringBuilder)object2).toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        IllegalStateException illegalStateException = new IllegalStateException("this should only be called when the cursor is valid");
        throw illegalStateException;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void init(Context object, Cursor cursor, int n10) {
        int n11;
        int n12 = n10 & 1;
        int n13 = 0;
        int n14 = 1;
        if (n12 == n14) {
            n10 |= 2;
            this.mAutoRequery = n14;
        } else {
            this.mAutoRequery = false;
        }
        if (cursor != null) {
            n13 = n14;
        }
        this.mCursor = cursor;
        this.mDataValid = n13;
        this.mContext = object;
        if (n13 != 0) {
            object = "_id";
            n11 = cursor.getColumnIndexOrThrow((String)object);
        } else {
            n11 = -1;
        }
        this.mRowIDColumn = n11;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object = new CursorAdapter$ChangeObserver(this);
            this.mChangeObserver = object;
            object = new CursorAdapter$MyDataSetObserver(this);
            this.mDataSetObserver = object;
        } else {
            n11 = 0;
            object = null;
            this.mChangeObserver = null;
            this.mDataSetObserver = null;
        }
        if (n13 != 0) {
            object = this.mChangeObserver;
            if (object != null) {
                cursor.registerContentObserver((ContentObserver)object);
            }
            if ((object = this.mDataSetObserver) != null) {
                cursor.registerDataSetObserver((DataSetObserver)object);
            }
        }
    }

    public void init(Context context, Cursor cursor, boolean n10) {
        n10 = n10 != 0 ? 1 : 2;
        this.init(context, cursor, n10);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.newView(context, cursor, viewGroup);
    }

    public abstract View newView(Context var1, Cursor var2, ViewGroup var3);

    public void onContentChanged() {
        Cursor cursor;
        boolean bl2 = this.mAutoRequery;
        if (bl2 && (cursor = this.mCursor) != null && !(bl2 = cursor.isClosed())) {
            cursor = this.mCursor;
            this.mDataValid = bl2 = cursor.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.mFilterQueryProvider;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider filterQueryProvider) {
        this.mFilterQueryProvider = filterQueryProvider;
    }

    public Cursor swapCursor(Cursor cursor) {
        Object object;
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            object = this.mChangeObserver;
            if (object != null) {
                cursor2.unregisterContentObserver((ContentObserver)object);
            }
            if ((object = this.mDataSetObserver) != null) {
                cursor2.unregisterDataSetObserver((DataSetObserver)object);
            }
        }
        this.mCursor = cursor;
        if (cursor != null) {
            int n10;
            object = this.mChangeObserver;
            if (object != null) {
                cursor.registerContentObserver((ContentObserver)object);
            }
            if ((object = this.mDataSetObserver) != null) {
                cursor.registerDataSetObserver((DataSetObserver)object);
            }
            object = "_id";
            this.mRowIDColumn = n10 = cursor.getColumnIndexOrThrow((String)object);
            n10 = 1;
            this.mDataValid = n10;
            this.notifyDataSetChanged();
        } else {
            this.mRowIDColumn = -1;
            boolean bl2 = false;
            cursor = null;
            this.mDataValid = false;
            this.notifyDataSetInvalidated();
        }
        return cursor2;
    }
}

