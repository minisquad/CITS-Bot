package me.minisquad;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.managers.GuildController;

/**
 * Automatically assigns roles to users on message reaction events
 * 
 * @github minisquad/UWA-CITS-BOT
 * @version 1.0
 */
public class RoleAssign extends ListenerAdapter {

    /**
     * Automatically assigns the approrpiate discord role to user based on
     * the reacted reaction
     * @param event Message reaction received event
     */
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        User user = event.getUser();
        String messageId = event.getMessageId();
        
        if (user.isBot()) return;
        if (messageId.equals(Constants.ROLE_ASSIGN_MSGID)) {
            Member member = event.getMember();
            Guild guild = event.getGuild();
            String reaction = event.getReaction().getReactionEmote().getName();
            GuildController controller = guild.getController();
            
            switch (reaction) {
                case "CITS1001":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS1001_ROLEID)).complete();
                    Main.log("Assigned CITS1001 role to " + user);
                    break;
                case "CITS1401":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS1401_ROLEID)).complete();
                    Main.log("Assigned CITS1401 role to " + user);
                    break;
                case "CITS1402":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS1402_ROLEID)).complete();
                    Main.log("Assigned CITS1402 role to " + user);
                    break;
                case "CITS2002":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS2002_ROLEID)).complete();
                    Main.log("Assigned CITS2002 role to " + user);
                    break;
                case "CITS2200":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS2200_ROLEID)).complete();
                    Main.log("Assigned CITS2200 role to " + user);
                    break;
                case "CITS2211":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS2211_ROLEID)).complete();
                    Main.log("Assigned CITS2211 role to " + user);
                    break;
                case "CITS2401":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS2401_ROLEID)).complete();
                    Main.log("Assigned CITS2401 role to " + user);
                    break;
                case "CITS3001":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3001_ROLEID)).complete();
                    Main.log("Assigned CITS3001 role to " + user);
                    break;
                case "CITS3002":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3002_ROLEID)).complete();
                    Main.log("Assigned CITS3002 role to " + user);
                    break;
                case "CITS3003":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3003_ROLEID)).complete();
                    Main.log("Assigned CITS3003 role to " + user);
                    break;
                case "CITS3004":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3004_ROLEID)).complete();
                    Main.log("Assigned CITS3004 role to " + user);
                    break;
                case "CITS3200":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3200_ROLEID)).complete();
                    Main.log("Assigned CITS3200 role to " + user);
                    break;
                case "CITS3401":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3401_ROLEID)).complete();
                    Main.log("Assigned CITS3401 role to " + user);
                    break;
                case "CITS3402":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3402_ROLEID)).complete();
                    Main.log("Assigned CITS3402 role to " + user);
                    break;
                case "CITS3403":
                    controller.addSingleRoleToMember(member, guild.getRoleById(Constants.CITS3403_ROLEID)).complete();
                    Main.log("Assigned CITS3403 role to " + user);
                    break;
                default:
                    Main.log("Invalid reaction :" + reaction + ": received from " + user);
            }
        }
    }

    /**
     * Automatically removes the approrpiate discord role from a user based on
     * the unreacted reaction
     * @param event Message reaction removed event
     */
    @Override
    public void onMessageReactionRemove(MessageReactionRemoveEvent event) {
        User user = event.getUser();
        String messageId = event.getMessageId();
        
        if (user.isBot()) return;
        if (messageId.equals(Constants.ROLE_ASSIGN_MSGID)) {
            Member member = event.getMember();
            Guild guild = event.getGuild();
            String reaction = event.getReaction().getReactionEmote().getName();
            GuildController controller = guild.getController();
            
            switch (reaction) {
                case "CITS1001":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS1001_ROLEID)).complete();
                    Main.log("Removed CITS1001 role from " + user);
                    break;
                case "CITS1401":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS1401_ROLEID)).complete();
                    Main.log("Removed CITS1401 role from " + user);
                    break;
                case "CITS1402":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS1402_ROLEID)).complete();
                    Main.log("Removed CITS1402 role from " + user);
                    break;
                case "CITS2002":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS2002_ROLEID)).complete();
                    Main.log("Removed CITS2002 role from " + user);
                    break;
                case "CITS2200":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS2200_ROLEID)).complete();
                    Main.log("Removed CITS2200 role from " + user);
                    break;
                case "CITS2211":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS2211_ROLEID)).complete();
                    Main.log("Removed CITS2211 role from " + user);
                    break;
                case "CITS2401":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS2401_ROLEID)).complete();
                    Main.log("Removed CITS2401 role from " + user);
                    break;
                case "CITS3001":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3001_ROLEID)).complete();
                    Main.log("Removed CITS3001 role from " + user);
                    break;
                case "CITS3002":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3002_ROLEID)).complete();
                    Main.log("Removed CITS3002 role from " + user);
                    break;
                case "CITS3003":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3003_ROLEID)).complete();
                    Main.log("Removed CITS3003 role from " + user);
                    break;
                case "CITS3004":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3004_ROLEID)).complete();
                    Main.log("Removed CITS3004 role from " + user);
                    break;
                case "CITS3200":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3200_ROLEID)).complete();
                    Main.log("Removed CITS3200 role from " + user);
                    break;
                case "CITS3401":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3401_ROLEID)).complete();
                    Main.log("Removed CITS3401 role from " + user);
                    break;
                case "CITS3402":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3402_ROLEID)).complete();
                    Main.log("Removed CITS3402 role from " + user);
                    break;
                case "CITS3403":
                    controller.removeSingleRoleFromMember(member, guild.getRoleById(Constants.CITS3403_ROLEID)).complete();
                    Main.log("Removed CITS3403 role from " + user);
                    break;
            }
        }
    }
}