/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder$FramePredicate;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;

public final class Id3Peeker {
    private final ParsableByteArray scratch;

    public Id3Peeker() {
        ParsableByteArray parsableByteArray;
        this.scratch = parsableByteArray = new ParsableByteArray(10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Metadata peekId3Data(ExtractorInput var1_1, Id3Decoder$FramePredicate var2_2) {
        block5: {
            var3_3 /* !! */  = null;
            var4_4 = 0;
            while (true) lbl-1000:
            // 2 sources

            {
                var5_5 = this.scratch;
                break;
            }
            catch (EOFException v0) {}
            {
                block7: {
                    block6: {
                        var5_5 = var5_5.getData();
                        var6_6 = 10;
                        var1_1.peekFully((byte[])var5_5, 0, var6_6);
                        this.scratch.setPosition(0);
                        var5_5 = this.scratch;
                        var7_7 = var5_5.readUnsignedInt24();
                        var8_8 = 0x494433;
                        if (var7_7 != var8_8) break block5;
                        this.scratch.skipBytes(3);
                        var5_5 = this.scratch;
                        var7_7 = var5_5.readSynchSafeInt();
                        var8_8 = var7_7 + 10;
                        if (var3_3 /* !! */  != null) break block6;
                        var3_3 /* !! */  = new byte[var8_8];
                        var9_9 = this.scratch.getData();
                        System.arraycopy(var9_9, 0, var3_3 /* !! */ , 0, var6_6);
                        var1_1.peekFully(var3_3 /* !! */ , var6_6, var7_7);
                        var5_5 = new Id3Decoder(var2_2);
                        var3_3 /* !! */  = (byte[])var5_5.decode(var3_3 /* !! */ , var8_8);
                        break block7;
                    }
                    var1_1.advancePeekPosition(var7_7);
                }
                var4_4 += var8_8;
                ** while (true)
            }
        }
        var1_1.resetPeekPosition();
        var1_1.advancePeekPosition(var4_4);
        return var3_3 /* !! */ ;
    }
}

