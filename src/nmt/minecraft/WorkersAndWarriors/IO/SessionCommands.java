package nmt.minecraft.WorkersAndWarriors.IO;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import nmt.minecraft.WorkersAndWarriors.WorkersAndWarriorsPlugin;

public class SessionCommands implements CommandExecutor {

	public static final String baseCommand = "wwsession";
	
	public enum SubCommand {
		CREATE("create"),
		LOADTEMPLATE("load"),
		OPEN("open"),
		START("start"),
		STOP("stop"),
		INFO("info"),
		LIST("list"),
		STOPALL("stopall"),
		SAVETEMPLATE("save");
		
		private String commandName;
		
		private SubCommand(String commandName) {
			this.commandName = commandName;
		}
		
		public final String getName() {
			return this.commandName;
		}
	}
	
	private static SessionCommands executor = null;
	
	public static SessionCommands getExecutor() {
		if (executor == null) {
			executor = new SessionCommands();
		}
		
		return executor;
	}
	
	private SessionCommands() {
		WorkersAndWarriorsPlugin.plugin.getCommand(baseCommand).setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase(baseCommand)) {
			if (args.length == 0) {
				return false;
			}
			String subCmd = args[0];
			
			if (subCmd.equalsIgnoreCase(SubCommand.CREATE.getName())) {
				return createCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.LOADTEMPLATE.getName())) {
				return loadCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.OPEN.getName())) {
				return openCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.START.getName())) {
				return startCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.STOP.getName())) {
				return stopCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.INFO.getName())) {
				return infoCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.LIST.getName())) {
				return listCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.STOPALL.getName())) {
				return stopAllCommand(sender, args);
			}
			
			if (subCmd.equalsIgnoreCase(SubCommand.SAVETEMPLATE.getName())) {
				return saveCommand(sender, args);
			}
			
			return false;
		} else {
			return false;
		}
		
	}
	
	private boolean createCommand(CommandSender sender, String[] args) {
		
		WorkersAndWarriorsPlugin.plugin.onReload();		
		return true;
	}
	
	private boolean loadCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean openCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean startCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean stopCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean infoCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean listCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean stopAllCommand(CommandSender sender, String[] args) {
		return false;
	}
	
	private boolean saveCommand(CommandSender sender, String[] args) {
		return false;
	}

}