-- ================================
library IEEE;
use IEEE.std_logic_1164.all;

-- Banco de pruebas del circuito del ejercicio 1
entity bp_circuito1 is 
end entity bp_circuito1;

architecture bp_arch of bp_circuito1 is
	 
	signal test_out_F1	: std_logic;
	signal test_out_F2	: std_logic; 
	signal test_in_A 	: std_logic; 
	signal test_in_B 	: std_logic; 
	signal test_in_C 	: std_logic;
	
	component circuito1 is 
		port (	F1,F2	: out std_logic;
				A,B,C	: in  std_logic);
	end component circuito1;
	
begin
	-- Instancia del circuito que va a ser testeado
	UUT: circuito1 port map (
		F1 => test_out_F1,
		F2 => test_out_F2,
		A => test_in_A,
		B => test_in_B,
		C => test_in_C);
	
	-- Vectores del test
	process	
		begin
		--test_in_A <= 'X'; test_in_B <= 'X'; test_in_C <='X'; wait for 100 ns;
		test_in_A <= '0'; test_in_B <= '0'; test_in_C <='0'; wait for 100 ns;
		test_in_A <= '0'; test_in_B <= '0'; test_in_C <='1'; wait for 100 ns;
		test_in_A <= '0'; test_in_B <= '1'; test_in_C <='0'; wait for 100 ns;
		test_in_A <= '1'; test_in_B <= '1'; test_in_C <='1'; wait for 100 ns;
		test_in_A <= '1'; test_in_B <= '0'; test_in_C <='0'; wait for 100 ns;
		test_in_A <= '1'; test_in_B <= '0'; test_in_C <='1'; wait for 100 ns;
		test_in_A <= '1'; test_in_B <= '1'; test_in_C <='0'; wait for 100 ns;
		test_in_A <= '1'; test_in_B <= '1'; test_in_C <='1'; wait for 100 ns;
	end process;
	
	--Verificación de las salidas
	verif : process
		variable error_status : boolean;
	begin
		--wait on test_in_A,test_in_B,test_in_C; wait for 100 ns;
		if(
			(test_in_A='0' and test_in_B='0'and test_in_C='0' and test_out_F1='0' and test_out_F2='0')or
			(test_in_A='0' and test_in_B='0'and test_in_C='1' and test_out_F1='0' and test_out_F2='1')or
			(test_in_A='0' and test_in_B='1'and test_in_C='0' and test_out_F1='1' and test_out_F2='0')or
			(test_in_A='0' and test_in_B='1'and test_in_C='1' and test_out_F1='1' and test_out_F2='1')or
			(test_in_A='1' and test_in_B='0'and test_in_C='0' and test_out_F1='1' and test_out_F2='0')or
			(test_in_A='1' and test_in_B='0'and test_in_C='1' and test_out_F1='1' and test_out_F2='1')or
			(test_in_A='1' and test_in_B='1'and test_in_C='0' and test_out_F1='1' and test_out_F2='0')or
			(test_in_A='1' and test_in_B='1'and test_in_C='1' and test_out_F1='1' and test_out_F2='0')	)
		then
			error_status := false;
		else
			error_status := true;
		end if;
		
		assert not error_status report "Test Fallado." severity note;
		
	end process verif;
end architecture bp_arch;
			
	
