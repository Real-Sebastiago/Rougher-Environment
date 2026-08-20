package com.real_sebastiago.rougher_environment;


import com.real_sebastiago.rougher_environment.Rougher_Environment_Common;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod("rougher_environment")
public class Rougher_Environment {
    
    public Rougher_Environment(IEventBus modBus) {
        
        modBus.addListener(this::doClientStuff);
    }
    
    private void doClientStuff(final FMLClientSetupEvent event) {
        
        Rougher_Environment_Common.init();
    }
    
    
}
