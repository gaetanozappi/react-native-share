package com.reactlibrary;

import android.content.Intent;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class Share extends ReactContextBaseJavaModule {
    private ReactContext mReactContext;
    private String url;

    public Share(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    @ReactMethod
    public void getCheck(Promise promise){
      url = null;
      checkIntent();
      if (url != null) {
          promise.resolve(url);
      } else {
          promise.reject("URL_NOT_FOUND");
      }
    }

    @Override
    public String getName() {
        return "Share";
    }

    private void checkIntent() {
        if (getCurrentActivity() != null) {
            Intent intent = getCurrentActivity().getIntent();
            if (intent != null) {
                String action = intent.getAction();
                String type = intent.getType();
                if (Intent.ACTION_SEND.equals(action) && type != null) {
                    if (type.startsWith("text/")) {
                        handleSendText(intent);
                    }
                }
            }
        }
    }

    void handleSendText(Intent intent) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
          url = sharedText;
        }
    }

}
