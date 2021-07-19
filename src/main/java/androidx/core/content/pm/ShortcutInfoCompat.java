/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Person
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.LocusId
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ShortcutInfo
 *  android.content.pm.ShortcutInfo$Builder
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.PersistableBundle
 *  android.os.UserHandle
 *  android.text.TextUtils
 */
package androidx.core.content.pm;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat$Builder;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    public ComponentName mActivity;
    public Set mCategories;
    public Context mContext;
    public CharSequence mDisabledMessage;
    public int mDisabledReason;
    public PersistableBundle mExtras;
    public boolean mHasKeyFieldsOnly;
    public IconCompat mIcon;
    public String mId;
    public Intent[] mIntents;
    public boolean mIsAlwaysBadged;
    public boolean mIsCached;
    public boolean mIsDeclaredInManifest;
    public boolean mIsDynamic;
    public boolean mIsEnabled = true;
    public boolean mIsImmutable;
    public boolean mIsLongLived;
    public boolean mIsPinned;
    public CharSequence mLabel;
    public long mLastChangedTimestamp;
    public LocusIdCompat mLocusId;
    public CharSequence mLongLabel;
    public String mPackageName;
    public androidx.core.app.Person[] mPersons;
    public int mRank;
    public UserHandle mUser;

    private PersistableBundle buildLegacyExtrasBundle() {
        CharSequence charSequence;
        PersistableBundle persistableBundle;
        int n10;
        Object object = this.mExtras;
        if (object == null) {
            object = new PersistableBundle();
            this.mExtras = object;
        }
        if ((object = this.mPersons) != null && (n10 = ((PersistableBundle)object).length) > 0) {
            persistableBundle = this.mExtras;
            int n11 = ((PersistableBundle)object).length;
            charSequence = EXTRA_PERSON_COUNT;
            persistableBundle.putInt((String)charSequence, n11);
            n11 = 0;
            object = null;
            while (n11 < (n10 = ((androidx.core.app.Person[])(persistableBundle = this.mPersons)).length)) {
                persistableBundle = this.mExtras;
                charSequence = new StringBuilder();
                String string2 = EXTRA_PERSON_;
                ((StringBuilder)charSequence).append(string2);
                int n12 = n11 + 1;
                ((StringBuilder)charSequence).append(n12);
                charSequence = ((StringBuilder)charSequence).toString();
                androidx.core.app.Person[] personArray = this.mPersons;
                object = personArray[n11].toPersistableBundle();
                persistableBundle.putPersistableBundle((String)charSequence, (PersistableBundle)object);
                n11 = n12;
            }
        }
        if ((object = this.mLocusId) != null) {
            persistableBundle = this.mExtras;
            object = ((LocusIdCompat)object).getId();
            charSequence = EXTRA_LOCUS_ID;
            persistableBundle.putString((String)charSequence, (String)object);
        }
        object = this.mExtras;
        n10 = (int)(this.mIsLongLived ? 1 : 0);
        object.putBoolean(EXTRA_LONG_LIVED, n10 != 0);
        return this.mExtras;
    }

    public static List fromShortcuts(Context context, List object) {
        int n10 = object.size();
        ArrayList<ShortcutInfo> arrayList = new ArrayList<ShortcutInfo>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = (ShortcutInfo)object.next();
            ShortcutInfoCompat$Builder shortcutInfoCompat$Builder = new ShortcutInfoCompat$Builder(context, (ShortcutInfo)object2);
            object2 = shortcutInfoCompat$Builder.build();
            arrayList.add((ShortcutInfo)object2);
        }
        return arrayList;
    }

    public static LocusIdCompat getLocusId(ShortcutInfo shortcutInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            LocusId locusId = shortcutInfo.getLocusId();
            if (locusId == null) {
                return null;
            }
            return LocusIdCompat.toLocusIdCompat(shortcutInfo.getLocusId());
        }
        return ShortcutInfoCompat.getLocusIdFromExtra(shortcutInfo.getExtras());
    }

    private static LocusIdCompat getLocusIdFromExtra(PersistableBundle object) {
        LocusIdCompat locusIdCompat = null;
        if (object == null) {
            return null;
        }
        String string2 = EXTRA_LOCUS_ID;
        if ((object = object.getString(string2)) != null) {
            locusIdCompat = new LocusIdCompat((String)object);
        }
        return locusIdCompat;
    }

    public static boolean getLongLivedFromExtra(PersistableBundle persistableBundle) {
        String string2;
        boolean bl2;
        if (persistableBundle != null && (bl2 = persistableBundle.containsKey(string2 = EXTRA_LONG_LIVED))) {
            return persistableBundle.getBoolean(string2);
        }
        return false;
    }

    public static androidx.core.app.Person[] getPersonsFromExtra(PersistableBundle persistableBundle) {
        String string2;
        boolean bl2;
        if (persistableBundle != null && (bl2 = persistableBundle.containsKey(string2 = EXTRA_PERSON_COUNT))) {
            int n10 = persistableBundle.getInt(string2);
            androidx.core.app.Person[] personArray = new androidx.core.app.Person[n10];
            int n11 = 0;
            while (n11 < n10) {
                Object object = new StringBuilder();
                String string3 = EXTRA_PERSON_;
                ((StringBuilder)object).append(string3);
                int n12 = n11 + 1;
                ((StringBuilder)object).append(n12);
                object = ((StringBuilder)object).toString();
                personArray[n11] = object = androidx.core.app.Person.fromPersistableBundle(persistableBundle.getPersistableBundle((String)object));
                n11 = n12;
            }
            return personArray;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Intent addToIntent(Intent intent) {
        Intent[] intentArray = this.mIntents;
        int n10 = intentArray.length + -1;
        Intent intent3 = intentArray[n10];
        intent3 = intent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)intent3);
        Object object = this.mLabel.toString();
        String string2 = "android.intent.extra.shortcut.NAME";
        intent3.putExtra(string2, (String)object);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            void var2_10;
            Object var2_6 = null;
            n10 = (int)(this.mIsAlwaysBadged ? 1 : 0);
            if (n10 != 0) {
                void var2_8;
                object = this.mContext.getPackageManager();
                string2 = this.mActivity;
                if (string2 != null) {
                    try {
                        Drawable drawable2 = object.getActivityIcon((ComponentName)string2);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {}
                }
                if (var2_8 == null) {
                    Drawable drawable3 = this.mContext.getApplicationInfo().loadIcon((PackageManager)object);
                }
            }
            object = this.mIcon;
            string2 = this.mContext;
            ((IconCompat)object).addToShortcutIntent(intent, (Drawable)var2_10, (Context)string2);
        }
        return intent;
    }

    public ComponentName getActivity() {
        return this.mActivity;
    }

    public Set getCategories() {
        return this.mCategories;
    }

    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getId() {
        return this.mId;
    }

    public Intent getIntent() {
        Intent[] intentArray = this.mIntents;
        int n10 = intentArray.length + -1;
        return intentArray[n10];
    }

    public Intent[] getIntents() {
        Intent[] intentArray = this.mIntents;
        int n10 = intentArray.length;
        return Arrays.copyOf(intentArray, n10);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    public ShortcutInfo toShortcutInfo() {
        int n10;
        int n11;
        Object object = this.mContext;
        Person[] personArray = this.mId;
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder((Context)object, (String)personArray);
        object = this.mLabel;
        builder = builder.setShortLabel((CharSequence)object);
        object = this.mIntents;
        builder = builder.setIntents((Intent[])object);
        object = this.mIcon;
        if (object != null) {
            personArray = this.mContext;
            object = ((IconCompat)object).toIcon((Context)personArray);
            builder.setIcon((Icon)object);
        }
        if ((n11 = TextUtils.isEmpty((CharSequence)(object = this.mLongLabel))) == 0) {
            object = this.mLongLabel;
            builder.setLongLabel((CharSequence)object);
        }
        if ((n11 = TextUtils.isEmpty((CharSequence)(object = this.mDisabledMessage))) == 0) {
            object = this.mDisabledMessage;
            builder.setDisabledMessage((CharSequence)object);
        }
        if ((object = this.mActivity) != null) {
            builder.setActivity((ComponentName)object);
        }
        if ((object = this.mCategories) != null) {
            builder.setCategories((Set)object);
        }
        n11 = this.mRank;
        builder.setRank(n11);
        object = this.mExtras;
        if (object != null) {
            builder.setExtras((PersistableBundle)object);
        }
        if ((n11 = Build.VERSION.SDK_INT) >= (n10 = 29)) {
            object = this.mPersons;
            if (object != null && (n10 = ((Object)object).length) > 0) {
                n11 = ((Object)object).length;
                personArray = new Person[n11];
                for (int i10 = 0; i10 < n11; ++i10) {
                    Person person;
                    personArray[i10] = person = this.mPersons[i10].toAndroidPerson();
                }
                builder.setPersons(personArray);
            }
            if ((object = this.mLocusId) != null) {
                object = ((LocusIdCompat)object).toLocusId();
                builder.setLocusId((LocusId)object);
            }
            n11 = (int)(this.mIsLongLived ? 1 : 0);
            builder.setLongLived(n11 != 0);
        } else {
            object = this.buildLegacyExtrasBundle();
            builder.setExtras((PersistableBundle)object);
        }
        return builder.build();
    }
}

