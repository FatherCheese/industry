package cookie.industry;

import cookie.industry.core.I2Tags;
import cookie.industry.core.block.I2BlocksNew;
import cookie.industry.core.item.I2ItemsNew;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class Industry2 implements ModInitializer, GameStartEntrypoint, ClientStartEntrypoint {
    public static String MOD_ID = "industry";
    public static Logger logger = LoggerFactory.getLogger(MOD_ID);

    /* IDEAS */
    // Farming stuff
    // Oil : Could be used for fuel, plastic, lubricant, and a vehicle
    // Flight : Chestplate(s) such as jetpacks
    // Overhaul cables and cable model(?) : Would be neat to see cables stick to walls rather than float

    @Override
    public void onInitialize() {
        logger.info("Industry2 Initialized.");
    }

    @Override
    public void beforeGameStart() {
        SoundHelper.addSound(MOD_ID, "zap.wav");
        SoundHelper.addSound(MOD_ID, "laser.wav");
        SoundHelper.addSound(MOD_ID, "tap.wav");
        SoundHelper.addSound(MOD_ID, "alarm.wav");
        SoundHelper.addSound(MOD_ID, "click.wav");

        I2BlocksNew.initializeBlocks();
        I2ItemsNew.initializeItems();
    }

    @Override
    public void afterGameStart() {
    }

    @Override
    public void beforeClientStart() {
    }

    @Override
    public void afterClientStart() {

    }
}
