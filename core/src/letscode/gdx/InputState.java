package letscode.gdx;

public interface InputState {
    boolean isLeftPressed();

    void setLeftPressed(boolean leftPressed);

    boolean isRightPressed();

    void setRightPressed(boolean rightPressed);

    boolean isUpPressed();

    void setUpPressed(boolean upPressed);

    boolean isDownPressed();

    void setDownPressed(boolean downPressed);

    boolean isFirePressed();

    void setFirePressed(boolean firePressed);

    float getAngle();

    void setAngle(float angle);
}
