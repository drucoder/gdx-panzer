package letscode.gdx.client.ws;

import com.google.gwt.core.client.JavaScriptObject;

public class WsEvent extends JavaScriptObject {
    protected WsEvent() {}

    public final native String getData()
            /*-{
                return this.data;
            }-*/
    ;
}
