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
    
        if (Constants.ADMIN_USERS.contains(user.getId())) {
            if (event.getMessage().getContentRaw().equals("#roleassign")) {
                Guild guild = event.getGuild();
                TextChannel channel = guild.getTextChannelById(Constants.ROLE_ASSIGN_TCID);

                String introText = Constants.getInfoText(guild);
                EmbedBuilder eb = createRoleAssignEmbed(guild);

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
            }
        }
    }

    public EmbedBuilder createRoleAssignEmbed(Guild guild) {
        EmbedBuilder eb = new EmbedBuilder();
        
        // Unit names and icons respectively
        String unitListString = "";
        Emote icon;
        for (String unit : Constants.CITS_UNITS) {
            String unitCode = unit.substring(0, 8);
            icon = guild.getEmotesByName(unitCode, false).get(0);
            unitListString += icon.getAsMention() + " " + unit + "\n";
        }
        eb.addField("Unit List", unitListString, false);

        return eb;
    }
}