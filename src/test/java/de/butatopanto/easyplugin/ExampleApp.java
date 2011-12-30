package de.butatopanto.easyplugin;

import com.google.inject.Injector;
import de.test.Example;
import de.devsurf.injection.guice.scanner.PackageFilter;
import de.devsurf.injection.guice.scanner.StartupModule;
import de.devsurf.injection.guice.scanner.reflections.ReflectionsScanner;

import java.io.IOException;

import static com.google.inject.Guice.createInjector;
import static de.devsurf.injection.guice.scanner.StartupModule.create;

public class ExampleApp {

  public static void main(String[] args) throws IOException {
    StartupModule startupModule = create(ReflectionsScanner.class, PackageFilter.create("de.test"));
    Injector injector = createInjector(startupModule);
    Example instance = injector.getInstance(Example.class);
    System.out.println(instance.sayHello());
  }
}