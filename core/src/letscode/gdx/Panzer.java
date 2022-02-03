package letscode.gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Panzer {
    private final float size = 64;
    private final float halfSize = size / 2;

    private final Vector2 position = new Vector2();
    private final Vector2 angle = new Vector2(1, 1);
    private final Vector2 origin = new Vector2();

    private final Texture texture;
    private final TextureRegion textureRegion;

    public Panzer(float x, float y) {
        this(x, y, "panzer_me.png");
    }

    public Panzer(float x, float y, String textureName) {
        texture = new Texture(textureName);
        textureRegion = new TextureRegion(texture);
        position.set(x, y);
        origin.set(position).add(halfSize, halfSize);
    }

    public void render(Batch batch) {
        batch.draw(
                textureRegion,
                position.x,
                position.y,
                halfSize,
                halfSize,
                size,
                size,
                1,
                1,
                angle.angleDeg()
        );
    }

    public void dispose() {
        texture.dispose();
    }

    public void moveTo(Vector2 direction) {
        position.add(direction);
        origin.set(position).add(halfSize, halfSize);
    }

    public void rotateTo(Vector2 mousePos) {
        angle.set(mousePos).sub(origin);
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getOrigin() {
        return origin;
    }

    public void moveTo(float x, float y) {
        position.set(x, y);
        origin.set(position).add(halfSize, halfSize);
    }

    public void rotateTo(float angle) {
        this.angle.setAngleDeg(angle);
    }
}
