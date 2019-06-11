package me.minisquad;

import java.util.List;
import java.util.function.Consumer;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Utilities extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        User user = event.getAuthor();
    
        // RoleAssign post creator with #roleassign
        if (Constants.ADMIN_USERS.contains(user.getId()) && event.getMessage().getContentRaw().equals("#roleassign")) {
            Guild guild = event.getGuild();
            TextChannel channel = guild.getTextChannelById(Constants.ROLE_ASSIGN_TCID);

            String introText = Constants.getInfoText(guild);
            EmbedBuilder eb = Embed.createRoleAssignEmbed(guild);

            // Consumer for reaction addition and Constants updates
            Consumer<Message> callback = (message) -> {
                String messageID = message.getId();
                Main.log("RoleAssign post created with ID " + messageID);
                Emote emote;
                for (String unit : Constants.CITS_UNITS) {
                    String unitCode = unit.substring(0, 8);
                    emote = guild.getEmotesByName(unitCode, false).get(0);
                    message.addReaction(emote).queue();
                }
                Main.log("Important manual change required. ROLE_ASSIGN_MSGID to ID " + messageID);
                Constants.ROLE_ASSIGN_MSGID = messageID;
            };

            // Purge 50 prior messages
            MessageHistory history = channel.getHistory();
            List<Message> messages = history.retrievePast(50).complete();
            channel.deleteMessages(messages).queue();

            channel.sendMessage(introText).embed(eb.build()).queue(callback);
        
        } else if (event.getMessage().getContentRaw().equals(".info")) {
            TextChannel channel = event.getChannel();
            EmbedBuilder eb;

            switch (channel.getParent().getId()) {
                case Constants.CITS1001_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS1001_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS1401_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS1401_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS1402_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS1402_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS2002_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS2002_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS2200_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS2200_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS2211_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS2211_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS2401_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS2401_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3001_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3001_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3002_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3002_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3003_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3003_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3004_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3004_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3200_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3200_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3401_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3401_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3402_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3402_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
                case Constants.CITS3403_PID:
                    eb = Embed.createUnitInfoEmbed(Constants.CITS3403_INFO);
                    channel.sendMessage(eb.build()).queue();
                    break;
            }
        }
    }
}