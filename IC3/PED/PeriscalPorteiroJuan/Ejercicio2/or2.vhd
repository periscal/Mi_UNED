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