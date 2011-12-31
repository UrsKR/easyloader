package de.butatopanto.easyplugin;

import de.butatopanto.easyloader.EasyLoader;
import org.junit.Test;

import java.io.File;

public class EasyPluginTest {

  @Test
  public void findsImplementationOfApplicationInTestmodule() throws Exception {
    EasyLoader loader = new EasyLoader(new File("./src/test/resources/testmodule.jar"));
    EasyPlugin easyPlugin = new EasyPlugin(loader, "de.butatopanto.test");
    easyPlugin.startApplication();
  }
}
