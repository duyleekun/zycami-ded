/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.mediapipe.components;

import android.util.Log;
import com.google.mediapipe.components.FrameProcessor;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.framework.GraphTextureFrame;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketCallback;
import com.google.mediapipe.framework.PacketGetter;
import java.util.Iterator;

public class FrameProcessor$1
implements PacketCallback {
    public final /* synthetic */ FrameProcessor this$0;

    public FrameProcessor$1(FrameProcessor frameProcessor) {
        this.this$0 = frameProcessor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void process(Packet packet) {
        Iterator iterator2;
        synchronized (this) {
            iterator2 = this.this$0;
            iterator2 = FrameProcessor.access$000((FrameProcessor)((Object)iterator2));
        }
        iterator2 = iterator2.iterator();
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            TextureFrameConsumer textureFrameConsumer = (TextureFrameConsumer)iterator2.next();
            GraphTextureFrame graphTextureFrame = PacketGetter.getTextureFrame(packet);
            String string2 = "FrameProcessor";
            int n10 = 2;
            boolean bl3 = Log.isLoggable((String)string2, (int)n10);
            if (bl3) {
                string2 = "FrameProcessor";
                String string3 = "Output tex: %d width: %d height: %d to consumer %h";
                int n11 = 4;
                Object[] objectArray = new Object[n11];
                Integer n12 = graphTextureFrame.getTextureName();
                objectArray[0] = n12;
                int n13 = graphTextureFrame.getWidth();
                n12 = n13;
                objectArray[1] = n12;
                int n14 = graphTextureFrame.getHeight();
                Integer n15 = n14;
                objectArray[n10] = n15;
                n10 = 3;
                objectArray[n10] = textureFrameConsumer;
                String string4 = String.format(string3, objectArray);
                Log.v((String)string2, (String)string4);
            }
            textureFrameConsumer.onNewFrame(graphTextureFrame);
        }
        return;
    }
}

