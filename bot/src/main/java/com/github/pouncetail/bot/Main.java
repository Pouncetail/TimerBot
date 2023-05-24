package com.github.pouncetail.bot;

import java.util.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;


public class Main {
	public static ArrayList<String> k = new ArrayList<>();
	public static ArrayList<Timer> t = new ArrayList<>();

    public static void main(String[] args) {
        // Insert your bot's token here
        String token = "MTA5NDAyMzgyMjkxNjcxODU5Mg.Gk_ijz.rRNnVaLvza_y2sjULvZuHaOPqIpWhiZ9NREeek";

        DiscordApi api = new DiscordApiBuilder().setToken(token).
        		addIntents(Intent.MESSAGE_CONTENT).login().join();
        MyListener listener = new MyListener();
        
        // Add a listener which answers with "Pong!" if someone writes "!ping"
        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("!new")) {
            	event.getChannel().sendMessage("Give a time in minutes");
            	api.addListener(listener);
            }
            if (event.getMessageContent().equalsIgnoreCase("!stop")) {
            	api.removeListener(listener);
            	event.getChannel().sendMessage("The pipe is stopped");
            }
        });

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }

}