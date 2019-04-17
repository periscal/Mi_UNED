-- ================================
-- Banco de pruebas del circuito Ejercicio 1
-- fichero: bp_arch_fun1.vhd
library IEEE;
use IEEE.std_logic_1164.all;
use IEEE.numeric_std.all;

entity bp_arch_fun1 is
    constant DELAY : time:= 100 ns; -- Retardo usado en el test
end entity bp_arch_fun1;

architecture bp_arch_fun1 of bp_arch_fun1 is

	signal F, G	: std_logic;
	signal A, B, C 	: std_logic;
	
	component fun1 is port
	 	(F,G	: out std_logic;
		A,B,C	: in  std_logic);
	end component fun1;
	
begin
	-- Instancia del circuito que va a ser testeado
	UUT: component fun1 port map (F,G,A,B,C);

	-- Vectores del test
vec_test : process is
	variable valor : unsigned (2 downto 0);
	begin
		-- Generar todos los posibles valores de entrada
		for i in 0 to 7 loop
			valor := to_unsigned(i,3);
			A <= std_logic(valor(2));
			B <= std_logic(valor(1));
			C <= std_logic(valor(0));
			wait for DELAY;
		end loop;
		-- Final de la simulación
		wait;
	end process vec_test;
end architecture bp_arch_fun1;				
-- ================================	
