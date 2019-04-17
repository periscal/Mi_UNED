-- ================================
-- Comportamiento circuito ejercicio 2
-- fichero: arch_comp_fun2.vhd

library IEEE;
use IEEE.std_logic_1164.all;

architecture arch_comp_fun2 of fun2 is
begin
    process(A,B,C,D,E) is
        variable mes        : std_logic_vector (3 downto 0);
        variable bisiesto   : std_logic ;
    begin
        mes := A & B & C & D;
        bisiesto := E;
        case mes is
            -- Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre tienen 31 dias
            when "0001"|"0011"|"0101"|"0111"|"1000"|"1010"|"1100" =>
                F28 <= '0'; F29 <= '0';  F30 <= '0';  F31 <= '1';  

            -- Abril, Junio, Septiembre, Noviembre tienen 30 dias
            when "0100"|"0110"|"1001"|"1011" =>
                F28 <= '0'; F29 <= '0';  F30 <= '1';  F31 <= '0'; 

            -- Febrero
            when "0010" =>
                F30 <= '0';  F31 <= '0'; 
                if(E='0')     then F28 <= '1'; F29 <= '0';  -- Si no es bisiesto
                elsif (E='1') then F28 <= '0'; F29 <= '1';  -- Si es bisiesto
                else               F28 <= 'X'; F29 <= 'X';
                end if;
            when others =>
                F28 <= 'X'; F29 <= 'X';  F30 <= 'X';  F31 <= 'X'; 
            end case;
    end process;
end architecture arch_comp_fun2;
-- ================================