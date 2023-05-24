package com.github.pouncetail.bot;

import java.util.*;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.*;

public class MyListener implements MessageCreateListener {
	
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
    	if (!event.getMessageAuthor().isBotUser() && 
    			event.getMessageContent().charAt(0) != ('!')) {
    		double de = 0;
    		try { 
    	        de = Double.parseDouble(event.getMessageContent());
    	        Timer d = new Timer();
        		TimerTask task = new TimerTask() {
        	        public void run() {
        	        	event.getChannel().sendMessage("<@" + event.getMessageAuthor().getId() + "> Your timer is up!");
        	        	Main.k.remove(event.getMessageAuthor().getDisplayName());
        	        	Main.t.remove(d);
        	        }
        	    };
        	    Long delay = new Long(Math.round(de* 1000) * 60);
            	Main.k.add(event.getMessageAuthor().getDisplayName());
        	    d.schedule(task, delay);
        		Main.t.add(d);
    	    } catch(NumberFormatException e) { 
    	    	event.getChannel().sendMessage("Try Again with an integer!");
    	    } catch(NullPointerException e) {
    	    	event.getChannel().sendMessage("Try Again with an integer!");
    	    }
    	}
    }
}