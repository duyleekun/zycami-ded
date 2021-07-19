/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$Style;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat$MediaStyle;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$BitmapCallback;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$CustomActionReceiver;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$MediaDescriptionAdapter;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$NotificationBroadcastReceiver;
import com.google.android.exoplayer2.ui.PlayerNotificationManager$NotificationListener;
import com.google.android.exoplayer2.ui.R$drawable;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.p0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PlayerNotificationManager {
    private static final String ACTION_DISMISS = "com.google.android.exoplayer.dismiss";
    public static final String ACTION_FAST_FORWARD = "com.google.android.exoplayer.ffwd";
    public static final String ACTION_NEXT = "com.google.android.exoplayer.next";
    public static final String ACTION_PAUSE = "com.google.android.exoplayer.pause";
    public static final String ACTION_PLAY = "com.google.android.exoplayer.play";
    public static final String ACTION_PREVIOUS = "com.google.android.exoplayer.prev";
    public static final String ACTION_REWIND = "com.google.android.exoplayer.rewind";
    public static final String ACTION_STOP = "com.google.android.exoplayer.stop";
    public static final String EXTRA_INSTANCE_ID = "INSTANCE_ID";
    private static final int MSG_START_OR_UPDATE_NOTIFICATION = 0;
    private static final int MSG_UPDATE_NOTIFICATION_BITMAP = 1;
    private static int instanceIdCounter;
    private int badgeIconType;
    private NotificationCompat$Builder builder;
    private List builderActions;
    private final String channelId;
    private int color;
    private boolean colorized;
    private final Context context;
    private ControlDispatcher controlDispatcher;
    private int currentNotificationTag;
    private final PlayerNotificationManager$CustomActionReceiver customActionReceiver;
    private final Map customActions;
    private int defaults;
    private final PendingIntent dismissPendingIntent;
    private final int instanceId;
    private final IntentFilter intentFilter;
    private boolean isNotificationStarted;
    private final Handler mainHandler;
    private final PlayerNotificationManager$MediaDescriptionAdapter mediaDescriptionAdapter;
    private MediaSessionCompat$Token mediaSessionToken;
    private final PlayerNotificationManager$NotificationBroadcastReceiver notificationBroadcastReceiver;
    private final int notificationId;
    private PlayerNotificationManager$NotificationListener notificationListener;
    private final NotificationManagerCompat notificationManager;
    private final Map playbackActions;
    private PlaybackPreparer playbackPreparer;
    private Player player;
    private final Player$EventListener playerListener;
    private int priority;
    private int smallIconResourceId;
    private boolean useChronometer;
    private boolean useNextAction;
    private boolean useNextActionInCompactView;
    private boolean usePlayPauseActions;
    private boolean usePreviousAction;
    private boolean usePreviousActionInCompactView;
    private boolean useStopAction;
    private int visibility;
    private final Timeline$Window window;

    public PlayerNotificationManager(Context context, String string2, int n10, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter) {
        this(context, string2, n10, playerNotificationManager$MediaDescriptionAdapter, null, null);
    }

    public PlayerNotificationManager(Context context, String string2, int n10, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter, PlayerNotificationManager$CustomActionReceiver playerNotificationManager$CustomActionReceiver) {
        this(context, string2, n10, playerNotificationManager$MediaDescriptionAdapter, null, playerNotificationManager$CustomActionReceiver);
    }

    public PlayerNotificationManager(Context context, String string2, int n10, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter, PlayerNotificationManager$NotificationListener playerNotificationManager$NotificationListener) {
        this(context, string2, n10, playerNotificationManager$MediaDescriptionAdapter, playerNotificationManager$NotificationListener, null);
    }

    public PlayerNotificationManager(Context context, String iterator2, int n10, PlayerNotificationManager$MediaDescriptionAdapter object, PlayerNotificationManager$NotificationListener playerNotificationManager$NotificationListener, PlayerNotificationManager$CustomActionReceiver playerNotificationManager$CustomActionReceiver) {
        int n11;
        int n12;
        this.context = context = context.getApplicationContext();
        this.channelId = iterator2;
        this.notificationId = n10;
        this.mediaDescriptionAdapter = object;
        this.notificationListener = playerNotificationManager$NotificationListener;
        this.customActionReceiver = playerNotificationManager$CustomActionReceiver;
        iterator2 = new Iterator();
        this.controlDispatcher = iterator2;
        iterator2 = new Iterator();
        this.window = iterator2;
        int n13 = instanceIdCounter;
        instanceIdCounter = n13 + 1;
        this.instanceId = n13;
        Object object2 = Looper.getMainLooper();
        object = new e(this);
        object2 = Util.createHandler(object2, (Handler.Callback)object);
        this.mainHandler = object2;
        object2 = NotificationManagerCompat.from(context);
        this.notificationManager = object2;
        super(this, null);
        this.playerListener = object2;
        super(this, null);
        this.notificationBroadcastReceiver = object2;
        super();
        this.intentFilter = object2;
        n10 = 1;
        this.usePreviousAction = n10;
        this.useNextAction = n10;
        this.usePlayPauseActions = n10;
        this.colorized = n10;
        this.useChronometer = n10;
        object = null;
        this.color = 0;
        this.smallIconResourceId = n12 = R$drawable.exo_notification_small_icon;
        this.defaults = 0;
        this.priority = n11 = -1;
        this.badgeIconType = n10;
        this.visibility = n10;
        iterator2 = PlayerNotificationManager.createPlaybackActions(context, n13);
        this.playbackActions = iterator2;
        iterator2 = iterator2.keySet().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object2 = (String)iterator2.next();
            object = this.intentFilter;
            object.addAction((String)object2);
        }
        if (playerNotificationManager$CustomActionReceiver != null) {
            n13 = this.instanceId;
            iterator2 = playerNotificationManager$CustomActionReceiver.createCustomActions(context, n13);
        } else {
            iterator2 = Collections.emptyMap();
        }
        this.customActions = iterator2;
        iterator2 = iterator2.keySet().iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object2 = (String)iterator2.next();
            object = this.intentFilter;
            object.addAction((String)object2);
        }
        n13 = this.instanceId;
        object2 = ACTION_DISMISS;
        context = PlayerNotificationManager.createBroadcastIntent((String)object2, context, n13);
        this.dismissPendingIntent = context;
        this.intentFilter.addAction((String)object2);
    }

    public static /* synthetic */ boolean a(PlayerNotificationManager playerNotificationManager, Message message) {
        return playerNotificationManager.handleMessage(message);
    }

    public static /* synthetic */ void access$000(PlayerNotificationManager playerNotificationManager, Bitmap bitmap, int n10) {
        playerNotificationManager.postUpdateNotificationBitmap(bitmap, n10);
    }

    public static /* synthetic */ void access$1000(PlayerNotificationManager playerNotificationManager, boolean bl2) {
        playerNotificationManager.stopNotification(bl2);
    }

    public static /* synthetic */ PlayerNotificationManager$CustomActionReceiver access$1100(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.customActionReceiver;
    }

    public static /* synthetic */ Map access$1200(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.customActions;
    }

    public static /* synthetic */ void access$400(PlayerNotificationManager playerNotificationManager) {
        playerNotificationManager.postStartOrUpdateNotification();
    }

    public static /* synthetic */ Player access$500(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.player;
    }

    public static /* synthetic */ boolean access$600(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.isNotificationStarted;
    }

    public static /* synthetic */ int access$700(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.instanceId;
    }

    public static /* synthetic */ PlaybackPreparer access$800(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.playbackPreparer;
    }

    public static /* synthetic */ ControlDispatcher access$900(PlayerNotificationManager playerNotificationManager) {
        return playerNotificationManager.controlDispatcher;
    }

    private static PendingIntent createBroadcastIntent(String string2, Context context, int n10) {
        Intent intent = new Intent(string2);
        string2 = context.getPackageName();
        string2 = intent.setPackage(string2);
        string2.putExtra(EXTRA_INSTANCE_ID, n10);
        return PendingIntent.getBroadcast((Context)context, (int)n10, (Intent)string2, (int)0x8000000);
    }

    private static Map createPlaybackActions(Context context, int n10) {
        HashMap<String, NotificationCompat$Action> hashMap = new HashMap<String, NotificationCompat$Action>();
        int n11 = R$drawable.exo_notification_play;
        int n12 = R$string.exo_controls_play_description;
        String string2 = context.getString(n12);
        String string3 = ACTION_PLAY;
        PendingIntent pendingIntent = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        NotificationCompat$Action notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, pendingIntent);
        hashMap.put(string3, notificationCompat$Action);
        n11 = R$drawable.exo_notification_pause;
        n12 = R$string.exo_controls_pause_description;
        string2 = context.getString(n12);
        string3 = ACTION_PAUSE;
        pendingIntent = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, pendingIntent);
        hashMap.put(string3, notificationCompat$Action);
        n11 = R$drawable.exo_notification_stop;
        n12 = R$string.exo_controls_stop_description;
        string2 = context.getString(n12);
        string3 = ACTION_STOP;
        pendingIntent = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, pendingIntent);
        hashMap.put(string3, notificationCompat$Action);
        n11 = R$drawable.exo_notification_rewind;
        n12 = R$string.exo_controls_rewind_description;
        string2 = context.getString(n12);
        string3 = ACTION_REWIND;
        pendingIntent = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, pendingIntent);
        hashMap.put(string3, notificationCompat$Action);
        n11 = R$drawable.exo_notification_fastforward;
        n12 = R$string.exo_controls_fastforward_description;
        string2 = context.getString(n12);
        string3 = ACTION_FAST_FORWARD;
        pendingIntent = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, pendingIntent);
        hashMap.put(string3, notificationCompat$Action);
        n11 = R$drawable.exo_notification_previous;
        n12 = R$string.exo_controls_previous_description;
        string2 = context.getString(n12);
        string3 = ACTION_PREVIOUS;
        pendingIntent = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, pendingIntent);
        hashMap.put(string3, notificationCompat$Action);
        n11 = R$drawable.exo_notification_next;
        n12 = R$string.exo_controls_next_description;
        string2 = context.getString(n12);
        string3 = ACTION_NEXT;
        context = PlayerNotificationManager.createBroadcastIntent(string3, context, n10);
        notificationCompat$Action = new NotificationCompat$Action(n11, (CharSequence)string2, (PendingIntent)context);
        hashMap.put(string3, notificationCompat$Action);
        return hashMap;
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context, String string2, int n10, int n11, int n12, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter) {
        NotificationUtil.createNotificationChannel(context, string2, n10, n11, 2);
        PlayerNotificationManager playerNotificationManager = new PlayerNotificationManager(context, string2, n12, playerNotificationManager$MediaDescriptionAdapter);
        return playerNotificationManager;
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context, String string2, int n10, int n11, int n12, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter, PlayerNotificationManager$NotificationListener playerNotificationManager$NotificationListener) {
        NotificationUtil.createNotificationChannel(context, string2, n10, n11, 2);
        PlayerNotificationManager playerNotificationManager = new PlayerNotificationManager(context, string2, n12, playerNotificationManager$MediaDescriptionAdapter, playerNotificationManager$NotificationListener);
        return playerNotificationManager;
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context, String string2, int n10, int n11, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter) {
        return PlayerNotificationManager.createWithNotificationChannel(context, string2, n10, 0, n11, playerNotificationManager$MediaDescriptionAdapter);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context, String string2, int n10, int n11, PlayerNotificationManager$MediaDescriptionAdapter playerNotificationManager$MediaDescriptionAdapter, PlayerNotificationManager$NotificationListener playerNotificationManager$NotificationListener) {
        return PlayerNotificationManager.createWithNotificationChannel(context, string2, n10, 0, n11, playerNotificationManager$MediaDescriptionAdapter, playerNotificationManager$NotificationListener);
    }

    private boolean handleMessage(Message object) {
        boolean bl2 = ((Message)object).what;
        boolean bl3 = true;
        if (bl2) {
            int n10;
            int n11;
            if (bl2 != bl3) {
                return false;
            }
            Player player = this.player;
            if (player != null && (n11 = this.isNotificationStarted) != 0 && (n11 = this.currentNotificationTag) == (n10 = ((Message)object).arg1)) {
                object = (Bitmap)((Message)object).obj;
                this.startOrUpdateNotification(player, (Bitmap)object);
            }
        } else {
            object = this.player;
            if (object != null) {
                boolean bl4 = false;
                Object var4_6 = null;
                this.startOrUpdateNotification((Player)object, null);
            }
        }
        return bl3;
    }

    private void postStartOrUpdateNotification() {
        Handler handler = this.mainHandler;
        boolean bl2 = handler.hasMessages(0);
        if (!bl2) {
            handler = this.mainHandler;
            handler.sendEmptyMessage(0);
        }
    }

    private void postUpdateNotificationBitmap(Bitmap bitmap, int n10) {
        this.mainHandler.obtainMessage(1, n10, -1, (Object)bitmap).sendToTarget();
    }

    private static void setLargeIcon(NotificationCompat$Builder notificationCompat$Builder, Bitmap bitmap) {
        notificationCompat$Builder.setLargeIcon(bitmap);
    }

    private boolean shouldShowPauseButton(Player player) {
        boolean bl2;
        int n10 = player.getPlaybackState();
        int n11 = 1;
        int n12 = 4;
        if (n10 == n12 || (n10 = player.getPlaybackState()) == n11 || !(bl2 = player.getPlayWhenReady())) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private void startOrUpdateNotification(Player object, Bitmap bitmap) {
        boolean bl2 = this.getOngoing((Player)object);
        Object object2 = this.builder;
        this.builder = object = this.createNotification((Player)object, (NotificationCompat$Builder)object2, bl2, bitmap);
        int n10 = 0;
        bitmap = null;
        if (object == null) {
            this.stopNotification(false);
            return;
        }
        object = ((NotificationCompat$Builder)object).build();
        object2 = this.notificationManager;
        int n11 = this.notificationId;
        ((NotificationManagerCompat)object2).notify(n11, (Notification)object);
        boolean bl3 = this.isNotificationStarted;
        if (!bl3) {
            object2 = this.context;
            PlayerNotificationManager$NotificationBroadcastReceiver playerNotificationManager$NotificationBroadcastReceiver = this.notificationBroadcastReceiver;
            IntentFilter intentFilter = this.intentFilter;
            object2.registerReceiver((BroadcastReceiver)playerNotificationManager$NotificationBroadcastReceiver, intentFilter);
            object2 = this.notificationListener;
            if (object2 != null) {
                n11 = this.notificationId;
                object2.onNotificationStarted(n11, (Notification)object);
            }
        }
        object2 = this.notificationListener;
        n11 = 1;
        if (object2 != null) {
            int n12 = this.notificationId;
            if (bl2 || !(bl2 = this.isNotificationStarted)) {
                n10 = n11;
            }
            object2.onNotificationPosted(n12, (Notification)object, n10 != 0);
        }
        this.isNotificationStarted = n11;
    }

    private void stopNotification(boolean bl2) {
        int n10 = this.isNotificationStarted;
        if (n10 != 0) {
            n10 = 0;
            this.isNotificationStarted = false;
            this.mainHandler.removeMessages(0);
            Object object = this.notificationManager;
            int n11 = this.notificationId;
            ((NotificationManagerCompat)object).cancel(n11);
            object = this.context;
            PlayerNotificationManager$NotificationBroadcastReceiver playerNotificationManager$NotificationBroadcastReceiver = this.notificationBroadcastReceiver;
            object.unregisterReceiver((BroadcastReceiver)playerNotificationManager$NotificationBroadcastReceiver);
            object = this.notificationListener;
            if (object != null) {
                n11 = this.notificationId;
                object.onNotificationCancelled(n11, bl2);
                PlayerNotificationManager$NotificationListener playerNotificationManager$NotificationListener = this.notificationListener;
                n10 = this.notificationId;
                playerNotificationManager$NotificationListener.onNotificationCancelled(n10);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public NotificationCompat$Builder createNotification(Player var1_1, NotificationCompat$Builder var2_2, boolean var3_3, Bitmap var4_4) {
        var5_5 = var1_1.getPlaybackState();
        if (var5_5 == (var6_6 = 1) && (var5_5 = (int)(var7_7 = var1_1.getCurrentTimeline()).isEmpty()) != 0) {
            this.builderActions = null;
            return null;
        }
        var7_7 = this.getActions(var1_1);
        var9_9 = var7_7.size();
        var8_8 = new ArrayList(var9_9);
        var9_9 = 0;
        var11_11 = null;
        for (var10_10 = 0; var10_10 < (var12_12 = var7_7.size()); ++var10_10) {
            var14_14 = this.playbackActions;
            var13_13 = (String)var7_7.get(var10_10);
            var15_15 = var14_14.containsKey(var13_13);
            if (var15_15) {
                var14_14 = this.playbackActions;
                var13_13 = (NotificationCompat$Action)var14_14.get(var13_13);
            } else {
                var14_14 = this.customActions;
                var13_13 = (NotificationCompat$Action)var14_14.get(var13_13);
            }
            if (var13_13 == null) continue;
            var8_8.add(var13_13);
        }
        if (var2_2 == null || (var10_10 = (int)var8_8.equals(var11_11 = this.builderActions)) == 0) {
            var11_11 = this.context;
            var13_13 = this.channelId;
            var2_2 = new NotificationCompat$Builder((Context)var11_11, (String)var13_13);
            this.builderActions = var8_8;
            var11_11 = null;
            for (var10_10 = 0; var10_10 < (var12_12 = var8_8.size()); ++var10_10) {
                var13_13 = (NotificationCompat$Action)var8_8.get(var10_10);
                var2_2.addAction((NotificationCompat$Action)var13_13);
            }
        }
        var8_8 = new NotificationCompat$MediaStyle();
        var11_11 = this.mediaSessionToken;
        if (var11_11 != null) {
            var8_8.setMediaSession((MediaSessionCompat$Token)var11_11);
        }
        var7_7 = this.getActionIndicesForCompactView((List)var7_7, var1_1);
        var8_8.setShowActionsInCompactView((int[])var7_7);
        var5_5 = var3_3 ^ 1;
        var8_8.setShowCancelButton((boolean)var5_5);
        var7_7 = this.dismissPendingIntent;
        var8_8.setCancelButtonIntent((PendingIntent)var7_7);
        var2_2.setStyle((NotificationCompat$Style)var8_8);
        var7_7 = this.dismissPendingIntent;
        var2_2.setDeleteIntent((PendingIntent)var7_7);
        var5_5 = this.badgeIconType;
        var7_7 = var2_2.setBadgeIconType(var5_5);
        var16_16 = var7_7.setOngoing((boolean)var3_3);
        var5_5 = this.color;
        var16_16 = var16_16.setColor(var5_5);
        var5_5 = (int)this.colorized;
        var16_16 = var16_16.setColorized((boolean)var5_5);
        var5_5 = this.smallIconResourceId;
        var16_16 = var16_16.setSmallIcon(var5_5);
        var5_5 = this.visibility;
        var16_16 = var16_16.setVisibility(var5_5);
        var5_5 = this.priority;
        var16_16 = var16_16.setPriority(var5_5);
        var5_5 = this.defaults;
        var16_16.setDefaults(var5_5);
        var3_3 = Util.SDK_INT;
        var5_5 = 21;
        var17_17 = 2.9E-44f;
        if (var3_3 < var5_5 || (var3_3 = (int)this.useChronometer) == 0 || (var3_3 = (int)var1_1.isPlaying()) == 0 || (var3_3 = (int)var1_1.isPlayingAd()) != 0 || (var3_3 = (int)var1_1.isCurrentWindowDynamic()) != 0) ** GOTO lbl-1000
        var16_16 = var1_1.getPlaybackParameters();
        var18_18 = var16_16.speed;
        var5_5 = 1065353216;
        var17_17 = 1.0f;
        cfr_temp_0 = var18_18 - var17_17;
        var3_3 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
        if (var3_3 == 0) {
            var19_19 = System.currentTimeMillis();
            var21_20 = var1_1.getContentPosition();
            var16_16 = var2_2.setWhen(var19_19 -= var21_20).setShowWhen((boolean)var6_6);
            var16_16.setUsesChronometer((boolean)var6_6);
        } else lbl-1000:
        // 2 sources

        {
            var16_16 = var2_2.setShowWhen(false);
            var16_16.setUsesChronometer(false);
        }
        var16_16 = this.mediaDescriptionAdapter.getCurrentContentTitle(var1_1);
        var2_2.setContentTitle((CharSequence)var16_16);
        var16_16 = this.mediaDescriptionAdapter.getCurrentContentText(var1_1);
        var2_2.setContentText((CharSequence)var16_16);
        var16_16 = this.mediaDescriptionAdapter.getCurrentSubText(var1_1);
        var2_2.setSubText((CharSequence)var16_16);
        if (var4_4 /* !! */  == null) {
            var16_16 = this.mediaDescriptionAdapter;
            this.currentNotificationTag = var5_5 = this.currentNotificationTag + var6_6;
            var4_4 /* !! */  = new PlayerNotificationManager$BitmapCallback(this, var5_5, null);
            var4_4 /* !! */  = var16_16.getCurrentLargeIcon(var1_1, (PlayerNotificationManager$BitmapCallback)var4_4 /* !! */ );
        }
        PlayerNotificationManager.setLargeIcon(var2_2, var4_4 /* !! */ );
        var1_1 = this.mediaDescriptionAdapter.createCurrentContentIntent(var1_1);
        var2_2.setContentIntent((PendingIntent)var1_1);
        return var2_2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int[] getActionIndicesForCompactView(List list, Player player) {
        int n10;
        int n11;
        int n12;
        Object object;
        int n13;
        block11: {
            block10: {
                int n14;
                block9: {
                    String string2 = ACTION_PAUSE;
                    int n15 = list.indexOf(string2);
                    String string3 = ACTION_PLAY;
                    n14 = list.indexOf(string3);
                    int n16 = this.usePreviousActionInCompactView;
                    n13 = -1;
                    if (n16 != 0) {
                        String string4 = ACTION_PREVIOUS;
                        n16 = list.indexOf(string4);
                    } else {
                        n16 = n13;
                    }
                    int n17 = this.useNextActionInCompactView;
                    if (n17 != 0) {
                        object = ACTION_NEXT;
                        n12 = list.indexOf(object);
                    } else {
                        n12 = n13;
                    }
                    n17 = 3;
                    object = new int[n17];
                    n11 = 0;
                    if (n16 != n13) {
                        object[0] = n16;
                        n11 = 1;
                    }
                    n10 = this.shouldShowPauseButton(player);
                    if (n15 == n13 || n10 == 0) break block9;
                    n10 = n11 + 1;
                    object[n11] = n15;
                    break block10;
                }
                if (n14 == n13 || n10 != 0) break block11;
                n10 = n11 + 1;
                object[n11] = n14;
            }
            n11 = n10;
        }
        if (n12 != n13) {
            n10 = n11 + 1;
            object[n11] = n12;
            n11 = n10;
        }
        return Arrays.copyOf((int[])object, n11);
    }

    /*
     * WARNING - void declaration
     */
    public List getActions(Player object) {
        boolean bl2;
        boolean bl3;
        void var3_12;
        boolean bl4;
        Object object2;
        boolean bl5;
        boolean bl6;
        ArrayList<String> arrayList;
        String string2;
        boolean bl7;
        Object object3;
        block22: {
            block18: {
                float f10;
                float f11;
                block21: {
                    float f12;
                    boolean bl8;
                    block20: {
                        block19: {
                            boolean bl9;
                            ControlDispatcher controlDispatcher;
                            boolean bl10;
                            object3 = object.getCurrentTimeline();
                            boolean n13 = ((Timeline)object3).isEmpty();
                            bl7 = false;
                            f11 = 0.0f;
                            string2 = null;
                            if (n13 || (bl10 = object.isPlayingAd())) break block18;
                            int n10 = object.getCurrentWindowIndex();
                            arrayList = this.window;
                            ((Timeline)object3).getWindow(n10, (Timeline$Window)((Object)arrayList));
                            object3 = this.window;
                            boolean bl11 = ((Timeline$Window)object3).isSeekable;
                            bl8 = true;
                            f12 = Float.MIN_VALUE;
                            if (!bl11 && (bl6 = ((Timeline$Window)object3).isLive()) && !(bl6 = object.hasPrevious())) {
                                bl6 = false;
                                object3 = null;
                                f10 = 0.0f;
                            } else {
                                bl6 = bl8;
                                f10 = f12;
                            }
                            if (bl11 && (bl5 = (controlDispatcher = this.controlDispatcher).isRewindEnabled())) {
                                bl5 = bl8;
                            } else {
                                bl5 = false;
                                controlDispatcher = null;
                            }
                            if (bl11 && (bl9 = (object2 = this.controlDispatcher).isFastForwardEnabled())) {
                                boolean bl12 = bl8;
                            } else {
                                boolean bl13 = false;
                                object2 = null;
                            }
                            Timeline$Window timeline$Window = this.window;
                            bl4 = timeline$Window.isLive();
                            if (!bl4) break block19;
                            timeline$Window = this.window;
                            bl4 = timeline$Window.isDynamic;
                            if (bl4) break block20;
                        }
                        if (!(bl4 = object.hasNext())) break block21;
                    }
                    bl7 = bl8;
                    f11 = f12;
                }
                boolean bl14 = bl7;
                float f13 = f11;
                bl7 = bl6;
                f11 = f10;
                bl6 = bl14;
                f10 = f13;
                break block22;
            }
            bl6 = false;
            object3 = null;
            float f14 = 0.0f;
            boolean bl15 = false;
            object2 = null;
            bl5 = false;
            Object var12_24 = null;
        }
        arrayList = new ArrayList<String>();
        bl4 = this.usePreviousAction;
        if (bl4 && bl7) {
            string2 = ACTION_PREVIOUS;
            arrayList.add(string2);
        }
        if (bl5) {
            string2 = ACTION_REWIND;
            arrayList.add(string2);
        }
        if (bl7 = this.usePlayPauseActions) {
            bl7 = this.shouldShowPauseButton((Player)object);
            if (bl7) {
                string2 = ACTION_PAUSE;
                arrayList.add(string2);
            } else {
                string2 = ACTION_PLAY;
                arrayList.add(string2);
            }
        }
        if (var3_12 != false) {
            object2 = ACTION_FAST_FORWARD;
            arrayList.add((String)object2);
        }
        if ((bl3 = this.useNextAction) && bl6) {
            object3 = ACTION_NEXT;
            arrayList.add((String)object3);
        }
        if ((object3 = this.customActionReceiver) != null) {
            object = object3.getCustomActions((Player)object);
            arrayList.addAll((Collection<String>)object);
        }
        if (bl2 = this.useStopAction) {
            object = ACTION_STOP;
            arrayList.add((String)object);
        }
        return arrayList;
    }

    public boolean getOngoing(Player player) {
        boolean bl2;
        int n10;
        int n11 = player.getPlaybackState();
        if ((n11 == (n10 = 2) || n11 == (n10 = 3)) && (bl2 = player.getPlayWhenReady())) {
            bl2 = true;
        } else {
            bl2 = false;
            player = null;
        }
        return bl2;
    }

    public void invalidate() {
        boolean bl2 = this.isNotificationStarted;
        if (bl2) {
            this.postStartOrUpdateNotification();
        }
    }

    public final void setBadgeIconType(int n10) {
        int n11 = this.badgeIconType;
        if (n11 == n10) {
            return;
        }
        if (n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        this.badgeIconType = n10;
        this.invalidate();
    }

    public final void setColor(int n10) {
        int n11 = this.color;
        if (n11 != n10) {
            this.color = n10;
            this.invalidate();
        }
    }

    public final void setColorized(boolean bl2) {
        boolean bl3 = this.colorized;
        if (bl3 != bl2) {
            this.colorized = bl2;
            this.invalidate();
        }
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher) {
        ControlDispatcher controlDispatcher2 = this.controlDispatcher;
        if (controlDispatcher2 != controlDispatcher) {
            this.controlDispatcher = controlDispatcher;
            this.invalidate();
        }
    }

    public final void setDefaults(int n10) {
        int n11 = this.defaults;
        if (n11 != n10) {
            this.defaults = n10;
            this.invalidate();
        }
    }

    public final void setFastForwardIncrementMs(long l10) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        boolean bl2 = controlDispatcher instanceof DefaultControlDispatcher;
        if (bl2) {
            controlDispatcher = (DefaultControlDispatcher)controlDispatcher;
            ((DefaultControlDispatcher)controlDispatcher).setFastForwardIncrementMs(l10);
            this.invalidate();
        }
    }

    public final void setMediaSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaSessionCompat$Token mediaSessionCompat$Token2 = this.mediaSessionToken;
        boolean bl2 = Util.areEqual(mediaSessionCompat$Token2, mediaSessionCompat$Token);
        if (!bl2) {
            this.mediaSessionToken = mediaSessionCompat$Token;
            this.invalidate();
        }
    }

    public final void setNotificationListener(PlayerNotificationManager$NotificationListener playerNotificationManager$NotificationListener) {
        this.notificationListener = playerNotificationManager$NotificationListener;
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        this.playbackPreparer = playbackPreparer;
    }

    public final void setPlayer(Player player) {
        boolean bl2;
        Object object = Looper.myLooper();
        Object object2 = Looper.getMainLooper();
        boolean bl3 = true;
        if (object == object2) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        if (player != null && (object = player.getApplicationLooper()) != (object2 = Looper.getMainLooper())) {
            bl3 = false;
        }
        Assertions.checkArgument(bl3);
        object = this.player;
        if (object == player) {
            return;
        }
        if (object != null) {
            object2 = this.playerListener;
            object.removeListener((Player$EventListener)object2);
            if (player == null) {
                this.stopNotification(false);
            }
        }
        this.player = player;
        if (player != null) {
            object = this.playerListener;
            player.addListener((Player$EventListener)object);
            this.postStartOrUpdateNotification();
        }
    }

    public final void setPriority(int n10) {
        int n11 = this.priority;
        if (n11 == n10) {
            return;
        }
        n11 = -2;
        if (n10 != n11 && n10 != (n11 = -1) && n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            throw illegalArgumentException;
        }
        this.priority = n10;
        this.invalidate();
    }

    public final void setRewindIncrementMs(long l10) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        boolean bl2 = controlDispatcher instanceof DefaultControlDispatcher;
        if (bl2) {
            controlDispatcher = (DefaultControlDispatcher)controlDispatcher;
            ((DefaultControlDispatcher)controlDispatcher).setRewindIncrementMs(l10);
            this.invalidate();
        }
    }

    public final void setSmallIcon(int n10) {
        int n11 = this.smallIconResourceId;
        if (n11 != n10) {
            this.smallIconResourceId = n10;
            this.invalidate();
        }
    }

    public final void setUseChronometer(boolean bl2) {
        boolean bl3 = this.useChronometer;
        if (bl3 != bl2) {
            this.useChronometer = bl2;
            this.invalidate();
        }
    }

    public final void setUseNavigationActions(boolean bl2) {
        this.setUseNextAction(bl2);
        this.setUsePreviousAction(bl2);
    }

    public final void setUseNavigationActionsInCompactView(boolean bl2) {
        this.setUseNextActionInCompactView(bl2);
        this.setUsePreviousActionInCompactView(bl2);
    }

    public void setUseNextAction(boolean bl2) {
        boolean bl3 = this.useNextAction;
        if (bl3 != bl2) {
            this.useNextAction = bl2;
            this.invalidate();
        }
    }

    public void setUseNextActionInCompactView(boolean bl2) {
        boolean bl3 = this.useNextActionInCompactView;
        if (bl3 != bl2) {
            this.useNextActionInCompactView = bl2;
            this.invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean bl2) {
        boolean bl3 = this.usePlayPauseActions;
        if (bl3 != bl2) {
            this.usePlayPauseActions = bl2;
            this.invalidate();
        }
    }

    public void setUsePreviousAction(boolean bl2) {
        boolean bl3 = this.usePreviousAction;
        if (bl3 != bl2) {
            this.usePreviousAction = bl2;
            this.invalidate();
        }
    }

    public void setUsePreviousActionInCompactView(boolean bl2) {
        boolean bl3 = this.usePreviousActionInCompactView;
        if (bl3 != bl2) {
            this.usePreviousActionInCompactView = bl2;
            this.invalidate();
        }
    }

    public final void setUseStopAction(boolean bl2) {
        boolean bl3 = this.useStopAction;
        if (bl3 == bl2) {
            return;
        }
        this.useStopAction = bl2;
        this.invalidate();
    }

    public final void setVisibility(int n10) {
        int n11 = this.visibility;
        if (n11 == n10) {
            return;
        }
        n11 = -1;
        if (n10 != n11 && n10 != 0 && n10 != (n11 = 1)) {
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        this.visibility = n10;
        this.invalidate();
    }
}

