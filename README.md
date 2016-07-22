![Calculator](https://raw.githubusercontent.com/Software86/Calculator/master/CalculatorThumb.png)

# Kalkylator 
### Grundläggande aritmetik i Java. 
* Körbar .jar fil finns i /dist 
* Källkoden finns i /src (kommentarer och kod på engelska)

## Funktioner
* Multiplikation
* Division
* Addition
* Subtraktion
* Återställningsknapp
 
## Bibliotek/Klasser använda
* java.swing för gui
* java.math.BigDecimal för uträkningen
* java.math.RoundingMode för att talen ska avrundas
* java.awt.GridBagLayout & java.awt.GridBagConstraints för placering av gui-komponenter

## Lite om algoritmen
* Gör uträkning varje gång + - / * knapparna används (förutom första gången efter återställning eller start)
* Hämtar siffrorna från textfältet (sträng), omvandlar till BigDecimal, genomför uträkningen och därefter omvandlar resultatet till en   sträng för att visa i textfältet.
* Kommer ihåg senaste resultatet för längre uträkningar
* Max 20 siffror
* Justerar storleken på siffrorna efter behov
* Avrundar decimaltal till närmaste heltal
