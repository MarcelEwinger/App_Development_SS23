```
UE App Development 623.9[51|52] SS 2023
Institute of Information Technology (ITEC) Primus|Münzer
```
```
ASSIGNMENT 08
Due date: 2023/06/06|
```
```
Aim:Better Look and Feel for User- and Developer-experience.
```
# 1 Themes and Styles

Themes and Styles should be used to separate the details of the visual appearance of
the application from its structure and behavior.

```
□ Describe the difference between Androids’StylesandThemes. How are they
used? What are they used for?
Eine Style ist eine Sammlung von Attributen, die das Erscheinungsbild einer 
einzelnen Ansicht festlegen. Ein Stil kann Attribute wie Schriftfarbe, 
Schriftgröße, Hintergrundfarbe und vieles mehr festlegen.

Ein Theme ist eine Sammlung von Attributen, die auf eine gesamte Anwendung, Aktivität
oder Ansichtshierarchie angewendet wird - nicht nur auf eine einzelne Ansicht.
```
```
□ Give an application of your choice a different look and feel with
```
```
□ at least two different styles.
□ at least two different themes.
```
```
□ Explain Androids’ ‘Style Hierarchy‘.
Android bietet eine Vielzahl von Möglichkeiten zum Festlegen von
Attributen in Ihrer Android-App. Sie können zum Beispiel Attribute
direkt in einem Layout festlegen, einen Stil auf eine Ansicht anwenden,
ein Design auf ein Layout anwenden und sogar Attribute programmatisch festlegen.
1. Anwenden von Styling auf Zeichen- oder Absatzebene unter Verwendung von
Textabschnitten auf von TextView abgeleitete Klassen.

2. Programmatische Anwendung von Attributen.

3. Einzelne Attribute direkt auf eine Ansicht anwenden.

4. Anwenden eines Stils auf eine Ansicht.

5. Default styling

6. Anwenden eines Designs auf eine Sammlung von Ansichten, eine Aktivität oder Ihre gesamte Anwendung.

7. Anwenden bestimmter ansichtsspezifischer Stile, wie z. B. das Festlegen eines TextAppearance für eine TextView.
```
# 2 Animation with Motion Layout

Implement following simple behaviour using Motion Layout:

```
□ Initially the layout shows only a button in the center of the screen with a label
“Show” on it.
```
```
□ If the user clicks the button, the button moves down and a text is shown in
the middle of the screen (e.g., DSVGO or Lorem ipsum). If the text is shown,
the button’s label changes to “Hide”.
```
```
□ If the user now clicks on the button, the long text dissappears and the button
moves to its initial possion showing its label “Show” again.
```



# 3 Jetpack Navigation

Jetpack Navigation is a powerful framework provided by Google that simplifies seam-
less app navigation in Android development. By utilizing navigation graphs, desti-
nations, actions, and deep linking, developers can create intuitive and user-friendly
navigation flows. In this exercise, you will implement a simple app using Jetpack
Navigation, following the provided requirements:

```
□ The app should consist of three destinations:
```
```
□ Home screen: Displays a list of items (be creative about the type of items)
□ Detail screen: Shows more specific details of a selected item
□ Edit screen: Allows rudimental editing of these details
```
```
□ Define appropriate actions to navigate between these destinations.
```
```
□ Use Safe Args to pass data securely.
```
```
□ Additionally, implement transition effects for the navigation to enhance the
user experience.
```
```
□ For more information on Jetpack Navigation, refer to the official documenta-
tion: https://developer.android.com/guide/navigation
```
```
THe Navigation Component is made up of three major parts:

1. Navigation Graph ("nav_graph.xml) - Collects all navigation-related data
in on place. This includes all of the locations in the app, reffered to as destinations, as well as the possible paths a user could take through the app (like in Adobe XD).

2. NavHostFragment (Layout XML view) — This is a unique widget that you can include in your layout. It shows various destinations from your Navigation Graph

3. NavController (Kotlin/Java object) — This is an object that keeps track of where you are in the navigation graph. As you move through a navigation graph, it orchestrates the swapping of destination content in the NavHostFragment.


1. Setting Up Jetpack Navigation
dependencies {
    implementation "androidx.navigation:navigation-fragment-ktx:2.5.3"
    implementation "androidx.navigation:navigation-ui-ktx:2.5.3"
}

2. Creating a Navigation Graph

3. Integrating NavController and NavHostFragment
Implement  <androidx.fragment.app.FragmentContainerView/> into the   activivity.

4. Create the Between Destintations
HomeFragment, DetailFragment, EditFragment

5. Adding destintations and actionsin the nav_graph.xml

6. Modifying HomeFragment

7. Passing Data Between Destinations
In build.gradle (Project)
 id 'androidx.navigation.safeargs' version '2.5.3' apply false
 
In build.gradle (App)
In Plugins -->  id("androidx.navigation.safeargs.kotlin")
buildscript {
        repositories {
            google()
        }
        dependencies {
            classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        }
    }
```

# 4 Date- and Timepicker Dialog

Date- and Timepicker dialogs are very useful controls to get valid timing information
from the user.

```
□ Scour the internet for examples that show different characteristics of date- and
timepickers.
```
![image](https://github.com/MarcelEwinger/App_Development_SS23/assets/29062595/002bf943-e7ba-4a72-aa05-4142ec67a4fb)
![image](https://github.com/MarcelEwinger/App_Development_SS23/assets/29062595/8cafc9c3-7b2b-4433-9ab3-4c3a408962bf)
![image](https://github.com/MarcelEwinger/App_Development_SS23/assets/29062595/74ea8078-ebcb-4b2e-bee8-d01c810b4481)
```
□ Describe the advantages and disadvantages for selected examples and different
use cases.
Verwendungszweck:
- Anreisedatum/Abreisedatum
- Ankunftsdatum und Uhrzeit bei ÖBB
- Abflugsdatum und Uhrzeit
- Reservierungssystem für Restaurant
- (Kalender-App bzw. Notiz-App)
Bild1: Einfache Verwendung, übersichtlich, gutes Design

Bild2: Übersichtlich, umschalten zwischen Datum und Zeit kann übersehen werden,
grafische Auswahl von Minuten nicht möglich, englisches Format, gutes Design

Bild3: unübersichtlich, Beschriftung der Uhr fehlt, genau Uhrzeitauswahl über 
Grafik kaum möglich, schlechtes Design
```
```
□ Implement a combined date- and timepicker that allows the user to select a
certain time and date.
```


