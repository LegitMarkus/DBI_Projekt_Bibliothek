package at.htlleonding;

import at.htlleonding.logic.LibraryLogic;
import io.quarkus.runtime.QuarkusApplication;

import javax.inject.Inject;

@io.quarkus.runtime.annotations.QuarkusMain
public class QuarkusCmdlineApp implements QuarkusApplication {
    @Inject
    LibraryLogic library;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello World from Quarkus...");

        return 0;
    }
}
