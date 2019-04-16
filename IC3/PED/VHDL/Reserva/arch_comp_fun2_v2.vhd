-- ================================
-- Comportamiento circuito ejercicio 2
-- fichero: arch_comp_fun2.vhd

library IEEE;
use IEEE.std_logic_1164.all;

architecture arch_comp_fun2 of fun2 is
begin
    F28 <= not(A) and not(B) and not(D) and not(E);
    F29 <= not(A) and not(B) and not(D) and E;
    F30 <= (A and D) or (not(A) and B and not(D));
    F31 <= A xor D;
end architecture arch_comp_fun2;
-- ================================