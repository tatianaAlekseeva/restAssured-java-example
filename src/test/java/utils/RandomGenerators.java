package utils;

import java.util.Random;
import java.util.UUID;

import static application.Application.getMaxId;

public class RandomGenerators {

    private static final Random random = new Random();

    public static int getItemId() {
        int maxId = getMaxId();
        int itemId = random.nextInt(maxId);
        return itemId;
    }

    private static String getId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();

    }

    public static String getRequestId() {
        return getId();
    }

    public static String getCookie() {
        return "user=".concat(getId());
    }
}
