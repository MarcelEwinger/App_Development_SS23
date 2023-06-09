```
Benischke 12007588
Ewinger 12003351
```
```
UE App Development 623.9[51|52] SS 2023
Institute of Information Technology (ITEC) Primus|Münzer
```
## ASSIGNMENT 09

```
Due date: 2023/06/13|
```
```
Aim:Sensors.
```
# 1 Spirit Level

A Spirit Level (Wasserwaage) uses tubes with a liquid and a bubble to measure if an
object aligns horizontally or vertically.

```
□ Develop an application that uses the accelerometer sensor to calculate the level
of objects.
```
```
□ Visualize the level numerically.
```
```
□ Visualize the level simulating an actual bubble level.
```
# 2 GPS Sensor I

A unique selling point of mobile applications is the combination of computational
power, internet capabilities, and location awareness. Usehttps: // developers.
google. com/ maps/ documentation/ android-sdk as starting point.

```
□ Build a layout that consists of
```
```
□ two buttons: one to start tracking and one to end tracking
□ a textview that shows the current latitude and the longitude
□ a textview to show the tracked distance
□ a fragment (SupportMapFragment, used in the next task)
```
```
□ when tracking is started, periodically fetch the location data and show lati-
tude/longitude as well as the total distance in the textviews
```
# 3 GPS Sensor II

```
□ Get a Google Map API key fromhttps://console.cloud.google.comThe-
oretically, each API call will be charged. Currently, each API owner gets
approximately 28.000 API calls for free per month.
```
```
□ include Google Map View into your application
```
```
□ draw the track into the map
```



# 4 Broadcast Receivers

```
□ Study the documentation onhttps://developer.android.com/guide/components/
broadcaststo better understand the concept of broadcast receivers.

Ein BroadcastReceiver (Broadcast-Empfänger) ist eine Komponente in der Android-Entwicklung, 
die verwendet wird, um auf Systemereignisse oder benutzerdefinierte Broadcasts zu reagieren. 
Er ermöglicht es einer App, bestimmte Broadcast-Nachrichten von verschiedenen Quellen im System 
zu empfangen und darauf zu reagieren.
```
```
□ Implement a simple application that uses a broadcast receiver to observe and
log the battery level of the device.
```
```
□ Create a custom BroadcastReceiver class that obtains the current battery
level from the Intent object and logs it.
□ Register your receiver dynamically from the main activity. It should listen
to broadcasts regarding battery changes.
□ Ensure that the receiver only listens to these broadcasts while the activity
is visible.
```
```
□ Use the extended controls of the emulator to test your app
```
```
□ Explain the difference between manifest declaration and context registration.
Manifest:
- Deklaration in der Manifest-xml-Datei
- Der Receiver wird statisch und automatisch vom Android-System registriert, wenn 
die Anwendung installiert wird.
- Manifest-deklarierte Receiver können Broadcasts empfangen, auch wenn die Anwendung 
nicht im Vordergrund oder für den Benutzer sichtbar ist.

Context:
- Bei der Context-Registrierung wird der Broadcast-Receiver zur Laufzeit über einen 
bestimmten Kontext, z. B. eine Aktivität oder einen Service, dynamisch registriert.

- Bei der Context-Registrierung wird der Broadcast-Receiver zur Laufzeit über einen 
bestimmten Kontext, z. B. eine Aktivität oder einen Service, dynamisch registriert.

- Context-registrierte Receiver empfangen Broadcasts nur, wenn die zugehörige Komponente 
im Vordergrund oder für den Benutzer sichtbar ist.

- Wenn die Komponente nicht mehr sichtbar ist oder zerstört wird, wird der Receiver automatisch deaktiviert.

Statisch:
- Wenn Ihre Anwendung Broadcasts empfangen muss, unabhängig davon, ob die App im Vordergrund oder 
Hintergrund ausgeführt wird. Ein typisches Beispiel dafür ist das Empfangen des BOOT_COMPLETED-Broadcasts, 
um nach dem Neustart des Geräts bestimmte Aktionen auszuführen.

- Wenn Ihre Anwendung bestimmte Aktionen ausführen muss, auch wenn die App nicht geöffnet ist oder die 
Komponenten nicht aktiv sind. Beispielsweise möchten Sie möglicherweise den ACTION_POWER_CONNECTED-Broadcast 
verwenden, um spezifische Aktionen auszuführen, sobald das Gerät an das Netzteil angeschlossen wird.

Dynamisch:
- Wenn Ihre Anwendung den Broadcast-Receiver nur benötigt, wenn eine bestimmte Aktivität oder ein 
bestimmter Dienst aktiv und sichtbar ist. Dies spart Ressourcen, da der Receiver deaktiviert wird, 
wenn die Komponente nicht sichtbar ist.

- Wenn Ihre Anwendung spezifische Aktionen basierend auf bestimmten Broadcasts in einer bestimmten 
Aktivität oder einem bestimmten Dienst durchführen soll. Zum Beispiel möchten Sie möglicherweise den 
ACTION_BATTERY_CHANGED-Broadcast in einer Aktivität anzeigen, die den Batteriestand des Geräts überwacht und aktualisiert.
```
```
□ Could we also register this receiver in the Manifest? Why (not)?
Um den BroadcastReceiver in der Manifest hinzuzufügen, muss man die
entsprechende "receiver" Deklaration erstellen.
 <receiver
            android:name=".BatteryLevelReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.BATTERY_CHANGED" />
            </intent-filter>
        </receiver>
```



