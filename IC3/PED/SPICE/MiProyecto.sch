EESchema Schematic File Version 4
LIBS:MiProyecto-cache
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
L 74xGxx:74AHC1G08 A4
U 0 0 5CB4213E
P 5050 4000
F 0 "A4" H 5025 4267 50  0000 C CNN
F 1 "74AHC1G08" H 5025 4176 50  0001 C CNN
F 2 "" H 5050 4000 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 5050 4000 50  0001 C CNN
	0    5050 4000
	1    0    0    -1  
$EndComp
$Comp
L 74xGxx:74AHC1G08 A1
U 0 0 5CB42752
P 4050 3100
F 0 "A1" H 4025 3367 50  0000 C CNN
F 1 "74AHC1G08" H 4025 3276 50  0001 C CNN
F 2 "" H 4050 3100 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 4050 3100 50  0001 C CNN
	0    4050 3100
	1    0    0    -1  
$EndComp
$Comp
L 74xx:74HCT04 N2
U 2 0 5CB48DBB
P 1900 1550
F 0 "N2" H 1900 1867 50  0001 C CNN
F 1 "74HCT04" H 1900 1776 50  0001 C CNN
F 2 "" H 1900 1550 50  0001 C CNN
F 3 "https://assets.nexperia.com/documents/data-sheet/74HC_HCT04.pdf" H 1900 1550 50  0001 C CNN
	2    1900 1550
	0    1    1    0   
$EndComp
$Comp
L 74xx:74HCT04 N1
U 1 0 5CB494BD
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
Text GLabel 2250 750  0    129  Input ~ 0
C
Text GLabel 2650 750  0    129  Input ~ 0
D
Text GLabel 3250 750  0    129  Input ~ 0
E
$Comp
L 74xx:74HCT04 N3
U 1 0 5CB46C60
P 2900 1600
F 0 "N3" H 2900 1917 50  0001 C CNN
F 1 "74HCT04" H 2900 1826 50  0001 C CNN
F 2 "" H 2900 1600 50  0001 C CNN
F 3 "https://assets.nexperia.com/documents/data-sheet/74HC_HCT04.pdf" H 2900 1600 50  0001 C CNN
	1    2900 1600
	0    1    1    0   
$EndComp
Wire Wire Line
	950  750  1200 750 
Wire Wire Line
	1200 750  1200 1250
Wire Wire Line
	1650 750  1900 750 
Wire Wire Line
	1900 750  1900 1250
Wire Wire Line
	2650 750  2900 750 
Wire Wire Line
	2900 750  2900 1300
Wire Wire Line
	3250 750  3250 2250
Wire Wire Line
	3250 750  3500 750 
Wire Wire Line
	3500 750  3500 1350
Wire Wire Line
	3500 1950 3500 2000
$Comp
L 74xGxx:74AHC1G08 A3
U 0 0 5CB60749
P 5000 3500
F 0 "A3" H 4975 3767 50  0000 C CNN
F 1 "74AHC1G08" H 4975 3676 50  0001 C CNN
F 2 "" H 5000 3500 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 5000 3500 50  0001 C CNN
	0    5000 3500
	1    0    0    -1  
$EndComp
$Comp
L 74xGxx:74AHC1G32 O1
U 0 0 5CB6282A
P 6350 3750
F 0 "O1" H 6325 4017 50  0000 C CNN
F 1 "74AHC1G32" H 6325 3926 50  0001 C CNN
F 2 "" H 6350 3750 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 6350 3750 50  0001 C CNN
	0    6350 3750
	1    0    0    -1  
$EndComp
$Comp
L 74xGxx:74AHC1G08 A2
U 0 0 5CB6A626
P 5000 2850
F 0 "A2" H 4975 3117 50  0000 C CNN
F 1 "74AHC1G08" H 4975 3026 50  0001 C CNN
F 2 "" H 5000 2850 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 5000 2850 50  0001 C CNN
	0    5000 2850
	1    0    0    -1  
$EndComp
Wire Wire Line
	4300 3100 4700 3100
Wire Wire Line
	4700 3100 4700 2900
Text Label 4650 3100 2    50   ~ 0
notA_notD
Wire Wire Line
	4700 3100 4700 3450
Connection ~ 4700 3100
Text GLabel 6600 3750 2    89   Output ~ 0
F30
Wire Wire Line
	5300 4000 6050 4000
Wire Wire Line
	6050 4000 6050 3800
Text Label 5650 4000 2    50   ~ 0
AD
Wire Wire Line
	5250 3500 6050 3500
Wire Wire Line
	6050 3500 6050 3700
Text Label 5900 3500 2    50   ~ 0
notA_B_notD
$Comp
L 74xGxx:74AHC1G08 A5
U 0 0 5CB7F988
P 6350 2050
F 0 "A5" H 6325 2317 50  0000 C CNN
F 1 "74AHC1G08" H 6325 2226 50  0001 C CNN
F 2 "" H 6350 2050 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 6350 2050 50  0001 C CNN
	0    6350 2050
	1    0    0    -1  
$EndComp
$Comp
L 74xGxx:74AHC1G08 A6
U 0 0 5CB82921
P 6350 2800
F 0 "A6" H 6325 3067 50  0000 C CNN
F 1 "74AHC1G08" H 6325 2976 50  0001 C CNN
F 2 "" H 6350 2800 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 6350 2800 50  0001 C CNN
	0    6350 2800
	1    0    0    -1  
$EndComp
Wire Wire Line
	5950 2850 5950 2100
Wire Wire Line
	5950 2100 6050 2100
Wire Wire Line
	6050 2000 3500 2000
Wire Wire Line
	5250 2850 5950 2850
Connection ~ 5950 2850
Wire Wire Line
	5950 2850 6050 2850
Wire Wire Line
	6050 2750 6050 2250
Wire Wire Line
	6050 2250 3250 2250
Text Label 5900 2850 2    50   ~ 0
notA_notB_notD
Text GLabel 6600 2800 2    89   Output ~ 0
F29
Text GLabel 6600 2050 2    89   Output ~ 0
F28
$Comp
L 74xGxx:74AHC1G86 X1
U 0 0 5CB8E5A3
P 6350 4350
F 0 "X1" H 6325 4617 50  0000 C CNN
F 1 "74AHC1G86" H 6325 4526 50  0001 C CNN
F 2 "" H 6350 4350 50  0001 C CNN
F 3 "http://www.ti.com/lit/sg/scyt129e/scyt129e.pdf" H 6350 4350 50  0001 C CNN
	0    6350 4350
	1    0    0    -1  
$EndComp
Text GLabel 6600 4350 2    89   Output ~ 0
F31
Wire Wire Line
	2650 4300 6050 4300
Wire Wire Line
	3750 3150 1200 3150
Wire Wire Line
	1200 1850 1200 3150
Wire Wire Line
	3750 3050 2900 3050
Wire Wire Line
	2900 1900 2900 3050
Wire Wire Line
	1900 2800 1900 1850
Wire Wire Line
	4700 3550 1650 3550
Wire Wire Line
	1650 750  1650 3550
Text Label 5950 2000 2    50   ~ 0
notE
Text Label 3700 3050 2    50   ~ 0
notD
Text Label 3700 3150 2    50   ~ 0
notA
Text Label 3650 2800 2    50   ~ 0
notB
$Comp
L 74xx:74HCT04 N4
U 1 0 5CB518B5
P 3500 1650
F 0 "N4" H 3500 1967 50  0001 C CNN
F 1 "74HCT04" H 3500 1876 50  0001 C CNN
F 2 "" H 3500 1650 50  0001 C CNN
F 3 "https://assets.nexperia.com/documents/data-sheet/74HC_HCT04.pdf" H 3500 1650 50  0001 C CNN
	1    3500 1650
	0    1    1    0   
$EndComp
Text GLabel 950  750  0    129  Input ~ 0
A
Wire Wire Line
	950  4400 6050 4400
Wire Wire Line
	1900 2800 4700 2800
Wire Wire Line
	950  750  950  3950
Wire Wire Line
	2650 750  2650 4050
Wire Wire Line
	4750 3950 950  3950
Connection ~ 950  3950
Wire Wire Line
	950  3950 950  4400
Wire Wire Line
	4750 4050 2650 4050
Connection ~ 2650 4050
Wire Wire Line
	2650 4050 2650 4300
$EndSCHEMATC
