/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.accessibility.AccessibilityRecord
 */
package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.List;

public class AccessibilityRecordCompat {
    private final AccessibilityRecord mRecord;

    public AccessibilityRecordCompat(Object object) {
        object = (AccessibilityRecord)object;
        this.mRecord = object;
    }

    public static int getMaxScrollX(AccessibilityRecord accessibilityRecord) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 >= n11) {
            return accessibilityRecord.getMaxScrollX();
        }
        return 0;
    }

    public static int getMaxScrollY(AccessibilityRecord accessibilityRecord) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 >= n11) {
            return accessibilityRecord.getMaxScrollY();
        }
        return 0;
    }

    public static AccessibilityRecordCompat obtain() {
        AccessibilityRecord accessibilityRecord = AccessibilityRecord.obtain();
        AccessibilityRecordCompat accessibilityRecordCompat = new AccessibilityRecordCompat(accessibilityRecord);
        return accessibilityRecordCompat;
    }

    public static AccessibilityRecordCompat obtain(AccessibilityRecordCompat accessibilityRecordCompat) {
        accessibilityRecordCompat = AccessibilityRecord.obtain((AccessibilityRecord)accessibilityRecordCompat.mRecord);
        AccessibilityRecordCompat accessibilityRecordCompat2 = new AccessibilityRecordCompat(accessibilityRecordCompat);
        return accessibilityRecordCompat2;
    }

    public static void setMaxScrollX(AccessibilityRecord accessibilityRecord, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 15;
        if (n11 >= n12) {
            accessibilityRecord.setMaxScrollX(n10);
        }
    }

    public static void setMaxScrollY(AccessibilityRecord accessibilityRecord, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 15;
        if (n11 >= n12) {
            accessibilityRecord.setMaxScrollY(n10);
        }
    }

    public static void setSource(AccessibilityRecord accessibilityRecord, View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            accessibilityRecord.setSource(view, n10);
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof AccessibilityRecordCompat;
        if (!bl4) {
            return false;
        }
        object = (AccessibilityRecordCompat)object;
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null ? (object = ((AccessibilityRecordCompat)object).mRecord) != null : !(bl2 = accessibilityRecord.equals(object = ((AccessibilityRecordCompat)object).mRecord))) {
            return false;
        }
        return bl3;
    }

    public int getAddedCount() {
        return this.mRecord.getAddedCount();
    }

    public CharSequence getBeforeText() {
        return this.mRecord.getBeforeText();
    }

    public CharSequence getClassName() {
        return this.mRecord.getClassName();
    }

    public CharSequence getContentDescription() {
        return this.mRecord.getContentDescription();
    }

    public int getCurrentItemIndex() {
        return this.mRecord.getCurrentItemIndex();
    }

    public int getFromIndex() {
        return this.mRecord.getFromIndex();
    }

    public Object getImpl() {
        return this.mRecord;
    }

    public int getItemCount() {
        return this.mRecord.getItemCount();
    }

    public int getMaxScrollX() {
        return AccessibilityRecordCompat.getMaxScrollX(this.mRecord);
    }

    public int getMaxScrollY() {
        return AccessibilityRecordCompat.getMaxScrollY(this.mRecord);
    }

    public Parcelable getParcelableData() {
        return this.mRecord.getParcelableData();
    }

    public int getRemovedCount() {
        return this.mRecord.getRemovedCount();
    }

    public int getScrollX() {
        return this.mRecord.getScrollX();
    }

    public int getScrollY() {
        return this.mRecord.getScrollY();
    }

    public AccessibilityNodeInfoCompat getSource() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mRecord.getSource());
    }

    public List getText() {
        return this.mRecord.getText();
    }

    public int getToIndex() {
        return this.mRecord.getToIndex();
    }

    public int getWindowId() {
        return this.mRecord.getWindowId();
    }

    public int hashCode() {
        int n10;
        AccessibilityRecord accessibilityRecord = this.mRecord;
        if (accessibilityRecord == null) {
            n10 = 0;
            accessibilityRecord = null;
        } else {
            n10 = accessibilityRecord.hashCode();
        }
        return n10;
    }

    public boolean isChecked() {
        return this.mRecord.isChecked();
    }

    public boolean isEnabled() {
        return this.mRecord.isEnabled();
    }

    public boolean isFullScreen() {
        return this.mRecord.isFullScreen();
    }

    public boolean isPassword() {
        return this.mRecord.isPassword();
    }

    public boolean isScrollable() {
        return this.mRecord.isScrollable();
    }

    public void recycle() {
        this.mRecord.recycle();
    }

    public void setAddedCount(int n10) {
        this.mRecord.setAddedCount(n10);
    }

    public void setBeforeText(CharSequence charSequence) {
        this.mRecord.setBeforeText(charSequence);
    }

    public void setChecked(boolean bl2) {
        this.mRecord.setChecked(bl2);
    }

    public void setClassName(CharSequence charSequence) {
        this.mRecord.setClassName(charSequence);
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mRecord.setContentDescription(charSequence);
    }

    public void setCurrentItemIndex(int n10) {
        this.mRecord.setCurrentItemIndex(n10);
    }

    public void setEnabled(boolean bl2) {
        this.mRecord.setEnabled(bl2);
    }

    public void setFromIndex(int n10) {
        this.mRecord.setFromIndex(n10);
    }

    public void setFullScreen(boolean bl2) {
        this.mRecord.setFullScreen(bl2);
    }

    public void setItemCount(int n10) {
        this.mRecord.setItemCount(n10);
    }

    public void setMaxScrollX(int n10) {
        AccessibilityRecordCompat.setMaxScrollX(this.mRecord, n10);
    }

    public void setMaxScrollY(int n10) {
        AccessibilityRecordCompat.setMaxScrollY(this.mRecord, n10);
    }

    public void setParcelableData(Parcelable parcelable) {
        this.mRecord.setParcelableData(parcelable);
    }

    public void setPassword(boolean bl2) {
        this.mRecord.setPassword(bl2);
    }

    public void setRemovedCount(int n10) {
        this.mRecord.setRemovedCount(n10);
    }

    public void setScrollX(int n10) {
        this.mRecord.setScrollX(n10);
    }

    public void setScrollY(int n10) {
        this.mRecord.setScrollY(n10);
    }

    public void setScrollable(boolean bl2) {
        this.mRecord.setScrollable(bl2);
    }

    public void setSource(View view) {
        this.mRecord.setSource(view);
    }

    public void setSource(View view, int n10) {
        AccessibilityRecordCompat.setSource(this.mRecord, view, n10);
    }

    public void setToIndex(int n10) {
        this.mRecord.setToIndex(n10);
    }
}

