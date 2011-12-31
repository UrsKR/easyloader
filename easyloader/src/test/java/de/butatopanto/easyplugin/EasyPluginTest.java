package de.butatopanto.easyplugin;

import de.butatopanto.easyloader.EasyLoader;
import org.junit.Test;

import java.io.File;

public class EasyPluginTest {

  @Test
  public void findsImplementationOfApplicationInTestmodule() throws Exception {
    String libraryAndModuleFolder = "./src/test/resources/";
    String modulePackage = "de.butatopanto.test";
    EasyLoader loader = new EasyLoader(new File(libraryAndModuleFolder));
    EasyPlugin easyPlugin = new EasyPlugin(loader, modulePackage);
    easyPlugin.startApplication();
  }
}
