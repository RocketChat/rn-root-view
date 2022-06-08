package chat.rocket.rootview;

import androidx.annotation.NonNull;

import android.app.Activity;
import android.view.View;
import android.graphics.Color;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = RootViewModule.NAME)
public class RootViewModule extends ReactContextBaseJavaModule {
    public static final String NAME = "RootView";

    public RootViewModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    @ReactMethod
    public void setColor(final String color) {
        final Activity activity = getCurrentActivity();

        if (activity == null) {
            return;
        }

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                View rootView = activity.getWindow().getDecorView();
                int parsedColor = Color.parseColor(color);
                rootView.getRootView().setBackgroundColor(parsedColor);
            }
        });
    }
}
