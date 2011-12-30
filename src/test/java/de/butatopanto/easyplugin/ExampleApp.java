package de.butatopanto.easyplugin;

import com.google.inject.Injector;
import de.butatopanto.easyloader.EasyLoader;
import de.devsurf.injection.guice.scanner.PackageFilter;
import de.devsurf.injection.guice.scanner.StartupModule;
import de.devsurf.injection.guice.scanner.reflections.ReflectionsScanner;
import de.test.Example;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static com.google.inject.Guice.createInjector;

public class ExampleApp {

  public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
    EasyLoader loader = new EasyLoader(new File("./src/test/resources/test.jar"));
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        StartupModule startupModule = StartupModule.create(ReflectionsScanner.class, PackageFilter.create("de.test"));
        Injector injector = createInjector(startupModule);
        Example instance = injector.getInstance(Example.class);
        System.out.println(instance.sayHello());
      }
    };
    Thread thread = new Thread(runnable);
    thread.setContextClassLoader(loader);
    thread.start();
  }
}