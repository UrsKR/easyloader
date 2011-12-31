package de.butatopanto.test;

import com.google.inject.AbstractModule;
import de.butatopanto.easyplugin.Application;
import de.devsurf.injection.guice.annotations.GuiceModule;

@GuiceModule
public class TestModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Application.class).toInstance(new TestApplication());
  }
}