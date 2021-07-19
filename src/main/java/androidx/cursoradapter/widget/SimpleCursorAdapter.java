/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import androidx.cursoradapter.widget.SimpleCursorAdapter$CursorToStringConverter;
import androidx.cursoradapter.widget.SimpleCursorAdapter$ViewBinder;

public class SimpleCursorAdapter
extends ResourceCursorAdapter {
    private SimpleCursorAdapter$CursorToStringConverter mCursorToStringConverter;
    public int[] mFrom;
    public String[] mOriginalFrom;
    private int mStringConversionColumn = -1;
    public int[] mTo;
    private SimpleCursorAdapter$ViewBinder mViewBinder;

    public SimpleCursorAdapter(Context context, int n10, Cursor cursor, String[] stringArray, int[] nArray) {
        super(context, n10, cursor);
        this.mTo = nArray;
        this.mOriginalFrom = stringArray;
        this.findColumns(cursor, stringArray);
    }

    public SimpleCursorAdapter(Context context, int n10, Cursor cursor, String[] stringArray, int[] nArray, int n11) {
        super(context, n10, cursor, n11);
        this.mTo = nArray;
        this.mOriginalFrom = stringArray;
        this.findColumns(cursor, stringArray);
    }

    private void findColumns(Cursor cursor, String[] stringArray) {
        if (cursor != null) {
            int n10;
            int n11 = stringArray.length;
            int[] nArray = this.mFrom;
            if (nArray == null || (n10 = nArray.length) != n11) {
                this.mFrom = nArray = new int[n11];
            }
            nArray = null;
            for (n10 = 0; n10 < n11; ++n10) {
                int n12;
                int[] nArray2 = this.mFrom;
                String string2 = stringArray[n10];
                nArray2[n10] = n12 = cursor.getColumnIndexOrThrow(string2);
            }
        } else {
            cursor = null;
            this.mFrom = null;
        }
    }

    public void bindView(View object, Context object2, Cursor object3) {
        object2 = this.mViewBinder;
        int[] nArray = this.mTo;
        int n10 = nArray.length;
        int[] nArray2 = this.mFrom;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            String string2;
            int n11;
            int n12 = nArray[i10];
            View view = object.findViewById(n12);
            if (view == null) continue;
            if (object2 != null) {
                n11 = nArray2[i10];
                n11 = (int)(object2.setViewValue(view, (Cursor)object3, n11) ? 1 : 0);
            } else {
                n11 = 0;
                string2 = null;
            }
            if (n11 != 0) continue;
            n11 = nArray2[i10];
            string2 = object3.getString(n11);
            if (string2 == null) {
                string2 = "";
            }
            if (bl2 = view instanceof TextView) {
                view = (TextView)view;
                this.setViewText((TextView)view, string2);
                continue;
            }
            bl2 = view instanceof ImageView;
            if (bl2) {
                view = (ImageView)view;
                this.setViewImage((ImageView)view, string2);
                continue;
            }
            object2 = new StringBuilder();
            object3 = view.getClass().getName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(" is not a ");
            ((StringBuilder)object2).append(" view that can be bounds by this SimpleCursorAdapter");
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String[] stringArray, int[] nArray) {
        this.mOriginalFrom = stringArray;
        this.mTo = nArray;
        this.findColumns(cursor, stringArray);
        super.changeCursor(cursor);
    }

    public CharSequence convertToString(Cursor cursor) {
        SimpleCursorAdapter$CursorToStringConverter simpleCursorAdapter$CursorToStringConverter = this.mCursorToStringConverter;
        if (simpleCursorAdapter$CursorToStringConverter != null) {
            return simpleCursorAdapter$CursorToStringConverter.convertToString(cursor);
        }
        int n10 = this.mStringConversionColumn;
        int n11 = -1;
        if (n10 > n11) {
            return cursor.getString(n10);
        }
        return super.convertToString(cursor);
    }

    public SimpleCursorAdapter$CursorToStringConverter getCursorToStringConverter() {
        return this.mCursorToStringConverter;
    }

    public int getStringConversionColumn() {
        return this.mStringConversionColumn;
    }

    public SimpleCursorAdapter$ViewBinder getViewBinder() {
        return this.mViewBinder;
    }

    public void setCursorToStringConverter(SimpleCursorAdapter$CursorToStringConverter simpleCursorAdapter$CursorToStringConverter) {
        this.mCursorToStringConverter = simpleCursorAdapter$CursorToStringConverter;
    }

    public void setStringConversionColumn(int n10) {
        this.mStringConversionColumn = n10;
    }

    public void setViewBinder(SimpleCursorAdapter$ViewBinder simpleCursorAdapter$ViewBinder) {
        this.mViewBinder = simpleCursorAdapter$ViewBinder;
    }

    public void setViewImage(ImageView imageView, String string2) {
        int n10 = Integer.parseInt(string2);
        try {
            imageView.setImageResource(n10);
        }
        catch (NumberFormatException numberFormatException) {
            string2 = Uri.parse((String)string2);
            imageView.setImageURI((Uri)string2);
        }
    }

    public void setViewText(TextView textView, String string2) {
        textView.setText((CharSequence)string2);
    }

    public Cursor swapCursor(Cursor cursor) {
        String[] stringArray = this.mOriginalFrom;
        this.findColumns(cursor, stringArray);
        return super.swapCursor(cursor);
    }
}

