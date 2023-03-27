Benischke 12007588
Ewinger 12003351

# 1 Android App Components

_Before we write our first app, we have to get acquainted with the basic building blocks of Android Apps. Study the lecture slides and the official Android Guide_

_[(](https://developer.android.com/guide/components/fundamentals)[https://developer.android.com/guide/components/fundamentals](https://developer.android.com/guide/components/fundamentals)[)](https://developer.android.com/guide/components/fundamentals) to get an overview and answer the following questions:_

□ **What are the four types of app components and what is their purpose?**

- **Aktivitäten (Activities)**:

Aktivitäten repräsentieren die Benutzeroberfläche (UI) einer Anwendung. Sie bieten ein Fenster für die Benutzeroberfläche, um mit dem Benutzer zu interagieren, und sie können verwendet werden, um verschiedene Bildschirme einer App anzuzeigen, wie z. B. einen Anmeldebildschirm, ein Hauptmenü oder einen Einstellungsbildschirm.

- **Dienste (Services)**:

Dienste sind Hintergrundprozesse, die ohne UI ausgeführt werden. Sie werden verwendet, um langwierige Operationen durchzuführen, wie z. B. Musik abspielen, Dateien herunterladen oder Daten synchronisieren. Sie können auch ausgeführt werden, wenn die App nicht im Vordergrund ist, und sie können über Messaging-Mechanismen mit anderen App-Komponenten kommunizieren.

- **Broadcast-Empfänger (Broadcast Receivers):**

Broadcast-Empfänger werden verwendet, um systemweite Broadcast-Nachrichten zu empfangen und darauf zu reagieren. Diese Nachrichten können vom System oder von anderen Apps stammen und Ereignisse in der App auslösen, wie z. B. die Aktualisierung der Benutzeroberfläche oder das Starten eines Dienstes.

- **Content-Provider:**

Content Provider verwalten einen gemeinsamen Satz von App-Daten, auf die andere Apps oder Komponenten zugreifen können. Sie bieten eine standardisierte Schnittstelle für die Speicherung und Abfrage von Daten und können verwendet werden, um Daten zwischen verschiedenen Apps zu teilen oder eine Backup- und Wiederherstellungsfunktion für Daten bereitzustellen.

□ **Does an app need to define one unique entry point, or can it have multiple ones?**  **How does the underlying paradigm differ from desktop applications?**

In der Android-Entwicklung kann eine App mehrere Einstiegspunkte haben. Jeder Einstiegspunkt wird durch eine Aktivität dargestellt, und eine App kann mehrere Aktivitäten haben.

Beispielsweise könnte eine Musikplayer-App eine Aktivität zum Anzeigen der Wiedergabeliste, eine weitere Aktivität zum Abspielen einzelner Songs und noch eine weitere Aktivität zum Verwalten der Musikbibliothek des Benutzers aufweisen. Jede dieser Aktivitäten kann separat gestartet werden, je nachdem, was der Benutzer tun möchte.

Im Gegensatz dazu haben herkömmliche Desktop-Anwendungen normalerweise einen einzigen Einstiegspunkt, normalerweise in Form einer ausführbaren Datei. Sobald die Anwendung gestartet ist, öffnet sie typischerweise ein Hauptfenster oder eine Benutzerschnittstelle, von der aus dem Benutzer auf verschiedene Merkmale oder Funktionen der Anwendung zugreifen kann.

□ **What is the difference between explicit and implicit Intents?**

Ein „Intent" ist ein Objekt, das eine bestimmte Aktion beschreibt, die ausgeführt werden soll, wie z.B. eine Aktivität starten, eine Nachricht senden oder eine Datei öffnen.

Eine **explizites Intent** wird verwendet, um eine bestimmte Komponente innerhalb derselben Anwendung zu starten, z. B. das Starten einer neuen Aktivität oder eines neuen Dienstes innerhalb der App. Beim Erstellen einer **expliziten Intent** gibt der Entwickler den Namen oder die Klasse der Zielkomponente an und das System startet diese Komponente direkt.

Wenn eine App beispielsweise zwei Aktivitäten namens „MainActivity" und „SettingsActivity" hat, kann ein expliziter Intent verwendet werden, um die „SettingsActivity" direkt aus der „MainActivity" zu starten, indem der Klassenname der Zielaktivität im Intent angegeben wird.

Andererseits wird ein **impliziter Intent** verwendet, um eine Aktion von einer anderen Komponente anzufordern, die zu derselben Anwendung gehören kann oder nicht. Der Entwickler gibt die auszuführende Aktion an, und das System sucht nach der geeigneten Komponente, die diese Aktion ausführen kann.

□ **What is the "application context" and what is the role of the class "R"?**

In der Android-Entwicklung ist der „ **application context**" ein globaler Kontext für die gesamte Anwendung, der Zugriff auf Ressourcen und Einstellungen auf Anwendungsebene bietet. Auf den Anwendungskontext kann über die Methode "getApplicationContext()" zugegriffen werden, die ein Kontextobjekt zurückgibt, das den Anwendungskontext darstellt.

Android R.java ist eine automatisch generierte Datei von aapt (Android Asset Packaging Tool), die Ressourcen-IDs für alle Ressourcen des res/-Verzeichnisses enthält.

2 The mother of all programs: Hello World!

_This simple program is traditionally used to get in touch with a programming language's syntax for the first time. It is also useful as sanity check to test if all requirements, like compilers, paths, dependencies, and so on are in place._

□ Write a simple Hello World program in Kotlin for Android

□ Run it on an emulated device

□ (optional) Run it on your own Android Smartphone (= Physical Device)

□ Investigate the content of your AndroidManifest.xml and explain its components.

\<application\>: This element contains information about the application, including its components and settings.

**a. android:allowBackup="true":** Dieses Attribut ermöglicht der Anwendung die Teilnahme am Sicherungs- und Wiederherstellungsframework von Android.

**b. android:dataExtractionRules="@xml/data\_extraction\_rules":** Dieses Attribut gibt die Datenextraktionsregeln an, die die Anwendung verwendet, um Daten während Sicherungs- und Wiederherstellungsvorgängen zu extrahieren.

**c. android:fullBackupContent="@xml/backup\_rules":** Dieses Attribut gibt die Sicherungsregeln an, die die Anwendung verwendet, um zu bestimmen, welche Daten in den Sicherungsvorgang eingeschlossen werden sollen.

**d. android:icon="@mipmap/ic\_launcher":** Dieses Attribut gibt das Anwendungssymbol an, das im Launcher angezeigt wird.

**e. android:label="@string/app\_name":** Dieses Attribut gibt den Namen der Anwendung an, der dem Benutzer angezeigt wird.

**f. android:supportsRtl="true":** Dieses Attribut gibt an, ob die Anwendung ein Layout von rechts nach links unterstützt.

**g. android:theme="@style/Theme.UE\_2":** Dieses Attribut gibt das von der Anwendung verwendete Design an.

**h. tools:targetApi="31":** Dieses Attribut gibt die Ziel-API-Ebene für die Anwendung an.

**\<activity\>:** Dieses Element definiert eine Aktivität in der Anwendung.

**a. android:name=".MainActivity":** Dieses Attribut gibt den Namen der Aktivität an.

**b. android:exported="true":** Dieses Attribut gibt an, ob auf die Aktivität von anderen Anwendungen zugegriffen werden kann.

**c. \<intent-filter\>:** Dieses Element gibt den Intent-Filter für die Aktivität an.

i. \<action android:name="android.intent.action.MAIN" /\>: Dieses Element gibt an, dass die Aktivität der Haupteinstiegspunkt für die Anwendung ist.

ii.\<category android:name="android.intent.category.LAUNCHER" /\>: Dieses Element gibt an, dass die Aktivität im Launcher angezeigt werden soll.

□ Add at least one additional language in your hello world program (e.g., german →"Hallo Welt") and switch the displayed language on your device.

[(](https://developer.android.com/training/basics/supporting-devices/languages)[https://developer.android.com/training/basics/supporting](https://developer.android.com/training/basics/supporting-devices/languages)[devices/languages](https://developer.android.com/training/basics/supporting-devices/languages)[)](https://developer.android.com/training/basics/supporting-devices/languages)

# 3 Logging and Debugging

Basic logging functionality is provided by the Class android.util.Log. ([https:/](https://developer.android.com/reference/android/util/Log)[/](https://developer.android.com/reference/android/util/Log)[developer.android.com/reference/android/util/Log](https://developer.android.com/reference/android/util/Log)[)](https://developer.android.com/reference/android/util/Log)

□ Extend your Hello World program with rudimental logging functionality. Write several log messages with different verbosity levels to Logcat and explain the output.

□ Logs are supportive during development but more important for debugging problems and errors of released applications. Think about different purposes of logging for software development and software in productive use. Name pros and cons of logging for those operational purposes. Investigate logging mechanisms to implement these varying logging objectives.

In der Softwareentwicklung wird die Protokollierung hauptsächlich zu **Debugging** - und **Testzwecken** verwendet. Entwickler verwenden Protokolle, um den **Ablauf des Programms** zu verfolgen, **potenzielle Probleme** zu identifizieren und **Fehler** zu beheben. Protokolle können auch verwendet werden, um zu überprüfen, ob sich das Programm wie erwartet verhält, und um Leistungs- und Nutzungsstatistiken zu überwachen.

**Vorteile der Anmeldung bei der Softwareentwicklung:**

- Hilft bei der Identifizierung und Behebung von Fehlern und Problemen während der Entwicklung.
- Bietet Einblick in das Verhalten, den Zustand und die Leistung des Programms.
- Hilft Entwicklern, den Ablauf des Programms und seinen Ausführungspfad zu verstehen.
- Kann verwendet werden, um Nutzungsstatistiken und Leistungsmetriken während der Entwicklung zu überwachen.

**Nachteile der Anmeldung bei der Softwareentwicklung:**

- Kann erhebliche Ressourcen verbrauchen, insbesondere wenn die Protokollierung auf einer hohen Detailebene aktiviert ist.
- Kann die Ausführung des Programms verlangsamen, insbesondere wenn die Protokollierung synchron erfolgt.
- Kann vertrauliche Informationen wie Kennwörter oder Benutzerdaten preisgeben, wenn die Protokollierung nicht ordnungsgemäß gesichert ist.

**Es gibt mehrere Mechanismen zum Implementieren der Protokollierung, darunter:**

- Verwenden einer Protokollierungsbibliothek wie Log4j oder SLF4J, die eine standardisierte Protokollierungs-API bereitstellt und so konfiguriert werden kann, dass Protokolle an verschiedene Ziele wie Dateien oder Datenbanken geschrieben werden.
- Verwenden der Protokollierungsfunktion, die von der Programmiersprache oder dem Framework bereitgestellt wird, z. B. die Log-Klasse in Android oder das Protokollierungsmodul in Python.

□ Build the application as debug variant and deploy it to the emulator / device.

□ Build the application as release variant. Are there additional requirements for the deployment? If so, describe and carry out the necessary steps.

# 4 Android Activity Lifecycle

T ![](RackMultipart20230327-1-yor495_html_8c6237c1949e79b5.png) he Android activity life cycle consists of several states as shown in the figure on the right.

□ Implement an app that overrides all lifecycle callbacks.

**onCreate():** Diese Methode wird aufgerufen, wenn die Aktivität erstellt wird. Hier können die Benutzeroberfläche der App initialisiert werden, Daten aus einer Datenbank oder einem Server laden und andere wichtige Aufgaben durchführen, die beim Start der App ausgeführt werden müssen.

**onStart():** Diese Methode wird aufgerufen, wenn die Aktivität sichtbar wird, aber noch nicht im Vordergrund steht. Hier könnten zum Beispiel Ressourcen wie Kamera, Bluetooth, GPS initialisiert werden.

**onResume():** Diese Methode wird aufgerufen, wenn die Aktivität im Vordergrund sichtbar wird. Hier könnten zum Beispiel Animationen starten oder Audio- oder Video-Streams abgespielt werden.

**onPause():** Diese Methode wird aufgerufen, wenn eine andere Aktivität im Vordergrund sichtbar wird oder wenn der Benutzer das Gerät sperrt. Hier sollten alle Ressourcen freigeben, die nicht mehr benötigt werden, wie z.B. die Kamera.

**onStop():** Diese Methode wird aufgerufen, wenn die Aktivität nicht mehr sichtbar ist. Hier könnten zum Beispiel Ressourcen wie GPS, Bluetooth oder andere Hardwareressourcen freigeben werden.

**onDestroy():** Diese Methode wird aufgerufen, wenn die Aktivität vollständig zerstört wird. Hier sollten alle Ressourcen freigeben werden, die noch offen sind oder die von der Aktivität erstellt wurden.

**onRestart():** Diese Methode wird aufgerufen, wenn die Aktivität nach einem Stopp wieder gestartet wird.

□ Furthermore, the application should log a meaningful message whenever a new state becomes active.

□ Investigate under which circumstances the current state changes to the subsequent state.

**onCreate() -\> onStart():** Der Zustand ändert sich von „erstellt" nach „gestartet", wenn die Methode onStart() aufgerufen wird. Dies kann passieren, wenn die Aktivität sichtbar wird, aber noch nicht im Vordergrund steht, beispielsweise wenn der Benutzer zu einer anderen App wechselt.

**onStart() -\> onResume():** Der Zustand ändert sich von „gestartet" zu „fortgesetzt", wenn die Methode onResume() aufgerufen wird. Dies kann passieren, wenn die Aktivität in den Vordergrund tritt und interaktiv wird.

**onResume() -\> onPause():** Der Zustand ändert sich von „resume" zu „paused", wenn die Methode onPause() aufgerufen wird. Dies kann passieren, wenn die Aktivität den Fokus verliert oder wenn eine andere Aktivität in den Vordergrund tritt.

**onPause() -\> onStop():** Der Zustand wechselt von „paused" auf „stopped", wenn die Methode onStop() aufgerufen wird. Dies kann passieren, wenn die Aktivität nicht mehr sichtbar ist, z. B. wenn der Benutzer zu einer anderen App wechselt oder zum Startbildschirm geht.

**onStop() -\> onRestart():** Der Zustand wechselt von „gestoppt" auf „neu gestartet", wenn die Methode onRestart() aufgerufen wird. Dies kann passieren, wenn die Aktivität nach dem Stoppen neu gestartet wird, z. B. wenn der Benutzer von einer anderen App oder vom Startbildschirm zurück zur Aktivität navigiert.

**onRestart() -\> onStart():** Der Zustand ändert sich von „restarted" auf „started", wenn die Methode onStart() aufgerufen wird. Dies kann passieren, wenn die Aktivität nach einem Neustart gestartet wird.

**onStop() -\> onDestroy():** Der Zustand wechselt von „stopped" auf „destroyed", wenn die Methode onDestroy() aufgerufen wird. Dies kann passieren, wenn die Aktivität zerstört wird, z. B. wenn der Benutzer die Aktivität beendet oder wenn das System wenig Arbeitsspeicher hat und Ressourcen freigeben muss.

□ Extend your app by a second Activity that also logs each state change. Both Activities should show a button that allows the user to switch to the other Activity.