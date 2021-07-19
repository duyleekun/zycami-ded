/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$ConcatenatedTimeline;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$FakeMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$HandlerAndRunnable;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$MediaSourceHolder;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource$MessageData;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ConcatenatingMediaSource
extends CompositeMediaSource {
    private static final MediaItem EMPTY_MEDIA_ITEM;
    private static final int MSG_ADD = 0;
    private static final int MSG_MOVE = 2;
    private static final int MSG_ON_COMPLETION = 5;
    private static final int MSG_REMOVE = 1;
    private static final int MSG_SET_SHUFFLE_ORDER = 3;
    private static final int MSG_UPDATE_TIMELINE = 4;
    private final Set enabledMediaSourceHolders;
    private final boolean isAtomic;
    private final IdentityHashMap mediaSourceByMediaPeriod;
    private final Map mediaSourceByUid;
    private final List mediaSourceHolders;
    private final List mediaSourcesPublic;
    private Set nextTimelineUpdateOnCompletionActions;
    private final Set pendingOnCompletionActions;
    private Handler playbackThreadHandler;
    private ShuffleOrder shuffleOrder;
    private boolean timelineUpdateScheduled;
    private final boolean useLazyPreparation;

    static {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        Uri uri = Uri.EMPTY;
        EMPTY_MEDIA_ITEM = mediaItem$Builder.setUri(uri).build();
    }

    public ConcatenatingMediaSource(boolean bl2, ShuffleOrder shuffleOrder, MediaSource ... mediaSourceArray) {
        this(bl2, false, shuffleOrder, mediaSourceArray);
    }

    public ConcatenatingMediaSource(boolean bl2, boolean bl3, ShuffleOrder cloneable, MediaSource ... mediaSourceArray) {
        for (MediaSource mediaSource : mediaSourceArray) {
            Assertions.checkNotNull(mediaSource);
        }
        int n10 = cloneable.getLength();
        if (n10 > 0) {
            cloneable = cloneable.cloneAndClear();
        }
        this.shuffleOrder = cloneable;
        this.mediaSourceByMediaPeriod = cloneable = new Cloneable();
        this.mediaSourceByUid = cloneable;
        super();
        this.mediaSourcesPublic = cloneable;
        super();
        this.mediaSourceHolders = cloneable;
        super();
        this.nextTimelineUpdateOnCompletionActions = cloneable;
        super();
        this.pendingOnCompletionActions = cloneable;
        super();
        this.enabledMediaSourceHolders = cloneable;
        this.isAtomic = bl2;
        this.useLazyPreparation = bl3;
        List<MediaSource> list = Arrays.asList(mediaSourceArray);
        this.addMediaSources(list);
    }

    public ConcatenatingMediaSource(boolean bl2, MediaSource ... mediaSourceArray) {
        ShuffleOrder$DefaultShuffleOrder shuffleOrder$DefaultShuffleOrder = new ShuffleOrder$DefaultShuffleOrder(0);
        this(bl2, shuffleOrder$DefaultShuffleOrder, mediaSourceArray);
    }

    public ConcatenatingMediaSource(MediaSource ... mediaSourceArray) {
        this(false, mediaSourceArray);
    }

    public static /* synthetic */ MediaItem access$100() {
        return EMPTY_MEDIA_ITEM;
    }

    private void addMediaSourceInternal(int n10, ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder) {
        int n11;
        int n12;
        Object object;
        if (n10 > 0) {
            object = this.mediaSourceHolders;
            n12 = n10 + -1;
            object = (ConcatenatingMediaSource$MediaSourceHolder)object.get(n12);
            Timeline timeline = ((ConcatenatingMediaSource$MediaSourceHolder)object).mediaSource.getTimeline();
            n11 = ((ConcatenatingMediaSource$MediaSourceHolder)object).firstWindowIndexInChild;
            n12 = timeline.getWindowCount();
            concatenatingMediaSource$MediaSourceHolder.reset(n10, n11 += n12);
        } else {
            n11 = 0;
            object = null;
            concatenatingMediaSource$MediaSourceHolder.reset(n10, 0);
        }
        n11 = concatenatingMediaSource$MediaSourceHolder.mediaSource.getTimeline().getWindowCount();
        n12 = 1;
        this.correctOffsets(n10, n12, n11);
        this.mediaSourceHolders.add(n10, concatenatingMediaSource$MediaSourceHolder);
        Object object2 = this.mediaSourceByUid;
        object = concatenatingMediaSource$MediaSourceHolder.uid;
        object2.put(object, concatenatingMediaSource$MediaSourceHolder);
        object2 = concatenatingMediaSource$MediaSourceHolder.mediaSource;
        this.prepareChildSource(concatenatingMediaSource$MediaSourceHolder, (MediaSource)object2);
        n10 = (int)(this.isEnabled() ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(((IdentityHashMap)(object2 = this.mediaSourceByMediaPeriod)).isEmpty() ? 1 : 0)) != 0) {
            object2 = this.enabledMediaSourceHolders;
            object2.add(concatenatingMediaSource$MediaSourceHolder);
        } else {
            this.disableChildSource(concatenatingMediaSource$MediaSourceHolder);
        }
    }

    private void addMediaSourcesInternal(int n10, Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder = (ConcatenatingMediaSource$MediaSourceHolder)object.next();
            int n11 = n10 + 1;
            this.addMediaSourceInternal(n10, concatenatingMediaSource$MediaSourceHolder);
            n10 = n11;
        }
    }

    private void addPublicMediaSources(int n10, Collection object, Handler object2, Runnable runnable) {
        boolean bl2;
        boolean bl3;
        Handler handler;
        Object object3;
        int n11;
        ArrayList<ConcatenatingMediaSource$MediaSourceHolder> arrayList;
        int n12;
        int n13 = 1;
        if (object2 == null) {
            n12 = n13;
        } else {
            n12 = 0;
            arrayList = null;
        }
        if (runnable == null) {
            n11 = n13;
        } else {
            n11 = 0;
            object3 = null;
        }
        if (n12 != n11) {
            n13 = 0;
            handler = null;
        }
        Assertions.checkArgument(n13 != 0);
        handler = this.playbackThreadHandler;
        arrayList = object.iterator();
        while ((n11 = arrayList.hasNext()) != 0) {
            object3 = (MediaSource)arrayList.next();
            Assertions.checkNotNull(object3);
        }
        n11 = object.size();
        arrayList = new ArrayList<ConcatenatingMediaSource$MediaSourceHolder>(n11);
        object3 = object.iterator();
        while (bl3 = object3.hasNext()) {
            MediaSource mediaSource = (MediaSource)object3.next();
            boolean bl4 = this.useLazyPreparation;
            ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder = new ConcatenatingMediaSource$MediaSourceHolder(mediaSource, bl4);
            arrayList.add(concatenatingMediaSource$MediaSourceHolder);
        }
        object3 = this.mediaSourcesPublic;
        object3.addAll(n10, arrayList);
        if (handler != null && !(bl2 = object.isEmpty())) {
            object = this.createOnCompletionAction((Handler)object2, runnable);
            object2 = new ConcatenatingMediaSource$MessageData(n10, arrayList, (ConcatenatingMediaSource$HandlerAndRunnable)object);
            Message message = handler.obtainMessage(0, object2);
            message.sendToTarget();
        } else if (runnable != null && object2 != null) {
            object2.post(runnable);
        }
    }

    public static /* synthetic */ boolean c(ConcatenatingMediaSource concatenatingMediaSource, Message message) {
        return concatenatingMediaSource.handleMessage(message);
    }

    private void correctOffsets(int n10, int n11, int n12) {
        Object object;
        int n13;
        while (n10 < (n13 = (object = this.mediaSourceHolders).size())) {
            int n14;
            object = (ConcatenatingMediaSource$MediaSourceHolder)this.mediaSourceHolders.get(n10);
            ((ConcatenatingMediaSource$MediaSourceHolder)object).childIndex = n14 = ((ConcatenatingMediaSource$MediaSourceHolder)object).childIndex + n11;
            ((ConcatenatingMediaSource$MediaSourceHolder)object).firstWindowIndexInChild = n14 = ((ConcatenatingMediaSource$MediaSourceHolder)object).firstWindowIndexInChild + n12;
            ++n10;
        }
    }

    private ConcatenatingMediaSource$HandlerAndRunnable createOnCompletionAction(Handler handler, Runnable runnable) {
        if (handler != null && runnable != null) {
            ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable = new ConcatenatingMediaSource$HandlerAndRunnable(handler, runnable);
            this.pendingOnCompletionActions.add(concatenatingMediaSource$HandlerAndRunnable);
            return concatenatingMediaSource$HandlerAndRunnable;
        }
        return null;
    }

    private void disableUnusedMediaSources() {
        boolean bl2;
        Iterator iterator2 = this.enabledMediaSourceHolders.iterator();
        while (bl2 = iterator2.hasNext()) {
            ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder = (ConcatenatingMediaSource$MediaSourceHolder)iterator2.next();
            List list = concatenatingMediaSource$MediaSourceHolder.activeMediaPeriodIds;
            boolean bl3 = list.isEmpty();
            if (!bl3) continue;
            this.disableChildSource(concatenatingMediaSource$MediaSourceHolder);
            iterator2.remove();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void dispatchOnCompletionActions(Set set) {
        synchronized (this) {
            Object object = set.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.pendingOnCompletionActions;
                    object.removeAll(set);
                    return;
                }
                Object object2 = object.next();
                object2 = (ConcatenatingMediaSource$HandlerAndRunnable)object2;
                ((ConcatenatingMediaSource$HandlerAndRunnable)object2).dispatch();
            }
        }
    }

    private void enableMediaSource(ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder) {
        this.enabledMediaSourceHolders.add(concatenatingMediaSource$MediaSourceHolder);
        this.enableChildSource(concatenatingMediaSource$MediaSourceHolder);
    }

    private static Object getChildPeriodUid(Object object) {
        return AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(object);
    }

    private static Object getMediaSourceHolderUid(Object object) {
        return AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(object);
    }

    private static Object getPeriodUid(ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder, Object object) {
        return AbstractConcatenatedTimeline.getConcatenatedUid(concatenatingMediaSource$MediaSourceHolder.uid, object);
    }

    private Handler getPlaybackThreadHandlerOnPlaybackThread() {
        return (Handler)Assertions.checkNotNull(this.playbackThreadHandler);
    }

    /*
     * Enabled aggressive block sorting
     */
    private boolean handleMessage(Message object) {
        ShuffleOrder shuffleOrder;
        int n10;
        int n11 = object.what;
        int n12 = 1;
        if (n11 == 0) {
            ConcatenatingMediaSource$MessageData concatenatingMediaSource$MessageData = (ConcatenatingMediaSource$MessageData)Util.castNonNull(object.obj);
            ShuffleOrder shuffleOrder2 = this.shuffleOrder;
            int n13 = concatenatingMediaSource$MessageData.index;
            Collection collection = (Collection)concatenatingMediaSource$MessageData.customData;
            int n14 = collection.size();
            this.shuffleOrder = shuffleOrder2 = shuffleOrder2.cloneAndInsert(n13, n14);
            n11 = concatenatingMediaSource$MessageData.index;
            Collection collection2 = (Collection)concatenatingMediaSource$MessageData.customData;
            this.addMediaSourcesInternal(n11, collection2);
            ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable = concatenatingMediaSource$MessageData.onCompletionAction;
            this.scheduleTimelineUpdate(concatenatingMediaSource$HandlerAndRunnable);
            return n12 != 0;
        }
        if (n11 != n12) {
            int n15 = 2;
            if (n11 == n15) {
                ConcatenatingMediaSource$MessageData concatenatingMediaSource$MessageData = (ConcatenatingMediaSource$MessageData)Util.castNonNull(object.obj);
                ShuffleOrder shuffleOrder3 = this.shuffleOrder;
                n15 = concatenatingMediaSource$MessageData.index;
                int n16 = n15 + 1;
                this.shuffleOrder = shuffleOrder3 = shuffleOrder3.cloneAndRemove(n15, n16);
                n15 = (Integer)concatenatingMediaSource$MessageData.customData;
                this.shuffleOrder = shuffleOrder3 = shuffleOrder3.cloneAndInsert(n15, n12);
                n11 = concatenatingMediaSource$MessageData.index;
                Integer n17 = (Integer)concatenatingMediaSource$MessageData.customData;
                n15 = n17;
                this.moveMediaSourceInternal(n11, n15);
                ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable = concatenatingMediaSource$MessageData.onCompletionAction;
                this.scheduleTimelineUpdate(concatenatingMediaSource$HandlerAndRunnable);
                return n12 != 0;
            }
            n15 = 3;
            if (n11 == n15) {
                ShuffleOrder shuffleOrder4;
                ConcatenatingMediaSource$MessageData concatenatingMediaSource$MessageData = (ConcatenatingMediaSource$MessageData)Util.castNonNull(object.obj);
                this.shuffleOrder = shuffleOrder4 = (ShuffleOrder)concatenatingMediaSource$MessageData.customData;
                ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable = concatenatingMediaSource$MessageData.onCompletionAction;
                this.scheduleTimelineUpdate(concatenatingMediaSource$HandlerAndRunnable);
                return n12 != 0;
            }
            n15 = 4;
            if (n11 == n15) {
                this.updateTimelineAndScheduleOnCompletionActions();
                return n12 != 0;
            }
            n15 = 5;
            if (n11 == n15) {
                Set set = (Set)Util.castNonNull(object.obj);
                this.dispatchOnCompletionActions(set);
                return n12 != 0;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        ConcatenatingMediaSource$MessageData concatenatingMediaSource$MessageData = (ConcatenatingMediaSource$MessageData)Util.castNonNull(object.obj);
        n11 = concatenatingMediaSource$MessageData.index;
        Integer n18 = (Integer)concatenatingMediaSource$MessageData.customData;
        int n19 = n18;
        this.shuffleOrder = n11 == 0 && n19 == (n10 = (shuffleOrder = this.shuffleOrder).getLength()) ? (shuffleOrder = this.shuffleOrder.cloneAndClear()) : (shuffleOrder = this.shuffleOrder.cloneAndRemove(n11, n19));
        n19 -= n12;
        while (true) {
            if (n19 < n11) {
                ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable = concatenatingMediaSource$MessageData.onCompletionAction;
                this.scheduleTimelineUpdate(concatenatingMediaSource$HandlerAndRunnable);
                return n12 != 0;
            }
            this.removeMediaSourceInternal(n19);
            n19 += -1;
        }
    }

    private void maybeReleaseChildSource(ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder) {
        Collection collection;
        boolean bl2 = concatenatingMediaSource$MediaSourceHolder.isRemoved;
        if (bl2 && (bl2 = (collection = concatenatingMediaSource$MediaSourceHolder.activeMediaPeriodIds).isEmpty())) {
            collection = this.enabledMediaSourceHolders;
            collection.remove(concatenatingMediaSource$MediaSourceHolder);
            this.releaseChildSource(concatenatingMediaSource$MediaSourceHolder);
        }
    }

    private void moveMediaSourceInternal(int n10, int n11) {
        int n12 = Math.min(n10, n11);
        int n13 = Math.max(n10, n11);
        ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder = (ConcatenatingMediaSource$MediaSourceHolder)this.mediaSourceHolders.get(n12);
        int n14 = concatenatingMediaSource$MediaSourceHolder.firstWindowIndexInChild;
        List list = this.mediaSourceHolders;
        Object object = (ConcatenatingMediaSource$MediaSourceHolder)list.remove(n10);
        list.add(n11, object);
        while (n12 <= n13) {
            object = (ConcatenatingMediaSource$MediaSourceHolder)this.mediaSourceHolders.get(n12);
            ((ConcatenatingMediaSource$MediaSourceHolder)object).childIndex = n12++;
            ((ConcatenatingMediaSource$MediaSourceHolder)object).firstWindowIndexInChild = n14;
            object = ((ConcatenatingMediaSource$MediaSourceHolder)object).mediaSource.getTimeline();
            n10 = ((Timeline)object).getWindowCount();
            n14 += n10;
        }
    }

    private void movePublicMediaSource(int n10, int n11, Handler object, Runnable runnable) {
        Handler handler;
        ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder;
        boolean bl2;
        boolean bl3 = true;
        Object object2 = null;
        if (object == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            concatenatingMediaSource$MediaSourceHolder = null;
        }
        boolean bl4 = runnable == null ? bl3 : false;
        if (bl2 != bl4) {
            bl3 = false;
            handler = null;
        }
        Assertions.checkArgument(bl3);
        handler = this.playbackThreadHandler;
        object2 = this.mediaSourcesPublic;
        concatenatingMediaSource$MediaSourceHolder = (ConcatenatingMediaSource$MediaSourceHolder)object2.remove(n10);
        object2.add(n11, concatenatingMediaSource$MediaSourceHolder);
        if (handler != null) {
            object = this.createOnCompletionAction((Handler)object, runnable);
            int n12 = 2;
            Integer n13 = n11;
            object2 = new ConcatenatingMediaSource$MessageData(n10, n13, (ConcatenatingMediaSource$HandlerAndRunnable)object);
            Message message = handler.obtainMessage(n12, object2);
            message.sendToTarget();
        } else if (runnable != null && object != null) {
            object.post(runnable);
        }
    }

    private void removeMediaSourceInternal(int n10) {
        ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder = (ConcatenatingMediaSource$MediaSourceHolder)this.mediaSourceHolders.remove(n10);
        Map map = this.mediaSourceByUid;
        Object object = concatenatingMediaSource$MediaSourceHolder.uid;
        map.remove(object);
        int n11 = -concatenatingMediaSource$MediaSourceHolder.mediaSource.getTimeline().getWindowCount();
        this.correctOffsets(n10, -1, n11);
        concatenatingMediaSource$MediaSourceHolder.isRemoved = true;
        this.maybeReleaseChildSource(concatenatingMediaSource$MediaSourceHolder);
    }

    private void removePublicMediaSources(int n10, int n11, Handler object, Runnable object2) {
        List list;
        int n12;
        int n13 = 0;
        Handler handler = null;
        int n14 = 1;
        if (object == null) {
            n12 = n14;
        } else {
            n12 = 0;
            list = null;
        }
        int n15 = object2 == null ? n14 : 0;
        if (n12 == n15) {
            n13 = n14;
        }
        Assertions.checkArgument(n13 != 0);
        handler = this.playbackThreadHandler;
        list = this.mediaSourcesPublic;
        Util.removeRange(list, n10, n11);
        if (handler != null) {
            object = this.createOnCompletionAction((Handler)object, (Runnable)object2);
            Integer n16 = n11;
            object2 = new ConcatenatingMediaSource$MessageData(n10, n16, (ConcatenatingMediaSource$HandlerAndRunnable)object);
            Message message = handler.obtainMessage(n14, object2);
            message.sendToTarget();
        } else if (object2 != null && object != null) {
            object.post((Runnable)object2);
        }
    }

    private void scheduleTimelineUpdate() {
        this.scheduleTimelineUpdate(null);
    }

    private void scheduleTimelineUpdate(ConcatenatingMediaSource$HandlerAndRunnable concatenatingMediaSource$HandlerAndRunnable) {
        Object object;
        boolean bl2 = this.timelineUpdateScheduled;
        if (!bl2) {
            object = this.getPlaybackThreadHandlerOnPlaybackThread();
            int n10 = 4;
            object = object.obtainMessage(n10);
            object.sendToTarget();
            this.timelineUpdateScheduled = bl2 = true;
        }
        if (concatenatingMediaSource$HandlerAndRunnable != null) {
            object = this.nextTimelineUpdateOnCompletionActions;
            object.add(concatenatingMediaSource$HandlerAndRunnable);
        }
    }

    private void setPublicShuffleOrder(ShuffleOrder shuffleOrder, Handler object, Runnable runnable) {
        Handler handler;
        ConcatenatingMediaSource$MessageData concatenatingMediaSource$MessageData;
        int n10;
        int n11 = 1;
        if (object == null) {
            n10 = n11;
        } else {
            n10 = 0;
            concatenatingMediaSource$MessageData = null;
        }
        int n12 = runnable == null ? n11 : 0;
        if (n10 != n12) {
            n11 = 0;
            handler = null;
        }
        Assertions.checkArgument(n11 != 0);
        handler = this.playbackThreadHandler;
        if (handler != null) {
            n10 = this.getSize();
            n12 = shuffleOrder.getLength();
            if (n12 != n10) {
                shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, n10);
            }
            object = this.createOnCompletionAction((Handler)object, runnable);
            int n13 = 3;
            concatenatingMediaSource$MessageData = new ConcatenatingMediaSource$MessageData(0, shuffleOrder, (ConcatenatingMediaSource$HandlerAndRunnable)object);
            shuffleOrder = handler.obtainMessage(n13, (Object)concatenatingMediaSource$MessageData);
            shuffleOrder.sendToTarget();
        } else {
            n11 = shuffleOrder.getLength();
            if (n11 > 0) {
                shuffleOrder = shuffleOrder.cloneAndClear();
            }
            this.shuffleOrder = shuffleOrder;
            if (runnable != null && object != null) {
                object.post(runnable);
            }
        }
    }

    private void updateMediaSourceInternal(ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder, Timeline timeline) {
        int n10 = concatenatingMediaSource$MediaSourceHolder.childIndex + 1;
        List list = this.mediaSourceHolders;
        int n11 = list.size();
        if (n10 < n11) {
            Object object = this.mediaSourceHolders;
            n11 = concatenatingMediaSource$MediaSourceHolder.childIndex + 1;
            object = (ConcatenatingMediaSource$MediaSourceHolder)object.get(n11);
            int n12 = timeline.getWindowCount();
            n10 = ((ConcatenatingMediaSource$MediaSourceHolder)object).firstWindowIndexInChild;
            n11 = concatenatingMediaSource$MediaSourceHolder.firstWindowIndexInChild;
            if ((n12 -= (n10 -= n11)) != 0) {
                int n13 = concatenatingMediaSource$MediaSourceHolder.childIndex + 1;
                n10 = 0;
                object = null;
                this.correctOffsets(n13, 0, n12);
            }
        }
        this.scheduleTimelineUpdate();
    }

    private void updateTimelineAndScheduleOnCompletionActions() {
        this.timelineUpdateScheduled = false;
        Set set = this.nextTimelineUpdateOnCompletionActions;
        Object object = new HashSet();
        this.nextTimelineUpdateOnCompletionActions = object;
        List list = this.mediaSourceHolders;
        ShuffleOrder shuffleOrder = this.shuffleOrder;
        boolean bl2 = this.isAtomic;
        object = new ConcatenatingMediaSource$ConcatenatedTimeline(list, shuffleOrder, bl2);
        this.refreshSourceInfo((Timeline)object);
        this.getPlaybackThreadHandlerOnPlaybackThread().obtainMessage(5, (Object)set).sendToTarget();
    }

    public void addMediaSource(int n10, MediaSource object) {
        synchronized (this) {
            object = Collections.singletonList(object);
            this.addPublicMediaSources(n10, (Collection)object, null, null);
            return;
        }
    }

    public void addMediaSource(int n10, MediaSource object, Handler handler, Runnable runnable) {
        synchronized (this) {
            object = Collections.singletonList(object);
            this.addPublicMediaSources(n10, (Collection)object, handler, runnable);
            return;
        }
    }

    public void addMediaSource(MediaSource mediaSource) {
        synchronized (this) {
            List list = this.mediaSourcesPublic;
            int n10 = list.size();
            this.addMediaSource(n10, mediaSource);
            return;
        }
    }

    public void addMediaSource(MediaSource mediaSource, Handler handler, Runnable runnable) {
        synchronized (this) {
            List list = this.mediaSourcesPublic;
            int n10 = list.size();
            this.addMediaSource(n10, mediaSource, handler, runnable);
            return;
        }
    }

    public void addMediaSources(int n10, Collection collection) {
        synchronized (this) {
            this.addPublicMediaSources(n10, collection, null, null);
            return;
        }
    }

    public void addMediaSources(int n10, Collection collection, Handler handler, Runnable runnable) {
        synchronized (this) {
            this.addPublicMediaSources(n10, collection, handler, runnable);
            return;
        }
    }

    public void addMediaSources(Collection collection) {
        synchronized (this) {
            List list = this.mediaSourcesPublic;
            int n10 = list.size();
            this.addPublicMediaSources(n10, collection, null, null);
            return;
        }
    }

    public void addMediaSources(Collection collection, Handler handler, Runnable runnable) {
        synchronized (this) {
            List list = this.mediaSourcesPublic;
            int n10 = list.size();
            this.addPublicMediaSources(n10, collection, handler, runnable);
            return;
        }
    }

    public void clear() {
        synchronized (this) {
            Object var1_1 = null;
            int n10 = this.getSize();
            this.removeMediaSourceRange(0, n10);
            return;
        }
    }

    public void clear(Handler handler, Runnable runnable) {
        synchronized (this) {
            int n10 = this.getSize();
            this.removeMediaSourceRange(0, n10, handler, runnable);
            return;
        }
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId object, Allocator allocator, long l10) {
        Object object2 = ConcatenatingMediaSource.getMediaSourceHolderUid(((MediaPeriodId)object).periodUid);
        Object object3 = ConcatenatingMediaSource.getChildPeriodUid(((MediaPeriodId)object).periodUid);
        object = ((MediaSource$MediaPeriodId)object).copyWithPeriodUid(object3);
        object3 = this.mediaSourceByUid;
        if ((object2 = (ConcatenatingMediaSource$MediaSourceHolder)object3.get(object2)) == null) {
            boolean bl2;
            object3 = new ConcatenatingMediaSource$FakeMediaSource(null);
            boolean bl3 = this.useLazyPreparation;
            object2 = new ConcatenatingMediaSource$MediaSourceHolder((MediaSource)object3, bl3);
            ((ConcatenatingMediaSource$MediaSourceHolder)object2).isRemoved = bl2 = true;
            object3 = ((ConcatenatingMediaSource$MediaSourceHolder)object2).mediaSource;
            this.prepareChildSource(object2, (MediaSource)object3);
        }
        this.enableMediaSource((ConcatenatingMediaSource$MediaSourceHolder)object2);
        ((ConcatenatingMediaSource$MediaSourceHolder)object2).activeMediaPeriodIds.add(object);
        object = ((ConcatenatingMediaSource$MediaSourceHolder)object2).mediaSource.createPeriod((MediaSource$MediaPeriodId)object, allocator, l10);
        this.mediaSourceByMediaPeriod.put(object, object2);
        this.disableUnusedMediaSources();
        return object;
    }

    public void disableInternal() {
        super.disableInternal();
        this.enabledMediaSourceHolders.clear();
    }

    public void enableInternal() {
    }

    public Timeline getInitialTimeline() {
        synchronized (this) {
            List list;
            Object object;
            ShuffleOrder shuffleOrder;
            block17: {
                block16: {
                    shuffleOrder = this.shuffleOrder;
                    int n10 = shuffleOrder.getLength();
                    object = this.mediaSourcesPublic;
                    int n11 = object.size();
                    if (n10 == n11) break block16;
                    shuffleOrder = this.shuffleOrder;
                    shuffleOrder = shuffleOrder.cloneAndClear();
                    n11 = 0;
                    object = null;
                    list = this.mediaSourcesPublic;
                    int n12 = list.size();
                    shuffleOrder = shuffleOrder.cloneAndInsert(0, n12);
                    break block17;
                }
                shuffleOrder = this.shuffleOrder;
            }
            list = this.mediaSourcesPublic;
            boolean bl2 = this.isAtomic;
            object = new ConcatenatingMediaSource$ConcatenatedTimeline(list, shuffleOrder, bl2);
            return object;
        }
    }

    public MediaItem getMediaItem() {
        return EMPTY_MEDIA_ITEM;
    }

    public MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(ConcatenatingMediaSource$MediaSourceHolder object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        Object object2;
        int n10;
        Object object3 = null;
        for (int i10 = 0; i10 < (n10 = (object2 = ((ConcatenatingMediaSource$MediaSourceHolder)object).activeMediaPeriodIds).size()); ++i10) {
            object2 = (MediaSource$MediaPeriodId)((ConcatenatingMediaSource$MediaSourceHolder)object).activeMediaPeriodIds.get(i10);
            long l10 = ((MediaPeriodId)object2).windowSequenceNumber;
            long l11 = mediaSource$MediaPeriodId.windowSequenceNumber;
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
            object3 = mediaSource$MediaPeriodId.periodUid;
            object = ConcatenatingMediaSource.getPeriodUid((ConcatenatingMediaSource$MediaSourceHolder)object, object3);
            return mediaSource$MediaPeriodId.copyWithPeriodUid(object);
        }
        return null;
    }

    public MediaSource getMediaSource(int n10) {
        synchronized (this) {
            List list = this.mediaSourcesPublic;
            Object object = list.get(n10);
            object = (ConcatenatingMediaSource$MediaSourceHolder)object;
            object = ((ConcatenatingMediaSource$MediaSourceHolder)object).mediaSource;
            return object;
        }
    }

    public int getSize() {
        synchronized (this) {
            List list = this.mediaSourcesPublic;
            int n10 = list.size();
            return n10;
        }
    }

    public int getWindowIndexForChildWindowIndex(ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder, int n10) {
        int n11 = concatenatingMediaSource$MediaSourceHolder.firstWindowIndexInChild;
        return n10 + n11;
    }

    public boolean isSingleWindow() {
        return false;
    }

    public void moveMediaSource(int n10, int n11) {
        synchronized (this) {
            this.movePublicMediaSource(n10, n11, null, null);
            return;
        }
    }

    public void moveMediaSource(int n10, int n11, Handler handler, Runnable runnable) {
        synchronized (this) {
            this.movePublicMediaSource(n10, n11, handler, runnable);
            return;
        }
    }

    public void onChildSourceInfoRefreshed(ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        this.updateMediaSourceInternal(concatenatingMediaSource$MediaSourceHolder, timeline);
    }

    public void prepareSourceInternal(TransferListener object) {
        synchronized (this) {
            super.prepareSourceInternal((TransferListener)object);
            Object object2 = new b(this);
            object = new Handler((Handler.Callback)object2);
            this.playbackThreadHandler = object;
            object = this.mediaSourcesPublic;
            boolean bl2 = object.isEmpty();
            if (bl2) {
                this.updateTimelineAndScheduleOnCompletionActions();
            } else {
                object = this.shuffleOrder;
                object2 = this.mediaSourcesPublic;
                int n10 = object2.size();
                this.shuffleOrder = object = object.cloneAndInsert(0, n10);
                object = this.mediaSourcesPublic;
                this.addMediaSourcesInternal(0, (Collection)object);
                this.scheduleTimelineUpdate();
            }
            return;
        }
    }

    public void releasePeriod(MediaPeriod object) {
        ConcatenatingMediaSource$MediaSourceHolder concatenatingMediaSource$MediaSourceHolder = (ConcatenatingMediaSource$MediaSourceHolder)Assertions.checkNotNull((ConcatenatingMediaSource$MediaSourceHolder)this.mediaSourceByMediaPeriod.remove(object));
        concatenatingMediaSource$MediaSourceHolder.mediaSource.releasePeriod((MediaPeriod)object);
        List list = concatenatingMediaSource$MediaSourceHolder.activeMediaPeriodIds;
        object = ((MaskingMediaPeriod)object).id;
        list.remove(object);
        object = this.mediaSourceByMediaPeriod;
        boolean bl2 = ((IdentityHashMap)object).isEmpty();
        if (!bl2) {
            this.disableUnusedMediaSources();
        }
        this.maybeReleaseChildSource(concatenatingMediaSource$MediaSourceHolder);
    }

    public void releaseSourceInternal() {
        synchronized (this) {
            Object object;
            block13: {
                super.releaseSourceInternal();
                object = this.mediaSourceHolders;
                object.clear();
                object = this.enabledMediaSourceHolders;
                object.clear();
                object = this.mediaSourceByUid;
                object.clear();
                object = this.shuffleOrder;
                object = object.cloneAndClear();
                this.shuffleOrder = object;
                object = this.playbackThreadHandler;
                if (object == null) break block13;
                object.removeCallbacksAndMessages(null);
                this.playbackThreadHandler = null;
            }
            object = null;
            this.timelineUpdateScheduled = false;
            object = this.nextTimelineUpdateOnCompletionActions;
            object.clear();
            object = this.pendingOnCompletionActions;
            this.dispatchOnCompletionActions((Set)object);
            return;
        }
    }

    public MediaSource removeMediaSource(int n10) {
        synchronized (this) {
            MediaSource mediaSource = this.getMediaSource(n10);
            int n11 = n10 + 1;
            this.removePublicMediaSources(n10, n11, null, null);
            return mediaSource;
        }
    }

    public MediaSource removeMediaSource(int n10, Handler handler, Runnable runnable) {
        synchronized (this) {
            MediaSource mediaSource = this.getMediaSource(n10);
            int n11 = n10 + 1;
            this.removePublicMediaSources(n10, n11, handler, runnable);
            return mediaSource;
        }
    }

    public void removeMediaSourceRange(int n10, int n11) {
        synchronized (this) {
            this.removePublicMediaSources(n10, n11, null, null);
            return;
        }
    }

    public void removeMediaSourceRange(int n10, int n11, Handler handler, Runnable runnable) {
        synchronized (this) {
            this.removePublicMediaSources(n10, n11, handler, runnable);
            return;
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        synchronized (this) {
            this.setPublicShuffleOrder(shuffleOrder, null, null);
            return;
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder, Handler handler, Runnable runnable) {
        synchronized (this) {
            this.setPublicShuffleOrder(shuffleOrder, handler, runnable);
            return;
        }
    }
}

