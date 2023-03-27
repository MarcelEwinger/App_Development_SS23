```
Benischke 12007588
Ewinger 12003351
```
```
ASSIGNMENT 01
Due date: 2023/03/14|
```
```
Aim: Familiarization with Kotlin and tools for Android app development.
```
# 1 Simple Kotlin Example

Implement the following example:
Write a classVehicle that consist of following member variables:

```
Variable
private int id
private String name
private Brand brand
private ArrayList<Workshop> workshops
private int weight
private int maxPermissableWeight
private double speed
private double maxSpeed
```
BrandandWorkshopare also classes. They manage information about the brand
of the vehicle or about authorized workshops where a vehicle can be repaired.
The classBrandhas following member variables:

```
Variable
private String name
private String country
private String phone
private String email
```
```
The instance variables of theWorkshopclass are as follows:
```
```
Variable
private String name
private String country
private int postcode
private String city
private String street
private String phone
```

Implement all classes. Try different variations of primary constructors, if neces-
sary, secondary contructors, default values, properties, inheritance, ....
Implement following methods in the classVehicle:

```
Method Behavior / Purpose
fun accelerate(): double Increases the current speed (speed) by the value
10, provided that the maximum speed of the vehi-
cle (maxSpeed) is not exceeded. The new speed is
returned.
fun brake(): double Reduces the current speed by the value 10,
whereby the speed must not be less than 0. The
new speed is returned.
fun drive(kilometers: int) Simulates driving a vehicle over a given route. The
accelerate() or brake() method should be called
three times for each kilometer traveled.
fun printInfo() Outputs all available information (values of the in-
stance variables) on the screen.
fun getWorkshop(postcode: int):
Workshop
```
```
Returns an authorized workshop with the given zip
code.
```
Test your classes by implementing aMainclass including the main() method,
creating a few vehicles and “driving” a few kilometers with them.
It is recommended to use IdeaJ (https://www.jetbrains.com/idea/as devel-
opment environment. Information about Kotlin and its syntax can be found at
https://kotlinlang.org/, in the Docs link on this page and the Kotlin slides
in Moodle. Moreover it might be helpful to make some warm-up excercises from
https://developer.android.com/kotlin/learn.

# 2 Android Studio

Android Studio is an integrated development environment (IDE) for the development
of applications for Google’s Android OS. It is based on IntelliJ IDEA software from
JetBrains. Android Studio supports several programming languages including Kotlin
since version 3.0. Currently, Android Studio Electric Eel | 2022.1.1 Patch 2 is
available for Windows, macOS and Linux.

```
□ Install Android Studio in your OS
Have a look athttps://developer.android.com/studio/install
```
```
□ Create sample projects withFile > New > New Projectand inspect:
```
- Resource Manager Window
  -  A tool window called Resource Manager is used to import, create, manage, and use resources in the project. Choose Resource Manager in the left sidebar or from the menu by choosing View > Tool Windows > Resource Manager.
- Project Window
  - This page provides an overview of the key components inside the project.
    View > Tool > Project
    by Default: Android View
- Structure Window

   - Übersicht über die Struktur der geöffneten Datei
    Links unten oder View > Tool Windows > Structure
# 3 Android Emulator

```
□ Install the Android Emulator
```
```
□ Optional: Enable hardware acceleration
  □ Android Virtual Device > Show Advanced Settings > Graphics: Hardware - GLES 2.0
```
```
□ Launch the Android Emulator
```
```
□ Create and manage virtual devices with different properties
□ Explore how to perform basic control actions with preinstalled apps
□ Explore how to use extended controls (location, displays, sensors,... )
  with preinstalled apps
    □ Extended Controls
```
```
□ Explore Logcat
```
```
□ Get familiar with the Logcat window in Android Studio
□ Explain the purpose of logcat and how messages can be filtered
    □ Logcat ist ein Befehlszeilentool, das Systemmeldungen anzeigt, einschließlich derer, 
      die von Android-Apps generiert werden, und verwendet wird zum Debuggen und Beheben von 
      Fehlern bei Android-Anwendungen. Android Studio bietet eine grafische Oberfläche zum
      Anzeigen von Logcat-Meldungen. adurch wird es für Entwickler einfacher Probleme in Apps
      zu diagnostizieren und zu beheben. Der Zweck von Logcat in Android Studio besteht darin, 
      Nachrichten anzuzeigen, die von Android generiert werden Betriebssystem und Anwendungen, 
      die auf dem Gerät oder Emulator ausgeführt werden. Diese Nachrichten können verwendet werden
      von Entwicklern, um Fehler aufzuspüren oder Probleme mit ihrer App zu diagnostizieren.
      Meldungen in Logcat sind in verschiedene Kategorien eingeteilt, z. B. „verbose“, „debug“, „info“, „warning“.
      und Fehler. Standardmäßig werden alle Meldungen im Logcat-Fenster angezeigt. Jedoch,
      Entwickler können die in Logcat angezeigten Nachrichten filtern, indem sie verschiedene Optionen wie Tag, Priorität,
      und Freitext auswählen.
```
```
□ Inspect the Device File Explorer Window in Android Studio
   □ Ansicht > Werkzeugfenster > Gerätedatei durchsuchen
   Android Studio speichert Dateien, die Sie im Gerätedatei-Explorer öffnen, in einem temporären
   Verzeichnis außerhalb des Projekts. Wenn Sie Änderungen an einer geöffneten Datei vornehmen
   den Gerätedatei-Explorer verwenden und Ihre Änderungen wieder auf dem Gerät speichern möchten,
   Sie müssen die geänderte Version der Datei manuell auf das Gerät hochladen.
```
# 4 Command line tools and Gradle

## 4.1 Command line tools

Explain the aim of following command line tools and explain their most important
purpose:

```
□ apkanalyzer
    https://developer.android.com/studio/command-line/apkanalyzer
    Build > APK analysieren
    Das apkanalyzer-Tool ist ein Befehlszeilentool, das mit dem Android SDK geliefert wird. 
    Es bietet eine Vielzahl von Funktionen zum Analysieren von APK-Dateien, einschließlich 
    Extrahieren von Informationen über den Inhalt der APK, Vergleichen zweier APK-Dateien
    und Prüfen des Inhalts einer bestimmten Datei innerhalb einer APK.
    Einige der wichtigsten Anwendungen von apkanalyzer sind:
    - Analysieren der Größe und des Inhalts einer APK, um Wege zu finden, sie für kleinere 
      Downloadgrößen oder schnellere Ladezeiten zu optimieren.
    - Vergleichen von zwei APK-Dateien, um Unterschiede zwischen ihnen zu identifizieren, z. B.
      Änderungen im Code oder in Ressourcen.
    - Untersuchen des Inhalts bestimmter Dateien innerhalb eines APKs, z. B. Layoutdateien oder Ressourcendateien
```
```
□ adb
    First download adb: https://developer.android.com/studio/releases/platform-tools
    https://developer.android.com/studio/command-line/adb
    Die Android Debug Bridge (ADB) ist ein Befehlszeilentool, mit dem Entwickler kommunizieren können
    mit einem Android-Gerät oder Emulator über eine USB-Verbindung. Es bietet eine Vielzahl von Funktionen
    zum Debuggen und Testen von Android-Anwendungen, einschließlich:
    - Installieren und Deinstallieren von Apps auf einem verbundenen Gerät oder Emulator.
    - Ausführen von Shell-Befehlen auf einem angeschlossenen Gerät oder Emulator.
    - Aufnehmen von Geräte-Screenshots oder -Videos.
    - Zugreifen auf und Ändern von Geräte- oder Emulatoreinstellungen.

    Einige der wichtigsten Anwendungen von adb sind:

    - Testen einer App auf einem physischen Gerät oder Emulator, damit Entwickler sehen können, wie die
      App verhält sich unter realen Bedingungen.
    - Debuggen einer App durch Erfassen von Protokollen, Verfolgen von Methodenaufrufen und Festlegen von Haltepunkten.
    - Benchmarking einer App, um Leistungsengpässe und Optimierungsbereiche zu identifizieren.
```
```
□ lint
    https://developer.android.com/studio/write/lint
    Android View > app > Right Mouse Push > Analyze > Inspect Code -> Whole Project
    lint ist ein statisches Analysetool, das in Android Studio integriert und ebenfalls verfügbar ist
    als Kommandozeilentool. Es überprüft den Code auf potenzielle Probleme oder Fehler, z. B. Speicherlecks,
    Leistungsprobleme und Sicherheitslücken. Einige der wichtigsten Verwendungszwecke von Flusen sind:
    - Identifizieren potenzieller Leistungsprobleme in einer App, z. B. ineffizientes Layout oder Ressourcennutzung.
    - Aufzeigen potenzieller Sicherheitslücken, wie z. B. ungesicherte Netzwerkverbindungen oder sensible Datenspeicherung.
    - Sicherstellen, dass eine App den Best Practices und Richtlinien für die Android-Entwicklung entspricht, z. B. die Verwendung der richtigen Benennung
        Konventionen oder das Vermeiden veralteter APIs.
```
## 4.2 Gradle

Gradle is used as build system in Android Studio. Android studio automatically
generates gradle build files. These build files might be sufficient for small projects
but must be manually edited for release builds or more complex software.

```
□ Get a closer look at gradle and describe the terms, e.g., build type, product
flavor, build variants, dependencies, multi APKs.
    Gradle ist ein Open-Source-Build-Automatisierungstool, das zur Automatisierung des Build-Prozesses von Softwareprojekten verwendet wird.
    Es wird häufig zum Erstellen von Android-Anwendungen verwendet und unterstützt verschiedene Funktionen wie Build-Typen, Produktvarianten,
     Build-Varianten, Abhängigkeiten und Multi-APKs. 
     
    - Build-Typ: Build-Typen sind verschiedene Versionen der Anwendung, die jedoch aus demselben Quellcode erstellt werden
      mit unterschiedlichen Konfigurationen. Zu den gängigen Build-Typen gehören „Debug“- und „Release“-Builds. Debug-Builds werden verwendet für
      Testen und Debuggen, während Release-Builds für die Verteilung an Endbenutzer optimiert sind.

    - Produktvariante: Produktvarianten werden verwendet, um verschiedene Versionen Ihrer Anwendung mit unterschiedlichen Funktionen zu erstellen
      oder Eigenschaften. Beispielsweise hat man möglicherweise eine kostenlose Version und eine kostenpflichtige Version der App mit jeweils unterschiedlichen Produktvarianten.

    - Build-Variante: Eine Build-Variante ist eine Kombination aus einem Build-Typ und einem Produkt-Flavor. Dadurch können Sie verschiedene Versionen erstellen
      Ihrer Anwendung mit unterschiedlichen Funktionen und Konfigurationen.

    - Abhängigkeiten: Abhängigkeiten sind externe Bibliotheken oder Module, auf die Ihre Anwendung angewiesen ist. Gradle kann automatisch herunterladen und verwalten
      diese Abhängigkeiten.

    - Multi-APKs: Mit Multi-APKs können Sie mehrere Versionen der Anwendung erstellen, die für verschiedene Geräte oder Konfigurationen optimiert sind.
      Beispielsweise können Sie separate APKs für unterschiedliche Bildschirmgrößen oder CPU-Architekturen erstellen.
```
```
□ Describe the build process that converts a project into an Android Application
Package (APK).
    - Kompilierung: Der erste Schritt besteht darin, den Quellcode in Dalvik-Bytecode zu kompilieren. Dies geschieht mit dem Java-Compiler und den Android-Build-Tools.

    - Ressourcenverarbeitung: Die Android-Build-Tools verarbeiten die Anwendungsressourcen wie Bilder und XML-Layoutdateien und generieren binäre XML-Dateien, die von der Anwendung zur Laufzeit verwendet werden können.

    - Verpackung: Der kompilierte Bytecode und die verarbeiteten Ressourcen werden zusammen in einer Android-Paketdatei (APK) verpackt. Diese Datei enthält alle erforderlichen Komponenten der Anwendung, einschließlich Code, Ressourcen und Manifestdatei.

    - Signieren: Bevor das APK auf einem Gerät installiert werden kann, muss es mit einem Zertifikat signiert werden, um seine Authentizität sicherzustellen. Dies erfolgt mit der Android Studio IDE oder den Befehlszeilentools.

    - Zipaligning: Nach dem Signieren des APK optimieren die Android-Build-Tools es, indem sie die Binärdaten des APK an einer 4-Byte-Grenze ausrichten. Dies verbessert die Leistung der Anwendung, wenn sie auf einem Gerät installiert ist.

    - Installation: Sobald das APK signiert und optimiert ist, kann es mit dem Paketmanager auf einem Android-Gerät installiert werden.
```
```
□ Describe following files used in gradle: 
   - settings.gradle
     Diese Datei wird verwendet, um die Module oder Teilprojekte zu spezifizieren, die Teil des Gesamtprojekts sind.
     Es kann auch verwendet werden, um das Root-Projekt zu konfigurieren und Variablen zu definieren, die über alle Module hinweg verwendet werden können.
     Die Einstellungsdatei ist in Groovy geschrieben, und die Suche nach Submodulen kann angepasst werden.
        
   - build.gradle
     Diese Datei ist die Hauptkonfigurationsdatei für ein Projekt und definiert den Erstellungsprozess. Es spezifiziert die Abhängigkeiten, Plugins und Aufgaben
     die verwendet werden, um den Code zu kompilieren, die Anwendung zu packen und andere Build-bezogene Aufgaben auszuführen. Es ist in Groovy oder Kotlin geschrieben
     Programmiersprachen und können verwendet werden, um den Build-Prozess für bestimmte Build-Typen, Produktvarianten oder Build-Varianten anzupassen.
        
   - gradle.properties
     Diese Datei enthält Eigenschaften, mit denen das Verhalten des Gradle-Build-Systems angepasst werden kann. Es kann zur Definition verwendet werden
     Variablen, die in der build.gradle-Datei verwendet werden, z. B. die Version des Android-Gradle-Plugins oder der Speicherort des Java-SDK. Es kann auch verwendet werden
     um den Build-Cache zu konfigurieren, die Protokollierung zu steuern und Funktionen wie die parallele Build-Ausführung zu aktivieren/deaktivieren.
```

