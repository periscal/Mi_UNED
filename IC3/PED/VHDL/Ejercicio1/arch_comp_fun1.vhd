-- ================================
-- Comportamiento circuito ejercicio 1
--fichero: archo_comp_fun1.vhd

library IEEE;
use IEEE.std_logic_1164.all;

architecture arch_comp_fun1 of fun1 is
begin
    F <= A or B;
    G <= (not(A) or not(B)) and C;
end architecture arch_comp_fun1;
-- ================================
