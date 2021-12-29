package letscode.gdx.client.ws;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative = true)
public class WebSocket {
    @JsMethod
    public native void send(String data);
    @JsMethod
    public native void addEventListener(String eventType, EventListenerCallback callback);
}
