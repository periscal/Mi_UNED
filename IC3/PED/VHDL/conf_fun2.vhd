-- ================================
-- Configuración
--fichero: conf_fun2.vhd

configuration conf_fun2 of bp_arch_fun2 is
   
    for bp_arch_fun2
        for UUT : fun2
            use entity work.fun2;
        end for;
    end for;
end configuration conf_fun2;
