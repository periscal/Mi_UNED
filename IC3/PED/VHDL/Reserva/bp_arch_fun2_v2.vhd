-- Banco de pruebas del circuito Ejercicio 1
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

entity bp_arch_fun2 is
    constant DELAY : time:= 100 ns; -- Retardo usado en el test
end entity bp_arch_fun2;

architecture bp_arch_fun2 of bp_arch_fun2 is
    signal F28,F29,F30,F31  : std_logic;
    signal A,B,C,D,E        : std_logic;

    component fun2 is port 
        (F28,F29,F30,F31 : out  std_logic;
         A,B,C,D,E       : in   std_logic);
    end component fun2;

begin
    -- Instancia del circuito que va a ser testeado
    UUT : component fun2 port map(F28,F29,F30,F31,A,B,C,D,E);
    
    -- Vectores del test
vec_test : process is
    variable mes : unsigned (3 downto 0);
    variable bisiesto : unsigned(0 downto 0);
    begin
        -- Generar todos los posibles valores de entrada
        for j in 0 to 1 loop
            bisiesto := to_unsigned(j,1);
            E <= std_logic(bisiesto(0));
            for i in 1 to 12 loop
                mes := to_unsigned(i,4);
                A <= std_logic(mes(3));
                B <= std_logic(mes(2));
                C <= std_logic(mes(1));
                D <= std_logic(mes(0));
                wait for DELAY;
            end loop;
        end loop;
        -- Final de la simulación
        wait;
    end process vec_test;
end architecture bp_arch_fun2;