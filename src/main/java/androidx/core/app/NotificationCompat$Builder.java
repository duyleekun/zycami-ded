/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Builder
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.media.AudioAttributes$Builder
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.widget.RemoteViews
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Action$Builder;
import androidx.core.app.NotificationCompat$BubbleMetadata;
import androidx.core.app.NotificationCompat$Extender;
import androidx.core.app.NotificationCompat$Style;
import androidx.core.app.NotificationCompatBuilder;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public class NotificationCompat$Builder {
    private static final int MAX_CHARSEQUENCE_LENGTH = 5120;
    public ArrayList mActions;
    public boolean mAllowSystemGeneratedContextualActions;
    public int mBadgeIcon;
    public RemoteViews mBigContentView;
    public NotificationCompat$BubbleMetadata mBubbleMetadata;
    public String mCategory;
    public String mChannelId;
    public boolean mChronometerCountDown;
    public int mColor;
    public boolean mColorized;
    public boolean mColorizedSet;
    public CharSequence mContentInfo;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public RemoteViews mContentView;
    public Context mContext;
    public Bundle mExtras;
    public PendingIntent mFullScreenIntent;
    public int mGroupAlertBehavior;
    public String mGroupKey;
    public boolean mGroupSummary;
    public RemoteViews mHeadsUpContentView;
    public ArrayList mInvisibleActions;
    public Bitmap mLargeIcon;
    public boolean mLocalOnly;
    public LocusIdCompat mLocusId;
    public Notification mNotification;
    public int mNumber;
    public ArrayList mPeople;
    public ArrayList mPersonList;
    public int mPriority;
    public int mProgress;
    public boolean mProgressIndeterminate;
    public int mProgressMax;
    public Notification mPublicVersion;
    public CharSequence[] mRemoteInputHistory;
    public CharSequence mSettingsText;
    public String mShortcutId;
    public boolean mShowWhen;
    public boolean mSilent;
    public Icon mSmallIcon;
    public String mSortKey;
    public NotificationCompat$Style mStyle;
    public CharSequence mSubText;
    public RemoteViews mTickerView;
    public long mTimeout;
    public boolean mUseChronometer;
    public int mVisibility;

    public NotificationCompat$Builder(Context context) {
        this(context, (String)null);
    }

    public NotificationCompat$Builder(Context context, Notification object) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl32 = Build.VERSION.SDK_INT;
        Object object2 = NotificationCompat.getChannelId((Notification)object);
        this(context, (String)object2);
        context = ((Notification)object).extras;
        object2 = NotificationCompat$Style.extractStyleFromNotification((Notification)object);
        Object object3 = NotificationCompat.getContentTitle((Notification)object);
        object3 = this.setContentTitle((CharSequence)object3);
        Object object4 = NotificationCompat.getContentText((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setContentText((CharSequence)object4);
        object4 = NotificationCompat.getContentInfo((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setContentInfo((CharSequence)object4);
        object4 = NotificationCompat.getSubText((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setSubText((CharSequence)object4);
        object4 = NotificationCompat.getSettingsText((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setSettingsText((CharSequence)object4).setStyle((NotificationCompat$Style)object2);
        object4 = ((Notification)object).contentIntent;
        object3 = ((NotificationCompat$Builder)object3).setContentIntent((PendingIntent)object4);
        object4 = NotificationCompat.getGroup((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setGroup((String)object4);
        int n10 = NotificationCompat.isGroupSummary((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setGroupSummary(n10 != 0);
        object4 = NotificationCompat.getLocusId((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setLocusId((LocusIdCompat)object4);
        long l10 = ((Notification)object).when;
        object3 = ((NotificationCompat$Builder)object3).setWhen(l10);
        n10 = NotificationCompat.getShowWhen((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setShowWhen(n10 != 0);
        n10 = NotificationCompat.getUsesChronometer((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setUsesChronometer(n10 != 0);
        n10 = NotificationCompat.getAutoCancel((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setAutoCancel(n10 != 0);
        n10 = NotificationCompat.getOnlyAlertOnce((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setOnlyAlertOnce(n10 != 0);
        n10 = NotificationCompat.getOngoing((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setOngoing(n10 != 0);
        n10 = NotificationCompat.getLocalOnly((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setLocalOnly(n10 != 0);
        object4 = ((Notification)object).largeIcon;
        object3 = ((NotificationCompat$Builder)object3).setLargeIcon((Bitmap)object4);
        n10 = NotificationCompat.getBadgeIconType((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setBadgeIconType(n10);
        object4 = NotificationCompat.getCategory((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setCategory((String)object4);
        object4 = NotificationCompat.getBubbleMetadata((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setBubbleMetadata((NotificationCompat$BubbleMetadata)object4);
        n10 = ((Notification)object).number;
        object3 = ((NotificationCompat$Builder)object3).setNumber(n10);
        object4 = ((Notification)object).tickerText;
        object3 = ((NotificationCompat$Builder)object3).setTicker((CharSequence)object4);
        object4 = ((Notification)object).contentIntent;
        object3 = ((NotificationCompat$Builder)object3).setContentIntent((PendingIntent)object4);
        object4 = ((Notification)object).deleteIntent;
        object3 = ((NotificationCompat$Builder)object3).setDeleteIntent((PendingIntent)object4);
        object4 = ((Notification)object).fullScreenIntent;
        int n11 = NotificationCompat.getHighPriority((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setFullScreenIntent((PendingIntent)object4, n11 != 0);
        object4 = ((Notification)object).sound;
        n11 = ((Notification)object).audioStreamType;
        object3 = ((NotificationCompat$Builder)object3).setSound((Uri)object4, n11);
        object4 = ((Notification)object).vibrate;
        object3 = ((NotificationCompat$Builder)object3).setVibrate((long[])object4);
        n10 = ((Notification)object).ledARGB;
        n11 = ((Notification)object).ledOnMS;
        int n12 = ((Notification)object).ledOffMS;
        object3 = ((NotificationCompat$Builder)object3).setLights(n10, n11, n12);
        n10 = ((Notification)object).defaults;
        object3 = ((NotificationCompat$Builder)object3).setDefaults(n10);
        n10 = ((Notification)object).priority;
        object3 = ((NotificationCompat$Builder)object3).setPriority(n10);
        n10 = NotificationCompat.getColor((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setColor(n10);
        n10 = NotificationCompat.getVisibility((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setVisibility(n10);
        object4 = NotificationCompat.getPublicVersion((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setPublicVersion((Notification)object4);
        object4 = NotificationCompat.getSortKey((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setSortKey((String)object4);
        l10 = NotificationCompat.getTimeoutAfter((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setTimeoutAfter(l10);
        object4 = NotificationCompat.getShortcutId((Notification)object);
        object3 = ((NotificationCompat$Builder)object3).setShortcutId((String)object4);
        object4 = "android.progressMax";
        n10 = context.getInt((String)object4);
        Object object5 = "android.progress";
        n11 = context.getInt((String)object5);
        Object object6 = "android.progressIndeterminate";
        boolean bl7 = context.getBoolean((String)object6);
        object3 = ((NotificationCompat$Builder)object3).setProgress(n10, n11, bl7);
        n10 = (int)(NotificationCompat.getAllowSystemGeneratedContextualActions((Notification)object) ? 1 : 0);
        object3 = ((NotificationCompat$Builder)object3).setAllowSystemGeneratedContextualActions(n10 != 0);
        n10 = ((Notification)object).icon;
        n11 = ((Notification)object).iconLevel;
        object3 = ((NotificationCompat$Builder)object3).setSmallIcon(n10, n11);
        object2 = NotificationCompat$Builder.getExtrasWithoutDuplicateData((Notification)object, (NotificationCompat$Style)object2);
        ((NotificationCompat$Builder)object3).addExtras((Bundle)object2);
        boolean bl8 = 23 != 0;
        if (bl32 >= bl8) {
            object2 = object.getSmallIcon();
            this.mSmallIcon = object2;
        }
        object2 = ((Notification)object).actions;
        int n13 = 0;
        object3 = null;
        if (object2 != null && (n10 = ((Notification.Action[])object2).length) != 0) {
            n10 = ((Notification.Action[])object2).length;
            object5 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                object6 = NotificationCompat$Action$Builder.fromAndroidAction((Notification.Action)object2[n11]).build();
                this.addAction((NotificationCompat$Action)object6);
            }
        }
        if (bl32 >= (bl6 = 21 != 0) && (n10 = (int)((object2 = NotificationCompat.getInvisibleActions((Notification)object)).isEmpty() ? 1 : 0)) == 0) {
            object2 = object2.iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object4 = (NotificationCompat$Action)object2.next();
                this.addInvisibleAction((NotificationCompat$Action)object4);
            }
        }
        object2 = ((Notification)object).extras;
        object4 = "android.people";
        if ((object2 = object2.getStringArray((String)object4)) != null && (n10 = ((Object)object2).length) != 0) {
            n10 = ((Object)object2).length;
            while (n13 < n10) {
                object5 = object2[n13];
                this.addPerson((String)object5);
                ++n13;
            }
        }
        if (bl32 >= (bl5 = 28 != 0)) {
            boolean bl9;
            object = ((Notification)object).extras;
            object2 = "android.people.list";
            if ((object = object.getParcelableArrayList((String)object2)) != null && !(bl9 = ((ArrayList)object).isEmpty())) {
                boolean bl10;
                object = ((ArrayList)object).iterator();
                while (bl10 = object.hasNext()) {
                    object2 = Person.fromAndroidPerson((android.app.Person)object.next());
                    this.addPerson((Person)object2);
                }
            }
        }
        if (bl32 >= (bl4 = 24 != 0) && (bl3 = context.containsKey((String)(object = "android.chronometerCountDown")))) {
            bl4 = context.getBoolean((String)object);
            this.setChronometerCountDown(bl4);
        }
        if (bl32 >= (bl4 = 26 != 0) && (bl2 = context.containsKey((String)(object = "android.colorized")))) {
            boolean bl11 = context.getBoolean((String)object);
            this.setColorized(bl11);
        }
    }

    public NotificationCompat$Builder(Context object, String string2) {
        long l10;
        Notification notification;
        boolean bl2;
        ArrayList arrayList;
        this.mActions = arrayList = new ArrayList();
        this.mPersonList = arrayList = new ArrayList();
        this.mInvisibleActions = arrayList = new ArrayList();
        this.mShowWhen = bl2 = true;
        this.mLocalOnly = false;
        this.mColor = 0;
        this.mVisibility = 0;
        this.mBadgeIcon = 0;
        this.mGroupAlertBehavior = 0;
        this.mNotification = notification = new Notification();
        this.mContext = object;
        this.mChannelId = string2;
        notification.when = l10 = System.currentTimeMillis();
        this.mNotification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = object;
        this.mAllowSystemGeneratedContextualActions = bl2;
    }

    private static Bundle getExtrasWithoutDuplicateData(Notification object, NotificationCompat$Style notificationCompat$Style) {
        Bundle bundle = object.extras;
        if (bundle == null) {
            return null;
        }
        object = object.extras;
        bundle = new Bundle((Bundle)object);
        bundle.remove("android.title");
        bundle.remove("android.text");
        bundle.remove("android.infoText");
        bundle.remove("android.subText");
        bundle.remove("android.intent.extra.CHANNEL_ID");
        bundle.remove("android.intent.extra.CHANNEL_GROUP_ID");
        bundle.remove("android.showWhen");
        bundle.remove("android.progress");
        bundle.remove("android.progressMax");
        bundle.remove("android.progressIndeterminate");
        bundle.remove("android.chronometerCountDown");
        bundle.remove("android.colorized");
        bundle.remove("android.people.list");
        bundle.remove("android.people");
        bundle.remove("android.support.sortKey");
        bundle.remove("android.support.groupKey");
        bundle.remove("android.support.isGroupSummary");
        bundle.remove("android.support.localOnly");
        bundle.remove("android.support.actionExtras");
        object = "android.car.EXTENSIONS";
        Object object2 = bundle.getBundle((String)object);
        if (object2 != null) {
            Bundle bundle2 = new Bundle(object2);
            object2 = "invisible_actions";
            bundle2.remove((String)object2);
            bundle.putBundle((String)object, bundle2);
        }
        if (notificationCompat$Style != null) {
            notificationCompat$Style.clearCompatExtraKeys(bundle);
        }
        return bundle;
    }

    public static CharSequence limitCharSequenceLength(CharSequence charSequence) {
        int n10;
        if (charSequence == null) {
            return charSequence;
        }
        int n11 = charSequence.length();
        if (n11 > (n10 = 5120)) {
            n11 = 0;
            charSequence = charSequence.subSequence(0, n10);
        }
        return charSequence;
    }

    private Bitmap reduceLargeIconSize(Bitmap bitmap) {
        int n10;
        int n11;
        if (bitmap != null && (n11 = Build.VERSION.SDK_INT) < (n10 = 27)) {
            Resources resources = this.mContext.getResources();
            n10 = R$dimen.compat_notification_large_icon_max_width;
            n10 = resources.getDimensionPixelSize(n10);
            int n12 = R$dimen.compat_notification_large_icon_max_height;
            n11 = resources.getDimensionPixelSize(n12);
            n12 = bitmap.getWidth();
            if (n12 <= n10 && (n12 = bitmap.getHeight()) <= n11) {
                return bitmap;
            }
            double d10 = n10;
            int n13 = bitmap.getWidth();
            boolean bl2 = true;
            double d11 = Math.max((int)(bl2 ? 1 : 0), n13);
            d10 /= d11;
            d11 = n11;
            n11 = bitmap.getHeight();
            double d12 = Math.max((int)(bl2 ? 1 : 0), n11);
            double d13 = Math.min(d10, d11 /= d12);
            double d14 = Math.ceil((double)bitmap.getWidth() * d13);
            n12 = (int)d14;
            n13 = bitmap.getHeight();
            d11 = (double)n13 * d13;
            d13 = Math.ceil(d11);
            n11 = (int)d13;
            bitmap = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n12, (int)n11, (boolean)bl2);
        }
        return bitmap;
    }

    private void setFlag(int n10, boolean bl2) {
        if (bl2) {
            Notification notification = this.mNotification;
            int n11 = notification.flags;
            notification.flags = n10 |= n11;
        } else {
            Notification notification = this.mNotification;
            int n12 = notification.flags;
            notification.flags = n10 = ~n10 & n12;
        }
    }

    private boolean useExistingRemoteView() {
        boolean bl2;
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (bl2 = notificationCompat$Style.displayCustomViewInline())) {
            bl2 = false;
            notificationCompat$Style = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public NotificationCompat$Builder addAction(int n10, CharSequence charSequence, PendingIntent pendingIntent) {
        ArrayList arrayList = this.mActions;
        NotificationCompat$Action notificationCompat$Action = new NotificationCompat$Action(n10, charSequence, pendingIntent);
        arrayList.add(notificationCompat$Action);
        return this;
    }

    public NotificationCompat$Builder addAction(NotificationCompat$Action notificationCompat$Action) {
        if (notificationCompat$Action != null) {
            ArrayList arrayList = this.mActions;
            arrayList.add(notificationCompat$Action);
        }
        return this;
    }

    public NotificationCompat$Builder addExtras(Bundle bundle) {
        if (bundle != null) {
            Bundle bundle2 = this.mExtras;
            if (bundle2 == null) {
                this.mExtras = bundle2 = new Bundle(bundle);
            } else {
                bundle2.putAll(bundle);
            }
        }
        return this;
    }

    public NotificationCompat$Builder addInvisibleAction(int n10, CharSequence charSequence, PendingIntent pendingIntent) {
        ArrayList arrayList = this.mInvisibleActions;
        NotificationCompat$Action notificationCompat$Action = new NotificationCompat$Action(n10, charSequence, pendingIntent);
        arrayList.add(notificationCompat$Action);
        return this;
    }

    public NotificationCompat$Builder addInvisibleAction(NotificationCompat$Action notificationCompat$Action) {
        if (notificationCompat$Action != null) {
            ArrayList arrayList = this.mInvisibleActions;
            arrayList.add(notificationCompat$Action);
        }
        return this;
    }

    public NotificationCompat$Builder addPerson(Person person) {
        if (person != null) {
            ArrayList arrayList = this.mPersonList;
            arrayList.add(person);
        }
        return this;
    }

    public NotificationCompat$Builder addPerson(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            ArrayList arrayList = this.mPeople;
            arrayList.add(string2);
        }
        return this;
    }

    public Notification build() {
        NotificationCompatBuilder notificationCompatBuilder = new NotificationCompatBuilder(this);
        return notificationCompatBuilder.build();
    }

    public NotificationCompat$Builder clearActions() {
        this.mActions.clear();
        return this;
    }

    public NotificationCompat$Builder clearInvisibleActions() {
        this.mInvisibleActions.clear();
        Bundle bundle = this.mExtras;
        String string2 = "android.car.EXTENSIONS";
        bundle = bundle.getBundle(string2);
        if (bundle != null) {
            Bundle bundle2 = new Bundle(bundle);
            bundle2.remove("invisible_actions");
            bundle = this.mExtras;
            bundle.putBundle(string2, bundle2);
        }
        return this;
    }

    public NotificationCompat$Builder clearPeople() {
        this.mPersonList.clear();
        this.mPeople.clear();
        return this;
    }

    public RemoteViews createBigContentView() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 < n11) {
            return null;
        }
        Object object = this.mBigContentView;
        if (object != null && (n11 = (int)(this.useExistingRemoteView() ? 1 : 0)) != 0) {
            return this.mBigContentView;
        }
        object = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (notificationCompat$Style = notificationCompat$Style.makeBigContentView((NotificationBuilderWithBuilderAccessor)object)) != null) {
            return notificationCompat$Style;
        }
        object = ((NotificationCompatBuilder)object).build();
        int n12 = 24;
        if (n10 >= n12) {
            return Notification.Builder.recoverBuilder((Context)this.mContext, (Notification)object).createBigContentView();
        }
        return ((Notification)object).bigContentView;
    }

    public RemoteViews createContentView() {
        boolean bl2;
        Object object = this.mContentView;
        if (object != null && (bl2 = this.useExistingRemoteView())) {
            return this.mContentView;
        }
        object = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (notificationCompat$Style = notificationCompat$Style.makeContentView((NotificationBuilderWithBuilderAccessor)object)) != null) {
            return notificationCompat$Style;
        }
        object = ((NotificationCompatBuilder)object).build();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return Notification.Builder.recoverBuilder((Context)this.mContext, (Notification)object).createContentView();
        }
        return ((Notification)object).contentView;
    }

    public RemoteViews createHeadsUpContentView() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            return null;
        }
        Object object = this.mHeadsUpContentView;
        if (object != null && (n11 = (int)(this.useExistingRemoteView() ? 1 : 0)) != 0) {
            return this.mHeadsUpContentView;
        }
        object = new NotificationCompatBuilder(this);
        NotificationCompat$Style notificationCompat$Style = this.mStyle;
        if (notificationCompat$Style != null && (notificationCompat$Style = notificationCompat$Style.makeHeadsUpContentView((NotificationBuilderWithBuilderAccessor)object)) != null) {
            return notificationCompat$Style;
        }
        object = ((NotificationCompatBuilder)object).build();
        int n12 = 24;
        if (n10 >= n12) {
            return Notification.Builder.recoverBuilder((Context)this.mContext, (Notification)object).createHeadsUpContentView();
        }
        return ((Notification)object).headsUpContentView;
    }

    public NotificationCompat$Builder extend(NotificationCompat$Extender notificationCompat$Extender) {
        notificationCompat$Extender.extend(this);
        return this;
    }

    public RemoteViews getBigContentView() {
        return this.mBigContentView;
    }

    public NotificationCompat$BubbleMetadata getBubbleMetadata() {
        return this.mBubbleMetadata;
    }

    public int getColor() {
        return this.mColor;
    }

    public RemoteViews getContentView() {
        return this.mContentView;
    }

    public Bundle getExtras() {
        Bundle bundle = this.mExtras;
        if (bundle == null) {
            this.mExtras = bundle = new Bundle();
        }
        return this.mExtras;
    }

    public RemoteViews getHeadsUpContentView() {
        return this.mHeadsUpContentView;
    }

    public Notification getNotification() {
        return this.build();
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getWhenIfShowing() {
        long l10;
        boolean bl2 = this.mShowWhen;
        if (bl2) {
            Notification notification = this.mNotification;
            l10 = notification.when;
        } else {
            l10 = 0L;
        }
        return l10;
    }

    public NotificationCompat$Builder setAllowSystemGeneratedContextualActions(boolean bl2) {
        this.mAllowSystemGeneratedContextualActions = bl2;
        return this;
    }

    public NotificationCompat$Builder setAutoCancel(boolean bl2) {
        this.setFlag(16, bl2);
        return this;
    }

    public NotificationCompat$Builder setBadgeIconType(int n10) {
        this.mBadgeIcon = n10;
        return this;
    }

    public NotificationCompat$Builder setBubbleMetadata(NotificationCompat$BubbleMetadata notificationCompat$BubbleMetadata) {
        this.mBubbleMetadata = notificationCompat$BubbleMetadata;
        return this;
    }

    public NotificationCompat$Builder setCategory(String string2) {
        this.mCategory = string2;
        return this;
    }

    public NotificationCompat$Builder setChannelId(String string2) {
        this.mChannelId = string2;
        return this;
    }

    public NotificationCompat$Builder setChronometerCountDown(boolean bl2) {
        this.mChronometerCountDown = bl2;
        this.getExtras().putBoolean("android.chronometerCountDown", bl2);
        return this;
    }

    public NotificationCompat$Builder setColor(int n10) {
        this.mColor = n10;
        return this;
    }

    public NotificationCompat$Builder setColorized(boolean bl2) {
        this.mColorized = bl2;
        this.mColorizedSet = true;
        return this;
    }

    public NotificationCompat$Builder setContent(RemoteViews remoteViews) {
        this.mNotification.contentView = remoteViews;
        return this;
    }

    public NotificationCompat$Builder setContentInfo(CharSequence charSequence) {
        this.mContentInfo = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$Builder setContentIntent(PendingIntent pendingIntent) {
        this.mContentIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$Builder setContentText(CharSequence charSequence) {
        this.mContentText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$Builder setContentTitle(CharSequence charSequence) {
        this.mContentTitle = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$Builder setCustomBigContentView(RemoteViews remoteViews) {
        this.mBigContentView = remoteViews;
        return this;
    }

    public NotificationCompat$Builder setCustomContentView(RemoteViews remoteViews) {
        this.mContentView = remoteViews;
        return this;
    }

    public NotificationCompat$Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
        this.mHeadsUpContentView = remoteViews;
        return this;
    }

    public NotificationCompat$Builder setDefaults(int n10) {
        Notification notification = this.mNotification;
        notification.defaults = n10;
        if ((n10 &= 4) != 0) {
            notification.flags = n10 = notification.flags | 1;
        }
        return this;
    }

    public NotificationCompat$Builder setDeleteIntent(PendingIntent pendingIntent) {
        this.mNotification.deleteIntent = pendingIntent;
        return this;
    }

    public NotificationCompat$Builder setExtras(Bundle bundle) {
        this.mExtras = bundle;
        return this;
    }

    public NotificationCompat$Builder setFullScreenIntent(PendingIntent pendingIntent, boolean bl2) {
        this.mFullScreenIntent = pendingIntent;
        this.setFlag(128, bl2);
        return this;
    }

    public NotificationCompat$Builder setGroup(String string2) {
        this.mGroupKey = string2;
        return this;
    }

    public NotificationCompat$Builder setGroupAlertBehavior(int n10) {
        this.mGroupAlertBehavior = n10;
        return this;
    }

    public NotificationCompat$Builder setGroupSummary(boolean bl2) {
        this.mGroupSummary = bl2;
        return this;
    }

    public NotificationCompat$Builder setLargeIcon(Bitmap bitmap) {
        this.mLargeIcon = bitmap = this.reduceLargeIconSize(bitmap);
        return this;
    }

    public NotificationCompat$Builder setLights(int n10, int n11, int n12) {
        Notification notification = this.mNotification;
        notification.ledARGB = n10;
        notification.ledOnMS = n11;
        notification.ledOffMS = n12;
        n10 = n11 != 0 && n12 != 0 ? 1 : 0;
        n11 = notification.flags & 0xFFFFFFFE;
        notification.flags = n10 |= n11;
        return this;
    }

    public NotificationCompat$Builder setLocalOnly(boolean bl2) {
        this.mLocalOnly = bl2;
        return this;
    }

    public NotificationCompat$Builder setLocusId(LocusIdCompat locusIdCompat) {
        this.mLocusId = locusIdCompat;
        return this;
    }

    public NotificationCompat$Builder setNotificationSilent() {
        this.mSilent = true;
        return this;
    }

    public NotificationCompat$Builder setNumber(int n10) {
        this.mNumber = n10;
        return this;
    }

    public NotificationCompat$Builder setOngoing(boolean bl2) {
        this.setFlag(2, bl2);
        return this;
    }

    public NotificationCompat$Builder setOnlyAlertOnce(boolean bl2) {
        this.setFlag(8, bl2);
        return this;
    }

    public NotificationCompat$Builder setPriority(int n10) {
        this.mPriority = n10;
        return this;
    }

    public NotificationCompat$Builder setProgress(int n10, int n11, boolean bl2) {
        this.mProgressMax = n10;
        this.mProgress = n11;
        this.mProgressIndeterminate = bl2;
        return this;
    }

    public NotificationCompat$Builder setPublicVersion(Notification notification) {
        this.mPublicVersion = notification;
        return this;
    }

    public NotificationCompat$Builder setRemoteInputHistory(CharSequence[] charSequenceArray) {
        this.mRemoteInputHistory = charSequenceArray;
        return this;
    }

    public NotificationCompat$Builder setSettingsText(CharSequence charSequence) {
        this.mSettingsText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$Builder setShortcutId(String string2) {
        this.mShortcutId = string2;
        return this;
    }

    public NotificationCompat$Builder setShortcutInfo(ShortcutInfoCompat object) {
        if (object == null) {
            return this;
        }
        Object object2 = ((ShortcutInfoCompat)object).getId();
        this.mShortcutId = object2;
        object2 = this.mLocusId;
        if (object2 == null) {
            object2 = ((ShortcutInfoCompat)object).getLocusId();
            if (object2 != null) {
                this.mLocusId = object2 = ((ShortcutInfoCompat)object).getLocusId();
            } else {
                object2 = ((ShortcutInfoCompat)object).getId();
                if (object2 != null) {
                    String string2 = ((ShortcutInfoCompat)object).getId();
                    this.mLocusId = object2 = new LocusIdCompat(string2);
                }
            }
        }
        if ((object2 = this.mContentTitle) == null) {
            object = ((ShortcutInfoCompat)object).getShortLabel();
            this.setContentTitle((CharSequence)object);
        }
        return this;
    }

    public NotificationCompat$Builder setShowWhen(boolean bl2) {
        this.mShowWhen = bl2;
        return this;
    }

    public NotificationCompat$Builder setSilent(boolean bl2) {
        this.mSilent = bl2;
        return this;
    }

    public NotificationCompat$Builder setSmallIcon(int n10) {
        this.mNotification.icon = n10;
        return this;
    }

    public NotificationCompat$Builder setSmallIcon(int n10, int n11) {
        Notification notification = this.mNotification;
        notification.icon = n10;
        notification.iconLevel = n11;
        return this;
    }

    public NotificationCompat$Builder setSmallIcon(IconCompat iconCompat) {
        Context context = this.mContext;
        iconCompat = iconCompat.toIcon(context);
        this.mSmallIcon = iconCompat;
        return this;
    }

    public NotificationCompat$Builder setSortKey(String string2) {
        this.mSortKey = string2;
        return this;
    }

    public NotificationCompat$Builder setSound(Uri uri) {
        Notification notification = this.mNotification;
        notification.sound = uri;
        notification.audioStreamType = -1;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            uri = new AudioAttributes.Builder();
            uri = uri.setContentType(4);
            n11 = 5;
            uri = uri.setUsage(n11).build();
            notification.audioAttributes = uri;
        }
        return this;
    }

    public NotificationCompat$Builder setSound(Uri uri, int n10) {
        Notification notification = this.mNotification;
        notification.sound = uri;
        notification.audioStreamType = n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            uri = new AudioAttributes.Builder();
            n12 = 4;
            uri = uri.setContentType(n12).setLegacyStreamType(n10).build();
            notification.audioAttributes = uri;
        }
        return this;
    }

    public NotificationCompat$Builder setStyle(NotificationCompat$Style notificationCompat$Style) {
        NotificationCompat$Style notificationCompat$Style2 = this.mStyle;
        if (notificationCompat$Style2 != notificationCompat$Style) {
            this.mStyle = notificationCompat$Style;
            if (notificationCompat$Style != null) {
                notificationCompat$Style.setBuilder(this);
            }
        }
        return this;
    }

    public NotificationCompat$Builder setSubText(CharSequence charSequence) {
        this.mSubText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$Builder setTicker(CharSequence charSequence) {
        Notification notification = this.mNotification;
        notification.tickerText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        return this;
    }

    public NotificationCompat$Builder setTicker(CharSequence charSequence, RemoteViews remoteViews) {
        Notification notification = this.mNotification;
        notification.tickerText = charSequence = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mTickerView = remoteViews;
        return this;
    }

    public NotificationCompat$Builder setTimeoutAfter(long l10) {
        this.mTimeout = l10;
        return this;
    }

    public NotificationCompat$Builder setUsesChronometer(boolean bl2) {
        this.mUseChronometer = bl2;
        return this;
    }

    public NotificationCompat$Builder setVibrate(long[] lArray) {
        this.mNotification.vibrate = lArray;
        return this;
    }

    public NotificationCompat$Builder setVisibility(int n10) {
        this.mVisibility = n10;
        return this;
    }

    public NotificationCompat$Builder setWhen(long l10) {
        this.mNotification.when = l10;
        return this;
    }
}

