/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.vision;

public class Frame$Metadata {
    private int format = -1;
    private int height;
    private int id;
    private int rotation;
    private int width;
    private long zzaz;

    public Frame$Metadata() {
    }

    public Frame$Metadata(Frame$Metadata frame$Metadata) {
        int n10;
        long l10;
        int n11;
        this.width = n11 = frame$Metadata.getWidth();
        this.height = n11 = frame$Metadata.getHeight();
        this.id = n11 = frame$Metadata.getId();
        this.zzaz = l10 = frame$Metadata.getTimestampMillis();
        this.rotation = n11 = frame$Metadata.getRotation();
        this.format = n10 = frame$Metadata.getFormat();
    }

    public static /* synthetic */ int zza(Frame$Metadata frame$Metadata, int n10) {
        frame$Metadata.width = n10;
        return n10;
    }

    public static /* synthetic */ long zza(Frame$Metadata frame$Metadata, long l10) {
        frame$Metadata.zzaz = l10;
        return l10;
    }

    public static /* synthetic */ int zzb(Frame$Metadata frame$Metadata, int n10) {
        frame$Metadata.height = n10;
        return n10;
    }

    public static /* synthetic */ int zzc(Frame$Metadata frame$Metadata, int n10) {
        frame$Metadata.format = n10;
        return n10;
    }

    public static /* synthetic */ int zzd(Frame$Metadata frame$Metadata, int n10) {
        frame$Metadata.id = n10;
        return n10;
    }

    public static /* synthetic */ int zze(Frame$Metadata frame$Metadata, int n10) {
        frame$Metadata.rotation = n10;
        return n10;
    }

    public int getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.height;
    }

    public int getId() {
        return this.id;
    }

    public int getRotation() {
        return this.rotation;
    }

    public long getTimestampMillis() {
        return this.zzaz;
    }

    public int getWidth() {
        return this.width;
    }

    public final void zzf() {
        int n10 = this.rotation % 2;
        if (n10 != 0) {
            int n11;
            n10 = this.width;
            this.width = n11 = this.height;
            this.height = n10;
        }
        this.rotation = 0;
    }
}

