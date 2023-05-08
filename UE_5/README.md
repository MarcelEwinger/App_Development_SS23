1 Measurement Units

The Android SDK supports a set of measurement units (e.g., px, in, mm, pt, dp, sp). A rule of thumb says to use sp for text sizes and dp for everything else.

•	Create a layout with one button for each measurement unit where the height and the width have a size that corresponds to the size of 0.5 inches.

•	Describe for each button if the chosen size with this specific measurement unit is density independent and if the size remains the same on different physical screens. Test it with different AVDs.

•	Make similar experiments with texts and font sizes.

•	Confirm or contradict the given rule of thumb.

px: Dichteabhängig
Pixel ist abhängig von der DPI (dots per inch) des Bildschirms.
Je höher die dpi, desto kleiner ist die Schaltfläche der Pixelangabe.
Bezieht sich auf die tatsächlichen Pixel auf dem Bildschirm.

in: 1 inch = 2,54 cm, Dichte-Unabghängig
Inch bzw. Zoll ist bildschirmabhängig, da die tatsächliche, physikalische Größe des Bildschirms für die Messung verwendet wird.

mm: Dichte-Unabhängig
Millimeter ist bildschirmabhängig, da die tatsächliche physikalische Größe des Bildschirms für die Messung verwendet wird.

pt: 1pt entspricht 1/72 Zoll, Dichte-Unabhängig
Die Größe ist daher von der tatsächlichen, physikalischen Bildschirmgröße abhängig.

dp: Dichte-Unabhängig
Eine abstrakte Einheit, die auf der physikalischen Dichte auf dem Bildschirm basiert. Diese Messungen beziehen sich auf einen 160-dpi-Bildschirm und ist somit unabhängig vom eigentlichen Bildschirm.

sp: Dichte-Unabhängig, Scale-Independent
SP ist eine Abkürzung für Scale Independent Pixels.
Es ist dasselbe wie die dp-Einheit, aber es wird zusätzlich entsprechend der Auswahl der Schriftgröße des Benutzers skaliert.
Es wird zum Definieren der Textgröße verwendet, da es entsprechend der bevorzugten Schriftgröße vom Nutzer auf einem mobilen Gerät skaliert wird.
Quelle: https://en.proft.me/2017/04/18/introduction-android-screen-densities/
Pixel2: 441 pixels per inch  0,5*441 = 221
