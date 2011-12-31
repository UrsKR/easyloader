package de.butatopanto.test;

import de.butatopanto.easyplugin.Application;

public class TestApplication implements Application {

  public boolean wasStarted = false;

  @Override
  public void start() {
    wasStarted = true;
  }
}