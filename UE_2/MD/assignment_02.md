UE App Development 623.9[51|52] SS 2023 Institute![](Aspose.Words.9f0ce39e-0ef3-42b8-aa17-a56c7edc84d7.001.png) of Information Technology (ITEC) Primus|Münzer

ASSIGNMENT 02 Due date: 2023/03/28|29

Aim: Kotlin meets Android.![](Aspose.Words.9f0ce39e-0ef3-42b8-aa17-a56c7edc84d7.002.png)

1  Android App Components

Before we write our first app, we have to get acquainted with the basic building blocks of Android Apps. Study the lecture slides and the official Android Guide ([https://developer.android.com/guide/components/fundamentals )](https://developer.android.com/guide/components/fundamentals) to get an overview and answer the following questions:

- What are the four types of app components and what is their purpose?
- Does an app need to define one unique entry point or can it have multiple ones? How does the underlying paradigm differ from desktop applications?
- What is the difference between explicit and implicit Intents?
- What is the "application context" and what is the role of the class "R"?
2  The mother of all programs: Hello World!

This simple program is traditionally used to get in touch with a programming lan- guage’s syntax for the first time. It is also useful as sanity check to test if all requirements, like compilers, paths, dependencies, and so on are in place.

- Write a simple Hello World program in Kotlin for Android
- Run it on an emulated device
- (optional) Run it on your own Android Smartphone (= Physical Device)
- Investigate the content of your AndroidManifest.xml and explain its compo- nents.
- Add at least one additional language in your hello world program (e.g., german →“Hallo Welt”) and switch the displayed language on your device.

([https://developer.android.com/training/basics/supporting- devices/languages )](https://developer.android.com/training/basics/supporting-devices/languages)

3  Logging and Debugging

Basic logging functionality is provided by the Class android.util.Log. ( [https:// developer.android.com/reference/android/util/Log )](https://developer.android.com/reference/android/util/Log)

- Extend your Hello World program with rudimental logging functionality. Write several log messages with different verbosity levels to Logcat and explain the output.
- Logs are supportive during development but more important for debugging problems and errors of released applications. Think about different purposes of logging for software development and software in productive use. Name pros and cons of logging for those operational purposes. Investigate logging mechanisms to implement these varying logging objectives.
- Build the application as debug variant and deploy it to the emulator / device.
- Build the application as release variant. Are there additional requirements for the deployment? If so, describe and carry out the necessary steps.
4  Android Activity LifeCycle

The Android activity lifecylce con- ![](Aspose.Words.9f0ce39e-0ef3-42b8-aa17-a56c7edc84d7.003.png)sists of several states as shown in the figure on the right. 

- Implement an app that over- rides all lifecycle callbacks. 
- Furthermore, the application should log a meaningful mes- sage whenever a new state be- comes active. 
- Investigate under which cir- cumstances the current state changes to the subsequent state. 
- Extend your app by a second Activity that also logs each state change. Both Activities should show a button that al- lows the user to switch to the other Activity. 
2
