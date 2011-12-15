package de.butatopanto.easyloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class EasyLoader {

  private ClassLoader classLoader = new URLClassLoader(new URL[0]);

  public EasyLoader(File file) throws MalformedURLException {
    classLoader = new URLClassLoader(getURLs(file), getClass().getClassLoader());
  }

  private URL[] getURLs(File file) throws MalformedURLException {
    if (file.isDirectory()) {
      return new URL[]{file.listFiles()[0].toURI().toURL()};
    }
    return new URL[]{file.toURI().toURL()};
  }

  public ClassLoader getClassLoader() {
    return classLoader;
  }
}
