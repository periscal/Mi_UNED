-- ================================
library IEEE;
use IEEE.std_logic_1164.all;
-- Inversor de 1 entrada
entity not1 is port
	(y0	: out std_logic;
	 x0	: in  std_logic);
end entity not1;

architecture not1 of not1 is
begin
		y0 <= not x0;
end architecture not1;
-- ================================

-- ================================
library IEEE;
use IEEE.std_logic_1164.all;
-- Puerta OR de 2 entradas
entity or2 is port
	(y0		: out std_logic;
	 x0,x1	: in  std_logic);
end entity or2;

architecture or2 of or2 is
begin
	y0 <= x0 or x1;
end architecture or2;
-- ================================

-- ================================
library IEEE;
use IEEE.std_logic_1164.all;
-- Puerta AND de 2 entradas
entity and2 is port
	(y0		: out std_logic;
	 x0,x1	: in  std_logic);
end entity and2;

architecture and2 of and2 is
begin
	y0 <= x0 and x1;
end architecture and2;
-- ================================

-- ================================
library IEEE;
use IEEE.std_logic_1164.all;
entity circuito1 is port
	(F1,F2	: out std_logic;
	 A,B,C	: in  std_logic);
end entity circuito1;
	
architecture circuito_estruc of circuito1 is
	
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
	NOT1_A : component not1 port map(x0 => A, y0 => notA);
	NOT1_B : component not1 port map(x0 => B, y0 => notB);
	OR2_1  : component or2  port map(x0 => notA, x1 => notB, y0 => notA_or_notB);
	OR2_2  : component or2 	port map(X0 => A, x1 => B, y0 => F1);
	AND2_AB: component and2 port map(x0 => C, x1 => notA_or_notB, y0 => F2);
end architecture circuito_estruc;
	