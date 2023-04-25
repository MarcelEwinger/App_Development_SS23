```
Benischke 12007588
Ewinger 12003351
```
```
ASSIGNMENT 03
Due date: 2023/04/25|26
```
```
Aim: Becoming acquainted with Android
```
# 1 Rotation & Explicit/Implicit Intents

- Create an activity with a text input field for entering a street address.

- Run the app, enter some value into the input field and rotate the device (Hint:
make sure that auto-rotation is enabled)

  -  Run the app, enter some value into the input field and rotate the device (Hint:
    make sure that auto-rotation is enabled)

    - Does the rotation affect the value of the input field? Why (not)?
    
    
      Standardmäßig bewahrt Android den Zustand einer Aktivität und ihrer Ansichten während einer Konfigurationsänderung (z. B. einer Bildschirmdrehung), indem es ihren aktuellen Zustand in einem Bundle speichert und ihn dann wiederherstellt, wenn die Aktivität neu erstellt wird. Das bedeutet, dass der in ein Eingabefeld eingegebene Text auch nach der Drehung noch vorhanden ist.

      (Wenn ein Bildschirm in Android gedreht wird, wird die aktuelle Aktivität zerstört und eine neue Aktivität im neuen Bildschirmorientierung erstellt. In diesem Prozess wird die Methode onSaveInstanceState() der aktuellen Aktivität aufgerufen, um ein Bundle-Objekt zu erstellen und darin alle wichtigen Daten zu speichern, die für die Wiederherstellung der Aktivität benötigt werden.
      
  - Edit the activity’s layout and temporarily remove the android:id attribute
    from the input field. Does the behavior change? Why (not)?
    
    Wenn man vorübergehend das android:id-Attribut aus einem Eingabefeld im Layout der Aktivität in Android Studio entfernen, ändert sich das Verhalten des Eingabefeldes selbst nicht. Dies liegt daran, dass das android:id-Attribut zur eindeutigen Identifizierung des Eingabefelds verwendet wird, aber nicht erforderlich ist, damit das Eingabefeld ordnungsgemäß funktioniert.

    Das Entfernen des android:id-Attributs verhindert jedoch, dass das Eingabefeld in dem Code mit der findViewById-Methode direkt referenzieren kann.
    
  - Is there a different way to influence the behavior of your activity for such
    "configuration changes"?
    
    Ja, es gibt verschiedene Möglichkeiten, das Verhalten der Aktivität bei Konfigurationsänderungen in Android zu beeinflussen. Ein gängiger Ansatz ist die Verwendung der Methoden onSaveInstanceState() und onRestoreInstanceState() zum Speichern und Wiederherstellen des Zustands Ihrer Aktivität bei Konfigurationsänderungen, z. B. wenn das Gerät gedreht wird.

    Wenn das Gerät gedreht wird, erstellt Android die Aktivität neu und zerstört die alte Aktivität. Die onSaveInstanceState-Methode wird kurz vor der Zerstörung der alten Aktivität aufgerufen und ermöglicht es, alle wichtigen Daten oder Statusinformationen über die Aktivität in einem Bundle-Objekt zu speichern. Dieses Bundle-Objekt wird an die onCreate-Methode der neuen Aktivitätsinstanz weitergegeben, wenn diese neu erstellt wird.
    

  - Explore what other mechanism Android offers to save and restore an
    activity’s state.
    
    1. SharedPreferences: Hierbei handelt es sich um einen Key-Value-Speichermechanismus, mit dem Sie kleine Datenmengen, z. B. Einstellungen oder Präferenzen, in einem dauerhaften Speicher ablegen können.

    2. SQLite-Datenbanken: Wenn die Anwendung größere Mengen an strukturierten Daten speichern muss, können Sie eine SQLite-Datenbank verwenden, um den Zustand Ihrer Aktivität zu speichern und wiederherzustellen. Dies kann besonders nützlich sein, wenn Ihre Anwendung Daten speichern muss, die zu groß oder zu komplex sind, um in SharedPreferences gespeichert zu werden.

    3. External Storage
    

- Implement a button that forwards the value of the text field to a second
activity. Display the value in a readonly text field.

- Implement a button in the second activity that launches Google Maps and
jumps to the location that you specified in the input field.

- Following links might be helpful:
  - https://developer.android.com/guide/components/intents-common#ViewMap
  - https://developer.android.com/guide/topics/manifest/queries-element
  - https://developer.android.com/training/basics/intents/sending



# 2 Services
- Go to https://developer.android.com/guide/components/services and
answer the following questions:

  - What are services, when should they be used  and what is the difference
  to threads?

     
    In Android ist ein Service eine Komponente, die lang laufende Operationen im Hintergrund ausführen kann, ohne eine Benutzeroberfläche zu benötigen.

    Services werden oft verwendet, um Aufgaben auszuführen, die auch dann ausgeführt werden müssen, wenn der Benutzer nicht mit der App interagiert oder die App nicht im Vordergrund steht. Zum Beispiel kann eine Musikplayer-App einen Service verwenden, um Musik im Hintergrund abzuspielen, während der Benutzer andere Apps verwendet, oder eine Wetter-App kann einen Service verwenden, um die neuesten Wetterdaten im Hintergrund abzurufen.

    Services unterscheiden sich von Threads darin, dass ein Service eine Komponente ist, die im Hintergrund läuft und eine bestimmte Aufgabe ausführt, während ein Thread eine Ausführungseinheit innerhalb eines Prozesses ist. Threads werden verwendet, um Aufgaben innerhalb einer App parallel auszuführen, aber sie sind nicht dafür ausgelegt, unbegrenzt im Hintergrund zu laufen. Im Gegensatz dazu sind Services dafür ausgelegt, im Hintergrund zu laufen und können auch dann weiterlaufen, wenn die App, die sie gestartet hat, nicht mehr im Vordergrund steht. Darüber hinaus können Services auch dann ausgeführt werden, wenn das Gerät im Ruhezustand ist, während Threads angehalten werden, wenn das Gerät im Ruhezustand ist.
    ```
  - What are the steps to create a service?
    
    1. Zuerst wird eine neue Klasse erstellt, die die Service Klasse erweitert.

    2. Danach wird die Methode onStartCommand() in der Service-Klasse überschrieben. Diese Methode wird aufgerufen, wenn der Service gestartet wird, und sollte den Code enthalten, der die Aufgabe ausführt, für die der Service erstellt wurde.

    3. Deklaration des Serviceses in der AndroidManifest.xml Datei. Dadurch kann Android den Service erkennen und wissen, wie er gestartet werden kann.

    4. Starten des Service. Man kann den Service mit der startService()-Methode von einer Activity oder einem anderen Service aus starten. Alternativ kann man den Service automatisch starten lassen, wenn das Gerät startet, indem Sie einen BroadcastReceiver verwenden.

    5. Implementierung der erforderlichen  Methoden zur Verwaltung des Lebenszyklus des Service. Dazu gehören Methoden wie onCreate(), onDestroy() und onBind().

    6. Wenn Ihr Service nicht mehr benötigt wird, kann man ihn stoppen mit der stopService()-Methode.
    

  - What are the statuses of a service lifecycle?
     
    1. Created: Dies ist der Anfangszustand eines Services, wenn er erstellt wurde, aber noch nicht gestartet wurde.

    2. Started: Ein Service tritt in den gestarteten Zustand ein, wenn er durch Aufruf von startService() gestartet wird. Der Service wird weiterlaufen, bis er entweder durch Aufruf von stopService() gestoppt wird oder wenn er vom System gestoppt wird.

    3. Bound: Ein Service tritt in den gebundenen Zustand ein, wenn er durch bindService() an eine Client-Komponente gebunden wird. In diesem Zustand kann die Client-Komponente mit dem Service kommunizieren, indem sie seine Methoden aufruft.

    4. Background: Ein Service tritt in den Hintergrundzustand ein, wenn er nicht mehr im Vordergrund ist und keine Clients an ihn gebunden sind. In diesem Zustand kann der Service weiterlaufen, aber mit reduzierter Priorität.

    5. Destroyed: Ein Service tritt in den zerstörten Zustand ein, wenn er entweder durch Aufruf von stopService() gestoppt wird oder wenn das System ihn aufgrund von Speichermangelbedingungen zerstören muss.
    

- Implement a simple music player as a service component.

  - Write a simple service that plays a predefined audio file. You can copy
a mp3 file in the raw directory or use, e.g., an existing ringtone. Use
android.media.MediaPlayer for that task.

  - Override the necessary methods in your service.

  - Implement an activity that starts and stops the service. (Hint: you may
need two buttons for this functionality.)



# 3 Fragments
- Get yourself acquainted with Fragments by implementing a simple app that
demonstrates their basic usage. It should include the following steps:

  - Create two new Fragments
 
  - Dynamically add a Fragment by Code
  
  - Dynamically remove the Fragment and replace it with the other one
  
  - Communicate from host Activity to Fragment
  
  - Communicate from Fragment to host Activity

- Do some deeper research to answer the following question

  - What was the original intention for the introduction of Fragments?
    
    Die Einführung von Fragments hatte das Ziel, eine wiederverwendbare und modulare UI-Komponente zu schaffen, die es ermöglicht, Android-Apps auf verschiedenen Bildschirmgrößen und Geräten besser anzupassen. Mit Fragmenten können UI-Komponenten wie Aktivitäten in kleinere, unabhängige und wiederverwendbare Teile aufgeteilt werden, die innerhalb einer Aktivität dynamisch hinzugefügt, ersetzt oder entfernt werden können. Dadurch wird es einfacher, verschiedene Layouts und Interaktionsmuster in einer App zu implementieren und die Benutzerfreundlichkeit zu verbessern.
    
  - How are Fragments used in modern Android development?
    
    Fragments werden immer noch weit verbreitet in der modernen Android-Entwicklung verwendet, um flexible und wiederverwendbare UI-Komponenten zu erstellen. Sie werden oft eingesetzt, um komplexe UI-Layouts wie Master-Detail-Flows, tab-basierte Schnittstellen und Mehrbereichs-Layouts zu implementieren. Fragments werden auch in Verbindung mit ViewModels und LiveData verwendet, um das MVVM-Architekturmuster in Android-Apps umzusetzen.

    Ein Master-Detail-Flow ist ein Design-Pattern für mobile Apps, das in der Regel für die Darstellung von Listen- oder Tabellenansichten verwendet wird, die eine größere Anzahl von Einträgen enthalten. Bei einem Master-Detail-Flow wird auf einem größeren Bildschirmtyp, wie z.B. einem Tablet oder Desktop-Computer, eine Liste oder Tabelle von Einträgen angezeigt, während auf einem kleineren Bildschirmtyp, wie z.B. einem Smartphone, nur ein Eintrag auf einmal dargestellt wird. Wenn der Benutzer auf einen Eintrag klickt, wird eine detaillierte Ansicht dieses Eintrags angezeigt, die an der Seite des Listen- oder Tabellenlayouts angezeigt wird.
    
  - What does the term ‘Single Activity Architecture’ refer to and what are
  pros and cons of this concept? Do you see any similarities to modern
  Web development?
    
    "Single Activity Architecture" bezieht sich auf ein Konzept in der Android-Entwicklung, bei dem eine einzige Aktivität die gesamte Benutzeroberfläche der App verwaltet, während alle anderen Screens als Fragmente dargestellt werden. Dadurch wird vermieden, dass der Benutzer zwischen verschiedenen Aktivitäten hin und her wechseln muss, um verschiedene Screens anzuzeigen. Dies führt zu einer besseren Leistung und geringerem Speicherverbrauch.

    Ein Vorteil dieser Architektur ist, dass sie es Entwicklern erleichtert, komplexe Anwendungen zu erstellen und die Benutzerfreundlichkeit zu verbessern, indem sie die Navigation innerhalb der App vereinfachen. Ein weiterer Vorteil ist, dass die Wiederverwendbarkeit von Code verbessert wird, da viele Funktionen der App innerhalb einer einzigen Aktivität implementiert werden können.

    Ein Nachteil ist jedoch, dass es schwieriger werden kann, den Code und die Funktionalität der App zu organisieren und zu warten. Es kann auch schwierig sein, Abhängigkeiten zwischen den verschiedenen Komponenten der App zu verwalten, insbesondere wenn die App sehr groß wird.

    In der modernen Web-Entwicklung gibt es einige Ähnlichkeiten zur Single-Activity-Architektur. Hier wird oft ein Single-Page-Application (SPA)-Ansatz verwendet, bei dem eine einzige HTML-Seite geladen wird und die App-Logik in JavaScript geschrieben wird. Auch hier wird vermieden, dass der Benutzer zwischen verschiedenen Seiten oder URLs hin und her navigieren muss, um verschiedene Screens anzuzeigen.
     



# 4 Touch Control
Implement an application similar to Figure 1 or 2. When the button “Random Point”
is pressed, a small circle is shown at a random position on the screen. When the user
tries to touch the center of the circle, the application shows the distance between the
touch position and the circle center. Consider the following implementation hints:

- Define the Button and a SurfaceView inside your layout XML file. The Button
may be outside the SurfaceView (Figure 1 or inside the SurfaceView (Figure 2.

- Implement a callback function for the button that draws the circle on the
canvas of the SurfaceView at a random position.

- Override the “onTouchEvent” listener that reacts on the user’s touch activity
and calculate the distance between the given circle and the touch position.

- What are the main differences between the layout shown in Figure 1 and 2.
Do you find some pros and cons?

![Figure 1 & 2](C:\Programmieren\GitHub\App_Development_SS23\UE_3\media\pic.PNG "pic")