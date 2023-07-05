package com.example.demo;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.NonNull;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * The type Test container.
 */
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = TestContainer.Initializer.class)
@Testcontainers
public abstract class TestContainer {

    /**
     * The type Initializer.
     */
    static class Initializer implements
            ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(
                @NonNull final ConfigurableApplicationContext
                        configurableApplicationContext) {
            TestPropertySourceUtils
                    .addInlinedPropertiesToEnvironment(
                            configurableApplicationContext);
        }
    }
}
