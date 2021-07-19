/*
 * Decompiled with CFR 0.151.
 */
package org.apache.tools.zip;

import org.apache.tools.zip.ZipFile$1;

public final class ZipFile$OffsetEntry {
    private long dataOffset;
    private long headerOffset;

    private ZipFile$OffsetEntry() {
        long l10;
        this.headerOffset = l10 = (long)-1;
        this.dataOffset = l10;
    }

    public /* synthetic */ ZipFile$OffsetEntry(ZipFile$1 zipFile$1) {
        this();
    }

    public static /* synthetic */ long access$000(ZipFile$OffsetEntry zipFile$OffsetEntry) {
        return zipFile$OffsetEntry.dataOffset;
    }

    public static /* synthetic */ long access$002(ZipFile$OffsetEntry zipFile$OffsetEntry, long l10) {
        zipFile$OffsetEntry.dataOffset = l10;
        return l10;
    }

    public static /* synthetic */ long access$200(ZipFile$OffsetEntry zipFile$OffsetEntry) {
        return zipFile$OffsetEntry.headerOffset;
    }

    public static /* synthetic */ long access$202(ZipFile$OffsetEntry zipFile$OffsetEntry, long l10) {
        zipFile$OffsetEntry.headerOffset = l10;
        return l10;
    }
}

