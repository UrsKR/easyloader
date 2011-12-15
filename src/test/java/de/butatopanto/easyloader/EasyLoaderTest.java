package de.butatopanto.easyloader;

import org.junit.Test;

import java.io.File;

public class EasyLoaderTest {

  @Test
  public void canLoadClassFromSingleJar() throws Exception {
    EasyLoader loader = new EasyLoader(new File("./src/test/resources/jaxen-1.1.3.jar"));
    ClassLoader classLoader = loader.getClassLoader();
    classLoader.loadClass("org.jaxen.BaseXPath");
  }
}