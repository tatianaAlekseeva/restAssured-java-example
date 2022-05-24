package tests;

import application.Application;
import org.junit.jupiter.api.BeforeAll;

import static java.lang.Runtime.getRuntime;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public static Application app;

    @BeforeAll
    static void start() {

        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        tlApp.set(app);

        getRuntime().addShutdownHook(
                new Thread(() -> app = null)
        );
    }
}
