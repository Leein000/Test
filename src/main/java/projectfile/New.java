package projectfile;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import java.util.logging.Logger;

public class New extends JavaPlugin {

    public final Logger logger = Logger.getLogger("Minecraft");

    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " 가 실행되었습니다 Version : " + pdfFile.getVersion());

    }

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + "플러그인이 좋료되었습니다");

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        getCommand("fireworks").setExecutor(this);

        if (commandLabel.equalsIgnoreCase("Fireworks")) {
            shootfireworks();
        }
        return false;
        }
        private void shootfireworks(){
        for (Player player : Bukkit.getOnlinePlayers()){
        Firework firework = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
        FireworkMeta fireworkm = firework.getFireworkMeta();
        FireworkEffect effect = FireworkEffect.builder().flicker(true).withColor(Color.AQUA).withFade(Color.BLACK).with(Type.BALL).trail(false).build();
        FireworkEffect effect2 = FireworkEffect.builder().flicker(false).withColor(Color.RED).withFade(Color.LIME).with(Type.BURST).trail(true).build();
        //flicker = 반짝임 여부, color = 폭죽 색깔, fade = 2번째 색깔, type = 모양, trail = 잔상
        Random random = new Random();
        int rf = random.nextInt(2);
        if(rf == 1){
            fireworkm.addEffect(effect);
        }
        else if(rf == 2){

            fireworkm.addEffect(effect2);
        }

        fireworkm.setPower(1);
        firework.setFireworkMeta(fireworkm);
        }
    }
}
