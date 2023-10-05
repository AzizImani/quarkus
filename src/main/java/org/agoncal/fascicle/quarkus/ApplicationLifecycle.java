package org.agoncal.fascicle.quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ApplicationLifecycle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationLifecycle.class);
    void onStart(@Observes StartupEvent ev) {
      LOGGER.info("The application is starting...");
    }
    void onStop(@Observes ShutdownEvent ev) {
      LOGGER.info("The application is stopping...");
    }
}