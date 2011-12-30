package de.test;

import com.google.inject.AbstractModule;
import de.devsurf.injection.guice.annotations.GuiceModule;

@GuiceModule
public class TestModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(Example.class).toInstance(new Example("Urs"));
  }
}
