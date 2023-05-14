```
Benischke 12007588
Ewinger 12003351
```
```
UE App Development 623.9[51|52] SS 2023
Institute of Information Technology (ITEC) Primus|Münzer
```
## ASSIGNMENT 06

```
Due date: 2023/05/16|
```
# 1 Adaptive and Responsive Layout

With the growing diversity of Android devices, it is essential to create layouts that
can fit various screen sizes and resolutions without compromising usability and ac-
cessibility. It is an important aspect of Android development that can improve the
user experience and ensure your app works well across different devices.

```
□ Create alternative layouts of the About Page from Assignment 4 Task 3:
```
```
□ an additional layout in widescreen for the allready chosen device
□ for a high resolution widescreen TV or screen
□ for a very small device, e.g., a 2 .7“device with a resolution of 240 × 320.
```
```
□ Evaluate your designs with different sized emulated devices.
```
```
□ Challenge your design decisions by finding pros and cons.
```
# 2 View Binding

View binding is a feature in Android that allows developers to easily access views
in their layouts by generating a binding class at compile time in order to reduce
boilerplate code, improve type safety, and increase efficiency.

```
□ How does View binding differ from the traditionalfindViewById(). What are
pros and cons?
```
```
□ Revisit your conversion app from the previous assignment and rewrite it such
that it uses View binding.
```
```
□ Explain the main steps and components of the implementation.
```
# 3 Data Binding

An even more advanced concept is Data binding. It supports two-way binding, allow-
ing you to update your data automatically when the user interacts with your views.

```
□ Re-revisit your conversion app from the previous assignment and rewrite it
such that it uses Data binding and LiveData.
```



```
□ Explain the main steps and components of the implementation.
```
```
□ What are the main differences between View binding and Data binding? When
would you use which concept?
```
# 4 ViewModel

ViewModel is an Android design pattern that separates UI-related data from the
user interface and survives configuration changes. It helps to simplify code, increase
maintainability and testability.

```
□ Write a simple scoreboard for counting scores of two teams.
```
```
□ It should consist of two text fields that display the current scores and appro-
priate buttons to modify or reset the scores.
```
```
□ The internal state of the app and the corresponding logic should be encapsu-
lated into a ViewModel class.
```
```
□ Explain the advantages of using ViewModel over other approaches for manag-
ing state in Android.

 - Vermeidung von Speicherlecks: ViewModels sind darauf ausgelegt, zerstört zu werden, wenn
   ihre zugehörigen UI-Komponenten nicht mehr aktiv sind

 - Gemeinsamer Zustand: ViewModels können zwischen verschiedenen UI-Komponenten, z. B. 
   Fragments innerhalb derselben Activity, geteilt werden

 - Einfache Tests: Da ViewModels nicht direkt von der Android-Plattform abhängen, können sie 
   leicht isoliert mit Unit-Tests getestet werden

 - Trennung der Verantwortlichkeiten: ViewModels trennen die Geschäftslogik und die Datenverwaltung 
   von den UI-Komponenten. Dies fördert eine sauberere Architektur, indem das Trennungsprinzip der
   Verantwortlichkeiten eingehalten wird.

 - Lebenszyklusbewusstsein: ViewModels sind lebenszyklusabhängige Komponenten, was bedeutet, dass 
   sie an den Lebenszyklus des UI-Controllers (z. B. Activity oder Fragment) gebunden sind
```



