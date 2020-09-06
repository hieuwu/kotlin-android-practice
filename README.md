
# kotlin-android-practice
Some small projects to practice Android Basics with Kotlin for beginners. Every project in this repository is simplest. Besides making your own project following this, you should improve the UI for better look and feel, or maybe add more functionalities to upgrade your skill. Happy coding !

# Tictactoe

 - Simple layout design with TableLayout    
 - Handle click event to change
   button's attributes   
 - Handle simple logic for game playing
   
   ![](https://i.imgur.com/De3BQXr.png)
   
**References:**
- [Button](https://developer.android.com/reference/android/widget/Button)
- [Declaring Variables Kotlin](https://kotlinlang.org/docs/tutorials/kotlin-for-py/declaring-variables.html)
- [Control Flow Kotlin](https://kotlinlang.org/docs/reference/control-flow.html)
- [ArrayList Kotlin](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/)
- [Function Kotlin](https://kotlinlang.org/docs/reference/functions.html)

# Calculator

- Simple layout design with TableLayout, LinearLayout
- Support multiple screens sizes 
- Handle calculating operations "+ - * /". The +/- and %
   is your part

 **Multiple screens Instruction:**
 These are some kind of screens that you have to support: ldpi, mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi
 You have to do this for every Ativity that you need it to be supported.
 
 **Follow these steps:**

 1. Add new resource file in layout folder
    
 2.  Name that new file by the name of the root activity. And the
    directory shoud follow this convention: layout-ldpi or
    layout-xxxhdpi
    
 3.   Use Design tab and choose the device with suitable kind of screen to
    see your layout in that screen
    
 4.  Change the layout if needed

![](https://i.imgur.com/ylZF0O8.png)

**References:**
- [EditText](https://developer.android.com/reference/android/widget/EditText)
- [Support Different Screens](https://developer.android.com/training/multiscreen/screensizes)


# Disneyworld
 - Play with Google Map SDK Android: change map types, view angle
 - Add toolbar menu to perform some actions
 - Use Thread, GPS service to get location continuously
 
 ![](https://i.imgur.com/XCWDpwd.png)

**References:**
 
- [Request App Permission](https://developer.android.com/training/permissions/requesting)
- [BitMapDescriptorFactor](https://developers.google.com/android/reference/com/google/android/gms/maps/model/BitmapDescriptorFactory)
- [BitMapDescriptor](https://developers.google.com/android/reference/com/google/android/gms/maps/model/BitmapDescriptor)
- [LocationListener](https://developer.android.com/reference/android/location/LocationListener)
- [LocationManager](https://developer.android.com/reference/android/location/LocationManager)
- [Marker](https://developers.google.com/maps/documentation/android-sdk/marker)
- [Map Types](https://developers.google.com/maps/documentation/android-sdk/map#map_types)
- [Menu](https://developer.android.com/guide/topics/ui/menus?hl=vi)
- [Toolbar](https://developer.android.com/training/appbar/setting-up)
- [Thread Kotlin](https://medium.com/@korhanbircan/multithreading-and-kotlin-ac28eed57fea)
- [Nested and Inner Class Kotlin](https://kotlinlang.org/docs/reference/nested-classes.html)
- [Classes and Inheritance Kotlin](https://kotlinlang.org/docs/reference/classes.html)
- [Interfaces Kotlin](https://kotlinlang.org/docs/reference/interfaces.html)
- [Exceptions: try, catch Kotlin](https://kotlinlang.org/docs/reference/exceptions.html)

# License

<a rel="license" href="http://creativecommons.org/licenses/by/4.0/"><img alt="Giấy phép Creative Commons " style="border-width:0" src="https://i.creativecommons.org/l/by/4.0/88x31.png" /></a><br /><span xmlns:dct="http://purl.org/dc/terms/" property="dct:title">Kotlin Android Practice</span> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/4.0/">Creative Commons Attribution 4.0 International License. </a>.<br />Based on a work at <a xmlns:dct="http://purl.org/dc/terms/" href="https://github.com/hieuwu/kotlin-android-practice" rel="dct:source">https://github.com/hieuwu/kotlin-android-practice</a>.
