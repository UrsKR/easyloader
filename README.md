*EasyLoader* is a simple drop-and-play plugin-system for Java.
It consists of two parts: ``EasyLoader`` (a directory-capable ``ClassLoader``), and ``EasyPlugin``(a no-xml dependency injector).

It relies on [Google Guice](http://code.google.com/p/google-guice/) and [Daniel Manzke](http://manzke.github.com/)'s [Guice Auto-Binding](https://github.com/manzke/guice-automatic-injection) system.

Usage
=====
1. Implement ``Application``.
2. Implement your Guice modules and annotate them with ``@GuiceModule`` (from Guice Auto-Binding).
3. Make sure your modules are all in the same package.
4. Have one of the modules bind the implemented application.
5. Package the modules into jars and drop all of them into a folder.
6. Make a main class similar to this:

```java
public static void main(String[] arguments){
	String libraryAndModuleFolder = "./src/test/resources/";
	String modulePackage = "de.butatopanto.test";
	EasyLoader loader = new EasyLoader(new File(libraryAndModuleFolder));
	EasyPlugin easyPlugin = new EasyPlugin(loader, modulePackage);
	easyPlugin.startApplication();   
}
```