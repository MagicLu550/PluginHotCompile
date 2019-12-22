package net.noyark.www.hotcompile


import cn.nukkit.command.{Command, CommandSender}
import cn.nukkit.plugin.PluginBase
import net.noyark.www.hotcompile.command.HotCommandCompiler

class HotCompile extends PluginBase{

  override def onLoad(): Unit = this.getLogger.info(HotMessageInfo.welcome)

  override def onEnable(): Unit = {
    HotCompile.hot = this
    this.saveDefaultConfig()
    if(this.getConfig.getBoolean("about"))HotMessageInfo aboutIt()
    val files = this.getDataFolder.listFiles()
    if(files!=null)
      files.foreach(f=>JavaCompiler hotCompile(f,this))
  }

  override def onCommand(sender: CommandSender, command: Command, label: String, args: Array[String]): Boolean =
    if("hc" equals command)HotCommandCompiler execute(sender,command,args) else false

}
object HotCompile{
  private var hot : HotCompile = _

  def getHotCompile = hot
}
