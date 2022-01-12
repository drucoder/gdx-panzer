package letscode.gdx.client.dto;

import letscode.gdx.InputState;

public class InputStateImpl implements InputState {
    public InputStateImpl() {
        setType("state");
        setLeftPressed(false);
        setRightPressed(false);
        setUpPressed(false);
        setDownPressed(false);
        setFirePressed(false);
        setAngle(0);
    }

    public InputStateImpl(boolean leftPressed, boolean rightPressed, boolean upPressed, boolean downPressed, boolean firePressed, float angle) {
        this();
        setLeftPressed(leftPressed);
        setRightPressed(rightPressed);
        setUpPressed(upPressed);
        setDownPressed(downPressed);
        setFirePressed(firePressed);
        setAngle(angle);
    }

    @Override
    public native boolean isLeftPressed() /*-{
        return this.leftPressed;
    }-*/;

    @Override
    public native void setLeftPressed(boolean leftPressed) /*-{
        this.leftPressed = leftPressed;
    }-*/;

    @Override
    public native boolean isRightPressed() /*-{
        return this.rightPressed;
    }-*/;

    @Override
    public native void setRightPressed(boolean rightPressed) /*-{
        this.rightPressed = rightPressed;
    }-*/;

    @Override
    public native boolean isUpPressed() /*-{
        return this.upPressed;
    }-*/;

    @Override
    public native void setUpPressed(boolean upPressed) /*-{
        this.upPressed = upPressed;
    }-*/;

    @Override
    public native boolean isDownPressed() /*-{
        return this.downPressed;
    }-*/;

    @Override
    public native void setDownPressed(boolean downPressed) /*-{
        this.downPressed = downPressed;
    }-*/;

    @Override
    public native boolean isFirePressed() /*-{
        return this.firePressed;
    }-*/;

    @Override
    public native void setFirePressed(boolean firePressed) /*-{
        this.firePressed = firePressed;
    }-*/;

    @Override
    public native float getAngle() /*-{
        return this.angle;
    }-*/;

    @Override
    public native void setAngle(float angle) /*-{
        this.angle = angle;
    }-*/;

    public native String getType() /*-{
        return this.type;
    }-*/;

    public native void setType(String type) /*-{
        this.type = type;
    }-*/;
}
