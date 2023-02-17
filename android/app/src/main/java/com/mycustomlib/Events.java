package com.mycustomlib;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class Events {
    public static class OnAnimatedEventIssue extends Event<OnAnimatedEventIssue> {

        WritableMap eventData;

        public OnAnimatedEventIssue(int viewTag, float value) {
            super(viewTag);
            eventData = Arguments.createMap();
            eventData.putDouble("value", value);
        }

        @Override
        public String getEventName() {
            return "onAnimatedEventIssue";
        }

        @Override
        public void dispatch(RCTEventEmitter rctEventEmitter) {
            rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
        }
    }


    public static class OnAnimatedEventWorks extends Event<OnAnimatedEventWorks> {

        WritableMap eventData;

        public OnAnimatedEventWorks(int viewTag,  float value) {
            super(viewTag);
            eventData = Arguments.createMap();
            eventData.putDouble("value", value);
        }

        @Override
        public String getEventName() {
            return "OnAnimatedEventWorks";
        }

        @Override
        public void dispatch(RCTEventEmitter rctEventEmitter) {
            rctEventEmitter.receiveEvent(getViewTag(), getEventName(), eventData);
        }
    }
}
