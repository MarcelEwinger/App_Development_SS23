```
UE App Development 623.9[51|52] SS 2023
Institute of Information Technology (ITEC) Primus|Münzer
```
```
ASSIGNMENT 04
Due date: 2023/05/02|
```
# 1 Gestures

Touch-based input is (in terms of computing history) a very new type of input, as
compared to mouse and keyboard. This kind of input is closely related to the use of
mobile devices.

```
□ Make yourself familiar with touch events.
```
```
□ Explore which single touch events are supported by Android.
□ Implement a simple (more or less empty) application that reacts on these
touch events.
□ The application should respond to every event with a suitable message
in a snackbar.
```
```
□ Extend your application to visualize, count and track the amount of fingers
that interact with the screen.
```
```
□ Implement a view that is able to detect multiple touch events and visu-
alize each of the touched positions with a differently colored circle.
□ If the position of a finger changes on the screen the colored circle should
move accordingly.
□ If a finger is removed from the screen, its circle should disappear.
□ Denote the count of active fingers at the screen as big number in the
center of the screen.
```
# 2 Layout

Layouts can affect the performance of an application tremendously. Nesting several
instances of layouts leads to a deep view hierarchy, which is especially expensive with
LinearLayout as every child is measured twice. Additionally, applications show bad
performance if such layouts are inflated repeatedly in ListViews or GridViews.

```
□ Implement the layout shown in Figure 1 with at least two different layout
types (LinearLayout, RelativeLayout, ConstraintLayout, ...).
```

```
□ Draw the hierarchy as tree for each implemented layout. UseTools >Layout
Inspectorto get detailed information about your layout.
```
```
□ Inspect the time that is used for layout measurement, draw duration and
animation duration. Take a closer look athttps://developer.android.com/
studio/profile/cpu-profilerto find out how Android Studio can be used
to perform such tasks.
```
# 3 ConstraintLayout

Typically, applications have some kind of an “about” page. All smaller or larger
apps that you will implement in this course should have such an informal page that
is shown as additional activity. The principle design of the page is described below.
Feel free to enrich your page as much as you want.

```
□ At the top and horizontally centered is a logo (https://de.freelogodesign.
org)that represents either you as developer or your application.
```
```
□ Beneath is the name of your application.
```
```
□ Under the name is a field that shows a short description of the application.
```
```
□ Beneath the description there are at least 3 icons that link to some (fake)
social media pages and mandatory to your email address. The distribution of
the icons is specified by chain style constraints.
```
```
□ At the bottom right aligned is a button that closes this information page.
```
```
□ Include this page as activity in an already implemented application.
```
# 4 Personal Web Browser

WebViews are helpful if web pages or web applications should become part of an app.

```
□ Create an application that looks like the example in Figure 2 consisting of a
label, an input textfield, a button, and the webview.
```
```
□ A click on the button takes the given URL and opens the requested web page.
```
```
□ Extend your app by implementing a back and forward navigation with appro-
priate GUI elements.
```
```
□ (optional) Extend your app with a simple (temporary) bookmarking function-
ality.
```

Figure 1: Sample Layout

```
Figure 2: WebView
```

