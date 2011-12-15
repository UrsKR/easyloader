package de.butatopanto.easyloader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Lists.newArrayList;

public class EasyLoader {

  private ClassLoader classLoader = new URLClassLoader(new URL[0]);

  public EasyLoader(File file) throws MalformedURLException {
    classLoader = new URLClassLoader(getURLs(file), getClass().getClassLoader());
  }

  private URL[] getURLs(File file) throws MalformedURLException {
    if (file.isDirectory()) {
      ArrayList<File> files = newArrayList(file.listFiles());
      Collection<URL> urls = transform(files, new ToURLs());
      return urls.toArray(new URL[urls.size()]);
    }
    return new URL[]{file.toURI().toURL()};
  }

  public ClassLoader getClassLoader() {
    return classLoader;
  }
}
