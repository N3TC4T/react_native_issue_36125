package com.mycustomlib;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.EventDispatcher;

import java.util.Map;

public class MyCustomViewManager extends ViewGroupManager<MyCustomView> {

    @Override
    public String getName() {
        return "MyCustomView";
    }

    @Override
    protected MyCustomView createViewInstance(ThemedReactContext reactContext) {
        return new MyCustomView(reactContext);
    }

    @Override
    protected void addEventEmitters(ThemedReactContext reactContext, MyCustomView view) {
        view.setEventListener(new MyViewEventEmitter(view, reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher()));
    }

    @javax.annotation.Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.<String, Object>builder()
                .put("onAnimatedEventIssue", MapBuilder.of("registrationName", "onAnimatedEventIssue"))
                .put("OnAnimatedEventWorks", MapBuilder.of("registrationName", "OnAnimatedEventWorks"))
                .build();
    }

    private static class MyViewEventEmitter implements MyCustomView.MyCustomListener {
        private final MyCustomView  myCustomViewView;
        private final EventDispatcher eventDispatcher;

        public MyViewEventEmitter(MyCustomView view, EventDispatcher eventDispatcher) {
            this.myCustomViewView = view;
            this.eventDispatcher = eventDispatcher;
        }

        @Override
        public void onAnimatedEventIssue(float value) {
            eventDispatcher.dispatchEvent(new Events.OnAnimatedEventIssue(myCustomViewView.getId(), value));
        }

        @Override
        public void onAnimatedEventWorks(float value) {
            eventDispatcher.dispatchEvent(new Events.OnAnimatedEventWorks(myCustomViewView.getId(), value));
        }
    }
}
