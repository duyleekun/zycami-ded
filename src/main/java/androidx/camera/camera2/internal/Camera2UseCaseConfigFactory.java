/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.util.Size
 *  android.view.Display
 *  android.view.WindowManager
 */
package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.Point;
import android.util.Size;
import android.view.Display;
import android.view.WindowManager;
import androidx.camera.camera2.internal.Camera2CaptureOptionUnpacker;
import androidx.camera.camera2.internal.Camera2SessionOptionUnpacker;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory$1;
import androidx.camera.camera2.internal.ImageCaptureOptionUnpacker;
import androidx.camera.camera2.internal.compat.workaround.PreviewPixelHDRnet;
import androidx.camera.core.impl.CaptureConfig$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;

public final class Camera2UseCaseConfigFactory
implements UseCaseConfigFactory {
    private static final Size MAX_PREVIEW_SIZE;
    public final WindowManager mWindowManager;

    static {
        Size size;
        MAX_PREVIEW_SIZE = size = new Size(1920, 1080);
    }

    public Camera2UseCaseConfigFactory(Context context) {
        context = (WindowManager)context.getSystemService("window");
        this.mWindowManager = context;
    }

    private Size getPreviewSize() {
        int n10;
        Point point = new Point();
        Display display = this.mWindowManager.getDefaultDisplay();
        display.getRealSize(point);
        int n11 = point.x;
        int n12 = point.y;
        if (n11 > n12) {
            n12 = point.x;
            n10 = point.y;
            display = new Size(n12, n10);
        } else {
            n12 = point.y;
            n10 = point.x;
            display = new Size(n12, n10);
        }
        n10 = display.getWidth();
        n12 = display.getHeight();
        Size size = MAX_PREVIEW_SIZE;
        int n13 = size.getWidth();
        int n14 = size.getHeight();
        if ((n10 *= n12) > (n13 *= n14)) {
            display = size;
        }
        return display;
    }

    public Config getConfig(UseCaseConfigFactory$CaptureType object) {
        MutableOptionsBundle mutableOptionsBundle = MutableOptionsBundle.create();
        Object object2 = new SessionConfig$Builder();
        int n10 = 1;
        ((SessionConfig$Builder)object2).setTemplateType(n10);
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.PREVIEW;
        if (object == useCaseConfigFactory$CaptureType) {
            PreviewPixelHDRnet.setHDRnet((SessionConfig$Builder)object2);
        }
        Object object3 = UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG;
        object2 = ((SessionConfig$Builder)object2).build();
        mutableOptionsBundle.insertOption((Config$Option)object3, object2);
        object2 = UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER;
        object3 = Camera2SessionOptionUnpacker.INSTANCE;
        mutableOptionsBundle.insertOption((Config$Option)object2, object3);
        object2 = new CaptureConfig$Builder();
        object3 = Camera2UseCaseConfigFactory$1.$SwitchMap$androidx$camera$core$impl$UseCaseConfigFactory$CaptureType;
        int n11 = object.ordinal();
        Object object4 = object3[n11];
        n11 = 2;
        if (object4 != n10) {
            if (object4 == n11 || object4 == (n11 = 3) || object4 == (n11 = 4)) {
                ((CaptureConfig$Builder)object2).setTemplateType(n10);
            }
        } else {
            ((CaptureConfig$Builder)object2).setTemplateType(n11);
        }
        Object object5 = UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG;
        object2 = ((CaptureConfig$Builder)object2).build();
        mutableOptionsBundle.insertOption((Config$Option)object5, object2);
        object2 = UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER;
        object5 = UseCaseConfigFactory$CaptureType.IMAGE_CAPTURE;
        object5 = object == object5 ? ImageCaptureOptionUnpacker.INSTANCE : Camera2CaptureOptionUnpacker.INSTANCE;
        mutableOptionsBundle.insertOption((Config$Option)object2, object5);
        if (object == useCaseConfigFactory$CaptureType) {
            object = ImageOutputConfig.OPTION_MAX_RESOLUTION;
            object2 = this.getPreviewSize();
            mutableOptionsBundle.insertOption((Config$Option)object, object2);
        }
        int n12 = this.mWindowManager.getDefaultDisplay().getRotation();
        object2 = ImageOutputConfig.OPTION_TARGET_ROTATION;
        object = n12;
        mutableOptionsBundle.insertOption((Config$Option)object2, object);
        return OptionsBundle.from(mutableOptionsBundle);
    }
}

