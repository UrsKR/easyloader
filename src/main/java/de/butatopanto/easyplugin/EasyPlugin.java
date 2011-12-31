package de.butatopanto.easyplugin;

import com.google.inject.Injector;
import de.devsurf.injection.guice.scanner.PackageFilter;
import de.devsurf.injection.guice.scanner.StartupModule;
import de.devsurf.injection.guice.scanner.reflections.ReflectionsScanner;

import static com.google.inject.Guice.createInjector;

public class EasyPlugin {

  private ClassLoader loader;
  private String modulePackage;

  public EasyPlugin(ClassLoader loader, String modulePackage) {
    this.loader = loader;
    this.modulePackage = modulePackage;
  }

  public void startApplication() {
    Thread.currentThread().setContextClassLoader(loader);
    StartupModule startupModule = StartupModule.create(ReflectionsScanner.class, PackageFilter.create(modulePackage));
    Injector injector = createInjector(startupModule);
    Application application = injector.getInstance(Application.class);
    application.start();
  }
}