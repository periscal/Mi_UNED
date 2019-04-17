-- ================================
library IEEE;
use IEEE.std_logic_1164.all;
-- Puerta OR de 2 entradas
entity xor2 is port
	(y0		: out std_logic;
	 x0,x1	: in  std_logic);
end entity xor2;

architecture xor2 of xor2 is
begin
	y0 <= x0 xor x1;
end architecture xor2;
-- ================================