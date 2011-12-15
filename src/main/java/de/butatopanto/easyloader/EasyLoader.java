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
    classLoader = new URLClassLoader(getURLs(file));
  }

  private URL[] getURLs(File file) throws MalformedURLException {
    if (file.isDirectory()) {
      return allJarFilesInDirectory(file);
    }
    return singleFile(file);
  }

  private URL[] allJarFilesInDirectory(File folder) {
    ArrayList<File> files = newArrayList(folder.listFiles());
    Collection<URL> urls = transform(files, new ToURL());
    return urls.toArray(new URL[urls.size()]);
  }

  private URL[] singleFile(File file) throws MalformedURLException {
    return new URL[]{new ToURL().apply(file)};
  }

  public ClassLoader getClassLoader() {
    return classLoader;
  }
}
