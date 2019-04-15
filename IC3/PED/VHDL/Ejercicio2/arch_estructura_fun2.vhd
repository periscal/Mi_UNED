-- ================================
library IEEE;
use IEEE.std_logic_1164.all;

architecture arch_estructura_fun2 of fun2 is
    signal notA,notB,notD,not_E : std_logic;
	--signal notB_C: std_logic;
    signal notA_notD :std_logic;
    signal notA_notB_notD :std_logic;
	signal notA_B_notD :std_logic;
	signal AD :std_logic;
	
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

	component xor2 is port
		(y0		: out std_logic;
	 	 x0,x1	: in  std_logic);
	end component xor2;
begin
	-- Instanciación y conexión de los componentes
	N1: component not1 port map(x0 => A, y0 => notA);
	N2: component not1 port map(x0 => B, y0 => notB);
	N3: component not1 port map(x0 => D, y0 => notD);
	N4: component not1 port map(x0 => E, y0 => not_E);
	--A2: component and2 port map(x0 => C, x1 => notB, y0 => notA_notB_notD);
	A1: component and2 port map(x0 => notA, x1 => notD, y0 => notA_notD);
	A2: component and2 port map(x0 => notB, x1 => notA_notD, y0 => notA_notB_notD);
	A3: component and2 port map(x0 => notA_notD, x1 => B, y0 => notA_B_notD);
	A4: component and2 port map(x0 => A, x1 => D, y0 => AD);
	A5: component and2 port map(x0 => not_E,x1 => notA_notB_notD, y0 => F28);
	A6: component and2 port map(x0 => E, x1 => notA_notB_notD, y0 => F29);
	O1: component or2  port map(x0 => AD,x1 => notA_B_notD, y0 => F30);
	x1: component xor2 port map(x0 => A, x1 => D, y0 => F31);

end architecture arch_estructura_fun2;

