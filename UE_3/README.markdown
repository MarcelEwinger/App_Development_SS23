![](vertopal_ce3ece04c3e243879eb7818e8fc8b36b/media/image1.png){width="3.4722222222222223in"
height="0.2916666666666667in"}

+-----------------------------------+-----------------------------------+
| > **UE App Development            | > SS 2023 Primus\|Münzer          |
| > 623.9\[51\|52\]** Institute of  |                                   |
| > Information Technology (ITEC)   |                                   |
+===================================+===================================+
+-----------------------------------+-----------------------------------+

+-----------------------------------------------------------------------+
| > **ASSIGNMENT 03**\                                                  |
| > Due date: 2023/04/25\|26                                            |
+=======================================================================+
+-----------------------------------------------------------------------+

> Aim: **Becoming acquainted with Android**.
>
> **1** **Rotation & Explicit/Implicit Intents**
>
> □ Create an activity with a text input field for entering a street
> address.
>
> □ Run the app, enter some value into the input field and rotate the
> device *(Hint:* *make sure that auto-rotation is enabled)*.
>
> □ Explain what happens in terms of the Activity lifecycle when the
> device is rotated.
>
> □ Does the rotation affect the value of the input field? Why (not)?
>
> □ Edit the activity's layout and temporarily remove the android:id
> attribute from the input field. Does the behavior change? Why (not)?
>
> □ Is there a different way to influence the behavior of your activity
> for such \"configuration changes\"?
>
> □ Explore what other mechanism Android offers to save and restore an
> activity's state.
>
> □ Implement a button that forwards the value of the text field to a
> second activity. Display the value in a readonly text field.
>
> □ Implement a button in the second activity that launches Google Maps
> and jumps to the location that you specified in the input field.
>
> □ Following links might be helpful:
>
> □ n#
>
> □
>
> □

1

> **2** **Services**
>
> □ Go to and answer
>
> □ What are services, when should they be used and what is the
> difference to threads?
>
> □ What are the steps to create a service?□ What are the statuses of a
> service lifecycle?
>
> □ Implement a simple music player as a service component.
>
> □ Write a simple service that plays a predefined audio file. You can
> copy a mp3 file in the raw directory or use, e.g., an existing
> ringtone. Use android.media.MediaPlayer for that task.
>
> □ Override the necessary methods in your service.
>
> □ Implement an activity that starts and stops the service. (Hint: you
> may need two buttons for this functionality.)
>
> **3** **Fragments**
>
> □ Get yourself acquainted with Fragments by implementing a simple app
> that demonstrates their basic usage. It should include the following
> steps:
>
> □ Create two new Fragments\
> □ Dynamically add a Fragment by Code\
> □ Dynamically remove the Fragment and replace it with the other one□
> Communicate from host Activity to Fragment\
> □ Communicate from Fragment to host Activity
>
> □ Do some deeper research to answer the following questions
>
> □ What was the original intention for the introduction of Fragments?□
> How are Fragments used in modern Android development?
>
> □ What does the term 'Single Activity Architecture' refer to and what
> are pros and cons of this concept? Do you see any similarities to
> modern Web development?

2

> **4** **Touch Control**

*Implement an application similar to Figure 1 or 2. When the button
"Random Point"*

*is pressed, a small circle is shown at a random position on the screen.
When the user*

*tries to touch the center of the circle, the application shows the
distance between the*

> *touch position and the circle center. Consider the following
> implementation hints:*
>
> □ Define the Button and a SurfaceView inside your layout XML file. The
> Button may be outside the SurfaceView (Figure 1 or inside the
> SurfaceView (Figure
>
> 2\.
>
> □ Implement a callback function for the button that draws the circle
> on the canvas of the SurfaceView at a random position.
>
> □ Override the "onTouchEvent" listener that reacts on the user's touch
> activity and calculate the distance between the given circle and the
> touch position.
>
> □ What are the main differences between the layout shown in Figure 1
> and 2. Do you find some pros and cons?
>
> ![](vertopal_ce3ece04c3e243879eb7818e8fc8b36b/media/image2.png){width="1.9194433508311461in"
> height="3.4125in"}
>
> Figure 1: Example screenshot v1.
>
> 3
