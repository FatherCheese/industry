package cookie.industry;

import cookie.industry.block.I2Blocks;
import cookie.industry.item.I2Items;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.AchievementHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.util.ClientStartEntrypoint;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.achievements.AchievementPage;

public class Industry2 implements ModInitializer, GameStartEntrypoint, ClientStartEntrypoint {
    public static String MOD_ID = "industry";
    public static Logger logger = LoggerFactory.getLogger(MOD_ID);

    /* IDEAS */
    // Electric Wrench
    // Powered bow : two modes - pulling and machine gun
    // Chargers : Walk on or wear them
    // Flight : Chestplate(s) such as jetpacks, or upgrades for the Iridium armor
    // Oil : Could be used for fuel, plastic, lubricant, and a vehicle (possibly also cooking?)

    @Override
    public void onInitialize() {
        logger.info("Industry2 has been initialized. Have fun automating!");
    }

    @Override
    public void beforeGameStart() {
        new I2Blocks().initializeBlocks();
        new I2Items().initializeItems();
        AchievementHelper.addPage(new I2Achievements());
    }

    @Override
    public void afterGameStart() {

    }

    @Override
    public void beforeClientStart() {
        SoundHelper.Client.addSound(MOD_ID, "zap.wav");
        SoundHelper.Client.addSound(MOD_ID, "laser.wav");
        SoundHelper.Client.addSound(MOD_ID, "tap.wav");
        SoundHelper.Client.addSound(MOD_ID, "alarm.wav");
        SoundHelper.Client.addSound(MOD_ID, "click.wav");
    }

    @Override
    public void afterClientStart() {

    }
}
