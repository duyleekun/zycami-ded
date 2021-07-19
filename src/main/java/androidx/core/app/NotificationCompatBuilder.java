/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.Notification$BubbleMetadata
 *  android.app.Notification$Builder
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.app.RemoteInput
 *  android.content.Context
 *  android.content.LocusId
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Icon
 *  android.media.AudioAttributes
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.SparseArray
 *  android.widget.RemoteViews
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.LocusId;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$BubbleMetadata;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.app.RemoteInput;
import androidx.core.content.LocusIdCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotificationCompatBuilder
implements NotificationBuilderWithBuilderAccessor {
    private final List mActionExtrasList;
    private RemoteViews mBigContentView;
    private final Notification.Builder mBuilder;
    private final NotificationCompat$Builder mBuilderCompat;
    private RemoteViews mContentView;
    private final Context mContext;
    private final Bundle mExtras;
    private int mGroupAlertBehavior;
    private RemoteViews mHeadsUpContentView;

    public NotificationCompatBuilder(NotificationCompat$Builder object) {
        int n10;
        Bundle bundle;
        Object object2;
        Object object3;
        Notification.Builder builder;
        Object object4;
        Object object5;
        Bundle bundle2;
        int n11 = Build.VERSION.SDK_INT;
        this.mActionExtrasList = bundle2 = new ArrayList();
        this.mExtras = bundle2 = new Bundle();
        this.mBuilderCompat = object;
        bundle2 = ((NotificationCompat$Builder)object).mContext;
        this.mContext = bundle2;
        int n12 = 26;
        if (n11 >= n12) {
            object5 = ((NotificationCompat$Builder)object).mContext;
            object4 = ((NotificationCompat$Builder)object).mChannelId;
            this.mBuilder = builder = new Notification.Builder((Context)object5, (String)object4);
        } else {
            object5 = ((NotificationCompat$Builder)object).mContext;
            this.mBuilder = builder = new Notification.Builder((Context)object5);
        }
        builder = ((NotificationCompat$Builder)object).mNotification;
        object5 = this.mBuilder;
        long l10 = builder.when;
        object5 = object5.setWhen(l10);
        int n13 = builder.icon;
        int n14 = builder.iconLevel;
        object5 = object5.setSmallIcon(n13, n14);
        object4 = builder.contentView;
        object5 = object5.setContent((RemoteViews)object4);
        object4 = builder.tickerText;
        RemoteViews remoteViews = ((NotificationCompat$Builder)object).mTickerView;
        object5 = object5.setTicker((CharSequence)object4, remoteViews);
        object4 = builder.vibrate;
        object5 = object5.setVibrate((long[])object4);
        n13 = builder.ledARGB;
        n14 = builder.ledOnMS;
        int n15 = builder.ledOffMS;
        object5 = object5.setLights(n13, n14, n15);
        n13 = builder.flags;
        n14 = 2;
        n15 = 1;
        boolean bl2 = false;
        Person person = null;
        if (n13 &= n14) {
            n13 = n15;
        } else {
            n13 = 0;
            object4 = null;
        }
        object5 = object5.setOngoing(n13 != 0);
        n13 = builder.flags & 8;
        if (n13) {
            n13 = n15;
        } else {
            n13 = 0;
            object4 = null;
        }
        object5 = object5.setOnlyAlertOnce(n13 != 0);
        n13 = builder.flags;
        int n16 = 16;
        if (n13 &= n16) {
            n13 = n15;
        } else {
            n13 = 0;
            object4 = null;
        }
        object5 = object5.setAutoCancel(n13 != 0);
        n13 = builder.defaults;
        object5 = object5.setDefaults(n13);
        object4 = ((NotificationCompat$Builder)object).mContentTitle;
        object5 = object5.setContentTitle((CharSequence)object4);
        object4 = ((NotificationCompat$Builder)object).mContentText;
        object5 = object5.setContentText((CharSequence)object4);
        object4 = ((NotificationCompat$Builder)object).mContentInfo;
        object5 = object5.setContentInfo((CharSequence)object4);
        object4 = ((NotificationCompat$Builder)object).mContentIntent;
        object5 = object5.setContentIntent((PendingIntent)object4);
        object4 = builder.deleteIntent;
        object5 = object5.setDeleteIntent((PendingIntent)object4);
        object4 = ((NotificationCompat$Builder)object).mFullScreenIntent;
        int n17 = builder.flags & 0x80;
        if (n17) {
            n17 = n15;
        } else {
            n17 = 0;
            object3 = null;
        }
        object5 = object5.setFullScreenIntent((PendingIntent)object4, n17 != 0);
        object4 = ((NotificationCompat$Builder)object).mLargeIcon;
        object5 = object5.setLargeIcon((Bitmap)object4);
        n13 = ((NotificationCompat$Builder)object).mNumber;
        object5 = object5.setNumber(n13);
        n13 = ((NotificationCompat$Builder)object).mProgressMax;
        n17 = ((NotificationCompat$Builder)object).mProgress;
        int n18 = ((NotificationCompat$Builder)object).mProgressIndeterminate;
        object5.setProgress(n13, n17, n18 != 0);
        int n19 = 21;
        if (n11 < n19) {
            object4 = this.mBuilder;
            object3 = builder.sound;
            n18 = builder.audioStreamType;
            object4.setSound(object3, n18);
        }
        n13 = 20;
        if (n11 >= n16) {
            object2 = this.mBuilder;
            object3 = ((NotificationCompat$Builder)object).mSubText;
            object2 = object2.setSubText((CharSequence)object3);
            n17 = (int)(((NotificationCompat$Builder)object).mUseChronometer ? 1 : 0);
            object2 = object2.setUsesChronometer(n17 != 0);
            n17 = ((NotificationCompat$Builder)object).mPriority;
            object2.setPriority(n17);
            object2 = ((NotificationCompat$Builder)object).mActions.iterator();
            while (n17 = (int)(object2.hasNext() ? 1 : 0)) {
                object3 = (NotificationCompat$Action)object2.next();
                this.addAction((NotificationCompat$Action)object3);
            }
            object2 = ((NotificationCompat$Builder)object).mExtras;
            if (object2 != null) {
                object3 = this.mExtras;
                object3.putAll((Bundle)object2);
            }
            if (n11 < n13) {
                n16 = (int)(((NotificationCompat$Builder)object).mLocalOnly ? 1 : 0);
                if (n16 != 0) {
                    object2 = this.mExtras;
                    object3 = "android.support.localOnly";
                    object2.putBoolean((String)object3, n15 != 0);
                }
                if ((object2 = ((NotificationCompat$Builder)object).mGroupKey) != null) {
                    object3 = this.mExtras;
                    bundle = "android.support.groupKey";
                    object3.putString((String)bundle, (String)object2);
                    n16 = (int)(((NotificationCompat$Builder)object).mGroupSummary ? 1 : 0);
                    if (n16 != 0) {
                        object2 = this.mExtras;
                        object3 = "android.support.isGroupSummary";
                        object2.putBoolean((String)object3, n15 != 0);
                    } else {
                        object2 = this.mExtras;
                        object3 = "android.support.useSideChannel";
                        object2.putBoolean((String)object3, n15 != 0);
                    }
                }
                if ((object2 = ((NotificationCompat$Builder)object).mSortKey) != null) {
                    object3 = this.mExtras;
                    bundle = "android.support.sortKey";
                    object3.putString((String)bundle, (String)object2);
                }
            }
            object2 = ((NotificationCompat$Builder)object).mContentView;
            this.mContentView = object2;
            object2 = ((NotificationCompat$Builder)object).mBigContentView;
            this.mBigContentView = object2;
        }
        if (n11 >= (n16 = 17)) {
            object2 = this.mBuilder;
            n17 = (int)(((NotificationCompat$Builder)object).mShowWhen ? 1 : 0);
            object2.setShowWhen(n17 != 0);
        }
        if (n11 >= (n16 = 19) && n11 < n19) {
            object2 = NotificationCompatBuilder.getPeople(((NotificationCompat$Builder)object).mPersonList);
            object3 = ((NotificationCompat$Builder)object).mPeople;
            if ((object2 = NotificationCompatBuilder.combineLists((List)object2, (List)object3)) != null && !(n17 = (int)(object2.isEmpty() ? 1 : 0))) {
                object3 = this.mExtras;
                n18 = object2.size();
                bundle = new String[n18];
                object2 = object2.toArray((T[])bundle);
                bundle = "android.people";
                object3.putStringArray((String)bundle, (String[])object2);
            }
        }
        if (n11 >= n13) {
            object4 = this.mBuilder;
            n16 = (int)(((NotificationCompat$Builder)object).mLocalOnly ? 1 : 0);
            object4 = object4.setLocalOnly(n16 != 0);
            object2 = ((NotificationCompat$Builder)object).mGroupKey;
            object4 = object4.setGroup((String)object2);
            n16 = (int)(((NotificationCompat$Builder)object).mGroupSummary ? 1 : 0);
            object4 = object4.setGroupSummary(n16 != 0);
            object2 = ((NotificationCompat$Builder)object).mSortKey;
            object4.setSortKey((String)object2);
            n13 = ((NotificationCompat$Builder)object).mGroupAlertBehavior;
            this.mGroupAlertBehavior = n13;
        }
        n13 = 28;
        if (n11 >= n19) {
            object5 = this.mBuilder;
            object2 = ((NotificationCompat$Builder)object).mCategory;
            object5 = object5.setCategory((String)object2);
            n16 = ((NotificationCompat$Builder)object).mColor;
            object5 = object5.setColor(n16);
            n16 = ((NotificationCompat$Builder)object).mVisibility;
            object5 = object5.setVisibility(n16);
            object2 = ((NotificationCompat$Builder)object).mPublicVersion;
            object5 = object5.setPublicVersion((Notification)object2);
            object2 = builder.sound;
            object3 = builder.audioAttributes;
            object5.setSound((Uri)object2, (AudioAttributes)object3);
            if (n11 < n13) {
                object5 = NotificationCompatBuilder.getPeople(((NotificationCompat$Builder)object).mPersonList);
                object2 = ((NotificationCompat$Builder)object).mPeople;
                object5 = NotificationCompatBuilder.combineLists((List)object5, (List)object2);
            } else {
                object5 = ((NotificationCompat$Builder)object).mPeople;
            }
            if (object5 != null && (n16 = (int)(object5.isEmpty() ? 1 : 0)) == 0) {
                object5 = object5.iterator();
                while ((n16 = (int)(object5.hasNext() ? 1 : 0)) != 0) {
                    object2 = (String)object5.next();
                    object3 = this.mBuilder;
                    object3.addPerson((String)object2);
                }
            }
            object5 = ((NotificationCompat$Builder)object).mHeadsUpContentView;
            this.mHeadsUpContentView = object5;
            object5 = ((NotificationCompat$Builder)object).mInvisibleActions;
            n19 = ((ArrayList)object5).size();
            if (n19 > 0) {
                Object object6;
                int n20;
                object5 = ((NotificationCompat$Builder)object).getExtras();
                object2 = "android.car.EXTENSIONS";
                if ((object5 = object5.getBundle((String)object2)) == null) {
                    object5 = new Bundle();
                }
                super((Bundle)object5);
                bundle = new Bundle();
                String string2 = null;
                for (int i10 = 0; i10 < (n20 = ((ArrayList)(object6 = ((NotificationCompat$Builder)object).mInvisibleActions)).size()); ++i10) {
                    object6 = Integer.toString(i10);
                    Bundle bundle3 = NotificationCompatJellybean.getBundleForAction((NotificationCompat$Action)((NotificationCompat$Builder)object).mInvisibleActions.get(i10));
                    bundle.putBundle((String)object6, bundle3);
                }
                string2 = "invisible_actions";
                object5.putBundle(string2, bundle);
                object3.putBundle(string2, bundle);
                bundle = ((NotificationCompat$Builder)object).getExtras();
                bundle.putBundle((String)object2, (Bundle)object5);
                object5 = this.mExtras;
                object5.putBundle((String)object2, (Bundle)object3);
            }
        }
        if (n11 >= (n19 = 23) && (object5 = ((NotificationCompat$Builder)object).mSmallIcon) != null) {
            object2 = this.mBuilder;
            object2.setSmallIcon((Icon)object5);
        }
        if (n11 >= (n19 = 24)) {
            object5 = this.mBuilder;
            object2 = ((NotificationCompat$Builder)object).mExtras;
            object5 = object5.setExtras((Bundle)object2);
            object2 = ((NotificationCompat$Builder)object).mRemoteInputHistory;
            object5.setRemoteInputHistory((CharSequence[])object2);
            object5 = ((NotificationCompat$Builder)object).mContentView;
            if (object5 != null) {
                object2 = this.mBuilder;
                object2.setCustomContentView((RemoteViews)object5);
            }
            if ((object5 = ((NotificationCompat$Builder)object).mBigContentView) != null) {
                object2 = this.mBuilder;
                object2.setCustomBigContentView((RemoteViews)object5);
            }
            if ((object5 = ((NotificationCompat$Builder)object).mHeadsUpContentView) != null) {
                object2 = this.mBuilder;
                object2.setCustomHeadsUpContentView((RemoteViews)object5);
            }
        }
        n19 = 0;
        object5 = null;
        if (n11 >= n12) {
            object2 = this.mBuilder;
            n17 = ((NotificationCompat$Builder)object).mBadgeIcon;
            object2 = object2.setBadgeIconType(n17);
            object3 = ((NotificationCompat$Builder)object).mSettingsText;
            object2 = object2.setSettingsText((CharSequence)object3);
            object3 = ((NotificationCompat$Builder)object).mShortcutId;
            object2 = object2.setShortcutId((String)object3);
            long l11 = ((NotificationCompat$Builder)object).mTimeout;
            object2 = object2.setTimeoutAfter(l11);
            n17 = ((NotificationCompat$Builder)object).mGroupAlertBehavior;
            object2.setGroupAlertBehavior(n17);
            n16 = (int)(((NotificationCompat$Builder)object).mColorizedSet ? 1 : 0);
            if (n16 != 0) {
                object2 = this.mBuilder;
                n17 = (int)(((NotificationCompat$Builder)object).mColorized ? 1 : 0);
                object2.setColorized(n17 != 0);
            }
            if ((n16 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((NotificationCompat$Builder)object).mChannelId)) ? 1 : 0)) == 0) {
                object2 = this.mBuilder.setSound(null).setDefaults(0);
                person = object2.setLights(0, 0, 0);
                person.setVibrate(null);
            }
        }
        if (n11 >= n13) {
            object4 = ((NotificationCompat$Builder)object).mPersonList.iterator();
            while (bl2 = object4.hasNext()) {
                person = (Person)object4.next();
                object2 = this.mBuilder;
                person = person.toAndroidPerson();
                object2.addPerson((android.app.Person)person);
            }
        }
        if (n11 >= (n13 = 29)) {
            object4 = this.mBuilder;
            bl2 = ((NotificationCompat$Builder)object).mAllowSystemGeneratedContextualActions;
            object4.setAllowSystemGeneratedContextualActions(bl2);
            object4 = this.mBuilder;
            person = NotificationCompat$BubbleMetadata.toPlatform(((NotificationCompat$Builder)object).mBubbleMetadata);
            object4.setBubbleMetadata((Notification.BubbleMetadata)person);
            object4 = ((NotificationCompat$Builder)object).mLocusId;
            if (object4 != null) {
                person = this.mBuilder;
                object4 = ((LocusIdCompat)object4).toLocusId();
                person.setLocusId((LocusId)object4);
            }
        }
        if ((n10 = ((NotificationCompat$Builder)object).mSilent) != 0) {
            object = this.mBuilderCompat;
            n10 = ((NotificationCompat$Builder)object).mGroupSummary;
            this.mGroupAlertBehavior = n10 != 0 ? n14 : n15;
            this.mBuilder.setVibrate(null);
            object = this.mBuilder;
            object.setSound(null);
            builder.defaults = n10 = builder.defaults & 0xFFFFFFFE;
            builder.defaults = n10 &= 0xFFFFFFFD;
            builder = this.mBuilder;
            builder.setDefaults(n10);
            if (n11 >= n12) {
                object = this.mBuilderCompat.mGroupKey;
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) {
                    object = this.mBuilder;
                    String string3 = "silent";
                    object.setGroup(string3);
                }
                object = this.mBuilder;
                n11 = this.mGroupAlertBehavior;
                object.setGroupAlertBehavior(n11);
            }
        }
    }

    private void addAction(NotificationCompat$Action notificationCompat$Action) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 20;
        if (n10 >= n11) {
            Notification.Action.Builder builder;
            PendingIntent pendingIntent;
            CharSequence charSequence;
            Bundle bundle = notificationCompat$Action.getIconCompat();
            int n12 = 23;
            int n13 = 0;
            Bundle bundle2 = null;
            if (n10 >= n12) {
                if (bundle != null) {
                    bundle = bundle.toIcon();
                } else {
                    n11 = 0;
                    bundle = null;
                }
                charSequence = notificationCompat$Action.getTitle();
                pendingIntent = notificationCompat$Action.getActionIntent();
                builder = new Notification.Action.Builder((Icon)bundle, charSequence, pendingIntent);
            } else {
                if (bundle != null) {
                    n11 = bundle.getResId();
                } else {
                    n11 = 0;
                    bundle = null;
                }
                charSequence = notificationCompat$Action.getTitle();
                pendingIntent = notificationCompat$Action.getActionIntent();
                builder = new Notification.Action.Builder(n11, charSequence, pendingIntent);
            }
            bundle = notificationCompat$Action.getRemoteInputs();
            if (bundle != null) {
                bundle = RemoteInput.fromCompat(notificationCompat$Action.getRemoteInputs());
                int n14 = ((android.app.RemoteInput[])bundle).length;
                while (n13 < n14) {
                    pendingIntent = bundle[n13];
                    builder.addRemoteInput((android.app.RemoteInput)pendingIntent);
                    n13 += 1;
                }
            }
            if ((bundle = notificationCompat$Action.getExtras()) != null) {
                bundle2 = notificationCompat$Action.getExtras();
                bundle = new Bundle(bundle2);
            } else {
                bundle = new Bundle();
            }
            n13 = (int)(notificationCompat$Action.getAllowGeneratedReplies() ? 1 : 0);
            charSequence = "android.support.allowGeneratedReplies";
            bundle.putBoolean((String)charSequence, n13 != 0);
            n13 = 24;
            if (n10 >= n13) {
                n13 = (int)(notificationCompat$Action.getAllowGeneratedReplies() ? 1 : 0);
                builder.setAllowGeneratedReplies(n13 != 0);
            }
            n13 = notificationCompat$Action.getSemanticAction();
            charSequence = "android.support.action.semanticAction";
            bundle.putInt((String)charSequence, n13);
            n13 = 28;
            if (n10 >= n13) {
                n13 = notificationCompat$Action.getSemanticAction();
                builder.setSemanticAction(n13);
            }
            if (n10 >= (n13 = 29)) {
                n10 = (int)(notificationCompat$Action.isContextual() ? 1 : 0);
                builder.setContextual(n10 != 0);
            }
            boolean bl2 = notificationCompat$Action.getShowsUserInterface();
            bundle.putBoolean("android.support.action.showsUserInterface", bl2);
            builder.addExtras(bundle);
            notificationCompat$Action = this.mBuilder;
            Notification.Action action = builder.build();
            notificationCompat$Action.addAction(action);
        } else {
            n11 = 16;
            if (n10 >= n11) {
                List list = this.mActionExtrasList;
                Notification.Builder builder = this.mBuilder;
                notificationCompat$Action = NotificationCompatJellybean.writeActionAndGetExtras(builder, notificationCompat$Action);
                list.add(notificationCompat$Action);
            }
        }
    }

    private static List combineLists(List arrayList, List list) {
        if (arrayList == null) {
            return list;
        }
        if (list == null) {
            return arrayList;
        }
        int n10 = arrayList.size();
        int n11 = list.size();
        ArraySet arraySet = new ArraySet(n10 += n11);
        arraySet.addAll((Collection)arrayList);
        arraySet.addAll((Collection)list);
        arrayList = new ArrayList(arraySet);
        return arrayList;
    }

    private static List getPeople(List object) {
        if (object == null) {
            return null;
        }
        int n10 = object.size();
        ArrayList<String> arrayList = new ArrayList<String>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            String string2 = ((Person)object.next()).resolveToLegacyUri();
            arrayList.add(string2);
        }
        return arrayList;
    }

    private void removeSoundAndVibration(Notification notification) {
        int n10;
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = n10 = notification.defaults & 0xFFFFFFFE;
        notification.defaults = n10 &= 0xFFFFFFFD;
    }

    public Notification build() {
        int n10;
        RemoteViews remoteViews;
        int n11;
        RemoteViews remoteViews2;
        NotificationCompat$Style notificationCompat$Style = this.mBuilderCompat.mStyle;
        if (notificationCompat$Style != null) {
            notificationCompat$Style.apply(this);
        }
        if (notificationCompat$Style != null) {
            remoteViews2 = notificationCompat$Style.makeContentView(this);
        } else {
            n11 = 0;
            remoteViews2 = null;
        }
        Notification notification = this.buildInternal();
        if (remoteViews2 != null) {
            notification.contentView = remoteViews2;
        } else {
            remoteViews2 = this.mBuilderCompat.mContentView;
            if (remoteViews2 != null) {
                notification.contentView = remoteViews2;
            }
        }
        n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12 && notificationCompat$Style != null && (remoteViews = notificationCompat$Style.makeBigContentView(this)) != null) {
            notification.bigContentView = remoteViews;
        }
        if (n11 >= (n10 = 21) && notificationCompat$Style != null && (remoteViews = this.mBuilderCompat.mStyle.makeHeadsUpContentView(this)) != null) {
            notification.headsUpContentView = remoteViews;
        }
        if (n11 >= n12 && notificationCompat$Style != null && (remoteViews2 = NotificationCompat.getExtras(notification)) != null) {
            notificationCompat$Style.addCompatExtras((Bundle)remoteViews2);
        }
        return notification;
    }

    public Notification buildInternal() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return this.mBuilder.build();
        }
        n11 = 24;
        int n12 = 1;
        int n13 = 2;
        if (n10 >= n11) {
            Notification notification = this.mBuilder.build();
            n11 = this.mGroupAlertBehavior;
            if (n11 != 0) {
                String string2 = notification.getGroup();
                if (string2 != null && (n11 = notification.flags & 0x200) != 0 && (n11 = this.mGroupAlertBehavior) == n13) {
                    this.removeSoundAndVibration(notification);
                }
                if ((string2 = notification.getGroup()) != null && (n11 = notification.flags & 0x200) == 0 && (n11 = this.mGroupAlertBehavior) == n12) {
                    this.removeSoundAndVibration(notification);
                }
            }
            return notification;
        }
        n11 = 21;
        if (n10 >= n11) {
            Notification.Builder builder = this.mBuilder;
            Object object = this.mExtras;
            builder.setExtras(object);
            builder = this.mBuilder.build();
            object = this.mContentView;
            if (object != null) {
                builder.contentView = object;
            }
            if ((object = this.mBigContentView) != null) {
                builder.bigContentView = object;
            }
            if ((object = this.mHeadsUpContentView) != null) {
                builder.headsUpContentView = object;
            }
            if ((n11 = this.mGroupAlertBehavior) != 0) {
                object = builder.getGroup();
                if (object != null && (n11 = builder.flags & 0x200) != 0 && (n11 = this.mGroupAlertBehavior) == n13) {
                    this.removeSoundAndVibration((Notification)builder);
                }
                if ((object = builder.getGroup()) != null && (n11 = builder.flags & 0x200) == 0 && (n11 = this.mGroupAlertBehavior) == n12) {
                    this.removeSoundAndVibration((Notification)builder);
                }
            }
            return builder;
        }
        n11 = 20;
        if (n10 >= n11) {
            Notification.Builder builder = this.mBuilder;
            Object object = this.mExtras;
            builder.setExtras(object);
            builder = this.mBuilder.build();
            object = this.mContentView;
            if (object != null) {
                builder.contentView = object;
            }
            if ((object = this.mBigContentView) != null) {
                builder.bigContentView = object;
            }
            if ((n11 = this.mGroupAlertBehavior) != 0) {
                object = builder.getGroup();
                if (object != null && (n11 = builder.flags & 0x200) != 0 && (n11 = this.mGroupAlertBehavior) == n13) {
                    this.removeSoundAndVibration((Notification)builder);
                }
                if ((object = builder.getGroup()) != null && (n11 = builder.flags & 0x200) == 0 && (n11 = this.mGroupAlertBehavior) == n12) {
                    this.removeSoundAndVibration((Notification)builder);
                }
            }
            return builder;
        }
        n11 = 19;
        String string3 = "android.support.actionExtras";
        if (n10 >= n11) {
            Bundle bundle;
            SparseArray sparseArray = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (sparseArray != null) {
                bundle = this.mExtras;
                bundle.putSparseParcelableArray(string3, sparseArray);
            }
            sparseArray = this.mBuilder;
            bundle = this.mExtras;
            sparseArray.setExtras(bundle);
            sparseArray = this.mBuilder.build();
            bundle = this.mContentView;
            if (bundle != null) {
                sparseArray.contentView = bundle;
            }
            if ((bundle = this.mBigContentView) != null) {
                sparseArray.bigContentView = bundle;
            }
            return sparseArray;
        }
        n11 = 16;
        if (n10 >= n11) {
            boolean bl2;
            Notification notification = this.mBuilder.build();
            Bundle bundle = NotificationCompat.getExtras(notification);
            Object object = this.mExtras;
            Bundle bundle2 = new Bundle((Bundle)object);
            object = this.mExtras.keySet().iterator();
            while (bl2 = object.hasNext()) {
                String string4 = (String)object.next();
                boolean bl3 = bundle.containsKey(string4);
                if (!bl3) continue;
                bundle2.remove(string4);
            }
            bundle.putAll(bundle2);
            bundle = NotificationCompatJellybean.buildActionExtrasMap(this.mActionExtrasList);
            if (bundle != null) {
                bundle2 = NotificationCompat.getExtras(notification);
                bundle2.putSparseParcelableArray(string3, (SparseArray)bundle);
            }
            if ((bundle = this.mContentView) != null) {
                notification.contentView = bundle;
            }
            if ((bundle = this.mBigContentView) != null) {
                notification.bigContentView = bundle;
            }
            return notification;
        }
        return this.mBuilder.getNotification();
    }

    public Notification.Builder getBuilder() {
        return this.mBuilder;
    }

    public Context getContext() {
        return this.mContext;
    }
}

