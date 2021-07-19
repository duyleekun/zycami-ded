/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.CharArrayBuffer
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.DataSetObserver
 *  android.net.Uri
 *  android.os.Bundle
 */
package androidx.room;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import androidx.room.AutoCloser;
import java.util.List;

public final class AutoClosingRoomOpenHelper$KeepAliveCursor
implements Cursor {
    private final AutoCloser mAutoCloser;
    private final Cursor mDelegate;

    public AutoClosingRoomOpenHelper$KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
        this.mDelegate = cursor;
        this.mAutoCloser = autoCloser;
    }

    public void close() {
        this.mDelegate.close();
        this.mAutoCloser.decrementCountAndScheduleClose();
    }

    public void copyStringToBuffer(int n10, CharArrayBuffer charArrayBuffer) {
        this.mDelegate.copyStringToBuffer(n10, charArrayBuffer);
    }

    public void deactivate() {
        this.mDelegate.deactivate();
    }

    public byte[] getBlob(int n10) {
        return this.mDelegate.getBlob(n10);
    }

    public int getColumnCount() {
        return this.mDelegate.getColumnCount();
    }

    public int getColumnIndex(String string2) {
        return this.mDelegate.getColumnIndex(string2);
    }

    public int getColumnIndexOrThrow(String string2) {
        return this.mDelegate.getColumnIndexOrThrow(string2);
    }

    public String getColumnName(int n10) {
        return this.mDelegate.getColumnName(n10);
    }

    public String[] getColumnNames() {
        return this.mDelegate.getColumnNames();
    }

    public int getCount() {
        return this.mDelegate.getCount();
    }

    public double getDouble(int n10) {
        return this.mDelegate.getDouble(n10);
    }

    public Bundle getExtras() {
        return this.mDelegate.getExtras();
    }

    public float getFloat(int n10) {
        return this.mDelegate.getFloat(n10);
    }

    public int getInt(int n10) {
        return this.mDelegate.getInt(n10);
    }

    public long getLong(int n10) {
        return this.mDelegate.getLong(n10);
    }

    public Uri getNotificationUri() {
        return this.mDelegate.getNotificationUri();
    }

    public List getNotificationUris() {
        return this.mDelegate.getNotificationUris();
    }

    public int getPosition() {
        return this.mDelegate.getPosition();
    }

    public short getShort(int n10) {
        return this.mDelegate.getShort(n10);
    }

    public String getString(int n10) {
        return this.mDelegate.getString(n10);
    }

    public int getType(int n10) {
        return this.mDelegate.getType(n10);
    }

    public boolean getWantsAllOnMoveCalls() {
        return this.mDelegate.getWantsAllOnMoveCalls();
    }

    public boolean isAfterLast() {
        return this.mDelegate.isAfterLast();
    }

    public boolean isBeforeFirst() {
        return this.mDelegate.isBeforeFirst();
    }

    public boolean isClosed() {
        return this.mDelegate.isClosed();
    }

    public boolean isFirst() {
        return this.mDelegate.isFirst();
    }

    public boolean isLast() {
        return this.mDelegate.isLast();
    }

    public boolean isNull(int n10) {
        return this.mDelegate.isNull(n10);
    }

    public boolean move(int n10) {
        return this.mDelegate.move(n10);
    }

    public boolean moveToFirst() {
        return this.mDelegate.moveToFirst();
    }

    public boolean moveToLast() {
        return this.mDelegate.moveToLast();
    }

    public boolean moveToNext() {
        return this.mDelegate.moveToNext();
    }

    public boolean moveToPosition(int n10) {
        return this.mDelegate.moveToPosition(n10);
    }

    public boolean moveToPrevious() {
        return this.mDelegate.moveToPrevious();
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        this.mDelegate.registerContentObserver(contentObserver);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDelegate.registerDataSetObserver(dataSetObserver);
    }

    public boolean requery() {
        return this.mDelegate.requery();
    }

    public Bundle respond(Bundle bundle) {
        return this.mDelegate.respond(bundle);
    }

    public void setExtras(Bundle bundle) {
        this.mDelegate.setExtras(bundle);
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        this.mDelegate.setNotificationUri(contentResolver, uri);
    }

    public void setNotificationUris(ContentResolver contentResolver, List list) {
        this.mDelegate.setNotificationUris(contentResolver, list);
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        this.mDelegate.unregisterContentObserver(contentObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDelegate.unregisterDataSetObserver(dataSetObserver);
    }
}

