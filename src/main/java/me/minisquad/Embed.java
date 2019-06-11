package me.minisquad;

import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Emote;
import net.dv8tion.jda.core.entities.Guild;

public class Embed {

    public static EmbedBuilder createRoleAssignEmbed(Guild guild) {
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
    
    public static EmbedBuilder createUnitInfoEmbed(String[] unitInfo) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.addField("**" + unitInfo[0] + " – Unit Information**", "**Subject Name:** " + unitInfo[1] + 
        "\n**Semester:** " + unitInfo[2] + "\n**Lecturer:** " + unitInfo[3] + "\n**Focus:** " + unitInfo[4], false);
        if (!unitInfo[5].isEmpty()) {
            eb.setThumbnail("https://research-repository.uwa.edu.au/files-asset/" + unitInfo[5]);
        }
        eb.setColor(Color.decode("#77ab59"));
        return eb;
    }
}