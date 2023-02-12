package org.msilot1001.boatplug;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.Vector;


public class EventListener implements Listener{
    @EventHandler
    public void move(VehicleMoveEvent event) {
        Vehicle vehicle = event.getVehicle();
        Entity passenger = (Entity) event.getVehicle().getPassenger();

        if(vehicle instanceof Boat ) {
            if(passenger instanceof Player) {
                Boat boat = (Boat) vehicle;
                Player player = (Player) passenger;
                ItemStack item = player.getItemInHand();
                Location loc = boat.getLocation();

                if(item != null && item.getType() == Material.LIME_BANNER && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("상승기")) {
                    boat.setGravity(false);
                    Double multiplier = 0.5D;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0.09D, boat.getLocation().getDirection().multiply(multiplier).getZ()));

                    player.getWorld().playSound(loc, Sound.ENTITY_WOLF_GROWL, 0.4F, 0);
                    player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.END_ROD, loc.getX(), loc.getY() + 1, loc.getZ(), 0);

                    scoreboardScores(player, multiplier);
                }

                if(item != null && item.getType() == Material.WHITE_BANNER && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("활공기")) {
                    boat.setGravity(true);
                    Double multiplier = 0.5D;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), -0.04D, boat.getLocation().getDirection().multiply(multiplier).getZ()));

                    player.getWorld().playSound(loc, Sound.ENTITY_WOLF_GROWL, 0.4F, 0);
                    player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.END_ROD, loc.getX(), loc.getY() + 1, loc.getZ(), 0);

                    scoreboardScores(player, multiplier);
                }

                if(item != null && item.getType() == Material.FEATHER && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("메인로터")) {
                    boat.setGravity(false);
                    Double multiplier = 10D;
                    boat.teleport(
                            new Location(player.getWorld(), boat.getLocation().getX(), boat.getLocation().getY() + 0.01d, boat.getLocation().getZ())
                    );
                    boat.setVelocity(new Vector(0, 0.4D, 0));

                    player.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1, 0);
                    player.getWorld().playSound(loc, Sound.ENTITY_WOLF_GROWL, 1, 0);
                    player.getWorld().playSound(loc, Sound.BLOCK_FIRE_AMBIENT, 2, 0);
                    player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.SMOKE_LARGE, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
                    player.getWorld().spawnParticle(Particle.END_ROD, loc.getX(), loc.getY() + 1, loc.getZ(), 0);

                    scoreboardScores(player, multiplier);
                }
                if(item != null && item.getType() == Material.COAL && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("속도0.5배")) {
                    boat.setGravity(true);
                    Double multiplier = 0.5D;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0, boat.getLocation().getDirection().multiply(multiplier).getZ()));
                    playExhaustSound(player, boat);

                    scoreboardScores(player, multiplier);
                }
                if(item != null && item.getType() == Material.COAL && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("속도1배")) {
                    boat.setGravity(true);
                    Double multiplier = 1D;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0, boat.getLocation().getDirection().multiply(multiplier).getZ()));
                    playExhaustSound(player, boat);

                    scoreboardScores(player, multiplier);
                }
                if(item != null && item.getType() == Material.COAL && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("속도1.5배")) {
                    boat.setGravity(true);
                    Double multiplier = 1.5D;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0, boat.getLocation().getDirection().multiply(multiplier).getZ()));
                    playExhaustSound(player, boat);

                    scoreboardScores(player, multiplier);
                }

                // 사용료 부과
                if(item != null && item.getType() == Material.COAL && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("속도2배")) {
                    boat.setGravity(true);
                    Double multiplier = 2d;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0, boat.getLocation().getDirection().multiply(multiplier).getZ()));
                    playExhaustSound(player, boat);

                    scoreboardScores(player, multiplier);
                }
                if(item != null && item.getType() == Material.COAL && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("속도3배")) {
                    boat.setGravity(true);
                    Double multiplier = 3d;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0, boat.getLocation().getDirection().multiply(multiplier).getZ()));
                    playExhaustSound(player, boat);

                    scoreboardScores(player, multiplier);
                }
                if(item != null && item.getType() == Material.COAL && player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals("antotaxi5cheatenable_c100125")) {
                    boat.setGravity(true);
                    Double multiplier = 5d;
                    boat.setVelocity(new Vector(boat.getLocation().getDirection().multiply(multiplier).getX(), 0, boat.getLocation().getDirection().multiply(multiplier).getZ()));

                    playExhaustSound(player, boat);

                    scoreboardScores(player, multiplier);
                }
            }
        }
    }

    public void playExhaustSound(Player player, Boat boat) {
        Location loc = boat.getLocation();

        player.getWorld().playSound(loc, Sound.ENTITY_WOLF_GROWL, 1, 0);
        player.getWorld().spawnParticle(Particle.SQUID_INK, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
        player.getWorld().spawnParticle(Particle.SMOKE_LARGE, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
        player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc.getX(), loc.getY() + 1, loc.getZ(), 0);
    }

    public void scoreboardScores(Player player, Double multiplier) {
        // 점수 부과
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();
        Objective obj = board.getObjective("boosttime");

        assert obj != null;
        Score score = obj.getScore(player.getName());

        score.setScore((int) (score.getScore() + Math.floor(multiplier)));
    }
}
