EESchema Schematic File Version 4
LIBS:ejercicio1-cache
EELAYER 29 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L 74xx:74HCT04 N1
U 1 1 5CB494BD
P 1200 1550
F 0 "N1" H 1200 1867 50  0001 C CNN
F 1 "74HCT04" H 1200 1776 50  0001 C CNN
F 2 "" H 1200 1550 50  0001 C CNN
F 3 "https://assets.nexperia.com/documents/data-sheet/74HC_HCT04.pdf" H 1200 1550 50  0001 C CNN
	1    1200 1550
	0    1    1    0   
$EndComp
Text GLabel 1650 750  0    129  Input ~ 0
B
Wire Wire Line
	950  750  1200 750 
Wire Wire Line
	1200 750  1200 1250
Wire Wire Line
	1650 750  1900 750 
Wire Wire Line
	1900 750  1900 1250
$Comp
L 74xGxx:74AHC1G32 O1
U 1 1 5CB6282A
P 2400 2100
F 0 "O1" H 2375 2367 50  0000 C CNN
F 1 "74AHC1G32" H 2375 2276 50  0001 C CNN
F 2 "" H 2400 2100 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 2400 2100 50  0001 C CNN
	1    2400 2100
	1    0    0    -1  
$EndComp
Text GLabel 2650 2100 2    89   Output ~ 0
F1
Text GLabel 950  750  0    129  Input ~ 0
A
$Comp
L 74xx:74HCT04 N2
U 2 1 5CB48DBB
P 1900 1550
F 0 "N2" H 1900 1867 50  0001 C CNN
F 1 "74HCT04" H 1900 1776 50  0001 C CNN
F 2 "" H 1900 1550 50  0001 C CNN
F 3 "https://assets.nexperia.com/documents/data-sheet/74HC_HCT04.pdf" H 1900 1550 50  0001 C CNN
	2    1900 1550
	0    1    1    0   
$EndComp
Text GLabel 2250 750  0    129  Input ~ 0
C
$Comp
L 74xGxx:74AHC1G32 O2
U 0 0 5CB78BEB
P 2400 2600
F 0 "O2" H 2375 2867 50  0000 C CNN
F 1 "74AHC1G32" H 2375 2776 50  0001 C CNN
F 2 "" H 2400 2600 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 2400 2600 50  0001 C CNN
	0    2400 2600
	1    0    0    -1  
$EndComp
$Comp
L 74xGxx:74AHC1G08 A1
U 1 1 5CB60749
P 3550 2550
F 0 "A1" H 3525 2817 50  0000 C CNN
F 1 "74AHC1G08" H 3525 2726 50  0001 C CNN
F 2 "" H 3550 2550 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 3550 2550 50  0001 C CNN
	1    3550 2550
	1    0    0    -1  
$EndComp
Wire Wire Line
	1200 1850 1200 2650
Wire Wire Line
	1200 2650 2100 2650
Wire Wire Line
	1900 1850 1900 2550
Wire Wire Line
	1900 2550 2100 2550
Wire Wire Line
	2100 2150 950  2150
Wire Wire Line
	950  2150 950  750 
Wire Wire Line
	2100 2050 1650 2050
Wire Wire Line
	1650 2050 1650 750 
Wire Wire Line
	2250 750  2250 1700
Wire Wire Line
	2250 1700 3250 1700
Wire Wire Line
	3250 1700 3250 2500
Wire Wire Line
	2650 2600 3250 2600
Text GLabel 3800 2550 2    89   Output ~ 0
F2
Text Label 1900 2650 0    50   ~ 0
notA
Text Label 1950 2550 0    50   ~ 0
notB
Text Label 2800 2600 0    50   ~ 0
notA+notB
$EndSCHEMATC
