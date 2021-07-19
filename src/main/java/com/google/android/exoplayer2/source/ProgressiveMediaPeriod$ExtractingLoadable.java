/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.IcyDataSource$Listener;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Map;

public final class ProgressiveMediaPeriod$ExtractingLoadable
implements Loader$Loadable,
IcyDataSource$Listener {
    private final StatsDataSource dataSource;
    private DataSpec dataSpec;
    private final ExtractorOutput extractorOutput;
    private TrackOutput icyTrackOutput;
    private long length;
    private volatile boolean loadCanceled;
    private final ConditionVariable loadCondition;
    private final long loadTaskId;
    private boolean pendingExtractorSeek;
    private final PositionHolder positionHolder;
    private final ProgressiveMediaExtractor progressiveMediaExtractor;
    private long seekTimeUs;
    private boolean seenIcyMetadata;
    public final /* synthetic */ ProgressiveMediaPeriod this$0;
    private final Uri uri;

    public ProgressiveMediaPeriod$ExtractingLoadable(ProgressiveMediaPeriod object, Uri uri, DataSource dataSource, ProgressiveMediaExtractor progressiveMediaExtractor, ExtractorOutput extractorOutput, ConditionVariable conditionVariable) {
        long l10;
        this.this$0 = object;
        this.uri = uri;
        this.dataSource = object = new StatsDataSource(dataSource);
        this.progressiveMediaExtractor = progressiveMediaExtractor;
        this.extractorOutput = extractorOutput;
        this.loadCondition = conditionVariable;
        this.positionHolder = object = new PositionHolder();
        this.pendingExtractorSeek = true;
        this.length = -1;
        this.loadTaskId = l10 = LoadEventInfo.getNewId();
        this.dataSpec = object = this.buildDataSpec(0L);
    }

    public static /* synthetic */ StatsDataSource access$100(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable) {
        return progressiveMediaPeriod$ExtractingLoadable.dataSource;
    }

    public static /* synthetic */ long access$200(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable) {
        return progressiveMediaPeriod$ExtractingLoadable.loadTaskId;
    }

    public static /* synthetic */ DataSpec access$300(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable) {
        return progressiveMediaPeriod$ExtractingLoadable.dataSpec;
    }

    public static /* synthetic */ long access$400(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable) {
        return progressiveMediaPeriod$ExtractingLoadable.seekTimeUs;
    }

    public static /* synthetic */ long access$500(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable) {
        return progressiveMediaPeriod$ExtractingLoadable.length;
    }

    public static /* synthetic */ void access$600(ProgressiveMediaPeriod$ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable, long l10, long l11) {
        progressiveMediaPeriod$ExtractingLoadable.setLoadPosition(l10, l11);
    }

    private DataSpec buildDataSpec(long l10) {
        DataSpec$Builder dataSpec$Builder = new DataSpec$Builder();
        Uri uri = this.uri;
        DataSpec$Builder dataSpec$Builder2 = dataSpec$Builder.setUri(uri).setPosition(l10);
        Object object = ProgressiveMediaPeriod.access$1400(this.this$0);
        dataSpec$Builder2 = dataSpec$Builder2.setKey((String)object).setFlags(6);
        object = ProgressiveMediaPeriod.access$1300();
        return dataSpec$Builder2.setHttpRequestHeaders((Map)object).build();
    }

    private void setLoadPosition(long l10, long l11) {
        this.positionHolder.position = l10;
        this.seekTimeUs = l11;
        this.pendingExtractorSeek = true;
        this.seenIcyMetadata = false;
    }

    public void cancelLoad() {
        this.loadCanceled = true;
    }

    /*
     * Exception decompiling
     */
    public void load() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [60[UNCONDITIONALDOLOOP]], but top level block is 61[WHILELOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void onIcyMetadata(ParsableByteArray parsableByteArray) {
        Object object;
        long l10;
        boolean bl2 = this.seenIcyMetadata;
        if (!bl2) {
            l10 = this.seekTimeUs;
        } else {
            object = this.this$0;
            l10 = ProgressiveMediaPeriod.access$1200((ProgressiveMediaPeriod)object);
            long l11 = this.seekTimeUs;
            l10 = Math.max(l10, l11);
        }
        int n10 = parsableByteArray.bytesLeft();
        Object object2 = object = Assertions.checkNotNull(this.icyTrackOutput);
        object2 = (TrackOutput)object;
        object2.sampleData(parsableByteArray, n10);
        object2.sampleMetadata(l10, 1, n10, 0, null);
        this.seenIcyMetadata = true;
    }
}

