/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader$MasterElement;
import com.google.android.exoplayer2.extractor.mkv.EbmlProcessor;
import com.google.android.exoplayer2.extractor.mkv.EbmlReader;
import com.google.android.exoplayer2.extractor.mkv.VarintReader;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

public final class DefaultEbmlReader
implements EbmlReader {
    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_ID_BYTES = 4;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int MAX_LENGTH_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private final ArrayDeque masterElementsStack;
    private EbmlProcessor processor;
    private final byte[] scratch;
    private final VarintReader varintReader;

    public DefaultEbmlReader() {
        Object object = new byte[8];
        this.scratch = object;
        object = new ArrayDeque;
        this.masterElementsStack = object;
        object = new VarintReader;
        super();
        this.varintReader = object;
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput extractorInput) {
        extractorInput.resetPeekPosition();
        while (true) {
            long l10;
            EbmlProcessor ebmlProcessor;
            byte[] byArray = this.scratch;
            int n10 = 0;
            int n11 = 4;
            extractorInput.peekFully(byArray, 0, n11);
            byArray = this.scratch;
            int n12 = VarintReader.parseUnsignedVarintLength(byArray[0]);
            int n13 = -1;
            if (n12 != n13 && n12 <= n11 && (n11 = (int)((ebmlProcessor = this.processor).isLevel1Element(n10 = (int)(l10 = VarintReader.assembleVarint(this.scratch, n12, false))) ? 1 : 0)) != 0) {
                extractorInput.skipFully(n12);
                return n10;
            }
            n12 = 1;
            extractorInput.skipFully(n12);
        }
    }

    private double readFloat(ExtractorInput extractorInput, int n10) {
        double d10;
        long l10 = this.readInteger(extractorInput, n10);
        int n11 = 4;
        float f10 = 5.6E-45f;
        if (n10 == n11) {
            n11 = (int)l10;
            f10 = Float.intBitsToFloat(n11);
            d10 = f10;
        } else {
            d10 = Double.longBitsToDouble(l10);
        }
        return d10;
    }

    private long readInteger(ExtractorInput object, int n10) {
        byte[] byArray = this.scratch;
        object.readFully(byArray, 0, n10);
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            l10 <<= 8;
            object = this.scratch;
            int n11 = object[i10] & 0xFF;
            long l11 = n11;
            l10 |= l11;
        }
        return l10;
    }

    private static String readString(ExtractorInput object, int n10) {
        if (n10 == 0) {
            return "";
        }
        byte[] byArray = new byte[n10];
        object.readFully(byArray, 0, n10);
        while (n10 > 0) {
            int n11 = n10 + -1;
            if ((n11 = byArray[n11]) != 0) break;
            n10 += -1;
        }
        object = new String(byArray, 0, n10);
        return object;
    }

    public void init(EbmlProcessor ebmlProcessor) {
        this.processor = ebmlProcessor;
    }

    public boolean read(ExtractorInput object) {
        Object object2 = this.processor;
        Assertions.checkStateNotNull(object2);
        while (true) {
            long l10;
            long l11;
            int n10;
            long l12;
            long l13;
            long l14;
            long l15;
            Object object3;
            object2 = (DefaultEbmlReader$MasterElement)this.masterElementsStack.peek();
            Object object4 = 1;
            if (object2 != null && (object3 = (Object)((l15 = (l14 = object.getPosition()) - (l13 = DefaultEbmlReader$MasterElement.access$000((DefaultEbmlReader$MasterElement)object2))) == 0L ? 0 : (l15 < 0L ? -1 : 1))) >= 0) {
                object = this.processor;
                object3 = DefaultEbmlReader$MasterElement.access$100((DefaultEbmlReader$MasterElement)this.masterElementsStack.pop());
                object.endMasterElement((int)object3);
                return object4;
            }
            object3 = this.elementState;
            int n11 = 4;
            StringBuilder stringBuilder = null;
            if (object3 == 0) {
                long l16;
                object2 = this.varintReader;
                l13 = ((VarintReader)object2).readUnsignedVarint((ExtractorInput)object, (boolean)object4, false, n11);
                long l17 = l13 - (l12 = (long)-2);
                object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object3 == 0) {
                    l13 = this.maybeResyncToNextLevel1Element((ExtractorInput)object);
                }
                if ((object3 = (l16 = l13 - (l12 = (long)-1)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) == 0) {
                    return false;
                }
                this.elementId = object3 = (int)l13;
                this.elementState = object4;
            }
            object3 = this.elementState;
            int n12 = 2;
            if (object3 == object4) {
                object2 = this.varintReader;
                n10 = 8;
                this.elementContentSize = l11 = ((VarintReader)object2).readUnsignedVarint((ExtractorInput)object, false, (boolean)object4, n10);
                this.elementState = n12;
            }
            if ((object3 = (object2 = this.processor).getElementType(n10 = this.elementId)) != 0) {
                if (object3 != object4) {
                    l11 = 8;
                    if (object3 != n12) {
                        n12 = 3;
                        if (object3 != n12) {
                            if (object3 != n11) {
                                n11 = 5;
                                if (object3 == n11) {
                                    long l18 = this.elementContentSize;
                                    long l19 = 4;
                                    long l20 = l18 - l19;
                                    object3 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                                    if (object3 != 0 && (object3 = (Object)(l18 == l11 ? 0 : (l18 < l11 ? -1 : 1))) != 0) {
                                        l10 = this.elementContentSize;
                                        stringBuilder = new StringBuilder(40);
                                        stringBuilder.append("Invalid float size: ");
                                        stringBuilder.append(l10);
                                        object2 = stringBuilder.toString();
                                        object = new ParserException((String)object2);
                                        throw object;
                                    }
                                    object2 = this.processor;
                                    n11 = this.elementId;
                                    n12 = (int)l18;
                                    double d10 = this.readFloat((ExtractorInput)object, n12);
                                    object2.floatElement(n11, d10);
                                    this.elementState = 0;
                                    return object4;
                                }
                                StringBuilder stringBuilder2 = new StringBuilder(32);
                                stringBuilder2.append("Invalid element type ");
                                stringBuilder2.append((int)object3);
                                object2 = stringBuilder2.toString();
                                object = new ParserException((String)object2);
                                throw object;
                            }
                            object2 = this.processor;
                            n11 = this.elementId;
                            n12 = (int)this.elementContentSize;
                            object2.binaryElement(n11, n12, (ExtractorInput)object);
                            this.elementState = 0;
                            return object4;
                        }
                        l13 = this.elementContentSize;
                        l12 = Integer.MAX_VALUE;
                        long l21 = l13 - l12;
                        object3 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                        if (object3 <= 0) {
                            object2 = this.processor;
                            n11 = this.elementId;
                            n12 = (int)l13;
                            object = DefaultEbmlReader.readString((ExtractorInput)object, n12);
                            object2.stringElement(n11, (String)object);
                            this.elementState = 0;
                            return object4;
                        }
                        l10 = this.elementContentSize;
                        stringBuilder = new StringBuilder(41);
                        stringBuilder.append("String element size: ");
                        stringBuilder.append(l10);
                        object2 = stringBuilder.toString();
                        object = new ParserException((String)object2);
                        throw object;
                    }
                    long l22 = this.elementContentSize;
                    long l23 = l22 - l11;
                    object3 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
                    if (object3 <= 0) {
                        object2 = this.processor;
                        n11 = this.elementId;
                        n12 = (int)l22;
                        l13 = this.readInteger((ExtractorInput)object, n12);
                        object2.integerElement(n11, l13);
                        this.elementState = 0;
                        return object4;
                    }
                    l10 = this.elementContentSize;
                    stringBuilder = new StringBuilder(42);
                    stringBuilder.append("Invalid integer size: ");
                    stringBuilder.append(l10);
                    object2 = stringBuilder.toString();
                    object = new ParserException((String)object2);
                    throw object;
                }
                l12 = object.getPosition();
                l13 = this.elementContentSize + l12;
                object = this.masterElementsStack;
                n11 = this.elementId;
                object2 = new DefaultEbmlReader$MasterElement(n11, l13, null);
                ((ArrayDeque)object).push(object2);
                EbmlProcessor ebmlProcessor = this.processor;
                n10 = this.elementId;
                long l24 = this.elementContentSize;
                ebmlProcessor.startMasterElement(n10, l12, l24);
                this.elementState = 0;
                return object4;
            }
            l10 = this.elementContentSize;
            object3 = (int)l10;
            object.skipFully((int)object3);
            this.elementState = 0;
        }
    }

    public void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }
}

