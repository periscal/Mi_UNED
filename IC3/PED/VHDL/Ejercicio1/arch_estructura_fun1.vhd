-- ================================
-- Descripcion estructura del circuito
-- fichero: arch_estructura_fun1.vhd

library IEEE;
use IEEE.std_logic_1164.all;

architecture arch_estructura_fun1 of fun1 is
	signal notA			: std_logic;
	signal notB			: std_logic;
	signal notA_or_notB : std_logic;
	
	-- Declaración de las clases de componentes
	component not1 is port
		(y0	: out std_logic;
		 x0	: in  std_logic);
	end component not1;
	
	component or2 is port
		(y0		: out std_logic;
		 x0,x1	: in  std_logic);
	end component or2;
	
	component and2 is port
		(y0		: out std_logic;
		 x0,x1	: in  std_logic);
	end component and2;
		
begin
	-- Instanciación y coneción de los componentes
	N1: component not1 port map(y0 => notA, x0 => A);
	N2: component not1 port map(y0 => notB, x0 => B);
	O1: component or2  port map(y0 => notA_or_notB, x0 => notA, x1 => notB);
	O2: component or2  port map(y0 => F, x0 => A, x1 => B);
	A1: component and2 port map(y0 => G, x0 => C, x1 => notA_or_notB);

end architecture arch_estructura_fun1;
-- ================================	