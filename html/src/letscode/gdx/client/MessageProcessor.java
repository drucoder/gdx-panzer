package letscode.gdx.client;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import letscode.gdx.Starter;
import letscode.gdx.client.ws.WsEvent;

public class MessageProcessor {
    private final Starter starter;

    public MessageProcessor(Starter starter) {
        this.starter = starter;
    }

    public void processEvent(WsEvent event) {
        String data = event.getData();
        if (data != null) {
            JSONValue parsed = JSONParser.parseStrict(data);
            JSONArray array = parsed.isArray();
            JSONObject object = parsed.isObject();

            if (array != null) {
                processArray(array);
            } else if (object != null) {
                processObject(object);
            }
        }
    }

    private void processArray(JSONArray array) {
        for (int i = 0; i < array.size(); i++) {
            JSONValue jsonValue = array.get(i);
            JSONObject object = jsonValue.isObject();
            if (object != null) {
                processObject(object);
            }
        }
    }

    private void processObject(JSONObject object) {
        JSONValue type = object.get("class");
        if (type != null) {
            switch (type.isString().stringValue()) {
                case "sessionKey":
                    String meId = object.get("id").isString().stringValue();
                    starter.setMeId(meId);
                    break;
                case "evict":
                    String idToEvict = object.get("id").isString().stringValue();
                    starter.evict(idToEvict);
                    break;
                case "panzer":
                    float x = (float) object.get("x").isNumber().doubleValue();
                    float y = (float) object.get("y").isNumber().doubleValue();
                    float angle = (float) object.get("angle").isNumber().doubleValue();
                    String id = object.get("id").isString().stringValue();
                    starter.updatePanzer(id, x, y, angle);
                    break;
                default:
                    throw new RuntimeException("Unknown message type " + type);
            }
        }
    }
}
