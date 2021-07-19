/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ShortcutInfo
 *  android.os.Build$VERSION
 *  android.os.PersistableBundle
 *  android.os.UserHandle
 *  android.text.TextUtils
 */
package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.Set;

public class ShortcutInfoCompat$Builder {
    private final ShortcutInfoCompat mInfo;
    private boolean mIsConversation;

    public ShortcutInfoCompat$Builder(Context object, ShortcutInfo shortcutInfo) {
        long l10;
        UserHandle userHandle;
        ShortcutInfoCompat shortcutInfoCompat;
        this.mInfo = shortcutInfoCompat = new ShortcutInfoCompat();
        shortcutInfoCompat.mContext = object;
        object = shortcutInfo.getId();
        shortcutInfoCompat.mId = object;
        object = shortcutInfo.getPackage();
        shortcutInfoCompat.mPackageName = object;
        object = shortcutInfo.getIntents();
        int n10 = ((Intent[])object).length;
        object = Arrays.copyOf(object, n10);
        shortcutInfoCompat.mIntents = object;
        shortcutInfoCompat.mActivity = object = shortcutInfo.getActivity();
        object = shortcutInfo.getShortLabel();
        shortcutInfoCompat.mLabel = object;
        object = shortcutInfo.getLongLabel();
        shortcutInfoCompat.mLongLabel = object;
        object = shortcutInfo.getDisabledMessage();
        shortcutInfoCompat.mDisabledMessage = object;
        int n11 = Build.VERSION.SDK_INT;
        n10 = 28;
        if (n11 >= n10) {
            shortcutInfoCompat.mDisabledReason = n10 = shortcutInfo.getDisabledReason();
        } else {
            n10 = (int)(shortcutInfo.isEnabled() ? 1 : 0);
            if (n10 != 0) {
                n10 = 0;
                userHandle = null;
            } else {
                n10 = 3;
            }
            shortcutInfoCompat.mDisabledReason = n10;
        }
        userHandle = shortcutInfo.getCategories();
        shortcutInfoCompat.mCategories = userHandle;
        userHandle = ShortcutInfoCompat.getPersonsFromExtra(shortcutInfo.getExtras());
        shortcutInfoCompat.mPersons = userHandle;
        shortcutInfoCompat.mUser = userHandle = shortcutInfo.getUserHandle();
        shortcutInfoCompat.mLastChangedTimestamp = l10 = shortcutInfo.getLastChangedTimestamp();
        n10 = 30;
        if (n11 >= n10) {
            n11 = (int)(shortcutInfo.isCached() ? 1 : 0);
            shortcutInfoCompat.mIsCached = n11;
        }
        n11 = (int)(shortcutInfo.isDynamic() ? 1 : 0);
        shortcutInfoCompat.mIsDynamic = n11;
        n11 = (int)(shortcutInfo.isPinned() ? 1 : 0);
        shortcutInfoCompat.mIsPinned = n11;
        n11 = (int)(shortcutInfo.isDeclaredInManifest() ? 1 : 0);
        shortcutInfoCompat.mIsDeclaredInManifest = n11;
        n11 = (int)(shortcutInfo.isImmutable() ? 1 : 0);
        shortcutInfoCompat.mIsImmutable = n11;
        n11 = (int)(shortcutInfo.isEnabled() ? 1 : 0);
        shortcutInfoCompat.mIsEnabled = n11;
        n11 = (int)(shortcutInfo.hasKeyFieldsOnly() ? 1 : 0);
        shortcutInfoCompat.mHasKeyFieldsOnly = n11;
        object = ShortcutInfoCompat.getLocusId(shortcutInfo);
        shortcutInfoCompat.mLocusId = object;
        shortcutInfoCompat.mRank = n11 = shortcutInfo.getRank();
        object = shortcutInfo.getExtras();
        shortcutInfoCompat.mExtras = object;
    }

    public ShortcutInfoCompat$Builder(Context context, String string2) {
        ShortcutInfoCompat shortcutInfoCompat;
        this.mInfo = shortcutInfoCompat = new ShortcutInfoCompat();
        shortcutInfoCompat.mContext = context;
        shortcutInfoCompat.mId = string2;
    }

    public ShortcutInfoCompat$Builder(ShortcutInfoCompat shortcutInfoCompat) {
        long l10;
        int n10;
        ShortcutInfoCompat shortcutInfoCompat2;
        this.mInfo = shortcutInfoCompat2 = new ShortcutInfoCompat();
        Object object = shortcutInfoCompat.mContext;
        shortcutInfoCompat2.mContext = object;
        object = shortcutInfoCompat.mId;
        shortcutInfoCompat2.mId = object;
        object = shortcutInfoCompat.mPackageName;
        shortcutInfoCompat2.mPackageName = object;
        object = shortcutInfoCompat.mIntents;
        int n11 = ((Intent[])object).length;
        object = Arrays.copyOf(object, n11);
        shortcutInfoCompat2.mIntents = object;
        object = shortcutInfoCompat.mActivity;
        shortcutInfoCompat2.mActivity = object;
        object = shortcutInfoCompat.mLabel;
        shortcutInfoCompat2.mLabel = object;
        object = shortcutInfoCompat.mLongLabel;
        shortcutInfoCompat2.mLongLabel = object;
        object = shortcutInfoCompat.mDisabledMessage;
        shortcutInfoCompat2.mDisabledMessage = object;
        shortcutInfoCompat2.mDisabledReason = n10 = shortcutInfoCompat.mDisabledReason;
        object = shortcutInfoCompat.mIcon;
        shortcutInfoCompat2.mIcon = object;
        n10 = (int)(shortcutInfoCompat.mIsAlwaysBadged ? 1 : 0);
        shortcutInfoCompat2.mIsAlwaysBadged = n10;
        object = shortcutInfoCompat.mUser;
        shortcutInfoCompat2.mUser = object;
        shortcutInfoCompat2.mLastChangedTimestamp = l10 = shortcutInfoCompat.mLastChangedTimestamp;
        n10 = (int)(shortcutInfoCompat.mIsCached ? 1 : 0);
        shortcutInfoCompat2.mIsCached = n10;
        n10 = (int)(shortcutInfoCompat.mIsDynamic ? 1 : 0);
        shortcutInfoCompat2.mIsDynamic = n10;
        n10 = (int)(shortcutInfoCompat.mIsPinned ? 1 : 0);
        shortcutInfoCompat2.mIsPinned = n10;
        n10 = (int)(shortcutInfoCompat.mIsDeclaredInManifest ? 1 : 0);
        shortcutInfoCompat2.mIsDeclaredInManifest = n10;
        n10 = (int)(shortcutInfoCompat.mIsImmutable ? 1 : 0);
        shortcutInfoCompat2.mIsImmutable = n10;
        n10 = (int)(shortcutInfoCompat.mIsEnabled ? 1 : 0);
        shortcutInfoCompat2.mIsEnabled = n10;
        object = shortcutInfoCompat.mLocusId;
        shortcutInfoCompat2.mLocusId = object;
        n10 = (int)(shortcutInfoCompat.mIsLongLived ? 1 : 0);
        shortcutInfoCompat2.mIsLongLived = n10;
        n10 = (int)(shortcutInfoCompat.mHasKeyFieldsOnly ? 1 : 0);
        shortcutInfoCompat2.mHasKeyFieldsOnly = n10;
        shortcutInfoCompat2.mRank = n10 = shortcutInfoCompat.mRank;
        object = shortcutInfoCompat.mPersons;
        if (object != null) {
            n11 = ((Person[])object).length;
            shortcutInfoCompat2.mPersons = object = Arrays.copyOf(object, n11);
        }
        if ((object = shortcutInfoCompat.mCategories) != null) {
            Set set = shortcutInfoCompat.mCategories;
            super(set);
            shortcutInfoCompat2.mCategories = object;
        }
        if ((shortcutInfoCompat = shortcutInfoCompat.mExtras) != null) {
            shortcutInfoCompat2.mExtras = shortcutInfoCompat;
        }
    }

    public ShortcutInfoCompat build() {
        Object object = this.mInfo.mLabel;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            int n10;
            object = this.mInfo;
            Object object2 = ((ShortcutInfoCompat)object).mIntents;
            if (object2 != null && (n10 = ((Intent[])object2).length) != 0) {
                n10 = (int)(this.mIsConversation ? 1 : 0);
                if (n10 != 0) {
                    object2 = ((ShortcutInfoCompat)object).mLocusId;
                    if (object2 == null) {
                        String string2 = ((ShortcutInfoCompat)object).mId;
                        ((ShortcutInfoCompat)object).mLocusId = object2 = new LocusIdCompat(string2);
                    }
                    object = this.mInfo;
                    n10 = 1;
                    ((ShortcutInfoCompat)object).mIsLongLived = n10;
                }
                return this.mInfo;
            }
            object = new IllegalArgumentException("Shortcut must have an intent");
            throw object;
        }
        object = new IllegalArgumentException("Shortcut must have a non-empty label");
        throw object;
    }

    public ShortcutInfoCompat$Builder setActivity(ComponentName componentName) {
        this.mInfo.mActivity = componentName;
        return this;
    }

    public ShortcutInfoCompat$Builder setAlwaysBadged() {
        this.mInfo.mIsAlwaysBadged = true;
        return this;
    }

    public ShortcutInfoCompat$Builder setCategories(Set set) {
        this.mInfo.mCategories = set;
        return this;
    }

    public ShortcutInfoCompat$Builder setDisabledMessage(CharSequence charSequence) {
        this.mInfo.mDisabledMessage = charSequence;
        return this;
    }

    public ShortcutInfoCompat$Builder setExtras(PersistableBundle persistableBundle) {
        this.mInfo.mExtras = persistableBundle;
        return this;
    }

    public ShortcutInfoCompat$Builder setIcon(IconCompat iconCompat) {
        this.mInfo.mIcon = iconCompat;
        return this;
    }

    public ShortcutInfoCompat$Builder setIntent(Intent intent) {
        Intent[] intentArray = new Intent[]{intent};
        return this.setIntents(intentArray);
    }

    public ShortcutInfoCompat$Builder setIntents(Intent[] intentArray) {
        this.mInfo.mIntents = intentArray;
        return this;
    }

    public ShortcutInfoCompat$Builder setIsConversation() {
        this.mIsConversation = true;
        return this;
    }

    public ShortcutInfoCompat$Builder setLocusId(LocusIdCompat locusIdCompat) {
        this.mInfo.mLocusId = locusIdCompat;
        return this;
    }

    public ShortcutInfoCompat$Builder setLongLabel(CharSequence charSequence) {
        this.mInfo.mLongLabel = charSequence;
        return this;
    }

    public ShortcutInfoCompat$Builder setLongLived() {
        this.mInfo.mIsLongLived = true;
        return this;
    }

    public ShortcutInfoCompat$Builder setLongLived(boolean bl2) {
        this.mInfo.mIsLongLived = bl2;
        return this;
    }

    public ShortcutInfoCompat$Builder setPerson(Person person) {
        Person[] personArray = new Person[]{person};
        return this.setPersons(personArray);
    }

    public ShortcutInfoCompat$Builder setPersons(Person[] personArray) {
        this.mInfo.mPersons = personArray;
        return this;
    }

    public ShortcutInfoCompat$Builder setRank(int n10) {
        this.mInfo.mRank = n10;
        return this;
    }

    public ShortcutInfoCompat$Builder setShortLabel(CharSequence charSequence) {
        this.mInfo.mLabel = charSequence;
        return this;
    }
}

