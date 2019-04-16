-- ================================
-- Banco de pruebas del circuito Ejercicio 2
-- fichero: bp_arch_fun2.vhd

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
    variable mes : std_logic_vector (3 downto 0);
    variable salidas : std_logic_vector (3 downto 0);
    variable bisiesto : std_logic;
    variable exito : boolean;
    variable dias : std_logic_vector (3 downto 0);

    begin
        exito := true;
        -- Generar todos los posibles valores de entrada
        for j in std_logic range '0' to '1' loop
            bisiesto :=j;
            E <= bisiesto;
            for i in 1 to 12 loop
                mes := std_logic_vector(to_unsigned(i,4));
                A <= mes(3);
                B <= mes(2);
                C <= mes(1);
                D <= mes(0);

                salidas := F28 & F29 & F30 & F31;
                case mes is
                    -- Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre tienen 31 salidas
                    when "0001"|"0011"|"0101"|"0111"|"1000"|"1010"|"1100" =>
                        dias := "0001"; -- 31 dias

                    -- Abril, Junio, Septiembre, Noviembre tienen 30 salidas
                    when "0100"|"0110"|"1001"|"1011" =>
                        dias := "0010"; -- 30 dias

                    -- Febrero
                    when "0010" =>
                        if    (E='0') then dias := "1000"; -- 28 dias
                        elsif (E='1') then dias := "0100"; --29 dias
                        end if;
                    when others => dias := "XXXX";
                end case;
                -- Una vez el numerdo de dias no coincide con la salida 'exito' en 'false'        
                if(dias /= salidas) then exito := (exito and false); end if;
                wait for DELAY;
            end loop;
        end loop;
        assert exito report "Test no superado." severity note;
        -- Final de la simulación
        wait;
    end process vec_test;
end architecture bp_arch_fun2;